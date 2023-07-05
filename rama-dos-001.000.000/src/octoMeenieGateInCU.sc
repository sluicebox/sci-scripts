;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7209)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use System)

(public
	octoMeenieGateInCU 0
)

(instance octoMeenieGateInCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7221)
		(= plane global116)
		(meenieLock init:)
		(self edgeW: 0 edgeE: 0)
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
				(gCurRoom newRoom: 7208) ; octoMeenie9
				(self dispose:)
			)
		)
	)
)

(instance meenieLock of Feature
	(properties
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 98)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(98
				(proc70_1 102 1)
				(SetFlag 184)
				(gCurRoom setScript: sOpenGate)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

