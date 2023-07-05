;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21320)
(include sci.sh)
(use Main)

(public
	rm21v320 0
)

(instance rm21v320 of ShiversRoom
	(properties
		picture 21320
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21310
	)
)

