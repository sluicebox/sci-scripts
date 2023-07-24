;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37240)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v240 0
)

(instance rm37v240 of ShiversRoom
	(properties
		picture 37240
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
		(if (proc951_11 9 37000)
			(gSounds fade: 23701 0 5 16 1 0)
			(proc951_9 23702)
			(gSounds play: 23702 -1 66 0)
		)
		(if (IsFlag 43)
			(gSounds play: 13707 0 82 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (!= newRoomNumber 37291)) ; rm37v291
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37291
	)

	(method (init)
		(self
			createPoly: 88 135 88 36 96 23 110 21 124 23 137 32 145 41 151 127 134 135 103 136
		)
		(super init: &rest)
	)
)

