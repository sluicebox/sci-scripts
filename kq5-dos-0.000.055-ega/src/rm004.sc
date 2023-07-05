;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm004 0
)

(local
	[local0 18] = [0 100 49 105 49 98 77 98 78 100 93 102 118 78 118 0 0 0]
	[local18 18] = [130 0 126 85 96 102 100 107 137 116 184 94 203 98 208 89 204 0]
	[local36 14] = [221 0 224 85 208 97 209 100 241 108 274 94 248 0]
	[local50 10] = [177 100 168 104 183 112 202 103 193 98]
	[local60 28] = [254 0 277 92 285 88 297 94 312 94 312 113 268 182 217 156 156 180 59 123 0 137 0 189 319 189 319 0]
	local88
	local89
	local90
	local91
	local92
	local93
	local94
	local95
	local96
	local97
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(cls)
	(signCel x: param2 cel: param1 init:)
	(RedrawCast)
	(while (not (proc0_15 ((= temp0 (Event new:)) type:) 1 4))
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(signCel dispose:)
)

(instance rm004 of Rm
	(properties
		picture 4
		west 3
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 30 loop: -1 play:)
		(switch gPrevRoomNum
			(5
				(switch global313
					(1
						(door0 cel: (- (NumCels door0) 1))
						(gEgo posn: 99 97)
					)
					(2
						(gEgo posn: 222 95)
						(door1 cel: (- (NumCels door1) 1))
					)
					(3
						(gEgo posn: 267 90)
						(door2 cel: (- (NumCels door2) 1))
					)
				)
				(HandsOff)
				(self setScript: outTheDoor)
			)
			(else
				(HandsOff)
				(gEgo posn: 6 121)
				(self setScript: walkIn4)
			)
		)
		(if (not (IsFlag 5))
			(SetFlag 5)
			(cart init: setScript: fixCart)
		else
			(self setFeatures: alley)
			(if (== ((gInventory at: 4) owner:) 4) ; Coin
				(glint init: setScript: glitter)
			)
		)
		(walker1 setCycle: Walk setStep: 1 1 setScript: walkThruW1 init:)
		(walker2 setCycle: Walk setStep: 2 1 setScript: walkThruBoy init:)
		(= local93 1)
		(= local95 1)
		(walker3 setCycle: Walk setStep: 1 1 setScript: walkThruW3 init:)
		(walker4 setCycle: Walk setStep: 1 1 setScript: walkThruW2 init:)
		(door0 init:)
		(door1 init:)
		(door2 init:)
		(self
			setFeatures:
				barrel
				sign1
				sign2
				sign3
				tailor
				toystore
				shoeshop
				townShip
		)
		(gEgo
			view: 5
			illegalBits: -32768
			ignoreActors: 0
			normal: 1
			setStep: 2 1
			offset: 2
			init:
		)
		((gEgo head:) hide:)
		(poly1 points: @local0 size: 9)
		(poly2 points: @local18 size: 9)
		(poly3 points: @local36 size: 7)
		(poly4 points: @local50 size: 5)
		(poly5 points: @local60 size: 14)
		(self addObstacle: poly1 poly2 poly3 poly4 poly5)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(= global313 1)
				(self setScript: openDoor)
			)
			((& (gEgo onControl: 0) $0010)
				(HandsOff)
				(= global313 2)
				(self setScript: openDoor)
			)
			((& (gEgo onControl: 0) $0040)
				(HandsOff)
				(= global313 3)
				(self setScript: openDoor)
			)
			(
				(and
					(gCast contains: barrelClone)
					(not (gEgo inRect: 24 80 63 124))
				)
				(cls)
				(fish dispose:)
				(barrelClone dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance walkIn4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 35 (gEgo y:) self)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkThruBoy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(-- local96)
				(= seconds (Random 5 16))
			)
			(1
				(if (>= local96 2)
					(-- state)
					(= cycles 10)
				else
					(++ local96)
					(switch local90
						(0
							(= temp0 305)
							(++ local90)
						)
						(1
							(= temp0 0)
							(-- local90)
						)
					)
					(client setMotion: MoveTo temp0 134 self)
					(= state -1)
				)
			)
		)
	)
)

(instance walkThruW1 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(-- local96)
				(if (>= local91 1)
					(client loop: 1)
				else
					(client loop: 0)
				)
				(= seconds (Random 5 16))
				(+= local91 local94)
			)
			(1
				(if (>= local96 2)
					(-- state)
					(= cycles 1)
				else
					(++ local96)
					(switch local91
						(0
							(= temp0 115)
							(= temp1 108)
							(= local94 1)
						)
						(1
							(= temp0 165)
							(= temp1 101)
						)
						(2
							(= temp0 263)
							(= temp1 98)
						)
						(3
							(= temp0 303)
							(= temp1 98)
							(= local94 -1)
						)
					)
					(client setMotion: PolyPath temp0 temp1 self)
					(= state -1)
				)
			)
		)
	)
)

(instance walkThruW2 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= seconds (Random 5 16))
				(-- local96)
			)
			(1
				(if (>= local96 2)
					(-- state)
					(= cycles 2)
				else
					(++ local96)
					(switch local92
						(0
							(= temp0 277)
							(= temp1 153)
							(= local92 1)
						)
						(1
							(= temp0 74)
							(= temp1 132)
							(= local92 0)
						)
					)
					(client setMotion: PolyPath temp0 temp1 self)
					(= state -1)
				)
			)
		)
	)
)

(instance walkThruW3 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(-- local96)
				(if (and (!= local93 3) (not local97))
					(client loop: 3)
					(= seconds (Random 5 16))
				else
					(= cycles 1)
				)
			)
			(1
				(= local97 1)
				(if (>= local96 2)
					(= local97 1)
					(-- state)
					(= cycles 3)
				else
					(= local97 0)
					(++ local96)
					(switch local93
						(0
							(= temp0 300)
							(= temp1 101)
							(= local95 1)
							(+= local93 1)
						)
						(1
							(= temp0 187)
							(= temp1 114)
							(+= local93 local95)
						)
						(2
							(= temp0 134)
							(= temp1 127)
							(+= local93 local95)
							(if (== local95 1)
								(++ local93)
							)
						)
						(4
							(= temp0 0)
							(= temp1 111)
							(= local95 -1)
							(+= local93 -1)
							(-- local93)
						)
					)
					(client setMotion: PolyPath temp0 temp1 self)
					(= state -1)
				)
			)
		)
	)
)

(instance glitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 7))
				(= state -1)
				(glint cycleSpeed: 2 setCycle: End)
			)
		)
	)
)

(instance outTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0)
				(= cycles 5)
			)
			(1
				(switch global313
					(1
						(gEgo setMotion: MoveTo 91 104 self)
					)
					(2
						(gEgo setMotion: MoveTo 205 100 self)
					)
					(else
						(gEgo setMotion: MoveTo 284 90 self)
					)
				)
			)
			(2
				(switch global313
					(1
						(door0 cycleSpeed: 2 setCycle: Beg self)
					)
					(2
						(door1 cycleSpeed: 2 setCycle: Beg self)
					)
					(else
						(door2 cycleSpeed: 2 setCycle: Beg self)
					)
				)
				(gGlobalSound3 number: 124 loop: 1 vol: 90 play:)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fixCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cart loop: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 8)
				(= state (- (Random 0 2) 1))
			)
			(1
				(cart loop: 1 setCycle: Fwd)
				(= cycles 8)
				(= state (- (Random 0 2) 1))
			)
			(2
				(cart loop: 2 setCycle: End self)
				(= state (- (Random 0 2) 1))
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (not (gEgo mover:))
			(cond
				((== state 0)
					(gEgo y: (+ (gEgo y:) 2))
					(self init:)
				)
				((== state 2)
					(gEgo y: (+ (gEgo y:) 2))
					(self start: 2 init:)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global313
					(1
						(gEgo setMotion: PolyPath 100 98 self)
					)
					(2
						(gEgo setMotion: PolyPath 207 100 self)
					)
					(else
						(gEgo setMotion: PolyPath 277 93 self)
					)
				)
			)
			(1
				(gEgo setMotion: 0 illegalBits: 0)
				(switch global313
					(1
						(door0 startUpd: setCycle: End self)
					)
					(2
						(door1 startUpd: setCycle: End self)
					)
					(else
						(door2 startUpd: setCycle: End self)
					)
				)
				(gGlobalSound3 number: 122 loop: 1 vol: 80 play:)
			)
			(2
				(switch global313
					(1
						(gEgo setMotion: MoveTo 109 91 self)
					)
					(2
						(gEgo setMotion: MoveTo 222 95 self)
					)
					(else
						(gEgo setPri: 2 setMotion: MoveTo 267 90 self)
					)
				)
			)
			(3
				(gEgo illegalBits: -32768)
				(gCurRoom newRoom: 5)
			)
		)
	)
)

(instance getFish of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (not (gEgo mover:)))
			(self start: 1 init:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(fish dispose:)
				(barrelClone dispose:)
				(= seconds 3)
			)
			(1
				(gEgo setMotion: PolyPath 51 106 self)
			)
			(2
				(gEgo
					normal: 0
					view: 154
					loop: 0
					cel: 0
					cycleSpeed: 2
					setAvoider: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo get: 5) ; Fish
				(SetScore 2)
				(gEgo normal: 1 view: 5 cycleSpeed: 0 loop: 1 setCycle: Walk)
				(RedrawCast)
				(PrintDC 4 0 #at 20 140) ; "Graham leans into the barrel and removes...phew!...the smelly old fish."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getCoin of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (gEgo mover:)))
			(gEgo y: (+ (gEgo y:) 2))
			(client setScript: getCoin)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 72 100 self)
			)
			(1
				(gEgo
					normal: 0
					view: 154
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setAvoider: 0
					setCycle: End self
				)
			)
			(2
				(glint dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo get: 4) ; Coin
				(SetScore 2)
				(gEgo
					normal: 1
					view: 5
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
				)
				(RedrawCast)
				(PrintDC 4 1 #at 20 140) ; "Bending down, Graham quickly retrieves the silver coin from the street."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talkMan of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (gEgo mover:)))
			(self init:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 68 107 self)
			)
			(1
				(proc0_7 gEgo cart 5)
				(gEgo setAvoider: 0)
				(= cycles 3)
			)
			(2
				(Say 160 4 2 67 80 100 25 6) ; "How goes it with you, good fellow?"
				(Say 197 4 3 67 80 10 25 9) ; "Not well, I'm afraid. This old wagon's always giving me trouble."
				(Say 160 4 4 67 80 100 25 6) ; "Can I help you in any way?"
				(Say 197 4 5 67 80 10 25 6) ; "Thank you kindly, but I think I can handle it."
				(Say 160 4 6 67 80 100 25 6) ; "All right then. Good luck."
				(Say 197 4 7 67 80 10 25 7) ; "Thanks. With this wagon, I'm gonna need it."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance lookInBarrel of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (gEgo mover:)))
			(gEgo y: (+ (gEgo y:) 2))
			(client setScript: lookInBarrel)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 51 106 self)
			)
			(1
				(gEgo loop: 7 cel: 1)
				(= cycles 10)
			)
			(2
				(if (== ((gInventory at: 5) owner:) 4) ; Fish
					(fish init:)
					(barrelClone init:)
					(RedrawCast)
					(PrintDC 4 8 #at 20 140 #time 8) ; "Inside the barrel, Graham sees an old fish."
				else
					(PrintDC 4 9) ; "The inside of the barrel is empty."
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance signCel of Prop
	(properties
		y 100
		x 160
		view 157
		priority 15
		signal 16
	)
)

(instance townShip of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 10) ; "Quaint houses and cute shops line the town's main cobblestoned street."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance alley of RFeature
	(properties
		nsTop 61
		nsLeft 40
		nsBottom 96
		nsRight 78
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 11) ; "A broken wagon blocks access to a smaller side street."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 12) ; "The cart is too heavy for Graham to move by himself."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sign1 of RFeature
	(properties
		nsTop 66
		nsLeft 86
		nsBottom 76
		nsRight 101
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(localproc_0 0 60)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sign2 of RFeature
	(properties
		nsTop 65
		nsLeft 205
		nsBottom 73
		nsRight 217
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(localproc_0 2 200)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sign3 of RFeature
	(properties
		nsTop 63
		nsLeft 286
		nsBottom 72
		nsRight 297
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(localproc_0 1 280)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door0 of Prop
	(properties
		y 93
		x 101
		view 152
		loop 3
		priority 2
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(3 ; Do
					(= global313 2)
					(HandsOff)
					(gCurRoom setScript: openDoor)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		y 96
		x 210
		view 152
		loop 1
		priority 2
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(3 ; Do
					(= global313 2)
					(HandsOff)
					(gCurRoom setScript: openDoor)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door2 of Prop
	(properties
		y 90
		x 275
		view 152
		loop 2
		priority 2
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(3 ; Do
					(= global313 3)
					(HandsOff)
					(gCurRoom setScript: openDoor)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance tailor of RFeature
	(properties
		nsTop 46
		nsLeft 75
		nsBottom 102
		nsRight 181
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 13) ; "A prosperous-looking tailorshop occupies the town's main corner."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance toystore of RFeature
	(properties
		nsTop 49
		nsLeft 181
		nsBottom 102
		nsRight 252
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 14) ; "A cute toyshop fronts the town's cobblestone street."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shoeshop of RFeature
	(properties
		nsTop 49
		nsLeft 252
		nsBottom 97
		nsRight 288
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 15) ; "Nearly hidden at the end of the street sits a small shoeshop."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cart of Prop
	(properties
		y 97
		x 63
		view 155
		priority 2
		signal 16
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 16) ; "Blocking an alleyway, a frustrated man fixes a broken wheel on his wagon."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 17) ; "The man is too busy with his work to notice Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(if (not local88)
						(++ local88)
						(gCurRoom setScript: talkMan)
					else
						(PrintDC 4 18) ; "Seeing the man is busy, Graham does not want to bother him again."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance barrel of RFeature
	(properties
		nsTop 95
		nsLeft 37
		nsBottom 105
		nsRight 50
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 19) ; "Graham notices an old wooden barrel on the street."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (gCast contains: fish))
						(gCurRoom setScript: lookInBarrel)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance barrelClone of Prop
	(properties
		y 81
		x 30
		view 157
		loop 1
		signal 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(if (== ((gInventory at: 5) owner:) 4) ; Fish
						(PrintDC 4 8 #at 20 140) ; "Inside the barrel, Graham sees an old fish."
					else
						(PrintDC 4 9) ; "The inside of the barrel is empty."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (== ((gInventory at: 5) owner:) 4) ; Fish
						(HandsOff)
						(gCurRoom setScript: getFish)
					else
						(PrintDC 4 20) ; "You couldn't carry around a big barrel."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance fish of Prop
	(properties
		y 61
		x 34
		view 157
		loop 1
		cel 1
		priority 6
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 21) ; "Inside the old barrel, Graham sees an old fish."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getFish)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance walker1 of Act
	(properties
		y 112
		view 156
		illegalBits 2048
		moveSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 22) ; "The town is busy with people going about their daily chores."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 23) ; "The people are too caught up in their own business to pay much attention to Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 4 24) ; "The people are too busy to spend much time talking to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance walker2 of Act
	(properties
		y 120
		x -20
		view 158
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 22) ; "The town is busy with people going about their daily chores."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 23) ; "The people are too caught up in their own business to pay much attention to Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 4 24) ; "The people are too busy to spend much time talking to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance walker3 of Act
	(properties
		y 101
		x 300
		view 159
		illegalBits 2048
		moveSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 22) ; "The town is busy with people going about their daily chores."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 23) ; "The people are too caught up in their own business to pay much attention to Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 4 24) ; "The people are too busy to spend much time talking to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance walker4 of Act
	(properties
		y 132
		x 73
		view 153
		illegalBits 2048
		moveSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 22) ; "The town is busy with people going about their daily chores."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 4 23) ; "The people are too caught up in their own business to pay much attention to Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 4 24) ; "The people are too busy to spend much time talking to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		y 98
		x 65
		view 152
		loop 4
		priority 1
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 4 25) ; "Graham notices a shiny silver coin lying forgotten on the street near the broken wagon."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getCoin)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

