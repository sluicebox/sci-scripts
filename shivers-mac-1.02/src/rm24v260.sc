;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24260)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v260 0
)

(instance rm24v260 of ShiversRoom
	(properties
		picture 24260
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24261)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(if (proc951_11 5 24000)
			(proc951_9 22402)
			(gSounds play: 22402 -1 0 0)
			(gSounds fade: 22402 98 6 30 0 0)
			(gSounds fade: 22404 0 6 30 1 0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24270
	)

	(method (init)
		(self createPoly: 85 47 85 120 132 120 132 47 86 47)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24250
	)
)

