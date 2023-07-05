;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use LoadMany)
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
)

(instance aSpell of Prop
	(properties)
)

(instance closeCombat of Script
	(properties)

	(method (init)
		(LoadMany rsSCRIPT 151 152 153 154 155)
		(if (gEgo has: 9) ; shield
			(Load rsVIEW 540)
		else
			(LoadMany rsSCRIPT 146 147 148 149 150)
			(Load rsVIEW 535)
			(aSpell view: 535)
		)
		(= global266 1)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (or (not (client canFight:)) (not global266))
			(event claimed: 1)
			(while ((= temp3 (Event new: 71)) type:)
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
					((Said 'look')
						(HighPrint 215 0) ; "Quit sightseeing and watch what you're doing!"
					)
					((Said 'escape,escape,run')
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
								(self setScript: (ScriptID 146 0) self local0) ; doSpell
							)
						)
					)
					(
						(or
							(Said 'fight,kill,hit,cut')
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
						(self setScript: (ScriptID 151 0) self local5) ; egoThrust
					)
					(JOY_LEFT
						(= local5 0)
						(self setScript: (ScriptID 154 0) self local5) ; egoDodge
					)
					(JOY_RIGHT
						(= local5 1)
						(self setScript: (ScriptID 154 0) self local5) ; egoDodge
					)
					(JOY_DOWN
						(= local5 2)
						(cond
							(local3
								(self setScript: (ScriptID 152 0) self local5) ; egoBlock
							)
							((not (gEgo has: 6)) ; blade
								(self setScript: (ScriptID 153 0) self local5) ; egoParry
							)
							(else
								(= local5 (Random 0 1))
								(self setScript: (ScriptID 154 0) self local5) ; egoDodge
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

