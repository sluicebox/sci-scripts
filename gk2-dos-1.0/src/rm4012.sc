;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4012)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm4012 0
)

(instance rm4012 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4012
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(fMary init:)
		(fClock init:)
		(gGame handsOn:)
	)
)

(instance fMary of GKFeature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 172 76 172 170 232 170 232 76)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4041)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fClock of GKFeature
	(properties
		noun 31
		modNum 400
	)

	(method (init)
		(self createPoly: 297 164 332 94 391 122 411 267 310 297)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 4017)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

