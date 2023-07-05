;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v320 0
)

(instance rm20v320 of ShiversRoom
	(properties
		picture 20320
	)

	(method (init)
		(if (== gPrevRoomNum 21350) ; rm21v350
			(proc951_7 22001)
			(proc951_9 22001)
			(gSounds play: 22001 -1 98 0)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 12021 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20340
	)

	(method (init)
		(self createPoly: 68 40 202 40 195 142 74 142 68 41)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20310
	)
)

