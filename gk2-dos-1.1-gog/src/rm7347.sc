;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7347)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm7347 0
)

(instance rm7347 of ExitRoom
	(properties
		picture 7347
		south 7301 ; rm7301
	)

	(method (init)
		(super init: &rest)
		(jergenPlate init:)
	)
)

(instance jergenPlate of GKFeature
	(properties
		noun 3
		modNum 730
		nsLeft 100
		nsTop 50
		nsRight 300
		nsBottom 380
	)
)

