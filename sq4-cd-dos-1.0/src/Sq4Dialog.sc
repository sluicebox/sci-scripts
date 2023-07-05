;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 816)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)
(use System)

(public
	proc816_0 0
	proc816_1 1
	proc816_2 2
	proc816_3 3
)

(procedure (proc816_0 param1 param2 param3 &tmp [temp0 4])
	(if (proc816_1 (if (>= argc 3) param3 else {}) 38 param1 param2 &rest)
		(StrLen param1)
	)
)

(procedure (proc816_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 6] temp18 temp19 temp20 [temp21 1002] temp1023 temp1024 temp1025 temp1026 temp1027 temp1028 temp1029 temp1030 [temp1031 100])
	(= temp1026 0)
	(= temp1027 0)
	(= temp6 (= temp7 -1))
	(= temp1030
		(= temp9
			(= temp8
				(= temp18
					(= temp2
						(= temp3
							(= temp1023 (= temp1028 (= temp19 (= temp1025 0))))
						)
					)
				)
			)
		)
	)
	((= temp0 (Sq4Dialog new:)) window: gSystemWindow name: {PrintD})
	(cond
		((u< [param1 0] 1000)
			(GetFarText [param1 0] [param1 1] @temp21)
			(= temp5 2)
		)
		([param1 0]
			(StrCpy @temp21 [param1 0])
			(= temp5 1)
		)
		(else
			(= temp21 0)
			(= temp5 0)
		)
	)
	((= temp1 (DText new:)) text: @temp21 font: gUserFont)
	(= temp1024 temp1)
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
		(switch [param1 temp5]
			(27
				(++ temp5)
				(if (and temp1 (not temp1025))
					(temp1 mode: [param1 temp5])
				)
			)
			(30
				(++ temp5)
				(if temp1
					(temp1 font: [param1 temp5] setSize: temp8)
				)
			)
			(67
				(= temp1026 1)
				(= temp8 [param1 (++ temp5)])
				(temp1024 setSize: temp8)
				(if temp1025
					(temp1025
						setSize: temp8
						moveTo: (temp1024 nsLeft:) (+ 4 (temp1024 nsBottom:))
					)
				)
			)
			(22
				(++ temp5)
				(temp0 time: [param1 temp5])
			)
			(77
				(++ temp5)
				(temp0 text: [param1 temp5])
			)
			(64
				(= temp6 [param1 (++ temp5)])
				(= temp7 [param1 (++ temp5)])
			)
			(80
				(Animate (gCast elements:) 0)
			)
			(38
				(++ temp5)
				((= temp3 (DEdit new:)) text: [param1 temp5])
				(++ temp5)
				(temp3 max: [param1 temp5] setSize:)
			)
			(78
				((= [temp12 temp19] (DButton new:))
					text: [param1 (++ temp5)]
					value: [param1 (++ temp5)]
					setSize:
				)
				(+= temp18 (+ ([temp12 temp19] nsRight:) 4))
				(++ temp19)
			)
			(79
				(= temp1027 1)
				(if (IsObject [param1 (+ temp5 1)])
					(= temp2 ([param1 (+ temp5 1)] new:))
					(temp2 setSize:)
					(+= temp5 1)
				else
					(= temp2 (DIcon new:))
					(temp2
						view: [param1 (+ temp5 1)]
						loop: [param1 (+ temp5 2)]
						cel: [param1 (+ temp5 3)]
						setSize:
					)
					(+= temp5 3)
				)
			)
			(111
				(if (and (< (+ temp5 1) argc) (IsObject [param1 (+ temp5 1)]))
					(temp0 caller: [param1 (+ temp5 1)])
					(++ temp5)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= temp9 temp0)
			)
			(32
				(++ temp5)
				(temp0 window: [param1 temp5])
			)
			(124
				(= temp1030 1)
			)
		)
	)
	(if temp1030
		(= temp9 0)
	)
	(if
		(and
			(not (or temp1026 temp1027))
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
			(= temp1028 8)
		)
		(if (& (temp2 state:) $0010)
			(temp1024
				moveTo: (+ 4 temp1028) (+ (temp2 nsBottom:) (temp1024 nsTop:))
				setSize:
			)
		else
			(temp1024
				moveTo: (+ 4 (temp2 nsRight:) temp1028) (temp1024 nsTop:)
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

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 816 0 param2) ; "%d"
	)
	(return
		(if (proc816_0 @temp0 5 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (proc816_2 &tmp [temp0 500])
	(Format @temp0 &rest)
	(proc816_1 @temp0)
)

(procedure (proc816_3 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
	(= temp10 (= temp11 -1))
	(= temp3 (= temp4 (= temp5 (= temp6 0))))
	(= temp12 0)
	(= temp14 0)
	((= temp1 (Sq4Dialog new:)) window: gSystemWindow)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		(switch (= temp8 [param1 temp0])
			(109
				(= temp5 (temp2 nsBottom:)) ; UNINIT
				(= temp3 0)
			)
			(64
				(= temp10 [param1 (++ temp0)])
				(= temp11 [param1 (++ temp0)])
			)
			(77
				(= temp12 [param1 (++ temp0)])
			)
			(124
				(= temp14 [param1 (++ temp0)])
			)
			(else
				(++ temp0)
				(switch temp8
					(23
						((= temp2 (DText new:)) text: [param1 temp0])
					)
					(78
						((= temp2 (DButton new:))
							text: [param1 temp0]
							value: [param1 (++ temp0)]
						)
					)
					(79
						((= temp2 (DIcon new:))
							view: [param1 temp0]
							loop: [param1 (++ temp0)]
							cel: [param1 (++ temp0)]
						)
					)
					(38
						((= temp2 (DEdit new:))
							text: [param1 temp0]
							max: [param1 (++ temp0)]
						)
					)
					(else
						((= temp2 (DText new:)) text: [param1 (-- temp0)])
					)
				)
				(if (and (< (+ temp0 1) argc) (== [param1 (+ temp0 1)] 1))
					(++ temp0)
					(+= temp3 [param1 (++ temp0)])
				)
				(if (and (< (+ temp0 1) argc) (== [param1 (+ temp0 1)] 0))
					(++ temp0)
					(+= temp5 [param1 (++ temp0)])
				)
				(temp2 setSize: moveTo: (+ temp3 4) (+ temp5 4))
				(temp1 add: temp2)
				(= temp3 (temp2 nsRight:))
			)
		)
	)
	(temp1 setSize: center:)
	(temp1
		moveTo:
			(if (== -1 temp10)
				(temp1 nsLeft:)
			else
				temp10
			)
			(if (== -1 temp11)
				(temp1 nsTop:)
			else
				temp11
			)
	)
	(if temp12
		(temp1 text: temp12)
	)
	(= temp13 (temp1 at: temp14))
	(if (not (& $0001 (temp13 state:)))
		(= temp13 0)
	)
	(= temp7 (temp1 open: (if temp12 4 else 0) -1 doit: temp13))
	(if (IsObject temp7)
		(if (temp7 isKindOf: DButton)
			(= temp7 (temp7 value:))
		else
			(= temp7 1)
		)
	)
	(temp1 dispose:)
	(return temp7)
)

(class Sq4Dialog of List
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

	(method (open param1 param2)
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
			type: param1
			priority: param2
			open:
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(= busy 1)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= temp3 gEatMice)
			(= temp4 (GetTime))
		else
			(= temp3 0)
		)
		(= temp2 0)
		(while (not temp2)
			(self eachElementDo: #cycle)
			(= temp1 ((Event new:) localize:))
			(if temp3
				(-- temp3)
				(if (== (temp1 type:) 1)
					(temp1 type: 0)
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

	(method (check &tmp temp0)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
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

	(method (dispose &tmp temp0)
		(self eachElementDo: #dispose 1 release:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if window
			(window dispose:)
		)
		(= theItem (= window 0))
		(= temp0 caller)
		(super dispose:)
		(if temp0
			(temp0 cue:)
		)
	)

	(method (advance &tmp temp0 temp1)
		(if theItem
			(theItem select: 0)
			(= temp1 (self contains: theItem))
			(repeat
				(if (not (= temp1 (self next: temp1)))
					(= temp1 (self first:))
				)
				(= theItem (NodeValue temp1))
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

	(method (retreat &tmp temp0 temp1)
		(if theItem
			(theItem select: 0)
			(= temp1 (self contains: theItem))
			(repeat
				(if (not (= temp1 (self prev: temp1)))
					(= temp1 (self last:))
				)
				(= theItem (NodeValue temp1))
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

	(method (handleEvent event &tmp temp0)
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
		(if (= temp0 (self firstTrue: #handleEvent event))
			(EditControl theItem 0)
			(if (not (temp0 checkState: 2))
				(if theItem
					(theItem select: 0)
				)
				((= theItem temp0) select: 1)
				(temp0 doit:)
				(= temp0 0)
			)
		else
			(= temp0 0)
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
					(= temp0 theItem)
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
					(= temp0 -1)
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
		(return temp0)
	)

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
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

	(method (setSize &tmp temp0 temp1 [temp2 4])
		(if text
			(TextSize @[temp2 0] text 0 -1 0)
			(= nsTop [temp2 0])
			(= nsLeft [temp2 1])
			(= nsBottom [temp2 2])
			(= nsRight [temp2 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (NodeValue temp0))
			(if (< (temp1 nsLeft:) nsLeft)
				(= nsLeft (temp1 nsLeft:))
			)
			(if (< (temp1 nsTop:) nsTop)
				(= nsTop (temp1 nsTop:))
			)
			(if (> (temp1 nsRight:) nsRight)
				(= nsRight (temp1 nsRight:))
			)
			(if (> (temp1 nsBottom:) nsBottom)
				(= nsBottom (temp1 nsBottom:))
			)
		)
		(+= nsRight 4)
		(+= nsBottom 4)
		(self moveTo: 0 0)
	)
)

