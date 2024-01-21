import customtkinter
import subprocess
import tkinter as tk
import os
import requests

customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("blue")

app = customtkinter.CTk()
app.geometry("400x180")
app.configure(bg="#242424")

current_dir = os.path.dirname(os.path.abspath(__file__))
app.wm_iconbitmap(os.path.join(current_dir, 'plus.ico'))
app.wm_title("CrepePlus v2.0")
title = tk.Label(app, text="Welcome to CrepePlus 2.0", font=("Arial", 32, "bold"), bg="#242424", fg="white")
title.pack()

scriptsDir = os.path.join(current_dir, 'scripts')
proxyDir = os.path.join(current_dir, 'proxy')

def button_callback1():
    subprocess.run(f'cmd /c start cmd /k "cd /d {scriptsDir} && start.bat"', shell=True)

def button_callback2():
    subprocess.run(f'cmd /c start cmd /k "cd /d {scriptsDir} && update.bat"', shell=True)

def button_callback3():
    subprocess.run(f'cmd /c start cmd /k "cd /d {proxyDir} && stopProxy.bat"', shell=True)
    app.destroy()

def button_callback4():
    subprocess.run(f'cmd /c start cmd /k "cd /d {scriptsDir} && build.bat"', shell=True)

def download_file(url, local_filename):
    with requests.get(url, stream=True) as r:
        r.raise_for_status()
        with open(local_filename, 'wb') as f:
            for chunk in r.iter_content(chunk_size=8192): 
                f.write(chunk)
    return local_filename

def update_launcher():
    latest_release = requests.get('https://api.github.com/repos/CrepePlus/CrepePlus/releases/latest')
    assets = latest_release.json()['assets']
    for asset in assets:
        if asset['name'] == 'CrepePlus.py':  # Replace with your launcher file name
            download_url = asset['browser_download_url']
            download_file(download_url, os.path.join(current_dir, 'CrepePlus.py'))  # Replace with the path to your launcher file
            print("Launcher updated! Please relaunch CrepePlus.bat!")
            break

def button_callback5():
    update_launcher()

# BTs
button1 = customtkinter.CTkButton(app, text="Start server & enable proxy", command=button_callback1)
button1.pack(pady=10)

button3 = customtkinter.CTkButton(app, text="Stop proxy & exit", command=button_callback3)
button3.pack(pady=10)

button4 = customtkinter.CTkButton(app, text="Build/repair server", command=button_callback4)
button4.pack(pady=10)

app.mainloop()
