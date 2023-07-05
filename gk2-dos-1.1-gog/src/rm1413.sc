;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1413)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm1413 0
)

(instance rm1413 of ExitRoom
	(properties
		picture 1413
		south 140 ; srGabeRoom
	)

	(method (init)
		(super init: &rest)
		(toolBox init:)
		(spot init:)
	)
)

(instance spot of GKFeature
	(properties
		modNum 140
		nsLeft 412
		nsTop 163
		nsRight 454
		nsBottom 225
		sceneNum 127
		nextRoomNum 1430 ; rm1430
	)
)

(instance toolBox of GKFeature
	(properties
		modNum 140
		nsLeft 441
		nsTop 260
		nsRight 557
		nsBottom 347
		sceneNum 127
		nextRoomNum 1441 ; rm1441
	)
)

