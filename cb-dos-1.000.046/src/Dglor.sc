;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 263)
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
	Dglor 0
)

(synonyms
	(actress body woman)
)

(instance Body of Prop
	(properties
		y 138
		x 207
		view 363
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dglor of Rgn
	(properties)

	(method (init)
		(proc415_1 4)
		(Body setPri: 8 init:)
		(|= gCorpseFlags $0004) ; Gloria
		(= global195 4)
		(self setScript: showCloseup)
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
				((Said 'look/boa')
					(Print 263 0) ; "The boa is tightly knotted around Gloria's neck!"
				)
				((Said 'get/boa')
					(Print 263 1) ; "The boa is too tightly knotted around Gloria's neck!"
				)
				((Said '/actress>')
					(cond
						((Said 'kill')
							(Print 263 2) ; "She's already dead!"
						)
						((Said 'kiss')
							(Print 263 3) ; "Yuck!!"
						)
						((Said 'embrace')
							(Print 263 4) ; "Ugh!!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 263 5) ; "Gloria's rather heavy for you. Why don't you find some help?"
						)
						((Said 'look')
							(Print 263 6) ; "It appears that Gloria was strangled with her own feather boa!"
						)
						((Said '(look<in),search')
							(if (< (gEgo distanceTo: Body) 20)
								(if (== gCurRoomNum 24)
									(HandsOff)
									(self setScript: pickUp)
								else
									(Print 263 7) ; "Nervously, you examine Gloria's body and confirm that she was indeed viciously strangled with her feather boa."
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'help')
							(Print 263 8) ; "You can do nothing for her now."
						)
						((Said 'talk')
							(Print 263 9) ; "Gloria is dead."
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
				(Print 263 10 #at 10 60 #icon 363 1 0 #mode 1) ; "What's this?! Gloria is lying very still upon the gazebo floor. On closer inspection, it's clear that someone has strangled Gloria with her own feather boa!"
				(= cycles 1)
			)
			(3
				(HandsOn)
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
				(gEgo setLoop: (gEgo loop:))
				(= cycles 2)
			)
			(1
				(gEgo
					view: 17
					cel: 0
					setMotion: 0
					ignoreControl: -32768
					setCycle: End self
				)
			)
			(2
				(Print 263 7) ; "Nervously, you examine Gloria's body and confirm that she was indeed viciously strangled with her feather boa."
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: 0
					setLoop: -1
					observeControl: -32768
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

