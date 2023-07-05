;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use System)

(public
	theCharSheet 0
)

(local
	[picX 4] = [7 25 19 30]
	[picY 4] = [30 32 36 32]
)

(procedure (saveEgoStats &tmp statNum)
	(for ((= statNum 0)) (< statNum 30) ((++ statNum))
		(= [gOldStats statNum] [gEgoStats statNum])
	)
)

(procedure (showTitle xPlace yPlace &tmp theColor)
	(= theColor (if (< gNumColors 16) 0 else 1))
	(Display &rest dsCOORD xPlace yPlace dsALIGN alLEFT dsFONT 300 dsCOLOR theColor)
)

(procedure (showValue xPlace yPlace color)
	(Display &rest dsCOORD xPlace yPlace dsALIGN alLEFT dsFONT 300 dsCOLOR color dsBACKGROUND 15)
)

(procedure (skillColor statNum)
	(return
		(if (== [gEgoStats statNum] [gOldStats statNum]) gSameColor else gChangeColor)
	)
)

(procedure (showSkill xPlace yPlace statNum varColor &tmp color [str 6])
	(= color
		(if varColor
			(skillColor statNum)
		else
			gSameColor
		)
	)
	(showValue
		xPlace
		yPlace
		color
		(Format @str 70 0 [gEgoStats statNum]) ; "%d"
		106
		22
	)
)

(class CharSheet of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 189
		nsRight 319
		theWindow 0
		useWindow 0
		showBars 0
		oldValid 0
	)

	(method (dispose)
		(saveEgoStats)
		(if theWindow
			(DisposeWindow theWindow)
		)
		(PicNotValid oldValid)
		(super dispose:)
	)

	(method (doit &tmp event ret)
		(= ret evNULL)
		(while (not ret)
			(GlobalToLocal (= event (Event new:)))
			(= ret (event type:))
			(event dispose:)
		)
		(self dispose:)
	)

	(method (init &tmp nullStr)
		(super init:)
		(Load rsVIEW 805)
		(= oldValid (PicNotValid 0))
		(if useWindow
			(= nullStr {*})
			(StrAt nullStr 0 0)
			(= theWindow
				(NewWindow nsTop nsLeft nsBottom nsRight nullStr 0 -1 0 15)
			)
		)
		(DrawCel 805 2 0 10 23 -1)
		(DrawCel 805 0 gHeroType [picX gHeroType] [picY gHeroType] -1)
		(showTitle 10 8 70 1) ; "Name :"
		(showTitle 83 28 70 2) ; "Strength"
		(showTitle 83 40 70 3) ; "Intelligence"
		(showTitle 83 52 70 4) ; "Agility"
		(showTitle 83 64 70 5) ; "Vitality"
		(showTitle 83 76 70 6) ; "Luck"
		(if showBars
			(showTitle 83 88 70 7) ; "Honor"
			(showTitle 10 112 70 8) ; "Puzzle Points"
			(showTitle 10 124 70 9) ; "Experience"
		)
		(showTitle 10 148 70 10) ; "Health Points"
		(showTitle 10 160 70 11) ; "Stamina Points"
		(showTitle 10 172 70 12) ; "Magic Points"
		(showTitle 207 28 70 13) ; "Weapon Use"
		(showTitle 207 40 70 14) ; "Parry"
		(showTitle 207 52 70 15) ; "Dodge"
		(showTitle 207 64 70 16) ; "Stealth"
		(showTitle 207 76 70 17) ; "Pick Locks"
		(showTitle 207 88 70 18) ; "Throwing"
		(showTitle 207 100 70 19) ; "Climbing"
		(showTitle 207 112 70 20) ; "Magic"
		(if showBars
			(showTitle 207 124 70 21) ; "Comm."
		)
		(self update:)
	)

	(method (update &tmp theColor [str 20])
		(if showBars
			(Display @gUserName dsWIDTH 260 dsCOORD 58 8 dsALIGN alLEFT dsFONT 300 dsCOLOR gSameColor)
		)
		(showSkill 170 28 0 showBars)
		(showSkill 170 40 1 showBars)
		(showSkill 170 52 2 showBars)
		(showSkill 170 64 3 showBars)
		(showSkill 170 76 4 showBars)
		(if showBars
			(showSkill 170 88 14 showBars)
			(= theColor (if (== gScore gOldScore) gSameColor else gChangeColor))
			(= gOldScore gScore)
			(showValue 103 112 theColor (Format @str 70 0 gScore) 106 50) ; "%d"
			(showValue
				103
				124
				(skillColor 15)
				(Format @str 70 0 [gEgoStats 15]) ; "%d", experience
				106
				50
			)
		)
		(= theColor
			(if showBars
				(skillColor 16)
			else
				gSameColor
			)
		)
		(showValue
			103
			148
			theColor
			(Format ; "%d / %d"
				@str
				70
				22
				(/ (+ [gEgoStats 16] 1) 2) ; health
				(/ (+ (MaxHealth) 1) 2)
			)
			106
			60
		)
		(= theColor
			(if showBars
				(skillColor 17)
			else
				gSameColor
			)
		)
		(showValue
			103
			160
			theColor
			(Format ; "%d / %d"
				@str
				70
				22
				(/ (+ [gEgoStats 17] 3) 4) ; stamina
				(/ (+ (MaxStamina) 3) 4)
			)
			106
			60
		)
		(= theColor
			(if showBars
				(skillColor 18)
			else
				gSameColor
			)
		)
		(showValue
			103
			172
			theColor
			(Format @str 70 22 [gEgoStats 18] (MaxMana)) ; "%d / %d", mana
			106
			60
		)
		(showSkill 288 28 5 showBars)
		(showSkill 288 40 6 showBars)
		(showSkill 288 52 7 showBars)
		(showSkill 288 64 8 showBars)
		(showSkill 288 76 9 showBars)
		(showSkill 288 88 10 showBars)
		(showSkill 288 100 11 showBars)
		(showSkill 288 112 12 showBars)
		(if showBars
			(showSkill 288 124 13 showBars)
		)
	)
)

(instance theCharSheet of CharSheet
	(properties)
)

