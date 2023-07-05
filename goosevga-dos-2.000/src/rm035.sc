;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Waters)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm035 0
)

(local
	[local0 15] = [147 114 0 1 135 0 55 135 0 214 131 0 147 130 0]
)

(instance rm035 of Rm
	(properties
		picture 35
		style 0
		north 28
		west 34
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 125 98 124 111 112 212 101 217 77 194 55 315 0 315 196 1 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 57 41 57 84 124 84 124 98 24 98 -3 92
					yourself:
				)
		)
		(water init:)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 100 (gEgo x:) 192) 57)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 26 (proc0_13 98 (gEgo y:) 130))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 67 108 init:)
			)
		)
		(proc0_8 168 79)
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
		(water doit:)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose &tmp temp0)
		(DisposeScript 401)
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

(instance water of Waters
	(properties
		priority 14
		view 160
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
				(= temp0 (proc0_13 149 (gEgo x:) 199))
				(= temp1 36)
			)
			(2
				(= temp0 227)
				(= temp1 (proc0_13 66 (gEgo y:) 108))
			)
			(3
				(= temp0 (proc0_13 5 (gEgo x:) 202))
				(= temp1 127)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 94 (gEgo y:) 124))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

