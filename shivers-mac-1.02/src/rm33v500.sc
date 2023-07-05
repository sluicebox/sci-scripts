;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33500)
(include sci.sh)
(use Main)
(use n951)
(use n960)
(use Motion)
(use Actor)
(use System)

(public
	rm33v500 0
)

(local
	local0
)

(instance rm33v500 of ShiversRoom
	(properties
		picture 33500
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spPuzzle init:)
		(spPuzzle2 init:)
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
		nextRoom 33150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33140
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 33500
	)

	(method (doVerb)
		(gCurRoom setScript: sPuzzle)
	)
)

(instance spPuzzle2 of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 33500
		loop 1
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
				(gSounds stop: 10408)
				(spPuzzle2 setCycle: End)
				(gSounds play: 10408 0 30 self)
			)
			(2
				(= local0 1)
				(gGame handsOn:)
				(spPuzzle dispose:)
				(spPuzzle2 dispose:)
			)
			(3
				(= local0 0)
				(gGame handsOff:)
				(gSounds play: 10409 0 30 0)
				(spPuzzle2 init: cel: (spPuzzle2 lastCel:) setCycle: Beg self)
			)
			(4
				(gSounds stop: 10409)
				(spPuzzle init: cel: (spPuzzle lastCel:) setCycle: Beg self)
				(gSounds play: 10409 0 30 self)
			)
			(5)
			(6
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
			(7
				(spPuzzle dispose:)
				(spPuzzle2 dispose:)
				(gCurRoom drawPic: 33140)
				(= cycles 1)
			)
			(8
				(gCurRoom drawPic: 33141)
				((Prop new:) view: 33140 setPri: 25 1 init: setCycle: End self)
				(gSounds play: 11007 0 90 self)
			)
			(9)
			(10
				(gGame handsOn:)
				(gCurRoom newRoom: 33140) ; rm33v140
			)
		)
	)
)

