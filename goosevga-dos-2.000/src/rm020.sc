;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
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
	rm020 0
)

(local
	[local0 6] = [129 148 80 237 133 80]
)

(instance rm020 of Rm
	(properties
		picture 20
		style 0
		horizon 50
		north 13
		south 27
		west 19
		vanishingX 40
		vanishingY -90
	)

	(method (init &tmp temp0)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 222 180 167 98 192 98 189 89 154 82 159 70 128 57 128 0 315 0 315 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 182 0 94 6 100 20 133 49 119 109 117 109 99 130 98 172 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 11 27 97 50 84 70 41 77 0 78
					yourself:
				)
		)
		(water init:)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 114 50)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 26 84)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo setPri: -1 posn: 187 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120)
			)
		)
		(gEgo init:)
		(proc0_8 35 104)
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
			((== 1 (gEgo edgeHit:))
				(self setScript: gStdClimbOut)
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

(instance water of Waters2
	(properties
		view 135
		cycleSpeed 5
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
				(= temp0 (proc0_13 95 (gEgo x:) 124))
				(= temp1 35)
			)
			(2
				(= temp0 199)
				(= temp1 (proc0_13 66 (gEgo y:) 143))
			)
			(3
				(= temp0 (proc0_13 165 (gEgo x:) 202))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 79 (gEgo y:) 93))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

