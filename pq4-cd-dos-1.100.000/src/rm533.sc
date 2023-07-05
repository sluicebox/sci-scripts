;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 533)
(include sci.sh)
(use Main)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm533 0
)

(instance rm533 of Room
	(properties
		modNum 530
		picture 530
	)

	(method (init)
		(super init: &rest)
		(self setScript: sEnter)
		(doors init:)
		(wall init:)
		(hallMap init:)
		(floor init:)
		(elevatorLight init:)
		(elevator init:)
	)
)

(instance elevatorLight of Feature
	(properties
		noun 15
		modNum 530
		nsLeft 150
		nsRight 157
		nsBottom 9
		sightAngle 360
		x 153
		y 14
	)
)

(instance floor of Feature
	(properties
		noun 20
		modNum 530
		nsLeft 36
		nsTop 131
		nsRight 283
		nsBottom 147
		sightAngle 360
		x 150
		y 101
	)
)

(instance elevator of Feature
	(properties
		noun 17
		modNum 530
		nsLeft 127
		nsTop 20
		nsRight 186
		nsBottom 134
		sightAngle 40
		approachX 156
		approachY 77
		approachDist 0
		x 156
		y 77
	)
)

(instance hallMap of Feature
	(properties
		noun 18
		modNum 530
		nsLeft 61
		nsTop 22
		nsRight 88
		nsBottom 41
		sightAngle 360
		x 74
		y 22
	)
)

(instance wall of Feature
	(properties
		noun 19
		modNum 530
		nsLeft 38
		nsRight 284
		nsBottom 148
		sightAngle 360
		x 150
		y 1
	)
)

(instance doors of Prop
	(properties
		x 125
		y 122
		priority 9
		view 530
		cycleSpeed 8
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance barry of Prop
	(properties
		noun 23
		modNum 530
		x 216
		y 136
		view 531
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance light of View
	(properties
		x 153
		y 13
		view 530
		loop 1
		cel 1
	)
)

(instance run of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
				(barry view: 535 loop: 0 cel: 0 x: 160 y: 147 init:)
			)
			(1
				(barry setCycle: End self)
			)
			(2
				(barry view: 536 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(barry dispose:)
			)
		)
	)
)

(instance peek of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(barry
					view: 531
					loop: 0
					cel: 0
					x: 225
					y: 136
					init:
					setCycle: End self
				)
			)
			(1
				(barry view: 533 loop: 0 cel: 0 x: 258 y: 135 setCycle: End)
			)
		)
	)
)

(instance peek2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 200)
			)
			(1
				(barry
					view: 532
					loop: 0
					cel: 0
					x: 75
					y: 137
					init:
					setCycle: End
				)
			)
		)
	)
)

(instance peek3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(barry setCycle: End self)
			)
			(1
				(barry loop: 1 cel: 0 setCycle: End)
			)
		)
	)
)

(instance rubberNeck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo setCycle: CT 2 -1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (doit)
		(super doit:)
		(gEgo cycleSpeed: 12)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gPqFlags test: 0)
					(switch (Random 0 3)
						(0
							(self setScript: run)
						)
						(1
							(self setScript: peek)
						)
						(2
							(self setScript: peek2)
						)
						(3
							(barry
								view: 534
								loop: 0
								cel: 0
								x: 100
								y: 139
								init:
								setCycle: CT 6 1
							)
						)
					)
				else
					(barry
						view: 534
						loop: 0
						cel: 0
						x: 100
						y: 139
						init:
						setCycle: CT 6 1
					)
				)
				(gGlobalSound1 number: 940 setLoop: -1 play:)
				(= ticks (Random 60 200))
			)
			(1
				(light init:)
				(gEgo
					view: 9061
					loop: 0
					cel: 2
					x: 150
					y: 119
					setScale: 0
					init:
				)
				(= cycles 1)
			)
			(2
				(cond
					((not script)
						(barry setCycle: CT 10 1 self)
						(gGlobalSound1 number: 942 setLoop: 1 play:)
					)
					(1
						(gGlobalSound1 number: 942 setLoop: 1 play: self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(if (not script)
					(self setScript: peek3)
				)
				(= ticks 120)
			)
			(4
				(gGlobalSound1 number: 939 setLoop: 1 play:)
				(doors setCycle: End)
				(gEgo setScript: rubberNeck)
				(= ticks 100)
			)
			(5
				(gGlobalSound1 number: 938 setLoop: 1 play:)
				(light dispose:)
				(doors setCycle: Beg self)
			)
			(6
				(gGlobalSound1 stop:)
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
				(gTheIconBar disable: 0)
			)
			(7
				(= cycles 10)
			)
			(8
				(self dispose:)
			)
		)
	)
)

