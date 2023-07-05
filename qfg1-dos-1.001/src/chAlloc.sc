;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use StatusBar)
(use Interface)
(use Game)

(public
	chAlloc 0
)

(local
	local0
	local1
	[local2 80]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(= [gOldStats temp0] [gEgoStats temp0])
	)
)

(procedure (localproc_1 param1 param2 param3)
	(Display &rest dsCOORD param1 param2 dsALIGN alLEFT dsFONT 300 dsCOLOR param3 dsBACKGROUND 15)
)

(procedure (localproc_2)
	(localproc_1 40 127 global274 (Format @local2 203 0 local0 local1) 106 52) ; "%d / %d"
	(poolBar max: local1 value: local0 draw:)
	(RedrawCast)
)

(instance nameEdit of DEdit
	(properties
		nsTop 6
		nsLeft 58
		nsBottom 19
		nsRight 310
		font 300
		max 40
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(if (& state $0008)
			(if (== $0040 (event type:)) ; direction
				(event type: evKEYBOARD)
				(switch (event message:)
					(JOY_DOWN
						(event message: KEY_DOWN)
					)
					(JOY_UP
						(event message: KEY_UP)
					)
				)
			)
			(if (and (& state $0008) (== evKEYBOARD (event type:)))
				(switch (event message:)
					(KEY_DOWN
						(event message: KEY_TAB)
					)
					(KEY_UP
						(event message: KEY_SHIFTTAB)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(class BoxSelector of Item
	(properties
		type 10
		state 1
	)

	(method (draw)
		(DrawCel 802 1 (if (& state $0008) 1 else 2) nsLeft nsTop -1)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(if (= temp0 (super handleEvent: event))
			(return temp0)
		)
		(if (not (& state $0008))
			(return 0)
		)
		(if (== $0040 (event type:)) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(JOY_RIGHT
					(event message: KEY_RIGHT)
				)
				(JOY_LEFT
					(event message: KEY_LEFT)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_UP
						(event message: KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(event message: KEY_TAB)
					)
					(KEY_RIGHT
						(self incr: 5)
					)
					(KEY_LEFT
						(self dec: 5)
					)
					(KEY_ADD
						(self incr: 1)
					)
					(KEY_SUBTRACT
						(self dec: 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
		(return 0)
	)

	(method (incr param1)
		(if (not local0)
			(return)
		)
		(if (< local0 param1)
			(= param1 local0)
		)
		(if (== [gEgoStats value] 0)
			(if (< local0 15)
				(return)
			)
			(= [gEgoStats value] 5)
			(-= local0 15)
		else
			(+= [gEgoStats value] param1)
			(-= local0 param1)
		)
		(self select: 0)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 15] (MaxStamina)) ; stamina
		(= [gEgoStats 16] (MaxMana)) ; mana
		(localproc_2)
		((ScriptID 204 0) update:) ; theCharSheet
		(self select: 1)
	)

	(method (dec param1 &tmp temp0)
		(if (not (= temp0 (- [gEgoStats value] [gOldStats value])))
			(return)
		)
		(if (== [gEgoStats value] 5)
			(= [gEgoStats value] 0)
			(+= local0 15)
		else
			(if (< temp0 param1)
				(= param1 temp0)
			)
			(-= [gEgoStats value] param1)
			(+= local0 param1)
		)
		(self select: 0)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 15] (MaxStamina)) ; stamina
		(= [gEgoStats 16] (MaxMana)) ; mana
		(localproc_2)
		((ScriptID 204 0) update:) ; theCharSheet
		(self select: 1)
	)
)

(instance strengthSel of BoxSelector
	(properties
		nsTop 33
		nsLeft 81
		nsBottom 46
		nsRight 191
	)
)

(instance intSel of BoxSelector
	(properties
		nsTop 45
		nsLeft 81
		nsBottom 58
		nsRight 191
		value 1
	)
)

(instance agilSel of BoxSelector
	(properties
		nsTop 57
		nsLeft 81
		nsBottom 70
		nsRight 191
		value 2
	)
)

(instance vitSel of BoxSelector
	(properties
		nsTop 69
		nsLeft 81
		nsBottom 82
		nsRight 191
		value 3
	)
)

(instance luckSel of BoxSelector
	(properties
		nsTop 81
		nsLeft 81
		nsBottom 94
		nsRight 191
		value 4
	)
)

(instance wpnSel of BoxSelector
	(properties
		nsTop 26
		nsLeft 205
		nsBottom 39
		nsRight 315
		value 5
	)
)

(instance parrySel of BoxSelector
	(properties
		nsTop 38
		nsLeft 205
		nsBottom 51
		nsRight 315
		value 6
	)
)

(instance dodgeSel of BoxSelector
	(properties
		nsTop 50
		nsLeft 205
		nsBottom 63
		nsRight 315
		value 7
	)
)

(instance stealthSel of BoxSelector
	(properties
		nsTop 62
		nsLeft 205
		nsBottom 75
		nsRight 315
		value 8
	)
)

(instance pickSel of BoxSelector
	(properties
		nsTop 74
		nsLeft 205
		nsBottom 87
		nsRight 315
		value 9
	)
)

(instance throwSel of BoxSelector
	(properties
		nsTop 86
		nsLeft 205
		nsBottom 99
		nsRight 315
		value 10
	)
)

(instance climbSel of BoxSelector
	(properties
		nsTop 98
		nsLeft 205
		nsBottom 111
		nsRight 315
		value 11
	)
)

(instance magicSel of BoxSelector
	(properties
		nsTop 110
		nsLeft 205
		nsBottom 123
		nsRight 315
		value 12
	)
)

(class CSDButton of DButton
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(if (& state $0008)
			(if (== $0040 (event type:)) ; direction
				(event type: evKEYBOARD)
				(switch (event message:)
					(JOY_DOWN
						(event message: KEY_DOWN)
					)
					(JOY_UP
						(event message: KEY_UP)
					)
				)
			)
			(if (and (& state $0008) (== evKEYBOARD (event type:)))
				(switch (event message:)
					(KEY_DOWN
						(event message: KEY_TAB)
					)
					(KEY_UP
						(event message: KEY_SHIFTTAB)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance exitButton of CSDButton
	(properties
		nsTop 156
		nsLeft 210
		text { Start Game }
	)
)

(instance canButton of CSDButton
	(properties
		nsTop 171
		nsLeft 226
		text { Cancel }
	)
)

(instance statDial of Dialog
	(properties
		nsBottom 189
		nsRight 320
	)
)

(instance poolBar of StatusBar
	(properties
		x 95
		y 132
		titleCel 4
	)
)

(instance chAlloc of Rm
	(properties
		picture 401
	)

	(method (init &tmp temp0 temp1 temp2)
		(Load rsSCRIPT 204)
		(Load rsSCRIPT 205)
		(Load rsVIEW 802)
		(Load rsVIEW global302)
		(super init:)
		(gContMusic stop:)
		(= [gEgoStats 13] 0) ; experience
		(= [gInvNum 1] 10) ; silver
		(= [gInvNum 2] 4) ; gold
		(gEgo use: 6 use: 9 use: 7 use: 23 use: 8 use: 3 5) ; blade, shield, dagger, lockpick, leather, food
		(= global401 0)
		(= local0 50)
		(= [gEgoStats 17] 0) ; openSpell
		(= [gEgoStats 18] 0) ; detectSpell
		(= [gEgoStats 21] 0) ; zapSpell
		(= [gEgoStats 23] 0) ; flameDartSpell
		(= [gEgoStats 24] 0) ; fetchSpell
		(switch gHeroType
			(0 ; Fighter
				(= [gEgoStats 0] 25) ; strength
				(= [gEgoStats 1] 10) ; intelligence
				(= [gEgoStats 2] 15) ; agility
				(= [gEgoStats 3] 15) ; vitality
				(= [gEgoStats 4] 10) ; luck
				(= [gEgoStats 5] 20) ; weapon-use
				(= [gEgoStats 6] 15) ; parry
				(= [gEgoStats 7] 10) ; dodge
				(= [gEgoStats 8] 0) ; stealth
				(= [gEgoStats 9] 0) ; pick locks
				(= [gEgoStats 10] 10) ; throwing
				(= [gEgoStats 11] 0) ; climbing
				(= [gEgoStats 12] 0) ; magic
				(gEgo get: 6 get: 9) ; blade, shield
			)
			(1 ; Magic User
				(= [gEgoStats 0] 10) ; strength
				(= [gEgoStats 1] 25) ; intelligence
				(= [gEgoStats 2] 15) ; agility
				(= [gEgoStats 3] 15) ; vitality
				(= [gEgoStats 4] 10) ; luck
				(= [gEgoStats 5] 10) ; weapon-use
				(= [gEgoStats 6] 0) ; parry
				(= [gEgoStats 7] 15) ; dodge
				(= [gEgoStats 8] 0) ; stealth
				(= [gEgoStats 9] 0) ; pick locks
				(= [gEgoStats 10] 0) ; throwing
				(= [gEgoStats 11] 0) ; climbing
				(= [gEgoStats 12] 25) ; magic
				(= [gEgoStats 21] 10) ; zapSpell
				(gEgo get: 7) ; dagger
			)
			(2 ; Thief
				(= [gEgoStats 0] 10) ; strength
				(= [gEgoStats 1] 15) ; intelligence
				(= [gEgoStats 2] 25) ; agility
				(= [gEgoStats 3] 10) ; vitality
				(= [gEgoStats 4] 10) ; luck
				(= [gEgoStats 5] 10) ; weapon-use
				(= [gEgoStats 6] 0) ; parry
				(= [gEgoStats 7] 5) ; dodge
				(= [gEgoStats 8] 10) ; stealth
				(= [gEgoStats 9] 10) ; pick locks
				(= [gEgoStats 10] 5) ; throwing
				(= [gEgoStats 11] 5) ; climbing
				(= [gEgoStats 12] 0) ; magic
				(gEgo get: 7 get: 23) ; dagger, lockpick
				(= global189 10)
			)
		)
		(= local1 local0)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 15] (MaxStamina)) ; stamina
		(= [gEgoStats 16] (MaxMana)) ; mana
		(gEgo get: 8 get: 3 5) ; leather, food
		(localproc_0)
		(nameEdit text: @global401 cursor: (StrLen @global401))
		(exitButton setSize:)
		(canButton setSize:)
		(statDial
			window: gHSW
			add:
				nameEdit
				strengthSel
				intSel
				agilSel
				vitSel
				luckSel
				wpnSel
				parrySel
				dodgeSel
				stealthSel
				pickSel
				throwSel
				climbSel
				magicSel
				exitButton
				canButton
			open: 0 15
		)
		((ScriptID 204 0) useWindow: 0 showBars: 0 init:) ; theCharSheet
		(Display 203 1 dsCOORD 62 109 dsALIGN alLEFT dsFONT 300 dsCOLOR global275) ; "Points Available"
		(poolBar max: local1 value: local0 init:)
		(Display 203 2 dsCOORD 165 127 dsWIDTH 150 dsALIGN alLEFT dsFONT 300 dsCOLOR global275) ; "TAB to move around, Arrows to adjust values."
		(localproc_2)
		(RedrawCast)
		(gGame setCursor: gNormalCursor 1)
		(= temp1 1)
		(= temp2 300)
		(while temp1
			(cond
				((or (not (= temp0 (statDial doit:))) (== temp0 canButton))
					(if
						(==
							(= temp0
								(Print ; "Are you sure you want to start over?"
									203
									3
									150
									{Start Over}
									1
									150
									{Keep Going}
									2
								)
							)
							1
						)
						(= temp1 0)
						(= temp2 202)
					)
				)
				((> local0 0)
					(if
						(==
							(= temp0
								(Print ; "You still have points to allocate."
									203
									4
									150
									{Start the Game}
									1
									150
									{Use More Points}
									2
								)
							)
							1
						)
						(= temp1 0)
					)
				)
				(else
					(= temp1 0)
				)
			)
		)
		(HandsOff)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 15] (MaxStamina)) ; stamina
		(= [gEgoStats 16] (MaxMana)) ; mana
		(localproc_0)
		(poolBar dispose:)
		((ScriptID 204 0) dispose:) ; theCharSheet
		(statDial dispose:)
		(gAddToPics dispose:)
		(gCurRoom drawPic: 401 newRoom: temp2)
	)
)

