;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v200 0
)

(instance rm24v200 of ShiversRoom
	(properties
		picture 24200
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24201)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24260
	)

	(method (init)
		(self createPoly: 73 52 73 139 172 139 172 54 73 52)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24180
	)
)

