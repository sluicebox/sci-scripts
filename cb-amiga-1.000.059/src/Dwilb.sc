;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 256)
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
	Dwilb 0
)

(synonyms
	(c c body man)
)

(instance Body of Prop
	(properties
		y 165
		x 87
		view 423
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/c'))
			(event claimed: 1)
			(Print 256 0) ; "It appears as if Wilbur was fatally hit on the head with a blunt instrument."
		)
	)
)

(instance WilburBlock of Blk
	(properties)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dwilb of Rgn
	(properties)

	(method (init)
		(if (== gCurRoomNum 69)
			(Body posn: 272 145)
		)
		(Body init:)
		(= global195 128)
		(if (< global198 200)
			(= global198 200)
			(proc415_1 2)
			(self setScript: showCloseup)
		)
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
				((Said 'get/monocle')
					(if (< (gEgo distanceTo: Body) 25)
						(HandsOff)
						(self setScript: pickUp)
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said '/c>')
					(cond
						((Said 'kill')
							(Print 256 1) ; "He's already dead!"
						)
						((Said 'kiss')
							(Print 256 2) ; "Yuck!!"
						)
						((Said 'embrace')
							(Print 256 3) ; "Ugh!!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 256 4) ; "That would be difficult to do. Perhaps you should get some help."
						)
						((Said '(look<in),search')
							(if (< (gEgo distanceTo: Body) 25)
								(HandsOff)
								(self setScript: pickUp)
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said 'help')
							(Print 256 5) ; "He's beyond help now."
						)
						((Said 'talk')
							(Print 256 6) ; "Wilbur is dead."
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
				(WilburBlock
					top: (Body nsTop:)
					bottom: (Body nsBottom:)
					right: (Body nsRight:)
					left: (Body nsLeft:)
				)
				(gEgo observeBlocks: WilburBlock)
				(= cycles 1)
			)
			(2
				(myMusic play:)
				(Print 256 7 #at 10 75 #icon 423 1 0 #mode 1) ; "Oh, no!! What's happened to Wilbur! Someone must have hit him over the head and killed him! Nervously, you look behind you...but, there's no one there."
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
				(LookAt gEgo Body)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(Print 256 8) ; "With trembling hands, you search Wilbur's body and confirm your suspicions that he died by a tremendous blow to the head."
				(if (not (gEgo has: 1)) ; monocle
					(Print 256 9) ; "What's this?! Why, it's Wilbur's monocle! Thinking it might come in handy, you take it with you."
					(= global182 1)
					(gEgo get: 1) ; monocle
				)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

