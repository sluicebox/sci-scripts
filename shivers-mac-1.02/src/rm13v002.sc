;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13002)
(include sci.sh)
(use Main)

(public
	rm13v002 0
)

(instance rm13v002 of ShiversRoom
	(properties
		picture 13030
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
		nextRoom 13003
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13003
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13006
	)

	(method (init)
		(self createPoly: 57 142 57 23 174 23 174 113 195 142)
		(super init: &rest)
	)
)

