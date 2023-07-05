;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm540 0
)

(instance rm540 of KQ6Room
	(properties
		noun 2
		picture 540
		south 510
	)

	(method (init &tmp temp0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 268 189 314 118 307 100 253 92 190 93 156 96 87 97 89 103 62 105 43 112 29 125 41 149 102 157 58 187 0 182 0 0 319 0 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 281 115 250 120 211 122 146 120 114 117 110 104 131 101 206 100 273 107
					yourself:
				)
		)
		(super init: &rest)
		(gGlobalSound number: 540 flags: 1 loop: -1 play:)
		(gGame handsOff:)
		(castle init:)
		(hedge init:)
		(beastPath init:)
		(fountain init:)
		(gateFeat init:)
		(spout init: setCycle: Fwd)
		(spray init: setCycle: Fwd)
		(gate init:)
		(gEgo init: reset: 3 posn: 125 187 setScale: Scaler 100 68 190 80)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
		(cond
			((== gPrevRoomNum 250)
				(beauty
					init:
					setScale: Scaler 100 68 190 100
					setStep: 4 3
					setCycle: Walk
				)
				(beast init:)
				((ScriptID 0 5) dispose:) ; beastTimer
				(weasel init: setCycle: Walk)
				(glint init: hide:)
				(self setScript: beautyScript)
			)
			((not (IsFlag 46))
				(beast init:)
				(self setScript: beastScript)
				(gEgo setMotion: MoveTo 116 131)
			)
			(else
				(gGame handsOn:)
				(gEgo setMotion: MoveTo 116 131)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 969)
	)
)

(instance gateFx of Sound
	(properties)
)

(instance beast of Actor
	(properties
		x 72
		y 62
		view 533
		loop 2
		signal 24576
		illegalBits 0
	)
)

(instance beauty of Actor
	(properties
		x 158
		y 189
		view 252
		loop 3
		signal 24576
	)
)

(instance weasel of Actor
	(properties
		x 301
		y 163
		view 545
		loop 1
	)
)

(instance glint of Prop
	(properties
		view 902
		signal 16384
	)
)

(instance spout of Prop
	(properties
		x 199
		y 89
		view 540
		cel 2
		priority 8
		signal 16400
	)

	(method (doVerb)
		(fountain doVerb: &rest)
	)
)

(instance spray of Prop
	(properties
		x 198
		y 89
		view 540
		loop 1
		cel 2
		priority 8
		signal 16
	)

	(method (doVerb)
		(fountain doVerb: &rest)
	)
)

(instance gate of Prop
	(properties
		x 72
		y 62
		view 5402
		signal 16384
	)

	(method (doVerb theVerb)
		(gateFeat doVerb: theVerb &rest)
	)
)

(instance castle of Feature
	(properties
		noun 6
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 43)
					(gMessager say: noun theVerb 4 1) ; "Beast's castle has a different, more welcoming air as the bridal home of Beauty and her prince."
				else
					(gMessager say: noun theVerb 3 1) ; "Beast's castle seems forlorn and far from any human warmth."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hedge of Feature
	(properties
		noun 7
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 43)
					(gMessager say: noun theVerb 4 1) ; "The hedge maze stands like a moat between the castle of the two new lovers and the rest of the world. Alexander has no desire to disturb them further."
				else
					(gMessager say: noun theVerb 3 1) ; "The maze of hedges seems to be a final obstacle protecting Beast's privacy. Having seen the result of his other violations, Alexander has no desire to test the maze."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fountain of Feature
	(properties
		x 198
		y 127
		noun 5
		onMeCheck 16
		approachX 196
		approachY 115
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 57 58 59 60 96 56) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1, fakeLamp5
			(if (IsFlag 77)
				(gMessager say: noun theVerb 8)
			else
				(gMessager say: noun theVerb 9)
			)
		else
			(switch theVerb
				(5 ; Do
					(gGame handsOff:)
					(gCurRoom setScript: getWater 0 0)
				)
				(43 ; huntersLamp
					(cond
						((& global161 $0001)
							(gMessager say: noun 43 5) ; "Alexander has already gotten some fountain water."
						)
						((not (IsFlag 43))
							(gMessager say: noun theVerb 3 1) ; "There's no time to do anything with the fountain now! Alexander's about to turn into a beast!"
						)
						((not (IsFlag 77))
							(gMessager say: 5 43 9 0) ; "Why would Alexander want to put fountain water in the hunter's lamp?"
						)
						(
							(or
								(not (& global161 $0004))
								(not (& global161 $0002))
							)
							(gMessager say: noun theVerb 10) ; "The lamp is not ready for the fountain water."
						)
						(else
							(gGame handsOff:)
							(gCurRoom setScript: getWater 0 43)
						)
					)
				)
				(44 ; teaCup
					(cond
						((not (IsFlag 43))
							(gMessager say: noun 43 3 1) ; "There's no time to do anything with the fountain now! Alexander's about to turn into a beast!"
						)
						((IsFlag 77)
							(gMessager say: noun 56 8) ; "The fountain water might do for 'falling water,' it's true, but the "Make Rain Spell" calls for a teapot. That looks nothing like a teapot."
						)
						(else
							(gMessager say: noun 56 9) ; "Why would Alexander want to put fountain water in that?"
						)
					)
				)
				(24 ; sacredWater
					(if (not (IsFlag 43))
						(gMessager say: noun 43 3 1) ; "There's no time to do anything with the fountain now! Alexander's about to turn into a beast!"
					else
						(gMessager say: noun 26 0) ; "The Oracle's vial is already full."
					)
				)
				(0
					(if (IsFlag 43)
						(gMessager say: noun theVerb 4 1) ; MISSING MESSAGE
					else
						(gMessager say: noun theVerb 3 1) ; MISSING MESSAGE
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance beastPath of Feature
	(properties
		noun 4
		onMeCheck 32
	)
)

(instance gateFeat of Feature
	(properties
		noun 8
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 43)
					(gMessager say: noun theVerb 4 1) ; "The gate has been firmly shut and latched. It looks like the prince and his Beauty need some time alone."
				else
					(gMessager say: noun theVerb 3 1) ; "The gate has been firmly shut and latched. Beast doesn't seem to welcome Alexander's company right now."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 543)
				(gate hide:)
				(beast
					posn: 72 62
					view: 533
					setLoop: 0
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(beast
					view: 5406
					posn: 96 98
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(gateFx number: 542 play:)
			)
			(2
				(gateFx number: 543 play:)
				(gate show:)
				(gEgo setMotion: MoveTo 107 130 self)
				(beast
					view: 542
					setScale: Scaler 100 68 190 100
					setCycle: Walk
					setStep: 4 3
					setLoop: 2
					y: (+ (beast y:) 3)
					setMotion: MoveTo 69 129 self
				)
			)
			(3 0)
			(4
				(beast view: 543 setLoop: 3 cel: 0)
				(= cycles 2)
			)
			(5
				(Face gEgo beast self)
			)
			(6
				(= cycles 2)
			)
			(7
				(myConv
					add: -1 1 0 1 1 ; "<GROWL!> Who dares enter Beast's garden?"
					add: -1 1 0 1 2 ; "My name is Alexander. I didn't mean to disturb your private garden."
					add: -1 1 0 1 3 ; "NO? And yet, Monsieur, you could hardly have 'accidentally' broken through the three enchanted traps of the Isle of the Beast!"
					add: -1 1 0 1 4 ; "Er.... I suppose it is simply my nature to break through enchanted traps."
					add: -1 1 0 1 5 ; "<Grrr> You must be a prince, then. I know the nature of princes all too well. This face you see before you is hideous, is it not?"
					init: self
				)
			)
			(8
				(beast setCycle: End self)
			)
			(9
				(myConv add: -1 1 0 1 6 add: -1 1 0 1 7 init: self) ; "Well...for the face of a beast, it is really quite noble.", "Ha! I'm glad you like it, for you will soon own one just like it. I, too, was once a pretty prince--caring for nothing but adventuring and rescuing fair maidens."
			)
			(10
				(beast setCycle: Beg self)
			)
			(11
				(myConv
					add: -1 1 0 1 8 ; "But I rankled one too many evil hags. One dark night, I was turned into this obscenity you see before you; warped in shape and trapped on this enchanted island over a hundred years ago."
					add: -1 1 0 1 9 ; "Surely, there is a way off this island."
					add: -1 1 0 1 10 ; "Oh, surely. You broke in, did you not? And yet, think; where would I go clad so 'eloquently' as I am with this silk--and this PELT?"
					add: -1 1 0 1 11 ; "You see, my prison is also my sanctuary. You are the first to break through the barriers in lo these many years. That is--except for the Druids who stole my heirloom coat of arms!"
					add: -1 1 0 1 12 ; "If there's any way I can help...."
					add: -1 1 0 1 13 ; "Help? You? I'm afraid you don't understand. The enchanted barriers were a warning and protection for YOU more than for me. Your prize for forcing your way past them is to join me in this dire life."
					add: -1 1 0 1 14 ; "By the laws of this sorcery, you are doomed to be trapped in the form of a beast. Your reward for broaching this garden is to be my slave, a slave as beastly as I am. You have only a few hours of humanity left."
					add: -1 1 0 1 15 ; "But that's not possible! There must be some way to break the enchantment! Spells always have a weakness somewhere."
					add: -1 1 0 1 16 ; "The enchantment you are under is tied to my own. The sorceress left me a 'way out,' all right, but I'm afraid it was only her final bitter joke."
					init: self
				)
			)
			(12
				(myConv
					add: -1 1 0 1 17 ; "(VERY BITTERLY) You see, I need only find a maiden to join me here; to share my castle, my life...willingly. Take another look at me. You can't help but admire the hag's terrible cruelty and cunning."
					add: -1 1 0 1 18 ; "(FIRMLY)I shall try to find such a maid, for Cassima's sake."
					add: -1 1 0 1 19 ; "Truly? How determined of you. I, personally, would not waste my last few hours as a man on an impossible errand. However, you may do as you please. I give you this token."
					init: self
				)
			)
			(13
				(gEgo hide:)
				(beast setLoop: 2 setCycle: End self)
			)
			(14
				(myConv
					add: -1 1 0 1 20 ; "It's my family ring and the only heirloom I have left. If, perchance, you should.... If you think you have found a maid.... <Grrrf>"
					add: -1 1 0 1 21 ; "I shall give her this ring."
					add: -1 1 0 1 22 ; "Yes. She must accept it of her own free will. By doing so, she accepts me. Not that you shall find anyone, mind you!"
					init: self
				)
			)
			(15
				(gEgo show:)
				(beast view: 542 setLoop: 0 setCycle: Walk)
				(= cycles 2)
			)
			(16
				(myConv add: -1 1 0 1 23 init: self) ; "Your time is short. Count the minutes on your fingers while fingers you have, pretty prince. Your master will await you."
			)
			(17
				(beast setLoop: 3 setMotion: MoveTo 96 98 self)
				(gEgo setHeading: 315)
			)
			(18
				(gEgo setHeading: 0)
				(gate hide:)
				(beast
					view: 532
					setScale: 0
					setLoop: 1
					cel: 0
					setCycle: End self
				)
				(gateFx number: 542 play:)
			)
			(19
				(beast setLoop: 2 cel: 0 setCycle: End self)
			)
			(20
				(gateFx number: 543 play:)
				(gate show:)
				(beast
					setPri: (- (gate priority:) 1)
					posn: 72 62
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(21
				(gGame handsOn:)
				((ScriptID 0 5) setReal: (gInventory at: 37) 0 3 0) ; beastTimer, ring
				(SetFlag 46)
				(gGame givePoints: 1)
				(gEgo get: 37) ; ring
				(beast dispose:)
				(self dispose:)
			)
		)
	)
)

(instance beautyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gate hide:)
				(beast
					posn: 72 62
					view: 533
					setLoop: 0
					ignoreActors: 1
					setCycle: End self
				)
				(beauty setScript: beautyWalkScript self)
			)
			(2
				(beast
					view: 5406
					posn: 96 98
					setLoop: 1
					cel: 0
					setCycle: End self
				)
				(gateFx number: 542 play:)
			)
			(3
				(gateFx number: 543 play:)
				(gate show:)
				(beast
					view: 542
					setScale: Scaler 100 68 190 100
					setCycle: Walk
					setStep: 4 3
					setLoop: -1
					y: (+ (beast y:) 3)
					setMotion: MoveTo 114 134 self
				)
				(UnLoad 128 533)
				(weasel setScript: weaselScript)
			)
			(4)
			(5
				(beast setLoop: 4 cel: 0)
				(= cycles 2)
			)
			(6
				(myConv
					add: -1 1 0 2 1 ; "I see you wear my ring. You willingly agree to spend your life here with me? Do you know what that means?"
					add: -1 1 0 2 2 ; "Yes, m'lord, I do. I have been touched by your story."
					add: -1 1 0 2 3 ; "Pity alone need not sentence you to endure this face."
					add: -1 1 0 2 4 ; "(ENTHUSIASTIC) Oh, but it is a gentle face, and kind."
					add: -1 1 0 2 5 ; "(EXULTING) You look at me so sweetly and are not repulsed.... Oh! By the light of your eyes my spirit soars!"
					init: self
				)
			)
			(7
				(beast view: 544 setLoop: 2 cel: 0 setCycle: End self)
				(gateFx number: 546 play:)
				(SetFlag 113)
			)
			(8
				(gMessager say: 1 0 2 6 self) ; "(EXULTING) The enchantment! It is broken!"
			)
			(9
				(beauty view: 5405 setLoop: 0 cel: 0 setCycle: End self)
				(UnLoad 128 544)
			)
			(10
				(UnLoad 128 252)
				(gMessager say: 1 0 2 7 self) ; "(SADLY, VERY QUIETLY) I am pleased to have served you, m'lord. Do you still wish me to stay?"
			)
			(11
				(gMessager say: 1 0 2 8 self) ; "(SURPRISED, FIRM, TENDER) What? Speak not such nonsense, Beauty! Do you think that I learned nothing of true love during my time here? You are my queen."
			)
			(12
				(beauty setLoop: 1 cel: 0 setCycle: End self)
				(gateFx number: 546 play:)
				(SetFlag 43)
			)
			(13
				(beast
					view: 547
					setLoop: 4
					cel: 0
					posn: (- (beast x:) 1) (+ (beast y:) 2)
				)
				(gGlobalSound stop:)
				(gGlobalSound number: 544 loop: -1 play:)
				(= seconds 2)
			)
			(14
				(beauty view: 546 setLoop: 4 cel: 2)
				(= cycles 2)
			)
			(15
				(myConv add: -1 1 0 2 9 add: -1 1 0 2 10 init: self) ; "(AWED) Oh! My clothes...! This gown...!", "How well it suits your noble heart."
			)
			(16
				(gEgo setMotion: MoveTo (+ (beauty x:) 30) (beauty y:) self)
			)
			(17
				(Face gEgo beauty self)
			)
			(18
				(gMessager say: 1 0 2 11 self) ; "(WHISPERING) Alexander, how can I ever repay you? I have nothing to offer except my gratitude. But, please, take these old clothes. Perhaps you'll find someone in need during your travels."
			)
			(19
				(gMessager say: 1 0 2 12 self) ; "You have already repaid me by your example of courage, Beauty, and by your friendship, I hope."
			)
			(20
				(gEgo get: 5 hide:) ; clothes
				(if (not (IsFlag 93))
					(SetFlag 112)
				)
				(beauty
					view: 549
					setLoop: 2
					cel: 0
					posn: (+ (beauty x:) 30) (+ (beauty y:) 1)
					setCycle: End self
				)
			)
			(21
				(beauty
					view: 546
					posn: (- (beauty x:) 30) (- (beauty y:) 1)
					setLoop: 4
					cel: 0
				)
				(UnLoad 128 549)
				(gEgo show:)
				(= seconds 1)
			)
			(22
				(myConv add: -1 1 0 2 13 add: -1 1 0 2 14 init: self) ; "You will always have our friendship and loyalty, Prince Alexander. But from a fellow adventurer, take some advice. If you find your true love, protect her with your life. We are all beasts without the redeeming humanity of love.", "And to aid you, accept my mirror. Now that my life is no longer hung in false shadows, I have no need for it. Give it to someone with nothing to fear from the truth it reveals."
			)
			(23
				(gEgo
					ignoreActors: 1
					ignoreHorizon: 1
					setPri: (- (beauty priority:) 1)
					setMotion: MoveTo (+ (beast x:) 32) (beast y:) self
				)
			)
			(24
				(beast
					view: 5403
					setLoop: 0
					cel: 0
					posn: (+ (beast x:) 18) (+ (beast y:) 1)
				)
				(gEgo
					normal: 0
					view: 541
					setLoop: 1
					cel: 0
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 4)
				)
				(beauty cel: 3)
				(= cycles 1)
			)
			(25
				(beast cel: 1)
				(= cycles 1)
			)
			(26
				(beauty cel: 1)
				(beast setCycle: End self)
				(gEgo setCycle: End self)
			)
			(27 0)
			(28
				(beast
					view: 548
					setLoop: 0
					cel: 0
					posn: (- (beast x:) 16) (+ (beast y:) 1)
				)
				(gEgo
					get: 24 ; mirror
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 4)
					reset:
					setPri: (- (beauty priority:) 1)
				)
				(= cycles 3)
			)
			(29
				(UnLoad 128 541)
				(UnLoad 128 5403)
				(myConv add: -1 1 0 2 15 init: self) ; "Thank you. I wish you both well."
			)
			(30
				(gEgo
					setCycle: Rev
					setLoop: 1
					setMotion: PolyPath (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(31
				(gEgo reset: 1)
				(beast setCycle: End self)
				(beauty view: 548 setLoop: 1 cel: 0 setCycle: End self)
			)
			(32 0)
			(33
				(gMessager say: 1 0 2 16 self) ; "Come, Beauty. Let me take you home."
			)
			(34
				(beauty hide:)
				(beast
					view: 5441
					setLoop: 0
					cel: 0
					posn: (+ (beast x:) 22) (beast y:)
					setCycle: End self
				)
			)
			(35
				(beast setLoop: 1 cel: 0 setCycle: End self)
			)
			(36
				(gEgo setHeading: 315)
				(beast
					view: 547
					setLoop: -1
					setCycle: Walk
					setLoop: 3
					setPri:
					posn: (- (beast x:) 9) (- (beast y:) 1)
					setMotion: MoveTo 84 102 self
				)
				(beauty
					view: 546
					setLoop: 3
					posn: (+ (beast x:) 17) (+ (beast y:) 1)
					setPri: (- (beast priority:) 1)
					show:
					setCycle: Walk
					setMotion: PolyPath 108 104
				)
				(UnLoad 128 548)
			)
			(37
				(gate hide:)
				(beast
					view: 534
					setLoop: 0
					cel: 0
					posn: 96 98
					setScale: 0
					setPri: -1
					setCycle: End self
				)
				(beauty setPri: -1)
				(gateFx number: 542 play:)
				(weaselScript register: 1)
			)
			(38
				(beauty setMotion: MoveTo 87 97 self)
			)
			(39
				(beauty setMotion: MoveTo 98 94 self)
			)
			(40
				(beast view: 5407 setLoop: 0 cel: 0 setCycle: End self)
			)
			(41
				(gateFx number: 543 play:)
				(beauty dispose:)
				(beast
					view: 5408
					setLoop: 0
					cel: 0
					posn: 72 62
					setCycle: End self
				)
			)
			(42
				(gate show:)
				(beast dispose:)
				(gGame givePoints: 2)
				(NextAct)
				(self dispose:)
			)
		)
	)
)

(instance beautyWalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(beauty setMotion: MoveTo 157 139 self)
			)
			(1
				(beauty setLoop: 1)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance weaselScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(weasel setMotion: MoveTo 259 165 self)
			)
			(1
				(weasel cel: 0)
				(= cycles 1)
			)
			(2
				(= seconds 5)
			)
			(3
				(glint
					show:
					posn: (- (weasel x:) 14) (weasel y:) 5
					setCycle: End self
				)
			)
			(4
				(glint setCycle: Beg self)
			)
			(5
				(if (not register)
					(self start: 2 init:)
				else
					(glint hide:)
					(= cycles 1)
				)
			)
			(6
				(weasel setMotion: MoveTo 175 183 self)
			)
			(7
				(glint
					show:
					posn: (- (weasel x:) 13) (weasel y:) 5
					setCycle: End self
				)
			)
			(8
				(glint setCycle: Beg self)
			)
			(9
				(glint dispose:)
				(weasel setMotion: MoveTo 90 210 self)
			)
			(10
				(gGame handsOn:)
				(weasel dispose:)
			)
		)
	)
)

(instance getWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 163 122 self)
				else
					(gEgo setMotion: PolyPath 165 121 self)
				)
			)
			(1
				(gEgo
					normal: 0
					setCel: 0
					cycleSpeed: 9
					view: 5404
					setLoop: (if register 5 else 2)
					setCycle: End self
				)
			)
			(2
				(gEgo reset: 6)
				(= cycles 4)
			)
			(3
				(if register
					(if (not (IsFlag 14))
						(gGame givePoints: 1)
					)
					(|= global161 $0001)
					(gMessager say: 5 43 6 0 self) ; "Alexander fills the hunter's lamp to the brim with the fountain water."
				else
					(gMessager say: 5 5 0 0 self) ; "The fountain water is cool and clear."
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance myConv of Conversation
	(properties)
)

