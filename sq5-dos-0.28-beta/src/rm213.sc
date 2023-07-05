;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use eureka)
(use Osc)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm213 0
)

(instance rm213 of Rm
	(properties
		picture 131
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(eurekaShip init: cel: 0)
		(blob init: setCycle: Fwd)
		(eureka damaged: 1)
		(gCurRoom setScript: sSuckBlob)
		(super init:)
	)
)

(instance sSuckBlob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(eurekaShip setCycle: End self)
			)
			(2
				(beatrbar init: setCycle: Fwd)
				(thruster init: setCycle: Osc)
				(= ticks 90)
			)
			(3
				(blob
					setLoop: 1
					cel: 0
					x: 84
					y: 36
					cycleSpeed: 15
					setCycle: End self
				)
				(gSq5Music2 number: 228 setLoop: -1 play:)
			)
			(4
				(gCurRoom newRoom: 201)
				(self dispose:)
			)
		)
	)
)

(instance eurekaShip of Prop
	(properties
		x 18
		y 38
		view 710
		loop 2
		cel 2
		priority 4
		signal 16400
	)
)

(instance blob of Prop
	(properties
		x 157
		y 19
		view 710
		cel 4
		priority 5
		signal 16400
		cycleSpeed 10
	)
)

(instance thruster of Prop
	(properties
		x 15
		y 52
		view 710
		loop 3
		cel 1
		priority 5
		signal 16400
	)
)

(instance beatrbar of Prop
	(properties
		x 38
		y 23
		view 710
		loop 4
		cel 3
		priority 5
		signal 16400
		cycleSpeed 2
	)
)

