;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 947)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use PolyEdit)
(use Window)
(use File)
(use System)

(local
	saveWin
	windowUp
	[fileName 40]
	[winTitle 20]
	[mainItems 28] = [{DIALOG} 0 0 {About} 0 0 {Item} 0 0 {Edit} 0 0 {Look} 0 0 {Del} 0 0 {Win} 0 0 {Help} 0 0 {eXit} 120 0 0]
	[editButtonItems 22] = [{EDITING} 0 0 {Text} 0 0 {Font} 0 0 {Value} 0 0 {Position} 0 0 {Help} 0 0 {Menu} 0 0 0]
	[editTextItems 25] = [{EDITING} 0 0 {Text} 0 0 {Font} 0 0 {Just} 0 0 {Width} 0 0 {Position} 0 0 {Help} 0 0 {Menu} 0 0 0]
	[editEditItems 22] = [{EDITING} 0 0 {Font} 0 0 {Length} 0 0 {Position} 0 0 {Text} 0 0 {Help} 0 0 {Menu} 0 0 0]
	[editIconItems 22] = [{EDITING} 0 0 {View} 0 0 {Loop} 0 0 {Cel} 0 0 {Position} 0 0 {Help} 0 0 {Menu} 0 0 0]
	[editSelectorItems 19] = [{EDITING} 0 0 {Width} 0 0 {Length} 0 0 {Position} 0 0 {Help} 0 0 {Menu} 0 0 0]
	[editWindowItems 22] = [{WINDOW} 0 0 {Create} 0 0 {Position} 0 0 {Delete} 0 0 {Title} 0 0 {Help} 0 0 {Menu} 0 0 0]
)

(procedure (localproc_0 param1 param2)
	(if (> (StrLen param1) param2)
		(StrAt param1 param2 0)
		(StrAt param1 (-- param2) 46)
		(StrAt param1 (-- param2) 46)
		(StrAt param1 (-- param2) 46)
	)
	(return param1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10] [temp15 10] [temp25 10] [temp35 10] [temp45 12])
	(= temp0 (param1 noun:))
	(= temp1 (param1 verb:))
	(= temp2 (param1 case:))
	(= temp3 (param1 seq:))
	(= temp4 (param1 modNum:))
	(Format @temp5 {%d} temp0)
	(Format @temp15 {%d} temp1)
	(Format @temp25 {%d} temp2)
	(Format @temp35 {%d} temp3)
	(Format @temp45 {%d} temp4)
	(if
		(Print
			addTitle: @winTitle
			font: 0
			addText: {Enter new message parameters:}
			addText: {Noun} 5 25
			addText: {Verb} 85 25
			addText: {Case} 5 39
			addText: {Seq} 85 39
			addText: {Module} 47 53
			addEdit: @temp5 4 45 25 @temp5
			addEdit: @temp15 4 125 25 @temp15
			addEdit: @temp25 4 45 39 @temp25
			addEdit: @temp35 4 125 39 @temp35
			addEdit: @temp45 5 101 53 @temp45
			addButton: 1 {   OK   } 18 67
			addButton: 0 {Cancel} 91 67
			init:
		)
		(= temp0 (ReadNumber @temp5))
		(= temp1 (ReadNumber @temp15))
		(= temp2 (ReadNumber @temp25))
		(= temp3 (ReadNumber @temp35))
		(= temp4 (ReadNumber @temp45))
		(cond
			((not (Message msgGET temp4 temp0 temp1 temp2 temp3))
				(Prints {Can't find message!})
				(return 0)
			)
			((not (Message msgSIZE temp4 temp0 temp1 temp2 temp3))
				(Prints {Message contains no text!})
				(return 0)
			)
			(else
				(param1
					noun: temp0
					verb: temp1
					case: temp2
					seq: temp3
					modNum: temp4
				)
				(return 1)
			)
		)
	else
		(return 0)
	)
)

(procedure (localproc_2 param1)
	(Print
		addTitle: @winTitle
		font: 0
		width: 50
		addText: {What kind of text?}
		addButton: 1 { Literal } 60 0
		addButton: 2 {MSG file} 60 14
		addButton: 0 {  Cancel  } 60 28
		first: (if (param1 seq:) 2 else 1)
		init:
	)
)

(instance mainMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @mainItems)
	)
)

(instance editBMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editButtonItems)
	)
)

(instance editTMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editTextItems)
	)
)

(instance editEMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editEditItems)
	)
)

(instance editIMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editIconItems)
	)
)

(instance editSMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editSelectorItems)
	)
)

(instance editWMenu of ClickMenu
	(properties)

	(method (init)
		(super init: @editWindowItems)
	)
)

(class DlgWindow of SysWindow
	(properties
		noun 0
		verb 0
		case 0
		seq 0
		modNum 0
	)

	(method (open &tmp savePort)
		(= type (if title 4 else 0))
		(= savePort (GetPort))
		(super open: &rest)
		(SetPort savePort)
		(= windowUp 1)
	)

	(method (dispose)
		(super dispose:)
		(= windowUp 0)
	)

	(method (create &tmp t l b r num theItem)
		(= t 190)
		(= l 320)
		(= b 0)
		(= r 0)
		(for ((= num 0)) (< num (DialogEditor size:)) ((++ num))
			(= theItem (DialogEditor at: num))
			(= t (Min (theItem nsTop:) t))
			(= l (Min (theItem nsLeft:) l))
			(= b (Max (theItem nsBottom:) b))
			(= r (Max (theItem nsRight:) r))
		)
		(DialogEditor eachElementDo: #hide)
		(self dispose:)
		(= top (- t 4))
		(= bottom (+ b 4))
		(= left (- l 4))
		(= right (+ r 4))
		(self open:)
		(DialogEditor eachElementDo: #draw)
	)

	(method (moveTo mX mY &tmp num theItem dX dY)
		(for ((= num 0)) (< num (DialogEditor size:)) ((++ num))
			(= theItem (DialogEditor at: num))
			(= dX (- (theItem nsLeft:) left))
			(= dY (- (theItem nsTop:) top))
			(theItem hide: moveTo: (+ mX dX) (+ mY dY))
		)
		(= left mX)
		(= top mY)
		(self create:)
	)

	(method (editMsg)
		(if (localproc_1 self)
			(if title
				(Memory memFREE title)
			)
			(= title (Memory memALLOC_CRIT (Message msgSIZE modNum noun verb case seq)))
			(Message msgGET modNum noun verb case seq title)
		)
		(self create:)
	)

	(method (editPosn &tmp event eX eY h w)
		(if windowUp
			(Prints {Click to where the top left of the window should be})
			(while (!= ((= event (Event new:)) type:) evMOUSEBUTTON)
				(event dispose:)
			)
			(= eX (event x:))
			(= eY (- (event y:) 10))
			(event dispose:)
			(= h (- bottom top))
			(= w (- right left))
			(= eX (Max 0 (Min eX (- 320 w))))
			(= eY (Max 0 (Min eY (- 190 h))))
			(self moveTo: eX eY)
		else
			(Prints {No window to position!})
		)
	)

	(method (editTitle)
		(switch (localproc_2 self)
			(0
				(return)
			)
			(2
				(self editMsg:)
				(return)
			)
		)
		(if seq
			(Memory memFREE title)
			(= noun (= verb (= case (= seq (= modNum (= title 0))))))
		)
		(if (not title)
			(= title (Memory memALLOC_CRIT 50))
			(StrCpy title {title})
		)
		(Print
			addTitle: @winTitle
			addText: {Enter new title:}
			addEdit: title 50 0 12 title
			init:
		)
		(self create:)
	)
)

(class _DItem of DItem
	(properties
		underBits 0
	)

	(method (select hilite)
		(self hide:)
		(if hilite
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(self draw:)
	)

	(method (hide &tmp t l b r)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(= t (- nsTop 1))
			(= l (- nsLeft 1))
			(= b (+ nsBottom 1))
			(= r (+ nsRight 1))
			(= underBits 0)
			(Graph grREDRAW_BOX t l b r)
		)
	)

	(method (draw &tmp t l b r)
		(= t (- nsTop 1))
		(= l (- nsLeft 1))
		(= b (+ nsBottom 1))
		(= r (+ nsRight 1))
		(if underBits
			(UnLoad 133 underBits)
			(= underBits 0)
		)
		(= underBits (Graph grSAVE_BOX t l b r 1))
		(DrawControl self)
	)

	(method (editPosn &tmp [str 25] [str2 5] num theX theY)
		(Format @str {%d} nsLeft)
		(Format @str2 {%d} nsTop)
		(if
			(= num
				(Print
					addTitle: @winTitle
					addText: {Enter new position:}
					addText: {x = } 0 12
					addText: {y = } 65 12
					addEdit: @str 5 25 12 @str
					addEdit: @str2 6 90 12 @str2
					font: 0
					addButton: 0 { Cancel } 35 26
					init:
				)
			)
			(= theX (Max 4 (ReadNumber @str)))
			(= theY (Max 4 (ReadNumber @str2)))
			(self hide: moveTo: theX theY draw:)
		)
	)

	(method (handleEvent event &tmp ret)
		(= ret 0)
		(event claimed: 1)
		(= ret (self track: event))
	)

	(method (track event &tmp eX eY [str 40])
		(if (== (event type:) 1)
			(self hide:)
			(repeat
				(= event (Event new: -32768))
				(event localize:)
				(= eX (event x:))
				(= eY (event y:))
				(DrawStatus (Format @str {DRAGGING: %d, %d} eX eY))
				(self moveTo: eX eY)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(DrawStatus { } 0 0)
			(DrawStatus 0)
			(if (DialogEditor curMenu:)
				((DialogEditor curMenu:) init:)
			)
			(DrawPic (gCurRoom picture:) 100)
			(if windowUp
				(DlgWindow create:)
			else
				(DialogEditor eachElementDo: #draw)
			)
		)
	)

	(method (dispose)
		(self hide:)
		(super dispose: &rest)
	)
)

(class _DText of _DItem
	(properties
		type 2
		text 0
		font 0
		mode 0
		width 0
		noun 0
		verb 0
		case 0
		seq 0
		modNum 0
	)

	(method (setSize w &tmp [r 4])
		(TextSize @[r 0] text font (if argc w else width))
		(-- nsLeft)
		(-- nsTop)
		(= nsBottom (+ nsTop [r 2] 1))
		(= nsRight (+ nsLeft [r 3] 1))
	)

	(method (editFont &tmp [str 25] num)
		(= num
			(Print
				addTitle: @winTitle
				font: 0
				width: 90
				addText: {Enter new font number:}
				addEdit: @str 6 0 24
				addButton: 0 { System } 100 0
				addButton: gUserFont {  User  } 100 14
				addButton: gSmallFont {  Small  } 100 28
				addButton: gBigFont {   Big   } 100 42
				addButton: -1 { Cancel } 100 56
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if (!= num -1)
			(self hide: font: num setSize: draw:)
		)
	)

	(method (editJust &tmp [str 25] num)
		(= str 0)
		(= num
			(Print
				addTitle: @winTitle
				font: 0
				width: 100
				addText: {Enter justification mode:}
				addButton: 1 {   Left   } 100 0
				addButton: 2 { Center } 100 14
				addButton: 3 {  Right  } 100 28
				addButton: 0 { Cancel } 100 42
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(self
				hide:
				mode:
					(switch num
						(1 0)
						(2 1)
						(3 -1)
					)
				setSize:
				draw:
			)
		)
	)

	(method (editMsg)
		(if (localproc_1 self)
			(Memory memFREE text)
			(= text (Memory memALLOC_CRIT (Message msgSIZE modNum noun verb case seq)))
			(Message msgGET modNum noun verb case seq text)
		)
		(self hide: setSize: draw:)
	)

	(method (editText)
		(switch (localproc_2 self)
			(0
				(return)
			)
			(2
				(self editMsg:)
				(return)
			)
		)
		(if seq
			(Memory memFREE text)
			(= text (Memory memALLOC_CRIT 100))
			(StrCpy text {text})
			(= noun (= verb (= case (= seq (= modNum 0)))))
		)
		(Print
			addTitle: @winTitle
			addText: {Enter new text:}
			addEdit: text 50 0 12 text
			init:
		)
		(self hide: setSize: draw:)
	)

	(method (editWidth &tmp [str 25] num)
		(Format @str {%d} width)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new width:}
				addEdit: @str 6 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(self hide: width: num setSize: draw:)
		)
	)

	(method (showHelp)
		(Print
			font: gUserFont
			width: 250
			addText:
				{Text Menu:\n\n  Text - Change the text\n  Font - Change the font of the text\n  Just - Change justification mode\n  Position - Change the position of the text\n  Menu - Return to the Main Menu\n}
			init:
		)
	)
)

(class _DIcon of _DItem
	(properties
		type 4
		view 0
		loop 0
		cel 0
	)

	(method (setSize)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)

	(method (editView &tmp [str 25] num)
		(Format @str {%d} view)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new view number:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(= view num)
		)
		(self hide: setSize: draw:)
	)

	(method (editLoop &tmp [str 25] num)
		(Format @str {%d} loop)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new loop number:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(= loop num)
		)
		(self hide: setSize: draw:)
	)

	(method (editCel &tmp [str 25] num)
		(Format @str {%d} cel)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new cel number:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(= cel num)
		)
		(self hide: setSize: draw:)
	)

	(method (showHelp)
		(Print
			font: gUserFont
			width: 250
			addText:
				{Icon Menu:\n\n  View - Change the view of the icon\n  Loop - Change the loop of the icon\n  Cel - Change the cel of the icon\n  Position - Change the position of the icon\n  Menu - Return to the Main Menu\n}
			init:
		)
	)
)

(class _DButton of _DItem
	(properties
		type 1
		state 1
		text 0
		font 0
		noun 0
		verb 0
		case 0
		seq 0
		modNum 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font 0 0)
		(+= [r 2] 2)
		(+= [r 3] 2)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 15) 16) 16))
		(= nsRight (+ [r 3] nsLeft))
	)

	(method (editFont &tmp [str 25] num)
		(= num
			(Print
				addTitle: @winTitle
				font: 0
				width: 90
				addText: {Enter new font number:}
				addEdit: @str 6 0 24
				addButton: 0 { System } 100 0
				addButton: gUserFont {  User  } 100 14
				addButton: gSmallFont {  Small  } 100 28
				addButton: gBigFont {   Big   } 100 42
				addButton: -1 { Cancel } 100 56
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if (!= num -1)
			(self hide: font: num setSize: draw:)
		)
	)

	(method (editMsg)
		(if (localproc_1 self)
			(Memory memFREE text)
			(= text (Memory memALLOC_CRIT (Message msgSIZE modNum noun verb case seq)))
			(Message msgGET modNum noun verb case seq text)
		)
		(self hide: setSize: draw:)
	)

	(method (editText)
		(switch (localproc_2 self)
			(0
				(return)
			)
			(2
				(self editMsg:)
				(return)
			)
		)
		(if seq
			(Memory memFREE text)
			(= text (Memory memALLOC_CRIT 50))
			(StrCpy text {button})
			(= noun (= verb (= case (= seq (= modNum 0)))))
		)
		(Print
			addTitle: @winTitle
			addText: {Enter new text:}
			addEdit: text 50 0 12 text
			init:
		)
		(self hide: setSize: draw:)
	)

	(method (editValue &tmp [str 25] num)
		(Format @str {%d} value)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new value:}
				addEdit: @str 6 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(= value num)
		)
	)

	(method (showHelp)
		(Print
			font: gUserFont
			width: 250
			addText:
				{Button Menu:\n\n  Text - Change the button text\n  Font - Change the font of the button text\n  Value - Change the return value of the button\n  Position - Change the position of the button\n  Menu - Return to the Main Menu\n}
			init:
		)
	)
)

(class _DEdit of _DItem
	(properties
		type 3
		state 1
		text 0
		font 0
		max 0
		cursor 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)

	(method (editFont &tmp [str 25] num)
		(= num
			(Print
				addTitle: @winTitle
				font: 0
				width: 90
				addText: {Enter new font number:}
				addEdit: @str 6 0 24
				addButton: 0 { System } 100 0
				addButton: gUserFont {  User  } 100 14
				addButton: gSmallFont {  Small  } 100 28
				addButton: gBigFont {   Big   } 100 42
				addButton: -1 { Cancel } 100 56
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if (!= num -1)
			(self hide: font: num setSize: draw:)
		)
	)

	(method (editLength &tmp [str 25] num)
		(Format @str {%d} max)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new maximum length:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(self max: num hide: setSize: draw:)
		)
	)

	(method (editText)
		(Print
			addTitle: @winTitle
			addText: {Enter new default text:}
			addEdit: text 25 0 12 text
			init:
		)
		(self hide: setSize: draw:)
	)

	(method (showHelp)
		(Print
			font: gUserFont
			width: 250
			addText:
				{Edit Menu:\n\n  Font - Change the font of the edit text\n  Length - Change the maximum length of input\n  Position - Change the position of the edit\n  Text - Change the default edit text\n  Menu - Return to the Main Menu\n}
			init:
		)
	)
)

(class _DSelector of _DItem
	(properties
		type 6
		font 0
		x 20
		y 6
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop 20 (* [r 2] y)))
		(= nsRight (+ nsLeft (/ (* [r 3] x 3) 4)))
	)

	(method (editLength &tmp [str 25] num)
		(Format @str {%d} y)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new length:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(self y: num hide: setSize: draw:)
		)
	)

	(method (editWidth &tmp [str 25] num)
		(Format @str {%d} x)
		(= num
			(Print
				addTitle: @winTitle
				addText: {Enter new width:}
				addEdit: @str 5 0 12 @str
				font: 0
				addButton: 0 { Cancel } 0 26
				init:
			)
		)
		(if str
			(= num (ReadNumber @str))
		)
		(if num
			(self x: num hide: setSize: draw:)
		)
	)

	(method (showHelp)
		(Print
			font: gUserFont
			width: 250
			addText:
				{Selector Menu:\n\n  Width - Change the selector width (in chars)\n  Length - Change number of selector lines\n  Position - Change the position of the selector\n  Menu - Return to the Main Menu\n}
			init:
		)
	)
)

(class DialogEditor of List
	(properties
		state 0
		curItem 0
		curMenu 0
	)

	(method (init)
		(= saveWin gSystemWindow)
		(StrCpy @winTitle {DialogEditor  v1.1})
		((= gSystemWindow SysWindow) color: 0 back: 255)
		(gGame setCursor: 999)
		(self changeState: 0)
	)

	(method (dispose)
		(mainMenu dispose:)
		(DlgWindow dispose:)
		(= gSystemWindow saveWin)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(DrawStatus { } 0 0)
		(DrawStatus 0)
		(super dispose:)
		(DrawPic (gCurRoom picture:) 100)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(if curMenu
			(curMenu dispose:)
		)
		(= curMenu
			(switch (= state newState)
				(0 mainMenu)
				(1 editBMenu)
				(2 editTMenu)
				(3 editEMenu)
				(4 editIMenu)
				(5 editSMenu)
				(6 editWMenu)
				(else 0)
			)
		)
		(if curMenu
			(curMenu init:)
		)
	)

	(method (delItem &tmp [temp0 45])
		(if size
			(if
				(Print
					addText: {Delete current item?}
					font: 0
					addButton: 1 {Yes} 0 12
					addButton: 0 {No} 40 12
					init:
				)
				(self delete: curItem)
				(curItem dispose:)
				(= curItem 0)
				(if size
					(= curItem (self at: 0))
				)
			)
		else
			(Prints {Nothing to delete!})
		)
	)

	(method (exit &tmp [str 100] rc file fileMode)
		(if (not windowUp)
			(DlgWindow create:)
		)
		(if (not fileName)
			(Format @fileName {%d.dlg} gCurRoomNum)
		)
		(if
			(not
				(= rc
					(Print
						addTitle: @winTitle
						addText: {Save to: }
						addEdit: @fileName 25 60 0 @fileName
						font: 0
						addButton: 1 {  Save  } 10 12
						addButton: 2 { Abandon } 80 12
						addButton: 0 { Cancel } 151 12
						init:
					)
				)
			)
			(return 0)
		)
		(if (== rc 2)
			(return 1)
		)
		(if (FileIO fiEXISTS @fileName)
			(Format @str {The file '%s' already exists.  Now what?} @fileName)
			(if
				(not
					(= rc
						(Print
							addTitle: @winTitle
							addText: @str
							font: 0
							addButton: 1 { Replace } 0 24
							addButton: 2 { Append } 70 24
							addButton: 0 { Cancel } 125 24
							init:
						)
					)
				)
				(return 0)
			)
		)
		(= fileMode (if (== rc 1) 2 else 0))
		(if (not ((= file (File new:)) name: @fileName open: fileMode))
			(Printf {Error opening '%s'} (file name:))
			(file dispose:)
			(return 0)
		)
		(file
			writeString: {\t\t; DialogEditor v1.0\r\n}
			writeString: {\t\t; by Brian K. Hughes\r\n}
			writeString: {\t\t(Print\r\n}
		)
		(if windowUp
			(Format
				@str
				{\t\t\tposn:\t\t\t%d %d,\r\n}
				(DlgWindow left:)
				(DlgWindow top:)
			)
			(file writeString: @str)
			(if (DlgWindow title:)
				(if (DlgWindow seq:)
					(Format
						@str
						{\t\t\taddTitle:\t%d %d %d %d %d,\r\n}
						(DlgWindow noun:)
						(DlgWindow verb:)
						(DlgWindow case:)
						(DlgWindow seq:)
						(DlgWindow modNum:)
					)
				else
					(Format
						@str
						{\t\t\taddTitle:\t\{%s\},\r\n}
						(DlgWindow title:)
					)
				)
				(file writeString: @str)
			)
		)
		(self writeFile: file)
		(if
			(Print
				addTitle: @winTitle
				addText: {This dialog should be...}
				font: 0
				addButton: 0 {   Modal   } 0 24
				addButton: 1 { Modeless } 0 38
				init:
			)
			(file writeString: {\t\t\tmodeless:\tTRUE,\r\n})
		)
		(file writeString: {\t\t\tinit:\r\n} writeString: {\t\t)\r\n})
		(file dispose:)
		(return 1)
	)

	(method (doit &tmp event [str 100])
		(self init:)
		(repeat
			(= event (Event new:))
			(if (not (curMenu handleEvent: event))
				(GlobalToLocal event)
				(breakif (self handleEvent: event))
			)
			(event dispose:)
		)
		(event dispose:)
		(self dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 506] [temp508 30] [temp538 30] [temp568 30] [temp598 30] [temp628 30] [temp658 20] [temp678 30] [temp708 30] [temp738 20] [temp758 30] [temp788 30])
		(switch (event type:)
			(evNULL)
			(evMOUSEBUTTON
				(if (= temp1 (self firstTrue: #check event))
					(event claimed: 1)
					(if (== (event modifiers:) emSHIFT)
						(temp1 handleEvent: event)
					else
						(if curItem
							(curItem select: 0)
						)
						((= curItem temp1) select: 1)
						(self changeState: 0)
					)
				)
			)
			(evMOUSERELEASE)
			(evKEYBOARD
				(switch (event message:)
					(KEY_QUESTION
						(event message: KEY_h)
					)
					(KEY_PAUSE
						(event message: KEY_x)
					)
				)
				(switch (event message:)
					(KEY_TAB
						(curItem select: 0)
						(= temp0 (DialogEditor indexOf: curItem))
						(if (== (++ temp0) (DialogEditor size:))
							(= curItem (DialogEditor at: 0))
						else
							(= curItem (DialogEditor at: temp0))
						)
						(curItem select: 1)
						(DialogEditor changeState: 0)
					)
					(KEY_SHIFTTAB
						(curItem select: 0)
						(if (== (= temp0 (DialogEditor indexOf: curItem)) 0)
							(= curItem
								(DialogEditor at: (- (DialogEditor size:) 1))
							)
						else
							(= curItem (DialogEditor at: (-- temp0)))
						)
					)
					(KEY_SPACE)
					(JOY_UPLEFT)
					(KEY_a
						(Print
							addTitle: @winTitle
							mode: 1
							width: 140
							addText: {by Brian K. Hughes\n17 July, 1992}
							init:
						)
					)
					(KEY_c
						(switch state
							(4
								(curItem editCel:)
							)
							(6
								(if size
									(DlgWindow create:)
								else
									(Prints {Can't create window: no items!})
								)
							)
						)
					)
					(KEY_d
						(switch state
							(0
								(self delItem:)
							)
							(6
								(if windowUp
									(DlgWindow dispose:)
									(self eachElementDo: #draw)
								else
									(Prints {No window to delete!})
								)
							)
						)
					)
					(KEY_e
						(if size
							(self
								changeState:
									(switch (curItem -super-:)
										(_DButton 1)
										(_DText 2)
										(_DEdit 3)
										(_DIcon 4)
										(_DSelector 5)
									)
							)
						else
							(Prints {No items to edit!})
						)
					)
					(KEY_f
						(if (OneOf state 2 1 3)
							(curItem editFont:)
						)
					)
					(KEY_h
						(switch state
							(0
								(Print
									font: gUserFont
									width: 250
									addText:
										{Main Menu:\n\n  About - About the DialogEditor\n  Item - Create a new item\n  Edit - Edit properties of the current item\n  Look - View properties of the current item\n  Del - Delete the current item\n  Win - Create a window background\n  Help - You're here!\n  eXit - Exit the DialogEditor (& maybe save)\n}
									init:
								)
							)
							(6
								(Print
									font: gUserFont
									width: 250
									addText:
										{Window Menu:\n\n  Create - Draw the window to the correct size\n  Position - Move the window and all items\n  Delete - Remove the window\n  Menu - Return to the Main Menu}
									init:
								)
							)
							(else
								(curItem showHelp:)
							)
						)
					)
					(KEY_i
						(= temp1 0)
						(switch
							(Print
								addTitle: @winTitle
								width: 65
								addText:
									{Select the kind of item you want to add to the dialog:}
								font: 0
								addButton: 1 {  Button  } 80 0
								addButton: 2 {   Text   } 80 14
								addButton: 3 {   Edit   } 80 28
								addButton: 4 {   Icon   } 80 42
								addButton: 6 { Selector } 80 56
								addButton: 0 {  Cancel  } 80 70
								init:
							)
							(1
								(= temp0 (Memory memALLOC_CRIT 50))
								(StrCpy temp0 {button})
								(= temp1
									((_DButton new:) text: temp0 yourself:)
								)
							)
							(2
								(= temp0 (Memory memALLOC_CRIT 100))
								(StrCpy temp0 {text})
								(= temp1 ((_DText new:) text: temp0 yourself:))
							)
							(3
								(= temp0 (Memory memALLOC_CRIT 50))
								(StrCpy temp0 {})
								(= temp1
									((_DEdit new:) text: temp0 max: 5 yourself:)
								)
							)
							(4
								(= temp1
									((_DIcon new:)
										view: 0
										loop: 0
										cel: 0
										yourself:
									)
								)
							)
							(6
								(= temp1
									((_DSelector new:) x: 10 y: 1 yourself:)
								)
							)
						)
						(if temp1
							(if curItem
								(curItem select: 0)
							)
							(= curItem temp1)
							(if windowUp
								(DlgWindow dispose:)
							)
							(self
								addToEnd:
									(curItem setSize: moveTo: 4 4 yourself:)
								eachElementDo: #draw
							)
							(curItem select: 1)
						)
					)
					(KEY_j
						(if (== state 2)
							(curItem editJust:)
						)
					)
					(KEY_l
						(switch state
							(0
								(if curItem
									(Format
										@temp508
										{  x:       %d}
										(curItem nsLeft:)
									)
									(Format
										@temp538
										{  y:       %d}
										(curItem nsTop:)
									)
									(switch (curItem -super-:)
										(_DText
											(StrCpy @temp788 {Text Item})
											(StrCpy @temp2 (curItem text:))
											(Format
												@temp568
												{  text:   %s}
												(localproc_0 @temp2 15)
											)
											(Format
												@temp598
												{  font:   %d}
												(curItem font:)
											)
											(Format
												@temp628
												{  width:  %d}
												(curItem width:)
											)
											(Format
												@temp658
												{  noun:   %d}
												(curItem noun:)
											)
											(Format
												@temp678
												{  verb:   %d}
												(curItem verb:)
											)
											(Format
												@temp708
												{  case:   %d}
												(curItem case:)
											)
											(Format
												@temp738
												{  seq:    %d}
												(curItem seq:)
											)
											(Format
												@temp758
												{  modNum: %d}
												(curItem modNum:)
											)
										)
										(_DButton
											(StrCpy @temp788 {Button Item})
											(StrCpy @temp2 (curItem text:))
											(Format
												@temp568
												{  text:   %s}
												(localproc_0 @temp2 15)
											)
											(Format
												@temp598
												{  font:   %d}
												(curItem font:)
											)
											(Format
												@temp628
												{  value:  %d}
												(curItem value:)
											)
											(Format
												@temp658
												{  noun:   %d}
												(curItem noun:)
											)
											(Format
												@temp678
												{  verb:   %d}
												(curItem verb:)
											)
											(Format
												@temp708
												{  case:   %d}
												(curItem case:)
											)
											(Format
												@temp738
												{  seq:    %d}
												(curItem seq:)
											)
											(Format
												@temp758
												{  modNum: %d}
												(curItem modNum:)
											)
										)
										(_DIcon
											(StrCpy @temp788 {Icon Item})
											(Format
												@temp568
												{  view:   %d}
												(curItem view:)
											)
											(Format
												@temp598
												{  loop:   %d}
												(curItem loop:)
											)
											(Format
												@temp628
												{  cel:    %d}
												(curItem cel:)
											)
											(= temp658
												(= temp678
													(= temp708
														(= temp738
															(= temp758 0)
														)
													)
												)
											)
										)
										(_DEdit
											(StrCpy @temp788 {Edit Item})
											(StrCpy @temp2 (curItem text:))
											(Format
												@temp568
												{  text:   %s}
												(localproc_0 @temp2 15)
											)
											(Format
												@temp598
												{  font:   %d}
												(curItem font:)
											)
											(Format
												@temp628
												{  max:    %d}
												(curItem max:)
											)
											(= temp658
												(= temp678
													(= temp708
														(= temp738
															(= temp758 0)
														)
													)
												)
											)
										)
										(_DSelector
											(StrCpy @temp788 {Selector Item})
											(Format
												@temp568
												{  width:  %d}
												(curItem x:)
											)
											(Format
												@temp598
												{  length: %d}
												(curItem y:)
											)
											(= temp628
												(= temp658
													(= temp678
														(= temp708
															(= temp738
																(= temp758 0)
															)
														)
													)
												)
											)
										)
									)
									(Print
										addTitle: @temp788
										addText: @temp508
										addText: @temp538 0 12
										addText: @temp568 0 24
										addText: @temp598 0 36
										addText: @temp628 0 48
										addText: @temp658 0 60
										addText: @temp678 0 72
										addText: @temp708 0 84
										addText: @temp738 0 96
										addText: @temp758 0 108
										init:
									)
									(if windowUp
										(DlgWindow create:)
									)
								else
									(Prints {No item to look at!})
								)
							)
							(4
								(curItem editLoop:)
							)
							(3
								(curItem editLength:)
							)
							(5
								(curItem editLength:)
							)
						)
					)
					(KEY_m
						(self changeState: 0)
					)
					(KEY_p
						(switch state
							(6
								(DlgWindow editPosn:)
							)
							(else
								(curItem editPosn:)
							)
						)
					)
					(KEY_t
						(switch state
							(6
								(DlgWindow editTitle:)
							)
							(else
								(curItem editText:)
							)
						)
					)
					(KEY_v
						(switch state
							(4
								(curItem editView:)
							)
							(1
								(curItem editValue:)
							)
						)
					)
					(KEY_w
						(switch state
							(0
								(self changeState: 6)
							)
							(5
								(curItem editWidth:)
							)
							(2
								(curItem editWidth:)
							)
						)
					)
					(KEY_x
						(self exit:)
						(return)
					)
				)
			)
		)
		(return 0)
	)

	(method (writeFile file &tmp i theItem [str 100] lastFont lastMode lastWidth)
		(= lastFont -1)
		(= lastMode 0)
		(= lastWidth 0)
		(for ((= i 0)) (< i size) ((++ i))
			(= theItem (self at: i))
			(switch (theItem -super-:)
				(_DButton
					(if (!= (theItem font:) lastFont)
						(= lastFont (theItem font:))
						(Format @str {\t\t\tfont:\t\t\t%d,\r\n} lastFont)
						(file writeString: @str)
					)
					(if (theItem seq:)
						(Format
							@str
							{\t\t\taddButton:\t%d %d %d %d %d %d %d %d, \r\n}
							(theItem value:)
							(theItem noun:)
							(theItem verb:)
							(theItem case:)
							(theItem seq:)
							(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
							(- (- (theItem nsTop:) (DlgWindow top:)) 4)
							(theItem modNum:)
						)
					else
						(Format
							@str
							{\t\t\taddButton:\t%d \{%s\} %d %d,\r\n}
							(theItem value:)
							(theItem text:)
							(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
							(- (- (theItem nsTop:) (DlgWindow top:)) 4)
						)
					)
					(file writeString: @str)
				)
				(_DText
					(if (!= (theItem font:) lastFont)
						(= lastFont (theItem font:))
						(Format @str {\t\t\tfont:\t\t\t%d,\r\n} lastFont)
						(file writeString: @str)
					)
					(if (!= (theItem mode:) lastMode)
						(= lastMode (theItem mode:))
						(Format
							@str
							{\t\t\tmode:\t\t\t%s,\r\n}
							(switch (theItem mode:)
								(0 {teJustLeft})
								(-1 {teJustRight})
								(1 {teJustCenter})
							)
						)
						(file writeString: @str)
					)
					(if (!= (theItem width:) lastWidth)
						(= lastWidth (theItem width:))
						(Format @str {\t\t\twidth:\t\t%d, \r\n} lastWidth)
						(file writeString: @str)
					)
					(if (theItem seq:)
						(Format
							@str
							{\t\t\taddText:\t\t%d %d %d %d %d %d %d, \r\n}
							(theItem noun:)
							(theItem verb:)
							(theItem case:)
							(theItem seq:)
							(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
							(- (- (theItem nsTop:) (DlgWindow top:)) 4)
							(theItem modNum:)
						)
					else
						(Format
							@str
							{\t\t\taddText:\t\t\{%s\} %d %d,\r\n}
							(theItem text:)
							(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
							(- (- (theItem nsTop:) (DlgWindow top:)) 4)
						)
					)
					(file writeString: @str)
				)
				(_DEdit
					(if (!= (theItem font:) lastFont)
						(= lastFont (theItem font:))
						(Format @str {\t\t\tfont:\t\t\t%d,\r\n} lastFont)
						(file writeString: @str)
					)
					(Format
						@str
						{\t\t\taddEdit:\t\t@str %d %d %d \{%s\},\r\n}
						(theItem max:)
						(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
						(- (- (theItem nsTop:) (DlgWindow top:)) 4)
						(theItem text:)
					)
					(file writeString: @str)
				)
				(_DIcon
					(Format
						@str
						{\t\t\taddIcon:\t\t%d %d %d %d %d,\r\n}
						(theItem view:)
						(theItem loop:)
						(theItem cel:)
						(- (- (theItem nsLeft:) (DlgWindow left:)) 4)
						(- (- (theItem nsTop:) (DlgWindow top:)) 4)
					)
					(file writeString: @str)
				)
				(_DSelector)
			)
		)
	)
)

