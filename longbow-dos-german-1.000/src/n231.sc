;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use Polygon)

(public
	proc231_0 0
)

(procedure (proc231_0)
	(cond
		((or (== gForestRoomNum 22) (== gForestRoomNum 122))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 184 242 184 233 173 258 161 319 161
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 128 183 107 170 133 162 207 162 229 173 201 183
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 94 160 0 160 0 144 91 144 105 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 238 101 223 105 113 105 103 100 102 91 131 83 204 83 238 93
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 73 107 78 114 35 118 0 114 0 108 18 102 56 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 286 83 275 87 224 87 217 82 230 79 274 79
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 84 0 52 132 52 130 81 106 87
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 275 74 199 76 183 66 208 61 264 61 293 64
						yourself:
					)
			)
		)
		((== gForestRoomNum 34)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 187 285 185 211 161 221 148 319 148 319 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 98 185 93 175 108 168 221 168 230 171 223 185
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 69 156 7 156 2 150 16 146 68 146 81 152
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 236 101 212 106 114 106 96 99 101 91 122 84 211 84 219 89 232 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 92 102 111 109 88 122 0 122 0 108 18 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 284 83 273 87 221 87 215 82 221 79 274 79
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 109 86 0 83 0 50 128 50 128 78
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 279 77 190 77 181 68 199 60 279 60 291 70
						yourself:
					)
			)
		)
		((or (== gForestRoomNum 88) (== gForestRoomNum 49))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 267 168 319 164 319 187 295 187 258 177
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 70 156 13 156 2 150 16 146 68 146 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 279 96 261 102 184 106 85 102 74 98 89 95 140 96 178 90 243 91
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 120 110 115 114 60 123 56 124 33 121 0 121 0 108 18 102 56 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 270 84 265 88 225 88 215 85 222 82 263 82
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 142 92 117 91 111 89 123 86 143 86 152 88
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 122 80 107 87 0 83 0 61 122 60
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 134 315 139 186 139 166 130 179 122 310 122
						yourself:
					)
			)
		)
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
						init: 319 184 288 183 258 175 263 169 277 166 306 163 319 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 232 189 85 189 123 180 161 175 195 179
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 70 156 4 156 0 150 5 146 68 146 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 78 108 76 116 35 120 0 118 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 103 88 0 88 0 0 319 0 319 88 236 88 227 101 114 101
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 75 104 0 104 0 97 73 97 88 101
						yourself:
					)
			)
		)
		((or (== gForestRoomNum 7) (== gForestRoomNum 27) (== gForestRoomNum 60))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 71 156 9 156 0 150 8 145 71 145 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 197 103 108 103 95 90 0 90 0 0 319 0 319 189 215 189 193 163 200 138 190 127
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 79 108 87 112 81 116 34 119 0 117 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 81 105 0 105 0 98 82 98 94 102
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
						init: 319 189 215 189 193 175 193 140 189 127 201 103 120 103 101 91 119 84 150 84 162 89 196 89 201 85 193 65 319 65
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 71 155 6 155 0 150 8 144 70 144 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 73 107 83 111 73 118 6 118 0 114 0 107
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 104 88 0 88 0 51 131 51 131 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 84 104 0 104 0 96 82 96 86 100
						yourself:
					)
			)
		)
		((or (== gForestRoomNum 76) (== gForestRoomNum 171) (== gForestRoomNum 183))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 0 189 0 146 185 146 198 117 200 102 117 102 107 94 100 94 98 90 119 84 160 84 166 92 203 92 203 80 319 80
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 76 108 83 115 35 118 0 114 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 96 88 0 88 0 56 122 57 122 80
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 75 104 0 104 0 97 74 97 88 101
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
						init: 319 189 0 189 0 142 319 142
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 238 89 247 98 238 101 113 101 107 96 107 90 125 85 214 85 223 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 76 108 85 116 34 121 0 117 0 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 287 82 276 87 224 87 215 82 222 77 274 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 108 87 0 87 0 49 141 49 141 79
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 274 75 194 75 177 68 193 63 275 63 288 69
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 78 105 0 105 0 96 75 96 87 103
						yourself:
					)
			)
		)
		((or (== gForestRoomNum 64) (== gForestRoomNum 129) (== gForestRoomNum 146))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 0 189 0 52 101 52 120 84 115 84 102 89 107 97 117 97 118 102 126 155 319 155
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 232 90 243 93 239 102 122 102 120 95 108 95 105 90 116 86 152 86 162 88 219 88 223 90
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 282 85 273 88 225 88 215 85 222 82 270 82
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
						init: 319 184 288 183 258 175 263 169 277 166 306 163 319 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 48 116 48 116 85 104 85 99 92 111 98 120 98 123 112 94 128 121 147 122 172 111 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 239 95 234 102 123 102 122 96 111 96 102 91 105 87 155 87 166 89 223 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 281 84 272 88 225 88 215 85 222 82 272 82
						yourself:
					)
			)
		)
		(else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 187 294 187 255 178 263 169 277 166 306 163 319 164
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 66 156 11 156 1 150 16 146 68 146 78 150
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 238 89 247 98 238 101 113 101 107 96 107 90 125 85 214 85 223 89
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 81 113 74 118 34 121 0 117 0 108 73 108
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 287 82 276 87 224 87 215 82 222 77 274 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 108 87 0 87 0 49 141 49 141 79
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 274 75 194 75 177 68 193 63 275 63 288 69
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 78 105 0 105 0 99 76 99 87 103
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 93 299 93 294 85 300 64 319 64
						yourself:
					)
			)
		)
	)
	(DisposeScript 231)
)

