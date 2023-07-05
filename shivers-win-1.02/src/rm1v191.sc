;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1191)
(include sci.sh)
(use Main)

(public
	rm1v191 0
)

(instance rm1v191 of ShiversRoom
	(properties
		picture 1191
	)

	(method (init)
		(gSounds interruptChain:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1181
	)

	(method (init)
		(self createPoly: 40 117 33 70 33 61 96 59 184 74 199 97)
		(super init: &rest)
	)
)

