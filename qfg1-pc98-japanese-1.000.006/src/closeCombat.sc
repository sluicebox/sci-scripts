;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	closeCombat 0
	aSpell 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 2
	local6
	local7
	local8
	local9
)

(instance aSpell of Prop
	(properties)
)

(instance closeCombat of Script
	(properties)

	(method (init)
		(if (gEgo has: 9) ; shield
			(Load rsVIEW 540)
		else
			(Load rsVIEW 535)
			(aSpell view: 535)
		)
		(= global266 1)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (or (not (client canFight:)) (not global266))
			(event claimed: 1)
			(while ((= temp3 (Event new: $0047)) type:) ; direction | evMOUSEKEYBOARD | evMOUSERELEASE
				(temp3 dispose:)
			)
			(temp3 dispose:)
			(return 1)
		)
		(if script
			(if (and (== (event type:) $0040) (!= (event message:) JOY_UP)) ; direction
				(script cue:)
			else
				(event claimed: 1)
				(return)
			)
		)
		(switch (event type:)
			(evSAID
				(clr)
				(cond
					((super handleEvent: event))
					((Said 'look,look')
						(HighPrint 215 0) ; "Quit sightseeing and watch what you're doing!"
					)
					((or (Said 'escape,escape') (Said 'run[/!*]'))
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
							(HighPrint 215 1) ; "You cannot escape this encounter."
						else
							((ScriptID gCurRoomNum) escaped: 1)
						)
					)
					((Said 'cast>')
						(cond
							((not (= local0 (SaidSpell event)))
								(HighPrint 215 2) ; "That isn't a known spell."
							)
							(local3
								(HighPrint 215 3) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
							)
							(
								(and
									(!= local0 23)
									(!= local0 21)
									(!= local0 20)
									(!= local0 22)
								)
								(HighPrint 215 4) ; "This might not be the best time for practicing non-combat spells."
							)
							((CastSpell local0)
								(client setEgoMP: [gEgoStats 16]) ; mana
								(HandsOff)
								(self setScript: doSpell self local0)
							)
						)
					)
					(
						(or
							(Said 'attack,kill,hit,cut,chop')
							(Said 'use/blade,dagger,weapon,shield')
						)
						(HighPrint 215 5) ; "Go ahead!"
					)
					((Said 'throw')
						(HighPrint 215 6) ; "You're too close."
					)
					(else
						(HighPrint 215 7) ; "You don't have time for that."
						(event claimed: 1)
					)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event x:))
				(= temp1 (event y:))
				(event claimed: 1)
			)
			($0040 ; direction
				(HandsOff)
				(switch (event message:)
					(JOY_UP
						(= local5 2)
						(self setScript: egoThrust self local5)
					)
					(JOY_LEFT
						(= local5 0)
						(self setScript: egoDodge self local5)
					)
					(JOY_RIGHT
						(= local5 1)
						(self setScript: egoDodge self local5)
					)
					(JOY_DOWN
						(= local5 2)
						(cond
							(local3
								(self setScript: egoBlock self local5)
							)
							((not (gEgo has: 6)) ; blade
								(self setScript: egoParry self local5)
							)
							(else
								(= local5 (Random 0 1))
								(self setScript: egoDodge self local5)
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
				(= local3 (local1 egoShield:))
				(= local2 (local1 egoHand:))
				(= local4 (local1 egosBack:))
				(gDirHandler addToFront: client)
				(gMouseHandler addToFront: client)
				(if (and (local1 noWeapon:) (not local3))
					(local2 setLoop: 1 setCel: 2)
				)
				(= cycles 1)
			)
			(1
				(if (local1 noWeapon:)
					(self changeState: 3)
				else
					(client
						canFight: 1
						action: 0
						cycleSpeed: 0
						moveSpeed: 0
						view: (local1 weaponView:)
						setLoop: 2
						cel: 0
						stopUpd:
					)
				)
			)
			(2
				(HandsOn)
				(self changeState: 1)
			)
			(3
				(EgoDead ; "Caught in combat with neither sword nor dagger, you are unable to resist the monster's fierce onslaught. Try to be better equipped in your next life."
					215
					8
					80
					{Bare Hands vs. Teeth and Claws, etc.}
					82
					516
					0
					9
				)
			)
		)
	)
)

(instance doSpell of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local2 ((ScriptID 213 0) egoHand:)) ; warrior
		(= local4 ((ScriptID 213 0) egosBack:)) ; warrior
		(= local3 ((ScriptID 213 0) egoShield:)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(local2 setCycle: End self)
			)
			(1
				(switch register
					(23
						(self setScript: egoFlame self)
					)
					(21
						(self setScript: egoZap self)
					)
					(20
						(self setScript: egoDazzle self)
					)
					(22
						(self setScript: egoCalm self)
					)
				)
			)
			(2
				(= register 0)
				(local2 setCycle: Beg self)
			)
			(3
				(local2 stopUpd:)
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

(instance egoFlame of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(local1 canFight: 0 action: 11)
				(self cue:)
			)
			(1
				(local6
					setLoop: 6
					setCel: 0
					cycleSpeed: 1
					ignoreActors:
					posn: (- (local1 x:) 77) (- (local1 y:) 87)
					init:
					setCycle: CT 2 1 self
				)
			)
			(2
				(= local7 (/ (- ((local1 opponent:) flameX:) (local6 x:)) 3))
				(= local8 (/ (- (local6 y:) ((local1 opponent:) flameY:)) 3))
				(local6
					setPri: 15
					setCel: 3
					posn: (+ (local6 x:) local7) (- (local6 y:) local8)
				)
				(= cycles 2)
			)
			(3
				(local6
					setCel: 4
					posn: (+ (local6 x:) local7) (- (local6 y:) local8)
				)
				(= cycles 2)
			)
			(4
				(local6
					setCel: 5
					posn: (+ (local6 x:) local7) (+ (local6 y:) local8)
				)
				(= cycles 2)
			)
			(5
				(local6 setCel: -1 setCycle: End self)
			)
			(6
				(local6 dispose:)
				((local1 opponent:) getHurt: (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
				(local1 canFight: 1 show:)
				(self dispose:)
			)
		)
	)
)

(instance egoZap of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global250 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(local1 canFight: 0 action: 11 setCel: 2)
				(= cycles 1)
			)
			(1
				(local6
					setLoop: 7
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					posn: (- (local1 x:) 7) (- (local1 y:) 70)
					setPri: (+ (local1 priority:) 1)
					init:
					setCycle: End self
				)
			)
			(2
				(local6 dispose:)
				(local1 canFight: 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoDazzle of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local6 (ScriptID 215 1)) ; aSpell
		(= local2 (local1 egoHand:))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 canFight: 0 action: 11)
				(self cue:)
			)
			(1
				(local6
					setLoop: 5
					cel: 0
					setPri: (- (local2 priority:) 1)
					cycleSpeed: 1
					ignoreActors:
					posn: (- (local1 x:) 78) (- (local1 y:) 81)
					init:
					setCycle: End self
				)
			)
			(2
				(local6 dispose:)
				(SetFlag 233)
				(= global251 [gEgoStats 20]) ; dazzleSpell
				(local1 canFight: 1 action: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoCalm of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 215 9) ; "Confidently, you cast the Calm spell."
				(EgoDead ; "Why, how cute! You cast the Calm spell, and the monster visibly relaxed. Why, now it's calmly and relaxedly ripping you to shreds and eating you."
					215
					10
					80
					{You should have studied harder}
					82
					521
					1
					4
				)
			)
		)
	)
)

(instance egoThrust of Script
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
				(= global266 0)
				(TrySkill 5 0 0) ; weapon-use
				(= local9 (local1 tryAttack: (local1 opponent:)))
				(if
					(and
						(or (== global332 425) (== global332 465))
						(== ((local1 opponent:) action:) 3)
					)
					(= local9 0)
				)
				(if local9
					(if
						(or
							(== global332 440)
							(== global332 420)
							(== global332 430)
							(== global332 425)
							(== global332 465)
						)
						(= register 3)
					)
					(local1
						getTired: 4
						canFight: 0
						action: 1
						setLoop: register
						setPri: (if (== global332 435) 1 else 9)
						setCel: 1
					)
				)
				(= cycles 8)
			)
			(1
				(if local9
					(= local9 0)
					(local1 doDamage: (local1 opponent:) global250)
					(= global250 0)
				)
				(local1 setPri: 11 setLoop: register setCycle: CT 0 1 self)
			)
			(2
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

(instance egoBlock of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local3 (local1 egoShield:))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 6 0 20) ; parry
				(local1
					getTired: 1
					canFight: 0
					action: 3
					posn: (local1 baseX:) (+ (local1 baseY:) 5)
					stopUpd:
				)
				(local3 setCel: 2 posn: (+ (local3 x:) 22) (- (local3 y:) 10))
				(= cycles 2)
			)
			(1
				(= cycles 6)
			)
			(2
				(local3 setCel: 0 posn: (- (local1 baseX:) 74) (local1 baseY:))
				(= cycles 4)
			)
			(3
				(local3 stopUpd:)
				(local1 posn: (local1 baseX:) (local1 baseY:))
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

(instance egoParry of Script
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
				(= global266 0)
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
				(local1 posn: (local1 baseX:) (local1 baseY:) setLoop: 2 cel: 0)
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

(instance egoDodge of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local3 (local1 egoShield:))
		(= local2 (local1 egoHand:))
		(= local4 (local1 egosBack:))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 7 0 20) ; dodge
				(local1
					getTired: 2
					canFight: 0
					action: (if (== register 0) 5 else 6)
				)
				(if local3
					(switch register
						(0
							(local3 posn: (- (local3 x:) 25) (- (local3 y:) 5))
						)
						(1
							(local3 posn: (+ (local3 x:) 40) (- (local3 y:) 5))
						)
					)
				else
					(switch register
						(0
							(local2 posn: (- (local2 x:) 38) (+ (local2 y:) 5))
						)
						(1
							(local2 posn: (+ (local2 x:) 46) (+ (local2 y:) 5))
						)
					)
				)
				(switch register
					(0
						(local1 posn: (- (local1 x:) 41) (+ (local1 y:) 5))
						(local4 posn: (- (local4 x:) 40) (+ (local4 y:) 5))
					)
					(1
						(local1 posn: (+ (local1 x:) 42) (+ (local1 y:) 5))
						(local4 posn: (+ (local4 x:) 40) (+ (local4 y:) 5))
					)
				)
				(= cycles 7)
			)
			(1
				(local1 posn: (local1 baseX:) (local1 baseY:))
				(if local3
					(local3 posn: (- (local1 baseX:) 74) (local1 baseY:))
				else
					(local2 posn: (- (local1 baseX:) 74) (local1 baseY:))
				)
				(local4 posn: (- (local1 baseX:) 41) (local1 baseY:))
				(self cue:)
			)
			(2
				(= global266 1)
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
		(= local2 ((ScriptID 213 0) egoHand:)) ; warrior
		(= local4 ((ScriptID 213 0) egosBack:)) ; warrior
		(= local3 ((ScriptID 213 0) egoShield:)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(local4 posn: (- (local4 x:) 3) (+ (local4 y:) 5))
				(local1 posn: (- (local1 x:) 3) (+ (local1 y:) 5))
				(if local3
					(local3 posn: (- (local3 x:) 5) (+ (local3 y:) 10))
				else
					(local2 posn: (- (local2 x:) 5) (+ (local2 y:) 10))
				)
				(= cycles 3)
			)
			(1
				(if (IsFlag 248)
					(EgoDead ; "It was a tough battle, and you lost. Never fear! All you have to do is restore your game, and... What do you mean, "Restore WHAT game?""
						215
						11
						80
						{What a monster!}
						82
						516
						0
						9
					)
				else
					(local4 posn: (- (local1 baseX:) 41) (local1 baseY:))
					(local1 posn: (local1 baseX:) (local1 baseY:))
					(if local3
						(local3 posn: (- (local1 baseX:) 74) (local1 baseY:))
					else
						(local2 posn: (- (local1 baseX:) 73) (local1 baseY:))
					)
					(= cycles 1)
				)
				(= global266 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

