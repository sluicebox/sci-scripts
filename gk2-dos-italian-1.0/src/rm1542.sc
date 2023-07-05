;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1542)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)

(public
	rm1542 0
)

(instance rm1542 of ExitRoom
	(properties
		picture 1542
		south 150 ; srGerdaRoom
	)

	(method (init)
		(super init: &rest)
		(photo init:)
	)

	(method (newRoom)
		(PlayScene 1501)
		(super newRoom: &rest)
	)
)

(instance photo of GKFeature
	(properties
		noun 2
		modNum 150
		nsLeft 160
		nsTop 19
		nsRight 628
		nsBottom 304
	)
)

