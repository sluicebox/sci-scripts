;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16000)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm16v00 0
)

(instance rm16v00 of ShiversRoom
	(properties
		picture 16000
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16004)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 9690) ; rm9v69
			(gSounds play: 11602 0 32 0)
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom)
		(proc951_1 6)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16040
	)

	(method (init)
		(self createPoly: 64 144 111 92 111 51 148 51 148 91 198 144)
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
				(proc951_9 21602)
				(gSounds play: 21602 -1 0 0)
				(gSounds fade: 21602 51 1 30 0 0)
				(gGame handsOn:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

