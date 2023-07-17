;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11805)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11805 0
)

(instance rm11805 of ExitRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		modNum 1180
		noun 11
		picture 11805
		south 11809 ; rm11809
	)

	(method (init)
		(switch gPrevRoomNum
			(11809
				(gEgo posn: 331 360 heading: 45)
			)
			(1180 ; basementHallRm
				(gEgo posn: 378 284 heading: 135)
			)
			(1185 ; propRm
				(gEgo posn: 163 290 heading: 135)
			)
			(11806
				(gEgo posn: 463 286 heading: 225)
			)
			(11841
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
		(if (IsFlag 799)
			(ClearFlag 799)
			(SetFlag 744)
			(PlayScene 905)
		)
		((ScriptID 1180 1) ; doorLatch
			init:
			x: 67
			y: 250
			createPoly: 49 280 49 230 85 220 85 262
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 287
			y: 229
			createPoly: 301 246 274 246 274 212 301 212
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
				(gCurRoom newRoom: 1180) ; basementHallRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWestExit of Feature
	(properties
		modNum 1180
		x 44
		y 296
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 6 323 5 69 83 69 83 323 yourself:)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== gEgo GabeEgo))
			(= global141 self)
		)
		(if (> (gEgo y:) 300)
			(= approachY 130)
		else
			(= approachY 285)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(PlayScene 904 0 1185) ; propRm
				else
					(gMessager say: 4 theVerb 0 0 0 modNum) ; "(CRANKY)I don't need anything from the prop room. Besides, Gracie locked the door."
				)
			)
			(37 ; invTheaterKeys
				(if (IsFlag 790)
					(if (IsFlag 744)
						(gMessager say: 6 theVerb 0 0 0 modNum) ; "(DOUBTFUL)I don't need to lock the door until Gabriel's in there."
					else
						(SetFlag 744)
						(PlayScene 905)
					)
				else
					(gMessager say: 5 theVerb 0 0 0 modNum) ; "(TRY TO LOCK PROP ROOM BEFORE CHECKING IT OUT)Maybe I should see what's in there before I lock it."
				)
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
				(gCurRoom newRoom: 11806)
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
		nsLeft 264
		nsTop 270
		nsRight 323
		nsBottom 301
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

