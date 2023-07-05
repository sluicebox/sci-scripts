;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7110)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use System)

(public
	octoEenieGateInCU 0
)

(instance octoEenieGateInCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7123)
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
				(gCurRoom newRoom: 7108) ; octoEenie9
				(self dispose:)
			)
		)
	)
)

(instance eenieLock of Feature
	(properties
		nsLeft 206
		nsTop 80
		nsRight 386
		nsBottom 205
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

