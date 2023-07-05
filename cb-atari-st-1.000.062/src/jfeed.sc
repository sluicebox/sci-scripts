;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 239)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	jfeed 0
)

(local
	local0
	local1
	local2
	local3
)

(instance jfeed of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(LoadMany rsSCRIPT 985)
		(Load rsVIEW 520)
		(if (> gAct 1)
			(= global155 17)
		)
		(if (gEgo has: 12) ; soup_bone
			(Load rsVIEW 48)
			(Load rsSCRIPT 991)
		)
		(if (>= global155 2)
			(Dish init: stopUpd:)
		else
			(Dish init: hide:)
		)
		(= global375 Dish)
		(if (>= gAct 1)
			(if (or (> global155 1) (> gAct 1))
				(= global162 1)
				(= local0 2)
				(Rover
					view: 520
					illegalBits: 0
					posn: 163 155
					loop: 2
					cel: 0
					ignoreActors: 1
					init:
					setScript: dogActions
					stopUpd:
				)
			else
				(Rover view: 520 posn: 340 160 init:)
			)
			(= global374 Rover)
		)
		(if (and (< global155 2) (== gAct 1))
			(LoadMany rsVIEW 440 445 526)
			(if (== global155 0)
				(Jeeves loop: 2 posn: 128 117)
			else
				(Jeeves init:)
			)
		)
		(if (and (> [gCycleTimers 2] 1) (== global155 16) (== gAct 1))
			(= [gCycleTimers 2] 90)
			(Jeeves view: 440 x: 300 y: 53 init:)
			(self setScript: (ScriptID 387 0)) ; jWalk
		)
		(= global373 Jeeves)
	)

	(method (doit)
		(if
			(and
				(& (gEgo onControl: 1) $0001)
				(< global155 2)
				(== gAct 1)
				(not script)
			)
			(DisposeScript 990)
			(self setScript: (ScriptID 386 0)) ; jDog
		)
		(if (and (>= global155 2) (>= gAct 1) (not (Rover script:)))
			(Rover setScript: dogActions)
		)
		(if (and (== [gCycleTimers 2] 100) (== gAct 1))
			(if (and (& (gEgo onControl: 1) $0001) (User controls:))
				(Jeeves view: 440 x: 235 y: 53)
				(self setScript: (ScriptID 387 0)) ; jWalk
			else
				(= [gCycleTimers 2] 110)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 991)
		(DisposeScript 985)
	)

	(method (handleEvent event &tmp temp0)
		(DisposeScript 990)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'show/bone[<beauregard]')
					(if (gEgo has: 12) ; soup_bone
						(switch local0
							(2
								(Print 239 0) ; "Beauregard perks up at the sight of the bone!"
								(= local3 1)
							)
							(else
								(Print 239 1) ; "Beauregard is more interested in his food right now."
							)
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				(
					(or
						(Said 'feed,give,drop,throw/bone')
						(Said
							'feed,give,drop,throw/bone[/(beauregard,doghouse)<away,from]'
						)
					)
					(if (Rover script:)
						(if (gEgo has: 12) ; soup_bone
							(if (and (> (gEgo y:) 95) (> (gEgo x:) 45))
								(HandsOff)
								(self setScript: toss)
							else
								(Print 239 2) ; "Why don't you get closer to the dog."
							)
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 239 3) ; "With food in his dish, Beauregard will not want that bone yet."
					)
				)
				((or (Said 'give/*/beauregard') (Said 'give/*<beauregard'))
					(Print 239 4) ; "He wouldn't be intereseted."
				)
				(
					(or
						(Said 'get/back<bone[<from]')
						(Said 'get/*/beauregard')
						(Said 'get/bone')
					)
					(cond
						((== local0 3)
							(Print 239 5) ; "Trying to take the bone away from Beauregard while he's chewing on it, isn't a good idea."
						)
						((== ((gInventory at: 12) owner:) 12) ; soup_bone
							(Print 239 6) ; "You gave it to Beauregard, remember?"
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance toss of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (gEgo cel:) 6))
			(gEgo put: 12 12) ; soup_bone
			(Bone
				cycleSpeed: 1
				setLoop: 4
				setCycle: Fwd
				moveSpeed: 2
				setMotion: JumpTo 293 155 self
				init:
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 285 150 300 159)
					(gEgo setMotion: MoveTo 270 145 self)
				else
					(= cycles 1)
				)
			)
			(1
				(DirLoop gEgo (GetAngle (gEgo x:) (gEgo y:) 293 155))
				(Ok) ; "Okay."
				(if (gEgo inRect: 242 152 320 200)
					(gEgo setPri: 14)
				)
				(gEgo view: 48 cel: 0 setCycle: End)
				(Bone
					setPri: 13
					ignoreActors: 1
					illegalBits: 0
					posn:
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 11)
							)
							(1
								(- (gEgo x:) 11)
							)
							(2
								(- (gEgo x:) 7)
							)
							(else
								(+ (gEgo x:) 4)
							)
						)
						(- (gEgo y:) 26)
				)
			)
			(2
				(DisposeScript 991)
				(Bone setCycle: 0 cel: 0 setPri: -1 stopUpd:)
				(gEgo view: 0 setLoop: -1 setPri: -1 setCycle: Walk)
				(= cycles 1)
			)
			(3
				(++ local2)
				(client setScript: 0)
			)
		)
	)
)

(instance dogActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(local1
				(if (< state 5)
					(= state 6)
					(= cycles 1)
				)
			)
			(local2
				(= local2 0)
				(= state 1)
				(= cycles 2)
				(= local0 4)
			)
			(local3
				(switch local0
					(2
						(= state 0)
						(= cycles 1)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Rover
					view: 520
					loop: 2
					cel: 0
					setCycle: 0
					setAvoider: 0
					ignoreActors: 1
					stopUpd:
				)
				(= local0 2)
			)
			(1
				(= local3 0)
				(Rover view: 527 setLoop: 0 cel: 0 posn: 159 155 setCycle: End)
				(= state -1)
				(= seconds 3)
			)
			(2
				(Rover loop: 6 posn: 159 155 setCycle: Beg self)
			)
			(3
				(Rover
					view: 520
					setLoop: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 194 155 self
				)
			)
			(4
				(Rover setMotion: MoveTo 275 155 self)
			)
			(5
				(Rover
					view: 527
					loop: 4
					cel: (- (NumCels Rover) 1)
					ignoreActors: 0
					setCycle: Beg self
				)
				(= global162 0)
			)
			(6
				(HandsOn)
				(= cycles 2)
			)
			(7
				(= local0 3)
				(Bone dispose:)
				(Rover view: 522 loop: 4 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(Rover setCycle: 0)
				(= seconds 5)
				(= state 6)
			)
		)
	)
)

(instance PetDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo (+ (Rover x:) 26) (+ (Rover y:) 5) self
				)
			)
			(1
				(gEgo view: 22 loop: 0 setAvoider: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 7 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(gEgo
					loop: 0
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(5
				(HandsOn)
				(gEgo view: 0 loop: 1 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance Dish of Prop
	(properties
		y 159
		x 206
		view 112
		loop 2
		cel 2
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/dish'))
				(event claimed: 1)
				(Print 239 7) ; "The dog dish is empty."
			)
			((Said 'get/dish')
				(Print 239 8) ; "You don't want to carry a dirty, old dog dish!"
			)
		)
	)
)

(instance Rover of Act
	(properties)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/beauregard'))
				(switch local0
					(0
						(Print 239 9) ; "Beauregard looks hungry!"
					)
					(1
						(Print 239 10) ; "Beauregard is sure enjoying his food!"
					)
					(2
						(Print 239 11) ; "Old Beauregard snoozes in his doghouse."
					)
					(3
						(Print 239 12) ; "Beauregard is sure enjoying the bone!"
					)
					(4
						(Print 239 13) ; "Beauregard's loose skin ripples as he chases the bone!"
					)
				)
				(event claimed: 1)
			)
			((Said '/beauregard>')
				(cond
					((Said 'get,move,pull,get')
						(switch local0
							(2
								(Print 239 14) ; "The dog doesn't want to move, and he's too heavy to pull."
							)
							(else
								(Print 239 15) ; "You can't. He just wants to eat!"
							)
						)
					)
					((Said 'pat')
						(switch local0
							(0
								(Print 239 16) ; "That wouldn't be a good idea right now."
							)
							(1
								(Print 239 16) ; "That wouldn't be a good idea right now."
							)
							(3
								(Print 239 16) ; "That wouldn't be a good idea right now."
							)
							(2
								(if (< (gEgo distanceTo: Rover) 40)
									(gEgo setScript: PetDog)
								else
									(NotClose) ; "You're not close enough."
								)
							)
						)
					)
					((Said 'talk')
						(Print 239 17) ; "Pricking up his ears, Beauregard listens as you gently speak to him."
					)
					((Said 'yell,yell')
						(Print 239 18) ; "You call to Beauregard but he ignores you."
					)
					((Said 'kill')
						(Print 239 19) ; "That's not a nice thought, Laura!"
					)
					((Said 'kiss')
						(Print 239 20) ; "Don't kiss a dog!"
					)
					((Said 'feed')
						(switch local0
							(0
								(Print 239 21) ; "There's no need for you to feed the dog. Jeeves'll do it."
							)
							(1
								(Print 239 1) ; "Beauregard is more interested in his food right now."
							)
							(2
								(Print 239 22) ; "Beauregard's not hungry anymore."
							)
							(3
								(Print 239 23) ; "He only wants his bone."
							)
						)
					)
				)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 161
		x 256
		view 451
	)

	(method (handleEvent event)
		(cond
			((Said 'talk,ask,tell/butler')
				(Print 239 24) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
			)
			((or (MousedOn self event 3) (Said 'look/butler'))
				(if (& global207 $0400)
					(Print 239 25) ; "Jeeves seems to be busy doing his chores."
				else
					(|= global207 $0400)
					(= global213 11)
					(Say 0 239 26) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Bone of Act
	(properties
		y 159
		x 176
		view 48
		loop 4
	)
)

