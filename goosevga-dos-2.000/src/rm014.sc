;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm014 0
)

(instance rm014 of Rm
	(properties
		picture 14
		style 0
		north 7
		south 21
		west 13
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 143 66 116 88 104 96 0 122 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 2 196 0 148 233 137 250 34 315 196
					yourself:
				)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 178 49)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 26 (proc0_13 115 (gEgo y:) 153))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (gEgo x:) 139 edgeHit: EDGE_NONE)
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
		(proc0_8 79 137)
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
			((== (gEgo onControl: 1) 4)
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
					(= ticks (+ 4 (DoAudio audPLAY 35)))
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
				(= temp0 (proc0_13 134 (gEgo x:) 244))
				(= temp1 41)
			)
			(2
				(= temp0 249)
				(= temp1 (proc0_13 49 (gEgo y:) 138))
			)
			(3
				(= temp0 (proc0_13 3 (gEgo x:) 235))
				(= temp1 149)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 123 (gEgo y:) 146))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

