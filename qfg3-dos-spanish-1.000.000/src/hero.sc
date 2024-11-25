;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use n026)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Ego)
(use Sound)
(use Motion)
(use System)

(public
	hero 0
	stopGroop 1
)

(procedure (localproc_0 param1 param2)
	(if
		(and
			(< param1 param2)
			(>=
				(cond
					(
						(<
							(if global404
								(- [gEgoStats 14] global404) ; honor
							)
							0
						)
						0
					)
					(global404
						(- [gEgoStats 14] global404) ; honor
					)
				)
				param2
			)
		)
		(return 1)
	)
	(if
		(and
			(>= param1 param2)
			(<
				(cond
					(
						(<
							(if global404
								(- [gEgoStats 14] global404) ; honor
							)
							0
						)
						0
					)
					(global404
						(- [gEgoStats 14] global404) ; honor
					)
				)
				param2
			)
		)
		(return -1)
	)
	(return 0)
)

(class hero of Ego
	(properties
		noun 2
		modNum 28
		sightAngle 90
	)

	(method (facingMe)
		(return 1)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 0)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 $0040) ; direction
				(if (and (== (= temp0 temp2) JOY_NULL) (& temp1 evKEYBOARD))
					(event claimed:)
					(return)
				)
				(if
					(and
						(& temp1 evKEYBOARD)
						(== temp0 (gUser prevDir:))
						(IsObject mover)
					)
					(= temp0 JOY_NULL)
				)
				(gUser prevDir: temp0)
				(self setDirection: temp0)
				(= temp4 1)
			)
			((& temp1 evVERB)
				(if (& temp1 evMOVE)
					(if (and (self mover:) (OneOf gCurRoomNum 150 160 170 180))
						(= temp3 ((self mover:) caller:))
					else
						(= temp3 0)
					)
					(switch gUseObstacles
						(0
							(self
								setMotion:
									MoveTo
									(event x:)
									(+ (event y:) z)
									temp3
							)
						)
						(1
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
									temp3
							)
						)
						(2
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
									0
									0
							)
						)
					)
					(gUser prevDir: 0)
					(= temp4 1)
				else
					(= temp4 (super handleEvent: event))
				)
			)
			(else
				(= temp4 (super handleEvent: event))
			)
		)
		(return temp4)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 2)
		(= temp1 theVerb)
		(= temp2 0)
		(= temp3 28)
		(switch theVerb
			(22 ; theHealPills
				(if (< [gEgoStats 16] (self maxHealth:)) ; health
					(if (IsFlag 115)
						(ClearFlag 115)
						(gEgo takeDamage: (- (/ (self maxHealth:) 3)))
						(SetFlag 115)
					else
						(gEgo takeDamage: (- (/ (self maxHealth:) 3)))
					)
					(if (> ((gInventory at: 12) amount:) 1) ; theHealPills
						((gInventory at: 12) ; theHealPills
							amount: (- ((gInventory at: 12) amount:) 1) ; theHealPills
						)
					else
						((gInventory at: 12) amount: 0 owner: 0 realOwner: 0) ; theHealPills
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(= temp2 9)
				else
					(= temp1 0)
					(= temp2 11)
				)
			)
			(23 ; theManaPills
				(if (< [gEgoStats 18] (gEgo maxMana:)) ; mana
					(gEgo useMana: (- (/ (gEgo maxMana:) 3)))
					(if (> ((gInventory at: 13) amount:) 1) ; theManaPills
						((gInventory at: 13) ; theManaPills
							amount: (- ((gInventory at: 13) amount:) 1) ; theManaPills
						)
					else
						((gInventory at: 13) amount: 0 owner: 0 realOwner: 0) ; theManaPills
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(= temp2 9)
				else
					(= temp1 0)
					(= temp2 11)
				)
			)
			(21 ; theCurePills
				(if (IsFlag 115)
					(ClearFlag 115)
					(if (> ((gInventory at: 11) amount:) 1) ; theCurePills
						((gInventory at: 11) ; theCurePills
							amount: (- ((gInventory at: 11) amount:) 1) ; theCurePills
						)
					else
						((gInventory at: 11) amount: 0 owner: 0 realOwner: 0) ; theCurePills
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(= temp2 9)
				else
					(= temp1 0)
					(= temp2 11)
				)
			)
			(24 ; theRations
				(= temp1 0)
				(if (< gFreeMeals 2)
					(if (> ((gInventory at: 14) amount:) 1) ; theRations
						((gInventory at: 14) ; theRations
							amount: (- ((gInventory at: 14) amount:) 1) ; theRations
						)
					else
						((gInventory at: 14) amount: 0 owner: 0 realOwner: 0) ; theRations
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(cond
						((IsFlag 3)
							(ClearFlag 3)
						)
						((IsFlag 2)
							(ClearFlag 2)
						)
						(else
							(++ gFreeMeals)
						)
					)
					(= temp2 10)
				else
					(= temp2 12)
				)
			)
			(28 ; theMeat
				(= temp1 0)
				(if (< gFreeMeals 2)
					(if (> ((gInventory at: 18) amount:) 1) ; theMeat
						((gInventory at: 18) ; theMeat
							amount: (- ((gInventory at: 18) amount:) 1) ; theMeat
						)
					else
						((gInventory at: 18) amount: 0 owner: 0 realOwner: 0) ; theMeat
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(cond
						((IsFlag 3)
							(ClearFlag 3)
						)
						((IsFlag 2)
							(ClearFlag 2)
						)
						(else
							(++ gFreeMeals)
						)
					)
					(= temp2 10)
				else
					(= temp2 12)
				)
			)
			(27 ; theFish
				(= temp1 0)
				(if (< gFreeMeals 2)
					(if (> ((gInventory at: 17) amount:) 1) ; theFish
						((gInventory at: 17) ; theFish
							amount: (- ((gInventory at: 17) amount:) 1) ; theFish
						)
					else
						((gInventory at: 17) amount: 0 owner: 0 realOwner: 0) ; theFish
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(cond
						((IsFlag 3)
							(ClearFlag 3)
						)
						((IsFlag 2)
							(ClearFlag 2)
						)
						(else
							(++ gFreeMeals)
						)
					)
					(= temp2 10)
				else
					(= temp2 12)
				)
			)
			(29 ; theFruit
				(= temp1 0)
				(if (< gFreeMeals 2)
					(if (> ((gInventory at: 19) amount:) 1) ; theFruit
						((gInventory at: 19) ; theFruit
							amount: (- ((gInventory at: 19) amount:) 1) ; theFruit
						)
					else
						((gInventory at: 19) amount: 0 owner: 0 realOwner: 0) ; theFruit
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(cond
						((IsFlag 3)
							(ClearFlag 3)
						)
						((IsFlag 2)
							(ClearFlag 2)
						)
						(else
							(++ gFreeMeals)
						)
					)
					(= temp2 10)
				else
					(= temp2 12)
				)
			)
			(46 ; theVineFruit
				(if (> ((gInventory at: 35) amount:) 1) ; theVineFruit
					((gInventory at: 35) amount: (- ((gInventory at: 35) amount:) 1)) ; theVineFruit, theVineFruit
				else
					((gInventory at: 35) amount: 0 owner: 0 realOwner: 0) ; theVineFruit
					(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
				)
				(= temp1 0)
				(= temp2 10)
				(SetFlag 115)
			)
			(40 ; theHoney
				(= temp1 0)
				(if (< gFreeMeals 2)
					(if (> ((gInventory at: 29) amount:) 1) ; theHoney
						((gInventory at: 29) ; theHoney
							amount: (- ((gInventory at: 29) amount:) 1) ; theHoney
						)
					else
						((gInventory at: 29) amount: 0 owner: 0 realOwner: 0) ; theHoney
						(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
					)
					(cond
						((IsFlag 3)
							(ClearFlag 3)
						)
						((IsFlag 2)
							(ClearFlag 2)
						)
						(else
							(++ gFreeMeals)
						)
					)
					(= temp2 10)
				else
					(= temp2 12)
				)
			)
			(48 ; thePeaceWater
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(gEgo drop: 37 1 get: 15) ; thePeaceWater, theWaterskin
			)
			(1 ; Look
				(= temp4 (Memory memALLOC_CRIT (+ (Message msgSIZE 28 2 1 0 1) 40))) ; "My, %s, you're looking heroic today!"
				(= temp5 (Message msgGET 28 2 1 0 1 temp4)) ; "My, %s, you're looking heroic today!"
				(gMessager sayFormat: temp5 temp4 @global157)
				(Memory memFREE temp4)
				(return 1)
			)
			(66 ; healingSpell
				(if (< [gEgoStats 16] (gEgo maxHealth:)) ; health
					(= temp2 23)
					(= temp5
						(Min
							(- (gEgo maxHealth:) [gEgoStats 16]) ; health
							(/ [gEgoStats 17] 2) ; stamina
						)
					)
					(+= [gEgoStats 16] temp5) ; health
					(-= [gEgoStats 17] temp5) ; stamina
				else
					(= temp2 25)
				)
			)
			(else
				(cond
					((>= theVerb 75) ; openSpell
						(= temp1 0)
						(= temp2 22)
					)
					((>= theVerb 10) ; Money
						(= temp1 0)
						(= temp2 21)
					)
				)
			)
		)
		(return (gMessager say: temp0 temp1 temp2 0 0 temp3))
	)

	(procedure (localproc_1 param1 param2)
		(self useSkill: param1 param2)
		(return (* [gEgoStats param1] param2))
	)

	(method (motionCue)
		(if (and (IsObject mover) (mover completed:))
			(mover motionCue:)
		)
		(if (and (IsObject cycler) (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (setMotion param1)
		(if (and param1 (== (gEgo view:) 20))
			(gEgo normalize:)
		)
		(super setMotion: param1 &rest)
	)

	(method (has param1)
		(if (== param1 0)
			(return 1)
		else
			(return ((gInventory at: param1) amount:))
		)
	)

	(method (get param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if (== argc 1) 1 else param2))
		(= temp2 ((gInventory at: param1) amount:))
		(cond
			((and (> gCurRoomNum 100) (== param1 0)) ; openCart
				(if (and (== ((gInventory at: param1) message:) 59) (== temp2 0))
					((gInventory at: param1) message: 10)
				)
			)
			((== param1 0)
				(= temp1 0)
			)
		)
		(cond
			(
				(>
					(= global465
						(-
							(= temp3
								(+
									(self wtCarried:)
									(* temp1 ((gInventory at: param1) value:))
								)
							)
							(self maxLoad:)
						)
					)
					0
				)
				(if (not (IsFlag 5))
					(gMessager say: 1 6 1 1 0 28) ; "You are carrying so much that you can hardly move. You'll have to drop something."
					(SetFlag 5)
					(self setStep: 1 1)
				)
			)
			((IsFlag 5)
				(ClearFlag 5)
				(self changeGait: -1 0)
			)
		)
		(if (< (+= temp1 temp2) 0)
			(= temp1 0)
		)
		(if (and (!= param1 0) (== temp1 0))
			((gInventory at: param1)
				amount: temp1
				realOwner: (if (OneOf gCurRoomNum 310 430) 0 else gCurRoom)
			)
			(gTheIconBar curInvIcon: 0 disable: 7 curIcon: (gTheIconBar at: 1))
		else
			((gInventory at: param1) amount: temp1 realOwner: self)
		)
		(return (- temp1 temp2))
	)

	(method (use param1 param2 &tmp temp0 temp1 temp2)
		(if
			(>
				(= temp1 (if (== argc 1) 1 else param2))
				((gInventory at: param1) amount:)
			)
			(= temp1 ((gInventory at: param1) amount:))
		)
		(self get: param1 (- temp1))
		(if (< ((gInventory at: param1) amount:) 1)
			(gTheIconBar curInvIcon: 0 advanceCurIcon:)
		)
		(return temp1)
	)

	(method (drop param1 param2)
		(self
			use:
				param1
				(if (== argc 2)
					param2
				else
					((gInventory at: param1) amount:)
				)
		)
	)

	(method (learn param1 param2 &tmp temp0 temp1)
		(= temp1 (if (== argc 1) 5 else param2))
		(if (and [gEgoStats 12] (> temp1 [gEgoStats param1])) ; magic use
			(= [gEgoStats param1] temp1)
		)
		(return [gEgoStats param1])
	)

	(method (canPickLocks)
		(if [gEgoStats 9] ; pick locks
			(self has: 7) ; theToolkit
		)
	)

	(method (useSkill param1 param2 &tmp temp0)
		(if (not [gEgoStats param1])
			(return 0)
		)
		(if (and (== param1 3) (IsFlag 115))
			(return 0)
		)
		(if (== param1 10)
			(self useStamina: 1)
		)
		(= temp0 (if (>= param2 0) 1 else -1))
		(if (> (Abs param2) [gEgoStats param1])
			(= param2 (* [gEgoStats param1] temp0))
		)
		(+= [gEgoStats 15] (/ (+ (Abs param2) 19) 20)) ; experience
		(+= [gSkillTicks param1] param2)
		(cond
			((>= [gSkillTicks param1] [gEgoStats param1])
				(-= [gSkillTicks param1] [gEgoStats param1])
				(if (> (+= [gEgoStats param1] (Random 2 4)) 300)
					(= [gEgoStats param1] 300)
				)
			)
			((< [gSkillTicks param1] 0)
				(+= [gSkillTicks param1] [gEgoStats param1])
				(if (< (-= [gEgoStats param1] (Random 2 4)) 5)
					(= [gEgoStats param1] 5)
				)
			)
			(else
				(return 0)
			)
		)
	)

	(method (useMana param1)
		(if [gEgoStats 12] ; magic use
			(if (< (-= [gEgoStats 18] param1) 0) ; mana
				(= [gEgoStats 18] 0) ; mana
			)
			(if (> [gEgoStats 18] (self maxMana:)) ; mana
				(= [gEgoStats 18] (self maxMana:)) ; mana
			)
		)
		(return [gEgoStats 18]) ; mana
	)

	(method (useStamina param1 &tmp temp0 temp1)
		(if (< argc 2)
			(= temp1 1)
		else
			(= temp1 0)
		)
		(if (> param1 0)
			(self useSkill: 3 (>> (+ param1 4) $0002)) ; Vitality
		)
		(cond
			((> (= temp0 (-= [gEgoStats 17] param1)) 4) ; stamina
				(ClearFlag 1)
				(if (> temp0 (gEgo maxStamina:))
					(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				)
			)
			((>= temp0 0))
			((self takeDamage: (>> (- 2 [gEgoStats 17]) $0002)) ; stamina
				(= [gEgoStats 17] 0) ; stamina
				(if (not (IsFlag 1))
					(SetFlag 1)
					(if (and (!= gCurRoomNum 550) temp1) ; combatRm
						(gNarrator y: (proc0_21 120 30 120 120 120))
						(gMessager say: 1 6 2 1 0 28) ; "You are so exhausted that everything you do hurts. Better get some rest."
						(gNarrator y: 120)
					)
				)
			)
			((> [gEgoStats 16] 0)) ; health
			(temp1
				(EgoDead 7 28) ; "Talk about over-exerting yourself... That last little move wore you out so much it hurt. In fact, it hurt so much, it killed you. Take it easier next time."
			)
		)
		(return [gEgoStats 16]) ; health
	)

	(method (addHonor param1 &tmp temp0 temp1 [temp2 20])
		(= temp0
			(cond
				(
					(<
						(if global404
							(- [gEgoStats 14] global404) ; honor
						)
						0
					)
					0
				)
				(global404
					(- [gEgoStats 14] global404) ; honor
				)
			)
		)
		(self useSkill: 14 (* param1 3)) ; honor
		(cond
			((= temp1 (localproc_0 temp0 10))
				(if (== temp1 1)
					((gInventory at: 1) state: 1) ; theSword
					(gEgo solvePuzzle: 202 2)
					(gMessager say: 1 6 13 0 0 28) ; "You now have the ability to make your magical sword burst into flame during combat."
				else
					((gInventory at: 1) state: 0) ; theSword
					(gMessager say: 1 6 14 0 0 28) ; "You have lost the ability to enflame your sword because of your actions."
				)
			)
			((= temp1 (localproc_0 temp0 25))
				(if (== temp1 1)
					(if (not [gEgoStats 12]) ; magic use
						(= [gEgoStats 12] 5) ; magic use
					)
					(= [gEgoStats 33] 10) ; healingSpell
					(gEgo solvePuzzle: 203 2)
					(gMessager say: 1 66 19 0 0 28) ; "You have just gained the Paladin's magical ability to heal."
				else
					(= [gEgoStats 33] 0) ; healingSpell
					(gMessager say: 1 66 20 0 0 28) ; "You have just lost the Paladin's magical ability to heal."
				)
			)
			((= temp1 (localproc_0 temp0 50))
				(if (== temp1 1)
					(SetFlag 150)
					(gEgo solvePuzzle: 204 2)
					(gMessager say: 1 6 17 0 0 28) ; "You have just gained the Paladin ability to sense the presence of danger."
				else
					(ClearFlag 150)
					(gMessager say: 1 6 15 0 0 28) ; "You have just lost the Paladin ability to sense the presence of danger."
				)
			)
			((= temp1 (localproc_0 temp0 80))
				(if (== temp1 1)
					(SetFlag 151)
					(gEgo solvePuzzle: 205 2)
					(gMessager say: 1 6 18 0 0 28) ; "You have just gained the Paladin's Honor Shield through your actions."
				else
					(ClearFlag 151)
					(gMessager say: 1 6 16 0 0 28) ; "You have just lost the magical protection of honor shield through your actions."
				)
			)
		)
	)

	(method (trySkill param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if
			(and
				(> (gEgo view:) 17)
				(< (gEgo view:) 21)
				(OneOf param1 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33)
			)
			(return 1)
		)
		(= temp3 1)
		(if (= temp0 [gEgoStats param1])
			(if (== argc 3)
				(+= temp0 param3)
			)
			(if param2
				(if (and (< param1 13) (!= param1 1) (!= param1 4))
					(self useStamina: (/ (+ param2 39) 40))
				)
			else
				(if (and (>= param1 5) (< param1 13))
					(self useStamina: (Random 2 8))
				)
				(= param2 (Random300))
			)
			(if (>= (localproc_1 4 1) (Random 1 500))
				(+= temp0 (Random 1 20))
			)
			(if (<= param2 temp0)
				(= temp3 1)
			else
				(= temp3 -1)
			)
			(if (= temp1 2)
				(cond
					((== param1 5)
						(self useSkill: 0 3) ; strength
						(self useSkill: 2 2) ; agility
					)
					((or (== param1 6) (== param1 7) (== param1 8))
						(self useSkill: 2 4) ; agility
						(self useSkill: 1 2) ; intelligence
					)
					((== param1 9)
						(self useSkill: 2 8) ; agility
						(self useSkill: 1 5) ; intelligence
					)
					((or (== param1 10) (== param1 11))
						(self useSkill: 0 5) ; strength
						(self useSkill: 2 4) ; agility
					)
					((== param1 13)
						(self useSkill: 1 6) ; intelligence
					)
					((>= param1 19)
						(self useSkill: 12 8) ; magic use
						(self useSkill: 1 4) ; intelligence
					)
				)
				(= temp2 100)
				(if (or (< param1 13) (== param1 5))
					(= temp2 25)
				)
				(self useSkill: param1 (Abs (/ temp2 temp1)))
			)
		else
			(= temp3 0)
		)
		(return temp3)
	)

	(method (solvePuzzle param1 param2 param3 &tmp temp0 temp1)
		(= temp0 0)
		(if (>= argc 3)
			(cond
				((and (& param3 $0001) (== gHeroType 0)) ; Fighter
					(= temp1 0)
				)
				((and (& param3 $0002) (== gHeroType 1)) ; Magic User
					(= temp1 1)
				)
				((and (& param3 $0004) (== gHeroType 2)) ; Thief
					(= temp1 2)
				)
				((and (& param3 $0008) (== gHeroType 3)) ; Paladin
					(= temp1 3)
				)
				(else
					(= temp1 -1)
				)
			)
			(if (and (>= argc 3) (!= gHeroType temp1))
				(return 0)
			)
			(if
				(and
					(== temp1 3)
					(!= gHeroType 3) ; Paladin
					(not (IsFlag 19))
					(not (IsFlag param1))
				)
				(+= global361 param2)
			)
			(if (and (== gHeroType 3) (== temp1 gBaseHeroType)) ; Paladin
				(= param3 3)
			)
		)
		(if (not (IsFlag param1))
			(SetFlag param1)
			(self useSkill: 1 (* param2 3)) ; intelligence
			(if (> (+= gScore param2) 500)
				(= gScore 500)
			)
			(puzzleSound play:)
			(= temp0 1)
		)
		(return temp0)
	)

	(method (takeDamage param1)
		(self useSkill: 3 (Abs param1)) ; Vitality
		(if
			(<
				(-=
					[gEgoStats 16] ; health
					(if (IsFlag 115)
						(Abs param1)
					else
						param1
					)
				)
				0
			)
			(= [gEgoStats 16] 0) ; health
		)
		(if (> [gEgoStats 16] (self maxHealth:)) ; health
			(= [gEgoStats 16] (self maxHealth:)) ; health
		)
		(return (> [gEgoStats 16] 0)) ; health
	)

	(method (castSpell param1 param2 &tmp temp0)
		(cond
			((< argc 2)
				(if
					(and
						(> (gEgo view:) 17)
						(< (gEgo view:) 21)
						(!= gCurRoomNum 550) ; combatRm
					)
					(return 1)
				)
			)
			((and param2 (!= gCurRoomNum 550)) ; combatRm
				(return 1)
			)
		)
		(if (< [gEgoStats 18] [global367 (- param1 19)]) ; mana
			(gMessager say: 1 6 3 1 0 28) ; "You don't have enough mana points to cast that spell."
			(return 0)
		else
			(return
				(self useMana: [global367 (- param1 19)] trySkill: param1 0)
			)
		)
	)

	(method (maxMana &tmp temp0)
		(return
			(and (= temp0 [gEgoStats 12]) (/ (+ [gEgoStats 1] temp0 temp0) 3)) ; magic use, intelligence
		)
	)

	(method (maxStamina)
		(return (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, Vitality
	)

	(method (maxHealth)
		(return (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; strength, Vitality, Vitality
	)

	(method (maxLoad)
		(return (+ 2400 (* [gEgoStats 0] 30))) ; strength
	)

	(method (eatMeal &tmp temp0)
		(= temp0 0)
		(cond
			(gFreeMeals
				(-- gFreeMeals)
				(= temp0 1)
			)
			(((gInventory at: 14) amount:) ; theRations
				((gInventory at: 14) amount: (- ((gInventory at: 14) amount:) 1)) ; theRations, theRations
				(if (not ((gInventory at: 14) amount:)) ; theRations
					((gInventory at: 14) owner: 0 realOwner: 0) ; theRations
				)
				(= temp0 1)
			)
			(((gInventory at: 18) amount:) ; theMeat
				(= temp0 1)
				((gInventory at: 18) amount: (- ((gInventory at: 18) amount:) 1)) ; theMeat, theMeat
				(if (not ((gInventory at: 18) amount:)) ; theMeat
					((gInventory at: 18) owner: 0 realOwner: 0) ; theMeat
				)
			)
			(((gInventory at: 17) amount:) ; theFish
				(= temp0 1)
				((gInventory at: 17) amount: (- ((gInventory at: 17) amount:) 1)) ; theFish, theFish
				(if (not ((gInventory at: 17) amount:)) ; theFish
					((gInventory at: 17) owner: 0 realOwner: 0) ; theFish
				)
			)
			(((gInventory at: 19) amount:) ; theFruit
				(= temp0 1)
				((gInventory at: 19) amount: (- ((gInventory at: 19) amount:) 1)) ; theFruit, theFruit
				(if (not ((gInventory at: 19) amount:)) ; theFruit
					((gInventory at: 19) owner: 0 realOwner: 0) ; theFruit
				)
			)
			((IsFlag 3)
				(if (self useStamina: 8 0)
					(gMessager say: 1 6 5 1 0 28) ; "You're starving. You'd better find some food SOON!"
				else
					(EgoDead 8 28) ; "While it's true that some foods may be bad for your health, NO food is even worse. You have, quite literally, starved to death."
				)
			)
			((IsFlag 2)
				(SetFlag 3)
				(gMessager say: 1 6 6 1 0 28) ; "You're really getting hungry."
			)
			(else
				(SetFlag 2)
				(gMessager say: 1 6 4 1 0 28) ; "You just ate the last of your rations. You'd better get some more food soon."
			)
		)
		(if temp0
			(cond
				((IsFlag 3)
					(ClearFlag 3)
				)
				((IsFlag 2)
					(ClearFlag 2)
				)
			)
		)
	)

	(method (wtCarried &tmp temp0 temp1)
		(= temp1 1)
		(= temp0 0)
		(while (< temp1 47)
			(+=
				temp0
				(* ((gInventory at: temp1) amount:) ((gInventory at: temp1) value:))
			)
			(++ temp1)
		)
		(= temp0 (+ (+= temp0 (* global410 2)) (* global424 2)))
	)

	(method (changeGait param1 param2 &tmp temp0 temp1)
		(= temp1 0)
		(if (and param2 (== gEgoGait param1))
			(return)
		)
		(if mover
			(= temp1 mover)
			(= mover 0)
		)
		(if (!= param1 -1)
			(= gEgoGait param1)
		)
		(if (or (< view 4) (== view 5))
			(switch gEgoGait
				(1 ; running
					(self view: 1 origStep: 2053 setStep: setCycle: StopWalk 5)
				)
				(2 ; sneaking
					(self view: 2 origStep: 1026 setStep: setCycle: StopWalk 2)
				)
				(else
					(self view: 0 origStep: 1027 setStep: setCycle: StopWalk 5)
				)
			)
		)
		(cond
			((IsFlag 5)
				(self setStep: 1 1 0)
			)
			(
				(and
					(not (OneOf gCurRoomNum 150 160 170 180))
					(or (== xStep 1) (== yStep 1))
				)
				(if (== view 1)
					(self setStep: 8 4 0)
				else
					(self setStep: 4 2 0)
				)
			)
		)
		(if temp1
			(self mover: temp1)
			((self mover:) init:)
		)
	)

	(method (normalize param1)
		(if argc
			(self loop: param1)
		)
		(self
			view: 0
			z: 0
			setPri: -1
			setLoop: -1
			setLoop: stopGroop
			setCycle: StopWalk 5
			setMotion: 0
			changeGait: -1 0
			illegalBits: $8000
			ignoreHorizon:
			setSpeed: gSpeed
		)
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler:) vWalking:))
		)
		(super doit: &rest)
	)

	(method (cue &tmp temp0)
		(cond
			((not (IsObject (client mover:)))
				(client mover: oldMover)
			)
			((IsObject oldMover)
				(oldMover dispose:)
			)
		)
		(if (IsObject oldCycler)
			(if (IsObject (client cycler:))
				(oldCycler dispose:)
			else
				(client cycler: oldCycler)
			)
		)
		(= temp0 caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if (IsObject temp0)
			(temp0 cue: &rest)
		)
	)
)

(instance puzzleSound of Sound
	(properties
		number 950
	)
)

