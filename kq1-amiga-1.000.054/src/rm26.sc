;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	rm26 0
)

(local
	local0
	[local1 2]
	[local3 2] = [114 9]
	[local5 2] = [71 112]
	[local7 2] = [0 1]
)

(instance rm26 of Rm
	(properties
		picture 26
		horizon 43
		north 39
		east 27
		south 23
		west 25
	)

	(method (init)
		(Load rsVIEW 226)
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
				(if (< (gEgo x:) 93)
					(gEgo posn: 63 (+ horizon 2))
				else
					(gEgo posn: (proc0_17 319 (gEgo x:) 213) 57)
				)
			)
			(south
				(gEgo posn: (proc0_18 179 (gEgo x:) 9) 188)
			)
			(west
				(if (< (gEgo y:) 100)
					(gEgo posn: 3 (proc0_17 61 (gEgo y:) (+ horizon 2)))
				else
					(gEgo posn: 3 (proc0_17 188 (gEgo y:) 128))
				)
			)
			(east
				(gEgo posn: 317 (proc0_17 188 (gEgo y:) 54))
			)
			(else
				(gEgo posn: 163 188)
			)
		)
		(gEgo init:)
		(proc0_1)
		(self setRegions: 608) ; riverReg
		(for ((= local0 0)) (< local0 2) ((++ local0))
			((= [local1 local0] (Clone Ripple))
				cycleSpeed: 1
				view: 226
				x: [local3 local0]
				y: [local5 local0]
				setLoop: [local7 local0]
				ignoreActors: 1
				description: {ripple}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(bank1 init:)
		(bank2 init:)
		(bank3 init:)
		(bank4 init:)
		(bank5 init:)
		(river1 init:)
		(river2 init:)
		(river3 init:)
		(river4 init:)
		(river5 init:)
		(river6 init:)
		(bigtree1 init:)
		(bigtree2 init:)
		(smalltree1 init:)
		(smalltree2 init:)
		(smalltree3 init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
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
				(self newRoom: temp0)
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
					(Said '[<at,around][/room,clearing,bury,vegetation,grass]')
				)
				(Print 26 0) ; "A lovely tree overlooks a bend in the river."
			)
		)
	)
)

(instance bank1 of NewFeature
	(properties
		x 19
		y 72
		noun '/bank'
		nsTop 64
		nsBottom 81
		nsRight 38
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The steep banks are high above the river.}
	)
)

(instance bank2 of NewFeature
	(properties
		x 52
		y 66
		noun '/bank'
		nsTop 58
		nsLeft 38
		nsBottom 75
		nsRight 67
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The steep banks are high above the river.}
	)
)

(instance bank3 of NewFeature
	(properties
		x 74
		y 64
		noun '/bank'
		nsTop 55
		nsLeft 66
		nsBottom 73
		nsRight 82
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The steep banks are high above the river.}
	)
)

(instance bank4 of NewFeature
	(properties
		x 91
		y 56
		noun '/bank'
		nsTop 51
		nsLeft 82
		nsBottom 62
		nsRight 101
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The steep banks are high above the river.}
	)
)

(instance bank5 of NewFeature
	(properties
		x 106
		y 49
		noun '/bank'
		nsTop 45
		nsLeft 101
		nsBottom 54
		nsRight 111
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The steep banks are high above the river.}
	)
)

(instance river1 of NewFeature
	(properties
		x 12
		y 104
		noun '/bank'
		nsTop 85
		nsBottom 123
		nsRight 25
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance river2 of NewFeature
	(properties
		x 40
		y 97
		noun '/brook,brook,water'
		nsTop 82
		nsLeft 23
		nsBottom 113
		nsRight 58
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance river3 of NewFeature
	(properties
		x 66
		y 89
		noun '/brook,brook,water'
		nsTop 75
		nsLeft 57
		nsBottom 104
		nsRight 75
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance river4 of NewFeature
	(properties
		x 84
		y 84
		noun '/brook,brook,water'
		nsTop 73
		nsLeft 75
		nsBottom 96
		nsRight 93
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance river5 of NewFeature
	(properties
		x 102
		y 76
		noun '/brook,brook,water'
		nsTop 63
		nsLeft 91
		nsBottom 89
		nsRight 114
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance river6 of NewFeature
	(properties
		x 121
		y 53
		noun '/brook,brook,water'
		nsTop 45
		nsLeft 111
		nsBottom 61
		nsRight 131
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The stream appears placid enough, but appearances can be deceiving.}
	)
)

(instance bigtree1 of NewFeature
	(properties
		x 256
		y 23
		noun '/ceder[<big]'
		nsLeft 194
		nsBottom 46
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This appears to be an oversized Dwarf Maple tree.}
	)
)

(instance bigtree2 of NewFeature
	(properties
		x 272
		y 77
		noun '/ceder[<big]'
		nsTop 46
		nsLeft 260
		nsBottom 108
		nsRight 284
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This appears to be an oversized Dwarf Maple tree.}
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 65
		y 160
		noun '/ceder[<little]'
		nsTop 152
		nsLeft 42
		nsBottom 168
		nsRight 89
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the smallest Giant Redwood tree you've ever seen!}
	)
)

(instance smalltree2 of NewFeature
	(properties
		x 99
		y 146
		noun '/ceder[<little]'
		nsTop 151
		nsLeft 70
		nsBottom 140
		nsRight 128
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the smallest Giant Redwood tree you've ever seen!}
	)
)

(instance smalltree3 of NewFeature
	(properties
		x 117
		y 158
		noun '/ceder[<little]'
		nsTop 151
		nsLeft 89
		nsBottom 165
		nsRight 145
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is the smallest Giant Redwood tree you've ever seen!}
	)
)

(instance bush1 of NewFeature
	(properties
		x 246
		y 124
		noun '/bush'
		nsTop 116
		nsLeft 220
		nsBottom 133
		nsRight 273
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the countless bushes and shrubs scattered throughout the beautiful Daventry countryside.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 280
		y 115
		noun '/bush'
		nsTop 109
		nsLeft 260
		nsBottom 121
		nsRight 300
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the countless bushes and shrubs scattered throughout the beautiful Daventry countryside.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 172
		y 87
		noun '/bush'
		nsTop 80
		nsLeft 156
		nsBottom 94
		nsRight 188
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the countless bushes and shrubs scattered throughout the beautiful Daventry countryside.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 178
		y 59
		noun '/bush'
		nsTop 50
		nsLeft 162
		nsBottom 69
		nsRight 194
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is just one of the countless bushes and shrubs scattered throughout the beautiful Daventry countryside.}
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/brook,boulder,water')
				(Print 26 1) ; "The turbulent river surges over and around the rocks, down the bend to the north."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 26 1) ; "The turbulent river surges over and around the rocks, down the bend to the north."
			)
		)
	)
)

