;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
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
	rm034 0
)

(instance rm034 of MGRoom
	(properties
		picture 34
		horizon 59
		north 27
		east 35
		west 33
		edgeN 65
		edgeS 255
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 112 58 109 78 106 142 121 183 125 225 126 315 125 315 196 0 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 262 0 283 82 234 81 177 82 143 79 133 58
					yourself:
				)
		)
		(proc0_1)
		((MoveProp new:) init: 136 0 61 137 13 yourself:)
		((MoveProp new:) init: 136 1 124 145 13 yourself:)
		((MoveProp new:) init: 136 2 208 143 13 yourself:)
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
				(gEgo posn: (proc0_13 83 (gEgo x:) 128) 60)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 77 (gEgo y:) 113))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 79 (gEgo y:) 129))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 120 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 180 103)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) 1)
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
				(= temp0 (proc0_13 106 (gEgo x:) 121))
				(= temp1 65)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 83 (gEgo y:) 124))
			)
			(3
				(= temp0 (proc0_13 52 (gEgo x:) 253))
				(= temp1 127)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 68 (gEgo y:) 111))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

