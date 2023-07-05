;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Print)
(use LoadMany)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	showEcorder 0
)

(local
	local0
	local1
	[local2 50]
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61 = 1
	local62
	local63
	local64
)

(procedure (localproc_0 param1)
	(sPtr y: (+ (sPtr y:) 11))
	(if (IsObject param1)
		(param1 cue:)
	)
)

(procedure (localproc_1 param1)
	(sPtr y: (- (sPtr y:) 11))
	(if (IsObject param1)
		(param1 cue:)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 param6)
	(Message msgGET 50 13 0 param5 param6 @local2)
	(Display @local2 dsFONT 9777 dsCOORD param1 param2 dsCOLOR param3 dsWIDTH param4)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(= temp1 30)
	(for ((= temp0 1)) (< temp0 5) ((++ temp0))
		(localproc_2 115 temp1 8 100 3 temp0)
		(+= temp1 11)
	)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= temp1 30)
	(for ((= temp0 1)) (< temp0 6) ((++ temp0))
		(localproc_2 115 temp1 8 100 4 temp0)
		(+= temp1 11)
	)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 1)
	(= temp5 1)
	(= temp4 30)
	(+= temp2 44)
	(for ((= temp3 1)) (< temp3 7) ((++ temp3))
		(if (not (IsEcorderFlag temp2))
			(switch temp3
				(1
					(= local52 1)
				)
				(2
					(= local53 1)
				)
				(3
					(= local54 1)
				)
				(4
					(= local55 1)
				)
				(5
					(= local56 1)
				)
				(6
					(= local57 1)
				)
			)
			(= temp1 22)
		else
			(switch temp3
				(1
					(= local52 0)
				)
				(2
					(= local53 0)
				)
				(3
					(= local54 0)
				)
				(4
					(= local55 0)
				)
				(5
					(= local56 0)
				)
				(6
					(= local57 0)
				)
			)
			(= temp1 8)
		)
		(= local58 6)
		(localproc_2 115 temp4 temp1 100 6 temp5)
		(++ temp5)
		(++ temp2)
		(+= temp4 11)
	)
)

(procedure (localproc_6 param1 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort -1)
	(= local0 (Graph grSAVE_BOX 0 0 30 320 1))
	(DrawCel 990 0 0 0 0 1)
	(DrawCel 990 1 0 40 0 1)
	(DrawCel 990 2 0 70 0 1)
	(DrawCel 990 3 0 100 0 1)
	(DrawCel 990 4 0 130 0 1)
	(DrawCel 990 5 0 160 0 1)
	(DrawCel 990 6 0 190 0 1)
	(DrawCel 990 7 0 220 0 1)
	(DrawCel 990 8 0 250 0 1)
	(DrawCel 990 9 0 280 0 1)
	(Animate (gCast elements:) 0)
	(DrawCel 990 10 1 130 0 1)
	(DrawCel 990 10 0 160 0 1)
	(SetPort temp0)
	(if (IsObject param1)
		(param1 cue:)
	)
)

(procedure (localproc_7 param1 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort -1)
	(Graph grRESTORE_BOX local0)
	(Graph grUPDATE_BOX 0 0 30 320 1)
	(Animate (gCast elements:) 0)
	(SetPort temp0)
	(if (IsObject param1)
		(param1 cue:)
	)
)

(procedure (localproc_8 param1 param2 param3 param4 param5 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort -1)
	(DrawCel 990 param1 param2 param3 param4 1)
	(Animate (gCast elements:) 0)
	(SetPort temp0)
	(if (IsObject param5)
		(param5 cue:)
	)
)

(procedure (localproc_9 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21)
	(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
	(for ((= temp8 (Inv first:))) temp8 ((= temp8 (Inv next: temp8)))
		(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
			(if (temp9 ownedBy: param1)
				(temp9 signal: (& (temp9 signal:) $fffb))
				(++ temp0)
				(if
					(>
						(= temp6
							(CelWide (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp2
					)
					(= temp2 temp6)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp1
					)
					(= temp1 temp7)
				)
			else
				(temp9 signal: (| (temp9 signal:) $0004))
			)
		else
			(++ temp3)
			(+= temp5 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
			(if
				(>
					(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
					temp4
				)
				(= temp4 temp7)
			)
		)
	)
	(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
		(-- temp16)
	)
	(if (> temp16 3)
		(= temp16 3)
	)
	(= local1 (/ temp0 temp16))
	(if (< (* temp16 local1) temp0)
		(++ local1)
	)
	(= temp10 (Max (+ 4 temp5) (* local1 (+ 4 temp2))))
	(= temp11 (* temp16 (+ 4 temp1)))
	(= temp12 (/ (- 190 temp11) 2))
	(= temp13 (/ (- 320 temp10) 2))
	(= temp14 (+ temp12 temp11))
	(= temp15 (+ temp13 temp10))
	(if (= temp21 (Inv window:))
		(temp21
			top: temp12
			left: temp13
			right: temp15
			bottom: temp14
			priority: -1
			open:
		)
	)
	(= temp20 local1)
	(if temp0
		(= temp18
			(+
				2
				(if (temp21 respondsTo: #yOffset)
					(temp21 yOffset:)
				)
			)
		)
		(= temp19
			(= temp17
				(+
					4
					(if (temp21 respondsTo: #xOffset)
						(temp21 xOffset:)
					)
				)
			)
		)
		(for ((= temp8 (Inv first:))) temp8 ((= temp8 (Inv next: temp8)))
			(if
				(and
					(not (& ((= temp9 (NodeValue temp8)) signal:) $0004))
					(temp9 isKindOf: InvI)
				)
				(if (not (& (temp9 signal:) $0080))
					(temp9
						nsLeft:
							(+
								temp17
								(/
									(-
										temp2
										(= temp6
											(CelWide
												(temp9 view:)
												(temp9 loop:)
												(temp9 cel:)
											)
										)
									)
									2
								)
							)
						nsTop:
							(+
								temp18
								(/
									(-
										temp1
										(= temp7
											(CelHigh
												(temp9 view:)
												(temp9 loop:)
												(temp9 cel:)
											)
										)
									)
									2
								)
							)
					)
					(temp9
						nsRight: (+ (temp9 nsLeft:) temp6)
						nsBottom: (+ (temp9 nsTop:) temp7)
					)
					(if (-- temp20)
						(+= temp17 temp2)
					else
						(= temp20 local1)
						(+= temp18 temp1)
						(= temp17 temp19)
					)
				else
					(= temp17 (temp9 nsLeft:))
					(= temp18 (temp9 nsTop:))
				)
				(temp9 show:)
				(if (== temp9 param2)
					(temp9 highlight:)
				)
			)
		)
	)
	(= temp17 (/ (- (- (temp21 right:) (temp21 left:)) temp5) 2))
	(= temp11 (- (temp21 bottom:) (temp21 top:)))
	(= temp18 32767)
	(for ((= temp8 (Inv first:))) temp8 ((= temp8 (Inv next: temp8)))
		(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
			(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
			(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
			(if (not (& (temp9 signal:) $0080))
				(if (== temp18 32767)
					(= temp18 (- temp11 temp7))
				)
				(temp9
					nsLeft: temp17
					nsTop: temp18
					nsBottom: temp11
					nsRight: (+ temp17 temp6)
				)
			)
			(= temp17 (+ (temp9 nsLeft:) temp6))
			(= temp18 (temp9 nsTop:))
			(temp9 signal: (& (temp9 signal:) $fffb) show:)
		)
	)
	(Animate (gCast elements:) 0)
	(if (IsObject param3)
		(param3 cue:)
	)
)

(procedure (localproc_10 param1)
	(if (Inv window:)
		((Inv window:) dispose:)
	)
	(Animate (gCast elements:) 0)
	(if (IsObject param1)
		(param1 cue:)
	)
)

(procedure (localproc_11 param1)
	(gCast eachElementDo: #hide)
	(DrawPic 50 100)
	(Animate (gCast elements:) 0)
	(DrawCel 9 1 2 115 29 1)
	(DrawCel 9 2 0 84 43 1)
	(DrawCel 9 2 2 84 68 1)
	(DrawCel 9 2 4 84 93 1)
	(DrawCel 9 0 0 180 101 1)
	(Animate (gCast elements:) 0)
	(if (IsObject param1)
		(param1 cue:)
	)
)

(instance showEcorder of Script
	(properties)

	(method (init)
		(if (not local62)
			(= local62 1)
			(LoadMany rsVIEW 990)
		)
		(gEgo get: 2) ; E-corder
		(User canInput: 0)
		(User canControl: 0)
		(gTheIconBar disable:)
		(= local63 gCast)
		(SetFlag 7)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0 [temp1 30] [temp31 30])
		(switch (= state newState)
			(0
				(= gCast (= local64 (myList new:)))
				(gMessager say: 19 2 48 1 self) ; "You can use the Ecorder to scan the environment. After you record something, you can take a look at the data."
			)
			(1
				(sPtr init:)
				(stk
					x: gMouseX
					y: gMouseY
					setLoop: (gTheCursor loop:)
					cel: (gTheCursor cel:)
					init:
				)
				(gTheCursor view: 960 loop: 10 cel: 14 init:)
				(= cycles 5)
			)
			(2
				(stk setLoop: 10 cel: 2)
				(= cycles 3)
			)
			(3
				(gMessager say: 19 2 48 2 self) ; "First, go to the inventory and choose the Ecorder."
			)
			(4
				(stk setMotion: MoveTo 180 10 self)
			)
			(5
				(stk setLoop: 10 cel: 5)
				(localproc_6 self)
			)
			(6
				(= ticks 60)
			)
			(7
				(stk setMotion: MoveTo 214 10 self)
			)
			(8
				(localproc_8 6 1 190 0)
				(= ticks 30)
			)
			(9
				(localproc_8 6 0 190 0 self)
			)
			(10
				(localproc_7 self)
			)
			(11
				(localproc_9 gEgo (gTheIconBar curIcon:) self)
			)
			(12
				(if (gEgo has: 0) ; buckazoid
					(= temp0 157)
				else
					(= temp0 124)
				)
				(stk setMotion: MoveTo temp0 95 self)
			)
			(13
				(= ticks 20)
			)
			(14
				(stk view: 960 setLoop: 10 cel: 4)
				(= ticks 20)
			)
			(15
				(stk setMotion: MoveTo 221 65 self)
			)
			(16
				(DrawCel 991 4 1 137 1 15)
				(= ticks 30)
			)
			(17
				(localproc_10 self)
			)
			(18
				(gMessager say: 19 2 48 3 self) ; "Move the Ecorder around until it lights up. It may light up in several places."
			)
			(19
				(stk setMotion: MoveTo 276 152 self)
			)
			(20
				(stk setLoop: 8 cel: 10 setMotion: MoveTo 280 160 self)
			)
			(21
				(gMessager say: 19 2 48 4 self) ; "When the Ecorder lights up, it has found something. Click the Ecorder to record."
			)
			(22
				(SetEcorderFlag 45)
				(gGame points: 1)
				(Message msgGET 100 29 0 47 1 @temp1) ; "ECORDING: Town Runoff"
				(gSystemWindow color: 8 back: 23)
				(Print addText: @temp1 init:)
				(gSystemWindow color: 57 back: 68)
				(= cycles 2)
			)
			(23
				(gMessager say: 19 2 48 5 self) ; "It recorded something about the water! To look at your data, use the inventory hand icon on the Ecorder."
			)
			(24
				(stk setMotion: MoveTo 276 152 self)
			)
			(25
				(stk setLoop: 10 cel: 4 setMotion: MoveTo 180 10 self)
			)
			(26
				(stk setLoop: 10 cel: 5)
				(localproc_6 self)
			)
			(27
				(= ticks 40)
			)
			(28
				(stk setMotion: MoveTo 214 10 self)
			)
			(29
				(localproc_8 6 1 190 0)
				(= ticks 30)
			)
			(30
				(localproc_8 6 0 190 0 self)
			)
			(31
				(localproc_7 self)
			)
			(32
				(localproc_9 gEgo (gTheIconBar curIcon:) self)
			)
			(33
				(stk setMotion: MoveTo 132 65 self)
			)
			(34
				(DrawCel 991 1 1 47 1 1)
				(= ticks 30)
			)
			(35
				(DrawCel 991 1 0 47 1 1)
				(stk setLoop: 10 cel: 2)
				(= ticks 50)
			)
			(36
				(if (gEgo has: 0) ; buckazoid
					(= temp0 157)
				else
					(= temp0 124)
				)
				(stk setMotion: MoveTo temp0 95 self)
			)
			(37
				(= ticks 20)
			)
			(38
				(localproc_10 self)
			)
			(39
				(localproc_11 self)
			)
			(40
				(gMessager say: 19 2 48 6 self) ; "To turn the power on, click the large, round button."
			)
			(41
				(stk x: 188 y: 145 cel: 15 show:)
				(= ticks 20)
			)
			(42
				(stk setMotion: MoveTo 117 147 self)
			)
			(43
				(DrawCel 9 8 1 105 136 1)
				(= ticks 30)
			)
			(44
				(stk setLoop: 10 cel: 6)
				(DrawCel 9 1 0 115 29 1)
				(= ticks 90)
			)
			(45
				(Message msgGET 50 13 0 16 1 @global137) ; "Adam"
				(inDx init: setCycle: End)
				(Message msgGET 50 13 0 1 1 @temp1) ; "Welcome to the  Rainforest, %s!"
				(Format @temp31 @temp1 @global137)
				(Display @temp31 dsCOORD 125 50 dsCOLOR 8 dsFONT 9777 dsWIDTH 100)
				(= seconds 3)
			)
			(46
				(Display @temp31 dsCOORD 125 50 dsCOLOR 23 dsFONT 9777 dsWIDTH 100)
				(= ticks 30)
			)
			(47
				(stk setLoop: 10 cel: 15)
				(localproc_3)
				(sPtr show:)
				(= ticks 90)
			)
			(48
				(gMessager say: 19 2 48 7 self) ; "Use the dial to move the pointer up and down to select the item you want to see."
			)
			(49
				(stk setMotion: MoveTo 117 156 self)
			)
			(50
				(= local59 2)
				(self setScript: sDown self)
			)
			(51
				(stk setMotion: MoveTo 117 132 self)
			)
			(52
				(= local60 2)
				(self setScript: sUp self)
			)
			(53
				(stk setMotion: MoveTo 201 111 self)
			)
			(54
				(gMessager say: 19 2 48 8 self) ; "All the recordings are listed under "Rainforest Facts." That is your database."
			)
			(55
				(DrawCel 9 0 1 180 101 1)
				(= ticks 5)
			)
			(56
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 0 0 180 101 1)
				(localproc_4)
				(= ticks 60)
			)
			(57
				(stk setMotion: MoveTo 117 156 self)
			)
			(58
				(= local59 1)
				(self setScript: sDown self)
			)
			(59
				(stk setMotion: MoveTo 201 111 self)
			)
			(60
				(DrawCel 9 0 1 180 101 1)
				(= ticks 5)
			)
			(61
				(gMessager say: 19 2 48 9 self) ; "The category is "Eco-Threats," so select it next."
			)
			(62
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 0 0 180 101 1)
				(= ticks 5)
			)
			(63
				(localproc_5)
				(= ticks 30)
			)
			(64
				(stk setMotion: MoveTo 117 132 self)
			)
			(65
				(= local60 1)
				(self setScript: sUp self)
			)
			(66
				(stk setMotion: MoveTo 201 111 self)
			)
			(67
				(gMessager say: 19 2 48 10 self) ; "You can look at the list anytime. When you record an item, it highlights. Select "Town Runoff"!"
			)
			(68
				(DrawCel 9 0 1 180 101 1)
				(= ticks 5)
			)
			(69
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 0 0 180 101 1)
				(self setScript: displayText self)
			)
			(70
				(= ticks 90)
			)
			(71
				(gMessager say: 19 2 48 11 self) ; "Press the ESC button to go back."
			)
			(72
				(stk setMotion: MoveTo 100 59 self)
			)
			(73
				(DrawCel 9 2 1 84 43 1)
				(= ticks 20)
			)
			(74
				(pictureSquare hide:)
				(= cycles 3)
			)
			(75
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 2 0 84 43 1)
				(= ticks 10)
			)
			(76
				(localproc_5)
				(sPtr show:)
				(= ticks 30)
			)
			(77
				(DrawCel 9 2 1 84 43 1)
				(= ticks 20)
			)
			(78
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 2 0 84 43 1)
				(= ticks 10)
			)
			(79
				(localproc_4)
				(= ticks 20)
			)
			(80
				(DrawCel 9 2 1 84 43 1)
				(= ticks 20)
			)
			(81
				(DrawCel 9 1 0 115 29 2)
				(DrawCel 9 2 0 84 43 1)
				(= ticks 10)
			)
			(82
				(localproc_3)
				(= ticks 20)
			)
			(83
				(stk setMotion: MoveTo 74 70 self)
			)
			(84
				(stk setLoop: 11 cel: 0 setMotion: MoveTo 40 100 self)
			)
			(85
				(gMessager say: 19 2 48 12 self) ; "Move the hand cursor out of the Ecorder and click the exit cursor to exit the Ecorder."
			)
			(86
				(pictureSquare dispose:)
				(stk dispose:)
				(sPtr dispose:)
				(inDx dispose:)
				(= gCast local63)
				(Animate (gCast elements:) 0)
				(= cycles 3)
			)
			(87
				(DrawPic gCurRoomNum 100)
				(gCast eachElementDo: #show)
				(Animate (gCast elements:) 1)
				(gTheCursor view: 960 loop: 10 cel: 6 init:)
				(= cycles 6)
			)
			(88
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(local64 dispose:)
		(ClearFlag 7)
		(super dispose:)
		(gTheIconBar enable:)
		(gGame handsOn:)
		(DisposeScript 333)
	)
)

(instance sDown of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawCel 9 6 1 101 150 1)
				(= ticks 30)
			)
			(1
				(localproc_0 self)
			)
			(2
				(DrawCel 9 6 0 101 150 1)
				(= ticks 30)
			)
			(3
				(if (== register local59)
					(self cue:)
				else
					(++ register)
					(self changeState: 0)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sUp of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawCel 9 4 1 100 125 1)
				(= ticks 30)
			)
			(1
				(localproc_1 self)
			)
			(2
				(DrawCel 9 4 0 100 125 1)
				(= ticks 30)
			)
			(3
				(if (== register local60)
					(self cue:)
				else
					(++ register)
					(self changeState: 0)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance displayText of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(sPtr hide:)
				(DrawCel 9 1 0 115 29 2)
				(= ticks 5)
			)
			(1
				(= temp1 local61)
				(cond
					((<= local61 9)
						(= temp0 0)
					)
					((<= local61 19)
						(-= temp1 10)
						(= temp0 1)
					)
					(else
						(-= temp1 20)
						(= temp0 2)
					)
				)
				(pictureSquare
					setLoop: temp0
					setCel: temp1
					setPri: 11
					x: (proc0_13 116 116 116 116 118)
					init:
				)
				(localproc_2
					(proc0_13 115 115 115 115 117)
					(proc0_13 60 60 60 60 62)
					8
					(proc0_13 101 100 100 100 98)
					13
					local61
				)
				(localproc_2
					(proc0_13 151 151 151 151 160)
					32
					8
					(proc0_13 65 64 64 64 48)
					6
					local61
				)
				(= ticks 30)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance stk of Actor
	(properties
		yStep 3
		view 960
		priority 15
		signal 24592
		illegalBits 0
		xStep 4
		moveSpeed 1
	)
)

(instance inDx of Prop
	(properties
		x 212
		y 7
		view 9
		loop 7
	)
)

(instance sPtr of View
	(properties
		x 117
		y 29
		view 9
		loop 1
		cel 1
		priority 10
		signal 16400
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance pictureSquare of View
	(properties
		x 118
		y 33
		view 24
	)

	(method (init)
		(= y (proc0_13 30 30 30 30 31))
		(super init: &rest)
	)
)

(instance myList of List
	(properties)

	(method (dispose)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(super dispose:)
	)
)

