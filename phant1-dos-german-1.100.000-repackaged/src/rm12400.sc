;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm12400 0
)

(local
	[local0 4]
)

(instance rm12400 of ScaryRoom
	(properties
		picture 12450
		stepSound 4
		baseView 6000
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (notify)
		(if script
			(script cue:)
		)
	)

	(method (init)
		(gEgo init: setScaler: Scaler 100 62 162 108)
		(proc1111_6)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(37100
				(self setScript: crawlOut)
			)
			(37200
				(self setScript: crawlOut)
			)
			(else
				(if global125
					(gEgo normalize: 617 posn: 240 145)
				else
					(gEgo normalize: 616 posn: 70 150)
				)
				(= global125 0)
				(self setScript: (ScriptID 0 5) 0 6) ; takeLastStep
			)
		)
		(gEgo setPri: 1)
		(super init:)
		(portrait init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (IsFlag 215)
			(panelButton init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(if (and (not (IsFlag 42)) (not (IsFlag 325)) (< gChapter 5))
			(tarot init: setPri: 0 approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(westExit init: 4)
	)
)

(instance tarot of View
	(properties
		approachX 60
		approachY 140
		x 25
		y 93
		view 12101
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
					(proc1111_7 920 123 31)
					(tarot dispose:)
					(gCurRoom drawPic: 12420)
					(SetFlag 42)
				)
				(1
					(gGame handsOn:)
					(gEgo get: 9) ; invTarot
					(gEgo normalize: 613 posn: 36 150)
					(gCurRoom drawPic: (gCurRoom picture:))
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo get: 9) ; invTarot
					(gGame handsOn:)
					(gEgo normalize: 613 posn: 36 150)
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance portrait of Feature
	(properties
		nsLeft 269
		nsRight 293
		nsBottom 29
		approachX 277
		approachY 137
		x 281
		y 14
	)

	(method (doVerb)
		(gCurRoom setScript: lookAtPic)
	)
)

(instance backDrop of Prop
	(properties
		approachX 170
		approachY 90
		x 167
		y 73
		fixPriority 1
		view 12450
		loop 1
	)
)

(instance secretPanel of Prop
	(properties
		approachX 170
		approachY 90
		x 167
		y 73
		priority 2
		fixPriority 1
		view 12450
	)

	(method (cue)
		(sfx stop:)
	)

	(method (init)
		(backDrop view: view x: x y: y init:)
		(super init:)
	)

	(method (dispose)
		(backDrop dispose:)
		(super dispose:)
	)
)

(instance lookAtPic of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(global114 endPause: 1)
			(proc1111_6)
			(proc1111_9)
			(gCurRoom drawPic: 12450)
			(gEgo normalize: 616 posn: 260 155)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(westExit approachY: 180)
					(gGame handsOff:)
					(proc1111_8)
					(gCurRoom drawPic: 12310)
					(global114 pause:)
					(proc1111_7 1000 19 52)
				)
				(1
					(proc1111_9)
					(global114 endPause:)
					(gCurRoom drawPic: 12450)
					(gEgo normalize: 616 posn: 260 155)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance crawlOut of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 12062) ; WAVE
					(Lock 140 12062 1) ; WAVE
					(gEgo hide:)
					(gCurRoom picture: 12460)
					(westExit approachY: 250)
					(WalkieTalkie showFrame: 12401 0 103 1 1)
					(secretPanel
						view: (+ 12461 (== gChapter 5))
						x: 120
						y: 128
						cel: 0
						init:
					)
					(= cycles 1)
				)
				(1
					(secretPanel setCycle: End self)
					(sfx number: 12062 setLoop: 1 play:)
				)
				(2
					(sfx stop:)
					(Lock 140 12062 0) ; WAVE
					(Load 140 12061) ; WAVE
					(Lock 140 12061 1) ; WAVE
					(Load 140 12063) ; WAVE
					(Lock 140 12063 1) ; WAVE
					(proc1111_6)
					(proc1111_7 12401 103 1 gEgo 200 1)
				)
				(3
					(sfx number: 12061 setLoop: 1 play: self)
				)
				(4
					(sfx number: 12063 setLoop: 1 play:)
					(secretPanel setCycle: Beg secretPanel)
				)
				(5
					(proc1111_6)
					(sfx stop:)
					(Lock 140 12061 0) ; WAVE
					(Lock 140 12063 0) ; WAVE
					(secretPanel dispose:)
					(gEgo posn: 170 130)
					(gEgo show: normalize: 615)
					(gCurRoom drawPic: 12450)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(secretPanel dispose:)
			(Lock 140 12061 0) ; WAVE
			(Lock 140 12062 0) ; WAVE
			(Lock 140 12063 0) ; WAVE
			(sfx stop:)
			(proc1111_6)
			(gEgo normalize: 615 posn: 170 130)
			(gEgo show: normalize: 615)
			(gCurRoom drawPic: 12450)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 4
	)
)

(instance doPanel of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load 140 12062) ; WAVE
					(Lock 140 12062 1) ; WAVE
					(Load 140 12061) ; WAVE
					(Lock 140 12061 1) ; WAVE
					(gGame handsOff:)
					(secretPanel
						view: (+ 12461 (== gChapter 5))
						x: 120
						y: 128
						cel: 0
						init:
					)
					(gCurRoom drawPic: 12460)
					(proc1111_7 12400 115 3 gEgo 200 1)
				)
				(1
					(sfx number: 12061 setLoop: 1 play: self)
				)
				(2
					(sfx number: 12062 setLoop: 1 play:)
					(secretPanel setCycle: End)
				)
				(3
					(gEgo hide:)
					(Lock 140 12061 0) ; WAVE
					(Lock 140 12062 0) ; WAVE
					(Load 140 12063) ; WAVE
					(Lock 140 12063 1) ; WAVE
					(sfx number: 12063 setLoop: 1 play:)
					(secretPanel setPri: 201 setCycle: Beg self)
				)
				(4
					(sfx stop:)
					(Lock 140 12061 0) ; WAVE
					(Lock 140 12062 0) ; WAVE
					(Lock 140 12063 0) ; WAVE
					(gCurRoom newRoom: 37100)
				)
			)
		else
			(= global115 0)
			(sfx stop:)
			(proc1111_6)
			(Lock 140 12061 0) ; WAVE
			(Lock 140 12062 0) ; WAVE
			(Lock 140 12063 0) ; WAVE
			(gCurRoom newRoom: 37100)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 20
		approachX -10
		approachY 180
		nextRoom 12200
	)
)

(instance panelButton of Feature
	(properties
		nsLeft 202
		nsTop 43
		nsRight 221
		nsBottom 61
		approachX 203
		approachY 116
		x 211
		y 52
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global163 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: doPanel)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

