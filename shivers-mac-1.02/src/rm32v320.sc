;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v320 0
)

(instance rm32v320 of ShiversRoom
	(properties
		picture 32320
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32321)
		else
			(= picture 32320)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32400
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32440
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

