@echo off
cd %CD%\CrepePackage\PlusResources\scripts
pip install customtkinter
cd..
start /min cmd /c "python CrepePlus.py"
exit