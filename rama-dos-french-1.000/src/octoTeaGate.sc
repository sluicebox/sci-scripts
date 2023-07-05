;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7803)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoTeaGate 0
)

(instance octoTeaGate of CloseupLocation
	(properties)

	(method (init)
		(super init: 7809)
		(= heading 225)
		(= plane global116)
		(exitToGate init:)
		(gCurRoom exitN: exitToGate)
		(self edgeW: 0 edgeE: 0)
	)

	(method (pitch)
		(self newRoom: 7800) ; octoTeacher
	)
)

(instance exitToGate of Feature
	(properties
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7804) ; octoTeaGateCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

