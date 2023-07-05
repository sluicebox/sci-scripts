;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7210)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)
(use System)

(public
	octoMeenieGateOutCU 0
)

(instance octoMeenieGateOutCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7222)
		(= plane global116)
		(meenieLock init:)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance exitToAtriumDir of ExitFeature ; UNUSED
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 7208
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
				(gCurRoom newRoom: 7211) ; octoMeeniePit
				(self dispose:)
			)
		)
	)
)

(instance meenieLock of Feature
	(properties
		nsLeft 206
		nsTop 80
		nsRight 386
		nsBottom 205
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

