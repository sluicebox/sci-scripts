;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm008 0
)

(instance rm008 of Rm
	(properties
		picture 8
		style 0
		north 1
		east 9
		south 15
	)

	(method (init)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 177 0 1 77 0 64 79 20 110 47 114 28 134 130 155 141 170
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 53 (gEgo x:) 133) 82)
				(self setScript: global145)
			)
			(east
				(gEgo posn: 231 (proc0_13 91 (gEgo y:) global59))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 123 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 130 128)
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
			((== (gEgo onControl:) 4)
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
				(= temp0 (proc0_13 72 (gEgo x:) 255))
				(= temp1 51)
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

