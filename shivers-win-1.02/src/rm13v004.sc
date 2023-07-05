;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13004)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v004 0
)

(instance rm13v004 of ShiversRoom
	(properties
		picture 13070
	)

	(method (init)
		(if (IsFlag 31)
			(self picture: 13071)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13007
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13005
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13008
	)

	(method (init)
		(self createPoly: 67 141 107 98 107 44 158 44 158 97 192 141)
		(super init: &rest)
	)
)

