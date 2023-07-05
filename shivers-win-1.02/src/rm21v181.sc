;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21181)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v181 0
)

(instance rm21v181 of ShiversRoom
	(properties
		picture 21181
	)

	(method (init)
		(proc951_16 40)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21180
	)

	(method (init)
		(self createPoly: 1 1 260 1 260 140 0 140 1 1)
		(if (== gPrevRoomNum 21180) ; rm21v180
			(= nextRoom 21180)
		)
		(if (== gPrevRoomNum 21160) ; rm21v160
			(= nextRoom 21160)
		)
		(super init: &rest)
	)
)

