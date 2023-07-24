;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20140)
(include sci.sh)
(use Main)

(public
	rm20v140 0
)

(instance rm20v140 of ShiversRoom
	(properties
		picture 20140
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20150
	)

	(method (init)
		(self createPoly: 149 72 169 49 195 49 214 72 214 125 149 125 149 72)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20130
	)

	(method (init)
		(self createPoly: 0 0 0 80 19 80 39 80 39 0 1 0)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 20900
	)

	(method (init)
		(self
			createPoly: 0 84 15 84 22 95 19 97 9 97 10 127 29 132 29 137 0 143 0 85
		)
		(super init: &rest)
	)
)

