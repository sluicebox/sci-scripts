;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13000)
(include sci.sh)
(use Main)

(public
	rm13v000 0
)

(instance rm13v000 of ShiversRoom
	(properties
		picture 13010
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
		nextRoom 13001
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13001
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13002
	)

	(method (init)
		(self createPoly: 67 143 105 97 105 41 165 41 153 95 192 142)
		(super init: &rest)
	)
)

