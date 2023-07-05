;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
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
	rm570 0
)

(local
	local0
)

(instance rm570 of Room
	(properties
		picture 570
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 178 89 166 89 148 140 190 140
					yourself:
				)
		)
		(switch gDay
			(2
				(if (and (gPqFlags test: 32) (not (gPqFlags test: 29)))
					(= global145 1)
					(gPqFlags set: 148)
					(crim init:)
				else
					(gGame handsOn:)
					(gPqFlags clear: 148)
				)
			)
			(3
				(cond
					((not (gPqFlags test: 136))
						(gPqFlags set: 111)
						(= global145 2)
						(gPqFlags set: 148)
						(crim init:)
					)
					(
						(and
							(gPqFlags test: 139)
							(== ((gInventory at: 11) owner:) 580) ; handgun
						)
						(= global145 3)
						(gPqFlags set: 148)
						(crim init:)
					)
					((gEgo has: 11) ; handgun
						(gPqFlags clear: 148)
						(gGame handsOn:)
					)
					(else
						(= global145 3)
						(gPqFlags set: 148)
						(crim init:)
					)
				)
			)
			(4
				(cond
					((not (gPqFlags test: 141))
						(= global145 5)
					)
					((gPqFlags test: 150)
						(= global145 7)
					)
					(else
						(= global145 6)
					)
				)
				(gPqFlags set: 148)
				(crim init:)
			)
			(5
				(if (gPqFlags test: 140)
					(cond
						((gPqFlags test: 101)
							(gGame handsOn:)
							(gPqFlags clear: 148)
						)
						((gPqFlags test: 151)
							(= global145 10)
							(gPqFlags set: 148)
							(crim init:)
						)
						(else
							(= global145 9)
							(gPqFlags set: 148)
							(crim init:)
						)
					)
				else
					(= global145 8)
					(gPqFlags set: 148)
					(crim init:)
				)
			)
		)
		(elevator init:)
		(buttons init: approachVerbs: 4) ; Do
		(hallSign init:)
		(floor init:)
		(hallDesk init:)
		(chairs init:)
		(door init:)
		(doors init:)
		(doubleDoors init:)
		(wall init:)
		(self setScript: sEnter)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 580)
			(if (!= (gGlobalSound0 number:) 983)
				(gGlobalSound0 number: 983 loop: -1 play:)
			)
			(gGlobalSound1 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (!= script sEnter) (<= (gEgo y:) 90))
			(gCurRoom newRoom: 580)
			(return)
		)
	)
)

(instance elevator of Feature
	(properties
		noun 8
		nsLeft 191
		nsTop 34
		nsRight 242
		nsBottom 122
		sightAngle 40
		x 216
		y 70
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 27 38 29 4 17 63) ; badge, caseChalk, coins, Do, glue, casePryBar
				(gMessager say: noun theVerb 1 0)
			)
			((OneOf theVerb 22 1) ; handgun, Look
				(gMessager
					say: noun theVerb (if (gCast contains: light) 2 else 1) 0
				)
			)
			((== theVerb 2) ; Talk
				(if (gCast contains: light)
					(gMessager say: noun theVerb 2 0) ; "The elevator is vacant of passengers. There's no one to talk to."
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

(instance crim of View
	(properties
		noun 3
		x 164
		y 68
		view 572
	)
)

(instance light of View
	(properties
		x 202
		y 26
		view 570
	)
)

(instance doors of Prop
	(properties
		x 207
		y 60
		fixPriority 1
		view 570
		loop 1
	)
)

(instance buttons of Feature
	(properties
		noun 6
		nsLeft 211
		nsTop 66
		nsRight 215
		nsBottom 83
		sightAngle 40
		approachX 200
		approachY 139
		approachDist 0
		x 213
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 0)
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

(instance chairs of Feature
	(properties
		noun 2
		x 50
		y 147
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 110 89 111 87 114 86 117 86 116 84 118 83 122 82 130 87 137 88 139 89 140 96 145 98 143 114 138 126 115 124 115 106 110 96 109 91
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 65 115 78 115 86 119 104 120 109 123 106 131 105 135 106 139 117 139 120 140 114 147 68 147 58 118 60 116
					yourself:
				)
		)
	)
)

(instance hallDesk of Feature
	(properties
		noun 9
		x 50
		y 128
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 138 76 159 76 159 92 156 104 145 104 145 96 141 94 141 86 131 84 128 84 128 79
					yourself:
				)
		)
	)
)

(instance floor of Feature
	(properties
		noun 10
		x 150
		y 78
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 161 78 175 78 217 148 119 147 124 140 122 137 108 136 112 130 141 129 149 117 157 107 161 94
					yourself:
				)
		)
	)
)

(instance hallSign of Feature
	(properties
		noun 7
		x 70
		y 60
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PBarredAccess init: 62 48 81 49 82 60 61 60 yourself:)
		)
	)
)

(instance doubleDoors of Feature
	(properties
		noun 5
		sightAngle 45
		x 95
		y 140
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 84 23 100 29 100 118 87 118 85 116
					yourself:
				)
		)
	)
)

(instance wall of Feature
	(properties
		noun 4
		nsLeft 36
		nsRight 284
		nsBottom 148
		x 150
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 156
		nsTop 49
		nsRight 172
		nsBottom 76
		x 164
		y 60
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 580)
					(gEgo
						x: 170
						y: 92
						heading: 180
						normalize: 0
						setScaler: Scaler 116 33 137 81
						init:
						setMotion: PolyPath 170 105 self
					)
				else
					(gEgo
						x: 229
						y: 121
						heading: 170
						normalize: 0
						setScaler: Scaler 116 33 137 81
						init:
					)
					(= local0 1)
					(self setScript: elevatorArrive self)
				)
			)
			(1
				(if (== gPrevRoomNum 580)
					(gGlobalSound0 number: 983 play:)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 185 120 self)
				)
			)
			(2
				(= local0 0)
				(self setScript: elevatorLeave self)
			)
			(3
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
				(gEgo setMotion: MoveTo 197 120 self)
			)
			(1
				(gEgo setHeading: 90)
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
					(gGame handsOff:)
					(= local0 0)
					(gEgo setMotion: MoveTo 170 121 self)
				else
					(self setScript: elevatorLeave self)
				)
			)
			(5
				(if register
					(= local0 (= register 0))
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
					(gGlobalSound1 number: 940 loop: -1 play:)
				)
				(= ticks (Random 200 400))
			)
			(1
				(light init:)
				(= cycles 1)
			)
			(2
				(gGlobalSound1 number: 942 loop: 1 play: self)
			)
			(3
				(= ticks 150)
			)
			(4
				(if (not (OneOf (gGlobalSound0 number:) 520 521 522))
					(gGlobalSound0
						number: (Random 520 522)
						loop: -1
						play:
						setVol: 0
						fade: 127 4 2 0
					)
				)
				(gGlobalSound1 number: 939 loop: 1 play: self)
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
							init: 178 89 166 89 148 140 203 140 194 121 237 121 237 116 192 116
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
				(gEgo setMotion: PolyPath 235 120 self)
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
								init: 178 89 166 89 148 140 190 140
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
				(gGlobalSound1 number: 938 loop: 1 play: self)
				(doors setCycle: Beg self)
			)
			(2)
			(3
				(light dispose:)
				(if 1
					(gGlobalSound1 number: 940 loop: -1 play:)
				)
				(if (not local0)
					(gGlobalSound0 number: 0 stop:)
					(gGame handsOn:)
				)
				(= ticks 90)
			)
			(4
				(if (not local0)
					(gGlobalSound0 number: 983 loop: -1 play:)
					(gGlobalSound1 number: 0 stop:)
				)
				(self dispose:)
			)
		)
	)
)

