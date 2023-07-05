;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13018)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v018 0
)

(instance rm13v018 of ShiversRoom
	(properties
		picture 13180
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 13021) ; rm13v021
			(gSounds fade: 21301 0 10 8 1 0)
			(proc951_9 21302)
			(gSounds play: 21302 -1 0 0)
			(gSounds fade: 21302 114 10 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13021
	)

	(method (init)
		(self createPoly: 80 123 80 19 175 19 175 122)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13601
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13602
	)
)

