;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v18 0
)

(instance rm14v18 of ShiversRoom
	(properties
		picture 14180
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitTar init: 9)
		(efExitForward init: 9)
		(if (proc951_11 3 14000)
			(proc951_9 21402)
			(gSounds play: 21402 -1 66 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 3 14000) (> newRoomNumber 14100)) ; rm14v10
			(gSounds fade: 21402 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14190
	)
)

(instance efExitTar of ExitFeature
	(properties
		nextRoom 14100
	)

	(method (init)
		(self createPoly: 147 115 125 136 39 136 30 94 45 50 122 50)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14090
	)

	(method (init)
		(self createPoly: 190 115 190 53 215 43 241 52 239 128)
		(super init: &rest)
	)
)

