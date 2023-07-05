;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 224)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	leaveRoom 0
)

(instance leaveRoom of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 304)
				((ScriptID 39 2) ; theMaster
					view: 639
					setLoop: (if ((ScriptID 39 2) fightLeft:) 0 else 1) ; theMaster
					cel: 0
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 8 0 6 0 self) ; "Even as we fought, I could detect your skills improving through practice."
			)
			(2
				(if ((client opponent:) endFight:)
					(gMessager say: 8 0 17 0 self) ; "It was most prudent that you should give in to my superior skill."
				else
					(gMessager say: 8 0 25 0 self) ; "Still, you seem to tire more easily than you should."
				)
			)
			(3
				(switch (Random 0 4)
					(0
						(gMessager say: 8 0 23 0 self) ; "Be more aware of the angle with which your weapon approaches your opponent."
					)
					(1
						(gMessager say: 8 0 20 0 self) ; "The art of dancing would be a good skill for you to practice, my friend."
					)
					(2
						(gMessager say: 8 0 22 0 self) ; "You have a tendency to overbalance when you dodge a blow. This will adversely affect the timing and effectiveness of your counterattack."
					)
					(3
						(gMessager say: 8 0 21 0 self) ; "Put your attention to the control of your legs when you duck a swing. Your springiness makes you seem to bounce,"
					)
					(4
						(gMessager say: 8 0 19 0 self) ; "If you would like a stretcher, my weak, tired friend... You seem a shadow of the person who began this little lesson."
					)
				)
			)
			(4
				(gMessager say: 8 0 5 0 self) ; "Should we meet again, I would not be adverse to another go-round. Farewell, friend!"
			)
			(5
				((ScriptID 39 2) ; theMaster
					setLoop: (if ((ScriptID 39 2) loop:) 0 else 1) ; theMaster
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setMotion:
						MoveTo
						(if ((ScriptID 39 2) fightLeft:) 340 else -20) ; theMaster
						(+ ((ScriptID 39 2) y:) 20) ; theMaster
						self
				)
				(ClearFlag 239)
				(ClearFlag 304)
			)
			(6
				(HandsOn)
				(client dispose:)
			)
		)
	)
)

