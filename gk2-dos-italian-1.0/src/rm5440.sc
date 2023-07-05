;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5440)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm5440 0
)

(instance rm5440 of ExitRoom
	(properties
		modNum 540
		picture 5440
		south 540 ; gabeRm
	)

	(method (init)
		(super init: &rest)
		(fClothes init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(PlayScene 1628)
		(super dispose: &rest)
	)
)

(instance fClothes of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 46 -2 593 -1 554 334 85 335)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 3 62 0 1 0 540) ; "(LOOK IN GABE'S SHRANK AT LODGE)There's nothin' in here."
		else
			(super doVerb: theVerb)
		)
	)
)

