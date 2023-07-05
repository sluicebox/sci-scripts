;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1112)
(include sci.sh)
(use Main)

(public
	rm1v112 0
)

(instance rm1v112 of ShiversRoom
	(properties
		picture 1112
	)

	(method (init)
		(gSounds fade: 10124 0 1 40 1 0)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitTrail init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1111
	)

	(method (init)
		(self createPoly: 1 1 20 1 20 84 1 84)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1111
	)
)

(instance efExitTrail of ExitFeature
	(properties
		nextRoom 1130
	)

	(method (init)
		(self createPoly: 1 143 1 104 21 94 60 88 61 92 38 98 13 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1122
	)

	(method (init)
		(self
			createPoly:
				66
				132
				75
				111
				60
				79
				120
				81
				135
				107
				176
				118
				176
				142
				116
				142
		)
		(super init: &rest)
	)
)

