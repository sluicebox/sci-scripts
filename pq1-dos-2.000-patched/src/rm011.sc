;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Grooper)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm011 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 27] = [103 85 123 96 7 0 139 98 5 213 137 239 152 8 1 231 154 5 266 123 329 114 0 0 0 0 0]
	[local33 27] = [7 0 5 139 98 123 96 97 77 8 1 5 231 154 239 152 213 145 0 0 0 329 114 329 114 266 123]
)

(instance rm011 of PQRoom
	(properties
		noun 3
		picture 111
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(gEgo get: 3) ; Patrol_Car_Keys
		)
		(= global224 {Saturday, August 15, 1992})
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 186 64 256 93 125 131 93 131 49 112 51 98
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 0 94 0 189 193 189 157 165 319 120 319 112 300 116 260 96 260 87 218 66 258 55 273 64 319 57 319 37 221 63 199 50 106 72 81 58 26 72 41 83
					yourself:
				)
		)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(= local0
			(switch global207
				(914 0)
				(105 9)
				(104 18)
			)
		)
		(and (!= global206 0) (== local4 32))
		(gEgo init:)
		(car1 addToPic:)
		(car2 addToPic:)
		(car3 addToPic:)
		(fDrain init:)
		(fMat init:)
		(fPole init:)
		(fWall init:)
		(glassDoor1 init:)
		(gLongSong number: 110 loop: -1 play:)
		(if (!= gPrevRoomNum 12)
			(= local2 1)
			(gEgo
				view: [local33 local0]
				loop: [local33 (+ local0 1)]
				cel: [local33 (+ local0 2)]
				posn: [local33 (+ local0 3)] [local33 (+ local0 4)]
				setPri: 5
				setCycle: 0
			)
			(if (== global211 62)
				(laura init:)
				(= local3 lauraStuff)
				(self setScript: getOutCar)
			else
				(self setScript: startInCar)
			)
		else
			(= local2 0)
			(gEgo posn: 10 19)
			(self setScript: fromHall)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					local2
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(event claimed: 1)
				(switch local0
					(0
						(car1 doVerb: 4)
					)
					(9
						(car2 doVerb: 4)
					)
					(18
						(car3 doVerb: 4)
					)
				)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance startInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lauraStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270)
				(laura setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self)
			)
			(1
				(Face laura gEgo self)
			)
			(2
				(if (IsFlag 169)
					(gMessager say: 12 2 2 0 self) ; "Alright, Sonny. You got the warrant. Good job! Boy, this'll be a feather in your cap."
				else
					(gMessager say: 12 2 3 0 self) ; "Too bad you weren't able to secure the No Bail Warrant, Sonny. That really would have been a feather in your cap. Oh, well. Since it was your first action since joining the unit, I don't think Morgan will come down too hard on you. Better luck next time."
				)
			)
			(3
				(gMessager say: 12 2 4 0 self) ; "Sonny, we got an anonymous tip that a drug deal is going down at Bert's Park. We've got to get over there."
			)
			(4
				(laura setMotion: DPath 267 79 285 56 333 56 self)
				(= local0 18)
				(self setScript: getInCar self)
			)
			(5)
			(6
				(self dispose:)
			)
		)
	)
)

(instance bounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 1)
				(gEgo setMotion: 0)
				(gMessager say: 8 0 5 0 self) ; "You haven't been on foot patrol for years. Use a car!"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 111)
				(gEgo setMotion: PolyPath 43 51 self)
				(glassDoor1 startUpd:)
			)
			(1
				(gLongSong2 number: 111 loop: 1 play:)
				(glassDoor1 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 72 75 self)
			)
			(3
				(gLongSong2 play:)
				(glassDoor1 setCycle: Beg self)
			)
			(4
				(glassDoor1 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 111)
				(gEgo setMotion: PolyPath 60 66 self)
				(glassDoor1 startUpd:)
			)
			(1
				(gLongSong2 number: 111 loop: 1 play:)
				(glassDoor1 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 43 51 self)
			)
			(3
				(gLongSong2 play:)
				(glassDoor1 setCycle: Beg self)
			)
			(4
				(glassDoor1 stopUpd:)
				(gEgo setMotion: MoveTo 15 19 self)
			)
			(5
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(switch local0
					(0
						(= global207 914)
						(= register door1)
					)
					(9
						(= global207 105)
						(= register door2)
					)
					(18
						(= register 0)
						(= global207 104)
					)
				)
				(gEgo
					setMotion:
						PolyPath
						[local6 (+ local0 0)]
						[local6 (+ local0 1)]
						self
				)
			)
			(1
				(gLongSong2 number: 900 loop: 1 play: self)
			)
			(2
				(if register
					(register startUpd: setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					setPri: 5
					setMotion:
						MoveTo
						[local6 (+ local0 2)]
						[local6 (+ local0 3)]
						self
				)
			)
			(4
				(gEgo setHeading: 135 self)
			)
			(5
				(gEgo
					view: [local6 (+ local0 4)]
					loop: [local6 (+ local0 5)]
					cel: 0
					posn: [local6 (+ local0 6)] [local6 (+ local0 7)]
					setCycle: CT [local6 (+ local0 8)] 1 self
				)
			)
			(6
				(if register
					(register setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(7
				(gLongSong2 number: 901 loop: 1 play: self)
			)
			(8
				(if (OneOf global211 2 31 40 54 62 73 81 92)
					(++ global211)
				)
				(if (not (gEgo has: 0)) ; Service_Revolver
					(SetFlag 85)
				else
					(ClearFlag 85)
				)
				(gCurRoom newRoom: 500)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getOutCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf global211 27 37 50 61 72 77 84 88)
					(++ global211)
				)
				(= local2 0)
				(switch local0
					(0
						(= register door1)
					)
					(9
						(= register door2)
					)
					(18
						(= register 0)
					)
				)
				(gLongSong2 number: 900 loop: 1 play: self)
			)
			(1
				(if register
					(register startUpd: setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo -1 2)
				(gEgo
					setPri: 5
					posn: [local33 (+ local0 5)] [local33 (+ local0 6)]
					setMotion:
						MoveTo
						[local33 (+ local0 7)]
						[local33 (+ local0 8)]
						self
				)
			)
			(4
				(if register
					(register setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(5
				(gLongSong2 number: 901 loop: 1 play: self)
			)
			(6
				(gEgo setPri: -1 setHeading: 180 self)
			)
			(7
				(if register
					(register stopUpd:)
				)
				(if local3
					(= next local3)
					(= local3 0)
					(= local0 local1)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance car1 of View
	(properties
		x 170
		y 100
		noun 9
		view 103
		loop 1
		cel 1
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(door1 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo has: 3)) ; Patrol_Car_Keys
						(gMessager say: noun 4 7 0) ; "You'll need keys for that."
					)
					((!= global206 0)
						(gMessager say: noun 4 8 0) ; "Only uniformed officers can use the patrol car, Bonds."
					)
					(local2
						(if (!= local0 0)
							(= local3 getInCar)
							(= local1 0)
						)
						(gCurRoom setScript: getOutCar)
					)
					(else
						(= local0 0)
						(gCurRoom setScript: getInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance car2 of View
	(properties
		x 262
		y 145
		noun 10
		view 107
		cel 2
		priority 12
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(door2 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((!= global206 1)
						(gMessager say: 13 4 9) ; "You can't do that -- at least not now!"
					)
					((not (gEgo has: 10)) ; Camaro_Keys
						(gMessager say: noun 4 7 0) ; "You'll need your car keys first."
					)
					(local2
						(if (!= local0 9)
							(= local3 getInCar)
							(= local1 9)
						)
						(gCurRoom setScript: getOutCar)
					)
					((or (!= global206 1) (not (OneOf global211 31 73)))
						(gMessager say: noun 4 8 0) ; "You don't want to use your personal car for business. You don't know if your insurance covers it!"
					)
					(else
						(= local0 9)
						(gCurRoom setScript: getInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance car3 of View
	(properties
		x 274
		y 79
		noun 11
		view 104
		priority 3
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo has: 11)) ; Undercover_Car_Keys
						(gMessager say: noun 4 7 0) ; "You'll need the undercover car's keys before you can drive it."
					)
					(local2
						(if (!= local0 18)
							(= local3 getInCar)
							(= local1 18)
						)
						(gCurRoom setScript: getOutCar)
					)
					(else
						(= local0 18)
						(gCurRoom setScript: getInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		x 105
		y 72
		noun 9
		view 103
		loop 8
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance door2 of Prop
	(properties
		x 235
		y 130
		noun 10
		view 107
		loop 2
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance glassDoor1 of Actor
	(properties
		x 55
		y 61
		noun 1
		view 102
		priority 2
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(= temp1 0)
		(cond
			((gCurRoom script:) 0)
			((& (= temp0 (gEgo onControl: 0)) $0002)
				(= temp1 1)
			)
			((& temp0 $0010)
				(= temp1 2)
			)
			((& temp0 $0004)
				(= temp1 4)
			)
			((& temp0 $0008)
				(= temp1 8)
			)
			((& temp0 $0020)
				(gCurRoom setScript: toHall)
			)
			((and (& temp0 $0040) (not local5) (not local2))
				(gCurRoom setScript: bounce)
			)
			((and (not (& temp0 $0040)) local5)
				(= local5 0)
			)
		)
		(if (== (|= local4 temp1) 15)
			(++ local4)
			(SetScore 128 5)
			(gMessager say: 8 0 6 0) ; "You give the car a quick inspection. Everything looks ready to go."
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local2
					(= local3 toHall)
					(gCurRoom setScript: getOutCar)
				else
					(gCurRoom setScript: toHall)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laura of Actor
	(properties
		x 185
		y 132
		view 12
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond
			((!= view 12) 0)
			((self isStopped:)
				(if
					(and
						(!=
							(= temp0 (self loop:))
							(= temp1 (- (NumLoops self) 1))
						)
						(IsObject (self cycler:))
						(not ((self cycler:) isKindOf: Grycler))
					)
					(self loop: temp1 cel: temp0)
				)
			)
			(
				(and
					(== (self loop:) (- (NumLoops self) 1))
					(not (& signal $0800))
				)
				(self loop: (self cel:))
			)
		)
	)

	(method (init)
		(super init: &rest)
		(proc134_4 self 12 0 185 132)
	)
)

(instance fDrain of Feature
	(properties
		x 148
		y 152
		noun 7
		nsTop 146
		nsLeft 135
		nsBottom 159
		nsRight 161
		sightAngle 40
		approachX 148
		approachY 152
		approachDist 100
	)
)

(instance fMat of Feature
	(properties
		x 62
		y 65
		noun 4
		nsTop 59
		nsLeft 39
		nsBottom 72
		nsRight 86
		sightAngle 40
		approachX 73
		approachY 79
		approachDist 100
	)
)

(instance fPole of Feature
	(properties
		x 249
		y 36
		noun 5
		nsLeft 236
		nsBottom 72
		nsRight 262
		sightAngle 40
		approachX 242
		approachY 96
		approachDist 103
	)
)

(instance fWall of Feature
	(properties
		noun 6
		sightAngle 40
		onMeCheck 16384
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

