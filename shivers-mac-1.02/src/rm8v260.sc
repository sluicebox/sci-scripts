;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8260)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v260 0
)

(instance rm8v260 of ShiversRoom
	(properties
		picture 8260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitCandles init: 3)
		(if (proc951_11 1 8000)
			(proc951_7 20802)
			(proc951_9 20802)
			(gSounds play: 20802 -1 50 0)
			(gSounds fade: 20801 0 5 16 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 1 8000) (<= 8250 newRoomNumber 8270)) ; rm8v250, rm8v270
			(proc951_7 20801)
			(proc951_9 20801)
			(gSounds play: 20801 -1 0 0)
			(gSounds fade: 20801 66 5 16 0 0)
			(gSounds fade: 20802 0 5 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8210
	)

	(method (init)
		(self createPoly: 63 142 78 118 108 116 108 43 184 43 179 118 195 141)
		(super init: &rest)
	)
)

(instance efExitCandles of ExitFeature
	(properties
		nextRoom 8160
	)

	(method (init)
		(self createPoly: 57 118 97 116 108 67 108 50 87 31 59 31 40 51 40 74)
		(super init: &rest)
	)
)

