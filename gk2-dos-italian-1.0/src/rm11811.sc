;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11811)
(include sci.sh)
(use Main)
(use GK2Ego)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11811 0
)

(instance rm11811 of ExitRoom
	(properties
		modNum 1180
		picture 11811
	)

	(method (init)
		(switch gPrevRoomNum
			(11810
				(gEgo posn: 243 290 heading: 135)
			)
			(11807
				(gEgo posn: 378 284 heading: 225)
			)
			(11812
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
			x: 101
			y: 255
			createPoly: 77 281 77 231 126 229 126 279
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 278
			y: 232
			createPoly: 264 246 264 218 293 218 293 246
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
				(gCurRoom newRoom: 11807)
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
				(gCurRoom newRoom: 11810)
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
				(gCurRoom newRoom: 11812)
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

