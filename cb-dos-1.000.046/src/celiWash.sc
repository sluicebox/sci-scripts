;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 229)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	celiWash 0
)

(synonyms
	(celie person woman)
)

(local
	local0
	[local1 2]
	local3
)

(instance celiWash of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsMESSAGE 243 228)
		(LoadMany rsVIEW 480 22 522 901)
		(= global208 2)
		(= [global377 1] 228)
		(Celie illegalBits: 0 init: setScript: wash)
		(if (== ((gInventory at: 12) owner:) 0) ; soup_bone
			(Rover view: 522 loop: 4 cycleSpeed: 2 setCycle: Fwd init:)
		else
			(Rover init: setScript: dogActions)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'talk/celie')
					(= global213 2)
					(switch local0
						(0
							(Say 1 229 0) ; "I gotta git these dishes done 'fore the Colonel get mad. Go on wid you, now!"
						)
						(1
							(Say 1 229 1) ; "I don't wanna talk. I ain't got nothin' to say!"
						)
						(2
							(Say 1 229 2) ; "Go on, now! Scat!"
						)
						(else
							(Say 1 229 3) ; "I ain't talkin!"
						)
					)
					(++ local0)
				)
				(
					(or
						(Said 'feed,give/bone/beauregard')
						(Said 'feed,give/beauregard/bone')
					)
					(if (gEgo has: 12) ; soup_bone
						(if (< (gEgo distanceTo: Rover) 60)
							(self setScript: giveBone)
						else
							(NotClose) ; "You're not close enough."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				(
					(or
						(Said 'give,feed/*<beauregard')
						(Said 'give,feed/*/beauregard')
						(Said 'feed/beauregard')
					)
					(if global219
						(if global224
							(Print 229 4) ; "Beauregard isn't interested."
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 229 5) ; "That's not your job."
					)
				)
				((or (Said 'show/*/beauregard') (Said 'show/*<beauregard'))
					(if (and global219 global224)
						(if (== global171 12)
							(Print 229 6) ; "Beauregard drools up at the sight of the bone!"
						else
							(Print 229 4) ; "Beauregard isn't interested."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((or (Said 'give/*/beauregard') (Said 'give/*<beauregard'))
					(if global224
						(Print 229 4) ; "Beauregard isn't interested."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said '/beauregard>')
					(cond
						((Said 'get,move')
							(Print 229 7) ; "It doesn't appear that Beauregard wants to move from his spot."
						)
						((Said 'pat')
							(if (< (gEgo distanceTo: Rover) 60)
								(Print 229 8) ; "Okay."
								(self setScript: petDog)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'talk')
							(Print 229 9) ; "The dog pricks up his ears as you speak to him."
						)
						((Said 'yell')
							(Print 229 10) ; "You call to Beauregard but he ignores you."
						)
						((Said 'kill')
							(Print 229 11) ; "That's not a nice thought, Laura!"
						)
						((Said 'kiss')
							(Print 229 12) ; "Don't kiss a dog!"
						)
					)
				)
				(
					(or
						(Said 'dry,scrub/dish')
						(Said 'help/celie')
						(Said 'help/dish/scrub<celie')
					)
					(Print 229 13) ; "Celie's got the dishes under control."
				)
			)
		)
	)
)

(instance wash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(Celie loop: 0 setCycle: Fwd)
				(= seconds (Random 6 12))
			)
			(1
				(Celie cel: 0 loop: 1 setCycle: End self)
				(= state
					(switch (Random 1 2)
						(1 -1)
						(2 1)
					)
				)
			)
			(2
				(Celie loop: 0 stopUpd:)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

(instance petDog of Script
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
				(gEgo loop: 5)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(5
				(gEgo loop: 0)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(6
				(HandsOn)
				(gEgo view: 0 loop: 1 setCycle: Walk)
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
			((not local3)
				(if (and (< (gEgo distanceTo: Rover) 30) (== state 0))
					(= cycles 1)
				)
				(if (and (> (gEgo distanceTo: Rover) 30) (== state 2))
					(= state -1)
					(= cycles 1)
				)
			)
			((< state 3)
				(= state 2)
				(= cycles 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Rover
					loop: 0
					cycleSpeed: 2
					cel: (- (NumCels Rover) 1)
					setCycle: Beg
				)
			)
			(1
				(Rover loop: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(Rover loop: 2 cycleSpeed: 2 setCycle: Fwd)
			)
			(3
				(Bone dispose:)
				(Rover view: 522 loop: 4 cycleSpeed: 2 setCycle: Fwd)
			)
		)
	)
)

(instance giveBone of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (gEgo cel:) 4))
			(gEgo put: 12 0) ; soup_bone
			(Bone init:)
			(++ local3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo (+ (Rover x:) 31) (+ (Rover y:) 3) self
				)
			)
			(1
				(gEgo view: 48 setLoop: 7 cel: 8 setCycle: Beg self)
				(Bone cel: 0 posn: (- (gEgo x:) 13) (- (gEgo y:) 1))
			)
			(2
				(Print 229 14) ; "You give the bone to Beauregard who eagerly begins to gnaw on it."
				(gEgo view: 0 loop: 1)
				(= cycles 1)
			)
			(3
				(gEgo view: 0 setAvoider: 0 setLoop: -1 setCycle: Walk)
				(HandsOn)
				(self setScript: 0)
			)
		)
	)
)

(instance Bone of Prop
	(properties
		y 95
		x 97
		view 522
		loop 8
	)
)

(instance Rover of Prop
	(properties
		y 90
		x 97
		view 527
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/beauregard,dirt'))
			(event claimed: 1)
			(if (IsFlag 49)
				(if local3
					(Print 229 15) ; "You see Beauregard lying on the floor by the stove greedily chewing the bone that you gave him."
				else
					(Print 229 16) ; "You see Beauregard lying on the floor by the stove."
				)
			else
				(SetFlag 49)
				(Print 229 17) ; "Beauregard appears to be a very old (and lazy) bloodhound. His loose skin hangs in folds and his long ears almost drag the ground. You sense that Beauregard must be the Colonel's beloved dog."
			)
		)
	)
)

(instance Celie of Act
	(properties
		y 103
		x 214
		view 486
	)

	(method (handleEvent event)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0002)))
				(event claimed: 1)
				(DoLook {celie})
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event 3) (Said 'look/celie'))
				)
				(event claimed: 1)
				(Print 229 18) ; "Celie is busily washing the dinner dishes."
			)
		)
	)
)

