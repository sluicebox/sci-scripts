;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 512)
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
	rm512 0
)

(local
	local0
)

(instance rm512 of Room
	(properties
		noun 7
		picture 512
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 148 83 127 130 203 130 180 83
					yourself:
				)
		)
		(elevator init:)
		(trashCan init:)
		(floor init:)
		(hallPhoto init:)
		(endDoor init:)
		(doors init:)
		(buttons init: approachVerbs: 4) ; Do
		(self setScript: sEnter)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 515)
			(if (!= (gGlobalSound0 number:) 983)
				(gGlobalSound0 number: 983 setLoop: -1 play:)
			)
			(gGlobalSound1 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (<= (gEgo y:) 95)
			(gCurRoom newRoom: 515)
			(return)
		)
	)
)

(instance doors of Prop
	(properties
		x 118
		y 56
		fixPriority 1
		view 513
		loop 1
	)
)

(instance elevator of Feature
	(properties
		noun 3
		nsLeft 53
		nsTop 19
		nsRight 135
		nsBottom 114
		sightAngle 40
		approachX 84
		approachY 68
		approachDist 0
		x 84
		y 68
	)

	(method (doVerb theVerb)
		(cond
			((== (gCurRoom script:) doElevator)
				(if (Message msgSIZE 512 noun theVerb 1 1)
					(gMessager say: noun theVerb 1 0)
				else
					(super doVerb: theVerb)
				)
			)
			((Message msgSIZE 512 noun theVerb 2 1)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttons of Feature
	(properties
		noun 4
		nsLeft 107
		nsTop 68
		nsRight 113
		nsBottom 76
		sightAngle 40
		approachX 122
		approachY 126
		approachDist 0
		x 112
		y 129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gCurRoom script:) doElevator)
					(super doVerb: theVerb)
				else
					(= local0 1)
					(gMessager say: noun theVerb 3) ; "Pressing the button, you call the elevator."
					(gCurRoom setScript: doElevator)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance endDoor of Feature
	(properties
		noun 6
		nsLeft 154
		nsTop 40
		nsRight 174
		nsBottom 78
		x 164
		y 64
	)
)

(instance hallPhoto of Feature
	(properties
		noun 1
		nsLeft 48
		nsTop 31
		nsRight 70
		nsBottom 54
		x 59
		y 69
	)
)

(instance trashCan of Feature
	(properties
		noun 2
		x 69
		y 135
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 55 81 75 81 79 89 78 131 73 135 55 135 51 92
					yourself:
				)
		)
	)
)

(instance floor of Feature
	(properties
		noun 5
		x 145
		y 146
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 145 79 183 79 229 147 37 147 36 130 109 132
					yourself:
				)
		)
	)
)

(instance light of View
	(properties
		x 120
		y 22
		view 513
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 515)
					(gEgo
						x: 168
						y: 96
						heading: 180
						normalize: 0
						setScaler: Scaler 140 43 154 79
						init:
						setMotion: PolyPath 168 115 self
					)
				else
					(gEgo
						x: 93
						y: 110
						heading: 270
						normalize: 0
						setScaler: Scaler 140 43 154 79
						init:
					)
					(= local0 1)
					(self setScript: elevatorArrive self)
				)
			)
			(1
				(if (== gPrevRoomNum 515)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 155 110 self)
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
				(gEgo setMotion: MoveTo 130 111 self)
			)
			(1
				(gEgo setHeading: 270)
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
					(gEgo setMotion: MoveTo 140 110 self)
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
				(doors setCycle: End self)
			)
			(5)
			(6
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 148 83 135 110 91 110 91 114 134 114 127 130 203 130 180 83
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
				(gEgo setMotion: PolyPath 93 110 self)
			)
			(1
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
								init: 148 83 127 130 203 130 180 83
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
				(if (not local0)
					(gGlobalSound0 fade: 0 2 1 1)
				)
				(gGlobalSound1 number: 938 setLoop: 1 play: self)
				(doors setCycle: Beg self)
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

