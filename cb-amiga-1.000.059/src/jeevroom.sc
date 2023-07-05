;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 246)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	jeevroom 0
)

(synonyms
	(butler person man)
)

(local
	local0
	local1
	local2
	local3
)

(instance jeevroom of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 1024)
		(medicine init: stopUpd:)
		(Load rsSOUND 76)
		(= global213 11)
		(Water setPri: 15 init: hide:)
		(switch gAct
			(1
				(if (or (== global155 17) (== [gCycleTimers 2] 1))
					(= global194 0)
					(Jeeves
						view: 457
						illegalBits: 0
						posn: 257 145
						setPri: 13
						cycleSpeed: 12
						setCycle: Fwd
						init:
					)
				)
			)
			(2
				(if (== global194 0)
					(++ global194)
					(LoadMany rsVIEW 442 449 456)
					(Jeeves
						view: 458
						illegalBits: 0
						setAvoider: (Avoid new:)
						posn: 189 96
						init:
					)
					(self setScript: hideAway)
				else
					(Jeeves
						view: 442
						setPri: 14
						posn: 94 133
						cel: 4
						ignoreActors: 1
						init:
					)
					(JHead
						ignoreActors: 1
						setPri: 14
						init:
						setScript: headActions
					)
					(self setScript: sitting)
				)
			)
			(4
				(= global213 28)
				(flowers setPri: 14 init:)
				(LoadMany rsVIEW 454 927)
				(JButt ignoreActors: 1 setPri: 14 init: stopUpd:)
				(Jeeves
					view: 454
					loop: 0
					cel: 0
					illegalBits: 0
					posn: 43 125
					setPri: 14
					init:
					setScript: Primp
				)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'talk/butler')
					(= global213 11)
					(switch gAct
						(1
							(switch local0
								(0
									(Say 1 246 0) ; "I deserve a little peace and quiet in my own room!"
								)
								(1
									(Say 1 246 1) ; "This is highly irregular, Miss Bow!"
								)
								(else
									(Print 246 2) ; "Exasperated, Jeeves closes his eyes and tries to ignore your constant jabber."
								)
							)
							(++ local0)
						)
						(2
							(switch local0
								(0
									(Say 1 246 3) ; "Can't a person have a little privacy around here?!"
								)
								(1
									(Say 1 246 4) ; "Would you mind leaving, Miss Bow?!"
								)
								(2
									(Say 1 246 5) ; "You shouldn't be down here, Miss Bow!"
								)
								(else
									(Print 246 6) ; "Jeeves refuses to indulge himself further in your idle conversation."
								)
							)
							(++ local0)
						)
						(4
							(= global213 28)
							(switch local0
								(0
									(Say 1 246 7) ; "Not you again!"
								)
								(1
									(Say 1 246 8) ; "Miss Bow! This is highly inappropriate!"
								)
								(2
									(Say 1 246 9) ; "Can't you see I'm busy!"
								)
								(3
									(Say 1 246 10) ; "Please give me my privacy, Miss Bow!"
								)
								(else
									(Print 246 11) ; "Frustrated, Jeeves hopes that by ignoring you, you might go away."
								)
							)
							(++ local0)
						)
					)
				)
				((Said 'ask,tell//*<about')
					(if (== gAct 4)
						(= global213 28)
					else
						(= global213 11)
					)
					(switch local1
						(0
							(Say 1 246 12) ; "Kindly leave my room."
						)
						(1
							(Say 1 246 13) ; "Please leave."
						)
						(2
							(Say 1 246 14) ; "I'm tired. I don't want to converse."
						)
						(3
							(Print 246 15) ; "It appears that Jeeves is in no mood to talk."
						)
						(4
							(Say 1 246 16) ; "PLEASE, Miss Bow!"
						)
						(5
							(Print 246 17) ; "Jeeves isn't listening to you."
						)
						(6
							(if (== gAct 1)
								(Print 246 18) ; "Jeeves is trying to rest."
							else
								(Print 246 19) ; "Jeeves must be the strong silent type, he doesn't respond."
							)
						)
						(7
							(Say 1 246 20) ; "I don't feel like talking!"
						)
					)
					(if (< local1 7)
						(++ local1)
					else
						(= local1 0)
					)
				)
				((Said 'give,show/*')
					(if (and global219 global224)
						(switch local2
							(0
								(Print 246 21) ; "It doesn't appear that Jeeves is interested in it."
							)
							(1
								(Print 246 22) ; "Obviously, he doesn't want it."
							)
							(2
								(Print 246 23) ; "Jeeves must not care about it."
							)
							(3
								(Print 246 24) ; "Jeeves shows no interest in it."
							)
							(else
								(Print 246 25) ; "Jeeves doesn't even acknowledge it."
							)
						)
						(++ local2)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said '/butler>')
					(cond
						((Said 'listen/butler')
							(Print 246 26) ; "Jeeves isn't talking to you."
						)
						((Said 'get/butler')
							(Print 246 27) ; "You wouldn't want him!!"
						)
						((Said 'kill/butler')
							(Print 246 28) ; "Now, now! There's no need for that!"
						)
						((Said 'kiss/butler')
							(Print 246 29) ; "He's too strange."
						)
						((Said 'embrace/butler')
							(Print 246 30) ; "He doesn't appeal to you."
						)
					)
				)
				((Said 'flirt//butler<with')
					(Print 246 31) ; "He's not your type!"
				)
				((or (Said 'sleep,lay') (Said 'go/bed,sleep'))
					(if (== gAct 1)
						(Print 246 32) ; "The bed is already occupied."
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance hideAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves cycleSpeed: 1 setCycle: End self)
			)
			(1
				(Jeeves cycleSpeed: 1 setCycle: Beg self)
			)
			(2
				(Jeeves
					view: 456
					loop: 0
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
					setMotion: MoveTo 38 156 self
				)
			)
			(3
				(gEgo observeControl: 16384)
				(Jeeves
					view: 449
					illegalBits: 0
					posn: 43 127
					loop: 6
					cel: 0
					setScript: Primp
				)
				(JButt setPri: 14 ignoreActors: 1 init: stopUpd:)
			)
		)
	)
)

(instance Ocab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo observeControl: 16384)
				(Jeeves loop: 9 cel: 0 setCycle: End self)
				(JButt hide:)
			)
			(1
				(medicine setPri: 14 setCycle: End)
				(= seconds 3)
			)
			(2
				(Jeeves setCycle: Beg self)
			)
			(3
				(medicine setPri: -1 setCycle: Beg self)
				(JButt setPri: 14 show:)
			)
			(4
				(= local3 1)
				(client setScript: 0)
			)
		)
	)
)

(instance Primp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local3
			(= local3 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo observeControl: 16384)
				(Jeeves cycleSpeed: 1 cel: 2 setPri: 14 setCycle: End self)
			)
			(1
				(self setScript: Ocab)
			)
			(2
				(Jeeves loop: 1 setCycle: End self)
			)
			(3
				(Jeeves loop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(Jeeves loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(Jeeves loop: 4 setCycle: Fwd)
				(= seconds 4)
			)
			(6
				(Jeeves loop: 3 cel: 2 setCycle: Beg self)
			)
			(7
				(Jeeves loop: 1 cel: 2 setCycle: Beg self)
			)
			(8
				(self setScript: Ocab)
			)
			(9
				(Jeeves loop: 5 cel: 0 setCycle: End self)
			)
			(10
				(Jeeves loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 6)
			)
			(11
				(Jeeves loop: 5 cel: 2 setCycle: Beg self)
			)
			(12
				(self setScript: Ocab)
			)
			(13
				(Jeeves loop: 7 cel: 0 setCycle: End self)
			)
			(14
				(Jeeves loop: 8 cel: 0 setCycle: Fwd)
				(Water show: setCycle: Fwd)
				(mySound number: 76 loop: -1 play:)
				(= seconds 6)
			)
			(15
				(Water hide:)
				(mySound stop:)
				(Jeeves loop: 7 cel: 2 setCycle: Beg self)
			)
			(16
				(if (== gAct 4)
					(= state 0)
					(= seconds (Random 3 8))
				else
					(= cycles 5)
				)
			)
			(17
				(gEgo ignoreControl: 16384)
				(Jeeves
					view: 456
					setPri: -1
					setCycle: Walk
					posn: 38 156
					cycleSpeed: 0
					setMotion: MoveTo 94 157 self
				)
				(JButt dispose:)
			)
			(18
				(Jeeves
					view: 442
					cel: 0
					loop: 0
					cycleSpeed: 1
					setCycle: End self
					ignoreActors: 1
				)
			)
			(19
				(Jeeves
					setPri: 14
					loop: 1
					posn: 94 133
					ignoreActors: 1
					setScript: sitting
				)
				(JHead ignoreActors: 1 setPri: 14 init: setScript: headActions)
				(client setScript: 0)
			)
		)
	)
)

(instance sitting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves loop: 1 cel: 0 setCycle: End)
				(= seconds (Random 6 12))
			)
			(1
				(Jeeves loop: 2 cel: 0 setCycle: Fwd)
				(= seconds (Random 6 12))
			)
			(2
				(Jeeves loop: 1 cel: 3 setCycle: Beg)
				(= seconds (Random 6 12))
				(= state -1)
			)
		)
	)
)

(instance headActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JHead loop: 3 cel: 0 setCycle: End)
				(= seconds (Random 10 15))
			)
			(1
				(JHead loop: 3 setCycle: Beg)
				(= seconds (Random 10 15))
			)
			(2
				(JHead loop: 4 setCycle: End)
				(= seconds (Random 10 15))
			)
			(3
				(JHead loop: 4 setCycle: Beg)
				(= seconds (Random 10 15))
				(= state -1)
			)
		)
	)
)

(instance JHead of Prop
	(properties
		y 128
		x 95
		view 442
		loop 3
	)
)

(instance Jeeves of Act
	(properties
		y 104
		x 216
		view 458
		loop 2
	)

	(method (handleEvent event)
		(cond
			((and (== gAct 1) (Said 'look[<at]/bed'))
				(Print 246 33) ; "Jeeves is lying on his bed. He must be trying to take a nap."
			)
			((or (MousedOn self event 3) (Said 'look/butler'))
				(if (== gAct 4)
					(= global213 28)
				else
					(= global213 11)
				)
				(event claimed: 1)
				(if (& global207 $0400)
					(switch gAct
						(1
							(Print 246 33) ; "Jeeves is lying on his bed. He must be trying to take a nap."
						)
						(2
							(Print 246 34) ; "Jeeves is trying to enjoy the privacy of his own room!"
						)
						(4
							(Print 246 35) ; "Jeeves must be getting ready to see someone special as he's taking great pains with his appearance while standing at his sink."
						)
					)
				else
					(|= global207 $0400)
					(Say 0 246 36) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
				)
			)
		)
	)
)

(instance flowers of Prop
	(properties
		y 143
		x 250
		view 153
		cel 1
		priority 13
	)

	(method (handleEvent event)
		(cond
			((Said 'get/blossom')
				(Print 246 37) ; "These flowers don't belong to you!"
			)
			((or (MousedOn self event 3) (Said 'look/blossom'))
				(event claimed: 1)
				(Print 246 38) ; "You notice a lovely bouquet of flowers on Jeeves' bed. You have a feeling you know who will be the recipient of these flowers!"
			)
		)
	)
)

(instance medicine of Prop
	(properties
		y 131
		x 28
		view 153
		loop 4
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look<in/mirror') (Said 'look/reflection'))
				(if (< (gEgo distanceTo: medicine) 40)
					(= global213 12)
					(Say 0 246 39) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said '(look<in),open/armoire')
				(Print 246 40) ; "There is nothing you need in Jeeves' medicine cabinet."
			)
			((or (MousedOn self event 3) (Said 'look/armoire,mirror'))
				(event claimed: 1)
				(Print 246 41) ; "There is a mirrored medicine cabinet on the wall next to the sink."
			)
		)
	)
)

(instance JButt of Prop
	(properties
		y 125
		x 43
		view 454
	)
)

(instance mySound of Sound
	(properties)
)

(instance Water of Prop
	(properties
		y 137
		x 40
		view 153
		loop 2
	)
)

