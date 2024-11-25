;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use System)

(public
	Print 0
	ShowView 1
	GetInput 2
	GetNumber 3
	Printf 4
	MousedOn 5
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (MousedOn obj event) ; UNUSED
	(return
		(and
			(< (obj nsLeft:) (event x:) (obj nsRight:))
			(< (obj nsTop:) (event y:) (obj nsBottom:))
		)
	)
)

(procedure (GetInput str maxLen prompt &tmp [temp0 4])
	(if (Print (if (>= argc 3) prompt else {}) #edit str maxLen &rest)
		(StrLen str)
	)
)

(procedure (ShowView txt v l c) ; UNUSED
	(Print txt #icon v l c &rest)
)

(procedure (Print args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 6] temp18 temp19 temp20 [temp21 1001] temp1022 temp1023 temp1024 temp1025 temp1026 temp1027 temp1028 temp1029 temp1030 temp1031 temp1032)
	(= temp1028 0)
	(= temp1029 0)
	(= temp6 (= temp7 -1))
	(= temp1026 (gGame printLang:))
	(= temp1027 (gGame subtitleLang:))
	(= temp1032
		(= temp9
			(= temp8
				(= temp18
					(= temp2 (= temp3 (= temp1023 (= temp1030 (= temp19 0)))))
				)
			)
		)
	)
	((= temp0 (Dialog new:)) window: gSystemWindow name: {PrintD})
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp21)
			(= temp5 2)
		)
		([args 0]
			(StrCpy @temp21 [args 0])
			(= temp5 1)
		)
		(else
			(= temp21 0)
			(= temp5 0)
		)
	)
	(for ((= temp1022 0)) (StrAt @temp21 temp1022) ((++ temp1022))
		(if
			(and
				(== (StrAt @temp21 temp1022) 14848)
				(== (StrAt @temp21 (+ 1 temp1022)) 74)
			)
			(gGame printLang: 1 subtitleLang: 81)
			(StrSplit @temp21 @temp21 {#J})
			(gGame printLang: temp1026 subtitleLang: temp1027)
			(StrAt @temp21 temp1022 0)
			(if (OneOf 81 temp1026 temp1027)
				((= temp1023 (DText new:))
					text: (+ @temp21 2 temp1022)
					font: 900
					name: {jDText}
				)
			)
		)
	)
	((= temp1 (DText new:)) text: @temp21 font: gUserFont)
	(= temp1024 (if (and temp1023 (== temp1026 81)) temp1023 else temp1))
	(= temp1025
		(cond
			((== temp1027 81) temp1023)
			(temp1023
				(if temp1027
					temp1
				else
					(temp1 dispose:)
					(= temp1 0)
				)
			)
		)
	)
	(temp1024 moveTo: 4 4 setSize:)
	(temp0 add: temp1024 setSize:)
	(if temp1025
		(temp1025
			setSize:
			moveTo: (temp1024 nsLeft:) (+ 4 (temp1024 nsBottom:))
		)
		(temp0 add: temp1025 setSize:)
	)
	(for ((= temp5 temp5)) (< temp5 argc) ((++ temp5))
		(switch [args temp5]
			(30
				(++ temp5)
				(if (and temp1 (not temp1025))
					(temp1 mode: [args temp5])
				)
			)
			(33
				(++ temp5)
				(if temp1
					(temp1 font: [args temp5] setSize: temp8)
				)
			)
			(70
				(= temp1028 1)
				(= temp8 [args (++ temp5)])
				(temp1024 setSize: temp8)
				(if temp1025
					(temp1025
						setSize: temp8
						moveTo: (temp1024 nsLeft:) (+ 4 (temp1024 nsBottom:))
					)
				)
			)
			(25
				(++ temp5)
				(temp0 time: [args temp5])
			)
			(80
				(++ temp5)
				(temp0 text: [args temp5])
			)
			(67
				(= temp6 [args (++ temp5)])
				(= temp7 [args (++ temp5)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(++ temp5)
				((= temp3 (DEdit new:)) text: [args temp5])
				(++ temp5)
				(temp3 max: [args temp5] setSize:)
			)
			(81
				((= [temp12 temp19] (DButton new:))
					text: [args (++ temp5)]
					value: [args (++ temp5)]
					setSize:
				)
				(+= temp18 (+ ([temp12 temp19] nsRight:) 4))
				(++ temp19)
			)
			(82
				(= temp1029 1)
				(if (IsObject [args (+ temp5 1)])
					(= temp2 ([args (+ temp5 1)] new:))
					(temp2 setSize:)
					(+= temp5 1)
				else
					(= temp2 (DIcon new:))
					(temp2
						view: [args (+ temp5 1)]
						loop: [args (+ temp5 2)]
						cel: [args (+ temp5 3)]
						setSize:
					)
					(+= temp5 3)
				)
			)
			(105
				(if (and (< (+ temp5 1) argc) (IsObject [args (+ temp5 1)]))
					(temp0 caller: [args (+ temp5 1)])
					(++ temp5)
				)
				(if (!= 0 81)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(= temp9 temp0)
				)
			)
			(35
				(++ temp5)
				(temp0 window: [args temp5])
			)
			(118
				(= temp1032 1)
			)
		)
	)
	(if temp1032
		(= temp9 0)
	)
	(if
		(and
			(not (or temp1028 temp1029))
			(> (- (temp0 nsBottom:) (temp0 nsTop:)) 100)
		)
		(temp1024 setSize: 300)
		(if temp1025
			(temp1025
				setSize: 300
				moveTo: (temp1024 nsLeft:) (+ 4 (temp1024 nsBottom:))
			)
		)
	)
	(if temp2
		(temp2 moveTo: 4 4)
		(if (or (== temp1024 temp1023) (== temp1025 temp1023))
			(= temp1030 8)
		)
		(if (& (temp2 state:) $0010)
			(temp1024
				moveTo: (+ 4 temp1030) (+ (temp2 nsBottom:) (temp1024 nsTop:))
				setSize:
			)
		else
			(temp1024
				moveTo: (+ 4 (temp2 nsRight:) temp1030) (temp1024 nsTop:)
				setSize:
			)
		)
		(if temp1025
			(temp1025 moveTo: (temp1024 nsLeft:) (+ 4 (temp1024 nsBottom:)))
		)
		(temp0 add: temp2)
	)
	(temp0 setSize:)
	(if temp3
		(temp3
			moveTo:
				((or temp1025 temp1024) nsLeft:)
				(+ 4 ((or temp1025 temp1024) nsBottom:))
		)
		(temp0 add: temp3 setSize:)
	)
	(= temp20
		(if (> temp18 (temp0 nsRight:))
			4
		else
			(- (temp0 nsRight:) temp18)
		)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		([temp12 temp5] moveTo: temp20 (temp0 nsBottom:))
		(temp0 add: [temp12 temp5])
		(= temp20 (+ 4 ([temp12 temp5] nsRight:)))
	)
	(temp0 setSize: center:)
	(if
		(or
			(and temp2 (& (temp2 state:) $0010))
			(and temp2 (not (StrLen @temp21)))
		)
		(temp2
			moveTo:
				(/
					(-
						(- (temp0 nsRight:) (temp0 nsLeft:))
						(- (temp2 nsRight:) (temp2 nsLeft:))
					)
					2
				)
				4
		)
	)
	(temp0
		moveTo:
			(if (== -1 temp6)
				(temp0 nsLeft:)
			else
				temp6
			)
			(if (== -1 temp7)
				(temp0 nsTop:)
			else
				temp7
			)
	)
	(= temp11 (GetPort))
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp9 15 else -1))
	(if temp9
		(= gModelessPort (GetPort))
		(SetPort temp11)
		(return (= gModelessDialog temp9))
	else
		(gSounds pause: 1)
	)
	(if
		(and
			(= temp10 (temp0 firstTrue: #checkState 1))
			(not (temp0 firstTrue: #checkState 2))
		)
		(temp10 state: (| (temp10 state:) $0002))
	)
	(if (== (= temp4 (temp0 doit: temp10)) -1)
		(= temp4 0)
	)
	(for ((= temp5 0)) (< temp5 temp19) ((++ temp5))
		(if (== temp4 [temp12 temp5])
			(= temp4 (temp4 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp4 1)
	)
	(temp0 dispose:)
	(gSounds pause: 0)
	(return temp4)
)

(procedure (GetNumber string default &tmp [theLine 40])
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine 255 0 default) ; "%d"
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (Printf &tmp [str 500])
	(Format @str &rest)
	(Print @str)
)

(class MenuBar of Obj
	(properties
		state 0
	)

	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)

	(method (hide)
		(DrawMenuBar 0)
	)

	(method (add)
		(AddMenu &rest)
	)

	(method (handleEvent event &tmp retVal oldRepeat)
		(= retVal 0)
		(if state
			(= oldRepeat (Joystick 12 30))
			(= retVal (MenuSelect event &rest))
			(Joystick 12 oldRepeat)
		)
		(return retVal)
	)
)

(class Item of Obj
	(properties
		type 0
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)

	(method (enable bool)
		(if bool
			(|= state $0001)
		else
			(&= state $fffe)
		)
	)

	(method (select bool)
		(if bool
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(self draw:)
	)

	(method (handleEvent event &tmp ret evtType evt)
		(if (event claimed:)
			(return 0)
		)
		(= ret 0)
		(if
			(and
				(& state $0001)
				(or
					(and (== (= evtType (event type:)) evSAID) (Said said))
					(and (== evtType evKEYBOARD) (== (event message:) key))
					(and (== evtType evMOUSEBUTTON) (self check: event))
				)
			)
			(event claimed: 1)
			(= ret (self track: event))
		)
		(return ret)
	)

	(method (check event)
		(return
			(and
				(>= (event x:) nsLeft)
				(>= (event y:) nsTop)
				(< (event x:) nsRight)
				(< (event y:) nsBottom)
			)
		)
	)

	(method (track event &tmp in lastIn)
		(if (== 1 (event type:))
			(= lastIn 0)
			(repeat
				(= event (Event new: evPEEK))
				(event localize:)
				(if (!= (= in (self check: event)) lastIn)
					(HiliteControl self)
					(= lastIn in)
				)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(if in
				(HiliteControl self)
			)
			(return in)
		else
			(return self)
		)
	)

	(method (isType param1)
		(return (== type param1))
	)

	(method (checkState param1)
		(return (& state param1))
	)

	(method (doit)
		(return value)
	)

	(method (setSize))

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)

	(method (draw)
		(DrawControl self)
	)

	(method (cycle))
)

(class DText of Item
	(properties
		type 2
		text 0
		font 1
		mode 0
	)

	(method (new &tmp newText)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp [r 4])
		(TextSize
			@[r 0]
			text
			font
			(if argc w else 0)
			{\0d\n----------\0d\n}
		)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft [r 3]))
	)
)

(class DIcon of Item
	(properties
		type 4
		view 0
		loop 0
		cel 0
	)

	(method (setSize &tmp [r 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of Item
	(properties
		type 1
		state 3
		text 0
		font 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font 0 0)
		(+= [r 2] 2)
		(+= [r 3] 2)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 15) 16) 16))
		(= nsRight (+ [r 3] nsLeft))
	)
)

(class DEdit of Item
	(properties
		type 3
		state 1
		text 0
		font 0
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(= font gInputFont)
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of Item
	(properties
		type 6
		font 0
		x 20
		y 6
		text 0
		cursor 0
		topString 0
		mark 0
	)

	(method (indexOf what &tmp ptr i)
		(= ptr text)
		(for ((= i 0)) (< i 300) ((++ i))
			(if (== 0 (StrLen ptr))
				(return -1)
			)
			(if (not (StrCmp what ptr))
				(return i)
			)
			(+= ptr x)
		)
	)

	(method (at what)
		(return (+ text (* x what)))
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop 20 (* [r 2] y)))
		(= nsRight (+ nsLeft (/ (* [r 3] x 3) 4)))
		(= topString (= cursor text))
		(= mark 0)
	)

	(method (retreat lines &tmp redraw)
		(= redraw 0)
		(while lines
			(if (!= cursor text)
				(= redraw 1)
				(-= cursor x)
				(if mark
					(-- mark)
				else
					(-= topString x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(return
			(if redraw
				(self draw:)
				1
			)
		)
	)

	(method (advance lines &tmp redraw)
		(if (not (StrAt cursor 0))
			(return)
		)
		(= redraw 0)
		(while lines
			(if (StrAt cursor x)
				(= redraw 1)
				(+= cursor x)
				(if (< (+ mark 1) y)
					(++ mark)
				else
					(+= topString x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(return
			(if redraw
				(self draw:)
				1
			)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(switch (event type:)
			(evKEYBOARD
				(event
					claimed:
						(switch (event message:)
							(KEY_HOME
								(self retreat: 50)
							)
							(KEY_END
								(self advance: 50)
							)
							($5100 ; PAGEDOWN
								(self advance: (- y 1))
							)
							($4900 ; PAGEUP
								(self retreat: (- y 1))
							)
							(KEY_DOWN
								(self advance: 1)
							)
							(KEY_UP
								(self retreat: 1)
							)
							(else 0)
						)
				)
			)
			(evMOUSEBUTTON
				(if (self check: event)
					(event claimed: 1)
					(cond
						((< (event y:) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (StillDown)))
							)
						)
						((> (event y:) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (StillDown)))
							)
						)
						(else
							(TextSize @[temp5 0] {M} font 0 0)
							(if
								(>
									(= temp4
										(/
											(- (event y:) (+ nsTop 10))
											[temp5 2]
										)
									)
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(if (and (event claimed:) (& state $0002)) self else 0)
	)
)

(class Dialog of List
	(properties
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
	)

	(method (open wtype pri)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements:) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: wtype
			priority: pri
			open:
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp done event ret eatMice lastTick)
		(= done 0)
		(= busy 1)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc def)
				def
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatMice gEatMice)
			(= lastTick (GetTime))
		else
			(= eatMice 0)
		)
		(= ret 0)
		(while (not ret)
			(self eachElementDo: #cycle)
			(= event ((Event new:) localize:))
			(if eatMice
				(-- eatMice)
				(if (== (event type:) 1)
					(event type: 0)
				)
				(while (== lastTick (GetTime))
				)
				(= lastTick (GetTime))
			)
			(= ret (self handleEvent: event))
			(event dispose:)
			(self check:)
			(if (or (== ret -1) (not busy))
				(= ret 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(= busy 0)
		(return ret)
	)

	(method (check &tmp thisSeconds)
		(if seconds
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= lastSeconds thisSeconds)
				(= lastSeconds thisSeconds)
				(if (not (-- seconds))
					(self cue:)
				)
			)
		)
	)

	(method (cue)
		(if (not busy)
			(self dispose:)
		else
			(= busy 0)
		)
	)

	(method (dispose &tmp theCaller)
		(self eachElementDo: #dispose release:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if window
			(window dispose:)
		)
		(= theItem (= window 0))
		(= theCaller caller)
		(super dispose:)
		(if theCaller
			(theCaller cue:)
		)
	)

	(method (advance &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self next: node)))
					(= node (self first:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (retreat &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self prev: node)))
					(= node (self last:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (handleEvent event &tmp ret)
		(if (& (event type:) $0040) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(JOY_LEFT
					(event message: KEY_LEFT)
				)
				(JOY_RIGHT
					(event message: KEY_RIGHT)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(if
			(or
				(event claimed:)
				(== (event type:) evNULL)
				(and
					(!= evMOUSEBUTTON (event type:))
					(!= evKEYBOARD (event type:))
					(!= $0040 (event type:)) ; direction
					(!= evJOYDOWN (event type:))
				)
			)
			(EditControl theItem event)
			(return 0)
		)
		(if (= ret (self firstTrue: #handleEvent event))
			(EditControl theItem 0)
			(if (not (ret checkState: 2))
				(if theItem
					(theItem select: 0)
				)
				((= theItem ret) select: 1)
				(ret doit:)
				(= ret 0)
			)
		else
			(= ret 0)
			(cond
				(
					(and
						(or
							(== (event type:) evJOYDOWN)
							(and
								(== evKEYBOARD (event type:))
								(== KEY_RETURN (event message:))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= ret theItem)
					(EditControl theItem 0)
					(event claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (event type:))
									(== KEY_RETURN (event message:))
								)
								(== evMOUSEBUTTON (event type:))
								(== evJOYDOWN (event type:))
							)
						)
						(and (== evKEYBOARD (event type:)) (== KEY_ESCAPE (event message:)))
					)
					(event claimed: 1)
					(= ret -1)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_RIGHT)
					)
					(if (>= (theItem cursor:) (StrLen (theItem text:)))
						(self advance:)
					else
						(EditControl theItem event)
					)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_LEFT)
					)
					(if (<= (theItem cursor:) 0)
						(self retreat:)
					else
						(EditControl theItem event)
					)
				)
				(
					(and
						(== evKEYBOARD (event type:))
						(OneOf (event message:) KEY_TAB KEY_RIGHT KEY_DOWN)
					)
					(event claimed: 1)
					(self advance:)
				)
				(
					(and
						(== evKEYBOARD (event type:))
						(OneOf (event message:) KEY_SHIFTTAB KEY_LEFT KEY_UP)
					)
					(event claimed: 1)
					(self retreat:)
				)
				(else
					(EditControl theItem event)
				)
			)
		)
		(return ret)
	)

	(method (move h v)
		(+= nsRight h)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (center)
		(self
			moveTo:
				(+
					(window brLeft:)
					(/
						(-
							(- (window brRight:) (window brLeft:))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop:)
					(/
						(-
							(- (window brBottom:) (window brTop:))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)

	(method (setSize &tmp node obj [r 4])
		(if text
			(TextSize @[r 0] text 0 -1 0)
			(= nsTop [r 0])
			(= nsLeft [r 1])
			(= nsBottom [r 2])
			(= nsRight [r 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(= obj (NodeValue node))
			(if (< (obj nsLeft:) nsLeft)
				(= nsLeft (obj nsLeft:))
			)
			(if (< (obj nsTop:) nsTop)
				(= nsTop (obj nsTop:))
			)
			(if (> (obj nsRight:) nsRight)
				(= nsRight (obj nsRight:))
			)
			(if (> (obj nsBottom:) nsBottom)
				(= nsBottom (obj nsBottom:))
			)
		)
		(+= nsRight 4)
		(+= nsBottom 4)
		(self moveTo: 0 0)
	)
)

(class Controls of List
	(properties)

	(method (draw)
		(self eachElementDo: #setSize)
		(self eachElementDo: #draw)
	)

	(method (handleEvent event &tmp cont)
		(if (event claimed:)
			(return 0)
		)
		(if
			(and
				(= cont (self firstTrue: #handleEvent event))
				(not (cont checkState: 2))
			)
			(cont doit:)
			(= cont 0)
		)
		(return cont)
	)
)

