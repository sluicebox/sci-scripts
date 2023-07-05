;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use GloryRm)
(use QIcon)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0
	local1
	local2
	local3 = 100
	local4
	local5
	local6
	[local7 2]
	local9
	local10
	local11
)

(procedure (localproc_0 &tmp temp0)
	(switch gHeroType
		(1 ; Magic User
			((gInventory at: 17) state: 0) ; theArmor
			(= [gEgoStats 0] 200) ; strength
			(= [gEgoStats 1] 250) ; intelligence
			(= [gEgoStats 2] 200) ; agility
			(= [gEgoStats 3] 200) ; vitality
			(= [gEgoStats 4] 200) ; luck
			(= [gEgoStats 12] 250) ; magic
			(= [gEgoStats 13] 225) ; communication
			(= [gEgoStats 14] 200) ; honor
			(= [gEgoStats 5] 200) ; weapon-use
			(= [gEgoStats 6] 0) ; parry
			(= [gEgoStats 7] 200) ; dodge
			(= [gEgoStats 10] 0) ; throwing
			(= [gEgoStats 8] 0) ; stealth
			(= [gEgoStats 9] 0) ; pick locks
			(= [gEgoStats 11] 0) ; climbing
			(= [gEgoStats 15] 0) ; acrobatics
			(= [gEgoStats 25] 200) ; calmSpell
			(= [gEgoStats 23] 200) ; dazzleSpell
			(= [gEgoStats 21] 200) ; detectSpell
			(= [gEgoStats 27] 200) ; fetchSpell
			(= [gEgoStats 26] 250) ; flameDartSpell
			(= [gEgoStats 28] 150) ; forceSpell
			(= [gEgoStats 31] 150) ; jugglingLightsSpell
			(= [gEgoStats 29] 200) ; levitateSpell
			(= [gEgoStats 33] 150) ; lightningSpell
			(= [gEgoStats 32] 0) ; summonStaffSpell
			(= [gEgoStats 20] 200) ; openSpell
			(= [gEgoStats 30] 150) ; reversalSpell
			(= [gEgoStats 22] 200) ; triggerSpell
			(= [gEgoStats 24] 250) ; zapSpell
		)
		(2 ; Thief
			((gInventory at: 17) state: 0) ; theArmor
			(= [gEgoStats 0] 200) ; strength
			(= [gEgoStats 1] 200) ; intelligence
			(= [gEgoStats 2] 250) ; agility
			(= [gEgoStats 3] 200) ; vitality
			(= [gEgoStats 4] 200) ; luck
			(= [gEgoStats 12] 0) ; magic
			(= [gEgoStats 13] 200) ; communication
			(= [gEgoStats 14] 150) ; honor
			(= [gEgoStats 5] 200) ; weapon-use
			(= [gEgoStats 6] 0) ; parry
			(= [gEgoStats 7] 225) ; dodge
			(= [gEgoStats 10] 200) ; throwing
			(= [gEgoStats 8] 200) ; stealth
			(= [gEgoStats 9] 200) ; pick locks
			(= [gEgoStats 11] 200) ; climbing
			(= [gEgoStats 15] 150) ; acrobatics
			(= [gEgoStats 25] 0) ; calmSpell
			(= [gEgoStats 23] 0) ; dazzleSpell
			(= [gEgoStats 21] 0) ; detectSpell
			(= [gEgoStats 27] 0) ; fetchSpell
			(= [gEgoStats 26] 0) ; flameDartSpell
			(= [gEgoStats 28] 0) ; forceSpell
			(= [gEgoStats 31] 0) ; jugglingLightsSpell
			(= [gEgoStats 29] 0) ; levitateSpell
			(= [gEgoStats 33] 0) ; lightningSpell
			(= [gEgoStats 32] 0) ; summonStaffSpell
			(= [gEgoStats 20] 0) ; openSpell
			(= [gEgoStats 30] 0) ; reversalSpell
			(= [gEgoStats 22] 0) ; triggerSpell
			(= [gEgoStats 24] 0) ; zapSpell
		)
		(else
			((gInventory at: 17) state: 1) ; theArmor
			(= [gEgoStats 0] 250) ; strength
			(= [gEgoStats 1] 200) ; intelligence
			(= [gEgoStats 2] 225) ; agility
			(= [gEgoStats 3] 225) ; vitality
			(= [gEgoStats 4] 200) ; luck
			(= [gEgoStats 12] 0) ; magic
			(= [gEgoStats 13] 200) ; communication
			(= [gEgoStats 14] 200) ; honor
			(= [gEgoStats 5] 250) ; weapon-use
			(= [gEgoStats 6] 250) ; parry
			(= [gEgoStats 7] 200) ; dodge
			(= [gEgoStats 10] 200) ; throwing
			(= [gEgoStats 8] 0) ; stealth
			(= [gEgoStats 9] 0) ; pick locks
			(= [gEgoStats 11] 0) ; climbing
			(= [gEgoStats 15] 0) ; acrobatics
			(= [gEgoStats 25] 0) ; calmSpell
			(= [gEgoStats 23] 0) ; dazzleSpell
			(= [gEgoStats 21] 0) ; detectSpell
			(= [gEgoStats 27] 0) ; fetchSpell
			(= [gEgoStats 26] 0) ; flameDartSpell
			(= [gEgoStats 28] 0) ; forceSpell
			(= [gEgoStats 31] 0) ; jugglingLightsSpell
			(= [gEgoStats 29] 0) ; levitateSpell
			(= [gEgoStats 33] 0) ; lightningSpell
			(= [gEgoStats 32] 0) ; summonStaffSpell
			(= [gEgoStats 20] 0) ; openSpell
			(= [gEgoStats 30] 0) ; reversalSpell
			(= [gEgoStats 22] 0) ; triggerSpell
			(= [gEgoStats 24] 0) ; zapSpell
		)
	)
	(= [gEgoStats 17] (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; health, strength, vitality, vitality
	(= [gEgoStats 18] (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; stamina, agility, vitality
	(= [gEgoStats 19] ; mana
		(if [gEgoStats 12] ; magic
			(/ (+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) 3) ; intelligence, magic, magic
		else
			0
		)
	)
	(gEgo get: 0 get: 17) ; thePurse, theArmor
	(= [gEgoStats 34] 0) ; frostSpell
	(= [gEgoStats 35] 0) ; ritualOfReleaseSpell
	(= [gEgoStats 36] 0) ; invisibilitySpell
	(= [gEgoStats 37] 0) ; auraSpell
	(= [gEgoStats 38] 0) ; protectionSpell
	(= [gEgoStats 39] 0) ; resistanceSpell
	(= [gEgoStats 40] 0) ; glideSpell
	(= [gEgoStats 41] 0) ; healSpell
	(= global394 0)
	(= global361 [gEgo 14])
)

(procedure (localproc_1 param1) ; UNUSED
	(return
		(switch param1
			(6 0)
			(7 1)
			(8 2)
			(9 3)
			(10 4)
			(11 12)
			(13 13)
			(14 5)
			(15 6)
			(16 7)
			(17 8)
			(18 9)
			(19 10)
			(20 11)
			(21 15)
		)
	)
)

(procedure (localproc_2)
	(switch gHeroType
		(1 ; Magic User
			((gInventory at: 17) state: 0) ; theArmor
			(if (< [gEgoStats 0] 200) ; strength
				(= [gEgoStats 0] 200) ; strength
			)
			(if (< [gEgoStats 1] 250) ; intelligence
				(= [gEgoStats 1] 250) ; intelligence
			)
			(if (< [gEgoStats 2] 200) ; agility
				(= [gEgoStats 2] 200) ; agility
			)
			(if (< [gEgoStats 3] 200) ; vitality
				(= [gEgoStats 3] 200) ; vitality
			)
			(if (< [gEgoStats 4] 200) ; luck
				(= [gEgoStats 4] 200) ; luck
			)
			(if (< [gEgoStats 12] 250) ; magic
				(= [gEgoStats 12] 250) ; magic
			)
			(if (< [gEgoStats 13] 225) ; communication
				(= [gEgoStats 13] 225) ; communication
			)
			(if (< [gEgoStats 14] 200) ; honor
				(= [gEgoStats 14] 200) ; honor
			)
			(if (< [gEgoStats 5] 200) ; weapon-use
				(= [gEgoStats 5] 200) ; weapon-use
			)
			(if (< [gEgoStats 7] 200) ; dodge
				(= [gEgoStats 7] 200) ; dodge
			)
			(if (< [gEgoStats 25] 200) ; calmSpell
				(= [gEgoStats 25] 200) ; calmSpell
			)
			(if (< [gEgoStats 23] 200) ; dazzleSpell
				(= [gEgoStats 23] 200) ; dazzleSpell
			)
			(if (< [gEgoStats 21] 200) ; detectSpell
				(= [gEgoStats 21] 200) ; detectSpell
			)
			(if (< [gEgoStats 27] 200) ; fetchSpell
				(= [gEgoStats 27] 200) ; fetchSpell
			)
			(if (< [gEgoStats 26] 250) ; flameDartSpell
				(= [gEgoStats 26] 250) ; flameDartSpell
			)
			(if (< [gEgoStats 31] 150) ; jugglingLightsSpell
				(= [gEgoStats 31] 150) ; jugglingLightsSpell
			)
			(if (< [gEgoStats 29] 200) ; levitateSpell
				(= [gEgoStats 29] 200) ; levitateSpell
			)
			(if (< [gEgoStats 33] 150) ; lightningSpell
				(= [gEgoStats 33] 150) ; lightningSpell
			)
			(if (< [gEgoStats 32] 0) ; summonStaffSpell
				(= [gEgoStats 32] 0) ; summonStaffSpell
			)
			(if (< [gEgoStats 20] 200) ; openSpell
				(= [gEgoStats 20] 200) ; openSpell
			)
			(if (< [gEgoStats 30] 150) ; reversalSpell
				(= [gEgoStats 30] 150) ; reversalSpell
			)
			(if (< [gEgoStats 22] 200) ; triggerSpell
				(= [gEgoStats 22] 200) ; triggerSpell
			)
			(if (< [gEgoStats 24] 250) ; zapSpell
				(= [gEgoStats 24] 250) ; zapSpell
			)
		)
		(2 ; Thief
			((gInventory at: 17) state: 0) ; theArmor
			(if (< [gEgoStats 0] 200) ; strength
				(= [gEgoStats 0] 200) ; strength
			)
			(if (< [gEgoStats 1] 200) ; intelligence
				(= [gEgoStats 1] 200) ; intelligence
			)
			(if (< [gEgoStats 2] 250) ; agility
				(= [gEgoStats 2] 250) ; agility
			)
			(if (< [gEgoStats 3] 200) ; vitality
				(= [gEgoStats 3] 200) ; vitality
			)
			(if (< [gEgoStats 4] 200) ; luck
				(= [gEgoStats 4] 200) ; luck
			)
			(if (< [gEgoStats 13] 200) ; communication
				(= [gEgoStats 13] 200) ; communication
			)
			(if (< [gEgoStats 14] 150) ; honor
				(= [gEgoStats 14] 150) ; honor
			)
			(if (< [gEgoStats 5] 200) ; weapon-use
				(= [gEgoStats 5] 200) ; weapon-use
			)
			(if (< [gEgoStats 7] 225) ; dodge
				(= [gEgoStats 7] 225) ; dodge
			)
			(if (< [gEgoStats 10] 200) ; throwing
				(= [gEgoStats 10] 200) ; throwing
			)
			(if (< [gEgoStats 8] 200) ; stealth
				(= [gEgoStats 8] 200) ; stealth
			)
			(if (< [gEgoStats 9] 200) ; pick locks
				(= [gEgoStats 9] 200) ; pick locks
			)
			(if (< [gEgoStats 11] 200) ; climbing
				(= [gEgoStats 11] 200) ; climbing
			)
			(if (< [gEgoStats 15] 150) ; acrobatics
				(= [gEgoStats 15] 150) ; acrobatics
			)
		)
		(else
			((gInventory at: 17) state: 1) ; theArmor
			(if (< [gEgoStats 0] 250) ; strength
				(= [gEgoStats 0] 250) ; strength
			)
			(if (< [gEgoStats 1] 200) ; intelligence
				(= [gEgoStats 1] 200) ; intelligence
			)
			(if (< [gEgoStats 2] 225) ; agility
				(= [gEgoStats 2] 225) ; agility
			)
			(if (< [gEgoStats 3] 225) ; vitality
				(= [gEgoStats 3] 225) ; vitality
			)
			(if (< [gEgoStats 4] 200) ; luck
				(= [gEgoStats 4] 200) ; luck
			)
			(if (< [gEgoStats 13] 200) ; communication
				(= [gEgoStats 13] 200) ; communication
			)
			(if (< [gEgoStats 14] 200) ; honor
				(= [gEgoStats 14] 200) ; honor
			)
			(if (< [gEgoStats 5] 250) ; weapon-use
				(= [gEgoStats 5] 250) ; weapon-use
			)
			(if (< [gEgoStats 6] 250) ; parry
				(= [gEgoStats 6] 250) ; parry
			)
			(if (< [gEgoStats 7] 200) ; dodge
				(= [gEgoStats 7] 200) ; dodge
			)
			(if (< [gEgoStats 10] 200) ; throwing
				(= [gEgoStats 10] 200) ; throwing
			)
		)
	)
	(= [gEgoStats 17] (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; health, strength, vitality, vitality
	(= [gEgoStats 18] (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; stamina, agility, vitality
	(= [gEgoStats 19] ; mana
		(if [gEgoStats 12] ; magic
			(/ (+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) 3) ; intelligence, magic, magic
		else
			0
		)
	)
	(gEgo get: 0 get: 17) ; thePurse, theArmor
	(= global361 [gEgoStats 14]) ; honor
	(if (== gHeroType 3) ; Paladin
		(= global394 1)
	)
)

(instance rm140 of GloryRm
	(properties
		picture 140
	)

	(method (init)
		(ClearFlag 6)
		(Load rsSCRIPT 91)
		(Load rsHEAP 91)
		(= local0 (IntArray with: 53 16 38 22 48 35 35 63 111 77 32768))
		(= local11 (Str new:))
		(if (== gPrevRoomNum 54) ; import
			(gGlory setCursor: (gNormalCursor view: 999 yourself:))
			(= picture 130)
			(SetFlag 50)
			(SetFlag 51)
			(super init: &rest)
			(charInitScreen init: show: dispose:)
		else
			(Palette 2 0 255 0) ; PalIntensity
			(LoadMany rsVIEW 140 141 142 143 147)
			(myChar init:)
			(fire1 setCycle: Fwd init:)
			(fire2 setCycle: Fwd init:)
			(door2 init:)
			(door3 init:)
			(bat1 init: hide:)
			(bat2 init: hide:)
			(bat3 init: hide:)
			(super init: &rest)
			(gGlory handsOff:)
			(User canInput: 1)
			(self setScript: showOff)
		)
	)

	(method (doVerb))

	(method (dispose)
		(ClearFlag 50)
		(ClearFlag 51)
		(local11 dispose:)
		(local0 dispose:)
		(super dispose:)
	)
)

(instance showOff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (<= local1 100)
			(Palette 2 0 255 (+= local1 1)) ; PalIntensity
			(if (== local1 100)
				(RemapColors 2 254 60) ; ByPercent
				(= local1 101)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory setCursor: (gNormalCursor view: 999 yourself:))
				(SetFlag 50)
				(SetFlag 51)
				(RemapColors 0) ; Off
				(= register 30)
				(torchFX number: 965 setLoop: -1 play:)
				(= seconds 1)
			)
			(1
				(bat2
					signal: (| (bat2 signal:) $0001)
					x: 80
					y: 39
					show:
					setCycle: Fwd
					setLoop: 0
				)
				(bat3
					signal: (| (bat3 signal:) $0001)
					x: 80
					y: 39
					show:
					setCycle: Fwd
					setLoop: 0
				)
				(bat1
					signal: (| (bat1 signal:) $0001)
					x: 80
					y: 39
					show:
					setCycle: Fwd
					setLoop: 0
					setMotion: MoveTo 53 16 self
				)
				(soundFX number: 132 setLoop: 1 play:)
			)
			(2
				(self setScript: batFly self)
			)
			(3
				(bat1 dispose:)
				(bat2 dispose:)
				(bat3 dispose:)
				(myChar
					signal: (| (myChar signal:) $0001)
					cycleSpeed: 1
					setCycle: End self
				)
				(soundFX number: 141 setLoop: 1 play:)
			)
			(4
				(fighterSign init:)
				(door1
					view: 142
					loop: 0
					cel: 6
					x: (myChar x:)
					y: (myChar y:)
					init:
				)
				(myChar hide:)
				(= cycles 2)
			)
			(5
				(myChar
					view: 141
					setLoop: 0
					show:
					cel: 0
					x: (door2 x:)
					y: (door2 y:)
				)
				(= seconds 4)
			)
			(6
				(= register 2)
				(myChar cycleSpeed: 6 setCycle: CT 12 1 self)
			)
			(7
				(soundFX number: 142 setLoop: 1 play:)
				(door2 hide:)
				(myChar setCycle: End self)
			)
			(8
				(myChar setLoop: 1 cel: 0 setCycle: End self)
			)
			(9
				(wizardSign init:)
				(door2 view: 141 loop: 1 cel: 9 show:)
				(door3 hide:)
				(myChar
					view: 143
					setLoop: 0
					cycleSpeed: 10
					cel: 0
					x: (door3 x:)
					y: (door3 y:)
				)
				(= seconds 2)
			)
			(10
				(= register 3)
				(soundFX number: 143 setLoop: 1 play:)
				(myChar setCycle: CT 3 1 self)
			)
			(11
				(= ticks 30)
			)
			(12
				(myChar setCycle: CT 6 1 self)
			)
			(13
				(= ticks 30)
			)
			(14
				(myChar setCycle: CT 10 1 self)
			)
			(15
				(= ticks 30)
			)
			(16
				(myChar setCycle: End self)
			)
			(17
				(robberSign init:)
				(door3 loop: 0 cel: 13 show:)
				(= cycles 2)
			)
			(18
				(myChar dispose:)
				(= cycles 1)
			)
			(19
				(bigBat init: x: 159 y: 300 setMotion: MoveTo 159 185 self)
				(bigBat2 init: x: 160 y: 300 setMotion: MoveTo 160 185)
			)
			(20
				(soundFX number: 132 setLoop: 1 play:)
				(bat2
					signal: (| (bat2 signal:) $0001)
					x: 80
					y: 39
					init:
					setCycle: Fwd
					setLoop: 0
				)
				(bat3
					signal: (| (bat3 signal:) $0001)
					x: 80
					y: 39
					init:
					setCycle: Fwd
					setLoop: 0
				)
				(bat1
					signal: (| (bat1 signal:) $0001)
					x: 80
					y: 39
					init:
					setCycle: Fwd
					setLoop: 0
					setMotion: MoveTo 53 16 self
				)
			)
			(21
				(self setScript: batFly self)
				(soundFX play:)
			)
			(22
				(soundFX stop:)
				(= seconds (Random 4 7))
			)
			(23
				(self changeState: 20)
			)
		)
	)
)

(instance bigBat of Actor
	(properties
		view 146
		signal 16385
	)

	(method (doit)
		(super doit: &rest)
		(if (<= y 186)
			(if (== y 185)
				(= y 186)
				(= z 1)
			else
				(= y 185)
				(= z 0)
			)
		)
	)

	(method (onMe)
		(return 0)
	)
)

(instance bigBat2 of Actor
	(properties
		view 146
		cel 1
		signal 16385
	)

	(method (doit)
		(super doit: &rest)
		(if (<= y 186)
			(if (== y 185)
				(= y 186)
				(= z 1)
			else
				(= y 185)
				(= z 0)
			)
		)
	)

	(method (onMe)
		(return 0)
	)
)

(instance batFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 5 22 self)
			)
			(1
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 61 25 self)
			)
			(2
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 35 33 self)
			)
			(3
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 10 8 self)
			)
			(4
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 57 14 self)
			)
			(5
				(bat1 moveSpeed: (Random 4 7) setMotion: MoveTo 80 39 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance bat1 of Actor
	(properties
		view 912
		signal 24576
		illegalBits 0
		xStep 5
	)

	(method (onMe)
		(return 0)
	)

	(method (setMotion param1 &tmp temp0)
		(super setMotion: param1 &rest)
		(if param1
			(bat2
				moveSpeed: (= temp0 (Random 4 7))
				cycleSpeed: temp0
				setMotion:
					MoveTo
					(+ (mover x:) (Random 5 15))
					(+ (mover y:) (Random 5 15))
			)
			(bat3
				moveSpeed: (= temp0 (Random 4 7))
				cycleSpeed: temp0
				setMotion:
					MoveTo
					(+ (mover x:) (Random 5 10))
					(+ (mover y:) (Random 5 10))
			)
		)
	)
)

(instance bat2 of Actor
	(properties
		view 912
		signal 24576
		illegalBits 0
		xStep 5
	)

	(method (onMe)
		(return 0)
	)
)

(instance bat3 of Actor
	(properties
		view 912
		signal 24576
		illegalBits 0
		xStep 5
	)

	(method (onMe)
		(return 0)
	)
)

(instance myChar of Prop
	(properties
		x 100
		y 142
		view 142
		signal 16384
	)

	(method (doVerb)
		(switch (showOff register:)
			(1
				(= gHeroType 0) ; Fighter
			)
			(2
				(= gHeroType 1) ; Magic User
			)
			(3
				(= gHeroType 2) ; Thief
			)
		)
		(gCurRoom setScript: sDoScreen)
	)
)

(instance sDoScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gHeroType
					(0 ; Fighter
						(fighterSign setCel: 1)
					)
					(1 ; Magic User
						(wizardSign setCel: 1)
					)
					(2 ; Thief
						(robberSign setCel: 1)
					)
				)
				(= cycles 1)
			)
			(1
				(charInitScreen init: show: dispose:)
			)
		)
	)
)

(instance fire1 of Prop
	(properties
		x 144
		y 81
		view 140
		cycleSpeed 10
		detailLevel 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance fire2 of Prop
	(properties
		x 231
		y 84
		view 140
		loop 1
		cycleSpeed 10
		detailLevel 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance door1 of View
	(properties
		x 101
		y 144
		view 142
		loop 2
		signal 16384
	)

	(method (doVerb)
		(= gHeroType 0) ; Fighter
		(gCurRoom setScript: sDoScreen)
	)
)

(instance door2 of View
	(properties
		x 189
		y 137
		view 140
		loop 6
	)

	(method (doVerb)
		(= gHeroType 1) ; Magic User
		(gCurRoom setScript: sDoScreen)
	)
)

(instance door3 of View
	(properties
		x 243
		y 132
		view 143
	)

	(method (doVerb)
		(= gHeroType 2) ; Thief
		(gCurRoom setScript: sDoScreen)
	)
)

(instance fighterSign of View
	(properties
		x 77
		y 139
		view 147
		cel 2
		signal 16384
	)

	(method (doVerb)
		(= gHeroType 0) ; Fighter
		(gCurRoom setScript: sDoScreen)
	)
)

(instance wizardSign of View
	(properties
		x 156
		y 143
		view 147
		loop 1
		cel 2
		signal 16384
	)

	(method (doVerb)
		(= gHeroType 1) ; Magic User
		(gCurRoom setScript: sDoScreen)
	)
)

(instance robberSign of View
	(properties
		x 261
		y 140
		view 147
		loop 2
		cel 2
		signal 16384
	)

	(method (doVerb)
		(= gHeroType 2) ; Thief
		(gCurRoom setScript: sDoScreen)
	)
)

(class SelectIcon of Obj
	(properties
		text1 0
		text2 0
		nameBack 0
		nameLow 0
		nameHigh 0
		valueBack 0
		valueLow 0
		valueHigh 0
		case 0
		stat 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		signal 0
		state 0
		maskView 0
		maskLoop 0
	)

	(method (update param1 &tmp temp0 temp1 temp2)
		(= temp0 valueBack)
		(= temp1 valueHigh)
		(= temp2 valueLow)
		(temp0 priority: 100)
		(temp1 priority: 100)
		(temp2 priority: 0)
		(if text2
			(text2 dispose:)
		)
		(= text2 (Str new:))
		(if (== stat -1)
			(text2 format: {%d} local3)
		else
			(text2 format: {%d} [gEgoStats stat])
		)
		(= valueBack (myDText new:))
		(= valueHigh (myDText new:))
		(= valueLow (myDText new:))
		(valueBack
			posn: nsLeft nsTop
			text: (text2 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 242
			init: local6
		)
		(valueHigh
			posn: (- nsLeft 1) nsTop
			text: (text2 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: (if param1 244 else 0)
			init: local6
		)
		(valueLow
			posn: (- nsLeft 1) nsTop
			text: (text2 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 243
			init: local6
		)
		(UpdateScreenItem valueBack)
		(UpdateScreenItem valueHigh)
		(UpdateScreenItem valueLow)
		(temp0 dispose:)
		(temp1 dispose:)
		(temp2 dispose:)
		(FrameOut)
	)

	(method (init)
		(= text1 (Str new:))
		(= text2 (Str new:))
		(= nameBack (myDText new:))
		(= nameHigh (myDText new:))
		(= nameLow (myDText new:))
		(= valueBack (myDText new:))
		(= valueHigh (myDText new:))
		(= valueLow (myDText new:))
		(= maskView [gEgoStats stat])
		(= maskLoop 0)
		(Message msgGET 140 1 0 case 1 (text1 data:))
		(nameBack
			posn: (- nsLeft 83) nsTop
			text: (text1 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local6
		)
		(nameHigh
			posn: (- nsLeft 84) nsTop
			text: (text1 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			setPri: 0
			setSize:
			init: local6
		)
		(nameLow
			posn: (- nsLeft 84) nsTop
			text: (text1 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local6
		)
		(if (== stat -1)
			(text2 format: {%d} local3)
		else
			(text2 format: {%d} [gEgoStats stat])
		)
		(valueBack
			posn: nsLeft nsTop
			text: (text2 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 242
			init: local6
		)
		(valueHigh
			posn: (- nsLeft 1) nsTop
			text: (text2 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 0
			init: local6
		)
		(valueLow
			posn: (- nsLeft 1) nsTop
			text: (text2 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 243
			init: local6
		)
	)

	(method (onMe param1)
		(return
			(and
				(< (- nsLeft 83) (param1 x:) nsRight)
				(< nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (select param1 &tmp temp0 temp1)
		(= temp1 0)
		(switch param1
			(1
				(cond
					((not [gEgoStats stat])
						(if (== local3 100)
							(= [gEgoStats stat] 100)
							(= local3 0)
							(= temp1 (= maskLoop 1))
						)
					)
					((< local3 5)
						(+= [gEgoStats stat] local3)
						(= local3 0)
						(= temp1 1)
					)
					(local3
						(+= [gEgoStats stat] 5)
						(-= local3 5)
						(= temp1 1)
					)
				)
			)
			(0
				(cond
					((and maskLoop [gEgoStats stat])
						(= [gEgoStats stat] 0)
						(= local3 100)
						(= maskLoop 0)
						(= temp1 1)
					)
					((< [gEgoStats stat] 5)
						(+= local3 [gEgoStats stat])
						(= [gEgoStats stat] 0)
						(= temp1 1)
					)
					((and [gEgoStats stat] (> [gEgoStats stat] maskView))
						(if (< (= temp0 (- [gEgoStats stat] maskView)) 5)
							(-= [gEgoStats stat] temp0)
							(+= local3 temp0)
						else
							(-= [gEgoStats stat] 5)
							(+= local3 5)
						)
						(= temp1 1)
					)
				)
			)
			(3
				(cond
					((not [gEgoStats stat])
						(if (== local3 100)
							(= [gEgoStats stat] 100)
							(= local3 0)
							(= temp1 (= maskLoop 1))
						)
					)
					(local3
						(++ [gEgoStats stat])
						(-- local3)
						(= temp1 1)
					)
				)
			)
			(2
				(cond
					((and maskLoop [gEgoStats stat])
						(= [gEgoStats stat] 0)
						(= local3 100)
						(= maskLoop 0)
						(= temp1 1)
					)
					((and [gEgoStats stat] (> [gEgoStats stat] maskView))
						(-- [gEgoStats stat])
						(++ local3)
						(= temp1 1)
					)
				)
			)
		)
		(if temp1
			(self update: 1)
			(pointIcon update: 0)
			(switch stat
				(1
					(= [gEgoStats 19] ; mana
						(if [gEgoStats 12] ; magic
							(/
								(+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) ; intelligence, magic, magic
								3
							)
						else
							0
						)
					)
					(manaIcon update: 0)
				)
				(12
					(= [gEgoStats 19] ; mana
						(if [gEgoStats 12] ; magic
							(/
								(+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) ; intelligence, magic, magic
								3
							)
						else
							0
						)
					)
					(manaIcon update: 0)
				)
				(3
					(= [gEgoStats 17] ; health
						(/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3) ; strength, vitality, vitality
					)
					(= [gEgoStats 18] (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; stamina, agility, vitality
					(healthIcon update: 0)
					(staminaIcon update: 0)
				)
				(0
					(= [gEgoStats 17] ; health
						(/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3) ; strength, vitality, vitality
					)
					(healthIcon update: 0)
				)
				(2
					(= [gEgoStats 18] (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; stamina, agility, vitality
					(staminaIcon update: 0)
				)
			)
		)
	)

	(method (show)
		(|= state $0020)
		(= nsBottom (+ nsTop 8))
	)

	(method (highlight param1)
		(if param1
			(nameHigh priority: 244)
			(valueHigh priority: 244)
		else
			(nameHigh priority: 0)
			(valueHigh priority: 0)
		)
		(UpdateScreenItem nameHigh)
		(UpdateScreenItem valueHigh)
		(FrameOut)
	)

	(method (dispose)
		(text1 dispose:)
		(if text2
			(text2 dispose:)
		)
		(super dispose:)
	)
)

(instance strengthIcon of SelectIcon
	(properties
		case 6
		nsLeft 93
		nsTop 34
		nsRight 113
	)
)

(instance intgenIcon of SelectIcon
	(properties
		case 7
		stat 1
		nsLeft 93
		nsTop 45
		nsRight 113
	)
)

(instance agilityIcon of SelectIcon
	(properties
		case 8
		stat 2
		nsLeft 93
		nsTop 56
		nsRight 113
	)
)

(instance vitalIcon of SelectIcon
	(properties
		case 9
		stat 3
		nsLeft 93
		nsTop 67
		nsRight 113
	)
)

(instance luckIcon of SelectIcon
	(properties
		case 10
		stat 4
		nsLeft 93
		nsTop 78
		nsRight 113
	)
)

(instance magicIcon of SelectIcon
	(properties
		case 11
		stat 12
		nsLeft 93
		nsTop 89
		nsRight 113
	)
)

(instance commIcon of SelectIcon
	(properties
		case 13
		stat 13
		nsLeft 93
		nsTop 100
		nsRight 113
	)
)

(instance weaponIcon of SelectIcon
	(properties
		case 14
		stat 5
		nsLeft 286
		nsTop 35
		nsRight 313
	)
)

(instance parryIcon of SelectIcon
	(properties
		case 15
		stat 6
		nsLeft 286
		nsTop 44
		nsRight 313
	)
)

(instance dodgeIcon of SelectIcon
	(properties
		case 16
		stat 7
		nsLeft 286
		nsTop 54
		nsRight 313
	)
)

(instance stealthIcon of SelectIcon
	(properties
		case 17
		stat 8
		nsLeft 286
		nsTop 64
		nsRight 313
	)
)

(instance pickIcon of SelectIcon
	(properties
		case 18
		stat 9
		nsLeft 286
		nsTop 74
		nsRight 313
	)
)

(instance throwIcon of SelectIcon
	(properties
		case 19
		stat 10
		nsLeft 286
		nsTop 84
		nsRight 313
	)
)

(instance climbIcon of SelectIcon
	(properties
		case 20
		stat 11
		nsLeft 286
		nsTop 94
		nsRight 313
	)
)

(instance acrobIcon of SelectIcon
	(properties
		case 21
		stat 15
		nsLeft 286
		nsTop 104
		nsRight 313
	)
)

(instance honorIcon of SelectIcon
	(properties
		case 22
		stat 14
		nsLeft 286
		nsTop 114
		nsRight 313
	)

	(method (onMe)
		(return 0)
	)
)

(instance pointIcon of SelectIcon
	(properties
		case 24
		stat -1
		nsLeft 93
		nsTop 137
		nsRight 113
	)

	(method (onMe)
		(return 0)
	)
)

(instance healthIcon of SelectIcon
	(properties
		case 29
		stat 17
		nsLeft 93
		nsTop 146
		nsRight 113
	)

	(method (onMe)
		(return 0)
	)
)

(instance staminaIcon of SelectIcon
	(properties
		case 25
		stat 18
		nsLeft 286
		nsTop 137
		nsRight 313
	)

	(method (onMe)
		(return 0)
	)
)

(instance manaIcon of SelectIcon
	(properties
		case 26
		stat 19
		nsLeft 286
		nsTop 146
		nsRight 313
	)

	(method (onMe)
		(return 0)
	)
)

(instance startIcon of SelectIcon
	(properties
		case 27
		nsLeft 5
		nsTop 172
		nsRight 70
	)

	(method (init)
		(= text1 (Str new:))
		(= nameBack (myDText new:))
		(= nameHigh (myDText new:))
		(= nameLow (myDText new:))
		(Message msgGET 140 1 0 case 1 (text1 data:))
		(nameBack
			posn: nsLeft nsTop
			text: (text1 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local6
		)
		(nameHigh
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			setPri: 0
			setSize:
			init: local6
		)
		(nameLow
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local6
		)
	)

	(method (onMe param1)
		(return
			(and
				(not (& signal $0004))
				(< nsLeft (param1 x:) nsRight)
				(< nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (show)
		(= nsBottom (+ nsTop 8))
	)

	(method (highlight param1)
		(if param1
			(nameHigh priority: 244)
		else
			(nameHigh priority: 0)
		)
		(UpdateScreenItem nameHigh)
		(FrameOut)
	)

	(method (select)
		(if (and local3 (proc91_0 140 1 6 1 1))
			(DisposeScript 91)
			(return 0)
		else
			(DisposeScript 91)
			(= local9 1)
			(charInitScreen state: (& (charInitScreen state:) $ffdf))
		)
	)
)

(instance cancelIcon of SelectIcon
	(properties
		case 4
		nsLeft 250
		nsTop 172
		nsRight 310
	)

	(method (init)
		(= text1 (Str new:))
		(= nameBack (myDText new:))
		(= nameHigh (myDText new:))
		(= nameLow (myDText new:))
		(Message msgGET 140 1 0 case 1 (text1 data:))
		(nameBack
			posn: nsLeft nsTop
			text: (text1 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local6
		)
		(nameHigh
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			setPri: 0
			setSize:
			init: local6
		)
		(nameLow
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local6
		)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (show)
		(= nsBottom (+ nsTop 8))
	)

	(method (highlight param1)
		(if param1
			(nameHigh priority: 244)
		else
			(nameHigh priority: 0)
		)
		(UpdateScreenItem nameHigh)
		(FrameOut)
	)

	(method (select)
		(if (not (proc91_0 140 1 6 4 1))
			(DisposeScript 91)
			(return 0)
		else
			(DisposeScript 91)
			(= local9 0)
			(gEgo drop: 17) ; theArmor
			(charInitScreen state: (& (charInitScreen state:) $ffdf))
		)
	)
)

(instance namePlate of SelectIcon
	(properties
		case 28
		nsLeft 81
		nsTop 172
		nsRight 235
	)

	(method (init)
		(= text1 (Str new:))
		(= nameBack (myDText new:))
		(= nameHigh (myDText new:))
		(= nameLow (myDText new:))
		(= valueHigh (myDText new:))
		(= valueLow (myDText new:))
		(Message msgGET 140 1 0 case 1 (text1 data:))
		(nameBack
			posn: nsLeft nsTop
			text: (text1 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local6
		)
		(nameHigh
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 106
			back: 254
			skip: 254
			setPri: 0
			setSize:
			init: local6
		)
		(nameLow
			posn: (- nsLeft 1) nsTop
			text: (text1 data:)
			font: 300
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local6
		)
		(valueHigh
			text: (gHeroName data:)
			posn: (+ nsLeft 47) (+ nsTop 2)
			fore: 106
			mode: 0
			font: gSmallFont
			setPri: 0
			setSize:
			init: local6
		)
		(valueLow
			text: (gHeroName data:)
			posn: (+ nsLeft 47) (+ nsTop 2)
			fore: 227
			mode: 0
			font: gSmallFont
			setPri: 243
			setSize:
			init: local6
		)
	)

	(method (onMe param1)
		(return
			(and
				(< nsLeft (param1 x:) nsRight)
				(< (- nsTop 2) (param1 y:) (+ nsBottom 4))
			)
		)
	)

	(method (show)
		(= nsBottom (+ nsTop 8))
	)

	(method (highlight param1)
		(if param1
			(nameHigh priority: 244)
			(valueHigh priority: 244)
		else
			(nameHigh priority: 0)
			(valueHigh priority: 0)
		)
		(UpdateScreenItem nameHigh)
		(UpdateScreenItem valueHigh)
		(FrameOut)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(= temp0 (IntArray with: 0 0 0 0))
		(TextSize (temp0 data:) (gHeroName data:) gSmallFont 0)
		(cond
			((== param1 8)
				(if local2
					(gHeroName at: (-- local2) 0)
					(= temp1 valueHigh)
					(= temp2 valueLow)
					(temp1 priority: 100)
					(temp2 priority: 0)
					(= valueHigh (myDText new:))
					(= valueLow (myDText new:))
					(valueHigh
						text: (gHeroName data:)
						posn: (+ nsLeft 47) (+ nsTop 2)
						fore: 106
						mode: 0
						font: gSmallFont
						setPri: 244
						setSize:
						init: local6
					)
					(valueLow
						text: (gHeroName data:)
						posn: (+ nsLeft 47) (+ nsTop 2)
						fore: 227
						mode: 0
						font: gSmallFont
						setPri: 243
						setSize:
						init: local6
					)
					(UpdateScreenItem valueHigh)
					(UpdateScreenItem valueLow)
					(temp1 dispose:)
					(temp2 dispose:)
					(FrameOut)
				)
			)
			((>= local2 40)
				(return 1)
			)
			((<= (temp0 at: 2) 105)
				(gHeroName at: local2 param1)
				(gHeroName at: (++ local2) 0)
				(= temp1 valueHigh)
				(= temp2 valueLow)
				(temp1 priority: 100)
				(temp2 priority: 0)
				(= valueHigh (myDText new:))
				(= valueLow (myDText new:))
				(valueHigh
					text: (gHeroName data:)
					posn: (+ nsLeft 47) (+ nsTop 2)
					fore: 106
					mode: 0
					font: gSmallFont
					setPri: 244
					setSize: 172
					init: local6
				)
				(valueLow
					text: (gHeroName data:)
					posn: (+ nsLeft 47) (+ nsTop 2)
					fore: 227
					mode: 0
					font: gSmallFont
					setPri: 243
					setSize: 172
					init: local6
				)
				(UpdateScreenItem valueHigh)
				(UpdateScreenItem valueLow)
				(temp1 dispose:)
				(temp2 dispose:)
				(FrameOut)
			)
			(else
				(return 1)
			)
		)
		(return (temp0 dispose:))
	)
)

(instance charInitScreen of IconBar
	(properties
		state 0
	)

	(method (advanceCurIcon))

	(method (swapCurIcon))

	(method (init &tmp temp0 temp1 temp2)
		(torchFX stop:)
		(gCast eachElementDo: #dispose)
		(= local6 (Cast new:))
		(= plane (Plane new:))
		(plane
			priority: (+ (GetHighPlanePri) 1)
			setRect: 0 10 319 199
			init:
			drawPic: 170 0
			addCast: local6
		)
		(Palette 2 0 255 100) ; PalIntensity
		(= temp1 (IntArray new: 4))
		(= local4 (IntArray with: 132 143 134))
		(= local5 (IntArray with: 50 52 62))
		(if (!= gPrevRoomNum 54) ; import
			(localproc_0)
		else
			(localproc_2)
		)
		(if (== gPrevRoomNum 54) ; import
			(TextSize (temp1 data:) (gHeroName data:) gSmallFont 0)
			(while (> (temp1 at: 2) 105)
				(= temp2 (gHeroName size:))
				(gHeroName at: (- temp2 1) 0)
				(TextSize (temp1 data:) (gHeroName data:) gSmallFont 0)
			)
			(= local2 (gHeroName size:))
		else
			(gHeroName copy: {})
			(= local2 (gHeroName size:))
		)
		(temp1 dispose:)
		(self
			add:
				strengthIcon
				intgenIcon
				agilityIcon
				vitalIcon
				luckIcon
				magicIcon
				commIcon
				weaponIcon
				parryIcon
				dodgeIcon
				stealthIcon
				pickIcon
				throwIcon
				climbIcon
				acrobIcon
				honorIcon
				pointIcon
				healthIcon
				staminaIcon
				manaIcon
				startIcon
				cancelIcon
				namePlate
		)
		(self eachElementDo: #init self)
	)

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(|= state $0020)
		(Message
			msgGET
			140
			(switch gHeroType
				(0 2) ; Fighter
				(1 3) ; Magic User
				(2 4) ; Thief
				(3 5) ; Paladin
			)
			0
			0
			1
			(local11 data:)
		)
		((myDText new:)
			posn: 135 140
			text: (local11 data:)
			font: 123
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local6
		)
		((myDText new:)
			posn: 134 140
			text: (local11 data:)
			font: 123
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local6
		)
		(= [gEgoStats 17] (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)) ; health, strength, vitality, vitality
		(= [gEgoStats 18] (/ (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; stamina, agility, vitality
		(= [gEgoStats 19] ; mana
			(if [gEgoStats 12] ; magic
				(/ (+ [gEgoStats 1] [gEgoStats 12] [gEgoStats 12]) 3) ; intelligence, magic, magic
			else
				0
			)
		)
		(if (== gHeroType 3) ; Paladin
			(aHero
				loop: 0
				cel: 0
				posn: (local4 at: 0) (local5 at: 0)
				init: local6
			)
		else
			(aHero
				loop: gHeroType
				cel: 0
				posn: (local4 at: gHeroType) (local5 at: gHeroType)
				init: local6
			)
		)
		(gSounds pause:)
		(|= state $0020)
		(if curIcon
			(gGlory
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(UpdatePlane plane)
		(self doit: hide:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if local2
			(startIcon signal: 0)
		else
			(startIcon signal: 4)
		)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp6 0)
		(= temp3 (event message:))
		(= temp4 (event modifiers:))
		(gCurRoom north: (= temp5 (self firstTrue: #onMe event)))
		(cond
			((& temp2 $0010) ; direction
				(switch temp3
					(JOY_RIGHT
						(if (and temp5 (temp5 state:))
							(self select: temp5 1)
						)
					)
					(JOY_LEFT
						(if (and highlightedIcon (highlightedIcon state:))
							(self select: temp5 0)
						)
					)
				)
			)
			((== temp2 evNULL)
				(cond
					((not temp5)
						(if highlightedIcon
							(highlightedIcon highlight: 0)
							(= highlightedIcon 0)
						)
					)
					((and temp5 (!= temp5 highlightedIcon))
						(= oldMouseY 0)
						(self highlight: temp5)
					)
				)
			)
			((not highlightedIcon) 0)
			((== temp2 evMOUSEBUTTON)
				(if temp5
					(cond
						((== temp5 namePlate) 0)
						((== temp4 emSHIFT)
							(self select: temp5 1)
						)
						(else
							(self select: temp5 0)
						)
					)
				)
			)
			((== temp2 evKEYBOARD)
				(switch temp3
					(KEY_RETURN
						(if
							(or
								(== highlightedIcon startIcon)
								(== highlightedIcon cancelIcon)
							)
							(self select: highlightedIcon 1)
						)
					)
					(else
						(cond
							((!= highlightedIcon namePlate) 0)
							(
								(or
									(<= KEY_a temp3 KEY_z)
									(<= KEY_A temp3 KEY_Z)
									(<= KEY_0 temp3 KEY_9)
								)
								(self select: namePlate temp3)
							)
							((== temp3 KEY_SPACE)
								(self select: namePlate temp3)
							)
							((== temp3 JOY_UPLEFT)
								(self select: namePlate temp3)
							)
						)
					)
				)
			)
		)
		(return temp6)
	)

	(method (highlight param1 param2)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
			(= highlightedIcon 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGlory
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (dispose)
		(if (and (!= gHeroType 1) [gEgoStats 12] (!= gPrevRoomNum 54)) ; Magic User, magic, import
			(= [gEgoStats 25] 0) ; calmSpell
			(= [gEgoStats 23] 0) ; dazzleSpell
			(= [gEgoStats 21] 100) ; detectSpell
			(= [gEgoStats 27] 0) ; fetchSpell
			(= [gEgoStats 26] 100) ; flameDartSpell
			(= [gEgoStats 28] 100) ; forceSpell
			(= [gEgoStats 31] 0) ; jugglingLightsSpell
			(= [gEgoStats 29] 0) ; levitateSpell
			(= [gEgoStats 33] 0) ; lightningSpell
			(= [gEgoStats 32] 0) ; summonStaffSpell
			(= [gEgoStats 20] 0) ; openSpell
			(= [gEgoStats 30] 0) ; reversalSpell
			(= [gEgoStats 22] 0) ; triggerSpell
			(= [gEgoStats 24] 150) ; zapSpell
		)
		(if (and (== gHeroType 1) (== gPrevRoomNum 54)) ; Magic User, import
			(if (< [gEgoStats 28] 100) ; forceSpell
				(= [gEgoStats 28] 100) ; forceSpell
			)
			(if (< [gEgoStats 33] 100) ; lightningSpell
				(= [gEgoStats 33] 100) ; lightningSpell
			)
			(if (< [gEgoStats 29] 100) ; levitateSpell
				(= [gEgoStats 29] 100) ; levitateSpell
			)
		)
		(= [gEgoStats 32] 0) ; summonStaffSpell
		(local4 dispose:)
		(local5 dispose:)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(self eachElementDo: #dispose)
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
		(if local9
			(= global361 [gEgoStats 14]) ; honor
		)
		(gCurRoom newRoom: (if local9 770 else 100))
	)
)

(instance aHero of View
	(properties
		view 170
	)
)

(instance myDText of DText
	(properties)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance torchFX of Sound
	(properties)
)

