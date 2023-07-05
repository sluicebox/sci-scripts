;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6020)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm6v020 0
)

(instance rm6v020 of ShiversRoom
	(properties
		picture 6020
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (>= 10000 gPrevRoomNum 9000)
			(gCurRoom setScript: sEnter)
			(gSounds play: 10614 0 40 0)
		)
		(if (== gPrevRoomNum 38120) ; rm38v120
			(gSounds play: 10620 0 40 0)
			(if (proc951_11 2 6000)
				(proc951_7 20603)
				(proc951_9 20603)
				(gSounds play: 20603 -1 32 0)
				(gSounds fade: 20601 0 5 16 1 0)
				(gSounds fadeChain:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6260
	)

	(method (init)
		(self createPoly: 143 140 143 42 202 42 202 139)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20903 0 1 30 1 self)
			)
			(1
				(proc951_10 20903)
				(= cycles 1)
			)
			(2
				(if (proc951_11 2 6000)
					(proc951_7 20603)
					(proc951_9 20603)
					(gSounds play: 20603 -1 0 0)
					(gSounds fade: 20603 32 1 30 0 0)
				else
					(proc951_7 20601)
					(proc951_9 20601)
					(gSounds play: 20601 -1 0 0)
					(gSounds fade: 20601 10 1 30 0 0)
					(gSounds playChain: -1 -4 20602 -1)
					(gSounds adjChainVol: 34)
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

