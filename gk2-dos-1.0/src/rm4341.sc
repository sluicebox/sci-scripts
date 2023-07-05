;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4341)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4341 0
)

(instance rm4341 of ExitRoom ; "Hunt Club: Front Hall"
	(properties
		modNum 430
		noun 16
		picture 4341
		south 430 ; clubFrontRm
	)

	(method (init)
		(self setRegions: 4599) ; clubRegion
		(fDrawer init:)
		(fSearchArea init:)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (cue)
		(= gCurRoomNum 4342)
		(PlayScene 256 0 -1)
		(PlayScene 254 0 430) ; clubFrontRm
	)
)

(instance fDrawer of GKFeature
	(properties
		modNum 430
	)

	(method (init)
		(self createPoly: 168 212 170 287 347 335 446 334 443 270)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame handsOff:)
				(if (gEgo has: 33) ; invXaverKeys
					(PlayScene 5259 0 4342) ; rm4342
				else
					(PlayScene 4259 0 4342) ; rm4342
				)
			)
			(39 ; invXaverKeys
				(gGame handsOff:)
				(SetFlag 542)
				(PlayScene 5259 0 4342) ; rm4342
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSearchArea of GKFeature
	(properties
		modNum 430
	)

	(method (init)
		(self createPoly: 385 33 477 49 495 60 419 173 202 124 297 28)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 257)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

