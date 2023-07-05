;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32520)
(include sci.sh)
(use Main)
(use n951)
(use n32001)

(public
	rm32v520 0
)

(instance rm32v520 of ShiversRoom
	(properties
		picture 32520
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 32670) (IsFlag 63)) ; rm32v670
			(gSounds fade: 13215 0 5 8 1 0)
			(ClearFlag 63)
			(if (proc951_11 7 32000)
				(proc951_9 23201)
				(gSounds play: 23201 -1 0 0)
				(proc32001_0)
				(gSounds fade: 23201 82 5 16 0 0)
				(gSounds fade: 23210 0 5 16 1 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32530
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32670
	)

	(method (init)
		(self createPoly: 73 137 73 22 186 22 186 140 72 140)
		(super init: &rest)
	)
)

