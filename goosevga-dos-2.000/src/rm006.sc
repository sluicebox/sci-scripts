;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Waters2)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm006 0
)

(local
	[local0 12] = [13 106 80 27 109 80 47 92 80 63 74 80]
)

(instance rm006 of Rm
	(properties
		picture 6
		style 0
		east 7
		south 13
		west 5
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 168 142 258 88 294 89 292 155 204 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 148 24 148 29 155 41 182 0 178
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 315 2 315 56 258 56 250 63 211 64 176 70 171 83 153 88 135 83 114 86 98 105 74 118 44 126 0 132
					yourself:
				)
		)
		(NormalEgo)
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
				(gEgo init:)
			)
			(else
				(gEgo posn: 128 120)
			)
		)
		(water6 init:)
		(gEgo init:)
		(proc0_8 136 99)
		(if
			(and
				global157
				(!= [global200 gCurRoomNum] 45)
				(!= [global200 gCurRoomNum] 44)
				(!= global130 45)
				(!= global130 44)
			)
			(cricObj init: setScript: cric)
		)
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
		(DisposeScript 402)
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
						(not (User controls:))
						(gCurRoom script:)
						(!= (DoAudio audPOSITION) -1)
					)
					(= cycles 1)
				else
					(= ticks
						(+
							4
							(DoAudio
								audPLAY
								(if (Random 0 1)
									35
								else
									(Random 574 577)
								)
							)
						)
					)
				)
				(= state -1)
			)
		)
	)
)

(instance water6 of Waters2
	(properties
		view 134
		cycleSpeed 4
	)

	(method (getLoop)
		(= x [local0 pos])
		(= y [local0 (++ pos)])
		(= cel [local0 (++ pos)])
	)

	(method (saveLoop)
		(= [local0 pos] cel)
		(++ pos)
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
				(= temp1 (proc0_13 56 (gEgo y:) 84))
			)
			(3
				(= temp0 (proc0_13 29 (gEgo x:) 204))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 133 (gEgo y:) 148))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

