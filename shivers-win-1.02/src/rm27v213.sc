;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27213)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v213 0
)

(instance rm27v213 of ShiversRoom
	(properties
		picture 27213
	)

	(method (init)
		(if (IsFlag 6)
			(= picture 27403)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27221
	)

	(method (init)
		(self createPoly: 89 142 121 57 143 57 174 142 89 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27212
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27214
	)
)

