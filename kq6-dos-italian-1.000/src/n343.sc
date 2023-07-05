;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 343)
(include sci.sh)
(use Main)
(use n913)
(use Polygon)

(public
	proc343_0 0
)

(procedure (proc343_0)
	(if (IsFlag 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 292 189 288 177 279 176 280 167 296 158 301 124 295 122 285 115 294 115 286 112 275 109 258 111 244 104 235 95 250 85 227 66 227 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 227 103 230 108 219 114 208 119 186 119 165 112 156 108 129 109 118 109 0 26 0 0 221 0 221 67 222 74 227 79 215 83 226 92 222 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 238 189 226 177 233 168 256 168 263 171 271 179 263 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 180 168 202 169 202 173 191 178 181 189 165 189 165 171
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 73 114 46 115 36 113 37 131 29 134 20 132 25 118 10 107 0 107 0 35 103 108 75 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 120 6 121 12 135 31 140 19 151 8 151 10 160 37 163 49 156 80 156 102 159 113 163 138 163 160 171 160 189 0 189
					yourself:
				)
		)
	else
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 226 0 319 0 319 189 292 189 288 177 279 176 280 167 299 154 301 124 295 122 285 115 295 115 286 112 275 109 258 111 240 104 233 95 250 85 226 68
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 228 101 230 108 219 114 208 119 186 119 165 112 156 108 129 109 118 110 74 111 69 115 44 115 37 117 45 132 8 148 16 160 35 163 59 150 134 161 159 171 154 178 154 189 0 189 0 0 222 0 222 69 228 80 220 84 228 92 225 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 238 189 226 177 233 168 256 168 263 171 271 179 263 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 176 169 202 169 202 173 191 178 182 183 162 189 162 177
					yourself:
				)
		)
	)
	(DisposeScript 343)
)

