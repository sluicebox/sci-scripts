;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge1 0
)

(local
	[local0 27]
	[local27 26] = [1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1]
	[local53 26] = [0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0 0]
	[local79 26] = [15 15 15 15 15 3 3 3 3 3 3 4 4 4 4 4 4 5 5 5 8 8 8 7 7 15]
	[local105 26] = [326 261 196 131 67 224 246 267 288 309 330 168 190 211 232 253 273 106 127 148 150 111 46 58 59 40]
	[local131 26] = [187 187 187 187 187 25 59 91 123 155 186 27 60 92 124 156 186 35 67 99 99 99 99 59 59 187]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 26) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: [local27 temp0]
			cel: [local53 temp0]
			priority: [local79 temp0]
			signal: 16400
			x: [local105 temp0]
			y: [local131 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge1 of HedgeRow
	(properties
		teleX 126
		teleY 126
	)

	(method (init &tmp temp0)
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
					init: 0 176 243 176 127 1 123 0 156 0 275 176 299 176 185 2 181 0 215 0 319 157 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 88 119 88 61 1 57 0 88 0 159 101 0 101
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 47 13 47 5 35 45 35 67 64 0 64
					yourself:
				)
		)
	)
)

