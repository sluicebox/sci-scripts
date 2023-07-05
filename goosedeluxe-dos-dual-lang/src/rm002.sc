;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm002 0
)

(instance rm002 of MGRoom
	(properties
		picture 2
		east 3
		south 9
		west 1
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
					init: 0 93 14 93 30 101 37 107 45 107 64 117 80 134 84 139 77 143 70 148 64 150 60 155 0 156
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 243 145 258 145 258 155 232 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 258 127 209 120 183 113 160 104 143 81 123 79 107 83 86 80 90 74 85 68 0 58 0 0 258 0
					yourself:
				)
		)
		((MoveProp new:) init: 139 0 244 106 13 yourself:)
		((MoveProp new:) init: 139 1 226 113 13 yourself:)
		((MoveProp new:) init: 139 2 208 89 13 yourself:)
		((MoveProp new:) init: 139 3 194 73 13 yourself:)
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
				(gEgo posn: 26 (proc0_13 66 (gEgo y:) 92))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 135)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 87 (gEgo x:) 209) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 120 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 120 106)
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

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
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
				(= temp0 (proc0_13 10 (gEgo x:) 166))
				(= temp1 51)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 127 (gEgo y:) 146))
			)
			(3
				(= temp0 (proc0_13 44 (gEgo x:) 222))
				(= temp1 166)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 64 (gEgo y:) 105))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

