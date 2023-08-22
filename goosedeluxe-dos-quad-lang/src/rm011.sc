;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use System)

(public
	rm011 0
)

(instance rm011 of MGRoom
	(properties
		picture 11
		north 4
		south 18
		edgeN 92
		edgeE 320
		edgeW -1
	)

	(method (init)
		(= global305 outCode)
		(Load rsVIEW 138)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 315 0 315 196 205 196 224 155 236 149 191 131 164 124 159 108 163 96 120 92 121 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 1 196 -3 28 95 85 85 94 65 91 45 101 63 115 53 131 36 149 67 196
					yourself:
				)
		)
		((MoveProp new:) init: 138 0 102 22 4 yourself:)
		((MoveProp new:) init: 138 1 164 19 4 yourself:)
		((MoveProp new:) init: 138 2 144 19 4 yourself:)
		((MoveProp new:) init: 138 2 103 41 4 yourself:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 91 (gEgo x:) 119) 92)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo posn: (proc0_13 95 (gEgo x:) 170) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 120)
				(gGame handsOn:)
			)
		)
		(proc0_8 73 140)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 91 (gEgo x:) 119))
				(= temp1 92)
			)
			(2
				(= temp0 229)
				(= temp1 (proc0_13 98 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 44 (gEgo x:) 219))
				(= temp1 158)
			)
			(4
				(= temp0 32)
				(= temp1 (proc0_13 98 (gEgo y:) 153))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

