;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm36300 0
)

(instance rm36300 of ScaryRoom
	(properties
		picture 36300
		stepSound 4
		baseView 6000
	)

	(method (newRoom)
		(Palette 2 55 135 100) ; PalIntensity
		(super newRoom: &rest)
	)

	(method (notify)
		(if script
			(script cue:)
		)
	)

	(method (init)
		(proc1111_6)
		(global114 play: 4050)
		(ClearFlag 121)
		(Palette 2 55 135 70) ; PalIntensity
		(gEgo init: normalize: setScaler: Scaler 71 40 132 100)
		(switch gPrevRoomNum
			(36200
				(gEgo normalize: 613 posn: 179 131)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 612 posn: 180 110)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(southExit init: 3)
		(door init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(peepHole init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(super init: &rest)
		(gGame handsOn:)
	)
)

(instance seeChapel of Script
	(properties)

	(method (dispose)
		(ClearFlag 248)
		(proc1111_9)
		(gCurRoom drawPic: 36300)
		(gEgo posn: 179 131 normalize: 611)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 248)
					(gEgo posn: 179 131 normalize: 611)
					(proc1111_8)
					(gGame handsOff:)
					(gCurRoom drawPic: 36306)
					(= scratch 1)
					(Palette 2 55 135 100) ; PalIntensity
					(proc1111_7 902 0 -38)
				)
				(1
					(= scratch 0)
					(SetFlag 121)
					(bible init:)
					(chest init:)
					((= register (View new:))
						view: 37100
						x: 0
						y: 0
						setPri: 200
						loop: 0
						cel: 0
						init:
					)
					(if (and (== gChapter 5) (ResCheck rsPIC 6605))
						(gCurRoom drawPic: 6605)
					else
						(gCurRoom drawPic: 6600)
					)
					(gGame handsOn:)
					(myKnob init: setHotspot: 4 3) ; Do, Move
					(= global162 1)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					((ScriptID 0 14) dispose:) ; exitButt
					(bible dispose:)
					(chest dispose:)
					(ClearFlag 121)
					(gGame handsOff:)
					(myKnob dispose:)
					(if register
						(register dispose:)
						(= register 0)
					)
					(gCurRoom drawPic: 36306)
					(proc1111_7 909 3 -33)
				)
				(3
					(Palette 2 55 135 70) ; PalIntensity
					(= global163 peepHole)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if scratch
				(self changeState: 1)
			else
				(= global163 peepHole)
				(ClearFlag 121)
				(if register
					(register dispose:)
					(= register 0)
				)
				(bible dispose:)
				(chest dispose:)
				(myKnob dispose:)
				(Palette 2 55 135 70) ; PalIntensity
				(self dispose:)
			)
		)
	)
)

(instance bible of View
	(properties)

	(method (init)
		(self view: (+ 6608 (== gChapter 5)) posn: 197 66 loop: 0 cel: 1)
		(super init: &rest)
	)
)

(instance chest of View
	(properties)

	(method (init)
		(if (< gChapter 7)
			(self
				view: (+ 6608 (== gChapter 5))
				posn: 148 88
				loop: 0
				setPri: 150
				cel: 0
			)
		else
			(self view: 6608 posn: 78 133 setPri: 150 loop: 0 cel: 3)
		)
		(super init: &rest)
	)
)

(instance sOpenPassage of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gGame handsOff:)
					(gCurRoom drawPic: 36305)
					(Palette 2 55 135 100) ; PalIntensity
					(proc1111_7 903 -2 -11 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 6500)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom newRoom: 6500)
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
		(if (== theVerb 4) ; Do
			((gCurRoom script:) cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		nsLeft 153
		nsTop 65
		nsRight 165
		nsBottom 75
		approachX 180
		approachY 110
		x 159
		y 69
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sOpenPassage)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance peepHole of Feature
	(properties
		nsLeft 142
		nsTop 39
		nsRight 154
		nsBottom 59
		approachX 140
		approachY 110
		x 100
		y 110
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: seeChapel)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 125
		approachX 174
		approachY 200
		nextRoom 36200
	)
)

