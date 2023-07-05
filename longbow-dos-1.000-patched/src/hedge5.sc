;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge5 0
)

(local
	[local0 52]
	[local52 51] = [1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 0 0 0 1 1 0 0 1 1 1 1 1 0 0 1 1 0 0 0 0 1 1 1 0 0 0 0 1]
	[local103 51] = [0 0 0 0 0 1 1 1 1 1 2 2 2 2 2 2 3 3 4 4 4 3 4 4 4 5 5 5 6 6 10 10 10 10 5 5 5 6 5 8 8 7 7 9 9 9 11 11 15 15 8]
	[local154 51] = [293 311 329 380 238 260 280 301 322 336 201 222 242 263 284 305 118 139 56 77 84 158 96 157 145 25 44 66 71 57 17 38 59 73 201 180 169 141 222 227 226 144 140 112 132 147 74 22 306 245 198]
	[local205 51] = [16 43 70 70 26 61 92 124 156 174 61 93 124 156 188 220 29 61 24 57 67 91 85 85 85 57 91 124 125 125 131 163 195 217 159 125 125 155 191 193 193 156 156 187 218 241 215 215 221 221 226]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 51) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local52 temp0]
			priority: [local103 temp0]
			signal: 16400
			x: [local154 temp0]
			y: [local205 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge5 of HedgeRow
	(properties
		teleX 140
		teleY 140
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
					init: 307 73 257 0 290 0 319 36 319 73
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 175 312 175 196 0 226 0 319 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 153 189 143 178 193 178 156 127 135 127 155 159 99 159 119 189 90 189 60 143 108 143 88 116 180 116 229 187 259 187 154 26 185 26 290 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 74 87 34 26 0 26 0 0 47 0 97 76 127 76 77 1 74 0 103 0 166 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 28 185 0 141 0 88 17 116 35 114 4 63 0 63 0 45 25 45 81 127 22 127 63 189 0 189 0 185
					yourself:
				)
		)
	)
)

