;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1004)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v04 0
)

(instance rm1v04 of ShiversRoom
	(properties
		picture 1004
	)

	(method (init)
		(gSounds play: 10102 0 82 0)
		(proc951_16 21)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 1003
	)

	(method (init)
		(self
			createPoly:
				4
				1
				38
				1
				41
				9
				41
				140
				162
				140
				162
				100
				219
				92
				221
				1
				263
				0
				263
				143
				0
				143
				0
				1
				4
				1
		)
		(super init: &rest)
	)
)

