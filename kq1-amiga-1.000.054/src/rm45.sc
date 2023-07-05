;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use Actor)

(public
	rm45 0
)

(instance rm45 of Rm
	(properties
		picture 45
		horizon 83
		north 4
		east 46
		south 36
		west 44
	)

	(method (init)
		(Load rsVIEW 245)
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
				(gEgo posn: (proc0_18 236 (gEgo x:) 203) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo
					posn:
						3
						(proc0_17
							188
							(proc0_18 160 (gEgo y:) 100)
							(+ horizon 2)
						)
				)
			)
			(else
				(gEgo posn: 317 (proc0_17 188 (gEgo y:) (+ horizon 2)))
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (IsFlag 2)
			(self setRegions: 600) ; rgGoat
		)
		(smoke init: setPri: 11 setCycle: Fwd)
		(stump init:)
		(chimney1 init:)
		(chimney2 init:)
		(house1 init:)
		(house2 init:)
		(house3 init:)
		(log1 init:)
		(log2 init:)
		(log3 init:)
		(log4 init:)
		(pinetree1 init:)
		(pinetree2 init:)
		(tree1 init:)
		(tree2 init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'talk,talk/man,woman')
				(if (gEgo inRect: 32 152 92 167)
					(Print 45 0) ; "You need to go inside to do that."
				else
					(Print 45 1) ; "You can't do that now."
				)
			)
			((Said 'bend/window')
				(if (gEgo inRect: 32 152 92 167)
					(Print 45 2) ; "There isn't a glass pane in this window."
				else
					(Print 45 3) ; "You are not close enough."
				)
			)
			((Said 'climb,climb/window')
				(if (gEgo inRect: 32 152 92 167)
					(Print 45 4) ; "You should really try to find the door."
				else
					(Print 45 3) ; "You are not close enough."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(Print 45 5) ; "You see the back of the old tumbledown cottage, badly in need of repair."
					)
					((Said '/board,board')
						(Print 45 6) ; "A patchwork of old boards keeps the house together."
					)
					((Said '/man,woman')
						(if (gEgo inRect: 32 152 92 167)
							(Print 45 7) ; "Perhaps you should go inside the house for a better look."
						else
							(Print 45 8) ; "You could get a much better view if you were a little bit closer."
						)
					)
					(
						(or
							(Said '<in[/window,building,building]')
							(Said '<through/window')
						)
						(cond
							(
								(and
									(gEgo inRect: 32 152 92 167)
									(not (IsFlag 113))
								)
								(Print 45 9) ; "When you look in the window, you see a poor starving woodcutter and his wife."
							)
							(
								(and
									(gEgo inRect: 32 152 92 167)
									(IsFlag 113)
								)
								(Print 45 10) ; "You see the woodcutter feeding his poor wife. Some of the color seems to have come back into her cheeks."
							)
							(else
								(Print 45 8) ; "You could get a much better view if you were a little bit closer."
							)
						)
					)
					((or (Said '/window') (proc0_14 event 46 109 63 127))
						(Print 45 11) ; "There is a window on the back of the house."
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 86
		y 65
		view 245
		cycleSpeed 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/smoke') (MousedOn self event 3))
				(Print 45 12) ; "There might be someone home."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance stump of NewFeature
	(properties
		x 190
		y 150
		noun '/stump'
		nsTop 143
		nsLeft 181
		nsBottom 157
		nsRight 199
		description {stump}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The tree was cut from this stump long ago.}
	)
)

(instance chimney1 of NewFeature
	(properties
		x 84
		y 73
		noun '/chimney'
		nsTop 63
		nsLeft 76
		nsBottom 83
		nsRight 92
		description {chimney}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The chimney seems to be the only part of the cottage that doesn't need repairing.}
	)
)

(instance chimney2 of NewFeature
	(properties
		x 93
		y 131
		noun '/chimney'
		nsTop 108
		nsLeft 86
		nsBottom 155
		nsRight 100
		description {chimney}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The chimney seems to be the only part of the cottage that doesn't need repairing.}
	)
)

(instance house1 of NewFeature
	(properties
		x 37
		y 106
		noun '[<at,toward]/building,building'
		nsTop 59
		nsBottom 153
		nsRight 74
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This old cottage is sagging and in great need of repair.}
	)
)

(instance house2 of NewFeature
	(properties
		x 79
		y 117
		noun '[<at,toward]/building,building'
		nsTop 83
		nsLeft 73
		nsBottom 151
		nsRight 85
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This old cottage is sagging and in great need of repair.}
	)
)

(instance house3 of NewFeature
	(properties
		x 92
		y 100
		noun '[<at,toward]/building,building'
		nsTop 93
		nsLeft 84
		nsBottom 108
		nsRight 101
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This old cottage is sagging and in great need of repair.}
	)
)

(instance log1 of NewFeature
	(properties
		x 157
		y 90
		noun '/branch'
		nsTop 83
		nsLeft 148
		nsBottom 97
		nsRight 166
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This log, felled long ago, awaits the woodcutter's fire.}
	)
)

(instance log2 of NewFeature
	(properties
		x 176
		y 96
		noun '/branch'
		nsTop 89
		nsLeft 165
		nsBottom 104
		nsRight 187
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This log, felled long ago, awaits the woodcutter's fire.}
	)
)

(instance log3 of NewFeature
	(properties
		x 201
		y 103
		noun '/branch'
		nsTop 95
		nsLeft 187
		nsBottom 111
		nsRight 216
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This log, felled long ago, awaits the woodcutter's fire.}
	)
)

(instance log4 of NewFeature
	(properties
		x 229
		y 109
		noun '/branch'
		nsTop 102
		nsLeft 216
		nsBottom 117
		nsRight 243
		description {log}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This log, felled long ago, awaits the woodcutter's fire.}
	)
)

(instance pinetree1 of NewFeature
	(properties
		x 223
		y 83
		noun '/ceder[<pine]'
		nsTop 64
		nsLeft 192
		nsBottom 103
		nsRight 255
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This beautiful pine tree adorns the woodcutter's back yard.}
	)
)

(instance pinetree2 of NewFeature
	(properties
		x 221
		y 49
		noun '/ceder[<pine]'
		nsTop 35
		nsLeft 205
		nsBottom 64
		nsRight 237
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This beautiful pine tree adorns the woodcutter's back yard.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 43
		y 28
		noun '/ceder'
		nsTop -2
		nsBottom 59
		nsRight 87
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some large trees still overhang the woodcutter's house.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 116
		y 20
		noun '/ceder'
		nsLeft 88
		nsBottom 41
		nsRight 144
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some large trees still overhang the woodcutter's house.}
	)
)

