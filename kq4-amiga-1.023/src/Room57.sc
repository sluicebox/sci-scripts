;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
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
	local11
	local12
	local13
	local14
)

(instance Room57 of Rm
	(properties
		picture 57
		style 16
	)

	(method (init)
		(witchMusic init:)
		(= south 6)
		(Load rsVIEW 631)
		(if (>= gAct 3)
			(Load rsVIEW 183)
			(Load rsVIEW 184)
			(Load rsVIEW 185)
			(Load rsVIEW 186)
			(Load rsVIEW 180)
			(Load rsVIEW 64)
			(Load rsVIEW 21)
		)
		(Load rsVIEW 65)
		(Load rsVIEW 66)
		(super init:)
		(= gIndoors 1)
		(= global189 1)
		(self setScript: rm57Script)
		(gEgo posn: 160 184 view: 2 setStep: 3 2 setPri: -1 loop: 3 init:)
		(if global207
			((= local11 (Act new:))
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
		((= local14 (Prop new:))
			isExtra: 1
			view: 631
			loop: 1
			cel: 0
			posn: 105 83
			init:
			cycleSpeed: 2
			setCycle: Fwd
		)
		((= local0 (View new:))
			view: 631
			loop: 4
			cel: 0
			posn: 159 151
			setPri: 12
			init:
			addToPic:
		)
		((= local1 (Prop new:))
			isExtra: 1
			view: 631
			loop: 5
			posn: 159 157
			setCycle: Fwd
			setPri: 12
			init:
		)
		((= local2 (Prop new:))
			view: 631
			loop: 0
			posn: 159 140
			setPri: 12
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(local2
			brTop: (+ (local2 brTop:) 14)
			brBottom: (+ (local2 brBottom:) 19)
		)
		(if (> gAct 2)
			(witchMusic loop: 1 play:)
			((= local9 (Prop new:))
				view: 631
				setLoop: 2
				cycleSpeed: 2
				setCycle: Fwd
				setPri: 12
				init:
				stopUpd:
				hide:
			)
			((= local4 (Prop new:))
				view: 186
				loop: 0
				cel: 5
				posn: 108 101
				setLoop: 1
				init:
				stopUpd:
			)
			((= local5 (Prop new:))
				view: 186
				setLoop: 3
				cel: 0
				posn: 108 121
				init:
				stopUpd:
			)
			((= local7 (Prop new:))
				view: 184
				loop: 0
				cel: 5
				posn: 135 100
				init:
				stopUpd:
			)
			((= local6 (Prop new:))
				view: 184
				setLoop: 2
				cel: 0
				posn: 135 120
				init:
				stopUpd:
			)
			(blockWitch2
				top: 115
				bottom: (local4 brBottom:)
				left: (- (local4 brLeft:) 2)
				right: (+ (local4 brBottom:) 2)
				init:
			)
			(blockWitch3
				top: 115
				bottom: (local7 brBottom:)
				left: (- (local7 brLeft:) 2)
				right: (+ (local7 brBottom:) 2)
				init:
			)
			(gEgo observeBlocks: blockWitch2 blockWitch3)
			((= local3 (Act new:))
				view: 185
				posn: 83 126
				illegalBits: -32768
				setLoop: 0
				init:
			)
			(if (gEgo has: 6) ; Witches__Glass_Eye
				(= local10 1)
				(if (and (not (gEgo has: 7)) (not global207)) ; Obsidian_Scarab
					(Load rsSCRIPT 991)
					((= local11 (Act new:))
						view: 631
						loop: 3
						cel: 0
						illegalBits: 0
						ignoreActors: 1
						posn: (local3 x:) (- (local3 y:) 30)
						setScript: scarabToss
						init:
					)
					(rm57Script changeState: 1)
				else
					(rm57Script changeState: 3)
				)
				(local7 setScript: witchMoan)
			else
				(= local10 0)
				(local4 setScript: witchEye)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo loop: 2)
		(Animate (gCast elements:) 0)
		(= global189 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			((and (& (gEgo onControl:) $0004) (not local12) (not local13))
				(Print 57 0 #time 3) ; "Ouch!"
				(ouchness cue:)
			)
			((> gAct 2)
				(cond
					((and (gEgo has: 6) (!= (local7 script:) witchMoan)) ; Witches__Glass_Eye
						(local3 setScript: 0 setMotion: 0)
						(witchEye changeState: 20)
					)
					(
						(and
							(!= (local3 script:) witchChase)
							(< (gEgo distanceTo: local3) 30)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(!= (local7 script:) witchMoan)
						)
						(local3 setScript: witchChase)
					)
					(
						(and
							(gEgo inRect: 110 123 119 133)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(not local12)
							(== (local3 script:) witchChase)
						)
						(Print 57 1 #time 2) ; "Watch out!"
						(Print 57 2 #time 2) ; "Too late."
						(local4 hide:)
						(local5 hide: ignoreActors:)
						(gEgo
							setMotion: 0
							view: 186
							loop: 2
							posn: (local5 x:) (local5 y:)
							setLoop: 2
							setCycle: Fwd
						)
						(= local12 1)
						(witchMusic number: 13 loop: 1 play:)
						(User canControl: 0 canInput: 0)
						(witchEye changeState: 7)
					)
					(
						(and
							(gEgo inRect: 131 122 138 131)
							(not (gEgo has: 6)) ; Witches__Glass_Eye
							(not local12)
							(== (local3 script:) witchChase)
						)
						(Print 57 1 #time 2) ; "Watch out!"
						(Print 57 2 #time 2) ; "Too late."
						(HandsOff)
						(gEgo
							setMotion: 0
							view: 184
							loop: 1
							posn: (local6 x:) (local6 y:)
							setLoop: 1
							setCycle: Fwd
						)
						(local7 hide:)
						(local6 hide: ignoreActors:)
						(= local12 1)
						(witchMusic number: 13 loop: 1 play:)
						(witchEye changeState: 4)
					)
					(
						(and
							(!= (local3 script:) witchChase)
							(!= (local7 script:) witchMoan)
							(gEgo inRect: 110 123 138 133)
						)
						(local3 setScript: witchChase)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gSounds eachElementDo: #stop 0)
		(gTimers eachElementDo: #dispose 84)
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
								(local10
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
						((> (gEgo distanceTo: local11) 20)
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
							(if (gEgo inRect: 119 122 129 136)
								(Print 57 8) ; "You just manage to snatch the glass eye from the grasp of the old witches! Now they are totally blind and helpless."
								(gEgo get: 6) ; Witches__Glass_Eye
								(gGame changeScore: 3)
								(= global182 1)
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
						(if (not local10)
							(Print 57 10) ; "You toss the glass eye to the pleading witches. "Aha! Foolish girl!" they shriek. "Leave us be, or you'll flavor our brew!""
							(gEgo put: 6 -1) ; Witches__Glass_Eye
						else
							(gGame changeScore: 3)
							(gEgo put: 6 -1) ; Witches__Glass_Eye
							(Print 57 11) ; "You throw the glass eye to the three old hags, who once again take turns peering at you. "Come closer, dear," one says. "We'd like to give a little gift to you.""
						)
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
								@global228
								57
								17
								(if (> gAct 2)
									{Within it, reside three one-eyed old witches.}
								else
									{ }
								)
								(if (gCast contains: local11)
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
				(local3 view: 185 loop: 0 setCycle: Beg self)
			)
			(1
				(local9 x: (+ (local3 x:) 1) y: (- (local3 y:) 43) show:)
				(= seconds 4)
			)
			(2
				(local9 hide:)
				(local3 loop: 1 setCycle: End self)
			)
			(3
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(local3 setScript: witchChase)
				)
				(local4 loop: 0 setCycle: CT 4 1 self)
			)
			(4
				(local7 stopUpd:)
				(local9 x: (- (local4 x:) 1) y: (- (local4 y:) 12) show:)
				(if (not local12)
					(= seconds 5)
				)
			)
			(5
				(local9 hide:)
				(local4 setLoop: 0 setCycle: Beg self)
			)
			(6
				(local4 setCycle: CT 5 -1)
				(local7 setCycle: CT 4 1 self)
			)
			(7
				(local4 stopUpd:)
				(local9 x: (+ (local7 x:) 0) y: (- (local7 y:) 12) show:)
				(if (not local12)
					(= seconds 5)
				)
			)
			(8
				(local9 hide:)
				(local7 setCycle: Beg self)
			)
			(9
				(local7 setCycle: CT 5 -1)
				(if (== (local3 script:) witchChase)
					(= state 3)
				)
				(local4 setCycle: CT 4 1 self)
			)
			(10
				(local7 stopUpd:)
				(local9 x: (- (local4 x:) 1) y: (- (local4 y:) 40) show:)
				(if (not local12)
					(= seconds 5)
				)
			)
			(11
				(local9 hide:)
				(local4 loop: 0 cel: 255 setCycle: End self)
			)
			(12
				(self changeState: 0)
			)
			(20
				(local9 hide:)
				(client setScript: 0)
				(local7 setScript: witchMoan)
			)
		)
	)
)

(instance witchChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3
					view: 180
					moveSpeed: 2
					setAvoider: Avoid
					setLoop: -1
					setCycle: Walk
					setMotion: Chase gEgo 7 self
				)
			)
			(1
				(HandsOff)
				(gEgo ignoreActors: hide:)
				(local4 show:)
				(local5 show:)
				(local7 show:)
				(local6 show:)
				(local3 view: 65 moveSpeed: 0)
				(self cue:)
			)
			(2
				(witchMusic number: 13 loop: 1 play:)
				(= local12 1)
				(local3
					view: 66
					setLoop:
						(if
							(<
								180
								(GetAngle
									(gEgo x:)
									(gEgo y:)
									(local3 x:)
									(local3 y:)
								)
							)
							1
						else
							0
						)
					setAvoider: Avoid
					setMotion:
						MoveTo
						157
						(if (< (local3 y:) 154) 143 else 164)
						self
				)
			)
			(3
				(Print 57 32 #at -1 20) ; "You knew you needed a hot bath, but not THIS hot!"
				(local3
					view: 66
					setLoop: (+ (local3 loop:) 2)
					cel: 255
					setCycle: End self
				)
			)
			(4
				(local3
					setLoop: -1
					illegalBits: -32768
					ignoreActors: 0
					setAvoider: Avoid
					view: 180
					setMotion: MoveTo 95 (local3 y:)
				)
				(local4 stopUpd:)
				(local7 stopUpd:)
				(witchMusic stop:)
				(gEgo
					view: 64
					posn: (local2 x:) (+ (local2 y:) 1)
					cel: 255
					ignoreActors: 1
					setPri: 12
					setLoop: (local3 loop:)
					show:
					setMotion: 0
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 2 cycleSpeed: 1 setCycle: Fwd)
				(= cycles (* (NumCels gEgo) 6))
			)
			(6
				(gEgo cel: 255 setLoop: 3 setCycle: End self)
			)
			(7
				(= seconds 6)
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
				(local3 setScript: 0)
				(local9 hide:)
				(local7 hide: ignoreActors:)
				(local6
					view: 183
					setLoop: 2
					cel: 255
					setCycle: End self
					ignoreActors: 0
				)
			)
			(1
				(local6 stopUpd:)
				(local4 hide: ignoreActors:)
				(local5
					view: 183
					setLoop: 1
					cel: 255
					ignoreActors: 0
					setCycle: End self
				)
			)
			(2
				(local5 stopUpd:)
				(local3 ignoreActors: 0 setMotion: MoveTo 125 133 self)
			)
			(3
				(if (not ((gInventory at: 6) ownedBy: -1)) ; Witches__Glass_Eye
					(Print 57 33) ; "Give us back our eye!" the old witches plead."
				)
				(local3 view: 183 setLoop: 0 cel: 255 setCycle: End)
			)
			(4
				(local6 setCycle: Beg)
				(local3 setCycle: Beg)
				(local5 setCycle: Beg)
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(5
				(local3 view: 180 setLoop: -1 setMotion: MoveTo 88 129 self)
			)
			(6
				(local5 view: 186 setLoop: 3 cel: 0)
				(local6 view: 184 setLoop: 2 cel: 0)
				(local4 show:)
				(local7 show:)
				(client setScript: 0)
				(local4 setScript: witchEye)
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
					(local11
						setMotion:
							JumpTo
							(- (gEgo x:) 20)
							(- (gEgo y:) 20)
							self
					)
				)
			)
			(1
				(= global208 (local11 x:))
				(= global209 (local11 y:))
				(= global207 1)
				(local11 setPri: -1)
				(= seconds 2)
			)
			(2
				(if (gCast contains: local11)
					(local11 setCycle: End self)
				)
			)
			(3
				(if (gCast contains: local11)
					(local11 setCycle: Beg self)
				)
			)
			(4
				(local11 stopUpd:)
				(= state 1)
				(= seconds 5)
			)
		)
	)
)

(instance ouchness of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local13 1)
				((ScriptID 0 5) setReal: self 3) ; timer2
			)
			(1
				(= state -1)
				(= local13 0)
			)
		)
	)
)

(instance witchMusic of Sound
	(properties
		number 12
		priority 15
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
				(LookAt gEgo local11)
				(gEgo view: 21 cel: 255 setCycle: End self)
			)
			(2
				(local11 dispose:)
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
				(gEgo view: 2 setCycle: Walk)
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
				(HandsOff)
				(= seconds 3)
			)
			(2
				(Print 57 44 #at -1 20) ; "As you re-enter the dismal cave, the three, one-eyed witches throw something toward you, which lands on the ground. "Here, take it," they cry. "It'll ward off the undead. You'll need it. Now, PLEASE give us back our eye!!""
				(= state 4)
				(= seconds 3)
				(HandsOn)
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

