;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use eureka)
(use Motion)
(use Actor)
(use System)

(public
	starField 0
	dockWall 1
	leftBayDoor 2
	rightBayDoor 3
	sOpenDoors 4
	sExitStarCon 5
)

(instance sOpenDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(leftBayDoor
					setLoop: 2
					setCel: 0
					setCycle: 0
					setStep: 1 1
					moveSpeed: 0
					setMotion: MoveTo 39 64 self
				)
				(rightBayDoor
					setLoop: 2
					setCel: 1
					setCycle: 0
					setStep: 1 1
					moveSpeed: 0
					setMotion: MoveTo 217 64 self
				)
			)
			(2
				(leftBayDoor dispose:)
				(rightBayDoor dispose:)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sExitStarCon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(= gEurekaLocation 17) ; empty space
				(eureka state: 1)
				(SetFlag 32)
			)
			(1
				(gCurRoom newRoom: 106)
				(self dispose:)
			)
		)
	)
)

(instance starField of View
	(properties
		x 104
		y 63
		view 215
		loop 1
		priority 4
		signal 16400
	)
)

(instance dockWall of View
	(properties
		x 48
		y 36
		view 215
		priority 6
		signal 16400
	)
)

(instance leftBayDoor of Actor
	(properties
		x 104
		y 64
		view 215
		loop 2
		priority 5
		signal 17
	)
)

(instance rightBayDoor of Actor
	(properties
		x 152
		y 64
		view 215
		loop 2
		cel 1
		priority 5
		signal 17
	)
)

