;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
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
	rm018 0
)

(local
	local0
	[local1 19] = [302 67 288 82 231 148 152 121 119 171 117 126 98 105 46 118 7 119 0]
	[local20 50] = [38 64 0 36 0 189 319 189 319 0 79 0 76 45 108 61 112 62 152 62 193 51 257 81 164 104 154 96 116 104 93 100 78 106 86 115 76 128 68 119 50 116 39 128 12 135 3 130 3 69]
)

(instance rm018 of Rm
	(properties
		picture 18
	)

	(method (init)
		(super init:)
		(HandsOn)
		(self setFeatures: treasure)
		(glint cycleSpeed: 1 init: setScript: sparkle)
		(gEgo
			offset: 3
			view: 0
			illegalBits: $8000
			posn: 76 71
			cycleSpeed: 0
			setStep: 3 2
			normal: 1
			init:
		)
		(if (== ((gInventory at: 6) owner:) 18) ; Brass_Bottle
			(bottle init:)
		)
		(if (== ((gInventory at: 11) owner:) 18) ; Gold_Coin
			(coin init: setScript: gleem)
		)
		(door init: setScript: closeDoor)
		(poly1 points: @local20 size: 25)
		(self addObstacle: poly1)
		(gGlobalSound number: 45 loop: -1 play:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(gCurRoom newRoom: 214)
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
		(super dispose:)
	)
)

(instance getCoin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(gEgo setMotion: PolyPath 130 69 self)
			)
			(1
				(cls)
				(PrintDC 18 0) ; "Bending down, Graham hurriedly picks up the gold coin from the temple floor."
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(SetScore 2)
				(coin dispose:)
				(gEgo
					normal: 1
					get: 11 ; Gold_Coin
					view: 0
					setCycle: Walk
					loop: 7
					cel: 1
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (Random 0 8))
				(client
					loop: (Random 1 7)
					x: [local1 (* temp0 2)]
					y: [local1 (+ (* temp0 2) 1)]
					setCycle: End self
				)
			)
			(1
				(= state -1)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance gleem of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= state -1)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance getLoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 119 104 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 398
					loop: 10
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 11 setCycle: Fwd)
				(= cycles 50)
			)
			(3
				(if (< (closeDoor state:) 1)
					(closeDoor changeState: 1)
				)
				(gEgo loop: 12 cel: 0 setCycle: End)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (HaveMouse)
					(= seconds 12)
				else
					(= seconds 30)
				)
			)
			(1
				(if (gCurRoom script:)
					(-- state)
					(= cycles 1)
				else
					(PrintDC 18 1 #at 10 10 #dispose) ; "The exit door is about to close!"
					(if (gEgo script:)
						(= seconds 2)
					else
						(= seconds 4)
					)
				)
			)
			(2
				(cls)
				(gGlobalSound3 number: 18 loop: 1 vol: 127 play:)
				(client setPri: (- (gEgo priority:) 1) setCycle: Beg self)
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $2000))
					(gEgo observeControl: 8192)
				else
					(gEgo setMotion: MoveTo 36 42)
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(= global330
					{Cheer up, Graham. At least you can practice your game of tiddlywinks!}
				)
				(EgoDead 258)
			)
		)
	)
)

(instance getBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(gEgo setMotion: PolyPath 120 64 self)
			)
			(1
				(cls)
				(PrintDC 18 2) ; "Quickly, Graham grabs the old brass bottle."
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 398
					loop: 9
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(SetScore 2)
				(bottle dispose:)
				(gEgo get: 6 setCycle: End self) ; Brass_Bottle
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

(instance door of Prop
	(properties
		y 64
		x 67
		view 398
		loop 8
		cel 13
		signal 16384
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
					(PrintDC 18 3) ; "Hurry! The door may close any time now!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bottle of Prop
	(properties
		y 60
		x 129
		view 398
		loop 13
		signal 16385
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
					(PrintDC 18 4) ; "Near the door sits an old, tarnished brass bottle."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getBottle)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		view 398
		priority 15
		signal 16400
	)
)

(instance coin of Prop
	(properties
		y 60
		x 117
		view 398
		signal 16384
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
					(PrintDC 18 5) ; "A lone gold coin, somehow separated from the rest of the treasure, lies on the floor near the door."
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

(instance treasure of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl PRIORITY (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 18 6) ; "Treasure! Treasure piled everywhere! The sparkling brilliance of it overwhelms Graham as he peers around the temple's interior."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 18 7) ; "Oh, my! Look at all this treasure!"
					(HandsOff)
					(gEgo setScript: getLoot)
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

