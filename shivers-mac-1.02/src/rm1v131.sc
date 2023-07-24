;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1131)
(include sci.sh)
(use Main)

(public
	rm1v131 0
)

(instance rm1v131 of ShiversRoom
	(properties
		picture 1131
	)

	(method (init)
		(efExitBench init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitBench of ExitFeature
	(properties
		nextRoom 1121
	)

	(method (init)
		(self createPoly: 73 124 75 68 64 67 49 87 24 90 8 111 20 128)
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
		nextRoom 1130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1111
	)

	(method (init)
		(self
			createPoly: 98 142 118 109 163 87 174 65 184 54 195 52 211 55 222 64 229 77 229 87 199 93 170 142
		)
		(super init: &rest)
	)
)

