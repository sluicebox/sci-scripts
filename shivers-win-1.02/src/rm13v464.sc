;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13464)
(include sci.sh)
(use Main)

(public
	rm13v464 0
)

(instance rm13v464 of ShiversRoom
	(properties
		picture 13550
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13467
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13465
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13462
	)

	(method (init)
		(self createPoly: 74 142 98 113 98 30 175 30 175 112 203 142)
		(super init: &rest)
	)
)

