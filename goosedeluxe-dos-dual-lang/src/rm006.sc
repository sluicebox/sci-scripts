;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm006 0
)

(instance rm006 of MGRoom
	(properties
		picture 6
		east 7
		south 13
		west 5
		edgeN -1
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 168 142 258 88 294 89 292 155 204 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 148 20 148 29 155 41 182 0 178
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 315 0 315 56 258 56 250 63 211 64 176 70 171 83 118 81 91 106 62 119 29 124 0 128
					yourself:
				)
		)
		((MoveProp new:) init: 134 0 15 105 13 yourself:)
		((MoveProp new:) init: 134 1 47 90 10 yourself:)
		((MoveProp new:) init: 134 2 63 74 13 yourself:)
		(if
			(and
				(!= [global200 gCurRoomNum] 45)
				(!= [global200 gCurRoomNum] 44)
				(!= global130 45)
				(!= global130 44)
			)
			(dummyProp init: setScript: cricketOrBirdScript)
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 26 145)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 92)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: 128 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 128 120)
				(gGame handsOn:)
			)
		)
		(proc0_8 136 99)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose &tmp temp0)
		(super dispose:)
	)
)

(instance dummyProp of Prop
	(properties
		x -10
		y -10
		view 895
		cel 7
	)
)

(instance cricketOrBirdScript of Script
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
			)
			(2
				(self init:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 114 (gEgo x:) 255))
				(= temp1 55)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 81 (gEgo y:) 84))
			)
			(3
				(= temp0 (proc0_13 52 (gEgo x:) 204))
				(= temp1 166)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 133 (gEgo y:) 148))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

