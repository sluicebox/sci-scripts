;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22130)
(include sci.sh)
(use Main)

(public
	rm22v130 0
)

(instance rm22v130 of ShiversRoom
	(properties
		picture 22130
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22100
	)
)

