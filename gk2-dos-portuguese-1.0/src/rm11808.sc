;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11808)
(include sci.sh)
(use Main)
(use GabeEgo)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11808 0
)

(instance rm11808 of ExitRoom
	(properties
		modNum 1180
		picture 11808
		south 11812 ; rm11812
	)

	(method (init)
		(switch gPrevRoomNum
			(11812
				(gEgo posn: 331 360 heading: 45)
			)
			(11807
				(gEgo posn: 243 290 heading: 135)
			)
			(11804
				(gEgo posn: 378 284 heading: 225)
			)
			(else
				(if (== global138 1)
					(gEgo posn: 163 290 heading: 135)
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
			x: 81
			y: 258
			createPoly: 104 290 59 287 59 226 104 229
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 282
			y: 225
			createPoly: 267 243 267 208 297 208 297 243
		)
		(drain init:)
		(northExit init:)
		(theWestExit init:)
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
				(gCurRoom newRoom: 11804)
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
		nsLeft 290
		nsTop 267
		nsRight 350
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

