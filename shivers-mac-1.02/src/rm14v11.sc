;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v11 0
)

(instance rm14v11 of ShiversRoom
	(properties
		picture 14110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitStatue init: 9)
		(efExitSkull init: 9)
		(if (and (proc951_11 3 14000) (< 14120 gPrevRoomNum 14270)) ; rm14v12, rm14v270
			(proc951_9 21402)
			(gSounds play: 21402 -1 66 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 3 14000) (>= newRoomNumber 14170)) ; rm14v17
			(gSounds fade: 21402 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14100
	)
)

(instance efExitStatue of ExitFeature
	(properties
		nextRoom 14190
	)

	(method (init)
		(self
			createPoly:
				11
				112
				23
				106
				20
				80
				23
				72
				20
				52
				9
				45
				12
				41
				35
				39
				45
				40
				48
				53
				44
				73
				121
				70
				124
				76
				110
				105
				129
				109
				129
				115
				45
				120
		)
		(super init: &rest)
	)
)

(instance efExitSkull of ExitFeature
	(properties
		nextRoom 14170
	)

	(method (init)
		(self
			createPoly: 230 99 220 99 200 82 200 72 217 56 228 56 245 66 245 75
		)
		(super init: &rest)
	)
)

