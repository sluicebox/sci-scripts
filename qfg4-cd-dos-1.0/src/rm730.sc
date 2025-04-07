;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use GloryTalker)
(use Scaler)
(use Feature)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm730 0
	eranaTalker 1
	avis 2
	katrina 3
	pSpark 4
	fireBall 5
	midBlast 6
	leftBlast 7
	rightBlast 8
	crystal 9
	sTimeItOut 10
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
)

(instance rm730 of GloryRm
	(properties
		picture 730
	)

	(method (init)
		(ClearFlag 6)
		(ClearFlag 373)
		(super init:)
		(gLongSong number: 203 loop: -1 play:)
		(crystal init: setPri: 64)
		(katrina init:)
		(avis init: signal: (| (avis signal:) $0001))
		(midBlast hide:)
		(leftBlast hide:)
		(rightBlast hide:)
		(gEgo
			view: 7
			cel: 0
			x: 170
			y: 140
			init:
			setScaler: Scaler 92 89 157 74
		)
		(gGlory handsOn:)
		(gTheIconBar disable: 0)
		(fNode1 init:)
		(fNode2 init:)
		(fNode3 init:)
		(fNode4 init:)
		(fNode5 init:)
		(fNode6 init:)
		(fNode7 init:)
		(adavisTeller init: avis 730 9 160 7)
		(heroTeller init: gEgo 730 9 128 7)
		(self setScript: (ScriptID 731 0)) ; enterScr
		(gGlory save: 1)
	)

	(method (cue)
		(switch local1
			(9
				(if local2
					(gCurRoom setScript: sDoTheEndGame)
				else
					(gCurRoom setScript: sSummon)
				)
			)
			(4
				(gMessager say: 0 86 0 0) ; "Your spell disappears into the distance having had no useful effect."
			)
			(5
				(gMessager say: 0 88 0 0) ; "Your spell disappears into the distance having had no useful effect."
			)
			(6
				(gMessager say: 0 79 0 0) ; "Your spell disappears into the distance having had no useful effect."
			)
			(8
				(gMessager say: 0 93 0 0) ; "Your spell disappears into the distance having had no useful effect."
			)
		)
		(= local1 0)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		(SetFlag 373)
		(DisposeScript 731)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(IsFlag 360)
				(not (gCurRoom script:))
				(not local5)
				(!= gHeroType 1) ; Magic User
			)
			(= local5 1)
			(gCurRoom setScript: sDoTheStaff)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Jump
				(gMessager say: 0 159 0 0) ; "You can't jump to that point."
				(return 1)
			)
			(60 ; theWillowisp
				(gMessager say: 0 60 0 0) ; "The tiny creature cringes in its flask. It will have nothing to do with this place!"
				(return 1)
			)
			(85 ; calmSpell
				(gEgo trySkill: 25) ; calmSpell
				(if local2
					(gMessager say: 0 85 0 0) ; "The magic in this place is too powerful and frenzied for your Calm spell to work."
				else
					(gMessager say: 0 85 36) ; "You think I haven't arranged protections against all of your spells? I know what puny magics the Wizards teach such as you!"
				)
				(return 1)
			)
			(56 ; theAmulet
				(if local2
					(gMessager say: 0 56 0) ; "The amulet offers you no protection against the power of the Dark One."
				else
					(gMessager say: 0 56 36) ; "You hope the Amulet will be of some help against the Vampire Ad Avis, but you recall that it only helps against life-draining attacks. It won't stop his spells."
				)
				(return 1)
			)
			(83 ; dazzleSpell
				(gEgo trySkill: 23) ; dazzleSpell
				(= local1 2)
				(if local2
					(gMessager say: 0 83 0) ; "There is nothing here for you to Dazzle."
				else
					(gMessager say: 0 83 36) ; "You think I haven't arranged protections against all of your spells? I know what puny magics the Wizards teach such as you!"
				)
				(return 1)
			)
			(81 ; detectMagicSpell
				(gEgo trySkill: 21) ; detectSpell
				(if local2
					(gMessager say: 0 81 0 0) ; "The cave pulses with magic both good and bad. The good magic seems to emanate from the crystal. It seems as if the image of Erana fills your mind. A dark, chaotic magic fills the black void around you."
				else
					(gMessager say: 0 81 36) ; "The entire cave is suffused with magic. The chaotic magic of the Dark One is stronger here than anywhere else in the cave, but you also sense Erana's gentle, healing magic and the lustful, greedy power of Ad Avis. The magic is strongest around the glowing crystal."
				)
				(return 1)
			)
			(86 ; flameDartSpell
				(gEgo trySkill: 26) ; flameDartSpell
				(= local1 4)
				(self setScript: (ScriptID 32) self 86) ; project
			)
			(88 ; forceBoltSpell
				(gEgo trySkill: 28) ; forceSpell
				(= local1 5)
				(self setScript: (ScriptID 32) self 88) ; project
			)
			(79 ; frostSpell
				(gEgo trySkill: 34) ; frostSpell
				(= local1 6)
				(self setScript: (ScriptID 32) self 79) ; project
			)
			(95 ; invisibleSpell
				(= local1 7)
				(if local2
					(gMessager say: 0 95 0 0) ; "You can't Hide from the Dark One for long!"
				else
					(gMessager say: 0 95 36) ; "You can Hide, but you cannot run! I know where you are, and I also know that you can't move while that spell is active. I fancy a little duck shoot now."
				)
				(return 1)
			)
			(93 ; lightningBallSpell
				(gEgo trySkill: 33) ; lightningSpell
				(= local1 8)
				(self setScript: (ScriptID 32) self 93) ; project
			)
			(7 ; ???
				(gMessager say: 0 7 0) ; MISSING MESSAGE
				(return 1)
			)
			(33 ; theGrapnel
				(gEgo trySkill: 10) ; throwing
				(cond
					(local2
						(super doVerb: theVerb)
					)
					(local4
						(gMessager say: 5 33 39) ; "You don't have time to do that; Ad Avis might stop laughing at any moment!"
					)
					(else
						(self setScript: sBurnUpGrapnel)
					)
				)
			)
			(92 ; summonStaffSpell
				(if (== (gEgo view:) 20)
					(gMessager say: 0 92 38) ; "You've already summoned the staff."
					(return 1)
				else
					(= local1 9)
					(self setScript: (ScriptID 46) self) ; staffScript
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sSummon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= [gEgoStats 17] (gEgo maxHealth:)) ; health
				(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 19] (gEgo maxMana:)) ; mana
				(if (or local4 local8)
					(self cue:)
				else
					(= local8 1)
					(gMessager say: 5 6 30 0 self) ; "So you have Erana's Staff. It will do you no good. I am protected against any magic you can wield against me even with the staff."
				)
			)
			(1
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sMessages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 60)
			)
			(1
				(if local4
					(gMessager say: 6 6 9 0 self) ; "Ad Avis may be helpless at the moment, but that doesn't mean his protective spells aren't working. You'll need to find a more powerful attack to do him any serious damage."
				else
					(= ticks 1)
				)
			)
			(2
				(if (== local1 0)
					(gMessager say: 5 6 5 0 self) ; "You think I haven't arranged protections against all of your spells? I know what puny magics the Wizards teach such as you!"
				else
					(gMessager say: 5 6 10 0 self) ; "Ha! There are advantages to being a Vampire. Those puny mundane weapons can do nothing to me!"
				)
			)
			(3
				(self setScript: sCastASpell)
			)
		)
	)
)

(instance sCastASpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				((= local0 (fireBall new:))
					view: 747
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(2
				(local0 setCycle: End self)
			)
			(3
				(local0 dispose:)
				(cond
					((and (> (gEgo view:) 17) (< (gEgo view:) 21))
						(gEgo takeDamage: 23)
					)
					((> global454 0)
						(gEgo
							takeDamage: (- 50 (/ (* [gEgoStats 26] 15) 100)) ; flameDartSpell
						)
					)
					(else
						(gEgo takeDamage: 50)
					)
				)
				(if (== [gEgoStats 17] 0) ; health
					(self setScript: sEgoDies)
				else
					(self cue:)
				)
			)
			(4
				(proc0_17 5 6 13 sCastASpell 730)
			)
			(5
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEgoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local10 1)
				(gLongSong number: 106 loop: -1 play:)
				(avis setLoop: 0 1 setCel: 0)
				(gEgo
					view: 743
					setLoop: 0 1
					setCel: 0
					x: (+ (gEgo x:) 2)
					y: (- (gEgo y:) 1)
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo
					posn: 146 162
					setCel: 5
					moveSpeed: 0
					setMotion: MoveTo 146 162 self
				)
			)
			(2
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance sAdavisDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gGlory handsOff:)
				(= local2 1)
				(heroTeller dispose:)
				(avis setScript: 0)
				(avis view: 748 setLoop: 0 1 setCel: 0 posn: 91 141)
				(self cue:)
			)
			(2
				(avis setCel: 0 setCycle: CT 2 1 self)
			)
			(3
				(avis setCel: 3 posn: 100 139)
				(self cue:)
			)
			(4
				(avis setCel: 4 posn: 105 139 setCycle: CT 8 1 self)
			)
			(5
				(avis setLoop: 1 1 setCel: 0 posn: 106 137 setCycle: End self)
			)
			(6
				(avis dispose:)
				(gLongSong number: 107 loop: 1 play: self)
			)
			(7
				(if (IsFlag 360)
					(gMessager say: 6 6 16 0) ; "A voice forms in the air around you, seemingly coming from your glowing staff: "It is time for you to fulfill my final destiny. You must use me to release my mistress from her imprisonment!""
				)
				(gLongSong number: 440 loop: -1 play:)
				(crystal signal: (| (crystal signal:) $0001) setCycle: Fwd)
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sBurnUpGrapnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local11 (gEgo view:))
				(= local12 (gEgo loop:))
				(gEgo view: 8 setLoop: 1 1 setCel: 0 setCycle: 0)
				(= ticks 30)
			)
			(1
				(avis view: 677 setLoop: 0 1 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				((= local0 (fireBall new:))
					view: 747
					setLoop: 1 1
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(3
				(local0 setCycle: End self)
			)
			(4
				(local0 dispose:)
				(gEgo
					use: 16 ; theGrapnel
					normalize:
					setCycle: 0
					view: local11
					loop: local12
				)
				(= ticks 6)
			)
			(5
				(gMessager say: 6 6 11 0 self) ; "Ad Avis's spell burned the rope completely off your grapnel. You'll need to find a way to stop his spells before you will have any chance of defeating Ad Avis."
			)
			(6
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sTimeItOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global439
					(1
						(= ticks 2400)
					)
					(2
						(= ticks 1800)
					)
					(3
						(= ticks 1200)
					)
				)
			)
			(1
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(2
				((= local0 (fireBall new:))
					view: 747
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(3
				(local0 setCycle: End self)
			)
			(4
				(local0 dispose:)
				(self setScript: sEgoDies)
			)
		)
	)
)

(instance sUltimateJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 9 128 20 0 self) ; "You tell the Ultimate Joke about the Wizard and the farmer's daughter."
			)
			(1
				(gMessager say: 5 6 12 0 self) ; "You think to delay your demise by telling stupid jokes? That wasn't even funny!"
			)
			(2
				(avis view: 733 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(3
				(avis setLoop: 1 1 setCycle: Fwd)
				(switch global439
					(1
						(= seconds 55)
					)
					(2
						(= seconds 45)
					)
					(3
						(= seconds 30)
					)
				)
			)
			(4
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(5
				((= local0 (fireBall new:))
					view: 747
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(6
				(local0 setCycle: End self)
			)
			(7
				(local0 dispose:)
				(self setScript: sEgoDies)
			)
		)
	)
)

(instance sDoTheStaff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gHeroType
					(0 ; Fighter
						(aStaff init: setPri: 207 setCycle: End self)
					)
					(2 ; Thief
						(aStaff init: setPri: 207 setCycle: End self)
					)
					(3 ; Paladin
						(aStaff init: setPri: 207 setCycle: End self)
					)
				)
			)
			(1
				(switch gHeroType
					(0 ; Fighter
						(aStaff setLoop: 3 1 setCel: 0 setCycle: End self)
					)
					(2 ; Thief
						(aStaff setLoop: 2 1 setCel: 0 setCycle: End self)
					)
					(3 ; Paladin
						(aStaff setLoop: 3 1 setCel: 0 setCycle: End self)
					)
				)
			)
			(2
				(switch gHeroType
					(0 ; Fighter
						(aStaff
							setLoop: 4 1
							setCel: 1
							setCycle: 0
							setMotion: MoveTo 161 83 self
						)
					)
					(2 ; Thief
						(aStaff
							setLoop: 4 1
							setCel: 0
							setCycle: 0
							setMotion: MoveTo 161 76 self
						)
					)
					(3 ; Paladin
						(aStaff
							setLoop: 4 1
							setCel: 1
							setCycle: 0
							setMotion: MoveTo 161 72 self
						)
					)
				)
			)
			(3
				(switch gHeroType
					(0 ; Fighter
						(gEgo view: 10 setLoop: 0 1 setCel: 0 posn: 168 80)
						(= ticks 6)
					)
					(2 ; Thief
						(gMessager say: 6 6 26 0 self) ; "The Staff has changed in your hands into a sharp wooden stake."
					)
					(3 ; Paladin
						(gEgo view: 10 setLoop: 0 1 setCel: 0 posn: 168 80)
						(= ticks 6)
					)
				)
			)
			(4
				(if (not local4)
					(switch gHeroType
						(0 ; Fighter
							(gMessager say: 5 6 14 0 self) ; "Go ahead, throw it! You'll take your one shot, which I shall easily deflect, then I'll finish with you at my leisure."
						)
						(2 ; Thief
							(gMessager say: 5 6 27 0 self) ; "Cute toy, but you'll never get close enough to hurt me with it. My spells will destroy you utterly should you be so foolish as to try."
						)
						(3 ; Paladin
							(gMessager say: 5 6 14 0 self) ; "Go ahead, throw it! You'll take your one shot, which I shall easily deflect, then I'll finish with you at my leisure."
						)
					)
				else
					(self cue:)
				)
			)
			(5
				(gGlory handsOn:)
				(aStaff hide: dispose:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sThrowYourWeapon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(avis setScript: 0)
				(if local4
					(gEgo view: 10 setLoop: 0 1 setCel: 0 setCycle: End self)
				else
					(self setScript: sBadThrow)
				)
			)
			(1
				(gEgo view: 5 setLoop: 5)
				(avis view: 733 setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(2
				(avis setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(3
				(gLongSong number: 107 loop: 1 play: self)
			)
			(4
				(gLongSong number: 440 loop: -1 play:)
				(avis
					view: 745
					setLoop: 3 1
					setCel: 5
					posn: 66 146
					setCycle: Beg self
				)
			)
			(5
				(avis
					setLoop: 1 1
					setCel: 2
					setCycle: 0
					ignoreActors: 1
					setMotion: MoveTo 149 72 self
				)
			)
			(6
				(gMessager say: 6 6 16 0 self) ; "A voice forms in the air around you, seemingly coming from your glowing staff: "It is time for you to fulfill my final destiny. You must use me to release my mistress from her imprisonment!""
			)
			(7
				(avis setLoop: 0 1 setCel: 6 setCycle: Beg self)
			)
			(8
				(avis hide: dispose:)
				(= local5 0)
				(= local2 1)
				(heroTeller dispose:)
				(crystal signal: (| (crystal signal:) $0001) setCycle: Fwd)
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
			)
		)
	)
)

(instance sBadThrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 10 setLoop: 0 1 setCel: 0)
				(self cue:)
			)
			(1
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(2
				((= local0 (fireBall new:))
					view: 747
					setLoop: 1 1
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(3
				(local0 setCycle: End self)
			)
			(4
				(local0 dispose:)
				(aSpear
					init:
					setLoop: 1
					moveSpeed: 0
					setMotion: JumpTo 209 189 self
				)
				(gEgo view: 5 setLoop: 5)
			)
			(5
				(aSpear dispose:)
				(gMessager say: 5 6 15 0 self) ; "Is that the best you can do? So sad. Now it's my turn."
			)
			(6
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(7
				((= local0 (fireBall new:))
					view: 747
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 176 60 self
				)
				(avis setCycle: End)
			)
			(8
				(local0 setCycle: End self)
			)
			(9
				(local0 dispose:)
				(self setScript: sEgoDies)
			)
		)
	)
)

(instance sJumpToAdavis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(avis setScript: 0)
				(if local4
					(gEgo trySkill: 15) ; acrobatics
					(= local7 1)
					(= local6 (gEgo cycleSpeed:))
					(= seconds 1)
				else
					(gCurRoom setScript: sJumpDeath)
				)
			)
			(1
				(avis view: 737 setLoop: 1 1 y: 145 setCel: 0 setCycle: End)
				(gEgo
					view: 30
					setLoop: 3 1
					setCel: 0
					setSpeed: 6
					setCycle: CT 6 1
					setMotion: JumpTo 125 120 self
				)
			)
			(2
				(avis
					view: 734
					setLoop: 0 1
					setCel: 0
					setPri: 180
					posn: 87 150
					setCycle: CT 2 1 self
				)
			)
			(3
				(avis hide:)
				(gEgo
					view: 734
					setLoop: 0 1
					setCel: 2
					setPri: 150
					setCycle: End self
					posn: 87 150
				)
			)
			(4
				(gEgo setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(6
				(gLongSong number: 107 loop: 1 play: self)
			)
			(7
				(gLongSong number: 440 loop: -1 play:)
				(gEgo
					view: 5
					setLoop: 7 1
					setCel: 0
					posn: 81 137
					cycleSpeed: local6
				)
				(avis
					view: 745
					setLoop: 2 1
					setCel: 5
					posn: 66 146
					show:
					setCycle: Beg self
				)
			)
			(8
				(avis
					setLoop: 1 1
					setCel: 2
					setCycle: 0
					ignoreActors: 1
					setMotion: MoveTo 61 119 self
				)
			)
			(9
				(gMessager say: 6 6 16 0 self) ; "A voice forms in the air around you, seemingly coming from your glowing staff: "It is time for you to fulfill my final destiny. You must use me to release my mistress from her imprisonment!""
			)
			(10
				(avis setLoop: 0 1 setCel: 6 setCycle: Beg self)
			)
			(11
				(ClearFlag 360)
				(= local5 0)
				(= local2 1)
				(heroTeller dispose:)
				(avis hide: dispose:)
				(crystal signal: (| (crystal signal:) $0001) setCycle: Fwd)
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sJumpBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local7 0)
				(gEgo trySkill: 15) ; acrobatics
				(gEgo
					view: 30
					setLoop: 2 1
					setCel: 0
					setSpeed: 6
					setCycle: CT 8 1
					setMotion: JumpTo 170 80 self
				)
			)
			(1
				(gEgo view: 5 setLoop: 2 1 setCel: 0)
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sJumpDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(avis view: 677 setLoop: 0 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				((= local0 (fireBall new:))
					view: 747
					x: 91
					y: 101
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 124 77 self
				)
				(avis setCycle: End)
			)
			(2
				(gLongSong number: 106 loop: -1 play:)
				(gEgo view: 749 setLoop: 0 1 setCel: 0 posn: 126 84)
				(local0 setCycle: Fwd)
				(= ticks 12)
			)
			(3
				(gEgo setCel: 2)
				(= ticks 12)
			)
			(4
				(gEgo setCel: 1)
				(= ticks 12)
			)
			(5
				(gEgo setCel: 3)
				(= ticks 12)
			)
			(6
				(local0 dispose:)
				(gEgo dispose:)
				(= ticks 12)
			)
			(7
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance sDoTheEndGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if local7
					(self setScript: sJumpBack self)
				else
					(self cue:)
				)
			)
			(1
				(gGlory handsOff:)
				(gMessager say: 1 157 16 0 self) ; "You touch the Staff of Erana to the crystal."
			)
			(2
				(gEgo
					view: 746
					setLoop: 0 1
					setCel: 0
					posn: 164 81
					setCycle: End self
				)
			)
			(3
				(gLongSong number: 108 setLoop: -1 play:)
				(gLongSong2 number: 971 loop: 1 play: self)
			)
			(4
				(crystal
					view: 735
					setLoop: 0 1
					setCel: 0
					posn: 124 91
					setCycle: End self
				)
			)
			(5
				(switch gHeroType
					(0 ; Fighter
						(gMessager say: 8 6 33 0 self) ; "Thank you. You have freed me from my long imprisonment and this land from its own danger."
					)
					(1 ; Magic User
						(gMessager say: 8 6 34 0 self) ; "You have freed me from my imprisonment by the Dark One. I have driven Avoozl back to its own dimension forever."
					)
					(2 ; Thief
						(gMessager say: 8 6 33 0 self) ; "Thank you. You have freed me from my long imprisonment and this land from its own danger."
					)
					(3 ; Paladin
						(gMessager say: 8 6 35 0 self) ; "You walk in honor and righteousness. This day you have freed the Land of Mordavia from great evil. May you always hold high the way of the Paladin."
					)
				)
			)
			(6
				(crystal setLoop: 1 1 setCel: 0 setCycle: Fwd)
				(= ticks 80)
			)
			(7
				(crystal setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(8
				(crystal setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(9
				(gEgo solvePuzzle: 464 50)
				(gCurRoom newRoom: 635)
			)
		)
	)
)

(instance avis of TargActor
	(properties
		noun 5
		x 73
		y 141
		view 737
	)

	(method (getHurt)
		(if (and (not local10) (not local2))
			(cond
				(
					(and
						local4
						(not (gEgo script:))
						(!= local1 0)
						(not
							(and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
					)
					(gCurRoom setScript: sMessages)
				)
				((and local4 (not (gEgo script:)))
					(gEgo view: 5 setLoop: 5 1)
					(gEgo setScript: sAdavisDies)
				)
				(else
					(gCurRoom setScript: sMessages)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(= global441 ((User curEvent:) x:))
		(= global442 ((User curEvent:) y:))
		(switch theVerb
			(33 ; theGrapnel
				(gEgo trySkill: 10) ; throwing
				(if local4
					(gMessager say: 6 6 29) ; "Climbing over to Ad Avis with the rope and grapnel would take too long. You need to find a faster approach."
				else
					(gCurRoom setScript: sBurnUpGrapnel)
				)
			)
			(21 ; theRocks
				(gEgo trySkill: 10) ; throwing
				(= local1 0)
				(gEgo use: 6) ; theRocks
				(gCurRoom setScript: (ScriptID 32) 0 21) ; project
			)
			(37 ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 6 6 40) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(gEgo trySkill: 10) ; throwing
					(gEgo use: 5) ; theThrowdagger
					(= local1 0)
					(gCurRoom setScript: (ScriptID 32) 0 37) ; project
				)
			)
			(86 ; flameDartSpell
				(gEgo trySkill: 26) ; flameDartSpell
				(= local1 4)
				(gCurRoom setScript: (ScriptID 32) 0 86) ; project
			)
			(88 ; forceBoltSpell
				(gEgo trySkill: 28) ; forceSpell
				(= local1 5)
				(gCurRoom setScript: (ScriptID 32) 0 88) ; project
			)
			(93 ; lightningBallSpell
				(gEgo trySkill: 33) ; lightningSpell
				(= local1 8)
				(gCurRoom setScript: (ScriptID 32) 0 93) ; project
			)
			(79 ; frostSpell
				(gEgo trySkill: 34) ; frostSpell
				(= local1 6)
				(gCurRoom setScript: (ScriptID 32) 0 79) ; project
			)
			(157 ; theStaff
				(if (OneOf gHeroType 0 3) ; Fighter, Paladin
					(gCurRoom setScript: sThrowYourWeapon)
				else
					(gMessager say: 5 170 28) ; "This is a closeup weapon -- it isn't balanced for throwing. You'll need to get closer to Ad Avis to use it."
				)
			)
			(10 ; Jump
				(if (== gHeroType 2) ; Thief
					(if local5
						(gCurRoom setScript: sJumpToAdavis)
					else
						(gMessager say: 5 159 17) ; "You can get to Ad Avis that way, but you'll need to have the right weapon in hand and strike quickly or his protective spells will surely destroy you."
					)
				else
					(gMessager say: 0 159 0 0) ; "You can't jump to that point."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fireBall of Actor
	(properties
		priority 207
		fixPriority 1
		view 26
		loop 1
		yStep 15
		signal 16385
		xStep 15
		moveSpeed 0
	)
)

(instance katrina of Actor
	(properties
		noun 4
		x 231
		y 100
		priority 108
		fixPriority 1
		view 742
		loop 1
		signal 16385
	)
)

(instance aStaff of Actor
	(properties
		x 169
		y 38
		view 745
		signal 16385
		moveSpeed 0
	)
)

(instance aSpear of Actor
	(properties
		x 175
		y 94
		view 10
		loop 1
	)
)

(instance pSpark of Prop
	(properties
		view 732
		signal 16385
	)
)

(instance midBlast of Prop
	(properties
		noun 2
		x 172
		y 87
		view 730
		signal 16385
	)
)

(instance rightBlast of Prop
	(properties
		noun 2
		x 242
		y 101
		view 730
		loop 1
		signal 16385
	)
)

(instance leftBlast of Prop
	(properties
		noun 2
		x 94
		y 139
		view 730
		loop 2
		signal 16385
	)
)

(instance crystal of Prop
	(properties
		noun 1
		x 128
		y 53
		priority 97
		fixPriority 1
		view 731
		signal 16384
	)

	(method (cue)
		(gMessager say: 1 86 0 0) ; "The crystal is totally unaffected by your spell."
	)

	(method (doVerb theVerb)
		(if local2
			(= global441 ((User curEvent:) x:))
			(= global442 ((User curEvent:) y:))
			(switch theVerb
				(10 ; Jump
					(gMessager say: 1 159 0 0) ; "You could reach the crystal, but then you'd fall into the void."
				)
				(37 ; theThrowdagger
					(if (== (gEgo has: 5) 1) ; theThrowdagger
						(gMessager say: 6 6 40) ; "You are down to your last dagger. You'd better hold on to it."
					else
						(gMessager say: 1 37 0 0) ; "It will take more than that to shatter the magical crystal!"
					)
				)
				(21 ; theRocks
					(gMessager say: 1 37 0 0) ; "It will take more than that to shatter the magical crystal!"
				)
				(86 ; flameDartSpell
					(self setScript: (ScriptID 32) crystal 86) ; project
				)
				(88 ; forceBoltSpell
					(self setScript: (ScriptID 32) crystal 88) ; project
				)
				(79 ; frostSpell
					(self setScript: (ScriptID 32) crystal 79) ; project
				)
				(33 ; theGrapnel
					(gMessager say: 1 33 0 0) ; "You could reach the crystal, but then you'd fall into the void."
				)
				(93 ; lightningBallSpell
					(self setScript: (ScriptID 32) crystal 93) ; project
				)
				(36 ; theSword
					(gMessager say: 1 36 0 0) ; "You can reach the crystal with your sword, but nothing happens when you touch it. You need to try something more closely attuned."
				)
				(157 ; theStaff
					(gCurRoom setScript: sDoTheEndGame)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(gMessager say: 1 157 0 0) ; "You don't have time to deal with the crystal right now -- Ad Avis is trying to kill you!"
		)
	)
)

(instance fNode1 of Feature
	(properties
		noun 2
		nsLeft 7
		nsTop 53
		nsRight 76
		nsBottom 96
		sightAngle 180
		x 41
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(4 ; Do
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance fNode2 of Feature
	(properties
		noun 2
		nsLeft 47
		nsTop 136
		nsRight 109
		nsBottom 168
		sightAngle 180
		x 78
		y 136
	)

	(method (doVerb theVerb)
		(fNode1 doVerb: theVerb)
	)
)

(instance fNode3 of Feature
	(properties
		noun 2
		nsLeft 88
		nsTop 114
		nsRight 144
		nsBottom 155
		sightAngle 180
		x 116
		y 134
	)

	(method (doVerb theVerb)
		(fNode1 doVerb: theVerb)
	)
)

(instance fNode4 of Feature
	(properties
		noun 2
		nsLeft 142
		nsTop 71
		nsRight 202
		nsBottom 105
		sightAngle 180
		x 172
		y 88
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Jump
			(if (and local2 local7)
				(gCurRoom setScript: sJumpBack)
			else
				(gMessager say: 0 159 0 0) ; "You can't jump to that point."
			)
		else
			(fNode1 doVerb: theVerb)
		)
	)
)

(instance fNode5 of Feature
	(properties
		noun 2
		nsLeft 153
		nsTop 146
		nsRight 211
		nsBottom 189
		sightAngle 180
		x 182
		y 146
	)

	(method (doVerb theVerb)
		(fNode1 doVerb: theVerb)
	)
)

(instance fNode6 of Feature
	(properties
		noun 2
		nsLeft 208
		nsTop 97
		nsRight 266
		nsBottom 128
		sightAngle 180
		x 237
		y 112
	)

	(method (doVerb theVerb)
		(fNode1 doVerb: theVerb)
	)
)

(instance fNode7 of Feature
	(properties
		noun 2
		nsLeft 259
		nsTop 22
		nsRight 303
		nsBottom 61
		sightAngle 180
		x 281
		y 41
	)

	(method (doVerb theVerb)
		(fNode1 doVerb: theVerb)
	)
)

(instance adavisTeller of Teller
	(properties
		title 1
		actionVerb 2
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 74 0)) ; avisTalker
	)
)

(instance heroTeller of Teller
	(properties
		actionVerb 2
	)

	(method (showCases)
		(super showCases: 20 (not local4)) ; Tell Ultimate Joke
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(gEgo view: 5 setLoop: 5 1)
		)
		(return 1)
	)

	(method (sayMessage)
		(if (== iconValue 20) ; Tell Ultimate Joke
			(self clean:)
			(= local4 1)
			(avis setScript: sUltimateJoke)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance eranaTalker of GloryTalker
	(properties
		x 0
		y 5
		talkWidth 150
		view 736
		textX 140
		textY 15
	)

	(method (init)
		(super init: eranaMouth 0 eranaEyes eranaFrame &rest)
		(eranaExtra init: cycleSpeed: 12 setCycle: Fwd)
		(star1 init: cycleSpeed: 12 setCycle: Fwd)
		(star2 init: cycleSpeed: 12 setCycle: Fwd)
		(star3 init: cycleSpeed: 12 setCycle: Fwd)
		(star4 init: cycleSpeed: 12 setCycle: Fwd)
		(star5 init: cycleSpeed: 12 setCycle: Fwd)
		(star6 init: cycleSpeed: 12 setCycle: Fwd)
		(star7 init: cycleSpeed: 12 setCycle: Fwd)
	)

	(method (hide)
		(eranaExtra hide:)
		(star1 hide:)
		(star2 hide:)
		(star3 hide:)
		(star4 hide:)
		(star5 hide:)
		(star6 hide:)
		(star7 hide:)
		(super hide:)
	)

	(method (showAgain)
		(eranaExtra show:)
		(star1 show:)
		(star2 show:)
		(star3 show:)
		(star4 show:)
		(star5 show:)
		(star6 show:)
		(star7 show:)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(eranaExtra dispose:)
			(star1 dispose:)
			(star2 dispose:)
			(star3 dispose:)
			(star4 dispose:)
			(star5 dispose:)
			(star6 dispose:)
			(star7 dispose:)
		)
		(super dispose: param1)
	)
)

(instance eranaFrame of View
	(properties
		y 5
		view 736
	)
)

(instance eranaMouth of Prop
	(properties
		x 46
		y 70
		view 736
		loop 1
	)
)

(instance eranaEyes of Prop
	(properties
		x 46
		y 48
		view 736
		loop 2
	)
)

(instance eranaExtra of Prop
	(properties
		x 45
		y 103
		view 736
		loop 3
	)
)

(instance star1 of Prop
	(properties
		x 160
		y 100
		view 736
		loop 4
	)
)

(instance star2 of Prop
	(properties
		x 104
		y 9
		view 736
		loop 5
	)
)

(instance star3 of Prop
	(properties
		x 8
		y 8
		view 736
		loop 6
	)
)

(instance star4 of Prop
	(properties
		y 93
		view 736
		loop 7
	)
)

(instance star5 of Prop
	(properties
		x 145
		y 38
		view 736
		loop 7
	)
)

(instance star6 of Prop
	(properties
		x 16
		y 51
		view 736
		loop 7
	)
)

(instance star7 of Prop
	(properties
		x 133
		y 3
		view 736
		loop 7
	)
)

