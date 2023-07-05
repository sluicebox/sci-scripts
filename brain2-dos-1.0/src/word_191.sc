;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 191)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use GameControls)
(use Window)
(use System)

(public
	word 0
)

(local
	local0
	local1
	[local2 621]
	local623
	[local624 20]
	local644
	local645
	local646
	[local647 8] = [1 1 0 -1 -1 -1 0 1]
	[local655 8] = [0 1 1 1 0 -1 -1 -1]
	[local663 20]
	[local683 20]
	local703
	local704
	local705 = 1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 [temp2 72] temp74 temp75 temp76)
	(localproc_3 @temp2 (* 36 (+ global114 1)))
	(= temp76 (= temp0 0))
	(while (< temp0 20)
		(= [local624 temp0] (localproc_2 @temp2))
		(Message
			msgGET
			190
			1
			0
			(switch (+ param1 (/ [local624 temp0] 36))
				(0 8)
				(1 10)
				(2 15)
				(3 7)
				(4 12)
				(5 13)
				(6 6)
				(7 11)
				(8 14)
			)
			(+ 1 (mod [local624 temp0] 36))
			(+ (* 16 temp0) local623)
		)
		(if (> (= temp75 (StrLen (+ (* 16 temp0) local623))) temp76)
			(= local646 temp0)
			(= temp76 temp75)
		)
		(++ temp0)
	)
	(for ((= temp0 0)) (< temp0 621) ((+= temp0 23))
		(= [local2 temp0] 0)
	)
	(for ((= temp1 (= temp0 0))) (< temp0 20) ((++ temp1))
		(if (StrAt local623 temp1)
			(if (u> (= temp74 (- (StrAt local623 temp1) 97)) 25)
				(= temp74 26)
			)
			(if (>= [local2 (*= temp74 23)] 22)
				(return 1)
			)
			(= [local2 (+ temp74 (++ [local2 temp74]))] temp1)
		else
			(= temp1 (- (* (++ temp0) 16) 1))
		)
	)
	(return 0)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6) ; UNUSED
	(Printf 191 0 param1 local1 local623) ; "didn't work %d %x %x"
	(= temp1 (+ local645 (* param1 91) 71))
	(= temp2 (Memory memPEEK (+ local0 (* 8 param1) 2)))
	(= temp3 (Memory memPEEK (+ local0 (* 8 param1))))
	(= temp4 [local647 [local683 param1]])
	(= temp5 [local655 [local683 param1]])
	(= temp6 (StrAt local1 (+ temp2 16 (* temp3 16))))
	(= temp0 0)
	(while (< temp0 [local663 param1])
		(StrAt local1 (+ temp2 16 (* temp3 16)) (StrAt temp1 temp0))
		(++ temp0)
		(+= temp2 temp4)
		(+= temp3 temp5)
	)
	(StrAt local623 (* (StrAt temp1 temp0) 16) temp6)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(if (= temp0 (StrAt param1 0))
		(= temp2 (Random 1 temp0))
		(= temp1 (StrAt param1 temp2))
		(StrCpy (+ param1 temp2) (+ param1 temp2 1))
		(StrAt param1 0 (- temp0 1))
		(return (- temp1 97))
	else
		(StrAt param1 0 255)
		(return 255)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0)
	(if (not param2)
		(Prints {0 length init})
	)
	(StrAt param1 0 param2)
	(for ((= temp0 1)) (<= temp0 param2) ((++ temp0))
		(StrAt param1 temp0 (+ 96 temp0))
	)
	(StrAt param1 temp0 0)
)

(instance word of Code
	(properties)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1)
		(= local1 param1)
		(= local0 param2)
		(= local644 param3)
		(= local703 param4)
		(= local645 (Memory memALLOC_CRIT 1820))
		((GameControls new:)
			window: ethnicWin
			add:
				(ethnicDude cel: (Random 0 1) yourself:)
				((ethnicDude new:)
					loop: 1
					cel: (Random 0 1)
					nsLeft: 65
					message: 3
					yourself:
				)
				((ethnicDude new:)
					loop: 2
					cel: (Random 0 1)
					nsLeft: 113
					message: 6
					yourself:
				)
			show:
			dispose:
		)
		(if (== (= temp1 (Memory memPEEK local703)) -1)
			(Memory memFREE local645)
			(return)
		)
		(gCSoundFX number: 22 loop: -1 play:)
		((Print new:) addText: {Generating puzzle} modeless: 1 init:)
		(= local623 (Memory memALLOC_CRIT 321))
		(while (localproc_0 temp1)
		)
		(= temp0 (GetTime))
		(while local705
			(assemble doit:)
			(if local705
				(while (localproc_0 temp1)
				)
			)
		)
		(Memory memFREE local645)
		(Memory memFREE local623)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCSoundFX stop:)
	)
)

(instance assemble of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= local705 0)
		(= local704 0)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(StrAt local1 temp0 255)
		)
		(while (< temp0 256)
			(StrAt local1 temp0 46)
			(++ temp0)
		)
		(while (< temp0 272)
			(StrAt local1 temp0 255)
			(++ temp0)
		)
		(for ((= temp0 31)) (< temp0 256) ((+= temp0 16))
			(StrAt local1 temp0 255)
		)
		(for ((= temp0 0)) (< temp0 1820) ((+= temp0 91))
			(StrAt local645 temp0 255)
			(StrAt local645 (+ temp0 21) 255)
			(StrAt local645 (+ temp0 38) 255)
			(StrAt local645 (+ temp0 62) 255)
		)
		(while (!= 1 (placeDetach doit: local645 0))
		)
		(= temp0 1)
		(while (< temp0 20)
			(= temp2 (+ local645 (* temp0 91)))
			(while (not (= temp1 (getCrosser doit: temp2 temp0)))
			)
			(if local705
				(return 255)
			)
			(if (== temp1 255)
				(for ((= temp3 0)) (< temp3 50) ((++ temp3))
					(if (placeDetach doit: temp2 temp0)
						(break)
					)
				)
				(if local705
					(return 255)
				)
				(if (== temp3 50)
					(= local705 1)
					(return 255)
				else
					(++ temp0)
				)
			else
				(++ temp0)
			)
			(if (< temp1 0)
				(Prints {exausted})
			)
		)
		(for ((= temp0 31)) (< temp0 256) ((+= temp0 16))
			(StrAt local1 temp0 0)
		)
		(for ((= temp0 16)) (< temp0 256) ((++ temp0))
			(if (== (StrAt local1 temp0) 46)
				(= temp1 (Random 0 19))
				(= temp3 (Random 0 (- [local663 temp1] 1)))
				(StrAt
					local1
					temp0
					(StrAt
						local1
						(+
							(*
								16
								(+
									(WordAt local0 (* 4 temp1))
									(* temp3 [local655 [local683 temp1]])
								)
							)
							16
							(WordAt local0 (+ (* 4 temp1) 1))
							(* temp3 [local647 [local683 temp1]])
						)
					)
				)
			)
		)
	)
)

(instance getCrosser of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1)
		(if (== (StrAt param1 0) 255)
			(localproc_3 param1 param2)
		)
		(if (== (= temp0 (localproc_2 param1)) 255)
			(return 255)
		)
		(while (not (= temp1 (getSpot doit: param1 param2 temp0)))
		)
		(if local705
			(return 255)
		)
		(return (if (== temp1 255) 0 else temp1))
	)
)

(instance getSpot of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp2 (+ param1 21))
		(if (== (StrAt temp2 0) 255)
			(localproc_3 temp2 [local663 param3])
		)
		(if (== (= temp0 (localproc_2 temp2)) 255)
			(return 255)
		)
		(while (not (= temp1 (getWord doit: temp2 param2 param3 temp0)))
		)
		(if local705
			(return 255)
		)
		(return (if (== temp1 255) 0 else temp1))
	)
)

(instance getWord of Code
	(properties)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp3
			(+
				(WordAt local0 (+ (* 4 param3) 1))
				(* param4 [local647 [local683 param3]])
			)
		)
		(= temp4
			(+
				(WordAt local0 (* 4 param3))
				(* param4 [local655 [local683 param3]])
			)
		)
		(if
			(u>
				(= temp6
					(- (= temp6 (StrAt local1 (+ (* 16 temp4) 16 temp3))) 97)
				)
				25
			)
			(= temp6 26)
		)
		(= temp2 (+ param1 17))
		(if (== (StrAt temp2 0) 255)
			(if (= temp7 [local2 (* 23 temp6)])
				(localproc_3 temp2 temp7)
			else
				(return 255)
			)
		)
		(if (== (= temp0 (localproc_2 temp2)) 255)
			(return 255)
		)
		(= temp5 [local2 (+ (* 23 temp6) temp0 1)])
		(if (> (++ local704) 4000)
			(= local705 1)
			(return 255)
		)
		(while (not (= temp1 (placeWord doit: temp2 param2 temp3 temp4 temp5)))
		)
		(return (if (== temp1 255) 0 else temp1))
	)
)

(instance placeWord of Code
	(properties)

	(method (doit param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0 (- param5 (mod param5 16)))
		(= temp2 (+ param1 24))
		(if (== (StrAt temp2 0) 255)
			(localproc_3 temp2 (if global114 8 else 3))
		)
		(if (== (= temp1 (localproc_2 temp2)) 255)
			(return 255)
		)
		(if (not (StrAt local623 temp0))
			(return 0)
		)
		(= temp5 [local647 temp1])
		(= temp7 [local655 temp1])
		(= temp4 (- param3 (* (- param5 temp0) temp5)))
		(= temp6 (- param4 (* (- param5 temp0) temp7)))
		(if (| (& $fff0 temp4) (& $fff0 temp6))
			(return 0)
		)
		(+= temp4 (+ 16 (* temp6 16)))
		(= temp6 (+ temp5 (* temp7 16)))
		(= temp3 temp0)
		(while (and (= temp5 (StrAt local623 temp3)) (not (& temp4 $ff00)))
			(if (and (!= (= temp8 (StrAt local1 temp4)) 46) (!= temp8 temp5))
				(return 0)
			)
			(++ temp3)
			(+= temp4 temp6)
		)
		(= temp5 [local647 temp1])
		(if (StrAt local623 temp3)
			(return 0)
		else
			(+= temp2 9)
			(= temp4 (- param3 (* (- param5 temp0) temp5)))
			(= temp6 (- param4 (* (- param5 temp0) temp7)))
			(Memory memPOKE (+ local0 (* 8 param2) 2) temp4)
			(Memory memPOKE (+ local0 (* 8 param2)) temp6)
			(= temp3 temp0)
			(while (StrAt local623 temp3)
				(StrAt temp2 0 (StrAt local1 (+ temp4 16 (* temp6 16))))
				(StrAt local1 (+ temp4 16 (* temp6 16)) (StrAt local623 temp3))
				(++ temp3)
				(++ temp2)
				(+= temp4 temp5)
				(+= temp6 temp7)
			)
			(= [local683 param2] temp1)
			(= [local663 param2] (- temp3 temp0))
			(Memory memPOKE (+ local0 (* 8 param2) 6) (- temp4 temp5))
			(Memory memPOKE (+ local0 (* 8 param2) 4) (- temp6 temp7))
			(Memory memPOKE (+ local644 (* 2 param2)) [local624 (/ param5 16)])
			(StrAt local623 temp0 0)
			(StrAt temp2 0 (/ temp0 16))
			(return 1)
		)
	)
)

(instance placeDetach of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 20])
		(= temp3 (+ param1 38))
		(= temp0 (Random 0 14))
		(= temp1 (Random 0 14))
		(if param2
			(localproc_3 @temp5 20)
			(while 1
				(= temp2 (* (localproc_2 @temp5) 16))
				(if (StrAt local623 temp2)
					(break)
				)
			)
		else
			(= temp2 (* local646 16))
		)
		(if (> (++ local704) 4000)
			(= local705 1)
			(return 255)
		)
		(while (not (= temp4 (placeWord doit: temp3 param2 temp0 temp1 temp2)))
		)
		(return (if (== temp4 255) 0 else temp4))
	)
)

(instance ethnicDude of IconI
	(properties
		view 179
		loop 0
		nsLeft 12
		nsTop 35
		message 0
		signal 193
		lowlightColor 53
	)

	(method (select)
		(Memory memPOKE local703 message)
	)
)

(instance ethnicWin of SysWindow
	(properties
		top 40
		left 20
		bottom 160
		right 189
		back 53
		priority -1
	)

	(method (open &tmp [temp0 100])
		(super open: &rest)
		(Message msgGET 180 16 9 0 1 @temp0) ; "Please choose one of the following languages for the Coconut Tree Word Search puzzle."
		(Display @temp0 dsCOORD 4 3 dsWIDTH 170)
		(Message msgGET 180 16 9 0 2 @temp0) ; "Spanish"
		(Display @temp0 dsCOORD 8 110)
		(Message msgGET 180 16 9 0 3 @temp0) ; "French"
		(Display @temp0 dsCOORD 63 110)
		(Message msgGET 180 16 9 0 4 @temp0) ; "German"
		(Display @temp0 dsCOORD 113 110)
	)
)

