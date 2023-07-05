;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13520)
(include sci.sh)
(use Main)

(public
	rm13v520 0
)

(instance rm13v520 of ShiversRoom
	(properties
		picture 13930
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
		nextRoom 13521
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13521
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13518
	)

	(method (init)
		(self
			createPoly:
				114
				63
				109
				96
				29
				121
				29
				143
				229
				143
				229
				130
				147
				95
				144
				63
				114
				63
		)
		(super init: &rest)
	)
)

