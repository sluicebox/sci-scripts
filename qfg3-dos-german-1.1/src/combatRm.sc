;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use GloryControls)
(use Print)
(use IconBar)
(use LoadMany)
(use Timer)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	combatRm 0
	WarriorObj 1
	combatSpell 2
	monsterHPStat 3
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(for ((= temp0 (FirstNode (gCast elements:)))) temp0 ((= temp0 temp1))
		(= temp1 (NextNode temp0))
		(if (not (IsObject (= temp2 (NodeValue temp0))))
			(return)
		)
		(if (temp2 respondsTo: #setCycle)
			(temp2 setCycle: 0)
			(if (temp2 respondsTo: #setMotion)
				(temp2 setMotion: 0)
			)
		)
	)
)

(procedure (localproc_1)
	(HandsOff)
	(if (<= [gEgoStats 16] 0) ; health
		(= global155 0)
	)
	(localproc_0)
	(if (spellTimer seconds:)
		(spellTimer dispose:)
	)
	(if (stamTimer seconds:)
		(stamTimer dispose:)
	)
	(if (duckTimer seconds:)
		(duckTimer dispose:)
	)
	(SetCursor -2)
	(combatControls state: (& (combatControls state:) $ffdf))
	(gTheIconBar enable:)
	(if (== gPrevRoomNum 549)
		(gCurRoom newRoom: 840)
	else
		(if local0
			(SetFlag 6)
		)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(class CombatIcon of IconI
	(properties
		ducking 0
		calledBy 0
		autoDodging 0
	)

	(method (highlight param1)
		(if (or (not (& signal $0020)) (& signal $0004))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)

	(method (onMe param1)
		(if (not (& signal $0004))
			(if
				(and
					(>= (param1 x:) nsLeft)
					(>= (param1 y:) nsTop)
					(<= (param1 x:) nsRight)
					(<= (param1 y:) nsBottom)
					(not
						(IsItSkip
							view
							loop
							cel
							(- (param1 y:) nsTop)
							(- (param1 x:) nsLeft)
						)
					)
				)
				(if (not cursor)
					(= cursor 1)
					(self highlight: 1)
				)
				(return 1)
			else
				(if cursor
					(= cursor 0)
					(self highlight: 0)
				)
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (cue)
		(if
			(and
				(or
					(== (gWarriorObj view:) 26)
					(== (gWarriorObj view:) 27)
					(== (gWarriorObj view:) 555)
				)
				(not ducking)
			)
			(= ducking 1)
			(duckTimer setTicks: 60 self)
		else
			(if
				(and
					(gWarriorObj cel:)
					(== (gWarriorObj cel:) (gWarriorObj lastCel:))
					(not ducking)
				)
				(egoNoise number: 938 play:)
				(gMonster getHurt:)
				(splotch show: setCycle: End self)
			)
			(= ducking 0)
			(gWarriorObj normalize:)
		)
	)

	(method (warriorCast param1 param2 &tmp temp0)
		(cond
			((< [gEgoStats 18] [global367 (- param1 19)]) ; mana
				(return)
			)
			((gEgo castSpell: param1)
				(= temp0 param2)
				(egoMPStat update:)
				(gWarriorObj cel: 0 setCycle: End temp0)
			)
		)
	)

	(method (tryAttack param1 param2 &tmp temp0 temp1 temp2 temp3)
		(gEgo trySkill: 5 200) ; weapon-use
		(egoSPStat update:)
		(egoHPStat update:)
		(= temp0 0)
		(if argc
			(= temp0 param1)
		)
		(cond
			(
				(>
					(= temp1
						(+
							(-
								(self attackLevel: param2)
								(gMonster defenseLevel: 0)
							)
							50
						)
					)
					80
				)
				(= temp1 80)
			)
			((< temp1 20)
				(= temp1 20)
			)
		)
		(= temp2 (- temp1 (Random 1 100)))
		(gWarriorObj cel: 0)
		(if (or (== calledBy 2) (== calledBy 0))
			(= temp0 CombatIcon)
		)
		(= calledBy 0)
		(if (> temp2 0)
			(gWarriorObj setCycle: End temp0)
		else
			(if (< (= temp3 (- (gWarriorObj lastCel:) 1)) 1)
				(= temp3 1)
			)
			(gWarriorObj setCycle: CT temp3 1 temp0)
		)
	)

	(method (attackLevel &tmp temp0)
		(= temp0
			(/
				(+
					(* [gEgoStats 5] 8) ; weapon-use
					(* [gEgoStats 2] 4) ; agility
					(* [gEgoStats 0] 2) ; strength
					[gEgoStats 1] ; intelligence
					[gEgoStats 4] ; luck
				)
				16
			)
		)
		(if (< [gEgoStats 17] 100) ; stamina
			(-= temp0 (/ (- 100 [gEgoStats 17]) 5)) ; stamina
		)
		(return temp0)
	)

	(method (defend param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(if (or (== (= temp0 param1) iconC) (== global420 24))
				(gEgo trySkill: 7 200) ; dodge
			else
				(gEgo trySkill: 6 200) ; parry
			)
		)
		(egoSPStat update:)
		(egoHPStat update:)
		(if (or (== calledBy 2) (== calledBy 0) autoDodging)
			(= autoDodging 0)
			(= temp0 CombatIcon)
		)
		(= calledBy 0)
		(gWarriorObj cel: 0 setCycle: CT 3 1 temp0)
	)
)

(class WarriorObj of Prop
	(properties
		x 100
		y 149
		priority 12
		signal 16400
		cycleSpeed 0
		status 0
		weapValue 0
	)

	(method (autoDodge &tmp temp0)
		(if (== global209 3)
			(return)
		)
		(if (== global209 1)
			(= temp0 5)
		else
			(= temp0 10)
		)
		(if (< (Random 0 100) (/ [gEgoStats 7] temp0)) ; dodge
			(iconC autoDodging: (if (== global419 0) 0 else 2) select:)
			(return)
		)
		(if (< (Random 0 100) (/ [gEgoStats 6] temp0)) ; parry
			(iconD autoDodging: (if (== global419 0) 0 else 2) select:)
		)
	)

	(method (getHurt param1 &tmp temp0)
		(gWarriorObj status: 0 cue:)
		(= temp0 (/ (+ [gEgoStats 6] [gEgoStats 7]) 6)) ; parry, dodge
		(= temp0 (- param1 (/ (* param1 temp0) 100)))
		(if (gEgo has: 5) ; theShield
			(-= temp0 (- 6 global209))
		)
		(if (> (+= temp0 (Random 0 10)) 0)
			(-= [gEgoStats 16] temp0) ; health
			(if (< [gEgoStats 16] 1) ; health
				(= [gEgoStats 16] 0) ; health
			)
			(egoHPStat update:)
		)
	)

	(method (normalize)
		(gWarriorObj view: global420 loop: 0 cel: 0 stopUpd:)
		(if (gCast contains: flames)
			(flames show: setCycle: Fwd)
		)
	)

	(method (cue)
		(switch status
			(0
				(if (gCast contains: flames)
					(flames hide:)
				)
				(= status 1)
				(self view: global421 loop: 1 cel: 0 setCycle: CT 1 1 self)
				(egoNoise number: 901 play:)
			)
			(1
				(= status 0)
				(self normalize:)
			)
		)
	)
)

(class MonsterProp of Prop
	(properties
		signal 16400
	)

	(method (init)
		(= cycleSpeed (/ 24 global209))
		(super init: &rest)
	)

	(method (cue)
		(self setCel: 0 stopUpd:)
	)
)

(class Monster of MonsterProp
	(properties
		roar 0
		primDamage 0
		secDamage 0
		tertDamage 0
		armorValue 0
		monHP 0
		spellHitX 0
		spellHitY 0
		zapped 0
		picture 0
		mustFight 0
	)

	(method (whimper)
		(if roar
			(gLongSong2 number: roar play:)
		)
	)

	(method (init)
		(= gMonster self)
		(super init: &rest)
	)

	(method (getHurt param1 param2 param3 &tmp temp0)
		(if (< argc 3)
			(if
				(<
					(= temp0
						(-
							(+ (gWarriorObj weapValue:) (/ [gEgoStats 0] 10)) ; strength
							(gMonster armorValue:)
						)
					)
					0
				)
				(= temp0 (/ (gWarriorObj weapValue:) 5))
			)
			(+= temp0 (Random 1 10))
			(if (> argc 1)
				(if (< 0 param2 4)
					(/= temp0 param2)
				else
					(+= temp0 param2)
				)
			)
			(+= temp0 global142)
			(= global142 0)
		else
			(= temp0 param3)
		)
		(if (spellTimer seconds:)
			(spellTimer seconds: 0 client: 0)
			(gMonster restart:)
		)
		(if (< (-= global156 temp0) 0)
			(= global156 0)
		)
		(monsterHPStat update:)
	)

	(method (spellHurt param1 &tmp temp0)
		(= temp0 0)
		(switch param1
			(25
				(= temp0 (+ 10 (/ [gEgoStats 25] 30))) ; flameDartSpell
				(gMonster getHurt: 0 0 temp0)
			)
			(27
				(= temp0 (+ 8 (/ [gEgoStats 27] 30))) ; forceBoltSpell
				(gMonster getHurt: 0 0 temp0)
			)
			(32
				(= temp0 (+ 12 (/ [gEgoStats 32] 30))) ; lightningBallSpell
				(gMonster getHurt: 0 0 temp0)
			)
			(22
				(Palette palSET_INTENSITY 0 255 500)
				(Palette palSET_INTENSITY 0 255 100)
				(self setCycle: 0 setScript: 0)
				(spellTimer setReal: combatRm (/ [gEgoStats 22] 10)) ; dazzleSpell
			)
		)
	)

	(method (defenseLevel)
		(return 280)
	)

	(method (restart))
)

(class StatusBar of Actor
	(properties
		view 553
		loop 1
		priority 1
		signal 18448
		xStep 1
		statMax 0
		xMax 0
	)

	(method (init)
		(= xMax (self x:))
		(self x: (self calcVal:))
		(super init: &rest)
	)

	(method (update param1 &tmp temp0)
		(self setMotion: MoveTo (self calcVal: param1) (self y:) self)
	)

	(method (calcVal param1 &tmp temp0)
		(= temp0 (/ (* param1 100) statMax))
		(= temp0 (- 47 (/ (* temp0 47) 100)))
		(if (and (> param1 1) (>= temp0 47))
			(= temp0 46)
		)
		(return (- xMax temp0))
	)
)

(instance combatRm of Rm
	(properties)

	(method (init)
		(if (== gPrevRoomNum 100) ; openCart
			(= gPrevRoomNum 400)
		)
		(= local0 (IsFlag 6))
		(ClearFlag 6)
		(gLongSong2 setLoop: 1)
		(gLongSong3 setLoop: 1)
		(= global155 2)
		((= gWarriorObj WarriorObj) view: 999 init:)
		(if
			(not
				(OneOf gPrevRoomNum 400 650 700 800 810 820 830 549 851 852 853)
			)
			((ScriptID
					(Print
						addText: 4 0 1 1 0 12 ; "Which monster type?"
						addButton: 560 4 0 0 2 0 26 ; "Dinosaur"
						addButton: 565 4 0 0 3 140 26 ; "Ant"
						addButton: 575 4 0 0 5 0 40 ; "Apeman"
						addButton: 580 4 0 0 6 140 40 ; "Cobra"
						addButton: 585 4 0 0 7 0 54 ; "Crocodileman"
						addButton: 590 4 0 0 8 140 54 ; "DeWorm"
						addButton: 595 4 0 0 9 0 68 ; "Leopardman"
						addButton: 845 4 0 0 10 140 68 ; "Demons"
						addButton: 855 4 0 0 11 0 82 ; "Gargoyle"
						addButton: 860 4 0 0 12 140 82 ; "Mirror"
						init:
					)
				)
				init:
			)
		else
			((ScriptID global365) init:)
		)
		(Load rsVIEW 553)
		(cond
			((and (gEgo has: 1) ((gInventory at: 1) state:)) ; theSword, theSword
				(gWarriorObj weapValue: 35)
				(= global419 0)
				(= global420 25)
				(= global421 555)
				(LoadMany rsVIEW 25 554 555)
				(flames init: setCycle: Fwd)
			)
			((gEgo has: 1) ; theSword
				(gWarriorObj weapValue: 20)
				(= global419 0)
				(= global420 23)
				(= global421 26)
				(LoadMany rsVIEW 23 26)
			)
			(else
				(gWarriorObj weapValue: 10)
				(= global419 2)
				(= global420 24)
				(= global421 27)
				(LoadMany rsVIEW 24 27 28 22 552)
				(LoadMany rsSCRIPT 21)
				(combatSpell init: hide:)
			)
		)
		(gWarriorObj view: global420)
		(gTheIconBar disable:)
		(splotch init: hide:)
		(HandsOn)
		(super init: &rest)
		(if (not global156)
			(= global156 (gMonster monHP:))
		)
		(egoStatus init:)
		(monStatus init:)
		(egoHPStat
			statMax:
				(if (gEgo maxHealth:)
					(gEgo maxHealth:)
				else
					100
				)
			init:
		)
		(egoSPStat
			statMax:
				(if (gEgo maxStamina:)
					(gEgo maxStamina:)
				else
					100
				)
			init:
		)
		(egoMPStat
			statMax:
				(if (gEgo maxMana:)
					(gEgo maxMana:)
				else
					100
				)
			init:
		)
		(monsterHPStat statMax: (gMonster monHP:) init:)
		(stamTimer setReal: stamTimer 5)
		(combatControls init: show: dispose:)
	)

	(method (cue)
		(gMonster restart:)
	)

	(method (dispose)
		(LoadMany 0 565 575 580 585 845 590 560 595 855 860)
		(UnLoad 128 24)
		(UnLoad 128 27)
		(UnLoad 128 28)
		(UnLoad 128 22)
		(UnLoad 128 552)
		(UnLoad 128 23)
		(UnLoad 128 26)
		(UnLoad 128 25)
		(UnLoad 128 554)
		(UnLoad 128 555)
		(UnLoad 128 553)
		(super dispose: &rest)
	)
)

(instance combatControls of GloryControls
	(properties)

	(method (init)
		(super init: &rest)
		(= icon1 iconA)
		(= icon2 iconB)
		(= icon3 iconC)
		(= icon4 iconD)
		(= icon5 iconE)
		(= icon6 iconF)
		(= icon7 iconMiddle)
		(self
			add: iconA iconB iconC iconD iconE iconF iconMiddle
			eachElementDo: #cel 0
			eachElementDo: #cursor 999
			eachElementDo: #signal 129
		)
		(cond
			((== global419 2)
				(if (== gHeroType 1) ; Magic User
					(= global419 1)
					(if (gMonster mustFight:)
						(combatControls disable: iconF)
					)
					(if (not [gEgoStats 23]) ; zapSpell
						(combatControls disable: iconE)
					)
					(if (not [gEgoStats 32]) ; lightningBallSpell
						(combatControls disable: iconA)
					)
					(if (not [gEgoStats 24]) ; calmSpell
						(combatControls disable: iconB)
					)
					(if (not [gEgoStats 25]) ; flameDartSpell
						(combatControls disable: iconC)
					)
					(if (not [gEgoStats 27]) ; forceBoltSpell
						(combatControls disable: iconD)
					)
					(combatControls
						eachElementDo: #view 552
						eachElementDo: #cel 0
					)
				else
					(self eachElementDo: #view 551)
					(if (not [gEgoStats 12]) ; magic use
						(iconMiddle view: 550)
						(if (gMonster mustFight:)
							(self disable: iconMiddle)
						)
					)
				)
			)
			((gMonster mustFight:)
				(self disable: iconMiddle)
			)
		)
		(SetCursor 137 242 196 318)
		(gGame setCursor: gTheCursor 1 290 170)
	)

	(method (dispatchEvent event &tmp [temp0 3])
		(if (and (!= (= gGameTime (GetTime)) local1) (> global210 0))
			(-- global210)
			(= local1 gGameTime)
		)
		(super dispatchEvent: event &rest)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(Animate (gCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
	)

	(method (show)
		(= window combatWin)
		(User input: 1)
		(gGame setCursor: 999)
		(super show: &rest)
	)
)

(instance combatWin of Window
	(properties
		top 125
		left 239
		bottom 189
		right 320
		type 131
	)

	(method (open)
		(super open: &rest)
		(DrawCel 550 0 0 0 0 -1)
	)
)

(instance iconA of CombatIcon
	(properties
		view 550
		loop 1
		nsLeft 2
		nsTop 2
		maskView 552
		maskLoop 8
		maskCel 3
	)

	(method (select)
		(= calledBy global419)
		(if (gCast contains: flames)
			(flames hide:)
		)
		(gWarriorObj view: global420)
		(switch calledBy
			(0
				(gWarriorObj loop: 1)
				(self tryAttack: self)
			)
			(2
				(gWarriorObj loop: 1)
				(self tryAttack: self)
			)
			(1
				(gWarriorObj view: 28 loop: 0)
				(self warriorCast: 32 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(switch global419
			(1
				(egoNoise number: 11 play:)
				(combatSpell
					x: 123
					y: 87
					setLoop: 2
					show:
					setCycle: Fwd
					approachDist: 32
					setStep: 6 6
					setMotion:
						MoveTo
						(gMonster spellHitX:)
						(gMonster spellHitY:)
						combatSpell
				)
			)
			(else
				(super cue:)
			)
		)
		(gWarriorObj normalize:)
	)
)

(instance iconB of CombatIcon
	(properties
		view 550
		loop 2
		nsLeft 50
		nsTop 2
		signal 16384
		maskView 552
		maskLoop 8
		maskCel 4
	)

	(method (select)
		(= calledBy global419)
		(gWarriorObj view: global420)
		(if (gCast contains: flames)
			(flames hide:)
			(gWarriorObj view: 554)
		)
		(switch calledBy
			(0
				(gWarriorObj loop: 2)
				(self tryAttack: self)
			)
			(2
				(gWarriorObj loop: 2)
				(self tryAttack: self)
			)
			(1
				(gWarriorObj view: 28 loop: 0)
				(self warriorCast: 22 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(switch global419
			(1
				(egoNoise number: 942 play:)
				(combatSpell
					x: 123
					y: 87
					show:
					setLoop: 3
					approachDist: 22
					setStep: 6 6
					setCycle: End combatSpell
				)
			)
			(else
				(super cue:)
			)
		)
		(gWarriorObj normalize:)
	)
)

(instance iconC of CombatIcon
	(properties
		view 550
		loop 3
		nsLeft 2
		nsTop 34
		maskView 552
		maskLoop 8
		maskCel 5
	)

	(method (select &tmp temp0)
		(= calledBy global419)
		(if autoDodging
			(= temp0 autoDodging)
		else
			(= temp0 calledBy)
		)
		(if (gCast contains: flames)
			(flames hide:)
		)
		(gWarriorObj view: global421)
		(switch temp0
			(0
				(gWarriorObj loop: 1)
				(self defend: self)
			)
			(2
				(gWarriorObj loop: 0)
				(self defend: self)
			)
			(1
				(gWarriorObj view: 28 loop: 0)
				(self warriorCast: 25 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(if (== global419 1)
			(egoNoise number: 13 play:)
			(combatSpell
				x: 123
				y: 87
				setLoop: 0
				show:
				setCycle: Fwd
				approachDist: 25
				setStep: 6 6
				setMotion:
					MoveTo
					(gMonster spellHitX:)
					(gMonster spellHitY:)
					combatSpell
			)
			(gWarriorObj normalize:)
		else
			(super cue:)
		)
	)
)

(instance iconD of CombatIcon
	(properties
		view 550
		loop 4
		nsLeft 52
		nsTop 34
		maskView 552
		maskLoop 8
		maskCel 6
	)

	(method (select &tmp temp0)
		(= calledBy global419)
		(if autoDodging
			(= temp0 autoDodging)
		else
			(= temp0 calledBy)
		)
		(if (gCast contains: flames)
			(flames hide:)
		)
		(gWarriorObj view: global421)
		(switch temp0
			(0
				(gWarriorObj loop: 0)
				(self defend: self)
			)
			(2
				(gWarriorObj loop: 1)
				(self defend: self)
			)
			(1
				(gWarriorObj view: 28 loop: 0)
				(self warriorCast: 27 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(if (== global419 1)
			(egoNoise number: 943 play:)
			(combatSpell
				x: 123
				y: 87
				setLoop: 1
				show:
				setCycle: Fwd
				approachDist: 27
				setStep: 6 6
				setMotion:
					MoveTo
					(gMonster spellHitX:)
					(gMonster spellHitY:)
					combatSpell
			)
			(gWarriorObj normalize:)
		else
			(super cue:)
		)
	)
)

(instance iconE of CombatIcon
	(properties
		view 550
		loop 5
		nsLeft 3
		nsTop 12
		maskView 552
		maskLoop 8
		maskCel 1
	)

	(method (select)
		(= calledBy global419)
		(gWarriorObj view: global421)
		(switch calledBy
			(0 0)
			(2 0)
			(1
				(if (gCast contains: flames)
					(flames hide:)
				)
				(gWarriorObj view: 28 loop: 0)
				(self warriorCast: 23 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(switch global419
			(1
				(egoNoise number: 900 play:)
				(= global142 (+ 5 (/ [gEgoStats 23] 10))) ; zapSpell
			)
			(else
				(super cue:)
			)
		)
		(gWarriorObj normalize:)
	)
)

(instance iconF of CombatIcon
	(properties
		view 550
		loop 6
		nsLeft 58
		nsTop 11
		maskView 552
		maskLoop 8
		maskCel 2
	)

	(method (select)
		(if (& signal $0004)
			(return 0)
		)
		(= calledBy global419)
		(gWarriorObj view: global421)
		(switch calledBy
			(0 0)
			(2 0)
			(1
				(localproc_1)
			)
		)
		(return 1)
	)
)

(instance iconMiddle of CombatIcon
	(properties
		view 550
		loop 7
		nsLeft 23
		nsTop 2
		maskView 550
		maskLoop 8
	)

	(method (select)
		(if (& signal $0004)
			(return 0)
		)
		(= calledBy global419)
		(switch calledBy
			(0
				(localproc_1)
			)
			(2
				(if (not [gEgoStats 12]) ; magic use
					(localproc_1)
				else
					(= global419 1)
					(if (gMonster mustFight:)
						(combatControls disable: iconF)
					)
					(if (not [gEgoStats 23]) ; zapSpell
						(combatControls disable: iconE)
					)
					(if (not [gEgoStats 32]) ; lightningBallSpell
						(combatControls disable: iconA)
					)
					(if (not [gEgoStats 24]) ; calmSpell
						(combatControls disable: iconB)
					)
					(if (not [gEgoStats 25]) ; flameDartSpell
						(combatControls disable: iconC)
					)
					(if (not [gEgoStats 27]) ; forceBoltSpell
						(combatControls disable: iconD)
					)
					(combatControls
						eachElementDo: #view 552
						eachElementDo: #cel 0
						eachElementDo: #show
					)
				)
			)
			(1
				(= global419 2)
				(combatControls
					enable: iconA iconB iconC iconD iconE iconF
					eachElementDo: #view 551
					eachElementDo: #cel 0
					eachElementDo: #show
				)
			)
		)
		(Animate (gCast elements:) 1)
		(return 1)
	)
)

(instance combatSpell of Actor
	(properties
		x 123
		y 87
		view 22
		priority 14
		signal 16400
		moveSpeed 0
	)

	(method (cue)
		(if (< loop 3)
			(self loop: (+ loop 3) setCel: 0 setCycle: End self)
			(egoNoise number: 930 play:)
			(gMonster spellHurt: approachDist)
		else
			(if (== approachDist 22)
				(gMonster spellHurt: approachDist)
			)
			(self hide: setCycle: 0)
		)
	)
)

(instance flames of Prop
	(properties
		x 100
		y 149
		view 554
		priority 14
		signal 16400
	)
)

(instance egoStatus of View
	(properties
		x 30
		y 15
		view 553
		cel 1
		priority 3
		signal 16400
	)
)

(instance monStatus of View
	(properties
		x 260
		y 15
		view 553
		priority 3
		signal 16400
	)
)

(instance egoHPStat of StatusBar
	(properties
		x 30
		y 15
	)

	(method (update)
		(super update: [gEgoStats 16]) ; health
	)

	(method (calcVal)
		(super calcVal: [gEgoStats 16]) ; health
	)

	(method (cue)
		(if (< [gEgoStats 16] 1) ; health
			(= global155 0)
			(localproc_1)
		)
	)
)

(instance egoSPStat of StatusBar
	(properties
		x 30
		y 26
	)

	(method (update)
		(super update: [gEgoStats 17]) ; stamina
	)

	(method (calcVal)
		(super calcVal: [gEgoStats 17]) ; stamina
	)
)

(instance egoMPStat of StatusBar
	(properties
		x 30
		y 37
	)

	(method (update)
		(super update: [gEgoStats 18]) ; mana
	)

	(method (calcVal)
		(super calcVal: [gEgoStats 18]) ; mana
	)
)

(instance monsterHPStat of StatusBar
	(properties
		x 260
		y 15
	)

	(method (update)
		(super update: global156)
	)

	(method (calcVal)
		(super calcVal: global156)
	)

	(method (cue)
		(cond
			((== global155 -1)
				(gWarriorObj setScript: sDemonEgoDies)
			)
			((< global156 1)
				(= global155 1)
				(localproc_1)
			)
		)
	)
)

(instance sDemonEgoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoStatus hide:)
				(monStatus hide:)
				(egoHPStat hide:)
				(egoSPStat hide:)
				(egoMPStat hide:)
				(monsterHPStat hide:)
				(combatControls hide:)
				(= cycles 3)
			)
			(1
				(gMessager say: 1 6 1 0 0 840) ; "I'll fight this monster. You gotta run!"
				(= cycles 3)
			)
			(2
				(= global155 1)
				(DisposeScript 40)
				(localproc_1)
			)
		)
	)
)

(instance splotch of Prop
	(properties
		view 553
		loop 2
		signal 16384
	)

	(method (show)
		(self
			setPri: (+ (gWarriorObj priority:) 1)
			x: (+ (gWarriorObj x:) (if (== (gWarriorObj loop:) 1) 48 else 67))
			y: (- (gWarriorObj y:) (if (== (gWarriorObj loop:) 1) 66 else 46))
		)
		(super show: &rest)
	)

	(method (cue)
		(self hide: x: -50)
	)
)

(instance duckTimer of Timer
	(properties)
)

(instance spellTimer of Timer
	(properties)
)

(instance stamTimer of Timer
	(properties)

	(method (cue)
		(gEgo useStamina: -5)
		(egoSPStat update:)
		(self setReal: self 2)
	)
)

(instance egoNoise of Sound
	(properties)
)

