;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1132)
(include sci.sh)
(use Main)

(public
	rm1v132 0
)

(instance rm1v132 of ShiversRoom
	(properties
		picture 1132
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitTrail init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1125
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1131
	)

	(method (init)
		(self createPoly: 236 1 262 1 262 29 244 42 236 65 236 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1121
	)

	(method (init)
		(self createPoly: 171 129 177 76 163 69 150 91 127 91 109 111 120 128)
		(super init: &rest)
	)
)

(instance efExitTrail of ExitFeature
	(properties
		nextRoom 1111
	)

	(method (init)
		(self
			createPoly:
				198
				144
				214
				116
				241
				110
				241
				86
				231
				82
				236
				66
				244
				34
				359
				30
				259
				144
		)
		(super init: &rest)
	)
)

