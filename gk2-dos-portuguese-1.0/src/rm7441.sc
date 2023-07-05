;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7441)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm7441 0
)

(instance rm7441 of ExitRoom
	(properties
		picture 7441
		south 740 ; gastRm
	)

	(method (init)
		(super init: &rest)
		(arti init:)
	)
)

(instance arti of GKFeature
	(properties
		noun 9
		modNum 740
		nsLeft 280
		nsTop 122
		nsRight 388
		nsBottom 252
	)
)

