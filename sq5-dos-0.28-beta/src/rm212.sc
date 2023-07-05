;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm212 0
)

(instance rm212 of Rm
	(properties
		picture 131
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(gGame handsOff:)
		(eurekaShip init:)
		(blob init:)
		(pulse1 init:)
		(pulse2 init:)
		(pulse3 init:)
		(pulse4 init:)
		(gCurRoom setScript: sFire)
		(super init:)
	)
)

(instance sFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pulse1 setCycle: Osc)
				(pulse2 setCycle: Osc)
				(pulse3 setCycle: Osc)
				(pulse4 setCycle: Osc)
				(= cycles 1)
			)
			(1
				(= seconds 1)
			)
			(2
				(eurekaShip setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(eurekaShip addToPic:)
				(torpedo init: setMotion: MoveTo 220 89 self)
				(gSq5Music2 number: 657 setLoop: 1 play:)
			)
			(5
				(torpedo x: 77 y: 60 hide:)
				(spit init: cycleSpeed: 2 setCycle: End self)
				(gSq5Music2 number: 519 setLoop: 1 play:)
			)
			(6
				(spit hide:)
				(torpedo show: setMotion: MoveTo 264 74 self)
				(gSq5Music2 number: 657 setLoop: 1 play:)
			)
			(7
				(torpedo dispose:)
				(spit show: cel: 0 x: 271 y: 77 setCycle: End self)
				(gSq5Music2 number: 519 setLoop: 1 play:)
			)
			(8
				(spit
					setLoop: 7
					x: 284
					y: 74
					setPri: 2
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(9
				(spit dispose:)
				(pulse1 dispose:)
				(pulse2 dispose:)
				(pulse3 dispose:)
				(pulse4 dispose:)
				(blob
					setLoop: 8
					cel: 0
					x: 238
					y: 77
					cycleSpeed: 25
					setCycle: End self
				)
			)
			(10
				(gCurRoom newRoom: 201)
				(self dispose:)
			)
		)
	)
)

(instance blob of Actor
	(properties
		x 214
		y 70
		view 705
		priority 2
		signal 16400
	)
)

(instance eurekaShip of Prop
	(properties
		x 20
		y 42
		view 705
		loop 5
		priority 2
		signal 16400
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self x: 20 y: 42 setLoop: 5 setCel: 0)
	)
)

(instance spit of Prop
	(properties
		x 227
		y 92
		view 705
		loop 6
		cel 3
		priority 4
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 6 setCel: 0)
	)
)

(instance torpedo of Actor
	(properties
		x 69
		y 61
		view 705
		loop 9
		priority 3
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 9
			setCel: 0
			setCycle: 0
			setStep: 25 25
			moveSpeed: 0
			setScale: Scaler 100 26 74 60
		)
	)
)

(instance pulse1 of Prop
	(properties
		x 221
		y 92
		view 705
		loop 1
		priority 2
		signal 16400
	)
)

(instance pulse2 of Prop
	(properties
		x 257
		y 80
		view 705
		loop 2
		cel 2
		priority 2
		signal 16400
		cycleSpeed 7
	)
)

(instance pulse3 of Prop
	(properties
		x 296
		y 68
		view 705
		loop 3
		cel 3
		priority 2
		signal 16400
		cycleSpeed 8
	)
)

(instance pulse4 of Prop
	(properties
		x 306
		y 102
		view 705
		loop 4
		priority 2
		signal 16400
	)
)

