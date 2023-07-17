;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1140)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	centerHallRm 0
)

(instance centerHallRm of ExitRoom ; "Wittelsbacher Theater: Center Hall"
	(properties
		noun 24
		picture 11401
		east 11304 ; rm11304
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(switch gPrevRoomNum
			(11304
				(gEgo
					posn: 541 302
					heading: 315
					sel_737:
					setScaler: Scaler 92 47 322 233
					init:
				)
			)
			(11303
				(gEgo
					posn: 195 244
					heading: 135
					sel_737:
					setScaler: Scaler 92 47 322 233
					init:
				)
			)
			(11442
				(gEgo
					posn: 420 258
					heading: 225
					sel_737:
					setScaler: Scaler 92 47 322 233
					init:
				)
			)
			(else
				(gEgo
					posn: 123 284
					heading: 45
					sel_737:
					setScaler: Scaler 92 47 322 233
					init:
				)
			)
		)
		(if (IsFlag 739)
			(Palette 1 (= global249 263)) ; PalLoad
		else
			(Palette 1 (= global249 264)) ; PalLoad
		)
		(super init: &rest)
		(exitToFoyer init:)
		(logeDoors init:)
		(westHall init:)
		(archway init:)
		(if (IsFlag 762)
			(rope init:)
		)
	)
)

(instance rope of View
	(properties
		modNum 1140
		x 412
		y 209
		view 11401
		loop 1
	)

	(method (doVerb theVerb)
		(logeDoors doVerb: theVerb)
	)
)

(instance exitToFoyer of ExitFeature
	(properties
		sightAngle 40
		x 46
		y 263
		BAD_SELECTOR 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 333 0 194 92 194 92 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 739)
					(PlayScene 848 0 1100) ; foyerRm
				else
					(PlayScene 847 0 1100) ; foyerRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance logeDoors of GKFeature
	(properties
		sightAngle 40
		x 424
		y 155
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 365 67 481 59 484 252 366 244
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (IsFlag 741))
					(gCurRoom newRoom: 11442)
				else
					(gCurRoom newRoom: 11410)
				)
			)
			(else
				(if (IsFlag 735)
					(super doVerb: theVerb)
				else
					(gCurRoom newRoom: 11410)
				)
			)
		)
	)
)

(instance westHall of ExitFeature
	(properties
		modNum 1140
		x 193
		y 154
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 81 227 74 228 235 159 235
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11303)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance archway of GKFeature
	(properties
		noun 25
		modNum 1140
		nsLeft 41
		nsTop 85
		nsRight 114
		nsBottom 256
		sightAngle 360
	)
)

