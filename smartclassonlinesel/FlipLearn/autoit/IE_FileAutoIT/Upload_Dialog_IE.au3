WinActivate("Choose File to Upload")
ControlSetText("Choose File to Upload","","Edit1",$CmdLine[1])
ControlClick("Choose File to Upload","","Button1")