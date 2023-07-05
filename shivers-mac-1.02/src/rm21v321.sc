;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21321)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v321 0
)

(instance rm21v321 of ShiversRoom
	(properties
		picture 21321
	)

	(method (init)
		(proc951_16 43)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21050
	)

	(method (init)
		(self createPoly: 1 1 260 1 260 140 0 140 1 1)
		(if (== gPrevRoomNum 21040) ; rm21v040
			(= nextRoom 21040)
		)
		(if (== gPrevRoomNum 21440) ; rm21v440
			(= nextRoom 21440)
		)
		(if (== gPrevRoomNum 21050) ; rm21v050
			(= nextRoom 21050)
		)
		(super init: &rest)
	)
)

