;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v21 0
)

(instance rm14v21 of ShiversRoom
	(properties
		picture 14210
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (>= gPrevRoomNum 15000)
			(proc951_9 21401)
			(gSounds fade: 21401 34 15 8 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14070
	)

	(method (init)
		(self
			createPoly:
				107
				143
				76
				97
				111
				76
				110
				61
				111
				23
				121
				19
				132
				23
				132
				60
				139
				73
				112
				93
				112
				98
				152
				122
				165
				143
		)
		(super init: &rest)
	)
)

