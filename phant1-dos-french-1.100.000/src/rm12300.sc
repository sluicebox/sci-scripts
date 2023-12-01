;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm12300 0
)

(local
	[local0 4]
	local4
	local5
)

(instance rm12300 of ScaryRoom
	(properties
		picture 12180
		stepSound 4
		baseView 6000
	)

	(method (drawPic param1)
		(if (gCast contains: mist)
			(switch param1
				(12180
					(mist scaleX: 40 scaleY: 80 priority: 1 show: posn: 197 93)
				)
				(12190
					(mist
						scaleX: 128
						scaleY: 128
						priority: 1
						show:
						posn: 156 15
					)
				)
				(12430
					(mist scaleX: 128 scaleY: 128 show: posn: 97 125)
				)
				(12440
					(mist
						scaleX: 128
						scaleY: 128
						priority: 1
						show:
						posn: 21 189
					)
				)
				(12300
					(mist scaleX: 30 scaleY: 30 priority: 1 show: posn: 273 70)
				)
				(12150
					(mist scaleX: 40 scaleY: 70 priority: 1 show: posn: 156 115)
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

	(method (init)
		(ClearFlag 121)
		(drawer init: setPri: 0)
		(gEgo init: setScaler: Scaler 100 28 150 73)
		(vanity init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (not (IsFlag 43))
			(mirror init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(portrait init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (< gChapter 6)
			(bed init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(westExit init: 4)
		(if (and (== gChapter 6) (not (IsFlag 43)))
			(mist init:)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(switch (gEgo x:)
					(80
						(= global163 bed)
					)
					(110
						(= global163 vanity)
					)
				)
				(gEgo show:)
			)
			(12100
				(switch global125
					(35
						(= global163 vanity)
						(gEgo normalize: 613 posn: 253 116)
						(if (and (== gChapter 6) (not (IsFlag 43)))
							(self setScript: seeVision549)
						else
							(self setScript: toVanityScr)
						)
						(= global125 0)
					)
					(53
						(= global163 bed)
						(gEgo normalize: 613 posn: 238 105)
						(self setScript: getOnBedScr)
					)
					(else
						(gEgo normalize: 610 posn: 20 150)
						(= global125 0)
						(self setScript: (ScriptID 0 5) 0 6) ; takeLastStep
					)
				)
			)
			(12200
				(switch global125
					(35
						(= global163 vanity)
						(gEgo normalize: 613 posn: 253 116)
						(if (and (== gChapter 6) (not (IsFlag 43)))
							(self setScript: seeVision549)
						else
							(self setScript: toVanityScr)
						)
						(= global125 0)
					)
					(53
						(= global163 bed)
						(gEgo normalize: 613 posn: 238 105)
						(self setScript: getOnBedScr)
					)
					(else
						(gEgo normalize: 610 posn: 20 150)
						(= global125 0)
						(self setScript: (ScriptID 0 5) 0 6) ; takeLastStep
					)
				)
			)
			(else
				(gEgo normalize: 610 posn: 20 150)
				(self setScript: (ScriptID 0 5) 0 6) ; takeLastStep
			)
		)
		(super init:)
	)

	(method (notify)
		(if (== script toVanityScr)
			(script cue:)
		)
	)

	(method (setScript)
		(ClearFlag 121)
		(super setScript: &rest)
	)

	(method (newRoom)
		(ClearFlag 121)
		(super newRoom: &rest)
	)
)

(instance drawer of View
	(properties
		x 122
		y 130
		view 12180
	)

	(method (init)
		(if (== gChapter 5)
			(= view 12181)
		)
		(super init: &rest)
	)
)

(instance mist of Prop
	(properties
		x 97
		y 125
		priority 150
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

	(method (doit &tmp temp0)
		(= temp0 cel)
		(super doit:)
		(if (and local5 (<= priority 135) (> priority 125))
			(local4 eachElementDo: #perform changePri local5)
		)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(super dispose:)
	)
)

(instance book of View
	(properties
		x 89
		y 108
		priority 200
		fixPriority 1
		view 12463
	)
)

(instance hands of View
	(properties
		x 1
		y 154
		priority 500
		fixPriority 1
		view 12192
	)
)

(instance letter of View
	(properties
		x 121
		y 92
		view 12190
	)

	(method (init)
		(if (== gChapter 5)
			(= view 12191)
		)
		(super init: &rest)
		(self nsLeft: 150 nsTop: 72 nsRight: 165 nsBottom: 90)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= nsLeft temp0 nsRight) (<= nsTop temp1 nsBottom)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				((gCurRoom script:) setScript: checkOutLetter)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theKnob of Feature
	(properties
		nsLeft 154
		nsTop 100
		nsRight 167
		nsBottom 111
		x 161
		y 105
	)

	(method (doVerb)
		((gCurRoom script:) cue:)
	)
)

(instance checkOutLetter of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ClearFlag 121)
					(letter hide:)
					(DoRobot 942 67 18 gEgo 200)
					(= register (View new:))
					(register
						view: (if (== gChapter 5) 944 else 943)
						loop: 0
						cel: 0
						x: 139
						y: 116
						init:
					)
					(gCurRoom drawPic: 12180)
				)
				(1
					(register cel: 1)
					(UpdateScreenItem register)
				)
				(2
					(register hide:)
					(global114 pause:)
					(gCurRoom drawPic: 12192)
					(sfx number: 12015 setLoop: 1 play: self)
				)
				(3
					(global114 endPause:)
					(hands dispose:)
					(letter hide:)
					(register show:)
					(DoRobot 943 66 17 gEgo 200)
					(gCurRoom drawPic: 12180)
				)
				(4
					(register dispose:)
					(SetFlag 121)
					(letter cel: 0 show:)
					(gCurRoom drawPic: 12190)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(global114 endPause: 1)
					(SetFlag 121)
					(sfx stop:)
					(KillRobot)
					(letter cel: 0 show:)
					(hands dispose:)
					(register dispose:)
					(gCurRoom drawPic: 12190)
					(gGame handsOn:)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 0
		nextRoom 12200
	)
)

(instance bed of Feature
	(properties
		approachX 100
		approachY 40
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 86 61 72 130 72 138 68 149 71 155 84 155 90 149 91 149 118 18 118
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getOnBedScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vanity of Feature
	(properties
		approachX 300
		approachY 94
		x 276
		y 98
	)

	(method (handleEvent event)
		(if (and (== global163 mirror) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 93 157 129 199 129 175 93
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: toVanityScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance portrait of Feature
	(properties
		nsLeft 65
		nsTop 15
		nsRight 91
		nsBottom 40
		sightAngle 40
		approachY 150
		x 78
		y 27
	)

	(method (doVerb)
		(= global125 1)
		(gCurRoom newRoom: 12200)
	)
)

(instance mirror of Feature
	(properties
		approachX 300
		approachY 94
	)

	(method (handleEvent event)
		(if (and (== global163 vanity) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 53 192 44 199 44 204 54 204 76 200 84 196 86 191 83 187 71
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(if (and (== gChapter 6) (not (IsFlag 43)))
					(gCurRoom setScript: seeVision549)
				else
					(gCurRoom setScript: primpScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
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

	(method (init)
		(backDrop view: view x: x y: y init:)
		(super init:)
	)

	(method (dispose)
		(backDrop dispose:)
		(super dispose:)
	)
)

(instance changePri of Code
	(properties)

	(method (doit param1 param2)
		(param1 priority: (+ (param1 priority:) param2))
	)
)

(instance seeVision549 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(Load 140 12063) ; WAVE
					(Lock 140 12063 1) ; WAVE
					(mirror dispose:)
					(= local5 0)
					(gGame handsOff:)
					(SetFlag 43)
					(DoRobot 5490)
					(drawer hide:)
					(if global125
						(gCurRoom picture: 12440)
					else
						(gCurRoom drawPic: 12440)
					)
				)
				(1
					(Robot 0 5494 (gCurRoom plane:) -1 30 36) ; Open
					(Robot 1 0) ; DisplayFrame
					(mist priority: 135 loop: 0)
					(gCurRoom drawPic: 12430)
					(= local4 (List new:))
					(local4 add: mist)
					(for ((= temp0 1)) (< temp0 3) ((++ temp0))
						(= scratch (Prop new:))
						(scratch
							view: (mist view:)
							loop: (mist loop:)
							x: (mist x:)
							y: (mist y:)
							init:
							setPri: (- (mist priority:) (* temp0 2))
							cycleSpeed: (mist cycleSpeed:)
							setCycle: Fwd
						)
						(local4 add: scratch)
					)
					(gEgo hide:)
					(= ticks 60)
				)
				(2
					(gEgo show:)
					(KillRobot)
					(DoRobot 5494 30 36)
				)
				(3
					(= local5 -1)
				)
				(4
					(local4
						delete: mist
						eachElementDo: #dispose
						release:
						dispose:
					)
					(= local4 0)
					(= local5 0)
					(DoRobot 5493 34 0)
					(gCurRoom drawPic: 12440)
				)
				(5
					(DoRobot 5496 -2 8)
					(gCurRoom drawPic: 12452)
				)
				(6
					(DoRobot 5497 69 11 gEgo 140)
					(gCurRoom drawPic: 12464)
					(book init:)
					(secretPanel
						view: (+ 12461 (== gChapter 5))
						x: 120
						y: 128
						cel: 0
						init:
					)
				)
				(7
					(book dispose:)
				)
				(8
					(secretPanel setCycle: End)
				)
				(9
					(gEgo hide:)
					(sfx number: 12063 setLoop: 1 play:)
					(secretPanel setCycle: Beg self)
				)
				(10
					(gEgo show:)
					(sfx stop:)
					(secretPanel dispose:)
					(= register 0)
					(DoRobot 5492 8 11)
					(gCurRoom drawPic: 12440)
				)
				(11
					(DoRobot 5495 37 35)
					(gCurRoom drawPic: 12430)
					(mist priority: 126)
					(= local4 (List new:))
					(local4 add: mist)
					(for ((= temp0 1)) (< temp0 3) ((++ temp0))
						(= scratch (Prop new:))
						(scratch
							view: (mist view:)
							loop: (mist loop:)
							x: (mist x:)
							y: (mist y:)
							init:
							setPri: (- (mist priority:) (* temp0 2))
							cycleSpeed: (mist cycleSpeed:)
							setCycle: Fwd
						)
						(local4 add: scratch)
					)
				)
				(12
					(= local5 1)
				)
				(13
					(= local5 0)
					(gEgo hide:)
					(for ((= temp0 0)) (< temp0 (local4 size:)) ((++ temp0))
						(= scratch (local4 at: temp0))
						(scratch
							loop: 1
							cel: 0
							setCycle: End (if (== scratch mist) self else 0)
						)
					)
				)
				(14
					(local4 eachElementDo: #dispose release: dispose:)
					(= local4 0)
					(gCurRoom drawPic: 12180)
					(gEgo show:)
					(gEgo normalize: 610 posn: 110 150)
					(Lock 140 12063 0) ; WAVE
					(drawer show:)
					(gGame handsOn:)
					(global114 endPause:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(global114 endPause:)
					(sfx stop:)
					(Lock 140 12063 0) ; WAVE
					(if local4
						(local4
							delete: mist
							eachElementDo: #dispose
							release:
							dispose:
						)
						(= local4 0)
					)
					(mist dispose:)
					(secretPanel dispose:)
					(= global115 0)
					(gCurRoom drawPic: 12180)
					(gEgo show:)
					(gEgo normalize: 610 posn: 110 150)
					(drawer show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getOnBedScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_8)
					(if global125
						(gCurRoom picture: 12300)
					else
						(gCurRoom drawPic: 12300)
					)
					(= global125 0)
					(DoRobot 890 189 33)
				)
				(1
					(proc1111_9)
					(gEgo normalize: 612 posn: 80 150)
					(gGame handsOn:)
					(gCurRoom drawPic: 12180)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_9)
					(= global115 0)
					(KillRobot)
					(gEgo normalize: 612 posn: 80 150)
					(gCurRoom drawPic: 12180)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance toVanityScr of Script
	(properties)

	(method (changeState newState)
		(cond
			((not global115)
				(switch (= state newState)
					(0
						(SetFlag 248)
						(gEgo normalize: 610 posn: 110 150)
						(= register 1)
						(proc1111_8)
						(if global125
							(gCurRoom picture: 12150)
						else
							(gCurRoom drawPic: 12150)
						)
						(DoRobot 940 30 6 gEgo 200)
					)
					(1
						(= register 0)
						(gCurRoom drawPic: 12190)
						(letter init: cel: 0 show: setHotspot: 4 3) ; Do, Move
						(gGame handsOn:)
						(theKnob init: setHotspot: 4 3) ; Do, Move
						(SetFlag 121)
						((ScriptID 0 14) init:) ; exitButt
					)
					(2
						((ScriptID 0 14) dispose:) ; exitButt
						(ClearFlag 121)
						(theKnob dispose:)
						(gGame handsOff:)
						(letter dispose:)
						(gCurRoom drawPic: 12150)
						(DoRobot 941 27 7 gEgo 200)
					)
					(3
						(proc1111_9)
						(ClearFlag 248)
						(gCurRoom drawPic: 12180)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(register
				(KillRobot)
				(= global115 0)
				(= state 0)
				(self cue:)
			)
			(else
				(ClearFlag 248)
				(ClearFlag 121)
				(KillRobot)
				(= global115 0)
				(proc1111_9)
				(gCurRoom drawPic: 12180)
				(theKnob dispose:)
				(letter dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 4
	)
)

(instance primpScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(if global125
						(gCurRoom picture: 12150)
					else
						(gCurRoom drawPic: 12150)
					)
					(DoRobot 980 8 42 gEgo 200)
				)
				(1
					(gCurRoom drawPic: 12180)
					(proc1111_9)
					(gEgo show:)
					(gEgo normalize: 610 posn: 110 150)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(proc1111_9)
					(gCurRoom drawPic: 12180)
					(gEgo show:)
					(gEgo normalize: 610 posn: 110 150)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

