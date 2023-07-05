;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v320 0
)

(instance rm16v320 of ShiversRoom
	(properties
		picture 16320
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16324)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16370
	)

	(method (init)
		(self createPoly: 88 143 91 71 110 30 192 30 208 42 213 66 213 143)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 16329
	)
)

