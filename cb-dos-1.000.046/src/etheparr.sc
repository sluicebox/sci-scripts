;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 238)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	etheparr 0
)

(synonyms
	(ethel person woman)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(Ethel loop: 1 setCycle: Fwd)
	(Print &rest #at 80 145 #font 4 #width 125 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(Print &rest #at 171 145 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance etheparr of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= global195 8)
		(Ethel init: setScript: ethelParrot)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said '/drink,glass>'))
			(cond
				((Said 'look')
					(Print 238 0) ; "It seems to be a very strong, alcoholic drink."
				)
				((Said 'get')
					(Print 238 1) ; "You don't want it!"
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance ethelParrot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel loop: 0 setCycle: End self)
			)
			(1
				(User canInput: 0)
				(if local1
					(switch local1
						(1
							(localproc_0 238 2) ; "Polly wanna cracker? Hic!"
						)
						(2
							(localproc_0 238 3) ; "Yer a shmart bird, Polly. YOU know whash happenin' 'round here, don'cha?"
						)
						(3
							(localproc_1 238 4) ; "AWWK!"
						)
						(4
							(localproc_0 238 5) ; "Thish whole fam'ly's fer the birds...no offensh, Polly."
						)
						(else
							(localproc_0 238 6) ; "Purrty Polly!"
						)
					)
				else
					(localproc_0 238 7) ; "Ya know, Polly...you really unnerstand me, don'cha, huh?"
				)
				(= seconds 5)
			)
			(2
				(Ethel setCycle: 0)
				(if local1
					(switch local1
						(1
							(localproc_1 238 8) ; "AWWK! Cracker...Hic!"
						)
						(2
							(localproc_1 238 9) ; "AWWK! Smart bird. Smart bird. AWWK!"
						)
						(3
							(localproc_0 238 10) ; "Whash'u say, Polly?"
						)
						(4
							(localproc_1 238 11) ; "Family...birds. AWWK!"
						)
						(else
							(localproc_1 238 12) ; "Pretty Polly. AWWK!"
						)
					)
				else
					(localproc_1 238 13) ; "AWWK! Polly. AWWK!"
				)
				(++ local1)
				(= seconds 3)
			)
			(3
				(User canInput: 1)
				(cls)
				(Ethel loop: 0 cel: 3 setCycle: Beg)
				(if (< (Random 1 100) 20)
					(= state 6)
				)
				(= seconds 10)
			)
			(4
				(Ethel loop: 2 cel: 0 cycleSpeed: 2 setCycle: End)
				(= seconds 3)
			)
			(5
				(Ethel setCycle: Beg self)
			)
			(6
				(if (< (Random 1 100) 20)
					(= state -1)
				)
				(= seconds 10)
			)
			(7
				(Ethel loop: 3 setCycle: End)
				(if (< (Random 1 100) 20)
					(= state -1)
				)
				(= seconds (Random 6 12))
			)
			(8
				(Ethel loop: 4 cel: 0 setCycle: End)
				(= seconds (Random 3 6))
			)
			(9
				(Ethel loop: 5 cel: 0 setCycle: End)
				(if (< (Random 1 100) 20)
					(= state -1)
				else
					(= state 3)
				)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance Ethel of Act
	(properties
		y 102
		x 168
		view 329
		illegalBits 0
	)

	(method (handleEvent event)
		(= global213 4)
		(cond
			(
				(or
					(Said 'ask,tell/parrot>')
					(Said 'show,give/*/parrot>')
					(Said 'show,give/*<parrot>')
				))
			((or (MousedOn self event 3) (Said 'look/ethel'))
				(if (not (& global207 $0008))
					(|= global207 $0008)
					(Say 0 238 14) ; "Ethel is a stylishly-dressed, overly made-up older woman. Many years of hard drinking have taken their toll on her as her face is puffy and red, and her skin has wrinkled prematurely. She always seems to have a drink in her hand. You have never met her before, but Ethel is your friend Lillian's mother."
				else
					(Print 238 15) ; "Ethel sits at the bar and, as usual, is hitting the booze. She seems to be taking an inordinate interest in the parrot."
				)
				(event claimed: 1)
			)
			((Said 'ask,tell//*<about')
				(switch (Random 1 8)
					(1
						(Say 1 238 16) ; "Huh?"
					)
					(2
						(Say 1 238 17) ; "Whash'at you say?"
					)
					(3
						(Say 1 238 18) ; "Hic!"
					)
					(4
						(Print 238 19) ; "Ethel looks at you blearily."
					)
					(5
						(Say 1 238 20) ; "How'sh about a liddle shnort?"
					)
					(6
						(Say 1 238 21) ; "That shounds nice."
					)
					(7
						(Say 1 238 22) ; "What? Hic!"
					)
					(else
						(Print 238 23) ; "Ethel isn't comprehending."
					)
				)
			)
			((or (Said 'give/*<ethel') (Said 'give/*[/ethel]'))
				(if (and global219 global224)
					(Print 238 24) ; "Ethel doesn't care about it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((or (Said 'show/*<ethel') (Said 'show/*[/ethel]'))
				(if (and global219 global224)
					(Print 238 25) ; "Ethel doesn't even look at it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/ethel>')
				(cond
					((Said 'talk')
						(switch local0
							(0
								(Print 238 26) ; "Ethel is more interested in the parrot; she doesn't seem to notice you."
							)
							(1
								(Say 1 238 27) ; "Huh? Who'shat?"
								(Say 1 238 28) ; "Ohhh. Ish'you, Laura. Hic!"
							)
							(2
								(Say 1 238 29) ; "Hey, ya wanna liddle shhnort, Laura?"
								(= global213 12)
								(Say 1 238 30) ; "You politely decline as you don't drink."
								(= global213 4)
								(Say 1 238 31) ; "Have it yer ownnn way. Hic!"
							)
							(3
								(Say 1 238 32) ; "Ish'at you, Polly? Hic!""
								(Say 1 238 33) ; "Ohhh'hi, Laura!"
								(Print 238 34) ; "Ethel doesn't seem too coherent."
							)
							(4
								(Say 1 238 35) ; "Wanna liddle dddrink, hhuhhh...Laura?"
								(= global213 12)
								(Say 1 238 36) ; "Again, you politely refuse her invitation."
							)
							(else
								(Print 238 37) ; "Ethel is too befuddled. You can't talk to her."
							)
						)
						(++ local0)
					)
					((Said 'listen')
						(Print 238 38) ; "Ethel doesn't seem to be saying anything intelligent."
					)
					((Said 'get')
						(Print 238 39) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 238 40) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 238 41) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 238 42) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

