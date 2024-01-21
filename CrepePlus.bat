@echo off
cd %CD%\CrepePackage\PlusResources\scripts
pip install -r requirements.txt
cd..
start /min cmd /c "python CrepePlus.py"
exit