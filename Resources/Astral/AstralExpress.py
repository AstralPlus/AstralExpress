from customtkinter import *
import tkinter as tk
import subprocess
import configparser
import os
import time
from pypresence import Presence
from pypresence.exceptions import DiscordNotFound

rpc = Presence(client_id="1200190629897052181")

try:
    rpc.connect()
    rpc.update(
        large_image="plus",
        details="Space anime game server tool",
        buttons=[
            {"label": "Github", "url": "https://github.com/AstralPlus/AstralExpress"}
        ]
    )
except DiscordNotFound:
    print("Discord not detected. RPC will not run.")

current_dir = os.path.dirname(os.path.abspath(__file__))

app = CTk()
app.geometry("355x255")
app.resizable(True, False)

app.wm_iconbitmap(os.path.join(current_dir, 'astral.ico'))
set_default_color_theme("blue")
app.wm_title("Astral Express v2.2")

tabview = CTkTabview(master=app)
tabview.pack(padx=0, pady=0)
tabview.add("Game")
tabview.add("Settings")

launch_game = tk.BooleanVar()
game_path = tk.StringVar()
close_game_on_exit = tk.BooleanVar()
script_dir = os.path.dirname(os.path.realpath(__file__))
scripts_path = os.path.join(script_dir, 'scripts.bat')

def launch_program():
    subprocess.Popen(f'"{scripts_path}" 1', shell=True)

    if launch_game.get() and game_path.get():
        time.sleep(5)
        game_path_full = game_path.get()
        subprocess.Popen(game_path_full, shell=True)

def rebuild_server():
    cmd = f'{scripts_path} 2'
    subprocess.Popen(["start", "cmd", "/k", cmd], shell=True)

def proxyOFF_exit():
    subprocess.Popen(f'"{scripts_path}" 3', shell=True)
    app.destroy()

button1 = CTkButton(master=tabview.tab("Game"), text="Start server", command=launch_program, fg_color="#C6829B", hover_color="#843E58")
button2 = CTkButton(master=tabview.tab("Game"), text="Rebuild server", command=rebuild_server, fg_color="#668cbd", hover_color="#37506F")
button3 = CTkButton(master=tabview.tab("Game"), text="Stop proxy & exit", command=proxyOFF_exit, fg_color="#A60003", hover_color="dark red")
button1.pack(padx=10, pady=10)
button2.pack(padx=10, pady=10)
button3.pack(padx=10, pady=10)


def update_button_text(*args):
    if launch_game.get() and game_path.get():
        button1.configure(text="Start server & launch game")
    else:
        button1.configure(text="Start server")

launch_game.trace_add("write", update_button_text)
game_path.trace_add("write", update_button_text)

label1 = CTkLabel(master=tabview.tab("Settings"), text="Launch game with server")
label1.grid(row=0, column=0, sticky='w', padx=10, pady=10)
checkbox = CTkCheckBox(master=tabview.tab("Settings"), text="", variable=launch_game)
checkbox.grid(row=0, column=1, sticky='e', padx=10, pady=10)

label2 = CTkLabel(master=tabview.tab("Settings"), text="Game Path")
label2.grid(row=1, column=0, sticky='w', padx=10, pady=0)
textbox = CTkEntry(master=tabview.tab("Settings"), textvariable=game_path)
textbox.grid(row=1, column=1, sticky='e', padx=10, pady=0)

def update_game_path_visibility(*args):
    if launch_game.get():
        label2.grid()
        textbox.grid()
    else:
        label2.grid_remove()
        textbox.grid_remove()

launch_game.trace_add("write", update_game_path_visibility)

def save_settings():
    config = configparser.ConfigParser()
    config['DEFAULT'] = {'LaunchGame': launch_game.get(),
                         'CloseGameOnExit': close_game_on_exit.get(),
                         'GamePath': game_path.get().replace("\\", "\\\\")}
    script_dir = os.path.dirname(os.path.realpath(__file__))
    settings_path = os.path.join(script_dir, 'settings.ini')
    with open(settings_path, 'w') as configfile:
        config.write(configfile)

save_button = CTkButton(master=tabview.tab("Settings"), text="Save Settings", command=save_settings)
save_button.grid(row=3, column=0, columnspan=2, padx=10, pady=10)

config = configparser.ConfigParser()
script_dir = os.path.dirname(os.path.realpath(__file__))
settings_path = os.path.join(script_dir, 'settings.ini')
config.read(settings_path)
if 'DEFAULT' in config:
    launch_game.set(config['DEFAULT'].getboolean('LaunchGame', False))
    close_game_on_exit.set(config['DEFAULT'].getboolean('CloseGameOnExit', False))
    game_path.set(config['DEFAULT'].get('GamePath', ''))

update_button_text()
update_game_path_visibility()

app.mainloop()