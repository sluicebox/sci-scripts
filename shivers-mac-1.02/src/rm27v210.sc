;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v210 0
)

(instance rm27v210 of ShiversRoom
	(properties
		picture 27210
	)

	(method (init)
		(if (IsFlag 6)
			(= picture 27402)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27201
	)

	(method (init)
		(self createPoly: 92 142 114 46 151 46 172 142 93 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27214
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27212
	)
)

