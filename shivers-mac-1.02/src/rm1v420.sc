;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1420)
(include sci.sh)
(use Main)

(public
	rm1v420 0
)

(instance rm1v420 of ShiversRoom
	(properties
		picture 1420
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1423
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1421
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1401
	)

	(method (init)
		(self
			createPoly:
				13
				145
				86
				122
				100
				85
				98
				52
				104
				50
				182
				85
				197
				93
				193
				124
				262
				142
		)
		(super init: &rest)
	)
)

