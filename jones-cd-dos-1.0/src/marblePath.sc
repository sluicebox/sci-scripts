;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Motion)

(public
	marblePath 0
)

(local
	[local0 171] = [170 144 150 156 162 168 174 180 186 192 198 204 210 216 222 228 234 240 246 252 258 264 270 276 282 280 275 270 264 259 257 259 264 270 276 282 288 294 299 304 306 306 304 299 294 288 282 276 281 286 291 296 301 305 305 306 306 306 306 307 307 304 299 294 288 282 276 270 264 258 252 246 240 234 228 222 216 210 204 198 193 188 183 178 172 167 162 158 152 148 143 138 133 128 123 118 113 108 103 97 91 85 79 73 67 61 55 49 43 37 31 25 19 14 11 11 14 19 21 23 24 30 36 42 48 54 59 62 63 62 61 58 54 49 43 37 31 25 19 16 14 13 15 19 24 29 34 39 40 38 33 29 35 41 47 53 58 63 68 74 80 86 92 98 104 109 115 120 126 132 138]
	[local171 171] = [170 37 37 38 39 40 40 39 39 39 39 39 40 40 40 40 40 39 38 37 37 38 39 40 39 43 47 52 55 60 66 72 76 79 80 81 83 86 89 94 100 106 112 117 119 120 121 121 126 128 130 133 137 142 148 152 158 164 170 176 182 187 189 189 189 188 187 187 188 188 188 190 191 190 189 188 188 189 189 189 186 184 179 177 175 173 169 169 169 169 170 173 176 180 183 185 187 188 188 188 188 188 187 186 185 185 185 186 187 187 187 187 187 183 178 173 167 162 157 153 149 150 150 150 150 149 146 141 135 129 123 118 114 111 110 109 108 107 105 100 94 88 83 78 74 70 66 63 59 54 50 45 45 45 44 44 42 40 37 37 37 38 38 39 39 39 39 39 38 38 37]
)

(class MarblePath of MoveTo
	(properties
		index 1
		theDirection 0
		finalDest 0
		lastPlace 0
		destIndex 0
		firstMove 1
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= caller param4)
		(= finalDest param3)
		(= lastPlace param2)
		(= b-moveCnt (- (client moveSpeed:) 1))
		(= destIndex ((gPlaces at: finalDest) index:))
		(= x (client x:))
		(= y (client y:))
		(= firstMove 1)
		(self setDirection: next:)
		(gTheWalker setCycle: Fwd)
	)

	(method (doit)
		(if (client moveSpeed:)
			(++ b-moveCnt)
			(if (== b-moveCnt (client moveSpeed:))
				(= b-moveCnt 0)
				(self next:)
				(if (== index destIndex)
					(gTheWalker setCycle: 0 stopUpd:)
					(self moveDone:)
				)
			)
		)
	)

	(method (next)
		(cond
			(firstMove
				(= firstMove 0)
			)
			((== theDirection 1)
				(++ index)
			)
			(else
				(-- index)
			)
		)
		(self at:)
		(client heading: (GetAngle (client x:) (client y:) x y))
		(client posn: x y)
		(if (client looper:)
			((client looper:) doit: client (client heading:))
		)
	)

	(method (at)
		(if (not index)
			(= index [local0 0])
		)
		(if (== index (+ [local0 0] 1))
			(= index 1)
		)
		(= x [local0 index])
		(= y [local171 index])
	)

	(method (setDirection &tmp temp0 temp1 temp2 temp3)
		(for ((= temp1 0)) (<= temp1 [local0 0]) ((++ temp1))
			(if (and (== x [local0 temp1]) (== y [local171 temp1]))
				(= temp2 temp1)
				(break)
			)
		)
		(= temp3 ((gPlaces at: finalDest) index:))
		(if (> temp2 temp3)
			(= theDirection
				(if (>= (= temp0 (- temp2 temp3)) (/ [local0 0] 2)) 1 else 0)
			)
		else
			(= theDirection
				(if (>= (= temp0 (- temp3 temp2)) (/ [local0 0] 2)) 0 else 1)
			)
		)
		(return temp0)
	)
)

(instance marblePath of MarblePath
	(properties)
)

