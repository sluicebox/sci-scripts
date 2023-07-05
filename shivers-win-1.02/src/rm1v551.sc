;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1551)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v551 0
)

(instance rm1v551 of ShiversRoom
	(properties
		picture 1551
	)

	(method (init)
		(gSounds setVol: 30110 40)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 9670) ; rm9v67
			(proc951_7 10112)
			(gSounds play: 10112 -1 0 0)
			(gSounds fade: 10112 82 2 40 0 0)
			(gSounds stop: 11602)
			(gSounds play: 11602 0 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1550
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1540
	)

	(method (init)
		(self createPoly: 118 142 98 91 218 91 213 142)
		(super init: &rest)
	)
)

