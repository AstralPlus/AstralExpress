@echo off
powershell -Command "$parentDir = Split-Path (Split-Path -Parent '%~dp0') -Parent; Invoke-WebRequest -Uri 'https://github.com/Melledy/LunarCore/zipball/development/' -OutFile \"$parentDir\LunarCore.zip\""
pause
exit
