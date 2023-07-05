;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
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
	rm086 0
)

(local
	[local0 36] = [131 0 185 134 155 132 143 127 96 129 77 143 86 149 89 155 231 154 229 148 198 137 215 132 199 130 144 0 319 0 319 189 0 189 0 0]
	local36
)

(instance rm086 of Rm
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
			(gEgo posn: 179 108 offset: 3 init:)
		)
		(poly1 points: @local0 size: 18)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (& (gEgo onControl: 0) $4000) (IsFlag 81))
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
				(= global330
					{Cheer up, Graham. The innkeeper will soon put you out of your misery.}
				)
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
				(PrintDC 86 0) ; "Graham stoops down and picks up the sturdy rope from the stone floor."
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(SetScore 2)
				(rope dispose:)
				(gEgo get: 20 setCycle: Beg self) ; Rope
			)
			(3
				(gEgo normal: 1 view: 0 setCycle: Walk loop: 7 cel: 1)
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
				(PrintDC 86 1 #at 10 120 #time 8) ; "Using the cobbler's hammer, Graham pounds on the rusty padlock until it breaks apart."
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
					setCycle: Walk
					posn: 175 110
					loop: 11
					cycleSpeed: 0
					cel: 4
					ignoreControl: 16384
				)
				(SetFlag 81)
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
				(PrintDC 86 2 #at 20 20 #dispose) ; "Struggle as he might, Graham cannot escape his bonds."
				(= seconds 7)
			)
			(2
				(cls)
				(= global330
					{Don't worry, Graham. The innkeeper will soon put you out of your misery.}
				)
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
				(PrintDC 86 2 #at 20 20 #dispose) ; "Struggle as he might, Graham cannot escape his bonds."
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
					setCycle: Walk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(8
				(gGlobalSound4 number: 63 loop: -1 vol: 127 play:)
				(cloud init: setCycle: End self)
			)
			(9
				(cloud hide:)
				(face init:)
				(mouth setCycle: Fwd init:)
				(eyes init: setScript: (moveScript new:))
				(eyebrows init: setScript: (moveScript new:))
				(hands init: setScript: (moveScript new:))
				(= cycles 5)
			)
			(10
				(PrintDC 86 3 #at 10 150 #width 280 #dispose) ; "I told you I'd repay your kindness when you saved me from that horrible cat. Good luck, friend."
				(= seconds 11)
			)
			(11
				(cls)
				(face dispose:)
				(eyes dispose:)
				(eyebrows dispose:)
				(hands dispose:)
				(mouth dispose:)
				(cloud setCycle: Beg self)
			)
			(12
				(cloud dispose:)
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

(instance moveScript of Script
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
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 86 4) ; "A small set of rickety, wooden stairs lead up to the cellar door."
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
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 86 5) ; "In the corner of the cellar, Graham notices a large rathole."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 86 6) ; "There is nothing that Graham would be interested in inside the rathole."
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
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 86 7) ; "Graham has unceremoniously found himself in the country inn's dusty, dirty cellar."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rat of Act
	(properties
		y 133
		x 60
		view 816
		illegalBits 0
	)
)

(instance door of Prop
	(properties
		y 100
		x 161
		view 818
		loop 2
		priority 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 86 4) ; "A small set of rickety, wooden stairs lead up to the cellar door."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local36)
						(PrintDC 86 8) ; "A rusty padlock on the door keeps Graham locked in."
					else
						(HandsOff)
						(gCurRoom setScript: exitRoom)
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(1 ; Key
							(PrintDC 86 9) ; "The key won't fit this lock."
							(event claimed: 1)
						)
						(22 ; Hammer
							(if (not local36)
								(HandsOff)
								(++ local36)
								(gCurRoom setScript: useHammer)
							else
								(PrintDC 86 10) ; "The lock has already been broken."
							)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 86 11) ; "That won't help Graham unlock the padlock on the door."
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
		y 137
		x 148
		view 820
		loop 2
		priority 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 86 12) ; "Lying in a heap on the cold, stone floor, Graham sees the rope that once held him captive."
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
		y 72
		x 81
		view 818
		loop 3
		cycleSpeed 2
	)
)

(instance hands of Prop
	(properties
		y 93
		x 74
		view 223
		loop 2
		cel 3
		priority 12
		signal 16400
	)
)

(instance mouth of Prop
	(properties
		y 69
		x 73
		view 223
		loop 3
		cel 2
		priority 12
		signal 16400
		cycleSpeed 3
	)
)

(instance eyes of Prop
	(properties
		y 63
		x 73
		view 223
		loop 4
		cel 2
		priority 13
		signal 16400
	)
)

(instance eyebrows of Prop
	(properties
		y 57
		x 73
		view 223
		loop 5
		cel 1
		priority 13
		signal 16400
	)
)

(instance face of Prop
	(properties
		y 110
		x 75
		view 223
		priority 11
		signal 16400
	)
)

(instance cloud of Prop
	(properties
		y 82
		x 75
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

(instance smokeOut1 of PV
	(properties
		y 3
		x 187
		view 292
		loop 3
	)
)

(instance smokeOut2 of PV
	(properties
		y 7
		x 294
		view 292
		loop 4
	)
)

