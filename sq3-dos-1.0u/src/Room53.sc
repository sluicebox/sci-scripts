;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room53 0
)

(instance hissing of Sound
	(properties)
)

(instance aSnake of Act
	(properties)
)

(instance tongue of Prop
	(properties)
)

(instance snakeSound of Sound
	(properties)
)

(instance Room53 of Rm
	(properties
		picture 53
	)

	(method (init)
		(= north gPrevRoomNum)
		(= global109 0)
		(Load rsSOUND 36)
		(Load rsSOUND 37)
		(Load rsSOUND 88)
		(Load rsSOUND 89)
		(self setRegions: 501) ; regDune
		(super init:)
		(NormalEgo)
		(gLongSong stop:)
		(User canControl: 0 canInput: 1)
		(gEgo posn: 155 95 view: 0 init: setMotion: MoveTo 155 105)
		(aSnake
			view: 77
			posn: -40 150
			setPri: 14
			setLoop: 0
			cel: 0
			setStep: 4 3
			ignoreActors: 1
			ignoreHorizon:
			illegalBits: 0
			init:
		)
		(aSnake setScript: snakeActions)
		(gCurRoom setScript: Actions)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong number: 22 priority: 0 loop: -1 play:)
		(HandsOn)
		(= global104 0)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 53 0) ; "That's a mighty big snake!"
						)
						((Said '/snake')
							(Print 53 1) ; "They sure grow them big here, don't they!"
						)
						((Said '/tongue')
							(Print 53 2) ; "You sure wish you had one like that."
						)
					)
				)
				((Said 'kiss/snake')
					(Print 53 3) ; "I think that may be his intent."
				)
				((Said 'kill/snake')
					(Print 53 4) ; "You left your Mark XII heavy duty, phased laser, pulsed neutron, blaster in your underwear drawer."
				)
				((Said 'jog')
					(Print 53 5) ; "Gee,that's a very good idea."
				)
				((Said 'feed/snake')
					(Print 53 6) ; "The only snake food here is you!"
				)
				((Said 'talk/snake')
					(Print 53 7) ; "You say howdy, but all you get is a hiss in return."
				)
				((Said 'bridle/snake')
					(Print 53 8) ; "You've been getting some mighty strange ideas from playing 'KQ II', haven't you? You loose 5 points."
					(gGame changeScore: -5)
				)
				((Said 'charm/snake')
					(Print 53 9) ; "You do have a charming personality, but I don't think that's going to cut it."
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState))
)

(instance snakeActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (== state 4)
			(cond
				((or (!= (gEgo x:) 155) (> (gEgo y:) 105))
					(User canControl: 0 canInput: 1)
					(= seconds 0)
					(self changeState: 5)
				)
				((and (<= (gEgo y:) 95) (== gCurRoomNum gNewRoomNum))
					(User canControl: 0 canInput: 1)
					(self changeState: 10)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSnake setMotion: MoveTo -22 94 self)
			)
			(1
				(aSnake setMotion: MoveTo -43 55 self)
			)
			(2
				(aSnake setMotion: MoveTo 0 62 self)
			)
			(3
				(if (IsObject (gEgo mover:))
					(-- state)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(4
				(tongue
					view: 77
					loop: 2
					posn: 133 83
					setPri: 13
					setCycle: Fwd
					setScript: hiss
					init:
				)
				(HandsOn)
				(= seconds 12)
			)
			(5
				(HandsOff)
				(hissing stop:)
				(hiss changeState: 3)
				(tongue setScript: 0 dispose:)
				(aSnake setCycle: End self)
				(snakeSound priority: 19 number: 89 play:)
			)
			(6
				(aSnake cel: 0)
				(gCurRoom horizon: 0)
				(gEgo
					view: 77
					setLoop: 3
					posn: 141 89
					ignoreActors:
					setCycle: Fwd
					setStep: 1 1
					moveSpeed: 2
					setMotion: MoveTo 126 87
				)
				(= seconds 7)
			)
			(7
				(gEgo setLoop: 4 setCel: 0 posn: 137 88)
				(snakeSound priority: 19 number: 88 play:)
				(aSnake cel: 1)
				(= seconds 1)
			)
			(8
				(gEgo hide:)
				(aSnake cel: 0)
				(= seconds 3)
			)
			(9
				(EgoDead 901 0 13 19) ; "Thanks for playing Space Quest ]I[. As usual, you've been a real hoot."
			)
			(10
				(tongue dispose:)
				(gEgo setMotion: MoveTo (gEgo x:) 70 self)
			)
			(11
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance hiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hissing number: 37 priority: 10 loop: 2 play: self)
			)
			(1
				(= state -1)
				(= seconds 4)
			)
		)
	)
)

