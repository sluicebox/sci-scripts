;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23930)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v930 0
)

(instance rm23v930 of ShiversRoom
	(properties
		picture 23930
	)

	(method (init)
		(proc951_16 49)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23230
	)

	(method (init)
		(if (== gPrevRoomNum 23260) ; rm23v260
			(self nextRoom: 23260)
		)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

