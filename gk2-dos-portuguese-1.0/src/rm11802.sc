;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11802)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11802 0
)

(instance rm11802 of ExitRoom
	(properties
		picture 11802
		south 11806 ; rm11806
	)

	(method (init)
		(switch gPrevRoomNum
			(11806
				(gEgo posn: 331 360 heading: 45)
			)
			(11840
				(gEgo posn: 238 273 heading: 135)
			)
			(11803
				(gEgo posn: 463 286 heading: 225)
			)
			(else
				(gEgo posn: 233 290 heading: 135)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GabeEgo)
			(Palette 1 (= global249 222)) ; PalLoad
		else
			(Palette 1 (= global249 221)) ; PalLoad
		)
		(super init: &rest)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 89
			y: 270
			createPoly: 67 243 111 243 111 298 67 294
		)
		(drain init:)
		(panelBox init:)
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
				(gCurRoom newRoom: 1180) ; basementHallRm
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
				(gCurRoom newRoom: 11803)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance panelBox of GKFeature
	(properties
		modNum 1180
		x 300
		y 163
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 128 326 128 326 199 274 199
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== gEgo GraceEgo) (gEgo has: 67)) ; invTheaterKeys
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gEgo GraceEgo) (gEgo has: 67)) ; invTheaterKeys
						(gMessager say: 14 theVerb 0 0 0 1180) ; "(PICKUP, TRY TO OPEN PANEL BOX AFTER GETTING KEYS CH 6)There's nothing else IN there."
					)
					((== gEgo GraceEgo)
						(PlayScene 900 0 11840) ; rm11840
					)
					(else
						(PlayScene 901 0 11840) ; rm11840
					)
				)
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

