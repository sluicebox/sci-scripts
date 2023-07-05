;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35130)
(include sci.sh)
(use Main)

(public
	rm35v130 0
)

(instance rm35v130 of ShiversRoom
	(properties
		picture 35130
	)

	(method (init)
		(efExitDesk init: 3)
		(efExitJukebox init: 3)
		(efExitDown init: 5)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 35160
	)

	(method (init)
		(self
			createPoly:
				32
				54
				40
				118
				65
				125
				95
				118
				91
				105
				126
				102
				132
				49
				31
				49
				32
				54
		)
		(super init: &rest)
	)
)

(instance efExitJukebox of ExitFeature
	(properties
		nextRoom 35150
	)

	(method (init)
		(self
			createPoly: 167 97 236 104 241 45 209 15 202 15 172 40 166 62 166 97
		)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35100
	)

	(method (init)
		(self createPoly: 37 142 37 127 218 127 218 142 38 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35140
	)
)

