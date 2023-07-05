;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Dlill 0
)

(synonyms
	(lil body woman)
)

(local
	local0
	local1
	local2
	local3
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Body of Prop
	(properties
		y 114
		x 91
		view 503
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/lil'))
			(Print 280 0) ; "You can tell by looking at her that Lillian died of a gunshot wound to the chest at point-blank range."
			(Print 280 1) ; "Huh...this is strange. For some reason, Lillian is dressed in an old army officer's cape, hat, gloves, and boots!"
			(event claimed: 1)
		)
	)
)

(instance Shot of Prop
	(properties
		y 105
		x 72
		view 503
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 280 2) ; "There is a bullet lying on the ground near Lillian's hand."
		)
	)
)

(instance Pistol of Prop
	(properties
		y 122
		x 61
		view 503
		loop 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 280 3) ; "You notice the silver derringer lying on the ground near to Lillian's feet."
		)
	)
)

(instance Dlill of Rgn
	(properties)

	(method (init)
		(Body ignoreActors: 1 init: stopUpd:)
		(if (not global185)
			(if (not (gEgo has: 14)) ; bullet
				(= local3 1)
				(Shot init: stopUpd:)
			)
			(if (not (gEgo has: 15)) ; derringer
				(= local2 1)
				(Pistol init: stopUpd:)
			)
		)
		(= global195 32)
		(if (not (& gCorpseFlags $0040)) ; Lillian
			(= [gCycleTimers 0] 3600)
			(= global111 75)
			(self setScript: showCloseup)
		)
	)

	(method (doit)
		(gEgo observeControl: 256)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/lil>')
					(cond
						((Said 'kill')
							(Print 280 4) ; "She's already dead!"
						)
						((Said 'kiss')
							(Print 280 5) ; "You were never THAT fond of her!"
						)
						((Said 'embrace')
							(Print 280 6) ; "Ugh!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 280 7) ; "She would be terribly heavy for you. You shouldn't try it."
						)
						((Said '(look<in),search')
							(if (< (gEgo distanceTo: Body) 25)
								(if (not (gEgo has: 5)) ; skeleton_key
									(= local1 3)
									(self setScript: pickUp)
								else
									(Print 280 8) ; "You've already done that!"
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'help')
							(Print 280 9) ; "You can't help her now. It's too late."
						)
						((Said 'talk')
							(Print 280 10) ; "Lillian is dead."
						)
					)
				)
				((Said 'get>')
					(cond
						((Said '/derringer')
							(SetFlag 26)
							(cond
								((gEgo has: 15) ; derringer
									(AlreadyTook) ; "You already took it."
								)
								((< (gEgo distanceTo: Pistol) 10)
									(= local1 1)
									(= local2 0)
									(Pistol setScript: pickUp)
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
						((Said '/bullet')
							(cond
								(global185
									(Print 280 11) ; "It would not be wise to unload the derringer at this time."
								)
								((gEgo has: 14) ; bullet
									(AlreadyTook) ; "You already took it."
								)
								((< (gEgo distanceTo: Shot) 10)
									(= local3 0)
									(= local1 2)
									(Shot setScript: pickUp)
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
						((Said '/cape')
							(Print 280 12) ; "You don't want that old, bloodstained cape!"
						)
						((Said '/hat')
							(Print 280 13) ; "You have no need of a hat."
						)
						((Said '/boot')
							(Print 280 14) ; "These boots are much too big for your feet!"
						)
						((Said '/glove')
							(Print 280 15) ; "You don't need any leather gloves."
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '<in/cape')
							(Print 280 16) ; "With trembling hands, you examine Lillian's body and see the horrible gunshot wound to her chest area."
							(if (not (gEgo has: 5)) ; skeleton_key
								(self setScript: pickUp)
							else
								(Print 280 17) ; "There is nothing else in the cape."
							)
						)
						((Said '/cape')
							(Print 280 18) ; "The old, bloodstained army cape looks to be at least thirty years old."
						)
						((Said '<in/hat')
							(Print 280 19) ; "There is nothing but Lillian's head in the hat."
						)
						((Said '/hat')
							(Print 280 20) ; "It looks like an old Colonel's hat."
						)
						((Said '<in/boot')
							(Print 280 21) ; "There is nothing but Lillian's feet in the boots."
						)
						((Said '/boot')
							(Print 280 22) ; "The large, muddy-soled army boots look like the old-fashioned kind of thirty years ago. You see a distinct insignia on the boot heels."
						)
						((Said '<in/glove')
							(Print 280 23) ; "There is nothing but Lillian's hands in the gloves."
						)
						((Said '/glove')
							(Print 280 24) ; "The cracked and worn leather gloves look very old. You notice dried bloodstains on them."
						)
						((Said '/insignia,heel')
							(if (< (gEgo distanceTo: Body) 40)
								(= local1 4)
								(self setScript: pickUp)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((or (Said '/dirt') (Said '<down'))
							(cond
								(local2
									(Print 280 25) ; "You notice the silver derringer lying on the ground near Lillian's feet."
								)
								(local3
									(Print 280 2) ; "There is a bullet lying on the ground near Lillian's hand."
								)
								(else
									(event claimed: 0)
								)
							)
						)
					)
				)
				((Said 'wear>')
					(cond
						((Said '/cape')
							(Print 280 12) ; "You don't want that old, bloodstained cape!"
						)
						((Said '/hat')
							(Print 280 13) ; "You have no need of a hat."
						)
						((Said '/boot')
							(Print 280 14) ; "These boots are much too big for your feet!"
						)
						((Said '/glove')
							(Print 280 15) ; "You don't need any leather gloves."
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
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gCorpseFlags $0040)) ; Lillian
						(|= gCorpseFlags $0040) ; Lillian
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(myMusic play:)
				(Print 280 26 #at 10 75 #icon 503 3 0 #mode 1) ; "Oh, no!!! Someone has shot Lillian to death in the hedge garden!! Quite afraid now, you fear greatly for your own life!"
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (== local1 1) (== local1 2))
					(LookAt gEgo client)
				else
					(LookAt gEgo Body)
				)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(if (or (== local1 1) (== local1 2))
					(client hide:)
				)
				(switch local1
					(1
						(= global182 1)
						(gEgo get: 15) ; derringer
						(if (gEgo has: 14) ; bullet
							(Ok) ; "Okay."
						else
							(Print 280 27) ; "As you stoop to pick up the derringer your eye happens to fall upon a bullet not far from Lillian's hand."
						)
					)
					(3
						(= global182 1)
						(gEgo get: 5) ; skeleton_key
						(Print 280 16) ; "With trembling hands, you examine Lillian's body and see the horrible gunshot wound to her chest area."
						(Print 280 28) ; "What's this?! You suddenly find a skeleton key in a pocket of the old army cape. Since it may be useful, you take it with you."
					)
					(2
						(= global182 1)
						(gEgo get: 14) ; bullet
						(Ok) ; "Okay."
					)
					(4
						(switch local0
							(0
								(Print 280 29) ; "After brushing away some of the dried mud, you can plainly see an insignia of an eagle on the boot heels."
							)
							(else
								(Print 280 30) ; "You can see an insignia of an eagle on the boot heels."
							)
						)
						(++ local0)
					)
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(if (or (== local1 1) (== local1 2))
					(client dispose:)
				)
				(client setScript: 0)
			)
		)
	)
)

