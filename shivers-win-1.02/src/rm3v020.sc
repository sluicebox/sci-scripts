;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3020)
(include sci.sh)
(use Main)

(public
	rm3v020 0
)

(instance rm3v020 of ShiversRoom
	(properties
		picture 3020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (and (!= gPrevRoomNum 990) (< gPrevRoomNum 3000)) ; shiversOptions
			(gSounds play: 10318 -1 0 0)
			(gSounds fade: 10318 32 15 15 0 0)
			(gSounds play: 10320 0 64 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3060
	)

	(method (init)
		(self
			createPoly: 73 118 86 91 111 57 162 56 173 63 192 95 192 109 145 117
		)
		(super init: &rest)
	)
)

