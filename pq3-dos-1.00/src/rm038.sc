;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm038 0
)

(instance rm038 of PQRoom
	(properties)

	(method (init)
		(LoadMany rsVIEW 1 5 16 17 209 420 421)
		(LoadMany rsSOUND 380 900 901)
		(if (== gPrevRoomNum 40)
			(gEgo view: 5 loop: 5 x: 98 y: 146)
			(= global105 13)
			(self picture: 38)
		else
			(gEgo loop: 4 cel: 0 x: 234 y: 162 priority: 14 signal: 16)
			(if (< gDay 2)
				(gEgo view: 16)
			else
				(gEgo view: 17)
				(SetFlag 17)
				(gEgo put: 16) ; nightStick
			)
			(if (or (>= global105 18) (<= global105 6))
				(light cycleSpeed: 9 setCycle: RandCycle init:)
				(light2 cel: 6 cycleSpeed: 10 setCycle: RandCycle init:)
				(self picture: 39)
			else
				(self picture: 38)
			)
		)
		(gEgo
			normal: 0
			setStep: 3 2
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
			init:
		)
		(mariesThemeSound loop: -1 init: play:)
		(super init:)
		(carDoor setPri: 15 init:)
		(carFront init:)
		(carMid init:)
		(carBack init:)
		(if (== gDay 1)
			(= global105 5)
		)
		(HandsOff)
		(cond
			((== gPrevRoomNum 40)
				(gCurRoom setScript: egoPCInCar)
			)
			((< gDay 2)
				(gCurRoom setScript: egoUOutOfCar)
			)
			(else
				(gCurRoom setScript: egoPCOutOfCar)
			)
		)
	)
)

(instance egoPCInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(gEgo
					setStep: 3 2
					setCycle: Walk
					setMotion: MoveTo 156 167 self
				)
			)
			(3
				(gEgo setPri: 15 setMotion: MoveTo 188 159 self)
			)
			(4
				(gEgo setMotion: MoveTo 239 170 self)
			)
			(5
				(doorOpenSound init: play:)
				(carDoor cel: 0 cycleSpeed: 4 setPri: 15 setCycle: End self)
			)
			(6
				(ShowClock 0)
				(gEgo setMotion: MoveTo 234 162 self)
			)
			(7
				(gEgo
					view: 420
					loop: 0
					cel: 8
					normal: 0
					cycleSpeed: 12
					setCycle: CT 7 -1 self
				)
			)
			(8
				(gEgo cel: 7 setCycle: CT 0 -1 self)
			)
			(9
				(carDoor setCycle: Beg self)
				(gEgo setPri: 14)
			)
			(10
				(doorCloseSound init: play:)
				(mariesThemeSound fade:)
				(= cycles 1)
			)
			(11
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance egoPCOutOfCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(doorOpenSound init: play:)
				(carDoor cycleSpeed: 4 setPri: 15 setCycle: End self)
			)
			(3
				(gEgo
					cycleSpeed: 12
					setPri: 15
					ignoreActors: 1
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 5
					loop: 6
					cycleSpeed: (gGame egoMoveSpeed:)
					setCycle: Walk
					setMotion: MoveTo 239 170 self
				)
			)
			(5
				(Face gEgo carDoor self)
			)
			(6
				(carDoor setCycle: Beg self)
				(doorCloseSound play:)
			)
			(7
				(ShowClock 0)
				(gEgo
					view: 5
					loop: 6
					cycleSpeed: (gGame egoMoveSpeed:)
					setCycle: Walk
					setMotion: MoveTo 188 159 self
				)
			)
			(8
				(gEgo setMotion: MoveTo 156 167 self)
			)
			(9
				(gEgo setPri: -1 setMotion: MoveTo 98 139 self)
				(mariesThemeSound fade:)
			)
			(10
				(gCast eachElementDo: #hide)
				(gEgo hide:)
				(gCurRoom style: 10 drawPic: 98)
				(= cycles 3)
			)
			(11
				(switch gDay
					(1
						(Display 38 0 dsCOORD 135 80 dsCOLOR global125 dsFONT 1) ; "Day 2"
					)
					(2
						(Display 38 1 dsCOORD 135 80 dsCOLOR global125 dsFONT 1) ; "Day 3"
					)
					(3
						(Display 38 2 dsCOORD 135 80 dsCOLOR global125 dsFONT 1) ; "Day 4"
					)
					(4
						(Display 38 3 dsCOORD 135 80 dsCOLOR global125 dsFONT 1) ; "Day 5"
					)
					(5
						(Display 38 4 dsCOORD 135 80 dsCOLOR global125 dsFONT 1) ; "Day 6"
					)
					(6
						(Print 38 5) ; "There are only 6 days in the game."
					)
					(else
						(Print 38 5) ; "There are only 6 days in the game."
					)
				)
				(= seconds 4)
			)
			(12
				(HandsOn)
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance egoUOutOfCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(doorOpenSound play:)
				(carDoor cycleSpeed: 4 setPri: 15 setCycle: End self)
			)
			(3
				(gEgo
					cycleSpeed: 12
					setPri: 15
					ignoreActors: 1
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 1
					loop: 6
					x: (- (gEgo x:) 6)
					y: (+ (gEgo y:) 3)
					setCycle: Walk
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 239 170 self
				)
			)
			(5
				(Face gEgo carDoor self)
			)
			(6
				(carDoor setCycle: Beg self)
				(doorCloseSound play:)
			)
			(7
				(ShowClock 0)
				(gEgo setMotion: MoveTo 188 159 self)
			)
			(8
				(gEgo setMotion: MoveTo 156 167 self)
			)
			(9
				(gEgo setPri: -1 setMotion: MoveTo 99 143 self)
				(mariesThemeSound fade:)
			)
			(10
				(gEgo hide:)
				(HandsOn)
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance carFront of View
	(properties
		x 205
		y 150
		view 209
		loop 2
		signal 16385
	)
)

(instance carMid of View
	(properties
		x 238
		y 170
		view 209
		loop 2
		cel 1
		signal 16385
	)
)

(instance carBack of View
	(properties
		x 285
		y 170
		view 209
		loop 2
		cel 2
		signal 16385
	)
)

(instance carDoor of Prop
	(properties
		x 219
		y 143
		view 209
		loop 3
	)
)

(instance light of Prop
	(properties
		x 143
		y 123
		view 421
		cel 3
	)
)

(instance light2 of Prop
	(properties
		x 241
		y 104
		view 421
		cel 14
		priority 8
		signal 16
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

(instance mariesThemeSound of Sound
	(properties
		number 380
		priority 14
		loop -1
	)
)

