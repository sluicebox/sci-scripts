;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39090)
(include sci.sh)
(use Main)
(use n951)

(public
	rm39v090 0
)

(instance rm39v090 of ShiversRoom
	(properties
		picture 39090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 13909 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39180
	)

	(method (init)
		(self
			createPoly: 263 0 243 0 243 46 263 46 263 114 243 114 243 143 263 143
		)
		(super init: &rest)
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39170
	)

	(method (init)
		(self createPoly: 102 124 110 113 111 45 218 43 223 116 226 126)
		(super init: &rest)
	)
)

