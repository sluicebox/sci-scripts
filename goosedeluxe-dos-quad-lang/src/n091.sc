;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Str)
(use Print)

(public
	proc91_0 0
	proc91_1 1
)

(procedure (proc91_0 &tmp temp0 temp1 temp2 [temp3 149] temp152 [temp153 4])
	(= temp2 (Str new: 150))
	(= temp152 (Str new: 5))
	(temp2 format: {})
	(for ((= temp1 41)) (<= temp1 60) ((++ temp1))
		(for ((= temp0 1)) (<= temp0 44) ((++ temp0))
			(if (== [global200 temp0] temp1)
				(switch temp1
					(41
						(temp152 format: {wife})
					)
					(42
						(temp152 format: {muffet})
					)
					(44
						(temp152 format: {mouse})
					)
					(45
						(temp152 format: {sheep})
					)
					(46
						(temp152 format: {dog})
					)
					(47
						(temp152 format: {lamb})
					)
					(48
						(temp152 format: {fiddle})
					)
					(49
						(temp152 format: {pie})
					)
					(50
						(temp152 format: {knife})
					)
					(51
						(temp152 format: {meat})
					)
					(52
						(temp152 format: {pipe})
					)
					(54
						(temp152 format: {broth})
					)
					(55
						(temp152 format: {candle})
					)
					(56
						(temp152 format: {pail})
					)
					(57
						(temp152 format: {can})
					)
					(58
						(temp152 format: {coin})
					)
					(59
						(temp152 format: {ladder})
					)
					(60
						(temp152 format: {horse})
					)
					(else
						(temp152 format: {???})
					)
				)
				(temp2 format: {%s%s@rm%d } temp2 temp152 temp0)
				(break)
			)
		)
	)
	(temp2 format: {%s ego has %d} temp2 global130)
	(Print addText: temp2 init:)
	(temp2 dispose:)
	(temp152 dispose:)
	(DisposeScript 91)
)

(procedure (proc91_1 param1 &tmp temp0)
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
	(DisposeScript 91)
)

