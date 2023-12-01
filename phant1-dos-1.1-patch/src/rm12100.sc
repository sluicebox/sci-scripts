;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm12100 0
)

(local
	[local0 4]
)

(instance rm12100 of ScaryRoom
	(properties
		picture 12100
		stepSound 4
		baseView 6000
	)

	(method (drawPic param1)
		(if (gCast contains: mist)
			(switch param1
				(12300
					(mist scaleX: 30 scaleY: 30 priority: 1 show: posn: 273 70)
				)
				(12100
					(mist scaleX: 15 scaleY: 15 priority: 1 show: posn: 122 67)
				)
				(else
					(mist hide:)
				)
			)
		)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (notify)
		(self cue:)
	)

	(method (init)
		(gEgo init:)
		(ClearFlag 121)
		(if (and (== gChapter 6) (not (IsFlag 43)))
			(mist init:)
		)
		(vanity init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (and (not (IsFlag 42)) (not (IsFlag 325)) (< gChapter 5))
			(tarot init: setPri: 200 approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(southExit init: 3)
		(toVanity init: 4)
		(door init: 10)
		(KillRobot)
		(switch gPrevRoomNum
			(12200
				(if (== gChapter 5)
					(= picture 12101)
				)
				(gEgo
					normalize: 613
					setScaler: Scaler 65 28 129 85
					posn: 189 95
				)
				(if (< gChapter 6)
					(bed init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(if (== gChapter 5)
					(= picture 12101)
				)
				(gEgo
					normalize: 612
					setScaler: Scaler 65 28 129 85
					posn: 189 99
				)
				(if (< gChapter 6)
					(bed init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(super init:)
		(if (and (== gChapter 2) (!= global182 gChapter))
			(crankScr init:)
		)
	)
)

(instance mist of Prop
	(properties
		x 97
		y 125
		fixPriority 1
		view 12304
		scaleSignal 1
	)

	(method (init)
		(RemapColors 2 244 105) ; ByPercent
		(RemapColors 2 243 110) ; ByPercent
		(RemapColors 2 242 115) ; ByPercent
		(RemapColors 2 241 120) ; ByPercent
		(RemapColors 2 240 125) ; ByPercent
		(RemapColors 2 239 130) ; ByPercent
		(RemapColors 2 238 135) ; ByPercent
		(RemapColors 2 237 140) ; ByPercent
		(RemapColors 2 236 145) ; ByPercent
		(super init: &rest)
		(= cycleSpeed 6)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(super dispose:)
	)
)

(instance crankScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if
					(and
						(not (gCurRoom script:))
						(not (gCurRoom inset:))
						(gUser canControl:)
						(not (CueObj client:))
					)
					(gGame handsOff:)
					(gCurRoom setScript: crankInsetScr)
				else
					(self cue:)
				)
			)
			(2
				(self state: -1 cue:)
			)
		)
	)
)

(instance crankInsetScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gCurRoom drawPic: 12421)
					(DoRobot 2310 -3 -22)
					(if (and (not (IsFlag 42)) (not (IsFlag 325)))
						(= register (View new:))
						(register view: 12421 posn: 110 113 init:)
					)
				)
				(1
					(if register
						(register dispose:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(proc1111_9)
					(gEgo normalize: 613 posn: 189 95)
					(= global182 gChapter)
					(crankScr dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if register
						(register dispose:)
					)
					(= global115 0)
					(gCurRoom drawPic: (gCurRoom picture:))
					(proc1111_9)
					(gEgo normalize: 613 posn: 189 95)
					(= global182 gChapter)
					(crankScr dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 180
		nsTop 42
		nsRight 207
		nsBottom 84
		approachX 193
		approachY 80
		x 193
		y 75
		nextRoom 13100
	)
)

(instance southExit of ExitFeature
	(properties
		approachX 193
		approachY 340
		y 10
		nextRoom 12200
	)
)

(instance toVanity of ExitFeature
	(properties
		approachX 176
		approachY 90
		nextRoom 12300
	)

	(method (init)
		(self
			createPoly: 156 43 177 43 177 95 169 95 169 79 164 71 157 69 156 66
		)
		(super init: &rest)
	)
)

(instance bed of Feature
	(properties
		nsLeft 73
		nsTop 66
		nsRight 124
		nsBottom 77
		approachX 174
		approachY 90
		x 98
		y 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global125 53)
				(gCurRoom newRoom: 12300)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vanity of Feature
	(properties
		nsLeft 112
		nsTop 53
		nsRight 127
		nsBottom 61
		approachX 149
		approachY 78
		x 119
		y 61
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(= global125 35)
				(gCurRoom newRoom: 12300)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tarot of View
	(properties
		approachX 248
		approachY 128
		x 264
		y 87
		view 12100
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: tarotScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tarotScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 920 123 31)
					(tarot dispose:)
					(gCurRoom drawPic: 12420)
					(SetFlag 42)
				)
				(1
					(gEgo get: 9) ; invTarot
					(gGame handsOn:)
					(gEgo normalize: 614 posn: 242 115)
					(gCurRoom drawPic: (gCurRoom picture:))
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo get: 9) ; invTarot
					(KillRobot)
					(gGame handsOn:)
					(gEgo normalize: 614 posn: 242 115)
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

