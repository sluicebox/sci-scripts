;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 852)
(include sci.sh)
(use Main)
(use n026)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm852 0
	paladinEndScript 1
	crankUpSword 2
	chuckSwordAtWiz 3
	lightnin1 4
	lightnin2 5
	orbTempts 6
)

(instance rm852 of Rm
	(properties
		modNum 850
		noun 18
		picture 850
	)

	(method (init)
		(= gHeroType 3) ; Paladin
		(SetFlag 124)
		(super init:)
		(self setRegions: 850) ; endGame
		(if (== gPrevRoomNum 550) ; combatRm
			(self setScript: killedGarg)
		else
			(self setScript: paladinEndScript)
		)
		(if (not (== global155 0))
			(gGame save: 1)
		)
	)
)

(instance paladinEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 850 2) view: 863) ; deWiz
				(gEgo setMotion: MoveTo 20 183 self)
			)
			(1
				(if (IsFlag 150)
					(gMessager say: 2 6 62 0 self 850) ; "You are almost overwhelmed by your sense of danger here."
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 3 6 13 0 self 850) ; "So you made it past my guardians, little pawn. I have been waiting for you."
			)
			(3
				((ScriptID 850 2) view: 863 loop: 6 setCycle: End self) ; deWiz
			)
			(4
				((ScriptID 850 3) setCycle: End self) ; gargoyle
			)
			(5
				((ScriptID 850 3) loop: 1 setCycle: CT 3 1 self) ; gargoyle
			)
			(6
				(= global365 855)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance killedGarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 850 3) loop: 2 cel: 0 noun: 4) ; gargoyle
				(gEgo x: 20 y: 183 solvePuzzle: 342 3 9)
				((ScriptID 850 2) view: 863 loop: (Random 0 6) cel: 0) ; deWiz
				(= seconds 2)
			)
			(1
				(if (== global155 0)
					(EgoDead 59 850) ; "The Gargoyle de-feeted and dis-armed you. The Demon Wizard has won this round, but you'd better demand a rematch."
				else
					(self cue:)
				)
			)
			(2
				((ScriptID 850 3) cycleSpeed: 3 setCycle: End self) ; gargoyle
			)
			(3
				((ScriptID 850 3) view: 854 setLoop: 1) ; gargoyle
				(gMessager say: 3 6 7 0 self 850) ; "So stone will not stop you. Then try my fire!"
			)
			(4
				((ScriptID 850 2) setScript: (ScriptID 850 8)) ; deWiz, castSpells
				(HandsOn)
				(gTheIconBar disable: 1 5 6)
				(self dispose:)
			)
		)
	)
)

(instance crankUpSword of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (self script:) (ScriptID 850 12)) ; blastWiz
				(== ((ScriptID 850 12) state:) 0) ; blastWiz
				(== (self state:) 0)
			)
			((ScriptID 850 12) cue:) ; blastWiz
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 1 4 5 6)
				(SetFlag 89)
				((ScriptID 850 8) dispose:) ; castSpells
				(gEgo setMotion: MoveTo 42 178 self)
			)
			(1
				(gTheIconBar disable: 1 4 5 6)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo setMotion: 0 setCycle: 0)
				(Face gEgo (ScriptID 850 2)) ; deWiz
				((ScriptID 850 2) ; deWiz
					view: 863
					cel: 0
					loop: (Random 0 6)
					setCycle: End self
				)
			)
			(2
				((ScriptID 850 2) view: 863 loop: 0 setCycle: CT 6 1 self) ; deWiz
			)
			(3
				((ScriptID 850 9) ; zap
					setLoop: (Random 0 4)
					x: 186
					y: 60
					cycleSpeed: 0
					moveSpeed: 0
					setScale:
					setStep: 8 7
					init:
					setMotion: MoveTo 61 111 self
				)
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(4
				(gEgo view: 38 loop: 0 cel: 0 setCycle: End)
				(sFx2 number: 240 play:)
			)
			(5
				(sFx2 number: 10 play:)
				((ScriptID 850 9) dispose:) ; zap
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize:)
				(= state 0)
				(if (== (self script:) (ScriptID 850 12)) ; blastWiz
					((ScriptID 850 12) cue:) ; blastWiz
				)
				(if (== ((ScriptID 850 3) script:) (ScriptID 850 7)) ; gargoyle, knockGarg
					((ScriptID 850 7) cue:) ; knockGarg
				)
				(gTheIconBar enable: 1 4)
				(switch global209
					(1
						(= seconds 15)
					)
					(2
						(= seconds 10)
					)
					(3
						(= seconds 5)
					)
				)
			)
		)
	)

	(method (dispose)
		(ClearFlag 82)
		(super dispose:)
	)
)

(instance chuckSwordAtWiz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 850 8) dispose:) ; castSpells
				(crankUpSword dispose:)
				(self setScript: (ScriptID 32 0) self 11) ; project
				(gEgo drop: 1) ; theSword
				(SetFlag 91)
			)
			(1)
			(2
				(sFx2 number: 910 play:)
				((ScriptID 850 2) ; deWiz
					view: 865
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(if (== (gEgo script:) (ScriptID 850 11)) ; walkOnGarg
					((ScriptID 850 11) cue:) ; walkOnGarg
				)
				(if (== ((ScriptID 850 16) state:) 0) ; egoHit
					((ScriptID 850 16) cue:) ; egoHit
				)
			)
			(3
				((ScriptID 850 2) loop: 1 cel: 0 setPri: 14 setCycle: End self) ; deWiz
			)
			(4
				((ScriptID 850 2) ; deWiz
					view: 865
					setLoop: 3
					cycleSpeed: 0
					setPri: 2
					setCycle: Fwd
				)
				(lightnin2 init: setPri: 1 cycleSpeed: 0 setCycle: Fwd)
				(sFx2 number: 7 play:)
				(self setScript: (ScriptID 850 10)) ; deWizTimer
				((ScriptID 850 10) setScript: orbTempts) ; deWizTimer
				(if (== (gEgo script:) (ScriptID 850 11)) ; walkOnGarg
					(gMessager say: 2 6 31 0 0 850) ; "The gargoyle releases your legs."
					((ScriptID 850 11) cue:) ; walkOnGarg
				)
				(if (== ((ScriptID 850 16) state:) 0) ; egoHit
					((ScriptID 850 16) cue:) ; egoHit
				)
			)
		)
	)
)

(instance orbTempts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(gMessager say: 2 6 32 0 self 850) ; "You hear a voice in your mind, "You have done well so far, Paladin. Now free me and I shall be your servant.""
			)
			(2
				(= seconds 7)
			)
			(3
				(gMessager say: 2 6 51 0 self 850) ; "You hear the voice again, "Set me free. I shall be yours.""
			)
			(4
				(= seconds 7)
			)
			(5
				(gMessager say: 2 6 52 0 self 850) ; "You seek knowledge and honor. I can teach you much."
			)
			(6
				(= seconds 7)
			)
			(7
				(gMessager say: 2 6 53 0 self 850) ; "Why do you hesitate? Touch me and we shall be as one."
			)
			(8
				(gMessager say: 2 6 54 0 self 850) ; "I want you. Come to me."
			)
			(9
				(= seconds 7)
			)
			(10
				(gMessager say: 2 6 55 0 self 850) ; "Please touch me. Free me!"
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance lightnin1 of Prop
	(properties
		x 265
		view 855
		loop 1
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		((ScriptID 850 4) doVerb: theVerb) ; orb
	)
)

(instance lightnin2 of Prop
	(properties
		x 204
		view 855
		loop 1
		cel 1
		priority 13
		signal 16400
	)
)

(instance sFx2 of Sound
	(properties)
)

