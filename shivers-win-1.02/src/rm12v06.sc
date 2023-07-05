;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12060)
(include sci.sh)
(use Main)

(public
	rm12v06 0
)

(instance rm12v06 of ShiversRoom
	(properties
		picture 12060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12321
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12030
	)

	(method (init)
		(self createPoly: 175 142 171 30 151 6 143 0 21 0 21 143)
		(super init: &rest)
	)
)

