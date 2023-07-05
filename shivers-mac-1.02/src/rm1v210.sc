;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v210 0
)

(instance rm1v210 of ShiversRoom
	(properties
		picture 1210
	)

	(method (init)
		(gSounds fade: 10114 0 1 40 1 0)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 58 1 100 0 0)
		(efExitSymbol init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitSymbol of ExitFeature
	(properties
		nextRoom 1213
	)

	(method (init)
		(self createPoly: 39 73 60 71 60 99 39 99)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1211
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1212
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 21
		nsTop 120
		nsRight 243
		nsBottom 144
		nextRoom 1214
	)

	(method (init)
		(if (IsFlag 1)
			(= nextRoom 1220)
		)
		(super init: &rest)
	)
)

