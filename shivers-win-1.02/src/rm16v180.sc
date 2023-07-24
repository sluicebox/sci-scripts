;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16180)
(include sci.sh)
(use Main)

(public
	rm16v180 0
)

(instance rm16v180 of ShiversRoom
	(properties
		picture 16180
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16160
	)

	(method (init)
		(self
			createPoly: 20 142 54 94 105 62 105 17 243 17 243 52 154 52 136 108 159 143
		)
		(super init: &rest)
	)
)

