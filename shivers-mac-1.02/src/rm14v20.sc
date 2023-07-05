;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v20 0
)

(instance rm14v20 of ShiversRoom
	(properties
		picture 14200
	)

	(method (init)
		(proc951_16 35)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 14190
	)

	(method (init)
		(if (== gPrevRoomNum 14150) ; rm14v15
			(= nextRoom 14150)
		)
		(self createPoly: 0 0 263 0 263 143 0 143 0 0)
		(super init: &rest)
	)
)

