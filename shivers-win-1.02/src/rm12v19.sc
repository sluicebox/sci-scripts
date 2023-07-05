;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v19 0
)

(instance rm12v19 of ShiversRoom
	(properties
		picture 12190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efCastle init: 9)
		(efPlaque1 init: 3)
		(efPlaque2 init: 3)
		(if (proc951_11 8 12000)
			(proc951_7 21910)
			(gSounds play: 21910 -1 0 0)
			(gSounds fade: 21910 50 10 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 8 12000) (!= newRoomNumber 12200)) ; rm12v20
			(gSounds fade: 21910 0 10 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12140
	)
)

(instance efCastle of ExitFeature
	(properties
		nextRoom 12200
	)

	(method (init)
		(self createPoly: 85 117 96 102 96 82 159 82 159 105 171 117)
		(super init: &rest)
	)
)

(instance efPlaque1 of ExitFeature
	(properties
		nextRoom 12570
	)

	(method (init)
		(self createPoly: 50 110 18 110 25 93 56 93)
		(super init: &rest)
	)
)

(instance efPlaque2 of ExitFeature
	(properties
		nextRoom 12560
	)

	(method (init)
		(self createPoly: 206 108 203 96 208 92 224 92 235 96 239 108)
		(super init: &rest)
	)
)

