;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 546)
(include sci.sh)
(use northExit)
(use Feature)

(public
	vzWRm 0
)

(instance vzWRm of ExitRoom ; "Hunting Lodge: Von Zell's Room"
	(properties
		modNum 546
		noun 9
		picture 56514
		south 56501 ; vzRm
	)

	(method (init)
		(super init: &rest)
		(fWindow init:)
	)
)

(instance fWindow of GKFeature
	(properties
		nextRoomNum 570 ; ledgeRm
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 112 14 466 16 465 317 110 321)
	)
)

