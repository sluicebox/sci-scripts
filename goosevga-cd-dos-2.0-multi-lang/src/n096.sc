;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc96_0 0
	proc96_1 1
)

(procedure (proc96_0 &tmp temp0 temp1 [temp2 150] [temp152 5]) ; UNUSED
	(Format @temp2 96 0)
	(for ((= temp1 41)) (<= temp1 60) ((++ temp1))
		(for ((= temp0 1)) (<= temp0 44) ((++ temp0))
			(if (== [global200 temp0] temp1)
				(switch temp1
					(41
						(Format @temp152 96 1) ; "wife"
					)
					(42
						(Format @temp152 96 2) ; "muffet"
					)
					(44
						(Format @temp152 96 3) ; "mouse"
					)
					(45
						(Format @temp152 96 4) ; "sheep"
					)
					(46
						(Format @temp152 96 5) ; "dog"
					)
					(47
						(Format @temp152 96 6) ; "lamb"
					)
					(48
						(Format @temp152 96 7) ; "fiddle"
					)
					(49
						(Format @temp152 96 8) ; "pie"
					)
					(50
						(Format @temp152 96 9) ; "knife"
					)
					(51
						(Format @temp152 96 10) ; "meat"
					)
					(52
						(Format @temp152 96 11) ; "pipe"
					)
					(54
						(Format @temp152 96 12) ; "broth"
					)
					(55
						(Format @temp152 96 13) ; "candle"
					)
					(56
						(Format @temp152 96 14) ; "pail"
					)
					(57
						(Format @temp152 96 15) ; "can"
					)
					(58
						(Format @temp152 96 16) ; "coin"
					)
					(59
						(Format @temp152 96 17) ; "ladder"
					)
					(60
						(Format @temp152 96 18) ; "horse"
					)
					(else
						(Format @temp152 96 19) ; "???"
					)
				)
				(Format @temp2 96 20 @temp2 @temp152 temp0) ; "%s%s@rm%d"
				(break)
			)
		)
	)
	(Format @temp2 96 21 @temp2 global130) ; "%s ego has %d"
	(Print @temp2)
	(DisposeScript 96)
)

(procedure (proc96_1 param1 &tmp temp0)
	(= temp0 (Random 1 44))
	(-- temp0)
	(repeat
		(if (> (++ temp0) 44)
			(= temp0 1)
		)
		(breakif
			(if (== [global200 temp0] 0)
				(breakif (< temp0 36))
				(if (and (> param1 47) (or (!= temp0 40) (!= param1 58)))
					(breakif (!= temp0 44))
					(!= param1 54)
				)
			)
		)
	)
	(= [global200 temp0] param1)
	(DisposeScript 96)
)

