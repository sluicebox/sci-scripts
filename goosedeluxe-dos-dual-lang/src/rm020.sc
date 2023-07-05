;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Sound)
(use Actor)
(use System)

(public
	rm020 0
)

(instance rm020 of MGRoom
	(properties
		picture 20
		north 13
		south 27
		west 19
		edgeN 50
		edgeE 320
		edgeW 10
	)

	(method (init &tmp temp0)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 90 15 90 15 127 46 127 68 118 114 93 135 93 169 166 0 166
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 93 50 73 71 37 73 0 76 0 0 93 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 201 165 169 93 199 93 164 84 156 78 127 55 127 0 257 0 257 166
					yourself:
				)
		)
		((MoveProp new:) init: 135 0 127 149 5 yourself:)
		((MoveProp new:) init: 135 1 234 132 5 yourself:)
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
				(gEgo posn: 114 50)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 66 84)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: 187 139)
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
		(proc0_8 35 104)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) 1)
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
				(= cycles (= state -1))
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 94 (gEgo x:) 126))
				(= temp1 49)
			)
			(2
				(= temp0 199)
				(= temp1 (proc0_13 56 (gEgo y:) 143))
			)
			(3
				(= temp0 (proc0_13 156 (gEgo x:) 203))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 65 (gEgo y:) 80))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 1)
	)
)

