;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use DeathIcon)
(use Str)
(use Print)
(use IconBar)
(use PolyPath)
(use StopWalk)
(use Cursor)
(use Grooper)
(use Actor)
(use System)

(public
	hero 0
	stopGroop 1
)

(local
	local0
)

(procedure (localproc_0 param1 param2)
	(if
		(and
			(< param1 param2)
			(>=
				(if global394
					(- (+ global394 [gEgoStats 14]) global361) ; honor
				else
					0
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
				(if global394
					(- (+ global394 [gEgoStats 14]) global361) ; honor
				else
					0
				)
				param2
			)
		)
		(return -1)
	)
	(return 0)
)

(class hero of Actor
	(properties
		noun 2
		modNum 28
		sightAngle 90
	)

	(method (facingMe)
		(return 1)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 2)
		(= temp1 theVerb)
		(= temp2 0)
		(= temp3 28)
		(return
			(if (== theVerb 10) ; Jump
				(if (not (gCurRoom doVerb: 10))
					(gGlory pragmaFail:)
				)
			else
				(switch theVerb
					(18 ; theHeals
						(if (< [gEgoStats 17] (self maxHealth:)) ; health
							(if (IsFlag 14)
								(ClearFlag 14)
								(gEgo
									takeDamage: (- (/ (self maxHealth:) 3))
								)
								(SetFlag 14)
							else
								(gEgo
									takeDamage: (- (/ (self maxHealth:) 3))
								)
							)
							(gEgo drop: 3 1 get: 9) ; theHeals, theFlask
							((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
							(= temp2 9)
						else
							(= temp1 0)
							(= temp2 11)
						)
					)
					(16 ; theManas
						(if (< [gEgoStats 19] (gEgo maxMana:)) ; mana
							(gEgo
								useMana: (- (/ (gEgo maxMana:) 3))
								drop: 1 1 ; theManas
							)
							(= temp2 9)
							((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
						else
							(= temp1 0)
							(= temp2 11)
						)
					)
					(17 ; theCures
						(if (IsFlag 14)
							(ClearFlag 14)
							(= global479 0)
							(gEgo drop: 2 1 get: 9) ; theCures, theFlask
							(= temp2 9)
							((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
						else
							(= temp1 0)
							(= temp2 11)
						)
					)
					(4 ; Do
						(if (== gCurRoomNum 520)
							(= temp2 30)
						else
							(= temp2 0)
						)
					)
					(19 ; theRations
						(= temp1 0)
						(if (< gFreeMeals 2)
							(gEgo drop: 4 1) ; theRations
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
					(1 ; Look
						(= temp4 (Str new:))
						(Message msgGET 28 2 1 0 1 (temp4 data:)) ; "My, you're looking heroic today!"
						(= temp5 (Str new:))
						(temp5 format: {%s} gHeroName)
						(temp4 format: (temp4 data:) temp5)
						(Print addText: temp4 init:)
						(Message msgGET 28 2 1 32 1 (temp4 data:)) ; "You are currently carrying %d quarks. The most you can carry without strain is a load of %d quarks."
						(temp4
							format:
								(temp4 data:)
								(self wtCarried:)
								(self maxLoad:)
						)
						(Print addText: temp4 init:)
						(temp4 dispose:)
						(temp5 dispose:)
						(return 1)
					)
					(102 ; healingSpell
						(if (< [gEgoStats 17] (gEgo maxHealth:)) ; health
							(= temp2 23)
							(= temp5
								(Min
									(- (gEgo maxHealth:) [gEgoStats 17]) ; health
									(/ [gEgoStats 18] 2) ; stamina
								)
							)
							(+= [gEgoStats 17] temp5) ; health
							(-= [gEgoStats 18] temp5) ; stamina
							((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
						else
							(= temp2 25)
						)
					)
					(54 ; theCloth
						(if
							(and
								(== gCurRoomNum 710)
								(> (gEgo x:) 190)
								(< (gEgo y:) 125)
							)
							(self setScript: (ScriptID 710 1)) ; sLevitateOverPit
							(return 1)
						)
					)
					(else
						(if (and (>= theVerb 79) (<= theVerb 98)) ; frostSpell, resistanceSpell
							(= temp1 0)
							(= temp2 22)
						)
					)
				)
				(if (Message msgSIZE temp3 temp0 temp1 temp2 1)
					(gMessager say: temp0 temp1 temp2 1 0 temp3)
				else
					(gMessager say: temp0 0 21 1 0 temp3)
				)
			)
		)
	)

	(procedure (localproc_1 param1 param2)
		(self useSkill: param1 param2)
		(return (* [gEgoStats param1] param2))
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 evVERB)
				(cond
					((& temp1 evMOVE)
						(cond
							(
								(and
									(gCurRoom exitList:)
									((gCurRoom exitList:)
										firstTrue: #onMe (event x:) (event y:)
									)
								)
								(return 1)
							)
							((and (gCurRoom east:) (>= (event x:) 313))
								(if (!= (gCurRoom rightY:) -1)
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											313
											(gCurRoom rightY:)
									)
								else
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											313
											(event y:)
									)
								)
							)
							((and (gCurRoom west:) (<= (event x:) 7))
								(if (!= (gCurRoom leftY:) -1)
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											7
											(gCurRoom leftY:)
									)
								else
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											7
											(event y:)
									)
								)
							)
							(
								(and
									(gCurRoom north:)
									(<= (event y:) (gCurRoom horizon:))
								)
								(if (!= (gCurRoom topX:) -1)
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(gCurRoom topX:)
											(gCurRoom horizon:)
									)
								else
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(event x:)
											(gCurRoom horizon:)
									)
								)
							)
							((and (gCurRoom south:) (>= (event y:) 182))
								(if (!= (gCurRoom bottomX:) -1)
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(gCurRoom bottomX:)
											182
									)
								else
									(self
										setMotion:
											((ScriptID 17) new:) ; pOffMover
											(event x:)
											182
									)
								)
							)
							(else
								(self
									setMotion:
										PolyPath
										(event x:)
										(+ (event y:) z)
								)
							)
						)
						(gUser prevDir: 0)
						(event claimed: 1)
					)
					((IsFlag 356) 0)
					(else
						(super handleEvent: event)
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (setMotion param1)
		(if param1
			(cond
				((== (gEgo view:) 20)
					(gEgo normalize:)
				)
				((not (gEgo isNotHidden:))
					(gEgo show:)
				)
			)
		)
		(super setMotion: param1 &rest)
	)

	(method (has param1 &tmp temp0)
		(cond
			((OneOf param1 58 59 60 61 62 63)
				(= temp0
					(switch param1
						(58 1)
						(59 2)
						(60 4)
						(61 8)
						(62 16)
						(63 32)
					)
				)
				(if (& ((gInventory at: 14) maskCel:) temp0) ; theKeyRing
					(return ((gInventory at: 14) amount:)) ; theKeyRing
				else
					(return 0)
				)
			)
			((== param1 0)
				(return 1)
			)
			(else
				(return ((gInventory at: param1) amount:))
			)
		)
	)

	(method (get param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (if (== argc 1) 1 else param2))
		(cond
			((OneOf param1 58 59 60 61 62 63)
				(= temp5
					(switch param1
						(58 1)
						(59 2)
						(60 4)
						(61 8)
						(62 16)
						(63 32)
					)
				)
				((gInventory at: 14) ; theKeyRing
					maskCel: (| ((gInventory at: 14) maskCel:) temp5) ; theKeyRing
				)
				(= param1 14)
			)
			((== param1 19)
				(switch ((= temp0 (gInventory at: 19)) state:) ; theSword
					(0
						(temp0 loop: 0)
						(temp0 cel: 12)
					)
					(1
						(temp0 loop: 0)
						(temp0 cel: 0)
					)
					(2
						(temp0 loop: 0)
						(temp0 cel: 15)
					)
				)
			)
			((== param1 17)
				(if ((= temp0 (gInventory at: 17)) state:) ; theArmor
					(temp0 cel: 13)
				else
					(temp0 cel: 2)
				)
			)
		)
		(= temp2 ((gInventory at: param1) amount:))
		(cond
			(
				(>
					(= global407
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
					(if (IsFlag 6)
						(gMessager say: 1 6 1 1 0 28) ; "You are carrying so much that you can hardly move. You'll have to drop something."
					)
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
				owner: (if (OneOf gCurRoomNum 330) 0 else gCurRoom)
			)
			(gTheIconBar curInvIcon: 0 disable: 6 curIcon: (gTheIconBar at: 0))
		else
			(= temp6 (gInventory at: param1))
			(temp6 amount: temp1 owner: self)
			(gTheIconBar
				curInvIcon: temp6
				enableIcon: (gTheIconBar useIconItem:)
				curIcon: (gTheIconBar useIconItem:)
			)
			(Cursor view: (temp6 view:) loop: (temp6 loop:) cel: (temp6 cel:))
			(= global204 (gTheIconBar at: 6))
			(global204
				cursorView: (temp6 view:)
				cursorLoop: (temp6 loop:)
				cursorCel: (temp6 cel:)
			)
			(= temp4 (ScriptID 36 1)) ; invItem
			(temp4
				view: (temp6 view:)
				loop: (temp6 loop:)
				cel: (temp6 cel:)
				show:
			)
			(UpdateScreenItem temp4)
			(gGlory
				setCursor:
					(IconBarCursor
						view: (temp6 view:)
						loop: (temp6 loop:)
						cel: (temp6 cel:)
						yourself:
					)
			)
		)
		(return (- temp1 temp2))
	)

	(method (use param1 param2 &tmp temp0 temp1)
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
			(= temp0 (ScriptID 36 1)) ; invItem
			(temp0 signal: (| (temp0 signal:) $0008))
			(DeleteScreenItem temp0)
		)
		(return temp1)
	)

	(method (drop param1 param2 &tmp temp0 temp1)
		(if (OneOf param1 58 59 60 61 63)
			(= temp1
				(switch param1
					(58 1)
					(59 2)
					(60 4)
					(61 8)
					(62 16)
					(63 32)
				)
			)
			(if (= temp0 ((gInventory at: 14) maskCel:)) ; theKeyRing
				((gInventory at: 14) maskCel: (& temp0 (~ temp1))) ; theKeyRing
			else
				(return 0)
			)
			(if ((gInventory at: 14) maskCel:) ; theKeyRing
				(return 0)
			)
			(= param1 14)
		)
		(return
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
	)

	(method (learn param1 param2 &tmp temp0 temp1)
		(= temp1 (if (== argc 1) 5 else param2))
		(if (and [gEgoStats 12] (> temp1 [gEgoStats param1])) ; magic
			(= [gEgoStats param1] temp1)
		)
		(return [gEgoStats param1])
	)

	(method (canPickLocks)
		(if [gEgoStats 9] ; pick locks
			(self has: 24) ; theToolkit
		)
	)

	(method (useSkill param1 param2 &tmp temp0)
		(* param2 8)
		(if (not [gEgoStats param1])
			(return 0)
		)
		(if (and (== param1 3) (IsFlag 14))
			(return 0)
		)
		(if (== param1 10)
			(self useStamina: 1)
		)
		(= temp0 (if (>= param2 0) 1 else -1))
		(if (> (Abs param2) [gEgoStats param1])
			(= param2 (* [gEgoStats param1] temp0))
		)
		(+= [gEgoStats 16] (/ (+ (Abs param2) 19) 20)) ; experience
		(if (== param1 11)
			(+= [global289 param1] param2)
		)
		(+= [global289 param1] param2)
		(cond
			((>= [global289 param1] [gEgoStats param1])
				(-= [global289 param1] [gEgoStats param1])
				(if (> (+= [gEgoStats param1] (Random 2 4)) 400)
					(= [gEgoStats param1] 400)
				)
			)
			((< [global289 param1] 0)
				(+= [global289 param1] [gEgoStats param1])
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
		(if [gEgoStats 12] ; magic
			(if (< (-= [gEgoStats 19] param1) 0) ; mana
				(= [gEgoStats 19] 0) ; mana
			)
			(if (> [gEgoStats 19] (self maxMana:)) ; mana
				(= [gEgoStats 19] (self maxMana:)) ; mana
			)
			((ScriptID 0 21) doit:) ; statusCode
		)
		(return [gEgoStats 19]) ; mana
	)

	(method (useStamina param1 &tmp temp0 temp1)
		(if (< argc 2)
			(= temp1 1)
		else
			(= temp1 0)
		)
		(if (> param1 0)
			(self useSkill: 3 (>> (+ param1 4) $0002)) ; vitality
		)
		(cond
			((> (= temp0 (-= [gEgoStats 18] param1)) 4) ; stamina
				(ClearFlag 1)
				(if (> temp0 (gEgo maxStamina:))
					(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				)
			)
			((>= temp0 0))
			((self takeDamage: (>> (- 2 [gEgoStats 18]) $0002)) ; stamina
				(= [gEgoStats 18] 0) ; stamina
				(if (not (IsFlag 1))
					(SetFlag 1)
					(if (and (!= gCurRoomNum 810) temp1) ; combat
						(gMessager say: 1 6 2 1 0 28) ; "You are so exhausted that everything you do hurts. Better get some rest."
					)
				)
			)
			((> [gEgoStats 17] 0)) ; health
			(temp1
				(EgoDead 7 28) ; "Talk about over-exerting yourself... That last little move wore you out so much it hurt. In fact, it hurt so much, it killed you. Take it easier next time."
			)
		)
		((ScriptID 0 21) doit:) ; statusCode
		(return [gEgoStats 17]) ; health
	)

	(method (addHonor param1 &tmp temp0 temp1 temp2)
		(/= param1 5)
		(= temp0
			(if global394
				(- (+ global394 [gEgoStats 14]) global361) ; honor
			else
				0
			)
		)
		(if (< param1 0)
			(for ((= temp1 param1)) (< temp1 0) ((++ temp1))
				(self useSkill: 14 -15) ; honor
			)
		else
			(for ((= temp1 0)) (< temp1 param1) ((++ temp1))
				(self useSkill: 14 15) ; honor
			)
		)
		(cond
			((!= gHeroType 3)) ; Paladin
			((= temp1 (localproc_0 temp0 210))
				(if (== temp1 1)
					(SetFlag 385)
					(if (== ((gInventory at: 19) state:) 3) ; theSword
						(gMessager say: 1 6 13 0 0 28) ; "You now have the ability to make your magical sword burst into flame during combat."
						(SetCursor 905 0 14)
						(= temp2 (ScriptID 36 1)) ; invItem
						(temp2 loop: 0 cel: 14 show:)
						(UpdateScreenItem temp2)
						((gInventory at: 19) cel: 14 mainCel: 14) ; theSword
						((gTheIconBar at: 6) cursorLoop: 0 cursorCel: 14)
					else
						(gMessager say: 1 6 31 0 0 28) ; "You suddenly know how to make a Paladin sword turn to flames. Unfortunately, you need a Paladin sword to do it."
					)
				else
					(ClearFlag 385)
					(gMessager say: 1 6 14 0 0 28) ; "You have lost the ability to enflame your sword because of your actions."
					(SetCursor 905 0 0)
					(= temp2 (ScriptID 36 1)) ; invItem
					(temp2 loop: 0 cel: 0 show:)
					(UpdateScreenItem temp2)
					((gInventory at: 19) cel: 0 mainCel: 0) ; theSword
					((gTheIconBar at: 6) cursorLoop: 0 cursorCel: 0)
				)
			)
			((= temp1 (localproc_0 temp0 25))
				(if (== temp1 1)
					(if (not [gEgoStats 12]) ; magic
						(= [gEgoStats 12] 5) ; magic
					)
					(if (not [gEgoStats 41]) ; healSpell
						(= [gEgoStats 41] 10) ; healSpell
						(gMessager say: 1 102 19 0 0 28) ; "You have just gained the Paladin's magical ability to heal."
					)
				else
					(= [gEgoStats 41] 0) ; healSpell
					(gMessager say: 1 102 20 0 0 28) ; "You have just lost the Paladin's magical ability to heal."
				)
			)
			((= temp1 (localproc_0 temp0 50))
				(if (== temp1 1)
					(SetFlag 20)
					(gMessager say: 1 6 17 0 0 28) ; "You have just gained the Paladin ability to sense the presence of danger."
				else
					(ClearFlag 20)
					(gMessager say: 1 6 15 0 0 28) ; "You have just lost the Paladin ability to sense the presence of danger."
				)
			)
			((= temp1 (localproc_0 temp0 80))
				(if (== temp1 1)
					(SetFlag 21)
					(= global453 1)
					((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
					(gMessager say: 1 6 18 0 0 28) ; "You have just gained the Paladin's Honor Shield through your actions."
				else
					(ClearFlag 21)
					(gMessager say: 1 6 16 0 0 28) ; "You have just lost the magical protection of Honor Shield through your actions."
				)
			)
		)
	)

	(method (trySkill param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if
			(and
				(> (gEgo view:) 17)
				(< (gEgo view:) 21)
				(OneOf
					param1
					20
					21
					22
					23
					24
					25
					26
					27
					28
					29
					30
					31
					32
					33
					41
					34
					35
				)
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
					((>= param1 20)
						(self useSkill: 12 8) ; magic
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
			(if (and (== gHeroType 3) (== temp1 global362)) ; Paladin
				(= param3 3)
			)
		)
		(if (not (IsFlag param1))
			(SetFlag param1)
			(self useSkill: 1 (* param2 3)) ; intelligence
			(if (> (+= gScore param2) 500)
				(= gScore 500)
			)
			(gLongSong3 number: 149 setLoop: 1 play:)
			(= temp0 1)
		)
		(return temp0)
	)

	(method (takeDamage param1)
		(self useSkill: 3 (Abs param1)) ; vitality
		(if
			(<
				(-=
					[gEgoStats 17] ; health
					(if (IsFlag 14)
						(Abs param1)
					else
						param1
					)
				)
				0
			)
			(= [gEgoStats 17] 0) ; health
		)
		(if (> [gEgoStats 17] (self maxHealth:)) ; health
			(= [gEgoStats 17] (self maxHealth:)) ; health
		)
		((ScriptID 0 21) doit:) ; statusCode
		(return (> [gEgoStats 17] 0)) ; health
	)

	(method (castSpell param1 param2 &tmp temp0)
		(cond
			((< argc 2)
				(if
					(and
						(> (gEgo view:) 17)
						(< (gEgo view:) 21)
						(!= gCurRoomNum 810) ; combat
					)
					(return 1)
				)
			)
			((and param2 (!= gCurRoomNum 810)) ; combat
				(return 1)
			)
		)
		(if (< [gEgoStats 19] [global367 (- param1 20)]) ; mana
			(gMessager say: 1 6 3 1 0 28) ; "You don't have enough mana points to cast that spell."
			(return 0)
		else
			(return
				(self
					useStamina: 2
					useMana: [global367 (- param1 20)]
					trySkill: param1 0
				)
			)
		)
	)

	(method (maxMana &tmp temp0)
		(if (= temp0 [gEgoStats 12]) ; magic
			(return (/ (+ [gEgoStats 1] temp0 temp0) 3)) ; intelligence
		)
	)

	(method (maxStamina)
		(return (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, vitality
	)

	(method (maxHealth)
		(return (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; strength, vitality, vitality
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
			(((gInventory at: 4) amount:) ; theRations
				((gInventory at: 4) amount: (- ((gInventory at: 4) amount:) 1)) ; theRations, theRations
				(if (not ((gInventory at: 4) amount:)) ; theRations
					((gInventory at: 4) owner: 0) ; theRations
				)
				(= temp0 1)
			)
			((IsFlag 3)
				(if (self useStamina: 8 0)
					(gMessager say: 1 6 5 1 0 28) ; "You're starving. You'd better find some food SOON!"
				else
					(EgoDead 8 28 995 1) ; "While it's true that some foods may be bad for your health, NO food is even worse. You have, quite literally, starved to death."
				)
			)
			((IsFlag 2)
				(SetFlag 3)
				(gMessager say: 1 6 6 1 0 28) ; "You're really getting hungry."
			)
			(else
				(SetFlag 2)
				(gMessager say: 1 6 4 1 0 28) ; "You don't have any rations. You'd better get some food soon."
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
		(while (< temp1 57)
			(+=
				temp0
				(* ((gInventory at: temp1) amount:) ((gInventory at: temp1) value:))
			)
			(++ temp1)
		)
		(= temp0 (+ (+= temp0 global395) ((gInventory at: 0) amount:))) ; thePurse
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
		(if (or (< view 4) (== view 5) (<= 47 view 49) (== view 52))
			(switch gEgoGait
				(1 ; running
					(if (IsFlag 373)
						(self
							view: 52
							origStep: 2053
							setStep:
							setCycle: StopWalk 48
						)
					else
						(self
							view: 1
							origStep: 2053
							setStep:
							setCycle: StopWalk 5
						)
					)
				)
				(2 ; sneaking
					(if (IsFlag 373)
						(self
							view: 49
							origStep: 1026
							setStep:
							setCycle: StopWalk 48
						)
					else
						(self
							view: 2
							origStep: 1026
							setStep:
							setCycle: StopWalk 2
						)
					)
				)
				(else
					(if (IsFlag 373)
						(self
							view: 47
							origStep: 1027
							setStep:
							setCycle: StopWalk 48
						)
					else
						(self
							view: 0
							origStep: 1027
							setStep:
							setCycle: StopWalk 5
						)
					)
				)
			)
		)
		(cond
			((IsFlag 5)
				(self setStep: 1 1 0)
			)
			((or (== xStep 1) (== yStep 1))
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

	(method (notBlockedByEdge)
		(if (and mover (mover isKindOf: PolyPath))
			(return (and (== x (mover finalX:)) (== y (mover finalY:))))
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
			setLooper: stopGroop
			setCycle: StopWalk 5
			setMotion: 0
			changeGait: -1 0
			illegalBits: 0
			ignoreHorizon:
			state: 2
		)
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if (and (gEgo cycler:) ((gEgo cycler:) isKindOf: StopWalk))
			(gEgo view: ((gEgo cycler:) vWalking:))
		)
		(super doit: &rest)
	)

	(method (cue &tmp temp0)
		(cond
			((not (client mover:))
				(client mover: oldMover)
			)
			(oldMover
				(oldMover dispose:)
			)
		)
		(if oldCycler
			(if (client cycler:)
				(oldCycler dispose:)
			else
				(client cycler: oldCycler)
			)
		)
		(= temp0 caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if temp0
			(temp0 cue: &rest)
		)
	)
)

