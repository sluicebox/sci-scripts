;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 858)
(include sci.sh)
(use Main)
(use Table)
(use Feature)
(use Actor)
(use System)

(local
	local0
)

(procedure (localproc_0 &tmp [temp0 200]) ; UNUSED
	(if local0
		(Format @temp0 &rest)
		(proc13_1 @temp0)
	)
)

(class MList of List
	(properties
		sel_20 {MList}
	)

	(method (sel_611 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (FirstNode sel_24))
		(= temp3 0)
		(= temp4 -32768)
		(while temp0
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return temp3)
			)
			(if (> (= temp5 (temp2 sel_96: param1 &rest)) temp4)
				(= temp3 temp2)
				(= temp4 temp5)
			)
			(= temp0 temp1)
		)
		(return temp3)
	)
)

(class Fighter of Actor
	(properties
		sel_20 {Fighter}
		sel_612 0
		sel_613 0
		sel_139 0
		sel_140 0
		sel_614 0
		sel_615 0
		sel_616 0
		sel_617 0
		sel_618 0
		sel_619 0
		sel_620 0
	)

	(method (sel_628 param1 &tmp temp0)
		(if argc
			(= temp0 sel_142)
			(if (IsObject sel_618)
				(sel_618 sel_111:)
			)
			(if (= sel_618 param1)
				(sel_618 sel_110: self &rest)
			)
			(= sel_142 temp0)
		)
		(return sel_618)
	)

	(method (sel_629 param1 &tmp temp0)
		(if argc
			(= temp0 sel_142)
			(if (IsObject sel_619)
				(sel_619 sel_111:)
			)
			(if (= sel_619 param1)
				(sel_619 sel_110: self &rest)
			)
			(= sel_142 temp0)
		)
		(return sel_619)
	)

	(method (sel_57)
		(super sel_57: &rest)
		(if sel_139
			(if (<= (-= sel_139 (Abs (- gGameTime sel_140))) 0)
				(= sel_139 0)
				(= sel_140 gGameTime)
			)
			(return)
		)
		(if sel_615
			(-- sel_615)
		)
		(if sel_619
			(sel_619 sel_57: &rest)
		else
			(++ sel_614)
		)
		(if sel_618
			(sel_618 sel_57: &rest)
		)
	)

	(method (sel_133 param1)
		(if (<= sel_620 0)
			(return 0)
		)
		(if (super sel_133: param1 &rest)
			(return 1)
		)
		(if sel_615
			(return 0)
		)
		(if sel_617
			(sel_617 sel_120: 133 param1 self)
		)
		(return (and sel_618 (sel_618 sel_133: param1 self)))
	)

	(method (sel_292 param1)
		(if sel_612
			(return 1)
		else
			(super sel_292: param1 &rest)
		)
	)

	(method (sel_111)
		(if sel_616
			(sel_616 sel_111:)
			(= sel_616 0)
		)
		(if sel_617
			(sel_617 sel_111:)
			(= sel_617 0)
		)
		(if sel_618
			(sel_618 sel_111:)
			(= sel_618 0)
		)
		(super sel_111: &rest)
	)

	(method (sel_626 param1)
		(sel_613 sel_623: param1)
	)

	(method (sel_627 param1 &tmp temp0 temp1 temp2 temp3)
		(if (== self ((param1 sel_630:) sel_42:))
			(return 0)
		)
		(if (= temp1 (sel_613 sel_629:))
			(or (temp1 sel_232:) (= temp1 0))
		)
		(= temp2 (Random 0 100))
		(= temp3 (sel_612 sel_631: param1 temp1))
		(return
			(cond
				((= temp0 (<= temp2 temp3))
					(sel_613 sel_624: param1)
					1
				)
				((and temp1 (== (temp1 sel_630:) (param1 sel_630:)))
					(= sel_615 (+ 96 (* 12 (param1 sel_632:))))
					0
				)
				(else 0)
			)
		)
	)

	(method (sel_621)
		(if argc
			(= sel_616 (or sel_616 (MList sel_109:)))
			(sel_616 sel_118: &rest sel_119: 42 self sel_119: 110)
		)
		(return sel_616)
	)

	(method (sel_622)
		(if argc
			(= sel_617 (or sel_617 (MList sel_109:)))
			(sel_617 sel_118: &rest sel_119: 42 self)
		)
		(return sel_617)
	)

	(method (sel_623 &tmp temp0)
		(if sel_618
			(= temp0 sel_142)
			(sel_618 sel_110: self)
			(= sel_142 temp0)
		)
	)

	(method (sel_624 param1 &tmp temp0 temp1 temp2)
		(if (= temp0 (sel_616 sel_120: 624 param1))
			(-= sel_620 (param1 sel_632:))
			(= temp1 (param1 sel_632:))
			(= temp2 sel_139)
			(= sel_139 (Max sel_615 sel_139 temp1))
			(self sel_625: param1 temp0)
		)
	)

	(method (sel_625))
)

(class Technique of Script
	(properties
		sel_20 {Technique}
		sel_232 0
		sel_21 0
		sel_633 0
		sel_2 0
		sel_3 0
		sel_620 0
		sel_634 0
		sel_630 0
		sel_73 0
		sel_37 0
		sel_31 0
		sel_635 100
	)

	(method (sel_243 param1)
		(if argc
			(= sel_630 param1)
		)
	)

	(method (sel_209)
		(sel_630 sel_209: &rest)
	)

	(method (sel_111 &tmp temp0 temp1)
		(= temp0 sel_42)
		(= temp1 (temp0 sel_142:))
		(sel_42 sel_619: 0 sel_614: 0)
		(super sel_111: &rest)
		(= sel_42 temp0)
		(sel_42 sel_142: temp1)
	)

	(method (sel_631 param1)
		(if argc
			(= sel_635 param1)
		)
		(return sel_635)
	)

	(method (sel_632 param1)
		(if argc
			(= sel_620 param1)
		)
		(return sel_620)
	)

	(method (sel_636 param1)
		(if argc
			(= sel_634 param1)
		)
		(return sel_634)
	)

	(method (sel_110 param1 &tmp temp0 temp1)
		(= sel_140 gGameTime)
		(= sel_232 0)
		(if (= temp0 (if argc param1 else sel_42))
			(= temp1 (temp0 sel_142:))
		)
		(super sel_110: temp0 &rest)
		(if temp0
			(temp0 sel_142: temp1)
		)
	)

	(method (sel_624 param1)
		(return
			(if (not (and sel_232 sel_630 (sel_630 sel_209: param1))) 0 else 1)
		)
	)

	(method (sel_133 param1)
		(return
			(cond
				((param1 sel_73:) 0)
				(
					(or
						(sel_42 sel_615:)
						(and (sel_42 sel_139:) (!= sel_42 (sel_630 sel_42:)))
					))
				(
					(or
						(and
							sel_21
							(& (param1 sel_31:) $0004)
							(== sel_21 (param1 sel_37:))
						)
						(and
							sel_633
							(& (param1 sel_31:) $0040)
							(== sel_633 (param1 sel_37:))
						)
						(and
							(& (param1 sel_31:) $0001)
							(sel_630 sel_209: param1)
						)
					)
					(if
						(and
							(not (sel_42 sel_142:))
							(!= (sel_42 sel_619:) self)
						)
						(sel_42 sel_629: self)
					)
					(param1 sel_73: 1)
					1
				)
			)
		)
	)
)

(class Part of Feature
	(properties
		sel_20 {Part}
		sel_42 0
		sel_620 0
	)

	(method (sel_209 param1)
		(return
			(if (and (IsObject param1) (param1 sel_116: 630))
				(== self (param1 sel_630:))
			else
				(super sel_209: param1 &rest)
			)
		)
	)

	(method (sel_624 param1)
		(return
			(if (self sel_209: param1)
				(-= sel_620 (param1 sel_632:))
				1
			)
		)
	)

	(method (sel_632 param1)
		(if argc
			(= sel_620 param1)
		)
		(return sel_620)
	)
)

(class Fight of Script
	(properties
		sel_20 {Fight}
		sel_637 0
		sel_638 0
		sel_639 0
	)

	(method (sel_110 param1 param2 param3 param4)
		(if (not sel_637)
			((= sel_637 param2) sel_612: self sel_613: param3)
		)
		(if (not sel_638)
			((= sel_638 param3) sel_612: self sel_613: param2)
		)
		(if argc
			(super sel_110: param1 &rest)
		)
		(sel_637 sel_110:)
		(sel_638 sel_110:)
		(if (not sel_639)
			((= sel_639 (Table sel_109:))
				sel_608: param4
				sel_609: ((sel_637 sel_622:) sel_86:)
				sel_610: ((sel_638 sel_622:) sel_86:)
			)
		)
	)

	(method (sel_111)
		(if sel_639
			(sel_639 sel_111:)
			(= sel_639 0)
		)
		(= sel_638 (= sel_637 0))
		(super sel_111: &rest)
	)

	(method (sel_631 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9 temp10)
		(= temp0
			(if (or (< argc 2) (not param2))
				(param1 sel_631:)
			else
				(= temp1 (sel_637 sel_622:))
				(= temp2 (sel_638 sel_622:))
				(if (== sel_637 (param1 sel_42:))
					(= temp3 param1)
					(= temp4 param2)
				else
					(= temp3 param2)
					(= temp4 param1)
				)
				(= temp9 (temp2 sel_132: temp4))
				(= temp10 (temp1 sel_132: temp3))
				(= temp8 (sel_639 sel_64: temp9 temp10))
				(/ (* (param1 sel_631:) (- 100 temp8)) 100)
			)
		)
	)
)

