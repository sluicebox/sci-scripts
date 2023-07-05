;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use HedgeRow)
(use Polygon)

(public
	hedge2 0
)

(local
	[local0 27]
	[local27 26] = [1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0]
	[local53 26] = [1 1 1 1 1 1 1 1 4 4 4 5 4 5 4 5 4 5 6 15 6 2 3 3 3 3]
	[local79 26] = [94 115 135 156 177 198 219 239 108 85 129 60 149 79 168 100 184 116 4 58 16 72 77 59 7 20]
	[local105 26] = [15 47 77 109 141 173 205 235 121 121 155 155 186 183 216 215 240 239 158 252 174 69 70 70 69 70]
	[local131 13]
	[local144 12] = [0 0 1 1 0 0 0 0 1 1 0 0]
	[local156 12] = [2 2 3 3 4 5 6 6 7 7 8 8]
	[local168 12] = [293 232 310 262 249 306 325 272 362 295 356 296]
	[local180 12] = [28 28 58 61 53 56 82 82 115 113 112 112]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 26) ((++ temp0))
		((= [local0 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local27 temp0]
			priority: [local53 temp0]
			signal: 16400
			x: [local79 temp0]
			y: [local105 temp0]
			init:
		)
		(gAddToPics add: [local0 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		((= [local131 temp0] (hedgeMaster new:))
			loop: 0
			cel: [local144 temp0]
			priority: [local156 temp0]
			signal: 16400
			x: (+ [local168 temp0] 15)
			y: [local180 temp0]
			init:
		)
		(gAddToPics add: [local131 temp0])
	)
	(gAddToPics doit:)
)

(instance hedgeMaster of Hedge
	(properties)
)

(instance hedge2 of HedgeRow
	(properties
		teleX 20
		teleY 90
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
					init: 185 189 62 1 59 0 93 0 218 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 189 4 108 104 108 156 189 127 189 84 123 46 123 88 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 75 0 1 2 1 2 31 24 65 50 65 31 40 62 40 86 75
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 176 0 110 28 168 28 176
					yourself:
				)
		)
	)
)

