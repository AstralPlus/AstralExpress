from customtkinter import *
import tkinter as tk
import subprocess
import configparser
import os
import time
from pypresence import Presence

rpc = Presence(client_id="1200190629897052181")
rpc.connect()
rpc.update(
    large_image="plus",
    details="Space anime game server tool",
    buttons=[
        {"label": "Github", "url": "https://github.com/AstralPlus/AstralExpress"}
    ]
)

current_dir = os.path.dirname(os.path.abspath(__file__))

app = CTk()
app.geometry("355x255")

app.wm_iconbitmap(os.path.join(current_dir, 'astral.ico'))
set_default_color_theme("blue")
app.wm_title("Astral Express v2.2")

tabview = CTkTabview(master=app)
tabview.pack(padx=0, pady=0)
tabview.add("Game")
tabview.add("Settings")

launch_game = tk.BooleanVar()
game_path = tk.StringVar()
launch_game = tk.BooleanVar()
game_path = tk.StringVar()
def launch_program():
    script_dir = os.path.dirname(os.path.realpath(__file__))

    scripts_path = os.path.join(script_dir, 'scripts.bat')

    subprocess.Popen(f'"{scripts_path}" 1', shell=True)

    if launch_game.get() and game_path.get():
        time.sleep(5)
        game_path_full = game_path.get()
        subprocess.Popen([game_path_full], shell=True)



button = CTkButton(master=tabview.tab("Game"), text="Start server", command=launch_program)
button.pack(padx=10, pady=10)

def update_button_text(*args):
    if launch_game.get() and game_path.get():
        button.configure(text="Start server & launch game")
    else:
        button.configure(text="Start server")

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
                         'GamePath': game_path.get()}
    script_dir = os.path.dirname(os.path.realpath(__file__))
    settings_path = os.path.join(script_dir, 'settings.ini')
    with open(settings_path, 'w') as configfile:
        config.write(configfile)

save_button = CTkButton(master=tabview.tab("Settings"), text="Save Settings", command=save_settings)
save_button.grid(row=2, column=0, columnspan=2, padx=10, pady=10)


config = configparser.ConfigParser()
script_dir = os.path.dirname(os.path.realpath(__file__))
settings_path = os.path.join(script_dir, 'settings.ini')
config.read(settings_path)
if 'DEFAULT' in config:
    launch_game.set(config['DEFAULT'].getboolean('LaunchGame', False))
    game_path.set(config['DEFAULT'].get('GamePath', ''))

update_button_text()
update_game_path_visibility()

app.mainloop()