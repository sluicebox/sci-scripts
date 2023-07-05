;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29810)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v810 0
)

(instance rm29v810 of ShiversRoom
	(properties
		picture 29810
	)

	(method (init)
		(proc951_16 61)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29010
	)

	(method (init)
		(if (== gPrevRoomNum 29010) ; rm29v010
			(= nextRoom 29010)
		)
		(if (== gPrevRoomNum 29060) ; rm29v060
			(= nextRoom 29060)
		)
		(if (== gPrevRoomNum 29270) ; rm29v270
			(= nextRoom 29270)
		)
		(self createPoly: 1 1 262 1 262 142 1 142 1 1)
		(super init: &rest)
	)
)

