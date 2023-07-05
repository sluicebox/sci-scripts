;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12570)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v57 0
)

(instance rm12v57 of ShiversRoom
	(properties
		picture 12570
	)

	(method (init)
		(proc951_16 32)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12190
	)

	(method (init)
		(if (== gPrevRoomNum 12240) ; rm12v24
			(self nextRoom: 12240)
		)
		(self createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
	)
)

