;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
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
	rm049 0
)

(instance rm049 of PQRoom
	(properties
		lookStr {the Coroner's office is conveniently located just down the street from the courthouse.}
		picture 49
		east -1
		south -1
		west -1
	)

	(method (init)
		(trunk x: 122 y: 185 marked: 0 init: close:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 162 89 62 59 45 62 25 56 26 50 0 43 0 21 0 0 319 0 319 112 245 112 207 100 205 91 200 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 228 140 228 131 252 131 252 140
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 57 86 166 118 117 150 10 113
					yourself:
				)
		)
		(LoadMany rsVIEW 209 520)
		(LoadMany rsSOUND 900 901)
		(sStreetFX init: play:)
		(proc0_17 10)
		(super init:)
		(carfront init:)
		(buildingDoor init:)
		(building init:)
		(coronerSign init:)
		(tree init:)
		(fireHydrant init:)
		(sidewalk init:)
		(street init:)
		(if (== gPrevRoomNum 50)
			(gEgo
				normal: 1
				view: 5
				setStep: 3 2
				setPri: -1
				illegalBits: 0
				init:
			)
			(gCurRoom setScript: exitCoronerOffice)
		else
			(gEgo
				normal: 0
				view: 420
				cycleSpeed: (gGame egoMoveSpeed:)
				moveSpeed: (gGame egoMoveSpeed:)
				x: (+ (carfront x:) 32)
				y: (+ (carfront y:) 10)
				setPri: 9
				cel: 0
				init:
			)
			(HandsOff)
			(gCurRoom setScript: getOutCar)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 881)
	)
)

(instance exitCoronerOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 226 83 init:)
				(buildingDoor ignoreActors: 1 setCycle: End self)
				(bdoorOpenSnd play:)
			)
			(1
				(gEgo setMotion: MoveTo 206 97 self)
			)
			(2
				(buildingDoor setCycle: Beg self)
			)
			(3
				(bdoorCloseSnd play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 206 97 self)
			)
			(1
				(bdoorOpenSnd play:)
				(buildingDoor ignoreActors: 1 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 226 83 self)
			)
			(3
				(buildingDoor setCycle: Beg self)
			)
			(4
				(bdoorCloseSnd play:)
				(gCurRoom newRoom: 50)
			)
		)
	)
)

(instance enterOfficeLocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 206 97 self)
			)
			(1
				(Print 49 0) ; "The door is locked."
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 81 136 self)
			)
			(1
				(doorOpenSound play:)
				(carDoor setCycle: End self)
			)
			(2
				(gEgo setLoop: 3 setMotion: PolyPath 65 127 self)
			)
			(3
				(gEgo normal: 0 view: 420 loop: 0 cel: 9 x: 69 y: 127)
				(= cycles 1)
			)
			(4
				(gEgo
					cycleSpeed: 12
					moveSpeed: 12
					setPri: 9
					setCycle: CT 0 -1 self
				)
			)
			(5
				(carDoor setCycle: Beg self)
			)
			(6
				(doorCloseSound play:)
				(gEgo setLoop: -1)
				(= cycles 2)
			)
			(7
				(buildingDoor hide:)
				(carfront hide:)
				(carmiddle hide:)
				(carback hide:)
				(carDoor hide:)
				(gEgo hide:)
				(gCurRoom drawPic: 98 6)
				(= cycles 10)
			)
			(8
				(Print 49 1) ; "You decide to drive to the hospital to check up on marie."
				(ClearFlag 65)
				(= global129 5)
				(= global130 5)
				(= global131 0)
				(= global132 0)
				(= global133 30)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance getOutCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(ShowClock 1)
				(carDoor setCycle: End self)
				(doorOpenSound play:)
			)
			(2
				(gEgo
					cycleSpeed: (gGame egoMoveSpeed:)
					moveSpeed: (gGame egoMoveSpeed:)
					ignoreActors: 1
					setCycle: End self
				)
			)
			(3
				(gEgo
					normal: 1
					view: 5
					x: 66
					y: 129
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(4
				(carDoor setCycle: Beg self)
			)
			(5
				(doorCloseSound play:)
				(= cycles 1)
			)
			(6
				(= seconds 4)
			)
			(7
				(ShowClock 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance poly1 of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance polyCar of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance polyHydrant of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance buildingDoor of Prop
	(properties
		x 206
		y 92
		view 520
		priority 4
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 49 2) ; "This is the front entrance to the coroner's office."
			)
			(3 ; Do
				(cond
					((trunk showing:)
						(super doVerb: theVerb)
					)
					((IsFlag 36)
						(gEgo setScript: enterOfficeLocked)
					)
					(else
						(gEgo setScript: enterOffice)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carfront of View
	(properties
		x 37
		y 117
		view 209
		loop 2
		priority 7
		signal 16657
	)

	(method (init)
		(carmiddle posn: (+ x 33) (+ y 20) loop: 2 cel: 1 init:)
		(carback posn: (+ x 80) (+ y 20) loop: 2 cel: 2 approachVerbs: 3 init:) ; Do
		(carDoor posn: (+ x 14) (+ y 23) 30 loop: 3 cel: 0 init:)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 49 3) ; "Your car sits out in front of the coroner's office."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carmiddle of View
	(properties
		view 209
		loop 2
		cel 1
		priority 7
		signal 16657
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 49 4) ; "You look fondly at your car."
			)
			(3 ; Do
				(if (IsFlag 36)
					(HandsOff)
					(gCurRoom setScript: getInCar)
				else
					(Print 49 5) ; "You haven't even been inside yet!"
				)
			)
			(else
				(carfront doVerb: theVerb)
			)
		)
	)
)

(instance carback of View
	(properties
		approachX 143
		approachY 139
		view 209
		loop 2
		cel 2
		priority 7
		signal 16657
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 49 6) ; "The trunk of your car is closed."
			)
			(3 ; Do
				(trunk open:)
			)
			(else
				(carfront doVerb: theVerb)
			)
		)
	)
)

(instance carDoor of Prop
	(properties
		view 209
		loop 3
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(carfront doVerb: theVerb)
	)
)

(instance fireHydrant of Feature
	(properties
		x 241
		y 129
		nsTop 116
		nsLeft 227
		nsBottom 143
		nsRight 256
		sightAngle 90
		lookStr {There's a fire hydrant on the sidewalk.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 7) ; "Since you're not a dog, I'll ignore that request."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tree of Feature
	(properties
		onMeCheck 8192
		lookStr {The tree looks lonely amid all that brick and concrete.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 8) ; "Not having a green thumb, you leave the tree alone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coronerSign of Feature
	(properties
		onMeCheck 16384
		lookStr {The sign reads "Coroner".}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 9) ; "There's nothing you can do with the sign."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance building of Feature
	(properties
		onMeCheck 2048
		lookStr {This building houses the County Coroner's office.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 10) ; "Just use the front door."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		onMeCheck 1024
		lookStr {Like all county buildings,The sidewalks are kept clean and tidy.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 11) ; "There's nothing you can do with the sidewalk."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance street of Feature
	(properties
		onMeCheck 512
		lookStr {The asphalt looks hot and dry.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 49 12) ; "Ok Bonds,... Lets try and keep our mind on our work!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorOpenSound of Sound
	(properties
		number 900
		priority 15
	)
)

(instance doorCloseSound of Sound
	(properties
		number 901
		priority 15
	)
)

(instance bdoorOpenSnd of Sound
	(properties
		number 907
	)
)

(instance bdoorCloseSnd of Sound
	(properties
		number 908
	)
)

(instance sStreetFX of Sound
	(properties
		number 913
		priority 15
		loop -1
	)
)

