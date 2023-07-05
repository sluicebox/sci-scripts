;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4041)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm4041 0
)

(instance rm4041 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4041
		south 4012 ; rm4012
	)

	(method (init)
		(super init: &rest)
		(fMary init:)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)
)

(instance fMary of GKFeature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 214 12 214 304 410 304 410 14)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62 0 0 0 400) ; "(LOOK AT MARY STATUE MARIENPLATZ, SOFT)She almost seems to be watching me."
		else
			(super doVerb: theVerb)
		)
	)
)

