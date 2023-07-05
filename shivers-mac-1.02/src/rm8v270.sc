;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8270)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v270 0
)

(instance rm8v270 of ShiversRoom
	(properties
		picture 8270
	)

	(method (init)
		(if (and (proc951_11 1 8000) (or (== gPrevRoomNum 8170) (== gPrevRoomNum 8120))) ; rm8v170, rm8v120
			(proc951_7 20801)
			(proc951_9 20801)
			(gSounds play: 20801 -1 0 0)
			(gSounds fade: 20801 66 5 16 0 0)
			(gSounds fade: 20802 0 5 8 1 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 0)
		(if (== newRoomNumber 10540) ; rm10v540
			(gSounds fadeChain:)
			(gSounds stop: 20802)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10540
	)

	(method (init)
		(self createPoly: 122 143 122 0 202 0 189 142)
		(super init: &rest)
	)
)

