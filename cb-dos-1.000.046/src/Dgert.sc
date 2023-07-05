;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
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
	Dgert 0
)

(synonyms
	(gertie gertie body woman)
)

(instance Body of Prop
	(properties)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dgert of Rgn
	(properties)

	(method (init)
		(proc415_1 1)
		(Body view: 343 cel: 0 posn: 55 126 init:)
		(|= gCorpseFlags $0001) ; Gertie
		(= global195 1)
		(self setScript: showCloseup)
	)

	(method (doit)
		(gEgo observeControl: 256)
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
				((Said '(look<in),search/cloth')
					(if (< (gEgo distanceTo: Body) 20)
						(self setScript: pickUp)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said '/gertie>')
					(cond
						((Said 'kill')
							(Print 235 0) ; "She's already dead!"
						)
						((Said 'kiss')
							(Print 235 1) ; "Ugh!!"
						)
						((Said 'embrace')
							(Print 235 2) ; "Yuck!!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 235 3) ; "Gertie's pretty heavy. Why don't you go tell someone about her?"
						)
						((Said '(look<in),search')
							(if (< (gEgo distanceTo: Body) 20)
								(self setScript: pickUp)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'look,find')
							(Print 235 4) ; "Gertie's dead, all right!"
						)
						((Said 'help')
							(Print 235 5) ; "It's too late."
						)
						((Said 'talk')
							(Print 235 6) ; "Gertie is dead."
						)
					)
				)
				((Said 'ask,show,tell,give')
					(Print 235 6) ; "Gertie is dead."
				)
				((Said 'get/pearl,necklace')
					(Print 235 7) ; "The pearl necklace doesn't belong to you!"
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
				(= cycles 2)
			)
			(1
				(if (not (& (gEgo onControl: 1) $0001))
					(= state 0)
				)
				(= cycles 1)
			)
			(2
				(HandsOff)
				(= seconds 3)
			)
			(3
				(myMusic play:)
				(Print 235 8 #at 10 75 #icon 343 1 0 #mode 1) ; "Oh, dear!! It looks as if Gertie has accidently fallen from her upstairs window and killed herself! Or...was it an accident?!"
				(= cycles 1)
			)
			(4
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
				(LookAt gEgo Body)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(Print 235 9) ; "You quickly examine Gertie's body and see that she died of a broken neck. You can see no clues as to what might have happened."
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

