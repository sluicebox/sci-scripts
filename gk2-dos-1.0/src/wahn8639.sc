;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8639)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)

(public
	wahn8639 0
)

(instance wahn8639 of ExitRoom
	(properties
		picture 8639
		south 8640 ; wahn8640
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 635))
			(SetFlag 635)
			(PlayScene 534)
		)
		(plq init:)
	)
)

(instance plq of GKFeature
	(properties
		noun 3
		modNum 860
		nsLeft 314
		nsTop 4
		nsRight 444
		nsBottom 312
	)
)

