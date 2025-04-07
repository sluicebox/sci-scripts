;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use GloryTalker)
(use Interface)
(use RandCycle)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm490 0
	babaTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(return
		(switch global439
			(1 11)
			(2 8)
			(3 5)
		)
	)
)

(instance rm490 of GloryRm
	(properties
		picture 490
	)

	(method (init)
		(if gDebugging
			(switch (GetNumber {event num? (1, 2 or 3)})
				(1
					(ClearFlag 166)
				)
				(2
					(gEgo get: 28) ; thePiepan
					((gInventory at: 28) ; thePiepan
						maskCel: (| ((gInventory at: 28) maskCel:) $0008) ; thePiepan
					)
				)
				(3
					(SetFlag 179)
				)
			)
		)
		(= local6 gEgoGait)
		(gEgo init: setScale: 0)
		(theBat init: setPri: 159)
		(cond
			((IsFlag 179)
				(= local2 3)
				(self setScript: s3rdEntrance)
			)
			((and (gEgo has: 28) (& ((gInventory at: 28) maskCel:) $0008)) ; thePiepan, thePiepan
				(= local2 2)
				(self setScript: s2ndEntrance)
			)
			(else
				(= local2 1)
				(self setScript: sFirstEntrance)
			)
		)
		(gLongSong number: 490 setLoop: -1 play:)
		(super init: &rest)
		(candle1 setCycle: RandCycle init:)
		(candle2 setCycle: RandCycle init:)
		(candle3 setCycle: RandCycle init:)
		(candle4 setCycle: RandCycle init:)
		(candle5 setCycle: RandCycle init:)
		(candle6 setCycle: RandCycle init:)
		(candle7 setCycle: RandCycle init:)
		(theBall setCycle: RandCycle init:)
		(fireplace setCycle: RandCycle init:)
		(theFire setCycle: RandCycle init:)
		(bubbles setCycle: Fwd init:)
		(gloryHand init:)
		(crystalBall init:)
		(candles init:)
		(tableFoot init:)
		(table init:)
		(doorSkull init:)
		(demonSkull init:)
		(bucket init:)
		(skeleton init:)
		(backScratcher init:)
		(theDoor init:)
		(candles2 init:)
		(candles3 init:)
		(cauldron init:)
		(fFirePlace init:)
		(bottle init:)
		(humanSkull init:)
		(cobwebs init:)
		(topShelf init:)
		(bookShelf init:)
		(jarShelf init:)
		(belowShelf init:)
		(boneNecklace init:)
		(RemapColors 3 253 75) ; ToGray
	)

	(method (newRoom newRoomNumber)
		(gGlory handsOff:)
		(gEgo changeGait: local6)
		(gLongSong fade:)
		(SetFlag 166)
		(super newRoom: newRoomNumber)
	)
)

(instance sFirstEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo posn: 80 128 normalize: 4)
				(= ticks 180)
			)
			(1
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 1 6 1 0 self) ; "You have a sense of doom hanging over you."
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 1 6 2 0 self) ; "A strangely familiar scratchy voice shouts, "Now!""
			)
			(3
				(spider init: setCycle: End self)
			)
			(4
				(spider signal: (& (spider signal:) $fffe))
				(= ticks 60)
			)
			(5
				(theBucket
					init:
					posn: 91 118
					view: 493
					loop: 1
					cel: 0
					setCycle: CT 8 1 self
				)
			)
			(6
				(gEgo hide:)
				(theBucket setCycle: CT 11 1 self)
			)
			(7
				(theBucket signal: (& (theBucket signal:) $fffe))
				(baba init: setCycle: End self)
				(soundFX number: 971 play:)
			)
			(8
				(baba signal: (& (baba signal:) $fffe))
				(= ticks 60)
			)
			(9
				(gMessager say: 2 6 3 0 self) ; "Spirits of the frigid north, Spin the water, draw it forth. Frosty Spirits, summoned twice --  Turn the water into ice!"
			)
			(10
				(= ticks 60)
			)
			(11
				(RemapColors 2 253 140) ; ByPercent
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(12
				(baba setLoop: 3 setCel: 0 setCycle: End self)
				(soundFX number: 983 play:)
			)
			(13
				(theBucket
					signal: (| (theBucket signal:) $0001)
					setCycle: End self
				)
				(baba setLoop: 1 setCycle: ForwardCounter 2)
			)
			(14
				(theBucket signal: (& (theBucket signal:) $fffe))
				(= ticks 180)
			)
			(15
				(baba signal: (& (baba signal:) $fffe))
				(gMessager say: 2 6 4 0 self) ; "You find yourself trapped in ice."
			)
			(16
				(self setScript: flapWings self)
			)
			(17
				(gMessager say: 2 6 7 0 self) ; "You turned me into a frog, didn't you? Thought I wouldn't remember you? 'Let's just visit Baba Yaga and see what we can turn her into today,' you thought to yourself, hunh?"
			)
			(18
				(self setScript: flapWings self)
			)
			(19
				(gMessager say: 2 6 6 0 self) ; "Good, we'll just skip the main course and go straight to dessert."
			)
			(20
				(heroTeller init: theBucket 490 4 128 3)
				(babaTeller init: baba 490 4 168 3)
				(gUser canInput: 1)
				(gTheIconBar enable: 1 3)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 6)
				)
				(gTheIconBar advanceCurIcon:)
				(= seconds (localproc_0))
			)
			(21
				(gGlory handsOff:)
				(if (and (not local0) (not local1))
					(gMessager say: 2 6 9 0 self) ; "What's the matter, cat got your tongue? Hope not, that's one of my favorite parts. I'm looking forward to 'Tongue on a Bun' and a 'Throat Float' after all."
				else
					(gMessager say: 2 6 8 0 self) ; "Just what I like, a dinner that doesn't make excuses. Bone jour and Bone Appetite!"
				)
			)
			(22
				(gGlory handsOff:)
				(EgoDead 10 490 978 1 912) ; "How Humiliating -- Hors de Combat as an Hors d'oeuvre. Perhaps next time you should try to talk your way out of becoming the main course."
			)
			(23
				(gGlory handsOff:)
				(baba
					signal: (| (baba signal:) $0001)
					setCycle: ForwardCounter 3 self
				)
			)
			(24
				(gGlory handsOff:)
				(baba signal: (& (baba signal:) $fffe))
				(self setScript: flapWings self)
			)
			(25
				(gGlory handsOff:)
				(gMessager say: 2 6 16 0 self) ; "You'd rather have pie? What, Eye Pie?"
			)
			(26
				(gGlory handsOff:)
				(self setScript: flapWings self)
			)
			(27
				(gGlory handsOff:)
				(gMessager say: 2 6 17 0 self) ; "Oh, Elderbury Pie! It's true, we haven't had that for a long while. But I can't very well make one now. I don't have any of the ingredients."
			)
			(28
				(self setScript: flapWings self)
			)
			(29
				(gMessager say: 2 6 18 0 self) ; "You're right, he did bring us some mandrake, didn't he? And it made such a lovely mousse. Very well, but it means no Eye Scream, for now."
			)
			(30
				(RemapColors 2 253 140) ; ByPercent
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(31
				(soundFX number: 936 play:)
				(baba setLoop: 3 setCel: 0 setCycle: End self)
			)
			(32
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance s2ndEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					posn: 80 128
					normalize:
					changeGait: 1 ; running
					setSpeed: 6
					setMotion: MoveTo 110 143 self
				)
			)
			(1
				(gEgo normalize: 4 setSpeed: register setLoop: 4)
				(= cycles 3)
			)
			(2
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 1 6 40 0 self) ; "You feel a sense of menace and the sensation of being watched."
				else
					(self cue:)
				)
			)
			(3
				(gMessager say: 1 6 19 0 self) ; "You quickly step out from under the trap. A moment later, you hear the voice of Baba Yaga."
			)
			(4
				(= ticks 100)
			)
			(5
				(baba init: setCycle: End self)
				(soundFX number: 971 play:)
			)
			(6
				(baba signal: (& (baba signal:) $fffe))
				(= ticks 90)
			)
			(7
				(gMessager say: 2 6 20 0 self) ; "Spirits of the swamp and mire, Aid me in what I desire! Creatures of mist, Beings of Fog, Turn this human into a hedgehog."
			)
			(8
				(RemapColors 2 253 140) ; ByPercent
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(baba setLoop: 3 setCel: 0 setCycle: End self)
				(soundFX number: 936 play:)
			)
			(10
				(baba signal: (& (baba signal:) $fffe))
				(if global440
					(+= state 7)
					(gMessager say: 2 6 22 0 self) ; "What? You have some sort of protection spell going? Didn't help your feet, did it? I guess we'll just have to settle for manwiches again."
				else
					(= register (gEgo cycleSpeed:))
					(gEgo
						view: 491
						setLoop: 0
						setCel: 0
						cycleSpeed: 6
						setCycle: End self
					)
				)
			)
			(11
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 1
					setCycle: ForwardCounter 3
				)
				(= ticks 180)
			)
			(12
				(gMessager say: 2 6 21 0 self) ; "I have a sudden craving for a tiddywiggle. Perhaps some Hedgehog Grog, Hedge-piggy Swiggle, and Pig Newtons."
			)
			(13
				(baba setLoop: 2 setCel: 0 setCycle: End self)
			)
			(14
				(baba setLoop: 3 setCel: 0 setCycle: End self)
				(soundFX number: 936 play:)
			)
			(15
				(baba setLoop: 1 setCycle: ForwardCounter 3 self)
			)
			(16
				(baba signal: (& (baba signal:) $fffe))
				(gEgo setCycle: Beg self)
			)
			(17
				(gEgo normalize: 4 setSpeed: register setLoop: 4)
				(= ticks 60)
			)
			(18
				(gMessager say: 2 6 23 0 self) ; "So now, my dining delight, do you have what I asked for?"
			)
			(19
				(gUser canInput: 1)
				(gTheIconBar enable: 1 3 7)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 6)
				)
				(gTheIconBar advanceCurIcon:)
				(heroTeller init: gEgo 490 4 128 5)
				(babaTeller init: baba 490 4 168 5)
				(self dispose:)
			)
		)
	)
)

(instance s3rdEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					posn: 80 128
					normalize:
					changeGait: 1 ; running
					setSpeed: 6
					setMotion: MoveTo 110 143 self
				)
			)
			(1
				(gEgo normalize: 4 setSpeed: register setLoop: 4)
				(= cycles 3)
			)
			(2
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 1 6 41 0 self) ; "You feel a sense of wariness and more than a little hunger."
				else
					(self cue:)
				)
			)
			(3
				(gMessager say: 1 6 27 0 self) ; "Baba Yaga speaks out loud."
			)
			(4
				(= ticks 60)
			)
			(5
				(baba init: setCycle: End self)
				(soundFX number: 971 play:)
			)
			(6
				(baba signal: (& (baba signal:) $fffe))
				(= ticks 60)
			)
			(7
				(gMessager say: 2 6 28 0 self) ; "Back so soon? I hope for your sake you brought us something to eat. After all, there's always room for Hero, heh, heh, heh."
			)
			(8
				(gTheIconBar enable: 1 3 7)
				(gUser canInput: 1)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 6)
				)
				(gTheIconBar advanceCurIcon:)
				(heroTeller init: gEgo 490 4 128 7)
				(babaTeller init: baba 490 4 168 7)
				(self dispose:)
			)
		)
	)
)

(instance sGivePie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo drop: 28 1) ; thePiepan
				(SetFlag 179)
				(gGlory handsOff:)
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 2 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(baba setLoop: 3 setCel: 0 setCycle: End self)
				(soundFX number: 936 play:)
			)
			(2
				(baba setLoop: 1)
				(thePie init:)
				(heroTeller dispose:)
				(babaTeller dispose:)
				(heroTeller init: gEgo 490 4 128 6)
				(babaTeller init: baba 490 4 168 6)
				(= ticks 120)
			)
			(3
				(gMessager say: 2 46 47 0 self) ; "Yum, that smells delicious. Just the way we like it, fresh from the fire."
			)
			(4
				(baba setCycle: ForwardCounter 3 self)
			)
			(5
				(baba signal: (& (baba signal:) $fffe))
				(gMessager say: 2 6 24 0 self) ; "So let me think, how should I reward you for such a lovely pie?"
			)
			(6
				(self setScript: flapWings self)
			)
			(7
				(gMessager say: 2 6 25 0 self) ; "Oh, all right, I suppose he did do us a favor. It wouldn't be polite to eat him now. Besides, he may be useful in the future."
			)
			(8
				(gUser canInput: 1)
				(gTheIconBar enable: 1 3)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 6)
				)
				(gTheIconBar advanceCurIcon:)
				(self dispose:)
			)
		)
	)
)

(instance sWarningDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 6 32 0 self) ; "Enough of this! If you won't give me something to eat, I'll just have to help myself. How about some 'Green Legs and Man'?"
			)
			(1
				(EgoDead 63 490 978 1 912) ; "Next time you visit Baba Yaga, don't forget to bring something suitably gruesome to gnaw on besides yourself."
			)
		)
	)
)

(instance sEventBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 5)
			)
			(1
				(gMessager say: 2 6 register 0 self)
			)
			(2
				(RemapColors 2 253 140) ; ByPercent
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(baba setLoop: 3 setCel: 0 setCycle: End self)
				(soundFX number: 936 play:)
			)
			(4
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance sGiveFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch register
					(27
						(gEgo drop: 12 1) ; theBonemeal
					)
					(47
						(gEgo drop: 29 1) ; theBones
					)
					(40
						(gEgo drop: 22 1) ; theGarlic
					)
					(26
						(gEgo drop: 11 1) ; theGruegoo
					)
				)
				(gMessager say: 2 register 29 0 self)
			)
			(1
				(baba
					signal: (| (baba signal:) $0001)
					setLoop: 1
					setCycle: ForwardCounter 3 self
				)
			)
			(2
				(baba signal: (& (baba signal:) $fffe))
				(gMessager say: 2 6 52 0 self) ; "So what do you want for this?"
				(heroTeller dispose:)
				(babaTeller dispose:)
				(heroTeller init: gEgo 490 4 128 8)
				(babaTeller init: baba 490 4 168 8)
			)
			(3
				(gTheIconBar enable: 1 3 7)
				(gUser canInput: 1)
				(if (not (gTheIconBar curInvIcon:))
					(gTheIconBar disable: 6)
				)
				(gTheIconBar advanceCurIcon:)
				(self dispose:)
			)
		)
	)
)

(instance flapWings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setLoop: 5)
				(if (not (gCast contains: babaHead))
					(babaHead init:)
				else
					(babaHead show:)
				)
				(babaHead setCycle: End)
				(theBat
					signal: (| (theBat signal:) $0001)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(theBat setLoop: 3 setCel: 0 setCycle: ForwardCounter 3 self)
			)
			(2
				(theBat setLoop: 4 setCel: 0 setCycle: End self)
				(babaHead setCycle: Beg self)
			)
			(3 0)
			(4
				(theBat signal: (& (theBat signal:) $fffe))
				(baba setLoop: 1)
				(babaHead hide:)
				(self dispose:)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties
		loopMenu 0
	)

	(method (showCases)
		(super
			showCases:
				43
				(and (not [gEgoStats 36]) [gEgoStats 12]) ; invisibilitySpell, magic
				56
				(and (not [gEgoStats 36]) [gEgoStats 12]) ; invisibilitySpell, magic
				36 ; Tell About Gnome
				(or
					(== local2 1)
					(== local2 2)
					(and (== local2 3) (not (IsFlag 180)))
				)
				72 ; Ask about Ritual
				(and
					(not (gEgo has: 54)) ; theBreathRit
					(not (IsFlag 396))
					(or
						(== local2 1)
						(== local2 2)
						(and (== local2 3) (IsFlag 110))
					)
				)
				74 ; Ask for Dark One Ritual
				(and
					(not (gEgo has: 54)) ; theBreathRit
					(not (IsFlag 396))
					(or
						(== local2 1)
						(== local2 2)
						(and (== local2 3) (not (IsFlag 110)))
					)
				)
				57 ; Ask for "Something Different"
				(and (not (gEgo has: 54)) (not (IsFlag 396))) ; theBreathRit
		)
	)

	(method (sayMessage)
		(if (not (IsFlag 166))
			(= local0 1)
			(if (!= iconValue 15) ; Tell About Gnome
				(sFirstEntrance seconds: (localproc_0))
			else
				(sFirstEntrance state: (+ (sFirstEntrance state:) 3))
			)
		)
		(if (== local2 2)
			(= local3 1)
			(switch iconValue
				(56
					(gEgo solvePuzzle: 496 6 2 learn: 36 100) ; invisibilitySpell
				)
				(43
					(gEgo solvePuzzle: 496 6 2 learn: 36 100) ; invisibilitySpell
				)
				(55 ; Tell About Gnome's Humor
					(gEgo get: 31) ; theHumorbar
					(SetFlag 180)
				)
				(47 ; Tell About Pie
					(= local3 0)
				)
				(72 ; Ask about Ritual
					(SetFlag 396)
					(gEgo get: 54) ; theBreathRit
				)
				(57 ; Ask for "Something Different"
					(SetFlag 396)
					(gEgo get: 54) ; theBreathRit
				)
			)
		)
		(if (== local2 3)
			(= local4 1)
			(switch iconValue
				(43
					(gEgo solvePuzzle: 496 6 2 learn: 36 100) ; invisibilitySpell
				)
				(56
					(gEgo solvePuzzle: 496 6 2 learn: 36 100) ; invisibilitySpell
				)
				(36 ; Tell About Gnome
					(gEgo get: 31) ; theHumorbar
					(SetFlag 180)
				)
				(72 ; Ask about Ritual
					(SetFlag 396)
					(gEgo get: 54) ; theBreathRit
				)
				(74 ; Ask for Dark One Ritual
					(SetFlag 396)
					(gEgo get: 54) ; theBreathRit
				)
			)
		)
		(super sayMessage: &rest)
	)

	(method (respond)
		(cond
			(local3
				(self clean:)
				(if (IsFlag 179)
					(gCurRoom setScript: sEventBye 0 26)
				else
					(gCurRoom setScript: sWarningDeath)
				)
			)
			(local4
				(self clean:)
				(gCurRoom setScript: sEventBye 0 33)
			)
			(else
				(super respond: &rest)
				(return 1)
			)
		)
	)
)

(instance babaTeller of Teller
	(properties
		title 1
		loopMenu 0
	)

	(method (init)
		(super init: &rest)
		(= talker babaTalker)
	)

	(method (doVerb theVerb)
		(cond
			((and (== local2 3) (OneOf theVerb 27 47 40 26)) ; theBonemeal, theBones, theGarlic, theGruegoo
				(gCurRoom setScript: sGiveFood 0 theVerb)
				(return 1)
			)
			((and (== local2 3) (> theVerb 13)) ; theBag
				(switch (- (++ local5) 1)
					(0
						(gMessager say: 2 6 30) ; "That is not something we consider edible. Feed us or weep."
					)
					(1
						(gMessager say: 2 6 31) ; "I'm getting hungrier, and you aren't giving me anything good to eat yet, O Soon-to-be-Supper."
					)
					(2
						(gCurRoom setScript: sWarningDeath)
					)
				)
			)
			(else
				(switch theVerb
					(46 ; thePiepan
						(if (& ((gInventory at: 28) maskCel:) $0008) ; thePiepan
							(gCurRoom setScript: sGivePie)
							(return 1)
						else
							(gMessager say: 2 46 73) ; "I'm looking for a pie, not a pie pan. Come back when it's done."
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)

	(method (sayMessage)
		(= local1 1)
		(super sayMessage: &rest)
	)
)

(instance baba of Prop
	(properties
		noun 2
		x 211
		y 132
		view 495
		signal 16385
	)

	(method (init)
		(self setPri: 160)
		(super init: &rest)
	)
)

(instance babaHead of Prop
	(properties
		view 495
		loop 4
		signal 16385
	)

	(method (doVerb theVerb)
		(baba doVerb: theVerb)
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors:
			setPri: (+ (baba priority:) 1)
			x: (baba x:)
			y: (baba y:)
			z: 0
		)
	)
)

(instance spider of Prop
	(properties
		noun 32
		x 118
		y 15
		view 492
		signal 16385
	)

	(method (init)
		(self setPri: 180)
		(super init: &rest)
	)
)

(instance theBucket of Prop
	(properties
		x 66
		y 95
		z 60
		view 490
		loop 11
		signal 16385
	)
)

(instance theBat of Prop
	(properties
		noun 31
		x 291
		y 41
		view 492
		loop 2
		signal 16384
	)
)

(instance thePie of View
	(properties
		noun 33
		x 72
		y 137
		z 1
		view 491
		loop 1
		signal 16384
	)
)

(instance candle1 of Prop
	(properties
		x 37
		y 128
		view 490
		cel 7
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles doVerb: theVerb)
	)
)

(instance candle2 of Prop
	(properties
		x 34
		y 130
		view 490
		loop 2
		cel 3
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles doVerb: theVerb)
	)
)

(instance candle3 of Prop
	(properties
		x 26
		y 131
		view 490
		loop 3
		cel 5
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles doVerb: theVerb)
	)
)

(instance candle4 of Prop
	(properties
		x 194
		y 90
		priority 13
		fixPriority 1
		view 490
		loop 8
		cel 5
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles2 doVerb: theVerb)
	)
)

(instance candle5 of Prop
	(properties
		x 226
		y 59
		view 490
		loop 10
		cel 9
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles3 doVerb: theVerb)
	)
)

(instance candle6 of Prop
	(properties
		x 247
		y 55
		view 490
		loop 12
		cel 7
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles3 doVerb: theVerb)
	)
)

(instance candle7 of Prop
	(properties
		x 283
		y 41
		view 490
		loop 13
		cel 7
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(candles3 doVerb: theVerb)
	)
)

(instance theBall of Prop
	(properties
		x 58
		y 134
		view 490
		loop 1
		cel 6
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(crystalBall doVerb: theVerb)
	)
)

(instance fireplace of Prop
	(properties
		x 245
		y 127
		view 490
		loop 4
		cel 5
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fFirePlace doVerb: theVerb)
	)
)

(instance theFire of Prop
	(properties
		x 292
		y 135
		view 490
		loop 6
		cel 6
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(fFirePlace doVerb: theVerb)
	)
)

(instance bubbles of Prop
	(properties
		x 291
		y 106
		view 490
		loop 9
		signal 16385
		detailLevel 2
	)

	(method (doVerb theVerb)
		(cauldron doVerb: theVerb)
	)
)

(instance babaTalker of GloryTalker
	(properties
		x 0
		y 16
		talkWidth 130
		view 496
		textX 160
		textY 10
	)

	(method (init)
		(super init: babaMouth 0 babaEyes babaFrame &rest)
	)
)

(instance babaFrame of View
	(properties
		y 16
		view 496
	)
)

(instance babaMouth of Prop
	(properties
		x 23
		y 63
		view 496
		loop 1
	)
)

(instance babaEyes of Prop
	(properties
		x 22
		y 56
		view 496
		loop 2
	)
)

(instance gloryHand of Feature
	(properties
		noun 10
		nsLeft 28
		nsTop 135
		nsRight 45
		nsBottom 147
		sightAngle 180
		x 36
		y 141
	)
)

(instance crystalBall of Feature
	(properties
		noun 11
		nsLeft 44
		nsTop 121
		nsRight 61
		nsBottom 136
		sightAngle 180
		x 52
		y 137
	)
)

(instance candles of Feature
	(properties
		noun 12
		nsLeft 24
		nsTop 116
		nsRight 44
		nsBottom 135
		sightAngle 180
		x 34
		y 137
	)
)

(instance tableFoot of Feature
	(properties
		noun 13
		nsLeft 42
		nsTop 146
		nsRight 74
		nsBottom 170
		sightAngle 180
		x 58
		y 158
	)
)

(instance table of Feature
	(properties
		noun 14
		nsLeft 24
		nsTop 126
		nsRight 95
		nsBottom 147
		sightAngle 180
		x 59
		y 136
	)
)

(instance doorSkull of Feature
	(properties
		noun 15
		nsLeft 70
		nsTop 75
		nsRight 86
		nsBottom 95
		sightAngle 180
		x 78
		y 91
	)
)

(instance demonSkull of Feature
	(properties
		noun 16
		nsLeft 57
		nsTop 31
		nsRight 92
		nsBottom 65
		sightAngle 180
		x 74
		y 48
	)
)

(instance bucket of Feature
	(properties
		noun 17
		nsLeft 54
		nsTop 12
		nsRight 82
		nsBottom 31
		sightAngle 180
		x 68
		y 21
	)

	(method (doVerb theVerb)
		(theBucket doVerb: theVerb)
	)
)

(instance skeleton of Feature
	(properties
		noun 18
		nsTop 145
		nsRight 129
		nsBottom 189
		sightAngle 180
		x 64
		y 157
	)
)

(instance backScratcher of Feature
	(properties
		noun 19
		nsLeft 127
		nsTop 122
		nsRight 145
		nsBottom 127
		sightAngle 180
		x 136
		y 124
	)
)

(instance theDoor of Feature
	(properties
		noun 20
		nsLeft 48
		nsTop 60
		nsRight 98
		nsBottom 120
		sightAngle 180
		x 73
		y 90
	)
)

(instance candles2 of Feature
	(properties
		noun 12
		nsLeft 185
		nsTop 75
		nsRight 203
		nsBottom 91
		sightAngle 180
		x 194
		y 83
	)
)

(instance candles3 of Feature
	(properties
		noun 12
		nsLeft 225
		nsTop 40
		nsRight 301
		nsBottom 53
		sightAngle 180
		x 263
		y 46
	)
)

(instance cauldron of Feature
	(properties
		noun 21
		nsLeft 265
		nsTop 90
		nsRight 300
		nsBottom 128
		sightAngle 180
		x 282
		y 109
	)
)

(instance fFirePlace of Feature
	(properties
		noun 22
		nsLeft 250
		nsTop 77
		nsRight 303
		nsBottom 134
		sightAngle 180
		x 276
		y 105
	)
)

(instance bottle of Feature
	(properties
		noun 23
		nsLeft 235
		nsTop 138
		nsRight 254
		nsBottom 180
		sightAngle 180
		x 244
		y 175
	)
)

(instance humanSkull of Feature
	(properties
		noun 24
		nsLeft 267
		nsTop 132
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 293
		y 160
	)
)

(instance cobwebs of Feature
	(properties
		noun 25
		nsLeft 192
		nsTop 160
		nsRight 268
		nsBottom 189
		sightAngle 180
		x 230
		y 174
	)
)

(instance topShelf of Feature
	(properties
		noun 26
		nsLeft 114
		nsTop 54
		nsRight 146
		nsBottom 72
		sightAngle 180
		x 130
		y 63
	)
)

(instance bookShelf of Feature
	(properties
		noun 27
		nsLeft 113
		nsTop 71
		nsRight 145
		nsBottom 85
		sightAngle 180
		x 129
		y 78
	)
)

(instance jarShelf of Feature
	(properties
		noun 28
		nsLeft 113
		nsTop 85
		nsRight 146
		nsBottom 97
		sightAngle 180
		x 129
		y 91
	)
)

(instance belowShelf of Feature
	(properties
		noun 29
		nsLeft 112
		nsTop 97
		nsRight 147
		nsBottom 117
		sightAngle 180
		x 129
		y 107
	)
)

(instance boneNecklace of Feature
	(properties
		noun 30
		nsTop 77
		nsRight 42
		nsBottom 138
		sightAngle 180
		x 21
		y 107
	)
)

(instance soundFX of Sound
	(properties)
)

