;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12580)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v58 0
)

(instance rm12v58 of ShiversRoom
	(properties
		picture 12580
	)

	(method (init)
		(proc951_16 29)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12070
	)

	(method (init)
		(if (== gPrevRoomNum 12090) ; rm12v09
			(self nextRoom: 12090)
		)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

