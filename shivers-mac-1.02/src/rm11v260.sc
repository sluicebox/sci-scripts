;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11260)
(include sci.sh)
(use Main)

(public
	rm11v260 0
)

(instance rm11v260 of ShiversRoom
	(properties
		picture 11260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11240
	)

	(method (init)
		(self
			createPoly: 134 142 53 142 27 83 27 52 54 53 63 61 61 95 71 107 138 106
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 11500
	)

	(method (init)
		(self createPoly: 135 143 136 131 155 122 175 121 171 83 206 84 206 143)
		(super init: &rest)
	)
)

