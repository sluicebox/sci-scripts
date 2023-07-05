;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26010)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm26v010 0
)

(instance rm26v010 of ShiversRoom
	(properties
		picture 26010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 29280) ; rm29v280
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26050
	)

	(method (init)
		(self
			createPoly:
				61
				143
				84
				120
				85
				45
				91
				37
				118
				31
				142
				31
				166
				37
				173
				43
				173
				119
				192
				145
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22901 0 1 30 1 self)
			)
			(1
				(gGame handsOn:)
				(proc951_9 22602)
				(gSounds play: 22602 -1 0 0)
				(gSounds fade: 22602 106 1 30 0 0)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

