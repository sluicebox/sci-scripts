;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30080)
(include sci.sh)
(use Main)

(public
	rm30v080 0
)

(instance rm30v080 of ShiversRoom
	(properties
		picture 30080
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30110
	)

	(method (init)
		(self
			createPoly:
				123
				115
				123
				48
				186
				48
				186
				127
				195
				132
				194
				136
				110
				136
				121
				127
				124
				126
				124
				118
		)
		(super init: &rest)
	)
)

