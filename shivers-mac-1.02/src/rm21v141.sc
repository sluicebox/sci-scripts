;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21141)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v141 0
)

(instance rm21v141 of ShiversRoom
	(properties
		picture 21141
	)

	(method (init)
		(proc951_16 41)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21130
	)

	(method (init)
		(self createPoly: 1 1 260 1 260 140 0 140 1 1)
		(if (== gPrevRoomNum 21130) ; rm21v130
			(= nextRoom 21130)
		)
		(if (== gPrevRoomNum 21220) ; rm21v220
			(= nextRoom 21220)
		)
		(if (== gPrevRoomNum 21230) ; rm21v230
			(= nextRoom 21230)
		)
		(super init: &rest)
	)
)

