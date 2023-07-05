;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 382)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sweeping 0
)

(synonyms
	(butler person man)
)

(local
	local0
	local1
)

(instance sweeping of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 1024)
		(LoadMany rsVIEW 459 910)
		(Jeeves view: 447)
		(boa setPri: 1 ignoreActors: 1 init:)
		(if (== ((gInventory at: 9) owner:) 36) ; broken_record
			(Load rsVIEW 17)
			(bRecord setPri: 1 ignoreActors: 1 init:)
			(footprint setPri: 1 ignoreActors: 1 init:)
		)
		(Jeeves illegalBits: -32752 x: 340 y: 100)
		(self setScript: rm36Actions)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look/mud,spot,bootprint'))
			(Print 382 0) ; "You don't see any mud here"
		)
	)
)

(instance rm36Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(= global374 1)
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: 0
					setAvoider: ((Avoid new:) offScreenOK: 1)
					init:
				)
				(Jeeves setMotion: MoveTo 153 110 self)
			)
			(2
				(Jeeves setMotion: MoveTo 132 100 self)
			)
			(3
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: End self)
			)
			(4
				(Jeeves setLoop: 3 setCycle: Fwd)
				(boa dispose:)
				(|= global141 $0004)
				(if (gCast contains: bRecord)
					(bRecord dispose:)
				)
				(= seconds 4)
			)
			(5
				(Jeeves cel: 2 loop: 1 setCycle: Beg self)
			)
			(6
				(Jeeves
					view: 447
					setCycle: Walk
					ignoreActors: 0
					setLoop: -1
					setMotion: MoveTo 117 106 self
				)
			)
			(7
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: End self)
			)
			(8
				(Jeeves setLoop: 3 setCycle: Fwd)
				(footprint dispose:)
				(= seconds 3)
			)
			(9
				(Jeeves cel: 2 loop: 1 setCycle: Beg self)
			)
			(10
				(Jeeves view: 447 setCycle: Walk ignoreActors: 0)
				(Jeeves setLoop: -1 setMotion: MoveTo 340 98 self)
			)
			(11
				(Jeeves dispose:)
				(= global374 0)
				(DisposeScript 985)
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
				(LookAt gEgo bRecord)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(gEgo get: 9) ; broken_record
				(bRecord hide:)
				(= global182 1)
				(Print 382 1) ; "As you bend down to retrieve the largest piece of the broken record, you notice some spots of mud on the rug."
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client dispose: setScript: 0)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 140
		x 196
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (& global207 $0400))
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(= global213 11)
				(|= global207 $0400)
				(event claimed: 1)
				(Say 0 382 2) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(event claimed: 1)
				(Print 382 3) ; "You notice Jeeves carpet-sweeping the rug."
			)
			((Said 'ask,tell//*<about')
				(= global213 11)
				(switch (Random 1 7)
					(1
						(Say 1 382 4) ; "It's not my business to gossip with the house guests."
					)
					(2
						(Say 1 382 5) ; "I mind my own business. So should you."
					)
					(3
						(Print 382 6) ; "It appears that Jeeves is trying hard to ignore you."
					)
					(4
						(Say 1 382 7) ; "I only do what I'm told and keep my mouth shut."
					)
					(5
						(Say 1 382 8) ; "Let me do my work, Miss Bow!"
					)
					(6
						(Print 382 9) ; "Jeeves refuses to submit to your persistent chatter."
					)
					(else
						(Say 1 382 10) ; "I never pay attention to anything but my duties."
					)
				)
			)
			((Said 'give,show/*')
				(if (and global219 global224)
					(switch (Random 1 5)
						(1
							(Print 382 11) ; "It doesn't appear that Jeeves is interested in it."
						)
						(2
							(Print 382 12) ; "Obviously, he doesn't want it."
						)
						(3
							(Print 382 13) ; "Jeeves must not care about it."
						)
						(4
							(Print 382 14) ; "Jeeves shows no interest in it."
						)
						(else
							(Print 382 15) ; "Jeeves doesn't even acknowledge it."
						)
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/butler>')
				(cond
					((Said 'talk')
						(= global213 11)
						(switch local1
							(0
								(Say 1 382 16) ; "I'm busy, Miss Bow. No time for conversation."
							)
							(1
								(Say 1 382 17) ; "It's not up to me to entertain you with idle chitchat."
							)
							(2
								(Say 1 382 18) ; "For the last time, Miss Bow, permit me to finish my work."
							)
							(else
								(Print 382 19) ; "Jeeves completely ignores you."
							)
						)
						(++ local1)
					)
					((Said 'listen')
						(Print 382 20) ; "Jeeves is not a big talker."
					)
					((Said 'get')
						(Print 382 21) ; "You wouldn't want him!!"
					)
					((Said 'kill')
						(Print 382 22) ; "Now, now! There's no need for that!"
					)
					((Said 'kiss')
						(Print 382 23) ; "He's too strange."
					)
					((Said 'embrace')
						(Print 382 24) ; "He doesn't appeal to you."
					)
				)
			)
			((Said 'flirt//butler<with')
				(Print 382 25) ; "He's not your type!"
			)
		)
	)
)

(instance bRecord of Prop
	(properties
		y 96
		x 115
		view 136
		loop 2
		cel 7
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event 3) (Said 'look/record'))
				(Print 382 26) ; "A broken record lies on the floor."
				(event claimed: 1)
			)
			((Said 'get/record[<broken]')
				(if (< (gEgo distanceTo: bRecord) 15)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance boa of Prop
	(properties
		y 100
		x 90
		view 136
		loop 9
		cel 3
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/feather'))
				(Print 382 27) ; "The small pile of pink feathers looks terribly suspicious! Could they have come from Gloria's feather boa?!!"
				(event claimed: 1)
			)
			((Said 'get/feather')
				(Print 382 28) ; "You see no sense in carrying around a bunch of feathers."
			)
		)
	)
)

(instance footprint of Prop
	(properties
		y 106
		x 100
		view 136
		loop 3
		cel 3
	)

	(method (handleEvent event)
		(cond
			((Said 'get/mud')
				(Print 382 29) ; "There is no reason for you to carry around mud."
			)
			((or (MousedOn self event 3) (Said 'look/mud,spot,bootprint'))
				(Print 382 30) ; "The muddy spot looks like a partial footprint."
				(event claimed: 1)
			)
		)
	)
)

