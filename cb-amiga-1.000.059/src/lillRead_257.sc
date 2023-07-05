;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 257)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
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
)

(procedure (localproc_0)
	(Print &rest #at 40 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance lillRead of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0001))
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsFONT 41)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(Load rsFONT 4)
		(LoadMany rsMESSAGE 406 243 288)
		(Load rsVIEW 905)
		(= global208 32)
		(= [global377 5] 288)
		(Lillian init:)
		(LHead init: stopUpd:)
		(Book init: stopUpd:)
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
				((Said 'look>')
					(cond
						((Said '/book')
							(if (< (gEgo distanceTo: Lillian) 40)
								(Print 257 0) ; "You glance at the book in Lillian's hand and see that it is an old fairy tale, entitled... "Bluebeard!""
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/doll')
							(Print 257 1) ; "The dolls look like they've been here for a long time! You wonder who they used to belong to. The big question is: WHY is Lillian reading a book to them?!"
						)
					)
				)
				((Said 'get>')
					(cond
						((Said '/book')
							(Print 257 2) ; "Lillian has it!"
						)
						((Said '/doll')
							(Print 257 3) ; "The dolls don't belong to you!"
						)
					)
				)
				((Said 'read/book')
					(if (< (gEgo distanceTo: Lillian) 40)
						(Print 257 0) ; "You glance at the book in Lillian's hand and see that it is an old fairy tale, entitled... "Bluebeard!""
					else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (== (Lillian cel:) 4))
			(Book hide:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
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
				(Lillian loop: 6 setCycle: Beg self)
			)
			(2
				(LHead loop: 5 setCycle: Fwd)
				(User canInput: 0)
				(switch local1
					(0
						(localproc_0 257 4) ; "And then he said..."
					)
					(1
						(localproc_0 257 5) ; "So she stuck the key in the lock and..."
					)
					(2
						(localproc_0 257 6) ; "She thought she was alone but..."
					)
					(3
						(localproc_0 257 7) ; "And what happened then was..."
					)
					(4
						(localproc_0 257 8) ; "As she quietly opened the door..."
					)
					(5
						(localproc_0 257 9) ; "He roared with anger as..."
					)
					(6
						(localproc_0 257 10) ; "The house was too quiet..."
					)
					(7
						(localproc_0 257 11) ; "And she said to him..."
					)
					(8
						(localproc_0 257 12) ; "She screamed when she saw..."
					)
					(else
						(localproc_0 257 13) ; "So up the stairs she went..."
					)
				)
				(if (< local1 9)
					(++ local1)
				else
					(= local1 0)
				)
				(= seconds 4)
			)
			(3
				(LHead loop: 5 setCycle: 0)
				(cls)
				(User canInput: 1)
				(= seconds 3)
			)
			(4
				(Lillian loop: 2 setCycle: End)
				(if (< (Random 1 100) 15)
					(= state 3)
				)
				(= seconds (Random 6 12))
			)
			(5
				(LHead loop: 3 setCycle: End)
				(= seconds (Random 3 8))
			)
			(6
				(LHead setCycle: Beg)
				(if (< (Random 1 100) 25)
					(= state 3)
				else
					(= state 1)
				)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 141
		x 187
		view 506
		loop 6
		cel 5
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((Said 'talk/lil')
				(= global213 6)
				(switch local0
					(0
						(Say 1 257 14) ; "Huh?! What're you doing here, Laura?!"
					)
					(1
						(Say 1 257 15) ; "Uh, I'm kinda busy right now. I have to finish the story."
					)
					(2
						(Say 1 257 16) ; "Hush, Laura! You're interrupting us!"
					)
					(else
						(Print 257 17) ; "Lillian has retreated into her book again. She doesn't answer you."
					)
				)
				(++ local0)
			)
			((Said 'tell,ask/lil')
				(Print 257 18) ; "It would appear that Lillian is more interested in reading a book to some old dolls than talking to you! It would probably be best to leave her alone right now."
			)
			((Said 'give,show/lil')
				(Print 257 19) ; "Lillian doesn't notice it."
			)
			((Said 'listen/lil')
				(Print 257 20) ; "Lillian is reading a story to the dolls. It appears to be some sort of horrible fairy tale."
			)
			((Said 'get/lil')
				(Print 257 21) ; "You can't get her!"
			)
			((Said 'kill/lil')
				(Print 257 22) ; "There's no need for THAT sort of thing!"
			)
			((Said 'kiss/lil')
				(Print 257 23) ; "You don't feel like kissing her."
			)
			((Said 'embrace/lil')
				(Print 257 24) ; "You don't feel like hugging her."
			)
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(|= global207 $0020)
				(= global213 6)
				(event claimed: 1)
				(Say 0 257 25) ; "Your friend Lillian Prune, is a rebellious flapper. Like you, she is twenty years old, but unlike you, she has been known to hang out in sleazy speakeasies, smoke, and run around with several young men. She is very assertive and out-going, to the point of obnoxiousness, but underneath it all you believe her to be a lonely, insecure girl."
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(event claimed: 1)
				(Print 257 26) ; "This is a bit odd! Your friend seems to be reading a book to those old dolls!"
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 141
		x 189
		z 33
		view 506
		loop 3
	)
)

(instance Book of Prop
	(properties
		y 123
		x 177
		view 163
		loop 2
		cel 2
	)
)

