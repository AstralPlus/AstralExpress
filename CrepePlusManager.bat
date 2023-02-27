@echo off
:menu
echo Welcome to the CrepePlus Manager
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo 1) Start the CrepePlus server
echo 2) Update CrepePlus
echo 3) Install/Update node modules
echo 4) Exit
echo 5) Want to try CBT3?
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
echo Created by Midrooms
echo ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
set /p op=Select: 
if "%op%"=="1" goto start
if "%op%"=="2" goto update
if "%op%"=="3" goto NPM
if "%op%"=="4" exit
if "%op%"=="5" goto cbt3
cls
goto menu

:start
cd %cd%\CrepePackage
powershell -Command "Start-Process MITM.bat -WindowStyle Minimized"
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyEnable /t REG_DWORD /d 1 /f
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v ProxyServer /t REG_SZ /d http://127.0.0.1:8080 /f
cls
echo CrepePlus has enabled the proxy! Some internet functionality may not work.
echo To disable the proxy, head to system settings - Network and internet -> Proxy -> Manual proxy -> Set up -> Use a proxy server checked off -> Save
echo If you can't figure how to disable the proxy, simply restart your PC.
npm run start

:update
@echo Updating CrepePlus... You will return to the menu once the update is completed.
@RD /S /Q "%CD%\CrepePackage"
powershell -Command "Invoke-WebRequest https://ps.rrryfoo.cf/CrepePackage.zip -Outfile CrepePackage.zip"
powershell -Command "Expand-Archive -Path CrepePackage.zip CrepePackage -Force"
DEL CrepePackage.zip
cd %cd%\CrepePackage\
powershell -Command "Start-Process inode.bat -WindowStyle Minimized"
cls
goto menu

:NPM
cd %CD%\CrepePackage
start inode.bat
cls
goto menu

:cbt3
echo Want to play CBT3?
echo Press any key to download the instructions and also included Fiddler Classic installer.
echo The files will be located in "CrepePlus-beta"
echo If you don't want to download the files, close the manager and open it again.
pause
powershell -Command "Invoke-WebRequest https://ps.rrryfoo.cf/CrepePlus-beta.zip -Outfile CrepePlus-beta.zip"
powershell -Command "Expand-Archive -Path CrepePlus-beta.zip CrepePlus-beta -Force"
DEL CrepePlus-beta.zip
cls
echo The CrepePlus-beta folder is now located where you ran the manager.
echo Press any key to return to the menu.
pause
cls
goto menu
