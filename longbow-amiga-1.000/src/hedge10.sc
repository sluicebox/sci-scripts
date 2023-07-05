;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge10 0
)

(local
	[local0 10]
	[local10 9] = [1 1 1 1 1 0 0 0 1]
	[local19 9] = [1 1 1 1 1 1 1 1 1]
	[local28 9] = [15 15 15 15 15 14 14 14 15]
	[local37 9] = [340 319 298 277 256 340 319 298 235]
	[local46 9] = [177 145 113 81 49 85 53 21 17]
	[local55 23]
	[local78 20] = [0 1 1 1 0 1 1 1 0 0 1 0 0 0 0 1 0 0 0 0]
	[local98 20] = [15 14 14 14 13 12 12 12 11 11 10 9 9 8 8 7 6 6 5 5]
	[local118 20] = [210 264 212 154 242 233 182 128 214 156 98 188 127 171 112 59 150 93 132 77]
	[local138 20] = [225 227 225 219 194 178 178 178 149 149 131 104 104 82 82 77 52 52 29 29]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: [local10 temp0]
			cel: [local19 temp0]
			priority: [local28 temp0]
			signal: 16400
			x: [local37 temp0]
			y: [local46 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 20) ((++ temp0))
		((= [local55 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local78 temp0]
			priority: [local98 temp0]
			signal: 16400
			x: (+ [local118 temp0] 10)
			y: (- [local138 temp0] 20)
			init:
		)
		(gAddToPics add: [local55 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge10 of HedgeRow
	(properties
		teleX 293
		teleY 56
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
					init: 319 183 199 0 234 0 319 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 92 259 0 293 0 319 39
					yourself:
				)
		)
	)
)

