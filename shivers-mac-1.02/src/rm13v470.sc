;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13470)
(include sci.sh)
(use Main)

(public
	rm13v470 0
)

(instance rm13v470 of ShiversRoom
	(properties
		picture 13580
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13471
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13472
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13474
	)

	(method (init)
		(self createPoly: 65 143 95 112 95 31 168 31 168 112 197 142)
		(super init: &rest)
	)
)

