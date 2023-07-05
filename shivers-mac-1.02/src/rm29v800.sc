;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29800)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v800 0
)

(instance rm29v800 of ShiversRoom
	(properties
		picture 29800
	)

	(method (init)
		(proc951_16 60)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29090
	)

	(method (init)
		(if (== gPrevRoomNum 29090) ; rm29v090
			(= nextRoom 29090)
		)
		(if (== gPrevRoomNum 29020) ; rm29v020
			(= nextRoom 29020)
		)
		(if (== gPrevRoomNum 29270) ; rm29v270
			(= nextRoom 29270)
		)
		(self createPoly: 1 1 262 1 262 142 1 142 1 1)
		(super init: &rest)
	)
)

