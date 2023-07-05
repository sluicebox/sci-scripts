;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge4 0
)

(local
	[local0 28]
	[local28 28] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 0 0]
	[local56 28] = [1 1 1 1 1 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 1 1]
	[local84 28] = [9 9 9 9 9 9 13 13 12 12 12 10 10 8 8 8 7 7 7 6 6 6 15 15 15 15 15 15]
	[local112 28] = [237 216 196 175 154 135 121 60 116 95 37 74 18 242 353 296 302 328 267 306 245 192 178 117 55 355 258 279]
	[local140 28] = [185 154 123 92 60 32 99 99 95 61 61 27 27 93 99 99 59 59 59 27 27 22 187 187 187 187 214 243]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 28) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: [local28 temp0]
			cel: [local56 temp0]
			priority: [local84 temp0]
			signal: 16400
			x: [local112 temp0]
			y: [local140 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge4 of HedgeRow
	(properties
		teleX 250
		teleY 150
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
					init: 0 176 174 176 186 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 276 189 264 176 319 176 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 216 189 92 1 88 0 121 0 251 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 88 87 88 75 62 0 62 0 47 93 47 129 101 0 101
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 221 101 184 47 319 47 319 64 226 64 243 88 319 88 319 101
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 81 29 0 29 0 0 65 0 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 175 29 153 0 292 0 314 29
					yourself:
				)
		)
	)
)

