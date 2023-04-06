@echo off
:menu
echo Welcome to CrepePlus         1.8
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo 1) Start the CrepePlus server
echo 2) Update CrepePlus
echo 3) Update/Install node modules
echo 4) Exit
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo Created by Midrooms and rrryfoo 
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

set /p op=Select: 
if "%op%"=="1" goto start
if "%op%"=="2" goto update
if "%op%"=="3" goto npm
if "%op%"=="4" exit

cls
goto menu

:start
start cmd /k "cd %cd%\CrepePackage\py && @echo off && title CrepePlus mitmdump && timeout /t 3 && mitmdump -s proxy.py -k"
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyEnable /t REG_DWORD /d 1 /f
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyServer /t REG_SZ /d http://127.0.0.1:8080 /f
cd..
cls
echo CrepePlus has enabled the proxy! Some internet functionality may not work.
echo To disable the proxy, head to system settings - Network and internet -> Proxy -> Manual proxy -> Set up -> Use a proxy server checked off -> Save
echo If you can't figure how to disable the proxy, simply restart your PC.
npm run start

:update
@echo Updating CrepePlus...
@RD /S /Q "%cd%\CrepePackage"
powershell -Command "Invoke-WebRequest https://github.com/CrepePlus/CrepePackages/raw/main/CrepePackage.zip"
powershell -Command "Expand-Archive -Path CrepePackage.zip CrepePackage -Force"
DEL CrepePackage.zip
start cmd /k "cd %cd%/CrepePackage && npm install"
cls
goto menu

:npm
start cmd /k "cd %cd%/CrepePackage && npm install"
cls
goto menu