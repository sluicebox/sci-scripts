;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27143)
(include sci.sh)
(use Main)

(public
	rm27v143 0
)

(instance rm27v143 of ShiversRoom
	(properties
		picture 27143
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27153
	)

	(method (init)
		(self createPoly: 41 142 51 128 90 118 83 47 176 47 252 142 41 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27142
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27140
	)
)

