;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm31v320 0
)

(instance rm31v320 of ShiversRoom
	(properties
		picture 31320
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (IsFlag 43)
			(gSounds play: 13122 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31300
	)

	(method (init)
		(self createPoly: 104 116 158 116 158 57 104 58 104 116)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31440
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31440
	)
)

