;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1213)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v213 0
)

(instance rm1v213 of ShiversRoom
	(properties
		picture 1213
	)

	(method (init)
		(proc951_16 85)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 1211
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 143 1 143)
		(if (== gPrevRoomNum 1211) ; rm1v211
			(= nextRoom 1211)
		)
		(if (== gPrevRoomNum 1210) ; rm1v210
			(= nextRoom 1210)
		)
		(super init: &rest)
	)
)

