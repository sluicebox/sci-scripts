;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4111)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4111 0
)

(instance rm4111 of ExitRoom ; "Dienerstrasse"
	(properties
		modNum 410
		noun 4
		picture 4111
		south 4102 ; rm4102
	)

	(method (init)
		(super init: &rest)
		(efHunt init:)
		(fSign init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 430) ; clubFrontRm
			(Lock 140 410 0) ; WAVE
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efHunt of ExitFeature
	(properties
		modNum 410
		sightAngle 360
		x 420
		y 100
		exitDir 0
	)

	(method (init)
		(self createPoly: 293 -1 311 19 310 313 105 363 101 181 99 -3)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (and (== gChapter 1) (not (IsFlag 520)))
					(PlayScene 67 0 430) ; clubFrontRm
				else
					(PlayScene 68 0 430) ; clubFrontRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSign of Feature
	(properties
		modNum 410
	)

	(method (init)
		(self
			createPoly:
				375
				40
				421
				46
				421
				128
				411
				144
				400
				147
				387
				141
				384
				129
				376
				129
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 6 62 0 0 0 410) ; "(LOOK AT HUNT CLUB SIGN)54 Dienerstrasse."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

