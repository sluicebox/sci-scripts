;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24410)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm24v410 0
)

(instance rm24v410 of ShiversRoom
	(properties
		picture 24410
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24411)
			(if (!= [global118 31] 0)
				(vPotView init:)
			)
		)
		(efExitSnake init: 3)
		(efExitCasket init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (proc951_11 1 24000)
			(proc951_9 22404)
			(gSounds play: 22404 -1 0 0)
			(gSounds fade: 22404 50 5 16 0 0)
			(gSounds fade: 22401 0 5 16 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 24420) (proc951_11 1 24000)) ; rm24v420
			(proc951_9 22401)
			(gSounds play: 22401 -1 0 0)
			(gSounds fade: 22401 98 5 16 0 0)
			(gSounds fade: 22404 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vPotView of View
	(properties
		x 110
		y 101
		view 0
	)

	(method (init)
		(self view: [global118 31] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10)
	)
)

(instance efExitSnake of ExitFeature
	(properties
		nextRoom 24420
	)

	(method (init)
		(self createPoly: 188 61 206 63 224 91 226 114 162 111 160 83 188 61)
		(super init: &rest)
	)
)

(instance efExitCasket of ExitFeature
	(properties
		nextRoom 24320
	)

	(method (init)
		(self createPoly: 87 51 135 51 136 100 153 131 90 133 87 51)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24380
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24390
	)
)

