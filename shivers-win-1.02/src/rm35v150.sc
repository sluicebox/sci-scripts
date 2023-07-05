;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35150)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm35v150 0
)

(instance rm35v150 of ShiversRoom
	(properties
		picture 35150
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(ClearFlag 43)
		(if (== gPrevRoomNum 35154) ; rm35v154
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 35154) ; rm35v154
			(gSounds fade: 24001 0 1 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35154
	)

	(method (init)
		(self
			createPoly:
				65
				142
				65
				119
				55
				119
				55
				104
				68
				91
				68
				70
				80
				48
				104
				30
				115
				28
				121
				5
				146
				5
				149
				13
				155
				28
				174
				36
				195
				56
				203
				79
				203
				92
				215
				104
				215
				119
				206
				119
				206
				142
				65
				142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35270
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35160
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global551
					(13
						(gSounds fade: 33510 0 2 30 1 self)
					)
					(14
						(gSounds fade: 33511 0 2 30 1 self)
					)
					(15
						(gSounds fade: 33512 0 2 30 1 self)
					)
					(23
						(gSounds fade: 33513 0 2 30 1 self)
					)
					(24
						(gSounds fade: 33514 0 2 30 1 self)
					)
					(25
						(gSounds fade: 33515 0 2 30 1 self)
					)
					(33
						(gSounds fade: 33516 0 2 30 1 self)
					)
					(34
						(gSounds fade: 33517 0 2 30 1 self)
					)
					(35
						(gSounds fade: 33518 0 2 30 1 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gGame handsOn:)
				(gSounds play: 24001 -1 0 0)
				(gSounds fade: 24001 90 1 30 0 0)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

