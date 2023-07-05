;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13416)
(include sci.sh)
(use Main)

(public
	rm13v416 0
)

(instance rm13v416 of ShiversRoom
	(properties
		picture 13330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13414
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13417
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13412
	)

	(method (init)
		(self createPoly: 83 142 113 97 110 47 159 47 159 95 208 140)
		(super init: &rest)
	)
)

