;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use Polygon)

(public
	proc232_0 0
)

(procedure (proc232_0)
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
						init: 319 185 287 185 255 179 253 173 263 169 277 166 319 166
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 72 156 4 156 0 150 3 145 74 145 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 233 98 226 101 112 101 101 92 110 87 157 87 162 91 226 91
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 77 108 82 115 74 118 33 120 0 118 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 96 91 0 91 0 0 61 0 61 54 121 75 135 75 139 80 132 85 108 85
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 176 88 171 81 186 79 262 53 262 0 319 0 319 88
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 82 105 0 105 0 99 82 99 90 103
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
						init: 319 102 118 102 111 98 122 95 201 95 190 87 191 75 319 75
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 72 155 8 155 0 149 13 144 73 144 82 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 78 108 83 114 76 117 33 120 0 116 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 84 105 0 105 0 98 84 98 90 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 159 94 108 94 101 91 116 84 159 84 170 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 102 89 0 89 0 75 129 75 129 78
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 241 189 204 174 189 157 204 143 319 143 319 189
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
						init: 71 119 0 119 0 108 73 108 82 112
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 96 78 96 84 101 79 104 0 104
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 105 89 0 89 0 68 124 68 124 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 281 87 218 87 207 80 216 70 285 70 294 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 221 102 110 102 99 93 115 85 160 85 163 88 228 88 241 94
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 68 156 6 156 0 150 6 142 69 142 75 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 59 189 59 168 88 157 255 157 263 152 319 152
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
						init: 228 103 129 103 120 94 115 94 104 89 112 85 157 85 159 89 228 89 234 96
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 85 189 0 189 0 140 96 140 114 146 119 173 116 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 94 0 75 121 75 121 79 102 89 91 89 76 94
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 278 185 255 178 267 164 319 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 280 88 222 88 211 80 220 73 279 73 291 81
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 76 119 0 119 0 109 79 109 85 113
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 100 83 100 86 103 83 106 0 106
						yourself:
					)
			)
		)
	)
	(DisposeScript 232)
)

