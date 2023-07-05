;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v280 0
)

(instance rm8v280 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 34)
			(= picture 8280)
		else
			(= picture 8290)
		)
		(if (and (proc951_11 1 8000) (or (== gPrevRoomNum 8180) (== gPrevRoomNum 8120))) ; rm8v180, rm8v120
			(proc951_7 20801)
			(proc951_9 20801)
			(gSounds play: 20801 -1 0 0)
			(gSounds fade: 20801 66 5 16 0 0)
			(gSounds fade: 20802 0 5 8 1 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8300
	)

	(method (init)
		(self createPoly: 88 142 86 115 98 97 101 72 170 72 170 141)
		(super init: &rest)
	)
)

