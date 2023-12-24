;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Bar)
(use Interface)
(use Timer)
(use Game)

(public
	chAlloc 0
)

(local
	pointsAvail
	origAvail
	[str 80]
)

(procedure (saveEgoStats &tmp statNum)
	(for ((= statNum 0)) (< statNum 30) ((++ statNum))
		(= [gOldStats statNum] [gEgoStats statNum])
	)
)

(procedure (showValue xPlace yPlace color)
	(Display &rest dsCOORD xPlace yPlace dsALIGN alLEFT dsFONT 300 dsCOLOR color dsBACKGROUND 15)
)

(procedure (updatePoints)
	(showValue 40 127 gSameColor (Format @str 810 0 pointsAvail origAvail) 106 52) ; "%d / %d"
	(poolBar max: origAvail value: pointsAvail draw:)
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

	(method (handleEvent event &tmp ret)
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
		(DrawCel 805 1 (if (& state $0008) 0 else 1) nsLeft nsTop -1)
	)

	(method (handleEvent event &tmp ret)
		(if (event claimed:)
			(return 0)
		)
		(if (= ret (super handleEvent: event))
			(return ret)
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

	(method (incr amt)
		(if (not pointsAvail)
			(return)
		)
		(if (< pointsAvail amt)
			(= amt pointsAvail)
		)
		(if (== [gEgoStats value] 0)
			(if (< pointsAvail 15)
				(return)
			)
			(= [gEgoStats value] 5)
			(-= pointsAvail 15)
		else
			(+= [gEgoStats value] amt)
			(-= pointsAvail amt)
		)
		(self select: 0)
		(= [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 17] (MaxStamina)) ; stamina
		(= [gEgoStats 18] (MaxMana)) ; mana
		(updatePoints)
		((ScriptID 70 0) update:) ; theCharSheet
		(self select: 1)
	)

	(method (dec amt &tmp delta)
		(if (not (= delta (- [gEgoStats value] [gOldStats value])))
			(return)
		)
		(if (< delta amt)
			(= amt delta)
		)
		(-= [gEgoStats value] amt)
		(if (< [gEgoStats value] 5)
			(+= amt [gEgoStats value])
			(= [gEgoStats value] 0)
			(+= pointsAvail 10)
		)
		(+= pointsAvail amt)
		(self select: 0)
		(= [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 17] (MaxStamina)) ; stamina
		(= [gEgoStats 18] (MaxMana)) ; mana
		(updatePoints)
		((ScriptID 70 0) update:) ; theCharSheet
		(self select: 1)
	)
)

(instance strengthSel of BoxSelector
	(properties
		nsTop 26
		nsLeft 81
		nsBottom 39
		nsRight 191
	)
)

(instance intSel of BoxSelector
	(properties
		nsTop 38
		nsLeft 81
		nsBottom 51
		nsRight 191
		value 1
	)
)

(instance agilSel of BoxSelector
	(properties
		nsTop 50
		nsLeft 81
		nsBottom 63
		nsRight 191
		value 2
	)
)

(instance vitSel of BoxSelector
	(properties
		nsTop 62
		nsLeft 81
		nsBottom 75
		nsRight 191
		value 3
	)
)

(instance luckSel of BoxSelector
	(properties
		nsTop 74
		nsLeft 81
		nsBottom 87
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

	(method (handleEvent event &tmp ret)
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
		nsRight 319
	)
)

(instance poolBar of Bar
	(properties
		x 95
		y 132
		cel 4
	)
)

(instance chAlloc of Rm
	(properties
		picture 1
		style 100
	)

	(method (init)
		(ClearFlag 2) ; fInMainGame
		(Load rsSCRIPT 70)
		(Load rsSCRIPT 24)
		(Load rsVIEW 805)
		(Load rsVIEW gStatusBarView)
		(super init:)
		(gCSound stop:)
		((Timer new:) setCycle: self 2)
	)

	(method (cue &tmp answer looping nextRoom index theLine magicSkill)
		(= gOrigHeroType gHeroType)
		(if (== gPrevRoomNum 805) ; import
			(= [gInvNum 3] 5) ; Food
			(= [gInvNum 37] 1) ; Waterskin
			(= gDrinksLeft 10)
			(= [gEgoStats 15] 5000) ; experience
		else
			(for ((= index 0)) (< index 58) ((++ index))
				(= [gInvNum index] (= [gInvDropped index] 0))
			)
			(for ((= index 19)) (<= index 29) ((++ index))
				(= [gEgoStats index] 0)
			)
			(= pointsAvail 50)
			(= [gEgoStats 15] 0) ; experience
			(= [gInvNum 17] 150) ; Gold
			(= [gInvNum 37] 1) ; Waterskin
			(= [gInvNum 3] 5) ; Food
			(= gUserName 0)
			(switch gHeroType
				(0 ; Fighter
					(= [gEgoStats 0] 70) ; strength
					(= [gEgoStats 1] 40) ; intelligence
					(= [gEgoStats 2] 60) ; agility
					(= [gEgoStats 3] 70) ; Vitality
					(= [gEgoStats 4] 50) ; luck
					(= [gEgoStats 5] 70) ; weapon-use
					(= [gEgoStats 6] 60) ; parry
					(= [gEgoStats 7] 40) ; dodge
					(= [gEgoStats 8] 0) ; sneak
					(= [gEgoStats 9] 0) ; pick locks
					(= [gEgoStats 10] 50) ; throw
					(= [gEgoStats 11] 0) ; climb
					(= [gEgoStats 12] 0) ; magic use
					(= [gInvNum 4] 1) ; Sword
					(= [gInvNum 15] 1) ; ChainMail
					(= [gInvNum 7] 1) ; Shield
				)
				(1 ; Magic User
					(= [gEgoStats 0] 40) ; strength
					(= [gEgoStats 1] 70) ; intelligence
					(= [gEgoStats 2] 60) ; agility
					(= [gEgoStats 3] 50) ; Vitality
					(= [gEgoStats 4] 50) ; luck
					(= [gEgoStats 5] 40) ; weapon-use
					(= [gEgoStats 6] 0) ; parry
					(= [gEgoStats 7] 50) ; dodge
					(= [gEgoStats 8] 0) ; sneak
					(= [gEgoStats 9] 0) ; pick locks
					(= [gEgoStats 10] 0) ; throw
					(= [gEgoStats 11] 0) ; climb
					(= [gEgoStats 12] 70) ; magic use
					(= [gEgoStats 19] 40) ; openSpell
					(= [gEgoStats 20] 40) ; detectSpell
					(= [gEgoStats 21] 30) ; triggerSpell
					(= [gEgoStats 23] 50) ; zapSpell
					(= [gEgoStats 24] 40) ; calmSpell
					(= [gEgoStats 25] 50) ; flameDartSpell
					(= [gEgoStats 26] 40) ; fetchSpell
					(= [gInvNum 5] 1) ; Dagger
					(= [gInvNum 6] 1) ; Leather
				)
				(2 ; Thief
					(= [gEgoStats 0] 50) ; strength
					(= [gEgoStats 1] 50) ; intelligence
					(= [gEgoStats 2] 70) ; agility
					(= [gEgoStats 3] 50) ; Vitality
					(= [gEgoStats 4] 60) ; luck
					(= [gEgoStats 5] 50) ; weapon-use
					(= [gEgoStats 6] 0) ; parry
					(= [gEgoStats 7] 50) ; dodge
					(= [gEgoStats 8] 60) ; sneak
					(= [gEgoStats 9] 60) ; pick locks
					(= [gEgoStats 10] 50) ; throw
					(= [gEgoStats 11] 60) ; climb
					(= [gEgoStats 12] 0) ; magic use
					(= [gInvNum 5] 5) ; Dagger
					(= [gInvNum 6] 1) ; Leather
					(= [gInvNum 11] 1) ; ThiefKit
					(= [gInvNum 12] 1) ; ThiefLicense
					(= gLockPickBonus 35)
				)
			)
		)
		(= origAvail pointsAvail)
		(= [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 17] (MaxStamina)) ; stamina
		(= [gEgoStats 18] (MaxMana)) ; mana
		(= [gEgoStats 13] (/ (+ (* [gEgoStats 1] 3) [gEgoStats 4]) 4)) ; communication, intelligence, luck
		(= [gEgoStats 14] 50) ; honor
		(saveEgoStats)
		(nameEdit text: @gUserName cursor: (StrLen @gUserName))
		(exitButton setSize:)
		(canButton setSize:)
		(statDial
			window: gSfWin
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
			open: 1 -1
		)
		((ScriptID 70 0) useWindow: 0 showBars: 0 init:) ; theCharSheet
		(Display 810 1 dsCOORD 62 109 dsALIGN alLEFT dsFONT 300 dsCOLOR gChangeColor) ; "Points Available"
		(poolBar max: origAvail value: pointsAvail init: startUpd:)
		(Display 810 2 dsCOORD 165 127 dsWIDTH 150 dsALIGN alLEFT dsFONT 300 dsCOLOR gChangeColor) ; "TAB to move around, Arrows to adjust values."
		(updatePoints)
		(RedrawCast)
		(gGame setCursor: gNormalCursor 1)
		(= looping 1)
		(= nextRoom 100)
		(while looping
			(cond
				((or (not (= answer (statDial doit:))) (== answer canButton))
					(if
						(==
							(= answer (Print 810 3 #button {Yes} 1 #button { No } 2)) ; "Choose a new character type?"
							1
						)
						(= looping 0)
						(= nextRoom 800)
					else
						(= looping 0)
						(= nextRoom 765)
					)
				)
				((< (StrLen @gUserName) 3)
					(Print 810 4) ; "Please choose a longer name for your character."
				)
				((> pointsAvail 0)
					(if
						(==
							(= answer
								(Print ; "You still have points to allocate."
									810
									5
									#button
									{Start the Game}
									1
									#button
									{Use More Points}
									2
								)
							)
							1
						)
						(= looping 0)
					)
				)
				(else
					(= looping 0)
				)
			)
		)
		(HandsOff)
		(= [gEgoStats 16] (MaxHealth)) ; health
		(= [gEgoStats 17] (MaxStamina)) ; stamina
		(= [gEgoStats 18] (MaxMana)) ; mana
		(saveEgoStats)
		(= theLine (poolBar lineObj:))
		(poolBar dispose: delete:)
		(if (IsObject theLine)
			(theLine delete:)
		)
		(RedrawCast)
		((ScriptID 70 0) dispose:) ; theCharSheet
		(statDial dispose:)
		(gAddToPics dispose:)
		(= magicSkill [gEgoStats 12]) ; magic use
		(if (!= gPrevRoomNum 805) ; import
			(if (and (!= gHeroType 2) [gEgoStats 9]) ; Thief, pick locks
				(= [gInvNum 10] 1) ; LockPick
				(= gLockPickBonus 20)
			)
			(if (and magicSkill (!= gHeroType 1)) ; Magic User
				(= [gEgoStats 25] (= [gEgoStats 26] magicSkill)) ; flameDartSpell, fetchSpell
			)
		)
		(if [gEgoStats 12] ; magic use
			(if (not [gEgoStats 23]) ; zapSpell
				(= [gEgoStats 23] magicSkill) ; zapSpell
			)
			(if (not [gEgoStats 24]) ; calmSpell
				(= [gEgoStats 24] magicSkill) ; calmSpell
			)
			(if (not [gEgoStats 19]) ; openSpell
				(= [gEgoStats 19] magicSkill) ; openSpell
			)
		)
		(if (== nextRoom 100)
			(SetFlag 2) ; fInMainGame
			(= gDay 1)
			(FixTime 8 0)
			(= gElementalState 0)
			(if (== gHeroType 0) ; Fighter
				(= gPaladinPoints 0)
			else
				(= gPaladinPoints 12)
			)
		)
		(gCurRoom drawPic: 1 newRoom: nextRoom)
	)
)

