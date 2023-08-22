;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm014 0
)

(instance rm014 of MGRoom
	(properties
		picture 14
		north 7
		west 13
		edgeN 46
		edgeE 320
		edgeS 255
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 198 46 112 59 136 69 130 77 97 84 106 95 0 117 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 196 0 148 166 147 232 121 251 38 315 38 315 196
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
				(gEgo posn: 178 49)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 115 (gEgo y:) 153))
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
		(proc0_8 79 137)
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
				(= temp0 (proc0_13 199 (gEgo x:) 233))
				(= temp1 46)
			)
			(2
				(= temp0 249)
				(= temp1 (proc0_13 49 (gEgo y:) 138))
			)
			(3
				(= temp0 (proc0_13 3 (gEgo x:) 235))
				(= temp1 149)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 123 (gEgo y:) 146))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

