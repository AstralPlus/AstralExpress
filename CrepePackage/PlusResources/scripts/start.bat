cd ..\proxy
start /min cmd /c "startProxy.bat"
cd ..\..\LunarCore
start cmd /c "java -jar LunarCore.jar"
cls
exit