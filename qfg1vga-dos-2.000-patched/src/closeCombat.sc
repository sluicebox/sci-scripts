;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use n814)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	closeCombat 0
	aSpell 1
	pointBox 2
	blood 3
	zapCrap 4
)

(local
	local0
	local1
	[local2 3]
	local5 = 2
	local6
	[local7 2]
	local9
	local10
	[local11 3]
	local14
	local15
	local16
	local17
	local18
	local19
)

(instance aSpell of Actor
	(properties)
)

(instance monHurt of Sound
	(properties
		flags -1
		number 102
		priority 1
	)
)

(instance closeCombat of Script
	(properties)

	(method (dispose &tmp temp0)
		(monHurt dispose:)
		(super dispose:)
	)

	(method (init)
		(monHurt init:)
		(SetFlag 284)
		(ClearFlag 102)
		(gUser canInput: 0)
		(pointBox init: setLoop: 2 stopUpd:)
		(= local10 0)
		(if (gEgo has: 2) ; sword
			(Load rsVIEW 109)
			(= local18 1)
			(= local10 0)
			(blood view: 535)
		else
			(= local18 0)
			(dodgeLIcon init: setPri: 15 hide: stopUpd:)
			(dodgeRIcon init: setPri: 15 hide: stopUpd:)
			(if (!= gHeroType 2) ; Thief
				(switchLoop doit:)
			)
			(Load rsVIEW 102)
			(blood view: 535)
			(aSpell view: 535)
		)
		(= global245 1)
		(super init: &rest)
	)

	(method (doit)
		(pointBox doit:)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (== (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(return 1)
		)
		(if (or (not (client canFight:)) (not global245) (IsFlag 102))
			(event claimed: 1)
			(while ((= temp3 (Event new: $0047)) type:) ; direction | evMOUSEKEYBOARD | evMOUSERELEASE
				(temp3 dispose:)
			)
			(temp3 dispose:)
			(return 1)
		)
		(if script
			(if
				(or
					(and (<= JOY_UP (event message:) JOY_UPLEFT) (!= (event message:) JOY_UP))
					(== (event type:) evMOUSEBUTTON)
				)
				(script cue:)
			else
				(event claimed: 1)
				(return)
			)
		)
		(cond
			((== (event type:) evMOUSEBUTTON)
				(= temp0 (event x:))
				(cond
					((< (= temp1 (event y:)) 144)
						(cond
							((> temp0 285)
								(= local5 2)
								(cond
									((not local10)
										(self setScript: egoThrust self local5)
									)
									((gEgo has: 2) ; sword
										(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
									)
									((gEgo knows: 23) ; flameDartSpell
										(if (CastSpell 23)
											(client setEgoMP: [gEgoStats 16]) ; mana
											(HandsOff)
											(self setScript: egoFlame self)
										)
									)
									(else
										(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
									)
								)
							)
							((< temp0 265)
								(= local5 1)
								(cond
									((not local10)
										(self setScript: egoThrust self local5)
									)
									((gEgo has: 2) ; sword
										(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
									)
									((gEgo knows: 21) ; zapSpell
										(if (CastSpell 21)
											(client setEgoMP: [gEgoStats 16]) ; mana
											(HandsOff)
											(self setScript: egoZap self)
										)
									)
									(else
										(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
									)
								)
							)
						)
					)
					((> temp1 159)
						(cond
							((> temp0 285)
								(= local5 0)
								(cond
									((not local10)
										(self setScript: egoDodge self local5)
									)
									((gEgo has: 2) ; sword
										(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
									)
									((gEgo knows: 20) ; dazzleSpell
										(if (CastSpell 20)
											(client setEgoMP: [gEgoStats 16]) ; mana
											(HandsOff)
											(self setScript: egoDazzle self)
										)
									)
									(else
										(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
									)
								)
							)
							((< temp0 265)
								(= local5 2)
								(cond
									((== (pointBox loop:) 2)
										(self setScript: egoBlock self local5)
									)
									(
										(or
											(== gPrevRoomNum 14)
											(== gPrevRoomNum 171) ; rmBear
											(== gPrevRoomNum 88)
											(== gPrevRoomNum 89)
											(== gPrevRoomNum 93)
											(== gPrevRoomNum 73)
											(== gPrevRoomNum 91)
										)
										(gMessager say: 1 0 2 0 0 215) ; "You cannot escape this encounter."
									)
									(else
										((ScriptID gCurRoomNum) escaped: 1)
									)
								)
							)
						)
					)
					((> 285 temp0 265)
						(if (gEgo has: 2) ; sword
							(if
								(or
									(== gPrevRoomNum 14)
									(== gPrevRoomNum 171) ; rmBear
									(== gPrevRoomNum 88)
									(== gPrevRoomNum 89)
									(== gPrevRoomNum 93)
									(== gPrevRoomNum 73)
									(== gPrevRoomNum 91)
								)
								(gMessager say: 1 0 2 0 0 215) ; "You cannot escape this encounter."
							else
								((ScriptID gCurRoomNum) escaped: 1)
							)
						else
							(switchLoop doit:)
						)
					)
				)
				(event claimed: 1)
			)
			((<= JOY_NULL (event message:) JOY_UPLEFT)
				(HandsOff)
				(switch (event message:)
					(JOY_UPRIGHT
						(gGame setCursor: gNormalCursor 1 293 135)
						(= local5 2)
						(cond
							((not local10)
								(self setScript: egoThrust self local5)
							)
							((gEgo has: 2) ; sword
								(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
							)
							((gEgo knows: 23) ; flameDartSpell
								(if (CastSpell 23)
									(client setEgoMP: [gEgoStats 16]) ; mana
									(HandsOff)
									(self setScript: egoFlame self)
								)
							)
							(else
								(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
							)
						)
					)
					(JOY_DOWNRIGHT
						(gGame setCursor: gNormalCursor 1 293 170)
						(= local5 0)
						(cond
							((not local10)
								(self setScript: egoDodge self local5)
							)
							((gEgo has: 2) ; sword
								(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
							)
							((gEgo knows: 20) ; dazzleSpell
								(if (CastSpell 20)
									(client setEgoMP: [gEgoStats 16]) ; mana
									(HandsOff)
									(self setScript: egoDazzle self)
								)
							)
							(else
								(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
							)
						)
					)
					(JOY_UPLEFT
						(gGame setCursor: gNormalCursor 1 255 135)
						(= local5 1)
						(cond
							((not local10)
								(self setScript: egoThrust self local5)
							)
							((gEgo has: 2) ; sword
								(gMessager say: 1 0 3 0 0 215) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
							)
							((gEgo knows: 21) ; zapSpell
								(if (CastSpell 21)
									(client setEgoMP: [gEgoStats 16]) ; mana
									(HandsOff)
									(self setScript: egoZap self)
								)
							)
							(else
								(gMessager say: 1 0 1 0 0 215) ; "You don't know that spell."
							)
						)
					)
					(JOY_DOWNLEFT
						(gGame setCursor: gNormalCursor 1 255 170)
						(= local5 2)
						(cond
							((not local10)
								(self setScript: egoBlock self local5)
							)
							(
								(or
									(== gPrevRoomNum 14)
									(== gPrevRoomNum 171) ; rmBear
									(== gPrevRoomNum 88)
									(== gPrevRoomNum 89)
									(== gPrevRoomNum 93)
									(== gPrevRoomNum 73)
									(== gPrevRoomNum 91)
								)
								(gMessager say: 1 0 2 0 0 215) ; "You cannot escape this encounter."
							)
							(else
								((ScriptID gCurRoomNum) escaped: 1)
							)
						)
					)
					(JOY_NULL
						(if (== (event type:) $0044) ; direction | evKEYBOARD
							(gGame setCursor: gNormalCursor 1 275 152)
							(if (gEgo has: 2) ; sword
								(if
									(or
										(== gPrevRoomNum 14)
										(== gPrevRoomNum 171) ; rmBear
										(== gPrevRoomNum 88)
										(== gPrevRoomNum 89)
										(== gPrevRoomNum 93)
										(== gPrevRoomNum 73)
										(== gPrevRoomNum 91)
									)
									(gMessager say: 1 0 2 0 0 215) ; "You cannot escape this encounter."
								else
									((ScriptID gCurRoomNum) escaped: 1)
								)
							else
								(switchLoop doit:)
							)
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
				(= local1 (ScriptID 213 0)) ; warrior
				(gDirectionHandler addToFront: client)
				(gMouseDownHandler addToFront: client)
				(= ticks 1)
			)
			(1
				(cond
					((local1 noWeapon:)
						(= state 2)
						(client
							view: 117
							setLoop: 0
							setCel: 0
							canFight: 0
							cycleSpeed: 12
							setCycle: End self
						)
					)
					((<= (local1 stamina:) 0)
						(client canFight: 0 action: 10)
						(EgoDead 64 65) ; "That was a little too much for you. You collapse from exhaustion and die."
					)
					(((local1 opponent:) ateEgo:))
					(else
						(if local18
							(client view: 109)
						else
							(client view: 102)
						)
						(client
							canFight: 1
							action: 0
							cycleSpeed: 8
							setLoop: 0
							setCel: 0
							setPri: -1
							stopUpd:
						)
					)
				)
			)
			(2
				(HandsOn)
				(gUser canInput: 0)
				(gGame setCursor: gNormalCursor 1)
				(self changeState: 1)
			)
			(3
				(EgoDead 126 129) ; "Caught in combat with neither sword nor dagger, you are unable to resist the monster's fierce onslaught. Try to be better equipped in your next life."
			)
		)
	)
)

(instance egoFlame of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(if local6
			(local6 dispose:)
		)
		(gUser canInput: 0)
		(gGame setCursor: gNormalCursor 1)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(local6 init: posn: 500 500 stopUpd:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(local1 canFight: 0 action: 11 view: 107 setCel: 0 setPri: 15)
				(local1 setCycle: CT 4 1 self)
				((ScriptID global279 0) inTransit: 1)
			)
			(1
				(local6
					view: 535
					setLoop: 6
					setCel: 1
					cycleSpeed: 4
					moveSpeed: 0
					xStep: 50
					yStep: 30
					ignoreActors:
					setPri: (+ ((local1 opponent:) priority:) 1)
					posn: (+ (local1 x:) 43) (- (local1 y:) 56)
				)
				(local1 setCycle: End self)
			)
			(2
				(= ticks 1)
			)
			(3
				(local1 setLoop: 0 setCel: 0 setPri: -1)
				(local6 setPri: (+ ((local1 opponent:) priority:) 1))
				(cond
					(
						(or
							(== global279 425)
							(== global279 430)
							(== global279 440)
							(== global279 450)
							(== global279 460)
						)
						(= ticks 1)
					)
					((!= global279 435)
						(local6
							setMotion:
								MoveTo
								((local1 opponent:) flameX:)
								((local1 opponent:) flameY:)
								self
						)
					)
					(else
						(local6
							setMotion:
								MoveTo
								(- ((local1 opponent:) x:) 37)
								(+ ((local1 opponent:) y:) 30)
								self
						)
					)
				)
			)
			(4
				(local6
					setPri: (+ ((local1 opponent:) priority:) 1)
					setCycle: End self
				)
			)
			(5
				(local6 priority: (+ ((local1 opponent:) priority:) 1))
				((local1 opponent:) setCycle: 0 setScript: 0)
				(if (== global279 455)
					((local1 opponent:) x: 123 y: 25 loop: 3 setCel: 0 stopUpd:)
					((ScriptID 455 3) hide: forceUpd:) ; ogreLegs
				)
				(if (== global279 450)
					((ScriptID 450 3) cel: 0 x: 182 y: 91 show: forceUpd:) ; trollLegs
					((local1 opponent:)
						x: 182
						y: 91
						setLoop: 1
						setCel: 0
						stopUpd:
					)
				)
				(= ticks 1)
			)
			(6
				(local6 dispose:)
				((ScriptID 425 3) x: 500 y: 500 setCycle: 0 forceUpd:) ; ball
				(SetFlag 285)
				(if (== global279 455)
					((ScriptID 455 3) ; ogreLegs
						loop: 2
						cel: 0
						x: 166
						y: 88
						show:
						forceUpd:
					)
					((local1 opponent:) loop: 1 x: 165 y: 80 setCel: 0 stopUpd:)
				)
				(if (or (== global279 445) (== global279 465))
					((local1 opponent:) cycleSpeed: 6)
				else
					((local1 opponent:) cycleSpeed: 23)
				)
				(monHurt play:)
				((local1 opponent:) setLoop: 1 setCel: 0 setCycle: End self)
			)
			(7
				((local1 opponent:) getHurt: (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
				((local1 opponent:) setMonsterHP: ((local1 opponent:) health:))
				(Animate (gCast elements:) 0)
				(if (<= ((local1 opponent:) health:) 0)
					((local1 opponent:) die:)
				)
				(if
					(and
						(or (== global279 445) (== global279 465))
						(<= ((local1 opponent:) health:) 0)
					)
					((local1 opponent:) setScript: (ScriptID global279 3))
				else
					((ScriptID global279 0) inTransit: 0)
					((local1 opponent:) setScript: (ScriptID global279 2))
				)
				(local1 canFight: 1 view: 102 setCel: 0 setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoZap of Script
	(properties)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(local1
					canFight: 0
					action: 11
					view: 108
					loop: 0
					cel: 0
					forceUpd:
					setPri: 15
				)
				(local1 setCycle: End self)
			)
			(1
				(= ticks 1)
			)
			(2
				(local1 canFight: 1 view: 102 cel: 0 forceUpd: setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance egoDazzle of Script
	(properties)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 canFight: 0 action: 11 view: 107 setCel: 0 setPri: 15)
				(local1 setCycle: End self)
			)
			(1
				(= ticks 15)
			)
			(2
				(local1 setLoop: 0 setCel: 0 setPri: -1)
				(local6
					view: 535
					setLoop: 5
					cel: 0
					setPri: 15
					cycleSpeed: 6
					ignoreActors:
					posn: (+ (local1 x:) 35) (- (local1 y:) 60)
					init:
					setCycle: End self
				)
			)
			(3
				(local6 dispose:)
				(SetFlag 233)
				(= global230 [gEgoStats 20]) ; dazzleSpell
				(local1 canFight: 1 action: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoThrust of Script
	(properties)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 getTired: 4 setCel: 0 canFight: 0 action: 1)
				(if
					(and
						local18
						(or (== global279 450) (== global279 435))
						(== local5 2)
					)
					(local1 view: 114)
				else
					(if (gEgo has: 2) ; sword
						(local1 view: (if (== local5 2) 110 else 109))
					else
						(local1 view: (if (== local5 2) 103 else 102))
					)
					(if (!= local5 2)
						(local1 setCel: 1)
					)
				)
				(= register 0)
				((ScriptID global279 0) inTransit: 1)
				(= global245 0)
				(TrySkill 5 0 0) ; weapon-use
				(= local9 (local1 tryAttack: (local1 opponent:)))
				(if
					(and
						(or
							(== global279 425)
							(== global279 465)
							(== global279 435)
							(== global279 445)
							(== global279 450)
							(== global279 440)
							(== global279 455)
							(== global279 420)
						)
						(== ((local1 opponent:) action:) 3)
					)
					(= local9 0)
				)
				(if local9
					(blood init: posn: 500 500 stopUpd:)
					(zapCrap init: posn: 500 500 stopUpd:)
					((local1 opponent:) setCycle: 0 setScript: 0 stopUpd:)
					(local1 doDamage: (local1 opponent:) global229)
					(switch global279
						(440
							((local1 opponent:)
								view: 442
								setLoop: 1
								setCel: 0
								stopUpd:
							)
						)
						(430
							(if (Random 0 1)
								((local1 opponent:)
									setLoop: 0
									setCel: 1
									stopUpd:
								)
							else
								((local1 opponent:)
									setLoop: 0
									setCel: 7
									stopUpd:
								)
							)
						)
						(445
							((local1 opponent:) setLoop: 1 setCel: 0 stopUpd:)
						)
						(450
							((ScriptID 450 3) ; trollLegs
								x: 182
								y: 91
								show:
								setCel: 0
								stopUpd:
							)
							((local1 opponent:)
								x: 182
								y: 91
								setLoop: 1
								setCel: 0
								stopUpd:
							)
						)
						(460
							(if (Random 0 1)
								((local1 opponent:)
									setLoop: 0
									setCel: 2
									stopUpd:
								)
							else
								((local1 opponent:)
									setLoop: 0
									setCel: 7
									stopUpd:
								)
							)
						)
						(420
							(cond
								((== local5 1)
									(if local18
										((local1 opponent:)
											setLoop: 0
											setCel: 2
											stopUpd:
										)
									else
										((local1 opponent:)
											setLoop: 0
											setCel: 3
											stopUpd:
										)
									)
								)
								((not local18)
									((local1 opponent:)
										setLoop: 0
										setCel: 2
										stopUpd:
									)
								)
							)
						)
					)
				else
					(if (and (!= global279 435) (IsFlag 284))
						(= local17 1)
						((local1 opponent:) setCycle: 0 setScript: 0 stopUpd:)
					)
					(if local17
						(switch global279
							(425
								((ScriptID 425 3) ; ball
									x: 500
									y: 500
									setCycle: 0
									forceUpd:
								)
								((local1 opponent:)
									setLoop: 0
									setCel: 4
									stopUpd:
								)
							)
							(440
								((local1 opponent:)
									view: 444
									setLoop: 0
									setCel: 1
									stopUpd:
								)
							)
							(430
								(if local17
									((local1 opponent:)
										setLoop: 0
										setCel: 0
										stopUpd:
									)
								)
							)
							(445
								((local1 opponent:)
									setLoop: 2
									setCel: 4
									stopUpd:
								)
							)
							(465
								((local1 opponent:)
									setLoop: 3
									setCel: 2
									stopUpd:
								)
							)
							(420
								(if local17
									(cond
										((and (== local5 2) local18)
											((local1 opponent:)
												setLoop: 0
												setCel: 2
												stopUpd:
											)
										)
										((Random 0 1)
											((local1 opponent:)
												setLoop: 0
												setCel: 0
												stopUpd:
											)
										)
										(else
											((local1 opponent:)
												setLoop: 0
												setCel: 1
												stopUpd:
											)
										)
									)
								)
							)
						)
					)
					(SetFlag 357)
				)
				((ScriptID 425 3) x: 500 y: 500 setCycle: 0 forceUpd:) ; ball
				(if
					(and
						(== global279 455)
						(== ((local1 opponent:) loop:) 0)
						(== local5 2)
						local18
					)
					(= register 1)
					(local1 setPri: 1 setCycle: CT 1 1 self)
					((local1 opponent:) setCycle: 0 setScript: 0 setCel: 0)
				else
					(if local9
						(local1 setPri: 15)
					else
						(if (== global279 450)
							(local1 setPri: 1)
						)
						(if (== global279 440)
							(local1 setPri: 15)
						)
					)
					(if (and (== local5 2) (gEgo has: 2)) ; sword
						(local1 setCycle: CT 2 1 self)
					else
						(local1 setCycle: CT 3 1 self)
					)
				)
			)
			(1
				(cond
					(register
						(= ticks 1)
					)
					(local9
						(cond
							((== global279 455)
								(= ticks 45)
							)
							((== global279 420)
								(= ticks 25)
							)
							(else
								(= ticks 1)
							)
						)
						(blood setPri: 15 ignoreActors: setCel: 0)
						(zapCrap setPri: 15 ignoreActors: setCel: 0)
						(monHurt play:)
						(if (== local5 2)
							(if local18
								(if (or (== global279 450) (== global279 435))
									(blood
										x: (+ (local1 x:) 53)
										y: (- (local1 y:) 81)
									)
								else
									(blood
										x: (+ (local1 x:) 64)
										y: (- (local1 y:) 64)
									)
								)
							else
								(blood
									x: (+ (local1 x:) 43)
									y: (- (local1 y:) 70)
								)
								(if global229
									(zapCrap
										x: (+ (local1 x:) 43)
										y: (- (local1 y:) 70)
										setCycle: End
									)
								)
							)
							(blood setLoop: 2 setCycle: End)
						else
							(if local18
								(blood
									x: (+ (local1 x:) 42)
									y: (- (local1 y:) 65)
								)
							else
								(blood
									x: (+ (local1 x:) 32)
									y: (- (local1 y:) 56)
								)
								(if global229
									(zapCrap
										x: (+ (local1 x:) 32)
										y: (- (local1 y:) 56)
										setCycle: End
									)
								)
							)
							(blood setLoop: 1 setCycle: End)
						)
						(= global229 0)
					)
					(else
						(= ticks 8)
					)
				)
			)
			(2
				(local1 setCycle: End self)
				(if local9
					(SetFlag 285)
					(if (== global279 455)
						((ScriptID 455 3) ; ogreLegs
							loop: 2
							cel: 0
							x: 166
							y: 88
							show:
							forceUpd:
						)
						((local1 opponent:)
							loop: 1
							cel: 0
							x: 165
							y: 80
							forceUpd:
						)
					)
					(if (or (== global279 445) (== global279 465))
						((local1 opponent:) cycleSpeed: 6)
					else
						((local1 opponent:) cycleSpeed: 23)
					)
					((local1 opponent:) loop: 1 cel: 0 setCycle: End self)
				else
					(if local17
						(switch global279
							(425
								((local1 opponent:)
									setLoop: 0
									setCel: 3
									stopUpd:
								)
							)
							(440
								((local1 opponent:)
									view: 444
									setLoop: 0
									setCel: 2
									stopUpd:
								)
							)
							(430
								(if local17
									((local1 opponent:)
										setLoop: 0
										setCel: 1
										stopUpd:
									)
								)
							)
							(445
								((local1 opponent:)
									setLoop: 2
									setCel: 5
									stopUpd:
								)
							)
							(465
								((local1 opponent:)
									setLoop: 3
									setCel: 3
									stopUpd:
								)
							)
							(460
								(if local17
									((local1 opponent:)
										setLoop: 0
										setCel: 0
										stopUpd:
									)
								)
							)
						)
					)
					(self cue:)
				)
			)
			(3
				(if (not (local1 cycler:))
					(if local18
						(local1 view: 109 setCel: 0 stopUpd:)
					else
						(local1 view: 102 setCel: 0 stopUpd:)
					)
				)
			)
			(4
				(if local18
					(local1 view: 109 setCel: 0 stopUpd:)
				else
					(local1 view: 102 setCel: 0 stopUpd:)
				)
				(= ticks 15)
			)
			(5
				(zapCrap dispose:)
				(blood dispose:)
				(if local9
					((local1 opponent:)
						setMonsterHP: ((local1 opponent:) health:)
					)
					(if (<= ((local1 opponent:) health:) 0)
						((local1 opponent:) die:)
					)
				)
				(if local18
					(local1 view: 109)
				)
				(cond
					((or (== global279 450) (== global279 455))
						(if (or local17 local9)
							((local1 opponent:)
								setScript: (ScriptID global279 2)
							)
							(= local17 0)
						)
						((ScriptID global279 0) inTransit: 0)
					)
					(
						(and
							(or (== global279 445) (== global279 465))
							(<= ((local1 opponent:) health:) 0)
						)
						((local1 opponent:) setScript: (ScriptID global279 3))
					)
					((and (== global279 435) (not local9))
						((ScriptID global279 0) inTransit: 0)
					)
					(else
						(if (not ((local1 opponent:) script:))
							(= local17 0)
							((local1 opponent:)
								setScript: (ScriptID global279 2)
							)
						)
						((ScriptID global279 0) inTransit: 0)
					)
				)
				(= local9 0)
				(ClearFlag 233)
				(ClearFlag 357)
				(local1 canFight: 1)
				(= global245 1)
				(self dispose:)
			)
		)
	)
)

(instance egoBlock of Script
	(properties)

	(method (init)
		(= local16 1)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global245 0)
				(if local18
					(local1 view: 111)
				else
					(local1 view: 104)
				)
				(local1 getTired: 1 canFight: 0 action: 3 setCel: 0)
				(TrySkill 6 0 20) ; parry
				(if ((local1 opponent:) ateEgo:)
					(self dispose:)
				)
				(if (and (or (== global279 455) (== global279 450)) local18)
					(local1 view: 115 loop: 0 forceUpd: setCycle: CT 2 1)
					(= ticks 80)
				else
					(= ticks 1)
				)
			)
			(1
				(local1 setCycle: End self)
			)
			(2
				(= ticks 12)
			)
			(3
				(if (and (or (== global279 455) (== global279 450)) local18)
					(local1 view: 109 forceUpd:)
				)
				(local1 setCel: 0 stopUpd:)
				(= global245 1)
				(self dispose:)
			)
		)
	)
)

(instance egoParry of Script ; UNUSED
	(properties)

	(method (init)
		(= local16 1)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global245 0)
				(TrySkill 6 0 20) ; parry
				(local1
					getTired: 1
					canFight: 0
					action: 3
					setLoop: 4
					setCel: 0
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(local1 setCel: 1)
				(= cycles 7)
			)
			(2
				(local1 setCel: 0)
				(= cycles 1)
			)
			(3
				(local1 cel: 0 setLoop: 2 stopUpd:)
				(= global245 1)
				(self dispose:)
			)
		)
	)
)

(instance egoDodge of Script
	(properties)

	(method (init)
		(= local16 1)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (doit)
		(if ((local1 opponent:) ateEgo:)
			(local1 setCycle: 0 setCycle: CT 0 -1)
			(self dispose:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global245 0)
				(TrySkill 7 0 20) ; dodge
				(cond
					((and local18 (or (== global279 450) (== global279 455)))
						(local1 view: 116 setLoop: 0)
					)
					(local18
						(local1 view: 112 setLoop: 0)
					)
					(else
						(local1 view: 105)
					)
				)
				(if local18
					(local1 setCel: 1)
				)
				(local1
					getTired: 2
					canFight: 0
					action: (if (== register 0) 5 else 6)
					setCel: 0
				)
				(local1 setCycle: End self)
			)
			(1
				(= ticks 12)
			)
			(2
				(if (== (local1 view:) 110)
					(local1 view: 109)
				)
				(local1 setCel: 0 stopUpd:)
				(= global245 1)
				(self dispose:)
			)
		)
	)
)

(instance painReaction of Script ; UNUSED
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global245 0)
				(= ticks 1)
			)
			(1
				(if (IsFlag 248)
					(= ticks 1)
				)
				(= global245 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dodgeLIcon of View
	(properties
		x 246
		y 175
		view 945
		cel 4
	)
)

(instance dodgeRIcon of View
	(properties
		x 282
		y 175
		view 945
		cel 5
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
		(gGame setCursor: gNormalCursor 1)
		(super dispose:)
	)

	(method (init)
		(gTheIconBar disable:)
		(gGame setCursor: gNormalCursor 1 280 155)
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
		y 175
		view 945
		loop 2
		value 1000
	)
)

(instance findPenalty of Code ; UNUSED
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 (GetTime))
		(= local15
			(cond
				((< (= temp1 (Abs (- temp0 local14))) 180) 50)
				((< temp1 240) 40)
				((< temp1 300) 30)
				((< temp1 360) 20)
				((< temp1 420) 10)
				(else 0)
			)
		)
		(if local16
			(= local15 0)
		)
		(= local16 0)
		(= local14 temp0)
	)
)

(instance switchLoop of Code
	(properties)

	(method (doit)
		(if local10
			(pointBox setLoop: 2)
			(if (not (gEgo has: 2)) ; sword
				(dodgeRIcon show: forceUpd: stopUpd:)
				(dodgeLIcon show: forceUpd: stopUpd:)
			)
			(= local10 0)
		else
			(pointBox setLoop: 3)
			(if (not (gEgo has: 2)) ; sword
				(dodgeRIcon hide: forceUpd: stopUpd:)
				(dodgeLIcon hide: forceUpd: stopUpd:)
			)
			(= local10 1)
		)
	)
)

(instance blood of Prop
	(properties
		cycleSpeed 3
	)
)

(instance zapCrap of Prop
	(properties
		view 535
		loop 7
		cycleSpeed 3
	)
)

