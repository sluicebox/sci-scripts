;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7111)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use System)

(public
	octoEenieGateOutCU 0
)

(instance octoEenieGateOutCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7124)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(eenieLock init:)
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 7112) ; octoEeniePit
				(self dispose:)
			)
		)
	)
)

(instance eenieLock of Feature
	(properties
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 88)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(88
				(proc70_1)
				(SetFlag 193)
				(gCurRoom setScript: sOpenGate)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

