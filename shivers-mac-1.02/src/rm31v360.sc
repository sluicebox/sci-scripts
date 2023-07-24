;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31360)
(include sci.sh)
(use Main)
(use n951)
(use n31001)

(public
	rm31v360 0
)

(instance rm31v360 of ShiversRoom
	(properties
		picture 31365
	)

	(method (init)
		(if (IsFlag 73)
			(= picture 31360)
		)
		(if (== gPrevRoomNum 31440) ; rm31v440
			(proc31001_1)
			(gSounds fade: 23101 0 5 16 1 0)
			(proc951_9 23109)
			(gSounds play: 23109 -1 66 0)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitCloseUpOfFloor init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31390
	)

	(method (init)
		(self
			createPoly: 136 26 127 26 115 29 108 39 107 48 111 59 121 66 130 68 147 64 153 57 157 45 155 40 150 33 144 29 137 26
		)
		(super init: &rest)
	)
)

(instance efExitCloseUpOfFloor of ExitFeature
	(properties
		nextRoom 31361
	)

	(method (init)
		(self createPoly: 166 110 100 110 88 125 173 125 167 111)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31370
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31350
	)
)

