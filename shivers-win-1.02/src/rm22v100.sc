;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v100 0
)

(instance rm22v100 of ShiversRoom
	(properties
		picture 22100
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(super init: &rest)
		(if (proc951_11 1 22000)
			(proc951_9 20803)
			(gSounds play: 20803 -1 0 0)
			(gSounds fade: 20803 50 5 16 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 22260) (proc951_11 1 22000)) ; rm22v260
			(gSounds fade: 20803 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22260
	)

	(method (init)
		(self createPoly: 177 52 156 52 141 135 141 142 196 142 184 52 175 52)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22120
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 22820
	)

	(method (init)
		(self createPoly: 52 105 83 105 79 118 46 118 52 106)
		(super init: &rest)
	)
)

