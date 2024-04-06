;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use GloryRm)
(use DButton)
(use Str)
(use Print)
(use IconBar)
(use File)
(use System)

(public
	import 0
)

(local
	local0 = 83
	local1
	[local2 3]
	local5
	[local6 39]
	local45 = 160
	local46 = 62
	local47
	local48
	local49 = 47
	local50 = 144
	local51 = 25
	local52 = 163
	local53 = 218
	local54
	local55
	local56
	local57
	local58
	[local59 4]
	[local63 34] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 41]
	local97 = 83
	local98
	[local99 3]
	local102
	[local103 30]
	local133 = 121
	local134 = 134
	local135
	local136
	local137 = 67
	local138 = 136
	local139 = 173
	local140 = 240
	local141 = 206
	[local142 25] = [0 1 2 3 4 5 6 7 8 9 10 11 12 16 17 18 19 20 21 22 23 24 25 26 27]
	local167
	local168
	local169
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 13) ((++ temp0))
		(= [gInitialStats temp0] 0)
	)
	(= gHeroType 0) ; Fighter
	(for ((= temp0 0)) (< temp0 57) ((++ temp0))
		((gInventory at: temp0) amount: 0 owner: 0)
	)
	(= gScore 0)
	(gHeroName copy: {xxxxxxxxxxy})
	(for ((= temp0 0)) (< temp0 48) ((++ temp0))
		(= [local0 (+ temp0 1)] 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 1)) (< temp0 13) ((++ temp0))
		(= [gInitialStats temp0] 0)
	)
	(= gHeroType 0) ; Fighter
	(for ((= temp0 0)) (< temp0 57) ((++ temp0))
		((gInventory at: temp0) amount: 0 owner: 0)
	)
	(= gScore 0)
	(gHeroName copy: {xxxxxxxxxxy})
	(for ((= temp0 0)) (< temp0 52) ((++ temp0))
		(= [local0 (+ temp0 1)] 0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2)
	(localproc_0)
	(if (not (glory2_sav open: 1))
		(Message msgGET 54 2 6 7 1 (local58 data:)) ; "Sorry! I can't find your hero file."
		(Printf (local58 data:) (glory2_sav name:))
		(return 0)
	)
	(= temp0 (Str new: 400))
	(= temp1 (Str new: 4))
	(glory2_sav readString: gHeroName 52)
	(glory2_sav readString: local58 300)
	(if (and (== (local58 size:) 86) (localproc_10))
		(temp0 dispose:)
		(temp1 dispose:)
		(return 1)
	)
	(for ((= temp2 0)) (< temp2 300) ((++ temp2))
		(local58 at: temp2 0)
	)
	(glory2_sav seek: 0 0)
	(glory2_sav readString: gHeroName 52)
	(glory2_sav readString: local58 83)
	(glory2_sav readString: temp1 3)
	(local58 cat: temp1)
	(local58 cat: temp1)
	(local58 cat: temp1)
	(local58 cat: temp1)
	(local58 cat: temp1)
	(glory2_sav readString: temp0 100)
	(local58 cat: temp0)
	(if (localproc_9)
		(temp0 dispose:)
		(temp1 dispose:)
		(return 1)
	else
		(localproc_1)
		(= local53 208)
		(glory2_sav seek: 0 0)
		(glory2_sav readString: local58 52)
		(glory2_sav readString: gHeroName 52)
		(glory2_sav readString: local58 300)
		(if (localproc_12)
			(temp0 dispose:)
			(temp1 dispose:)
			(return 1)
		)
	)
	(Print addText: 2 6 25 1 init:) ; "I'm terribly sorry. That doesn't seem to be a proper "Quest for Glory" saved hero file."
	(local169 dispose:)
	(= local169 (Str new:))
	(temp0 dispose:)
	(temp1 dispose:)
	(return 0)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(return (+ (localproc_5 param3 param4) (* (localproc_5 param1 param2) 100)))
)

(procedure (localproc_4 param1)
	(cond
		((or (== param1 32) (== param1 0))
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

(procedure (localproc_5 param1 param2 &tmp [temp0 2])
	(return (| (<< (localproc_4 param1) $0004) (localproc_4 param2)))
)

(procedure (localproc_6 param1 param2 param3 &tmp temp0 temp1)
	(if (= temp1 (param2 size:))
		(= temp0 (param2 at: (- temp1 1)))
		(if (OneOf temp0 92 58)
			(param1 format: {%s%s} param2 param3)
		else
			(param1 format: {%s%c%s} param2 92 param3)
		)
	else
		(param1 copy: param3)
	)
	(param1 data:)
)

(procedure (localproc_7 param1 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp0 0)
	(for ((= temp1 0)) (= temp2 (param1 at: temp0)) ((++ temp1))
		(if (not (or (<= 48 temp2 57) (<= 65 temp2 90) (<= 97 temp2 122)))
			(Prints 2 6 13 1)
			(local169 dispose:)
			(= local169 (Str new:))
			(return 0)
		)
		(if (>= temp1 8)
			(local169 dispose:)
			(= local169 (Str new:))
			(gMessager say: 2 6 14 1) ; "That file name is too long. File names must have eight or fewer characters."
			(return 0)
		)
		(++ temp0)
	)
	(return 1)
)

(procedure (localproc_8 param1 &tmp temp0 temp1 temp2)
	(= temp1 0)
	(= temp0 (Str new:))
	(gGlory handsOn:)
	(repeat
		(IconBarCursor view: 942 loop: 0 cel: 14 init:)
		(if (not (HaveMouse))
			(gGlory setCursor: IconBarCursor 1 global202 global203)
		else
			(gGlory setCursor: IconBarCursor 1)
		)
		(= temp1
			(Print
				font: 999
				largeAlp: 0
				addText: 1 0 1 1 0 10 ; "New Directory"
				addEdit: (temp0 copy: param1) 30 0 25 param1
				addButton: 1 1 0 0 1 0 40 ; "OK"
				addButton: 0 1 0 0 2 0 58 ; "Cancel"
				init:
			)
		)
		(gGlory handsOff:)
		(if (not temp1)
			(break)
		)
		(if (not (temp0 size:))
			(GetCWD (temp0 data:))
			(local169 dispose:)
			(= local169 (Str new:))
		)
		(if (ValidPath (temp0 data:))
			(local167 copy: temp0)
			(local169 dispose:)
			(= local169 (Str new:))
			(break)
		else
			(Message msgGET 54 2 6 15 1 (local58 data:)) ; "That is not a valid directory."
			(Printf (local58 data:) (temp0 data:))
			(local169 dispose:)
			(= local169 (Str new:))
		)
	)
	(temp0 dispose:)
	(return temp1)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(for ((= temp2 0)) (< temp0 52) ((+= temp2 2))
		(= [local0 (+ temp0 1)]
			(localproc_5 (local58 at: temp2) (local58 at: (+ temp2 1)))
		)
		(++ temp0)
	)
	(for ((= temp0 52)) (< 0 temp0) ((-- temp0))
		(^= [local0 temp0] (& [local0 (- temp0 1)] $00ff))
	)
	(= local54 218)
	(for ((= temp0 0)) (< temp0 40) ((+= temp0 2))
		(&= [local0 (+ temp0 1)] $00ff)
		(+= local54 [local0 (+ temp0 1)])
	)
	(= local55 0)
	(for ((= temp0 1)) (< temp0 40) ((+= temp0 2))
		(&= [local0 (+ temp0 1)] $00ff)
		(+= local55 [local0 (+ temp0 1)])
	)
	(&= local54 $00ff)
	(&= local55 $00ff)
	(if (or (!= local54 local47) (!= local55 local48))
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 34) ((++ temp0))
		(= [gEgoStats [local63 temp0]] [local6 temp0])
		(if
			(and
				(not (< 13 [local63 temp0] 20))
				(not (<= 0 [local6 temp0] 300))
			)
			(return 0)
		)
	)
	(if (== local1 0)
		(if (and [gEgoStats 24] [gEgoStats 30]) ; zapSpell, reversalSpell
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
	(= gHeroType (= global362 local1))
	(if (and (not (& local5 $0080)) (== gHeroType 3)) ; Paladin
		(SetFlag 29)
	)
	(if (== gHeroType 3) ; Paladin
		(= global362 0)
	)
	(if (== (& local5 $0030) 48)
		(SetFlag 22)
	)
	(return 1)
)

(procedure (localproc_10 &tmp temp0 temp1)
	(= temp0 0)
	(for ((= temp1 0)) (< temp0 43) ((+= temp1 2))
		(= [local97 (+ temp0 1)]
			(localproc_5 (local58 at: temp1) (local58 at: (+ temp1 1)))
		)
		(++ temp0)
	)
	(for ((= temp0 43)) (< 0 temp0) ((-- temp0))
		(^= [local97 temp0] (& [local97 (- temp0 1)] $007f))
	)
	(= local54 local141)
	(for ((= temp0 0)) (< temp0 35) ((+= temp0 2))
		(&= [local97 (+ temp0 1)] $007f)
		(+= local54 [local97 (+ temp0 1)])
	)
	(= local55 0)
	(for ((= temp0 1)) (< temp0 35) ((+= temp0 2))
		(&= [local97 (+ temp0 1)] $007f)
		(+= local55 [local97 (+ temp0 1)])
	)
	(&= local54 $007f)
	(&= local55 $007f)
	(if (or (!= local54 local135) (!= local55 local136))
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(= [gEgoStats [local142 temp0]] (* 2 [local103 temp0]))
		(if
			(and
				(not (< 12 [local142 temp0] 20))
				(not (<= 0 [local103 temp0] 300))
			)
			(return 0)
		)
	)
	(= gHeroType (= global362 local98))
	(= [gEgoStats 13] (/ (+ (* [gEgoStats 1] 2) [gEgoStats 4]) 3)) ; communication, intelligence, luck
	(= [gEgoStats 14] 100) ; honor
	(if (& local102 $0020)
		(SetFlag 22)
	)
	(return 1)
)

(procedure (localproc_11 &tmp temp0 temp1)
	(= temp0 (Str new:))
	(Message msgGET 54 2 6 23 1 (temp0 data:)) ; "Your character has been imported as a %s. Only if this is incorrect, indicate your profession below, otherwise select continue..."
	(= temp1 (Str new:))
	(switch local1
		(0
			(Message msgGET 54 2 6 18 1 (temp1 data:)) ; "Fighter"
		)
		(1
			(Message msgGET 54 2 6 21 1 (temp1 data:)) ; "Wizard"
		)
		(2
			(Message msgGET 54 2 6 19 1 (temp1 data:)) ; "Thief"
		)
		(3
			(Message msgGET 54 2 6 22 1 (temp1 data:)) ; "Paladin"
		)
	)
	(gGlory handsOn:)
	(IconBarCursor view: 942 loop: 0 cel: 14 init:)
	(if (not (HaveMouse))
		(gGlory setCursor: IconBarCursor 1 global202 global203)
	else
		(gGlory setCursor: IconBarCursor 1)
	)
	(= local168
		(Print
			addTextF: (temp0 data:) (temp1 data:)
			font: 999
			addButton: 4 2 6 26 1 0 65 54 ; "Continue"
			addButton: 0 2 6 18 1 70 65 54 ; "Fighter"
			addButton: 1 2 6 21 1 70 85 54 ; "Wizard"
			addButton: 2 2 6 19 1 130 65 54 ; "Thief"
			addButton: 3 2 6 22 1 130 85 54 ; "Paladin"
			init:
		)
	)
	(gGlory handsOff:)
	(temp0 dispose:)
	(temp1 dispose:)
	(return local168)
)

(procedure (localproc_12 &tmp temp0 temp1)
	(= temp0 0)
	(for ((= temp1 0)) (< temp0 52) ((+= temp1 4))
		(= [local0 (+ temp0 1)]
			(localproc_3
				(local58 at: temp1)
				(local58 at: (+ temp1 1))
				(local58 at: (+ temp1 2))
				(local58 at: (+ temp1 3))
			)
		)
		(++ temp0)
	)
	(for ((= temp0 52)) (< 0 temp0) ((-- temp0))
		(^= [local0 temp0] [local0 (- temp0 1)])
	)
	(= local54 local53)
	(for ((= temp0 0)) (< temp0 45) ((+= temp0 2))
		(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
		(+= local54 [local0 (+ temp0 1)])
	)
	(= local55 0)
	(for ((= temp0 1)) (< temp0 45) ((+= temp0 2))
		(= [local0 (+ temp0 1)] [local0 (+ temp0 1)])
		(+= local55 [local0 (+ temp0 1)])
	)
	(for ((= temp0 0)) (< temp0 34) ((++ temp0))
		(= [gEgoStats [local63 temp0]] [local6 (- temp0 1)])
		(if
			(and
				(not (< 13 [local63 temp0] 20))
				(not (<= 0 [local6 temp0] 300))
			)
			(cond
				((> [local6 temp0] 300)
					(= [local6 temp0] 300)
				)
				((< [local6 temp0] 0)
					(= [local6 temp0] 0)
				)
			)
		)
	)
	(if (and (== local1 0) [gEgoStats [local63 24]] [gEgoStats [local63 30]])
		(= local1 1)
	)
	(if (== (= gHeroType (= global362 local1)) 3)
		(= global362 0)
	)
	(if (& local5 $0020)
		(SetFlag 387)
	)
	(return 1)
)

(instance import of GloryRm
	(properties
		picture 130
	)

	(method (init)
		(gGlory handsOff:)
		(= local167 (Str new:))
		(GetCWD (local167 data:))
		(= local58 (Str newWith: 301))
		(= local57 (Str new:))
		(= local169 (Str new:))
		(super init: &rest)
		(self setScript: importHero)
	)

	(method (dispose)
		(local167 dispose:)
		(local58 dispose:)
		(local57 dispose:)
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

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Message msgGET 54 2 6 2 1 (local57 data:)) ; "a:shadows.sav"
				(gMessager say: 2 0 0 0 self) ; "Please insert your saved character disk from any of the first three Quest for Glory games into the disk drive so your hero can make the journey to Quest for Glory: Shadows of Darkness."
			)
			(2
				(= cycles 2)
			)
			(3
				(= temp2 (Str new:))
				(gGlory handsOn:)
				(IconBarCursor view: 942 loop: 0 cel: 14 init:)
				(if (not (HaveMouse))
					(gGlory setCursor: IconBarCursor 1 global202 global203)
				else
					(gGlory setCursor: IconBarCursor 1)
				)
				(= temp1
					(Print
						font: 999
						largeAlp: 0
						addText: 2 6 8 1 5 -5 54 ; "Import Character, file must have '.sav' extension."
						addFSelector:
							0
							15
							8
							(localproc_6 temp2 local167 {*.sav})
						classButton: MyButton
						addButton: 1 2 6 12 1 126 18 54 ; "Import"
						classButton: changeButton
						addButton: 2 2 6 11 1 126 40 54 ; "Change  Directory"
						classButton: MyButton
						addButton: 0 2 6 10 1 126 70 54 ; "Cancel"
						init:
					)
				)
				(gGlory handsOff:)
				(temp2 dispose:)
				(switch temp1
					(0
						(gCurRoom newRoom: 100)
					)
					(2
						(localproc_8 local167)
						(self changeState: 2)
					)
					(else
						(local169 cat: local167)
						(= temp3 (local167 size:))
						(= temp4 (local167 at: (- temp3 1)))
						(if (OneOf temp4 92 58)
							0
						else
							(local169 cat: {\5c})
						)
						(local169 cat: gSaveFileSelText)
						(glory2_sav name: (local169 data:))
					)
				)
				(= cycles 2)
			)
			(4
				(if (= local56 (localproc_2))
					(= cycles 2)
				else
					(self changeState: 7)
				)
			)
			(5
				(gMessager say: 2 6 3 0 self) ; "Your character has been successfully imported. Welcome to "Shadows of Darkness!""
			)
			(6
				(if (and local56 (< -1 (localproc_11) 4))
					(= gHeroType (= global362 local168))
					(if (== local168 3)
						(= global362 0)
					)
				)
				(gCurRoom newRoom: (if local56 140 else 100))
			)
			(7
				(gGlory handsOn:)
				(IconBarCursor view: 942 loop: 0 cel: 14 init:)
				(if (not (HaveMouse))
					(gGlory setCursor: IconBarCursor 1 global202 global203)
				else
					(gGlory setCursor: IconBarCursor 1)
				)
				(if
					(Print
						addText: 2 6 4 1 ; "Do you want to try importing your hero again?"
						font: 999
						addButton: 1 2 6 5 1 0 50 ; "YES"
						addButton: 0 2 6 6 1 60 50 ; "NO"
						init:
					)
					(gGlory handsOff:)
					(local169 dispose:)
					(= local169 (Str new:))
					(= local133 121)
					(= local134 134)
					(= local137 67)
					(= local138 136)
					(= local139 173)
					(= local140 240)
					(= local45 160)
					(= local46 62)
					(= local49 47)
					(= local50 144)
					(= local51 25)
					(= local52 163)
					(self changeState: 2)
				else
					(gGlory handsOff:)
					(local169 dispose:)
					(= local169 (Str new:))
					(= local56 0)
					(self changeState: 6)
				)
			)
		)
	)
)

(class MyButton of DButton
	(properties
		view 64990
		fore 0
		font 999
	)
)

(instance changeButton of MyButton
	(properties
		loop 1
	)
)

