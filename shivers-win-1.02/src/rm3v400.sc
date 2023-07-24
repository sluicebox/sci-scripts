;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3400)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm3v400 0
)

(instance rm3v400 of ShiversRoom
	(properties
		picture 3400
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 4000) ; rm4v000
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3330
	)

	(method (init)
		(self
			createPoly: 104 119 79 118 68 102 70 85 81 77 80 55 75 50 75 47 97 47 89 36 94 32 128 29 136 35 134 39 125 49 121 79 182 87 189 97 229 107 224 120
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20402 0 1 30 1 self)
			)
			(1
				(proc951_10 20402)
				(= cycles 1)
			)
			(2
				(proc951_7 10318)
				(proc951_9 10318)
				(gSounds play: 10318 -1 0 0)
				(gSounds fade: 10318 32 15 15 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

