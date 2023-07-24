;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39120)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm39v120 0
)

(instance rm39v120 of ShiversRoom
	(properties
		picture 39120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(efExitForwardLeft init: 3)
		(cond
			((IsFlag 80)
				(= picture 39121)
			)
			((== global547 9)
				((View new:) view: 39120 setPri: 1 1 init:)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (> newRoomNumber -26416)
			(gSounds fade: 23901 26 5 16 0 0)
			(gSounds fade: 23902 42 5 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39110
	)

	(method (init)
		(self
			createPoly: 231 3 231 44 235 39 247 30 259 23 262 23 262 121 226 121 226 142 264 142 264 0 231 0
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 39150
	)

	(method (init)
		(self
			createPoly: 54 16 54 141 119 141 119 95 128 85 147 84 147 15 54 15
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 39180
	)

	(method (init)
		(self createPoly: 262 118 225 117 228 64 235 48 246 37 263 30 263 118)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 39140
	)

	(method (init)
		(self createPoly: 33 15 33 118 52 106 52 15 34 15)
		(super init: &rest)
	)
)

