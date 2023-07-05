;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27041)
(include sci.sh)
(use Main)

(public
	rm27v041 0
)

(instance rm27v041 of ShiversRoom
	(properties
		picture 27041
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27030
	)

	(method (init)
		(self createPoly: 91 143 123 52 153 52 179 143 91 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27040
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27042
	)
)

