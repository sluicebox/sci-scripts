;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8340)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm8v340 0
)

(instance rm8v340 of ShiversRoom
	(properties
		picture 8341
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(ladder init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8300
	)
)

(instance ladder of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 8340
	)

	(method (init)
		(if (IsFlag 34)
			(= cel 5)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 146)
		(if (not (IsFlag 34))
			(gSounds play: 10803 0 32 0)
			(self cycleSpeed: 12 setCycle: End)
			(SetFlag 34)
		)
	)
)

