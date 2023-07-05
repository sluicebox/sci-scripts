;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13187)
(include sci.sh)
(use Main)

(public
	rm13v187 0
)

(instance rm13v187 of ShiversRoom
	(properties
		picture 13590
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13186
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13189
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13211
	)

	(method (init)
		(self createPoly: 36 142 36 12 191 12 191 130 200 142)
		(super init: &rest)
	)
)

