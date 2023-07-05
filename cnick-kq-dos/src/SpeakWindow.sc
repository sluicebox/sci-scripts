;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Window)
(use User)
(use System)

(class SpeakWindow of SysWindow
	(properties
		sel_20 {SpeakWindow}
		sel_60 -1
		sel_428 0
		sel_429 0
		sel_430 0
		sel_431 0
		sel_432 0
		sel_433 0
		sel_434 0
	)

	(method (sel_174 param1 param2)
		(+= sel_187 param2)
		(+= sel_188 param1)
		(+= sel_189 param2)
		(+= sel_190 param1)
	)

	(method (sel_175 param1 param2)
		(self sel_174: (- param1 sel_188) (- param2 sel_187))
	)

	(method (sel_435 param1 param2)
		(+= sel_187 param2)
		(+= sel_188 param1)
		(-= sel_189 param2)
		(-= sel_190 param1)
	)

	(method (sel_183 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(SetPort 0)
		(= sel_60 15)
		(= sel_25 0)
		(= sel_26 (if global294 7 else 6))
		(if (not sel_430)
			(= sel_430 (User sel_309:))
		)
		(= temp6 (sel_430 sel_6:))
		(= temp5 (sel_430 sel_8:))
		(= temp8 (sel_430 sel_7:))
		(= temp7 (sel_430 sel_9:))
		(= temp1 (sel_430 sel_6:))
		(= temp2
			(/ (CelWide (sel_430 sel_2:) (sel_430 sel_3:) (sel_430 sel_4:)) 2)
		)
		(if (< (sel_430 sel_1:) 159)
			(= temp0 (+ (sel_430 sel_1:) temp2))
		else
			(= temp0 160)
		)
		(self sel_174: (- temp0 sel_188) (- temp1 (+ sel_189 14)))
		(self sel_435: -10 -10)
		(self
			sel_174:
				(if (< sel_188 0)
					(- 0 sel_188)
				else
					0
				)
				(if (< sel_187 0)
					(- 0 sel_187)
				else
					0
				)
		)
		(self
			sel_174:
				(if (>= sel_190 319)
					(- 319 sel_190)
				else
					0
				)
				0
		)
		(self
			sel_174:
				(if (< (+ sel_190 10) temp8)
					(- 319 sel_190)
				else
					0
				)
				0
		)
		(self
			sel_175:
				sel_188
				(if (> sel_189 temp1)
					(= temp4 1)
					(- (sel_430 sel_0:) temp1)
				else
					(= temp4 0)
					sel_187
				)
		)
		(if
			(and
				(> temp5 sel_187)
				(< temp6 sel_189)
				(< (- temp5 sel_187) (- 189 sel_189))
			)
			(self sel_174: 0 (- temp5 sel_187))
		)
		(= sel_16 sel_187)
		(= sel_17 sel_188)
		(= sel_18 sel_189)
		(= sel_19 sel_190)
		(= temp10 1)
		(if (!= sel_60 -1)
			(|= temp10 $0002)
		)
		(if temp4
			(= sel_431 (+ 1 (- sel_16 11)))
			(= temp3 3)
		else
			(= sel_431 (- sel_18 2))
			(= temp3 0)
		)
		(= sel_433 (+ sel_431 11))
		(cond
			((< (- sel_188 (/ (- sel_188 sel_190) 2)) (sel_430 sel_1:))
				(+= temp3 1)
			)
			((== (- sel_188 (/ (- sel_188 sel_190) 2)) (sel_430 sel_1:))
				(+= temp3 2)
			)
		)
		(cond
			((< (- sel_190 10) (sel_430 sel_1:))
				(= sel_434 (- sel_190 10))
				(= sel_432 (- sel_434 20))
			)
			((> (+ sel_188 10) (sel_430 sel_1:))
				(= sel_432 (+ sel_188 10))
				(= sel_434 (+ sel_432 20))
			)
			(else
				(= sel_432 (sel_430 sel_1:))
				(cond
					((or (== temp3 0) (== temp3 3))
						(+= sel_432 temp2)
					)
					((or (== temp3 1) (== temp3 4))
						(-= sel_432 (+ temp2 20))
					)
				)
				(= sel_434 (+ sel_432 20))
			)
		)
		(|= sel_31 $0080)
		(= sel_10 (Min sel_16 sel_431))
		(= sel_12 (Max sel_18 sel_433))
		(= sel_13 sel_19)
		(= sel_11 sel_17)
		(self sel_435: 10 10)
		(super sel_183:)
		(= temp9 (GetPort))
		(SetPort 0)
		(Graph
			grFILL_BOX
			(- sel_187 10)
			sel_188
			(+ sel_189 10)
			sel_190
			temp10
			sel_26
			sel_60
		)
		(Graph
			grFILL_BOX
			sel_187
			(- sel_188 10)
			sel_189
			(+ sel_190 10)
			temp10
			sel_26
			sel_60
		)
		(DrawCel 997 1 0 sel_17 sel_16 sel_60)
		(DrawCel 997 1 1 (- (- sel_19 1) 10) sel_16 sel_60)
		(DrawCel 997 1 2 sel_17 (- sel_18 10) sel_60)
		(DrawCel 997 1 3 (- sel_19 10) (- sel_18 10) sel_60)
		(Graph grDRAW_LINE sel_16 (+ sel_17 10) sel_16 (- sel_19 10) 7 -1 -1)
		(Graph grDRAW_LINE (+ sel_16 10) sel_17 (- sel_18 10) sel_17 7 -1 -1)
		(Graph
			grDRAW_LINE
			(+ sel_16 10)
			(- sel_19 1)
			(- sel_18 10)
			(- sel_19 1)
			(if global294 7 else 0)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ sel_16 10)
			(- sel_19 2)
			(- sel_18 10)
			(- sel_19 2)
			(if global294 7 else 5)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- sel_18 1)
			(+ sel_17 10)
			(- sel_18 1)
			(- sel_19 10)
			(if global294 0 else 0)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- sel_18 2)
			(+ sel_17 10)
			(- sel_18 2)
			(- sel_19 10)
			(if global294 8 else 4)
			-1
			-1
		)
		(DrawCel 997 0 temp3 sel_432 sel_431 sel_60)
		(Graph grUPDATE_BOX sel_16 sel_17 sel_18 sel_19 1)
		(SetPort temp9)
	)

	(method (sel_111)
		(super sel_111:)
	)
)

