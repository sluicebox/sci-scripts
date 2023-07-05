;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm035 0
)

(local
	local0
)

(instance rm035 of Rm
	(properties
		picture 35
		style 0
		horizon 100
		north 28
		west 34
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 400)
		(Load rsVIEW 136)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(28
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 45) 86) 1))
			)
			(34 0)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 70 110)
		(if global131
			(water1 setCycle: Fwd cycleSpeed: 3 setPri: 0 init:)
			(water2 setCycle: Fwd cycleSpeed: 3 setPri: 0 init:)
			(water3 setCycle: Fwd cycleSpeed: 3 setPri: 0 init:)
			(= local0 (Random 0 4))
			(if (or (== 0 local0) (== 3 local0))
				(frog init: setScript: frogScript)
			)
		else
			(water1 init: addToPic:)
			(water2 init: addToPic:)
			(water3 init: addToPic:)
		)
	)
)

(instance frogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
			)
			(1
				(frog
					setPri: 15
					illegalBits: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: End self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance frog of Actor
	(properties
		x 201
		y 179
		view 400
		loop 1
	)
)

(instance water1 of Prop
	(properties
		x 266
		y 164
		view 136
		loop 2
	)
)

(instance water2 of Prop
	(properties
		x 303
		y 153
		view 136
	)
)

(instance water3 of Prop
	(properties
		x 151
		y 169
		view 136
	)
)

