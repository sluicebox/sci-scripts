;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33150)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm33v150 0
)

(instance rm33v150 of ShiversRoom
	(properties
		picture 33150
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
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

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33160
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
				(proc951_7 22701)
				(proc951_9 22701)
				(= cycles 1)
			)
			(2
				(gSounds play: 22701 -1 98 0)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

