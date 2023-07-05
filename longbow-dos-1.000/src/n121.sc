;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Wat)
(use Polygon)
(use System)

(public
	proc121_0 0
)

(local
	[local0 4]
	[local4 36] = [238 238 235 235 230 230 236 235 233 233 231 234 231 231 233 237 236 236 236 236 236 236 237 231 232 232 233 233 234 234 234 236 238 238 238 234]
	[local40 36] = [0 1 1 0 0 0 1 1 0 1 1 1 0 1 1 1 0 1 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1 0 1 1]
	[local76 36] = [317 307 20 45 104 22 367 284 54 131 299 151 13 69 287 278 40 -20 364 328 0 58 279 300 12 48 291 312 23 46 274 352 0 54 81 275]
	[local112 36] = [184 115 52 106 56 119 97 225 68 56 68 215 120 50 76 203 50 136 94 257 136 56 203 68 131 49 75 96 124 41 171 96 119 71 25 174]
)

(procedure (proc121_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= temp1 (+ (* (- (Wat section:) 1) 4) temp0))
		((= [local0 temp0] ((ScriptID 120 1) new:)) ; tree
			view: [local4 temp1]
			loop: [local40 temp1]
			x: [local76 temp1]
			y: [local112 temp1]
			cel: 0
			priority:
				(cond
					((== temp1 21) 0)
					((OneOf temp1 4 9 29 34) 1)
					((OneOf temp1 18 31) 3)
					((OneOf temp1 6 8) 4)
					((== temp1 17) 6)
					((OneOf temp1 7 11 15 19 22) 15)
					(else -1)
				)
			signal: 20496
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
	(if argc
		(switch (Wat section:)
			(1
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 36 103 36 115 21 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 268 67 268 46 297 28 319 28 319 67
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 99 94 99 101 0 101 0 94
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 70 319 118 214 118 220 84 266 70
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 220 162 319 162 319 180 220 180
							yourself:
						)
				)
			)
			(2
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 80 103 80 117 21 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 64 260 64 257 41 295 24 319 24 319 27
							yourself:
						)
				)
			)
			(3
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 36 103 36 115 21 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 254 67 254 50 297 28 319 28 319 67
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 36 62 76 62 83 66 83 72 36 72
							yourself:
						)
				)
			)
			(4
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 227 189 227 182 319 182 319 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 55 103 55 112 21 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 267 66 267 50 297 28 319 28 319 66
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 251 68 312 68 312 75 251 75
							yourself:
						)
				)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 319 182 319 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 36 103 36 115 21 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 261 67 251 53 297 28 319 28 319 67
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 77 91 77 88 96 0 96
							yourself:
						)
				)
			)
			(6
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 319 182 319 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 140 0 110 73 110 73 133 14 140
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 259 71 259 49 297 28 319 28 319 71
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
				)
			)
			(7
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 138 208 124 319 124 319 159 263 159
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 134 0 108 67 108 67 127
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 275 81 255 71 255 52 297 28 319 28 319 68 303 68 303 75
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 99 285 99 285 87 319 87
							yourself:
						)
				)
			)
			(8
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 124 0 103 84 103 84 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 239 67 239 50 297 28 319 28 319 67
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 31 137 31 158 45 148 54 114 60 81 60 59 53 0 57
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 231 0 197 16 167 21 121 11 96 16 70 12 53 15 22 21 0 18
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 206 165 319 165 319 177 206 177
							yourself:
						)
				)
			)
			(9
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 235 189 235 182 315 182 315 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 100 189 100 186 199 186 199 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 208 175 208 166 319 166 319 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 268 67 268 46 297 28 319 28 319 67
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 -1 227 -1 197 17 150 27 162 49 89 122 42 128 0 129
							yourself:
						)
				)
			)
		)
	)
	(DisposeScript 121)
)

