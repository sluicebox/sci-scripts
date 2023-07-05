;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23950)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v950 0
)

(instance rm23v950 of ShiversRoom
	(properties
		picture 23950
	)

	(method (init)
		(proc951_16 54)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23630
	)

	(method (init)
		(if (== gPrevRoomNum 23390) ; rm23v390
			(self nextRoom: 23390)
		)
		(if (== gPrevRoomNum 23670) ; rm23v670
			(self nextRoom: 23670)
		)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

