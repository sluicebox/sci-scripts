;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11803)
(include sci.sh)
(use Main)
(use GK2Ego)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11803 0
)

(instance rm11803 of ExitRoom
	(properties
		modNum 1180
		picture 11803
		south 11807 ; rm11807
	)

	(method (init)
		(switch gPrevRoomNum
			(11807
				(gEgo posn: 331 360 heading: 45)
			)
			(11804
				(gEgo posn: 463 286 heading: 225)
			)
			(else
				(gEgo posn: 233 290 heading: 135)
			)
		)
		(gEgo sel_737: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GabeEgo)
			(Palette 1 (= global249 222)) ; PalLoad
		else
			(Palette 1 (= global249 221)) ; PalLoad
		)
		(super init: &rest)
		(drain init:)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 63
			y: 279
			createPoly: 42 299 42 245 83 245 84 313
		)
		(theWestExit init:)
		(theEastExit init:)
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
				(gCurRoom newRoom: 11802)
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
				(gCurRoom newRoom: 11804)
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
		nsLeft 295
		nsTop 260
		nsRight 364
		nsBottom 302
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

