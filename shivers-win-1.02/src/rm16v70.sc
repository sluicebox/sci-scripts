;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16070)
(include sci.sh)
(use Main)

(public
	rm16v70 0
)

(instance rm16v70 of ShiversRoom
	(properties
		picture 16070
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16200
	)

	(method (init)
		(self createPoly: 87 144 129 103 155 95 158 51 189 51 185 90 209 142)
		(super init: &rest)
	)
)

