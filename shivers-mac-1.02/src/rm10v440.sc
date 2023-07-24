;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10440)
(include sci.sh)
(use Main)

(public
	rm10v440 0
)

(instance rm10v440 of ShiversRoom
	(properties
		picture 10440
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10470
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10450
	)

	(method (init)
		(self
			createPoly: 77 141 89 122 69 103 63 75 66 52 89 26 117 16 158 18 187 31 200 49 204 73 197 99 182 114 176 118 192 142
		)
		(super init: &rest)
	)
)

