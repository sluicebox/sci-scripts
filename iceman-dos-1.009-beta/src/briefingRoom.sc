;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use n824)
(use n954)
(use LoadMany)
(use DPath)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	briefingRoom 0
)

(local
	local0
	local1
)

(instance briefingRoom of Rm
	(properties
		picture 21
		vanishingX 153
		vanishingY -20
	)

	(method (dispose)
		(proc0_3)
		(gIceGlobalSound fade:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 204 421 21 121 221 421 521)
		(slideShowWest init:)
		(slideShowEast init:)
		(Braxton init:)
		(Agent init:)
		(envelope init: setPri: 9)
		(coffeeCup init:)
		(HandsOff)
		(gAddToPics
			add:
				chair
				(= local0 ((Clone chair) x: 156 y: 144 yourself:))
				(= local1 ((Clone chair) x: 95 y: 145 yourself:))
				flag
			doit:
		)
		(gEgo posn: 270 206 view: 204 loop: 3 init: setScript: egoEnters)
		(self setScript: briefingScript setFeatures: table)
		(proc824_0)
		(gIceGlobalSound number: (proc0_5 63) priority: 1 loop: -1 play:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(if (Said '[<around][/room]')
					(Print 21 0) ; "This is the briefing room."
				)
			)
			((Said 'stand,(get<up)')
				(gEgo setScript: egoStandScript)
			)
			((Said 'get/drink,cup,coffee')
				(Print 21 1) ; "It's just an empty cup and is of no use to you."
			)
			((Said 'open/door')
				(Print 21 2) ; "You won't have any trouble opening the door if you just walk over to it."
			)
		)
	)
)

(instance slideShowWest of Prop
	(properties
		y 103
		x 119
		view 21
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 8 stopUpd: setCel: 0)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance slideShowEast of Prop
	(properties
		y 103
		x 215
		view 21
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 8 stopUpd: setCel: 0)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance slideWest of View
	(properties
		y 103
		x 119
		view 21
		loop 6
		cel 4
	)

	(method (init)
		(super init:)
		(self setPri: 7)
	)
)

(instance slideEast of View
	(properties
		y 103
		x 215
		view 21
		loop 6
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 7)
	)
)

(instance blackOutSlide of View
	(properties
		y 103
		x 119
		view 21
		loop 6
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)
)

(instance briefingScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if
			(or
				(OneOf state 47 48)
				(!= (event type:) evKEYBOARD)
				(!= (event message:) KEY_RETURN)
				(event claimed:)
			)
			(return)
		)
		(if (and (not (OneOf state 29 34)) gModelessDialog)
			(gModelessDialog dispose:)
			(self cue:)
		)
		(event claimed: 1)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 40)
			)
			(1
				(lips init: setCycle: Fwd)
				(Print 21 3 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Welcome John!" Braxton says, "Sorry about your leave being cut short, but the matter before us is of utmost importance."
				(= seconds 20)
			)
			(2
				(proc0_3)
				(Print 21 4 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; ""Have a seat John and I'll bring you up to date." he says."
				(= seconds 20)
			)
			(3
				(lips dispose:)
				(proc0_3)
				(Braxton illegalBits: 0 setMotion: MoveTo 165 123 self)
				(gEgo
					setMotion: MoveTo (- (chair x:) 30) (chair y:) self
					ignoreControl: -32768
					ignoreActors:
				)
			)
			(4
				(Braxton loop: 2)
			)
			(5
				(Braxton stopUpd:)
				(gEgo
					setMotion: MoveTo (- (chair x:) 10) (- (chair y:) 1) self
				)
			)
			(6
				(gEgo
					view: 421
					setLoop: 0
					posn: (chair x:) (chair y:)
					cycleSpeed: 1
					heading: 0
					setCycle: End self
				)
			)
			(7
				(gEgo stopUpd:)
				(lips init: posn: 166 86 setCycle: Fwd)
				(Print 21 5 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "General Braxton speaks, "This meeting has been called due to the recent kidnapping of Ambassador Richard Loyd by terrorist Jawharah Khommini Sieb Abdual.""
				(= seconds 20)
			)
			(8
				(proc0_3)
				(Print 21 6 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Continuing he says, "Our intelligence has located the compound where the Ambassador is being held. And, for security reasons, that information will not be disclosed in this meeting."
				(= seconds 20)
			)
			(9
				(proc0_3)
				(Print 21 7 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "The President" he says, "has sent the US 7th fleet into the Mediterranean as a diversion. Our job is to rescue the Ambassador by taking advantage of a well-conceived covert operation, code named "Iceman."
				(= seconds 20)
			)
			(10
				(lips dispose:)
				(proc0_3)
				(coffeeCup dispose:)
				(Braxton
					view: 521
					setLoop: 0
					cycleSpeed: 1
					posn: (Braxton x:) (- (Braxton y:) 2)
					setCycle: End self
				)
				(= seconds 5)
			)
			(11
				(Braxton setCycle: CT 2 -1)
				(= seconds 3)
			)
			(12
				(Braxton setCycle: End)
				(= seconds 3)
			)
			(13
				(Braxton setCycle: Beg self)
			)
			(14
				(coffeeCup init:)
				(Braxton
					view: 121
					loop: 2
					cel: 5
					posn: (Braxton x:) (+ (Braxton y:) 2)
				)
				(Print 21 8 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Directing his attention to you, the General says..."
				(= seconds 20)
			)
			(15
				(lips init: posn: 166 87 setCycle: Fwd)
				(Print 21 9 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Westland! Due to your past outstanding performances, you have been chosen to carry out this mission."
				(= seconds 20)
			)
			(16
				(proc0_3)
				(Print 21 10 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Continuing he says, "You are temporarily assigned to the nuclear attack submarine, USS Blackhawk.""
				(= seconds 20)
			)
			(17
				(proc0_3)
				(Print 21 11 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "You will rendezvous" he says, "with the boat at Pearl Harbor."
				(= seconds 17)
			)
			(18
				(proc0_3)
				(Print 21 12 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "The papers authorizing your assignment are in the sealed Manila envelope located on the table in front of you."
				(= seconds 20)
			)
			(19
				(proc0_3)
				(Print 21 13 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "The General continues, "You will report only to the Captain of USS Blackhawk, "Jonathan Hawkins.""
				(= seconds 20)
			)
			(20
				(proc0_3)
				(Print 21 14 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Finalizing your orders the General tells you, "The details of the mission are locked in the safe of the Blackhawk." And finally, he says, "Commit the numbers 134 to memory.""
				(= seconds 20)
			)
			(21
				(proc0_3)
				(lips dispose:)
				(coffeeCup dispose:)
				(Braxton view: 521 setLoop: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 3)
			)
			(22
				(Braxton setCycle: CT 2 -1)
				(= seconds 3)
			)
			(23
				(Braxton setCycle: End)
				(= seconds 2)
			)
			(24
				(Braxton setCycle: Beg self)
			)
			(25
				(coffeeCup init:)
				(lips init: setCycle: Fwd)
				(Braxton
					view: 121
					cycleSpeed: 0
					setLoop: 2
					cel: 5
					setCycle: Walk
				)
				(Print 21 15 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose #draw) ; "At this time gentlemen, I turn the meeting over to Forrest Collins of the Central Intelligence Agency."
				(= seconds 14)
			)
			(26
				(proc0_3)
				(lips dispose:)
				(Braxton setLoop: -1 setMotion: MoveTo 58 123 self)
			)
			(27
				(Agent illegalBits: 0 setCycle: Beg self)
				(Braxton setScript: braxSitScript)
			)
			(28
				(Agent
					view: 221
					posn: (- (local0 x:) 10) (- (local0 y:) 1)
					setLoop: -1
					setCycle: Walk
					setMotion: DPath 91 150 58 150 58 123 165 123 self
				)
			)
			(29
				(Agent loop: 2)
				(blackOutSlide init:)
				(slideShowWest setCycle: End self)
			)
			(30
				(Agent stopUpd:)
				(slideShowWest cue:)
				(= cycles 10)
			)
			(31
				(blackOutSlide hide:)
				(slideWest setCel: 4 init:)
				(Agent setLoop: 5 setCel: 0 setCycle: End)
				(= cycles 5)
			)
			(32
				(lips init: posn: 164 87 setCycle: Fwd)
				(Print 21 16 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "The agent directs his conversation to you and says, "Westland, our intelligence has verified this compound as being the one holding Ambassador Richard Loyd.""
				(= seconds 18)
			)
			(33
				(Agent setCycle: Beg self)
			)
			(34
				(Agent setLoop: 2 setCel: 0)
				(lips hide:)
				(proc0_3)
				(Print 21 17 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "Continuing he says, "You must make contact with a female agent who will be disguised as a Muslim.""
				(blackOutSlide posn: (slideEast x:) (slideEast y:) show:)
				(slideShowEast setCycle: End self)
			)
			(35
				(lips show:)
				(slideShowEast cue:)
				(= seconds 2)
			)
			(36
				(blackOutSlide hide:)
				(slideEast setCel: 1 init:)
				(Agent setLoop: 4 setCycle: End)
				(lips x: 167)
				(= seconds 10)
			)
			(37
				(proc0_3)
				(Print 21 18 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "You must use the code name "Iceman." Continuing he says, " She will have in her possession, a map directing you to the compound."
				(= seconds 15)
			)
			(38
				(Agent setCycle: Beg)
				(= seconds 5)
			)
			(39
				(lips dispose:)
				(proc0_3)
				(Print 21 19 #title {Agent} #at 5 10 #dispose) ; "Next slide, please."
				(blackOutSlide posn: (slideWest x:) (slideWest y:) show:)
				(= seconds 5)
			)
			(40
				(blackOutSlide hide:)
				(slideWest loop: 5 setCel: 0 init:)
				(= cycles 10)
			)
			(41
				(slideWest loop: 6 setCel: 2 init:)
				(Agent setLoop: 5 setCycle: End)
				(= cycles 10)
			)
			(42
				(lips init: x: 164 setCycle: Fwd)
				(Print 21 20 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "The agent continues by saying, "From Pearl, you will set a course heading of 30 degrees latitude and 170 degrees longitude. Not until reaching these coordinates, will you unlock and review your orders.""
				(= seconds 20)
			)
			(43
				(proc0_3)
				(lips dispose:)
				(Agent setCycle: Beg)
				(Print 21 19 #title {Agent} #at 5 10 #dispose) ; "Next slide, please."
				(blackOutSlide posn: (slideEast x:) (slideEast y:) show:)
				(= seconds 12)
			)
			(44
				(Agent setLoop: -1 loop: 2 setCycle: Walk)
				(blackOutSlide hide:)
				(slideEast loop: 6 setCel: 3)
				(= seconds 2)
			)
			(45
				(lips init: x: 166 setCycle: Fwd)
				(Print 21 21 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "Continuing, the agent says, "This is the USS Blackhawk. What separates this attack sub from the others, is a device called the "Electronic Noise Cancellation Transducer.""
				(= seconds 20)
			)
			(46
				(proc0_3)
				(Print 21 22 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "The transducer is attached to the drive shaft where it picks up generated noise. It then feeds the noise through a computer which cancels it. This makes for much improved silent running."
				(= seconds 20)
			)
			(47
				(proc0_3)
				(Print 21 23 #title {Agent} #at 5 10 #width 305 #font 3 #dispose) ; "That's it for me Westland," He finishes, "I'll turn it back to General Braxton."
				(slideShowWest setCycle: Beg self)
			)
			(48
				(slideShowEast setCycle: Beg self)
				(proc0_3)
			)
			(49
				(lips dispose:)
				(slideShowWest cue:)
				(slideShowEast cue:)
				(Braxton setCycle: Beg self)
			)
			(50
				(Agent setScript: agentSitScript)
				(Braxton
					view: 121
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: DPath 56 138 56 123 165 123 self
				)
			)
			(51
				(lips init: posn: 166 87 setCycle: Fwd)
				(Braxton loop: 2 cel: 5)
				(Print 21 24 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Just one final thing before you leave."
				(= seconds 15)
			)
			(52
				(proc0_3)
				(Print 21 25 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Although you have completed submarine school, it will be necessary for you to be checked out on a few of the control room systems while aboard the Blackhawk."
				(= seconds 20)
			)
			(53
				(proc0_3)
				(Print 21 26 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Continuing he says, "The systems qualification will entitle you to earn your gold dolphins.""
				(= seconds 20)
			)
			(54
				(proc0_3)
				(Print 21 27 #title {Braxton} #at 5 10 #width 305 #font 3 #dispose) ; "Well gentlemen," he says, "That concludes this meeting. Remember Westland, time is of the essence. Goodbye and good luck to you."
				(= seconds 20)
			)
			(55
				(proc0_3)
				(lips dispose:)
				(Agent setCycle: Beg self)
			)
			(56
				(Braxton setMotion: MoveTo 40 123 self)
				(Agent setScript: agentExit)
			)
			(57
				(Braxton setLoop: 2 setMotion: MoveTo 40 174 self)
			)
			(58
				(Braxton setLoop: 1 setMotion: MoveTo -15 174 self)
			)
			(59
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance Braxton of Act
	(properties
		y 123
		x 144
		view 121
		loop 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: ignoreControl: -32768 setCycle: Walk)
	)
)

(instance braxSitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Braxton setMotion: MoveTo 48 123 self)
			)
			(1
				(Braxton
					ignoreControl: -32768
					ignoreActors:
					setMotion: MoveTo 85 144 self
				)
			)
			(2
				(Braxton
					cycleSpeed: 2
					posn: 95 145
					view: 421
					setLoop: 2
					cel: 0
					setCycle: End
				)
			)
		)
	)
)

(instance Agent of Act
	(properties
		y 144
		x 156
		view 421
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 ignoreControl: -32768 cel: (self lastCel:))
	)
)

(instance chair of PV
	(properties
		y 146
		x 231
		view 21
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/chair]>')
				(cond
					((Said 'sit')
						(proc0_39) ; "You don't need to do that."
					)
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 21 28) ; "A chair"
					)
				)
			)
		)
	)
)

(instance flag of PV
	(properties
		y 127
		x 275
		view 21
		loop 3
		cel 1
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flag]>')
				(cond
					((TurnIfSaid self event))
					((Said 'look[<at]')
						(Print 21 29) ; "The American flag. Long may she wave."
					)
				)
			)
		)
	)
)

(instance agentSitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Agent setMotion: DPath 58 123 58 140 91 150 self)
			)
			(1
				(Agent
					setMotion: MoveTo (- (local0 x:) 10) (- (local0 y:) 1) self
				)
			)
			(2
				(Agent
					view: 421
					loop: 1
					posn: (local0 x:) (local0 y:)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gCurRoom cue:)
			)
		)
	)
)

(instance coffeeCup of View
	(properties
		y 109
		x 163
		view 21
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance lips of Prop
	(properties
		y 86
		x 145
		view 521
		loop 1
	)

	(method (init)
		(super init:)
		(self setLoop: loop setPri: 9)
	)
)

(instance egoStandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					view: 204
					loop: 3
					posn: (- (chair x:) 10) (- (chair y:) 1)
					setCycle: Walk
					observeControl: -32768
					ignoreActors: 0
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: -1
				)
				(HandsOn)
			)
		)
	)
)

(instance envelope of View
	(properties
		y 110
		x 204
		view 21
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/[envelope,order,instructions]>')
				(cond
					((TurnIfSaid self event 'look/[<at]'))
					((Said 'look[<at]')
						(Print 21 30) ; "This envelope has your orders temporarily assigning you to the USS Blackhawk."
					)
					((Said 'open,look[<in]')
						(Print 21 31) ; "These orders are not to be opened until you're on the USS Blackhawk and at your rendezvous point."
					)
					((GoToIfSaid self event 204 140 0 21 32))
					((Said 'get')
						(if (gEgo has: 0) ; Envelope
							(Print 21 33) ; "You already have that."
						else
							(Print 21 34) ; "You pick the envelope up off of the desk."
							(envelope dispose:)
							(gEgo get: 0) ; Envelope
							(gGame changeScore: 1)
						)
					)
				)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 3 illegalBits: 0 setMotion: MoveTo 230 160 self)
			)
			(1
				(gEgo setMotion: MoveTo 215 160 self)
			)
			(2
				(gEgo illegalBits: $8000 loop: 3)
				(briefingRoom south: 20)
			)
		)
	)
)

(instance agentExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Agent
					view: 221
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 45 150 self
				)
			)
			(1
				(Agent setMotion: MoveTo 45 176 self)
			)
			(2
				(Agent setMotion: MoveTo -15 176 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance table of RFeature
	(properties
		y 110
		x 165
		nsTop 108
		nsLeft 70
		nsBottom 112
		nsRight 250
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table]>')
				(cond
					((TurnIfSaid self event 'look[<on,at]/*'))
					((Said 'look[<on,at]')
						(if (gEgo has: 0) ; Envelope
							(Print 21 35) ; "An Ordinary table."
						else
							(Print 21 36) ; "There is a manila envelope on the table."
						)
					)
				)
			)
		)
	)
)

