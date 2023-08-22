;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm028 0
)

(local
	[local0 58] = [2 0 0 0 -14336 133 39 122 55 122 80 125 144 125 131 116 131 102 131 91 0 -32689 -14106 156 248 139 247 124 219 121 204 124 175 118 167 109 169 102 173 90 258 -32681 0 99 17 0 118 17 0 138 17 0 159 17 0 179 17 0]
	local58
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
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 153 108)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) 222) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 (proc0_13 117 (gEgo y:) global61))
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
			(= local58 1)
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
		y 70
		x 108
		view 174
		cel 3
		priority 4
		cycleSpeed 7
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance shoe2 of Prop
	(properties
		y 29
		x 128
		view 174
		loop 1
		cycleSpeed 5
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
		y 47
		x 148
		view 174
		loop 2
		priority 1
		cycleSpeed 6
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
		y 20
		x 169
		view 174
		loop 3
		cycleSpeed 5
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
		y 53
		x 192
		view 174
		loop 4
		cel 2
		priority 2
		cycleSpeed 17
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

