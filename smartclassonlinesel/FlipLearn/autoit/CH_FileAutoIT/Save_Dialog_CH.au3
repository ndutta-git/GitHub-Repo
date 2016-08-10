;---------------------------------------------------------
;~ Save_Dialog_FF.au3
;~ Purpose: To handle the Dowload/save Dialogbox in Firefox
;~ Usage: Save_Dialog_FF.exe "Dialog Title" "Opetaion" "Path"
;~ Create By: Gaurang Shah
;~ Email: gaurangnshah@gmail.com
;----------------------------------------------------------

; set the select mode to select using substring
AutoItSetOption("WinTitleMatchMode","2")

if $CmdLine[0] < 2 then
; Arguments are not enough
msgbox(0,"Error","Supply all the Arguments, Dialog title,Save/Cancel and Path to save(optional)")
Exit
EndIf

; wait until dialog box appears
$x=WinGetTitle("[REGEXPTITLE:"&$CmdLine[1]&"]")
$title =$x  ; retrives whole window title
WinWait($title ) ; match the window with substring
WinActive($title);

; if user choose to save file
If (StringCompare($CmdLine[2],"Save",0) = 0) Then

WinActivate($title)
WinWaitActive($title)
Sleep(1)
Send("{DOWN}")
Sleep(1)
; If firefox is set the save the file on some specif location without asking to user.
; It will be save after this point.
;If not A new Dialog will appear prompting for Path to save
Send("{ENTER}")

if ( StringCompare(WinGetTitle("[active]"),$title,0) = 0 ) Then
WinActivate($title)
Send("{ENTER}")
EndIf

if WinExists("[REGEXPTITLE:Save As]") Then
$title = WinGetTitle("[REGEXPTITLE:Save As]")
if($CmdLine[0] = 2) Then
; Save File
WinActivate($title)
ControlSetText($title,"","Edit1",$CmdLine[3])

ControlClick($title,"","Button1")
Else
;Set path and save file
WinActivate($title)
WinWaitActive($title)
ControlSetText($title,"","Edit1",$CmdLine[3])
ControlClick($title,"","Button1")
EndIf

Else
;Firefox is configured to save file at specific location
Exit
EndIf

EndIf
; do not save the file
If (StringCompare($CmdLine[2],"Cancel",0) = 0) Then
WinWaitActive($title)
Send("{ESCAPE}")
EndIf
