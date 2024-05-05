;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
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
	rm42 0
)

(local
	local0
	[local1 3]
	[local4 3] = [241 241 226]
	[local7 3] = [249 63 51]
	[local10 3] = [134 142 180]
	[local13 3] = [3 3 2]
)

(instance rm42 of Rm
	(properties
		picture 42
		horizon 44
		north 7
		east 43
		south 39
		west 41
	)

	(method (init)
		(LoadMany rsVIEW 14 241 226)
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
				(gEgo posn: (proc0_17 264 (gEgo x:) 0) (+ horizon 2))
			)
			(south
				(if (< (gEgo x:) 60)
					(gEgo posn: 10 176)
				else
					(gEgo y: 188)
				)
			)
			(west
				(if (< (gEgo y:) 148)
					(gEgo posn: 3 (proc0_17 103 (gEgo y:) (+ horizon 2)))
				else
					(gEgo posn: 10 170)
				)
			)
			(east
				(if (and global130 (<= (gEgo y:) 119))
					(gEgo
						posn: 317 (proc0_17 119 (gEgo y:) (+ horizon 2))
					)
				else
					(gEgo x: 315)
				)
			)
			(else
				(gEgo posn: 142 76)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(for ((= local0 0)) (< local0 3) ((++ local0))
			((= [local1 local0] (Clone Ripple))
				view: [local4 local0]
				x: [local7 local0]
				y: [local10 local0]
				setLoop: [local13 local0]
				ignoreActors: 1
				description: {ripple}
				setPri: 1
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(self setRegions: 608) ; riverReg
		(self setRegions: 612) ; water42Reg
		(bridge1 init:)
		(bridge2 init:)
		(bridge3 init:)
		(bridge4 init:)
		(bush1 init:)
		(bush2 init:)
		(river1 init:)
		(river2 init:)
		(river3 init:)
		(river4 init:)
		(river5 init:)
		(lake1 init:)
		(bank1 init:)
		(pinetree1 init:)
		(pinetree2 init:)
		(pinetree3 init:)
		(oaktree1 init:)
		(oaktree2 init:)
		(oaktree3 init:)
		(oaktree4 init:)
	)

	(method (doit &tmp temp0)
		(cond
			((and script (or (not global130) (== global130 6)))
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
			((and script global130)
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
			((Said 'climb,climb')
				(if global130
					(Print 42 0) ; "You can just walk out of the river."
				else
					(event claimed: 0)
				)
			)
			((Said 'swim')
				(if (& (gEgo onControl: 1) $0200)
					(Print 42 1) ; "The swift current is making it impossible to swim."
				else
					(event claimed: 0)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 42 2) ; "Off to one side is a clear blue lake surrounded by a pretty meadow. A swift river flows into the lake."
					)
					((Said '/clearing')
						(Print 42 3) ; "The pretty meadow surrounds the clear blue lake."
					)
					((Said '/water')
						(if (gEgo inRect: 165 44 312 116)
							(Print 42 4) ; "The clear blue lake is surrounded by a pretty meadow."
						else
							(Print 42 5) ; "The river gets to be rather rough around these parts."
						)
					)
					((Said '<below,below/bridge')
						(Print 42 6) ; "You glance under the old bridge, but see nothing unusual."
					)
				)
			)
		)
	)
)

(instance river1 of NewFeature
	(properties
		x 167
		y 138
		noun '/brook,brook'
		nsTop 121
		nsLeft 18
		nsBottom 156
		nsRight 317
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The river gets to be rather rough around these parts.}
	)
)

(instance river2 of NewFeature
	(properties
		x 93
		y 161
		noun '/brook,brook'
		nsTop 156
		nsLeft 68
		nsBottom 166
		nsRight 119
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The river gets to be rather rough around these parts.}
	)
)

(instance river3 of NewFeature
	(properties
		x 80
		y 173
		noun '/brook,brook'
		nsTop 167
		nsLeft 61
		nsBottom 179
		nsRight 99
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The river gets to be rather rough around these parts.}
	)
)

(instance river4 of NewFeature
	(properties
		x 62
		y 180
		noun '/brook,brook'
		nsTop 177
		nsLeft 43
		nsBottom 184
		nsRight 81
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The river gets to be rather rough around these parts.}
	)
)

(instance river5 of NewFeature
	(properties
		x 45
		y 186
		noun '/brook,brook'
		nsTop 184
		nsLeft 24
		nsBottom 189
		nsRight 66
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The river gets to be rather rough around these parts.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 5
		y 112
		noun '/bush'
		nsTop 104
		nsBottom 121
		nsRight 11
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You see lush plants and bushes throughout the kingdom of Daventry.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 12
		y 142
		noun '/bush'
		nsTop 122
		nsBottom 162
		nsRight 25
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You see lush plants and bushes throughout the kingdom of Daventry.}
	)
)

(instance lake1 of NewFeature
	(properties
		x 307
		y 88
		noun '/lake,lake'
		nsTop 65
		nsLeft 295
		nsBottom 111
		nsRight 319
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The clear blue lake is surrounded by a pretty meadow.}
	)
)

(instance bridge1 of NewFeature
	(properties
		x 157
		y 108
		noun '/bridge,crossing'
		nsTop 95
		nsLeft 112
		nsBottom 121
		nsRight 203
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {It is an old stone bridge, worn smooth by the ravages of weather and time.}
	)
)

(instance bridge2 of NewFeature
	(properties
		x 180
		y 139
		noun '/bridge,crossing'
		nsTop 121
		nsLeft 133
		nsBottom 157
		nsRight 228
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {It is an old stone bridge, worn smooth by the ravages of weather and time.}
	)
)

(instance bank1 of NewFeature
	(properties
		x 153
		y 112
		noun '/bank[<brook]'
		nsTop 107
		nsLeft 12
		nsBottom 118
		nsRight 294
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These rocky banks are damp and slippery.__Be careful not to come too close!}
	)
)

(instance bridge3 of NewFeature
	(properties
		x 115
		y 88
		noun '/bridge,crossing'
		nsTop 82
		nsLeft 107
		nsBottom 95
		nsRight 123
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {It is an old stone bridge, worn smooth by the ravages of weather and time.}
	)
)

(instance bridge4 of NewFeature
	(properties
		x 175
		y 89
		noun '/bridge,crossing'
		nsTop 83
		nsLeft 162
		nsBottom 95
		nsRight 189
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {It is an old stone bridge, worn smooth by the ravages of weather and time.}
	)
)

(instance oaktree1 of NewFeature
	(properties
		x 73
		y 7
		noun '/ceder[<oak]'
		nsLeft 3
		nsBottom 14
		nsRight 143
		description {oak tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A stand of lovely golden oaks line the riverbank.}
	)
)

(instance oaktree2 of NewFeature
	(properties
		x 70
		y 43
		noun '/ceder[<oak]'
		nsTop 14
		nsLeft 60
		nsBottom 72
		nsRight 81
		description {oak tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A stand of lovely golden oaks line the riverbank.}
	)
)

(instance pinetree1 of NewFeature
	(properties
		x 238
		y 71
		noun '/ceder[<pine]'
		nsTop 45
		nsLeft 212
		nsBottom 98
		nsRight 265
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a beautiful pine tree by the clear blue lake.}
	)
)

(instance pinetree2 of NewFeature
	(properties
		x 239
		y 35
		noun '/ceder[<pine]'
		nsTop 27
		nsLeft 226
		nsBottom 44
		nsRight 253
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a beautiful pine tree by the clear blue lake.}
	)
)

(instance pinetree3 of NewFeature
	(properties
		x 239
		y 21
		noun '/ceder[<pine]'
		nsTop 16
		nsLeft 232
		nsBottom 27
		nsRight 246
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There is a beautiful pine tree by the clear blue lake.}
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
				(Print 42 7) ; "There are some large rocks jutting out of the river here."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 42 7) ; "There are some large rocks jutting out of the river here."
			)
		)
	)
)

(instance oaktree3 of NewFeature
	(properties
		x 136
		y 31
		noun '/ceder[<oak]'
		nsLeft 121
		nsBottom 62
		nsRight 151
		description {oaktree2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A stand of lovely golden oaks line the riverbank.}
	)
)

(instance oaktree4 of NewFeature
	(properties
		x 188
		y 35
		noun '/ceder[<oak]'
		nsLeft 177
		nsBottom 70
		nsRight 199
		description {oaktree3}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {A stand of lovely golden oaks line the riverbank.}
	)
)

