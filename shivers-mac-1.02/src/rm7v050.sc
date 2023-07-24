;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7050)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v050 0
)

(instance rm7v050 of ShiversRoom
	(properties
		picture 7050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7070
	)

	(method (init)
		(self
			createPoly: 91 59 91 92 113 91 70 142 186 143 155 98 156 86 211 85 210 18 129 17 129 60
		)
		(super init: &rest)
	)
)

