;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11804)
(include sci.sh)
(use Main)
(use GabeEgo)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11804 0
)

(instance rm11804 of ExitRoom
	(properties
		modNum 1180
		picture 11804
		south 11808 ; rm11808
	)

	(method (init)
		(switch gPrevRoomNum
			(11808
				(gEgo posn: 331 360 heading: 45)
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
			x: 91
			y: 257
			createPoly: 117 287 65 290 65 226 116 225
		)
		(theWestExit init:)
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
				(gCurRoom newRoom: 11803)
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
		nsLeft 304
		nsTop 269
		nsRight 371
		nsBottom 303
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

