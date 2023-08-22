;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use System)

(public
	rm038 0
)

(instance rm038 of Rm
	(properties
		picture 38
		style 0
	)

	(method (init)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 141 150 141 132 168 127 187 120 171 112 160 122 149 126 134 125 128 113 110 114 101 108 84 119 82 128 104 131 116 131 116 150
					yourself:
				)
		)
		(HandsOn)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 3 posn: 132 130)
		)
		(gEgo init:)
		(proc0_8 110 132 110 132)
		(= global133 0)
	)

	(method (doit)
		(if (> (gEgo y:) 136)
			(self newRoom: 12)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(!= (event type:) evVERB)
				script
				(!= global130 41)
			)
			(return)
		else
			(event claimed: 1)
			(HandsOff)
			(= global133 1)
			(= global161 1)
			(gEgo setAvoider: PAvoider setMotion: MoveTo 130 137)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 97 (gEgo x:) 177))
				(= temp1 104)
			)
			(2
				(= temp0 194)
				(= temp1 (proc0_13 110 (gEgo y:) 124))
			)
			(3
				(= temp0 (proc0_13 108 (gEgo x:) 158))
				(= temp1 152)
			)
			(4
				(= temp0 77)
				(= temp1 (proc0_13 109 (gEgo y:) 130))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

