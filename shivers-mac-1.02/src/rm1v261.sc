;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1261)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v261 0
)

(instance rm1v261 of ShiversRoom
	(properties
		picture 1261
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 34 1 40 0 0)
		(gSounds fade: 10112 0 1 40 1 0)
		(if (IsFlag 33)
			(vLetter init:)
		)
		(efExitLeft init: 7)
		(efExitLeftHigh init: 7)
		(efExitLeftSign init: 3)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance vLetter of View
	(properties
		priority 20
		fixPriority 1
		view 1261
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1260
	)

	(method (init)
		(self createPoly: 1 103 20 110 20 143 1 143)
		(super init: &rest)
	)
)

(instance efExitLeftHigh of ExitFeature
	(properties
		nextRoom 1260
	)

	(method (init)
		(self createPoly: 1 60 20 56 20 1 1 1)
		(super init: &rest)
	)
)

(instance efExitLeftSign of ExitFeature
	(properties
		nextRoom 1030
	)

	(method (init)
		(self createPoly: 1 61 30 51 30 111 1 102)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self
			createPoly:
				94
				143
				108
				114
				163
				100
				173
				82
				172
				46
				185
				35
				205
				35
				220
				44
				221
				86
				242
				96
				182
				107
				156
				119
				169
				143
		)
		(super init: &rest)
	)
)

