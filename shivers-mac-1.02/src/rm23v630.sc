;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23630)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v630 0
)

(instance rm23v630 of ShiversRoom
	(properties
		picture 23630
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23600
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23690
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23370
	)

	(method (init)
		(self
			createPoly: 207 1 207 110 196 110 196 120 184 120 184 131 194 142 240 142 240 0 207 0
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23950
	)

	(method (init)
		(self createPoly: 116 106 133 103 141 111 126 116 116 107)
		(super init: &rest)
	)
)

