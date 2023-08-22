;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm4 0
)

(local
	local0
)

(instance rm4 of Rm
	(properties
		picture 4
		north 13
		east 3
		south 45
		west 5
	)

	(method (init)
		(if (>= global101 1)
			(Load rsVIEW 302)
		)
		(Load rsVIEW 1)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 220 (gEgo x:) 92) 78)
				(SetFlag 44)
			)
			(south
				(gEgo posn: (proc0_17 237 (gEgo x:) 3) 188)
			)
			(west
				(cond
					(global130
						(gEgo y: (proc0_17 158 (gEgo y:) 100))
					)
					((< (gEgo y:) 131)
						(gEgo y: 84)
					)
				)
				(gEgo x: 4)
			)
			(east
				(gEgo posn: 317 125)
			)
			(else
				(gEgo posn: 315 145)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(if (== gPrevRoomNum north)
			(gEgo setPri: 3)
		)
		(self setRegions: 603) ; waterReg
		(lake1 init:)
		(lake2 init:)
		(lake3 init:)
		(sand1 init:)
		(sand2 init:)
		(sand3 init:)
		(sand4 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(if (>= global101 1)
			(fish init:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(OneOf (gEgo onControl: 1) 2 4 8 16)
					(!= (gEgo illegalBits:) -24576)
				)
				(gEgo illegalBits: -24576)
			)
			(
				(and
					(not (OneOf (gEgo onControl: 1) 2 4 8 16))
					(== (gEgo illegalBits:) -24576)
				)
				(gEgo illegalBits: -32768)
			)
		)
		(cond
			((and script (not global130))
				(script doit:)
			)
			((and (not (gEgo script:)) (& (gEgo onControl: 1) $0040))
				(gEgo setScript: climbBackHill)
			)
			((and (& (gEgo onControl: 1) $2000) (== gNewRoomNum gCurRoomNum))
				(gCurRoom setScript: slipIntoWater)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(ClearFlag 44)
				(gEgo illegalBits: -32768 priority: -1)
				(self newRoom: temp0)
			)
			(
				(or
					(and
						(IsFlag 44)
						(>= (gEgo x:) 157)
						(>= (gEgo y:) 95)
						(== (gEgo script:) 0)
					)
					(and
						(& (gEgo onControl: 1) $0200)
						(not (IsFlag 44))
						(== (gEgo script:) 0)
					)
				)
				(gEgo setScript: climbHill)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $4000))
					(< (gEgo y:) 108)
					(> (gEgo x:) 119)
					(== (gEgo script:) 0)
					(not (IsFlag 44))
					(!= (gEgo priority:) 3)
					(not (& (gEgo onControl: 1) $0010))
				)
				(= local0 0)
				(SetFlag 44)
				(gEgo setPri: 3)
			)
			(
				(and
					(& (gEgo onControl: 1) $4000)
					(not (IsFlag 44))
					(== (gEgo script:) 0)
					(!= (gEgo priority:) 7)
				)
				(= local0 0)
				(gEgo setPri: 7)
			)
			(
				(and
					(not
						(and
							(not (& (gEgo onControl: 1) $4000))
							(< (gEgo y:) 108)
							(> (gEgo x:) 119)
						)
					)
					(not (& (gEgo onControl: 1) $4000))
					(!= local0 1)
				)
				(= local0 1)
				(ClearFlag 44)
				(gEgo setPri: -1)
			)
			(script
				(script doit:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,grass]')
						(Print 4 0) ; "There are many smooth pebbles next to the lake."
					)
					((Said '<down')
						(if (& (gEgo onControl: 1) $0100)
							(Print 4 1) ; "You're standing on a pebble strewn patch of sand on the river bank."
						else
							(Print 4 2) ; "You see your own boot-clad feet."
						)
					)
					((Said '/water,bank,bank')
						(Print 4 3) ; "There is a beach of pebbles on its edge."
					)
					((Said '[<at]/beach')
						(Print 4 4) ; "The sandy beach along the side of the lake is strewn with small pebbles."
					)
					((Said '/boulder')
						(Print 4 5) ; "The only rocks of interest are some pebbles on the beach."
					)
					((Said '/pebble')
						(cond
							((gEgo has: 9) ; Pebbles
								(event claimed: 0)
							)
							((& (gEgo onControl: 1) $0100)
								(Print 4 1) ; "You're standing on a pebble strewn patch of sand on the river bank."
							)
							(else
								(Print 4 6) ; "From here it looks like an ordinary beach of pebbles."
							)
						)
					)
				)
			)
			((Said 'get,get/boulder')
				(Print 4 7) ; "The only rocks worth getting are some pebbles on the beach."
			)
			((Said 'get,get/pebble')
				(cond
					((not (& (gEgo onControl: 1) $0100))
						(Print 4 8) ; "You are not close enough to the pebbles to get them."
					)
					((== global140 5)
						(Print 4 9) ; "Your pockets cannot hold any more pebbles."
					)
					((IsFlag 1)
						(Print 4 10) ; "You can't pick up any of the pebbles while you are invisible."
					)
					(else
						(gEgo setScript: getPebbles)
					)
				)
			)
		)
	)
)

(instance getPebbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 1 setMotion: 0 setCycle: End self)
			)
			(1
				(SetScore 91 1)
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(switch global140
					(0
						(gEgo get: 9) ; Pebbles
						(Print 4 11) ; "You grab a handful of pebbles."
					)
					(4
						(Print 4 12) ; "You grab a pebble."
					)
					(else
						(Print 4 13) ; "You grab some pebbles."
					)
				)
				(= global140 6)
				(UpdatePebbles)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 44))
					(gEgo
						illegalBits: 0
						setLoop: 3
						setPri: 3
						setMotion: MoveTo (gEgo x:) 94 self
					)
				else
					(gEgo
						illegalBits: 0
						setLoop: 2
						setMotion: MoveTo 216 84 self
					)
				)
			)
			(1
				(if (IsFlag 44)
					(ClearFlag 44)
					(gEgo setPri: 7 setMotion: MoveTo 217 89 self)
				else
					(SetFlag 44)
					(= cycles 1)
				)
			)
			(2
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance climbBackHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setPri: 1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(1
				(proc0_1)
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance slipIntoWater of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 0)
			(cond
				((& (gEgo onControl: 1) $0002)
					(self changeState: 1)
				)
				((< (gEgo yStep:) 9)
					(gEgo setStep: -1 (+ (gEgo yStep:) 2))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					ignoreActors:
					setMotion: MoveTo (- (gEgo x:) 200) (+ (gEgo y:) 140)
					setStep: 6 4
				)
				(if (IsFlag 1)
					(Print 4 14) ; "As you slip into the water, the magic ring slips from your finger."
					(gGame changeScore: -3)
				)
			)
			(1
				(gEgo
					posn: (- (gEgo x:) 2) (gEgo y:)
					setCycle: StopWalk 2
					setStep: 3 2
					ignoreActors: 0
					setMotion: 0
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fishJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fish
					posn: (Random 10 125) (Random 110 140)
					loop: (Random 0 1)
					setCycle: End self
				)
			)
			(1
				(fish stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fish of Prop
	(properties
		view 302
	)

	(method (init)
		(self cycleSpeed: (if (>= global101 1) 1 else 0) ignoreActors: stopUpd:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (< (Random 1 100) 3) (not (fish script:)) (not global130))
			(fish setScript: fishJump)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (fish script:)
					(Print 4 15) ; "That's one giant leap for the fish!"
				else
					(Print 4 16) ; "Looks like all the fish are currently underwater."
				)
			)
			(7
				(Print 4 17) ; "The fish would make your clothes smell and wouldn't be any help on your quest."
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/fish')
				(self doVerb: 1)
			)
			((Said 'get,get,capture/fish')
				(self doVerb: 7)
			)
		)
	)
)

(instance lake1 of NewFeature
	(properties
		x 81
		y 104
		noun '[<at,around][/room,lake,water,lake]'
		nsTop 91
		nsBottom 118
		nsRight 163
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake with a small beach of pebbles on its edge.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 85
		y 139
		noun '[<at,around][/room,lake,water,lake]'
		nsTop 118
		nsBottom 161
		nsRight 171
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake with a small beach of pebbles on its edge.}
	)
)

(instance lake3 of NewFeature
	(properties
		x 190
		y 135
		noun '[<at,around][/room,lake,water,lake]'
		nsTop 122
		nsLeft 170
		nsBottom 149
		nsRight 211
		description {lake3}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake with a small beach of pebbles on its edge.}
	)
)

(instance sand1 of NewFeature
	(properties
		x 125
		y 169
		noun '/beach,sand'
		nsTop 166
		nsLeft 56
		nsBottom 172
		nsRight 195
		description {sand}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {On the beach are some smooth pebbles.}
	)
)

(instance sand2 of NewFeature
	(properties
		x 176
		y 164
		noun '/beach,sand'
		nsTop 162
		nsLeft 155
		nsBottom 166
		nsRight 198
		description {sand}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {On the beach are some smooth pebbles.}
	)
)

(instance sand3 of NewFeature
	(properties
		x 188
		y 158
		noun '/beach,sand'
		nsTop 154
		nsLeft 172
		nsBottom 162
		nsRight 204
		description {sand}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {On the beach are some smooth pebbles.}
	)
)

(instance sand4 of NewFeature
	(properties
		x 150
		y 176
		noun '/beach,sand'
		nsTop 172
		nsLeft 118
		nsBottom 180
		nsRight 183
		description {sand}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {On the beach are some smooth pebbles.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 159
		y 34
		noun '/ceder'
		nsTop -1
		nsBottom 69
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many lush trees surrounding the lake.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 178
		y 82
		noun '/ceder'
		nsTop 69
		nsLeft 160
		nsBottom 95
		nsRight 196
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many lush trees surrounding the lake.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 289
		y 129
		noun '/ceder'
		nsTop 69
		nsLeft 259
		nsBottom 189
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many lush trees surrounding the lake.}
	)
)

