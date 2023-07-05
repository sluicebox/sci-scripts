;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37151)
(include sci.sh)
(use Main)

(public
	rm37v151 0
)

(instance rm37v151 of ShiversRoom
	(properties
		picture 37151
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37160
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 20
		nsTop 113
		nsRight 243
		nsBottom 143
		nextRoom 37150
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37230
	)

	(method (init)
		(self createPoly: 93 124 93 40 131 25 169 37 169 124)
		(super init: &rest)
	)
)

