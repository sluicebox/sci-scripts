;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17080)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v080 0
)

(instance rm17v080 of ShiversRoom
	(properties
		picture 17080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (proc951_11 9 17000)
			(proc951_7 21111)
			(gSounds play: 21111 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (!= newRoomNumber 17090)) ; rm17v090
			(gSounds fade: 21111 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17020
	)

	(method (init)
		(self createPoly: 83 143 83 17 165 5 164 143)
		(super init: &rest)
	)
)

