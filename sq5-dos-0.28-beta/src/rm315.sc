;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm315 0
)

(local
	local0
	local1
	[local2 16] = [224 221 221 221 221 221 225 225 234 240 242 243 239 238 239 238]
	[local18 16] = [66 67 67 67 67 67 67 67 73 77 86 90 88 89 91 91]
	local34
	[local35 18] = [253 255 255 254 254 255 251 250 248 244 238 233 233 234 240 241 241 240]
	[local53 18] = [70 71 71 71 71 71 71 71 70 69 73 85 87 87 84 86 87 87]
	[local71 9] = [256 253 252 241 228 218 213 201 192]
	[local80 9] = [38 39 39 40 46 59 56 54 54]
	[local89 9] = [0 1 2 3 4 5 6 4 0]
	local98
	[local99 6] = [159 148 138 126 116 102]
	[local105 6] = [145 147 144 146 144 145]
)

(instance rm315 of Rm
	(properties
		noun 9
		picture 64
	)

	(method (init)
		(self setRegions: 350) ; kiz
		(LoadMany rsVIEW 422 423 411 425 402 401 424 400 426)
		(NormalEgo 0)
		(gEgo actions: (ScriptID 350 1)) ; yoFlo
		(switch gPrevRoomNum
			(305
				(if (IsFlag 21)
					(gCurRoom setScript: sWD40Explodes)
					(gCurRoom style: 14)
				else
					(gCurRoom setScript: sEnterViaTunnelE)
				)
			)
			(else
				(gCurRoom setScript: sEnterViaTunnelB)
			)
		)
		(if (not (IsFlag 21))
			(gEgo setScale: Scaler 38 36 143 69 init:)
		)
		(super init:)
		(theMusic3 number: 403 setLoop: -1 play:)
		(if (not (IsFlag 13))
			(rock init:)
			(gWalkHandler addToFront: rock)
		)
		(bubbles init: setCycle: Fwd)
		(fall1 init: setCycle: Fwd)
		(fall2 init: setCycle: Fwd)
		(if (not (IsFlag 21))
			(wd40 view: 424 loop: 2 cel: 0 x: 50 y: 50 init:)
		)
		(bottomCave init: setOnMeCheck: 1 8192)
		(bottomFalls init: setOnMeCheck: 1 2)
		(cave305 init: setOnMeCheck: 1 -32768)
		(cave310 init: setOnMeCheck: 1 64)
		(pond init: setOnMeCheck: 1 4)
		(topCave init: setOnMeCheck: 1 16384)
		(topFalls init: setOnMeCheck: 1 8)
		(tree init: setOnMeCheck: 1 16)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 47 144 63 143 100 143 128 139 128 138 100 138 100 140 63 140 62 139 47 138
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 225 65 225 63 190 63 189 66 197 66 224 66
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 254 70 285 70 285 68 254 68
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 273 43 265 43 265 45 273 45
					yourself:
				)
		)
	)

	(method (doit)
		(super doit:)
		(Palette palANIMATE 240 248 5 249 255 -8)
		(cond
			(
				(and
					(InRect 34 140 73 150 gEgo)
					(not (wd40 script:))
					(or (not (IsFlag 14)) (IsFlag 15))
				)
				(wd40 setScript: sWD40Appears)
			)
			(
				(and
					(InRect 100 137 129 139 gEgo)
					(not (> 270 (gEgo heading:) 90))
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sExitViaTunnelB)
			)
			(
				(and
					(InRect 275 67 287 71 gEgo)
					(< (gEgo heading:) 180)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sExitViaTunnelE)
			)
			(
				(and
					(InRect 34 130 73 139 gEgo)
					(not (> 270 (gEgo heading:) 90))
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sThruTunnelC 0 1)
			)
			(
				(and
					(InRect 191 63 200 66 gEgo)
					(> (gEgo heading:) 180)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sThruTunnelC 0 0)
			)
			(
				(and
					(InRect 221 62 227 67 gEgo)
					(< 0 (gEgo heading:) 180)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sJumpLeftToRight)
			)
			(
				(and
					(InRect 254 67 258 71 gEgo)
					(> (gEgo heading:) 180)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sJumpRightToLeft)
			)
			(
				(and
					(== (gEgo y:) 45)
					(>= 270 (gEgo heading:) 90)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sClimbDownFromRock)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 16)
					(gMessager say: noun theVerb 2 0) ; "It's not exactly a vacation paradise, but you've spent time on several worse planets than Kiz Urazgubi."
				else
					(gMessager say: noun theVerb 1 0) ; "The beauty of this picturesque scene causes you to forget for a brief instant that you are being stalked by a killer android who would like nothing better than to wear your gizzard as a bow-tie."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSq5Music2 stop:)
		(theMusic3 dispose:)
		(if (gWalkHandler contains: rock)
			(gWalkHandler delete: rock)
		)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance sBounceRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sWD40EntersCave dispose:)
				(= local0 0)
				(SetFlag 13)
				(= local34 0)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 281 41 self)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(gSq5Music2 number: 405 setLoop: 1 play:)
				(gEgo
					view: 422
					setLoop: 6
					cel: 0
					x: 279
					y: 44
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setCycle: End self)
				(gSq5Music2 number: 405 setLoop: 1 play:)
			)
			(6
				(gSq5Music2 stop:)
				(= cycles 1)
			)
			(7
				(NormalEgo 0)
				(gEgo
					x: 281
					y: 41
					setScale: Scaler 38 36 143 69
					setMotion: MoveTo 263 43
				)
				(= cycles 1)
			)
			(8
				(rock
					cel: [local89 local34]
					x: [local71 local34]
					y: [local80 local34]
				)
				(if (== local34 3)
					(ext1
						view: 422
						cel: 0
						x: 269
						y: 57
						setStep: 2 10
						signal: (| (ext1 signal:) $2000)
						ignoreActors:
						init:
						setCycle: 0
						setLoop: -1
						setLoop: 8
						setMotion: MoveTo 287 189
					)
					(ext2
						view: 422
						cel: 1
						x: 270
						y: 48
						setStep: 2 10
						signal: (| (ext2 signal:) $2000)
						ignoreActors:
						init:
						setCycle: 0
						setLoop: -1
						setLoop: 8
						setMotion: MoveTo 272 189
					)
					(ext3
						view: 422
						cel: 2
						x: 268
						y: 47
						setStep: 2 10
						signal: (| (ext3 signal:) $2000)
						ignoreActors:
						init:
						setCycle: 0
						setLoop: -1
						setLoop: 8
						setMotion: MoveTo 270 189
					)
					(ext4
						view: 422
						cel: 3
						x: 271
						y: 50
						setStep: 2 10
						signal: (| (ext4 signal:) $2000)
						ignoreActors:
						init:
						setCycle: 0
						setLoop: -1
						setLoop: 8
						setMotion: MoveTo 277 189
					)
				)
				(if (== local34 5)
					(gSq5Music2 number: 407 setLoop: 1 play:)
				)
				(if (< (++ local34) 9)
					(-- state)
				)
				(= ticks 5)
			)
			(9
				(gSq5Music2 number: 408 setLoop: -1 play:)
				(rock hide:)
				(= ticks 180)
			)
			(10
				(gSq5Music2 number: 409 setLoop: 1 play:)
				(rock loop: 9 cel: 0 x: 45 y: 128 setPri: 13 show:)
				(= ticks 4)
			)
			(11
				(rock loop: 9 cel: 1 x: 45 y: 128)
				(wd40 view: 423 loop: 0 cel: 0 x: 92 y: 142 show: setCycle: End)
				(= ticks 5)
			)
			(12
				(wd40
					loop: 1
					cel: 0
					setCycle: 0
					scaleSignal: 1
					scaleX: 64
					scaleY: 64
					setMotion: JumpTo 240 240
				)
				(rock dispose:)
				(ext1
					view: 422
					cel: 2
					x: 43
					y: 159
					setStep: 5 10
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 26 189
				)
				(ext2
					view: 422
					cel: 3
					x: 93
					y: 145
					setStep: 5 10
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 129 159
				)
				(ext3
					view: 422
					cel: 4
					x: 69
					y: 162
					setStep: 5 10
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 76 189
				)
				(ext4
					view: 422
					cel: 5
					x: 31
					y: 133
					setStep: 5 10
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 0 127
				)
				(ext5
					view: 422
					cel: 6
					x: 39
					y: 118
					setStep: 5 10
					ignoreActors:
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 1 111
				)
				(ext6
					view: 422
					cel: 8
					x: 43
					y: 130
					ignoreActors:
					setStep: 5 10
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 20 144
				)
				(ext7
					view: 422
					cel: 14
					x: 91
					y: 128
					ignoreActors:
					setStep: 5 10
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 117 128
				)
				(ext8
					view: 422
					cel: 15
					x: 62
					y: 155
					setStep: 5 10
					ignoreActors:
					xStep: 10
					yStep: 10
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 9
					setMotion: MoveTo 62 189
				)
				(= ticks 60)
			)
			(13
				(gSq5Music2 number: 410 setLoop: 1 play:)
				(ext1 dispose:)
				(ext2 setMotion: MoveTo 157 189)
				(ext3 dispose:)
				(ext4 dispose:)
				(ext5 dispose:)
				(ext6 setMotion: MoveTo 7 180)
				(ext7 setMotion: MoveTo 150 134 self)
				(ext8 dispose:)
			)
			(14
				(gSq5Music2 fade:)
				(ext2 dispose:)
				(ext6 dispose:)
				(ext7 setMotion: MoveTo 190 145 self)
			)
			(15
				(ext7 setMotion: MoveTo 222 185 self)
			)
			(16
				(ext7 dispose:)
				(SetFlag 14)
				(SetScore 208 100)
				(gSq5Music2 number: 411 setLoop: 1 play: self)
			)
			(17
				(gSq5Music1 fade: 0 5 10 1)
				(gMessager say: 7 0 0 0 self) ; "Looks like you Bould'er over with your ingenuity Rog. She's cooling her jets at the bottom of that pool below. Nice work!"
			)
			(18
				(gSq5Music1 number: 15 loop: -1 play: 0 fade: 127 10 5 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUptoRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 265 69 self)
			)
			(1
				(gEgo
					view: 422
					setLoop: 5
					cel: 0
					x: 268
					y: 48
					setPri: 2
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0 x: 268 y: 38 setCycle: CT 9 1 self)
			)
			(3
				(NormalEgo 0)
				(gEgo x: 269 y: 44 setScale: Scaler 38 36 143 69)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDownFromRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 271 43 self)
			)
			(1
				(gEgo
					view: 422
					setLoop: 5
					cel: 9
					x: 268
					y: 38
					setPri: 2
					setScale: 0
					setCycle: Beg self
				)
			)
			(2
				(gEgo cel: 10 x: 268 y: 48 setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(gEgo x: 265 y: 69 setPri: -1 setScale: Scaler 38 36 143 69)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterViaTunnelE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 287
					y: 69
					init:
					setPri: -1
					setMotion: MoveTo 270 69 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterViaTunnelB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 107 y: 135 init: setMotion: MoveTo 107 140 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 411
					loop: 5
					cel: 0
					x: 273
					y: 66
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 305)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 107 135 self)
			)
			(1
				(gCurRoom newRoom: 310)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThruTunnelC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: MoveTo 80 135 self)
				else
					(gEgo setMotion: MoveTo 185 66 self)
					(if (== local0 5)
						(gCurRoom setScript: sRogDiesInTunnel)
					)
				)
			)
			(1
				(cond
					((not register)
						(= seconds 5)
					)
					((not (wd40 script:))
						(= seconds 5)
					)
				)
			)
			(2
				(if register
					(gEgo x: 185 y: 66 setMotion: MoveTo 208 65 self)
				else
					(gEgo x: 80 y: 135 setMotion: MoveTo 61 141 self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJumpLeftToRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local34 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 422
					loop: 0
					cel: local34
					setScale: 0
					setCycle: 0
					x: [local2 local34]
					y: [local18 local34]
				)
				(if (== local34 12)
					(gSq5Music2 number: 5041 setLoop: 1 play:)
				)
				(if (< (++ local34) 16)
					(-- state)
				)
				(= ticks 6)
			)
			(2
				(gEgo
					view: 422
					loop: 2
					cel: 0
					x: 258
					y: 72
					setCycle: End self
				)
			)
			(3
				(NormalEgo 0)
				(gEgo x: 259 y: 70 setScale: Scaler 38 36 143 69)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJumpRightToLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local34 0)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 422
					loop: 1
					setScale: 0
					x: [local35 local34]
					y: [local53 local34]
					setCycle: 0
				)
				(cond
					((< local34 10)
						(gEgo cel: local34)
					)
					((> local34 11)
						(gEgo cel: (- local34 2))
					)
					(else
						(gEgo cel: 9)
					)
				)
				(if (== local34 12)
					(gSq5Music2 number: 5041 setLoop: 1 play:)
				)
				(if (< (++ local34) 17)
					(-- state)
				)
				(= ticks 6)
			)
			(2
				(gEgo view: 422 loop: 3 cel: 0 x: 222 y: 70 setCycle: 0)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(NormalEgo 0)
				(gEgo loop: 1 y: 65 setScale: Scaler 38 36 143 69)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWD40Appears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(if (IsFlag 15)
					(+= state 3)
				)
				(= cycles 1)
			)
			(1
				(gSq5Music2 number: 401 setLoop: -1 play: 0 fade: 127 10 10 0)
				(ext1
					view: 420
					loop: 0
					cel: 0
					x: 132
					y: 12
					init:
					setCycle: Osc 1 self
				)
				(ext2
					view: 420
					loop: 1
					cel: 0
					x: 139
					y: 28
					init:
					setCycle: Osc 1
				)
			)
			(2
				(ext1
					view: 420
					loop: 2
					cel: 0
					x: 226
					y: 136
					setCycle: Osc 1 self
				)
				(ext2 view: 420 loop: 3 cel: 0 x: 243 y: 145 setCycle: Osc 1)
			)
			(3
				(ext1
					view: 420
					loop: 4
					cel: 0
					x: 199
					y: 186
					setCycle: Osc 1 self
				)
			)
			(4
				(ext1 dispose:)
				(ext2 dispose:)
				(= local0 4)
				(gSq5Music1 number: 35 loop: -1 play:)
				(if (IsFlag 15)
					(wd40
						view: 425
						setLoop: -1
						setLoop: 0
						cel: 0
						x: 263
						y: 190
						ignoreActors:
						show:
						setMotion: MoveTo 263 170 self
					)
				else
					(= local0 2)
					(wd40
						view: 425
						loop: 2
						cel: 0
						x: 263
						y: 170
						ignoreActors:
						show:
						setCycle: End self
					)
				)
			)
			(5
				(jetpack init:)
				(wd40
					cel: 0
					xStep: 10
					yStep: 12
					setCycle: 0
					setLoop: -1
					setLoop: 0
					setMotion: MoveTo 242 89 self
				)
			)
			(6
				(if (InRect 76 131 84 139 gEgo)
					(if (IsFlag 15)
						(= next sWD40BackDown)
					else
						(= next sWD40EntersCave)
					)
				else
					(wd40 stopUpd:)
					(= next sWD40Fires)
				)
				(self dispose:)
			)
		)
	)
)

(instance sWD40BackDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wd40 setMotion: MoveTo 263 190 self)
			)
			(1
				(jetpack dispose:)
				(wd40 hide:)
				(sThruTunnelC cue:)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sWD40Fires of Script
	(properties)

	(method (doit)
		(if (InRect 76 131 84 139 gEgo)
			(if (IsFlag 15)
				(= next sWD40BackDown)
			else
				(= next sWD40EntersCave)
			)
			(self dispose:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< (gEgo y:) 139) (not (gCurRoom script:)))
					(wd40 hide:)
					(self dispose:)
				else
					(SetFlag 66)
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 236
						y: 89
						setStep: 15 5
						moveSpeed: 0
						init:
						setScript: sFireBall self 0
					)
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(if (and (< (gEgo y:) 139) (not (gCurRoom script:)))
					(wd40 hide:)
					(self dispose:)
				else
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 236
						y: 89
						setScript: sFireBall self 0
					)
				)
			)
			(3
				(= seconds 4)
			)
			(4
				(if (and (< (gEgo y:) 139) (not (gCurRoom script:)))
					(wd40 hide:)
					(self dispose:)
				else
					(gEgo setMotion: 0)
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 236
						y: 89
						setScript: sFireBall self 1
					)
				)
			)
			(5
				(fireBall dispose:)
				(cond
					((<= 45 (gEgo heading:) 135)
						(gEgo loop: 3)
					)
					((<= 136 (gEgo heading:) 225)
						(gEgo loop: 0)
					)
					((<= 226 (gEgo heading:) 315)
						(gEgo loop: 2)
					)
					(else
						(gEgo loop: 1)
					)
				)
				(gEgo
					view: 401
					cel: 0
					setScale: Scaler 38 36 143 69
					setCycle: End self
				)
			)
			(6
				(EgoDead 17) ; "Nice reflexes. We'll mail your remains home in an envelope."
				(self dispose:)
			)
		)
	)
)

(instance sFireBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(fireBall
						setMotion:
							MoveTo
							(+ (gEgo x:) 7)
							(- (gEgo y:) 10)
							self
					)
				else
					(fireBall
						setMotion:
							MoveTo
							(+ (gEgo x:) 2)
							(- (gEgo y:) 18)
							self
					)
				)
			)
			(1
				(if (not register)
					(gSq5Music2 number: 4021 setLoop: 1 play:)
					(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sWD40EntersCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ext10
					view: (wd40 view:)
					loop: (wd40 loop:)
					cel: (wd40 cel:)
					x: (wd40 x:)
					y: (wd40 y:)
					init:
					addToPic:
				)
				(wd40 hide:)
				(ext9
					view: (jetpack view:)
					loop: (jetpack loop:)
					cel: (jetpack cel:)
					x: (jetpack x:)
					y: (jetpack y:)
					init:
					addToPic:
				)
				(jetpack dispose:)
				(= cycles 2)
			)
			(1
				(ext9 dispose:)
				(ext10 dispose:)
				(gAddToPics delete: ext9 ext10)
				(DrawPic 64 9)
				(= cycles 2)
			)
			(2
				(= ticks 240)
			)
			(3
				(= local98 0)
				(wd40
					view: 424
					setLoop: 0
					cel: 0
					setPri: 15
					x: [local99 0]
					y: [local105 0]
					ignoreActors:
					setCycle: End
					setMotion: 0
					show:
				)
				(= ticks 30)
			)
			(4
				(wd40
					x: [local99 local98]
					y: [local105 local98]
					cel: 0
					setCycle: End self
				)
				(if (< (++ local98) 6)
					(-- state)
				)
			)
			(5
				(gSq5Music2 number: 222 setLoop: 1 play:)
				(wd40
					view: 424
					loop: 1
					cel: 0
					x: 102
					y: 147
					ignoreActors:
					setCycle: End self
				)
			)
			(6
				(gSq5Music2 fade:)
				(wd40 hide:)
				(= local0 5)
				(sThruTunnelC cue:)
				(= cycles 1)
			)
			(7
				(= seconds 20)
			)
			(8
				(if (and (InRect 200 50 225 80 gEgo) (== local0 5))
					(gCurRoom setScript: sRogDies)
					(self dispose:)
				)
				(= local0 0)
				(= cycles 1)
			)
			(9
				(wd40
					view: 424
					loop: 3
					cel: 0
					x: 89
					y: 144
					show:
					ignoreActors:
					setCycle: End self
				)
			)
			(10
				(= local98 5)
				(wd40
					view: 424
					setLoop: 0
					cel: 0
					x: [local99 5]
					y: [local105 5]
					setCycle: End self
				)
			)
			(11
				(wd40
					x: [local99 local98]
					y: [local105 local98]
					setCycle: End self
				)
				(if (>= (-- local98) 0)
					(-- state)
				)
			)
			(12
				(wd40 hide:)
				(self dispose:)
			)
		)
	)
)

(instance sRogDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 200
					y: 50
					init:
					setMotion: MoveTo (+ (gEgo x:) 2) (- (gEgo y:) 8) self
				)
			)
			(1
				(fireBall dispose:)
				(cond
					((<= 45 (gEgo heading:) 135)
						(gEgo loop: 3)
					)
					((<= 136 (gEgo heading:) 225)
						(gEgo loop: 0)
					)
					((<= 226 (gEgo heading:) 315)
						(gEgo loop: 2)
					)
					(else
						(gEgo loop: 1)
					)
				)
				(gEgo
					view: 401
					cel: 0
					setScale: Scaler 38 36 143 69
					setCycle: End self
				)
			)
			(2
				(EgoDead 17) ; "Nice reflexes. We'll mail your remains home in an envelope."
				(self dispose:)
			)
		)
	)
)

(instance sRogDiesInTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(ext1
					view: 422
					loop: 11
					cel: 0
					x: 195
					y: 47
					init:
					setCycle: End
				)
				(ext2
					view: 422
					loop: 12
					cel: 0
					x: 207
					y: 63
					init:
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(ext1 hide:)
				(ext2 hide:)
				(gEgo
					view: 401
					cel: 0
					setScale: Scaler 38 36 143 69
					setLoop: -1
					setLoop: 1
					setCycle: End self
				)
			)
			(2
				(EgoDead 18) ; "Entering a cavern that's known to contain a killer android can be hazardous to one's health."
				(self dispose:)
			)
		)
	)
)

(instance sWD40Explodes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wd40
					view: 400
					cel: 0
					x: 250
					y: 180
					setStep: 5 15
					scaleX: 106
					scaleY: 106
					scaleSignal: 1
					setCycle: 0
					setLoop: -1
					setLoop: 7
					moveSpeed: 0
					init:
					setMotion: MoveTo 148 107 self
				)
			)
			(1
				(gSq5Music2 number: 222 setLoop: -1 play:)
				(wd40 view: 426 loop: 0 cel: 0 x: 142 y: 80 setCycle: End self)
			)
			(2
				(gSq5Music2 number: 203 setLoop: 1 play:)
				(wd40 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gSq5Music2 fade:)
				(wd40 dispose:)
				(ext1
					view: 426
					loop: 2
					cel: 0
					x: 142
					y: 80
					setStep: 3 8
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 100 200
				)
				(ext2
					view: 426
					loop: 2
					cel: 1
					x: 138
					y: 83
					setStep: 3 7
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 111 200
				)
				(ext3
					view: 426
					loop: 2
					cel: 2
					x: 129
					y: 78
					setStep: 3 9
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 120 200
				)
				(ext4
					view: 426
					loop: 2
					cel: 3
					x: 142
					y: 80
					setStep: 3 7
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 130 200
				)
				(ext5
					view: 426
					loop: 2
					cel: 4
					x: 142
					y: 80
					setStep: 3 8
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 150 200
				)
				(ext6
					view: 426
					loop: 2
					cel: 5
					x: 142
					y: 87
					setStep: 3 9
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 160 200
				)
				(ext7
					view: 426
					loop: 2
					cel: 6
					x: 148
					y: 80
					setStep: 3 6
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 170 200
				)
				(ext8
					view: 426
					loop: 2
					cel: 7
					x: 122
					y: 76
					setStep: 3 7
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 180 200
				)
				(ext9
					view: 426
					loop: 2
					cel: 8
					x: 142
					y: 80
					setStep: 3 8
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setMotion: MoveTo 190 200
				)
				(ext10
					view: 426
					loop: 3
					cel: 0
					x: 112
					y: 70
					setStep: 3 7
					moveSpeed: 0
					init:
					setPri: 15
					ignoreActors:
					setCycle: Fwd
					setMotion: MoveTo 200 200 self
				)
			)
			(4
				(gSq5Music2 fade:)
				(SetFlag 16)
				(ClearFlag 15)
				(gGame handsOn:)
				(gCurRoom newRoom: 305)
				(self dispose:)
			)
		)
	)
)

(instance wd40 of Actor
	(properties
		x 50
		y 50
		noun 4
		modNum 301
		view 424
		priority 14
		signal 16400
	)
)

(instance ext1 of Actor
	(properties
		signal 16384
	)
)

(instance ext2 of Actor
	(properties
		signal 16384
	)
)

(instance ext3 of Actor
	(properties
		signal 16384
	)
)

(instance ext4 of Actor
	(properties
		signal 16384
	)
)

(instance ext5 of Actor
	(properties
		signal 16384
	)
)

(instance ext6 of Actor
	(properties
		signal 16384
	)
)

(instance ext7 of Actor
	(properties
		signal 16384
	)
)

(instance ext8 of Actor
	(properties
		signal 16384
	)
)

(instance ext9 of Actor
	(properties
		signal 16384
	)
)

(instance ext10 of Actor
	(properties
		signal 16384
	)
)

(instance rock of Actor
	(properties
		x 256
		y 38
		noun 3
		view 422
		loop 7
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(< (gEgo distanceTo: self) 40)
						(> (gEgo y:) 55)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sClimbUptoRock)
				)
			)
			(3 ; Walk
				(if
					(and
						(< (gEgo distanceTo: self) 40)
						(> (gEgo y:) 55)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sClimbUptoRock)
				)
			)
			(21 ; Kiz_Branch
				(if (< (gEgo distanceTo: self) 26)
					(if (== local0 5)
						(gCurRoom setScript: sBounceRock)
					else
						(gMessager say: 10 0 0 0) ; "Timing is everything here--better wait."
					)
				else
					(gMessager say: 6 0 0 0) ; "Get closer."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireBall of Actor
	(properties
		x 236
		y 89
		view 402
		priority 15
		signal 16400
	)
)

(instance bubbles of Prop
	(properties
		x 100
		y 145
		view 421
	)
)

(instance fall1 of Prop
	(properties
		x 84
		y 68
		view 421
		loop 1
	)
)

(instance fall2 of Prop
	(properties
		x 149
		y 153
		view 421
		loop 2
		signal 4096
	)
)

(instance jetpack of Prop
	(properties
		view 425
		loop 4
		priority 15
		signal 16400
		cycleSpeed 3
	)

	(method (init)
		(self x: 272 y: 226)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(self x: (+ (wd40 x:) 9) y: (+ (wd40 y:) 56))
		(super doit:)
	)
)

(instance bottomCave of Feature
	(properties
		x 62
		y 133
		noun 1
		onMeCheck 8192
	)
)

(instance bottomFalls of Feature
	(properties
		x 156
		y 176
		noun 2
		onMeCheck 2
	)
)

(instance cave305 of Feature
	(properties
		x 275
		y 60
		noun 4
		onMeCheck -32768
	)
)

(instance cave310 of Feature
	(properties
		x 107
		y 131
		noun 5
		onMeCheck 64
	)
)

(instance pond of Feature
	(properties
		x 122
		y 146
		noun 8
		onMeCheck 4
	)
)

(instance topCave of Feature
	(properties
		x 199
		y 55
		noun 11
		onMeCheck 16384
	)
)

(instance topFalls of Feature
	(properties
		x 94
		y 111
		noun 12
		onMeCheck 8
	)
)

(instance tree of Feature
	(properties
		x 4
		y 116
		noun 13
		onMeCheck 16
	)
)

(instance theMusic3 of Sound
	(properties
		flags 1
	)
)

