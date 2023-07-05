;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15070)
(include sci.sh)
(use Main)

(public
	rm15v7 0
)

(instance rm15v7 of ShiversRoom
	(properties
		picture 15070
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
		nextRoom 15080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15050
	)

	(method (init)
		(self
			createPoly: 75 143 96 125 96 67 116 61 143 62 174 68 174 133 184 142
		)
		(super init: &rest)
	)
)

