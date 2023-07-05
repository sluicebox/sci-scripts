;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19150)
(include sci.sh)
(use Main)
(use n951)
(use RandCycle)
(use System)

(public
	rm19v150 0
)

(instance rm19v150 of ShiversRoom
	(properties
		picture 19150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(rustlingPlants init:)
		(super init: &rest)
		(if (and (proc951_11 8 19000) (!= gPrevRoomNum 19140) (!= gPrevRoomNum 19160)) ; rm19v140, rm19v160
			(gSounds adjChainVol: 16)
			(gSounds fade: 21909 0 15 8 1 0)
			(gSounds playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1)
			(gSounds play: 21903 -1 48 0)
		)
	)

	(method (newRoom)
		(gSounds stop: 11902)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19190
	)

	(method (init)
		(self createPoly: 91 137 110 125 116 61 123 70 209 72 209 122 186 141)
		(super init: &rest)
	)
)

(instance rustlingPlants of ShiversProp
	(properties
		x 190
		priority 255
		fixPriority 1
		view 19150
	)

	(method (init)
		(super init: &rest)
		(self setScript: movePlant)
	)
)

(instance movePlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 17))
			)
			(1
				(gSounds play: 11902 0 22 self)
				(rustlingPlants setCycle: RandCycle 68)
				(= state -1)
			)
		)
	)
)

