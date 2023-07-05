;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22090)
(include sci.sh)
(use Main)
(use n951)
(use n22001)

(public
	rm22v090 0
)

(instance rm22v090 of ShiversRoom
	(properties
		picture 22090
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (proc951_11 1 22000)
			(proc22001_1)
			(proc951_9 22212)
			(gSounds play: 22212 -1 50 0)
			(gSounds fade: 22201 0 5 16 1 0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22100
	)

	(method (init)
		(self createPoly: 104 45 193 45 193 142 98 142 98 45 103 45)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22310
	)
)

