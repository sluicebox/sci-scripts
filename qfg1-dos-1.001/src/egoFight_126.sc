;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 126)
(include sci.sh)
(use Main)
(use User)
(use System)

(public
	egoFight 0
)

(instance egoFight of Script
	(properties)

	(method (dispose)
		(gDirHandler release:)
		(gEgo illegalBits: -32768)
		(super dispose:)
		(DisposeScript 126)
	)

	(method (doit)
		(cond
			((and (IsFlag 318) (IsFlag 313) (not (self script:)))
				(ClearFlag 318)
				(if (gEgo has: 6) ; blade
					(self setScript: (ScriptID 114 1)) ; halfTime
				else
					(self setScript: (ScriptID 114 0)) ; turn
				)
			)
			(
				(and
					global343
					(IsFlag 319)
					(not ((ScriptID 15 1) script:)) ; kobold
					(not (self script:))
				)
				(ClearFlag 319)
				(if (IsFlag 149)
					(SetFlag 320)
				else
					(ClearFlag 320)
				)
				(SetFlag 285)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or script ((ScriptID 15 1) script:)) ; kobold
			(event claimed: 1)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look/kobold,creature,monster,man,wizard')
						(HighPrint 126 0) ; "He's not a happy Kobold."
					)
					((Said 'look')
						(HighPrint 126 1) ; "Quit sightseeing and watch what you're doing!"
					)
					((Said 'escape,escape,run')
						(HighPrint 126 2) ; "C'mon! He's not going to KILL you... is he?"
					)
					((Said 'cast')
						(event claimed: 0)
					)
					((Said 'ask')
						(HighPrint 126 3) ; "Later! Later!"
					)
					((Said 'fight,kill,hit,cut')
						(HighPrint 126 4) ; "Of course!"
					)
					((Said 'use/blade,dagger,shield')
						(HighPrint 126 5) ; "In other words, keep fighting!"
					)
					((Said 'throw')
						(HighPrint 126 6) ; "You're a little too busy at the moment."
					)
					(else
						(HighPrint 126 7) ; "Now??"
						(event claimed: 1)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if ((ScriptID 15 4) script:) ; ball
							((ScriptID 15 4) setScript: 0) ; ball
						)
						(if
							(and
								(IsFlag 318)
								(not (IsFlag 314))
								(not (self script:))
							)
							(ClearFlag 318)
							(SetFlag 316)
							(if (gEgo has: 6) ; blade
								(switch (Random 0 1)
									(0
										(self
											setScript:
												(ScriptID 127 2) ; Thrust
												self
												client
										)
									)
									(1
										(self
											setScript:
												(ScriptID 113 0) ; Slash
												self
												client
										)
									)
								)
							else
								(self setScript: (ScriptID 128 3) self client) ; Lunge
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_LEFT
						(if ((ScriptID 15 4) script:) ; ball
							((ScriptID 15 4) setScript: 0) ; ball
						)
						(if
							(and
								(IsFlag 318)
								(not (IsFlag 314))
								(not (self script:))
							)
							(ClearFlag 318)
							(SetFlag 316)
							(if (gEgo has: 6) ; blade
								(self setScript: (ScriptID 127 0) self client) ; Dodge
							else
								(self setScript: (ScriptID 128 0) self client) ; DodgeLeft
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_RIGHT
						(if ((ScriptID 15 4) script:) ; ball
							((ScriptID 15 4) setScript: 0) ; ball
						)
						(if
							(and
								(IsFlag 318)
								(not (IsFlag 314))
								(not (self script:))
							)
							(ClearFlag 318)
							(SetFlag 316)
							(if (gEgo has: 6) ; blade
								(self setScript: (ScriptID 127 1) self client) ; Duck
							else
								(self setScript: (ScriptID 128 1) self client) ; DodgeRight
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_DOWN
						(if ((ScriptID 15 4) script:) ; ball
							((ScriptID 15 4) setScript: 0) ; ball
						)
						(if
							(and
								(IsFlag 318)
								(not (IsFlag 314))
								(not (self script:))
							)
							(ClearFlag 318)
							(SetFlag 316)
							(if (gEgo has: 6) ; blade
								(self setScript: (ScriptID 113 1) self client) ; ParryUp
							else
								(self setScript: (ScriptID 128 2) self client) ; Duck
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
				(gEgo illegalBits: 0)
				(User canInput: 1)
				(gDirHandler addToFront: client)
				(= cycles 2)
			)
			(1
				(SetFlag 318)
				(client cycleSpeed: 0 moveSpeed: 0)
			)
			(2
				(if (<= global343 0)
					(SetFlag 283)
					(SetFlag 311)
					(gEgo illegalBits: -32768)
					(self dispose:)
				else
					(= cycles 5)
				)
			)
			(3
				(ClearFlag 316)
				(self changeState: 1)
			)
		)
	)
)

