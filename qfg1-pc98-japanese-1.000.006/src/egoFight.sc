;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use System)

(public
	egoFight 0
)

(instance egoFight of Script
	(properties)

	(method (dispose)
		(gDirHandler release:)
		(super dispose:)
	)

	(method (doit)
		(if
			(or
				(and (client fightLeft:) (> (client x:) 300))
				(and (not (client fightLeft:)) (< (client x:) 20))
			)
			(client gotBeat: (ScriptID 223 1)) ; tooTired
		else
			(super doit:)
		)
	)

	(method (handleEvent event)
		(if (or script (not (client canFight:)))
			(event claimed: 1)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look')
						(HighPrint 216 0) ; "Quit sightseeing and watch what you're doing!"
					)
					((or (Said 'escape,escape') (Said 'run[/!*]'))
						(HighPrint 216 1) ; "C'mon! He's not going to KILL you... is he?"
					)
					((Said 'cast')
						(HighPrint 216 2) ; "You're too busy!"
					)
					((Said 'talk,talk,ask')
						(HighPrint 216 3) ; "Later! Later!"
					)
					((Said 'attack,use[/blade]')
						(HighPrint 216 4) ; "You ARE!"
					)
					((Said 'kill,cut')
						(HighPrint 216 5) ; "You're not fighting, you're PRACTICING!"
					)
					(else
						(HighPrint 216 6) ; "Why would you want to do that?"
						(event claimed: 1)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if (client canFight:)
							(client canFight: 0)
							(switch (Random 0 1)
								(0
									(self
										setScript:
											(Clone (ScriptID 217 2)) ; Thrust
											self
											client
									)
								)
								(1
									(self
										setScript:
											(Clone (ScriptID 217 3)) ; Slash
											self
											client
									)
								)
							)
							(TrySkill 5 0 20) ; weapon-use
							(if (client tryAttack: (client opponent:))
								((client opponent:) getHit:)
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_LEFT
						(if (client canFight:)
							(TrySkill 7 0 20) ; dodge
							(client canFight: 0)
							(self
								setScript: (Clone (ScriptID 217 0)) self client ; Dodge
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_RIGHT
						(if (client canFight:)
							(TrySkill 7 0 20) ; dodge
							(client canFight: 0)
							(self
								setScript: (Clone (ScriptID 217 1)) self client ; Duck
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_DOWN
						(if (client canFight:)
							(client canFight: 0)
							(TrySkill 6 0 20) ; parry
							(if (== ((client opponent:) action:) 2)
								(self
									setScript:
										(Clone (ScriptID 217 5)) ; ParryDown
										self
										client
								)
							else
								(self
									setScript:
										(Clone (ScriptID 217 4)) ; ParryUp
										self
										client
								)
							)
						else
							(event claimed: 1)
						)
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client drawWeapons:)
				(gDirHandler addToFront: client)
				(= cycles 1)
			)
			(1
				(client
					canFight: 1
					action: 0
					cycleSpeed: 0
					moveSpeed: 0
					stopUpd:
					getTired: 4 (ScriptID 223 1) ; tooTired
				)
			)
			(2
				(if ((client opponent:) endFight:)
					(client setScript: 0)
				else
					(= cycles 5)
				)
			)
			(3
				(gEgo hide:)
				(self changeState: 1)
			)
		)
	)
)

