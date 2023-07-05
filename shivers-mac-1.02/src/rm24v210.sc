;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v210 0
)

(instance rm24v210 of ShiversRoom
	(properties
		picture 24210
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 0)
		(if (== newRoomNumber 24110) ; rm24v110
			(if (proc951_11 5 24000)
				(gSounds fade: 22404 0 5 15 1 0)
			else
				(gSounds fade: 22402 0 6 30 1 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24110
	)

	(method (init)
		(self createPoly: 101 52 101 142 155 142 155 52 101 52)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24200
	)
)

