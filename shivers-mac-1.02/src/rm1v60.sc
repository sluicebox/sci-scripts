;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1060)
(include sci.sh)
(use Main)

(public
	rm1v60 0
)

(instance rm1v60 of ShiversRoom
	(properties
		picture 1060
	)

	(method (init)
		(gSounds fade: 10111 98 1 40 0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1061
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1070
	)

	(method (init)
		(self
			createPoly: 103 143 117 111 66 85 102 79 109 24 130 24 138 82 160 82 160 88 95 88 156 110 168 143
		)
		(super init: &rest)
	)
)

