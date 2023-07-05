;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38130)
(include sci.sh)
(use Main)
(use n951)
(use n960)
(use Motion)
(use Actor)
(use System)

(public
	rm38v130 0
)

(local
	local0
)

(instance rm38v130 of ShiversRoom
	(properties
		picture 6300
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
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
		(DisposeScript 960)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38100
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 6300
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
					(self dispose:)
				)
			)
			(5
				(spPuzzle dispose:)
				(gCurRoom drawPic: 38110)
				(= cycles 1)
			)
			(6
				((Prop new:) view: 38110 setPri: 25 1 init: setCycle: End self)
				(gSounds play: 11007 0 90 self)
			)
			(7)
			(8
				(gGame handsOn:)
				(gCurRoom newRoom: 38110) ; rm38v110
				(self dispose:)
			)
		)
	)
)

