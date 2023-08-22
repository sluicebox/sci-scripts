;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm028 0
)

(local
	[local0 15] = [99 17 0 118 17 0 138 17 0 159 17 0 179 17 0]
	local15
)

(instance rm028 of Rm
	(properties
		picture 28
		style 0
		north 21
		south 35
		west 27
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 113 0 84 43 103 84 103 84 99 124 99 127 120 34 123 14 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 99 315 196 211 196 252 139 250 120 246 120 224 117 210 121 180 116 171 110 173 99
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 153 108)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 global61 (gEgo x:) 222) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 117 (gEgo y:) global59))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(if (not ((gGoals at: 11) egoReturned:))
			(shoe1 init:)
			(shoe2 init:)
			(shoe3 init:)
			(shoe4 init:)
			(shoe5 init:)
			(= local15 1)
		)
		(proc0_8 213 134)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdWalkOut 0 1)
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
		view 174
		cel 3
		priority 4
		signal 16384
		cycleSpeed 11
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance shoe2 of Prop
	(properties
		x 128
		y 29
		view 174
		loop 1
		signal 16384
		cycleSpeed 10
	)

	(method (init)
		(if (> global170 90)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
	)
)

(instance shoe3 of Prop
	(properties
		x 148
		y 47
		view 174
		loop 2
		priority 1
		signal 16384
		cycleSpeed 13
	)

	(method (init)
		(if (> global170 70)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
	)
)

(instance shoe4 of Prop
	(properties
		x 169
		y 20
		view 174
		loop 3
		signal 16384
		cycleSpeed 20
	)

	(method (init)
		(if (> global170 110)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
	)
)

(instance shoe5 of Prop
	(properties
		x 192
		y 53
		view 174
		loop 4
		cel 2
		priority 2
		signal 16384
		cycleSpeed 30
	)

	(method (init)
		(if (> global170 120)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
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
				(= temp1 (proc0_13 114 (gEgo y:) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

