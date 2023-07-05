;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use Array)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	local0
)

(instance rm530 of Room
	(properties
		picture 530
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(sFx init:)
		(super init: &rest)
		(doors init: signal: (| (doors signal:) $4000))
		(wall init:)
		(hallMap init:)
		(floor init:)
		(elevatorLight init:)
		(elevator init:)
		(gGlobalSound0 fade: 127 4 2 0)
		(self setScript: sEnter)
		(if (gPqFlags test: 32)
			(lineUp doit:)
		else
			(= local0 1)
			(bucket init:)
			(scott init:)
		)
	)
)

(instance scott of Prop
	(properties
		noun 24
		view 8534
	)

	(method (init)
		(if (Random 0 1)
			(self x: 126 y: 157 loop: 1 setScript: mop)
		else
			(self x: 198 y: 159 loop: 0 setScript: mop)
		)
		(super init:)
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

(instance bucket of View
	(properties
		noun 25
		modNum 530
		x 153
		y 136
		view 8538
		loop 1
		cel 1
		signal 16384
	)

	(method (init)
		(= cel (Random 0 1))
		(= loop (Random 0 1))
		(super init:)
	)
)

(instance doors of Prop
	(properties
		x 125
		y 122
		view 530
		cycleSpeed 8
	)
)

(instance light of View
	(properties
		noun 15
		x 153
		y 13
		view 530
		loop 1
		cel 1
	)
)

(instance elevatorLight of Feature
	(properties
		noun 15
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
		nsLeft 36
		nsTop 131
		nsRight 283
		nsBottom 147
		sightAngle 360
		x 150
		y 101
	)
)

(instance hallMap of Feature
	(properties
		noun 18
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
		nsLeft 38
		nsRight 284
		nsBottom 148
		sightAngle 360
		x 150
		y 1
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
				(sFx number: 530 loop: 1 play:)
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

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if 1
					(gGlobalSound1 number: 940 loop: -1 play:)
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
				(gGlobalSound1 number: 942 loop: 1 play: self)
			)
			(3
				(if 1
					(gGlobalSound1 number: 939 loop: 1 play: self)
				else
					(= cycles 2)
				)
				(doors setCycle: End self)
			)
			(4)
			(5
				(if (gCast contains: scott)
					(mop cue:)
				else
					(gMessager sayRandom: 0 0 1 self 530)
				)
			)
			(6
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
				(if local0
					(gTheDoits add: scott)
				)
				(gTheIconBar disable: 0)
			)
			(7
				(if local0
					(gTheDoits delete: scott)
				)
				(if 1
					(gGlobalSound1 number: 938 loop: 1 play: self)
				else
					(= cycles 2)
				)
				(light dispose:)
				(doors setCycle: Beg self)
			)
			(8)
			(9
				(if (gCast contains: scott)
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

(instance lineUp of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp0 (IntArray new: 12))
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(temp0 at: temp1 temp1)
		)
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(= temp2 (Random 0 11))
			(= temp3 (temp0 at: temp1))
			(temp0 at: temp1 (temp0 at: temp2))
			(temp0 at: temp2 temp3)
		)
		(while temp1
			(-- temp1)
			(= temp2 (Random 0 11))
			(= temp3 (temp0 at: temp1))
			(temp0 at: temp1 (temp0 at: temp2))
			(temp0 at: temp2 temp3)
		)
		(= temp2 (Random 0 1))
		(= temp3 0)
		(while (< temp1 12)
			(if temp2
				(+= temp3 (+ 3 (CelWide 537 temp2 (temp0 at: temp1))))
				((View new:)
					view: 537
					loop: temp2
					cel: (temp0 at: temp1)
					noun: (+ 1 (temp0 at: temp1))
					signal: 4129
					x: temp3
					y: (+ 143 (- 5 (Random 0 10)))
					init:
				)
			else
				((View new:)
					view: 537
					loop: temp2
					cel: (temp0 at: temp1)
					noun: (+ 1 (temp0 at: temp1))
					x: temp3
					y: (+ 143 (- 5 (Random 0 10)))
					signal: 4129
					init:
				)
				(+= temp3 (+ 3 (CelWide 537 temp2 (temp0 at: temp1))))
			)
			(++ temp1)
		)
		(temp0 dispose:)
	)
)

(instance sFx of Sound
	(properties)
)

