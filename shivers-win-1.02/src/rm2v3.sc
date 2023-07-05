;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2030)
(include sci.sh)
(use Main)
(use n951)
(use n2001)
(use System)

(public
	rm2v3 0
)

(instance rm2v3 of ShiversRoom
	(properties
		picture 2030
	)

	(method (init)
		(if (not (IsFlag 2))
			(gSounds interruptChain:)
			(self setScript: sDelay)
			(self picture: 2031)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2470
	)

	(method (init)
		(self
			createPoly: 46 143 64 129 64 61 80 45 179 45 192 58 197 129 211 143
		)
		(super init: &rest)
	)
)

(instance sDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gGame handsOn:)
				(proc2001_0)
				(self dispose:)
			)
		)
	)
)

