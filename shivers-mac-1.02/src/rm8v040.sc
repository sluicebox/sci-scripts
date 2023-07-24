;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v040 0
)

(instance rm8v040 of ShiversRoom
	(properties
		picture 8040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitCandles init: 3)
		(efExitForward init: 9)
		(if (proc951_11 1 8000)
			(proc951_9 20802)
			(gSounds play: 20802 -1 50 0)
			(gSounds fade: 20801 0 5 16 1 0)
		)
		(if (IsFlag 43)
			(gSounds play: 10810 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 1 8000) (<= 8000 newRoomNumber 8030)) ; rm8v000, rm8v030
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
		nextRoom 8030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8000
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8110
	)

	(method (init)
		(self
			createPoly: 89 142 107 118 105 86 98 86 98 59 169 59 169 83 174 87 174 118 196 142
		)
		(super init: &rest)
	)
)

(instance efExitCandles of ExitFeature
	(properties
		nextRoom 8160
	)

	(method (init)
		(self
			createPoly: 172 74 184 98 184 119 212 119 214 87 230 75 230 56 212 37 191 37 172 57
		)
		(super init: &rest)
	)
)

