import customtkinter
import subprocess
import tkinter as tk
import os
from pypresence import Presence

rpc = Presence(client_id="1200190629897052181")
rpc.connect()
rpc.update(
    large_image="plus",
    details="Space anime game server tool!",
    state="In launcher",
    buttons=[
        {"label": "Join us!", "url": "https://discord.gg/dVcRarJBx4"},
        {"label": "Project Github", "url": "https://github.com/AstralPlus/AstralExpress"}
    ]
)


customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("blue")

app = customtkinter.CTk()
app.geometry("325x160")
app.configure(bg="#242424")
app.resizable(False, False)

current_dir = os.path.dirname(os.path.abspath(__file__))
app.wm_iconbitmap(os.path.join(current_dir, 'astral.ico'))
app.wm_title("Astral Express v2.1")
title = tk.Label(app, text="Welcome to Astral Express", font=("Arial", 20, "bold"), bg="#242424", fg="white")
title.pack()

current_dir = os.path.dirname(os.path.realpath(__file__))

def button_callback1():
    subprocess.run(f'cmd /c start cmd /k "cd /d {current_dir} && scripts.bat 1"', shell=True)
rpc.update(state="Playing 1.6.0")

def button_callback2():
    subprocess.run(f'cmd /c start cmd /k "cd /d {current_dir} && scripts.bat 2"', shell=True)


def button_callback3():
    subprocess.run(f'cmd /c start cmd /k "cd /d {current_dir} && scripts.bat 3"', shell=True)
    app.destroy()


button1 = customtkinter.CTkButton(app, text="Start server & enable proxy", command=button_callback1, fg_color="#C6829B", hover_color="#843E58")
button1.pack(pady=5)

button2 = customtkinter.CTkButton(app, text="Build/repair server", command=button_callback2, fg_color="#7DABE6", hover_color="#37506F")
button2.pack(pady=5)

button3 = customtkinter.CTkButton(app, text="Stop proxy & exit", command=button_callback3, fg_color="#A60003", hover_color="dark red")
button3.pack(pady=5)

app.mainloop()