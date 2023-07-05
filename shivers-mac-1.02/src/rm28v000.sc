;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28000)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm28v000 0
)

(instance rm28v000 of ShiversRoom
	(properties
		picture 28000
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 27092) ; rm27v092
			(gSounds play: 12708 0 82 0)
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 28040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 28010
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc951_11 5 36000)
					(gSounds fade: 22702 0 1 30 1 self)
				else
					(gSounds fade: 22701 0 1 30 1 self)
				)
			)
			(1
				(proc951_10 22702)
				(proc951_10 22701)
				(= cycles 1)
			)
			(2
				(if (== gPrevRoomNum 27092) ; rm27v092
					(proc951_9 22801)
					(gSounds play: 22801 -1 0 0)
					(gSounds fade: 22801 98 1 30 0 0)
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

