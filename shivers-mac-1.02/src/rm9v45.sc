;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9450)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm9v45 0
)

(instance rm9v45 of ShiversRoom
	(properties
		picture 9450
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(efExitForwardRight init: 9)
		(if (IsFlag 43)
			(gSounds play: 10904 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 8030) ; rm8v030
			(gCurRoom setScript: sEnterNine)
		)
	)

	(method (newRoom newRoomNumber)
		(if (<= 9000 newRoomNumber 9200) ; rm9v20
			(gSounds fade: 10908 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9740
	)

	(method (init)
		(self createPoly: 86 141 115 110 115 94 157 95 157 110 172 141)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 9110
	)

	(method (init)
		(self createPoly: 170 140 232 140 232 63 160 63 160 114 170 140)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 9340
	)

	(method (init)
		(self createPoly: 32 140 88 141 110 116 110 63 33 63 32 140)
		(super init: &rest)
	)
)

(instance sEnterNine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20801 0 6 30 1 self)
			)
			(1
				(proc951_10 20801)
				(= cycles 1)
			)
			(2
				(proc951_9 20903)
				(gSounds play: 20903 -1 8 0)
				(gSounds fade: 20903 42 1 30 0 0)
				(if (IsFlag 42)
					(proc951_9 10908)
					(gSounds play: 10908 -1 8 0)
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

