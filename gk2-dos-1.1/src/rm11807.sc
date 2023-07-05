;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11807)
(include sci.sh)
(use Main)
(use GK2Ego)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11807 0
)

(instance rm11807 of ExitRoom
	(properties
		modNum 1180
		picture 11807
		south 11811 ; rm11811
	)

	(method (init)
		(switch gPrevRoomNum
			(11811
				(gEgo posn: 331 360 heading: 45)
			)
			(11806
				(gEgo posn: 243 290 heading: 135)
			)
			(11803
				(gEgo posn: 378 284 heading: 225)
			)
			(11808
				(gEgo posn: 463 286 heading: 225)
			)
			(else
				(if (== global138 1)
					(gEgo posn: 163 290 heading: 135)
				else
					(gEgo posn: 378 284 heading: 45)
				)
			)
		)
		(gEgo normalize: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GabeEgo)
			(Palette 1 (= global249 222)) ; PalLoad
		else
			(Palette 1 (= global249 221)) ; PalLoad
		)
		(super init: &rest)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 98
			y: 249
			createPoly: 126 284 71 284 71 214 126 214
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 268
			y: 216
			createPoly: 255 238 255 195 282 195 282 238
		)
		(drain init:)
		(northExit init:)
		(theWestExit init:)
		(theEastExit init:)
	)
)

(instance northExit of ExitFeature
	(properties
		modNum 1180
		approachX 350
		approachY 232
		x 44
		y 196
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 88 358 88 358 284 242 284
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11803)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWestExit of ExitFeature
	(properties
		modNum 1180
		x 44
		y 296
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 6 323 5 69 83 69 83 323 yourself:)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(if (> (gEgo y:) 300)
			(= approachY 130)
		else
			(= approachY 285)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11806)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theEastExit of ExitFeature
	(properties
		modNum 1180
		x 546
		y 193
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 501 318 501 69 591 69 591 318
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(if (> (gEgo y:) 300)
			(= approachY 130)
		else
			(= approachY 285)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11808)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drain of GKFeature
	(properties
		modNum 1180
		nsLeft 306
		nsTop 268
		nsRight 371
		nsBottom 300
		sightAngle 360
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 62) ; Do
				(if (== gEgo GabeEgo)
					(= noun 16)
				else
					(= noun 15)
				)
			)
			((== gEgo GabeEgo)
				(= noun 17)
			)
			(else
				(= noun 18)
			)
		)
		(super doVerb: theVerb)
	)
)

