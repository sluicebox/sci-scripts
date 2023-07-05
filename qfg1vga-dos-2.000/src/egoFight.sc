;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use n814)
(use Actor)
(use System)

(public
	egoFight 0
	pointBox 1
)

(instance egoFight of Script
	(properties)

	(method (init)
		(gMouseDownHandler add: self)
		(pointBox init: setLoop: 2 stopUpd:)
		(gTheIconBar disable:)
		(super init: &rest)
	)

	(method (dispose)
		(gDirectionHandler release:)
		(gMouseDownHandler delete: self)
		(gTheIconBar enable:)
		(pointBox dispose:)
		(super dispose:)
	)

	(method (doit)
		(pointBox doit:)
		(if
			(or
				(and (client fightLeft:) (> (client x:) 288))
				(and (not (client fightLeft:)) (< (client x:) 95))
			)
			((client opponent:) setMotion: 0 setCycle: 0 setScript: 0)
			(if ((ScriptID 220 0) script:) ; opponentFight
				(((ScriptID 220 0) script:) dispose:) ; opponentFight
			)
			(if script
				(script dispose:)
			)
			(client endFight: 1 canFight: 0)
			(client gotBeat: (ScriptID 223 1)) ; tooTired
		else
			(super doit:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (or script (not (client canFight:)))
			(event claimed: 1)
			(return)
		)
		(cond
			((== (event type:) evMOUSEBUTTON)
				(= temp0 (event x:))
				(cond
					((< (= temp1 (event y:)) 154)
						(cond
							((> temp0 285)
								(if (client canFight:)
									(client canFight: 0)
									(if script
										(script dispose:)
									)
									(self
										setScript:
											(Clone (ScriptID 217 2)) ; Thrust
											self
											client
									)
									(TrySkill 5 0 20) ; weapon-use
									(if (client tryAttack: (client opponent:))
										((client opponent:) getHit:)
									)
								else
									(event claimed: 1)
								)
							)
							((< temp0 265)
								(if (client canFight:)
									(client canFight: 0)
									(if script
										(script dispose:)
									)
									(self
										setScript:
											(Clone (ScriptID 217 3)) ; Slash
											self
											client
									)
									(TrySkill 5 0 20) ; weapon-use
									(if (client tryAttack: (client opponent:))
										((client opponent:) getHit:)
									)
								else
									(event claimed: 1)
								)
							)
						)
					)
					((> temp1 169)
						(cond
							((> temp0 285)
								(if (client canFight:)
									(TrySkill 7 0 20) ; dodge
									(client canFight: 0)
									(if script
										(script dispose:)
									)
									(if (Random 0 1)
										(self
											setScript:
												(Clone (ScriptID 217 0)) ; Dodge
												self
												client
										)
									else
										(self
											setScript:
												(Clone (ScriptID 217 1)) ; Duck
												self
												client
										)
									)
								else
									(event claimed: 1)
								)
							)
							((< temp0 265)
								(if (client canFight:)
									(client canFight: 0)
									(TrySkill 6 0 20) ; parry
									(if script
										(script dispose:)
									)
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
					)
				)
				(event claimed: 1)
			)
			((<= JOY_NULL (event message:) JOY_UPLEFT)
				(switch (event message:)
					(JOY_UPRIGHT
						(if (client canFight:)
							(client canFight: 0)
							(if script
								(script dispose:)
							)
							(self
								setScript: (Clone (ScriptID 217 2)) self client ; Thrust
							)
							(TrySkill 5 0 20) ; weapon-use
							(if (client tryAttack: (client opponent:))
								((client opponent:) getHit:)
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_UPLEFT
						(if (client canFight:)
							(TrySkill 7 0 20) ; dodge
							(client canFight: 0)
							(if script
								(script dispose:)
							)
							(self
								setScript: (Clone (ScriptID 217 3)) self client ; Slash
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_DOWNRIGHT
						(if (client canFight:)
							(TrySkill 7 0 20) ; dodge
							(client canFight: 0)
							(if script
								(script dispose:)
							)
							(if (Random 0 1)
								(self
									setScript:
										(Clone (ScriptID 217 0)) ; Dodge
										self
										client
								)
							else
								(self
									setScript:
										(Clone (ScriptID 217 1)) ; Duck
										self
										client
								)
							)
						else
							(event claimed: 1)
						)
					)
					(JOY_DOWNLEFT
						(if (client canFight:)
							(client canFight: 0)
							(TrySkill 6 0 20) ; parry
							(if script
								(script dispose:)
							)
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
				(gDirectionHandler addToFront: client)
				(= cycles 1)
			)
			(1
				(client
					canFight: 1
					action: 0
					cycleSpeed: 18
					moveSpeed: 12
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

(class inputBox of View
	(properties
		oldX 0
		oldY 0
		relX 280
		relY 155
		first 1
		leftBor 260
		rightBor 303
		topBor 130
		botBor 175
		max 1000
		value 0
	)

	(method (dispose)
		(ClearFlag 359)
		(gGame setCursor: gNormalCursor 1)
		(super dispose:)
	)

	(method (init)
		(gTheIconBar disable:)
		(gGame setCursor: gNormalCursor 1 280 155)
		(SetFlag 359)
		(self setPri: 14 ignoreActors:)
		(super init: &rest)
	)

	(method (draw &tmp temp0 temp1)
		(if (< max 1)
			(= max 1)
		)
		(if (> (= temp1 value) max)
			(= temp1 max)
		)
		(if
			(>
				(= temp0
					(/ (+ (= temp1 (/ (+ (* temp1 100) max -1) max)) 9) 10)
				)
				9
			)
			(= temp0 9)
		)
		(self cel: temp0 setPri: 14 stopUpd:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (Event new:))
		(= temp3 (temp0 x:))
		(= temp4 (- (temp0 y:) 10))
		(if first
			(= oldX temp3)
			(= oldY temp4)
			(= first 0)
		)
		(if (or (!= temp3 oldX) (!= temp4 oldY))
			(if (!= temp3 oldX)
				(= temp5 (- temp3 oldX))
				(= oldX temp3)
				(cond
					((< (= temp1 (+ relX temp5)) leftBor)
						(= temp1 (= oldX leftBor))
					)
					((> temp1 rightBor)
						(= temp1 (= oldX rightBor))
					)
				)
			else
				(= temp1 relX)
			)
			(if (!= temp4 oldY)
				(= temp6 (- temp4 relY))
				(= oldY temp4)
				(cond
					((< (= temp2 (+ relY temp6)) topBor)
						(= temp2 (= oldY topBor))
					)
					((> temp2 botBor)
						(= temp2 (= oldY botBor))
					)
				)
			else
				(= temp2 relY)
			)
			(= relY temp2)
			(= relX temp1)
			(gGame setCursor: gNormalCursor 1 relX temp2)
		)
		(temp0 dispose:)
		(super doit: &rest)
	)
)

(instance pointBox of inputBox
	(properties
		x 303
		y 185
		view 945
		loop 2
		value 1000
	)
)

