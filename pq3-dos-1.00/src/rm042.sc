;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm042 0
)

(instance rm042 of PQRoom
	(properties
		picture 42
		east -1
		south -1
		west -1
	)

	(method (init)
		(LoadMany rsVIEW 1 5 16 209 455 456)
		(cond
			((or (== gPrevRoomNum 43) (== gPrevRoomNum 44) (== gPrevRoomNum 443))
				(gEgo view: 5 loop: 1 cel: 0 posn: 238 84 setPri: -1)
			)
			((== gDay 1)
				(gEgo view: 16 loop: 4 cel: 0 posn: 60 167 setPri: 12)
			)
			(else
				(gEgo view: 456 loop: 1 cel: 0 posn: 63 166 setPri: 12)
			)
		)
		(gEgo setStep: 3 2 normal: 0 init:)
		(if (not (IsFlag 226))
			(proc0_17 10)
			(SetFlag 226)
		)
		(if (== gDay 1)
			(patrolCarBack init:)
		else
			(unMarkedCarBack init:)
		)
		(building init:)
		(entrance approachVerbs: 3 init:) ; Do
		(plantsLFT init:)
		(plantsRT init:)
		(asphalt init:)
		(sidewalk init:)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 110 128 80 119 93 113 58 103 77 94 0 71 0 0 319 0 319 154 274 169 216 147 192 154 174 147 202 102 262 113 288 98 257 91 293 74 271 67 209 80 200 82 182 76 157 83 144 79 129 82 158 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 55 123 157 157 106 187 35 167 4 152 23 137
					yourself:
				)
		)
		(HandsOff)
		(cond
			((or (== gPrevRoomNum 43) (== gPrevRoomNum 44) (== gPrevRoomNum 443))
				(gCurRoom setScript: egoOutCourtHouse)
			)
			((== gDay 1)
				(gCurRoom setScript: egoOutPatrolCar)
			)
			(else
				(gCurRoom setScript: egoOutUnMarkedCar)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			(
				(and
					(& (gEgo onControl: 0) $0010)
					(== (gEgo view:) 5)
					(IsFlag 28)
				)
				(ClearFlag 28)
				(HandsOff)
				(gCurRoom setScript: goInMore 0 43)
			)
			((and (IsFlag 29) (& (gEgo onControl: 0) $0010))
				(HandsOff)
				(gCurRoom setScript: goInMore 0 44)
			)
			((& (gEgo onControl: 0) $0010)
				(HandsOff)
				(gCurRoom setScript: notYet)
			)
		)
		(super doit:)
	)
)

(instance goInMore of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 271 70 self)
			)
			(1
				(if (== register 44)
					(= save1 1)
					(Print 42 0) ; "You request to see Judge Simpson in her chambers."
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(2
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance notYet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 88 self)
			)
			(1
				(Print 42 1) ; "There's nothing for you to do at the courthouse right now."
				(= cycles 1)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoOutCourtHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 88 self)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoInUnMarkedCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 57 171 self)
			)
			(1
				(doorOpenSound play:)
				(unMarkedCarDoor cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(2
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 6) (- (gEgo y:) 5) self
				)
			)
			(3
				(gEgo
					view: 420
					loop: 0
					cel: 8
					normal: 0
					cycleSpeed: 10
					setCycle: CT 7 -1 self
				)
			)
			(4
				(gEgo cel: 7 setPri: 12 setCycle: CT 0 -1 self)
			)
			(5
				(unMarkedCarDoor setPri: 15 setCycle: Beg self)
			)
			(6
				(doorCloseSound play:)
				(= cycles 1)
			)
			(7
				(self dispose:)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance egoOutUnMarkedCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorOpenSound play:)
				(unMarkedCarDoor cycleSpeed: 10 setPri: 14 setCycle: End self)
			)
			(1
				(ShowClock 1)
				(gEgo
					cycleSpeed: 9
					setPri: 15
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 5
					setLoop: 4
					posn: 53 170
					setCycle: Walk
					setMotion: MoveTo 57 176 self
				)
			)
			(3
				(unMarkedCarDoor setCycle: Beg self)
			)
			(4
				(doorCloseSound play:)
				(= cycles 1)
			)
			(5
				(= save1 1)
				(Say unMarkedCarMiddle 42 2) ; "I'll be waitin' for ya in the car, Boss."
				(= seconds 4)
			)
			(6
				(ShowClock 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(unMarkedCarDoor setPri: 10 stopUpd:)
				(NormalEgo 5 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoInPatrolCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 57 171 self)
			)
			(1
				(doorOpenSound play:)
				(patrolCarDoor cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 57 168 self)
			)
			(3
				(gEgo
					view: 16
					posn: 63 166
					loop: 4
					cel: 8
					normal: 0
					cycleSpeed: 10
					setCycle: CT 1 -1 self
				)
			)
			(4
				(gEgo cel: 1 setPri: 12 setCycle: CT 0 -1 self)
			)
			(5
				(patrolCarDoor setPri: 15 setCycle: Beg self)
			)
			(6
				(doorCloseSound play:)
				(= cycles 1)
			)
			(7
				(self dispose:)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance egoOutPatrolCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorOpenSound play:)
				(patrolCarDoor cycleSpeed: 10 setPri: 14 setCycle: End self)
			)
			(1
				(gEgo
					cycleSpeed: 10
					setPri: 15
					ignoreActors: 1
					setCycle: CT 7 1 self
				)
			)
			(2
				(gEgo cel: 7 setCycle: CT 8 1 self)
			)
			(3
				(gEgo
					view: 1
					loop: 4
					posn: 54 167
					setCycle: Walk
					setMotion: MoveTo 57 176 self
				)
			)
			(4
				(patrolCarDoor setCycle: Beg self)
			)
			(5
				(doorCloseSound play:)
				(= cycles 1)
			)
			(6
				(patrolCarDoor setPri: 10 stopUpd:)
				(NormalEgo 1 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance patrolCarFront of View
	(properties
		x 29
		y 155
		lookStr {You look fondly at your car.}
		view 209
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(patrolCarBack doVerb: theVerb invItem)
	)
)

(instance patrolCarMiddle of View
	(properties
		x 62
		y 175
		lookStr {You look fondly at your car.}
		view 209
		cel 1
		priority 9
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(patrolCarBack doVerb: theVerb invItem)
	)
)

(instance patrolCarBack of View
	(properties
		x 109
		y 175
		lookStr {You look fondly at your car.}
		view 209
		cel 2
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: egoInPatrolCar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(patrolCarFront init:)
		(patrolCarMiddle init:)
		(patrolCarDoor init:)
		(super init:)
	)
)

(instance patrolCarDoor of Prop
	(properties
		x 45
		y 173
		z 30
		lookStr {You look fondly at your car.}
		view 209
		loop 1
		priority 10
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(patrolCarBack doVerb: theVerb invItem)
	)
)

(instance unMarkedCarFront of View
	(properties
		x 29
		y 155
		lookStr {You look fondly at your car.}
		view 209
		loop 2
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(unMarkedCarBack doVerb: theVerb invItem)
	)
)

(instance unMarkedCarMiddle of View
	(properties
		x 62
		y 175
		lookStr {You look fondly at your car.}
		view 209
		loop 2
		cel 1
		priority 9
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(unMarkedCarBack doVerb: theVerb invItem)
	)
)

(instance unMarkedCarBack of View
	(properties
		x 109
		y 175
		lookStr {You look fondly at your car.}
		view 209
		loop 2
		cel 2
		priority 9
		signal 16401
	)

	(method (init)
		(unMarkedCarFront init:)
		(unMarkedCarDoor init:)
		(unMarkedCarMiddle init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: egoInUnMarkedCar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unMarkedCarDoor of Prop
	(properties
		x 43
		y 178
		z 30
		lookStr {You look fondly at your car.}
		view 209
		loop 3
		priority 10
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(unMarkedCarBack doVerb: theVerb invItem)
	)
)

(instance building of Feature
	(properties
		x 170
		y 7
		description {the building}
		onMeCheck 18
		lookStr {Lytton city courthouse... You hope Judge Simpson got up on the right side of the bed this morning}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 3) ; "Just use the front door."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance entrance of Feature
	(properties
		x 226
		y 62
		description {building entrance}
		onMeCheck 4
		approachX 229
		approachY 82
		lookStr {The front entrance to the courthouse.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((and (== (gEgo view:) 5) (IsFlag 28))
						(gCurRoom newRoom: 43)
					)
					((IsFlag 29)
						(gCurRoom newRoom: 443)
					)
					(else
						(gCurRoom setScript: notYet)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plantsLFT of Feature
	(properties
		x 144
		y 132
		description {the plants}
		onMeCheck 1024
		lookStr {This site boasts typical Lytton city landscape.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 4) ; "You consider using the bushes, but decide that you can wait until you get to a restroom."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plantsRT of Feature
	(properties
		x 272
		y 165
		description {the plants}
		onMeCheck 2048
		lookStr {This site boasts typical Lytton city landscape.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 4) ; "You consider using the bushes, but decide that you can wait until you get to a restroom."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		x 111
		y 139
		description {sidewalk}
		onMeCheck 32
		lookStr {A nice, wide sidewalk runs in front of the courthouse.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 5) ; "Hey! Try to keep your mind on your work, Ok, bonds?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance asphalt of Feature
	(properties
		x 9
		y 183
		description {the asphalt}
		onMeCheck 256
		lookStr {The asphalt looks hot and dry.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 6) ; "Hey! Try to keep your mind on your work Ok bonds?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mPQ3motifSound of Sound ; UNUSED
	(properties
		number 50
		priority 13
		loop -1
	)
)

(instance doorOpenSound of Sound
	(properties
		number 900
	)
)

(instance doorCloseSound of Sound
	(properties
		number 901
	)
)

