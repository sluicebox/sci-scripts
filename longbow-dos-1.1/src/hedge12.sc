;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge12 0
)

(local
	[local0 38]
	[local38 37] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1]
	[local75 37] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
	[local112 37] = [1 1 1 1 1 1 3 3 3 3 5 5 5 6 6 6 7 7 7 7 10 10 10 10 10 12 12 12 12 12 12 13 13 13 13 13 13]
	[local149 37] = [327 264 201 138 74 34 339 309 246 195 321 307 286 358 331 352 257 277 298 313 170 190 211 232 248 88 110 131 152 173 190 28 48 69 90 109 128]
	[local186 37] = [45 45 45 45 45 45 83 83 83 83 115 115 115 142 173 205 146 177 209 233 114 146 178 210 233 79 112 144 176 208 233 78 109 141 173 203 233]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 37) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: [local38 temp0]
			cel: [local75 temp0]
			priority: [local112 temp0]
			signal: 16400
			x: [local149 temp0]
			y: [local186 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge12 of HedgeRow
	(properties
		teleX 131
		teleY 188
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
					init: 77 189 0 71 0 20 319 20 319 47 70 47 164 189 135 189 40 47 14 47 105 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 189 114 74 319 74 319 85 153 85 222 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 262 189 204 105 319 105 319 117 243 117 289 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 317 189 317 187 278 130 319 130 319 144
					yourself:
				)
		)
	)
)

