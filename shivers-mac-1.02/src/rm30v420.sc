;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30420)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm30v420 0
)

(local
	local0
)

(instance rm30v420 of ShiversRoom
	(properties
		picture 30420
		invView 1
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(cond
			((== gPrevRoomNum 30421) ; octagonPuzzle
				(ClearFlag 43)
				(if (IsFlag 58)
					(gCurRoom setScript: sPuzzleSolved)
				else
					(gCurRoom setScript: sNotSolved)
				)
			)
			((IsFlag 58)
				((View new:) view: 30420 loop: 4 cel: 1 setPri: 1 1 init:)
				(psHole init:)
				(self initRoom: 134 162 49 73)
			)
			(else
				(spPuzzle init:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30410
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 40
		fixPriority 1
		view 30420
	)

	(method (doVerb)
		(if (== cel (self lastCel:))
			(gCurRoom newRoom: 30421) ; octagonPuzzle
		else
			(SetFlag 43)
			(gSounds play: 13004 0 82 0)
			(self setCycle: End)
		)
	)
)

(instance psHole of PotSpot
	(properties
		nsLeft 134
		nsTop 49
		nsRight 162
		nsBottom 73
	)
)

(instance sPuzzleSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0
					((Prop new:)
						view: 30420
						loop: 1
						setPri: 40 1
						init:
						cel: 0
						cycleSpeed: 18
						setCycle: End self
						yourself:
					)
				)
				(gSounds play: 13008 0 82 0)
			)
			(1
				(local0 loop: 3 cel: 0 cycleSpeed: 4 setCycle: Fwd)
				(gSounds play: 13007 0 82 self)
			)
			(2
				(local0 loop: 2 cel: 0 cycleSpeed: 18 setCycle: End self)
				((View new:) view: 30420 loop: 4 setPri: 1 1 init:)
				(gSounds play: 13004 0 82 0)
				(psHole init:)
				(gCurRoom initRoom: 134 162 49 73)
			)
			(3
				(local0 loop: 5 cel: 1 setPri: 2 1)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance sNotSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spPuzzle
					loop: 0
					cel: (spPuzzle lastCel:)
					init:
					setCycle: Beg self
				)
				(gSounds play: 13008 0 82 0)
			)
			(1
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

