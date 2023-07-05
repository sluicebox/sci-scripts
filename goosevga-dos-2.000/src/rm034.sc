;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
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
	rm034 0
)

(local
	[local0 9] = [64 136 80 133 146 80 211 143 80]
)

(instance rm034 of Rm
	(properties
		picture 34
		style 0
		horizon 59
		north 27
		east 35
		west 33
	)

	(method (init)
		(= global345 outCode)
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
		(water init:)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 83 (gEgo x:) 128) 60)
				(self setScript: global145)
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
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 180 103)
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
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose &tmp temp0)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water of Waters2
	(properties
		view 136
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 6 (gEgo x:) 136))
				(= temp1 46)
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

