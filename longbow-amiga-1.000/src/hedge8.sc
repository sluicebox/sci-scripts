;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge8 0
)

(local
	[local0 48]
	[local48 47] = [0 0 0 0 0 1 1 0 1 1 1 0 1 1 1 0 0 0 1 1 1 1 1 1 0 0 1 1 1 1 0 0 0 0 1 1 1 0 0 0 1 1 1 1 1 1 1]
	[local95 47] = [5 4 4 4 4 7 7 5 6 6 6 7 7 8 8 8 8 10 8 8 8 8 10 10 10 10 9 9 9 10 10 10 11 11 11 11 11 15 15 15 12 12 12 12 13 13 13]
	[local142 47] = [327 330 302 264 204 165 179 298 249 332 343 247 266 200 221 280 271 305 301 101 122 133 175 186 255 235 44 65 76 19 80 70 103 93 124 145 166 325 260 211 64 82 103 115 9 30 51]
	[local189 47] = [57 24 24 24 24 45 66 57 84 124 141 79 110 98 130 130 130 165 164 34 66 83 147 165 165 165 33 66 83 83 83 83 123 123 157 189 221 215 215 215 153 181 214 233 169 202 234]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 47) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local48 temp0]
			priority: [local95 temp0]
			signal: 16400
			x: [local142 temp0]
			y: [local189 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge8 of HedgeRow
	(properties
		teleX 196
		teleY 34
	)

	(method (init)
		(super init:)
		(if (not (<= 30 gPrevRoomNum 85)) ; hedge1, hedge12
			(gRgnMusic number: 490 loop: -1 play:)
		else
			(gRgnMusic fade: 127 8 30 0)
		)
		(localproc_0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 164 168 126 110 158 110 188 155 276 155 260 132 199 132 113 0 319 0 319 26 156 26 183 65 219 65 202 45 319 45 319 63 238 63 273 108 243 108 226 85 196 85 219 120 279 120 314 168
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 141 283 88 313 88 319 94
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 185 319 189 121 189 80 125 53 125 91 189 63 189 13 111 98 111 147 185
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 110 85 57 1 53 0 85 0 143 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 85 0 30 21 74 50 74 0 0 30 0 89 85
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 189 0 144 29 189 yourself:)
		)
	)
)

