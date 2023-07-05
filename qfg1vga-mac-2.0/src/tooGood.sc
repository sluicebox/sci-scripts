;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use n814)
(use Motion)
(use User)
(use System)

(public
	tooGood 0
	tooTired 1
)

(instance tooGood of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 304)
				((ScriptID 39 1) stop:) ; swordMusic
				(= cycles 2)
			)
			(1
				(gMessager say: 8 0 3) ; "Enough!"
				((ScriptID 39 2) ; theMaster
					view: 639
					setLoop: (if (client fightLeft:) 5 else 4)
					setCel: 0
				)
				(= cycles 6)
			)
			(2
				(SkillUsed 4 50) ; luck
				(if (== gHeroType 0) ; Fighter
					(SolvePuzzle 608 10 0)
				)
				(gMessager say: 8 0 10) ; "I can see now that my career must end. Anytime that I, the Weapon Master, can be beaten by a mindless, nasty little twerp such as you, it is time to take an interminable vacation."
				((ScriptID 39 2) ; theMaster
					setLoop: (if (== ((ScriptID 39 2) loop:) 4) 1 else 0) ; theMaster
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(if ((ScriptID 39 2) fightLeft:) 340 else -20) ; theMaster
						((ScriptID 39 2) y:) ; theMaster
						self
				)
				(ClearFlag 239)
				(SetFlag 249)
			)
			(3
				(ClearFlag 304)
				((client opponent:) dispose:)
				(gEgo
					posn: ((client opponent:) x:) ((client opponent:) y:)
					loop: (if ((ScriptID 39 2) fightLeft:) 0 else 1) ; theMaster
					cel: 0
					show:
				)
				(NormalEgo)
				(HandsOn)
				(User canInput: 1)
				(client dispose:)
			)
		)
	)
)

(instance tooTired of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 304)
				((ScriptID 39 1) stop:) ; swordMusic
				(= cycles 2)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(client
					view: 514
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(if (< [gEgoStats 15] 2) ; stamina
					(gMessager say: 8 0 9 1 self) ; "The lesson wears you down, and you become exhausted."
				else
					(gMessager say: 8 0 13 1 self) ; "You are forced to admit that the Weapon Master has gotten the better of you."
				)
			)
			(3
				(client setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 120)
			)
			(5
				(client setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(client hide: forceUpd:)
				(= ticks 1)
			)
			(7
				(gEgo
					loop: (if (client fightLeft:) 1 else 0)
					posn: (client x:) (client y:)
					show:
					forceUpd:
				)
				(NormalEgo)
				(= ticks 10)
			)
			(8
				(gEgo stopUpd:)
				(if (client endFight:)
					((client opponent:) setScript: (ScriptID 224 0)) ; leaveRoom
				)
				(ClearFlag 304)
				(client dispose:)
			)
		)
	)
)

