;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11806)
(include sci.sh)
(use Main)
(use GK2Ego)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11806 0
)

(instance rm11806 of ExitRoom
	(properties
		modNum 1180
		picture 11806
		south 11810 ; rm11810
	)

	(method (init)
		(switch gPrevRoomNum
			(11810
				(gEgo posn: 331 360 heading: 45)
			)
			(11805
				(gEgo posn: 243 290 heading: 135)
			)
			(11807
				(gEgo posn: 463 286 heading: 225)
			)
			(11802
				(gEgo posn: 378 284 heading: 225)
			)
			(else
				(if (== global138 1)
					(gEgo posn: 163 290 heading: 45)
				else
					(gEgo posn: 378 284 heading: 45)
				)
			)
		)
		(gEgo sel_737: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GabeEgo)
			(Palette 1 (= global249 222)) ; PalLoad
		else
			(Palette 1 (= global249 221)) ; PalLoad
		)
		(super init: &rest)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 96
			y: 256
			createPoly: 127 288 65 293 65 222 127 219
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 283
			y: 224
			createPoly: 269 242 269 206 298 206 298 242
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
		BAD_SELECTOR 0
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
				(gCurRoom newRoom: 11802)
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
		BAD_SELECTOR 6
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
				(gCurRoom newRoom: 11805)
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
		y 293
		BAD_SELECTOR 2
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
				(gCurRoom newRoom: 11807)
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
		nsLeft 294
		nsTop 270
		nsRight 345
		nsBottom 294
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

