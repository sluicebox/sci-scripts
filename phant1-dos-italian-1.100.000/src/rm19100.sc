;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19100)
(include sci.sh)
(use Main)
(use n1111)
(use Osc)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm19100 0
)

(instance rm19100 of ScaryRoom
	(properties
		picture 19130
		stepSound 4
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(= picture (+ param1 1))
			(super drawPic: (+ param1 1) &rest)
		else
			(= picture param1)
			(super drawPic: picture &rest)
		)
		(switch picture
			(19200
				(twister view: 19200 posn: 81 111 show:)
				(if (IsFlag 31)
					(trunkLid view: 19108 posn: 185 95 show:)
				else
					(trunkLid view: 19107 posn: 158 95 show:)
				)
			)
			(19201
				(twister view: 19201 posn: 81 111 show:)
				(if (IsFlag 31)
					(trunkLid view: 19110 posn: 185 95 show:)
				else
					(trunkLid view: 19109 posn: 158 95 show:)
				)
			)
			(19210
				(twister view: 19210 posn: -8 124 show:)
				(if (IsFlag 31)
					(trunkLid view: 19112 posn: 207 127 show:)
				else
					(trunkLid view: 19111 posn: 145 130 show:)
				)
			)
			(19211
				(twister view: 19211 posn: -8 124 show:)
				(if (IsFlag 31)
					(trunkLid view: 19114 posn: 207 127 show:)
				else
					(trunkLid view: 19113 posn: 145 130 show:)
				)
			)
			(else
				(twister hide:)
				(trunkLid hide:)
			)
		)
	)

	(method (notify)
		(gGame handsOff:)
		(gCurRoom setScript: exitScr)
	)

	(method (init)
		(if (and (not (gEgo has: 10)) (not (gEgo has: 14))) ; invBrooch, invCrucifix
			(insetView cel: 0 init:)
		else
			(insetView cel: 1 init:)
		)
		(blankets init: setPri: 5)
		(if (== gChapter 5)
			(blankets loop: 1)
			(insetView view: 19132)
		)
		(insetDiary init: setHotspot: 4 3) ; Do, Move
		(if (and (not (gEgo has: 10)) (not (gEgo has: 14))) ; invBrooch, invCrucifix
			(insetBrooch init: setHotspot: 4 3) ; Do, Move
		)
		(insetLocket init: setHotspot: 4 3) ; Do, Move
		(gEgo init: posn: 1000 1000 normalize: setScale: 0 hide:)
		(trunkLid init:)
		(twister init:)
		(KillRobot)
		(if (IsFlag 31)
			(= picture 19200)
			(gCurRoom setScript: kneelScr)
		else
			(gGame handsOn:)
			(gUser canControl: 0)
			((ScriptID 0 14) init:) ; exitButt
		)
		(SetFlag 31)
		(super init: &rest)
	)

	(method (dispose)
		((ScriptID 0 14) dispose:) ; exitButt
		(super dispose:)
	)
)

(instance trunkLid of View
	(properties
		view 19113
	)
)

(instance twister of View
	(properties
		view 19123
	)
)

(instance sfx of Sound
	(properties)
)

(instance kneelScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo
						posn: 136 118
						view: 4823
						show:
						loop: 0
						cel: 0
						setCycle: End self
					)
					(insetView hide:)
					(blankets hide:)
					(trunkLid show:)
				)
				(1
					(gEgo hide:)
					(insetView show:)
					(blankets show:)
					(trunkLid hide:)
					(gCurRoom drawPic: 19130)
					(gGame handsOn:)
					(gUser canControl: 0)
					((ScriptID 0 14) init:) ; exitButt
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo hide:)
					(insetView show:)
					(blankets show:)
					(trunkLid hide:)
					(gCurRoom drawPic: 19130)
					(gGame handsOn:)
					(gUser canControl: 0)
					((ScriptID 0 14) init:) ; exitButt
					(self dispose:)
				)
			)
		)
	)
)

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo
						posn: 136 118
						view: 4824
						show:
						loop: 0
						cel: 0
						setCycle: End self
					)
					(insetView hide:)
					(blankets hide:)
					(trunkLid show:)
					(gCurRoom drawPic: 19200)
				)
				(1
					(gCurRoom newRoom: 19000)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 19000)
				)
			)
		)
	)
)

(instance sDoBrooch of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					((ScriptID 0 14) dispose:) ; exitButt
					(insetView hide:)
					(blankets hide:)
					(gEgo
						view: 4820
						posn: 136 118
						loop: 0
						cel: 0
						init:
						setCycle: End self
					)
					(gCurRoom drawPic: 19200)
				)
				(1
					(gEgo view: 4821 posn: 0 130)
					(insetView show: cel: 1)
					(blankets show:)
					(trunkLid hide:)
					(gCurRoom drawPic: 19130)
					(sfx number: 19046 loop: 1 play: self)
				)
				(2
					(gEgo
						posn: 136 118
						view: 4822
						loop: 0
						cel: 0
						setCycle: End self
						get: 10 ; invBrooch
					)
					(insetView hide:)
					(blankets hide:)
					(trunkLid show:)
					(gCurRoom drawPic: 19200)
				)
				(3
					(global114 endPause:)
					(gCurRoom newRoom: 19000)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(sfx stop:)
					(gEgo get: 10) ; invBrooch
					(global114 endPause:)
					(gCurRoom newRoom: 19000)
				)
			)
		)
	)
)

(instance sDoLocket of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					((ScriptID 0 14) dispose:) ; exitButt
					(insetView hide:)
					(blankets hide:)
					(gEgo
						posn: 132 114
						view: 4810
						loop: 0
						cel: 0
						init:
						setCycle: End self
					)
					(gCurRoom drawPic: 19200)
				)
				(1
					(gEgo view: 4811 posn: 0 130)
					(sfx number: 19045 loop: 1 play: self)
					(trunkLid hide:)
					(if (and (not (gEgo has: 10)) (not (gEgo has: 14))) ; invBrooch, invCrucifix
						(insetView cel: 2 show:)
						(blankets show:)
					else
						(insetView cel: 3 show:)
						(blankets show:)
					)
					(gCurRoom drawPic: 19130)
				)
				(2
					(gEgo
						posn: 132 114
						view: 4812
						loop: 0
						cel: 0
						setCycle: End self
					)
					(trunkLid show:)
					(insetView dispose:)
					(blankets dispose:)
					(gCurRoom drawPic: 19200)
				)
				(3
					(gCurRoom newRoom: 19000)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(sfx stop:)
					(gCurRoom newRoom: 19000)
				)
			)
		)
	)
)

(instance diarySpeech of Sound
	(properties
		number 19044
	)
)

(instance bookSound of Sound
	(properties
		number 19040
	)
)

(instance sReadDiary of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 4800)
					(SetFlag 301)
					((ScriptID 0 14) dispose:) ; exitButt
					(insetView hide:)
					(blankets view: 19212 posn: 179 130)
					(gEgo posn: 1000 1000 init:)
					(DoRobot 4802 20 -16)
					(gCurRoom drawPic: 19210)
				)
				(1
					(gEgo
						view: 4806
						cel: 0
						loop: 0
						posn: 70 132
						cycleSpeed: 20
						setCycle: Osc
					)
					(global114 pause:)
					(diarySpeech play: self)
				)
				(2
					(global114 endPause:)
					(gEgo
						view: 4800
						setCel: 0
						loop: 0
						setScale: 0
						posn: 136 117
						cycleSpeed: 8
						setCycle: CT 36 1 self
					)
					(gCurRoom drawPic: 19200)
				)
				(3
					(bookSound play:)
					(gEgo setCycle: End self)
				)
				(4
					(gCurRoom newRoom: 19000)
				)
			)
		else
			(switch (= state newState)
				(0
					(global114 endPause: 1)
					(KillRobot)
					(= global115 0)
					(gEgo setCycle: 0)
					(gCurRoom newRoom: 19000)
				)
			)
		)
	)
)

(instance insetView of View
	(properties
		x 82
		y 57
		view 19130
	)
)

(instance blankets of View
	(properties
		x 63
		y 108
		view 19131
	)
)

(instance insetDiary of Feature
	(properties)

	(method (init)
		(self createPoly: 120 56 150 67 117 109 83 92)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sReadDiary)
		else
			(super doVerb: &rest)
		)
	)
)

(instance insetLocket of Feature
	(properties
		nsLeft 170
		nsTop 79
		nsRight 185
		nsBottom 108
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoLocket)
		else
			(super doVerb: &rest)
		)
	)
)

(instance insetBrooch of Feature
	(properties
		nsLeft 145
		nsTop 102
		nsRight 161
		nsBottom 115
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(global114 pause:)
			(gCurRoom setScript: sDoBrooch)
		else
			(super doVerb: &rest)
		)
	)
)

