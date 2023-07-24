;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21220)
(include sci.sh)
(use Main)

(public
	rm21v220 0
)

(instance rm21v220 of ShiversRoom
	(properties
		picture 21220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForwardRightPlaque init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21170
	)

	(method (init)
		(self
			createPoly: 71 106 71 91 105 25 122 0 161 0 218 85 222 115 210 119 206 121 71 107
		)
		(super init: &rest)
	)
)

(instance efExitForwardRightPlaque of ExitFeature
	(properties
		nextRoom 21141
	)

	(method (init)
		(self
			createPoly: 206 82 188 82 188 112 179 119 179 121 196 125 203 125 213 122 213 118 206 112 206 82
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21230
	)
)

