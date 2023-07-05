;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm37 0
)

(local
	local0
)

(procedure (localproc_0)
	(Print 37 5) ; "The huge snake is watching you very closely, and its intentions are less than friendly."
)

(instance rm37 of Rm
	(properties
		picture 37
		horizon 73
		north 44
		east 36
		south 28
		west 38
	)

	(method (init)
		(LoadMany rsVIEW 237 303)
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
				(if (> (gEgo x:) 160)
					(gEgo
						posn: (proc0_18 293 (gEgo x:) 215) (+ horizon 2)
					)
				else
					(gEgo posn: (proc0_18 125 (gEgo x:) 89) (+ horizon 2))
				)
			)
			(west
				(gEgo posn: 3 (proc0_17 200 (gEgo y:) (+ horizon 2)))
			)
			(south
				(gEgo y: 188)
			)
			(east
				(gEgo
					posn: 317 (proc0_17 185 (proc0_18 98 (gEgo y:) 85) 76)
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(snakeBody priority: 12)
		(gAddToPics add: snakeBody eachElementDo: #init doit:)
		(snakeHead setPri: 12 init: stopUpd:)
		(snakeTongue setPri: 12 init: cel: 2 stopUpd:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(lake1 init:)
		(lake2 init:)
		(= local0 2)
		(if (>= global101 1)
			(wa1 setPri: 0 setCycle: Fwd init: ignoreActors:)
			(wa2 setPri: 0 setCycle: Fwd init: ignoreActors:)
			(wa3 setPri: 0 setCycle: Fwd init: ignoreActors:)
		)
		(self setRegions: 603) ; waterReg
		(if (and (not (IsFlag 2)) (>= global101 1))
			(self setLocales: 611)
		)
	)

	(method (doit &tmp temp0)
		(if (and (not (snakeHead script:)) (>= global101 1))
			(cond
				((and (< (gEgo x:) (snakeHead x:)) (!= local0 2))
					(snakeHead setScript: headLeft)
				)
				((and (>= (gEgo x:) (snakeHead x:)) (!= local0 3))
					(snakeHead setScript: headRight)
				)
				(
					(and
						(> (gEgo distanceTo: snakeHead) 95)
						(!= (snakeTongue cycler:) 0)
					)
					(snakeTongue setCycle: End)
				)
				(
					(and
						(> (gEgo distanceTo: snakeHead) 95)
						(== (snakeTongue cycler:) 0)
					)
					(if (< (Random 1 100) 10)
						(snakeTongue setCycle: End)
					)
				)
				(
					(and
						(<= (gEgo distanceTo: snakeHead) 95)
						(== (snakeTongue cycler:) 0)
						(< (Random 1 100) 35)
					)
					(snakeTongue setCycle: End)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look>')
				(if (Said '[<at,around][/room]')
					(Print 37 0) ; "Large moss-covered trees surround a shallow, swampy lake."
				)
			)
			((Said 'climb,climb/ceder')
				(Print 37 1) ; "Spotting the snake in the treetops you wisely decide that there are better trees to climb than this one."
			)
			((Said 'capture,kill,shoot,get,get,eat,eat/snake')
				(Print 37 2) ; "You'll wind up with a useless dead snake and a guilty conscience."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance snakeBody of PicView
	(properties
		x 178
		y 48
		description {snake}
		view 303
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/snake') (MousedOn self event 3))
				(event claimed: 1)
				(localproc_0)
			)
			((Said 'look,look/tongue')
				(Print 37 3) ; "The snake's small red tongue flicks at the air, tasting your presence in the swamp."
			)
			((Said 'talk,talk,call/snake')
				(Print 37 4) ; "Even if the snake could hear you, it wouldn't have anything to say."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance snakeHead of Prop
	(properties
		x 178
		y 48
		description {snake}
		view 303
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance snakeTongue of Prop
	(properties
		x 175
		y 59
		description {snake}
		view 303
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(localproc_0)
			)
		)
	)
)

(instance wa1 of Prop
	(properties
		x 158
		y 114
		description {ripple}
		sightAngle 180
		closeRangeDist 500
		longRangeDist 500
		shiftClick 0
		view 237
		loop 1
		cycleSpeed 2
	)

	(method (handleEvent))
)

(instance wa2 of Prop
	(properties
		x 126
		y 107
		description {ripple}
		sightAngle 180
		closeRangeDist 500
		longRangeDist 500
		shiftClick 0
		view 237
		loop 1
		cel 1
		cycleSpeed 2
	)

	(method (handleEvent))
)

(instance wa3 of Prop
	(properties
		x 145
		y 134
		description {ripple}
		sightAngle 180
		closeRangeDist 500
		longRangeDist 500
		shiftClick 0
		view 237
		loop 2
		cycleSpeed 2
	)

	(method (handleEvent))
)

(instance headLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 2)
				(snakeTongue setCycle: End self)
			)
			(1
				(snakeHead setCycle: Beg self)
			)
			(2
				(snakeTongue loop: 2 posn: 175 59)
				(self cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance headRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 3)
				(snakeTongue setCycle: End self)
			)
			(1
				(snakeHead setCycle: End self)
			)
			(2
				(snakeTongue loop: 3 posn: 185 58)
				(self cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance lake1 of NewFeature
	(properties
		x 167
		y 110
		noun '/lake,lake,water,swamp'
		nsTop 101
		nsLeft 35
		nsBottom 120
		nsRight 299
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The murky water of this swampy lake looks very uninviting.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 158
		y 138
		noun '/lake,lake,water,swamp'
		nsTop 121
		nsLeft 64
		nsBottom 156
		nsRight 252
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The murky water of this swampy lake looks very uninviting.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 255
		y 101
		noun '/ceder'
		nsTop 51
		nsLeft 222
		nsBottom 152
		nsRight 288
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Large, mossy trees grow around this small, swampy lake.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 160
		y 24
		noun '/ceder'
		nsBottom 50
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Large, mossy trees grow around this small, swampy lake.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 69
		y 101
		noun '/ceder'
		nsTop 51
		nsLeft 28
		nsBottom 151
		nsRight 111
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Large, mossy trees grow around this small, swampy lake.}
	)
)

