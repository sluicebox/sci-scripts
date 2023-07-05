;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12550)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v55 0
)

(instance rm12v55 of ShiversRoom
	(properties
		picture 12550
	)

	(method (init)
		(proc951_16 30)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12110
	)

	(method (init)
		(if (== gPrevRoomNum 12150) ; rm12v15
			(self nextRoom: 12150)
		)
		(self createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

