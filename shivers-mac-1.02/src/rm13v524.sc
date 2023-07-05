;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13524)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v524 0
)

(instance rm13v524 of ShiversRoom
	(properties
		picture 13891
	)

	(method (init)
		(proc951_16 34)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 13522
	)

	(method (init)
		(if (== gPrevRoomNum 13521) ; rm13v521
			(= nextRoom gPrevRoomNum)
		)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(super init: &rest)
	)
)

