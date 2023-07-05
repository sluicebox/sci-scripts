;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8410)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm8v410 0
)

(instance rm8v410 of ShiversRoom
	(properties
		picture 8411
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 34)
			(efExitLadder init: 4)
		)
		(ladder init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8370
	)
)

(instance efExitLadder of ExitFeature
	(properties
		nextRoom 8420
	)

	(method (init)
		(self createPoly: 73 0 133 0 133 62 74 62)
		(super init: &rest)
	)
)

(instance ladder of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 8410
	)

	(method (init)
		(if (IsFlag 34)
			(= cel 0)
		else
			(= cel 5)
		)
		(self createPoly: 78 143 79 95 131 97 134 142)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 34)
			(gSounds play: 10803 0 32 0)
			(self cycleSpeed: 12 setCycle: End)
			(ClearFlag 34)
			(efExitLadder dispose:)
		)
	)
)

