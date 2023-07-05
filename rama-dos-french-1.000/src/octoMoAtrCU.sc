;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7402)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use System)

(public
	octoMoAtrCU 0
)

(instance octoMoAtrCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7405)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(moLock init:)
		(moCU init:)
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 90)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 7400) ; octoMoAtrium
				(self dispose:)
			)
		)
	)
)

(instance moCU of Feature
	(properties
		noun 27
		nsBottom 277
		nsLeft 12
		nsRight 571
		nsTop 5
		case 1
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance moLock of Feature
	(properties
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 84)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84
				(proc70_1)
				(ClearFlag 194)
				(gCurRoom setScript: sOpenGate)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

