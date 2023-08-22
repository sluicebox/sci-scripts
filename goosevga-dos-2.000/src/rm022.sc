;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm022 0
)

(instance rm022 of Rm
	(properties
		picture 22
		style 0
		north 15
		east 23
		south 29
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 196 0 0 85 0 81 76 51 104 71 115 43 135 125 196 82 189
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 87 (gEgo x:) 140) 72)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 78 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 81 (gEgo y:) global59))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 155 130)
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
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
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
				(= temp0 (proc0_13 91 (gEgo x:) 252))
				(= temp1 50)
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

