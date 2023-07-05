;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm029 0
)

(local
	local0
)

(instance rm029 of Rm
	(properties
		picture 29
		style 0
		horizon 98
		north 22
		east 30
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 400)
		(Load rsVIEW 136)
		(Load rsVIEW 300)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(22
				(gEgo x: (+ (/ (* (- (gEgo x:) 54) 37) 52) 131))
			)
			(30
				(gEgo y: (+ (/ (* (- (gEgo y:) 95) 59) 63) 99))
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 205 115)
		(flower init:)
		((Clone flower) loop: 1 cel: 1 x: 13 y: 132 init:)
		((Clone flower) loop: 1 cel: 2 x: 259 y: 140 init:)
		((Clone flower) loop: 2 cel: 1 x: 254 y: 140 init:)
		((Clone flower) loop: 2 cel: 1 x: 75 y: 111 init:)
		(if global131
			(water1 setCycle: Fwd cycleSpeed: 3 init:)
			(water2 setCycle: Fwd cycleSpeed: 3 init:)
		else
			(water1 init: addToPic:)
			(water2 init: addToPic:)
		)
		(= local0 (Random 0 4))
	)
)

(instance turtleScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
			)
			(1
				(turtle
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

(instance turtle of Act
	(properties
		y 174
		x 37
		view 400
	)
)

(instance water1 of Prop
	(properties
		y 152
		x 90
		view 136
	)
)

(instance water2 of Prop
	(properties
		y 164
		x 143
		view 136
		loop 1
	)
)

(instance flower of View
	(properties
		y 127
		x 8
		view 300
		cel 1
	)
)

