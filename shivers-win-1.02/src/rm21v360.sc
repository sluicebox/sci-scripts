;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21360)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v360 0
)

(instance rm21v360 of ShiversRoom
	(properties
		picture 21360
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(if (<= 1000 gPrevRoomNum 21000) ; rm1v00
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
		)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 12021 0 82 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom)
		(proc951_1 2)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21370
	)

	(method (init)
		(self
			createPoly:
				186
				140
				179
				125
				179
				14
				84
				14
				84
				124
				72
				139
				70
				141
				187
				141
		)
		(super init: &rest)
	)
)

