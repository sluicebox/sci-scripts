;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v250 0
)

(instance rm37v250 of ShiversRoom
	(properties
		picture 37250
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitDesk init: 3)
		(if (and (proc951_11 9 37000) (== gPrevRoomNum 37292))
			(gSounds fade: 23701 0 5 16 1 0)
			(proc951_9 23702)
			(gSounds play: 23702 -1 66 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (not (<= -28276 newRoomNumber -28246)))
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37122
	)

	(method (init)
		(self
			createPoly:
				133
				141
				132
				192
				134
				43
				64
				43
				64
				118
				71
				118
				75
				123
				71
				132
				70
				141
				133
				141
		)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 37251
	)

	(method (init)
		(self
			createPoly:
				135
				132
				134
				95
				204
				94
				206
				88
				221
				91
				216
				97
				240
				105
				240
				132
				135
				132
		)
		(super init: &rest)
	)
)

