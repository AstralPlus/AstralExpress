@echo off
cd %CD%\Resources\Resources\Astral
pip install customtkinter
pip install pypresence
start /min cmd /c "python AstralExpress.py"
exit