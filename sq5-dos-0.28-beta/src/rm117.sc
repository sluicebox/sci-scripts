;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
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
	rm117 0
	guardTalker 2
)

(instance rm117 of Rm
	(properties
		noun 10
		picture 29
		style -32758
		horizon 91
		north 115
		west 121
		vanishingX 193
		vanishingY 91
	)

	(method (init)
		(gCurRoom
			setRegions: 109 ; starCon
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 191 185 152 147 250 147 250 144 150 142 150 140 148 128 155 109 172 100 183 97 204 95 226 94 227 93 197 94 155 98 130 104 101 113 74 127 58 136 0 136 0 185
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
		(bigmoon init: setOnMeCheck: 1 2)
		(space init: setOnMeCheck: 1 16384)
		(cStar init: setScript: sMoveStars)
		(lStar init:)
		(lift init: setOnMeCheck: 1 8)
		(Ghead init:)
		(machine init: setOnMeCheck: 1 64)
		(monitor init: setScript: sPlayMC)
		(skylight init: setOnMeCheck: 1 512)
		(red_planet init: setOnMeCheck: 1 -32768)
		(lower_level init: setOnMeCheck: 1 256)
		(cadet init: setMotion: MoveTo 316 185 cadet setCycle: Fwd setLoop: 2)
		(LoadMany rsVIEW 115)
		(super init:)
		(switch gPrevRoomNum
			(119
				(gCurRoom setScript: sFrom119)
			)
			(115
				(gCurRoom setScript: sFrom115)
			)
			(else
				(NormalEgo 1 0)
				(gEgo
					posn: 10 140
					init:
					illegalBits: 0
					setScale: Scaler 100 16 155 92
					setMotion: MoveTo 106 140 self
				)
				(gGame handsOn:)
			)
		)
	)

	(method (doit)
		(if (and (StepOn gEgo 16) (not (gCurRoom script:)))
			(gCurRoom setScript: sDontGoThere)
		)
		(if (and (StepOn gEgo 1024) (not (gCurRoom script:)))
			(gCurRoom setScript: sDownTheDrain)
		)
		(if (and (< (gEgo y:) 103) (not (gCurRoom script:)))
			(gCurRoom setScript: sLeaveHi)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 21)
	)
)

(instance ppLight of Prop
	(properties
		x 231
		y 7
		view 114
		loop 13
		detailLevel 2
	)
)

(instance cStar of Actor
	(properties
		x 273
		y 9
		yStep 7
		view 114
		loop 5
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
		loop 5
		cel 1
		signal 26624
		detailLevel 2
		illegalBits 0
		xStep 1
		moveSpeed 7
	)
)

(instance tv of Prop
	(properties
		x 306
		y 85
		view 114
		loop 7
		cycleSpeed 40
		detailLevel 2
	)
)

(instance lowLite1 of Prop
	(properties
		x 312
		y 141
		view 114
		loop 9
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance lowLite2 of Prop
	(properties
		x 312
		y 153
		view 114
		loop 9
		cel 1
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance hiLite1 of Prop
	(properties
		x 282
		y 22
		view 114
		loop 11
		detailLevel 2
	)
)

(instance hiLite2 of Prop
	(properties
		x 282
		y 27
		view 114
		loop 11
		cel 1
		detailLevel 2
	)
)

(instance hiLite3 of Prop
	(properties
		x 296
		y 17
		view 114
		loop 11
		cel 2
		detailLevel 2
	)
)

(instance hiLite4 of Prop
	(properties
		x 301
		y 22
		view 114
		loop 11
		cel 3
		detailLevel 2
	)
)

(instance hiLite5 of Prop
	(properties
		x 311
		y 17
		view 114
		loop 11
		cel 4
		detailLevel 2
	)
)

(instance hiLite6 of Prop
	(properties
		x 301
		y 24
		view 114
		loop 11
		cel 5
		detailLevel 2
	)
)

(instance hiLite7 of Prop
	(properties
		x 302
		y 27
		view 114
		loop 11
		cel 6
		detailLevel 2
	)
)

(instance Ghead of Prop
	(properties
		x 133
		y 160
		noun 11
		view 114
		loop 1
		priority 15
		signal 16400
	)
)

(instance warning of Prop
	(properties
		x 29
		y 4
		view 114
		loop 4
		priority 15
		signal 16400
	)
)

(instance cadet of Actor
	(properties
		x 197
		y 185
		noun 14
		yStep 1
		view 114
		loop 2
		priority 5
		signal 24592
		xStep 1
	)

	(method (cue)
		(self dispose:)
	)
)

(instance elevator of Actor
	(properties
		x 231
		y 144
		yStep 3
		view 115
		cel 1
		priority 12
		signal 16400
		cycleSpeed 0
		illegalBits 0
	)

	(method (doit)
		(if (and (< 211 (gEgo x:) 250) (< 134 (gEgo y:)))
			(self show:)
		else
			(self hide:)
		)
		(if (== (gEgo x:) 233)
			(self x: (gEgo x:) y: (gEgo y:))
		)
		(super doit: &rest)
	)
)

(instance lift of Feature
	(properties
		x 150
		y 190
		noun 4
		onMeCheck 8
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
		x 34
		y 79
		noun 1
		onMeCheck 2
	)
)

(instance space of Feature
	(properties
		x 140
		y 9
		noun 13
		onMeCheck 16384
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
				(gMessager say: 8 1 0 0 self) ; "You are not allowed beyond this point."
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
				(gEgo setMotion: MoveTo 113 130 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveHi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 181 98 self)
			)
			(1
				(gCurRoom newRoom: 115)
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
				(lStar show: posn: 34 51 setMotion: MoveTo 62 79 self)
			)
			(2
				(lStar hide:)
				(= seconds (Random 2 4))
			)
			(3
				(cStar show: posn: 273 9 setMotion: MoveTo 232 51 self)
			)
			(4
				(cStar hide:)
				(= seconds (Random 2 4))
			)
			(5
				(lStar show: posn: 59 58 setMotion: MoveTo 7 58 self)
			)
			(6
				(lStar hide:)
				(= seconds (Random 2 4))
			)
			(7
				(lStar show: posn: 19 111 setMotion: MoveTo 55 111 self)
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

(instance sDownTheDrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 233 144 self)
			)
			(2
				(elevator init: setCycle: Fwd)
				(gSq5Music2 number: 127 setLoop: 1 play: self)
				(gEgo
					setCycle: 0
					setScale: 0
					setStep: 5 5
					setLoop: 8
					setCel: 0
					setPri: 13
				)
			)
			(3
				(gSq5Music2 number: 1281 setLoop: -1 play:)
				(gEgo setMotion: MoveTo 233 240 self)
			)
			(4
				(gSq5Music2 number: 109 setLoop: 1 play: self)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 119)
			)
		)
	)
)

(instance sFrom115 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 1 2)
				(gEgo
					view: 1
					posn: 181 98
					init:
					illegalBits: 0
					setScale: Scaler 100 16 155 92
					setMotion: MoveTo 149 109 self
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
					init:
					view: 1
					posn: 233 240
					looper: 0
					setLoop: (- (NumLoops gEgo) 1)
					setPri: 13
					moveSpeed: 6
					cel: 1
					setCycle: 0
					ignoreActors: 1
					noun: 19
					setMotion: MoveTo 233 144 self
				)
				(elevator init: posn: 233 240 setCycle: Fwd ignoreActors: 1)
			)
			(2
				(NormalEgo 1 1)
				(gEgo
					setScale: Scaler 100 16 155 92
					setMotion: PolyPath 119 143 self
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

(instance sMoveGuard of Script ; UNUSED
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

(instance red_planet of Feature
	(properties
		x 217
		y 121
		noun 7
		onMeCheck -32768
	)
)

(instance machine of Feature
	(properties
		x 311
		y 40
		noun 5
		onMeCheck 64
	)
)

(instance skylight of Feature
	(properties
		x 245
		y 31
		noun 12
		onMeCheck 512
	)
)

(instance monitor of Prop
	(properties
		x 13
		y 161
		noun 6
		onMeCheck 128
		view 1142
		loop 1
		priority 15
		signal 16
		cycleSpeed 14
	)
)

(instance sPlayMC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monitor setCycle: End self)
			)
			(1
				(monitor cel: 0)
				(= state -1)
				(= seconds 3)
			)
		)
	)
)

(instance lower_level of Feature
	(properties
		x 297
		y 163
		onMeCheck 256
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
		x 77
		y 126
		talkWidth 100
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 77 tailY: 121 xOffset: -5 isBottom: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

