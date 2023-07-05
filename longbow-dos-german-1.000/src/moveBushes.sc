;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use n013)
(use n222)
(use n232)
(use n242)
(use Interface)
(use sweepRgn)
(use verseScript)
(use Language)
(use Motion)
(use Actor)
(use System)

(public
	proc225_0 0
	proc225_1 1
	proc225_2 2
	moveBushes 3
	liveBush 4
	treeClue 5
	dummyHint 6
	makeClue 7
	dumpClue 8
	dummyBush 9
)

(local
	[local0 8] = [{north} {south} {east} {west} {northeast} {northwest} {southeast} {southwest}]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 4]
	[local20 96] = [34 121 260 227 45 164 163 285 49 34 199 267 34 124 201 214 48 88 185 198 41 84 163 288 35 120 254 219 49 174 147 284 58 42 164 295 76 180 259 221 38 177 142 280 40 87 164 272 23 114 221 297 47 170 256 289 52 143 102 189 53 183 215 280 42 167 167 293 27 86 136 238 53 178 291 -1 10 176 275 -1 32 264 161 -1 84 189 288 217 54 164 249 295 31 58 143 211]
	[local116 96] = [116 118 138 185 117 102 183 164 106 160 151 102 121 121 90 182 156 89 103 185 161 108 184 140 119 119 141 188 115 102 181 165 107 160 189 140 123 92 141 188 119 104 189 182 163 107 189 100 123 121 188 143 118 105 92 181 106 84 102 189 119 89 185 138 155 102 178 180 159 107 184 150 120 89 144 -1 116 102 134 -1 107 103 189 -1 127 95 147 187 121 108 93 186 164 113 89 159]
	[local212 4] = [0 1 0 1]
	[local216 24] = [174 314 27 0 0 161 305 307 173 287 65 -15 0 156 305 316 151 300 10 0 0 178 305 321]
	[local240 24] = [85 60 73 118 223 235 221 130 77 63 83 145 223 221 221 158 81 76 99 152 223 229 221 142]
	[local264 8]
	[local272 2] = [272 43]
	[local274 4] = [159 272 170 300]
	[local278 6] = [294 294 272 166 43 294]
	[local284 6] = [23 23 272 166 43 23]
	[local290 9] = [294 294 272 159 55 30 100 200 300]
	[local299 9] = [23 23 55 159 272 30 100 200 300]
	[local308 10] = [272 55 159 272 166 43 30 100 200 300]
	[local318 3] = [189 99 235]
	[local321 3] = [189 91 235]
	[local324 6] = [189 99 86 86 86 230]
	[local330 6] = [189 91 86 86 86 230]
	[local336 9] = [99 189 189 189 189 230 235 230 220]
	[local345 9] = [189 91 181 189 189 235 230 220 230]
	[local354 10] = [189 189 189 86 86 86 230 235 230 220]
	[local364 4] = [189 189 230 230]
	local368
	[local369 2]
)

(procedure (proc225_0 &tmp temp0)
	(switch (gCurRoom picture:)
		(220
			(= local14 0)
		)
		(230
			(= local14 4)
		)
		(240
			(= local14 8)
		)
	)
	(cond
		((== gForestRoomNum 34)
			(= local15 0)
		)
		((== gForestRoomNum 66)
			(= local15 12)
		)
		((== gForestRoomNum 114)
			(= local15 24)
		)
		((or (== gForestRoomNum 53) (== gForestRoomNum 120))
			(= local15 36)
		)
		((or (== gForestRoomNum 132) (== gForestRoomNum 155))
			(= local15 48)
		)
		((or (== gForestRoomNum 22) (== gForestRoomNum 122))
			(= local15 60)
		)
		((or (== gForestRoomNum 88) (== gForestRoomNum 49))
			(= local15 72)
		)
		((== gForestRoomNum 20)
			(= local15 84)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		((= [local16 temp0] (aTree new:))
			view:
				(cond
					((or (== gForestRoomNum 132) (== gForestRoomNum 155)) 234)
					((== gForestRoomNum 34) 230)
					((or (== gForestRoomNum 53) (== gForestRoomNum 120)) 233)
					((== gForestRoomNum 66) 231)
					((== gForestRoomNum 20) 237)
					((== gForestRoomNum 114) 232)
					((or (== gForestRoomNum 22) (== gForestRoomNum 122)) 235)
					((or (== gForestRoomNum 88) (== gForestRoomNum 49)) 236)
				)
			loop: [local212 temp0]
			x: [local20 (+ temp0 local15 local14)]
			y: [local116 (+ temp0 local15 local14)]
		)
	)
	(AddToAddToPics [local16 0] [local16 1] [local16 2] [local16 3])
)

(procedure (proc225_1)
	(cond
		((or (== gForestRoomNum 18) (== gForestRoomNum 33) (== gForestRoomNum 35))
			(= local9 230)
		)
		((or (== gForestRoomNum 51) (== gForestRoomNum 65) (== gForestRoomNum 82))
			(= local9 231)
		)
		((or (== gForestRoomNum 98) (== gForestRoomNum 115) (== gForestRoomNum 130))
			(= local9 232)
		)
		(
			(or
				(== gForestRoomNum 52)
				(== gForestRoomNum 54)
				(== gForestRoomNum 69)
				(== gForestRoomNum 119)
				(== gForestRoomNum 121)
				(== gForestRoomNum 135)
				(== gForestRoomNum 137)
			)
			(= local9 233)
		)
		(
			(or
				(== gForestRoomNum 116)
				(== gForestRoomNum 117)
				(== gForestRoomNum 131)
				(== gForestRoomNum 133)
				(== gForestRoomNum 154)
			)
			(= local9 234)
		)
		(
			(or
				(== gForestRoomNum 23)
				(== gForestRoomNum 37)
				(== gForestRoomNum 38)
				(== gForestRoomNum 106)
				(== gForestRoomNum 138)
			)
			(= local9 235)
		)
		(
			(or
				(== gForestRoomNum 50)
				(== gForestRoomNum 67)
				(== gForestRoomNum 68)
				(== gForestRoomNum 72)
				(== gForestRoomNum 83)
				(== gForestRoomNum 85)
				(== gForestRoomNum 86)
				(== gForestRoomNum 89)
				(== gForestRoomNum 99)
				(== gForestRoomNum 100)
				(== gForestRoomNum 101)
				(== gForestRoomNum 104)
			)
			(= local9 236)
		)
		((or (== gForestRoomNum 19) (== gForestRoomNum 21) (== gForestRoomNum 36))
			(= local9 237)
		)
		(
			(or
				(== gForestRoomNum 136)
				(== gForestRoomNum 151)
				(== gForestRoomNum 153)
				(== gForestRoomNum 167)
			)
			(= local9 239)
		)
	)
	(switch (gCurRoom curPic:)
		(220
			(cond
				(
					(or
						(== gForestRoomNum 36)
						(== gForestRoomNum 38)
						(== gForestRoomNum 69)
						(== gForestRoomNum 82)
						(== gForestRoomNum 100)
						(== gForestRoomNum 104)
						(== gForestRoomNum 130)
						(== gForestRoomNum 138)
					)
					(= local11 0)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 37)
						(== gForestRoomNum 99)
						(== gForestRoomNum 135)
						(== gForestRoomNum 167)
					)
					(= local11 1)
					(= local10 -1)
				)
				((or (== gForestRoomNum 101) (== gForestRoomNum 137))
					(= local11 2)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 21)
						(== gForestRoomNum 23)
						(== gForestRoomNum 35)
						(== gForestRoomNum 50)
						(== gForestRoomNum 54)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 115)
						(== gForestRoomNum 121)
						(== gForestRoomNum 133)
						(== gForestRoomNum 153)
					)
					(= local11 3)
					(= local10 -1)
				)
				((or (== gForestRoomNum 51) (== gForestRoomNum 117))
					(= local11 4)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 18)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 98)
						(== gForestRoomNum 106)
						(== gForestRoomNum 116)
						(== gForestRoomNum 136)
					)
					(= local11 5)
					(= local10 15)
				)
				((== gForestRoomNum 67)
					(= local11 6)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 19)
						(== gForestRoomNum 33)
						(== gForestRoomNum 52)
						(== gForestRoomNum 65)
						(== gForestRoomNum 83)
						(== gForestRoomNum 119)
						(== gForestRoomNum 131)
						(== gForestRoomNum 151)
						(== gForestRoomNum 154)
					)
					(= local11 7)
					(= local10 -1)
				)
			)
		)
		(230
			(cond
				(
					(or
						(== gForestRoomNum 36)
						(== gForestRoomNum 38)
						(== gForestRoomNum 69)
						(== gForestRoomNum 82)
						(== gForestRoomNum 100)
						(== gForestRoomNum 104)
						(== gForestRoomNum 130)
						(== gForestRoomNum 138)
					)
					(= local11 8)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 37)
						(== gForestRoomNum 99)
						(== gForestRoomNum 135)
						(== gForestRoomNum 167)
					)
					(= local11 9)
					(= local10 -1)
				)
				((or (== gForestRoomNum 101) (== gForestRoomNum 137))
					(= local11 10)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 21)
						(== gForestRoomNum 23)
						(== gForestRoomNum 35)
						(== gForestRoomNum 50)
						(== gForestRoomNum 54)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 115)
						(== gForestRoomNum 121)
						(== gForestRoomNum 133)
						(== gForestRoomNum 153)
					)
					(= local11 11)
					(= local10 -1)
				)
				((or (== gForestRoomNum 51) (== gForestRoomNum 117))
					(= local11 12)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 18)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 98)
						(== gForestRoomNum 106)
						(== gForestRoomNum 116)
						(== gForestRoomNum 136)
					)
					(= local11 13)
					(= local10 15)
				)
				((== gForestRoomNum 67)
					(= local11 14)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 19)
						(== gForestRoomNum 33)
						(== gForestRoomNum 52)
						(== gForestRoomNum 65)
						(== gForestRoomNum 83)
						(== gForestRoomNum 119)
						(== gForestRoomNum 131)
						(== gForestRoomNum 151)
						(== gForestRoomNum 154)
					)
					(= local11 15)
					(= local10 -1)
				)
			)
		)
		(240
			(cond
				(
					(or
						(== gForestRoomNum 36)
						(== gForestRoomNum 38)
						(== gForestRoomNum 69)
						(== gForestRoomNum 82)
						(== gForestRoomNum 100)
						(== gForestRoomNum 104)
						(== gForestRoomNum 130)
						(== gForestRoomNum 138)
					)
					(= local11 16)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 37)
						(== gForestRoomNum 99)
						(== gForestRoomNum 135)
						(== gForestRoomNum 167)
					)
					(= local11 17)
					(= local10 -1)
				)
				((or (== gForestRoomNum 101) (== gForestRoomNum 137))
					(= local11 18)
					(= local10 -1)
				)
				(
					(or
						(== gForestRoomNum 21)
						(== gForestRoomNum 23)
						(== gForestRoomNum 35)
						(== gForestRoomNum 50)
						(== gForestRoomNum 54)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 115)
						(== gForestRoomNum 121)
						(== gForestRoomNum 133)
						(== gForestRoomNum 153)
					)
					(= local11 19)
					(= local10 -1)
				)
				((or (== gForestRoomNum 51) (== gForestRoomNum 117))
					(= local11 20)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 18)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 98)
						(== gForestRoomNum 106)
						(== gForestRoomNum 116)
						(== gForestRoomNum 136)
					)
					(= local11 21)
					(= local10 15)
				)
				((== gForestRoomNum 67)
					(= local11 22)
					(= local10 15)
				)
				(
					(or
						(== gForestRoomNum 19)
						(== gForestRoomNum 33)
						(== gForestRoomNum 52)
						(== gForestRoomNum 65)
						(== gForestRoomNum 83)
						(== gForestRoomNum 119)
						(== gForestRoomNum 131)
						(== gForestRoomNum 151)
						(== gForestRoomNum 154)
					)
					(= local11 23)
					(= local10 -1)
				)
			)
		)
	)
	((= [local16 0] (aTree new:))
		view: local9
		priority: local10
		x: [local216 local11]
		y:
			(if
				(or
					(== gForestRoomNum 18)
					(== gForestRoomNum 68)
					(== gForestRoomNum 72)
					(== gForestRoomNum 98)
					(== gForestRoomNum 106)
					(== gForestRoomNum 116)
					(== gForestRoomNum 136)
				)
				(switch local9
					(232 205)
					(233 229)
					(234 249)
					(236 253)
					(237 209)
					(239 249)
					(else 221)
				)
			else
				[local240 local11]
			)
		signal: 16400
	)
	(AddToAddToPics [local16 0])
)

(procedure (proc225_2 &tmp temp0)
	(cond
		(
			(or
				(== gForestRoomNum 3)
				(== gForestRoomNum 4)
				(== gForestRoomNum 5)
				(== gForestRoomNum 6)
				(== gForestRoomNum 24)
				(== gForestRoomNum 25)
				(== gForestRoomNum 26)
			)
			(= local368 2)
			(= local12 166)
			(= local13 86)
		)
		(
			(or
				(== gForestRoomNum 147)
				(== gForestRoomNum 148)
				(== gForestRoomNum 149)
				(== gForestRoomNum 168)
				(== gForestRoomNum 169)
				(== gForestRoomNum 170)
				(== gForestRoomNum 182)
			)
			(= local368 4)
			(= local12 55)
			(= local13 189)
		)
		(
			(or
				(== gForestRoomNum 43)
				(== gForestRoomNum 91)
				(== gForestRoomNum 107)
				(== gForestRoomNum 123)
				(== gForestRoomNum 139)
			)
			(= local368 3)
			(= local12 294)
			(= local13 145)
		)
		(
			(or
				(== gForestRoomNum 48)
				(== gForestRoomNum 81)
				(== gForestRoomNum 97)
				(== gForestRoomNum 113)
			)
			(= local368 3)
			(= local12 23)
			(= local13 132)
		)
		((or (== gForestRoomNum 7) (== gForestRoomNum 27) (== gForestRoomNum 60))
			(= local368 6)
			(= local12 294)
			(= local13 145)
		)
		((or (== gForestRoomNum 2) (== gForestRoomNum 17) (== gForestRoomNum 32))
			(= local368 6)
			(= local12 23)
			(= local13 132)
		)
		((or (== gForestRoomNum 76) (== gForestRoomNum 171) (== gForestRoomNum 183))
			(= local368 9)
			(= local12 294)
			(= local13 145)
		)
		((or (== gForestRoomNum 64) (== gForestRoomNum 129) (== gForestRoomNum 146))
			(= local368 9)
			(= local12 23)
			(= local13 132)
		)
		((== gForestRoomNum 156)
			(= local368 10)
			(= local12 294)
			(= local13 132)
		)
	)
	(liveBush posn: local12 local13 signal: 16449 init:)
	(for ((= temp0 0)) (< temp0 local368) ((++ temp0))
		((= [local264 temp0] (berryBush new:))
			x:
				(cond
					(
						(or
							(== gForestRoomNum 3)
							(== gForestRoomNum 4)
							(== gForestRoomNum 5)
							(== gForestRoomNum 6)
							(== gForestRoomNum 24)
							(== gForestRoomNum 25)
							(== gForestRoomNum 26)
						)
						(+ [local272 temp0] (Random -3 3))
					)
					(
						(or
							(== gForestRoomNum 147)
							(== gForestRoomNum 148)
							(== gForestRoomNum 149)
							(== gForestRoomNum 168)
							(== gForestRoomNum 169)
							(== gForestRoomNum 170)
							(== gForestRoomNum 182)
						)
						(+ [local274 temp0] (Random -3 3))
					)
					(
						(or
							(== gForestRoomNum 43)
							(== gForestRoomNum 91)
							(== gForestRoomNum 107)
							(== gForestRoomNum 123)
							(== gForestRoomNum 139)
						)
						(Random 292 295)
					)
					(
						(or
							(== gForestRoomNum 48)
							(== gForestRoomNum 81)
							(== gForestRoomNum 97)
							(== gForestRoomNum 113)
						)
						(Random 20 24)
					)
					((or (== gForestRoomNum 7) (== gForestRoomNum 27) (== gForestRoomNum 60)) [local278 temp0])
					((or (== gForestRoomNum 2) (== gForestRoomNum 17) (== gForestRoomNum 32)) [local284 temp0])
					(
						(or
							(== gForestRoomNum 76)
							(== gForestRoomNum 171)
							(== gForestRoomNum 183)
						)
						[local290 temp0]
					)
					(
						(or
							(== gForestRoomNum 64)
							(== gForestRoomNum 129)
							(== gForestRoomNum 146)
						)
						[local299 temp0]
					)
					((== gForestRoomNum 156) [local308 temp0])
				)
			y:
				(cond
					(
						(or
							(== gForestRoomNum 3)
							(== gForestRoomNum 4)
							(== gForestRoomNum 5)
							(== gForestRoomNum 6)
							(== gForestRoomNum 24)
							(== gForestRoomNum 25)
							(== gForestRoomNum 26)
						)
						86
					)
					(
						(or
							(== gForestRoomNum 147)
							(== gForestRoomNum 148)
							(== gForestRoomNum 149)
							(== gForestRoomNum 168)
							(== gForestRoomNum 169)
							(== gForestRoomNum 170)
							(== gForestRoomNum 182)
						)
						[local364 temp0]
					)
					(
						(or
							(== gForestRoomNum 43)
							(== gForestRoomNum 91)
							(== gForestRoomNum 107)
							(== gForestRoomNum 123)
							(== gForestRoomNum 139)
						)
						(+ [local318 temp0] (Random -2 2))
					)
					(
						(or
							(== gForestRoomNum 48)
							(== gForestRoomNum 81)
							(== gForestRoomNum 97)
							(== gForestRoomNum 113)
						)
						(+ [local321 temp0] (Random -2 2))
					)
					((or (== gForestRoomNum 7) (== gForestRoomNum 27) (== gForestRoomNum 60)) [local324 temp0])
					((or (== gForestRoomNum 2) (== gForestRoomNum 17) (== gForestRoomNum 32)) [local330 temp0])
					(
						(or
							(== gForestRoomNum 76)
							(== gForestRoomNum 171)
							(== gForestRoomNum 183)
						)
						[local336 temp0]
					)
					(
						(or
							(== gForestRoomNum 64)
							(== gForestRoomNum 129)
							(== gForestRoomNum 146)
						)
						[local345 temp0]
					)
					((== gForestRoomNum 156) [local354 temp0])
				)
			init:
		)
		(gAddToPics add: [local264 temp0])
	)
	(gAddToPics doit:)
)

(instance berryBush of PicView
	(properties
		view 238
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: treeClue)
					(treeClue dispose:)
				else
					(gEgo setScript: makeClue 0 (self view:))
				)
			)
			(3 ; Do
				(if (IsFlag 129)
					(Say 1225 0 0) ; "The bushes are full of unyielding thorns."
				else
					(Say 1225 1 0) ; "The bushes are full of thorns, and the berries are not quite ripe enough to pick."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance liveBush of Actor
	(properties
		yStep 8
		view 238
		illegalBits 0
		xStep 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: treeClue)
					(treeClue dispose:)
				else
					(self setScript: makeClue 0 (self view:))
				)
			)
			(3 ; Do
				(if (IsFlag 129)
					(Say 1225 0 0) ; "The bushes are full of unyielding thorns."
				else
					(Say 1225 1 0) ; "The bushes are full of thorns, and the berries are not quite ripe enough to pick."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dummyBush of PicView
	(properties)

	(method (init)
		(self
			view: 238
			priority: (liveBush priority:)
			signal: 16
			x: (liveBush x:)
			y: (liveBush y:)
		)
		(super init:)
	)
)

(instance aHint of PicView ; UNUSED
	(properties
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(super doVerb: theVerb &rest)
	)
)

(instance dummyHint of PicView
	(properties)

	(method (init)
		(self
			view: (treeClue view:)
			loop: (treeClue loop:)
			cel: (treeClue cel:)
			x: (treeClue x:)
			y: (treeClue y:)
			priority: (treeClue priority:)
		)
		(super init:)
	)
)

(instance treeClue of View
	(properties
		cel 1
		priority 15
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(gEgo setScript: dumpClue)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event modifiers:) $0000)
				(or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			)
			(self dispose:)
			(event claimed:)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance makeClue of Script
	(properties)

	(method (changeState newState &tmp [temp0 85])
		(switch (= state newState)
			(0
				(cond
					(
						(or
							(== gForestRoomNum 36)
							(== gForestRoomNum 38)
							(== gForestRoomNum 69)
							(== gForestRoomNum 82)
							(== gForestRoomNum 100)
							(== gForestRoomNum 104)
							(== gForestRoomNum 130)
							(== gForestRoomNum 138)
						)
						(= local8 0)
					)
					(
						(or
							(== gForestRoomNum 18)
							(== gForestRoomNum 68)
							(== gForestRoomNum 72)
							(== gForestRoomNum 98)
							(== gForestRoomNum 106)
							(== gForestRoomNum 116)
							(== gForestRoomNum 136)
						)
						(= local8 1)
					)
					(
						(or
							(== gForestRoomNum 19)
							(== gForestRoomNum 33)
							(== gForestRoomNum 52)
							(== gForestRoomNum 65)
							(== gForestRoomNum 83)
							(== gForestRoomNum 119)
							(== gForestRoomNum 131)
							(== gForestRoomNum 151)
							(== gForestRoomNum 154)
						)
						(= local8 2)
					)
					(
						(or
							(== gForestRoomNum 21)
							(== gForestRoomNum 23)
							(== gForestRoomNum 35)
							(== gForestRoomNum 50)
							(== gForestRoomNum 54)
							(== gForestRoomNum 85)
							(== gForestRoomNum 86)
							(== gForestRoomNum 89)
							(== gForestRoomNum 115)
							(== gForestRoomNum 121)
							(== gForestRoomNum 133)
							(== gForestRoomNum 153)
						)
						(= local8 3)
					)
					(
						(or
							(== gForestRoomNum 37)
							(== gForestRoomNum 99)
							(== gForestRoomNum 135)
							(== gForestRoomNum 167)
						)
						(= local8 4)
					)
					((or (== gForestRoomNum 101) (== gForestRoomNum 137))
						(= local8 5)
					)
					((== gForestRoomNum 67)
						(= local8 6)
					)
					((or (== gForestRoomNum 51) (== gForestRoomNum 117))
						(= local8 7)
					)
				)
				(treeClue
					view: register
					x:
						(switch register
							(230 57)
							(231 27)
							(232 31)
							(233 45)
							(234 35)
							(235 39)
							(236 28)
							(237 38)
							(238 41)
							(239 35)
						)
					y:
						(switch register
							(230 57)
							(231 58)
							(232 39)
							(233 57)
							(234 70)
							(235 54)
							(236 56)
							(237 65)
							(238 76)
							(239 71)
						)
					signal: 16400
					init:
				)
				(= ticks 6)
			)
			(1
				(if
					(or
						(== gForestRoomNum 116)
						(== gForestRoomNum 117)
						(== gForestRoomNum 131)
						(== gForestRoomNum 133)
						(== gForestRoomNum 154)
						(== gForestRoomNum 18)
						(== gForestRoomNum 33)
						(== gForestRoomNum 35)
						(== gForestRoomNum 52)
						(== gForestRoomNum 54)
						(== gForestRoomNum 69)
						(== gForestRoomNum 119)
						(== gForestRoomNum 121)
						(== gForestRoomNum 135)
						(== gForestRoomNum 137)
						(== gForestRoomNum 51)
						(== gForestRoomNum 65)
						(== gForestRoomNum 82)
						(== gForestRoomNum 19)
						(== gForestRoomNum 21)
						(== gForestRoomNum 36)
						(== gForestRoomNum 98)
						(== gForestRoomNum 115)
						(== gForestRoomNum 130)
						(== gForestRoomNum 23)
						(== gForestRoomNum 37)
						(== gForestRoomNum 38)
						(== gForestRoomNum 106)
						(== gForestRoomNum 138)
						(== gForestRoomNum 50)
						(== gForestRoomNum 67)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 83)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 99)
						(== gForestRoomNum 100)
						(== gForestRoomNum 101)
						(== gForestRoomNum 104)
						(== gForestRoomNum 136)
						(== gForestRoomNum 151)
						(== gForestRoomNum 153)
						(== gForestRoomNum 167)
					)
					(Print
						(if 1
							(= global216 (Memory memALLOC_CRIT (StrLen [local0 local8])))
							(= global221 (Memory memALLOC_CRIT (StrLen [local0 local8])))
							(StrSplitInTwo global216 global221 [local0 local8])
							(Format @temp0 225 0 global216 global221) ; "'Tis a Druid tree. If I travel %s, I'll reach a grove."
							(Memory memFREE global216)
							(Memory memFREE global221)
						)
						#at
						100
						15
						#width
						180
						#time
						4
					)
				)
				(treeClue signal: (| (treeClue signal:) $0041))
				(self dispose:)
			)
		)
	)
)

(instance dumpClue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(treeClue signal: (& (treeClue signal:) $ffbe))
				(= ticks 6)
			)
			(1
				(treeClue dispose:)
				(self dispose:)
			)
		)
	)
)

(instance aTree of PicView
	(properties
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: treeClue)
					(gEgo setScript: dumpClue)
				else
					(gEgo setScript: makeClue 0 (self view:))
				)
			)
			(3 ; Do
				(Say 1225 2 1) ; "There's nothing I need to take from the Druid tree."
			)
			(5 ; Talk
				(Say 1225 3 1) ; "A Druid tree doesn't answer to mere mortal speech."
			)
			(10 ; Longbow
				(Say 1225 4 1) ; "I'll not shoot at a Druid tree."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dummyLiveBush of PicView
	(properties)

	(method (init)
		(self
			view: (liveBush view:)
			loop: (liveBush loop:)
			cel: (liveBush cel:)
			signal: 16384
			x: (liveBush x:)
			y: (liveBush y:)
		)
		(super init:)
	)
)

(instance moveBushes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(liveBush signal: (& (liveBush signal:) $ffbe))
				(= cycles 12)
			)
			(1
				(liveBush
					setMotion: MoveTo ([local264 0] x:) ([local264 0] y:) self
				)
			)
			(2
				(liveBush signal: (| (liveBush signal:) $0041))
				(switch (gCurRoom picture:)
					(220
						(proc222_0)
					)
					(230
						(proc232_0)
					)
					(240
						(proc242_0)
					)
				)
				(= global124 53)
				(HandsOn)
				(SetIcon 0)
				(dummyLiveBush init:)
				(gAddToPics add: dummyLiveBush)
				(= seconds 5)
			)
			(3
				(gSFX number: 401 loop: -1 play:)
				(gTheIconBar disable: 5)
				(liveBush dispose: delete:)
				(proc750_1)
				(gAddToPics eachElementDo: #dispose release:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 225)
	)
)

