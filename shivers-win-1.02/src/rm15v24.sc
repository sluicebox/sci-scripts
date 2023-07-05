;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15240)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm15v24 0
)

(instance rm15v24 of ShiversRoom
	(properties
		picture 15240
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 9630) ; rm9v63
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15250
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20903 0 1 30 1 self)
				(gSounds play: 11503 0 82 0)
				(ClearFlag 43)
			)
			(1
				(proc951_10 20903)
				(= cycles 1)
			)
			(2
				(proc951_9 21501)
				(gSounds play: 21501 -1 0 0)
				(gSounds fade: 21501 66 5 16 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

