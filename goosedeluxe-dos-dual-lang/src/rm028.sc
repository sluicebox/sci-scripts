;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm028 0
)

(instance rm028 of MGRoom
	(properties
		picture 28
		north 21
		south 35
		west 27
		edgeE 320
	)

	(method (init)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -1 66 134 66 130 112 108 118 65 118 44 110 -1 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 179 66 300 66 300 155 233 155 241 140 250 135 250 117 220 112 192 115 170 106
					yourself:
				)
		)
		(proc0_1)
		(if (not ((gGoals at: 11) egoReturned:))
			(shoe1 init:)
			(shoe2 init:)
			(shoe3 init:)
			(shoe4 init:)
			(shoe5 init:)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 153 110)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 (gCurRoom edgeW:) (gEgo x:) 222) 145)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 117 (gEgo y:) (gCurRoom edgeS:)))
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
		(super init: &rest)
		(proc0_8 213 134)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((< (gEgo y:) 110)
				(self setScript: gStdWalkOut 0 1)
			)
			((> (gEgo y:) 150)
				(self setScript: gStdWalkOut 0 3)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance shoe1 of Prop
	(properties
		x 108
		y 70
		priority 4
		view 174
		cel 3
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance shoe2 of Prop
	(properties
		x 128
		y 29
		view 174
		loop 1
		cycleSpeed 10
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance shoe3 of Prop
	(properties
		x 148
		y 47
		priority 1
		view 174
		loop 2
		cycleSpeed 13
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance shoe4 of Prop
	(properties
		x 156
		y 20
		view 174
		loop 3
		cycleSpeed 20
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance shoe5 of Prop
	(properties
		x 192
		y 53
		priority 2
		view 174
		loop 4
		cel 2
		cycleSpeed 30
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 115 (gEgo x:) 210))
				(= temp1 84)
			)
			(2
				(= temp0 256)
				(= temp1 (proc0_13 119 (gEgo y:) 142))
			)
			(3
				(= temp0 (proc0_13 3 (gEgo x:) 362))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 114 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

