;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 534)
(include sci.sh)
(use Main)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm534 0
)

(instance rm534 of Room
	(properties
		modNum 530
		picture 530
	)

	(method (init)
		(super init: &rest)
		(self setScript: sEnter)
		(doors init: signal: (| (doors signal:) $4000))
		(conSign init:)
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
		modNum 530
		x 125
		y 122
		view 530
		cycleSpeed 8
	)
)

(instance conSign of View
	(properties
		noun 21
		modNum 530
		x 155
		y 98
		priority 150
		fixPriority 1
		view 5301
	)

	(method (init)
		(|= signal $1000)
		(super init:)
	)
)

(instance light of View
	(properties
		modNum 530
		x 153
		y 13
		view 530
		loop 1
		cel 1
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 1 60))
			)
			(1
				(switch (Random 0 2)
					(0
						(sFx number: 982 setLoop: 1 play: self)
					)
					(1
						(sFx number: 1003 setLoop: -1 play:)
						(= ticks (Random 30 60))
					)
					(else
						(= ticks (Random 1 60))
					)
				)
			)
			(2
				(= ticks (Random 30 60))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound1 number: 940 setLoop: -1 play:)
				(= ticks (Random 60 200))
			)
			(1
				(light init:)
				(gEgo
					heading: 180
					normalize: 0
					x: 152
					y: 116
					setScaler: Scaler 133 91 146 109
					init:
				)
				(= cycles 1)
			)
			(2
				(gGlobalSound1 number: 942 setLoop: 1 play:)
				(= ticks 120)
			)
			(3
				(gGlobalSound1 number: 939 setLoop: 1 play: self)
				(doors setCycle: End self)
			)
			(4)
			(5
				(self setScript: soundScript)
				(= seconds 3)
			)
			(6
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
				(gTheIconBar disable: 0)
			)
			(7
				(gGlobalSound1 number: 938 setLoop: 1 play: self)
				(light dispose:)
				(doors setCycle: Beg self)
			)
			(8)
			(9
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)

	(method (play)
		(|= flags $0004)
		(super play: &rest)
	)
)

