;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37123)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v123 0
)

(instance rm37v123 of ShiversRoom
	(properties
		picture 37123
	)

	(method (init)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitDesk init: 3)
		(super init: &rest)
		(if (proc951_11 9 37000)
			(gSounds fade: 23701 0 5 16 1 0)
			(proc951_9 23702)
			(gSounds play: 23702 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (!= newRoomNumber 37270)) ; rm37v270
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37122
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37270
	)

	(method (init)
		(self
			createPoly: 58 144 92 111 72 111 77 58 118 35 148 33 209 73 197 106 143 106 143 143
		)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 37251
	)

	(method (init)
		(self createPoly: 0 111 89 112 58 143 0 143 0 111)
		(super init: &rest)
	)
)

