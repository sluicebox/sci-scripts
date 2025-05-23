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

(procedure (MousedOn obj event theMods)
	(cond
		((!= (event type:) 1) 0)
		((and (>= argc 3) theMods (== (& (event modifiers:) theMods) 0)) 0)
		((obj respondsTo: #nsLeft)
			(InRect
				(obj nsLeft:)
				(obj nsTop:)
				(obj nsRight:)
				(obj nsBottom:)
				event
			)
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

(procedure (Print args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 6] temp18 temp19 temp20 temp21 [temp22 1000])
	(= temp11 (GetPort))
	(= temp6 (= temp7 -1))
	(= temp9 (= temp8 (= temp18 (= temp19 (= temp2 (= temp3 (= temp20 0)))))))
	((= temp0 (Dialog new:)) window: gHSW name: {PrintD})
	(= temp1 (DText new:))
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp22)
			(= temp5 2)
		)
		([args 0]
			(StrCpy @temp22 [args 0])
			(= temp5 1)
		)
		(else
			(= temp22 0)
			(= temp5 0)
		)
	)
	(temp1 text: @temp22 moveTo: 4 4 font: gUserFont setSize:)
	(temp0 add: temp1)
	(for ((= temp5 temp5)) (< temp5 argc) ((++ temp5))
		(switch [args temp5]
			(30
				(++ temp5)
				(temp1 mode: [args temp5])
			)
			(33
				(++ temp5)
				(temp1 font: [args temp5] setSize: temp8)
			)
			(70
				(= temp8 [args (++ temp5)])
				(temp1 setSize: temp8)
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
				((= [temp12 temp20] (DButton new:))
					text: [args (++ temp5)]
					value: [args (++ temp5)]
					setSize:
				)
				(+= temp18 (+ ([temp12 temp20] nsRight:) 4))
				(++ temp20)
			)
			(150
				((= [temp12 temp20] (DButton new:))
					text: [args (++ temp5)]
					value: [args (++ temp5)]
					setSize:
				)
				(+= temp19 (+ ([temp12 temp20] nsBottom:) 4))
				(++ temp20)
			)
			(82
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
			(88
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp9 temp0)
			)
			(35
				(++ temp5)
				(temp0 window: [args temp5])
			)
		)
	)
	(if temp2
		(temp2 moveTo: 4 4)
		(temp1 moveTo: (+ 4 (temp2 nsRight:)) (temp1 nsTop:))
		(temp0 add: temp2)
	)
	(temp0 setSize:)
	(if temp3
		(temp3 moveTo: (temp1 nsLeft:) (+ 4 (temp1 nsBottom:)))
		(temp0 add: temp3 setSize:)
	)
	(cond
		(temp18
			(= temp21
				(if (> temp18 (temp0 nsRight:))
					4
				else
					(- (temp0 nsRight:) temp18)
				)
			)
			(for ((= temp5 0)) (< temp5 temp20) ((++ temp5))
				([temp12 temp5] moveTo: temp21 (temp0 nsBottom:))
				(temp0 add: [temp12 temp5])
				(= temp21 (+ 4 ([temp12 temp5] nsRight:)))
			)
		)
		(temp19
			(= temp21 (+ (temp0 nsTop:) 4))
			(for ((= temp5 0)) (< temp5 temp20) ((++ temp5))
				([temp12 temp5] moveTo: (temp0 nsRight:) temp21)
				(temp0 add: [temp12 temp5])
				(= temp21 (+ 4 ([temp12 temp5] nsBottom:)))
			)
		)
	)
	(temp0 setSize: center:)
	(if (and temp2 (not (StrLen @temp22)))
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
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp9 15 else -1))
	(if temp9
		(= global62 (GetPort))
		(SetPort temp11)
		(return (= gModelessDialog temp9))
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
	(for ((= temp5 0)) (< temp5 temp20) ((++ temp5))
		(if (== temp4 [temp12 temp5])
			(= temp4 (temp4 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp4 1)
	)
	(temp0 dispose:)
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
		(= state 0)
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
				(GlobalToLocal event)
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
		(TextSize @[r 0] text font (if argc w else 0))
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
		(TextSize @[r 0] text font)
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
		(TextSize @[r 0] {M} font)
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
		lsTop 0
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
		(TextSize @[r 0] {M} font)
		(= nsBottom (+ nsTop 20 (* [r 2] y)))
		(= nsRight (+ nsLeft (/ (* [r 3] x 3) 4)))
		(= lsTop (= cursor text))
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
					(-= lsTop x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(if redraw
			(self draw:)
		)
	)

	(method (advance lines &tmp redraw)
		(= redraw 0)
		(while lines
			(if (StrAt cursor x)
				(= redraw 1)
				(+= cursor x)
				(if (< (+ mark 1) y)
					(++ mark)
				else
					(+= lsTop x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(if redraw
			(self draw:)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (event claimed:)
			(return 0)
		)
		(if (== $0040 (event type:)) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(= temp0 0)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
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
					(else
						(event claimed: 0)
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
							(TextSize @[temp5 0] {M} font)
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
		seconds 0
		lastSeconds 0
	)

	(method (open wtype pri)
		(if (and (PicNotValid) gCast)
			(RedrawCast)
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

	(method (doit def &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
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
			(= temp3 60)
			(= temp4 (GetTime))
		else
			(= temp3 0)
		)
		(= temp2 0)
		(while (not temp2)
			(self eachElementDo: #cycle)
			(GlobalToLocal (= temp1 (Event new:)))
			(if temp3
				(-- temp3)
				(if (== (temp1 type:) evMOUSEBUTTON)
					(temp1 type: evNULL)
				)
				(while (== temp4 (GetTime))
				)
				(= temp4 (GetTime))
			)
			(= temp2 (self handleEvent: temp1))
			(temp1 dispose:)
			(self check:)
			(if (or (== temp2 -1) (not busy))
				(= temp2 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(= busy 0)
		(return temp2)
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

	(method (dispose)
		(if (== self gModelessDialog)
			(SetPort global62)
			(= gModelessDialog 0)
			(= global62 0)
		)
		(if window
			(window dispose:)
		)
		(= theItem (= window 0))
		(super dispose:)
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
		)
	)

	(method (handleEvent event &tmp ret)
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
				((and (== evKEYBOARD (event type:)) (== KEY_TAB (event message:)))
					(event claimed: 1)
					(self advance:)
				)
				((and (== evKEYBOARD (event type:)) (== KEY_SHIFTTAB (event message:)))
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
			(TextSize @[r 0] text 0 -1)
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

