;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm040 0
)

(local
	local0 = 1
	local1
	local2
	[local3 30] = [319 0 319 137 139 136 145 107 196 107 220 82 246 90 303 72 295 10 216 9 206 14 189 10 110 24 85 18 63 0]
	[local33 10] = [70 189 70 138 96 142 125 138 171 189]
	[local43 8] = [28 189 47 127 68 129 64 189]
	[local51 12] = [0 189 0 62 53 62 29 96 45 124 21 189]
	[local63 14] = [93 101 98 113 93 123 80 129 72 115 71 105 82 99]
	[local77 12] = [150 72 170 73 177 87 155 100 130 93 131 77]
	[local89 14] = [256 18 270 12 290 19 292 30 279 42 263 42 255 32]
	[local103 12] = [191 23 211 38 211 42 199 46 162 33 151 23]
	[local115 40] = [0 1 99 43 158 41 192 53 198 49 209 47 215 42 217 39 222 35 205 23 228 13 244 23 248 34 219 55 185 64 126 70 125 88 83 79 86 59 0 59]
)

(instance rm040 of KQ5Room
	(properties
		picture 40
		horizon 5
		north 35
	)

	(method (init)
		(super init:)
		(self
			setFeatures: path40
			addObstacle: poly1 poly2 poly3 poly4 poly5 poly6 poly7 poly8 poly9
		)
		(ClearFlag 40)
		(gFeatures eachElementDo: #init)
		(water1 init:)
		(water2 init:)
		(water3 init:)
		(pond1 init:)
		(pond2 init:)
		(pond2 setScript: shadow)
		(if (== (gGame detailLevel:) 3)
			(waterfall init:)
		)
		(= global320 221)
		(= global321 91)
		(= global325
			{"Let's get a move-on, shall we, Graham!"}
		)
		(cedric init: setScript: cedricLand)
		(gEgo normal: 0 view: 586 loop: 2 posn: 70 9 setStep: 2 2 init:)
		((gEgo head:) hide:)
		(poly1 points: @local3 size: 15)
		(poly2 points: @local33 size: 5)
		(poly3 points: @local43 size: 4)
		(poly4 points: @local51 size: 6)
		(poly5 points: @local63 size: 7)
		(poly6 points: @local77 size: 6)
		(poly7 points: @local89 size: 7)
		(poly8 points: @local103 size: 6)
		(poly9 points: @local115 size: 20)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $0040)
				(gEgo setPri: 0)
			)
			((= local1 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: cedricFly)
			)
			((& (gEgo onControl: 1) $4000)
				(HandsOff)
				(self setScript: climb)
			)
			((& (gEgo onControl: 1) $2000)
				(HandsOff)
				(self setScript: fallWater)
			)
			((& (gEgo onControl: 0) $0008)
				(HandsOff)
				(gEgo illegalBits: 0)
				(self setScript: shortJump)
			)
			((& (gEgo onControl: 0) $0010)
				(HandsOff)
				(gEgo illegalBits: 0)
				(self setScript: shortJump3)
			)
			((& (gEgo onControl: 0) $0001)
				(gEgo setPri: -1)
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
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance shadow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pond2 cel: 0 loop: local0 setCycle: End self)
				(= cycles 1)
				(++ local0)
			)
			(1
				(= cycles (Random 60 120))
			)
			(2
				(if (== local0 5)
					(= local0 1)
				)
				(= state -1)
			)
		)
	)
)

(instance climb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 2 setMotion: MoveTo 148 144 self)
			)
			(1
				(gEgo view: 588 setLoop: 0 setMotion: MoveTo 171 157 self)
			)
			(2
				(gEgo setLoop: 1 setMotion: MoveTo 225 171 self)
			)
			(3
				(gEgo
					setLoop: 3
					cel: 0
					posn: (+ (gEgo x:) 5) (- (gEgo y:) 5)
					cycleSpeed: 2
					setCycle: End
				)
				(pond2
					setScript: 0
					loop: 5
					cel: 0
					posn: 260 189
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(4
				(SetScore 2)
				(proc0_28 75 40 0 67 50 8 70 160 25 4) ; "Graham! Look out!"
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance fallWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_28 75 40 1 67 50 8 70 160 25 4) ; "Graham! Watch out!"
				(gEgo
					setLoop: (if (== (gEgo loop:) 2) 5 else 4)
					cel: 0
					setCycle: End
					setPri: 1
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
				(gGlobalSound3 number: 83 priority: 15 loop: 1 vol: 127 play:)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(= global330
					{That last step was a doozy!}
				)
				(EgoDead)
			)
		)
	)
)

(instance shortJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 588
					loop: 4
					cel: 0
					setCycle: End self
					cycleSpeed: 2
					setMotion: JumpTo 181 40 self
				)
			)
			(1 0)
			(2
				(gEgo
					view: 586
					loop: 2
					illegalBits: $8000
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance shortJump3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 588
					loop: 5
					cel: 0
					setCycle: End self
					cycleSpeed: 2
					setMotion: JumpTo 212 43 self
				)
			)
			(1 0)
			(2
				(gEgo
					view: 586
					loop: 1
					illegalBits: $8000
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance cedricLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric setCycle: Fwd setMotion: MoveTo 221 91 self)
			)
			(1
				(cedric setLoop: 1 stopUpd:)
				(cedricHead init:)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance cedricFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric setCycle: Beg self)
			)
			(1
				(gCurRoom newRoom: local1)
			)
		)
	)
)

(instance path40 of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 2) ; "A twisty path winds confusingly up the rocky mountainside."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance pond1 of Prop
	(properties
		x 281
		y 188
		view 580
		cel 1
		priority 12
		signal 16400
	)

	(method (init)
		(if (== (gGame detailLevel:) 3)
			(self cycleSpeed: 3 setCycle: Fwd)
		else
			species
		)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 3) ; "A pool of water reflects the blueness of the sky where occasionally a vision of a huge soaring bird can be observed."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance pond2 of Prop
	(properties
		x 281
		y 189
		view 580
		loop 1
		priority 13
		signal 16400
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 2 setCycle: Fwd show:)
	)
)

(instance water1 of Prop
	(properties
		x 56
		y 63
		view 580
		loop 6
		priority 1
		signal 16400
	)

	(method (init)
		(if (> (gGame detailLevel:) 1)
			(self cycleSpeed: 3 setCycle: Fwd)
		else
			species
		)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 4) ; "Within a ravine, a swift river courses its way down the mountains."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance water2 of Prop
	(properties
		x 107
		y 82
		view 580
		loop 7
		cel 1
		priority 1
		signal 16400
	)

	(method (init)
		(if (> (gGame detailLevel:) 1)
			(self cycleSpeed: 2 setCycle: Fwd)
		else
			species
		)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 4) ; "Within a ravine, a swift river courses its way down the mountains."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance water3 of Prop
	(properties
		x 152
		y 90
		view 580
		loop 8
		cel 2
		priority 1
		signal 16400
	)

	(method (init)
		(if (> (gGame detailLevel:) 1)
			(self cycleSpeed: 2 setCycle: Fwd)
		else
			species
		)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 4) ; "Within a ravine, a swift river courses its way down the mountains."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance waterfall of Prop
	(properties
		x 32
		y 168
		view 580
		loop 9
		priority 15
		signal 16400
	)

	(method (init)
		(self cycleSpeed: 2 setCycle: Fwd)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 40 5) ; "A beautiful waterfall cascades down from a high, vertical cliff."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cedric of Actor
	(properties
		x 335
		y 200
		view 581
		priority 14
		signal 18448
	)

	(method (handleEvent event &tmp temp0)
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
					(PrintDC 40 6) ; "Cedric looks cold and weary as he dutifully follows Graham across these treacherous mountains."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not local2)
						(++ local2)
						(proc0_28 75 40 7 67 50 8 70 160 25 8) ; "Will we EVER find our way out of these mountains, Graham?"
						(proc0_28 165 40 8 67 8 8 25 8) ; "I don't know, Cedric. I'm beginning to wonder!"
					else
						(switch (Random 0 3)
							(0
								(PrintDC 40 9) ; "Cedric isn't listening to Graham at the moment."
							)
							(1
								(PrintDC 40 10) ; "Cedric isn't paying any attention to Graham."
							)
							(2
								(PrintDC 40 11) ; "Cedric isn't in the mood to talk right now."
							)
							(else
								(PrintDC 40 12) ; "Cedric doesn't have anything important to say at the moment."
							)
						)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 40 13) ; "Cedric doesn't need anything at the moment."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance cedricHead of Prop
	(properties
		x 221
		y 91
		view 581
		loop 2
		priority 15
		signal 16400
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(
				(<
					(= temp0
						(GetAngle
							(cedricHead x:)
							(cedricHead y:)
							(gEgo x:)
							(gEgo y:)
						)
					)
					135
				)
				(self setCel: 2)
			)
			((< temp0 292)
				(self setCel: 0)
			)
			(else
				(self setCel: 1)
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
	(properties)
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

(instance poly6 of Polygon
	(properties)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly8 of Polygon
	(properties)
)

(instance poly9 of Polygon
	(properties)
)

