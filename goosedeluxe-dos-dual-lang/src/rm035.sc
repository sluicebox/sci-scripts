;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm035 0
)

(instance rm035 of MGRoom
	(properties
		picture 35
		north 28
		west 34
		edgeN 54
		edgeE 320
		edgeW 15
		edgeS 255
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 85 0 132 61 127 124 111 200 108 220 57 193 56 110 56 109 39 97 56 46 59 68 67 94 75 105 85 122 86 120 89 112 96 93 97
					yourself:
				)
		)
		((MoveProp new:) init: 160 0 174 132 9 yourself:)
		((MoveProp new:) init: 160 1 27 147 8 yourself:)
		((MoveProp new:) init: 160 2 79 147 8 yourself:)
		((MoveProp new:) init: 160 3 230 147 7 yourself:)
		((MoveProp new:) init: 160 4 173 145 9 yourself:)
		(proc0_1)
		(if
			(and
				(!= [global200 gCurRoomNum] 45)
				(!= [global200 gCurRoomNum] 44)
				(!= global130 45)
				(!= global130 44)
			)
			(cricObj init: setScript: cric)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 105 (gEgo x:) 110) 54)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 98 (gEgo y:) 130))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 67 108 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 168 79)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance cricObj of Prop
	(properties
		x -10
		y -10
		view 895
		cel 7
		signal 16384
	)
)

(instance cric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 360 600))
			)
			(1
				(if
					(or
						(not (gUser controls:))
						(gCurRoom script:)
						(!= (DoAudio audPOSITION) -1)
					)
					(= cycles 1)
				else
					(= ticks
						(+
							4
							(gSfx
								number:
									(if (Random 0 1)
										35
									else
										(Random 574 577)
									)
								play:
							)
						)
					)
				)
				(= state -1)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 105 (gEgo x:) 110))
				(= temp1 53)
			)
			(2
				(= temp0 254)
				(= temp1 (proc0_13 66 (gEgo y:) 108))
			)
			(3
				(= temp0 (proc0_13 5 (gEgo x:) 202))
				(= temp1 127)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 98 (gEgo y:) 124))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 2)
	)
)

