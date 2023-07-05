;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Inventory)
(use System)

(public
	theInvSheet 0
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 [temp1 40])
	(Display
		(Format @temp1 206 0 (= temp0 [gInvNum param1])) ; "%d"
		dsCOORD
		(+ param2 5)
		param3
		dsALIGN
		alRIGHT
		dsFONT
		gSmallFont
		dsCOLOR
		1
		dsWIDTH
		20
	)
	(Display
		(Format @temp1 3 (+ param1 param1) (if (> temp0 1) 115 else 0))
		dsCOORD
		(+ param2 30)
		param3
		dsALIGN
		alLEFT
		dsFONT
		gSmallFont
		dsCOLOR
		1
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 [temp1 8])
	(= temp0 (- param1 17))
	(Display
		(Format @temp1 206 0 [global190 temp0]) ; "%d"
		dsCOORD
		(+ param2 7)
		param3
		dsALIGN
		alLEFT
		dsFONT
		gSmallFont
		dsCOLOR
		1
		dsWIDTH
		20
	)
	(Display 4 temp0 dsCOORD (+ param2 33) param3 dsALIGN alLEFT dsFONT gSmallFont dsCOLOR 1)
	(Display
		(Format @temp1 206 0 [gEgoStats param1]) ; "%d"
		dsCOORD
		(+ param2 105)
		param3
		dsALIGN
		alLEFT
		dsFONT
		gSmallFont
		dsCOLOR
		1
	)
)

(class InvSheet of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 189
		nsRight 320
		theWindow 0
	)

	(method (dispose)
		(DisposeWindow theWindow)
		(super dispose:)
		(DisposeScript 206)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 evNULL)
		(while (not temp1)
			(GlobalToLocal (= temp0 (Event new:)))
			(= temp1 (temp0 type:))
			(temp0 dispose:)
		)
		(self dispose:)
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 [temp5 40])
		(super init:)
		(= theWindow (NewWindow nsTop nsLeft nsBottom nsRight {} 0 15 1 15))
		(Display 206 1 dsCOORD 10 8 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "You Are Carrying:"
		(= temp4 (WtCarried))
		(= temp0 1)
		(= temp2 24)
		(while (<= temp0 41)
			(if (and (> [gInvNum temp0] 0) (> temp0 2))
				(if (<= temp2 160)
					(localproc_0 temp0 10 temp2)
				)
				(+= temp2 9)
			)
			(++ temp0)
		)
		(cond
			((== temp2 24)
				(Display 206 2 dsCOORD 40 (+ temp2 5) dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Nothing"
			)
			((>= temp2 174)
				(Display 206 3 dsCOORD 40 172 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; ". . . and more"
			)
		)
		(= temp3 (if (< global211 16) 4 else 12))
		(Display
			(Format @temp5 206 0 [gInvNum 2]) ; "%d", gold
			dsCOORD
			180
			10
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			temp3
			dsWIDTH
			25
		)
		(Display 206 4 dsCOORD 220 10 dsALIGN alLEFT dsFONT 300 dsCOLOR temp3) ; "Gold Coins"
		(= temp3 (if (< global211 16) 8 else 7))
		(Display
			(Format @temp5 206 0 [gInvNum 1]) ; "%d", silver
			dsCOORD
			180
			23
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			temp3
			dsWIDTH
			25
		)
		(Display 206 5 dsCOORD 220 23 dsALIGN alLEFT dsFONT 300 dsCOLOR temp3) ; "Silver Coins"
		(= temp3
			(cond
				((< temp4 (/ (* (MaxLoad) 90) 100)) 1)
				((< global211 16) 4)
				(else 12)
			)
		)
		(Display
			(Format @temp5 206 6 temp4) ; "%d#"
			dsCOORD
			180
			36
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			temp3
			dsWIDTH
			25
		)
		(Display 206 7 dsCOORD 220 36 dsALIGN alLEFT dsFONT 300 dsCOLOR temp3) ; "Weight Carried"
		(Display
			(Format @temp5 206 6 (MaxLoad)) ; "%d#"
			dsCOORD
			180
			49
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			temp3
			dsWIDTH
			25
		)
		(Display 206 8 dsCOORD 220 49 dsALIGN alLEFT dsFONT 300 dsCOLOR temp3) ; "Max Weight"
		(if [gEgoStats 12] ; magic
			(Display 206 9 dsCOORD 185 75 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "MP"
			(Display 206 10 dsCOORD 218 75 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Spells:"
			(Display 206 11 dsCOORD 280 75 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Skill"
			(= temp2 91)
			(= temp0 17)
			(= temp2 91)
			(while (< temp0 25)
				(if (> [gEgoStats temp0] 0)
					(localproc_1 temp0 185 temp2)
					(+= temp2 9)
				)
				(++ temp0)
			)
		)
	)
)

(instance theInvSheet of InvSheet
	(properties)
)

