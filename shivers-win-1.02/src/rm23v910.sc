;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23910)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v910 0
)

(instance rm23v910 of ShiversRoom
	(properties
		picture 23910
	)

	(method (init)
		(proc951_16 48)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23060
	)

	(method (init)
		(if (== gPrevRoomNum 23160) ; rm23v160
			(self nextRoom: 23160)
		)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

