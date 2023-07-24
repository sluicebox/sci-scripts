;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21230)
(include sci.sh)
(use Main)

(public
	rm21v230 0
)

(instance rm21v230 of ShiversRoom
	(properties
		picture 21230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitForwardLeftPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21140
	)

	(method (init)
		(self
			createPoly: 202 137 200 122 185 117 167 16 163 2 92 0 83 119 63 141 203 139
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeftPlaque of ExitFeature
	(properties
		nextRoom 21141
	)

	(method (init)
		(self
			createPoly: 65 75 47 75 47 102 38 112 38 115 44 118 61 119 72 115 72 111 66 105 66 75
		)
		(super init: &rest)
	)
)

