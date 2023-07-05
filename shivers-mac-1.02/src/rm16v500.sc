;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16500)
(include sci.sh)
(use Main)

(public
	rm16v500 0
)

(instance rm16v500 of ShiversRoom
	(properties
		picture 16500
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16710
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 16510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16150
	)

	(method (init)
		(self
			createPoly:
				91
				142
				93
				110
				79
				96
				84
				95
				85
				65
				94
				49
				160
				49
				170
				109
				222
				146
		)
		(super init: &rest)
	)
)

