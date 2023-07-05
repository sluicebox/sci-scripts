;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v300 0
)

(instance rm22v300 of ShiversRoom
	(properties
		picture 22300
	)

	(method (init)
		(proc951_16 106)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 22230
	)

	(method (init)
		(if (== gPrevRoomNum 22210) ; rm22v210
			(self nextRoom: 22210)
		)
		(self createPoly: 20 106 20 142 240 142 240 106 20 106)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22270
	)
)

