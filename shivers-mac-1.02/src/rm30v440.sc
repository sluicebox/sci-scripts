;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30440)
(include sci.sh)
(use Main)
(use n951)
(use Actor)
(use System)

(public
	rm30v440 0
)

(instance rm30v440 of ShiversRoom
	(properties
		picture 30440
	)

	(method (init)
		(cond
			((IsFlag 58)
				(self picture: 30444)
				(if (!= [global118 39] 0)
					(vPotView init:)
				)
			)
			((IsFlag 85)
				(self picture: 30441)
			)
		)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
		(cond
			((> gPrevRoomNum 32000)
				(gCurRoom setScript: sEnter)
			)
			((IsFlag 43)
				(gSounds play: 13014 0 82 0)
				(ClearFlag 43)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30390
	)

	(method (init)
		(self createPoly: 152 25 248 27 248 112 152 112 152 25)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 212
		y 73
		view 0
	)

	(method (init)
		(self view: [global118 39] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 13 scaleY: 13 setPri: 10)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 33250)
				(gSounds fade: 23201 0 6 30 1 self)
				(gSounds play: 13014 0 82 0)
				(ClearFlag 43)
			)
			(1
				(proc951_10 23201)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(proc951_7 23001)
				(proc951_9 23001)
				(gSounds play: 23001 -1 82 0)
				(self dispose:)
			)
		)
	)
)

