;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4020)
(include sci.sh)
(use Main)

(public
	rm4v020 0
)

(instance rm4v020 of ShiversRoom
	(properties
		picture 4220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4000
	)

	(method (init)
		(self
			createPoly: 89 108 117 82 117 67 121 57 126 51 129 50 134 50 138 53 144 57 148 61 148 68 148 78 147 81 146 83 157 86 179 106
		)
		(super init: &rest)
	)
)

