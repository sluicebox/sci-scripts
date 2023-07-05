;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11809)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm11809 0
)

(instance rm11809 of ExitRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		modNum 1180
		noun 11
		picture 11809
	)

	(method (init)
		(if (or (not (gGk2Music handle:)) (!= 11812 (gGk2Music number:)))
			(Lock rsAUDIO 11812 1)
			(gGk2Music number: 11812 setLoop: -1 play:)
		)
		(switch gPrevRoomNum
			(11805
				(gEgo posn: 378 284 heading: 135)
			)
			(11810
				(gEgo posn: 463 286 heading: 225)
			)
			(11853
				(gEgo posn: 100 300 heading: 135)
			)
			(else
				(gEgo posn: 378 284 heading: 45)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 100 60 365 273 init:)
		(if (== gEgo GraceEgo)
			(Palette 1 (= global249 221)) ; PalLoad
		else
			(Palette 1 (= global249 222)) ; PalLoad
		)
		(super init: &rest)
		(if (== gEgo GraceEgo)
			(openVentFeature init:)
		)
		(if (IsFlag 800)
			(openVent init:)
			(if (== gEgo GabeEgo)
				(openVentFeature init:)
			)
		)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 278
			y: 233
			createPoly: 262 252 262 214 294 214 294 252
		)
		(drain init:)
		(northExit init:)
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

(instance openVentFeature of GKFeature
	(properties
		modNum 1180
		nsLeft 480
		nsRight 640
		sightAngle 360
	)

	(method (handleEvent event)
		(= global141 self)
		(if (and (== gEgo GabeEgo) (not (IsFlag 701)))
			(= global141 0)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 13 148 79 150 79 234 13 257
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(openVent doVerb: theVerb &rest)
	)
)

(instance openVent of View
	(properties
		modNum 1180
		x 88
		y 258
		view 30118
	)

	(method (handleEvent event)
		(= global141 self)
		(if (and (== gEgo GabeEgo) (not (IsFlag 701)))
			(= global141 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gEgo GabeEgo) (IsFlag 701))
						(gMessager say: 13 theVerb 0 0 0 1180) ; "(PICK UP, CH 6--TRY TO PUT VENT COVER BACK ON AFTER FIRST TIME, DARK AND CRANKY)It's no use. I broke the damn thing!"
					)
					((== gEgo GabeEgo)
						(SetFlag 701)
						(PlayScene 903)
						(gEgo posn: 100 300 heading: 315)
					)
					((IsFlag 701)
						(gMessager say: 20 theVerb 0 0 0 1180) ; "(PICK UP, CH 6--LOOK AT VENT IN BASEMENT, DOUBTFUL)I don't think I need to mess with the vent. If I want to go outside, I can use the doors upstairs."
					)
					(else
						(gMessager say: 19 theVerb 0 0 0 1180) ; "(PICK UP, CH 6--LOOK AT VENT IN BASEMENT, NOT REAL INTERESTED)Cool air's coming in through that vent. It must lead outside."
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
		nsLeft 266
		nsTop 287
		nsRight 338
		nsBottom 325
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

