;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Wander)
(use Path)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room1 0
)

(local
	local0
	local1
	[local2 7] = [217 107 117 111 -50 119 -32768]
	[local9 7] = [117 111 217 107 365 116 -32768]
	local16
	local17
	local18
)

(instance Room1 of Rm
	(properties
		picture 1
	)

	(method (init)
		(= horizon 85)
		(= east 4)
		(= west 3)
		(= north 28)
		(super init:)
		(LoadMany rsSOUND 82 88)
		(LoadMany rsVIEW 6 13 9)
		(self setRegions: 205 207) ; swampReg, fenceReg
		(myMusic number: 88 loop: 0)
		(if gDetailLevel
			(Turtle setPri: 13 init: stopUpd: setScript: turtleScript)
			(Frog init: stopUpd: setScript: frogScript)
			(flyCage left: -2 right: 321 bottom: 191 top: 100 init:)
			(Fly
				setLoop: 7
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly2
				setLoop: 7
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly3
				setLoop: 7
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly4
				setLoop: 7
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly5
				setLoop: 7
				cel: 4
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Fly6
				setLoop: 7
				cel: 5
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(Gator
				setLoop: 8
				setCycle: Fwd
				setPri: 3
				moveSpeed: 1
				ignoreActors: 1
				init:
				setScript: gatorScript
			)
			(wave1 ignoreActors: 1 cycleSpeed: 2 setCycle: Fwd setPri: 2 init:)
			(wave2 ignoreActors: 1 cycleSpeed: 2 setCycle: Fwd setPri: 2 init:)
		else
			(wave1 addToPic:)
			(wave2 addToPic:)
		)
		(gEgo view: 0 posn: 131 88 illegalBits: -32768 init:)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 1 0) ; "A weather-beaten dock extends from the island's edge out into the alligator-infested bayou. Toward the center of the island you can see the old plantation house."
		)
		(if (== script 0)
			(if (& (gEgo onControl: 0) $0004)
				(Frog dispose:)
				(self setScript: fallLeft)
			)
			(if (& (gEgo onControl: 0) $0008)
				(Frog dispose:)
				(self setScript: fallRight)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'move/box')
					(Print 1 1) ; "You could never lift those heavy crates!"
				)
				((Said 'open,(look<in)/box')
					(Print 1 2) ; "There is nothing you would want in these old crates."
				)
				((Said 'look>')
					(cond
						((Said '<below/dock')
							(Print 1 3) ; "All you see under the dock is swamp water."
						)
						((Said '[<around,at][/room,dock]')
							(Print 1 0) ; "A weather-beaten dock extends from the island's edge out into the alligator-infested bayou. Toward the center of the island you can see the old plantation house."
						)
						((Said '/box')
							(Print 1 4) ; "Old crates are piled at the end of the dock."
						)
					)
				)
				((Said 'get/box')
					(Print 1 1) ; "You could never lift those heavy crates!"
				)
			)
		)
	)
)

(instance fallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 6
					cel: 0
					loop: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 0 loop: 3 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(= local16 (/ (- (gEgo y:) 90) 11))
				(= local17 (/ (- (gEgo y:) 90) 11))
				(gEgo
					cel: 0
					setLoop: 5
					cycleSpeed: 0
					setStep: 8 10
					setMotion:
						MoveTo
						(- (gEgo x:) local17)
						(+ (gEgo y:) local16)
					setCycle: End self
				)
				(Splash number: 82 loop: 1 priority: 3 play:)
			)
			(3
				(gEgo
					view: 13
					setLoop: 3
					cel: 0
					y: (+ (gEgo y:) 18)
					setMotion: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(4
				(myIcon init:)
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
				(EgoDead 1 5) ; "The thick muck was too much for you."
				(client setScript: 0)
			)
		)
	)
)

(instance fallRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 6
					setLoop: 0
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 0 setLoop: 2 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(gEgo
					setPri: 3
					cel: 0
					setLoop: 4
					cycleSpeed: 0
					setStep: 8 10
					setMotion: MoveTo (+ (gEgo x:) 34) (+ (gEgo y:) 25)
					setCycle: End self
				)
				(Splash number: 82 loop: 1 priority: 2 play:)
			)
			(3
				(gEgo
					view: 13
					setLoop: 2
					cel: 0
					setMotion: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(4
				(myIcon init:)
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
				(EgoDead 1 5) ; "The thick muck was too much for you."
				(client setScript: 0)
			)
		)
	)
)

(instance gatorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local1
					(0
						(Gator setLoop: 8 setMotion: leftPath self)
						(= local1 1)
					)
					(1
						(Gator setLoop: 9 setMotion: rightPath self)
						(= local1 0)
					)
				)
			)
			(1
				(= state -1)
				(= seconds (Random 15 25))
			)
		)
	)
)

(instance turtleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(Turtle setCycle: End self)
			)
			(2
				(Turtle dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance frogScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (< (Random 1 100) 40))
			(if (< local0 2)
				(myMusic loop: 1 play:)
				(++ local0)
			else
				(= local0 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
				(++ local0)
			)
			(1
				(myMusic loop: 1 priority: 2 play:)
				(Frog setCycle: End self)
			)
			(2
				(Frog posn: (Random 1 140) (Random 118 199) hide:)
				(= cycles 19)
			)
			(3
				(Frog loop: 6 illegalBits: 1 setCycle: Beg self show:)
			)
			(4
				(Frog loop: 5 setCycle: Fwd)
				(= seconds (Random 3 16))
			)
			(5
				(Frog loop: 6 setCycle: End self)
			)
			(6
				(Frog posn: (Random 1 140) (Random 118 199) hide:)
				(= state 2)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 652
	)
)

(instance wave1 of Prop
	(properties
		y 123
		x 261
		view 101
	)
)

(instance wave2 of Prop
	(properties
		y 186
		x 260
		view 101
		loop 1
		cel 2
		priority 14
	)
)

(instance Turtle of Prop
	(properties
		y 187
		x 61
		view 101
		loop 2
	)
)

(instance Frog of Act
	(properties
		y 123
		x 74
		view 101
		loop 3
		priority 8
	)

	(method (handleEvent)
		(cond
			((Said 'look/frog,turtle')
				(Print 1 6) ; "Many frogs and turtles live in the bayou."
			)
			((Said 'capture,get/frog,turtle')
				(Print 1 7) ; "You have better things to do than to worry about the little swamp creatures."
			)
			((Said 'talk/frog,turtle')
				(Print 1 8) ; "This isn't King's Quest!"
			)
			((Said 'kiss/frog,turtle')
				(Print 1 9) ; "What do you think this is...King's Quest?!"
			)
			((Said 'kill/frog,turtle')
				(Print 1 7) ; "You have better things to do than to worry about the little swamp creatures."
			)
			((Said 'pat/frog,turtle')
				(Print 1 10) ; "You'd have to catch them first."
			)
		)
	)
)

(instance Gator of Act
	(properties
		y 116
		x 360
		view 101
	)

	(method (handleEvent event)
		(if (not (self mover:))
			(return)
		)
		(cond
			((or (MousedOn self event 3) (Said 'look/alligator'))
				(event claimed: 1)
				(Print 1 11) ; "Vicious 'gators inhabit the swamp surrounding the island."
			)
			((Said '/alligator>')
				(cond
					((Said 'feed')
						(Print 1 12) ; "These alligators prefer fresh meat. Heh, heh."
					)
					((Said 'get,capture')
						(Print 1 13) ; "You MUST be kidding!"
					)
					((Said 'pat')
						(Print 1 14) ; "You can't be SERIOUS!"
					)
					((Said 'talk')
						(Print 1 15) ; "'Gators don't talk!"
					)
					((Said 'kiss')
						(Print 1 16) ; "Be reasonable!!"
					)
					((Said 'hit,kill')
						(Print 1 17) ; "You couldn't hurt a big 'gator."
					)
				)
			)
			(
				(or
					(Said 'feed,give,show/*[/alligator]')
					(Said 'feed,give,show/*<alligator')
				)
				(if (and global219 global224)
					(Print 1 12) ; "These alligators prefer fresh meat. Heh, heh."
				else
					(DontHave) ; "You don't have it."
				)
			)
		)
	)
)

(instance Fly of Act
	(properties
		y 123
		x 74
		view 101
	)
)

(instance Fly2 of Act
	(properties
		y 179
		x 97
		view 101
	)
)

(instance Fly3 of Act
	(properties
		y 139
		x 107
		view 101
	)
)

(instance Fly4 of Act
	(properties
		y 123
		x 124
		view 101
	)
)

(instance Fly5 of Act
	(properties
		y 159
		x 97
		view 101
	)
)

(instance Fly6 of Act
	(properties
		y 139
		x 147
		view 101
	)
)

(instance myMusic of Sound
	(properties)
)

(instance Splash of Sound
	(properties)
)

(instance flyCage of Cage
	(properties)
)

(instance leftPath of Path
	(properties)

	(method (at param1)
		(return [local2 param1])
	)
)

(instance rightPath of Path
	(properties)

	(method (at param1)
		(return [local9 param1])
	)
)

