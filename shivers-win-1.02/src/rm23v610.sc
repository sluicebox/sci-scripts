;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23610)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v610 0
)

(instance rm23v610 of ShiversRoom
	(properties
		picture 23610
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23690
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23600
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23650
	)

	(method (init)
		(self
			createPoly: 138 58 116 58 98 82 98 98 121 117 139 117 153 99 153 70 139 58
		)
		(super init: &rest)
	)
)

