;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27071)
(include sci.sh)
(use Main)

(public
	rm27v071 0
)

(instance rm27v071 of ShiversRoom
	(properties
		picture 27071
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
		nextRoom 27061
	)

	(method (init)
		(self createPoly: 92 142 105 37 161 37 175 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27072
	)
)

