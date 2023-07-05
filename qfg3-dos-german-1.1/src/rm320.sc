;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use Teller)
(use GloryTalker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm320 0
	rightGuardTalker 1
	leftGuardTalker 2
	rightGuardTalker 3
	leftGuardTalker 4
)

(local
	[local0 6] = [0 18 17 20 19 999]
	[local6 6] = [0 -2 3 -4 13 999]
	[local12 5] = [0 8 -9 -11 999]
	[local17 5] = [0 6 7 5 999]
	[local22 3] = [0 10 999]
	[local25 3] = [0 12 999]
	[local28 6] = [0 -2 -3 -4 -13 999]
	[local34 6] = [0 -2 -3 -4 -13 999]
	[local40 6] = [0 -2 3 4 13 999]
	[local46 5] = [0 8 -9 -11 999]
	[local51 8] = [0 21 22 23 24 25 26 999]
	[local59 4] = [0 28 29 999]
	[local63 4]
	[local67 7]
	[local74 5]
	[local79 5]
	[local84 7]
	[local91 6] = [0 -2 -4 -9 -11 999]
	[local97 6] = [0 -2 -4 -9 -11 999]
)

(instance rm320 of Rm
	(properties
		noun 11
		picture 320
		vanishingY -58
	)

	(method (init)
		(LoadMany rsVIEW 196 191)
		(= [local63 0] @local0)
		(= [local67 0] @local6)
		(= [local67 1] @local12)
		(= [local67 2] @local17)
		(= [local67 3] @local22)
		(= [local67 4] @local25)
		(= [local84 0] @local40)
		(= [local84 1] @local46)
		(= [local84 3] @local51)
		(= [local84 4] @local59)
		(= [local74 0] @local28)
		(= [local79 0] @local34)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 135 0 0 319 0 319 124 310 136 296 136 275 55 249 55 273 139 260 140 236 133 132 148 92 129 97 120 97 103 82 99 87 120 73 123 58 123 43 114 63 103 44 91 41 112 27 120 11 124
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 163 4 159 4 146 14 144 21 134 40 131 48 134 36 137 99 153 129 163 304 143 319 189 0 189
					yourself:
				)
		)
		(tell init: gEgo @local0 @local63)
		(gEgo noun: 3 init: normalize: xStep: 2 yStep: 1 setScale: 415)
		(leftGuardTell
			init:
				leftGuard
				(if gNight @local34 else @local28)
				(if gNight @local79 else @local74)
		)
		(leftGuard
			noun: (if gNight 4 else 2)
			init:
			stopUpd:
			approachVerbs: 4 2 ; Do, Talk
		)
		(rightGuardTell
			init:
				rightGuard
				(if gNight @local40 else @local6)
				(if gNight @local84 else @local67)
				(if gNight @local97 else @local91)
		)
		(rightGuard
			noun: (if gNight 5 else 1)
			init:
			stopUpd:
			approachVerbs: 4 2 ; Do, Talk
		)
		(tallGay1 init:)
		(tallGay2 init:)
		(temple init:)
		(toKing init:)
		(toJudge init:)
		(magicshop init:)
		(dome init:)
		(spire init:)
		(super init: &rest)
		(gLongSong number: 320 setLoop: -1 play:)
		(switch gPrevRoomNum
			(270
				(gEgo x: -17 y: 180)
				(self setScript: sFrom270)
			)
			(330
				(gEgo x: 60 y: 111)
				(self setScript: sFrom330)
			)
			(350
				(gEgo x: 271 y: 105)
				(self setScript: sFrom350)
			)
			(210
				(gEgo x: 319 y: 164)
				(self setScript: sFrom210)
			)
			(else
				(gEgo x: 100 y: 123 view: 1)
				(self setScript: sFrom340)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond
			(script)
			((not (= temp0 (gEgo onControl: 1))))
			((== temp0 2)
				(if
					(and
						(= temp1 (gEgo mover:))
						(== (OnControl CONTROL (temp1 x:) (temp1 y:)) 2)
					)
					(gCurRoom setScript: sTo270)
				)
			)
			((== temp0 4)
				(if
					(and
						(= temp1 (gEgo mover:))
						(== (OnControl CONTROL (temp1 x:) (temp1 y:)) 4)
					)
					(HandsOff)
					(gCurRoom setScript: noEnterKings)
				)
			)
			((== temp0 8)
				(if
					(and
						(= temp1 (gEgo mover:))
						(== (OnControl CONTROL (temp1 x:) (temp1 y:)) 8)
					)
					(HandsOff)
					(gCurRoom setScript: noEnterJudgement)
				)
			)
			((== temp0 16)
				(if
					(and
						(= temp1 (gEgo mover:))
						(== (OnControl CONTROL (temp1 x:) (temp1 y:)) 16)
					)
					(gCurRoom setScript: sTo350)
				)
			)
			((== temp0 32)
				(if
					(and
						(= temp1 (gEgo mover:))
						(== (OnControl CONTROL (temp1 x:) (temp1 y:)) 32)
					)
					(gCurRoom setScript: sTo210)
				)
			)
			((not (< (gEgo x:) 315))
				(gCurRoom setScript: sTo210)
			)
		)
	)

	(method (dispose)
		(UnLoad 128 196)
		(UnLoad 128 191)
		(super dispose:)
	)
)

(instance sTo270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 0 155 self)
			)
			(1
				(gLongSong fade: 0 5 10 1)
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sFrom210 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 280 141 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance noEnterKings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(leftGuard setCycle: End self)
			)
			(1
				(if gNight
					(gMessager say: 5 6 1 0 self) ; "No one can enter here at night."
				else
					(gMessager say: 1 6 1 0 self) ; "None may enter unless requested to do so."
				)
			)
			(2
				(leftGuard setCycle: Beg self)
			)
			(3
				(leftGuard stopUpd:)
				(gEgo
					setCycle: Rev
					setLoop: 6
					setMotion:
						PolyPath
						(- (gEgo x:) 4)
						(+ (gEgo y:) 4)
						self
				)
			)
			(4
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance noEnterJudgement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(rightGuard setCycle: End self)
			)
			(1
				(if gNight
					(gMessager say: 5 6 1 0 self) ; "No one can enter here at night."
				else
					(gMessager say: 1 6 1 0 self) ; "None may enter unless requested to do so."
				)
			)
			(2
				(rightGuard setCycle: Beg self)
			)
			(3
				(rightGuard stopUpd:)
				(gEgo
					setCycle: Rev
					setLoop: 6
					setMotion: MoveTo (- (gEgo x:) 5) (+ (gEgo y:) 3) self
				)
			)
			(4
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTo350 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong fade: 0 5 10 1)
				(gEgo setMotion: PolyPath 273 98 self)
			)
			(1
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance sTo210 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 4)
						(+ (gEgo y:) 11)
						self
				)
			)
			(1
				(gLongSong fade: 0 5 10 1)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance sFrom270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 29 128 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFrom330 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 27 122 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFrom340 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 1
					setLoop: 5
					setCycle: Walk
					setMotion: PolyPath 75 124 self
				)
			)
			(1
				(gEgo view: 0 normalize:)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFrom350 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 282 138 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (gEgo x:) 5)
					(= register 270)
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 20)
							(+ (gEgo y:) 30)
							self
					)
				else
					(= register 210)
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 20)
							(+ (gEgo y:) 30)
							self
					)
				)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance rightGuard of Actor
	(properties
		x 105
		y 128
		approachX 98
		approachY 134
		view 197
		signal 16384
	)
)

(instance leftGuard of Actor
	(properties
		x 30
		y 116
		approachX 28
		approachY 122
		view 192
		signal 16384
	)
)

(instance magicshop of Feature
	(properties
		x 28
		y 171
		noun 14
		nsTop 154
		nsLeft 4
		nsBottom 189
		nsRight 53
	)
)

(instance dome of Feature
	(properties
		x 209
		y 164
		noun 9
		nsTop 153
		nsLeft 174
		nsBottom 176
		nsRight 245
	)
)

(instance spire of Feature
	(properties
		x 211
		y 129
		noun 15
		nsTop 106
		nsLeft 202
		nsBottom 152
		nsRight 220
	)
)

(instance tallGay1 of Feature
	(properties
		x 140
		y 75
		noun 6
		nsTop 7
		nsLeft 123
		nsBottom 144
		nsRight 157
	)
)

(instance tallGay2 of Feature
	(properties
		x 11
		y 58
		noun 7
		nsTop 2
		nsLeft 1
		nsBottom 115
		nsRight 21
	)
)

(instance temple of Feature
	(properties
		x 260
		y 39
		noun 8
		nsTop 28
		nsLeft 244
		nsBottom 51
		nsRight 277
	)
)

(instance toKing of Feature
	(properties
		x 48
		y 103
		noun 12
		nsTop 94
		nsLeft 43
		nsBottom 112
		nsRight 54
	)
)

(instance toJudge of Feature
	(properties
		x 94
		y 112
		noun 13
		nsTop 104
		nsLeft 90
		nsBottom 120
		nsRight 98
	)
)

(instance tell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				18
				(not gNight)
				20
				gNight
				17
				(not gNight)
				19
				gNight
		)
	)
)

(instance leftGuardTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -2 -3 -4 -13)
	)

	(method (doChild)
		(if gNight
			(gMessager say: 4 5 14) ; "I am a Liontaur, and not here to speak to humans."
		else
			(gMessager say: 2 5 14) ; "It is not my duty to answer the questions of humans."
		)
		(return 0)
	)
)

(instance rightGuardTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -2 -3 -4 -13)
	)
)

(instance leftGuardTalker of GloryTalker
	(properties
		x 5
		y 2
		view 194
		loop 1
		talkWidth 260
		back 57
		textX 20
		textY 150
		backColor 11
	)

	(method (init)
		(super init: leftGuardBust leftGuardEyes leftGuardMouth &rest)
	)
)

(instance leftGuardMouth of Prop
	(properties
		nsTop 47
		nsLeft 49
		view 194
	)
)

(instance leftGuardEyes of Prop
	(properties
		nsTop 33
		nsLeft 42
		view 194
		loop 2
	)
)

(instance leftGuardBust of View
	(properties
		nsTop 24
		nsLeft 30
		view 193
		loop 3
	)
)

(instance rightGuardTalker of GloryTalker
	(properties
		x 200
		y 2
		view 193
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 150
		backColor 11
	)

	(method (init)
		(super init: rightGuardBust rightGuardEyes rightGuardMouth &rest)
	)
)

(instance rightGuardMouth of Prop
	(properties
		nsTop 47
		nsLeft 23
		view 193
	)
)

(instance rightGuardEyes of Prop
	(properties
		nsTop 33
		nsLeft 29
		view 193
		loop 2
	)
)

(instance rightGuardBust of View
	(properties
		nsTop 24
		nsLeft 40
		view 193
		loop 3
	)
)

