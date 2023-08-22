;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm008 0
)

(instance rm008 of MGRoom
	(properties
		picture 8
		north 1
		east 9
		south 15
		edgeN 82
		edgeW -1
	)

	(method (init)
		(super init:)
		(= global305 outCode)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 177 0 1 77 0 64 79 20 110 36 113 36 124 143 147 161 170
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
				(gEgo posn: (proc0_13 53 (gEgo x:) 133) 82)
				(self setScript: gStdClimbIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 91 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 123 (gEgo x:) (gCurRoom edgeE:)) 139)
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
		(proc0_8 130 128)
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
				(= temp0 (proc0_13 106 (gEgo x:) 138))
				(= temp1 82)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 63 (gEgo y:) 153))
			)
			(3
				(= temp0 (proc0_13 136 (gEgo x:) 256))
				(= temp1 158)
			)
			(4
				(= temp0 15)
				(= temp1 (proc0_13 84 (gEgo y:) 139))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

