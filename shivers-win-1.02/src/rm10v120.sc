;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10120)
(include sci.sh)
(use Main)

(public
	rm10v120 0
)

(instance rm10v120 of ShiversRoom
	(properties
		picture 10120
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitID init: 5)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10530
	)

	(method (init)
		(self createPoly: 220 0 263 0 263 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10130
	)

	(method (init)
		(self
			createPoly: 183 130 85 130 69 117 52 80 65 40 89 22 103 14 164 14 183 24 207 44 214 63 215 90 206 116 195 127
		)
		(super init: &rest)
	)
)

(instance efExitID of ExitFeature
	(properties
		nextRoom 10121
	)

	(method (init)
		(self createPoly: 133 143 128 131 100 131 91 143)
		(super init: &rest)
	)
)

