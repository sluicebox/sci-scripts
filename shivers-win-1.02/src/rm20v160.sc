;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20160)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm20v160 0
)

(instance rm20v160 of ShiversRoom
	(properties
		picture 20160
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 27023) ; rm27v023
				(gSounds play: 12703 0 82 0)
				(gCurRoom setScript: sEnter)
			)
			((IsFlag 43)
				(gSounds play: 12703 0 82 0)
				(ClearFlag 43)
			)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20120
	)

	(method (init)
		(self createPoly: 59 28 211 28 211 137 58 137 58 28)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20130
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20110
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22701 0 1 30 1 self)
			)
			(1
				(proc951_10 22701)
				(= cycles 1)
			)
			(2
				(proc951_9 22001)
				(gSounds play: 22001 -1 0 0)
				(gSounds fade: 22001 98 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

