;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v190 0
)

(instance rm26v190 of ShiversRoom
	(properties
		picture 26190
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26210
	)

	(method (init)
		(self createPoly: 75 27 183 27 179 91 243 87 243 143 21 143 21 86 80 90)
		(super init: &rest)
	)
)

