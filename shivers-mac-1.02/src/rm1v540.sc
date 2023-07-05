;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1540)
(include sci.sh)
(use Main)

(public
	rm1v540 0
)

(instance rm1v540 of ShiversRoom
	(properties
		picture 1540
	)

	(method (init)
		(gSounds setVol: 30110 20)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1521
	)

	(method (init)
		(self
			createPoly:
				72
				112
				86
				97
				81
				21
				97
				26
				153
				28
				153
				85
				185
				142
				128
				142
				103
				124
				85
				124
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1530
	)
)

