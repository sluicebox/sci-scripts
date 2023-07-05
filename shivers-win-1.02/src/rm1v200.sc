;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v200 0
)

(instance rm1v200 of ShiversRoom
	(properties)

	(method (init)
		(gSounds fade: 10114 0 1 40 1 0)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 58 1 100 0 0)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForwardDown init: 9)
		(if (IsFlag 1)
			(= picture 1201)
		else
			(= picture 1200)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1210
	)

	(method (init)
		(self createPoly: 89 74 186 74 186 117 89 117)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1212
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1202
	)
)

(instance efExitForwardDown of ExitFeature
	(properties
		nextRoom 1214
	)

	(method (init)
		(if (IsFlag 1)
			(= nextRoom 1220)
		)
		(self createPoly: 106 143 107 137 143 127 200 127 253 139 253 143)
		(super init: &rest)
	)
)

