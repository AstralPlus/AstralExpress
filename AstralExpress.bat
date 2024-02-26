@echo off
cd %CD% \Resources\Astral
python -c "import pkg_resources" 2> nul
if errorlevel 1 (
    echo "Python is not installed. Please install Python first."
    exit /b
)

python -c "import customtkinter" 2> nul
if errorlevel 1 (
    echo "Installing customtkinter..."
    pip install customtkinter
)

python -c "import pypresence" 2> nul
if errorlevel 1 (
    echo "Installing pypresence..."
    pip install pypresence
)

start /min cmd /c "python AstralExpress.py"
exit