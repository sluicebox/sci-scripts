;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21075)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v075 0
)

(instance rm21v075 of ShiversRoom
	(properties
		picture 21800
	)

	(method (init)
		(proc951_16 44)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21040
	)

	(method (init)
		(self createPoly: 1 1 260 1 260 140 0 140 1 1)
		(if (== gPrevRoomNum 21040) ; rm21v040
			(= nextRoom 21040)
		)
		(if (== gPrevRoomNum 21060) ; rm21v060
			(= nextRoom 21060)
		)
		(super init: &rest)
	)
)

