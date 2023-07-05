;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4016)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm4016 0
)

(instance rm4016 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4049
		south 4015 ; rm4015
	)

	(method (init)
		(super init: &rest)
		(fUberSign init:)
	)
)

(instance fUberSign of GKFeature
	(properties
		noun 11
		modNum 400
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 2 84 615 84 615 282 -3 282)
	)
)

