;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30200)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm30200 0
)

(local
	local0 = 1
)

(instance rm30200 of ScaryRoom
	(properties
		picture 30200
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gGame handsOff:)
		(gEgo normalize: 0 init: setScaler: Scaler 170 67 149 94)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(30100
				(gEgo
					x: (- 193 (/ (* (- (gEgo x:) 60) 120) 221))
					y: 126
					heading: (mod (+ (gEgo heading:) 180) 360)
					heading2View:
				)
			)
			(30300
				(gEgo view: 0 posn: 254 101)
			)
			(34400
				(gEgo view: 2 posn: 145 105)
			)
			(30400
				(if (== global125 9)
					(= global125 0)
					(gEgo view: 3 posn: 131 126)
					(gCurRoom setScript: useDoor)
				else
					(gEgo view: 0 posn: 131 126)
					(self setScript: returnControlScr)
				)
			)
			(else
				(gEgo view: 3 posn: 121 126)
			)
		)
		(door init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(couch init: setHotspot: 4 3) ; Do, Move
		(desk init: setHotspot: 4 3) ; Do, Move
		(magazines init: setHotspot: 4 3) ; Do, Move
		(if (not script)
			(self setScript: (ScriptID 0 5) self 10) ; takeLastStep
		)
		(super init: &rest)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance returnControlScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setCel: 0 setCycle: CT 10 1 self)
				)
				(1
					(gCurRoom newRoom: 34400)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setCycle: 0)
					(gCurRoom newRoom: 34400)
				)
			)
		)
	)
)

(instance goToCouch of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 270 self)
				)
				(1
					(gCurRoom newRoom: 30400)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setCycle: 0)
					(gCurRoom newRoom: 30400)
				)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 0 self)
				)
				(1
					(gCurRoom newRoom: 34400)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setCycle: 0)
					(gCurRoom newRoom: 34400)
				)
			)
		)
	)
)

(instance toDesk of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 90 self)
				)
				(1
					(gCurRoom newRoom: 30100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setCycle: 0)
					(gCurRoom newRoom: 30100)
				)
			)
		)
	)
)

(instance door of Feature
	(properties
		nsLeft 127
		nsTop 47
		nsRight 157
		nsBottom 94
		approachX 142
		approachY 104
		x 142
		y 72
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: leaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance couch of Feature
	(properties)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				init: 0 82 46 71 75 74 99 75 95 94 49 112 38 129 34 129 21 117 12 117 16 123 8 127 11 122 6 116 8 102 0 91
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: goToCouch)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 260
		y 105
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				init: 218 101 224 97 224 83 243 85 243 90 252 84 258 84 259 78 268 79 268 88 279 90 279 129 220 129 220 107 216 106
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: toDesk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magazines of Feature
	(properties
		x 98
		y 249
	)

	(method (init)
		(= onMeCheck
			((List new:)
				add:
					((Polygon new:)
						type: PBarredAccess
						init: 84 100 96 100 97 104 91 106 84 104
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 102 95 109 95 113 99 105 100 99 97
						yourself:
					)
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: goToCouch)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

