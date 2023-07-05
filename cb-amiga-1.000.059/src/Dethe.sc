;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 268)
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
	Dethe 0
)

(synonyms
	(ethel body woman)
)

(local
	local0
)

(instance Body of Prop
	(properties
		view 323
		cel 1
	)
)

(instance myMusic of Sound
	(properties
		number 120
		priority 5
	)
)

(instance Dethe of Rgn
	(properties)

	(method (init)
		(proc415_1 8)
		(if (== gCurRoomNum 61)
			(Body view: 331 posn: 42 125 setPri: 11 init:)
		else
			(Body posn: 157 95 setPri: 4 ignoreActors: 1 init:)
			(gEgo observeControl: 256)
		)
		(= gEthelState 100)
		(= global195 8)
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
				((Said 'look/head')
					(Print 268 0) ; "You see a large groove across her skull."
				)
				((Said '/ethel>')
					(cond
						((Said 'kill')
							(Print 268 1) ; "She's already dead!"
						)
						((Said 'kiss')
							(Print 268 2) ; "You didn't want to do that when she was alive!"
						)
						((Said 'embrace')
							(Print 268 3) ; "That's touching, Laura...but kind of strange!"
						)
						((Said 'get,pull,pull,press,move')
							(Print 268 4) ; "Ethel's pretty heavy; you might hurt yourself."
						)
						((Said '(look<in),search')
							(cond
								(local0
									(Print 268 5) ; "You've already done that!"
								)
								((< (gEgo distanceTo: Body) 25)
									(if (== gCurRoomNum 61)
										(Print 268 6) ; "You fearfully search Ethel's body and find that she was indeed killed by a terrible hit on the head."
									else
										(self setScript: pickUp)
									)
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
						((Said 'look')
							(Print 268 7) ; "It looks like Ethel was hit fatally on the head with a heavy, blunt instrument."
						)
						((Said 'help')
							(Print 268 8) ; "It's now too late."
						)
						((Said 'talk')
							(Print 268 9) ; "Ethel is dead."
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
				(if (not (& gCorpseFlags $0008)) ; Ethel
					(|= gCorpseFlags $0008) ; Ethel
					(myMusic play:)
					(if (!= gCurRoomNum 61)
						(Print 268 10 #at 10 10 #icon 323 1 0 #mode 1) ; "This is dreadful!! Poor Ethel has been hit over the head and killed! Something terrible is going on around here and you suddenly feel a cold fear spreading ominously throughout your body!"
					else
						(Print 268 10 #at 10 10 #icon 331 1 0 #mode 1) ; "This is dreadful!! Poor Ethel has been hit over the head and killed! Something terrible is going on around here and you suddenly feel a cold fear spreading ominously throughout your body!"
					)
				)
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
				(Print 268 6) ; "You fearfully search Ethel's body and find that she was indeed killed by a terrible hit on the head."
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

