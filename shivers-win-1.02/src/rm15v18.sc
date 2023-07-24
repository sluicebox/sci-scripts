;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15180)
(include sci.sh)
(use Main)

(public
	rm15v18 0
)

(instance rm15v18 of ShiversRoom
	(properties
		picture 15180
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15210
	)

	(method (init)
		(self
			createPoly: 35 142 35 137 55 127 55 112 101 97 101 27 166 27 166 97 211 112 223 142
		)
		(super init: &rest)
	)
)

