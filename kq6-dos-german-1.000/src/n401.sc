;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use Polygon)

(public
	proc401_0 0
	proc401_1 1
	proc401_2 2
	proc401_3 3
	proc401_4 4
)

(procedure (proc401_0)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 148 148 101 149 85 144 41 184 266 183 248 157 231 142 215 148 172 148 169 49 319 49 319 189 0 189 0 49 146 49
				yourself:
			)
	)
	(DisposeScript 401)
)

(procedure (proc401_1)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 189 0 50 319 50 319 189 190 189 190 185 266 185 231 143 86 143 39 185 130 185 130 189
				yourself:
			)
	)
	(DisposeScript 401)
)

(procedure (proc401_2)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 50 319 50 319 189 0 189 0 162 78 162 59 176 27 185 276 185 243 154 227 143 96 143 84 155 0 155
				yourself:
			)
	)
	(DisposeScript 401)
)

(procedure (proc401_3)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 319 189 0 189 0 50 319 50 319 154 234 154 223 143 84 143 41 185 275 185 258 175 243 162 319 162
				yourself:
			)
	)
	(DisposeScript 401)
)

(procedure (proc401_4)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 169 148 170 0 319 0 319 154 228 154 220 148
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 148 148 93 148 86 155 0 155 0 0 148 0
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 79 162 57 176 25 185 130 185 130 189 0 189 0 162
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 319 162 319 189 190 189 190 185 276 185 256 174 241 162
				yourself:
			)
	)
	(DisposeScript 401)
)

