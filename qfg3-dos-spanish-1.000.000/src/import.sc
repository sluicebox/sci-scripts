;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Interface)
(use Print)
(use Dialog)
(use IconBar)
(use FileSelector)
(use LoadMany)
(use GameControls)
(use File)
(use Game)
(use System)

(public
	import 0
)

(local
	local0 = 83
	local1
	[local2 3]
	local5
	[local6 30]
	local36
	local37
	local38
	local39
	local40
	local41 = 160
	local42 = 62
	local43
	local44
	local45 = 47
	local46 = 144
	local47 = 25
	local48 = 163
	local49 = 218
	local50
	local51
	local52
	[local53 44]
	[local97 300]
	[local397 40]
	[local437 20]
	[local457 20]
	[local477 60]
	[local537 30] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29]
	local567 = 83
	local568
	[local569 3]
	local572
	[local573 25]
	local598
	[local599 4]
	local603 = 121
	local604 = 134
	local605
	local606
	local607 = 67
	local608 = 136
	local609 = 173
	local610 = 240
	local611 = 206
	[local612 25] = [0 1 2 3 4 5 6 7 8 9 10 11 12 15 16 17 18 19 20 21 22 23 24 25 26]
	[local637 20]
	local657
	[local658 5]
	[local663 5]
	[local668 10]
	[local678 10]
	[local688 10]
	[local698 10]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 13) ((++ temp0))
		(= [global211 temp0] 0)
	)
	(= gHeroType 0) ; Fighter
	(for ((= temp0 0)) (< temp0 47) ((++ temp0))
		((gInventory at: temp0) amount: 0 owner: 0)
	)
	(= gScore 0)
	(StrCpy @global157 {xxxxxxxxxxy})
	(for ((= temp0 0)) (< temp0 48) ((++ temp0))
		(= [local0 (+ temp0 1)] 0)
	)
)

(procedure (localproc_1)
	(if (not (glory2_sav open: 1))
		(Message msgGET 54 2 6 7 1 @local97) ; "Sorry! I can't find your hero file "%s"."
		(Printf @local97 (glory2_sav name:))
		(return 0)
	)
	(glory2_sav readString: @global157 52)
	(glory2_sav readString: @local97 90)
	(cond
		((== (StrLen @local97) 86)
			(if (not (localproc_9))
				(return 0)
			)
		)
		((not (localproc_8))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_2 param1)
	(return
		(+
			(localproc_3 (>> param1 $0008))
			(* (localproc_3 (& param1 $00ff)) 16)
		)
	)
)

(procedure (localproc_3 param1)
	(cond
		((== param1 32)
			(return 0)
		)
		((<= 48 param1 57)
			(return (- param1 48))
		)
		(else
			(return (- param1 87))
		)
	)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1)
	(if (= temp1 (StrLen param2))
		(= temp0 (StrAt param2 (- temp1 1)))
		(Format
			param1
			{%s%c%s}
			param2
			(if (OneOf temp0 92 58) 0 else 92)
			param3
		)
	else
		(StrCpy param1 param3)
	)
	(return param1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp0 0)
	(for ((= temp1 0)) (= temp2 (StrAt param1 temp0)) ((++ temp1))
		(if (not (or (<= 48 temp2 57) (<= 65 temp2 90) (<= 97 temp2 122)))
			(Prints 2 6 13 1)
			(return 0)
		)
		(if (>= temp1 8)
			(Prints 2 6 14 1)
			(return 0)
		)
		(++ temp0)
	)
	(return 1)
)

(procedure (localproc_6 param1)
	(if (localproc_7 @local637)
		(gGame setCursor: gWaitCursor)
		(if (not (savedHeros init:))
			(return 0)
		)
		(param1 dispose:)
		(param1 init:)
		(savedHeros draw:)
	)
	(gGame setCursor: gNormalCursor)
	(return 1)
)

(procedure (localproc_7 param1 &tmp temp0 [temp1 60])
	(= temp0 0)
	(repeat
		(if
			(not
				(= temp0
					(Print
						addText: 1 0 1 1 0 12 ; "New Directory"
						addEdit: (StrCpy @temp1 param1) 30 0 26 param1
						addButton: 1 1 0 0 1 0 40 ; "OK"
						addButton: 0 1 0 0 2 0 54 ; "Cancel"
						init:
					)
				)
			)
			(break)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy @local637 @temp1)
			(break)
		else
			(Message msgGET 54 2 6 15 1 @local97) ; ""%s" is not a valid directory."
			(Printf @local97 @temp1)
		)
	)
	(return temp0)
)

(procedure (localproc_8 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 48) ((++ temp0))
		(= [local0 (+ temp0 1)] (localproc_2 [local97 temp0]))
	)
	(for ((= temp0 48)) (< 0 temp0) ((-- temp0))
		(^= [local0 temp0] (& [local0 (- temp0 1)] $00ff))
	)
	(= local50 local49)
	(for ((= temp0 0)) (< temp0 40) ((+= temp0 2))
		(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $00ff))
		(+= local50 [local0 (+ temp0 1)])
	)
	(= local51 0)
	(for ((= temp0 1)) (< temp0 40) ((+= temp0 2))
		(= [local0 (+ temp0 1)] (& [local0 (+ temp0 1)] $00ff))
		(+= local51 [local0 (+ temp0 1)])
	)
	(&= local50 $00ff)
	(&= local51 $00ff)
	(if (or (!= local50 local43) (!= local51 local44))
		(Prints 2 6 17 1)
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 30) ((++ temp0))
		(= [gEgoStats [local537 temp0]] [local6 temp0])
		(if
			(and
				(not (< 13 [local537 temp0] 19))
				(not (<= 0 [local6 temp0] 300))
			)
			(Prints 2 6 17 1)
			(return 0)
		)
	)
	(if (== local1 0)
		(if (and [gEgoStats 23] [gEgoStats 29]) ; zapSpell, reversalSpell
			(= local1 1)
		else
			(= temp1 0)
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(if [gEgoStats temp0]
					(++ temp1)
				)
			)
			(if (or (not [gEgoStats 6]) (== temp1 13)) ; parry
				(= local1 2)
			)
		)
	)
	(= gHeroType (= gBaseHeroType local1))
	(if (and (not (& local5 $0080)) (== gHeroType 3)) ; Paladin
		(SetFlag 144)
	)
	(if (== gHeroType 3) ; Paladin
		(= gBaseHeroType 0) ; Fighter
	)
	(if ((gInventory at: 10) amount: local36) ; theDaggers
		((gInventory at: 10) owner: gEgo) ; theDaggers
		((gInventory at: 10) realOwner: gEgo) ; theDaggers
	)
	(if ((gInventory at: 12) amount: local37) ; theHealPills
		((gInventory at: 12) owner: gEgo) ; theHealPills
		((gInventory at: 12) realOwner: gEgo) ; theHealPills
	)
	(if ((gInventory at: 13) amount: local38) ; theManaPills
		((gInventory at: 13) owner: gEgo) ; theManaPills
		((gInventory at: 13) realOwner: gEgo) ; theManaPills
	)
	(if ((gInventory at: 11) amount: local40) ; theCurePills
		((gInventory at: 11) owner: gEgo) ; theCurePills
		((gInventory at: 11) realOwner: gEgo) ; theCurePills
	)
	(if (== (& local5 $0030) 48)
		(SetFlag 158)
	)
	(if (& local5 $0004)
		(gEgo get: 28 1) ; thePin
	)
	(return 1)
)

(procedure (localproc_9 &tmp temp0)
	(for ((= temp0 0)) (< temp0 43) ((++ temp0))
		(= [local567 (+ temp0 1)] (localproc_2 [local97 temp0]))
	)
	(for ((= temp0 43)) (< 0 temp0) ((-- temp0))
		(^= [local567 temp0] (& [local567 (- temp0 1)] $007f))
	)
	(= local50 local611)
	(for ((= temp0 0)) (< temp0 35) ((+= temp0 2))
		(= [local567 (+ temp0 1)] (& [local567 (+ temp0 1)] $007f))
		(+= local50 [local567 (+ temp0 1)])
	)
	(= local51 0)
	(for ((= temp0 1)) (< temp0 35) ((+= temp0 2))
		(= [local567 (+ temp0 1)] (& [local567 (+ temp0 1)] $007f))
		(+= local51 [local567 (+ temp0 1)])
	)
	(&= local50 $007f)
	(&= local51 $007f)
	(if (or (!= local50 local605) (!= local51 local606))
		(Prints 2 6 16 1)
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(= [gEgoStats [local612 temp0]] (* 2 [local573 temp0]))
		(if
			(and
				(not (< 12 [local612 temp0] 19))
				(not (<= 0 [local573 temp0] 300))
			)
			(Prints 2 6 16 1)
			(return 0)
		)
	)
	(= gHeroType (= gBaseHeroType local568))
	(= [gEgoStats 13] (/ (+ (* [gEgoStats 1] 2) [gEgoStats 4]) 3)) ; communication, intelligence, luck
	(= [gEgoStats 14] 100) ; honor
	(if ((gInventory at: 10) amount: local598) ; theDaggers
		((gInventory at: 10) owner: gEgo) ; theDaggers
	)
	(if ((gInventory at: 0) amount: 100) ; theRoyals
		((gInventory at: 0) owner: gEgo) ; theRoyals
	)
	(if (& local572 $0020)
		(SetFlag 158)
	)
	(return 1)
)

(procedure (localproc_10)
	(Message msgGET 54 2 6 22 1 @local658) ; "Paladin"
	(Message msgGET 54 2 6 21 1 @local663) ; "Wizard"
	(quest init: show: dispose:)
	(return local657)
)

(procedure (localproc_11)
	(Message msgGET 54 2 6 18 1 @local668) ; "Fighter"
	(Message msgGET 54 2 6 21 1 @local678) ; "Wizard"
	(Message msgGET 54 2 6 19 1 @local688) ; "Thief"
	(Message msgGET 54 2 6 22 1 @local698) ; "Paladin"
	(choose init: show: dispose:)
	(return local657)
)

(instance import of Rm
	(properties
		picture 130
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable:)
		(super init: &rest)
		(Palette palSET_INTENSITY 72 255 60)
		(self setScript: importHero)
	)

	(method (dispose)
		(LoadMany 0 993 944)
		(super dispose:)
	)
)

(instance glory2_sav of File
	(properties
		name {glory2.sav}
	)
)

(instance importHero of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Message msgGET 54 2 6 2 1 @local53) ; "a:glory3.sav"
				(gMessager say: 2 0 0 0 self) ; "Please insert your saved character disk from "Quest for Glory I: So You Want To Be A Hero" or "Quest for Glory II: Trial by Fire" into the disk drive so your hero can make the journey to Quest for Glory III."
			)
			(2
				(= cycles 2)
			)
			(3
				(if (getFileName doit: @local53)
					(glory2_sav name: @local53)
					(= cycles 2)
				else
					(self changeState: 6)
				)
			)
			(4
				(localproc_0)
				(if (= local52 (localproc_1))
					(= cycles 2)
				else
					(self changeState: 7)
				)
			)
			(5
				(gMessager say: 2 6 3 0 self) ; "Your character has been successfully imported. Welcome to Tarna!"
			)
			(6
				(if (and (IsFlag 144) [gEgoStats 29]) ; reversalSpell
					(if (localproc_10)
						(= gHeroType 3) ; Paladin
						(= gBaseHeroType 0) ; Fighter
					else
						(= local1 (= gHeroType (= gBaseHeroType 1))) ; Magic User
					)
				)
				(if (and local52 (< -1 (localproc_11) 4))
					(= gHeroType (= gBaseHeroType local657))
					(if (== local657 3)
						(= gBaseHeroType 0) ; Fighter
					)
				)
				(Palette palSET_INTENSITY 72 255 100)
				(if local52
					(gLongSong fade: 0 2 5 1)
				)
				(gCurRoom newRoom: (if local52 140 else 130))
			)
			(7
				(if
					(Print
						addText: 2 6 4 1 ; "Do you want to try importing your hero again?"
						addButton: 1 2 6 5 1 0 50 ; "YES"
						addButton: 0 2 6 6 1 60 50 ; "NO"
						init:
					)
					(= local603 121)
					(= local604 134)
					(= local607 67)
					(= local608 136)
					(= local609 173)
					(= local610 240)
					(= local41 160)
					(= local42 62)
					(= local45 47)
					(= local46 144)
					(= local47 25)
					(= local48 163)
					(self changeState: 2)
				else
					(= local52 0)
					(self changeState: 6)
				)
			)
		)
	)
)

(instance getFileName of Dialog
	(properties)

	(method (init &tmp temp0 temp1)
		(= window GloryWindow)
		(= nsBottom 0)
		(Message msgGET 54 2 6 8 1 @local397) ; "Import Character"
		(= text @local397)
		(if (not (savedHeros init:))
			(return 0)
		)
		(savedHeros setSize: moveTo: 4 (+ nsBottom 4) state: 2)
		(= temp0 (+ (savedHeros nsRight:) 4))
		(Message msgGET 54 2 6 10 1 @local437) ; "Cancel"
		(Message msgGET 54 2 6 11 1 @local457) ; "Change Directory"
		(Message msgGET 54 2 6 12 1 @local477) ; "Import"
		(importItem
			text: @local477
			setSize:
			moveTo: temp0 (+ 10 (savedHeros nsTop:))
			state: (if (savedHeros nFiles:) 3 else 0)
		)
		(changeDirItem
			text: @local457
			setSize:
			moveTo: temp0 (+ (importItem nsBottom:) 4)
			state: (& (changeDirItem state:) $fff7)
		)
		(cancelItem
			text: @local437
			setSize:
			moveTo: temp0 (+ (changeDirItem nsBottom:) 4)
			state: (& (changeDirItem state:) $fff7)
		)
		(self
			add: savedHeros importItem changeDirItem cancelItem
			setSize:
			center:
			open: 4 15
		)
		(return 1)
	)

	(method (doit param1 &tmp temp0 temp1)
		(GetCWD @local637)
		(if (not (self init:))
			(self dispose:)
			(return 0)
		)
		(repeat
			(cond
				(
					(==
						(= temp0
							(super
								doit:
									(if (savedHeros nFiles:)
										importItem
									else
										changeDirItem
									)
							)
						)
						importItem
					)
					(localproc_4 param1 @local637 (savedHeros cursor:))
					(= temp1 1)
					(break)
				)
				((== temp0 changeDirItem)
					(if (not (= temp1 (localproc_6 self)))
						(break)
					)
				)
				((or (== temp0 0) (== temp0 cancelItem))
					(= local52 0)
					(= temp1 0)
					(break)
				)
			)
		)
		(self dispose:)
		(return temp1)
	)

	(method (dispose)
		(self eachElementDo: #dispose 1 release:)
		(super dispose:)
	)
)

(instance savedHeros of FileSelector
	(properties
		y 16
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 80])
		(gGame setCursor: gWaitCursor)
		(= font gSmallFont)
		(= mask (localproc_4 @temp6 @local637 {*.*}))
		(if (not (= temp1 (self readFiles: mask)))
			(Prints 2 6 9 1)
		else
			(= temp4 text)
			(= temp2 0)
			(while (< temp2 nFiles)
				(for ((= temp3 0)) (= temp5 (StrAt temp4 temp3)) ((++ temp3))
					(StrAt
						temp4
						temp3
						(if (or (< temp5 65) (> temp5 90))
							temp5
						else
							(+ (- temp5 65) 97)
						)
					)
				)
				(++ temp2)
				(+= temp4 x)
			)
		)
		(gGame setCursor: gNormalCursor)
		(return temp1)
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelItem of DButton
	(properties)
)

(instance changeDirItem of DButton
	(properties)
)

(instance importItem of DButton
	(properties)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 50
			left: 72
			bottom: 155
			right: 248
			priority: 15
			yourself:
		)
		(self add: titleIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 70])
		(Message msgGET 54 2 6 20 1 @temp0) ; "You have a choice. In "Quest for Glory II" you became a Paladin. Do you want to be a Paladin in this game, or stay a Wizard?"
		(Display @temp0 dsWIDTH 165 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 70
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local658 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local658 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 85
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local663 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local663 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance choose of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 40
			left: 72
			bottom: 155
			right: 248
			priority: 15
			yourself:
		)
		(self add: chooseIcon figIcon wizIcon thiIcon palIcon)
		(super init: &rest)
	)
)

(instance chooseIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 100] [temp100 10] [temp110 110])
		(switch local1
			(0
				(Message msgGET 54 2 6 18 1 @temp100) ; "Fighter"
			)
			(1
				(Message msgGET 54 2 6 21 1 @temp100) ; "Wizard"
			)
			(2
				(Message msgGET 54 2 6 19 1 @temp100) ; "Thief"
			)
			(3
				(Message msgGET 54 2 6 22 1 @temp100) ; "Paladin"
			)
		)
		(Message msgGET 54 2 6 23 1 @temp0) ; "Your character has been imported as a %s. If you do not feel this is the proper profession, please indicate your preference below..."
		(Format @temp110 @temp0 @temp100)
		(Display @temp110 dsWIDTH 165 dsFONT 999 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance figIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 55
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 0)
		(choose state: (& (choose state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local668 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local668 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance wizIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 70
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 1)
		(choose state: (& (choose state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local678 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local678 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance thiIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 85
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 2)
		(choose state: (& (choose state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local688 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local688 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance palIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 100
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local657 3)
		(choose state: (& (choose state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local698 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local698 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

