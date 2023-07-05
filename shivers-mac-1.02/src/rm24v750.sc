;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24750)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm24v750 0
)

(instance rm24v750 of ShiversRoom
	(properties
		picture 24750
	)

	(method (init)
		(if (IsFlag 67)
			(self picture: 24751)
			(if (!= [global118 31] 0)
				(vPotView init:)
			)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (== gPrevRoomNum 23600) ; rm23v600
			(proc951_9 22401)
			(gSounds play: 22401 -1 98 0)
		)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance vPotView of View
	(properties
		x 116
		y 111
		view 0
	)

	(method (init)
		(self view: [global118 31] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 13 scaleY: 13 setPri: 10)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24410
	)

	(method (init)
		(self createPoly: 96 37 155 37 155 143 98 143 95 143 95 37)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24760
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24760
	)
)

