;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29820)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v820 0
)

(instance rm29v820 of ShiversRoom
	(properties
		picture 29820
	)

	(method (init)
		(proc951_16 62)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29170
	)

	(method (init)
		(if (== gPrevRoomNum 29170) ; rm29v170
			(= nextRoom 29170)
		)
		(if (== gPrevRoomNum 29270) ; rm29v270
			(= nextRoom 29270)
		)
		(self createPoly: 1 1 262 1 262 142 1 142 1 1)
		(super init: &rest)
	)
)

