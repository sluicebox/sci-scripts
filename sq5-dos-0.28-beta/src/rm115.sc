;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use FlickerCycler)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm115 0
	guardTalker 2
)

(local
	local0
)

(instance rm115 of Rm
	(properties
		noun 10
		picture 30
		style -32758
		north 117
	)

	(method (init)
		(gCurRoom
			setRegions: 109 ; starCon
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 69 146 164 146 162 163 225 163 246 151 319 152 318 141 261 141 236 127 196 108 158 97 128 96 121 97 132 97 154 104 167 116 174 144 71 144
					yourself:
				)
		)
		(warning init: stopUpd:)
		(ppLight setCycle: Fwd init:)
		(tv setCycle: Osc init:)
		(lowLite1 setCycle: FlickerCycler init:)
		(lowLite2 setCycle: FlickerCycler init:)
		(hiLite1 setCycle: FlickerCycler init:)
		(hiLite2 setCycle: FlickerCycler init:)
		(hiLite3 setCycle: FlickerCycler init:)
		(hiLite4 setCycle: FlickerCycler init:)
		(hiLite5 setCycle: FlickerCycler init:)
		(hiLite6 setCycle: FlickerCycler init:)
		(hiLite7 setCycle: FlickerCycler init:)
		(cStar init: hide: setScript: sMoveStars)
		(monitor init: setCycle: Fwd)
		(lStar init:)
		(machine init: setOnMeCheck: 1 64)
		(skylight init: setOnMeCheck: 1 512)
		(big_window init: setOnMeCheck: 1 16384)
		(lower_level init: setOnMeCheck: 1 128)
		(space init: setOnMeCheck: 1 1024)
		(Ghead init: setScript: sMoveGuard)
		(cadet init: setMotion: MoveTo 7 189 cadet setCycle: Fwd setLoop: 3)
		(bigmoon init: setOnMeCheck: 1 2)
		(lift init: setOnMeCheck: 1 8)
		(LoadMany rsVIEW 115)
		(super init:)
		(switch gPrevRoomNum
			(119
				(gCurRoom setScript: sFrom119)
			)
			(else
				(gCurRoom setScript: sFrom117)
				(if (not (IsFlag 8))
					(elvis
						setLoop: 0
						init:
						setCycle: Fwd
						setMotion: MoveTo 330 146
					)
					(SetFlag 8)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (StepOn gEgo 16) (not (gCurRoom script:)))
			(gCurRoom setScript: sDontGoThere)
		)
		(if (and (StepOn gEgo 4) (not (gCurRoom script:)))
			(gCurRoom setScript: sDownTheDrain)
		)
		(if
			(and
				(StepOn gEgo 32)
				(not (gCurRoom script:))
				(gEgo setMotion: PolyPath 92 92)
			)
			(gCurRoom newRoom: 117)
		)
		(if (and (< (gEgo y:) 103) (not (gCurRoom script:)))
			(gCurRoom setScript: sLeaveHi)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 21)
	)
)

(instance sLeaveHi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 151 98 self)
			)
			(1
				(gCurRoom newRoom: 117)
			)
		)
	)
)

(instance sDownTheDrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 145 self)
			)
			(1
				(gSq5Music2 number: 127 setLoop: 1 play: self)
				(gEgo
					setCycle: 0
					setScale: 0
					setStep: 5 5
					setLoop: 8
					setCel: 0
					setPri: 13
				)
				(elevator init: setCycle: Fwd)
			)
			(2
				(gSq5Music2 number: 1281 setLoop: -1 play:)
				(gEgo setMotion: MoveTo 84 240 self)
				(elevator setMotion: MoveTo 84 240)
			)
			(3
				(gSq5Music2 number: 109 setLoop: 1 play: self)
			)
			(4
				(gGame handsOn:)
				(gCurRoom newRoom: 119)
			)
		)
	)
)

(instance sDontGoThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Ghead setCycle: Beg)
				(= cycles 3)
			)
			(1
				(gMessager say: 8 1 0 0 self) ; "Space Cadets are not allowed beyond this point."
			)
			(2
				(warning startUpd: hide:)
				(= cycles 3)
			)
			(3
				(warning show:)
				(= cycles 3)
			)
			(4
				(warning hide:)
				(= cycles 3)
			)
			(5
				(warning show:)
				(= cycles 3)
			)
			(6
				(warning hide:)
				(= cycles 3)
			)
			(7
				(warning show: stopUpd:)
				(Ghead setCycle: End)
				(gEgo setMotion: MoveTo 191 126 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrom117 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 1)
				(gEgo
					posn: 151 98
					init:
					setScale: Scaler 100 16 145 92
					setMotion: MoveTo 175 109 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrom119 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 127 setLoop: 1 play: self)
			)
			(1
				(gSq5Music2 number: 128 setLoop: 1 play:)
				(gEgo
					posn: 84 240
					init:
					view: 1
					looper: 0
					setLoop: (- (NumLoops gEgo) 1)
					cel: 0
					setPri: 13
					moveSpeed: 6
					setCycle: 0
					ignoreActors: 1
					noun: 19
					setMotion: MoveTo 84 144 self
				)
				(elevator init: posn: 84 240 setCycle: Fwd ignoreActors: 1)
			)
			(2
				(NormalEgo 1 0)
				(gEgo
					setScale: Scaler 100 16 145 92
					setMotion: PolyPath 202 138 self
				)
			)
			(3
				(gGame handsOn:)
				(elevator dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveGuard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 8))
			)
			(1
				(Ghead setCycle: End self)
			)
			(2
				(= seconds (Random 2 8))
			)
			(3
				(Ghead setCycle: Beg self)
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sMoveStars of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(lStar show: posn: 200 82 setMotion: MoveTo 218 82 self)
			)
			(2
				(lStar hide:)
				(= seconds (Random 2 4))
			)
			(3
				(cStar show: posn: 46 8 setMotion: MoveTo 92 50 self)
			)
			(4
				(cStar hide:)
				(= seconds (Random 2 4))
			)
			(5
				(lStar show: posn: 246 107 setMotion: MoveTo 230 83 self)
			)
			(6
				(lStar hide:)
				(= seconds (Random 2 4))
			)
			(7
				(lStar show: posn: 236 70 setMotion: MoveTo 236 105 self)
			)
			(8
				(lStar hide:)
				(= seconds (Random 2 4))
			)
			(9
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance elvis of Actor
	(properties
		x 234
		y 135
		noun 4
		view 119
	)
)

(instance cadet of Actor
	(properties
		x 119
		y 189
		noun 15
		view 114
		loop 3
		priority 10
		signal 16
		detailLevel 2
	)

	(method (cue)
		(self dispose:)
	)
)

(instance cStar of Actor
	(properties
		x 273
		y 9
		yStep 7
		view 114
		loop 6
		signal 26624
		detailLevel 2
		illegalBits 0
		xStep 7
		moveSpeed 0
	)
)

(instance lStar of Actor
	(properties
		x 34
		y 51
		yStep 1
		view 114
		loop 6
		cel 1
		signal 26624
		detailLevel 2
		illegalBits 0
		xStep 1
		moveSpeed 7
	)
)

(instance ppLight of Prop
	(properties
		x 88
		y 7
		view 114
		loop 14
		detailLevel 2
	)
)

(instance tv of Prop
	(properties
		x 14
		y 85
		view 114
		loop 8
		cycleSpeed 40
		detailLevel 2
	)
)

(instance lowLite1 of Prop
	(properties
		x 8
		y 141
		view 114
		loop 10
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance lowLite2 of Prop
	(properties
		x 8
		y 153
		view 114
		loop 10
		cel 1
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance hiLite1 of Prop
	(properties
		x 38
		y 22
		view 114
		loop 12
		detailLevel 2
	)
)

(instance hiLite2 of Prop
	(properties
		x 37
		y 27
		view 114
		loop 12
		cel 1
		detailLevel 2
	)
)

(instance hiLite3 of Prop
	(properties
		x 24
		y 17
		view 114
		loop 12
		cel 2
		detailLevel 2
	)
)

(instance hiLite4 of Prop
	(properties
		x 19
		y 22
		view 114
		loop 12
		cel 3
		detailLevel 2
	)
)

(instance hiLite5 of Prop
	(properties
		x 8
		y 17
		view 114
		loop 12
		cel 4
		detailLevel 2
	)
)

(instance hiLite6 of Prop
	(properties
		x 19
		y 24
		view 114
		loop 12
		cel 5
		detailLevel 2
	)
)

(instance hiLite7 of Prop
	(properties
		x 17
		y 27
		view 114
		loop 12
		cel 6
		detailLevel 2
	)
)

(instance space of Feature
	(properties
		x 140
		y 9
		noun 13
		onMeCheck 1024
	)
)

(instance warning of Prop
	(properties
		x 163
		y 4
		view 114
		loop 4
		detailLevel 2
	)
)

(instance Ghead of Prop
	(properties
		x 196
		y 167
		noun 11
		view 114
		priority 15
		signal 16400
	)
)

(instance elevator of Actor
	(properties
		x 84
		y 144
		yStep 3
		view 115
		loop 1
		priority 12
		signal 16400
		cycleSpeed 0
		illegalBits 0
	)

	(method (doit)
		(if (and (< 63 (gEgo x:) 114) (< 134 (gEgo y:)))
			(self show:)
		else
			(self hide:)
		)
		(if (== (gEgo x:) 84)
			(self x: (gEgo x:) y: (gEgo y:))
		)
		(super doit: &rest)
	)
)

(instance lift of Feature
	(properties
		x 150
		y 190
		noun 5
		onMeCheck 8
		approachX 223
		approachY 146
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sDownTheDrain)
			)
			(3 ; Walk
				(gCurRoom setScript: sDownTheDrain)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigmoon of Feature
	(properties
		x 250
		y 100
		noun 1
		onMeCheck 2
		approachX 203
		approachY 108
	)
)

(instance machine of Feature
	(properties
		x 10
		y 32
		noun 6
		onMeCheck 64
	)
)

(instance skylight of Feature
	(properties
		x 79
		y 34
		noun 12
		onMeCheck 512
	)
)

(instance monitor of Prop
	(properties
		x 264
		y 159
		noun 7
		onMeCheck 256
		view 1142
		cel 4
		priority 15
		signal 16
		cycleSpeed 12
	)
)

(instance big_window of Feature
	(properties
		x 273
		y 79
		noun 14
		onMeCheck 16384
	)
)

(instance lower_level of Feature
	(properties
		x 25
		y 166
		onMeCheck 128
	)

	(method (init)
		(if (IsFlag 6)
			(= noun 2)
		else
			(= noun 3)
		)
		(super init:)
	)
)

(instance guardTalker of Narrator
	(properties
		x 245
		y 125
		talkWidth 300
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 255 tailY: 115 xOffset: 1 isBottom: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

