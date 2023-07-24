;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7162)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v162 0
)

(instance rm7v162 of ShiversRoom
	(properties
		picture 7162
	)

	(method (init)
		(proc951_16 93)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 7160
	)

	(method (init)
		(if (== gPrevRoomNum 7160) ; rm7v160
			(= nextRoom 7160)
		)
		(if (== gPrevRoomNum 7090) ; rm7v090
			(= nextRoom 7090)
		)
		(self
			createPoly: 1 1 1 142 262 142 262 1 2 1 18 15 18 125 240 124 240 18 240 14 17 14
		)
		(super init: &rest)
	)
)

