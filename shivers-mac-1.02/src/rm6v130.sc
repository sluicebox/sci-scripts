;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6130)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v130 0
)

(instance rm6v130 of ShiversRoom
	(properties
		picture 6130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 6400) ; rm6v400
			(gSounds play: 10614 0 40 0)
			(if (IsFlag 6)
				(ClearFlag 6)
				(gSounds play: 10405 0 30 0)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6070
	)

	(method (init)
		(self createPoly: 192 121 189 51 231 55 242 55 242 120)
		(super init: &rest)
	)
)

