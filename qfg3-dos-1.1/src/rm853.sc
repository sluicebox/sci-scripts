;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 853)
(include sci.sh)
(use Main)
(use n026)
(use OccasionalCycle)
(use Scaler)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm853 0
	mageEndScript 1
	deMageBattle 2
	deWizRecoils 3
)

(local
	local0
)

(instance rm853 of Rm
	(properties
		modNum 850
		noun 18
		picture 850
	)

	(method (init)
		(super init:)
		(self setRegions: 850) ; endGame
		(if (== gPrevRoomNum 550) ; combatRm
			(= local0 1)
			(SetFlag 124)
			(self setScript: fromFracas)
		else
			((ScriptID 850 6) init: stopUpd:) ; deMaster
			(self setScript: mageEndScript)
		)
		(if (not (== global155 0))
			(gGame save: 1)
		)
	)

	(method (doVerb theVerb)
		(if
			(and
				(not (== (mageEndScript state:) 3))
				(== ((ScriptID 850 2) view:) 861) ; deWiz
				(== ((ScriptID 850 2) loop:) 0) ; deWiz
			)
			((ScriptID 850 2) loop: 1 cel: 0 setCycle: End) ; deWiz
		)
		(switch theVerb
			(85 ; reversalSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
				(cond
					((== local0 1)
						(gMessager say: 2 6 65 0 0 850) ; "You have already activated the Reversal spell."
					)
					(
						(and
							(not (== local0 1))
							(not (== (self script:) egoSummon))
							(not (== (self script:) deMageBattle))
						)
						(= local0 1)
						((ScriptID 850 8) dispose:) ; castSpells
						(SetFlag 82)
						(self setScript: deMageBattle)
					)
				)
			)
			(81 ; flameDartSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
				(if (gEgo script:)
					((gEgo script:) setScript: (ScriptID 850 12)) ; blastWiz
				else
					(gEgo setScript: (ScriptID 850 12) 0 theVerb) ; blastWiz
				)
			)
			(83 ; forceBoltSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
				(if (gEgo script:)
					((gEgo script:) setScript: (ScriptID 850 12)) ; blastWiz
				else
					(gEgo setScript: (ScriptID 850 12) 0 theVerb) ; blastWiz
				)
			)
			(88 ; lightningBallSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
				(if (gEgo script:)
					((gEgo script:) setScript: (ScriptID 850 12)) ; blastWiz
				else
					(gEgo setScript: (ScriptID 850 12) 0 theVerb) ; blastWiz
				)
			)
			(84 ; levitateSpell
				(if (== (deMageBattle script:) egoTakesDamage)
					(egoTakesDamage dispose:)
					(deMageBattle setScript: egoLevitates deMageBattle)
				else
					(gMessager say: 2 6 64 0 0 850) ; "That would serve no purpose at this time."
				)
			)
			(87 ; summonStaffSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
				(if (not (== (egoSummon state:) -1))
					(super doVerb: theVerb)
				)
				(if (not (IsFlag 97))
					(mageEndScript dispose:)
					((ScriptID 850 8) dispose:) ; castSpells
					(deMageBattle dispose:)
					(gCurRoom setScript: egoSummon)
				)
			)
			(80 ; calmSpell
				(if (== (deMageBattle script:) egoTakesDamage)
					(sFx3 number: 942 play:)
					(egoTakesDamage dispose:)
					(deMageBattle cue:)
				else
					(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
				)
			)
			(77 ; triggerSpell
				(cond
					((== (deMageBattle state:) 11)
						(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
					)
					((IsFlag 97)
						(gCurRoom setScript: kablooie)
					)
					((== (deMageBattle state:) 17)
						(deMageBattle state: -1)
						((deMageBattle client:) setScript: triggerGarg)
					)
					(else
						(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
					)
				)
			)
			(76 ; detectMagicSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				else
					(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
				)
			)
			(78 ; dazzleSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				else
					(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
				)
			)
			(86 ; jugglingLightsSpell
				(if (== (deMageBattle state:) 11)
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				else
					(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
				)
			)
			(75 ; openSpell
				(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance triggerGarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 15 cel: 0 setCycle: End self)
				(gLongSong2 setLoop: 1 number: 900 play:)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize:)
				(client setScript: fromFracas)
			)
		)
	)
)

(instance deWizRecoils of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 850 2) view: 866 loop: 0 cel: 0 setCycle: End self) ; deWiz
			)
			(1
				((ScriptID 850 2) setCycle: Beg self) ; deWiz
			)
			(2
				((ScriptID 850 2) view: 863) ; deWiz
				(gMessager say: 3 6 46 0 self 850) ; "Augh! Now you have truly earned my wrath!"
			)
			(3
				(if (== (egoSummon state:) 4)
					(egoSummon seconds: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance kablooie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 97)
				(gEgo view: 15 cel: 0 setCycle: End self)
				(gLongSong2 number: 944 setLoop: 1 play:)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize:)
				((ScriptID 850 2) loop: 2 cel: 0 setCycle: End) ; deWiz
				(stick setMotion: MoveTo 183 68)
				(= seconds 3)
			)
			(3
				(stick dispose:)
				((ScriptID 850 17) number: 930 play:) ; sFx
				(kaBoom init: setPri: 14 setCycle: CT 5 1 self)
			)
			(4
				((ScriptID 850 2) dispose:) ; deWiz
				(kaBoom setCycle: End self)
			)
			(5
				(kaBoom
					setLoop: 1
					x: 193
					y: 77
					setScale: Scaler 22 150 96 34
					cycleSpeed: 10
					setCycle: Fwd
					setMotion: JumpTo 67 174 self
				)
			)
			(6
				((ScriptID 850 17) number: 403 play:) ; sFx
				(kaBoom setMotion: JumpTo 44 178 self)
			)
			(7
				((ScriptID 850 17) number: 403 play:) ; sFx
				(kaBoom setCycle: 0)
				(= seconds 3)
			)
			(8
				(gEgo setMotion: MoveTo 22 176 self)
			)
			(9
				(gEgo setLoop: 0 setCycle: CT 3 1 self)
			)
			(10
				((ScriptID 850 17) number: 920 play:) ; sFx
				(kaBoom setMotion: JumpTo 144 189 self)
			)
			(11
				(gEgo solvePuzzle: 340 10 normalize:)
				(kaBoom dispose:)
				(HandsOn)
				((ScriptID 32 0) start: 0) ; project
				(self setScript: portalTimer)
			)
		)
	)
)

(instance portalTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global209
					(1
						(= seconds 180)
					)
					(2
						(= seconds 30)
					)
					(3
						(= seconds 15)
					)
				)
			)
			(1
				(switch global209
					(1
						(= seconds 180)
					)
					(2
						(= seconds 30)
					)
					(3
						(= seconds 20)
					)
				)
			)
			(2
				(HandsOff)
				((ScriptID 850 6) init:) ; deMaster
				(DrawPic 850 9)
				(EgoDead 2 850 857 End) ; "You died fried by a Thermonuclear Blast from the Demon Master. Next time you need to destroy the Orb a bit faster."
			)
		)
	)
)

(instance egoSummon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 124)
				(if (gCast contains: (ScriptID 850 6)) ; deMaster
					(self setScript: deMasterBails self)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(gEgo view: 20 loop: 4 cel: 0 setCycle: End self)
				((ScriptID 850 17) number: 900 play:) ; sFx
			)
			(2
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 3 6 23 0 self 850) ; "You think that worthless piece of wood can harm ME?"
			)
			(4
				(gTheIconBar enable: 6 2 3 8)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 941)
				(gUser canInput: 1)
				(SetFlag 15)
				((ScriptID 32 0) start: 1) ; project
				(= seconds 10)
			)
			(5
				(SetFlag 97)
				(HandsOff)
				((ScriptID 850 2) ; deWiz
					view: 864
					loop: 0
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(6
				((ScriptID 850 17) number: 12 play:) ; sFx
				((ScriptID 850 9) ; zap
					view: 21
					setLoop: 7
					x: 167
					y: 81
					init:
					setCycle: Fwd
					setMotion: JumpTo 23 143 self
				)
			)
			(7
				(gEgo view: 20 loop: 6 cel: 0 setCycle: CT 2 1)
				((ScriptID 850 9) setMotion: MoveTo 17 128) ; zap
				(= seconds 4)
			)
			(8
				(gEgo setLoop: 4 cel: 255 setCycle: Beg)
				(stick init: setLoop: 1 setMotion: JumpTo 183 63)
				((ScriptID 850 9) setMotion: JumpTo 169 81 self) ; zap
			)
			(9
				(gEgo normalize:)
				((ScriptID 850 9) dispose:) ; zap
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(10
				((ScriptID 850 2) loop: 1 cel: 0 setCycle: End self) ; deWiz
			)
			(11
				(gMessager say: 3 6 24 0 self 850) ; "Ha! Now I have your staff. You are defenseless against me!"
			)
			(12
				(gEgo drop: 44) ; theWood
				(gUser canInput: 1)
				(gTheIconBar enable: 3 2 8 6)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 941)
				(= seconds 5)
			)
			(13
				(gMessager say: 3 6 25 0 self 850) ; "Foolish human, you have given me the tool I need. I shall use your magical staff to open the gate."
			)
			(14
				(= seconds 5)
			)
			(15
				(gMessager say: 3 6 14 0 self 850) ; "Come forth, O Lord. By my power and by the forces held in this enchanted staff, I summon thee forth!"
			)
			(16
				(stick dispose:)
				((ScriptID 850 2) ; deWiz
					view: 861
					loop: 1
					cel: 5
					cycleSpeed: 10
					setCycle: Beg self
				)
			)
			(17
				((ScriptID 850 2) ; deWiz
					loop: 2
					setCycle: OccasionalCycle self 1 10 30
				)
				(= seconds 5)
			)
			(18
				((ScriptID 850 2) setCycle: 0) ; deWiz
				((ScriptID 850 6) init:) ; deMaster
				(DrawPic 850 9)
				(= seconds 2)
			)
			(19
				(EgoDead 2 850 857 End) ; "You died fried by a Thermonuclear Blast from the Demon Master. Next time you need to destroy the Orb a bit faster."
			)
		)
	)
)

(instance egoLevitates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 17 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				((ScriptID 850 17) number: 281 play:) ; sFx
				(gEgo
					setCel: 255
					setScale:
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 50) self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(floorFire dispose:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
			(4
				(gEgo setScale: Scaler 92 63 189 130 setCycle: Beg self)
			)
			(5
				(gEgo normalize:)
				(gUser canInput: 1)
				(gTheIconBar enable: 2 4 6 3 8)
				(= state -1)
				(self dispose:)
			)
		)
	)
)

(instance mageEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 4 0 self 850) ; "Our plan worked, Lord! Even now, our enemy Rakeesh is in disgrace and the Liontaur Warriors march out from Tarna. The Simbani idiots and the Leopardmen fools will all avenge their murdered leaders. And they will all blame Rakeesh and each other, not dreaming it is our doing!"
			)
			(2
				(gEgo setMotion: MoveTo 20 183 self)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 1 5)
				(switch global209
					(1
						(= seconds 60)
					)
					(2
						(= seconds 30)
					)
					(3
						(= seconds 20)
					)
				)
			)
			(4
				(if (gCast contains: (ScriptID 850 6)) ; deMaster
					(self setScript: deMasterBails self)
				else
					(self cue:)
				)
			)
			(5
				(gUser canInput: 1)
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(6
				((ScriptID 850 2) loop: 1 setCycle: End self) ; deWiz
			)
			(7
				(gMessager say: 3 6 6 0 self 850) ; "So, you have escaped from my trap. Perhaps destroying you will be more interesting than I thought."
			)
			(8
				(gTheIconBar enable: 3 6 8)
				(gGame setCursor: 941)
				((ScriptID 850 2) setScript: (ScriptID 850 8)) ; deWiz, castSpells
				(self dispose:)
			)
		)
	)
)

(instance deMageBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: (ScriptID 850 6)) ; deMaster
					(self setScript: deMasterBails self)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				((ScriptID 850 2) view: 863 loop: 0 setCycle: CT 6 1 self) ; deWiz
			)
			(2
				(gEgo view: 15 loop: 2 cel: 0 setCycle: End)
				((ScriptID 850 17) number: 943 play:) ; sFx
				((ScriptID 850 9) ; zap
					setLoop: (Random 0 4)
					x: 186
					y: 60
					setStep: 8 7
					cycleSpeed: 0
					moveSpeed: 0
					setScale:
					init:
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 35) self
				)
				((ScriptID 850 2) setCycle: End) ; deWiz
				((ScriptID 850 17) number: 13 play:) ; sFx
			)
			(3
				(gEgo normalize: 6)
				((ScriptID 850 17) number: 10 play:) ; sFx
				((ScriptID 850 9) ; zap
					setMotion:
						MoveTo
						((ScriptID 850 2) x:) ; deWiz
						(- ((ScriptID 850 2) y:) 35) ; deWiz
						self
				)
			)
			(4
				((ScriptID 850 9) loop: 10 setCycle: End self) ; zap
				((ScriptID 850 17) number: 930 play:) ; sFx
			)
			(5
				((ScriptID 850 9) dispose:) ; zap
				((ScriptID 850 2) view: 868 loop: 0 cel: 0 setCycle: End self) ; deWiz
			)
			(6
				((ScriptID 850 2) setCycle: Beg self) ; deWiz
			)
			(7
				((ScriptID 850 2) view: 863 loop: 0 cel: 0) ; deWiz
				(gMessager say: 3 6 16 0 self 850) ; "Floor of flame, enflame this fool!"
			)
			(8
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(9
				((ScriptID 850 2) setCycle: Beg self) ; deWiz
			)
			(10
				(gMessager say: 3 6 17 0 self 850) ; "Eat flaming death, fool!"
			)
			(11
				((ScriptID 850 17) number: 101 play:) ; sFx
				(floorFire x: (gEgo x:) y: (gEgo y:) init: setCycle: Fwd)
				(gTheIconBar enable: 8 2 6)
				(gGame setCursor: 941)
				(gUser canInput: 1)
				(self setScript: egoTakesDamage self)
			)
			(12
				(if (not (== (egoLevitates state:) -1))
					(self cue:)
				)
			)
			(13
				(gEgo normalize:)
				(floorFire dispose:)
				(gMessager say: 3 6 56 0 self 850) ; "Pillar of Stone, Heed my command! Gargoyle, come forth, Destroy that man!"
			)
			(14
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(15
				(HandsOff)
				((ScriptID 850 3) ; gargoyle
					view: 852
					loop: 0
					cel: 0
					noun: 4
					setCycle: End self
				)
			)
			(16
				(sFx3 number: 900 play:)
				((ScriptID 850 3) loop: 1 setCycle: CT 3 1 self) ; gargoyle
			)
			(17
				(HandsOn)
				(gTheIconBar disable: 5)
				(= seconds 5)
			)
			(18
				(gMessager say: 3 6 33 0 self 850) ; "Creature of stone, attack him!"
			)
			(19
				(= global365 855)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance fromFracas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 124)
				(gEgo x: 20 y: 183)
				((ScriptID 850 3) view: 852 loop: 2 cel: 0) ; gargoyle
				((ScriptID 850 2) view: 863 loop: (Random 0 6) cel: 0) ; deWiz
				(= seconds 2)
			)
			(1
				(if (and (== gPrevRoomNum 550) (== global155 0)) ; combatRm
					(EgoDead 60 850) ; "The Gargoyle converts you to confetti. Next time you're up against something that much tougher than you, don't go toe-to-toe. Hey, you're the magic user, do we have to spell it out for you?"
				else
					(self cue:)
				)
			)
			(2
				((ScriptID 850 3) cycleSpeed: 3 setCycle: End self) ; gargoyle
			)
			(3
				((ScriptID 850 3) view: 854 setLoop: 1) ; gargoyle
				(gMessager say: 3 6 21 0 self 850) ; "So you have defeated my minion. Enough of this foolishness!"
			)
			(4
				(gMessager say: 3 6 22 0 self 850) ; "Now I shall summon my Lord. He shall deal with you personally. He'll enjoy that."
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 1 5)
				((ScriptID 850 2) view: 861 loop: 1 cel: 255 setCycle: Beg self) ; deWiz
			)
			(6
				((ScriptID 850 2) loop: 0 cel: 255 setCycle: End self) ; deWiz
			)
			(7
				((ScriptID 850 2) setCycle: OccasionalCycle self 1 10 25) ; deWiz
				(switch global209
					(1
						(= seconds 60)
					)
					(2
						(= seconds 40)
					)
					(3
						(= seconds 20)
					)
				)
			)
			(8
				((ScriptID 850 2) setCycle: 0) ; deWiz
				((ScriptID 850 6) init:) ; deMaster
				(DrawPic 850 9)
				(= seconds 1)
			)
			(9
				(EgoDead 2 850) ; "You died fried by a Thermonuclear Blast from the Demon Master. Next time you need to destroy the Orb a bit faster."
				(self dispose:)
			)
		)
	)
)

(instance egoTakesDamage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 29 setCycle: Fwd)
				(if (gEgo takeDamage: 10)
					(switch global209
						(1
							(= seconds 6)
						)
						(2
							(= seconds 4)
						)
						(3
							(= seconds 2)
						)
					)
				else
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance deMasterBails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				((ScriptID 850 6) dispose:) ; deMaster
				(DrawPic 850 9)
				(= seconds 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance floorFire of Prop
	(properties
		modNum 850
		view 872
		signal 16384
	)
)

(instance kaBoom of Actor
	(properties
		x 193
		y 97
		noun 5
		modNum 850
		view 867
		signal 16384
	)
)

(instance stick of Actor
	(properties
		x 20
		y 117
		view 790
		loop 1
	)
)

(instance sFx3 of Sound
	(properties)
)

