;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 276)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	desk 0
)

(synonyms
	(attorney person man)
)

(local
	local0
	local1
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 80 145 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance Clarence of Prop
	(properties
		y 138
		x 267
		view 411
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (& global207 $0040))
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(|= global207 $0040)
				(= global213 7)
				(event claimed: 1)
				(Say 0 276 0) ; "Clarence Sparrow is a dapper-looking man in his late forties. From what you have gleaned, he has been the Colonel's attorney for some time and seems to know the rest of the group as well. His manner is a bit on the curt side and you can sense a bit of sneakiness here."
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 276 1) ; "Clarence looks despondent as he sits hunched over the desk writing something in his notebook."
			)
		)
	)
)

(instance cHead of Prop
	(properties
		y 99
		x 268
		view 411
		loop 1
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (& global207 $0040))
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(|= global207 $0040)
				(= global213 7)
				(event claimed: 1)
				(Say 0 276 0) ; "Clarence Sparrow is a dapper-looking man in his late forties. From what you have gleaned, he has been the Colonel's attorney for some time and seems to know the rest of the group as well. His manner is a bit on the curt side and you can sense a bit of sneakiness here."
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 276 1) ; "Clarence looks despondent as he sits hunched over the desk writing something in his notebook."
			)
		)
	)
)

(instance desk of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= global195 64)
		(cHead setPri: 10 init:)
		(Clarence init:)
		(self setScript: noteBook)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(= global213 7)
			(cond
				((Said 'look>')
					(cond
						((Said '/attorney')
							(Print 276 1) ; "Clarence looks despondent as he sits hunched over the desk writing something in his notebook."
						)
						((Said '/desk')
							(Print 276 2) ; "Clarence's notebook is on the desk."
						)
						((Said '<in/notebook')
							(Print 276 3) ; "Clarence is bent over the notebook and you can't read it."
						)
						((Said '/notebook')
							(Print 276 4) ; "It just looks like an ordinary notebook."
						)
					)
				)
				((Said 'ask//*<about')
					(switch local1
						(0
							(Say 1 276 5) ; "I'm busy! I don't want to talk right now!"
							(++ local1)
						)
						(1
							(Print 276 6) ; "Clarence refuses to answer you as he writes at his desk."
						)
					)
				)
				((Said 'tell//*<about')
					(Print 276 7) ; "Clarence looks deep in thought and doesn't seem to hear you."
				)
				((Said 'show/*')
					(if (and global219 global224)
						(Print 276 8) ; "Clarence doesn't even notice it."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'give/*')
					(if (and global219 global224)
						(Print 276 9) ; "Clarence isn't interested."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said '/attorney>')
					(cond
						((Said 'talk')
							(switch local0
								(0
									(Say 1 276 10) ; "Please, Laura. I'm not in a mood to talk right now."
								)
								(1
									(Say 1 276 11) ; "I have other things on my mind. Leave me alone."
								)
								(2
									(Say 1 276 12) ; "Please! Can't you see I'm trying to write?!"
								)
								(else
									(Print 276 13) ; "Clarence isn't listening to you anymore. He's too involved in his writing."
								)
							)
							(++ local0)
						)
						((Said 'listen')
							(Print 276 14) ; "He's not talking, he's writing."
						)
						((Said 'get')
							(Print 276 15) ; "You wouldn't want him!!"
						)
						((Said 'kill')
							(Print 276 16) ; "Now, now! There's no need for that!"
						)
						((Said 'kiss')
							(Print 276 17) ; "Why...you hardly even know the man!"
						)
						((Said 'embrace')
							(Print 276 18) ; "He's not very huggable."
						)
						((Said 'flirt')
							(Print 276 19) ; "He doesn't appeal to you."
						)
					)
				)
				((Said 'get,open/notebook')
					(Print 276 20) ; "It's Clarence's notebook! You can't take it!"
				)
				((Said 'read/notebook')
					(Print 276 3) ; "Clarence is bent over the notebook and you can't read it."
				)
			)
		)
	)
)

(instance noteBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
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
				(cHead loop: 5 cel: 0 cycleSpeed: 3 setCycle: End)
				(Clarence cycleSpeed: 1 setCycle: Fwd)
				(= seconds (Random 5 12))
			)
			(2
				(Clarence setCycle: 0)
				(cHead setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(3
				(cHead loop: 1 cel: 0 setCycle: End)
				(= seconds (Random 3 5))
			)
			(4
				(cHead setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(5
				(switch (Random 1 2)
					(1
						(= state 0)
					)
					(2
						(= state 2)
					)
				)
				(= seconds (Random 3 5))
			)
		)
	)
)

