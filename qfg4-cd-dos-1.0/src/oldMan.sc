;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	oldMan 0
	sOldManWalk 1
)

(local
	local0
)

(instance oldMan of Actor
	(properties
		noun 17
		sightAngle 90
		x 280
		y 139
		view 284
		cycleSpeed 9
		xStep 2
		moveSpeed 9
	)

	(method (handleEvent event)
		(= approachX (oldMan x:))
		(= approachY (- (oldMan y:) 10))
		(super handleEvent: event &rest)
	)
)

(instance sOldManWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (++ local0) 5)
					(self setScript: sCallWife self)
				else
					(oldMan
						view: 285
						setLoop: (* (Random 0 1) 2) 1
						cel: 0
						setCycle: End self
					)
				)
			)
			(1
				(oldMan setLoop: 2)
				(= cycles 6)
			)
			(2
				(oldMan
					view: 285
					setLoop: (+ (* (Random 0 1) 2) 1) 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 314 139 self
				)
			)
			(4
				(oldMan
					view: 285
					setLoop: (+ (* (Random 0 1) 2) 1) 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 293 185 self
				)
			)
			(6
				(oldMan
					view: 285
					setLoop: (* (Random 0 1) 2) 1
					cel: 0
					setCycle: End self
				)
			)
			(7
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 172 185 self
				)
			)
			(8
				(if (>= (++ local0) 5)
					(self setScript: sCallWife self)
				else
					(oldMan
						view: 285
						setLoop: (* (Random 0 1) 2) 1
						cel: 0
						setCycle: End self
					)
				)
			)
			(9
				(oldMan setLoop: 3)
				(= cycles 6)
			)
			(10
				(oldMan
					view: 285
					setLoop: (+ (* (Random 0 1) 2) 1) 1
					cel: 0
					setCycle: End self
				)
			)
			(11
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 293 185 self
				)
			)
			(12
				(oldMan
					view: 285
					setLoop: (+ (* (Random 0 1) 2) 1) 1
					cel: 0
					setCycle: End self
				)
			)
			(13
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 314 139 self
				)
			)
			(14
				(oldMan
					view: 285
					setLoop: (* (Random 0 1) 2) 1
					cel: 0
					setCycle: End self
				)
			)
			(15
				(= state -1)
				(oldMan
					view: 284
					setLoop: -1 1
					setCycle: Walk
					setMotion: MoveTo 280 139 self
				)
			)
		)
	)
)

(instance sCallWife of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gMessager say: 17 6 41 0 self) ; "Anna? Where are you, Anna?"
			)
			(1
				(self dispose:)
			)
		)
	)
)

