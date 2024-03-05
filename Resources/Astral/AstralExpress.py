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
    pass

current_dir = os.path.dirname(os.path.abspath(__file__))

app = CTk()
app.geometry("355x255")
app.resizable(True, False)

app.wm_iconbitmap(os.path.join(current_dir, 'astral.ico'))
set_default_color_theme("blue")
app.wm_title("Astral Express v2.2")

tabview = CTkTabview(master=app)
tabview.pack(padx=0, pady=0)
tabview.add("Server")
tabview.add("Settings")

launch_game = tk.BooleanVar()
game_path = tk.StringVar()
close_game_on_exit = tk.BooleanVar()
launch_delay = tk.IntVar()
script_dir = os.path.dirname(os.path.realpath(__file__))
lunarcore_dir = os.path.join(script_dir, "..", "LunarCore")

def launch_program():    
    if os.path.isdir(lunarcore_dir):
        os.chdir(lunarcore_dir)
        subprocess.Popen(["start", "cmd", "/k", "java", "-jar", "LunarCore.jar"], shell=True)
        astral_proxy_dir = os.path.join(script_dir, "..", "Astral", "proxy")
        os.chdir(astral_proxy_dir)
        subprocess.Popen(["start", "/min", "cmd", "/c", "StarRail.HttpProxy.exe"], shell=True)
    if launch_game.get() and game_path.get():
        time.sleep(launch_delay.get())
        game_path_full = game_path.get()
        subprocess.Popen(["start", game_path_full], shell=True)

def rebuild_server():
    current_dir = os.path.dirname(os.path.realpath(__file__))
    lunarcore_dir = os.path.join(current_dir, "..", "LunarCore")
    if os.path.isdir(lunarcore_dir):
        os.chdir(lunarcore_dir)
        if os.path.exists("LunarCore.jar"):
            os.remove("LunarCore.jar")
            subprocess.Popen(["cmd", "/c", "start", "cmd", "/k", "gradlew jar && pause && exit"])

def proxyOFF_exit():
    script_dir = os.path.dirname(os.path.realpath(__file__))
    os.chdir(script_dir)
    subprocess.run(["taskkill", "/f", "/im", "StarRail.HttpProxy.exe"], shell=True)
    subprocess.run(["certutil", "-user", "-delstore", "root", "ae8fe14dc72938ad5b1ed3889dd8e2ec619a50cf"], shell=True)
    subprocess.run(["reg", "add", "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings", "/v", "ProxyEnable", "/t", "REG_DWORD", "/d", "0", "/f"], shell=True)
    subprocess.run(["reg", "add", "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings", "/v", "ProxyServer", "/d", "", "/f"], shell=True)
    app.destroy()


button1 = CTkButton(master=tabview.tab("Server"), text="Start server", command=launch_program, fg_color="#C6829B", hover_color="#843E58")
button2 = CTkButton(master=tabview.tab("Server"), text="Rebuild server", command=rebuild_server, fg_color="#668cbd", hover_color="#37506F")
button3 = CTkButton(master=tabview.tab("Server"), text="Stop proxy & exit", command=proxyOFF_exit, fg_color="#A60003", hover_color="dark red")
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

slider_label_text = tk.StringVar()

slider_label = CTkLabel(master=tabview.tab("Settings"), textvariable=slider_label_text)
slider_label.grid(row=2, column=0, sticky='w', padx=10, pady=10)

slider = CTkSlider(master=tabview.tab("Settings"), from_=1, to=30, variable=launch_delay, command=lambda value: launch_delay.set(value), width=140)
slider.grid(row=2, column=1, sticky='w', padx=10, pady=10)

def update_slider_label_text(*args):
    slider_label_text.set(f"Launch delay ({launch_delay.get()}s)")
launch_delay.trace_add("write", update_slider_label_text)
update_slider_label_text()

def update_game_path_visibility(*args):
    if launch_game.get():
        label2.grid()
        textbox.grid()
        slider.grid() 
        slider_label.grid() 
    else:
        label2.grid_remove()
        textbox.grid_remove()
        slider.grid_remove()
        slider_label.grid_remove()

launch_game.trace_add("write", update_game_path_visibility)

def save_settings():
    config = configparser.ConfigParser()
    config['DEFAULT'] = {'LaunchGame': launch_game.get(),
                         'CloseGameOnExit': close_game_on_exit.get(),
                         'GamePath': game_path.get().replace("\\", "\\\\"),
                         'LaunchDelay': launch_delay.get()}
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
    launch_delay.set(config['DEFAULT'].getint('LaunchDelay', 5))

update_button_text()
update_game_path_visibility()

app.mainloop()