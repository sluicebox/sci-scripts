;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge3 0
)

(local
	[local0 9]
	[local9 8] = [1 1 1 1 1 1 1 1]
	[local17 8] = [0 0 0 0 0 0 1 15]
	[local25 8] = [10 30 51 72 93 114 16 73]
	[local33 8] = [73 105 137 169 201 233 172 261]
	[local41 23]
	[local64 23] = [1 0 1 1 0 0 0 0 0 1 1 1 0 0 1 1 0 0 0 0 1 1 0]
	[local87 23] = [6 7 7 7 8 9 9 10 10 11 11 11 12 12 12 12 13 13 14 14 15 14 15]
	[local110 23] = [92 178 199 147 144 210 154 225 168 244 194 140 252 196 270 222 214 273 288 231 309 261 247]
	[local133 23] = [89 63 94 94 89 108 108 128 126 158 158 155 170 170 195 195 194 197 217 217 247 249 239]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local9 temp0]
			priority: [local17 temp0]
			signal: 16400
			x: [local25 temp0]
			y: [local33 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 22) ((++ temp0))
		((= [local41 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local64 temp0]
			priority: [local87 temp0]
			signal: 16400
			x: (+ [local110 temp0] 15)
			y: [local133 temp0]
			init:
		)
		(gAddToPics add: [local41 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge3 of HedgeRow
	(properties
		teleX 15
		teleY 160
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
				((Polygon new:) type: PBarredAccess init: 62 189 0 94 0 46 95 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 27 174 0 174 0 100 27 160
					yourself:
				)
		)
	)
)

