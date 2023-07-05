;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use IconBar)
(use GameControls)
(use Game)
(use Actor)
(use System)

(public
	chAlloc 0
)

(local
	[local0 14] = [999 0 1 2 3 4 12 5 6 7 8 9 10 11]
	[local14 14] = [28 40 52 64 76 88 100 40 52 64 76 88 100 112]
	[local28 14] = [100 100 100 100 100 100 100 204 204 204 204 204 204 204]
	[local42 14] = [0 1 2 3 4 5 6 7 9 10 1 9 11 12]
	[local56 49] = [0 25 10 15 15 10 0 20 15 10 0 0 10 0 0 10 25 15 15 10 25 10 0 15 0 0 0 0 0 10 15 25 10 10 0 10 0 5 10 10 5 5 67 78 68 20 23 27 1]
	local105
	local106 = 50
	[local107 14]
	[local121 14]
	local135
)

(procedure (localproc_0 param1)
	(Display &rest dsCOORD 220 param1 dsCOLOR 215 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
	(Display &rest dsCOORD 219 param1 dsCOLOR 91 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
)

(procedure (localproc_1 &tmp [temp0 4] temp4)
	(for ((= temp4 1)) (< temp4 14) ((++ temp4))
		(= [gEgoStats [local0 temp4]] [local107 temp4])
	)
	(DrawCel 802 8 1 215 142 15)
	(Format @temp0 {%d} local106)
	(if local106
		(Display @temp0 dsCOORD 220 141 dsCOLOR 215 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
		(Display @temp0 dsCOORD 219 141 dsCOLOR 50 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
	else
		(localproc_0 141 @temp0)
	)
	(DrawCel 802 8 1 215 154 15)
	(localproc_0
		153
		(Format @temp0 {%d} (= [gEgoStats 14] (/ (+ (MaxHealth) 1) 2))) ; health
	)
	(DrawCel 802 8 1 215 166 15)
	(localproc_0
		165
		(Format @temp0 {%d} (= [gEgoStats 15] (/ (+ (MaxStamina) 3) 4))) ; stamina
	)
	(DrawCel 802 8 1 215 178 15)
	(localproc_0 177 (Format @temp0 {%d} (= [gEgoStats 16] (MaxMana)))) ; mana
)

(instance chAlloc of Rm
	(properties
		picture 904
	)

	(method (init)
		(super init: &rest)
		(pointsAvail init:)
		(= global428 0)
		(self setScript: selectChar)
	)

	(method (dispose &tmp temp0)
		(startControls eachElementDo: #dispose dispose: release:)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 15] (MaxStamina)) ; stamina
		(= [gEgoStats 16] (MaxMana)) ; mana
		(for ((= temp0 0)) (< temp0 25) ((++ temp0))
			(= [global201 temp0] [gEgoStats temp0])
		)
		(= global424 gScore)
		(super dispose:)
	)
)

(instance selectChar of Script
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(= cycles 2)
			)
			(1
				(theChar cel: gHeroType init:)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= ticks 60)
			)
			(2
				(startControls init: show:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance startControls of GameControls
	(properties)

	(method (init &tmp temp0)
		(self add: namePlate)
		(for ((= temp0 1)) (< temp0 14) ((++ temp0))
			(self
				add:
					((selectionIcon new:)
						nsLeft: [local28 temp0]
						nsTop: [local14 temp0]
						cel: [local42 temp0]
						maskCel: [local42 temp0]
						state: temp0
						yourself:
					)
			)
			(= [local121 temp0] [local56 (+ temp0 (* gHeroType 14))])
			(= [local107 temp0] [local56 (+ temp0 (* gHeroType 14))])
		)
		(self
			add:
				(startIcon theObj: startCode selector: #doit yourself:)
				(cancelIcon theObj: cancelCode selector: #doit yourself:)
		)
		(super init: &rest)
	)

	(method (show)
		(|= state $0020)
		(self eachElementDo: #show)
		((= curIcon (= highlightedIcon (self at: 0))) highlight: 1)
		(DrawCel 802 5 0 1 148 15)
		(localproc_1)
		(ClearFlag 359)
		(gGame
			setCursor: 999 1 (+ (curIcon nsLeft:) 5) (- (curIcon nsBottom:) 2)
		)
		(self doit: hide:)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if local135
			(gCurRoom newRoom: local135)
			(event dispose:)
			(return 1)
		)
		(= temp0 (event x:))
		(= temp1 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp4 0)
		(= temp5 (event modifiers:))
		(= temp6 (self firstTrue: #onMe event))
		(event dispose:)
		(cond
			((& temp2 $0040) ; direction
				(switch temp3
					(JOY_RIGHT
						(if (and highlightedIcon (highlightedIcon state:))
							(self select: temp6 1)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_LEFT
						(if (and highlightedIcon (highlightedIcon state:))
							(self select: temp6 0)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_UP
						(if (not highlightedIcon)
							(= highlightedIcon (self at: (- size 1)))
						)
						(self retreat:)
					)
					(JOY_DOWN
						(if (not highlightedIcon)
							(= highlightedIcon (self at: 0))
						)
						(self advance:)
					)
					(JOY_UPRIGHT
						(if (temp6 state:)
							(self select: temp6 3)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
					(JOY_DOWNRIGHT
						(if (temp6 state:)
							(self select: temp6 2)
							(gLongSong2 number: 63 loop: 1 play:)
						)
					)
				)
			)
			((== temp2 evNULL)
				(cond
					((not (IsObject temp6))
						(if (IsObject highlightedIcon)
							(highlightedIcon highlight: 0)
							(= highlightedIcon 0)
						)
					)
					((and temp6 (!= temp6 highlightedIcon))
						(= oldMouseY 0)
						(self highlight: temp6)
					)
				)
			)
			((not (IsObject highlightedIcon)) 0)
			((== temp2 evMOUSEBUTTON)
				(cond
					((== highlightedIcon namePlate) 0)
					((not (temp6 state:))
						(cond
							((== temp6 startIcon)
								(startCode doit:)
							)
							((== temp6 cancelIcon)
								(cancelCode doit:)
							)
							(else
								(self select: temp6 1)
							)
						)
					)
					((== temp5 emSHIFT)
						(self select: temp6 1)
						(gLongSong2 number: 63 loop: 1 play:)
					)
					(else
						(self select: temp6 0)
						(gLongSong2 number: 63 loop: 1 play:)
					)
				)
			)
			((== temp2 evKEYBOARD)
				(switch temp3
					(KEY_ESCAPE
						(cancelCode doit:)
					)
					(KEY_RETURN
						(cond
							((== highlightedIcon startIcon)
								(startCode doit:)
							)
							((== highlightedIcon cancelIcon)
								(cancelCode doit:)
							)
						)
					)
					(KEY_TAB
						(cond
							((< (= temp7 (highlightedIcon state:)) 1) 0)
							((< (= temp7 (highlightedIcon state:)) 7)
								(highlightedIcon highlight: 0)
								(= highlightedIcon (self at: (+ temp7 5)))
								(self advance:)
							)
							((< temp7 13)
								(highlightedIcon highlight: 0)
								(= highlightedIcon (self at: (- temp7 5)))
								(self retreat:)
							)
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
							((and (== temp3 JOY_UPLEFT) local105)
								(self select: namePlate temp3)
							)
						)
					)
				)
			)
		)
		(return temp4)
	)
)

(instance selectionIcon of IconI
	(properties
		view 802
		loop 1
		maskView 802
		maskLoop 2
		highlightColor 9
		lowlightColor 91
	)

	(method (show)
		(self highlight: 0)
		(= nsRight (+ nsLeft (if (< state 7) 102 else 111)))
		(= nsBottom (+ nsTop 12))
	)

	(method (select param1)
		(if (super select: &rest)
			(switch param1
				(1
					(cond
						((not local106) 0)
						((< local106 5)
							(+= [local107 state] local106)
							(= local106 0)
						)
						((not [local107 state])
							(if (>= local106 15)
								(+= [local107 state] 5)
								(-= local106 15)
							)
						)
						(else
							(+= [local107 state] 5)
							(-= local106 5)
						)
					)
				)
				(0
					(cond
						((== [local107 state] [local121 state]) 0)
						((and (== [local107 state] 5) (not [local121 state]))
							(= [local107 state] 0)
							(+= local106 15)
						)
						(else
							(-= [local107 state] 5)
							(+= local106 5)
						)
					)
				)
				(3
					(cond
						((not local106) 0)
						((not [local107 state]) 0)
						(else
							(+= [local107 state] 1)
							(-= local106 1)
						)
					)
				)
				(2
					(cond
						((== [local107 state] [local121 state]) 0)
						((and (== [local107 state] 5) (not [local121 state]))
							(= [local107 state] 0)
							(+= local106 15)
						)
						(else
							(-= [local107 state] 1)
							(+= local106 1)
						)
					)
				)
			)
			(self highlight: 1)
			(localproc_1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (highlight param1 &tmp temp0 [temp1 4] temp5 temp6)
		(= temp0
			(if (< state 7)
				(+ nsLeft 71)
			else
				(+ nsLeft 80)
			)
		)
		(DrawCel view 8 (if (< state 7) 0 else 1) temp0 (+ nsTop 1) 15)
		(if param1
			(DrawCel view loop cel nsLeft nsTop 15)
			(= temp5 50)
			(= temp6 215)
		else
			(DrawCel maskView maskLoop maskCel nsLeft nsTop 15)
			(= temp5 91)
			(= temp6 215)
		)
		(Display
			(Format @temp1 {%d} [local107 state])
			dsCOORD
			(+ temp0 1)
			nsTop
			dsCOLOR
			temp6
			dsWIDTH
			25
			dsALIGN
			alRIGHT
			dsFONT
			123
		)
		(Display
			(Format @temp1 {%d} [local107 state])
			dsCOORD
			temp0
			nsTop
			dsCOLOR
			temp5
			dsWIDTH
			25
			dsALIGN
			alRIGHT
			dsFONT
			123
		)
	)
)

(instance startIcon of ControlIcon
	(properties
		view 802
		loop 3
		cel 0
		nsLeft 9
		nsTop 157
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance cancelIcon of ControlIcon
	(properties
		view 802
		loop 4
		cel 0
		nsLeft 9
		nsTop 170
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance namePlate of IconI
	(properties
		view 802
		loop 1
		cel 0
		nsLeft 100
		nsTop 22
		nsRight 300
		nsBottom 34
		maskView 802
		maskLoop 9
	)

	(method (show))

	(method (select param1 &tmp [temp0 4])
		(if (super select: &rest)
			(TextSize @[temp0 0] @global428 123 0)
			(cond
				((and (== param1 8) local105)
					(StrAt @global428 (-- local105) 0)
					(DrawCel maskView maskLoop maskCel (+ nsLeft 46) nsTop 15)
					(self highlight: 1)
				)
				((<= [temp0 3] 150)
					(StrAt @global428 local105 param1)
					(StrAt @global428 (++ local105) 0)
					(self highlight: 1)
				)
				(else
					(return 1)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2)
		(if param1
			(= temp2 loop)
			(= temp0 50)
			(= temp1 215)
		else
			(= temp2 2)
			(= temp0 91)
			(= temp1 215)
		)
		(DrawCel view temp2 cel nsLeft nsTop 15)
		(Display
			@global428
			dsCOORD
			(+ nsLeft 47)
			nsTop
			dsCOLOR
			temp1
			dsWIDTH
			172
			dsALIGN
			alLEFT
			dsFONT
			123
		)
		(Display
			@global428
			dsCOORD
			(+ nsLeft 46)
			nsTop
			dsCOLOR
			temp0
			dsWIDTH
			172
			dsALIGN
			alLEFT
			dsFONT
			123
		)
	)
)

(instance theChar of View
	(properties
		x 48
		y 145
		view 802
		priority 14
		signal 16
	)
)

(instance pointsAvail of View
	(properties
		x 102
		y 140
		view 802
		loop 7
		priority 15
		signal 16
	)
)

(instance cancelCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if
			(= temp0
				(Print
					font: gUserFont
					mode: 1
					addText: 1 0 1 1 0 0 203 ; "Would you like to choose a different character type?"
					addButton: 0 1 0 1 2 37 30 203 ; "No"
					addButton: 1 1 0 1 3 87 30 203 ; "Yes"
					init:
				)
			)
			(= local135 202)
		else
			(= temp2 (startControls curIcon:))
			(for ((= temp1 1)) (< temp1 14) ((++ temp1))
				(= [local121 temp1] [local56 (+ temp1 (* gHeroType 14))])
				(= [local107 temp1] [local56 (+ temp1 (* gHeroType 14))])
			)
			(= local105 (= global428 0))
			(DrawCel 802 9 0 146 22 15)
			(= local106 50)
			(localproc_1)
			(startControls eachElementDo: #highlight 0)
			(gGame
				setCursor: 999 1 (+ (temp2 nsLeft:) 5) (- (temp2 nsBottom:) 2)
			)
			(temp2 highlight: 1)
		)
	)
)

(instance startCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 1)
		(if local106
			(= temp0
				(Print
					font: gUserFont
					mode: 1
					addText: 1 0 2 1 0 0 203 ; "You still have points to allocate."
					addButton: 0 1 0 2 2 37 20 203 ; "Use More Points"
					addButton: 1 1 0 2 3 45 40 203 ; "Start the Game"
					init:
				)
			)
		)
		(if temp0
			(= local135 300)
			(switch gHeroType
				(0 ; Fighter
					(gEgo get: 2 get: 5) ; sword, shield
				)
				(1 ; Magic User
					(gEgo get: 6 learn: 21 10) ; dagger, zapSpell
				)
				(2 ; Thief
					(gEgo get: 6 get: 7) ; dagger, lockPick
					(= global175 10)
				)
			)
		)
	)
)

