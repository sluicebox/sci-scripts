;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm121 0
)

(instance rm121 of Rm
	(properties
		picture 121
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(= global159 1)
		(Load rsVIEW 194)
		(Load rsVIEW 68)
		(Load rsVIEW 210)
		(Load rsPIC 120)
		(Load rsPIC 122)
		(Load rsSOUND 30)
		(super init:)
		(gEgo
			view: 68
			loop: 2
			posn: 152 92
			setCycle: Walk
			setStep: 2 1
			setPri: 15
			ignoreActors: 1
		)
		(self setScript: OpenDoor)
	)

	(method (doit &tmp [temp0 50])
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
	)
)

(instance OpenDoor of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(Print 121 0) ; "You and the Two Guys are separated and escorted away. A door opens and you are led into the dark unknown."
				(door init: setCycle: End self)
			)
			(1
				(gEgo init: setMotion: MoveTo 152 116 self)
				(guard1 init: setMotion: MoveTo 149 116)
				(guard2 init: setMotion: MoveTo 155 116)
			)
			(2
				(= seconds 2)
			)
			(3
				(door setCycle: Beg self)
				(gEgo hide:)
				(guard1 hide:)
				(guard2 hide:)
			)
			(4
				(gCurRoom drawPic: 120)
				(gAddToPics add: robo1 robo2)
				(gAddToPics doit:)
				(gEgo show:)
				(guard1 show:)
				(guard2 show:)
				(gLongSong number: 30 loop: -1 priority: 1 play:)
				(= cycles 2)
			)
			(5
				(= seconds 1)
				(door dispose:)
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo setMotion: MoveTo 145 116 self)
			)
			(8
				(gEgo setMotion: MoveTo 98 116 self)
				(guard1 setLoop: 3 setMotion: MoveTo 98 116)
				(guard2 setLoop: 3 setMotion: MoveTo 98 116)
			)
			(9
				(gCurRoom drawPic: 122)
				(elevator init:)
				(gEgo
					view: 0
					setStep: 3 2
					posn: 277 171
					ignoreActors: 1
					setPri: -1
					setMotion: MoveTo 145 171 self
				)
				(guard1
					setLoop: 0
					cel: 0
					setStep: 3 2
					posn: 296 168
					setPri: -1
					setMotion: MoveTo 162 168
				)
				(guard2
					setLoop: 0
					cel: 0
					setStep: 3 2
					posn: 291 174
					setPri: -1
					setMotion: MoveTo 166 174
				)
			)
			(10
				(gEgo hide:)
				(elevator
					illegalBits: 0
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 145 122 self
				)
			)
			(11
				(guard1 setLoop: 1 cel: 0 setMotion: MoveTo 330 (guard1 y:))
				(guard2 setLoop: 1 cel: 0 setMotion: MoveTo 330 (guard2 y:))
				(elevator setLoop: 1 setMotion: MoveTo 145 67 self)
			)
			(12
				(elevator setLoop: 2 setMotion: MoveTo 145 41 self)
			)
			(13
				(gEgo cycleSpeed: 1 posn: 145 41 show:)
				(elevator setLoop: 3)
				(gEgo setMotion: MoveTo 137 40 self)
			)
			(14
				(gEgo view: 199 setLoop: 6 cel: 0 setCycle: End self)
			)
			(15
				(elevator setMotion: MoveTo 145 67 self)
			)
			(16
				(elevator setLoop: 4 setMotion: MoveTo 145 122 self)
			)
			(17
				(elevator setLoop: 5 setMotion: MoveTo 145 171 self)
			)
			(18
				(gEgo cycleSpeed: 0)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 194
			setLoop: 0
			setCel: 0
			posn: 153 91
			setPri: 5
			ignoreActors: 1
		)
	)
)

(instance guard1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 210
			setLoop: 2
			setCycle: Walk
			setStep: 2 1
			posn: 149 90
			setPri: 5
			ignoreActors: 1
		)
	)
)

(instance guard2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 210
			setLoop: 2
			setCycle: Walk
			setStep: 2 1
			posn: 155 90
			setPri: 5
			ignoreActors: 1
		)
	)
)

(instance elevator of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 199
			setLoop: 5
			setCel: 0
			yStep: 4
			posn: 145 171
			setPri: 4
			ignoreActors: 1
		)
	)
)

(instance robo1 of PV
	(properties
		y 88
		x 53
		view 194
		loop 2
		priority 7
		signal 16384
	)
)

(instance robo2 of PV
	(properties
		y 88
		x 265
		view 194
		loop 2
		cel 1
		priority 7
		signal 16384
	)
)

