;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Sound)
(use Actor)
(use System)

(public
	rm022 0
)

(instance rm022 of MGRoom
	(properties
		picture 22
		north 15
		east 23
		south 29
		edgeN 73
		edgeW -1
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 196 0 0 85 0 90 73 56 99 71 110 50 123 65 140 90 166 115 196
					yourself:
				)
		)
		(proc0_1)
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
				(gEgo posn: (proc0_13 90 (gEgo x:) 115) 75)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo posn: (proc0_13 78 (gEgo x:) (gCurRoom edgeE:)) 139)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 81 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 100 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 155 130)
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

(instance dummyProp of Prop
	(properties
		x -10
		y -10
		view 895
		cel 7
	)
)

(instance cricketOrBirdSound of Sound
	(properties)
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
							(cricketOrBirdSound
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
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 90 (gEgo x:) 115))
				(= temp1 73)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 57 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 76 (gEgo x:) 259))
				(= temp1 158)
			)
			(4
				(= temp0 41)
				(= temp1 (proc0_13 85 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

