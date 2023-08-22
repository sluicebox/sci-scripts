;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)
(use User)

(public
	rm29 0
)

(instance rm29 of Rm
	(properties
		picture 29
		horizon 70
		north 36
		east 30
		south 20
		west 28
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
				(gEgo
					posn:
						(proc0_17 319 (proc0_18 258 (gEgo x:) 148) 89)
						(+ horizon 2)
				)
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 30) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) (+ 2 horizon)))
			)
			(east
				(gEgo posn: 317 (proc0_17 188 (gEgo y:) (+ 2 horizon)))
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(tree8 init:)
		(tree9 init:)
		(tree10 init:)
		(tree11 init:)
		(tree12 init:)
		(tree13 init:)
		(tree14 init:)
		(tree15 init:)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
		(if (and (not (IsFlag 2)) (Random 0 6))
			(self setRegions: 602) ; rgMenace
		)
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
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
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
				(Print 29 0) ; "Gnarled, ancient trees loom in this dark part of the forest."
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 72
		y 162
		noun '/ceder'
		nsTop 152
		nsLeft 34
		nsBottom 173
		nsRight 110
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 71
		y 106
		noun '/ceder'
		nsTop 61
		nsLeft 51
		nsBottom 152
		nsRight 92
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 65
		y 38
		noun '/ceder'
		nsTop 16
		nsLeft 43
		nsBottom 61
		nsRight 87
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 98
		y 25
		noun '/ceder'
		nsTop 18
		nsLeft 86
		nsBottom 33
		nsRight 110
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 22
		y 50
		noun '/ceder'
		nsTop 40
		nsLeft 15
		nsBottom 61
		nsRight 29
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 34
		y 31
		noun '/ceder'
		nsTop 21
		nsLeft 26
		nsBottom 42
		nsRight 42
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 74
		y 7
		noun '/ceder'
		nsTop -2
		nsLeft 60
		nsBottom 16
		nsRight 88
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree8 of NewFeature
	(properties
		x 266
		y 69
		noun '/ceder'
		nsTop 35
		nsLeft 256
		nsBottom 104
		nsRight 276
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree9 of NewFeature
	(properties
		x 260
		y 28
		noun '/ceder'
		nsTop 22
		nsLeft 249
		nsBottom 35
		nsRight 272
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 203
		y 160
		noun '/boulder'
		nsTop 154
		nsLeft 195
		nsBottom 166
		nsRight 211
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Even the rocks in this part of the forest seem more jagged and unfriendly.  Watch your step, they're everywhere!}
	)
)

(instance rock2 of NewFeature
	(properties
		x 220
		y 161
		noun '/boulder'
		nsTop 157
		nsLeft 211
		nsBottom 165
		nsRight 230
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Even the rocks in this part of the forest seem more jagged and unfriendly.  Watch your step, they're everywhere!}
	)
)

(instance rock3 of NewFeature
	(properties
		x 262
		y 166
		noun '/boulder'
		nsTop 161
		nsLeft 230
		nsBottom 171
		nsRight 294
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Even the rocks in this part of the forest seem more jagged and unfriendly.  Watch your step, they're everywhere!}
	)
)

(instance rock4 of NewFeature
	(properties
		x 271
		y 158
		noun '/boulder'
		nsTop 155
		nsLeft 252
		nsBottom 161
		nsRight 290
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Even the rocks in this part of the forest seem more jagged and unfriendly.  Watch your step, they're everywhere!}
	)
)

(instance rock5 of NewFeature
	(properties
		x 272
		y 152
		noun '/boulder'
		nsTop 149
		nsLeft 266
		nsBottom 155
		nsRight 279
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Even the rocks in this part of the forest seem more jagged and unfriendly.  Watch your step, they're everywhere!}
	)
)

(instance tree10 of NewFeature
	(properties
		x 305
		y 37
		noun '/ceder'
		nsTop -1
		nsLeft 292
		nsBottom 75
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree11 of NewFeature
	(properties
		x 226
		y 31
		noun '/ceder'
		nsTop -1
		nsLeft 212
		nsBottom 64
		nsRight 240
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree12 of NewFeature
	(properties
		x 183
		y 33
		noun '/ceder'
		nsLeft 166
		nsBottom 66
		nsRight 201
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree13 of NewFeature
	(properties
		x 177
		y 69
		noun '/ceder'
		nsTop 66
		nsLeft 161
		nsBottom 73
		nsRight 194
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree14 of NewFeature
	(properties
		x 38
		y 47
		noun '/ceder'
		nsTop -1
		nsLeft 23
		nsBottom 96
		nsRight 53
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

(instance tree15 of NewFeature
	(properties
		x 3
		y 90
		noun '/ceder'
		nsTop -2
		nsLeft -1
		nsBottom 183
		nsRight 6
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {In this part of the forest the trees are twisted and misshapen lending an eerie feel to the place.}
	)
)

