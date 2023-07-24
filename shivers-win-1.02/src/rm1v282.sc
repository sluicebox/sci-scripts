;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1282)
(include sci.sh)
(use Main)

(public
	rm1v282 0
)

(instance rm1v282 of ShiversRoom
	(properties
		picture 1282
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
		nextRoom 1280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1281
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1290
	)

	(method (init)
		(self
			createPoly: 111 143 123 79 136 76 150 70 150 28 196 28 196 109 203 112 203 118 209 126 208 132 219 143
		)
		(super init: &rest)
	)
)

