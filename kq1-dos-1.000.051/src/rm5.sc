;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm5 0
)

(instance rm5 of Rm
	(properties
		picture 5
		north 12
		east 4
		south 44
		west 6
	)

	(method (init)
		(if (>= global101 1)
			(LoadMany rsVIEW 302 700)
		)
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
				(gEgo posn: (gEgo x:) 82)
			)
			(south
				(gEgo posn: (proc0_17 310 (gEgo x:) 119) 186)
			)
			(west
				(gEgo
					posn: 4 (proc0_17 185 (proc0_18 121 (gEgo y:) 91) 73)
				)
			)
			(east
				(cond
					(global130
						(gEgo y: (proc0_17 153 (gEgo y:) 109))
					)
					((< (gEgo y:) 131)
						(gEgo y: 78)
					)
					(else
						(gEgo y: 175)
					)
				)
				(gEgo x: 317)
			)
			(else
				(gEgo posn: 4 137)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(self setRegions: 603) ; waterReg
		(lake1 init:)
		(lake2 init:)
		(lake3 init:)
		(lake4 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(bigrock1 init:)
		(bigrock2 init:)
		(bigrock3 init:)
		(bigrock4 init:)
		(smallrock1 init:)
		(root1 init:)
		(root2 init:)
		(root3 init:)
		(if (>= global101 1)
			(fish init:)
			(ripple init: cycleSpeed: global101 setCycle: Fwd)
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
			((and script (not global130))
				(script doit:)
			)
			(
				(and
					(not (gEgo script:))
					(== gNewRoomNum gCurRoomNum)
					(& (gEgo onControl: 1) $2000)
				)
				(gCurRoom setScript: slipIntoWater)
			)
			((and script global130)
				(script doit:)
			)
			(
				(and
					(& (gEgo onControl: 1) $0200)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setScript: climbHill)
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
					((Said '[<at,around][/room,lake]')
						(Print 5 0) ; "This is a serene mountain lake."
					)
					((Said '/well')
						(Print 5 1) ; "In the woods to the north, you can just see what looks like an old stone well."
					)
				)
			)
		)
	)
)

(instance ripple of Prop
	(properties
		x 249
		y 132
		view 700
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 5 2) ; "The sunlight glistens on the rippling water."
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
			((Said 'look,look/ripple')
				(self doVerb: 1)
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
					posn: (Random 267 318) (Random 120 146)
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
					(Print 5 3) ; "That's one giant leap for the fish!"
				else
					(Print 5 4) ; "Do you see any fish here at the moment?"
				)
			)
			(7
				(Print 5 5) ; "Perhaps you'll find a use for a fish in a different King's Quest, but not in this one."
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

(instance climbHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setPri: 1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
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
		(if (and (== state 0) (& (gEgo onControl: 1) $0002))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					ignoreActors:
					illegalBits: 0
					setStep: 6 4
					setMotion: MoveTo 312 120
				)
				(if (IsFlag 1)
					(Print 5 6) ; "As you slip into the water, the magic ring slips from your finger."
					(gGame changeScore: -3)
				)
			)
			(1
				(gEgo
					posn: (gEgo x:) (+ (gEgo y:) 2)
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

(instance lake1 of NewFeature
	(properties
		x 286
		y 131
		noun '/lake,lake,water'
		nsTop 104
		nsLeft 253
		nsBottom 159
		nsRight 319
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 237
		y 134
		noun '/lake,lake,water'
		nsTop 116
		nsLeft 223
		nsBottom 153
		nsRight 252
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 43
		y 17
		noun '/ceder,oak'
		nsLeft 3
		nsBottom 35
		nsRight 84
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {An old, dignified oak tree rests near the shore of the lake.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 75
		y 69
		noun '/ceder,oak'
		nsTop 35
		nsLeft 60
		nsBottom 104
		nsRight 90
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {An old, dignified oak tree rests near the shore of the lake.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 129
		y 29
		noun '/ceder,oak'
		nsTop 16
		nsLeft 105
		nsBottom 42
		nsRight 153
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {An old, dignified oak tree rests near the shore of the lake.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 110
		y 47
		noun '/ceder,oak'
		nsTop 42
		nsLeft 89
		nsBottom 53
		nsRight 131
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {An old, dignified oak tree rests near the shore of the lake.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 110
		y 3
		noun '/ceder,oak'
		nsTop -1
		nsLeft 83
		nsBottom 7
		nsRight 138
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {An old, dignified oak tree rests near the shore of the lake.}
	)
)

(instance bigrock1 of NewFeature
	(properties
		x 42
		y 87
		noun '/boulder[<big]'
		nsTop 57
		nsLeft 25
		nsBottom 117
		nsRight 59
		description {big rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak are entwined around this craggy cluster of rocks.}
	)
)

(instance bigrock2 of NewFeature
	(properties
		x 18
		y 92
		noun '/boulder[<big]'
		nsTop 71
		nsLeft 12
		nsBottom 113
		nsRight 25
		description {big rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak are entwined around this craggy cluster of rocks.}
	)
)

(instance bigrock3 of NewFeature
	(properties
		x 107
		y 86
		noun '/boulder[<big]'
		nsTop 76
		nsLeft 90
		nsBottom 96
		nsRight 125
		description {big rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak are entwined around this craggy cluster of rocks.}
	)
)

(instance bigrock4 of NewFeature
	(properties
		x 81
		y 120
		noun '/boulder[<big]'
		nsTop 104
		nsLeft 59
		nsBottom 136
		nsRight 104
		description {big rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak are entwined around this craggy cluster of rocks.}
	)
)

(instance smallrock1 of NewFeature
	(properties
		x 232
		y 102
		noun '/boulder[<little]'
		nsTop 92
		nsLeft 214
		nsBottom 112
		nsRight 251
		description {small rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A boulder sits at the side of lake, the water lapping gently against its sides.}
	)
)

(instance lake3 of NewFeature
	(properties
		x 191
		y 114
		noun '/lake,water'
		nsTop 105
		nsLeft 173
		nsBottom 123
		nsRight 209
		description {lake2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake.}
	)
)

(instance lake4 of NewFeature
	(properties
		x 295
		y 98
		noun '/lake,water'
		nsTop 96
		nsLeft 271
		nsBottom 101
		nsRight 320
		description {lake3}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a serene mountain lake.}
	)
)

(instance root1 of NewFeature
	(properties
		x 121
		y 101
		noun '/root'
		nsTop 95
		nsLeft 99
		nsBottom 107
		nsRight 143
		description {root}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak spread out here to soak up water from the moist earth.}
	)
)

(instance root2 of NewFeature
	(properties
		x 134
		y 115
		noun '/root'
		nsTop 107
		nsLeft 110
		nsBottom 124
		nsRight 159
		description {root}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak spread out here to soak up water from the moist earth.}
	)
)

(instance root3 of NewFeature
	(properties
		x 123
		y 131
		noun '/root'
		nsTop 124
		nsLeft 113
		nsBottom 139
		nsRight 134
		description {root}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The roots of the oak spread out here to soak up water from the moist earth.}
	)
)

