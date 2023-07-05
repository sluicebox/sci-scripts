;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Game)
(use System)

(public
	rm019 0
)

(instance rm019 of Rm
	(properties
		picture 19
		style 0
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
					type: PBarredAccess
					init: 0 0 315 0 315 71 258 73 238 77 152 77 155 53 126 54 127 77 33 79 23 83 0 83
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 91 315 91 315 196 227 196 224 155 229 148 251 133 241 110 158 110 144 104 33 104 33 114 205 196 0 196
					yourself:
				)
		)
		(switch gPrevRoomNum
			(west
				(= global345 outCode1)
				(gEgo posn: 26 86)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global345 outCode1)
				(gEgo posn: 231 89)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global345 outCode2)
				(gEgo posn: 170 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(north
				(= global345 outCode1)
				(gEgo posn: 140 76)
				(self setScript: gStdWalkIn)
			)
			(else
				(= global345 outCode2)
				(gEgo posn: 133 113 init:)
			)
		)
		(proc0_8 199 145)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 114 66 166 74)
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
				(= temp0 (proc0_13 126 (gEgo x:) 155))
				(= temp1 48)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 73 (gEgo y:) 90))
			)
			(3
				(= temp0 (proc0_13 10 (gEgo x:) 253))
				(= temp1 93)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 84 (gEgo y:) 90))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 33 (gEgo x:) 232))
				(= temp1 103)
			)
			(2
				(= temp0 252)
				(= temp1 (proc0_13 111 (gEgo y:) 134))
			)
			(3
				(= temp0 (proc0_13 123 (gEgo x:) 223))
				(= temp1 158)
			)
			(4
				(= temp0 28)
				(= temp1 (proc0_13 103 (gEgo y:) 112))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

