;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm086 0
)

(local
	[local0 36] = [131 0 185 134 155 132 143 127 96 129 77 143 86 149 89 155 231 154 229 148 198 137 215 132 199 130 144 0 319 0 319 189 0 189 0 0]
	local36
	[local37 9] = [1005 60 100 5 8 26 19 24 32]
)

(instance rm086 of KQ5Room
	(properties
		picture 86
	)

	(method (init)
		(super init:)
		(gAddToPics add: smokeOut1 smokeOut2 doit:)
		(self setFeatures: stairs ratHole room addObstacle: poly1)
		(torch setCycle: Fwd init:)
		(door init:)
		(if (== gPrevRoomNum 85)
			(gGlobalSound number: 66 loop: -1 vol: 127 play:)
			(HandsOff)
			(gEgo
				normal: 0
				view: 818
				loop: 1
				posn: 150 128
				cycleSpeed: 3
				observeControl: 16384
				setCycle: Fwd
				init:
			)
			((gEgo head:) hide:)
			(if
				(or
					(== ((gInventory at: 8) owner:) 6) ; Shoe
					(== ((gInventory at: 16) owner:) 6) ; Stick
					(== ((gInventory at: 19) owner:) 6) ; Leg_of_Lamb
					(== ((gInventory at: 5) owner:) 6) ; Fish
				)
				(self setScript: rescue)
			else
				(self setScript: yourStuck)
			)
		else
			(gGlobalSound number: 787 loop: -1 play:)
			(if (== ((gInventory at: 20) owner:) 86) ; Rope
				(rope init: stopUpd:)
			)
			(++ local36)
			(gEgo posn: 179 108 init:)
		)
		(poly1 points: @local0 size: 18)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (& (gEgo onControl: 0) $4000) (IsFlag 80))
				(HandsOff)
				(self setScript: exitRoom)
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
		(gEgo ignoreControl: 16384)
		(super dispose:)
	)
)

(instance walkingDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(cls)
				(= global330 741)
				(EgoDead)
			)
		)
	)
)

(instance getRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 150 138 self)
			)
			(1
				(Say 9054)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(SetScore 2)
				(rope dispose:)
				(gEgo get: 20 setCycle: Beg self) ; Rope
			)
			(3
				(gEgo normal: 1 view: 0 setCycle: SyncWalk loop: 7 cel: 1)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance useHammer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 175 110 self)
			)
			(1
				(Say 736)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 822
					loop: 0
					cel: 0
					cycleSpeed: 2
					posn: 168 109
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0 setCycle: End self)
				(gGlobalSound3 number: 828 loop: 1 vol: 127 play:)
			)
			(3
				(gEgo cel: 0 setCycle: End self)
				(gGlobalSound3 number: 828 loop: 1 play:)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
				(gGlobalSound3 number: 828 loop: 1 play:)
			)
			(5
				(gGlobalSound3 number: 828 loop: 1 play:)
				(gEgo
					normal: 1
					view: 0
					setCycle: SyncWalk
					posn: 175 110
					loop: 11
					cycleSpeed: 0
					cel: 4
					ignoreControl: 16384
				)
				(SetFlag 80)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(6
				(cls)
				(SetScore 4)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo y:) 111)
					(gEgo setMotion: PolyPath 182 110 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGlobalSound3 number: 123 loop: 1 play:)
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 173 99 self)
			)
			(3
				(cls)
				(HandsOn)
				(client setScript: 0)
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance yourStuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 55)
			)
			(1
				(Say 740 0 1)
				(= seconds 7)
			)
			(2
				(cls)
				(= global330 742)
				(EgoDead)
			)
		)
	)
)

(instance rescue of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 5) (== (rat cel:) 1))
			(gGlobalSound3 number: 881 loop: 1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 55)
			)
			(1
				(Say 740 0 1)
				(= seconds 7)
			)
			(2
				(cls)
				(gGlobalSound number: 62 loop: 1 play:)
				(rat
					setCycle: Walk
					setStep: 2 2
					moveSpeed: 1
					setMotion: MoveTo 117 132 self
					init:
				)
			)
			(3
				(rat setLoop: 2 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 15)
			)
			(4
				(rat
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 131 126 self
				)
			)
			(5
				(rat setLoop: 2 setCycle: Fwd)
				(= cycles 100)
			)
			(6
				(rat setCycle: 0)
				(gEgo view: 820 loop: 0 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 884 loop: 1 vol: 127 play:)
			)
			(7
				(rope init:)
				(gEgo
					normal: 1
					view: 0
					loop: 1
					cel: 7
					cycleSpeed: 0
					x: (- (gEgo x:) 6)
					y: (+ (gEgo y:) 5)
					setCycle: SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(8
				(gGlobalSound4 number: 63 loop: -1 vol: 127 play:)
				(= cycles 1)
			)
			(9
				(= cycles 1)
			)
			(10
				(proc762_1 @local37 5104)
				(= cycles 1)
			)
			(11
				(cls)
				(= cycles 1)
			)
			(12
				(rat
					setLoop: 1
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 58 133 self
				)
				(gGlobalSound4 fade:)
			)
			(13
				(gGlobalSound number: 787 loop: -1 play:)
				(if (not (gEgo has: 22)) ; Hammer
					(door setScript: walkingDead)
				)
				(rat dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance moveScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 10)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 3 10))
			)
		)
	)
)

(instance stairs of RFeature
	(properties
		nsTop 38
		nsLeft 162
		nsBottom 120
		nsRight 209
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 729)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance ratHole of RFeature
	(properties
		nsTop 116
		nsLeft 72
		nsBottom 131
		nsRight 88
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 730)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 734)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 731)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rat of Actor
	(properties
		x 60
		y 133
		view 816
		illegalBits 0
	)
)

(instance door of Prop
	(properties
		x 161
		y 100
		view 818
		loop 2
		priority 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 729)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local36)
						(Say 735)
					else
						(HandsOff)
						(gCurRoom setScript: exitRoom)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(1
							(Say 737)
							(event claimed: 1)
						)
						(22
							(if (not local36)
								(HandsOff)
								(++ local36)
								(gCurRoom setScript: useHammer)
							else
								(Say 738)
							)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 739)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance rope of Prop
	(properties
		x 148
		y 137
		view 820
		loop 2
		priority 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 732)
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getRope)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance torch of Prop
	(properties
		x 81
		y 72
		view 818
		loop 3
		cycleSpeed 2
	)
)

(instance hands of Prop ; UNUSED
	(properties
		x 74
		y 93
		view 223
		loop 2
		cel 3
		priority 12
		signal 16400
	)
)

(instance theMouth of Prop ; UNUSED
	(properties
		x 73
		y 69
		view 223
		loop 3
		cel 2
		priority 12
		signal 16400
		cycleSpeed 3
	)
)

(instance theEyes of Prop ; UNUSED
	(properties
		x 73
		y 63
		view 223
		loop 4
		cel 2
		priority 13
		signal 16400
	)
)

(instance eyebrows of Prop ; UNUSED
	(properties
		x 73
		y 57
		view 223
		loop 5
		cel 1
		priority 13
		signal 16400
	)
)

(instance face of Prop ; UNUSED
	(properties
		x 75
		y 110
		view 223
		priority 11
		signal 16400
	)
)

(instance cloud of Prop ; UNUSED
	(properties
		x 75
		y 82
		view 214
		priority 10
		signal 16400
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance smokeOut1 of PicView
	(properties
		x 187
		y 3
		view 292
		loop 3
	)
)

(instance smokeOut2 of PicView
	(properties
		x 294
		y 7
		view 292
		loop 4
	)
)

