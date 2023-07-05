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
	(for ((= temp0 1)) (< temp0 40) ((++ temp0))
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
				(leadStar init:)
			)
			(1
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
		(= temp0 (Random 50 160))
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
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
			(local1
				(self
					x: (+ x (if (and (< cel 2) (== loop 2)) 4 else 2))
					y: (+ y (if (and (< cel 2) (== loop 2)) 4 else 2))
				)
				(if (or (> x 320) (> y 200))
					(self x: (- x 320) y: (- y 200))
				)
			)
			(local2
				(self
					x: (+ x (if (and (< cel 2) (== loop 2)) 4 else 2))
					y: (+ y (if (and (< cel 2) (== loop 2)) 2 else 1))
				)
				(if (or (> x 320) (> y 200))
					(self x: (- x 320) y: (- y 200))
				)
			)
			(local0
				(self x: (+ x (if (and (< cel 2) (== loop 2)) 4 else 2)))
				(if (> x 319)
					(self x: (- x 319))
				)
			)
		)
		(super doit: &rest)
	)
)

(instance leadStar of Actor
	(properties
		view 217
		priority 4
		signal 24576
		moveSpeed 0
	)

	(method (init)
		(super init: &rest)
		(= local1 1)
	)

	(method (doit)
		(cond
			(local1
				(self x: (+ x 6) y: (+ y 6))
				(if (and (> x 320) (> y 200))
					(= local1 0)
					(= local2 1)
					(self x: 0 y: 0)
				)
			)
			(local2
				(self x: (+ x 6) y: (+ y 3))
				(if (> x 319)
					(= local2 0)
					(= local0 1)
					(self x: 0 y: 0)
				)
			)
			(local0
				(eurekaShip init:)
				(asteroids init:)
				(self dispose:)
			)
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
		(if local0
			(if (< x 236)
				(self x: (+ x 3))
			else
				(= local0 0)
				(sGoliathApproach cue:)
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
		(if local0
			(self x: (- (eurekaShip x:) 167))
		)
		(super doit: &rest)
	)
)

