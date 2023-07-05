;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 269)
(include sci.sh)
(use Main)
(use Interface)
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
	[local0 6] = [136 141 69 147 139 141]
	local6
	local7
	local8
)

(instance sweeping of Rgn
	(properties)

	(method (init)
		(super init:)
		(DisposeScript 990)
		(= global195 1024)
		(LoadMany rsVIEW 459 910)
		(Jeeves
			view: 447
			setCycle: Walk
			posn: 330 150
			init:
			setScript: sweepFeather
		)
		(Feather setPri: 8 ignoreActors: 1 init:)
	)

	(method (doit)
		(if (Jeeves isBlocked:)
			(if (not local8)
				(= local8 1)
				(Print 269 0) ; "Would you mind moving, Miss Bow?"
			)
		else
			(= local8 0)
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
	)
)

(instance sweepFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Jeeves setMotion: MoveTo 250 151 self)
				(= global373 1)
			)
			(2
				(|= global141 $0002)
				(Jeeves view: 459 cel: 0 loop: 1 setCycle: End self)
			)
			(3
				(Jeeves loop: 3 setCycle: Fwd)
				(Feather dispose:)
				(= seconds 4)
			)
			(4
				(Jeeves cel: 2 loop: 1 setCycle: Beg self)
			)
			(5
				(Jeeves
					view: 447
					setCycle: Walk
					setMotion:
						MoveTo
						[local0 (* local6 2)]
						[local0 (+ (* local6 2) 1)]
						self
				)
			)
			(6
				(Jeeves view: 459 cel: 0 loop: 0 setCycle: End self)
			)
			(7
				(Jeeves loop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(8
				(Jeeves cel: 2 loop: 0 setCycle: Beg self)
			)
			(9
				(Jeeves view: 447 setCycle: Walk ignoreActors: 0)
				(if (< local6 2)
					(++ local6)
					(= state 4)
				)
				(= cycles 1)
			)
			(10
				(Jeeves setMotion: MoveTo 330 150 self)
			)
			(11
				(= global373 0)
				(Jeeves setScript: 0 dispose:)
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
				(Say 0 269 1) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(event claimed: 1)
				(Print 269 2) ; "You notice Jeeves carpet-sweeping the rug."
			)
			((Said 'ask,tell//*<about')
				(= global213 11)
				(switch (Random 1 7)
					(1
						(Say 1 269 3) ; "It's not my business to gossip with the house guests."
					)
					(2
						(Say 1 269 4) ; "I mind my own business. So should you."
					)
					(3
						(Print 269 5) ; "It appears that Jeeves is trying hard to ignore you."
					)
					(4
						(Say 1 269 6) ; "I only do what I'm told and keep my mouth shut."
					)
					(5
						(Say 1 269 7) ; "Let me do my work, Miss Bow!"
					)
					(6
						(Print 269 8) ; "Jeeves refuses to submit to your persistent chatter."
					)
					(else
						(Say 1 269 9) ; "I never pay attention to anything but my duties."
					)
				)
			)
			((Said 'give,show/*')
				(if (and global219 global224)
					(switch (Random 1 5)
						(1
							(Print 269 10) ; "It doesn't appear that Jeeves is interested in it."
						)
						(2
							(Print 269 11) ; "Obviously, he doesn't want it."
						)
						(3
							(Print 269 12) ; "Jeeves must not care about it."
						)
						(4
							(Print 269 13) ; "Jeeves shows no interest in it."
						)
						(else
							(Print 269 14) ; "Jeeves doesn't even acknowledge it."
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
						(switch local7
							(0
								(Say 1 269 15) ; "I'm busy, Miss Bow. No time for conversation."
							)
							(1
								(Say 1 269 16) ; "It's not up to me to entertain you with idle chitchat."
							)
							(2
								(Say 1 269 17) ; "For the last time, Miss Bow, permit me to finish my work."
							)
							(else
								(Print 269 18) ; "Jeeves completely ignores you."
							)
						)
						(++ local7)
					)
					((Said 'listen')
						(Print 269 19) ; "Jeeves is not a big talker."
					)
					((Said 'get')
						(Print 269 20) ; "You wouldn't want him!!"
					)
					((Said 'kill')
						(Print 269 21) ; "Now, now! There's no need for that!"
					)
					((Said 'kiss')
						(Print 269 22) ; "He's too strange."
					)
					((Said 'embrace')
						(Print 269 23) ; "He doesn't appeal to you."
					)
					((Said 'flirt')
						(Print 269 24) ; "He's not your type!"
					)
				)
			)
		)
	)
)

(instance Feather of Prop
	(properties
		y 151
		x 227
		view 132
		loop 5
	)

	(method (handleEvent event)
		(cond
			((Said 'get/feather')
				(Print 269 25) ; "You see no sense in carrying around a bunch of feathers."
			)
			((or (Said 'look/feather') (MousedOn self event 3))
				(Print 269 26) ; "You wonder how the small pink feathers got on the floor. They look like they may have come from a pillow...or...a feather boa!"
				(event claimed: 1)
			)
		)
	)
)

