;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm016 0
)

(instance rm016 of MGRoom
	(properties
		picture 16
		north 9
		east 17
		south 23
		west 15
		edgeN 41
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 198 178 196 155 213 154 258 102 292 104 290 177
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 222 51 192 6 280 7 287 75 258 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 99 85 81 85 60 84 53 81 57 69 96 69 109 78 101 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 73 32 81 36 88 31 99 13 104 0 106
					yourself:
				)
		)
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
			(north
				(gEgo posn: 64 40)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo posn: (proc0_13 (gCurRoom edgeW:) (gEgo x:) 204) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 102 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 86)
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
		(proc0_8 54 127)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdClimbOut)
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
				(= temp0 (proc0_13 32 (gEgo x:) 126))
				(= temp1 41)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 78 (gEgo y:) 99))
			)
			(3
				(= temp0 (proc0_13 1 (gEgo x:) 188))
				(= temp1 166)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 46 (proc0_14 72 (gEgo y:) 106) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

