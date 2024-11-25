;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use System)

(public
	Print 0
	Printf 4
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 (Event new:))
	(= temp1 (!= (temp0 type:) evMOUSERELEASE))
	(temp0 dispose:)
	(return temp1)
)

(procedure (Print args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 8] temp23 temp24 temp25 temp26 [temp27 800])
	(= temp9 (= temp10 -1))
	(= temp12 (= temp11 (= temp23 (= temp24 (= temp2 (= temp3 (= temp25 0)))))))
	((= temp0 (Dialog new:)) window: gSysWindow name: {PrintD})
	(= temp1 (DText new:))
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @temp27)
			(= temp8 2)
		)
		([args 0]
			(StrCpy @temp27 [args 0])
			(= temp8 1)
		)
		(else
			(= temp27 0)
			(= temp8 0)
		)
	)
	(temp1 text: @temp27 moveTo: 4 4 font: gUserFont setSize:)
	(temp0 add: temp1)
	(for ((= temp8 temp8)) (< temp8 argc) ((++ temp8))
		(switch [args temp8]
			(30
				(++ temp8)
				(temp1 mode: [args temp8])
			)
			(33
				(++ temp8)
				(temp1 font: [args temp8] setSize: temp11)
			)
			(70
				(= temp11 [args (++ temp8)])
				(temp1 setSize: temp11)
			)
			(25
				(++ temp8)
				(temp0 time: [args temp8])
			)
			(80
				(++ temp8)
				(temp0 text: [args temp8])
			)
			(67
				(= temp9 [args (++ temp8)])
				(= temp10 [args (++ temp8)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(++ temp8)
				((= temp3 (DEdit new:)) text: [args temp8])
				(++ temp8)
				(temp3 max: [args temp8] setSize:)
			)
			(81
				((= [temp15 temp25] (DButton new:))
					text: [args (++ temp8)]
					value: [args (++ temp8)]
					setSize:
				)
				(+= temp23 (+ ([temp15 temp25] nsRight:) 4))
				(++ temp25)
			)
			(82
				(if (IsObject [args (+ temp8 1)])
					(= temp2 ([args (+ temp8 1)] new:))
					(temp2 setSize:)
					(+= temp8 1)
				else
					(= temp2 (DIcon new:))
					(temp2
						view: [args (+ temp8 1)]
						loop: [args (+ temp8 2)]
						cel: [args (+ temp8 3)]
						setSize:
					)
					(+= temp8 3)
				)
			)
			(88
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp12 temp0)
			)
			(35
				(++ temp8)
				(temp0 window: [args temp8])
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
		(temp23
			(= temp26
				(if (> temp23 (temp0 nsRight:))
					4
				else
					(- (temp0 nsRight:) temp23)
				)
			)
			(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
				([temp15 temp8] moveTo: temp26 (temp0 nsBottom:))
				(temp0 add: [temp15 temp8])
				(= temp26 (+ 4 ([temp15 temp8] nsRight:)))
			)
		)
		(temp24
			(= temp26 (+ (temp0 nsTop:) 4))
			(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
				([temp15 temp8] moveTo: (temp0 nsRight:) temp26)
				(temp0 add: [temp15 temp8])
				(= temp26 (+ 4 ([temp15 temp8] nsBottom:)))
			)
		)
	)
	(temp0 setSize: center:)
	(if (and temp2 (not (StrLen @temp27)))
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
	(= temp5 (if (== temp10 -1) 0 else temp10))
	(= temp6 (- (temp0 nsBottom:) (temp0 nsTop:)))
	(if (> (+ temp5 temp6) 180)
		(-= temp5 (- (+ temp5 temp6) 180))
	)
	(if (< (+ temp5 (temp0 nsTop:)) 10)
		(+= temp5 (- (temp0 nsTop:) 10))
	)
	(temp0
		moveTo:
			(if (== -1 temp9)
				(temp0 nsLeft:)
			else
				temp9
			)
			(if temp5
				temp5
			else
				(temp0 nsTop:)
			)
	)
	(= temp14 (GetPort))
	(temp0 open: (if (temp0 text:) 4 else 0) (if temp12 15 else -1))
	(if temp12
		(= local0 (GetPort))
		(SetPort temp14)
		(return (= gModelessDialog temp12))
	)
	(if
		(and
			(= temp13 (temp0 firstTrue: #checkState 1))
			(not (temp0 firstTrue: #checkState 2))
		)
		(temp13 state: (| (temp13 state:) $0002))
	)
	(if (== (= temp7 (temp0 doit: temp13)) -1)
		(= temp7 0)
	)
	(for ((= temp8 0)) (< temp8 temp25) ((++ temp8))
		(if (== temp7 [temp15 temp8])
			(= temp7 (temp7 value:))
			(break)
		)
	)
	(if (not (temp0 theItem:))
		(= temp7 1)
	)
	(temp0 dispose:)
	(return temp7)
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
			(= retVal (MenuSelect event &rest))
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
				(breakif (not (localproc_0)))
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
		(return 0)
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
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
			(= eatMice 60)
			(= lastTick (GetTime))
		else
			(= eatMice 0)
		)
		(= ret 0)
		(while (not ret)
			(self eachElementDo: #cycle)
			(GlobalToLocal (= event (Event new:)))
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

	(method (dispose)
		(if (== self gModelessDialog)
			(SetPort local0)
			(= gModelessDialog 0)
			(= local0 0)
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

	(method (handleEvent event &tmp ret eType eMsg)
		(= eType (event type:))
		(= eMsg (event message:))
		(if
			(or
				(event claimed:)
				(== eType evNULL)
				(and (!= evMOUSEBUTTON eType) (!= evKEYBOARD eType) (!= $0040 eType) (!= evJOYDOWN eType)) ; direction
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
						(or (== eType evJOYDOWN) (and (== evKEYBOARD eType) (== KEY_RETURN eMsg)))
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
								(and (== evKEYBOARD eType) (== KEY_RETURN eMsg))
								(== evMOUSEBUTTON eType)
								(== evJOYDOWN eType)
							)
						)
						(and (== evKEYBOARD eType) (== KEY_ESCAPE eMsg))
					)
					(event claimed: 1)
					(= ret -1)
				)
				((and (== evKEYBOARD eType) (== KEY_TAB eMsg))
					(event claimed: 1)
					(self advance:)
				)
				((and (== evKEYBOARD eType) (== KEY_SHIFTTAB eMsg))
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

