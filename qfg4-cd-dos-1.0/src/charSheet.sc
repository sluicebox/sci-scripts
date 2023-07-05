;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use Actor)
(use System)

(public
	charSheet 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
	local9
)

(procedure (localproc_0 param1) ; UNUSED
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

(instance charSheet of Code
	(properties)

	(method (doit)
		(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
		(= local1 gScore)
		(SetFlag 13)
		(= local9 (Str new:))
		(charInitScreen init: show: dispose:)
		(local9 dispose:)
		(ClearFlag 13)
	)
)

(instance myChar of Prop ; UNUSED
	(properties
		x 100
		y 142
		view 142
		signal 16384
	)
)

(class SheetIcon of Obj
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

	(method (init &tmp temp0)
		(PalVary 3) ; PalVaryKill
		(= text1 (Str new:))
		(= text2 (Str new:))
		(= nameBack (myDText new:))
		(= nameLow (myDText new:))
		(= valueBack (myDText new:))
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
			init: local4
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
			init: local4
		)
		(cond
			((== stat -1)
				(text2 format: {%d} local1)
				(valueBack posn: nsLeft nsTop)
				(valueLow posn: (- nsLeft 1) nsTop)
			)
			((== stat 17)
				(text2 format: {%d/%d} [gEgoStats 17] (gEgo maxHealth:)) ; health
				(valueBack posn: (- nsLeft 27) nsTop)
				(valueLow posn: (- nsLeft 28) nsTop)
			)
			((== stat 18)
				(text2 format: {%d/%d} [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(valueBack posn: (- nsLeft 27) nsTop)
				(valueLow posn: (- nsLeft 28) nsTop)
			)
			((== stat 19)
				(text2 format: {%d/%d} [gEgoStats 19] (gEgo maxMana:)) ; mana
				(valueBack posn: (- nsLeft 27) nsTop)
				(valueLow posn: (- nsLeft 28) nsTop)
			)
			(else
				(text2 format: {%d} [gEgoStats stat])
				(valueBack posn: nsLeft nsTop)
				(valueLow posn: (- nsLeft 1) nsTop)
			)
		)
		(valueBack
			text: (text2 data:)
			font: 300
			fore: 174
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 242
			init: local4
		)
		(cond
			((and (== stat 17) (IsFlag 14))
				(= temp0 106)
			)
			((> [gEgoStats stat] [gInitialStats stat])
				(= temp0 97)
			)
			((< [gEgoStats stat] [gInitialStats stat])
				(= temp0 95)
			)
			((and (== stat -1) (!= global140 gScore))
				(= global140 gScore)
				(= temp0 97)
			)
			(else
				(= temp0 227)
			)
		)
		(valueLow
			text: (text2 data:)
			font: 300
			fore: temp0
			back: 254
			skip: 254
			mode: -1
			setSize:
			setPri: 243
			init: local4
		)
	)

	(method (show)
		(|= state $0020)
		(= nsBottom (+ nsTop 8))
	)

	(method (dispose)
		(text1 dispose:)
		(text2 dispose:)
		(super dispose:)
	)
)

(instance strengthIcon of SheetIcon
	(properties
		case 6
		nsLeft 93
		nsTop 34
		nsRight 113
	)
)

(instance intgenIcon of SheetIcon
	(properties
		case 7
		stat 1
		nsLeft 93
		nsTop 45
		nsRight 113
	)
)

(instance agilityIcon of SheetIcon
	(properties
		case 8
		stat 2
		nsLeft 93
		nsTop 56
		nsRight 113
	)
)

(instance vitalIcon of SheetIcon
	(properties
		case 9
		stat 3
		nsLeft 93
		nsTop 67
		nsRight 113
	)
)

(instance luckIcon of SheetIcon
	(properties
		case 10
		stat 4
		nsLeft 93
		nsTop 78
		nsRight 113
	)
)

(instance magicIcon of SheetIcon
	(properties
		case 11
		stat 12
		nsLeft 93
		nsTop 89
		nsRight 113
	)
)

(instance commIcon of SheetIcon
	(properties
		case 13
		stat 13
		nsLeft 93
		nsTop 100
		nsRight 113
	)
)

(instance weaponIcon of SheetIcon
	(properties
		case 14
		stat 5
		nsLeft 286
		nsTop 35
		nsRight 313
	)
)

(instance parryIcon of SheetIcon
	(properties
		case 15
		stat 6
		nsLeft 286
		nsTop 44
		nsRight 313
	)
)

(instance dodgeIcon of SheetIcon
	(properties
		case 16
		stat 7
		nsLeft 286
		nsTop 54
		nsRight 313
	)
)

(instance stealthIcon of SheetIcon
	(properties
		case 17
		stat 8
		nsLeft 286
		nsTop 64
		nsRight 313
	)
)

(instance pickIcon of SheetIcon
	(properties
		case 18
		stat 9
		nsLeft 286
		nsTop 74
		nsRight 313
	)
)

(instance throwIcon of SheetIcon
	(properties
		case 19
		stat 10
		nsLeft 286
		nsTop 84
		nsRight 313
	)
)

(instance climbIcon of SheetIcon
	(properties
		case 20
		stat 11
		nsLeft 286
		nsTop 94
		nsRight 313
	)
)

(instance acrobIcon of SheetIcon
	(properties
		case 21
		stat 15
		nsLeft 286
		nsTop 104
		nsRight 313
	)
)

(instance honorIcon of SheetIcon
	(properties
		case 22
		stat 14
		nsLeft 286
		nsTop 114
		nsRight 313
	)
)

(instance pointIcon of SheetIcon
	(properties
		case 30
		stat -1
		nsLeft 93
		nsTop 137
		nsRight 113
	)
)

(instance healthIcon of SheetIcon
	(properties
		case 29
		stat 17
		nsLeft 93
		nsTop 146
		nsRight 113
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 14)
			(valueLow fore: 106)
		)
	)
)

(instance staminaIcon of SheetIcon
	(properties
		case 25
		stat 18
		nsLeft 286
		nsTop 137
		nsRight 313
	)
)

(instance manaIcon of SheetIcon
	(properties
		case 26
		stat 19
		nsLeft 286
		nsTop 146
		nsRight 313
	)
)

(instance namePlate of SheetIcon
	(properties
		case 28
		nsLeft 81
		nsTop 172
		nsRight 235
	)

	(method (init)
		(= text1 (Str new:))
		(= nameBack (myDText new:))
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
			init: local4
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
			init: local4
		)
		(valueHigh
			text: (gHeroName data:)
			posn: (+ nsLeft 47) (+ nsTop 2)
			fore: 106
			mode: 0
			font: gSmallFont
			setPri: 0
			setSize:
			init: local4
		)
		(valueLow
			text: (gHeroName data:)
			posn: (+ nsLeft 47) (+ nsTop 2)
			fore: 227
			mode: 0
			font: gSmallFont
			setPri: 243
			setSize:
			init: local4
		)
	)

	(method (show)
		(= nsBottom (+ nsTop 8))
	)

	(method (dispose)
		(text1 dispose:)
		(DisposeClone self)
	)
)

(instance charInitScreen of IconBar
	(properties
		state 0
	)

	(method (advanceCurIcon))

	(method (swapCurIcon))

	(method (init &tmp temp0 temp1 temp2)
		(= local4 (Cast new:))
		(= plane (Plane new:))
		(plane
			priority: (+ (GetHighPlanePri) 1)
			setRect: 0 10 319 199
			init:
			drawPic: 170 0
			addCast: local4
		)
		(= temp1 (IntArray new: 4))
		(= local2 (IntArray with: 132 143 134))
		(= local3 (IntArray with: 50 52 62))
		(= local0 (gHeroName size:))
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
				namePlate
		)
		(self eachElementDo: #init self)
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
			(local9 data:)
		)
		((myDText new:)
			posn: 135 140
			text: (local9 data:)
			font: 123
			fore: 174
			back: 254
			skip: 254
			setSize:
			setPri: 242
			init: local4
		)
		((myDText new:)
			posn: 134 140
			text: (local9 data:)
			font: 123
			fore: 227
			back: 254
			skip: 254
			setSize:
			setPri: 243
			init: local4
		)
		(if (== gHeroType 3) ; Paladin
			(aHero
				loop: 0
				cel: 0
				posn: (local2 at: 0) (local3 at: 0)
				init: local4
			)
		else
			(aHero
				loop: gHeroType
				cel: 0
				posn: (local2 at: gHeroType) (local3 at: gHeroType)
				init: local4
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
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp6 0)
		(= temp3 (event message:))
		(= temp4 (event modifiers:))
		(if (not temp5) ; UNINIT
			(= global107 0)
		else
			(= global107 temp5) ; UNINIT
		)
		(cond
			((& temp2 $0010) ; direction
				(switch temp3
					(JOY_RIGHT
						(if (and temp5 (temp5 state:)) ; UNINIT, UNINIT
							(self select: temp5 1) ; UNINIT
						)
					)
					(JOY_LEFT
						(if (and highlightedIcon (highlightedIcon state:))
							(self select: temp5 0) ; UNINIT
						)
					)
					(JOY_UP
						(self retreat:)
					)
					(JOY_DOWN
						(self advance:)
					)
					(JOY_UPRIGHT
						(if (temp5 state:) ; UNINIT
							(self select: temp5 3) ; UNINIT
						)
					)
					(JOY_DOWNRIGHT
						(if (temp5 state:) ; UNINIT
							(self select: temp5 2) ; UNINIT
						)
					)
				)
			)
			((== temp2 evNULL)
				(cond
					((not temp5) ; UNINIT
						(if highlightedIcon
							(highlightedIcon highlight: 0)
							(= highlightedIcon 0)
						)
					)
					((and temp5 (!= temp5 highlightedIcon)) ; UNINIT, UNINIT
						(= oldMouseY 0)
						(self highlight: temp5) ; UNINIT
					)
				)
			)
			((== temp2 evMOUSEBUTTON)
				(charInitScreen state: (& (charInitScreen state:) $ffdf))
				(return 1)
			)
			((== temp2 evKEYBOARD)
				(switch temp3
					(KEY_ESCAPE
						(charInitScreen
							state: (& (charInitScreen state:) $ffdf)
						)
						(return 1)
					)
				)
			)
		)
		(return temp6)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 20) ((++ temp0))
			(= [gInitialStats temp0] [gEgoStats temp0])
		)
		(local2 dispose:)
		(local3 dispose:)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(self eachElementDo: #dispose)
			(DisposeList elements)
		)
		(= size (= elements 0))
		(proc0_16)
		(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
		(DisposeClone self)
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

