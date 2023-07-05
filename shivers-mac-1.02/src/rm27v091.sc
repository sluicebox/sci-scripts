;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27091)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm27v091 0
)

(instance rm27v091 of ShiversRoom
	(properties
		picture 27091
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
		(gCurRoom setScript: sEnter)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 36000) (!= newRoomNumber 27081)) ; rm27v081
			(gSounds fade: 22702 0 5 16 1 0)
			(proc951_9 22701)
			(gSounds play: 22701 -1 98 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27081
	)

	(method (init)
		(self createPoly: 36 126 167 134 167 27 35 27 35 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27092
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22801 0 1 30 1 self)
			)
			(1
				(proc951_10 22801)
				(= cycles 1)
			)
			(2
				(cond
					((proc951_11 5 36000)
						(gSounds fade: 22701 0 5 32 1 0)
						(proc951_9 22702)
						(gSounds play: 22702 -1 0 0)
						(gSounds fade: 22702 50 5 16 0 0)
					)
					((== gPrevRoomNum 28020) ; rm28v020
						(proc951_9 22701)
						(gSounds play: 22701 -1 98 0)
						(gSounds play: 12708 0 82 0)
					)
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

