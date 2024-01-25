@echo off
cd %CD%\CrepePackage\PlusResources\scripts
pip install customtkinter
pip install pypresence
cd..
start /min cmd /c "python CrepePlus.py"
exit