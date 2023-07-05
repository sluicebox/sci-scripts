;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm008 0
)

(instance rm008 of Rm
	(properties
		picture 8
		style 0
		horizon 100
		east 9
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 120)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(1
				(gEgo x: (+ (/ (* (- (gEgo x:) 150) 111) 169) 63))
			)
			(2
				(gEgo x: (+ (/ (* (- (gEgo x:) 0) 112) 63) 206))
			)
			(9 0)
			(15
				(gEgo posn: 271 175)
			)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(gEgo init:)
		(proc0_10 155 135)
		(if global131
			(well init: stopUpd:)
			(sun setCycle: Fwd setScript: sunScript cycleSpeed: 3 init:)
			(sunEyes setPri: 3 init:)
		else
			(well init: addToPic:)
			(sun init: addToPic:)
			(sunEyes setPri: 15 init: addToPic:)
		)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 3)
				(if (== global111 58)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 15)
			)
			((== (gEgo edgeHit:) 1)
				(if (< (gEgo x:) 190)
					(if (== global111 56)
						(gGlobalMGSound fade:)
					)
					(gCurRoom newRoom: 1)
				else
					(gCurRoom newRoom: 2)
				)
			)
		)
		(super doit:)
	)
)

(instance sunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 10))
			)
			(1
				(sunEyes setCycle: End self)
			)
			(2
				(= seconds (Random 0 5))
			)
			(3
				(sunEyes setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance well of View
	(properties
		y 23
		x 131
		view 120
		loop 2
		cel 1
	)
)

(instance sun of Prop
	(properties
		y 27
		x 197
		view 120
		loop 1
	)
)

(instance sunEyes of Prop
	(properties
		y 13
		x 197
		view 120
		loop 4
	)
)

