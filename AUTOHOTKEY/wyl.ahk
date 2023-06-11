;互换alt和control
;LAlt::LCtrl
;LCtrl::LAlt
AltState = 0
CtrlState = 0

; ============main key=========
; 左Win换成左 LAlt
;LWin:: LAlt

; 替换菜单键为Win
;AppsKey:: LWin

; LShift 按键
LShift::
 SendInput {LShift Down}
Return

LShift up::
 SendInput {LShift Up}
Return

; LAlt 按键
LAlt::
 if CtrlState = 1  ; LCtrl被按下，LAlt复原
 {
  AltState = 1
  SendInput {LAlt Down}
 }
 else if AltState = 0  ; 第一个被按下，改键为LCtrl
 {
  AltState = 2
  SendInput {LCtrl Down}
 }
Return

LAlt up::
 if AltState = 1
 {
  SendInput {LAlt Up}
 }
 else if AltState = 2
 {
  SendInput {LCtrl Up}
 }
 AltState = 0
Return

; LCtrl按键
LCtrl::
 if AltState = 2  ; LAlt已经被按下，改建为LAlt
 {
  CtrlState = 2
  SendInput {LAlt Down}
 }
 else   ; 默认输出LCtrl
 {
  CtrlState = 1
  SendInput {LCtrl Down}
 }
Return

LCtrl up::
 if CtrlState = 1
 {
  SendInput {LCtrl up}
 }
 else if CtrlState = 2
 {
  SendInput {LAlt up}
 }
 CtrlState = 0
Return

Space::
 if CtrlState = 1
 {
  SendInput {LCtrl Up}
  CtrlState = 0
 }
 if AltState = 2
 {
  SendInput {LCtrl Up}
  SendInput {LAlt Down}
  AltState = 1
 }
 SendInput {Space Down}
Return

Space up::
 SendInput {Space Up}
Return

;  tab  翻页功能不变
tab::
 if AltState = 2
 {
  SendInput {LCtrl Up}
  SendInput {LAlt Down}{tab}
  AltState = 1
 }
 else
 {
  SendInput {tab Down}
 }
Return

tab up::
 SendInput {tab Up}
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
