;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4017)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm4017 0
)

(instance rm4017 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4017
		south 4012 ; rm4012
	)

	(method (init)
		(super init: &rest)
		(fClock init:)
		(gGame handsOn:)
	)
)

(instance fClock of GKFeature
	(properties
		noun 31
		modNum 400
	)

	(method (init)
		(self
			createPoly: 79 32 117 -2 494 -1 528 33 548 199 523 235 527 335 125 334 137 239 71 231
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: noun theVerb 0 0 0 400) ; "(LOOK AT GLOCKENSPEIL IN MARIENPLATZ)That must be the famous Munich Glockenspiel."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

