;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 851)
(include sci.sh)
(use Main)
(use n026)
(use Sound)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm851 0
	fighterEndScript 1
	crankUpShield 2
	spearWiz 3
)

(instance rm851 of Rm
	(properties
		modNum 850
		noun 18
		picture 850
	)

	(method (init)
		(super init:)
		(self setRegions: 850) ; endGame
		(SetFlag 124)
		(if (== gPrevRoomNum 550) ; combatRm
			(self setScript: killedGarg)
		else
			(self setScript: fighterEndScript)
		)
		(if (not (== global155 0))
			(gGame save: 1)
		)
	)
)

(instance fighterEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 850 6) init: stopUpd:) ; deMaster
				(gEgo setMotion: MoveTo 20 183 self)
			)
			(1
				(gMessager say: 1 6 4 0 self 850) ; "Our plan worked, Lord! Even now, our enemy Rakeesh is in disgrace and the Liontaur Warriors march out from Tarna. The Simbani idiots and the Leopardmen fools will all avenge their murdered leaders. And they will all blame Rakeesh and each other, not dreaming it is our doing!"
			)
			(2
				(gMessager say: 1 6 5 0 self 850) ; "Behind you, idiot! It's that interfering human!"
			)
			(3
				((ScriptID 850 6) dispose:) ; deMaster
				(DrawPic 850 9)
				(= seconds 2)
			)
			(4
				((ScriptID 850 2) loop: 1 setCycle: End self) ; deWiz
			)
			(5
				(gMessager say: 3 6 6 0 self 850) ; "So, you have escaped from my trap. Perhaps destroying you will be more interesting than I thought."
			)
			(6
				((ScriptID 850 2) view: 863 loop: 6 setCycle: End self) ; deWiz
			)
			(7
				(sFx2 number: 944 play:)
				((ScriptID 850 3) setCycle: End self) ; gargoyle
			)
			(8
				((ScriptID 850 3) loop: 1 setCycle: CT 3 1 self) ; gargoyle
			)
			(9
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
				(gEgo normalize: x: 20 y: 183 solvePuzzle: 342 3)
				((ScriptID 850 3) loop: 2 cel: 0 noun: 4) ; gargoyle
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

(instance crankUpShield of Script
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
				(SetFlag 82)
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
				(sFx2 number: 13 play:)
				((ScriptID 850 9) ; zap
					setLoop: (Random 0 4)
					x: 186
					y: 60
					cycleSpeed: 0
					moveSpeed: 0
					setScale:
					setStep: 8 7
					init:
					setMotion:
						MoveTo
						(+ (gEgo x:) 20)
						(- (gEgo y:) 34)
						self
				)
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(4
				(gEgo view: 36 loop: 0 cel: 0 setCycle: CT 4 1)
			)
			(5
				(sFx2 number: 10 play:)
				((ScriptID 850 9) dispose:) ; zap
				(gEgo setCycle: End self)
			)
			(6
				(gEgo normalize:)
				(if (== (self script:) (ScriptID 850 12)) ; blastWiz
					((ScriptID 850 12) cue:) ; blastWiz
				)
				(if (== ((ScriptID 850 3) script:) (ScriptID 850 7)) ; gargoyle, knockGarg
					((ScriptID 850 7) cue:) ; knockGarg
				)
				(= state 0)
				(HandsOn)
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

(instance spearWiz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (== ((ScriptID 850 16) state:) -1)) ; egoHit
					0
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(SetFlag 84)
				(if ((ScriptID 850 2) script:) ; deWiz
					((ScriptID 850 2) setScript: 0) ; deWiz
				)
				((ScriptID 32 0) start: 1) ; project
				(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
				(self setScript: (ScriptID 32 0) 0 56) ; project
				(gEgo drop: 45) ; theMagicSpear
				(gTheIconBar advanceCurIcon:)
			)
			(2
				(sFx2 number: 931 play: 127)
				((ScriptID 850 2) ; deWiz
					setPri: 14
					moveSpeed: 0
					setStep: 6 5
					setCycle: Walk
					setMotion: MoveTo 243 89 self
				)
				((ScriptID 850 5) setPri: 0) ; portal
			)
			(3
				(sFx2 number: 101 play:)
				((ScriptID 850 2) dispose:) ; deWiz
				(gEgo solvePuzzle: 340 10)
				(= seconds 1)
			)
			(4
				(if (== (gEgo script:) (ScriptID 850 11)) ; walkOnGarg
					(gMessager say: 2 6 31 0 0 850) ; "The gargoyle releases your legs."
					((ScriptID 850 11) cue:) ; walkOnGarg
				)
				(if (== ((ScriptID 850 16) state:) 0) ; egoHit
					((ScriptID 850 16) cue:) ; egoHit
				)
				(self setScript: (ScriptID 850 10)) ; deWizTimer
			)
		)
	)
)

(instance sFx2 of Sound
	(properties)
)

