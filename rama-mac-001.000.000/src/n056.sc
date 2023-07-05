;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Str)

(public
	proc56_0 0
)

(local
	local0 = 7
	[local1 10] = [{g} {ab} {ay} {an} {d} {ah} {j} {ax} {ac} {ar}]
	[local11 26] = [{Q} {As} {E} {O} {Au} {U} {0} {S} {V} {Ai} {P} {9} {H} {X} {Ap} {L} {3} {Z} {I} {W} {Am} {Y} {T} {1} {N} {2}]
	[local37 26] = [{q} {as} {e} {o} {au} {u} {0} {s} {v} {ai} {p} {9} {h} {x} {ap} {l} {3} {z} {i} {w} {am} {y} {t} {1} {n} {2}]
	[local63 26] = [{Ag} {M} {Aa} {K} {Av} {5} {At} {R} {6} {:} {Aj} {Ak} {B} {Ad} {Aq} {7} {Aw} {8} {'} {Az} {Af} {Ao} {C} {Ae} {F} {Al}]
	[local89 26] = [{ag} {m} {aa} {k} {av} {5} {at} {r} {6} {:} {aj} {ak} {b} {ad} {aq} {7} {aw} {8} {'} {az} {af} {ao} {c} {ae} {f} {al}]
)

(procedure (proc56_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp5 198)
	(= temp6 166)
	(= temp1 (Str new: 400))
	(= temp2 (Str new: 25))
	(= temp3 (param1 size:))
	(for ((= temp4 0)) (<= temp4 temp3) ((++ temp4))
		(= temp0 (param1 at: temp4))
		(= temp7 0)
		(if (<= 65 temp0 90)
			(= temp7 1)
		)
		(cond
			((== temp0 101)
				(if (or (< (= temp0 (param1 at: (++ temp4))) 65) (> temp0 122))
					(temp2 copy: {au})
					(-- temp4)
				else
					(= temp0 (- (+ 101 temp0) temp5))
					(temp2 copy: [local89 temp0])
				)
			)
			((== temp0 69)
				(if (or (< (= temp0 (param1 at: (++ temp4))) 65) (> temp0 122))
					(temp2 copy: {Au})
					(-- temp4)
				else
					(= temp0 (- (+ 69 temp0) temp6))
					(temp2 copy: [local63 temp0])
				)
			)
			((<= 65 temp0 122)
				(if temp7
					(-= temp0 65)
					(temp2 copy: [local11 temp0])
				else
					(-= temp0 97)
					(temp2 copy: [local37 temp0])
				)
			)
			((<= 48 temp0 57)
				(-= temp0 48)
				(temp2 copy: [local1 temp0])
			)
			((== temp0 58)
				(temp2 copy: {-})
			)
			((== temp0 45)
				(temp2 copy: {:})
			)
			((== temp0 39)
				(temp2 copy: {4})
			)
			(else
				(temp2 copy: ((Str format: {%c} temp0) data:))
			)
		)
		(temp1 cat: (temp2 data:))
	)
	(param2 copy: (temp1 data:))
)

