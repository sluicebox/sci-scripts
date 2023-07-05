;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use System)

(public
	rm019 0
)

(instance rm019 of MGRoom
	(properties
		picture 19
		north 12
		east 20
		south 26
		west 18
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 230 75 148 74 148 55 131 55 118 74 -1 82 -1 94 34 92 233 98 258 101 258 76
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 220 165 220 150 230 145 220 140 235 120 232 110 100 110 100 135 122 165
					yourself:
				)
		)
		(switch gPrevRoomNum
			(west
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo posn: 26 86)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo posn: 231 89)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global305 outCode2)
				(self edgeN: -1)
				(gEgo posn: 170 139)
				(self setScript: gStdWalkIn)
			)
			(north
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo posn: 136 74 loop: 2 init:)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(if (> global174 105)
					(= global305 outCode2)
					(self edgeN: -1)
				else
					(= global305 outCode1)
					(self edgeS: 255)
				)
				(gGame handsOn:)
			)
			(else
				(= global305 outCode2)
				(self edgeN: -1)
				(gEgo posn: 133 113 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 199 145)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 126 60 152 65)
				(self newRoom: 12)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 133 (gEgo x:) 150))
				(= temp1 60)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 76 (gEgo y:) 101))
			)
			(3
				(= temp0 (proc0_13 10 (gEgo x:) 253))
				(= temp1 93)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 82 (gEgo y:) 94))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 1)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 33 (gEgo x:) 225))
				(= temp1 105)
			)
			(2
				(= temp0 241)
				(= temp1 (proc0_13 104 (gEgo y:) 117))
			)
			(3
				(= temp0 (proc0_13 124 (gEgo x:) 217))
				(= temp1 158)
			)
			(4
				(= temp0 30)
				(= temp1 (proc0_13 103 (gEgo y:) 112))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

