;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use eureka)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm222 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 80) ((++ temp0))
		((star new:) init:)
	)
	(star init:)
)

(instance rm222 of Rm
	(properties
		picture 55
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(gGame handsOff:)
		(localproc_0)
		(eurekaShip init:)
		(asteroids init:)
		(self setScript: sGoliathApproach)
		(super init:)
	)
)

(instance sEurekaRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(eurekaShip setCycle: End self)
			)
			(2
				(eurekaShip setMotion: MoveTo 185 72 self)
			)
			(3
				(= global113 15)
				(eureka curLocation: 15 state: 3)
				(gCurRoom newRoom: 201)
				(self dispose:)
			)
		)
	)
)

(instance sGoliathApproach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= seconds 5)
			)
			(1
				(= local0 0)
				(= cycles 1)
			)
			(2
				(= local1 1)
				(= seconds 2)
			)
			(3
				(= local1 0)
				(= cycles 1)
			)
			(4
				(= local2 1)
			)
			(5
				(= seconds 2)
			)
			(6
				(if (IsFlag 42)
					(gCurRoom newRoom: 201)
				else
					(= next sEurekaRuns)
				)
				(self dispose:)
			)
		)
	)
)

(instance star of Actor
	(properties
		view 217
		priority 4
		signal 24576
		moveSpeed 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (Random 50 400))
		(= temp1 (Random 0 359))
		(= temp2 (+ -100 (CosMult temp1 temp0)))
		(= temp3 (+ -100 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			posn: temp2 temp3
			setLoop: (Random 0 2)
			setCel: (Random 0 3)
			heading: 135
			setCycle: 0
			setPri: 4
		)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(local0
				(self x: (+ x 4) y: (+ y 4))
			)
			(local1
				(self x: (+ x 4) y: (+ y 2))
			)
			(local2
				(self x: (+ x 4))
			)
		)
		(if (| (> x 320) (> y 200))
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance eurekaShip of Actor
	(properties
		x -3
		y 72
		view 2242
		loop 1
		priority 5
		signal 24576
		cycleSpeed 2
	)

	(method (doit)
		(if local2
			(if (< x 236)
				(self x: (+ x 3))
			else
				(= local2 0)
				(sGoliathApproach state: (+ (sGoliathApproach state:) 1) cue:)
			)
		)
		(super doit: &rest)
	)
)

(instance asteroids of Actor
	(properties
		x -170
		y 62
		view 2242
		priority 5
		signal 24576
	)

	(method (doit)
		(if local2
			(self x: (- (eurekaShip x:) 167))
		)
		(super doit: &rest)
	)
)

