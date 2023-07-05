;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v020 0
)

(instance rm8v020 of ShiversRoom
	(properties
		picture 8020
	)

	(method (init)
		(if (and (proc951_11 1 8000) (or (== gPrevRoomNum 8060) (== gPrevRoomNum 8120))) ; rm8v060, rm8v120
			(proc951_7 20801)
			(proc951_9 20801)
			(gSounds play: 20801 -1 0 0)
			(gSounds fade: 20801 66 5 16 0 0)
			(gSounds fade: 20802 0 5 8 1 0)
		)
		(if (IsFlag 43)
			(gSounds play: 10810 0 40 0)
			(ClearFlag 43)
		)
		(efExitStand init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8580
	)

	(method (init)
		(self
			createPoly:
				73
				143
				88
				121
				88
				89
				93
				84
				159
				88
				156
				88
				155
				121
				164
				143
				73
				143
		)
		(super init: &rest)
	)
)

(instance efExitStand of ExitFeature
	(properties
		nextRoom 8520
	)

	(method (init)
		(self
			createPoly:
				57
				121
				76
				118
				82
				113
				83
				57
				46
				57
				34
				78
				38
				83
				44
				83
				45
				117
				50
				119
		)
		(super init: &rest)
	)
)

