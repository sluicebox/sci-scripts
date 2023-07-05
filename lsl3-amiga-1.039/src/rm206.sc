;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm206 0
)

(local
	seenMsg
	stripperState
)

(instance rm206 of Rm
	(properties
		picture 206
	)

	(method (init)
		(HandsOff)
		(User canInput: 1)
		(SetFlag 5)
		(= gOldEgoState gEgoState)
		(= gEgoState gCurRoomNum)
		(Load rsSOUND 206)
		(super init:)
		(self setScript: RoomScript)
		(aShade1 init:)
		(aShade2 init:)
		(aShade3 init:)
		(aGull init:)
		(aGirl init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'look/area')
					(Said 'look<stop,away')
					(Said 'stop/look')
					(Said 'look<stop/awning')
					(Said 'exit,stop')
					(Said 'drop/binocular')
				)
				(Ok) ; "O.K."
				(= gEgoState gOldEgoState)
				(gCurRoom newRoom: 200)
			)
			((Said 'listen/woman')
				(Print 206 0) ; "These are binoculars, not microphones!"
			)
			((Said 'talk/woman')
				(Print 206 1) ; "She can't hear you."
			)
			((Said '/panties,panties')
				(Print 206 2) ; "Only you and Dennis Jonathan would stare at those tiny little things!"
			)
			((Said 'pull/binocular')
				(Print 206 3) ; "You attempt to turn the binoculars so as not to see into that woman's room, but you just can not!"
				(Print 206 4 #at -1 144) ; "(Hee, hee!)"
			)
			((Said 'look<in/binocular')
				(Print 206 5) ; "This is as far in as you can look!"
			)
			((Said 'look/area')
				(Print 206 6) ; "You are voyeuring into a woman's room in the hotel."
				(Print 206 7 #at -1 144) ; "(No wonder this is called a scenic viewpoint!)"
			)
			((Said 'look[/woman]')
				(switch stripperState
					(1
						(Printf 206 8 gEgoName) ; "%s! You're looking into a woman's hotel room!"
					)
					(2
						(Print 206 9) ; "She's turned off the lights!"
					)
					(3
						(Print 206 10) ; "She's pulling down the shades."
					)
					(4
						(Print 206 11) ; "Oh, my gawd! She's taking off her clothes!"
					)
					(5
						(Print 206 12) ; "WOW!"
					)
					(6
						(Print 206 13) ; "Did you see that?!"
					)
					(else
						(Print 206 14) ; "Where?"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= stripperState 1)
				(= seconds 3)
			)
			(1
				(aGirl setMotion: MoveTo 10 109 self)
				(= cycles 11)
			)
			(2
				(gMusic number: 206 loop: -1 play:)
			)
			(3
				(gAddToPics add: atpWall1 add: atpWall2 add: atpWall3 doit:)
				(= cycles 3)
				(= stripperState 2)
			)
			(4
				(aGirl setCycle: Walk setMotion: MoveTo 111 109 self)
			)
			(5
				(aGirl setLoop: 4 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(6
				(= stripperState 3)
				(aGirl setLoop: 5 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(7
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade1 setMotion: MoveTo 113 (- 102 (* 8 gFilthLevel)) self)
			)
			(8
				(aShade1 stopUpd:)
				(aGirl setLoop: 4 setCel: 255 setCycle: Beg self cycleSpeed: 1)
			)
			(9
				(aGirl
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 162 109 self
					cycleSpeed: 0
				)
			)
			(10
				(aGirl setLoop: 4 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(11
				(aGirl setLoop: 5 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(12
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade2 setMotion: MoveTo 169 (- 102 (* 8 gFilthLevel)) self)
			)
			(13
				(aShade2 stopUpd:)
				(aGirl setLoop: 4 setCel: 255 setCycle: Beg self cycleSpeed: 1)
			)
			(14
				(aGirl
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 220 109 self
					cycleSpeed: 0
				)
			)
			(15
				(aGirl setLoop: 4 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(16
				(aGirl setLoop: 5 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(17
				(aGirl setCycle: Beg cycleSpeed: 3)
				(aShade3 setMotion: MoveTo 225 (- 102 (* 8 gFilthLevel)) self)
			)
			(18
				(aShade3 stopUpd:)
				(= cycles 22)
			)
			(19
				(aGirl
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 169 109 self
					cycleSpeed: 0
				)
			)
			(20
				(= stripperState 4)
				(aGirl setLoop: 6 setCel: 0 setCycle: End self cycleSpeed: 1)
			)
			(21
				(= cycles (+ 8 gFilthLevel))
			)
			(22
				(aGirl setLoop: 7 setCel: 0 setCycle: End self)
			)
			(23
				(= cycles (+ 8 gFilthLevel))
			)
			(24
				(= stripperState 5)
				(gMusic fade:)
				(aGirl
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 300 109 self
					cycleSpeed: 0
				)
			)
			(25
				(= stripperState 6)
				(= seconds 3)
			)
			(26
				(SetFlag 16)
				(gGame changeScore: 2)
				(Print 206 15) ; "You wipe the sweat from your hands as you remove your eyes from the binoculars."
				(= gEgoState gOldEgoState)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance aShade1 of Act
	(properties
		y 64
		x 113
		view 206
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aShade2 of Act
	(properties
		y 64
		x 169
		view 206
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aShade3 of Act
	(properties
		y 64
		x 225
		view 206
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance atpWall1 of PV
	(properties
		y 109
		x 113
		view 206
		loop 1
	)
)

(instance atpWall2 of PV
	(properties
		y 109
		x 169
		view 206
		loop 2
	)
)

(instance atpWall3 of PV
	(properties
		y 109
		x 225
		view 206
		loop 3
	)
)

(instance aGirl of Act
	(properties
		y 109
		x 263
		view 207
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Walk ignoreActors:)
	)
)

(instance aGull of Act
	(properties
		y 70
		x -66
		view 208
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setPri: 13 setCycle: Fwd ignoreActors: setMotion: MoveTo 319 44)
	)
)

