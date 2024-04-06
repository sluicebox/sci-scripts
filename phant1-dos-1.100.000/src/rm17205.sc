;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17205)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm17205 0
)

(instance rm17205 of ScaryRoom
	(properties
		picture 17320
	)

	(method (notify)
		((ScriptID 0 14) dispose:) ; exitButt
		(gCurRoom newRoom: 17000)
	)

	(method (dispose)
		((ScriptID 0 14) dispose:) ; exitButt
		(super dispose:)
	)

	(method (init)
		(super init:)
		(bill init:)
		(theBill init: setHotspot: 4 3) ; Do, Move
		(handle1 init: setHotspot: 4 3) ; Do, Move
		((ScriptID 0 14) init:) ; exitButt
		(gGame handsOn:)
		(gUser canControl: 0)
	)
)

(instance bill of View
	(properties
		x 134
		y 112
		view 17320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(SetFlag 71)
				(gEgo get: 1) ; invMoney
				((ScriptID 0 14) dispose:) ; exitButt
				(gCurRoom newRoom: 17000)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBill of Feature
	(properties
		x 111
		y 89
	)

	(method (init)
		(self
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 98 75 88 82 103 93 121 94 124 87 107 83
					yourself:
				)
		)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((ScriptID 0 14) dispose:) ; exitButt
				(gGame handsOff:)
				(SetFlag 71)
				(gEgo get: 1) ; invMoney
				(gCurRoom newRoom: 17000)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance handle1 of Feature
	(properties
		nsLeft 198
		nsTop 113
		nsRight 270
		nsBottom 132
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 17000)
		else
			(super doVerb: theVerb)
		)
	)
)

