;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 525)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm525 0
)

(local
	local0
)

(instance rm525 of Room
	(properties
		modNum 530
		picture 530
	)

	(method (init)
		(super init: &rest)
		(buttons init: approachVerbs: 4) ; Do
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 34 146 284 146 284 135 36 135
					yourself:
				)
		)
		(doors init: signal: (| (doors signal:) $4000))
		(wall init:)
		(hallMap init:)
		(floor init:)
		(elevatorLight init:)
		(elevator init:)
		(self setScript: sEnter)
	)

	(method (newRoom newRoomNumber)
		(gEgo stopView: 5)
		(if (== newRoomNumber 535)
			(if (!= (gGlobalSound0 number:) 983)
				(gGlobalSound0 number: 983 setLoop: -1 play:)
			)
			(gGlobalSound1 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= script sEnter)
			(cond
				((>= (gEgo x:) 284)
					(gPqFlags set: 31)
					(gCurRoom newRoom: 535)
				)
				((<= (gEgo x:) 37)
					(gCurRoom newRoom: 535)
				)
			)
		)
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
		y 123
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

(instance buttons of Feature
	(properties
		noun 16
		modNum 530
		nsLeft 73
		nsTop 68
		nsRight 79
		nsBottom 84
		sightAngle 40
		approachX 73
		approachY 137
		approachDist 0
		x 76
		y 76
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 0)
				(if (!= (gCurRoom script:) doElevator)
					(= local0 1)
					(gMessager say: noun 4 6 0 0 530) ; "You call the elevator."
					(gCurRoom setScript: doElevator)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doors of Prop
	(properties
		noun 14
		modNum 530
		x 125
		y 122
		view 530
		cycleSpeed 10
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

(instance light of View
	(properties
		noun 15
		modNum 530
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
				(gEgo stopView: 9125)
				(if (== gPrevRoomNum 535)
					(if (gPqFlags test: 31)
						(gPqFlags clear: 31)
						(gEgo
							heading: 270
							normalize: 9120
							x: 283
							y: 140
							setScaler: Scaler 100 69 147 106
							init:
							setMotion: MoveTo 250 140 self
						)
					else
						(gEgo
							heading: 90
							normalize: 9120
							x: 37
							y: 140
							setScaler: Scaler 100 69 147 106
							init:
							setMotion: MoveTo 50 140 self
						)
					)
				else
					(gEgo
						heading: 180
						normalize: 9120
						x: 152
						y: 116
						setScaler: Scaler 100 69 147 106
						init:
					)
					(= local0 1)
					(self setScript: elevatorArrive self)
				)
				(gEgo origStep: 2052)
			)
			(1
				(if (== gPrevRoomNum 535)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 151 138 self)
				)
			)
			(2
				(= local0 0)
				(self setScript: elevatorLeave self)
			)
			(3
				(gGlobalSound0 number: 983 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 155 133 self)
			)
			(1
				(gEgo setHeading: 0)
				(self setScript: elevatorArrive self)
			)
			(2
				(self setScript: getInElevator self)
			)
			(3
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
			)
			(4
				(if register
					(= local0 0)
					(gGame handsOff:)
					(gEgo setMotion: MoveTo 151 138 self)
				else
					(self setScript: elevatorLeave self)
				)
			)
			(5
				(if register
					(= register 0)
					(= local0 0)
					(self setScript: elevatorLeave self)
					(gGame handsOn:)
				else
					(self dispose:)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance elevatorArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(doors priority: 14)
				else
					(doors priority: 0)
				)
				(if 1
					(gGlobalSound1 number: 940 setLoop: -1 play:)
				)
				(= ticks (Random 200 400))
			)
			(1
				(light init:)
				(= cycles 1)
			)
			(2
				(gGlobalSound1 number: 942 setLoop: 1 play: self)
			)
			(3
				(= ticks 150)
			)
			(4
				(doors setCycle: End self)
				(if (not (OneOf (gGlobalSound0 number:) 520 521 522))
					(gGlobalSound0
						number: (Random 520 522)
						setLoop: -1
						setVol: 0
						play:
						fade: 127 4 2 0
					)
				)
				(gGlobalSound1 number: 939 setLoop: 1 play: self)
			)
			(5)
			(6
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 34 146 284 146 284 135 173 135 173 106 138 106 138 135 36 135
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance getInElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 152 116 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance elevatorLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 34 146 284 146 284 135 36 135
								yourself:
							)
					)
					(gGame handsOn:)
				else
					(proc0_4 1)
					(gGame handsOff:)
				)
				(= cycles 3)
			)
			(1
				(doors priority: (if local0 14 else 0) setCycle: Beg self)
				(if (not local0)
					(gGlobalSound0 fade: 0 2 1 1)
				)
				(gGlobalSound1 number: 938 setLoop: 1 play: self)
			)
			(2)
			(3
				(light dispose:)
				(if 1
					(gGlobalSound1 number: 940 setLoop: -1 play:)
				)
				(if (not local0)
					(gGlobalSound0 stop: number: 0)
					(gGame handsOn:)
					(= ticks 150)
				else
					(= ticks 150)
				)
			)
			(4
				(if (not local0)
					(gGlobalSound0 number: 983 setLoop: -1 play:)
					(gGlobalSound1 stop:)
				)
				(self dispose:)
			)
		)
	)
)

