;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11810)
(include sci.sh)
(use Main)
(use GK2Ego)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11810 0
)

(instance rm11810 of ExitRoom
	(properties
		modNum 1180
		picture 11810
	)

	(method (init)
		(switch gPrevRoomNum
			(11809
				(gEgo posn: 243 290 heading: 135)
			)
			(11806
				(gEgo posn: 378 284 heading: 225)
			)
			(11811
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
		(gEgo BAD_SELECTOR: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GraceEgo)
			(Palette 1 (= global249 221)) ; PalLoad
		else
			(Palette 1 (= global249 222)) ; PalLoad
		)
		(super init: &rest)
		(drain init:)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 95
			y: 267
			createPoly: 71 293 71 239 119 239 119 295
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 269
			y: 232
			createPoly: 254 249 254 215 284 215 284 249
		)
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
				(gCurRoom newRoom: 11806)
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

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11809)
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

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11811)
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
		nsTop 273
		nsRight 358
		nsBottom 311
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

