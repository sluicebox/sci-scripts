;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 278)
(include sci.sh)
(use Main)
(use Interface)
(use FndBody)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	Dclar 0
)

(synonyms
	(attorney body man)
)

(instance Body of Prop
	(properties
		y 94
		x 199
		view 403
		loop 1
		cel 1
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dclar of Rgn
	(properties)

	(method (init)
		(if (== (= global106 gCurRoomNum) 73)
			(Body view: 403 loop: 1 cel: 2 posn: 241 141)
		else
			(ClearFlag 35)
		)
		(Body init:)
		(= global195 64)
		(if (< global201 200)
			(= global201 200)
			(proc415_1 32)
			(self setScript: showCloseup)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/dagger')
					(Print 278 0) ; "A pearl-handled dagger is stuck in Clarence's chest."
				)
				((Said 'get/dagger')
					(Print 278 1) ; "You don't need to touch that thing!"
				)
				((Said '/attorney>')
					(cond
						((Said 'kill')
							(Print 278 2) ; "He's already dead!"
						)
						((Said 'kiss')
							(Print 278 3) ; "That's too strange!"
						)
						((Said 'embrace')
							(Print 278 4) ; "Yuck!!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 278 5) ; "He's awfully heavy. It would be difficult for you to do so."
						)
						((Said '(look<in),search')
							(if (< (gEgo distanceTo: Body) 40)
								(if (not (gEgo has: 16)) ; matches
									(Print 278 6) ; "Shaking terribly, you search Clarence's body and establish that he did indeed die by a stab wound to the chest."
									(Print 278 7) ; "Upon further searching you discover a pack of matches in Clarence's coat pocket. Thinking it might come in handy, you take it with you."
									(= global182 1)
									(gEgo get: 16) ; matches
								else
									(Print 278 8) ; "You've already done that!"
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'look')
							(Print 278 9) ; "It's readily apparent that Clarence was mortally stabbed in the chest with a sharp dagger."
						)
						((Said 'help')
							(Print 278 10) ; "He's beyond help now."
						)
						((Said 'talk')
							(Print 278 11) ; "Clarence is dead."
						)
					)
				)
			)
		)
	)
)

(instance showCloseup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(myMusic play:)
				(Print 278 12 #at 10 10 #icon 403 0 0 #mode 1) ; "This is horrendous!! Now it's Clarence! Someone has killed him by stabbing him in the chest with a dagger! If only there were a way to flee this terrible island...!"
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

