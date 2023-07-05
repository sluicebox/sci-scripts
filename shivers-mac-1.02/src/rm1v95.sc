;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1095)
(include sci.sh)
(use Main)

(public
	rm1v95 0
)

(instance rm1v95 of ShiversRoom
	(properties
		picture 1095
	)

	(method (init &tmp [temp0 2])
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1091
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1101
	)

	(method (init)
		(self createPoly: 70 36 70 142 189 141 189 1 70 1 70 37)
		(super init: &rest)
	)
)

