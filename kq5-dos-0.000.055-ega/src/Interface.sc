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
	StillDown 5
	PrintDC 6
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (GetInput str maxLen prompt &tmp [temp0 4])
	(if (Print (if (>= argc 3) prompt else {test}) #edit str maxLen &rest)
		(StrLen str)
	)
)

(procedure (ShowView txt v l c)
	(Print txt 82 v l c 0 &rest)
)

(procedure (Print args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 6] temp19 temp20 temp21 [temp22 500])
	(= temp4
		(if (not (proc0_15 gTheCursor gWaitCursor 995 999)) global106 else gTheCursor)
	)
	(if (not (HaveMouse))
		(gGame setCursor: 5 1)
	)
	(= temp12 (GetPort))
	(= temp7 (= temp8 -1))
	(= temp10 (= temp9 (= temp19 (= temp2 (= temp3 (= temp20 0))))))
	((= temp0 (Dialog new:)) window: gMyWindow name: {PrintD})
	(= temp1 (DText new:))
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp22)
			(= temp6 2)
		)
		([args 0]
			(StrCpy @temp22 [args 0])
			(= temp6 1)
		)
		(else
			(= temp22 0)
			(= temp6 0)
		)
	)
	(temp1 text: @temp22 font: gUserFont setSize:)
	(temp0 add: temp1)
	(for ((= temp6 temp6)) (< temp6 argc) ((++ temp6))
		(= global107 @args)
		(switch [args temp6]
			(82
				(if (IsObject [args (+ temp6 1)])
					(= temp2 ([args (++ temp6)] new:))
					(temp2
						loop: [args (++ temp6)]
						cel: [args (++ temp6)]
						setSize:
						init:
					)
				else
					(= temp2 (DIcon new:))
					(temp2
						view: [args (++ temp6)]
						loop: [args (++ temp6)]
						cel: [args (++ temp6)]
						letter: [args (++ temp6)]
						setSize:
					)
				)
			)
			(30
				(temp1 mode: [args (++ temp6)])
			)
			(33
				(temp1 font: [args (++ temp6)] setSize: temp9)
			)
			(70
				(= temp9 [args (++ temp6)])
				(temp1 setSize: temp9)
			)
			(25
				(temp0 time: [args (++ temp6)])
			)
			(80
				(temp0 text: [args (++ temp6)])
			)
			(67
				(= temp7 [args (++ temp6)])
				(= temp8 [args (++ temp6)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				((= temp3 (DEdit new:)) text: [args (++ temp6)])
				(temp3 max: [args (++ temp6)] setSize:)
			)
			(81
				((= [temp13 temp20] (DButton new:))
					text: [args (++ temp6)]
					value: [args (++ temp6)]
					setSize:
				)
				(+= temp19 (+ ([temp13 temp20] nsRight:) 4))
				(++ temp20)
			)
			(103
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp10 temp0)
			)
			(134
				(temp0 caller: [args (++ temp6)])
			)
			(35
				(temp0 window: [args (++ temp6)])
			)
			(351
				(temp0 dontErase: 1)
			)
		)
	)
	(if temp20
		(gGame setCursor: (= global106 999) (HaveMouse))
	)
	(temp1 moveTo: ((temp0 window:) hMargin:) ((temp0 window:) vMargin:))
	(if temp2
		(temp2 moveTo: ((temp0 window:) hMargin:) ((temp0 window:) vMargin:))
		(if (temp2 letter:)
			(temp1 moveTo: (+ 4 (temp2 nsLeft:)) (- (temp2 nsBottom:) 7))
		else
			(temp1 moveTo: 4 (+ (temp2 nsBottom:) 4))
		)
		(temp0 add: temp2)
	)
	(temp0 setSize:)
	(if temp3
		(temp3 moveTo: (temp1 nsLeft:) (+ 4 (temp1 nsBottom:)))
		(temp0 add: temp3 setSize:)
	)
	(= temp21
		(if (> temp19 (temp0 nsRight:))
			4
		else
			(- (temp0 nsRight:) temp19)
		)
	)
	(for ((= temp6 0)) (< temp6 temp20) ((++ temp6))
		([temp13 temp6] moveTo: temp21 (+ 4 (temp0 nsBottom:)))
		(temp0 add: [temp13 temp6])
		(= temp21 (+ 4 ([temp13 temp6] nsRight:)))
	)
	(temp0 setSize:)
	(temp0
		nsRight: (+ ((temp0 window:) hMargin:) (temp0 nsRight:))
		nsBottom: (+ ((temp0 window:) vMargin:) (temp0 nsBottom:))
		center:
	)
	(if (or (and temp2 (not (temp2 letter:))) (and temp2 (not (StrLen @temp22))))
		(temp2
			moveTo:
				(/
					(-
						(- (temp0 nsRight:) (temp0 nsLeft:))
						(- (temp2 nsRight:) (temp2 nsLeft:))
					)
					2
				)
				((temp0 window:) vMargin:)
		)
	)
	(temp0
		moveTo:
			(if (== -1 temp7)
				(temp0 nsLeft:)
			else
				temp7
			)
			(if (== -1 temp8)
				(temp0 nsTop:)
			else
				temp8
			)
	)
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp10 15 else -1))
	(if temp10
		(= global78 (GetPort))
		(SetPort temp12)
		(return (= gModelessDialog temp10))
	)
	(if
		(and
			(= temp11 (temp0 firstTrue: #checkState 1))
			(not (temp0 firstTrue: #checkState 2))
		)
		(temp11 state: (| (temp11 state:) $0002))
	)
	(if (== (= temp5 (temp0 doit: temp11)) -1)
		(= temp5 0)
	)
	(for ((= temp6 0)) (< temp6 temp20) ((++ temp6))
		(if (== temp5 [temp13 temp6])
			(= temp5 (temp5 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp5 1)
	)
	(temp0 dispose:)
	(if (not (proc0_15 gTheCursor gWaitCursor 995 999))
		(= global106 temp4)
		(proc0_26 (| (HaveMouse) (!= global70 (gUIcons at: 0))))
	else
		(gGame setCursor: temp4 (HaveMouse))
	)
	(return temp5)
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

(procedure (PrintDC param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 200] [temp204 200])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp4)
	else
		(StrCpy @temp4 param1)
	)
	(= temp0 (StrAt @temp4 0))
	(= temp1 (StrAt @temp4 1))
	(if (and (>= temp0 65) (<= temp0 90))
		(StrAt @temp4 0 32)
		(if (== temp1 32)
			(Format @temp204 {___})
		else
			(Format @temp204 {__})
		)
		(StrCat @temp204 @temp4)
		(= temp2 (+ 0 (/ (- temp0 65) 13)))
		(= temp3 (mod (- temp0 65) 13))
		(Print @temp204 &rest 82 945 temp2 temp3 1)
	else
		(Print @temp4 &rest)
	)
)

(class DItem of Obj
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

	(method (isType theType)
		(return (== type theType))
	)

	(method (checkState bit)
		(return (& state bit))
	)

	(method (doit)
		(return value)
	)

	(method (setSize))

	(method (move h v)
		(+= nsRight h)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (draw)
		(DrawControl self)
	)

	(method (cycle))
)

(class DText of DItem
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

(class DIcon of DItem
	(properties
		type 4
		view 0
		loop 0
		cel 0
		priority -1
		letter 0
	)

	(method (setSize &tmp [r 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of DItem
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

(class DEdit of DItem
	(properties
		type 3
		state 1
		text 0
		font 4
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} 1)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of DItem
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
		(= nsRight (+ nsLeft (/ (* [r 3] x 4) 4)))
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
			(if (StrAt text 0)
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
				(5
					(event message: KEY_DOWN)
				)
				(1
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
		timer 0
		busy 0
		caller 0
		dontErase 0
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
			open: self
		)
		(if time
			(Timer setReal: self time)
		)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp done event ret eatMice lastTick)
		(= done 0)
		(= busy 1)
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
			(= eatMice 5)
			(= lastTick (GetTime))
		else
			(= eatMice 0)
		)
		(= ret 0)
		(while (not ret)
			(self eachElementDo: #cycle)
			((= event (Event new:)) localize:)
			(if eatMice
				(-- eatMice)
				(if (== (event type:) evMOUSEBUTTON)
					(event type: evNULL)
				)
				(while (== lastTick (GetTime))
				)
				(= lastTick (GetTime))
			)
			(= ret (self handleEvent: event))
			(event dispose:)
			(if timer
				(timer doit:)
			)
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

	(method (cue)
		(if (not busy)
			(self dispose:)
		else
			(= busy 0)
		)
	)

	(method (dispose &tmp theCaller)
		(if (== self gModelessDialog)
			(SetPort global78)
			(= gModelessDialog 0)
			(= global78 0)
		)
		(if window
			(window dispose:)
			(= window 0)
		)
		(if timer
			(timer dispose: delete:)
		)
		(= theItem 0)
		(= theCaller caller)
		(super dispose:)
		(if theCaller
			(caller cue:)
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
			(cond
				((ret isType: 3)
					(if theItem
						(theItem select: 0)
					)
					((= theItem ret) select: 1)
					(= ret 0)
				)
				((not (ret checkState: 2))
					(ret doit:)
					(self advance:)
					(= ret 0)
				)
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
		(+= nsRight 1)
		(+= nsBottom 1)
		(self moveTo: 0 0)
	)
)

(class Controls of List
	(properties
		window -1
	)

	(method (init)
		(= window (GetPort))
	)

	(method (add)
		(if (== window -1)
			(self init:)
		)
		(super add: &rest)
	)

	(method (draw &tmp temp0)
		(= temp0 (GetPort))
		(SetPort window)
		(self eachElementDo: #setSize)
		(self eachElementDo: #draw)
		(SetPort temp0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 0)
		(if (not (event claimed:))
			(= temp1 (GetPort))
			(SetPort window)
			(event localize:)
			(if
				(and
					(= temp0 (self firstTrue: #handleEvent event))
					(not (temp0 checkState: 2))
				)
				(temp0 doit:)
				(= temp0 0)
			)
			(SetPort temp1)
		)
		(return temp0)
	)
)

