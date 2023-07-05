;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10030)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm10v030 0
)

(instance rm10v030 of ShiversRoom
	(properties
		picture 10030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDown init: 5)
		(super init: &rest)
		(if (== gPrevRoomNum 34010) ; rm34v010
			(if (IsFlag 6)
				(gSounds play: 10407 0 90 0)
			else
				(gSounds play: 10503 0 90 0)
			)
			(self setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10090
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 10060
	)

	(method (init)
		(self createPoly: 127 143 20 98 20 143)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(proc951_7 21002)
				(proc951_9 21002)
				(gSounds playChain: 21001 0 21002 -1)
				(gSounds adjChainVol: 98)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

