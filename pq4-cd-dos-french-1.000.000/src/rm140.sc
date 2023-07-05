;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm140 0
	emmoTalker 1
	gangTalker 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm140 of Room
	(properties
		noun 19
		picture 140
	)

	(method (init)
		(if (== gPrevRoomNum 17) ; MapRoom
			(= style 9)
		else
			(= style 0)
		)
		(if (and (> gDay 2) (!= gPrevRoomNum 130) (!= gPrevRoomNum 150))
			(gGlobalSound1 number: 917 loop: 1 play:)
		)
		(if (< gDay 3)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 0 137 60 137 68 131 107 131 111 137 319 137 319 121 137 121 133 127 34 127 28 121 0 121
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 15 137 53 137 72 131 103 131 127 137 319 137 319 120 16 120
						yourself:
					)
			)
		)
		(leftDoor init: approachVerbs: 4) ; Do
		(super init: &rest)
		(switch gPrevRoomNum
			(6 ; speedRoom
				(if (< gDay 3)
					(gEgo setHeading: 270 posn: 180 135)
				else
					(gEgo x: 54 y: 136 setHeading: 0)
				)
				(gGlobalSound1 number: 130 loop: -1 play:)
			)
			(17 ; MapRoom
				(gEgo x: 54 y: 136 setHeading: 0)
				(gGlobalSound1 number: 130 loop: -1 play:)
			)
			(130
				(gEgo setHeading: 270 posn: 206 130)
			)
			(150
				(gEgo setHeading: 180 posn: 133 115)
			)
			(else
				(gEgo setHeading: 270 posn: 180 135)
				(gGlobalSound1 number: 130 loop: -1 play:)
			)
		)
		(gEgo
			setScaler: Scaler 87 55 152 115
			normalize: 0
			setPri: (if (== gPrevRoomNum 150) 55 else -1)
			init:
		)
		(if (< gDay 3)
			(proc0_4 1)
			(if (not (gPqPointFlags test: 37))
				(emmo
					init:
					signal: (| (emmo signal:) $4000)
					approachVerbs: 27 2 ; badge, Talk
				)
				(leftKid init: signal: (| (leftKid signal:) $4000))
				(leftKidLegs init: signal: (| (leftKidLegs signal:) $4000))
			)
		else
			(proc0_4 0)
			(car init:)
			(trunk init:)
		)
		(switch gPrevRoomNum
			(150
				(self setScript: from150Script)
			)
			(else
				(if (and (== gDay 2) (not (gPqFlags test: 134)))
					(gPqFlags set: 134)
					(exSpiff
						setCycle: Walk
						init:
						signal: (| (exSpiff signal:) $0800)
						setScript: spiffOutScript
					)
				else
					(gGame handsOn:)
				)
			)
		)
		(cafeDoor init:)
		(billboard init:)
		(rainbow init:)
		(field init:)
		(burnedBldg init:)
		(pole init:)
		(sidewalk init:)
		(sky init:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 222)
			(proc0_4 1)
			(gCurRoom newRoom: 130)
		)
		(if (and (not script) (< (gEgo x:) 5))
			(gGame handsOff:)
			(self setScript: noExitScr)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= gDay 3) (OneOf newRoomNumber 130 150))
			(proc0_4 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance noExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(gMessager say: 0 75 0 0 self) ; "Don't wander off. You have an investigation to complete."
			)
			(2
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance spiffOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(exSpiff setMotion: MoveTo -22 133 self)
			)
			(1
				(gGame handsOn:)
				(exSpiff dispose:)
			)
		)
	)
)

(instance exSpiff of Actor
	(properties
		x 65
		y 133
		view 1408
	)
)

(instance exitDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(leftDoor setCycle: End self)
			)
			(2
				(= ticks 10)
			)
			(3
				(gEgo setMotion: MoveTo 138 115 self)
			)
			(4
				(gEgo setPri: (- (leftDoor priority:) 1))
				(leftDoor setCycle: Beg self)
			)
			(5
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance from150Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 fade: 0 3 5 1)
				(gGame handsOff:)
				(leftDoor setCycle: End self)
			)
			(1
				(gGlobalSound1 number: 130 loop: -1 play:)
				(gEgo setMotion: MoveTo 138 122 self)
			)
			(2
				(gEgo setPri: -1)
				(leftDoor setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance emmo of Actor
	(properties
		noun 7
		approachX 137
		approachY 129
		approachDist 20
		x 114
		y 125
		view 140
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(self setScript: emmoScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (gPqPointFlags test: 17)
					(cond
						((> local2 3)
							(if (not (gPqPointFlags test: 37))
								(gGame points: 4 37)
							)
							(gMessager say: 7 2 10 0) ; "If you can think of anything that might help us, why don't you give me a call down at Parker Center. Just ask for Robbery Homicide, Detective Carey."
						)
						((== local2 3)
							(gMessager say: 7 2 14 0) ; "You a big baseball fan? I see you've got a baseball."
						)
						((== local2 2)
							(gMessager say: 7 2 15 0) ; "Did you know Bobby Washington?"
						)
						((== local2 1)
							(gMessager say: 7 2 13 0) ; "Last night there was a double murder... a police officer and a neighborhood boy, Bobby Washington. Do you know anything that might help us solve what happened to them?"
						)
						((not local2)
							(gPqPointFlags set: 9)
							(gMessager say: 7 2 7 0) ; "I'd like to ask you fellas a couple of questions."
						)
					)
					(++ local2)
				else
					(switch local1
						(0
							(gMessager say: 7 2 6 0) ; "I'd like to ask you fellas a couple of questions."
						)
						(else
							(gMessager say: 7 2 12 0) ; "This is a serious matter. I'm investigating the murder of a police officer and a young boy. I'd like to ask you and your friend some questions."
						)
					)
					(++ local1)
				)
			)
			(57 ; photo
				(if (gPqPointFlags test: 17)
					(gMessager say: 7 57 7) ; "Can you tell me if you recognize the man in this photograph?"
				else
					(gMessager say: 7 57 6) ; "I was wondering if you recognize this man in the photo?"
				)
			)
			(27 ; badge
				(if (gPqPointFlags test: 17)
					(gMessager say: 7 27 7 0) ; "Carey, once is enough."
				else
					(gGame handsOff:)
					(gCurRoom setScript: badgeScript 0 self)
				)
			)
			(52 ; notebook
				(cond
					(local4
						(gMessager say: 2 52 4 0) ; "Recording information twice is unnecessary, Detective."
					)
					((not (gPqPointFlags test: 17))
						(gMessager say: noun theVerb 6) ; "What is it you wish to record, Detective?"
					)
					(else
						(if (not (gPqPointFlags test: 38))
							(gGame points: 2 38)
						)
						(gGame handsOff:)
						(gCurRoom setScript: notebookScr 0 self)
					)
				)
			)
			(4 ; Do
				(gMessager say: 7 4 (if (gPqPointFlags test: 17) 7 else 6) 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftKid of Actor
	(properties
		noun 8
		approachX 73
		approachY 130
		approachDist 20
		x 53
		y 100
		priority 124
		fixPriority 1
		view 148
		loop 1
	)

	(method (init)
		(super init:)
		(self setScript: kidScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; badge
				(if local0
					(gMessager say: noun 27 7) ; "Second identification is unnecessary, Carey."
				else
					(gGame handsOff:)
					(if (not (gPqPointFlags test: 39))
						(gGame points: 2 39)
					)
					(gCurRoom setScript: badgeScript 0 self)
				)
			)
			(52 ; notebook
				(cond
					(local5
						(gMessager say: 2 52 4 0) ; "Recording information twice is unnecessary, Detective."
					)
					((not local0)
						(gMessager say: noun theVerb 6) ; "What have you learned worth recording, Detective?"
					)
					(else
						(if (not (gPqPointFlags test: 40))
							(gGame points: 2 40)
						)
						(gGame handsOff:)
						(gCurRoom setScript: notebookScr 0 self)
					)
				)
			)
			(2 ; Talk
				(cond
					((not local0)
						(gMessager say: noun theVerb 6) ; "Are you interested in talking?"
					)
					((== local3 0)
						(++ local3)
						(gMessager say: noun theVerb 7) ; "Son, what is your name?"
					)
					((== local3 1)
						(++ local3)
						(gMessager say: noun theVerb 13) ; "Herbie, do you know anything that might help us solve last night's double murder?"
					)
					(else
						(gMessager say: noun theVerb 15) ; "Can't think of anyone who might have wanted to see Bobby or the police officer hurt?"
					)
				)
			)
			(4 ; Do
				(gMessager say: 8 4 (if local0 7 else 6) 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftKidLegs of Actor
	(properties
		noun 8
		x 53
		y 123
		view 148
	)

	(method (doVerb theVerb)
		(leftKid doVerb: theVerb)
	)
)

(instance emmoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(emmo
					view: 140
					cycleSpeed: 8
					setLoop: 0
					cel: 0
					posn: 114 125
					setCycle: CT 11 1 self
				)
			)
			(2
				(emmo setCycle: End self)
			)
			(3
				(emmo setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 10)
			)
			(5
				(emmo view: 141 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(emmo setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(= ticks 100)
			)
			(8
				(emmo view: 142 setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(emmo setLoop: 1 cel: 0)
				(= ticks 20)
			)
			(10
				(emmo setCycle: End self)
			)
			(11
				(emmo view: 143 setLoop: 0 cel: 0 setCycle: End self)
			)
			(12
				(emmo setLoop: 1 cel: 0 setCycle: End self)
			)
			(13
				(= ticks 20)
			)
			(14
				(emmo view: 144 setLoop: 0 cel: 0 setCycle: End self)
			)
			(15
				(emmo setLoop: 1 cel: 0 setCycle: End self)
			)
			(16
				(= ticks 60)
				(= state 0)
			)
		)
	)
)

(instance kidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(leftKid setCycle: End self)
			)
			(2
				(= seconds (Random 2 4))
			)
			(3
				(leftKid setCycle: Beg self)
			)
			(4
				(= cycles 1)
			)
			(5
				(leftKidLegs dispose:)
				(leftKid setLoop: 2 posn: 53 123 setCycle: End self)
				(UpdateScreenItem leftKid)
			)
			(6
				(leftKid setCycle: Beg self)
			)
			(7
				(= seconds (Random 3 6))
			)
			(8
				(leftKid setLoop: (Random 4 5) posn: 53 100 setCycle: End self)
				(leftKidLegs setLoop: 3 init:)
			)
			(9
				(= seconds (Random 2 4))
			)
			(10
				(leftKid setCycle: Beg self)
				(= state 4)
			)
		)
	)
)

(instance notebookScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(Face gEgo register self)
			)
			(2
				(= cycles 1)
			)
			(3
				((ScriptID 39 0) init: self) ; NotebookOut
			)
			(4
				(if (== register leftKid)
					(= local5 1)
					(gMessager say: 8 52 7 0 self) ; "Do you live around here, son?"
				else
					(= local4 1)
					(gMessager say: 7 52 7 0 self) ; "What's your name, young man?"
				)
			)
			(5
				((ScriptID 39 1) init: self) ; NotebookIn
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance badgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(Face gEgo register self)
			)
			(2
				(= cycles 1)
			)
			(3
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(4
				(= seconds 2)
			)
			(5
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(6
				(if (== register leftKid)
					(= local0 1)
					(gMessager say: 8 27 0 0 self) ; "I'm Detective Carey, LAPD."
				else
					(gGame points: 2 17)
					(gMessager say: 7 27 0 0 self) ; "I'm Detective Carey, LAPD, Homicide."
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance car of View
	(properties
		noun 12
		x 173
		y 152
		view 149
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 17) ; MapRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trunk of Feature
	(properties
		noun 17
		nsLeft 236
		nsTop 118
		nsRight 260
		nsBottom 135
		sightAngle 40
		approachX 248
		approachY 126
		approachDist 0
		x 248
		y 153
		z 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; keys
				(gCurRoom setScript: toTrunkScript)
			)
			(4 ; Do
				(gMessager say: 17 4 0 0) ; "The trunk to your car is locked, Carey."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 210 137 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance leftDoor of Prop
	(properties
		noun 16
		approachX 144
		approachY 120
		x 119
		y 56
		view 145
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: exitDoorScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance billboard of Feature
	(properties
		noun 1
		nsLeft 8
		nsTop 52
		nsRight 37
		nsBottom 70
		sightAngle 40
		x 22
		y 61
	)
)

(instance rainbow of Feature
	(properties
		noun 4
		nsLeft 222
		nsRight 319
		nsBottom 115
		sightAngle 40
		x 270
		y 57
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gDay 2)
					(gMessager say: 4 1 1 0) ; "This colorful cafe adds a little charm to this old neighborhood..."
				else
					(gMessager say: 4 1 3 0) ; "The cafe has been closed down. The sting operation foiled..."
				)
			)
			(29 ; coins
				(if (== gDay 2)
					(gMessager say: 4 29 1 0) ; "There's no toll here, Carey..."
				else
					(gMessager say: 4 29 3 0) ; "They might only be coins, Carey, but they add up to dollars..."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cafeDoor of Feature
	(properties
		noun 5
		nsLeft 240
		nsTop 66
		nsRight 261
		nsBottom 116
		sightAngle 40
		x 250
		y 91
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gDay 2)
					(gMessager say: 5 1 1 0) ; "It's the doorway to enchilada heaven, Carey."
				else
					(gMessager say: 5 1 3 0) ; "The door's been locked and sealed by the CRASH unit, Detective."
				)
			)
			(4 ; Do
				(if (== gDay 2)
					(gCurRoom setScript: toCafeScr)
				else
					(gMessager say: 5 4 3 0) ; "The door is locked, Carey. The sting operation has closed down."
				)
			)
			(22 ; handgun
				(if (== gDay 2)
					(gMessager say: 5 22 1 0) ; "Holster your weapon immediately, Detective..."
				else
					(gMessager say: 5 22 3 0) ; "You have no cause, or reason to shoot up the door, Detective."
				)
			)
			(46 ; keys
				(if (== gDay 2)
					(gMessager say: 5 46 1 0) ; "You don't have keys to this cafe, Detective..."
				else
					(gMessager say: 5 46 3 0) ; "It's locked, Carey... and you don't have a key."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toCafeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqFlags set: 159)
				(gEgo setMotion: PolyPath 220 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance field of Feature
	(properties
		noun 6
		nsLeft 1
		nsTop 83
		nsRight 46
		nsBottom 117
		sightAngle 40
		x 23
		y 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== gDay 2)
					(gMessager say: 6 1 1 0) ; "This field has been burned to the ground..."
				else
					(gMessager say: 6 1 3 0) ; "This field has been witness to violence and pain..."
				)
			)
			(4 ; Do
				(if (== gDay 2)
					(gMessager say: 6 4 1 0) ; "Carey, you have better things to do than go on a scavenger hunt."
				else
					(gMessager say: 6 4 3 0) ; "SID has swept the area clean,Carey. All that remains are memories."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance burnedBldg of Feature
	(properties
		noun 2
		nsLeft 48
		nsTop 33
		nsRight 222
		nsBottom 115
		sightAngle 40
		x 135
		y 50
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; caseBaggies
				(if (== gDay 2)
					(gMessager say: 2 13 1 0) ; "The area looks clean of any known evidence, Detective..."
				else
					(gMessager say: 2 13 3 0) ; "SID has already been here and swept the area clean, Detective..."
				)
			)
			(4 ; Do
				(if (== gDay 2)
					(gMessager say: 2 4 1 0) ; "The stone is rough, the concrete hot."
				else
					(gMessager say: 2 4 3 0) ; "The stone is chipped and bruised from the pelleting of the fire fight."
				)
			)
			(22 ; handgun
				(if (== gDay 2)
					(gMessager say: 2 22 1 0) ; "Shooting up old buildings is a criminal offense. Remember your oath."
				else
					(gMessager say: 2 22 3 0) ; "Unnecessary use of force, Carey. Put the gun away."
				)
			)
			(52 ; notebook
				(cond
					((== gDay 2)
						(gMessager say: 2 52 1 0) ; "There is nothing noteworthy about this building, Carey..."
					)
					((not (gPqPointFlags test: 26))
						(gPqPointFlags set: 26)
						(gMessager say: 2 52 3 0) ; "Field notes are an effective investigative tool, Detective..."
					)
					(else
						(gMessager say: 2 52 4 0) ; "Recording information twice is unnecessary, Detective."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pole of Feature
	(properties
		noun 14
		nsLeft 80
		nsRight 92
		nsBottom 136
		x 86
		y 135
	)
)

(instance sidewalk of Feature
	(properties
		noun 18
		nsTop 117
		nsRight 319
		nsBottom 149
		sightAngle 40
		x 159
		y 117
	)
)

(instance sky of Feature
	(properties
		noun 20
		x 1
		y 1
	)

	(method (init)
		(self
			createPoly: 0 0 222 0 220 32 46 31 45 67 38 67 38 52 8 51 7 64 0 64
		)
		(super init:)
	)
)

(instance careyTalker of Narrator ; UNUSED
	(properties
		x 110
		y 10
		modeless 2
	)
)

(instance emmoTalker of Narrator
	(properties
		x 75
		y 10
		modeless 2
	)
)

(instance gangTalker of Narrator
	(properties
		x 5
		y 10
		modeless 2
	)
)

