;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13260)
(include sci.sh)
(use Main)

(public
	rm13v260 0
)

(instance rm13v260 of ShiversRoom
	(properties
		picture 13350
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13261
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13259
	)
)

