;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37270)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v270 0
)

(instance rm37v270 of ShiversRoom
	(properties
		picture 37270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efWardrobe init: 3)
		(if (proc951_11 9 37000)
			(proc951_9 21111)
			(gSounds play: 21111 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (!= newRoomNumber 37291)) ; rm37v291
			(gSounds fade: 21111 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37280
	)

	(method (init)
		(self
			createPoly:
				263
				0
				243
				0
				243
				37
				255
				27
				255
				140
				243
				133
				243
				143
				263
				143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37291
	)

	(method (init)
		(self createPoly: 165 133 173 28 204 8 239 18 241 137 211 144 190 146)
		(super init: &rest)
	)
)

(instance efWardrobe of ExitFeature
	(properties
		nextRoom 37370
	)

	(method (init)
		(self createPoly: 76 28 20 22 20 132 44 133 80 114)
		(super init: &rest)
	)
)

