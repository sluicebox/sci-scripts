;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37360)
(include sci.sh)
(use Main)
(use n951)
(use n960)
(use Motion)
(use Actor)
(use System)

(public
	rm37v360 0
)

(local
	local0
)

(instance rm37v360 of ShiversRoom
	(properties
		picture 37361
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitBack init: 8)
		(spPuzzle init:)
		(super init: &rest)
	)

	(method (newRoom)
		(if local0
			(gSounds play: 10409 0 30 0)
			(spPuzzle cel: 0 init:)
			(UpdateScreenItem spPuzzle)
			(FrameOut)
			(proc960_1)
		)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37350
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 37340
	)

	(method (init)
		(self
			createPoly:
				54
				13
				207
				13
				207
				127
				54
				127
				54
				13
				20
				0
				20
				143
				243
				143
				243
				0
				20
				0
		)
		(super init: &rest)
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 37361
	)

	(method (doVerb)
		(gCurRoom setScript: sPuzzle)
	)
)

(instance sPuzzle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(efExitBack dispose:)
				(= temp0 0)
				(if (IsFlag 6)
					(= temp0 1)
				)
				(proc960_0 self)
				(gSounds play: 10408 0 30 0)
				(spPuzzle setCycle: End self)
				(if (== 1 temp0)
					(gSounds play: 10405 0 50 0)
				)
			)
			(1
				(= local0 1)
				(gGame handsOn:)
				(spPuzzle dispose:)
			)
			(2
				(= local0 0)
				(gGame handsOff:)
				(spPuzzle init: cel: (spPuzzle lastCel:) setCycle: Beg self)
				(gSounds play: 10409 0 30 self)
			)
			(3)
			(4
				(proc960_1)
				(if (IsFlag 6)
					(= cycles 1)
				else
					(gGame handsOn:)
					(efExitLeft init: 2)
					(efExitRight init: 1)
					(efExitBack init: 1)
					(self dispose:)
				)
			)
			(5
				(spPuzzle dispose:)
				(gCurRoom drawPic: 37330)
				(= cycles 1)
			)
			(6
				((Prop new:)
					view: 37330
					setPri: 25 1
					init:
					cycleSpeed: 10
					setCycle: End self
				)
				(gSounds play: 11007 0 90 self)
			)
			(7)
			(8
				(gGame handsOn:)
				(gCurRoom newRoom: 37330) ; rm37v330
			)
		)
	)
)

