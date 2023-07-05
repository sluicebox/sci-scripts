;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19320)
(include sci.sh)
(use Main)

(public
	rm19v320 0
)

(instance rm19v320 of ShiversRoom
	(properties
		picture 19320
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
		nextRoom 19310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19200
	)

	(method (init)
		(self
			createPoly:
				88
				143
				100
				115
				100
				34
				113
				18
				141
				13
				168
				19
				181
				35
				180
				121
				198
				144
		)
		(super init: &rest)
	)
)

