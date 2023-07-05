;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm35 0
)

(instance rm35 of Rm
	(properties
		picture 35
		north 46
		east 34
		south 30
		west 36
		picAngle 60
	)

	(method (init)
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
				(gEgo posn: (proc0_17 190 (gEgo x:) 109) 60)
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo
					posn: 3 (proc0_17 188 (proc0_18 175 (gEgo y:) 166) 75)
				)
			)
			(else
				(gEgo posn: 317 (proc0_17 175 (gEgo y:) 69))
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (and (not (IsFlag 2)) (Random 0 3))
			(self setRegions: 602) ; rgMenace
		)
		(smalltree1 init:)
		(smalltree2 init:)
		(smalltree3 init:)
		(smalltree4 init:)
		(smalltree5 init:)
		(smalltree6 init:)
		(smalltree7 init:)
		(smalltree8 init:)
		(smalltree9 init:)
		(smalltree10 init:)
		(smalltree11 init:)
		(plant1 init:)
		(plant2 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(gMenace script:)
					(or (!= (gMenace script:) (ScriptID 602 1)) global103) ; startScript
				)
				((gMenace script:) doit:)
			)
			(
				(and
					(& (gEgo onControl: 1) $1000)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setScript: climbHill)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(FadeBackSound)
				(self newRoom: temp0)
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
			((Said 'get,get,move,pull/boulder')
				(Print 35 0) ; "No way. Who knows what squirmy, slimy creatures are lurking underneath?"
			)
			(
				(or
					(Said 'look,look[<!*]/boulder')
					(proc0_14 event 121 114 309 126)
					(proc0_14 event 141 106 301 114)
					(proc0_14 event 177 96 289 106)
					(proc0_14 event 192 87 279 96)
					(proc0_14 event 206 77 254 87)
				)
				(Print 35 1) ; "There are craggy rocks scattered around the forest. You hate to think of what's underneath them."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,ceder,clearing]')
						(Print 35 2) ; "You are in an eerie, desolate part of the forest."
					)
					((Said '/ceder')
						(Print 35 3) ; "The trees are bent and stunted, making the forest look even gloomier."
					)
					((Said '<below/boulder')
						(Print 35 0) ; "No way. Who knows what squirmy, slimy creatures are lurking underneath?"
					)
				)
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
				(SetFlag 44)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setLoop: 3
					setPri: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(1
				(proc0_1)
				(HandsOn)
				(ClearFlag 44)
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 24
		y 117
		noun '/ceder[<little]'
		nsTop 100
		nsBottom 135
		nsRight 49
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree2 of NewFeature
	(properties
		x 71
		y 122
		noun '/ceder[<little]'
		nsTop 105
		nsLeft 48
		nsBottom 140
		nsRight 94
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree3 of NewFeature
	(properties
		x 100
		y 127
		noun '/ceder[<little]'
		nsTop 118
		nsLeft 94
		nsBottom 136
		nsRight 107
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree4 of NewFeature
	(properties
		x 34
		y 152
		noun '/ceder[<little]'
		nsTop 137
		nsLeft 29
		nsBottom 168
		nsRight 39
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree5 of NewFeature
	(properties
		x 35
		y 15
		noun '/ceder[<little]'
		nsTop 11
		nsLeft 3
		nsBottom 20
		nsRight 67
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree6 of NewFeature
	(properties
		x 80
		y 20
		noun '/ceder[<little]'
		nsTop 14
		nsLeft 67
		nsBottom 27
		nsRight 93
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree7 of NewFeature
	(properties
		x 34
		y 32
		noun '/ceder[<little]'
		nsTop 28
		nsLeft 10
		nsBottom 37
		nsRight 58
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree8 of NewFeature
	(properties
		x 50
		y 47
		noun '/ceder[<little]'
		nsTop 42
		nsLeft 12
		nsBottom 51
		nsRight 89
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree9 of NewFeature
	(properties
		x 225
		y 52
		noun '/ceder[<little]'
		nsTop 42
		nsLeft 198
		nsBottom 63
		nsRight 252
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree10 of NewFeature
	(properties
		x 251
		y 34
		noun '/ceder[<little]'
		nsTop 25
		nsLeft 227
		nsBottom 43
		nsRight 275
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance smalltree11 of NewFeature
	(properties
		x 235
		y 71
		noun '/ceder[<little]'
		nsTop 66
		nsLeft 185
		nsBottom 76
		nsRight 286
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These small twisted trees make the area seem very strange.}
	)
)

(instance plant1 of NewFeature
	(properties
		x 284
		y 157
		noun '/bury,bush'
		nsTop 135
		nsLeft 266
		nsBottom 180
		nsRight 303
		description {plant}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The plants don't seem to grow very well in this part of the forest.}
	)
)

(instance plant2 of NewFeature
	(properties
		x 246
		y 173
		noun '/bury,bush'
		nsTop 167
		nsLeft 228
		nsBottom 179
		nsRight 265
		description {plant}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The plants don't seem to grow very well in this part of the forest.}
	)
)

