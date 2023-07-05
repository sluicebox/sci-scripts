;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use Polygon)

(public
	proc222_0 0
)

(procedure (proc222_0)
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
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 149 228 143 195 135 184 130 189 125 319 125
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 285 189 167 189 200 183 247 179
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 169 113 164 119 120 124 69 126 40 120 23 123 0 123 0 107 87 99 158 107
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 307 121 231 121 216 118 230 114 306 114 314 118
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 104 319 109 281 109 277 107 283 104
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 130 85 120 91 0 91 0 0 70 0 70 57 101 75 122 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 171 91 159 84 167 75 193 75 230 58 229 0 319 0 319 91
						yourself:
					)
			)
		)
		(
			(or
				(== gForestRoomNum 43)
				(== gForestRoomNum 91)
				(== gForestRoomNum 107)
				(== gForestRoomNum 123)
				(== gForestRoomNum 139)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 200 93 115 93 107 81 115 75 319 75 319 110 207 105
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 145 277 145 198 135 193 129 199 125 319 125
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 301 121 222 121 215 117 223 114 301 114 310 116
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 186 189 183 175 190 150 319 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 71 91 0 91 0 75 71 75 80 82
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 164 120 84 128 0 122 0 107 149 107 158 109 165 113
						yourself:
					)
			)
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
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 111 91 108 82 115 75 319 75 319 91
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 85 189 85 153 113 146 319 146
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 296 120 225 120 216 116 223 113 300 113 311 116
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 111 288 111 280 109 291 107 319 107
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 168 116 141 125 64 127 0 125 0 105 150 105 164 110
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 75 71 75 77 83 71 89 0 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 139 241 136 197 134 194 128 198 126 319 127
						yourself:
					)
			)
		)
		(
			(or
				(== gForestRoomNum 48)
				(== gForestRoomNum 81)
				(== gForestRoomNum 97)
				(== gForestRoomNum 113)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 147 224 138 203 133 192 129 203 125 319 125
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 288 189 165 189 200 183 247 179
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 170 115 167 121 81 125 0 118 0 102 120 102 164 109
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 297 121 231 121 221 118 229 114 296 114 309 117
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 104 319 109 281 109 277 107
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 124 92 116 82 124 73 258 73 265 84 258 92
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 109 189 0 189 0 140 108 141 120 175
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 102 95 0 95 0 53 104 53 115 75
						yourself:
					)
			)
		)
	)
	(DisposeScript 222)
)

