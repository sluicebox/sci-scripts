;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v170 0
)

(instance rm8v170 of ShiversRoom
	(properties
		picture 8170
	)

	(method (init)
		(if (proc951_11 1 8000)
			(if (!= gPrevRoomNum 8160) ; rm8v160
				(gSounds stop: 20803)
			)
			(proc951_7 20803)
			(proc951_9 20803)
			(gSounds play: 20803 -1 50 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitSecret init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 1 8000) (!= newRoomNumber 8160)) ; rm8v160
			(gSounds fade: 20803 0 5 8 1 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8120
	)

	(method (init)
		(self
			createPoly:
				243
				7
				243
				18
				254
				18
				254
				129
				237
				129
				237
				142
				262
				142
				262
				7
				243
				7
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8220
	)

	(method (init)
		(self createPoly: 227 99 227 139 54 139 54 3 236 3 227 98)
		(super init: &rest)
	)
)

(instance efExitSecret of ExitFeature
	(properties
		nextRoom 8270
	)

	(method (init)
		(self createPoly: 253 19 253 128 236 128 240 18 247 18)
		(super init: &rest)
	)
)

