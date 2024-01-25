import customtkinter
import subprocess
import tkinter as tk
import os
from pypresence import Presence
rpc = Presence(client_id="1200190629897052181")
rpc.connect()
rpc.update(large_image="plus", details="Private server manager for SR!", state="In launcher")


customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("blue")

app = customtkinter.CTk()
app.geometry("325x160")
app.configure(bg="#242424")
app.resizable(False, False)

current_dir = os.path.dirname(os.path.abspath(__file__))
app.wm_iconbitmap(os.path.join(current_dir, 'plus.ico'))
app.wm_title("CrepePlus v2.1")
title = tk.Label(app, text="Welcome to CrepePlus", font=("Arial", 32, "bold"), bg="#242424", fg="white")
title.pack()

scriptsDir = os.path.join(current_dir, 'scripts')
proxyDir = os.path.join(current_dir, 'proxy')

def button_callback1():
    subprocess.run(f'cmd /c start cmd /k "cd /d {scriptsDir} && start.bat"', shell=True)
    rpc.update(large_image="plus", details="In-game", state="Playing 1.6.0")

def button_callback2():
    subprocess.run(f'cmd /c start cmd /k "cd /d {scriptsDir} && build.bat"', shell=True)

def button_callback3():
    subprocess.run(f'cmd /c start cmd /k "cd /d {proxyDir} && stopProxy.bat"', shell=True)
    app.destroy()

button1 = customtkinter.CTkButton(app, text="Start server & enable proxy", command=button_callback1, fg_color="#C6829B", hover_color="#843E58")
button1.pack(pady=5)

button2 = customtkinter.CTkButton(app, text="Build/repair server", command=button_callback2, fg_color="#7DABE6", hover_color="#37506F")
button2.pack(pady=5)

button3 = customtkinter.CTkButton(app, text="Stop proxy & exit", command=button_callback3, fg_color="#A60003", hover_color="dark red")
button3.pack(pady=5)

app.mainloop()
