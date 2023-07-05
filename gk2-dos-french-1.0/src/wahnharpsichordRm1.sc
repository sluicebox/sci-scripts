;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8614)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahnharpsichordRm1 0
)

(instance wahnharpsichordRm1 of ExitRoom
	(properties
		picture 8614
		south 8601 ; wahnDispRm
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		nsLeft 247
		nsTop 67
		nsRight 320
		nsBottom 108
		nextRoomNum 8652 ; rm8652
	)
)

