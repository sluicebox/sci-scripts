;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2200)
(include sci.sh)
(use Main)

(public
	rm2v20 0
)

(instance rm2v20 of ShiversRoom
	(properties
		picture 2200
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
		nextRoom 2210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2180
	)

	(method (init)
		(self
			createPoly: 36 142 39 121 57 117 59 97 104 97 106 75 113 69 127 67 141 67 152 74 154 97 193 97 194 117 211 122 213 142
		)
		(super init: &rest)
	)
)

