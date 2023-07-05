;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 282)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	lillRead 0
)

(synonyms
	(lil person woman)
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 40 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance lillRead of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= global195 32)
		(if (not (& gMustDos $0002))
			(Load rsFONT 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(Lillian init: stopUpd:)
		(self setScript: reading)
	)

	(method (doit)
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
				((Said 'play[/doll]')
					(Print 282 0) ; "You have better things to do, Laura!"
				)
				((Said 'look/blackboard')
					(Print 282 1) ; "You see a small chalkboard on the wall. Strange, there are seven tally marks on it."
				)
				((Said 'get/blackboard')
					(Print 282 2) ; "The chalkboard is attached to the playhouse wall. You can't take it."
				)
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
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
				(Lillian loop: 8 cycleSpeed: 1 setCycle: Fwd)
				(if (not local1)
					(++ local1)
					(Print 282 3 #dispose) ; "We have a visitor, darlings. Sit up straight now."
				)
				(if (< (Random 1 100) 51)
					(= state 4)
				)
				(= seconds (Random 3 12))
			)
			(2
				(cls)
				(Lillian loop: 1 setCycle: End)
				(if (< (Random 1 100) 51)
					(= state 5)
				)
				(= seconds (Random 3 12))
			)
			(3
				(Lillian loop: 0 setCycle: Fwd)
				(Print 282 4 #dispose) ; "Rock-a-bye, baby."
				(= seconds (Random 3 12))
			)
			(4
				(cls)
				(Lillian loop: 1 cel: 2 setCycle: Beg)
				(cond
					((< (= local2 (Random 1 100)) 31)
						(= state 0)
					)
					((> local2 70)
						(= state 1)
					)
				)
				(= seconds (Random 3 12))
			)
			(5
				(cls)
				(Lillian loop: 7 setCycle: Fwd)
				(if (< (Random 1 100) 51)
					(= state 0)
				else
					(= state 1)
				)
				(= seconds (Random 3 12))
			)
			(6
				(Lillian loop: 4 setCycle: Fwd)
				(= state 3)
				(= seconds (Random 3 12))
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 141
		x 187
		view 506
		loop 8
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(|= global207 $0020)
				(= global213 6)
				(event claimed: 1)
				(Say 0 282 5) ; "Your friend Lillian Prune, is a rebellious flapper. Like you, she is twenty years old, but unlike you, she has been known to hang out in speakeasies, smoke, and run around with several young men. She is assertive and outgoing, to the point of obnoxiousness, but underneath it all you believe her to be a lonely, insecure girl."
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(event claimed: 1)
				(Print 282 6) ; "Lillian is acting VERY bizarre! Not only is she playing with the old dolls, but she's treating them as if they were alive! She barely notices you."
			)
			((Said 'tell,ask//*<about')
				(Print 282 7) ; "Lillian is caught up in some fantasy world with those dolls! She's not listening to you."
			)
			((Said 'give,show/*')
				(if (and global219 global224)
					(Print 282 8) ; "Your friend is too involved with those dolls to really notice you."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/lil>')
				(cond
					((Said 'talk')
						(= global213 6)
						(switch local0
							(0
								(Say 1 282 9) ; "Our visitor is talking to us. Pay attention now."
							)
							(1
								(Say 1 282 10) ; "What? We don't want any visitors?"
							)
							(2
								(Say 1 282 11) ; "Oh! We don't want anybody to know our secret. Our visitor will have to leave."
							)
							(3
								(Say 1 282 12) ; "You'll have to go. We don't want to play with you right now."
							)
							(4
								(Say 1 282 13) ; "Maybe if we ignore her, darlings, she will go away. Hussshhhh!"
							)
							(else
								(Print 282 14) ; "Lillian is lost in her own world. She doesn't seem to even notice you anymore."
							)
						)
						(++ local0)
					)
					((Said 'get')
						(Print 282 15) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 282 16) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 282 17) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 282 18) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

