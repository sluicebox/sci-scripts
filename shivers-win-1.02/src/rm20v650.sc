;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20650)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v650 0
)

(instance rm20v650 of ShiversRoom
	(properties
		picture 20650
	)

	(method (init)
		(efExitPlaque init: 3)
		(efExitDoor init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (and (proc951_11 4 20000) (IsFlag 16))
			(gSounds fade: 22001 0 5 16 1 0)
			(proc951_9 22002)
			(gSounds play: 22002 -1 50 0)
		)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 20910
	)

	(method (init)
		(self
			createPoly:
				42
				74
				60
				74
				60
				84
				57
				84
				55
				106
				63
				106
				70
				111
				63
				114
				50
				115
				35
				115
				33
				112
				41
				106
				49
				106
				44
				85
				41
				85
				41
				74
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 20680
	)

	(method (init)
		(self createPoly: 180 24 216 20 216 88 203 94 199 122 178 123 180 25)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20640
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20640
	)
)

