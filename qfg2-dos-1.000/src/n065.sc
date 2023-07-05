;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use ProjClient)
(use SpellScript)
(use System)

(public
	SaidSpell 0
	TrySpell 1
	CastSpell 2
	ThrowObj 3
)

(local
	[thingInvs 6] = [32 51 39 9 5 16]
	[thingNames 6] = [{any dirt} {any sand} {any powder} {a rock} {a throwing knife} {the rope}]
	[spellNames 13] = ['/open,open,(spell<open,open)' '/detect,(spell,magic<detect),(spell<magic<detect)' '/trigger,(spell<trigger)' '/dazzle,(spell<dazzle)' '/zap,(spell<zap)' '/calm,(spell<calm)' '/flame,fire,dart,fireball,(spell<flame,fire,dart,fireball)' '/fetch,(spell<fetch)' '/force,bolt,(spell<force,bolt)' '/levitate,fly,(spell<levitate,fly)' '/reversal,reflection,mirror,(spell<reversal,reflection,mirror)' 0 0]
)

(procedure (SaidSpell event &tmp index obj)
	(for ((= index 0)) (< index 11) ((++ index))
		(if (Said [spellNames index])
			(break)
		)
	)
	(if (>= index 11)
		(event claimed: 1)
		(= index 0)
	else
		(+= index 19)
	)
	(return index)
)

(procedure (TrySpell spellNum &tmp spellObj retVal)
	(= retVal 0)
	(cond
		((not spellNum)
			(HighPrint 65 0) ; "That isn't a spell."
		)
		((not [gEgoStats 12]) ; magic use
			(HighPrint 65 1) ; "You don't know how to cast spells."
		)
		((not (gEgo knows: spellNum))
			(HighPrint 65 2) ; "You don't know that spell."
		)
		((and gSpellChecker (not (gSpellChecker doit: spellNum))))
		((< [gEgoStats 18] [gSpCostOpen (- spellNum 19)]) ; mana
			(HighPrint 65 3) ; "You don't have enough Magic Points to cast that spell."
		)
		(else
			(TrySkill spellNum 0)
			(UseMana [gSpCostOpen (- spellNum 19)])
			(= retVal 1)
		)
	)
	(return retVal)
)

(procedure (CastSpell prType owner whoCares prHitBonus prDamageBonus &tmp theHitBonus theDamage prScript [str 40])
	(= theDamage (= theHitBonus 0))
	(if (>= argc 3)
		(= theHitBonus prHitBonus)
		(if (>= argc 4)
			(= theDamage prDamageBonus)
		)
	)
	(if (== gCurRoomNum 640)
		(+= theHitBonus 200)
	)
	(cond
		((not (OneOf prType 1 2 3 4 5 6))
			(if (not (TrySpell prType))
				(return 0)
			)
		)
		((and gSpellChecker (not (gSpellChecker doit: prType)))
			(return 0)
		)
		((not (gEgo has: [thingInvs (- prType 1)]))
			(HighPrint (Format @str 65 4 [thingNames (- prType 1)])) ; "That's hard to do without %s."
			(return 0)
		)
		((== prType 1)
			(if (< gClumpsLeft 10)
				(HighPrint 65 5) ; "Uh oh! Your pot is empty."
				(return 0)
			else
				(-= gClumpsLeft 10)
			)
		)
		((== prType 2)
			(if (not (mod gClumpsLeft 10))
				(HighPrint 65 6) ; "You suddenly realize that even the largest sandbag is not infinite in capacity. You've run out of sand."
				(return 0)
			else
				(-- gClumpsLeft)
			)
		)
		((== prType 3)
			(if (not (gEgo has: 39)) ; BurningPowder
				(HighPrint 65 7) ; "You have no more powder."
				(return 0)
			else
				(gEgo use: 39) ; BurningPowder
			)
		)
		((== prType 6)
			(cond
				((and (!= gCurRoomNum 390) (NoRoom 15 (gEgo illegalBits:)))
					(HighPrint 65 8) ; "Give yourself a little room, Hero."
					(return 0)
				)
				((gEgo script:)
					(HighPrint 65 9) ; "Not now!"
					(return 0)
				)
				(else
					(if (== gRopeUses 10)
						(HighPrint 65 10) ; "Your rope is beginning to feel limp. Perhaps its magical power is limited."
					)
					(if (== gRopeUses 1)
						(HighPrint 65 11) ; "Your rope is so limp that you don't know if it will rise for you at all. It's magic has been drained."
					)
					(owner setScript: (ScriptID 61 2) whoCares) ; ropeClimb
					(return 1)
				)
			)
		)
		(else
			(gEgo use: [thingInvs (- prType 1)])
		)
	)
	(if
		(and
			(OneOf prType 20 24 22)
			(== (gCurRoom picture:) 700)
			(NoRoom 6 (gEgo illegalBits:))
		)
		(HighPrint 65 8) ; "Give yourself a little room, Hero."
		(return 0)
	)
	(switch prType
		(28
			(if (and (!= gCurRoomNum 390) (NoRoom 15 (gEgo illegalBits:)))
				(HighPrint 65 8) ; "Give yourself a little room, Hero."
				(return 0)
			else
				(owner setScript: (ScriptID 62 0) whoCares) ; levitate
				(return 1)
			)
		)
		(4
			(++ theDamage)
		)
		(5
			(+= theDamage (+ 5 (/ [gEgoStats 0] 10))) ; strength
		)
		(25
			(+= theDamage (+ 5 (/ [gEgoStats 25] 3))) ; flameDartSpell
		)
		(27
			(+= theDamage (+ 3 (/ [gEgoStats 27] 4))) ; forceBoltSpell
		)
	)
	(if (OneOf prType 20 23 24 22 29)
		((= prScript (SpellScript new:)) type: prType)
	else
		((= prScript (ProjScript new:)) type: prType hitBonus: theHitBonus damage: theDamage)
	)
	(owner setScript: prScript whoCares)
	(return 1)
)

(procedure (ThrowObj)
	(CastSpell &rest)
)

