;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4570)
(include sci.sh)
(use Main)
(use n951)

(public
	rm4v570 0
)

(instance rm4v570 of ShiversRoom
	(properties
		picture 4040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 4600) ; rm4v600
			(proc951_7 20402)
			(proc951_9 20402)
			(gSounds play: 20402 -1 0 0)
			(gSounds fade: 20402 98 15 15 0 0)
		)
		(super init: &rest)
		(if (IsFlag 6)
			(ClearFlag 6)
			(gSounds play: 10405 0 30 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4560
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4580
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 142 210 142 210 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 4540
	)

	(method (init)
		(self createPoly: 176 112 86 112 117 77 117 61 145 61 145 78)
		(super init: &rest)
	)
)

