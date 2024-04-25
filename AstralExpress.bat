@echo off
cd %CD% \Resources\Astral
python -c "import pkg_resources" 2> nul
if errorlevel 1 (
    echo "Python is not installed. Please install Python first."
    pause
    exit /b
)

python -c "import customtkinter" 2> nul
if errorlevel 1 (
    echo "Installing customtkinter..."
    pip install customtkinter
    pause
)

start /min cmd /c "python AstralExpress.py"
exit