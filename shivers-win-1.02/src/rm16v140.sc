;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16140)
(include sci.sh)
(use Main)

(public
	rm16v140 0
)

(instance rm16v140 of ShiversRoom
	(properties
		picture 16140
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 16130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16710
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16120
	)

	(method (init)
		(self
			createPoly:
				1
				142
				43
				106
				42
				40
				54
				43
				55
				92
				57
				95
				78
				77
				78
				41
				121
				41
				121
				76
				121
				91
				141
				109
				226
				142
		)
		(super init: &rest)
	)
)

