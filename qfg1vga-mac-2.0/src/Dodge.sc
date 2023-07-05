;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 217)
(include sci.sh)
(use Motion)
(use System)

(public
	Dodge 0
	Duck 1
	Thrust 2
	Slash 3
	ParryUp 4
	ParryDown 5
	Leap 6
)

(instance Dodge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					setMotion: 0
					action: (Random 5 6)
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register setCel: 0 action: 0)
				(self dispose:)
			)
		)
	)
)

(instance Duck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 7
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register setCel: 0 action: 0)
				(self dispose:)
			)
		)
	)
)

(instance Thrust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 1
					setLoop: (if (register fightLeft:) 3 else 2)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					action: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance Slash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 2
					setLoop: (if (register fightLeft:) 5 else 4)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					action: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance ParryUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 3
					setLoop: (if (register fightLeft:) 9 else 8)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					action: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance ParryDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 4
					setLoop: (if (register fightLeft:) 9 else 8)
					setCel: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register
					setLoop: (if (register fightLeft:) 1 else 0)
					setCel: 0
					action: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance Leap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register
					action: 8
					setLoop: (if (register fightLeft:) 7 else 6)
					posn:
						(if (register fightLeft:)
							(- (register x:) 30)
						else
							(+ (register x:) 30)
						)
						(register y:)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 18)
			)
			(2
				(register
					setLoop: (if (register fightLeft:) 0 else 1)
					posn:
						(if (register fightLeft:)
							(- (register x:) 30)
						else
							(+ (register x:) 30)
						)
						(register y:)
					setCel: 0
				)
				(= cycles 2)
			)
			(3
				(if (register fightLeft:)
					(register fightLeft: 0 action: 0 canFight: 1)
				else
					(register fightLeft: 1 action: 0)
				)
				(self dispose:)
			)
		)
	)
)

