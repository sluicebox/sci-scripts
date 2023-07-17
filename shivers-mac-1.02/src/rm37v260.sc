;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37260)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v260 0
)

(instance rm37v260 of ShiversRoom
	(properties
		picture 37260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efWardrobe init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (not (<= -28286 newRoomNumber -28166)))
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37270
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
		nextRoom 37140
	)

	(method (init)
		(self
			createPoly: 84 119 91 82 109 81 116 76 118 57 157 56 162 96 193 120
		)
		(super init: &rest)
	)
)

(instance efWardrobe of ExitFeature
	(properties
		nextRoom 37370
	)

	(method (init)
		(self createPoly: 237 130 237 42 243 37 255 27 255 140)
		(super init: &rest)
	)
)

