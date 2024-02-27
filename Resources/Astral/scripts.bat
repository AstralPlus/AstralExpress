@echo off
IF "%~1"=="1" goto 1
IF "%~1"=="2" goto 2
IF "%~1"=="3" goto 3
goto end


:1
@echo off
cd ..\LunarCore
start cmd /k "java -jar LunarCore.jar"
cd ..\Astral\proxy
start StarRail.HttpProxy.exe
exit
goto end


:2
cd..
cd %CD%\LunarCore
del /F /Q LunarCore.jar
gradlew jar
pause
exit
goto end


:3
@echo off
cd /d %~dp0
taskkill /f /im StarRail.HttpProxy.exe
certutil -user -delstore root ae8fe14dc72938ad5b1ed3889dd8e2ec619a50cf
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyEnable /t REG_DWORD /d 0 /f
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyServer /d "" /f
exit
goto end


:end