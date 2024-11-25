;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room57 0
)

(synonyms
	(hag hag woman)
	(dirt dirt dirt dirt dirt)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance Room57 of Rm
	(properties
		picture 57
		style 16
	)

	(method (init)
		(Load rsVIEW 631)
		(Load rsVIEW 183)
		(Load rsVIEW 184)
		(Load rsVIEW 185)
		(Load rsVIEW 186)
		(Load rsVIEW 180)
		(Load rsVIEW 64)
		(Load rsVIEW 40)
		(Load rsVIEW 65)
		(Load rsVIEW 66)
		(super init:)
		(= gIndoors 1)
		(= global189 1)
		(self setScript: rm57Script)
		(gEgo posn: 160 185 view: 4 setStep: 4 1 setPri: -1 loop: 3 init:)
		(if global207
			((= local7 (Act new:))
				view: 631
				loop: 3
				cel: 0
				illegalBits: 0
				ignoreActors: 1
				posn: global208 global209
				setScript: scarabToss
				init:
			)
		)
		((= local10 (Prop new:))
			view: 631
			loop: 1
			cel: 0
			posn: 111 63
			init:
			cycleSpeed: 2
			setCycle: Fwd
		)
		((= local0 (Prop new:))
			view: 631
			posn: 159 139
			setPri: 12
			setCycle: Fwd
			init:
		)
		(local0
			brTop: (+ (local0 brTop:) 14)
			brBottom: (+ (local0 brBottom:) 19)
		)
		(if (> gAct 2)
			(witchMusic init:)
			(playMusic cue:)
			((= local5 (Prop new:))
				view: 631
				setLoop: 2
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 12
				init:
				stopUpd:
				hide:
			)
			((= local2 (Prop new:))
				view: 186
				loop: 0
				cel: 5
				posn: 108 122
				setLoop: 1
				init:
				stopUpd:
			)
			((= local3 (Prop new:))
				view: 184
				loop: 0
				cel: 5
				posn: 135 121
				init:
				stopUpd:
			)
			(blockWitch2
				top: (local2 brTop:)
				bottom: (local2 brBottom:)
				left: (local2 brLeft:)
				right: (local2 brBottom:)
				init:
			)
			(blockWitch3
				top: (local3 brTop:)
				bottom: (local3 brBottom:)
				left: (local3 brLeft:)
				right: (local3 brBottom:)
				init:
			)
			(gEgo observeBlocks: blockWitch2 blockWitch3)
			((= local1 (Act new:))
				view: 185
				posn: 83 127
				illegalBits: $8000
				setLoop: 0
				init:
			)
			(if (gEgo has: 6) ; Witches__Glass_Eye
				(= local6 1)
				(if (and (not (gEgo has: 7)) (not global207)) ; Obsidian_Scarab
					(Load rsSCRIPT 991)
					((= local7 (Act new:))
						view: 631
						loop: 3
						cel: 0
						illegalBits: 0
						ignoreActors: 1
						posn: (local1 x:) (- (local1 y:) 30)
						setScript: scarabToss
						init:
					)
					(rm57Script changeState: 1)
				else
					(rm57Script changeState: 3)
				)
				(local3 setScript: witchMoan)
			else
				(= local6 0)
				(local2 setScript: witchEye)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= global189 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			((& (gEgo onControl: 0) $0040)
				(gEgo loop: 2)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 6)
			)
			((and (& (gEgo onControl:) $0004) (not local8) (not local9))
				(Print 57 0 #time 3) ; "Ouch!"
				(ouchness cue:)
			)
			((> gAct 2)
				(cond
					((and (gEgo has: 6) (!= (local3 script:) witchMoan)) ; Witches__Glass_Eye
						(local1 setScript: 0 setMotion: 0)
						(witchEye changeState: 20)
					)
					(
						(and
							(!= (local1 script:) witchChase)
							(< (gEgo distanceTo: local1) 30)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(!= (local3 script:) witchMoan)
						)
						(local1 setScript: witchChase)
					)
					(
						(and
							(gEgo inRect: 110 123 119 133)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(not local8)
							(== (local1 script:) witchChase)
						)
						(Print 57 1 #time 2) ; "Watch out!"
						(Print 57 2 #time 2) ; "Too late."
						(gEgo
							setMotion: 0
							view: 186
							loop: 2
							posn: (local2 x:) (local2 y:)
							setLoop: 2
							setCycle: Fwd
						)
						(local2 hide:)
						(= local8 1)
						(witchMusic number: 13)
						(playMusic cue:)
						(User canControl: 0 canInput: 0)
						(witchEye changeState: 7)
					)
					(
						(and
							(gEgo inRect: 129 123 138 133)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(not local8)
							(== (local1 script:) witchChase)
						)
						(Print 57 1 #time 2) ; "Watch out!"
						(Print 57 2 #time 2) ; "Too late."
						(gEgo
							setMotion: 0
							view: 184
							loop: 1
							posn: (local3 x:) (local3 y:)
							setLoop: 1
							setCycle: Fwd
						)
						(local3 hide:)
						(= local8 1)
						(witchMusic number: 13)
						(playMusic cue:)
						(User canControl: 0 canInput: 0)
						(witchEye changeState: 4)
					)
					(
						(and
							(!= (local1 script:) witchChase)
							(!= (local3 script:) witchMoan)
							(gEgo inRect: 110 123 138 133)
						)
						(local1 setScript: witchChase)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(witchMusic keep: 0)
		(gSounds eachElementDo: #dispose)
		(= global189 0)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (> gAct 2)
			(cond
				((Said 'look>')
					(cond
						((Said '/eye')
							(if ((gInventory at: 6) ownedBy: 57) ; Witches__Glass_Eye
								(Print 57 3) ; "The blind, one-eyed hags peer at you through a glass eye."
							else
								(event claimed: 0)
							)
						)
						((Said '/hag')
							(cond
								((not (gEgo has: 6)) ; Witches__Glass_Eye
									(Print 57 4) ; "Three, old one-eyed crones inhabit this dreary cave. They possess a glass eye, which they pass from one to another, that enables them to see. Through the glass eye, they each in turn peer at you with a frightening mixture of curiosity and malice."
								)
								(local6
									(Print 57 5) ; "The old one-eyed witches seem powerless without their glass eye. You actually feel rather sorry for them."
								)
								(((gInventory at: 6) ownedBy: -1) ; Witches__Glass_Eye
									(Print 57 6) ; "The ugly old hags are relieved to receive their precious glass eye."
								)
								(else
									(Print 57 5) ; "The old one-eyed witches seem powerless without their glass eye. You actually feel rather sorry for them."
								)
							)
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'talk')
					(cond
						(((gInventory at: 6) ownedBy: 57) ; Witches__Glass_Eye
							(answer1 cue:)
						)
						((gEgo has: 6) ; Witches__Glass_Eye
							(answer2 cue:)
						)
						(else
							(answer3 cue:)
						)
					)
				)
				((Said 'rob,get/charm')
					(cond
						((gEgo has: 7) ; Obsidian_Scarab
							(Print 800 0) ; "You already took it."
						)
						((not global207)
							(Print 57 7) ; "What scarab?"
						)
						((> (gEgo distanceTo: local7) 20)
							(Print 800 1) ; "You're not close enough."
						)
						(else
							(gEgo setScript: pickUp)
						)
					)
				)
				((Said 'get,rob/eye')
					(if (not (gEgo has: 6)) ; Witches__Glass_Eye
						(if ((gInventory at: 6) ownedBy: 57) ; Witches__Glass_Eye
							(if (gEgo inRect: 120 123 128 135)
								(Print 57 8) ; "You just manage to snatch the glass eye from the grasp of the old witches! Now they are totally blind and helpless."
								(gEgo get: 6) ; Witches__Glass_Eye
								(gGame changeScore: 3)
							else
								(Print 800 1) ; "You're not close enough."
							)
						else
							(Print 57 9) ; "Do you really think the witches will let you take their precious glass eye again?"
						)
					else
						(Print 800 0) ; "You already took it."
					)
				)
				((Said 'give,return,throw/eye')
					(if (gEgo has: 6) ; Witches__Glass_Eye
						(if (not local6)
							(Print 57 10) ; "You toss the glass eye to the pleading witches. "Aha! Foolish girl!" they shriek. "Leave us be, or you'll flavor our brew!""
						else
							(gGame changeScore: 3)
							(Print 57 11) ; "You throw the glass eye to the three old hags, who once again take turns peering at you. "Come closer, dear," one says. "We'd like to give a little gift to you.""
						)
						(gEgo put: 6 -1) ; Witches__Glass_Eye
						(witchMoan changeState: 4)
					else
						(Print 800 2) ; "You don't have it."
					)
				)
				((Said '/hag>')
					(cond
						((Said 'kill')
							(Print 57 12) ; "You couldn't do it."
						)
						((Said 'get')
							(Print 57 13) ; "You wouldn't want them."
						)
						((Said 'kiss')
							(Print 57 14) ; "YUCK!!"
						)
						((and (Said 'give>') (= temp0 (gInventory saidMe:)))
							(if (gEgo has: (gInventory indexOf: temp0))
								(Print 57 15) ; "The witches don't want it."
							else
								(DontHave) ; "You don't have it."
							)
						)
					)
				)
			)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '/bottle')
						(Print 57 16) ; "You don't want them."
					)
					((or (Said '[<around,in][/room,cave]') (Said '[/!*]'))
						(Print
							(Format ; "This is a dismal and dreary cave. %s In the center of the cave, over a hot fire, boils a foul-smelling brew inside a large black cauldron. %s"
								@global300
								57
								17
								(if (> gAct 2)
									{Within it, reside three one-eyed old witches.}
								else
									{ }
								)
								(if (gCast contains: local7)
									{You see a black scarab on the cave floor.}
								else
									{ }
								)
							)
						)
					)
					((Said '/caldron')
						(Print 57 18) ; "A greenish, foul brew boils ominously within the cauldron."
					)
					((Said '/brew')
						(Print 57 19) ; "The green brew looks disgusting...and smells that way, too!"
					)
					((Said '/fire')
						(Print 57 20) ; "A hot fire burns under a large cauldron filled with bubbling brew."
					)
					((Said '<out/cave')
						(Print 57 21) ; "Outside the cave, you see the terrible grabbing trees."
					)
					((or (Said '/dirt') (Said '<down'))
						(if global207
							(Print 57 22) ; "You see a black scarab on the cave floor."
						else
							(Print 57 23) ; "There is nothing of interest on the cave floor."
						)
					)
					((Said '/wall')
						(Print 57 24) ; "There is nothing of interest on the rough cave walls."
					)
					((Said '/shelf')
						(Print 57 25) ; "You see bottles and jars of disgusting-looking stuff. None of it interests you, though."
					)
					((Said '/skull')
						(Print 57 26) ; "You shiver at the sight of a human skull on the shelf."
					)
				)
			)
			((Said 'get,rob>')
				(cond
					((Said '/bottle')
						(Print 57 27) ; "You don't want any of them."
					)
					((Said '/skull')
						(Print 57 28) ; "You don't need it."
					)
					((Said '/brew')
						(Print 57 29) ; "You wouldn't want it!"
					)
				)
			)
			((Said 'eat,drink/brew')
				(Print 57 30) ; "You gag at the thought!"
			)
			((Said 'get/caldron')
				(Print 57 31) ; "It's too heavy to carry."
			)
		)
	)
)

(instance witchEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 view: 185 loop: 0 setCycle: Beg self)
			)
			(1
				(local5 x: (+ (local1 x:) 1) y: (- (local1 y:) 43) show:)
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(2
				(local5 hide:)
				(local1 loop: 1 setCycle: End self)
			)
			(3
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(local1 setScript: witchChase)
				)
				(local2 loop: 0 setCycle: CT 4 1 self)
			)
			(4
				(local3 stopUpd:)
				(local5 x: (- (local2 x:) 1) y: (- (local2 y:) 40) show:)
				(if (not local8)
					((ScriptID 0 4) setReal: self 5) ; timer1
				)
			)
			(5
				(local5 hide:)
				(local2 setLoop: 0 setCycle: Beg self)
			)
			(6
				(local2 setCycle: CT 5 -1)
				(local3 setCycle: CT 4 1 self)
			)
			(7
				(local2 stopUpd:)
				(local5 x: (+ (local3 x:) 0) y: (- (local3 y:) 39) show:)
				(if (not local8)
					((ScriptID 0 4) setReal: self 5) ; timer1
				)
			)
			(8
				(local5 hide:)
				(local3 setCycle: Beg self)
			)
			(9
				(local3 setCycle: CT 5 -1)
				(if (== (local1 script:) witchChase)
					(= state 3)
				)
				(local2 setCycle: CT 4 1 self)
			)
			(10
				(local3 stopUpd:)
				(local5 x: (- (local2 x:) 1) y: (- (local2 y:) 40) show:)
				(if (not local8)
					((ScriptID 0 4) setReal: self 5) ; timer1
				)
			)
			(11
				(local5 hide:)
				(local2 loop: 4 cel: 0 setCycle: End self)
			)
			(12
				(self changeState: 0)
			)
			(20
				(local5 hide:)
				(client setScript: 0)
				(local3 setScript: witchMoan)
			)
		)
	)
)

(instance witchChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1
					view: 180
					moveSpeed: 2
					setAvoider: Avoid
					setLoop: -1
					setCycle: Walk
					setMotion: Chase gEgo 6 self
				)
			)
			(1
				(HandsOff)
				(gEgo dispose:)
				(witchEye cue:)
				(local2 show:)
				(local3 show:)
				(local1 view: 65 moveSpeed: 1)
				(self cue:)
			)
			(2
				(witchMusic number: 13)
				(playMusic cue:)
				(= local8 1)
				(local1
					view: 66
					setLoop:
						(if
							(<
								180
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(local1 x:)
									(local1 y:)
								)
							)
							1
						else
							0
						)
					setAvoider: Avoid
					setMotion:
						MoveTo
						(local0 x:)
						(if (< (local1 y:) (+ (local0 y:) 18))
							(+ (local0 y:) 9)
						else
							(+ (local0 y:) 25)
						)
						self
				)
			)
			(3
				(Print 57 32 #at -1 20) ; "You knew you needed a hot bath, but not THIS hot!"
				(local1
					view: 66
					loop: (+ (local1 loop:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(local1
					setLoop: -1
					view: 180
					setMotion: MoveTo (local0 x:) (+ (local0 y:) 10)
				)
				(local2 stopUpd:)
				(local3 stopUpd:)
				(gEgo
					view: 64
					posn: (local0 x:) (+ (local0 y:) 1)
					cel: 0
					ignoreActors: 1
					setPri: (local0 priority:)
					setLoop: (local1 loop:)
					init:
					setMotion: 0
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 2 setCycle: Fwd)
				(= cycles (* (NumCels gEgo) 3))
			)
			(6
				(gEgo cel: 0 setLoop: 3 setCycle: End self)
			)
			(7
				(= seconds 3)
			)
			(8
				(= gDeathFlag 1)
			)
		)
	)
)

(instance witchMoan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setScript: 0)
				(local5 hide:)
				(local3
					view: 183
					setLoop: 2
					cel: 0
					setCycle: End self
					ignoreActors: 0
				)
			)
			(1
				(local2
					view: 183
					setLoop: 1
					cel: 0
					ignoreActors: 0
					setCycle: End self
				)
			)
			(2
				(local1 ignoreActors: 0 setMotion: MoveTo 125 133 self)
			)
			(3
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(Print 57 33) ; "Give us back our eye!" the old witches plead."
				)
				(local1 view: 183 setLoop: 0 cel: 0 setCycle: End)
				(local2 stopUpd:)
				(local3 stopUpd:)
			)
			(4
				(local3 setCycle: Beg)
				(local1 setCycle: Beg)
				(local2 setCycle: Beg)
				((ScriptID 0 6) setReal: self 4) ; timer3
			)
			(5
				(local1
					view: 180
					setLoop: -1
					illegalBits: 0
					setMotion: MoveTo 79 128 self
				)
			)
			(6
				(local2 view: 186 setLoop: 1)
				(local3 view: 184 setLoop: 0)
				(client setScript: 0)
				(local2 setScript: witchEye)
			)
		)
	)
)

(instance answer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 57 34) ; "Even though the old hags are frightening, you decide to speak to them. They don't answer as they are mumbling and muttering among themselves, while peering through their glass eye at you."
			)
			(1
				(Print 57 35) ; "Again, you attempt to talk to the three one-eyed witches. This time, one cackles, "What a pretty little thing you are, dearie. Come here, and let me touch your golden hair.""
			)
			(2
				(Print 57 36) ; "As you speak with them again, they beg you to come closer so they can see you better and feel your pretty hair."
				(= state 1)
			)
		)
	)
)

(instance answer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(Print 57 37) ; ""Give us back our eye!" the old witches plead."
				)
			)
			(1
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(switch (Random 1 4)
						(1
							(Print 57 38) ; "Your voice is drowned out by the wails of the three ugly hags as they beg for the return of their eye."
						)
						(2
							(Print 57 39) ; "We need our eye!" the three crones cry. "Give it back to us!"
						)
						(3
							(Print 57 40) ; "You again talk to the old witches, who cry and wail for the return of their glass eye."
						)
						(4
							(Print 57 37) ; ""Give us back our eye!" the old witches plead."
						)
					)
					(= state 0)
				)
			)
		)
	)
)

(instance answer3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 57 41) ; "You speak with the three ugly witches. They mutter to themselves, after which one cajoles, "Come here, girl. We have something to give you for being such a nice girl and returning our eye.""
			)
			(1
				(switch (Random 1 3)
					(1
						(Print 57 42) ; "You try talking to the old hags again. In a syrupy voice, one hag says, "Don't be afraid, dear. Come here, we have a gift for you.""
					)
					(2
						(Print 57 43) ; ""Come over here, girl." The old, one-eyed witches attempt to entice you with promises of a gift, in payment for your return of their glass eye."
					)
					(3
						(Print 57 41) ; "You speak with the three ugly witches. They mutter to themselves, after which one cajoles, "Come here, girl. We have something to give you for being such a nice girl and returning our eye.""
					)
				)
				(= state 0)
			)
		)
	)
)

(instance scarabToss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global207
					(self changeState: 1)
				else
					(local7
						setMotion:
							JumpTo
							(- (gEgo x:) 20)
							(- (gEgo y:) 20)
							self
					)
				)
			)
			(1
				(= global208 (local7 x:))
				(= global209 (local7 y:))
				(= global207 1)
				(local7 setPri: -1)
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(2
				(if (gCast contains: local7)
					(local7 setCycle: End self)
				)
			)
			(3
				(if (gCast contains: local7)
					(local7 setCycle: Beg self)
				)
			)
			(4
				(local7 stopUpd:)
				(= state 1)
				((ScriptID 0 5) setReal: self 5) ; timer2
			)
		)
	)
)

(instance ouchness of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 1)
				((ScriptID 0 7) setReal: self 3) ; timer4
			)
			(1
				(= state -1)
				(= local9 0)
			)
		)
	)
)

(instance witchMusic of Sound
	(properties
		number 12
		loop 0
		keep 1
	)
)

(instance playMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(witchMusic loop: 1 play: self)
			)
			(1
				(= state -1)
			)
		)
	)
)

(instance blockWitch2 of Blk
	(properties)
)

(instance blockWitch3 of Blk
	(properties)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(HandsOff)
				(LookAt gEgo local7)
				(gEgo view: 40 cel: 0 setCycle: End self)
			)
			(2
				(local7 dispose:)
				(= global207 0)
				(gEgo get: 7) ; Obsidian_Scarab
				(= global182 1)
				(gGame changeScore: 2)
				(= seconds 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 4 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance rm57Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 3)
			)
			(2
				(Print 57 44 #at -1 20) ; "As you re-enter the dismal cave, the three, one-eyed witches throw something toward you, which lands on the ground. "Here, take it," they cry. "It'll ward off the undead. You'll need it. Now, PLEASE give us back our eye!!""
				(= state 4)
				(= seconds 3)
			)
			(3
				(= seconds 3)
			)
			(4
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(Print 57 45) ; "As you re-enter the dismal cave, the three, one-eyed witches plead, "Please! Give us back our eye!!""
				)
			)
			(5
				(Print 57 46) ; "You think about it."
			)
		)
	)
)

