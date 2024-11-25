;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 814)
(include sci.sh)
(use Main)
(use n104)
(use n105)
(use n106)
(use Print)
(use PolyPath)
(use StopWalk)
(use Inventory)
(use User)
(use System)

(public
	EgoDead 0
	PrintTimeAndDay 1
	EgoGait 2
	NormalEgo 3
	AlreadyDone 5
	CantDo 6
	DontHave 7
	RedrawCast 8
	HaveMem 9
	Face 10
	HaveMoney 11
	FixTime 12
	NextDay 13
	Random100 14
	TrySkill 15
	SkillUsed 16
	UseStamina 17
	UseMana 18
	TakeDamage 19
	MaxStamina 20
	MaxHealth 21
	MaxMana 22
	MaxLoad 23
	CastSpell 24
	SoundFX 25
	SolvePuzzle 26
	EatMeal 27
	WtCarried 28
	CanPickLocks 29
	proc814_30 30
	proc814_31 31
	proc814_32 32
	CastArea 33
)

(local
	local0
)

(procedure (EgoDead param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 120] [temp128 50] [temp178 4] [temp182 4])
	(= temp0 (if (and argc param1) param1 else 82))
	(= temp1 (if (and (> argc 1) param2) param2 else 83))
	(= temp2 (Random 0 2))
	(= temp3 0)
	(= temp4 800)
	(if (>= argc 3)
		(= temp2 param3)
		(if (>= argc 4)
			(= temp3 param4)
			(if (>= argc 5)
				(= temp4 param5)
			)
		)
	)
	(HandsOff)
	(Wait 100)
	(gGame setCursor: gNormalCursor 1)
	(gSounds eachElementDo: #stop)
	(if global275
		(gLongSong number: global275 priority: 15 loop: 1 110 play:)
	)
	(= temp6 (+ (CelWide temp4 temp3 temp2) 10))
	(Message msgGET 815 1 0 temp1 1 @temp128)
	(TextSize @temp182 @temp128 123 260)
	(Message msgGET 815 1 0 temp0 1 @temp8)
	(TextSize @temp178 @temp8 gUserFont (- 260 temp6))
	(= temp5 (+ (- [temp182 2] [temp182 0]) 10))
	(= temp7
		(+
			(Max
				(+ (- [temp178 2] [temp178 0]) 10)
				(CelHigh temp4 temp3 temp2)
			)
			temp5
			10
		)
	)
	(repeat
		(switch
			(Print
				width: 260
				font: 123
				addText: @temp128 0 0
				font: gUserFont
				mode: 1
				addIcon: temp4 temp3 temp2 0 temp5
				width: (- 260 temp6)
				addText: @temp8 temp6 temp5
				addButton: 1 {Restore} 0 temp7
				addButton: 2 {Restart} 70 temp7
				addButton: 3 {____Quit____} 140 temp7
				init:
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (PrintTimeAndDay &tmp temp0 [temp1 20] [temp21 30])
	(= temp0 gDay)
	(Format
		@temp1
		(switch gTimeOfDay
			(0 {Day is dawning})
			(1 {It is mid-morning})
			(2 {It is midday})
			(3 {It is mid-afternoon})
			(4 {Sunset approaches})
			(5 {The night is still young})
			(6 {It is the middle of the night})
			(7 {It is not yet dawn})
		)
	)
	(if (or (!= gTimeOfDay 6) (> gClock 500))
		(++ temp0)
	)
	(Print font: gUserFont addTextF: @temp21 {%s on day %d.} @temp1 temp0 init:)
)

(procedure (EgoGait param1 param2 &tmp temp0)
	(if (and param2 (not (User canControl:)))
		(gMessager say: 1 0 0 4 0 814) ; "You can't do that now."
		(return)
	)
	(if (!= param1 -1)
		(= gEgoGait param1)
	)
	(switch gEgoGait
		(1 ; running
			(gEgo view: 5 setStep: 8 4 setCycle: StopWalk 4)
			((gTheIconBar at: 1) loop: 6 cursor: 937)
		)
		(2 ; sneaking
			(gEgo view: 6 setStep: 3 2 setCycle: StopWalk 8)
			((gTheIconBar at: 1) loop: 8 cursor: 947)
		)
		(else
			(gEgo
				view: 0
				setStep: 3 2
				cycleSpeed: (gEgo moveSpeed:)
				setCycle: StopWalk 4
			)
			((gTheIconBar at: 1) loop: 0 cursor: 940)
		)
	)
	(if (and (IsObject (gEgo mover:)) ((gEgo mover:) isKindOf: PolyPath))
		(gEgo
			setMotion:
				PolyPath
				((gEgo mover:) finalX:)
				((gEgo mover:) finalY:)
		)
	)
)

(procedure (NormalEgo param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0
		(switch gEgoGait
			(1 5) ; running
			(2 6) ; sneaking
			(else 0)
		)
	)
	(= temp1 (if (== gEgoGait 2) 8 else 4)) ; sneaking
	(EgoGait -1 0)
	(if (not (User controls:))
		(gGame setCursor: gWaitCursor)
	)
	(if argc
		(gEgo loop: param1)
		(if (> argc 1)
			(= temp0 param2)
			(if (> argc 2)
				(= temp1 param3)
			)
		)
	)
	(= temp2
		(switch (gEgo loop:)
			(3 0)
			(6 45)
			(0 90)
			(4 135)
			(2 180)
			(5 225)
			(1 270)
			(7 315)
		)
	)
	(gEgo
		setPri: -1
		view: temp0
		setLoop: -1
		setLoop: (ScriptID 0 1) ; stopGroop
		setCycle: StopWalk temp1
		illegalBits: $8000
		ignoreHorizon:
		ignoreActors: 0
		heading: temp2
	)
)

(procedure (AlreadyDone)
	(gMessager say: 1 0 0 5 0 814) ; "You've already done that."
)

(procedure (CantDo)
	(gMessager say: 1 0 0 6 0 814) ; "You can't do that now."
)

(procedure (DontHave)
	(gMessager say: 1 0 0 7 0 814) ; "You don't have it."
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (HaveMem param1)
	(return (> (MemoryInfo 0) param1)) ; LargestPtr
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(cond
		((> (Abs (- temp0 (gEgo heading:))) 23)
			(param1 setHeading: temp0 (and (IsObject temp3) temp3))
		)
		((IsObject temp3)
			(temp3 cue:)
		)
	)
)

(procedure (HaveMoney param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 param1)
	(= temp1 1)
	(= temp3 ((gInventory at: 0) amount:)) ; silver
	(= temp4 (/ ((gInventory at: 0) amount:) 10)) ; silver
	(= temp2 (* ((gInventory at: 38) amount:) 10)) ; gold
	(= temp5 (not (mod temp0 10)))
	(cond
		((< (+ temp2 temp3) temp0)
			(= temp1 0)
		)
		((== (+ temp2 temp3) temp0)
			((gInventory at: 0) amount: 0) ; silver
			((gInventory at: 38) amount: 0) ; gold
		)
		((> temp3 temp0)
			((gInventory at: 0) amount: (- ((gInventory at: 0) amount:) temp0)) ; silver, silver
		)
		(temp4
			((gInventory at: 0) amount: (- ((gInventory at: 0) amount:) (* temp4 10))) ; silver, silver
			(-= temp0 (* temp4 10))
			((gInventory at: 38) ; gold
				amount:
					(-
						((gInventory at: 38) amount:) ; gold
						(+ (/ temp0 10) (if temp5 0 else 1))
					)
			)
			(if (not temp5)
				((gInventory at: 0) ; silver
					amount: (+ ((gInventory at: 0) amount:) (- 10 (mod temp0 10))) ; silver
				)
			)
		)
		(else
			((gInventory at: 38) ; gold
				amount:
					(-
						((gInventory at: 38) amount:) ; gold
						(+ (/ temp0 10) (if temp5 0 else 1))
					)
			)
			(if (not temp5)
				((gInventory at: 0) ; silver
					amount: (+ ((gInventory at: 0) amount:) (- 10 (mod temp0 10))) ; silver
				)
			)
		)
	)
	(return temp1)
)

(procedure (FixTime param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (^ gClock $0001))
	(if (>= argc 1)
		(= gClock (* 150 param1))
		(= global121 (GetTime 1)) ; SysTime12
		(if (>= argc 2)
			(+= gClock (/ (* 150 param2) 60))
		)
	)
	(^= gClock $0001)
	(= temp0 gTimeOfDay)
	(cond
		((< gClock 300)
			(= gTimeOfDay 6)
		)
		((< gClock 750)
			(= gTimeOfDay 7)
		)
		((< gClock 1200)
			(= gTimeOfDay 0)
		)
		((< gClock 1650)
			(= gTimeOfDay 1)
		)
		((< gClock 2100)
			(= gTimeOfDay 2)
		)
		((< gClock 2550)
			(= gTimeOfDay 3)
		)
		((< gClock 3000)
			(= gTimeOfDay 4)
		)
		((< gClock 3450)
			(= gTimeOfDay 5)
		)
		(else
			(= gTimeOfDay 6)
		)
	)
	(if (> gTimeOfDay 4)
		(= gNight 1)
		(ClearFlag 217)
		(PalVary pvINIT (gCurRoom picture:) 1)
		(if global451
			(PalVary pvCHANGE_TARGET global451)
		)
	else
		(= gNight 0)
		(PalVary pvREVERSE 1)
	)
)

(procedure (NextDay)
	(++ gDay)
	(ClearFlag 217)
)

(procedure (Random100)
	(return (+ 1 (/ (Random 0 999) 10)))
)

(procedure (TrySkill param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(if (not (= temp0 [gEgoStats param1]))
		(return 0)
	)
	(if (== argc 3)
		(+= temp0 param3)
	)
	(if param2
		(if (>= param1 5)
			(UseStamina (/ param2 10))
		)
	else
		(if (>= param1 5)
			(UseStamina (Random 1 6))
		)
		(= param2 (Random100))
	)
	(if (>= (localproc_0 4 1) (Random 1 200))
		(+= temp0 (Random 1 20))
	)
	(= temp3 (<= param2 temp0))
	(= temp1
		(cond
			((<= (= temp1 (Abs (- param2 temp0))) 10) 2)
			((<= temp1 30) 4)
			((<= temp1 50) 6)
			(else
				(return temp3)
			)
		)
	)
	(= temp2
		(cond
			((== param1 5)
				(/ (+ (localproc_0 2 2) (localproc_0 0 2)) 16)
			)
			((or (== param1 6) (== param1 7) (== param1 8))
				(/ (+ (localproc_0 2 3) (localproc_0 1 1)) 8)
			)
			((== param1 9)
				(/ (+ (localproc_0 2 3) (localproc_0 1 1)) 4)
			)
			((or (== param1 10) (== param1 11))
				(/ (+ (localproc_0 2 3) (localproc_0 0 2)) 5)
			)
			((>= param1 17)
				(/ (+ (localproc_0 12 4) (localproc_0 1 2)) 6)
			)
			(else 10)
		)
	)
	(SkillUsed param1 (/ temp2 temp1))
	(return temp3)
)

(procedure (SkillUsed param1 param2)
	(if (not [gEgoStats param1])
		(return 0)
	)
	(if (> (= param2 (Abs param2)) [gEgoStats param1])
		(= param2 [gEgoStats param1])
	)
	(+= [gEgoStats 13] (/ param2 4)) ; experience
	(+= [global150 param1] param2)
	(if (>= [global150 param1] [gEgoStats param1])
		(-= [global150 param1] [gEgoStats param1])
		(if (> (+= [gEgoStats param1] (Random 1 3)) 100)
			(= [gEgoStats param1] 100)
		)
		(return 1)
	)
	(return 0)
)

(procedure (UseStamina param1 &tmp temp0)
	(if (> param1 0)
		(SkillUsed 3 (/ (+ param1 3) 4)) ; vitality
	)
	(cond
		((< (= temp0 (-= [gEgoStats 15] param1)) 0) ; stamina
			(TakeDamage (/ (- -3 [gEgoStats 15]) 4)) ; stamina
			(= [gEgoStats 15] 0) ; stamina
			(if (not gFastCast)
				(cond
					((not (IsFlag 110))
						(SetFlag 110)
						(Wait 10)
						(gMessager say: 1 0 0 10 0 814) ; "You are so exhausted that everything you do hurts. Better get some rest."
					)
					((<= [gEgoStats 14] 0) ; health
						(EgoDead 64 65) ; "That was a little too much for you. You collapse from exhaustion and die."
					)
				)
			)
		)
		((> temp0 4)
			(ClearFlag 110)
			(if (> temp0 (MaxStamina))
				(= [gEgoStats 15] (MaxStamina)) ; stamina
			)
		)
	)
)

(procedure (UseMana param1)
	(if [gEgoStats 12] ; magic
		(if (< (-= [gEgoStats 16] param1) 0) ; mana
			(= [gEgoStats 16] 0) ; mana
		)
		(if (> [gEgoStats 16] (MaxMana)) ; mana
			(= [gEgoStats 16] (MaxMana)) ; mana
		)
		(if (> param1 0)
			(SkillUsed 1 (/ param1 5)) ; intelligence
			(SkillUsed 12 (/ param1 2)) ; magic
		)
	)
)

(procedure (TakeDamage param1)
	(if (> param1 0)
		(SkillUsed 3 (/ (+ param1 1) 2)) ; vitality
	)
	(if (< (-= [gEgoStats 14] param1) 0) ; health
		(= [gEgoStats 14] 0) ; health
	)
	(if (> [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 14] (MaxHealth)) ; health
	)
	(return (> [gEgoStats 14] 0)) ; health
)

(procedure (MaxStamina)
	(return (* (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, vitality
)

(procedure (MaxHealth &tmp temp0)
	(return (* 2 (= temp0 (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)))) ; strength, vitality, vitality
)

(procedure (MaxMana &tmp temp0)
	(if (= temp0 [gEgoStats 12]) ; magic
		(return (/ (+ [gEgoStats 1] temp0 temp0) 3)) ; intelligence
	else
		(return 0)
	)
)

(procedure (MaxLoad)
	(return (+ 40 (/ [gEgoStats 0] 2))) ; strength
)

(procedure (CastSpell param1 &tmp temp0)
	(if (< [gEgoStats 16] [global176 (+ (- param1 17) 1)]) ; mana
		(gMessager say: 1 0 0 11 0 814) ; "You don't have enough Magic Points to cast that spell."
		(Wait 30)
		(= temp0 0)
	else
		(TrySkill param1 0)
		(UseMana [global176 (+ (- param1 17) 1)])
		(= temp0 1)
	)
	(return temp0)
)

(procedure (SoundFX param1)
	(return param1)
)

(procedure (SolvePuzzle param1 param2 param3)
	(if (and (>= argc 3) (!= gHeroType param3))
		(return)
	)
	(if (not (IsFlag param1))
		(SetFlag param1)
		(+= gScore param2)
		((ScriptID 0 9) doit: gCurRoomNum) ; statusCode
		(SkillUsed 1 param2) ; intelligence
	)
)

(procedure (EatMeal)
	(cond
		(gFreeMeals
			(-- gFreeMeals)
		)
		(((gInventory at: 1) amount:) ; rations
			(if (not ((gInventory at: 1) amount: (- ((gInventory at: 1) amount:) 1))) ; rations, rations
				(gMessager say: 1 0 0 12 0 814) ; "You just ate your last ration. You'd better get some more food soon."
			)
		)
		((IsFlag 124)
			(SetFlag 125)
			(gMessager say: 1 0 0 13 0 814) ; "You're starving. Better find some food SOON!"
			(TakeDamage 1)
		)
		(else
			(SetFlag 124)
			(gMessager say: 1 0 0 14 0 814) ; "You're really getting hungry."
		)
	)
)

(procedure (WtCarried &tmp temp0 temp1)
	(= temp1 0)
	(= temp0 0)
	(while (< temp1 40)
		(+=
			temp0
			(*
				(((ScriptID 206 0) at: temp1) amount:) ; gloryInv
				(((ScriptID 206 0) at: temp1) weight:) ; gloryInv
			)
		)
		(++ temp1)
	)
	(= temp0 (/ (+ temp0 59) 60))
)

(procedure (CanPickLocks)
	(return (and [gEgoStats 9] (or (gEgo has: 7) (gEgo has: 8)))) ; pick locks, lockPick, thiefKit
)

(procedure (proc814_30)
	(if (not global422)
		(= global422 (gTheIconBar curIcon:))
	)
)

(procedure (proc814_31)
	(if global422
		(gTheIconBar curIcon: global422)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(= global422 0)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 7))
				(not (gTheIconBar curInvIcon:))
			)
			(gTheIconBar advanceCurIcon:)
		)
	)
)

(procedure (proc814_32 param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Inv at: param1))
		(gTheIconBar select: (gTheIconBar at: 7) curInvIcon: temp0)
	else
		(= temp0 (gTheIconBar at: param1))
		(gTheIconBar select: temp0)
	)
	(gGame setCursor: (temp0 cursor:) 1)
)

(procedure (localproc_0 param1 param2)
	(SkillUsed param1 param2)
	(return (* [gEgoStats param1] param2))
)

(procedure (CastArea param1)
	(switch param1
		(81
			(return 0)
		)
		(51
			(CastOpen)
		)
		(50
			(gMessager say: 1 0 0 15 0 814) ; "You sense no magic in this area."
		)
		(77
			(gMessager say: 1 0 0 16 0 814) ; "There is no response to your spell."
		)
		(78
			(CastDazzle)
		)
		(80
			(CastCalm)
		)
		(82
			(gMessager say: 1 0 0 17 0 814) ; "Everything here must be bolted down somehow."
		)
		(79
			(if (or (gEgo has: 2) (gEgo has: 6)) ; sword, dagger
				(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(gMessager say: 1 0 0 18 0 814) ; "Your weapon is now magically charged."
			else
				(gMessager say: 1 0 0 19 0 814) ; "You don't have a weapon to charge."
			)
		)
		(else
			(gMessager say: 1 0 0 20 0 814) ; "Cast what???"
		)
	)
)

