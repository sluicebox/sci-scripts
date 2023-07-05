;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use Teller)
(use ArrayPath)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	[local0 17] = [-15 156 20 154 40 132 107 121 127 97 114 89 42 97 10 77 -32768]
	[local17 17] = [10 77 42 97 114 89 127 97 107 121 40 132 20 154 -15 156 -32768]
	[local34 21] = [-15 162 30 156 52 137 118 124 143 102 213 97 270 48 237 36 240 26 330 18 -32768]
	[local55 21] = [330 18 240 26 237 36 270 48 213 97 143 102 118 124 52 137 30 156 -15 162 -32768]
	[local76 15] = [41 70 71 91 116 87 149 97 220 100 288 51 330 54 -32768]
	[local91 15] = [330 54 288 51 220 100 149 97 116 87 71 91 41 70 -32768]
	[local106 9] = [44 71 71 90 116 85 330 159 -32768]
	[local115 9] = [330 159 116 85 71 90 44 71 -32768]
	[local124 11] = [330 150 235 120 230 104 291 56 330 59 -32768]
	[local135 11] = [330 59 291 56 230 104 235 120 330 150 -32768]
	[local146 15] = [-15 178 45 163 65 142 129 129 159 107 201 107 330 154 -32768]
	[local161 15] = [330 154 201 107 159 107 129 129 65 142 45 163 -15 178 -32768]
	[local176 20]
	[local196 10]
	local206
	local207 = 4
	local208
	[local209 5] = [270 271 272 271 272]
	[local214 5] = [15 16 17 18 19]
	local219
	local220
	local221
)

(instance rm270 of Rm
	(properties
		noun 21
		picture 270
		horizon 70
		north 320
		picAngle 70
		vanishingX 310
		vanishingY -100
	)

	(method (init)
		(= local208 1)
		(= [local176 0] @local0)
		(= [local176 1] @local161)
		(= [local176 2] @local34)
		(= [local176 3] @local146)
		(= [local176 4] @local106)
		(= [local176 5] @local76)
		(= [local176 6] @local106)
		(= [local176 7] @local34)
		(= [local176 8] @local106)
		(= [local176 9] @local135)
		(= [local176 10] @local17)
		(= [local176 11] @local124)
		(= [local176 12] @local55)
		(= [local176 13] @local161)
		(= [local176 14] @local34)
		(= [local176 15] @local91)
		(= [local176 16] @local115)
		(= [local176 17] @local91)
		(= [local176 18] @local115)
		(= [local176 19] @local124)
		(LoadMany rsVIEW 270 271 272)
		(gEgo init: normalize: setScale: Scaler 39 30 135 70)
		(switch gPrevRoomNum
			(200
				(gEgo x: 325 y: 153)
				(= local219 312)
				(= local220 153)
				(HandsOff)
				(self setScript: moveOut)
			)
			(210
				(gEgo x: 325 y: 153)
				(= local219 312)
				(= local220 153)
				(HandsOff)
				(self setScript: moveOut)
			)
			(240
				(gEgo x: -5 y: 157)
				(= local219 8)
				(= local220 152)
				(HandsOff)
				(self setScript: moveOut)
			)
			(280
				(gLongSong fade: 70 5 3 0 hold: 1)
				(gEgo x: 297 y: 127)
				(= local219 277)
				(= local220 132)
				(HandsOff)
				(self setScript: moveOut)
			)
			(285
				(gLongSong fade: 70 5 3 0 hold: 1)
				(gEgo x: 297 y: 127)
				(= local219 278)
				(= local220 132)
				(HandsOff)
				(self setScript: moveOut)
			)
			(290
				(gLongSong fade: 70 5 3 0 hold: 1 holdVal: 1)
				(gEgo x: 142 y: 76)
				(= local219 132)
				(= local220 83)
				(HandsOff)
				(self setScript: moveOut)
			)
			(300
				(gLongSong fade: 70 5 3 0 hold: 1)
				(if (< (gEgo x:) 115)
					(gEgo x: 56 y: 81)
					(= local219 69)
					(= local220 88)
				else
					(gEgo x: 22 y: 84)
					(= local219 35)
					(= local220 91)
				)
				(HandsOff)
				(self setScript: moveOut)
			)
			(320
				(gEgo x: 259 y: 71)
				(HandsOn)
			)
			(else
				(gEgo x: 160 y: 160)
				(HandsOn)
			)
		)
		(if (!= gPrevRoomNum 210)
			(gLongSong3 number: 925 setLoop: -1 play: 100)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 145 286 136 294 123 278 134 255 126 271 119 238 108 302 59 319 60
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 116 0 263 48 205 97 176 88 148 91 130 83 140 72 124 81 106 75 90 75 94 87 71 89 45 72 65 91 40 92 18 78 30 93 8 95 7 101 116 91 95 117 22 126 0 146
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 187 53 183 59 170 82 146 186 124 203 126 95 146 194 186 319 164 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 201 136 263 160 195 173 135 148
					yourself:
				)
		)
		(if (townPerson1 checkDetail:)
			(++ local206)
			(townPerson1
				detailLevel: 0
				init:
				setScript: (walkAround new:)
				setScale: Scaler 91 43 190 0
				setLoop: Grooper
				setCycle: Walk
			)
		)
		(if (not gNight)
			(if (townPerson2 checkDetail:)
				(++ local206)
				(townPerson2
					detailLevel: 0
					init:
					setScript: (walkAround new:)
					setScale: Scaler 91 43 190 0
					setLoop: Grooper
					setCycle: Walk
				)
			)
			(if (townPerson3 checkDetail:)
				(++ local206)
				(townPerson3
					detailLevel: 0
					init:
					setScript: (walkAround new:)
					setScale: Scaler 91 43 190 0
					setLoop: Grooper
					setCycle: Walk
				)
			)
			(if (townPerson4 checkDetail:)
				(++ local206)
				(townPerson4
					detailLevel: 0
					init:
					setScript: (walkAround new:)
					setScale: Scaler 91 43 190 0
					setLoop: Grooper
					setCycle: Walk
				)
			)
		)
		(guard1 init: noun: 20 addToPic:)
		(garden init:)
		(trees init:)
		(magicsign init:)
		(apothsign init:)
		(restsign init:)
		(restentr init:)
		(apothentr init:)
		(magicentr init:)
		(kingentr init:)
		(bazstair init:)
		(upplant init:)
		(rightplant init:)
		(upstair init:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 320)
			(gLongSong3 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((and (== (= temp0 (gEgo onControl: 1)) 512) (not local221))
				(= local221 1)
				(gLongSong3 fade: 1 3 5 0)
				(gLongSong number: 280 setLoop: -1 play: 1 hold: 1)
				(gLongSong fade: 70 3 5 0)
			)
			((and (== temp0 1024) local221)
				(= local221 0)
				(gLongSong fade: 0 5 3 1)
				(gLongSong3 fade: 100 3 5 0)
			)
			((and (== temp0 2048) (not local221))
				(= local221 1)
				(gLongSong3 fade: 1 3 5 0)
				(gLongSong number: 290 setLoop: -1 play: 1 hold: 1)
				(gLongSong fade: 70 3 5 0)
			)
			((and (== temp0 4096) local221)
				(= local221 0)
				(gLongSong fade: 0 5 3 1)
				(gLongSong3 fade: 100 3 5 0)
			)
			((and (== temp0 8192) (not local221))
				(= local221 1)
				(gLongSong3 fade: 1 3 5 0)
				(gLongSong number: 300 setLoop: -1 play: 1 hold: 1)
				(gLongSong fade: 70 3 5 0)
			)
			((and (== temp0 16384) local221)
				(= local221 0)
				(gLongSong fade: 0 5 3 1)
				(gLongSong3 fade: 100 3 5 0)
			)
		)
		(cond
			(script)
			((not (< 5 (gEgo x:) 315))
				(HandsOff)
				(self setScript: sExit)
			)
			((== temp0 2)
				(HandsOff)
				(self setScript: toRestLeft)
			)
			((== temp0 4)
				(HandsOff)
				(self setScript: toRestRight)
			)
			((== temp0 8)
				(HandsOff)
				(self setScript: toApoth)
			)
			((== temp0 16)
				(HandsOff)
				(self setScript: toKreesha)
			)
			((== temp0 32)
				(if (not (& (gEgo signal:) $0010))
					(gEgo signal: (| (gEgo signal:) $0010) priority: 9)
				)
			)
			((& (gEgo signal:) $0010)
				(gEgo signal: (& (gEgo signal:) $ffef))
			)
		)
	)

	(method (dispose)
		(UnLoad 128 270)
		(UnLoad 128 271)
		(UnLoad 128 272)
		(super dispose:)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (gEgo x:) 5)
					(= register 240)
					(gEgo setMotion: PolyPath -5 (gEgo y:) self)
				else
					(= register 210)
					(gEgo setMotion: PolyPath 325 (gEgo y:) self)
				)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance toRestLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade: 100 5 5 0)
				(gEgo setMotion: PolyPath 22 84 self)
			)
			(1
				(gLongSong3 fade:)
				(gLongSong fade: 110 5 5 0)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance toRestRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade: 100 5 5 0)
				(gEgo setMotion: PolyPath 56 81 self)
			)
			(1
				(gLongSong3 fade:)
				(gLongSong fade: 110 5 5 0)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance toKreesha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade: 100 5 5 0)
				(gEgo setMotion: PolyPath 297 127 self)
			)
			(1
				(gLongSong3 fade:)
				(gLongSong fade: 127 5 5 0)
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance toApoth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade: 127 5 5 0)
				(gEgo setMotion: PolyPath 142 76 self)
			)
			(1
				(gLongSong3 fade:)
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance walkAround of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (and (< local208 local206) (not (Random 0 2)))
					(++ local208)
					(= seconds (Random 10 25))
				else
					(self cue:)
				)
			)
			(1
				(= temp0 (Random 5 12))
				(= temp1 (Random 0 local207))
				(client
					view: [local209 temp1]
					noun: [local214 temp1]
					moveSpeed: temp0
					cycleSpeed: temp0
				)
				(= register (Random 0 9))
				(if (== (client view:) 270)
					(while
						(OneOf [local176 register] @local0 @local76 @local106)
						(= register (Random 0 9))
					)
				else
					(while [local196 register]
						(= register (Random 0 9))
					)
				)
				(= [local196 register] 1)
				(if (Random 0 1)
					(+= register 10)
				)
				(if (< local208 local206)
					(++ local208)
					(client
						x: (WordAt [local176 register] 2)
						y: (WordAt [local176 register] 3)
						setMotion: ArrayPath [local176 register] 2 self
					)
				else
					(client
						x: (WordAt [local176 register] 0)
						y: (WordAt [local176 register] 1)
						setMotion: ArrayPath [local176 register] 0 self
					)
				)
			)
			(2
				(if (> register 9)
					(-= register 10)
				)
				(= [local196 register] 0)
				(client x: (- 0 (Random 200 500)) y: (- 0 (Random 200 500)))
				(= seconds (Random 5 35))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance moveOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath local219 local220 self)
				(= seconds 3)
			)
			(1
				(if (and (!= (gEgo x:) local219) (!= (gEgo y:) local220))
					(self init:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance townPerson1 of Actor
	(properties
		view 270
		signal 24576
		detailLevel 5
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 2)) ; Look, Talk
			(super doVerb: theVerb &rest)
		else
			(Teller doVerb: theVerb &rest)
		)
	)

	(method (checkDetail)
		(if (< (gGame detailLevel:) detailLevel)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance townPerson2 of Actor
	(properties
		view 270
		signal 24576
		detailLevel 4
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 2)) ; Look, Talk
			(super doVerb: theVerb &rest)
		else
			(Teller doVerb: theVerb &rest)
		)
	)

	(method (checkDetail)
		(if (< (gGame detailLevel:) detailLevel)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance townPerson3 of Actor
	(properties
		view 270
		signal 24576
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 2)) ; Look, Talk
			(super doVerb: theVerb &rest)
		else
			(Teller doVerb: theVerb &rest)
		)
	)

	(method (checkDetail)
		(if (< (gGame detailLevel:) detailLevel)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance townPerson4 of Actor
	(properties
		view 270
		signal 24576
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 2)) ; Look, Talk
			(super doVerb: theVerb &rest)
		else
			(Teller doVerb: theVerb &rest)
		)
	)

	(method (checkDetail)
		(if (< (gGame detailLevel:) detailLevel)
			(return 0)
		else
			(return 1)
		)
	)
)

(instance guard1 of View
	(properties
		x 273
		y 43
		view 197
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 1) (== theVerb 2)) ; Look, Talk
			(super doVerb: theVerb &rest)
		else
			(Teller doVerb: theVerb &rest)
		)
	)
)

(instance garden of Feature
	(properties
		x 198
		y 150
		noun 3
		nsTop 136
		nsLeft 156
		nsBottom 165
		nsRight 240
		sightAngle 180
	)
)

(instance trees of Feature
	(properties
		x 191
		y 118
		noun 4
		nsTop 102
		nsLeft 152
		nsBottom 135
		nsRight 230
		sightAngle 180
	)
)

(instance magicsign of Feature
	(properties
		x 285
		y 101
		noun 5
		nsTop 87
		nsLeft 269
		nsBottom 116
		nsRight 302
		sightAngle 180
	)
)

(instance apothsign of Feature
	(properties
		x 128
		y 55
		noun 6
		nsTop 45
		nsLeft 116
		nsBottom 65
		nsRight 140
		sightAngle 180
	)
)

(instance restsign of Feature
	(properties
		x 48
		y 63
		noun 8
		nsTop 59
		nsLeft 21
		nsBottom 68
		nsRight 76
		sightAngle 180
	)
)

(instance restentr of Feature
	(properties
		x 48
		y 78
		noun 9
		nsTop 69
		nsLeft 22
		nsBottom 88
		nsRight 75
		sightAngle 180
	)
)

(instance apothentr of Feature
	(properties
		x 128
		y 73
		noun 7
		nsTop 65
		nsLeft 117
		nsBottom 82
		nsRight 140
		sightAngle 180
	)
)

(instance magicentr of Feature
	(properties
		x 285
		y 125
		noun 2
		nsTop 114
		nsLeft 270
		nsBottom 137
		nsRight 300
		sightAngle 180
	)
)

(instance kingentr of Feature
	(properties
		x 302
		y 24
		noun 10
		nsTop 10
		nsLeft 289
		nsBottom 39
		nsRight 315
		sightAngle 180
	)
)

(instance bazstair of Feature
	(properties
		x 33
		y 145
		noun 11
		nsTop 121
		nsBottom 170
		nsRight 66
		sightAngle 180
	)
)

(instance upplant of Feature
	(properties
		x 152
		y 35
		noun 14
		nsTop 28
		nsLeft 135
		nsBottom 42
		nsRight 170
		sightAngle 180
	)
)

(instance rightplant of Feature
	(properties
		x 305
		y 79
		noun 13
		nsTop 71
		nsLeft 291
		nsBottom 87
		nsRight 319
		sightAngle 180
	)
)

(instance upstair of Feature
	(properties
		x 256
		y 69
		noun 12
		nsTop 52
		nsLeft 234
		nsBottom 87
		nsRight 279
		sightAngle 180
	)
)

