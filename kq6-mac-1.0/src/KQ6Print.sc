;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Interface)
(use Kq6Talker)
(use Print)
(use Dialog)

(class KQ6Print of Print
	(properties)

	(method (say param1 &tmp [temp0 7])
		(self addText: param1 &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (addText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(if (> argc 3)
			(= temp0 [param1 0])
			(= temp1 [param1 1])
			(= temp2 [param1 2])
			(= temp3 (if [param1 3] [param1 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 [param1 4])
				(if (>= argc 6)
					(= temp5 [param1 5])
					(if (>= argc 7)
						(= temp6 [param1 6])
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7)
					(= temp9 (StrAt temp7 0))
					(if (>= 90 temp9 65)
						(StrAt temp7 0 9)
						(= temp10 (+ 0 (/ (- temp9 65) 13)))
						(= temp11 (mod (- temp9 65) 13))
						(dialog
							add:
								((DText new:)
									text: temp7
									font: font
									mode: mode
									setSize: width
									moveTo: (+ 4 temp4) (+ 4 temp5 7)
									yourself:
								)
							add:
								((DIcon new:)
									view: (Kq6Narrator strView:)
									loop: temp10
									cel: temp11
									setSize:
									moveTo: (+ temp4 4) (+ 4 temp5 2)
									yourself:
								)
							setSize:
						)
					else
						(dialog
							add:
								((DText new:)
									text: temp7
									font: font
									mode: mode
									setSize: width
									moveTo: (+ 4 temp4) (+ 4 temp5)
									yourself:
								)
							setSize:
						)
					)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 [param1 1])
				(if (>= argc 3)
					(= temp5 [param1 2])
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen [param1 0]) 1)))
			(StrCpy temp7 [param1 0])
			(dialog
				add:
					((DText new:)
						text: temp7
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)
)

