;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	rm34 0
)

(local
	local0
	[local1 2]
	[local3 2] = [234 226]
	[local5 2] = [230 281]
	[local7 2] = [133 150]
	[local9 2] = [0 3]
)

(instance rm34 of Rm
	(properties
		picture 34
		horizon 47
		north 47
		east 33
		south 31
		west 35
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
		(LoadMany rsVIEW 234 226)
		(super init:)
		(switch gPrevRoomNum
			(north
				(if (< (gEgo x:) 230)
					(gEgo posn: (+ (gEgo x:) 100) (+ horizon 2))
				else
					(gEgo
						posn: (proc0_17 319 (gEgo x:) 297) (+ horizon 2)
					)
				)
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) 68))
			)
			(east
				(if (< (gEgo y:) 140)
					(gEgo posn: 317 (proc0_17 66 (gEgo y:) 49))
				else
					(gEgo posn: 317 187)
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(self setRegions: 608) ; riverReg
		(for ((= local0 0)) (< local0 2) ((++ local0))
			((= [local1 local0] (Clone Ripple))
				view: [local3 local0]
				cycleSpeed: 1
				x: [local5 local0]
				y: [local7 local0]
				setLoop: [local9 local0]
				setPri: 2
				ignoreActors: 1
				description: {ripple}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
		(rock6 init:)
		(rock7 init:)
		(rock8 init:)
		(river1 init:)
		(river2 init:)
		(river3 init:)
		(river4 init:)
		(cliff1 init:)
		(cliff2 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(bush5 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
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
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,grass]')
						(Print 34 0) ; "High cliffs border a wild, raging river."
					)
					((or (Said '<across') (Said '<across/brook,water,brook'))
						(Print 34 1) ; "You notice an enchanting meadow."
					)
					((Said '/clearing')
						(Print 34 2) ; "The meadow on the other side of the river looks very peaceful and enchanting."
					)
				)
			)
		)
	)
)

(instance rock1 of NewFeature
	(properties
		x 38
		y 85
		noun '/boulder'
		nsTop 80
		nsLeft 16
		nsBottom 90
		nsRight 60
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock2 of NewFeature
	(properties
		x 40
		y 96
		noun '/boulder'
		nsTop 90
		nsLeft 5
		nsBottom 102
		nsRight 75
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock3 of NewFeature
	(properties
		x 53
		y 105
		noun '/boulder'
		nsTop 102
		nsLeft 13
		nsBottom 109
		nsRight 94
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock4 of NewFeature
	(properties
		x 67
		y 114
		noun '/boulder'
		nsTop 109
		nsLeft 31
		nsBottom 119
		nsRight 103
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock5 of NewFeature
	(properties
		x 86
		y 123
		noun '/boulder'
		nsTop 119
		nsLeft 63
		nsBottom 127
		nsRight 110
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock6 of NewFeature
	(properties
		x 106
		y 132
		noun '/boulder'
		nsTop 127
		nsLeft 85
		nsBottom 138
		nsRight 128
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock7 of NewFeature
	(properties
		x 177
		y 99
		noun '/boulder'
		nsTop 83
		nsLeft 154
		nsBottom 116
		nsRight 201
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock8 of NewFeature
	(properties
		x 187
		y 127
		noun '/boulder'
		nsTop 116
		nsLeft 165
		nsBottom 139
		nsRight 209
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/boulder')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 34 3) ; "Some of the rocks poke up from the riverbed. These rocks are actually very tall and treacherous!"
			)
		)
	)
)

(instance river1 of NewFeature
	(properties
		x 232
		y 63
		noun '/brook,brook,water'
		nsTop 49
		nsLeft 199
		nsBottom 78
		nsRight 266
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The river is dangerous and powerful.}
	)
)

(instance river2 of NewFeature
	(properties
		x 246
		y 102
		noun '/brook,brook,water'
		nsTop 78
		nsLeft 202
		nsBottom 126
		nsRight 290
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The river is dangerous and powerful.}
	)
)

(instance river3 of NewFeature
	(properties
		x 268
		y 138
		noun '/brook,brook,water'
		nsTop 126
		nsLeft 217
		nsBottom 150
		nsRight 319
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The river is dangerous and powerful.}
	)
)

(instance river4 of NewFeature
	(properties
		x 287
		y 162
		noun '/brook,brook,water'
		nsTop 150
		nsLeft 254
		nsBottom 175
		nsRight 320
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The river is dangerous and powerful.}
	)
)

(instance cliff1 of NewFeature
	(properties
		x 242
		y 39
		noun '/cliff,brook<bank'
		nsTop 23
		nsLeft 213
		nsBottom 56
		nsRight 272
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The banks of the river are tall and steep.  If you fell down, you'd never be able to climb back up again.}
	)
)

(instance cliff2 of NewFeature
	(properties
		x 292
		y 97
		noun '/cliff,brook<bank'
		nsTop 57
		nsLeft 264
		nsBottom 138
		nsRight 320
		description {cliff}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The banks of the river are tall and steep.  If you fell down, you'd never be able to climb back up again.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 15
		y 26
		noun '/ceder'
		nsBottom 52
		nsRight 30
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A few oak trees serenely overlook the turbulent river below.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 89
		y 19
		noun '/ceder'
		nsTop -1
		nsLeft 68
		nsBottom 39
		nsRight 110
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A few oak trees serenely overlook the turbulent river below.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 303
		y 17
		noun '/ceder'
		nsTop -1
		nsLeft 286
		nsBottom 36
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A few oak trees serenely overlook the turbulent river below.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 31
		y 59
		noun '/bush'
		nsTop 51
		nsBottom 67
		nsRight 63
		description {bush1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Low bushes are growing in abundance in the clean Daventry air.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 94
		y 46
		noun '/bush'
		nsTop 40
		nsLeft 66
		nsBottom 53
		nsRight 123
		description {bush2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Low bushes are growing in abundance in the clean Daventry air.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 47
		y 33
		noun '/bush'
		nsTop 25
		nsLeft 27
		nsBottom 42
		nsRight 68
		description {bush3}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Low bushes are growing in abundance in the clean Daventry air.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 178
		y 73
		noun '/bush'
		nsTop 66
		nsLeft 168
		nsBottom 81
		nsRight 188
		description {bush4}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Low bushes are growing in abundance in the clean Daventry air.}
	)
)

(instance bush5 of NewFeature
	(properties
		x 309
		y 41
		noun '/bush'
		nsTop 35
		nsLeft 298
		nsBottom 47
		nsRight 320
		description {bush5}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Low bushes are growing in abundance in the clean Daventry air.}
	)
)

