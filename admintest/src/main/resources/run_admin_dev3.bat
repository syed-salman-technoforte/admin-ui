chdir /d D:\Admin_UI_Test_Rig

call MasterDataCleanup_dev3.bat

java  -Dpath=https://admin.dev3.mosip.net/ -DKeyclockURL=https://iam.dev3.mosip.net -Denv.user=api-internal.dev3  -Denv.endpoint=https://api-internal.dev3.mosip.net  -jar admintest-1.2.1-jar-with-dependencies.jar


echo
xcopy D:\Admin_UI_Test_Rig\test-output\emailable-report.html D:\Admin_UI_Test_Rig\test-output\Reports\AdminUI-dev2-Report-%date:~-4,4%%date:~-7,2%%date:~-10,2%%time%.html*

pause
