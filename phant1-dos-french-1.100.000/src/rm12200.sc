;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12200)
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
	rm12200 0
)

(local
	[local0 4]
)

(instance rm12200 of ScaryRoom
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

	(method (init &tmp temp0)
		(gEgo init:)
		(if (and (== gChapter 6) (not (IsFlag 43)))
			(mist init:)
		)
		(vanity init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(= temp0 0)
		(southExit init: 3)
		(toVanity init: 4)
		(door init: 1)
		(KillRobot)
		(switch gPrevRoomNum
			(12300
				(if (== gChapter 5)
					(= picture 12301)
				else
					(= picture 12300)
				)
				(thePicture init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				(gEgo
					normalize: 615
					setScaler: Scaler 90 35 150 92
					posn: 245 111
				)
				(if global125
					(= temp0 lookAtPic)
					(= global163 thePicture)
					(= global125 0)
				else
					(self setScript: (ScriptID 0 5) 0 6) ; takeLastStep
				)
			)
			(12400
				(if (== gChapter 5)
					(= picture 12301)
				else
					(= picture 12300)
				)
				(thePicture init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				(gEgo
					normalize: 614
					setScaler: Scaler 90 35 150 92
					posn: 110 110
				)
				(if global125
					(= temp0 lookAtPic)
					(= global163 thePicture)
					(= global125 0)
				else
					(= temp0 (ScriptID 0 5)) ; takeLastStep
				)
			)
			(else
				(if (== gChapter 5)
					(= picture 12301)
				else
					(= picture 12300)
				)
				(thePicture init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				(gEgo
					normalize: 617
					setScaler: Scaler 90 35 150 92
					posn: 180 120
				)
				(if global125
					(= temp0 lookAtPic)
					(= global163 thePicture)
					(= global125 0)
				else
					(= temp0 (ScriptID 0 5)) ; takeLastStep
				)
			)
		)
		(super init:)
		(if temp0
			(self setScript: temp0)
		)
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

(instance lookAtPic of Script
	(properties)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(proc1111_9)
			(global114 endPause: 1)
			(gCurRoom drawPic: 12300)
			(= global115 0)
			(gEgo normalize: 617 posn: 102 94)
			(door approachY: 200)
			(toVanity approachY: 200)
			(vanity approachY: 200)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_8)
					(gCurRoom drawPic: 12310)
					(global114 pause:)
					(DoRobot 1000 19 52)
				)
				(1
					(global114 endPause:)
					(proc1111_9)
					(gCurRoom drawPic: 12300)
					(door approachY: 200)
					(toVanity approachY: 200)
					(vanity approachY: 200)
					(gEgo normalize: 617 posn: 102 94)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
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
					(if (and (not (IsFlag 42)) (not (IsFlag 194)))
						(= register (View new:))
						(register view: 12421 posn: 110 113 init:)
					)
					(door approachY: 100)
					(toVanity approachY: 100)
					(vanity approachY: 100)
				)
				(1
					(if (== gChapter 5)
						(gCurRoom drawPic: 12301)
					else
						(gCurRoom drawPic: 12300)
					)
					(if register
						(register dispose:)
					)
					(proc1111_9)
					(gEgo normalize: 614 posn: 180 120)
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
					(= global115 0)
					(if register
						(register dispose:)
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 12301)
					else
						(gCurRoom drawPic: 12300)
					)
					(proc1111_9)
					(gEgo normalize: 614 posn: 180 120)
					(= global182 gChapter)
					(crankScr dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance thePicture of Feature
	(properties
		nsLeft 86
		nsTop 22
		nsRight 105
		nsBottom 47
		approachX 101
		approachY 70
		x 95
		y 34
	)

	(method (doVerb)
		(gCurRoom setScript: lookAtPic)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 180
		nsTop 42
		nsRight 207
		nsBottom 84
		approachX 193
		approachY 150
		x 193
		y 75
		nextRoom 12100
	)

	(method (init)
		(= nsLeft 286)
		(= nsTop 0)
		(= nsRight 294)
		(= nsBottom 129)
		(= approachX 292)
		(= approachY 130)
		(super init: 2)
	)
)

(instance southExit of ExitFeature
	(properties
		approachX 193
		approachY 340
		y 10
		nextRoom 12400
	)

	(method (init)
		(= nsTop (= nsLeft 0))
		(= nsRight 10)
		(= nsBottom 128)
		(= approachX 50)
		(= approachY 99)
		(super init: 4)
	)

	(method (handleEvent event)
		(if (and (event type:) (== global163 thePicture) (self onMe: event))
			(= global125 1)
		)
		(super handleEvent: event &rest)
	)
)

(instance toVanity of ExitFeature
	(properties
		approachX 176
		approachY 90
		nextRoom 12300
	)

	(method (init)
		(= nsLeft 248)
		(= nsTop 10)
		(= nsRight 293)
		(= nsBottom 110)
		(= approachX 254)
		(= approachY 103)
		(super init: 1)
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

	(method (init)
		(= nsLeft 255)
		(= nsTop 53)
		(= nsRight 287)
		(= nsBottom 86)
		(= approachX 274)
		(= approachY 96)
		(super init: &rest)
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
		x 258
		y 90
		view 12100
		cel 1
	)

	(method (init)
		(self view: 12300 cel: 0 x: -9 y: 86 approachX: 0 approachY: 150)
		(+= view (== gChapter 5))
		(super init:)
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
					(door approachY: 100)
					(toVanity approachY: 100)
					(vanity approachY: 100)
					(gGame handsOff:)
					(DoRobot 920 123 31)
					(tarot dispose:)
					(gCurRoom drawPic: 12420)
					(gEgo get: 9) ; invTarot
					(SetFlag 42)
				)
				(1
					(gGame handsOn:)
					(gEgo normalize: 615 posn: 80 150)
					(gCurRoom drawPic: 12300)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gGame handsOn:)
					(gEgo normalize: 615 posn: 80 150)
					(gCurRoom drawPic: 12300)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

