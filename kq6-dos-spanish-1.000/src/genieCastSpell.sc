;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 744)
(include sci.sh)
(use Main)
(use n913)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use System)

(public
	genieCastSpell 0
	saladinKillEgo 1
)

(instance genieCastSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 189 314 189 195 189 198 161 279 161 227 120 223 120 212 129 159 129 115 162 78 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 165 141 238 141 246 151 159 151
							yourself:
						)
				)
				(= cycles 2)
			)
			(1
				(gTheIconBar enable:)
				(gMessager say: 1 0 6 1 self) ; "The lovely image of Cassima suddenly bursts into smoke and is replaced by...the vizier's genie!"
			)
			(2
				(self setScript: (ScriptID 742 4) self) ; genieReappears
			)
			(3
				(gMessager say: 1 0 6 2 self) ; "Shamir, you fool!"
			)
			(4
				(gMessager say: 1 0 6 3 self) ; "It is not my fault, Master! The illusion was broken!"
			)
			(5
				(gMessager say: 1 0 6 4 self) ; "Treason! What have you done with the princess?"
			)
			(6
				(gMessager say: 1 0 6 5 self) ; "Enraged, Saladin and the other guard dogs begin advancing on the vizier!"
			)
			(7
				(gMessager say: 1 0 6 6 self) ; "DO SOMETHING, YOU WORTHLESS GENIE!!!"
			)
			(8
				(LoadMany 0 1004 1063 1029 1001 1026)
				(UnLoad 128 892)
				(UnLoad 128 899)
				(UnLoad 128 8921)
				(UnLoad 128 8992)
				(UnLoad 128 891)
				(UnLoad 128 890)
				(self setScript: (ScriptID 740 23) self) ; theGreatEscape
			)
			(9
				(gEgo put: 24) ; mirror
				(gGame handsOn:)
				((ScriptID 740 3) setScript: (ScriptID 742 5)) ; genie, genieScr
				(self dispose:)
				(DisposeScript 744)
			)
		)
	)
)

(instance saladinKillEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gTheIconBar enable:)
				(if (IsFlag 156)
					(= register 999)
					((ScriptID 740 2) view: 7415 setLoop: 0 cel: 3 setPri: 9) ; vizier
				else
					(= state 11)
				)
				(= cycles 2)
			)
			(2
				(SetFlag 59)
				(gMessager say: 1 0 38 1 self) ; "(VERY INTERESTED) Hmmm? Mint?"
			)
			(3
				(ClearFlag 59)
				(gMessager say: 1 0 38 2 self) ; "(WARNING TONE) CASSIMA!"
			)
			(4
				((ScriptID 740 2) setCycle: CT 5 1 self) ; vizier
			)
			(5
				(= ticks 90)
			)
			(6
				((ScriptID 740 2) setCycle: CT 10 1 self) ; vizier
			)
			(7
				(SetFlag 59)
				(gMessager say: 1 0 38 3 self) ; "(NASTY/GENIE, DRUNKEN) Tee, hee, hee <hic>!"
			)
			(8
				(ClearFlag 59)
				(gMessager say: 1 0 38 4 self) ; "(CONFUSED, CONCERNED) Princess?"
			)
			(9
				(SetFlag 59)
				(gMessager say: 1 0 38 5 self) ; "Kill him <hic>!"
			)
			(10
				((ScriptID 740 2) setCycle: End self) ; vizier
			)
			(11
				(ClearFlag 59)
				(gMessager say: 1 0 38 6 self) ; "(CONFUSED) As you wish...."
			)
			(12
				(gGlobalSound number: 0 stop:)
				(gGlobalSound number: 705 setLoop: 1 play:)
				((ScriptID 740 5) view: 736 cycleSpeed: 3 moveSpeed: 3) ; saladin
				(Face (ScriptID 740 5) gEgo self) ; saladin
			)
			(13
				(if (not register)
					(gMessager say: 1 0 5 0 self) ; "If you refuse to defend yourself, you must have faked the letter. Since you cannot prove your point, I shall prove MINE!"
				else
					(= cycles 1)
				)
			)
			(14
				(gEgo setHeading: 180)
				((ScriptID 740 5) ; saladin
					setMotion:
						PolyPath
						(- (gEgo x:) 24)
						(+ (gEgo y:) 5)
						self
				)
			)
			(15
				((ScriptID 740 5) setHeading: 0 self) ; saladin
			)
			(16
				(gEgo hide:)
				((ScriptID 740 5) ; saladin
					view: 738
					setLoop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 756 setLoop: 1 play:)
			)
			(17
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 971 setLoop: 1 play: self)
			)
			(18
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
				((ScriptID 740 5) setCycle: End self) ; saladin
			)
			(19
				(switch register
					(29
						(gMessager say: 1 0 29 0 self) ; "Saladin almost seems reluctant as he stabs Alexander with lethal skill, according to his princess's wishes."
					)
					(else
						(= cycles 2)
					)
				)
			)
			(20
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(EgoDead 33) ; "She loves me, she loves me NOT?"
		(DisposeScript 744)
	)
)

