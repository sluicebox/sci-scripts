;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5541)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm5541 0
)

(instance rm5541 of ExitRoom
	(properties
		modNum 543
		picture 5541
	)

	(method (init)
		(super init: &rest)
		(Lock 140 250 1) ; WAVE
		(gGk2Music setLoop: -1 number: 250 play:)
		(fSouthExit init:)
		(fLedgeCU init:)
		(fTrees init:)
		(gGame handsOn:)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		modNum 540
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 6301 0 5512) ; rm5512
		else
			(super doVerb: &rest)
		)
	)
)

(instance fLedgeCU of ExitFeature
	(properties
		BAD_SELECTOR 5542
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 300 0 211 618 218 618 300)
	)

	(method (setCursor param1)
		(param1 view: 998)
		(param1 loop: 1)
		(param1 cel: 0)
	)
)

(instance fTrees of GKFeature
	(properties
		modNum 543
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 -1 616 -1 616 217 1 211)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 4 62 0 1 0 543) ; "(LOOKING OUT PREISS'S WINDOW, WRY)More woods than you can shake a stick at."
		else
			(super doVerb: &rest)
		)
	)
)

