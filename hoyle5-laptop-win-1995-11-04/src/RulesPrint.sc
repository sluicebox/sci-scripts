;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 821)
(include sci.sh)
(use Main)
(use DButton)
(use Str)
(use Print)
(use Dialog)
(use System)

(public
	proc821_0 0
)

(procedure (proc821_0 param1 param2)
	(rulesPrint init: param1 param2 &rest)
)

(class RulesPrint of Print
	(properties)

	(method (addTextF param1 param2 &tmp temp0 temp1)
		(= temp0 (FindFormatLen &rest))
		(= temp1 (Str newWith: temp0 {}))
		(temp1 format: &rest)
		(self addText: (temp1 data:) param1 param2)
		(temp1 dispose:)
	)

	(method (addButton param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= temp9 (if classButton classButton else DButton))
		(if (> argc 4)
			(= temp0 [param2 0])
			(= temp1 [param2 1])
			(= temp2 [param2 2])
			(= temp3 (if [param2 3] [param2 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (> argc 5)
				(= temp4 [param2 4])
				(if (> argc 6)
					(= temp5 [param2 5])
					(if (> argc 7)
						(= temp6 [param2 6])
					)
				)
			)
			(= temp7 (Str new:))
			(if
				(or
					(not (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
					(not
						(Message msgGET temp6 temp0 temp1 temp2 temp3 (temp7 data:))
					)
				)
				(temp7 dispose:)
				(return 0)
			)
			(dialog
				add:
					(= temp8
						((temp9 new:)
							value: param1
							font: font
							fore: fore
							back:
								(if (== back -1)
									(temp9 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp9 skip:)
								else
									skip
								)
							text: (temp7 data:)
							setSize:
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
			(temp7 data: 0 dispose:)
		else
			(= temp4 0)
			(= temp5 0)
			(if (> argc 2)
				(= temp4 [param2 1])
				(if (> argc 3)
					(= temp5 [param2 2])
				)
			)
			(= temp7 (KString 8 (KString 9 [param2 0]))) ; StrDup, StrGetData
			(dialog
				add:
					(= temp8
						((temp9 new:)
							value: param1
							font: font
							fore: fore
							back:
								(if (== back -1)
									(temp9 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp9 skip:)
								else
									skip
								)
							text: temp7
							setSize:
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
		)
		(return temp8)
	)

	(method (addButtonBM param1 param2 param3 &tmp temp0)
		(= temp0 (self addButton: &rest))
		(if (!= param1 -1)
			(temp0
				view: param1
				loop: param2
				cel: param3
				setPri: 140
				borderColor: -1
				setSize:
			)
		else
			(temp0 view: 64990 loop: 0 cel: 0 setSize:)
		)
	)
)

(instance rulesPrint of Code
	(properties)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(if (< argc 4)
			(= temp2 18)
		else
			(= temp2 param4)
		)
		(if (< argc 3)
			(= temp3 1)
		else
			(= temp3 param3)
		)
		(for ((= temp0 1)) (<= temp0 param2) ((++ temp0))
			(if
				(not
					(= temp1
						(RulesPrint
							back: -1
							margin: 13
							fore: 0
							font: gUserFont
							addBitmap: 917 6 0
							addText: temp3 temp2 0 temp0 0 0 param1
							addButtonBM: 917 1 0 1 {Back} 5 214
							addButtonBM: 917 2 0 2 {Forward} 78 214
							addButtonBM: 917 3 0 3 {Cancel} 161 214
							addTextF: 247 215 {%d of %d} temp0 param2
							init:
						)
					)
				)
				(break)
			else
				(if (== temp1 1)
					(if (== temp0 1)
						(= temp0 (+ param2 1))
					)
					(-= temp0 2)
				)
				(if (== temp1 3)
					(= temp0 param2)
				)
			)
		)
		(DisposeScript 821)
	)
)

