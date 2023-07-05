;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	Room222 0
)

(local
	local0
	local1
	[local2 3]
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 2]
	local13
	[local14 5]
	local19
	[local20 4]
	local24
	local25
	[local26 2]
	local28
	local29
	local30
	[local31 50]
)

(instance openMusic of Sound
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance waves of List
	(properties)
)

(instance Room222 of Rm
	(properties
		picture 25
		style 8
	)

	(method (init)
		(Load rsVIEW 757)
		(Load rsVIEW 755)
		(Load rsVIEW 771)
		(Load rsVIEW 753)
		(Load rsVIEW 765)
		(Load rsPIC 25)
		(Load rsPIC 205)
		(Load rsPIC 209)
		(super init:)
		(gCurRoom setScript: RoomActions)
	)

	(method (newRoom newRoomNumber)
		(TheMenuBar draw:)
		(cls)
		(if (IsObject waves)
			(waves dispose:)
		)
		(= gUserFont gBigFont)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(= local0 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (not local0))
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(gGame restart:)
			)
		)
	)
)

(instance RoomActions of Script
	(properties)

	(method (doit &tmp [temp0 40])
		(super doit:)
		(if global215
			(Display
				(Format @temp0 222 0 state (openMusic prevSignal:) local1) ; "state:%2d music:%3d highest:%3d"
				dsCOORD
				0
				0
				dsBACKGROUND
				15
			)
		)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(openMusic number: 106 loop: 6 play: highState)
				(setupRoom25 doit:)
				(= local24 (Prop new:))
				(local24
					posn: 229 125
					view: 680
					loop: 0
					cel: 0
					setCycle: CT 5 1 self
					init:
				)
			)
			(1
				(local24 setLoop: 0 setCycle: End self)
				(= local13
					((Prop new:)
						view: 757
						posn: 229 125
						setLoop: 0
						cel: 0
						init:
						yourself:
					)
				)
			)
			(2
				(local24 dispose:)
				(= local19
					((Act new:)
						view: 755
						loop: 0
						posn: -20 (+ (gCurRoom horizon:) 40)
						setPri: 15
						illegalBits: 0
						ignoreActors:
						cycleSpeed: 0
						setCycle: Fwd
						setMotion: MoveTo 260 126
						init:
						yourself:
					)
				)
				(= local9
					((Act new:)
						view: 110
						loop: 0
						posn: -30 (+ (gCurRoom horizon:) 20)
						illegalBits: 0
						setPri: 14
						ignoreActors:
						cycleSpeed: 0
						setCycle: Fwd
						setMotion: MoveTo 260 70 self
						init:
						yourself:
					)
				)
				(if global223
					(= local10
						((Act new:)
							view: 114
							loop: 0
							posn: -40 (+ (gCurRoom horizon:) 2)
							setPri: 14
							ignoreActors:
							illegalBits: 0
							cycleSpeed: 0
							setCycle: Fwd
							setMotion: MoveTo 260 85
							init:
							yourself:
						)
					)
				)
			)
			(3
				(local9 observeBlocks: fairyBlock)
				(if global223
					(local10 observeBlocks: fairyBlock)
				)
				(local13 dispose:)
				(= local13
					((Prop new:)
						view: 757
						posn: 229 125
						setLoop: 0
						setCel: 1
						init:
						yourself:
					)
				)
				(local19 setLoop: 3 cel: 0 stopUpd:)
				(local9 setMotion: Wander)
				(if global223
					(local10 setMotion: Wander)
				)
				(= local25 (Print 222 1 #title {Genesta} #at 100 161 #width 200 #dispose)) ; "The lovely fairy speaks. "I am the fairy, Genesta. Welcome to Tamir!""
				(Timer setReal: self 12)
			)
			(4
				(local13 dispose:)
				(local19 hide:)
				(cls)
				(if global223
					(local28 dispose:)
					(local29 dispose:)
					(waveActions changeState: 10)
				)
				(local9 dispose:)
				(if global223
					(local10 dispose:)
				)
				(setupRoom209 doit:)
				(= local13
					((Act new:)
						view: 771
						loop: 0
						posn: 107 78
						cel: 0
						setPri: 15
						ignoreActors:
						stopUpd:
						forceUpd:
						init:
						yourself:
					)
				)
				((View new:)
					view: 771
					loop: 1
					cel: 3
					posn: 192 77
					setPri: 15
					ignoreActors:
					addToPic:
				)
				(Timer setReal: self 1)
			)
			(5
				(cls)
				(= local25 (Print 222 2 #at 50 161 #width 200 #draw #dispose)) ; "Rosella looks awestruck at the fairy. She is stunningly beautiful! But still there is a certain sadness to her."
				(Timer setReal: self 9)
			)
			(6
				(cls)
				(local13 cycleSpeed: 2 setCycle: Fwd show:)
				(= local25 (Print 222 3 #title {Rosella} #at 1 161 #width 200 #dispose)) ; "Finally, Rosella speaks. "I know you would like me to help you in some way, but I don't know how I could help a fairy.""
				(Timer setReal: self 12)
			)
			(7
				(cls)
				(local8 dispose:)
				(local19 dispose:)
				(local13 hide:)
				(gCurRoom drawPic: 205)
				((View new:)
					view: 765
					setLoop: 0
					posn: 200 119
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(= local6
					((Act new:)
						view: 765
						loop: 2
						posn: 200 99
						setPri: 14
						ignoreActors:
						cycleSpeed: 3
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(blinkEyes changeState: 0)
				(= local25 (Print 222 4 #title {Genesta} #at 100 140 #width 200 #dispose)) ; "Genesta looks sadder than ever. "You're wrong, Rosella. You see, I'm losing my magical powers. Yesterday as I was strolling through the woods, Lolotte, the evil fairy, caught me unawares and stole my magic talisman.""
				(Timer setReal: self 11)
			)
			(8
				(cls)
				(= local25 (Print 222 5 #title {Genesta} #at 70 140 #width 239 #dispose)) ; "The fairy sighs, "She yanked it from my neck and raced away screeching with laughter. Immediately I felt my powers diminishing and my body weakening. I will die in 24 hours if my talisman is not returned.""
				(Timer setReal: self 11)
			)
			(9
				(blinkEyes changeState: 4)
				(Timer setReal: self 14)
			)
			(10
				(cls)
				(blinkEyes changeState: 7)
				(local6 dispose:)
				(setupRoom209 doit:)
				(local13
					view: 771
					loop: 0
					cel: 0
					posn: 107 78
					setPri: 15
					ignoreActors:
					cycleSpeed: 2
					show:
					stopUpd:
					forceUpd:
				)
				(= local19
					((Act new:)
						view: 771
						loop: 1
						posn: 192 77
						setPri: 15
						ignoreActors:
						cycleSpeed: 2
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(Timer setReal: self 2)
			)
			(11
				(cls)
				(= local25 (Print 222 6 #title {Genesta} #at 100 140 #width 200 #dispose)) ; "Intently, Genesta looks at Rosella. "Lolotte is very evil and will use the talisman to bring more evil to Tamir. Now I fear it will contaminate my whole country!""
				(Timer setReal: self 13)
			)
			(12
				(cls)
				(= local25 (Print 222 7 #title {Genesta} #at 100 140 #width 200 #dispose)) ; "Further, I cannot send you home without my talisman."
				(Timer setReal: self 9)
			)
			(13
				(cls)
				(local19 setCel: 0 stopUpd:)
				(local13 setCycle: Fwd)
				(= local25 (Print 222 8 #title {Rosella} #at 1 140 #width 200 #dispose)) ; "Rosella is unsure as to what SHE can do. Meekly, she asks, "I want to help you, but how?""
				(Timer setReal: self 9)
			)
			(14
				(cls)
				(local13 setCel: 0 stopUpd:)
				(local19 setCycle: Fwd)
				(= local25 (Print 222 9 #title {Genesta} #at 100 140 #width 200 #dispose)) ; "You can do more than you think, Rosella," Genesta assures her. "I believe you will be able to penetrate Lolotte's domain."
				(Timer setReal: self 14)
			)
			(15
				(cls)
				(local8 dispose:)
				(local13 dispose:)
				(local19 dispose:)
				(gCurRoom drawPic: 205)
				((View new:)
					view: 753
					setLoop: 0
					posn: 50 119
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(= local6
					((Act new:)
						view: 753
						loop: 2
						posn: 50 94
						setPri: 14
						ignoreActors:
						cycleSpeed: 3
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(rosellaBlinks changeState: 0)
				(cls)
				(= local25 (Print 222 10 #title {Rosella} #at 1 140 #width 200 #dispose)) ; "Suddenly, Rosella remembers the tiny tree. "Can you tell me where to find the magic fruit?""
				(Timer setReal: self 9)
			)
			(16
				(cls)
				(local6 hide:)
				(= local25 (Print 222 11 #title {Genesta} #at 100 140 #width 200 #dispose)) ; "Remorsefully, Genesta looks at Rosella. "It will not be easy to reach the tree. It grows on a tiny island within a vast swamp on the other side of the great mountains.""
				(Timer setReal: self 12)
			)
			(17
				(cls)
				(local6 show:)
				(= local25 (Print 222 12 #title {Rosella} #at 1 140 #width 200 #dispose)) ; "Bravely fighting back tears, Rosella says, "I will help you in any way I can, Genesta. How can I find Lolotte?""
				(Timer setReal: self 14)
			)
			(18
				(cls)
				(rosellaBlinks changeState: 4)
				(gCast eachElementDo: #dispose)
				(setupRoom25 doit:)
				(= local19
					((Act new:)
						view: 755
						loop: 4
						posn: 260 125
						cel: 0
						setPri: 15
						illegalBits: 0
						ignoreActors:
						cycleSpeed: 5
						init:
						yourself:
					)
				)
				(= local9
					((Act new:)
						view: 110
						loop: 0
						posn: 260 69
						illegalBits: 0
						setPri: 14
						ignoreActors:
						cycleSpeed: 0
						setMotion: Wander
						setCycle: Fwd
						observeBlocks: fairyBlock
						init:
						yourself:
					)
				)
				(if global223
					(= local10
						((Act new:)
							view: 114
							loop: 0
							posn: 260 84
							setPri: 14
							ignoreActors:
							illegalBits: 0
							cycleSpeed: 0
							setMotion: Wander
							setCycle: Fwd
							observeBlocks: fairyBlock
							init:
							yourself:
						)
					)
				)
				(= local13
					((Act new:)
						view: 757
						setLoop: 0
						posn: 229 125
						cel: 1
						setPri: 14
						init:
						yourself:
					)
				)
				(Timer setReal: self 2)
			)
			(19
				(cls)
				(= local25 (Print 222 13 #title {Genesta} #at 100 161 #width 200 #dispose)) ; "The beautiful fairy points eastward. "Lolotte's castle overlooks Tamir from the great mountains.""
				(Timer setReal: self 7)
			)
			(20
				(local19 setCycle: End)
				(Timer setReal: self 7)
			)
			(21
				(cls)
				(= local25 (Print 222 14 #title {Genesta} #at 80 161 #width 220 #dispose)) ; "Genesta looks weaker as she says, "There is not much more I can do, Rosella. As it is, it will be difficult for me to fly home again.""
				(local19 loop: 3 setCycle: Fwd)
				(Timer setReal: self 11)
			)
			(22
				(cls)
				(= local25 (Print 222 15 #title {Genesta} #at 80 161 #width 220 #dispose)) ; "One thing I must do for you, though. I shall disguise you as a peasant girl so as not to attract attention."
				(Timer setReal: self 10)
			)
			(23
				(cls)
				(local19 loop: 2 setCycle: End self)
			)
			(24
				(= local24
					((Act new:)
						view: 770
						loop: 0
						cel: 0
						posn: (+ (local13 x:) 6) (local13 y:)
						ignoreActors:
						setCycle: End self
						cycleSpeed: 2
						setPri: 15
						init:
						yourself:
					)
				)
			)
			(25
				(local24 setLoop: 1 setCycle: End self)
				(local13 loop: 1 forceUpd:)
			)
			(26
				(local24 dispose:)
				(cls)
				(= local25 (Print 222 16 #title {Rosella} #at 1 161 #width 200 #dispose)) ; ""Th-thank-you, Genesta...I think," Rosella stammers."
				(local13 loop: 2 setCycle: End cycleSpeed: 4 cel: 0)
				(local19 loop: 3 stopUpd: forceUpd:)
				(Timer setReal: self 10)
			)
			(27
				(cls)
				(= local25 (Print 222 17 #title {Genesta} #at 80 161 #width 220 #dispose)) ; "It will be better for you," the fairy says. "Well, I must be off while I can still fly. I KNOW you can do it!"
				(Timer setReal: self 9)
			)
			(28
				(cls)
				(local19
					setMotion: MoveTo -30 (+ (gCurRoom horizon:) 1)
					cycleSpeed: 0
					setCycle: Fwd self
				)
				(local9 ignoreBlocks: fairyBlock)
				(if global223
					(local10 ignoreBlocks: fairyBlock)
					(local10 setMotion: MoveTo -30 (+ (gCurRoom horizon:) 1))
				)
				(local9 setMotion: MoveTo -30 (+ (gCurRoom horizon:) 1))
				(cls)
				(= local25 (Print 222 18 #title {Genesta} #at 200 161 #dispose)) ; "Good-bye, good luck."
				(Timer setReal: self 7)
			)
			(29
				(local13 setLoop: 1 cel: 0 forceUpd:)
				(Timer setReal: self 13)
			)
			(30
				(cls)
				(= local25 (Print 222 19 #at -1 161 #dispose)) ; "Well, you're on your own, Rosella."
				(Timer setReal: self 4)
			)
			(31
				(if
					(or
						(and (== local1 127) (== (openMusic prevSignal:) 93))
						(== (openMusic signal:) -1)
						(== (openMusic prevSignal:) (openMusic signal:) 127)
					)
					(cls)
					(= seconds 5)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(32
				(openMusic dispose:)
				(gGame restart:)
			)
		)
	)
)

(instance stopRosella of Code ; UNUSED
	(properties)

	(method (doit)
		(local13 stopUpd:)
	)
)

(instance hideRosella of Code ; UNUSED
	(properties)

	(method (doit)
		(local13 hide:)
	)
)

(instance gotHere of Code ; UNUSED
	(properties)

	(method (doit)
		(Print 222 20) ; "Got Here"
	)
)

(instance blinkEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7
					((Act new:)
						view: 765
						loop: 3
						setCel: 0
						posn: 201 67
						setPri: 14
						cycleSpeed: 2
						ignoreActors:
						hide:
						init:
						yourself:
					)
				)
				(self changeState: 1)
			)
			(1
				(local7 hide:)
				(Timer setReal: self (Random 4 7))
			)
			(2
				(local7 show: setCycle: End self)
			)
			(3
				(self changeState: 1)
			)
			(4
				(if timer
					(timer dispose:)
				)
				(local7 show:)
				(local7 setLoop: 1 setCycle: End self)
			)
			(5
				(local7 setLoop: 3 hide:)
				(= local5 ((Act new:) view: 765 setLoop: 4 init: yourself:))
				(local5
					cel: 2
					setCel:
					posn: (+ (local7 x:) 9) (+ (local7 y:) 6)
					setPri: 15
					ignoreActors:
					setStep: 0 1
					setMotion: MoveTo (+ (local7 x:) 9) (+ (local7 y:) 30) self
				)
			)
			(6
				(local5 dispose:)
				(self changeState: 1)
			)
			(7
				(local7 dispose:)
			)
		)
	)
)

(instance rosellaBlinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7
					((Act new:)
						view: 753
						loop: 1
						setCel: 0
						posn: 50 64
						setPri: 14
						cycleSpeed: 5
						ignoreActors:
						init:
						yourself:
					)
				)
				(self changeState: 1)
			)
			(1
				(local7 hide:)
				(Timer setReal: self (Random 4 7))
			)
			(2
				(local7 show: setCycle: End self)
			)
			(3
				(self changeState: 1)
			)
			(4
				(if timer
					(timer dispose:)
				)
			)
		)
	)
)

(instance setupRoom209 of Code
	(properties)

	(method (doit)
		(gCurRoom drawPic: 209)
		((View new:)
			view: 771
			cel: 0
			loop: 2
			posn: 165 169
			ignoreActors:
			setPri: 1
			addToPic:
		)
		(= local8
			((Act new:)
				view: 771
				loop: 3
				posn: 152 104
				setPri: 14
				ignoreActors:
				cycleSpeed: 0
				setCycle: Fwd
				init:
				yourself:
			)
		)
	)
)

(instance setupRoom25 of Code
	(properties)

	(method (doit)
		(gCurRoom drawPic: 25)
		(if global223
			(= local28 (Prop new:))
			(= local29 (Prop new:))
			(local28
				view: 666
				loop: 6
				cel: 1
				posn: 254 182
				setPri: 0
				ignoreActors:
				setCycle: Fwd
				init:
			)
			(local29
				view: 666
				loop: 7
				cel: 1
				posn: 226 164
				setPri: 0
				ignoreActors:
				setCycle: Fwd
				init:
			)
			(wave1
				view: 666
				loop: 3
				cel: 3
				posn: 177 74
				setPri: 0
				ignoreActors:
				setCycle: Fwd
				cycleSpeed: 1
				init:
			)
			(wave2
				view: 666
				loop: 4
				cel: 3
				posn: 164 115
				setPri: 0
				ignoreActors:
				setCycle: Fwd
				cycleSpeed: 1
				init:
			)
			(waves add: wave1)
			(waves add: wave2)
			(wave1 setScript: waveActions)
		)
	)
)

(instance fairyBlock of Cage
	(properties
		top 66
		left 152
		bottom 115
		right 319
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local30 0)) (< local30 (waves size:)) ((++ local30))
					((View new:)
						view: ((waves at: local30) view:)
						loop: ((waves at: local30) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local30) x:)
						y: ((waves at: local30) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local30 0)
				(self changeState: 1)
			)
			(1
				((waves at: local30) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local30) hide:)
				(if (< local30 (- (waves size:) 1))
					(++ local30)
				else
					(= local30 0)
				)
				(waveActions changeState: 1)
			)
			(10
				(wave2 dispose:)
				(wave1 setScript: 0 dispose:)
			)
		)
	)
)

(instance highState of Script
	(properties)

	(method (cue)
		(if (> (openMusic signal:) local1)
			(= local1 (openMusic signal:))
		)
	)
)

