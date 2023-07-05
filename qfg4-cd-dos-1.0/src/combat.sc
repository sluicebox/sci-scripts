;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use GloryRm)
(use SView)
(use IconBar)
(use Sound)
(use Motion)
(use System)

(public
	combat 0
	proc810_1 1
	proc810_2 2
	bloodDrop 3
	jumpUp 4
	jumpForward 5
	jumpAttack 6
	jumpVAttack 7
	throwDagger 8
	toBomb 9
	highSlash 10
	lowSlash 11
	proc810_12 12
	proc810_13 13
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15 = 15
	local16
	local17
	local18
	local19
	local20
)

(procedure (proc810_12 param1)
	(switch param1
		(0
			(return 0)
		)
		(10
			(return 1)
		)
		(else
			(return (>= param1 (Random 1 10)))
		)
	)
)

(procedure (proc810_2 &tmp temp0)
	(if
		(<=
			(= temp0
				(-
					(+ (/ [gEgoStats 5] 10) global142 local7) ; weapon-use
					(+ local8 (Random 1 10))
				)
			)
			0
		)
		(= temp0 3)
	)
	(if global142
		(= global142 0)
		((ScriptID 40 8) cel: 2) ; xZapButton
		(UpdateScreenItem (ScriptID 40 8)) ; xZapButton
	)
	(return temp0)
)

(procedure (proc810_1 param1 &tmp temp0 temp1)
	(switch param1
		(18
			(= temp1 80)
			(= temp0 local2)
		)
		(19
			(= temp1 80)
			(= temp0 local3)
		)
		(17
			(= temp1 104)
			(= temp0 local4)
		)
		(-1
			(return
				(if global156
					(/ (* 104 (/ (* global156 80) global180)) 80)
				else
					0
				)
			)
		)
	)
	(return
		(if (> [gEgoStats param1] 0)
			(/ (* temp1 (/ (* [gEgoStats param1] 80) temp0)) 80)
		else
			0
		)
	)
)

(procedure (proc810_13 param1 param2 &tmp temp0)
	(if (< (gGlory _detailLevel:) 5)
		(return)
	)
	(switch param1
		(0
			(= temp0 gLongSong2)
		)
		(1
			(= temp0 gLongSong3)
		)
		(2
			(= temp0 spellSound1)
		)
		(3
			(= temp0 spellSound2)
		)
		(4
			(= temp0 spellSound3)
		)
		(else
			(return)
		)
	)
	(temp0 flags: 5 setLoop: 1 number: param2 play:)
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (not [gEgoStats param1])
		(return 0)
	)
	(if (and (== param1 3) (IsFlag 14))
		(return 0)
	)
	(if (!= param1 1)
		(* param2 3)
	)
	(= temp0 (if (>= param2 0) 1 else -1))
	(if (> (Abs param2) [gEgoStats param1])
		(= param2 (* [gEgoStats param1] temp0))
	)
	(+= [gEgoStats 16] (/ (+ (Abs param2) 19) 20)) ; experience
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

(procedure (localproc_1 param1 param2)
	(localproc_0 param1 param2)
	(return (* [gEgoStats param1] param2))
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(= temp0 [gEgoStats param1])
	(if (>= (localproc_1 4 1) (Random 1 500))
		(+= temp0 (Random 1 20))
	)
	(= temp1 2)
	(cond
		((== param1 5)
			(localproc_0 0 3)
			(localproc_0 2 2)
		)
		((or (== param1 6) (== param1 7) (== param1 8))
			(localproc_0 2 4)
			(localproc_0 1 2)
		)
		((== param1 9)
			(localproc_0 2 8)
			(localproc_0 1 5)
		)
		((or (== param1 10) (== param1 11))
			(localproc_0 0 5)
			(localproc_0 2 4)
		)
		((== param1 13)
			(localproc_0 1 6)
		)
		((>= param1 20)
			(localproc_0 12 8)
			(localproc_0 1 4)
		)
	)
	(= temp2 100)
	(if (or (< param1 13) (== param1 5))
		(= temp2 25)
	)
	(localproc_0 param1 (Abs (/ temp2 temp1)))
)

(instance combat of GloryRm
	(properties)

	(method (init &tmp temp0)
		(= local19 gCombatMonsterNum)
		(= local20 gHeroType)
		(= gCombatResult 0)
		(if (not gCombatMonsterNum)
			(= gCombatMonsterNum 855) ; horror
		)
		(Load rsSCRIPT 40)
		(Load rsSCRIPT 41)
		(cond
			((OneOf gHeroType 2 1) ; Thief, Magic User
				(Load rsVIEW 45)
				(= global182 88)
				(= global183 13)
				(= local11 70)
				(= local12 0)
				(= local13 86)
				(= local14 31)
			)
			((== ((gInventory at: 19) state:) 2) ; theSword
				(Load rsVIEW 25)
				(= global182 94)
				(= global183 19)
				(= local11 83)
				(= local12 1)
				(= local13 114)
				(= local14 40)
			)
			(else
				(Load rsVIEW 23)
				(= global182 113)
				(= global183 12)
				(= local11 74)
				(= local12 4)
				(= local13 115)
				(= local14 40)
			)
		)
		(RemapColors 2 254 60) ; ByPercent
		(cond
			((== gCombatMonsterNum 855) ; horror
				(= picture 700)
			)
			(
				(OneOf
					gPrevRoomNum
					620
					621
					622
					623
					624
					625
					626
					627
					628
					629
					630
					631
					632
					633
					634
					640
					641
					642
					644
					660
					661
					662
					663
					664
					670
					680
					610
				)
				(= picture 690)
			)
			((OneOf gPrevRoomNum 530 535 541 542 543 545) ; swamp1, swamp2, swamp3
				(= picture 550)
			)
			((== gPrevRoomNum 720)
				(= picture 700)
			)
			(else
				(= picture 430)
			)
		)
		(if (< 2700 gClock 2801)
			(PalVary 9 (+ picture 1)) ; PalVaryMergeSource
		)
		(proc0_16)
		(proc0_13)
		(Palette 2 66 85 100) ; PalIntensity
		(gGlory
			setCursor:
				(IconBarCursor
					view: (if (IsFlag 374) 997 else 994)
					loop: 0
					cel: 0
					yourself:
				)
		)
		(= local2 (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, vitality
		(= local3 (/ (+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) 3)) ; intelligence, magic, magic
		(= local4 (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; strength, vitality, vitality
		(= local1 local2)
		(= local9 0)
		(if (== gPrevRoomNum 575)
			(SetFlag 381)
		)
		(= global167 0)
		(= global168 0)
		(= global169 0)
		(= global170 0)
		(= global171 0)
		(= global172 0)
		(= global173 0)
		(= global174 0)
		(= global175 0)
		(ClearFlag 376)
		(= local10 ((gInventory at: 5) amount:)) ; theThrowdagger
		(= temp0 (/ [gEgoStats 3] 100)) ; vitality
		(= local0 (= local15 (- 19 (* temp0 temp0))))
		(= global193 0)
		(= gDagger 0)
		(= global187 0)
		(= global189 0)
		(= global192 0)
		((ScriptID 0 21) doit: 100) ; statusCode
		(= gCombatMonsterActor (ScriptID gCombatMonsterNum 0))
		(gLongSong
			number:
				(switch gCombatMonsterNum
					(820 821)
					(825 825) ; badder
					(830 831) ; revenant
					(835 836) ; wyvern
					(840 841) ; chernovy
					(850 851) ; wraith
					(870 871) ; nectar
					(855 856) ; horror
				)
		)
		(if (!= gCombatMonsterNum 830) ; revenant
			(gLongSong setLoop: -1 play:)
		)
		(= global180
			(switch gCombatMonsterNum
				(820 100)
				(830 250) ; revenant
				(835 300) ; wyvern
				(840 300) ; chernovy
				(850 ; wraith
					(if (IsFlag 381) 400 else 300)
				)
				(870 350) ; nectar
				(855 400) ; horror
				(825 ; badder
					(cond
						(
							(and
								(> (= local16 global462) 0)
								(> (= local17 global463) 0)
								(> (= local18 global464) 0)
							)
							(+= global156 (+ global462 global463 global464))
							200
						)
						((and (> global462 0) (> global463 0))
							(+= global156 (+ global462 global463))
							150
						)
						((and (> global462 0) (> global464 0))
							(+= global156 (+ global462 global464))
							150
						)
						((and (> global463 0) (> global464 0))
							(+= global156 (+ global463 global464))
							150
						)
						((> global462 0)
							(+= global156 global462)
							100
						)
						((> global463 0)
							(+= global156 global463)
							100
						)
						((> global464 0)
							(+= global156 global464)
							100
						)
						(else 50)
					)
				)
			)
		)
		(pCombat init: show: dispose:)
		(UpdatePlane (gThePlane back: 0 picture: -1 yourself:))
		(FrameOut)
		(self newRoom: gPrevRoomNum)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 global166) ((++ temp0))
			(localproc_2 24)
		)
		(for ((= temp0 0)) (< temp0 global167) ((++ temp0))
			(localproc_2 5)
		)
		(for ((= temp0 0)) (< temp0 global168) ((++ temp0))
			(localproc_2 7)
		)
		(for ((= temp0 0)) (< temp0 global169) ((++ temp0))
			(localproc_2 6)
		)
		(for ((= temp0 0)) (< temp0 global170) ((++ temp0))
			(localproc_2 10)
		)
		(for ((= temp0 0)) (< temp0 global171) ((++ temp0))
			(localproc_2 15)
		)
		(for ((= temp0 0)) (< temp0 global172) ((++ temp0))
			(localproc_2 26)
		)
		(for ((= temp0 0)) (< temp0 global173) ((++ temp0))
			(localproc_2 28)
		)
		(for ((= temp0 0)) (< temp0 global174) ((++ temp0))
			(localproc_2 33)
		)
		(for ((= temp0 0)) (< temp0 global175) ((++ temp0))
			(localproc_2 34)
		)
		((ScriptID 0 21) doit:) ; statusCode
		((gInventory at: 5) amount: local10) ; theThrowdagger
		(ClearFlag 381)
		(ClearFlag 386)
		(DisposeScript 38)
		(DisposeScript 40)
		(DisposeScript 41)
		(switch gCombatMonsterNum
			(850 ; wraith
				(DisposeScript 850)
			)
			(820
				(DisposeScript 820)
			)
			(830 ; revenant
				(DisposeScript 830)
			)
			(870 ; nectar
				(DisposeScript 870)
			)
			(840 ; chernovy
				(DisposeScript 840)
			)
			(835 ; wyvern
				(DisposeScript 835)
			)
			(855 ; horror
				(DisposeScript 855)
			)
			(825 ; badder
				(DisposeScript 825)
			)
		)
		(if (< [gEgoStats 18] 0) ; stamina
			(= [gEgoStats 18] 0) ; stamina
		)
		(if (< [gEgoStats 19] 0) ; mana
			(= [gEgoStats 19] 0) ; mana
		)
		(if (and (IsFlag 14) (> [gEgoStats 17] 0) (< [gEgoStats 17] 10)) ; health, health
			(= [gEgoStats 17] 10) ; health
		)
		(ClearFlag 378)
		(if (== gCombatMonsterNum 825) ; badder
			(if (> global156 0)
				(cond
					((> global156 150)
						(= global464 (- global156 150))
						(= global462 50)
						(= global463 50)
						(= global156 50)
					)
					((> global156 100)
						(= global463 (- global156 100))
						(= global462 50)
						(= global464 0)
						(= global156 50)
					)
					((> global156 50)
						(= global462 (- global156 50))
						(= global463 0)
						(= global464 0)
						(= global156 50)
					)
					(else
						(= global462 0)
						(= global463 0)
						(= global464 0)
					)
				)
			else
				(= global462 0)
				(= global463 0)
				(= global464 0)
				(= global156 0)
			)
		)
		(if (not gCombatResult)
			(if (<= [gEgoStats 17] 0) ; health
				(= gCombatResult 1)
			else
				(= gCombatResult 2)
			)
		)
		(= gCombatMonsterNum local19)
		(= gHeroType local20)
		(gLongSong2 stop:)
		(gLongSong3 stop:)
		(spellSound1 stop:)
		(spellSound2 stop:)
		(spellSound3 stop:)
		(gSounds eachElementDo: #clean self)
		(DisposeScript gCurRoomNum)
	)
)

(instance pCombat of CombatBar
	(properties)

	(method (init)
		(super init: &rest)
		((ScriptID 40 0) init: self) ; xMeterPanel
		((ScriptID 40 1) init: self) ; xLeftSpell
		((ScriptID 40 2) init: self) ; xRightSpell
		(egoSpell init: self)
		(bloodDrop init: self)
		((ScriptID 40 3) init: self) ; xStaminaPart
		(if [gEgoStats 12] ; magic
			((ScriptID 40 4) init: self) ; xMagicPart
		)
		((ScriptID 40 5) init: self) ; xHealthPart
		((ScriptID 40 6) init: self) ; xMonsterPart
		(if (== gHeroType 2) ; Thief
			(dagger init: self)
		)
		(self add: ego1 gCombatMonsterActor)
		(if (not (IsFlag 378))
			(self add: (ScriptID 40 7)) ; xRunButton
		)
		(if [gEgoStats 24] ; zapSpell
			(self add: (ScriptID 40 8)) ; xZapButton
		)
		(if [gEgoStats 26] ; flameDartSpell
			(self add: (ScriptID 40 9)) ; xFlameButton
		)
		(if [gEgoStats 33] ; lightningSpell
			(self add: (ScriptID 40 10)) ; xLitButton
		)
		(if [gEgoStats 28] ; forceSpell
			(self add: (ScriptID 40 11)) ; xForceButton
		)
		(if [gEgoStats 34] ; frostSpell
			(self add: (ScriptID 40 12)) ; xFrostButton
		)
		(self add: (ScriptID 40 14)) ; xModeButton
	)

	(method (dispatchEvent &tmp temp0)
		(if (and (< [gEgoStats 18] local1) (not (-- local0))) ; stamina
			(++ [gEgoStats 18]) ; stamina
			(= local0 local15)
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
		(super dispatchEvent:)
	)

	(method (resetPuzzle)
		(= local6 (+ (ego1 width:) (gCombatMonsterActor width:) 10))
		(switch gCombatMonsterNum
			(850 ; wraith
				(bloodDrop setLoop: 11 1)
			)
			(else
				(bloodDrop setLoop: 10 1)
			)
		)
		(= local7
			(cond
				((OneOf gHeroType 2 1) 7) ; Thief, Magic User
				((== ((gInventory at: 19) state:) 2) 18) ; theSword
				(else 12)
			)
		)
		(= local8
			(switch gCombatMonsterNum
				(850 4) ; wraith
				(820 1)
				(830 5) ; revenant
				(870 7) ; nectar
				(840 4) ; chernovy
				(835 9) ; wyvern
				(855 9) ; horror
				(825 3) ; badder
			)
		)
	)

	(method (move param1 &tmp temp0)
		(cond
			(argc
				(switch param1
					(0
						(if (not (ego1 script:))
							(ego1 setScript: (ScriptID 41 7)) ; xGoForward
						)
					)
					(1
						(if (not (ego1 script:))
							(ego1 setScript: (ScriptID 41 8)) ; xGoBackward
						)
					)
					(4
						(if (and (not (ego1 script:)) (> [gEgoStats 18] 7)) ; stamina
							(switch gCombatMonsterNum
								(820
									(ego1 setScript: lowSlash)
								)
								(825 ; badder
									(ego1 setScript: highSlash)
								)
								(else
									(ego1 setScript: slash)
								)
							)
						)
					)
					(3
						(if (and (not (ego1 script:)) (> [gEgoStats 18] 7)) ; stamina
							(SetNowSeen ego1)
							(SetNowSeen gCombatMonsterActor)
							(if (< (+ (ego1 nsRight:) 25) (gCombatMonsterActor nsLeft:))
								(ego1 setScript: jumpAttack)
							else
								(ego1 setScript: jumpVAttack)
							)
						)
					)
					(6
						(if (not (ego1 script:))
							(if (== gCombatMonsterNum 820)
								(ego1 setScript: toParryLow)
							else
								(ego1 setScript: toDuck)
							)
						)
					)
					(7
						(if (not (IsFlag 378))
							(= gCombatResult 3)
							(&= state $ffdf)
						)
					)
					(8
						((ScriptID 40 8) select:) ; xZapButton
					)
					(9
						((ScriptID 40 9) select:) ; xFlameButton
					)
					(11
						((ScriptID 40 11) select:) ; xForceButton
					)
					(10
						((ScriptID 40 10) select:) ; xLitButton
					)
					(12
						((ScriptID 40 12) select:) ; xFrostButton
					)
					(13
						(if
							(and
								(not (dagger active:))
								(> [gEgoStats 18] 0) ; stamina
								(not (ego1 script:))
								(> ((gInventory at: 5) amount:) 1) ; theThrowdagger
							)
							(-= [gEgoStats 18] (Random 6 12)) ; stamina
							(= temp0 (proc810_1 18))
							(UpdateScreenItem
								((ScriptID 40 3) ; xStaminaPart
									x: (- temp0 46)
									setInsetRect: (- 80 temp0) 0 80 2
									yourself:
								)
							)
							(= global187 16)
							(ego1 setScript: throwDagger)
						)
					)
					(2
						(if (and (> [gEgoStats 18] 0) (not (ego1 script:))) ; stamina
							(ego1 setScript: jumpUp)
						)
					)
					(14
						(if
							(and
								(not (ego1 script:))
								(OneOf gHeroType 2 1) ; Thief, Magic User
							)
							(ego1 setScript: jabHigh)
						)
					)
					(15
						(if
							(and
								(not (ego1 script:))
								(!= ((gInventory at: 19) state:) 2) ; theSword
							)
							(ego1 setScript: jabLow)
						)
					)
					(16
						(if (not (ego1 script:))
							(ego1 setScript: jumpVAttack)
						)
					)
					(17
						(if (and (> [gEgoStats 18] 0) (not (ego1 script:))) ; stamina
							(SetNowSeen ego1)
							(SetNowSeen gCombatMonsterActor)
							(if (< (+ (ego1 nsRight:) 42) (gCombatMonsterActor nsLeft:))
								(ego1 setScript: jumpForward)
							else
								(ego1 setScript: jumpUp)
							)
						)
					)
					(18
						(if (and (> [gEgoStats 18] 0) (> (ego1 x:) 50)) ; stamina
							(if (> (gEgo x:) 40)
								(ego1 setScript: flipBack)
							else
								(ego1 setScript: jumpUp)
							)
						)
					)
					(19
						(if (not (ego1 script:))
							(ego1 setScript: toParryHigh)
						)
					)
					(20
						(if (not (ego1 script:))
							(ego1 setScript: toParryLow)
						)
					)
				)
			)
			((not (ego1 script:))
				(if (> (combatEvent x:) (ego1 x:))
					(ego1 setScript: (ScriptID 41 7)) ; xGoForward
				else
					(ego1 setScript: (ScriptID 41 8)) ; xGoBackward
				)
			)
		)
	)
)

(instance jabHigh of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ego1
					view: (ego1 typeView:)
					setLoop: 6 1
					cycleSpeed: 6
					cel: 0
					attackCode: 14
					setCycle: End self
				)
				(++ global167)
			)
			(1
				(if (<= (Abs (- (ego1 x:) (gCombatMonsterActor x:))) 10)
					(gCombatMonsterActor getHurt: 2)
					(= temp0 (proc810_1 -1))
					(UpdateScreenItem
						((ScriptID 40 6) ; xMonsterPart
							x: (+ 100 temp0)
							setInsetRect: (- 104 temp0) 0 104 2
							yourself:
						)
					)
				)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance jabLow of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ego1
					view: (ego1 typeView:)
					setLoop: 5 1
					cel: 0
					cycleSpeed: 6
					attackCode: 15
					setCycle: End self
				)
				(++ global167)
			)
			(1
				(ego1 setCycle: Beg self)
			)
			(2
				(if (<= (Abs (- (ego1 x:) (gCombatMonsterActor x:))) 10)
					(gCombatMonsterActor getHurt: 2)
					(= temp0 (proc810_1 -1))
					(UpdateScreenItem
						((ScriptID 40 6) ; xMonsterPart
							x: (+ 100 temp0)
							setInsetRect: (- 104 temp0) 0 104 2
							yourself:
						)
					)
				)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance toBomb of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(SetNowSeen gCombatMonsterActor)
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 9 1
					cel: 0
					xStep: 15
					cycleSpeed: 1
					moveSpeed: 0
					setCycle: Fwd
					attackCode: 22
					setMotion: MoveTo (gCombatMonsterActor nsLeft:) (ego1 y:) self
				)
				(++ global171)
			)
			(1
				(if (ObjectIntersect gCombatMonsterActor ego1)
					(if (< (= temp1 (/ global156 3)) 20)
						(= temp1 20)
					)
					(if (> (-= global156 temp1) 0)
						(= temp0 (proc810_1 -1))
						(UpdateScreenItem
							((ScriptID 40 6) ; xMonsterPart
								x: (+ 100 temp0)
								setInsetRect: (- 104 temp0) 0 104 2
								yourself:
							)
						)
						(ego1 setMotion: MoveTo 45 (ego1 y:) self)
					else
						(= gCombatResult 2)
						(pCombat state: (& (pCombat state:) $ffdf))
					)
				else
					(self cue:)
				)
			)
			(2
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance toDuck of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(not state)
				(or
					(OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
					(and
						(& ((gPuzzleBar combatEvent:) type:) $0200)
						(>= ((gPuzzleBar combatEvent:) z:) 0)
					)
				)
			)
			(if
				(and
					(== gHeroType 2) ; Thief
					(> [gEgoStats 18] 35) ; stamina
					(gCombatMonsterActor
						onMe:
							((pCombat combatEvent:) x:)
							((pCombat combatEvent:) y:)
					)
				)
				(-= [gEgoStats 18] 35) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				(client setScript: toBomb)
			else
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 0)
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 6 1
					cel: 0
					attackCode: 6
				)
				(++ global168)
			)
			(1
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance toParryHigh of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not state)
				(or
					(OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
					(and
						(& ((gPuzzleBar combatEvent:) type:) $0200)
						(>= ((gPuzzleBar combatEvent:) z:) 0)
					)
				)
			)
			(&= global192 $fffe)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(|= global192 $0001)
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: (if (== (ego1 typeView:) 44) 2 else 0) 1
					cel: 0
					attackCode: 19
				)
				(++ global169)
			)
			(1
				(ego1 cue:)
				(&= global192 $fffe)
				(self dispose:)
			)
		)
	)
)

(instance toParryLow of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not state)
				(or
					(OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
					(and
						(& ((gPuzzleBar combatEvent:) type:) $0200)
						(>= ((gPuzzleBar combatEvent:) z:) 0)
					)
				)
			)
			(&= global192 $fffd)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(|= global192 $0002)
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: (if (== (ego1 typeView:) 44) 3 else 1) 1
					cel: 0
					attackCode: 20
				)
				(++ global169)
			)
			(1
				(ego1 cue:)
				(&= global192 $fffd)
				(self dispose:)
			)
		)
	)
)

(instance slash of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen ego1)
		(if
			(and
				register
				(or
					(gCombatMonsterActor
						onMe:
							(+ (ego1 nsLeft:) global182)
							(+ (ego1 nsTop:) global183)
					)
					(and
						(== state 2)
						(| (SetNowSeen gCombatMonsterActor) $0001)
						(>= (ego1 nsRight:) (gCombatMonsterActor nsLeft:))
					)
				)
			)
			(= register 0)
			(bloodDrop
				x: (+ (ego1 nsLeft:) global182)
				y: (+ (ego1 nsTop:) global183)
				cel: 0
				setCycle: End bloodDrop
				setPri: (+ (gCombatMonsterActor priority:) 2)
				show:
			)
			(gCombatMonsterActor getHurt: 2)
			(ego1 dedectPts: (proc810_2))
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 0)
				(if local9
					(= ticks local9)
					(= local9 0)
				else
					(self cue:)
				)
			)
			(1
				(ego1
					view: (ego1 typeView:)
					setLoop: 7 1
					cel: 0
					cycleSpeed: 5
					attackCode: 4
					setCycle: CT 3 1 self
				)
				(++ global167)
				(proc810_13 0 901)
			)
			(2
				(= register 1)
				(= ticks 5)
			)
			(3
				(ego1 setCycle: End self)
			)
			(4
				(-= [gEgoStats 18] (Random 5 15)) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				(= local9 5)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance highSlash of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(SetNowSeen ego1)
		(if
			(and
				register
				(gCombatMonsterActor
					onMe: (+ (ego1 nsLeft:) local11) (+ (ego1 nsTop:) local12)
				)
			)
			(= register 0)
			(bloodDrop
				x: (+ (ego1 nsLeft:) global182)
				y: (+ (ego1 nsTop:) global183)
				cel: 0
				setCycle: End bloodDrop
				setPri: (+ (gCombatMonsterActor priority:) 2)
				show:
			)
			(= temp0 (proc810_2))
			(if (== gCombatMonsterNum 825) ; badder
				(cond
					((> local18 0)
						(if (> temp0 local16)
							(= temp0 local16)
							(= local18 0)
						)
					)
					((> local17 0)
						(if (> temp0 local17)
							(= temp0 local17)
							(= local17 0)
						)
					)
					((and (> local16 0) (> temp0 local16))
						(= temp0 local16)
						(= local16 0)
					)
				)
			)
			(ego1 dedectPts: temp0)
			(gCombatMonsterActor getHurt: 2)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ego1
					view: (ego1 typeView:)
					setLoop: 8 1
					cel: 0
					cycleSpeed: 5
					attackCode: 4
					setCycle: CT 3 1 self
				)
				(proc810_13 0 901)
				(++ global167)
			)
			(1
				(= ticks 5)
			)
			(2
				(ego1 setCycle: End self)
			)
			(3
				(-= [gEgoStats 18] (Random 5 15)) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance lowSlash of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen ego1)
		(if
			(and
				register
				(gCombatMonsterActor
					onMe: (+ (ego1 nsLeft:) local13) (+ (ego1 nsTop:) local14)
				)
			)
			(= global184 0)
			(= register 0)
			(bloodDrop
				x: (+ (ego1 nsLeft:) local13)
				y: (+ (ego1 nsTop:) local14)
				cel: 0
				setCycle: End bloodDrop
				setPri: (+ (gCombatMonsterActor priority:) 2)
				show:
			)
			(gCombatMonsterActor getHurt: 2)
			(ego1 dedectPts: (proc810_2))
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global184 1)
				(= register 1)
				(ego1
					view: (ego1 typeView:)
					setLoop: 9 1
					cel: 0
					cycleSpeed: 5
					attackCode: 4
					setCycle: CT 2 1 self
				)
				(proc810_13 0 901)
				(++ global167)
			)
			(1
				(= ticks 10)
			)
			(2
				(ego1 setCycle: End self)
			)
			(3
				(= global184 0)
				(-= [gEgoStats 18] (Random 5 15)) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				(= local9 5)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance jumpAttack of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (OneOf state 1 2) (> [gEgoStats 18] 0)) ; stamina
			(-- [gEgoStats 18]) ; stamina
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= ticks local9)
					(= local9 0)
				else
					(self cue:)
				)
			)
			(1
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 7 1
					cel: 0
					cycleSpeed: 3
					xStep: 6
					attackCode: 3
					setCycle: CT 5 1
					moveSpeed: 0
					setMotion: ShotTo (+ (ego1 x:) 42) (ego1 y:) self
				)
				(proc810_13 0 903)
				(++ global167)
			)
			(2
				(ego1
					setCycle:
						CombatAttack
						7
						1
						self
						gCombatMonsterActor
						local6
						6
						(proc810_2)
				)
				(proc810_13 0 901)
			)
			(3
				(if
					(and
						(> (- (ego1 x:) 18) (ego1 width:))
						(not (& (bloodDrop signal:) $0008))
					)
					(ego1 setMotion: ShotTo (- (ego1 x:) 18) (ego1 y:) self)
				else
					(self cue:)
				)
			)
			(4
				(proc810_13 0 910)
				(= local9 10)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance jumpVAttack of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (OneOf state 1 2) (> [gEgoStats 18] 0)) ; stamina
			(-- [gEgoStats 18]) ; stamina
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= ticks local9)
					(= local9 0)
				else
					(self cue:)
				)
			)
			(1
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 7 1
					cel: 0
					cycleSpeed: 4
					attackCode: 16
					xStep: 6
					setCycle: CT 5 1 self
					moveSpeed: 0
				)
				(proc810_13 0 903)
			)
			(2
				(++ global167)
				(ego1
					setCycle:
						CombatAttack
						7
						1
						self
						gCombatMonsterActor
						local6
						6
						(proc810_2)
				)
				(proc810_13 0 901)
			)
			(3
				(if
					(and
						(> (- (ego1 x:) 18) (ego1 width:))
						(not (& (bloodDrop signal:) $0008))
					)
					(ego1 setMotion: ShotTo (- (ego1 x:) 18) (ego1 y:) self)
				else
					(self cue:)
				)
			)
			(4
				(= local9 10)
				(proc810_13 0 910)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance jumpUp of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (OneOf state 0 1) (> [gEgoStats 18] 0)) ; stamina
			(-- [gEgoStats 18]) ; stamina
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 5 1
					cycleSpeed: 3
					cel: 0
					attackCode: 2
					setCycle: CT 4 1 self
				)
				(proc810_13 0 903)
			)
			(1
				(= ticks 10)
			)
			(2
				(ego1 setCycle: End self)
			)
			(3
				(proc810_13 0 910)
				(++ global168)
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance jumpForward of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== state 1) (> [gEgoStats 18] 0)) ; stamina
			(-- [gEgoStats 18]) ; stamina
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= ticks local9)
					(= local9 0)
				else
					(self cue:)
				)
			)
			(1
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 5 1
					cycleSpeed: 6
					cel: 0
					attackCode: 3
					setCycle: End self
					setMotion: ShotTo (+ (ego1 x:) 42) (ego1 y:)
				)
				(proc810_13 0 903)
			)
			(2
				(= local9 5)
				(++ global168)
				(proc810_13 0 910)
				(ego1 cue: setMotion: 0)
				(self dispose:)
			)
		)
	)
)

(instance flipBack of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== state 1) (> [gEgoStats 18] 0)) ; stamina
			(-- [gEgoStats 18]) ; stamina
			(= temp0 (proc810_1 18))
			(UpdateScreenItem
				((ScriptID 40 3) ; xStaminaPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= ticks local9)
					(= local9 0)
				else
					(self cue:)
				)
			)
			(1
				(ego1
					view: (+ (ego1 typeView:) 1)
					setLoop: 5 1
					cycleSpeed: 6
					cel: 0
					attackCode: 18
					setCycle: End self
					setMotion: ShotTo (- (ego1 x:) 42) (ego1 y:)
				)
				(proc810_13 0 903)
			)
			(2
				(= local9 5)
				(proc810_13 0 910)
				(ego1 cue: setMotion: 0)
				(self dispose:)
			)
		)
	)
)

(instance throwDagger of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ego1
					view: (ego1 typeView:)
					setLoop: 10 1
					cel: 0
					cycleSpeed: 6
					attackCode: 13
					setCycle: End self
				)
			)
			(1
				(dagger
					myTarget: gCombatMonsterActor
					x: (+ (ego1 x:) 45)
					y: (= temp0 (- (ego1 y:) 35))
					setLoop: 13 1
					setPri: (+ (ego1 priority:) 5)
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: ShotTo 330 temp0 dagger
					show:
				)
				(++ global170)
				(ego1 setCycle: Beg self)
			)
			(2
				(ego1 cue:)
				(self dispose:)
			)
		)
	)
)

(instance ego1 of SActor
	(properties
		x 50
		y 138
	)

	(method (init)
		(= gCombatEgoActor self)
		(= typeView
			(cond
				((OneOf gHeroType 2 1) 44) ; Thief, Magic User
				((== ((gInventory at: 19) state:) 2) 24) ; theSword
				((== ((gInventory at: 19) state:) 3) 27) ; theSword
				(else 22)
			)
		)
		(self cue:)
		(super init: &rest)
		(|= signal $1000)
		(if (IsFlag 374)
			(self setScript: (ScriptID gCombatMonsterNum 1))
		)
	)

	(method (cue)
		(= view typeView)
		(= cel (= loop 0))
		(= y 138)
		(= attackCode 0)
		(= cycleSpeed 16)
		(= global192 0)
		(self setCycle: Fwd)
		(cond
			((IsFlag 376)
				(ClearFlag 376)
				(if (IsFlag 374)
					(ClearFlag 374)
					((ScriptID 40 14) show:) ; xModeButton
					(gGlory
						setCursor:
							(IconBarCursor view: 994 loop: 0 cel: 0 yourself:)
					)
					(self setScript: 0)
				else
					(SetFlag 374)
					(gGlory
						setCursor:
							(IconBarCursor view: 997 loop: 0 cel: 0 yourself:)
					)
					(self setScript: (ScriptID gCombatMonsterNum 1))
				)
			)
			((IsFlag 374)
				(self setScript: (ScriptID gCombatMonsterNum 1))
			)
		)
	)

	(method (getHurt param1 &tmp temp0 temp1)
		(= temp1 param1)
		(if global453
			(/= temp1 2)
		)
		(if (<= (-= [gEgoStats 17] temp1) 0) ; health
			(= [gEgoStats 17] 0) ; health
			(= gCombatResult 1)
			(pCombat noHands: 1)
			(SetFlag 386)
		)
		(= temp0 (proc810_1 17))
		(UpdateScreenItem
			((ScriptID 40 5) ; xHealthPart
				x: (- temp0 94)
				setInsetRect: (- 104 temp0) 0 104 2
				yourself:
			)
		)
		(if global186
			(= global186 0)
			(UpdateScreenItem
				((ScriptID 40 1) x: 159 setInsetRect: 0 0 0 0 yourself:) ; xLeftSpell
			)
			(UpdateScreenItem
				((ScriptID 40 2) x: 119 setInsetRect: 0 0 0 -1 yourself:) ; xRightSpell
			)
		)
	)

	(method (dedectPts param1 &tmp temp0)
		(if (<= (-= global156 param1) 0)
			(= global156 0)
			(= gCombatResult 2)
			(pCombat noHands: 1)
			(SetFlag 386)
		)
		(if (& (bloodDrop signal:) $0008)
			(bloodDrop
				x: (+ (ego1 nsLeft:) local13)
				y: (+ (ego1 nsTop:) local14)
				cel: 0
				setCycle: End bloodDrop
				setPri: (+ (gCombatMonsterActor priority:) 2)
				show:
			)
		)
		(= temp0 (proc810_1 -1))
		(UpdateScreenItem
			((ScriptID 40 6) ; xMonsterPart
				x: (+ 100 temp0)
				setInsetRect: (- 104 temp0) 0 104 2
				yourself:
			)
		)
	)

	(method (doVerb)
		(if (not script)
			(if (== gCombatMonsterNum 820)
				(ego1 setScript: toParryLow)
			else
				(switch ((pCombat combatEvent:) modifiers:)
					(3
						(self setScript: toParryLow)
					)
					(4
						(self setScript: toParryLow)
					)
					(8
						(self setScript: toParryHigh)
					)
					(else
						(self setScript: toDuck)
					)
				)
			)
		)
	)
)

(instance egoSpell of CombatSpell
	(properties
		signal 16384
		xStep 10
		moveSpeed 0
	)

	(method (init)
		(= gEgoSpell self)
		(super init: &rest)
		(self cue:)
	)

	(method (setMotion param1 &tmp temp0)
		(if param1
			(-= [gEgoStats 19] local5) ; mana
			(= temp0 (proc810_1 19))
			(UpdateScreenItem
				((ScriptID 40 4) ; xMagicPart
					x: (- temp0 46)
					setInsetRect: (- 80 temp0) 0 80 2
					yourself:
				)
			)
		)
		(switch type
			(26
				(proc810_13 2 933)
			)
			(28
				(proc810_13 2 938)
			)
			(33
				(proc810_13 2 934)
			)
			(34
				(proc810_13 2 940)
			)
		)
		(super setMotion: param1 &rest)
	)

	(method (setCycle param1)
		(if (== param1 End)
			(proc810_13 2 944)
		)
		(super setCycle: param1 &rest)
	)

	(method (doit)
		(if (super doit:)
			(cond
				(global189
					(if
						(and
							global193
							(global193 active:)
							(self onMe: (global193 x:) (global193 y:))
						)
						(global193 active: 0 cue:)
					)
				)
				(
					(and
						global193
						(global193 active:)
						(self onMe: (global193 x:) (global193 y:))
					)
					(= myTarget 0)
					(global193 active: 0 cue:)
					(self
						active: 0
						setPri: 240
						setMotion: 0
						setLoop: (+ loop (if (> loop 5) 1 else 2)) 1
						cel: 0
						setCycle: End self
					)
				)
			)
		)
	)

	(method (cue)
		(= global189 0)
		(self hide:)
	)

	(method (toDamage &tmp temp0 temp1)
		(if (or global189 (!= (gCombatMonsterActor attackCode:) 23))
			(if (< (= temp1 (- (/ [gEgoStats type] global165) (Random 1 9))) 5)
				(= temp1 5)
			)
			(switch gCombatMonsterNum
				(855 ; horror
					(if (== type 34)
						(*= temp1 2)
					else
						(= temp1 0)
					)
				)
				(830 ; revenant
					(switch type
						(34
							(= temp1 0)
						)
						(26
							(*= temp1 2)
						)
					)
				)
				(850 ; wraith
					(if (== type 34)
						(= temp1 0)
					else
						(/= temp1 2)
					)
				)
			)
			(if (<= (-= global156 temp1) 0)
				(= global156 0)
				(= gCombatResult 2)
				(pCombat noHands: 1)
				(SetFlag 386)
			)
			(= temp0 (proc810_1 -1))
			(UpdateScreenItem
				((ScriptID 40 6) ; xMonsterPart
					x: (+ 100 temp0)
					setInsetRect: (- 104 temp0) 0 104 2
					yourself:
				)
			)
			(SetNowSeen gCombatMonsterActor)
			(self
				setPri: 240
				setMotion: 0
				setLoop: (+ loop (if (> loop 5) 1 else 2)) 1
				cel: 0
				x: (+ (gCombatMonsterActor nsLeft:) (gCombatMonsterActor explodeX:))
				setCycle: End self
			)
			(if (> temp1 0)
				(oldTarget setMotion: 0 setCycle: 0)
				(oldTarget getHurt: 0)
			)
			(= hit 1)
		)
	)
)

(instance dagger of CombatSpell
	(properties
		view 44
		loop 13
		signal 16384
		moveSpeed 0
		type 10
	)

	(method (show)
		(super show: &rest)
		((gInventory at: 5) amount: (- ((gInventory at: 5) amount:) 1)) ; theThrowdagger, theThrowdagger
	)

	(method (init)
		(super init: &rest)
		(= gDagger self)
		(self cue:)
	)

	(method (toDamage &tmp temp0 temp1)
		(if
			(<=
				(= temp1
					(-
						(+ (/ [gEgoStats 5] 10) global142 local7) ; weapon-use
						(+ local8 (Random 1 10))
					)
				)
				0
			)
			(= temp1 1)
		)
		(if global142
			(= global142 0)
			((ScriptID 40 8) cel: 2) ; xZapButton
			(UpdateScreenItem (ScriptID 40 8)) ; xZapButton
		)
		(if (>= (-= global156 temp1) 0)
			(oldTarget setMotion: 0 setCycle: 0 getHurt: 2)
			(= temp0 (proc810_1 -1))
			(UpdateScreenItem
				((ScriptID 40 6) ; xMonsterPart
					x: (+ 100 temp0)
					setInsetRect: (- 104 temp0) 0 104 2
					yourself:
				)
			)
			(self
				setMotion: 0
				setLoop: 14 1
				cel: 0
				setPri: (+ (gCombatMonsterActor priority:) 1)
				setCycle: End self
			)
		else
			(= gCombatResult 2)
			(pCombat noHands: 1)
			(SetFlag 386)
		)
	)

	(method (cue)
		(self hide:)
	)
)

(instance bloodDrop of SActor
	(properties
		view 26
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self cue:)
	)

	(method (cue)
		(self hide:)
	)
)

(instance spellSound1 of Sound
	(properties)
)

(instance spellSound2 of Sound
	(properties)
)

(instance spellSound3 of Sound
	(properties)
)

