;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1061)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v61 0
)

(instance rm1v61 of ShiversRoom
	(properties
		picture 1061
	)

	(method (init)
		(gSounds fade: 10124 0 1 40 1 0)
		(if (IsFlag 33)
			(vLetter init:)
		)
		(efExitMailBox init: 3)
		(efExitGate init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance vLetter of View
	(properties
		priority 20
		fixPriority 1
		view 1061
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1060
	)

	(method (init)
		(self createPoly: 216 143 216 113 262 113 262 143)
		(super init: &rest)
	)
)

(instance efExitMailBox of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self createPoly: 95 121 162 110 163 28 95 34 95 120)
		(super init: &rest)
	)
)

(instance efExitGate of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self
			createPoly:
				26
				142
				53
				128
				138
				117
				174
				106
				197
				95
				196
				34
				208
				13
				231
				3
				252
				1
				262
				1
				262
				105
				216
				112
				166
				130
				167
				139
				170
				142
		)
		(super init: &rest)
	)
)

