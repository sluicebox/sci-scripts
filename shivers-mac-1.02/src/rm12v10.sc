;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v10 0
)

(instance rm12v10 of ShiversRoom
	(properties
		picture 12100
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (proc951_11 6 12000)
			(proc951_7 21210)
			(gSounds play: 21210 -1 0 0)
			(gSounds fade: 21210 15 10 8 0 0)
			(gSounds fade: 21212 0 10 8 1 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12321
	)

	(method (init)
		(self
			createPoly: 47 11 82 28 186 28 185 123 84 122 77 130 63 130 41 142 39 50 47 11
		)
		(super init: &rest)
	)
)

