;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11812)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm11812 0
)

(instance rm11812 of ExitRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		modNum 1180
		noun 11
		picture 11812
		south 1190 ; furnaceRm
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 11002)
			(gGk2Music fade: 0 10 10 1)
			(Lock rsAUDIO 11812 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (or (not (gGk2Music handle:)) (!= 11812 (gGk2Music number:)))
			(Lock rsAUDIO 11812 1)
			(gGk2Music number: 11812 setLoop: -1 play:)
		)
		(switch gPrevRoomNum
			(11811
				(gEgo posn: 243 290 heading: 135)
			)
			(11808
				(gEgo posn: 378 284 heading: 225)
			)
			(11002
				(gEgo posn: 463 286 heading: 225)
			)
			(else
				(switch global138
					(1
						(gEgo posn: 163 290 heading: 135)
					)
					(2
						(gEgo posn: 378 284 heading: 45)
					)
					(3
						(gEgo posn: 493 286 heading: 225)
					)
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
			y: 273
			createPoly: 69 302 69 244 121 244 121 303
		)
		((ScriptID 1180 2) ; doorLatch2
			init:
			x: 284
			y: 232
			createPoly: 270 249 270 216 299 216 299 249
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
				(gCurRoom newRoom: 11808)
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
				(gCurRoom newRoom: 11811)
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
					(PlayScene 898 0 11002) ; rm11002
				else
					(gMessager say: 1 theVerb 0 0 0 modNum) ; "(THEATER BASEMENT, TRY TO TAKE GABRIEL UP TO FOYER)I can't go up there. If the ushers see me, they'll call security."
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

