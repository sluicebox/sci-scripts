;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 242)
(include sci.sh)
(use Main)
(use Polygon)

(public
	proc242_0 0
)

(procedure (proc242_0)
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
						init: 271 149 261 156 168 156 156 146 171 140 262 140
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 233 189 58 189 114 179 230 185
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 89 162 0 162 0 150 86 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 144 274 139 260 132 273 127 319 127
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 141 87 122 95 0 94 0 0 59 0 59 43 115 75 142 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 108 98 122 102 107 107 0 107 0 98
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 94 295 94 285 101 255 101 244 94 192 94 178 85 186 75 212 75 265 39 265 0 319 0
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
						init: 319 104 206 104 197 89 205 75 319 74
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 233 189 58 189 119 179 218 184
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 162 0 151 93 154 92 162
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 126 103 111 107 0 107 0 98 23 98 107 98
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 68 82 63 88 0 88 0 75 60 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 135 82 135 90 128 95 75 95 72 84 76 75 130 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 240 189 220 182 197 180 189 156 172 156 153 149 172 138 265 138 281 145 319 145 319 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 141 284 141 262 133 263 128 280 126 319 126
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
						init: 159 151 200 139 273 141 283 124 319 120 319 189 62 189 67 183 121 164 148 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 298 101 241 101 227 97 240 90 299 90 308 94
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 123 101 109 107 0 107 0 98 23 98 107 98
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 67 85 56 90 0 90 0 75 57 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 136 85 135 93 128 95 78 95 72 88 77 75 129 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 147 60 147 83 153 88 159 80 163 41 164 38 178 24 189 0 189
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
						init: 319 146 272 139 261 133 269 127 319 127
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 233 189 0 189 0 144 110 144 116 181 230 185
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 116 108 0 108 0 75 117 75 127 93
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 158 143 167 137 246 137 254 144 247 152 166 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 295 102 241 102 233 97 240 89 295 89 305 95
						yourself:
					)
			)
		)
	)
	(DisposeScript 242)
)

