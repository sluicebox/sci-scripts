;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
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
	rm002 0
)

(local
	[local0 12] = [247 108 80 226 113 80 212 99 80 197 75 80]
)

(instance rm002 of Rm
	(properties
		picture 2
		style 0
		east 3
		south 9
		west 1
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 42 155 43 196 0 170 0 104 26 116 88 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 243 145 258 145 258 155 223 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 258 127 197 122 168 112 144 86 127 81 96 86 87 81 82 71 37 66 0 63 0 0 258 0
					yourself:
				)
		)
		(proc0_1)
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
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(water2 init:)
		(proc0_8 120 106)
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
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water2 of Waters2
	(properties
		view 139
		cycleSpeed 8
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
				(= temp0 (proc0_13 10 (gEgo x:) 166))
				(= temp1 51)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 127 (gEgo y:) 146))
			)
			(3
				(= temp0 (proc0_13 44 (gEgo x:) 222))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 64 (gEgo y:) 105))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

