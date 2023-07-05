;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Teller)
(use GloryTalker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm210 0
	guard1Talker 1
	guard2Talker 2
)

(local
	[local0 6] = [0 35 36 33 34 999]
	[local6 6] = [0 -45 42 -40 43 999]
	[local12 3] = [0 -41 999]
	[local15 3] = [0 44 999]
	[local18 4] = [0 -46 37 999]
	[local22 3] = [0 -39 999]
	[local25 3] = [0 38 999]
	[local28 6] = [0 -45 42 -40 43 999]
	[local34 5] = [0 -37 41 -44 999]
	[local39 3] = [0 49 999]
	[local42 5] = [0 57 -48 54 999]
	[local47 4] = [0 -38 -50 999]
	[local51 5] = [0 56 58 55 999]
	[local56 3] = [0 51 999]
	[local59 5] = [0 -37 52 53 999]
	[local64 6] = [0 45 -42 40 -43 999]
	[local70 3] = [0 60 999]
	[local73 3] = [0 59 999]
	[local76 6] = [0 45 42 -40 43 999]
	[local82 3] = [0 -62 999]
	[local85 3] = [0 -46 999]
	[local88 3] = [0 -38 999]
	[local91 3] = [0 56 999]
	[local94 4]
	[local98 8]
	[local106 11]
	[local117 5]
	[local122 7]
	[local129 7] = [0 -45 -40 -41 -46 -39 999]
	[local136 9] = [0 -45 -40 -44 -48 -50 -38 -37 999]
	[local145 4] = [0 -42 -43 999]
	[local149 6] = [0 -40 -62 -46 -38 999]
	local155 = 118
	[local156 20]
)

(instance rm210 of Rm
	(properties
		noun 26
		picture 210
		picAngle 75
	)

	(method (init)
		(gWalkHandler addToFront: self)
		(HandsOff)
		(= [local94 0] @local0)
		(= [local98 0] @local6)
		(= [local98 1] @local12)
		(= [local98 2] @local18)
		(= [local98 3] @local15)
		(= [local98 4] @local22)
		(= [local98 5] @local25)
		(= [local106 0] @local28)
		(= [local106 1] @local34)
		(= [local106 2] @local59)
		(= [local106 3] @local42)
		(= [local106 4] @local47)
		(= [local106 5] @local56)
		(= [local106 6] @local51)
		(= [local106 7] @local39)
		(= [local117 0] @local64)
		(= [local117 1] @local70)
		(= [local117 2] @local73)
		(= [local122 0] @local76)
		(= [local122 1] @local82)
		(= [local122 2] @local85)
		(= [local122 3] @local88)
		(= [local122 4] @local91)
		(cond
			((== gPrevRoomNum 200)
				(gLongSong3 number: 925 setLoop: -1 play: 100)
				(self setScript: cominFromBoonies)
			)
			((== gPrevRoomNum 340)
				(self setScript: getOutAndStayOut)
				(gLongSong setLoop: -1 changeTo: 925)
			)
			(else
				(if (== gPrevRoomNum 320)
					(gLongSong3 number: 925 setLoop: -1 play: 100)
				)
				(self setScript: cominFromTown)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 299 189 267 173 220 173 207 157 250 157 175 143 159 63 155 63 140 144 67 158 116 158 110 173 60 173 18 189 0 189
					yourself:
				)
		)
		(pot1 init:)
		(pot2 init:)
		(leftPotPalm init:)
		(leftFrond init:)
		(leftDistantPalm init:)
		(rightPotPalm init:)
		(rightFrond init:)
		(rightDistantPalm init:)
		(leftStatue init:)
		(rightStatue init:)
		(lionHead init:)
		(door init:)
		(stairs init:)
		(pillar1 init:)
		(pillar2 init:)
		(pillar3 init:)
		(pillar4 init:)
		(if (IsFlag 20)
			(closedCityGates init: addToPic:)
		else
			(egoTell init: gEgo @local0 @local94)
			(if (not gNight)
				((Teller new:) init: guard2 @local28 @local106 @local136)
				((Teller new:) init: guard1 @local6 @local98 @local129)
				(guard1 init: addToPic:)
				(guard2 init: addToPic:)
			else
				((Teller new:) init: guard1 @local64 @local117 @local145)
				((Teller new:) init: guard2 @local76 @local122 @local149)
				(guard1 noun: 3 init: addToPic:)
				(guard2 noun: 4 init: addToPic:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 150 350 320)
			(gLongSong3 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(if (< ((User curEvent:) y:) 145)
				(if (< ((User curEvent:) y:) 96)
					(if (< ((User curEvent:) y:) 61)
						(= local155 61)
					else
						(= local155 96)
					)
				else
					(= local155 118)
				)
			else
				(= local155 118)
			)
		)
		(super doVerb: theVerb &rest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((< (gEgo y:) 145)
				(self setScript: goinIntoTown)
			)
			((> (gEgo y:) 186)
				(self setScript: goinToBoonies)
			)
		)
	)
)

(instance cominFromTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					x: (if (== gPrevRoomNum 270) 130 else 160)
					y: (if (== gPrevRoomNum 270) 118 else 96)
					normalize:
					edgeHit: EDGE_NONE
					setScale: Scaler 30 14 142 73
					noun: 5
				)
				(if (== gPrevRoomNum 270)
					(gEgo setMotion: PolyPath 160 (gEgo y:) self)
				else
					(gEgo setMotion: PolyPath 160 150 self)
				)
			)
			(1
				(if (== gPrevRoomNum 270)
					(gEgo setMotion: PolyPath 160 150 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setScale: Scaler 90 30 189 142)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getOutAndStayOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					x: 160
					y: (if (== gPrevRoomNum 270) 118 else 96)
					normalize:
					edgeHit: EDGE_NONE
					setScale: Scaler 30 14 142 73
					changeGait: 1 ; running
					setMotion: PolyPath 160 150 self
					noun: 988
				)
			)
			(1
				(gEgo
					setScale: Scaler 90 30 189 142
					setMotion: MoveTo 160 165 self
				)
			)
			(2
				(gMessager say: 6 6 1 0 self) ; "You quickly leave Tarna before things get even worse."
			)
			(3
				(gEgo setMotion: MoveTo 160 250 self)
				(SetFlag 20)
			)
			(4
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance goinToBoonies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(1
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance cominFromBoonies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					x: 160
					y: 220
					noun: 5
					normalize:
					setScale: Scaler 90 30 189 142
					setMotion: PolyPath 160 180 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goinIntoTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setScale: Scaler 30 14 142 73
					setMotion: PolyPath 160 local155 self
				)
			)
			(1
				(if (== local155 118)
					(gEgo setMotion: MoveTo 130 118 self)
				else
					(self cue:)
				)
			)
			(2
				(switch local155
					(118
						(gCurRoom newRoom: 270)
					)
					(96
						(gCurRoom newRoom: 320)
					)
					(61
						(gCurRoom newRoom: 350)
					)
				)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				35
				(not gNight)
				33
				(not gNight)
				36
				gNight
				34
				gNight
		)
	)
)

(instance guard1 of View
	(properties
		x 73
		y 165
		noun 1
		approachX 125
		approachY 167
		view 210
		loop 3
		cel 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 2 4) ; Look, Talk, Do
	)
)

(instance guard2 of View
	(properties
		x 231
		y 169
		noun 2
		approachX 214
		approachY 167
		view 210
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 2 4) ; Look, Talk, Do
	)
)

(instance guard1Talker of GloryTalker
	(properties
		x 1
		y 1
		view 191
		loop 1
		talkWidth 150
		back 57
		textX 139
		textY 5
	)

	(method (init)
		(super init: guard1Brow guard1Eyes guard1Mouth &rest)
	)
)

(instance guard1Mouth of Prop
	(properties
		nsTop 46
		nsLeft 46
		view 191
	)
)

(instance guard1Eyes of Prop
	(properties
		nsTop 35
		nsLeft 44
		view 191
		loop 2
	)
)

(instance guard1Brow of View
	(properties
		nsTop 24
		nsLeft 40
		view 191
		loop 3
	)
)

(instance guard2Talker of GloryTalker
	(properties
		x 203
		y 1
		view 196
		loop 1
		talkWidth 150
		back 57
		textX -180
		textY 5
	)

	(method (init)
		(super init: guard2Bust guard2Eyes guard2Mouth &rest)
	)
)

(instance guard2Mouth of Prop
	(properties
		nsTop 46
		nsLeft 26
		view 196
	)
)

(instance guard2Eyes of Prop
	(properties
		nsTop 35
		nsLeft 34
		view 196
		loop 2
	)
)

(instance guard2Bust of View
	(properties
		view 196
		loop 1
	)
)

(instance closedCityGates of View
	(properties
		x 161
		y 150
		noun 7
		view 211
	)
)

(instance pot1 of Feature
	(properties
		x 29
		y 151
		noun 8
		nsTop 135
		nsLeft 5
		nsBottom 168
		nsRight 53
		sightAngle 180
	)
)

(instance pot2 of Feature
	(properties
		x 288
		y 152
		noun 9
		nsTop 135
		nsLeft 264
		nsBottom 170
		nsRight 313
		sightAngle 180
	)
)

(instance leftPotPalm of Feature
	(properties
		x 24
		y 68
		noun 10
		nsTop 3
		nsLeft 1
		nsBottom 133
		nsRight 47
		sightAngle 180
	)
)

(instance leftFrond of Feature
	(properties
		x 59
		y 46
		noun 11
		nsTop 21
		nsLeft 47
		nsBottom 71
		nsRight 71
		sightAngle 180
	)
)

(instance leftDistantPalm of Feature
	(properties
		x 85
		y 38
		noun 12
		nsTop 28
		nsLeft 74
		nsBottom 48
		nsRight 96
		sightAngle 180
	)
)

(instance rightPotPalm of Feature
	(properties
		x 293
		y 68
		noun 13
		nsTop 2
		nsLeft 268
		nsBottom 135
		nsRight 319
		sightAngle 180
	)
)

(instance rightFrond of Feature
	(properties
		x 257
		y 69
		noun 14
		nsTop 49
		nsLeft 247
		nsBottom 90
		nsRight 268
		sightAngle 180
	)
)

(instance rightDistantPalm of Feature
	(properties
		x 231
		y 39
		noun 15
		nsTop 29
		nsLeft 222
		nsBottom 50
		nsRight 241
		sightAngle 180
	)
)

(instance leftStatue of Feature
	(properties
		x 93
		y 65
		noun 16
		nsTop 49
		nsLeft 85
		nsBottom 81
		nsRight 102
		sightAngle 180
	)
)

(instance rightStatue of Feature
	(properties
		x 220
		y 63
		noun 17
		nsTop 47
		nsLeft 213
		nsBottom 80
		nsRight 228
		sightAngle 180
	)
)

(instance lionHead of Feature
	(properties
		x 158
		y 25
		noun 18
		nsTop 10
		nsLeft 139
		nsBottom 40
		nsRight 178
		sightAngle 180
	)
)

(instance door of Feature
	(properties
		x 157
		y 57
		noun 27
		nsTop 53
		nsLeft 154
		nsBottom 61
		nsRight 161
		sightAngle 180
	)
)

(instance stairs of Feature
	(properties
		x 159
		y 89
		noun 20
		nsTop 61
		nsLeft 138
		nsBottom 117
		nsRight 180
		sightAngle 180
	)
)

(instance pillar1 of Feature
	(properties
		x 82
		y 110
		noun 23
		nsTop 85
		nsLeft 74
		nsBottom 135
		nsRight 90
		sightAngle 180
	)
)

(instance pillar2 of Feature
	(properties
		x 98
		y 117
		noun 22
		nsTop 98
		nsLeft 92
		nsBottom 136
		nsRight 105
		sightAngle 180
	)
)

(instance pillar3 of Feature
	(properties
		x 216
		y 121
		noun 24
		nsTop 99
		nsLeft 211
		nsBottom 143
		nsRight 222
		sightAngle 180
	)
)

(instance pillar4 of Feature
	(properties
		x 231
		y 115
		noun 25
		nsTop 87
		nsLeft 225
		nsBottom 143
		nsRight 238
		sightAngle 180
	)
)

