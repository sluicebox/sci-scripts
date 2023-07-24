;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10250)
(include sci.sh)
(use Main)

(public
	rm10v250 0
)

(instance rm10v250 of ShiversRoom
	(properties
		picture 10250
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10260
	)

	(method (init)
		(self
			createPoly: 92 121 115 90 108 85 102 74 103 65 107 57 113 52 121 48 132 47 141 47 149 51 155 56 160 63 161 70 161 76 158 82 153 87 150 90 172 120
		)
		(super init: &rest)
	)
)

