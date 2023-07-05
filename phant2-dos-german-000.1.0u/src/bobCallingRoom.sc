;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4083)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use BorderWindow)
(use System)

(public
	bobCallingRoom 0
)

(local
	local0
)

(instance bobCallingRoom of P2Room
	(properties
		picture 233
	)

	(method (init)
		(super init: &rest)
		(if (ClearFlag 1001)
			(= local0 1)
		)
		(gGame handsOff:)
		(bobHungUp init:)
	)

	(method (dispose)
		(if local0
			(SetFlag 1001)
		)
		(super dispose: &rest)
	)
)

(instance phoneFeature of P2Feature
	(properties
		doneFlag 387
	)
)

(instance bobHungUp of Script
	(properties)

	(method (changeState newState)
		(= state newState)
		(cond
			((== state 0)
				(phoneFeature
					init: (proc63002_10 512 177 562 179 584 234 527 233)
					whoDoit: curtisAnswered
				)
				(= seconds 2)
			)
			((>= state 10)
				(gCurRoom newRoom: 4023) ; curtisCubicleRoomCH3SR2
				(self dispose:)
			)
			(else
				(gP2SoundFX play: 4042 100)
				(= seconds 4)
				(gGame handsOn:)
			)
		)
	)
)

(instance curtisAnswered of Code
	(properties)

	(method (doit)
		(gP2SoundFX stop:)
		(= global209 6020)
		(= global211 1)
		(bobHungUp state: 20 cue:)
	)
)

