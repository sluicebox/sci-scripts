;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22310)
(include sci.sh)
(use Main)
(use n951)
(use n22001)

(public
	rm22v310 0
)

(instance rm22v310 of ShiversRoom
	(properties
		picture 22310
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (proc951_11 1 22000)
			(gSounds interruptChain:)
			(proc22001_0)
			(proc951_9 22201)
			(gSounds play: 22201 -1 0 0)
			(gSounds fade: 22201 74 5 16 0 0)
			(gSounds fade: 22212 0 5 16 1 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22070
	)

	(method (init)
		(self createPoly: 20 20 243 20 243 123 20 123)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22090
	)
)

