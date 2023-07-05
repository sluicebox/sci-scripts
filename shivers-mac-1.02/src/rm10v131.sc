;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10131)
(include sci.sh)
(use Main)

(public
	rm10v131 0
)

(instance rm10v131 of ShiversRoom
	(properties
		picture 10131
	)

	(method (init)
		(if (== gPrevRoomNum 10132) ; rm10v132
			(gSounds play: 10621 0 82 0)
		)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitNote init: 0)
		(efExitUp init: 4)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10510
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 40
		nextRoom 10130
	)
)

(instance efExitNote of ExitFeature
	(properties
		nextRoom 10132
	)

	(method (init)
		(self createPoly: 149 109 174 77 240 90 214 125)
		(super init: &rest)
	)
)

