;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1016)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Timer)
(use BorderWindow)
(use PolyEdit)
(use System)

(public
	mhEndGameSR1 0
)

(local
	local0
)

(instance mhEndGameSR1 of CloseupRoom
	(properties
		picture 981
		style 0
	)

	(method (init)
		(ClearFlag 1001)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(syringe init:)
		(syringeFeat init:)
		(saw init:)
		(sawFeat init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(delayIt dispose:)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 7006) ; dreamingTreeRoomENDGAME
			(gP2SongPlyr fadeOut: 0)
		)
	)
)

(instance syringe of View
	(properties
		x 182
		y 285
		view 981
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance saw of View
	(properties
		x 320
		y 288
		view 981
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance syringeFeat of P2Feature
	(properties
		priority 500
	)

	(method (init)
		(super
			init:
				(proc63002_10
					207
					264
					193
					210
					187
					110
					194
					37
					254
					37
					257
					104
					231
					211
					214
					264
				)
		)
		(= whoDoit syringeCode)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(self delVerb: 4)
		)
	)
)

(instance syringeCode of Code
	(properties)

	(method (doit)
		(surgeryTimer dispose:)
		(syringe hide:)
		(= global209 680)
		(SetFlag 1506)
		(= local0 7006)
		(delayIt init:)
	)
)

(instance sawFeat of P2Feature
	(properties
		priority 500
	)

	(method (init)
		(super init: 333 65 414 234)
		(= whoDoit sawCode)
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(self delVerb: 4)
		)
	)
)

(instance sawCode of Code
	(properties)

	(method (doit)
		(surgeryTimer dispose:)
		(saw hide:)
		(= global209 650)
		(= local0 999)
		(delayIt init:)
	)
)

(instance delayIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 15)
			)
			(1
				(gCurRoom newRoom: local0)
				(self dispose:)
			)
		)
	)
)

