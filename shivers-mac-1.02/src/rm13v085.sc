;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13085)
(include sci.sh)
(use Main)

(public
	rm13v085 0
)

(instance rm13v085 of ShiversRoom
	(properties
		picture 13510
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13084
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13086
	)
)

