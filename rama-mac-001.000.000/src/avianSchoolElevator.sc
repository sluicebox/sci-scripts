;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6612)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	avianSchoolElevator 0
)

(instance avianSchoolElevator of CloseupLocation
	(properties
		noun 43
	)

	(method (init)
		(if (IsFlag 125)
			(super init: 6561)
			(rope init: setHotspot: 2)
		else
			(super init: 6560)
		)
		(self edgeN: 32)
		(self edgeE: 0)
		(self edgeW: 0)
		(if (SetFlag 153)
			(proc1111_31 40)
		)
	)
)

(instance rope of Feature
	(properties
		nsLeft 120
		nsTop 113
		nsRight 296
		nsBottom 265
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 6510) ; mirmicatHall1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

