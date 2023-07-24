;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9360)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v36 0
)

(instance rm9v36 of ShiversRoom
	(properties
		picture 9360
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitPuzzle init: 9)
		(efExitDoor init: 9)
		(pFountain init:)
		(if (IsFlag 42)
			(if (== gPrevRoomNum 9320) ; rm9v32
				(PrintDebug {fade to 26})
				(gSounds fade: 10908 26 15 8 0 0)
			)
			(if (proc951_11 0 9000)
				(gSounds fade: 20903 0 10 16 1 0)
				(gSounds stop: 20908)
				(proc951_9 20908)
				(gSounds play: 20908 -1 50 0)
			)
			((Prop new:)
				view: 9360
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9360 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 9390) (IsFlag 42) (proc951_11 0 9000)) ; rm9v39
			(gSounds fade: 20908 0 10 16 1 0)
			(gSounds stop: 20903)
			(proc951_9 20903)
			(gSounds play: 20903 -1 0 0)
			(gSounds fade: 20903 42 10 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9340
	)

	(method (init)
		(self
			createPoly: 240 0 240 30 264 30 264 114 240 114 240 144 265 144 265 0 240 0
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9390
	)

	(method (init)
		(self
			createPoly: 175 104 175 82 232 35 263 35 263 118 201 118 222 141 130 141 141 118
		)
		(super init: &rest)
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 9420
	)

	(method (init)
		(self createPoly: 84 87 83 33 157 34 156 103 118 117)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 9470
	)

	(method (init)
		(self createPoly: 13 92 13 34 53 34 53 91)
		(super init: &rest)
	)
)

(instance pFountain of ShiversProp
	(properties
		priority 3
		fixPriority 1
		view 9360
	)
)

