;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20910)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v910 0
)

(instance rm20v910 of ShiversRoom
	(properties
		picture 20910
	)

	(method (init)
		(proc951_16 39)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20670
	)

	(method (init)
		(if (== gPrevRoomNum 20650) ; rm20v650
			(= nextRoom gPrevRoomNum)
		)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

