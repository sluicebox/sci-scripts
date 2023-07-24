;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v140 0
)

(instance rm10v140 of ShiversRoom
	(properties
		picture 10140
	)

	(method (init)
		(if (== gPrevRoomNum 10142) ; rm10v142
			(gSounds play: 11020 0 82 0)
		)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitDown init: 0)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10500
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10150
	)

	(method (init)
		(self
			createPoly: 92 112 61 71 64 36 94 9 135 8 188 8 208 38 208 80 182 111
		)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 10142
	)

	(method (init)
		(self createPoly: 60 140 56 130 92 123 105 131)
		(super init: &rest)
	)
)

