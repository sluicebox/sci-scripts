;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10450)
(include sci.sh)
(use Main)

(public
	rm10v450 0
)

(instance rm10v450 of ShiversRoom
	(properties
		picture 10450
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 0)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 16000) ; rm16v00
			(gSounds fadeChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10460
	)
)

(instance efExitForward of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 91 125 89 55 183 55 180 126)
		(super init: &rest)
	)
)

