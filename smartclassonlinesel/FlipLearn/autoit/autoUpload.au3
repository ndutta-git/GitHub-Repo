
#include <Excel.au3>
#include <MsgBoxConstants.au3>

Local $BrowserType = $CmdLine[1]


if $BrowserType="CH" Then

	WinActivate("Open")
	ControlSetText("Open", "", "Edit1", $file )
	ControlClick("Open", "", "Button1")

ElseIf  $BrowserType="FF" Then

	WinActivate("File Upload")
	ControlSetText("File Upload", "", "Edit1", $file )
	ControlClick("File Upload", "", "Button1")


ElseIf  $BrowserType="IE" Then

	   WinActivate("Choose File to Upload")
	   ControlSetText("Choose File to Upload", "", "Edit1", $file )
	   ControlClick("Choose File to Upload", "", "Button1")

EndIf

