;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 961)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(instance SkeletonHead of View
	(properties
		fixPriority 1
		view 14170
		loop 1
	)

	(method (init param1 param2 param3 param4)
		(= x param1)
		(= y param2)
		(= priority param3)
		(= cel param4)
		(super init: &rest)
	)
)

(instance SkeletonButton of ShiversProp
	(properties
		fixPriority 1
		view 14170
		loop 2
	)

	(method (init param1 param2 param3)
		(= x param1)
		(= y param2)
		(= priority param3)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sPushButton)
	)
)

(class SkeletonDialPuzzle of ShiversProp
	(properties
		fixPriority 1
		view 14170
		cycleSpeed 18
		curColor 0
		whichDial 0
	)

	(method (init param1 param2 param3 param4)
		(= x param1)
		(= y param2)
		(= priority param3)
		(= whichDial param4)
		(= curColor [global328 whichDial])
		(SkeletonHead init: param1 param2 (+ param3 1) curColor)
		(SkeletonHead hide:)
		(SkeletonButton init: param1 param2 (+ param3 5))
		(cond
			((== whichDial 0)
				(self view: 11330)
			)
			((== whichDial 1)
				(self view: 14170)
			)
			((== whichDial 5)
				(self view: 23650)
			)
			((== whichDial 3)
				(self view: 21400)
			)
			((== whichDial 4)
				(self view: 20190)
			)
			((== whichDial 2)
				(self view: 24171)
			)
		)
		(SkeletonHead view: (self view:))
		(SkeletonButton view: (self view:) setLoop: 2 1)
		(= cel (self lastCel:))
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sTurnDial)
	)

	(method (isSolved &tmp temp0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if (!= [global328 temp0] [global334 temp0])
				(return 0)
			)
		)
		(return 1)
	)
)

(instance sTurnDial of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (SkeletonDialPuzzle cel:)
					(SkeletonHead hide:)
					(SkeletonDialPuzzle cel: 0)
				)
				(= cycles 1)
			)
			(1
				(gSounds stop: 15002)
				(gSounds play: 15002 0 127 0)
				(SkeletonDialPuzzle setCycle: End)
				(= cycles 1)
			)
			(2
				(SkeletonHead cel: (mod (+ (SkeletonHead cel:) 1) 4))
				(= seconds 3)
			)
			(3
				(SkeletonHead show:)
				(= ticks 60)
			)
			(4
				(SkeletonHead hide:)
				(= [global328 (SkeletonDialPuzzle whichDial:)]
					(SkeletonHead cel:)
				)
				(if
					(!=
						(SkeletonHead cel:)
						[global334 (SkeletonDialPuzzle whichDial:)]
					)
					(ClearFlag 78)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 15029)
				(= cycles 1)
			)
			(1
				(gSounds play: 15029 0 127 0)
				(SkeletonHead show:)
				(= ticks 60)
			)
			(2
				(gGame handsOn:)
				(SkeletonHead hide:)
				(self dispose:)
			)
		)
	)
)

