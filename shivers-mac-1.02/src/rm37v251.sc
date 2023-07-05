;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37251)
(include sci.sh)
(use Main)

(public
	rm37v251 0
)

(instance rm37v251 of ShiversRoom
	(properties
		picture 37251
	)

	(method (init)
		(efExitJournal init: 0)
		(efExitPicture init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 37252) ; rm37v252
			(gSounds play: 13705 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37122
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37123
	)
)

(instance efExitPicture of ExitFeature
	(properties
		nextRoom 37267
	)

	(method (init)
		(self createPoly: 68 58 66 12 20 13 23 62 68 58)
		(super init: &rest)
	)
)

(instance efExitJournal of ExitFeature
	(properties
		nextRoom 37252
	)

	(method (init)
		(self createPoly: 99 46 87 83 89 86 156 86 151 46 99 46)
		(super init: &rest)
	)
)

