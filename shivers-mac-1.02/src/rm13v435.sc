;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13435)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v435 0
)

(instance rm13v435 of ShiversRoom
	(properties
		picture 13170
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 13432) ; rm13v432
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
		nextRoom 13432
	)

	(method (init)
		(self createPoly: 92 120 92 22 184 22 184 121)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13605
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13606
	)
)

