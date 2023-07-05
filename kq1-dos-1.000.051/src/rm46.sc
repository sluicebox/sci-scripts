;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)
(use User)

(public
	rm46 0
)

(instance rm46 of Rm
	(properties
		picture 46
		horizon 52
		north 3
		east 47
		south 35
		west 45
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
				(gEgo posn: (proc0_17 155 (gEgo x:) 0) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 103) 188)
			)
			(west
				(gEgo
					posn: 3 (proc0_17 177 (proc0_18 129 (gEgo y:) 114) 0)
				)
			)
			(east
				(gEgo posn: 317 (proc0_18 182 (gEgo y:) 160))
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (and (not (IsFlag 2)) (Random 0 3))
			(self setRegions: 602) ; rgMenace
		)
		(stump1 init:)
		(stump2 init:)
		(smalltree1 init:)
		(smalltree2 init:)
		(smalltree3 init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(tree1 init:)
		(tree2 init:)
		(rock4 init:)
		(rocks1 init:)
		(rocks2 init:)
		(rocks3 init:)
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
			(
				(and
					(Said 'look,look>')
					(Said '[<at,around][/room,ceder,clearing]')
				)
				(Print 46 0) ; "You are in a gloomy forest clearing."
			)
		)
	)
)

(instance stump1 of NewFeature
	(properties
		x 21
		y 161
		noun '/stump'
		nsTop 134
		nsBottom 188
		nsRight 42
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a moldering old stump here, rotting to pieces.}
	)
)

(instance stump2 of NewFeature
	(properties
		x 59
		y 161
		noun '/stump'
		nsTop 150
		nsLeft 41
		nsBottom 173
		nsRight 77
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a moldering old stump here, rotting to pieces.}
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 43
		y 79
		noun '/ceder[<little]'
		nsTop 66
		nsBottom 92
		nsRight 87
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees here are stunted and twisted.  They give you the heebie-jeebies.}
	)
)

(instance smalltree2 of NewFeature
	(properties
		x 18
		y 103
		noun '/ceder[<little]'
		nsTop 92
		nsLeft 12
		nsBottom 115
		nsRight 24
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees here are stunted and twisted.  They give you the heebie-jeebies.}
	)
)

(instance smalltree3 of NewFeature
	(properties
		x 79
		y 110
		noun '/ceder[<little]'
		nsTop 101
		nsLeft 55
		nsBottom 120
		nsRight 104
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The trees here are stunted and twisted.  They give you the heebie-jeebies.}
	)
)

(instance rocks1 of NewFeature
	(properties
		x 181
		y 114
		noun '/boulder'
		nsTop 104
		nsLeft 134
		nsBottom 124
		nsRight 228
		description {rocks}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are numerous small rocks and boulders in this part of the forest.}
	)
)

(instance rocks2 of NewFeature
	(properties
		x 263
		y 169
		noun '/boulder'
		nsTop 157
		nsLeft 215
		nsBottom 181
		nsRight 311
		description {rocks}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are numerous small rocks and boulders in this part of the forest.}
	)
)

(instance rocks3 of NewFeature
	(properties
		x 271
		y 153
		noun '/boulder'
		nsTop 150
		nsLeft 244
		nsBottom 157
		nsRight 298
		description {rocks}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are numerous small rocks and boulders in this part of the forest.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 47
		y 40
		noun '/bush'
		nsTop 25
		nsLeft 27
		nsBottom 56
		nsRight 67
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Even in this slightly dismal part of the forest, the bushes grow well in the bright Daventry sun.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 84
		y 45
		noun '/bush'
		nsTop 36
		nsLeft 67
		nsBottom 55
		nsRight 101
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Even in this slightly dismal part of the forest, the bushes grow well in the bright Daventry sun.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 299
		y 40
		noun '/bush'
		nsTop 19
		nsLeft 279
		nsBottom 62
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Even in this slightly dismal part of the forest, the bushes grow well in the bright Daventry sun.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 260
		y 54
		noun '/bush'
		nsTop 44
		nsLeft 242
		nsBottom 65
		nsRight 279
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Even in this slightly dismal part of the forest, the bushes grow well in the bright Daventry sun.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 13
		y 17
		noun '/ceder'
		nsTop -2
		nsBottom 36
		nsRight 26
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Several unimpressive little trees have grown in the sandy soil of the forest.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 172
		y 18
		noun '/ceder'
		nsTop -2
		nsLeft 26
		nsBottom 39
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Several unimpressive little trees have grown in the sandy soil of the forest.}
	)
)

(instance rock4 of NewFeature
	(properties
		x 203
		y 58
		noun '/boulder'
		nsTop 47
		nsLeft 163
		nsBottom 69
		nsRight 243
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are numerous small rocks and boulders in this part of the forest.}
	)
)

