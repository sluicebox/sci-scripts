;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37100)
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
	rm37100 0
)

(instance rm37100 of ScaryRoom
	(properties
		picture 37100
		stepSound 4
		baseView 6000
	)

	(method (notify)
		(if script
			(script cue:)
		)
	)

	(method (newRoom)
		(Palette 2 55 135 100) ; PalIntensity
		(super newRoom: &rest)
	)

	(method (init)
		(Palette 2 55 135 70) ; PalIntensity
		(global114 play: 4050)
		(ClearFlag 121)
		(KillRobot)
		(gEgo init: setScaler: Scaler 100 50 155 116 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(38200
				(gEgo normalize: 616 posn: 180 155)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(38100
				(gEgo normalize: 616 posn: 235 150)
			)
			(37300
				(gEgo normalize: 612 posn: 240 120)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(else
				(gEgo normalize: 614 posn: 240 120)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(hiddenDoor init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		(peepHole init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		(cigarette init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		(if (IsFlag 146)
			(lift init:)
			(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(rightCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(camChange init: 1)
		(super init: &rest)
		(gGame handsOn:)
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

(instance seeMariesRoom of Script
	(properties)

	(method (dispose)
		(proc1111_9)
		(ClearFlag 248)
		(gCurRoom drawPic: 37100)
		(gEgo posn: 180 155 normalize: 614)
		(Palette 2 55 135 70) ; PalIntensity
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 248)
					(gEgo posn: 180 155 normalize: 614)
					(= scratch 1)
					(proc1111_8)
					(gGame handsOff:)
					(gCurRoom drawPic: 37105)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 901 -16 -42)
				)
				(1
					(= scratch 0)
					(KillRobot)
					((= register (View new:))
						name: {hole}
						view: 37100
						x: 0
						y: 0
						setPri: 200
						loop: 0
						cel: 0
						init:
					)
					(if (and (== gChapter 6) (not (IsFlag 43)))
						(mist
							scaleX: 15
							scaleY: 15
							priority: 1
							posn: 122 67
							init:
						)
					)
					(gCurRoom drawPic: (+ 12100 (== gChapter 5)))
					(gGame handsOn:)
					(myKnob init: setHotspot: 4 3) ; Do, Move
					(= global162 1)
					(SetFlag 121)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					((ScriptID 0 14) dispose:) ; exitButt
					(ClearFlag 121)
					(if (and (== gChapter 6) (not (IsFlag 43)))
						(mist dispose:)
					)
					(gGame handsOff:)
					(register dispose:)
					(= register 0)
					(myKnob dispose:)
					(gCurRoom drawPic: 37105)
					(DoRobot 908 -16 -42)
				)
				(3
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if scratch
				(self changeState: 1)
			else
				(ClearFlag 121)
				(if (and (== gChapter 6) (not (IsFlag 43)))
					(mist dispose:)
				)
				(if register
					(register dispose:)
					(= register 0)
				)
				(myKnob dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sRightHandle of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cigarette dispose:)
					(lift dispose:)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 9644 0 0)
					(gCurRoom drawPic: 38130)
					(ClearFlag 146)
				)
				(1
					(DoRobot 9646 25 1 gEgo 0 1)
					(gCurRoom drawPic: 37325)
				)
				(2
					(gEgo hide:)
					(gCurRoom newRoom: 38200)
				)
			)
		else
			(= global115 0)
			(KillRobot)
			(gCurRoom newRoom: 38200)
		)
	)
)

(instance sRightCrank of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 146)
					(cigarette hide:)
					(gCurRoom drawPic: 37200)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 37200 34 -3)
				)
				(1
					(gCurRoom drawPic: 37100)
					(lift init:)
					(cigarette show:)
					(Palette 2 55 135 70) ; PalIntensity
					(gEgo posn: 180 150 normalize: 610 setHeading: 200 self)
				)
				(2
					(lift dispose:)
					(cigarette hide:)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 9644 0 0)
					(gCurRoom drawPic: 38130)
				)
				(3
					(DoRobot 9646 25 1 gEgo 0 1)
					(gCurRoom drawPic: 37325)
				)
				(4
					(gEgo hide:)
					(gCurRoom newRoom: 38200)
				)
			)
		else
			(= global115 0)
			(KillRobot)
			(gCurRoom newRoom: 38200)
		)
	)
)

(instance sPullLever of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(Palette 2 55 135 100) ; PalIntensity
					(cigarette dispose:)
					(lift dispose:)
					(gCurRoom drawPic: 37205)
					(DoRobot 907 -2 1 gEgo -1 1)
				)
				(1
					(cond
						((== gChapter 5)
							(global114 play: 913)
						)
						((== gChapter 6)
							(global114 play: 914)
						)
						((== gChapter 7)
							(global114 play: 9140)
						)
					)
					(gCurRoom newRoom: 12400)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(cond
						((== gChapter 5)
							(global114 play: 913)
						)
						((== gChapter 6)
							(global114 play: 914)
						)
						((== gChapter 7)
							(global114 play: 9140)
						)
					)
					(gCurRoom newRoom: 12400)
				)
			)
		)
	)
)

(instance checkOutCase of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (IsFlag 261)
						(global114 pause:)
					)
					(cigarette hide:)
					(if (gCast contains: lift)
						(lift hide:)
					)
					(DoRobot 5090 -13 -6)
					(gCurRoom drawPic: 37330)
				)
				(1
					(DoRobot 5095 -3 0)
					(gCurRoom drawPic: 410)
				)
				(2
					(gCurRoom drawPic: 37330)
					(cond
						((IsFlag 261)
							(gCurRoom setScript: sLookCase3)
						)
						((IsFlag 260)
							(gCurRoom setScript: sLookCase2)
						)
						(else
							(gCurRoom setScript: sLookCase1)
						)
					)
				)
			)
		else
			(KillRobot)
			(cond
				((IsFlag 261)
					(gCurRoom setScript: sLookCase3)
				)
				((IsFlag 260)
					(gCurRoom setScript: sLookCase2)
				)
				(else
					(gCurRoom setScript: sLookCase1)
				)
			)
		)
	)
)

(instance sLookCase1 of Script
	(properties)

	(method (dispose)
		(gEgo posn: 245 125 normalize: 613)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5120 -20 -39)
				)
				(1
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookCase2 of Script
	(properties)

	(method (dispose)
		(gEgo posn: 245 125 normalize: 613)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5100 -20 -39)
				)
				(1
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookCase3 of Script
	(properties)

	(method (dispose)
		(gEgo posn: 245 125 normalize: 613)
		(global114 endPause:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5110 -18 -43)
				)
				(1
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(cigarette show:)
					(if (gCast contains: lift)
						(lift show:)
					)
					(gCurRoom drawPic: 37100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lift of View
	(properties
		y 130
		priority 1
		fixPriority 1
		view 37102
	)
)

(instance cigarette of View
	(properties
		approachX 245
		approachY 109
		x 245
		y 109
		view 36100
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 259)
				(gCurRoom setScript: checkOutCase)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myKnob of Feature
	(properties
		nsLeft 276
		nsTop 49
		nsRight 292
		nsBottom 85
		x 284
		y 67
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((gCurRoom script:) cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance peepHole of Feature
	(properties
		nsLeft 119
		nsTop 40
		nsRight 152
		nsBottom 57
		approachX 175
		approachY 150
		x 145
		y 120
		z 69
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(if (< (gEgo y:) 130)
				(= approachX (gEgo x:))
			else
				(= approachX 175)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: seeMariesRoom)
		else
			(super doVerb: &rest)
		)
	)
)

(instance hiddenDoor of Feature
	(properties
		sightAngle 40
		approachX 225
		approachY 113
		x 213
		y 65
	)

	(method (init)
		(self createPoly: 232 26 236 28 214 58 214 46 231 25)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sPullLever)
		else
			(super doVerb: &rest)
		)
	)
)

(instance rightCrank of Feature
	(properties
		nsLeft 264
		nsTop 61
		nsRight 288
		nsBottom 127
		sightAngle 40
		approachX 220
		approachY 183
		x 257
		y 88
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sRightCrank)
		else
			(super doVerb: &rest)
		)
	)
)

(instance insideCrank of Feature
	(properties
		approachX 170
		approachY 165
	)

	(method (init)
		(self
			createPoly: 0 39 24 41 51 55 70 71 89 92 101 118 107 129 40 129 29 111 14 91 1 122 0 40
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (gEgo y:) 120))
			(= approachX 220)
			(= approachY 183)
		else
			(= approachX 170)
			(= approachY 165)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sRightHandle)
		else
			(super doVerb: &rest)
		)
	)
)

(instance camChange of ExitFeature
	(properties
		nsLeft 225
		nsTop 30
		nsRight 252
		nsBottom 100
		approachX 238
		approachY 100
		x 238
		y 99
		nextRoom 37300
	)
)

