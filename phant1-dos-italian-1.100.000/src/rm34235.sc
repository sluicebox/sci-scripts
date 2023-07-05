;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34235)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm34235 0
)

(instance rm34235 of ScaryRoom
	(properties
		picture 34235
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 95 40 135 94
			normalize:
		)
		(if (or (!= (gGDacSound number:) 903) (not (gGDacSound handle:)))
			(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(34225
				(gEgo normalize: 4 posn: 50 100)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(34300
				(= global163 antDoor)
				(gEgo normalize: 9 posn: 166 108)
				(gGame handsOn:)
			)
			(32100
				(gEgo normalize: 9 posn: 166 108)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(34400
				(gEgo normalize: 9 posn: 95 103)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 7 posn: 175 125)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(switch (Random 0 5)
			(0
				(msWhite init:)
			)
			(1
				(bossGuy init:)
			)
			(2
				(me init:)
			)
		)
		(super init: &rest)
		(antSign init:)
		(westExit init: 4)
		(southExit init: 11)
		(antDoor init: 1)
		(if (not (IsFlag 11))
			(realtyDoor init: 1)
		)
	)

	(method (dispose)
		(Lock 140 33021 0) ; WAVE
		(Lock 140 33022 0) ; WAVE
		(Lock 140 34013 0) ; WAVE
		(Lock 140 34014 0) ; WAVE
		(super dispose:)
	)
)

(instance storeLocked of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(doorView init:)
					(proc1111_7 1760 19 26)
					(gCurRoom drawPic: 34300)
				)
				(1
					(doorView dispose:)
					(gCast eachElementDo: #show)
					(gEgo show: posn: 166 108 normalize: 14)
					(gCurRoom drawPic: 34235)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo show: posn: 166 108 normalize: 14)
					(if (gCast contains: doorView)
						(doorView dispose:)
					)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 34235)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookAntiqueSign of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(proc1111_7 1790 -37 -44)
					(doorView init:)
					(gCurRoom drawPic: 34300)
				)
				(1
					(doorView hide:)
					(if (== gChapter 1)
						(antClosedView init:)
					)
					(gCurRoom drawPic: 34310)
					(= seconds 5)
				)
				(2
					(doorView show:)
					(proc1111_7 1791 -37 -44)
					(if (== gChapter 1)
						(antClosedView dispose:)
					)
					(gCurRoom drawPic: 34300)
				)
				(3
					(doorView dispose:)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo normalize: 14 posn: 166 108)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(if (gCast contains: doorView)
						(doorView dispose:)
					)
					(if (gCast contains: antClosedView)
						(antClosedView dispose:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: normalize: 14 posn: 166 108)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openRealtyScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(gCurRoom drawPic: 34410)
					(= seconds 5)
				)
				(1
					(gEgo show: normalize: 5 posn: 107 102)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo show: normalize: 5 posn: 107 102)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance closedRealtyScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(theRealtySign view: 34400 init:)
					(closedDoor init:)
					(proc1111_7 1770 -8 -40)
					(gCurRoom drawPic: 34400)
				)
				(1
					(closedDoor dispose:)
					(theRealtySign dispose:)
					(gCast eachElementDo: #show)
					(gEgo show: posn: 95 103 normalize: 9)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(if (gCast contains: theRealtySign)
						(theRealtySign dispose:)
					)
					(if (gCast contains: closedDoor)
						(closedDoor dispose:)
					)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo show: posn: 95 103 normalize: 9)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance antClosedView of View
	(properties
		x 147
		y 111
		view 34410
	)
)

(instance realtySignView of View ; UNUSED
	(properties
		x 215
		y 105
		view 34410
	)
)

(instance msWhite of Prop
	(properties
		x 247
		y 132
		view 34235
	)

	(method (init)
		(super init:)
		(Load 140 33021 33022 34013 34014) ; WAVE
		(Lock 140 34013 1) ; WAVE
		(Lock 140 34014 1) ; WAVE
		(Lock 140 33021 1) ; WAVE
		(Lock 140 33022 1) ; WAVE
		(if (< (Random 0 9) 5)
			(self setLoop: 1 x: 240 y: 121)
		)
		(self setCycle: Fwd cycleSpeed: 9)
	)

	(method (doit)
		(cond
			(
				(and
					(self isNotHidden:)
					(== loop 0)
					(not (bounce handle:))
					(OneOf cel 16 28 40 52 65 77 89 100)
				)
				(bounce number: (if (Random 0 1) 34013 else 34014) play:)
			)
			(
				(and
					(self isNotHidden:)
					(== loop 0)
					(not (bounce handle:))
					(== cel 8)
				)
				(bounce number: (if (Random 0 1) 33021 else 33022) play:)
			)
			(
				(and
					(self isNotHidden:)
					(== loop 1)
					(not (bounce handle:))
					(OneOf cel 14 39 53 73 99 112)
				)
				(bounce number: (if (Random 0 1) 33021 else 33022) play:)
			)
		)
		(super doit:)
	)
)

(instance bossGuy of Prop
	(properties
		x 243
		y 121
		view 34236
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(super init:)
		(self setCycle: End self cycleSpeed: 8)
	)
)

(instance me of Prop
	(properties
		x 241
		y 121
		view 34237
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: 6)
		(Load 140 34013 34014) ; WAVE
		(Lock 140 34013 1) ; WAVE
		(Lock 140 34014 1) ; WAVE
	)

	(method (doit)
		(cond
			(
				(and
					(self isNotHidden:)
					(not (bounce handle:))
					(OneOf cel 25 51 80 143 179)
				)
				(bounce number: (if (Random 0 1) 34013 else 34014) play:)
			)
			(
				(and
					(self isNotHidden:)
					(not (bounce handle:))
					(OneOf cel 0 102 120 159 234)
				)
				(bounce number: 34014 play:)
			)
		)
		(super doit:)
	)
)

(instance bounce of Sound
	(properties)
)

(instance antSign of Feature
	(properties
		nsLeft 192
		nsTop 68
		nsRight 237
		nsBottom 99
		x 186
		y 93
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
	)

	(method (handleEvent event)
		(if (and (== global163 antDoor) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookAntiqueSign)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance realtySign of Feature ; UNUSED
	(properties
		nsLeft 98
		nsTop 81
		nsRight 108
		nsBottom 86
		sightAngle 20
		x 129
		y 87
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (not (IsFlag 93)) (OneOf gChapter 2 4))
					(gCurRoom setScript: closedRealtyScr)
				else
					(gGame handsOff:)
					(gCurRoom setScript: openRealtyScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance realtyDoor of ExitFeature
	(properties
		nsLeft 109
		nsTop 68
		nsRight 124
		nsBottom 96
		x 129
		y 87
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if
					(and
						(IsFlag 93)
						(!= gChapter 4)
						(!= gChapter 6)
						(not
							(and
								(== gChapter 1)
								(gEgo has: 0) ; invLibKey
								(IsFlag 235)
							)
						)
					)
					(gCurRoom newRoom: 34400)
				else
					(gCurRoom setScript: closedRealtyScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance antDoor of ExitFeature
	(properties
		nsLeft 160
		nsTop 69
		nsRight 186
		nsBottom 101
		approachX 176
		approachY 93
		x 186
		y 93
	)

	(method (handleEvent event)
		(cond
			((and (== global163 antSign) (self onMe: event))
				(= global163 self)
			)
			((== (gEgo x:) 190)
				(= approachX 180)
			)
			(else
				(= approachX 176)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (!= gChapter 1)
					(gCurRoom newRoom: 34300)
				else
					(gCurRoom setScript: storeLocked)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		approachX 300
		approachY 220
		x 160
		y 150
		nextRoom 34100
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 50
		x 0
		y 10
		nextRoom 34225
	)
)

(instance doorView of View
	(properties
		x 113
		y 22
		view 34301
	)
)

(instance theRealtySign of View
	(properties
		x 189
		y 76
	)
)

(instance closedDoor of View
	(properties
		x 126
		y 23
		view 34402
	)
)

