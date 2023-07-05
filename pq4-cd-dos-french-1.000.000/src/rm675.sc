;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 675)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm675 0
)

(local
	local0
)

(instance rm675 of Room
	(properties
		noun 7
		picture 675
	)

	(method (init)
		(PalVary 8 676) ; PalVaryNewSource
		(= local0 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 148 21 152 198 74 187 74
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			posn: 17 142
			setScaler: Scaler 65 33 139 82
			setHeading: 45
			init:
			normalize: 0
		)
		(if (and (== gDay 6) (not global144))
			(gGlobalSound0 number: 650 loop: -1 play:)
			(woman init: signal: (| (woman signal:) $4000))
			(gGame handsOff:)
			(self setScript: enterScript)
		else
			(gGlobalSound0 number: 425 loop: -1 play:)
			(gGame handsOn:)
		)
		(light1 init:)
		(light2 init:)
		(light3 init:)
		(light4 init:)
		(light5 init:)
		(light6 init:)
		(booth init:)
		(seats init:)
		(door init:)
	)

	(method (dispose)
		(if (== local0 1)
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)

	(method (drawPic)
		(if local0
			(PalVary 8 676) ; PalVaryNewSource
		)
		(super drawPic: &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== local0 1) (not (gEgo inRect: 0 50 80 152)))
				(= local0 0)
				(PalVary 3) ; PalVaryKill
			)
			((and (== local0 0) (gEgo inRect: 0 50 80 152))
				(= local0 1)
				(PalVary 8 676) ; PalVaryNewSource
			)
			((self script:) 0)
			((> (gEgo y:) 145)
				(gCurRoom newRoom: 680)
			)
			((gEgo inRect: 188 65 198 81)
				(if (and (not (gPqFlags test: 135)) (== gDay 6))
					(= global144 1)
				)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 26 139 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance woman of Prop
	(properties
		noun 2
		x 86
		y 119
		priority 155
		fixPriority 1
		view 673
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager
					say:
						2
						2
						(if (gEgo inRect: 42 120 82 140) 1 else 2)
						0
						self
				)
			)
			(4 ; Do
				(gCurRoom setScript: doWomanScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doWomanScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 62 132 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gEgo z: 1000)
				(altEgo
					setScaler: Scaler 65 33 139 82
					init:
					signal: (| (altEgo signal:) $4800)
					setCycle: CT 4 1 self
				)
			)
			(4
				(altEgo setCycle: CT 3 -1 self)
			)
			(5
				(altEgo cel: 4)
				(= ticks 20)
			)
			(6
				(altEgo cel: 3)
				(= ticks 20)
			)
			(7
				(altEgo cel: 4)
				(= ticks 20)
			)
			(8
				(altEgo setCycle: Beg self)
			)
			(9
				(gEgo z: 0)
				(altEgo dispose:)
				(= cycles 2)
			)
			(10
				(gMessager say: 2 4 3 0 self) ; "Ma'am? Ma'am? Can you hear me? I'm a police officer... Ma'am?"
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance altEgo of Actor
	(properties
		x 62
		y 132
		priority 155
		fixPriority 1
		view 9030
	)
)

(instance light1 of Feature
	(properties
		noun 1
		nsLeft 23
		nsTop 11
		nsRight 33
		nsBottom 37
		sightAngle 40
		x 28
		y 24
	)
)

(instance light2 of Feature
	(properties
		noun 1
		nsLeft 90
		nsTop 27
		nsRight 108
		nsBottom 44
		sightAngle 40
		x 99
		y 35
	)

	(method (doVerb theVerb)
		(light1 doVerb: theVerb)
	)
)

(instance light3 of Feature
	(properties
		noun 1
		nsLeft 142
		nsTop 35
		nsRight 148
		nsBottom 49
		sightAngle 40
		x 145
		y 42
	)

	(method (doVerb theVerb)
		(light1 doVerb: theVerb)
	)
)

(instance light4 of Feature
	(properties
		noun 1
		nsLeft 171
		nsTop 40
		nsRight 178
		nsBottom 51
		sightAngle 40
		x 174
		y 45
	)

	(method (doVerb theVerb)
		(light1 doVerb: theVerb)
	)
)

(instance light5 of Feature
	(properties
		noun 1
		nsLeft 223
		nsRight 238
		nsBottom 8
		sightAngle 40
		x 230
		y 4
	)

	(method (doVerb theVerb)
		(light1 doVerb: theVerb)
	)
)

(instance light6 of Feature
	(properties
		noun 1
		nsLeft 292
		nsTop 32
		nsRight 319
		nsBottom 47
		sightAngle 40
		x 305
		y 39
	)

	(method (doVerb theVerb)
		(light1 doVerb: theVerb)
	)
)

(instance door of Feature
	(properties
		noun 5
		nsLeft 209
		nsTop 46
		nsRight 227
		nsBottom 69
		sightAngle 40
		x 218
		y 57
	)
)

(instance booth of Feature
	(properties
		noun 4
		nsLeft 194
		nsTop 23
		nsRight 264
		nsBottom 34
		sightAngle 40
		x 229
		y 28
	)
)

(instance seats of Feature
	(properties
		noun 3
		sightAngle 40
		x 235
		y 71
	)

	(method (init)
		(self createPoly: 194 70 279 70 319 99 319 149 88 149 62 111)
		(super init:)
	)
)

