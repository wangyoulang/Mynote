AltState = 0
CtrlState = 0

; ============main key=========
; 左Win换成左 LAlt
LWin:: LAlt

; 替换菜单键为Win
AppsKey:: LWin

; LShift 按键
LShift::
	SendInput {LShift Down}
Return

LShift up::
	SendInput {LShift Up}
Return


; 输入法/大小写切换
CapsLock::
	if AltState = 2
	{
		SetCapsLockState, % GetKeyState("CapsLock","T") ? "Off" : "On"
	}
	else
	{
		KeyWait, CapsLock, T0.3
		If ErrorLevel
		{
	   		SetCapsLockState, % GetKeyState("CapsLock","T") ? "Off" : "On"
    			KeyWait, CapsLock
		}
		else
		{
			SetCapsLockState, % "Off"
			SendInput {LCtrl down}{Space}{LCtrl up}
		}
	}
Return

; ==========Spc key========

; 左Alt + [ = 后退
[::
	if AltState
	{
		if AltState = 2
		{
			SendInput {LCtrl Up}
		}
		SendInput {LAlt Down}{Left Down}
		AltState = 1
	}
	else
	{
		SendInput {[ Down}
	}
Return

[ up::
	if AltState
	{
		SendInput {Left Up}
	}
	else
	{
		SendInput {[ Up}
	}
Return

; 左Alt + ] = 前进
]::
	if AltState
	{
		if AltState = 2
		{
			SendInput {LCtrl Up}
		}
		SendInput {LAlt Down}{Right Down}
		AltState = 1
	}
	else
	{
		SendInput {] Down}
	}
Return

] up::
	if AltState
	{
		SendInput {Right Up}
	}
	else
	{
		SendInput {] Up}
	}
Return

; 左Alt + 方向上键 = 上一页
Up::
	if AltState = 2
	{
		SendInput {LCtrl Up}
		SendInput {PgUp Down}
		SendInput {LCtrl Down}
	}
	else
	{
		SendInput {Up Down}
	}
Return

Up up::
	if AltState = 2
	{
		SendInput {PgUp Up}
	}
	else
	{
		SendInput {Up Up}
	}
Return

; 左Alt + 方向下键 = 下一页
Down::
	if AltState = 2
	{
		SendInput {LCtrl Up}
		SendInput {PgDn Down}
		SendInput {LCtrl Down}
	}
	else
	{
		SendInput {Down Down}
	}
Return

Down up::
	if AltState = 2
	{
		SendInput {PgDn Up}
	}
	else
	{
		SendInput {Down Up}
	}
Return

; 左Alt + 方向左键 = Home（光标移到行首）
Left::
	if AltState = 2
	{
		SendInput {LCtrl Up}
		SendInput {Home Down}
		SendInput {LCtrl Down}
	}
	else
	{
		SendInput {Left Down}
	}
Return

Left up::
	if AltState = 2
	{
		SendInput {Home Up}
	}
	else
	{
		SendInput {Left Up}
	}
Return

; 左Alt + 方向右键 = End（光标移到行尾）
Right::
	if AltState = 2
	{
		SendInput {LCtrl Up}
		SendInput {End Down}
		SendInput {LCtrl Down}
	}
	else
	{
		SendInput {Right Down}
	}
Return

Right up::
	if AltState = 2
	{
		SendInput {End Up}
	}
	else
	{
		SendInput {Right Up}
	}
Return
