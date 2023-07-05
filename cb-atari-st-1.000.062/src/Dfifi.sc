;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 273)
(include sci.sh)
(use Main)
(use Interface)
(use FndBody)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Dfifi 0
)

(synonyms
	(butler man)
	(fifi body woman)
)

(local
	[local0 2]
)

(instance Body of Prop
	(properties
		y 90
		x 154
		view 443
		loop 1
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/fifi,butler,people'))
			(event claimed: 1)
			(Print 273 0) ; "It's not readily apparent how Jeeves and Fifi died as there are no wound marks on their bodies."
		)
	)
)

(instance mySound of Sound
	(properties
		number 99
		priority 1
		loop -1
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dfifi of Rgn
	(properties)

	(method (init)
		(proc415_1 16)
		(Body ignoreActors: 1 init: stopUpd:)
		(= global376 mySound)
		(= global195 1040)
	)

	(method (doit)
		(if (and (not script) (> (gEgo x:) 64))
			(self setScript: showCloseup)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'get,pull,pull,press,move/fifi,butler,fifi')
					(Print 273 1) ; "It would be terribly hard for you to move Jeeves or Fifi. Leave them there for now."
				)
				((Said 'kill')
					(Print 273 2) ; "They're already dead!"
				)
				((Said '(look<in),search/fifi,butler')
					(if (& (gEgo onControl: 0) $0040)
						(gEgo setScript: pickUp)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'look/glass,drink')
					(Print 273 3) ; "It appears that Fifi and Jeeves were drinking cognac when they died."
				)
				((Said 'get/glass,drink')
					(Print 273 4) ; "You shouldn't touch them!"
				)
				((Said '/fifi>')
					(cond
						((Said 'kiss')
							(Print 273 5) ; "Yuck!!"
						)
						((Said 'embrace')
							(Print 273 6) ; "That won't do any good, Laura!"
						)
						((Said 'help')
							(Print 273 7) ; "She's beyond help now!"
						)
						((Said 'talk')
							(Print 273 8) ; "Fifi is dead."
						)
					)
				)
				((Said '/butler>')
					(cond
						((Said 'kiss')
							(Print 273 9) ; "What an awful thought!!"
						)
						((Said 'embrace')
							(Print 273 10) ; "Don't be strange, Laura!"
						)
						((Said 'help')
							(Print 273 11) ; "You can't help him now!"
						)
						((Said 'talk')
							(Print 273 12) ; "Jeeves is dead."
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
				(mySound number: 99 loop: -1 play:)
				(global373 setCycle: Fwd init:)
				(|= gCorpseFlags $0010) ; Jeeves & Fifi
				(SetFlag 22)
				(HandsOff)
				(= seconds 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(myMusic play:)
				(Print 273 13 #at 10 10 #icon 443 0 0 #mode 1) ; "What is happening around here!! You have discovered poor Fifi and Jeeves lying dead on the floor with their spilled drinks nearby. You don't like the looks of this at all!"
				(= cycles 1)
			)
			(3
				(gEgo observeControl: 256)
				(HandsOn)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LookAt gEgo Body)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(Print 273 14) ; "You thoroughly examine Jeeves and Fifi's body but cannot see how they might have died. You are very puzzled."
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

