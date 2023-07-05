;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37060)
(include sci.sh)
(use Main)

(public
	rm37v060 0
)

(instance rm37v060 of ShiversRoom
	(properties
		picture 37060
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37050
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37040
	)

	(method (init)
		(self createPoly: 87 117 87 85 99 52 142 47 141 68 154 68 165 120)
		(super init: &rest)
	)
)

