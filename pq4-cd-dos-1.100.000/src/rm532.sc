;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 532)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm532 0
	chiefTalker 1
)

(local
	local0
	local1
)

(instance rm532 of Room
	(properties
		modNum 530
		picture 530
	)

	(method (init)
		(sFx init:)
		(super init: &rest)
		(doors init:)
		(wall init:)
		(hallMap init:)
		(floor init:)
		(elevator init:)
		(elevatorLight init:)
		(if (gPqFlags test: 32)
			(chief init:)
			(bill init:)
		else
			(= local1 1)
			(bucket init:)
			(scott init:)
		)
		(self setScript: sEnter)
		(FrameOut)
	)
)

(instance chief of Prop
	(properties
		noun 13
		modNum 530
		x 140
		y 148
		view 538
	)
)

(instance bill of View
	(properties
		noun 22
		modNum 530
		x 191
		y 145
		view 5300
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

(instance chiefTalker of Narrator
	(properties
		x 60
		y 15
		modeless 2
	)
)

(instance yak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chief setCycle: End self)
			)
			(1
				(chief loop: 1 cel: 0 setCycle: Fwd)
				(gMessager sayRandom: 13 0 4 self 530)
			)
			(2
				(chief setCycle: Beg self)
			)
			(3
				(chief loop: 0)
				(chief cel: (chief lastCel:) setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance mop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scott setCycle: Fwd)
			)
			(1
				(scott setCycle: End self)
			)
			(2
				(if (scott loop:)
					(scott loop: 5 cel: 0 setCycle: End self)
				else
					(scott loop: 4 cel: 0 setCycle: End self)
				)
			)
			(3
				(gMessager sayRandom: 0 0 2 self 530)
			)
			(4
				(scott setCycle: Beg self)
			)
			(5
				(if (== (scott loop:) 5)
					(scott loop: 1 setCycle: Fwd)
				else
					(scott loop: 0 setCycle: Fwd)
				)
				(sEnter cue:)
			)
			(6
				(scott setCycle: End self)
			)
			(7
				(if (not (Random 0 5))
					(if (scott loop:)
						(scott loop: 3 cel: 0 setCycle: End self)
					else
						(scott loop: 2 cel: 0 setCycle: End self)
					)
				else
					(sEnter cue:)
					(self dispose:)
				)
			)
			(8
				(gGlobalSound0 pause: 1)
				(gMessager sayRandom: 0 0 3 self 530)
				(sFx number: 530 setLoop: 1 play:)
			)
			(9
				(= ticks 30)
			)
			(10
				(scott setCycle: Beg self)
			)
			(11
				(if (== (scott loop:) 3)
					(scott loop: 1 setCycle: Fwd)
				else
					(scott loop: 0 setCycle: Fwd)
				)
				(sEnter cue:)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance scott of Prop
	(properties
		noun 24
		modNum 530
		view 8534
	)

	(method (init)
		(|= signal $4000)
		(if (Random 0 1)
			(self x: 126 y: 157 loop: 1 setScript: mop)
		else
			(self x: 198 y: 159 loop: 0 setScript: mop)
		)
		(super init:)
	)
)

(instance bucket of Prop
	(properties
		noun 25
		modNum 530
		x 153
		y 136
		view 8538
		loop 1
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(= cel (Random 0 1))
		(= loop (Random 0 1))
		(super init:)
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

(instance light of View
	(properties
		x 153
		y 13
		view 530
		loop 1
		cel 1
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if 1
					(gGlobalSound1 number: 940 setLoop: -1 play:)
				)
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
				(if 1
					(gGlobalSound1 number: 939 setLoop: 1 play: self)
				else
					(= cycles 2)
				)
				(doors setCycle: End self)
			)
			(4)
			(5
				(if local1
					(mop cue:)
				else
					(chief setScript: yak self)
				)
			)
			(6
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
				(gTheIconBar disable: 0)
				(if local1
					(gTheDoits add: scott)
				)
			)
			(7
				(gTheDoits delete: scott)
				(if 1
					(gGlobalSound1 number: 938 setLoop: 1 play: self)
				else
					(= cycles 2)
				)
				(light dispose:)
				(doors setCycle: Beg self)
			)
			(8)
			(9
				(if local1
					(mop cue:)
				else
					(self cue:)
				)
			)
			(10
				(= ticks 240)
			)
			(11
				(gGlobalSound0 pause: 0)
				(self dispose:)
			)
		)
	)
)

