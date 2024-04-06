;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use n007)
(use dominoes_opt)
(use Interface)
(use RandCycle)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	unknown_100_4 0
	proc100_1 1
	proc100_2 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	[local14 49]
	[local63 48] = [0 0 0 0 0 0 3 3 3 3 3 3 3 1 1 1 1 1 1 1 1 1 1 1 1 2 2 0 0 0 0 0 0 0 0 0 2 2 1 1 1 1 1 1 1 1 1 1]
	[local111 48] = [1 1 1 1 1 1 2 2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 3 3 1 1 1 1 1 1 1 1 1 3 3 0 0 0 0 0 0 0 0 0 0]
)

(procedure (proc100_1 &tmp temp0 temp1 temp2)
	(if global132
		(= temp0 (= temp1 -1))
		(if (= temp2 (global118 sel_626:))
			(= temp0 (temp2 sel_598:))
		)
		(if (= temp2 (global119 sel_626:))
			(= temp1 (temp2 sel_598:))
		)
		(= global145
			(= global111 (if (> temp0 temp1) global118 else global119))
		)
		(gUnknown_100_14 sel_110:)
		(global145 sel_617:)
	)
	(= local13 (gSystemWindow sel_26:))
	(gSystemWindow sel_26: 21)
	(if (== global111 global118)
		(Print (Format @global550 199 6 (global111 sel_510:)) 64 -1 17 111) ; "%s's play first."
	else
		(Print 100 0 64 -1 17 111) ; "Laura's play first."
	)
	(gSystemWindow sel_26: local13)
	(proc0_1)
)

(procedure (proc100_2 param1)
	(proc101_0 param1)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(localproc_3)
	(= temp3 (if (== global111 global118) global119 else global118))
	(= temp2 (+ (temp3 sel_86:) (Class_100_2 sel_86:)))
	(for ((= temp0 0)) (< temp0 49) ((++ temp0))
		(if [local14 temp0]
			(if (Class_100_2 sel_86:)
				(= [local14 temp0]
					(/
						(* (temp3 sel_86:) 100)
						(+ (Class_100_2 sel_86:) (temp3 sel_86:))
					)
				)
			else
				(= [local14 temp0] 100)
			)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(return (+ (localproc_6 param1) (localproc_6 param2)))
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(for ((= temp1 (= temp0 0))) (< temp1 (global111 sel_86:)) ((++ temp1))
		(if
			(and
				(!= (global111 sel_64: temp1) param2)
				(or
					(== ((global111 sel_64: temp1) sel_598:) param1)
					(== ((global111 sel_64: temp1) sel_599:) param1)
				)
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2)
	(= temp2 (if (== global111 global118) global119 else global118))
	(for ((= temp0 0)) (< temp0 49) ((++ temp0))
		(= [local14 temp0] 100)
	)
	(for ((= temp0 0)) (< temp0 (global111 sel_86:)) ((++ temp0))
		(localproc_5 (global111 sel_64: temp0) 0)
	)
	(for ((= temp0 0)) (< temp0 (unknown_100_10 sel_86:)) ((++ temp0))
		(for
			((= temp1 0))
			(< temp1 ((unknown_100_10 sel_64: temp0) sel_86:))
			((++ temp1))
			
			(localproc_5 ((unknown_100_10 sel_64: temp0) sel_64: temp1) 0)
		)
	)
	(localproc_4 (temp2 sel_622:) 0)
	(localproc_4 (temp2 sel_623:) 0)
	(localproc_4 (temp2 sel_624:) 0)
	(localproc_4 (temp2 sel_625:) 0)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0)
	(if (>= param1 0)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (!= param2 -1)
				(= [local14 (+ (* param1 7) temp0)] param2)
			)
			(if (>= argc 3)
				(+= [local14 (+ (* param1 7) temp0)] param3)
			)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (!= param2 -1)
				(= [local14 (+ (* temp0 7) param1)] param2)
			)
			(if (and (>= argc 3) (!= temp0 param1))
				(+= [local14 (+ (* param1 7) temp0)] param3)
			)
		)
	)
)

(procedure (localproc_5 param1 param2 &tmp temp0)
	(= [local14 (+ (* (param1 sel_598:) 7) (param1 sel_599:))] param2)
	(= [local14 (+ (* (param1 sel_599:) 7) (param1 sel_598:))] param2)
)

(procedure (localproc_6 param1 &tmp temp0 temp1 temp2)
	(for ((= temp1 (= temp2 0))) (< temp1 7) ((++ temp1))
		(if [local14 (+ (* param1 7) temp1)]
			(++ temp2)
		)
	)
	(return temp2)
)

(class Class_100_0 of Class_0_3
	(properties
		sel_2 100
		sel_598 0
		sel_599 0
		sel_600 0
		sel_601 0
		sel_602 2
		sel_603 0
		sel_604 0
		sel_605 0
		sel_606 0
		sel_607 0
		sel_608 0
	)

	(method (sel_611)
		(= sel_603 (self sel_612: unknown_100_8))
		(= sel_604 (self sel_612: unknown_100_9))
	)

	(method (sel_612 param1 &tmp temp0)
		(if (not (param1 sel_86:))
			(return 28)
		)
		(if (!= (self sel_598:) (param1 sel_482:))
			(if (!= (self sel_599:) (param1 sel_482:))
				(return 999)
			)
			(= temp0 (self sel_598:))
		else
			(= temp0 (self sel_599:))
		)
		(return
			(localproc_1
				(if (== param1 unknown_100_8)
					temp0
				else
					(unknown_100_8 sel_482:)
				)
				(if (== param1 unknown_100_9)
					temp0
				else
					(unknown_100_9 sel_482:)
				)
			)
		)
	)

	(method (sel_613)
		(= sel_605 (self sel_614: unknown_100_8))
		(= sel_606 (self sel_614: unknown_100_9))
	)

	(method (sel_614 param1 &tmp temp0)
		(if (not (param1 sel_86:))
			(return
				(if (!= sel_598 sel_599)
					(+ (localproc_2 sel_598 self) (localproc_2 sel_599 self))
				else
					(localproc_2 sel_598 self)
				)
			)
		)
		(if (!= sel_598 (param1 sel_482:))
			(if (!= sel_599 (param1 sel_482:))
				(return 0)
			)
			(= temp0 sel_598)
		else
			(= temp0 sel_599)
		)
		(return (localproc_2 temp0 self))
	)

	(method (sel_610)
		(self sel_165: sel_598 sel_4: sel_599)
	)

	(method (sel_609 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (not param2)
			(return 1)
		)
		(= temp2 (param2 sel_7:))
		(= temp3 (param2 sel_9:))
		(= temp0 (param2 sel_6:))
		(= temp1 (param2 sel_8:))
		(= temp4
			(+
				temp2
				(/ (CelWide (param2 sel_2:) (param2 sel_3:) (param2 sel_4:)) 2)
			)
		)
		(= temp5
			(+
				temp0
				(/ (CelHigh (param2 sel_2:) (param2 sel_3:) (param2 sel_4:)) 2)
			)
		)
		(return
			(or
				(and
					(<= temp0 sel_6)
					(>= temp1 sel_6)
					(<= temp2 sel_7)
					(>= temp3 sel_7)
				)
				(and
					(<= temp0 sel_6)
					(>= temp1 sel_6)
					(<= temp2 sel_9)
					(>= temp3 sel_9)
				)
				(and
					(<= temp0 sel_8)
					(>= temp1 sel_8)
					(<= temp2 sel_7)
					(>= temp3 sel_7)
				)
				(and
					(<= temp0 sel_8)
					(>= temp1 sel_8)
					(<= temp2 sel_9)
					(>= temp3 sel_9)
				)
				(and
					(>= temp0 sel_6)
					(<= temp1 sel_8)
					(or
						(and (<= temp2 sel_7) (>= temp3 sel_7))
						(and (<= temp2 sel_9) (>= temp3 sel_9))
						(and (>= temp2 sel_7) (<= temp3 sel_9))
					)
				)
				(and
					(>= temp2 sel_7)
					(<= temp3 sel_9)
					(or
						(and (<= temp0 sel_6) (>= temp1 sel_6))
						(and (<= temp0 sel_8) (>= temp1 sel_8))
						(and (>= temp0 sel_6) (<= temp1 sel_8))
					)
				)
				(and (<= sel_7 temp4 sel_9) (<= sel_6 temp5 sel_8))
			)
		)
	)

	(method (sel_304 param1)
		(return
			(and
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
				(not (& sel_14 $0080))
			)
		)
	)

	(method (sel_132 param1 &tmp temp0)
		(super sel_132: param1 &rest)
		(if
			(and
				(== (Class_100_2 sel_27:) 0)
				(not (Class_100_2 sel_122: self))
				(self sel_304: param1)
			)
			(= local11 self)
			(param1 sel_73: 1)
			(param1 sel_73:)
			(return)
		)
		(if
			(and
				(not (param1 sel_73:))
				(not (param1 sel_61:))
				(or (proc0_2 param1) (& (param1 sel_31:) $0001))
				(self sel_304: param1)
				(not (global111 sel_615:))
			)
			(param1 sel_73: 1)
			(if (not (unknown_100_7 sel_122: self))
				(= global110 self)
				(if
					(and
						(== (Class_100_2 sel_27:) 1)
						(< (unknown_100_2 sel_29:) 6)
					)
					(cond
						((& (param1 sel_31:) $0001)
							(if (global118 sel_122: self)
								(global118 sel_461:)
								(= temp0 (self sel_172:))
								(= global115 0)
								(gUnknown_0_18 sel_132: temp0)
								(if (not (temp0 sel_73:))
									(gSound sel_39: 904)
									(self
										sel_306: 30 30
										sel_296: MoveTo sel_600 sel_601 self
									)
								)
								(temp0 sel_111:)
							)
						)
						((proc0_2 param1)
							(global111 sel_199: self)
						)
					)
				)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_172 &tmp temp0 temp1 temp2 temp3 temp4)
		(= local1 0)
		(self sel_63: 15)
		(= gClass_100_0 self)
		(= sel_600 sel_1)
		(= sel_601 sel_0)
		(= temp0 (- sel_1 (gUnknown_0_17 sel_1:)))
		(= temp1 (- sel_0 (gUnknown_0_17 sel_0:)))
		(unknown_100_3 sel_118: self)
		(self sel_285:)
		(self sel_2: 102)
		(for ((= temp3 0)) (< temp3 (unknown_100_10 sel_86:)) ((++ temp3))
			((unknown_100_10 sel_64: temp3) sel_616: self)
		)
		(Animate (unknown_100_3 sel_24:) 0)
		(proc0_1)
		(while (!= 2 ((= temp2 (Event sel_109:)) sel_31:))
			(self
				sel_1: (+ (temp2 sel_1:) temp0)
				sel_0: (+ (temp2 sel_0:) temp1)
			)
			(Animate (unknown_100_3 sel_24:) 0)
			(temp2 sel_111:)
		)
		(self sel_2: 100)
		(self sel_283:)
		(unknown_100_3 sel_125:)
		(return temp2)
	)

	(method (sel_144)
		(gSound sel_39: 300)
		(if (== (Class_100_2 sel_27:) 0)
			(if (not global120)
				(= global145
					(= global111
						(if
							(==
								(if global111 global111 else global145)
								(unknown_100_5 sel_64: 0)
							)
							(unknown_100_5 sel_64: 1)
						else
							(unknown_100_5 sel_64: 0)
						)
					)
				)
				(global145 sel_617:)
			)
			(if (<= (Class_100_2 sel_86:) (- 28 (* (Class_100_2 sel_40:) 2)))
				((gCurRoom sel_141:) sel_144:)
			)
		)
		(= global120 0)
		(= gClass_100_0 0)
		(self sel_63: 1 sel_283:)
		(= global115 0)
	)
)

(class Class_100_1 of EventHandler
	(properties
		sel_20 -1
		sel_1 0
		sel_0 0
		sel_602 2
		sel_618 2
		sel_31 0
		sel_619 0
		sel_620 0
		sel_621 0
		sel_510 0
		sel_622 -1
		sel_623 -1
		sel_624 -1
		sel_625 -1
		sel_527 0
	)

	(method (sel_630 param1 &tmp temp0 temp1 temp2)
		(if (and argc param1)
			(= sel_622 (= sel_623 (= sel_624 (= sel_625 -1))))
			(return)
		)
		(for ((= temp0 0)) (< temp0 (unknown_100_10 sel_86:)) ((++ temp0))
			(if
				(and
					(!=
						(= temp2 ((unknown_100_10 sel_64: temp0) sel_482:))
						sel_622
					)
					(!= temp2 sel_623)
					(!= temp2 sel_624)
					(!= temp2 sel_625)
				)
				(cond
					((== sel_622 -1)
						(= sel_622 temp2)
					)
					((== sel_623 -1)
						(= sel_623 temp2)
					)
					((== sel_624 -1)
						(= sel_624 temp2)
					)
					((== sel_625 -1)
						(= sel_625 temp2)
					)
				)
			)
		)
	)

	(method (sel_617)
		(localproc_0)
		(self sel_119: 611)
		(self sel_119: 613)
	)

	(method (sel_199 param1)
		(if sel_621
			(sel_621 sel_284: sel_2: 100)
		)
		(if (!= param1 sel_621)
			(param1 sel_284: sel_2: 102)
			(= sel_621 param1)
		else
			(= sel_621 0)
		)
		(Animate (self sel_24:) 0)
	)

	(method (sel_461)
		(if sel_621
			(sel_621 sel_284: sel_2: 100)
			(= sel_621 0)
			(Animate (self sel_24:) 0)
		)
	)

	(method (sel_391 &tmp temp0 temp1)
		(= temp0 0)
		(if sel_86
			(for ((= temp1 0)) (< temp1 sel_86) ((++ temp1))
				(= temp0
					(+
						(+= temp0 ((self sel_64: temp1) sel_598:))
						((self sel_64: temp1) sel_599:)
					)
				)
			)
		)
		(return temp0)
	)

	(method (sel_132 param1)
		(if (== (Class_100_2 sel_27:) 0)
			(if (super sel_132: param1)
				(gSound sel_39: 905)
				(if (unknown_100_7 sel_122: local11)
					(gUnknown_0_2 sel_446: (Random 6 8) 0 445)
				else
					(gUnknown_0_2 sel_446: (Random 9 11) 0 445)
				)
			)
			(return)
		)
		(cond
			((== global111 self)
				(super sel_132: param1)
			)
			((super sel_132: param1)
				(gSound sel_39: 905)
				(gUnknown_0_2 sel_446: (Random 6 8) 0 445)
			)
		)
	)

	(method (sel_615 &tmp temp0)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			(if (not (& ((self sel_64: temp0) sel_14:) $0004))
				(return 1)
			)
		)
		(return 0)
	)

	(method (sel_144 &tmp temp0 temp1 temp2 temp3)
		(= global537 0)
		(if (>= (unknown_100_2 sel_29:) 2)
			(if (== (unknown_100_2 sel_29:) 2)
				(for
					((= temp0 0))
					(< temp0 (unknown_100_10 sel_86:))
					((++ temp0))
					
					((unknown_100_10 sel_64: temp0) sel_118: global110)
				)
				(= global120 0)
				((gCurRoom sel_141:) sel_144:)
			)
			(if (!= global111 global118)
				(if (== (global110 sel_598:) (global110 sel_599:))
					(= temp1 7)
				)
				(if (>= (global110 sel_598:) (global110 sel_599:))
					(= temp2 (global110 sel_598:))
					(= temp3 (global110 sel_599:))
				else
					(= temp2 (global110 sel_599:))
					(= temp3 (global110 sel_598:))
				)
				(global110 sel_165: (+ temp3 temp1) sel_4: temp2)
			)
			(global110 sel_2: 100 sel_287: sel_602: 2 sel_144:)
			(if (not (sel_620 sel_122: global110))
				(sel_620 sel_118: global110)
			)
			(if global111
				(global111 sel_81: global110)
			)
		)
		(= global110 0)
		(if (not global120)
			(= global145
				(= global111
					(if
						(==
							(if global111 global111 else global145)
							(unknown_100_5 sel_64: 0)
						)
						(unknown_100_5 sel_64: 1)
					else
						(unknown_100_5 sel_64: 0)
					)
				)
			)
			(gUnknown_100_14 sel_110:)
			(global145 sel_617:)
		else
			(= global120 0)
		)
		(= global115 0)
		(if (and (>= (unknown_100_2 sel_29:) 3) (not sel_86))
			(unknown_100_2 sel_144:)
		)
		(proc0_1)
		(proc0_3)
	)

	(method (sel_629 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (if (== sel_618 2) -13 else 13))
		(for ((= temp1 1)) (<= temp1 sel_86) ((++ temp1))
			(= global121
				(if (& temp1 $0001)
					sel_1
				else
					(+ sel_1 28)
				)
			)
			(= temp0 (/ (- temp1 1) 2))
			(= global122 (+ sel_0 (* temp0 temp3)))
			(for ((= temp2 0)) (< temp2 (- sel_86 1)) ((++ temp2))
				(if
					(and
						(== ((self sel_64: temp2) sel_1:) global121)
						(== ((self sel_64: temp2) sel_0:) global122)
					)
					(continue 2)
				)
			)
			(break)
		)
	)

	(method (sel_118 param1)
		(if (not argc)
			(super sel_118:)
			(return)
		)
		(super sel_118: param1)
		(self sel_629:)
		(param1
			sel_2: 100
			sel_4:
				(if (== sel_602 2)
					(param1 sel_599:)
				else
					0
				)
			sel_165:
				(if (== sel_602 2)
					(param1 sel_598:)
				else
					14
				)
			sel_602: sel_602
			sel_63: 15
			sel_306: 30 30
			sel_287:
			sel_296: MoveTo global121 global122 param1
			sel_110:
		)
		(if (and (== (Class_100_2 sel_27:) 1) (< (unknown_100_2 sel_29:) 6))
			(if (== (global111 sel_31:) 1)
				(if (== local2 4)
					(gUnknown_0_2 sel_445:)
				)
			else
				(if (== local2 2)
					(gUnknown_0_2 sel_443:)
				)
				(if (== local2 4)
					(gUnknown_0_2 sel_444:)
				)
			)
		)
	)

	(method (sel_610 &tmp temp0)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			(if (== ((self sel_64: temp0) sel_602:) 3)
				((self sel_64: temp0) sel_602: 2)
			else
				((self sel_64: temp0) sel_602: 3)
			)
			((self sel_64: temp0)
				sel_4:
					(if (== sel_602 2)
						((self sel_64: temp0) sel_599:)
					else
						0
					)
				sel_165:
					(if (== sel_602 2)
						((self sel_64: temp0) sel_598:)
					else
						14
					)
			)
		)
	)

	(method (sel_626 &tmp temp0 temp1)
		(= temp1 0)
		(if sel_86
			(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
				(if
					(and
						(==
							((self sel_64: temp0) sel_598:)
							((self sel_64: temp0) sel_599:)
						)
						(or
							(not temp1)
							(and
								temp1
								(>
									((self sel_64: temp0) sel_598:)
									(temp1 sel_598:)
								)
							)
						)
					)
					(= temp1 (self sel_64: temp0))
				)
			)
		)
		(return temp1)
	)

	(method (sel_628 param1 param2 &tmp temp0 temp1 temp2)
		(if (== argc 0)
			(if (and global134 global132)
				(= sel_619 ((= sel_620 (unknown_100_10 sel_64: 0)) sel_640:))
				(return (self sel_626:))
			)
			(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
				(for
					((= temp1 0))
					(< temp1 (unknown_100_10 sel_86:))
					((++ temp1))
					
					(if
						((unknown_100_10 sel_64: temp1)
							sel_628: (self sel_64: temp0)
						)
						(= sel_619
							((= sel_620 (unknown_100_10 sel_64: temp1))
								sel_640:
							)
						)
						(return (self sel_64: temp0))
					)
				)
			)
		else
			(= sel_620 param2)
			(= sel_619 (sel_620 sel_640:))
			(return (param2 sel_628: param1))
		)
		(return 0)
	)

	(method (sel_562 &tmp temp0 temp1)
		(switch sel_31
			(0
				(= temp0 0)
				(return)
			)
			(1
				(= temp0 (self sel_627:))
				(return)
			)
		)
	)

	(method (sel_627 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(proc0_4 981)
		(Wait 1)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(Wait 5)
		(proc0_6)
		(= temp3 (= temp4 0))
		(self sel_617:)
		(if (= temp2 (self sel_628:))
			(if (and global132 (not (unknown_100_8 sel_86:)))
				(return temp2)
			)
			(if (== (global111 sel_527:) 0)
				(return (self sel_631:))
			)
			(if (== (global111 sel_527:) 2)
				(if (and (not (Class_100_2 sel_86:)) (self sel_632:))
					(= sel_619 ((= sel_620 local4) sel_640:))
					(return local5)
				)
				(if (self sel_639:)
					(= sel_619 ((= sel_620 local4) sel_640:))
					(return local5)
				)
				(if (and (Class_100_2 sel_86:) (self sel_638:))
					(= sel_619 ((= sel_620 local4) sel_640:))
					(return local5)
				)
			)
			(= temp0 0)
			(= temp1 999)
			(while (< temp0 sel_86)
				(= temp6 ((self sel_64: temp0) sel_603:))
				(= temp7 ((self sel_64: temp0) sel_604:))
				(= temp8 ((self sel_64: temp0) sel_605:))
				(= temp9 ((self sel_64: temp0) sel_606:))
				(= temp5
					(+
						((self sel_64: temp0) sel_598:)
						((self sel_64: temp0) sel_599:)
					)
				)
				(if
					(or
						(< (- temp6 temp8) temp1)
						(and (== (- temp6 temp8) temp1) (> temp5 temp3))
					)
					(= temp4 temp5)
					(= temp1
						(-
							((self sel_64: temp0) sel_603:)
							((self sel_64: temp0) sel_605:)
						)
					)
					(= sel_619 ((= sel_620 unknown_100_8) sel_640:))
					(= temp2 (self sel_64: temp0))
				)
				(if
					(or
						(< (- temp7 temp9) temp1)
						(and (== (- temp7 temp9) temp1) (> temp5 temp4))
					)
					(= temp4 temp5)
					(= temp1
						(-
							((self sel_64: temp0) sel_604:)
							((self sel_64: temp0) sel_606:)
						)
					)
					(= sel_619 ((= sel_620 unknown_100_9) sel_640:))
					(= temp2 (self sel_64: temp0))
				)
				(++ temp0)
			)
			(return temp2)
		else
			(return 0)
		)
	)

	(method (sel_631 &tmp temp0 temp1)
		(= temp0 1)
		(while temp0
			(= temp1 (self sel_64: (Random 0 (- sel_86 1))))
			(switch (Random 0 1)
				(0
					(cond
						((unknown_100_8 sel_628: temp1)
							(global111
								sel_619: ((= sel_620 unknown_100_8) sel_640:)
							)
							(= temp0 0)
						)
						((unknown_100_9 sel_628: temp1)
							(global111
								sel_619: ((= sel_620 unknown_100_9) sel_640:)
							)
							(= temp0 0)
						)
					)
				)
				(1
					(cond
						((unknown_100_9 sel_628: temp1)
							(global111
								sel_619: ((= sel_620 unknown_100_9) sel_640:)
							)
							(= temp0 0)
						)
						((unknown_100_8 sel_628: temp1)
							(global111
								sel_619: ((= sel_620 unknown_100_8) sel_640:)
							)
							(= temp0 0)
						)
					)
				)
			)
		)
		(return temp1)
	)

	(method (sel_632 &tmp temp0 temp1)
		(unknown_100_7 sel_119: 608 0)
		(unknown_100_0
			sel_118: (unknown_100_8 sel_64: (- (unknown_100_8 sel_86:) 1))
		)
		(unknown_100_1
			sel_118: (unknown_100_9 sel_64: (- (unknown_100_9 sel_86:) 1))
		)
		(= local3 0)
		(= local5 0)
		(= local4 0)
		(= local6 0)
		(= local7 0)
		(= local10 0)
		(= local9 0)
		(= local8 0)
		((unknown_100_8 sel_64: (- (unknown_100_8 sel_86:) 1))
			sel_607: (unknown_100_8 sel_482:)
		)
		((unknown_100_9 sel_64: (- (unknown_100_9 sel_86:) 1))
			sel_607: (unknown_100_9 sel_482:)
		)
		(self sel_633:)
		(if (== local3 0)
			(= local6 -1)
			(for ((= temp1 0)) (< temp1 sel_86) ((++ temp1))
				(= temp0 (self sel_64: temp1))
				(if
					(and
						(or
							(unknown_100_8 sel_628: temp0)
							(unknown_100_9 sel_628: temp0)
						)
						(< local6 (+ (temp0 sel_598:) (temp0 sel_599:)))
					)
					(= local6 (+ (temp0 sel_598:) (temp0 sel_599:)))
					(= local5 temp0)
					(= local4
						(if (unknown_100_8 sel_628: temp0)
							unknown_100_8
						else
							unknown_100_9
						)
					)
				)
			)
		)
		(if (== local4 unknown_100_0)
			(= local4 unknown_100_8)
		)
		(if (== local4 unknown_100_1)
			(= local4 unknown_100_9)
		)
		(unknown_100_0 sel_125:)
		(unknown_100_1 sel_125:)
		(= local12 0)
		(return local5)
	)

	(method (sel_633 &tmp temp0 temp1 temp2)
		(proc0_6)
		(if (self sel_635:)
			(for ((= temp0 0)) (< temp0 (unknown_100_7 sel_86:)) ((++ temp0))
				(= temp2 (unknown_100_7 sel_64: temp0))
				(if (not (temp2 sel_608:))
					(= temp1 unknown_100_0)
					(while (!= temp1 0)
						(if (self sel_634: temp2 temp1)
							(temp2 sel_607: (self sel_637: temp2 temp1))
							(temp1 sel_118: temp2)
							(if (not (self sel_636:))
								(if (== (++ local7) 1)
									(= local8 temp1)
									(= local9 temp2)
									(if (== (temp2 sel_598:) (temp2 sel_599:))
										(= local4 local8)
										(= local5 local9)
										(temp1 sel_81: temp2)
										(= local3 99)
										(return)
									)
								)
								(if (and (not local12) (> local7 4))
									(= local12 983)
								)
								(if
									(>
										(+=
											local10
											(+
												(temp2 sel_598:)
												(temp2 sel_599:)
											)
										)
										local6
									)
									(= local6 local10)
									(= local3 local7)
									(= local4 local8)
									(= local5 local9)
								)
								(temp2 sel_608: 1)
								(if local12
									(if (> (++ local12) 990)
										(= local12 983)
									)
									(if (not (HaveMouse))
										(gGame sel_191: local12 1 305 185)
									else
										(gGame sel_191: local12 1)
									)
								)
								(if (< local7 5)
									(self sel_633:)
								)
								(-- local7)
								(-=
									local10
									(+ (temp2 sel_598:) (temp2 sel_599:))
								)
							)
							(temp1 sel_81: temp2)
							(temp2 sel_608: 0)
						)
						(if (== temp1 unknown_100_1)
							(= temp1 0)
						)
						(if (== temp1 unknown_100_0)
							(= temp1 unknown_100_1)
						)
					)
				)
			)
		)
	)

	(method (sel_634 param1 param2)
		(return
			(or
				(==
					(param1 sel_598:)
					((param2 sel_64: (- (param2 sel_86:) 1)) sel_607:)
				)
				(==
					(param1 sel_599:)
					((param2 sel_64: (- (param2 sel_86:) 1)) sel_607:)
				)
			)
		)
	)

	(method (sel_635 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (unknown_100_7 sel_86:)) ((++ temp0))
			(if (not ((unknown_100_7 sel_64: temp0) sel_608:))
				(= temp1 (unknown_100_7 sel_64: temp0))
				(if
					(or
						(==
							(temp1 sel_598:)
							((unknown_100_0
									sel_64: (- (unknown_100_0 sel_86:) 1)
								)
								sel_607:
							)
						)
						(==
							(temp1 sel_598:)
							((unknown_100_1
									sel_64: (- (unknown_100_1 sel_86:) 1)
								)
								sel_607:
							)
						)
						(==
							(temp1 sel_599:)
							((unknown_100_0
									sel_64: (- (unknown_100_0 sel_86:) 1)
								)
								sel_607:
							)
						)
						(==
							(temp1 sel_599:)
							((unknown_100_1
									sel_64: (- (unknown_100_1 sel_86:) 1)
								)
								sel_607:
							)
						)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sel_636 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (unknown_100_6 sel_86:)) ((++ temp0))
			(= temp1 (unknown_100_6 sel_64: temp0))
			(if
				(or
					(==
						(temp1 sel_598:)
						((unknown_100_0 sel_64: (- (unknown_100_0 sel_86:) 1))
							sel_607:
						)
					)
					(==
						(temp1 sel_598:)
						((unknown_100_1 sel_64: (- (unknown_100_1 sel_86:) 1))
							sel_607:
						)
					)
					(==
						(temp1 sel_599:)
						((unknown_100_0 sel_64: (- (unknown_100_0 sel_86:) 1))
							sel_607:
						)
					)
					(==
						(temp1 sel_599:)
						((unknown_100_1 sel_64: (- (unknown_100_1 sel_86:) 1))
							sel_607:
						)
					)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (sel_637 param1 param2 param3)
		(cond
			((and argc param3)
				(if (== (param1 sel_598:) (param2 sel_482:))
					(param1 sel_599:)
					(return)
				else
					(param1 sel_598:)
					(return)
				)
			)
			(
				(==
					(param1 sel_598:)
					((param2 sel_64: (- (param2 sel_86:) 1)) sel_607:)
				)
				(param1 sel_599:)
				(return)
			)
			(else
				(param1 sel_598:)
				(return)
			)
		)
	)

	(method (sel_638 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (< (+ (unknown_100_8 sel_86:) (unknown_100_9 sel_86:)) 6)
			(return 0)
		)
		(= local4 0)
		(= local5 0)
		(= local6 -1)
		(for ((= temp2 0)) (< temp2 (unknown_100_7 sel_86:)) ((++ temp2))
			(= temp0 (unknown_100_7 sel_64: temp2))
			(= temp1 unknown_100_8)
			(while (!= temp1 0)
				(if (temp1 sel_628: temp0)
					(= temp3 (self sel_637: temp0 temp1 1))
					(temp0 sel_608: 1)
					(= temp4 1)
					(for
						((= temp7 0))
						(< temp7 (unknown_100_6 sel_86:))
						((++ temp7))
						
						(if
							(or
								(==
									((unknown_100_6 sel_64: temp7) sel_598:)
									temp3
								)
								(==
									((unknown_100_6 sel_64: temp7) sel_599:)
									temp3
								)
							)
							(= temp4 0)
						)
					)
					(for
						((= temp7 0))
						(< temp7 (Class_100_2 sel_86:))
						((++ temp7))
						
						(if
							(or
								(==
									((Class_100_2 sel_64: temp7) sel_598:)
									temp3
								)
								(==
									((Class_100_2 sel_64: temp7) sel_599:)
									temp3
								)
							)
							(= temp4 0)
						)
					)
					(if temp4
						(= temp5 0)
						(= temp6 0)
						(for
							((= temp7 0))
							(< temp7 (unknown_100_7 sel_86:))
							((++ temp7))
							
							(if
								(and
									(not
										((unknown_100_7 sel_64: temp7) sel_608:)
									)
									(or
										(==
											((unknown_100_7 sel_64: temp7)
												sel_598:
											)
											temp3
										)
										(==
											((unknown_100_7 sel_64: temp7)
												sel_599:
											)
											temp3
										)
									)
								)
								(++ temp5)
								(if
									(==
										((unknown_100_7 sel_64: temp7) sel_598:)
										((unknown_100_7 sel_64: temp7) sel_599:)
									)
									(= temp6 1)
								)
							)
						)
						(if
							(and
								(or (>= temp5 2) (and temp5 (not temp6)))
								(> (+ (temp0 sel_598:) (temp0 sel_599:)) local6)
							)
							(= local6 (+ (temp0 sel_598:) (temp0 sel_599:)))
							(= local5 temp0)
							(= local4 temp1)
						)
					)
					(temp0 sel_608: 0)
				)
				(if (== temp1 unknown_100_9)
					(= temp1 0)
				)
				(if (== temp1 unknown_100_8)
					(= temp1 unknown_100_9)
				)
			)
		)
		(return local5)
	)

	(method (sel_639 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (< (+ (unknown_100_8 sel_86:) (unknown_100_9 sel_86:)) 6)
			(return 0)
		)
		(= local4 0)
		(= local5 0)
		(= local6 10)
		(for ((= temp5 0)) (< temp5 (unknown_100_7 sel_86:)) ((++ temp5))
			(= temp0 (unknown_100_7 sel_64: temp5))
			(= temp1 unknown_100_8)
			(while (!= temp1 0)
				(if (temp1 sel_628: temp0)
					(= temp2 (self sel_637: temp0 temp1 1))
					(= temp6
						(if (== temp1 unknown_100_8)
							(unknown_100_9 sel_482:)
						else
							(unknown_100_8 sel_482:)
						)
					)
					(= temp9 1)
					(if (== (temp0 sel_598:) (temp0 sel_599:))
						(++ temp9)
					)
					(= temp11
						(if (== temp1 unknown_100_8)
							unknown_100_9
						else
							unknown_100_8
						)
					)
					(if
						(and
							(!= (temp0 sel_598:) (temp0 sel_599:))
							(== (temp1 sel_482:) (temp11 sel_482:))
						)
						(++ temp9)
					)
					(if (== temp2 temp6)
						(*= temp9 2)
					)
					(for
						((= temp4 0))
						(< temp4 (unknown_100_8 sel_86:))
						((++ temp4))
						
						(if (== ((unknown_100_8 sel_64: temp4) sel_598:) temp2)
							(++ temp9)
						)
						(if (== ((unknown_100_8 sel_64: temp4) sel_599:) temp2)
							(++ temp9)
						)
						(if (== ((unknown_100_8 sel_64: temp4) sel_598:) temp6)
							(++ temp9)
						)
						(if (== ((unknown_100_8 sel_64: temp4) sel_599:) temp6)
							(++ temp9)
						)
					)
					(for
						((= temp4 1))
						(< temp4 (unknown_100_9 sel_86:))
						((++ temp4))
						
						(if (== ((unknown_100_9 sel_64: temp4) sel_598:) temp2)
							(++ temp9)
						)
						(if (== ((unknown_100_9 sel_64: temp4) sel_599:) temp2)
							(++ temp9)
						)
						(if (== ((unknown_100_9 sel_64: temp4) sel_598:) temp6)
							(++ temp9)
						)
						(if (== ((unknown_100_9 sel_64: temp4) sel_599:) temp6)
							(++ temp9)
						)
					)
					(if (== temp9 16)
						(= temp8 0)
						(for
							((= temp10 0))
							(< temp10 (unknown_100_6 sel_86:))
							((++ temp10))
							
							(= temp8
								(+
									(+=
										temp8
										((unknown_100_6 sel_64: temp10)
											sel_598:
										)
									)
									((unknown_100_6 sel_64: temp10) sel_599:)
								)
							)
						)
						(for
							((= temp10 0))
							(< temp10 (Class_100_2 sel_86:))
							((++ temp10))
							
							(= temp8
								(+
									(+=
										temp8
										((Class_100_2 sel_64: temp10) sel_598:)
									)
									((Class_100_2 sel_64: temp10) sel_599:)
								)
							)
						)
						(= temp7 0)
						(for
							((= temp10 0))
							(< temp10 (unknown_100_7 sel_86:))
							((++ temp10))
							
							(= temp7
								(+
									(+=
										temp7
										((unknown_100_7 sel_64: temp10)
											sel_598:
										)
									)
									((unknown_100_7 sel_64: temp10) sel_599:)
								)
							)
						)
						(if
							(and
								(<
									(= temp7
										(-
											(-= temp7 (temp0 sel_598:))
											(temp0 sel_599:)
										)
									)
									temp8
								)
								(> (- temp8 temp7) local6)
							)
							(= local6 (- temp8 temp7))
							(= local5 temp0)
							(= local4 temp1)
						)
					)
				)
				(if (== temp1 unknown_100_9)
					(= temp1 0)
				)
				(if (== temp1 unknown_100_8)
					(= temp1 unknown_100_9)
				)
			)
		)
		(return local5)
	)
)

(instance unknown_100_0 of List
	(properties
		sel_20 -1
	)
)

(instance unknown_100_1 of List
	(properties
		sel_20 -1
	)
)

(class Class_100_2 of EventHandler
	(properties
		sel_20 -1
		sel_187 60
		sel_188 70
		sel_189 140
		sel_190 250
		sel_25 12
		sel_60 14
		sel_5 0
		sel_27 1
		sel_641 0
		sel_642 0
		sel_40 7
		sel_643 0
	)

	(method (sel_110 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(for ((= temp1 temp0)) (< temp1 7) ((++ temp1))
				(self
					sel_118:
						((Class_100_0 sel_109:)
							sel_598: temp0
							sel_599: temp1
							sel_602: 3
							sel_300: -1
							sel_53: 1
							sel_117:
						)
				)
			)
		)
	)

	(method (sel_646 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			(if
				(==
					((self sel_64: temp0) sel_598:)
					((self sel_64: temp0) sel_599:)
				)
				(= temp1 (param1 sel_598:))
				(= temp2 (param1 sel_599:))
				(param1
					sel_598: ((self sel_64: temp0) sel_598:)
					sel_599: ((self sel_64: temp0) sel_599:)
				)
				((self sel_64: temp0) sel_598: temp1 sel_599: temp2)
				(return)
			)
		)
	)

	(method (sel_644 &tmp temp0 temp1)
		(for ((= temp0 200)) (>= temp0 0) ((-- temp0))
			(self sel_81: (= temp1 (self sel_64: (Random 0 (- sel_86 1)))))
			(self sel_118: temp1)
		)
	)

	(method (sel_645 &tmp temp0)
		(= temp0 0)
		(if (> sel_86 sel_642)
			(= temp0 (self sel_64: (Random 0 (- sel_86 1))))
			(self sel_81: temp0)
		)
		(unknown_100_13
			sel_4:
				(if (> sel_86 14)
					(- sel_86 15)
				else
					sel_86
				)
			sel_165: (if (> sel_86 14) 8 else 3)
			sel_284:
		)
		(if (<= sel_86 sel_642)
			(unknown_100_13 sel_102:)
			(sel_641 sel_165: 5)
		)
		(return temp0)
	)

	(method (sel_132 param1 &tmp temp0 temp1)
		(if (not (param1 sel_73:))
			(cond
				((== sel_27 0)
					(super sel_132: param1)
					(if (and (param1 sel_73:) (not (global111 sel_615:)))
						(if
							(and
								(== (param1 sel_31:) 1)
								(== global111 global118)
							)
							(global110 sel_285:)
							(global110 sel_4: 1)
							((= temp1 (List sel_109:)) sel_118: global110)
							(Animate (temp1 sel_24:) 0)
							(while (!= 2 ((= temp0 (Event sel_109:)) sel_31:))
								(global110
									sel_4:
										(if (global110 sel_304: temp0) 1 else 0)
								)
								(Animate (temp1 sel_24:) 0)
								(temp0 sel_111:)
							)
							(temp1 sel_81: global110)
							(temp1 sel_111:)
							(temp0 sel_111:)
							(if (== (global110 sel_4:) 1)
								(global110 sel_4: 0)
								(self sel_81: global110)
								(global110 sel_438:)
								(if
									(and
										(<= sel_86 (- 28 (* sel_40 2)))
										global132
										(not (global118 sel_626:))
										(not (global119 sel_626:))
										(!=
											(global110 sel_598:)
											(global110 sel_599:)
										)
									)
									(self sel_646: global110)
								)
								(global111 sel_118: global110)
							)
						else
							(self sel_81: global110)
							(global110 sel_438:)
							(global111 sel_118: global110)
						)
					)
				)
				(
					(and
						sel_641
						(sel_641 sel_132: param1)
						(not (global111 sel_615:))
					)
					(proc0_1)
					(cond
						((and (global111 sel_628:) global130)
							(if (> sel_86 sel_642)
								(Print 199 0) ; "You cannot draw another Domino since you have a valid play."
							else
								(Print 199 1) ; "You cannot pass since you have a valid play."
							)
						)
						((= global110 (self sel_645:))
							(if (> (++ local2) 1)
								(global111 sel_630: 1)
							)
							(global111 sel_630:)
							(global110
								sel_282:
									(+ (unknown_100_12 sel_1:) 10)
									(+ (unknown_100_12 sel_0:) 10)
								sel_63: 1
								sel_198:
							)
							(global111 sel_118: global110)
							(if (== global111 global118)
								(global110 sel_437:)
							)
							(= global120 1)
						)
						(else
							(global111 sel_630:)
							(= local13 (gSystemWindow sel_26:))
							(gSystemWindow sel_26: 21)
							(Print 199 3 3 22 3) ; "PASS"
							(gSystemWindow sel_26: local13)
							(= global145 (= global111 global119))
							(gUnknown_100_14 sel_110:)
							(global145 sel_617:)
							(if (== (++ global127) 2)
								(= global145 global111)
								(global145 sel_617:)
								(= global111 0)
								((gCurRoom sel_141:) sel_144:)
							)
						)
					)
				)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_198 &tmp temp0 temp1 temp2)
		(for ((= temp0 (= sel_27 0))) (< temp0 7) ((++ temp0))
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(= temp2 (self sel_64: (+ (* temp0 4) temp1)))
				(temp2
					sel_4: 0
					sel_165: 15
					sel_282: (+ 100 (* temp0 17)) (+ 50 (* temp1 25))
					sel_63: (temp2 sel_60:)
					sel_287:
					sel_110:
					sel_283:
				)
			)
		)
		(self sel_119: 198)
	)
)

(instance unknown_100_2 of Script
	(properties
		sel_20 -1
	)

	(method (sel_143 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(= global117 0)
				(= global133 -1)
				(= global139 (= global140 (= global141 0)))
				(= global129 0)
				(unknown_100_5 sel_118: unknown_100_6 unknown_100_7)
				(unknown_100_10 sel_118: unknown_100_8 unknown_100_9)
				(unknown_100_10 sel_119: 110)
				(= global118 (unknown_100_5 sel_64: 0))
				(= global119 (unknown_100_5 sel_64: 1))
				(= global123 (= global124 0))
				(global118 sel_510: @global150)
				(global119 sel_510: @global157)
				(Class_100_2 sel_641: unknown_100_12 sel_110:)
				(= global145 (= global111 (unknown_100_5 sel_64: (Random 0 1))))
				(if (== global111 global118)
					(= global128 0)
				else
					(= global128 3)
				)
				(= sel_135 1)
			)
			(1
				(++ global129)
				(= global117 0)
				(if global135
					(Class_100_2 sel_40: global135)
					(= global135 0)
				)
				(Class_100_2 sel_27: 0 sel_644: sel_198: sel_119: 437)
				(= global126 (= global125 0))
				(= local13 (gSystemWindow sel_26:))
				(gSystemWindow sel_26: 21)
				(Print
					(Format @global550 199 4 (Class_100_2 sel_40:)) ; "Select %d Dominoes each"
					27
					1
					64
					-1
					17
					111
				)
				(User sel_319: 1)
				(gSystemWindow sel_26: local13)
				(= local0 (= global127 0))
			)
			(2
				(= global110 0)
				(= global134 1)
				(Class_100_2 sel_27: 1)
				(Class_100_2 sel_119: 102 sel_119: 438)
				(unknown_100_12 sel_110: sel_437:)
				(unknown_100_13
					sel_4:
						(if (> (Class_100_2 sel_86:) 14)
							(- (Class_100_2 sel_86:) 15)
						else
							(Class_100_2 sel_86:)
						)
					sel_165: (if (> (Class_100_2 sel_86:) 14) 8 else 3)
					sel_110:
				)
				(global118 sel_119: 437)
				(if gModelessDialog
					(gModelessDialog sel_111:)
				)
				(for
					((= temp0 0))
					(< temp0 (unknown_100_10 sel_86:))
					((++ temp0))
					
					(gUnknown_0_18 sel_118: (unknown_100_10 sel_64: temp0))
					(((unknown_100_10 sel_64: temp0) sel_640:)
						sel_2: 103
						sel_165: 4
						sel_4: 0
						sel_287:
						sel_282: 147 94
						sel_198:
						sel_437:
					)
				)
				(global118 sel_630: 1)
				(global119 sel_630: 1)
				(= local2 0)
				(proc100_1)
				(if (and (== global111 global119) (== global119 unknown_100_7))
					(Wait 1)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
				)
				(gUnknown_100_14 sel_110:)
			)
			(3
				(if gModelessDialog
					(gModelessDialog sel_111:)
				)
			)
			(4
				(gUnknown_100_14 sel_102:)
				(= global117 1)
				(proc0_1)
				(for
					((= temp0 0))
					(< temp0 (unknown_100_10 sel_86:))
					((++ temp0))
					
					(((unknown_100_10 sel_64: temp0) sel_640:)
						sel_102:
						sel_438:
					)
				)
				(global118 sel_119: 438)
				(= global145 global111)
				(= global111 0)
				(if (global119 sel_86:)
					(global119 sel_119: 610)
				)
				(= global137
					(cond
						((not (global118 sel_86:)) 0)
						((not (global119 sel_86:)) 1)
						(else -1)
					)
				)
				(unknown_100_11 sel_110: global137)
				(+= global126 (global118 sel_391:))
				(if (>= (+= global125 (global119 sel_391:)) global126)
					(-= global125 global126)
					(= global126 0)
				else
					(-= global126 global125)
					(= global125 0)
				)
				(+= global123 global125)
				(+= global124 global126)
				(proc0_1)
				(= global133 (if global125 global125 else global126))
				(proc0_3)
				(proc100_2 1)
				(= global133 -1)
				(self sel_144:)
			)
			(5
				(if
					(and
						(or (>= global123 global148) (>= global124 global148))
						(!= global123 global124)
					)
					(proc0_3)
					(= global539
						(if (> global123 global124)
							(global118 sel_510:)
						else
							(global119 sel_510:)
						)
					)
					(gSong sel_165: -1 sel_39: 906)
					(= local13 (gSystemWindow sel_26:))
					(gSystemWindow sel_26: 21)
					(Print
						(Format ; "%s WON THE GAME  FINAL SCORE: %s: %d, %s: %d"
							@global550
							199
							5
							global539
							(global118 sel_510:)
							global123
							(global119 sel_510:)
							global124
						)
						27
						1
					)
					(gSystemWindow sel_26: local13)
					(gSong sel_162:)
					(if (> global123 global124)
						(gUnknown_0_2 sel_446: (Random 27 29))
					else
						(gUnknown_0_2 sel_446: (Random 30 32))
					)
					(= global123
						(= global124
							(= global129
								(= global139 (= global140 (= global141 0)))
							)
						)
					)
				)
				(self sel_144:)
			)
			(6
				(unknown_100_13 sel_102:)
				((Class_100_2 sel_641:) sel_165: 6)
				(= global145 (= global111 global118))
				(if (not global129)
					((Class_100_2 sel_641:) sel_102:)
					(self sel_144:)
				)
			)
			(7
				(unknown_100_11 sel_102:)
				(proc0_1)
				(for
					((= temp0 0))
					(< temp0 (unknown_100_10 sel_86:))
					((++ temp0))
					
					(if ((unknown_100_10 sel_64: temp0) sel_86:)
						(for
							((= temp1 0))
							(< temp1 ((unknown_100_10 sel_64: temp0) sel_86:))
							((++ temp1))
							
							(Class_100_2
								sel_118:
									(((unknown_100_10 sel_64: temp0)
											sel_64: temp1
										)
										sel_102:
										sel_2: 100
										sel_287:
										sel_602: 3
										sel_117:
									)
							)
						)
						((unknown_100_10 sel_64: temp0) sel_125:)
					)
				)
				(if (global118 sel_86:)
					(for
						((= temp0 0))
						(< temp0 (global118 sel_86:))
						((++ temp0))
						
						(Class_100_2
							sel_118:
								((global118 sel_64: temp0)
									sel_102:
									sel_2: 100
									sel_287:
									sel_602: 3
									sel_117:
								)
						)
					)
					(global118 sel_125:)
				)
				(if (global119 sel_86:)
					(for
						((= temp0 0))
						(< temp0 (global119 sel_86:))
						((++ temp0))
						
						(Class_100_2
							sel_118:
								((global119 sel_64: temp0)
									sel_102:
									sel_2: 100
									sel_287:
									sel_602: 3
									sel_117:
								)
						)
					)
					(global119 sel_125:)
				)
				(gUnknown_0_18 sel_125:)
				(proc0_1)
				(= global120 0)
				(= sel_29 0)
				(if (== global128 0)
					(= global128 3)
					(= global145 (= global111 global119))
				else
					(= global145 (= global111 global118))
					(= global128 0)
				)
				(self sel_144:)
			)
		)
	)

	(method (sel_57 &tmp [temp0 2])
		(super sel_57: &rest)
		(if
			(and
				(or (== sel_29 3) (== sel_29 2))
				(== global111 global119)
				(not (global111 sel_615:))
			)
			(cond
				((= global110 (global111 sel_562:))
					(gSound sel_39: 100)
					(global110
						sel_63: 9
						sel_296:
							JumpTo
							((global111 sel_619:) sel_1:)
							((global111 sel_619:) sel_0:)
							global111
					)
					(global111 sel_81: global110)
					(= global145 global111)
					(= global111 0)
				)
				((> (Class_100_2 sel_86:) (Class_100_2 sel_642:))
					(if (> (++ local2) 1)
						(global111 sel_630: 1)
					)
					(global111 sel_630:)
					(= global120 1)
					(proc0_6)
					(unknown_100_12 sel_436:)
					(= global110 (Class_100_2 sel_645:))
					(global110
						sel_165: 14
						sel_282:
							(+ (unknown_100_12 sel_1:) 10)
							(+ (unknown_100_12 sel_0:) 10)
						sel_63: 1
						sel_198:
					)
					(global111 sel_118: global110)
					(if (== global111 global118)
						(global110 sel_437:)
					)
				)
				(else
					(Wait 1)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(Wait 5)
					(proc0_6)
					(unknown_100_12 sel_436:)
					(global111 sel_630:)
					(proc0_3)
					(gUnknown_0_2 sel_446: (Random 0 2))
					(= global145 (= global111 global118))
					(gUnknown_100_14 sel_110:)
					(global145 sel_617:)
					(if (== (++ global127) 2)
						(= global145 global111)
						(global145 sel_617:)
						(= global111 0)
						((gCurRoom sel_141:) sel_144:)
					)
				)
			)
		)
	)
)

(instance unknown_100_3 of List
	(properties
		sel_20 -1
	)
)

(instance unknown_100_4 of Rm
	(properties
		sel_20 -1
		sel_368 100
		sel_28 10
	)

	(method (sel_110)
		(Load rsVIEW 100)
		(Load rsVIEW 103)
		(Load rsVIEW 102)
		(Load rsVIEW 110)
		(Load rsVIEW 983)
		(Load rsVIEW 984)
		(Load rsVIEW 985)
		(Load rsVIEW 986)
		(Load rsVIEW 987)
		(Load rsVIEW 988)
		(Load rsVIEW 989)
		(Load rsVIEW 990)
		(Load rsVIEW 997)
		Jump
		RandCycle
		(ScriptID 110) ; unknown_110_0
		(Load rsVIEW 980)
		(gUnknown_0_2 sel_282: 289 29 sel_198: sel_110:)
		(Load rsTEXT (+ (* (+ (gUnknown_0_2 sel_2:) 1) 1000) global187))
		(Class_0_5 sel_110:)
		(super sel_110:)
		(gSong sel_162:)
		((= gDominoes_opt (ScriptID 101 1)) sel_57: 2) ; dominoes_opt
		(proc0_1)
		(Class_100_2 sel_118:)
		(unknown_100_5 sel_118:)
		(unknown_100_10 sel_118:)
		(unknown_100_8 sel_118:)
		(unknown_100_9 sel_118:)
		(unknown_100_3 sel_118:)
		(unknown_100_6 sel_118: sel_527: global190 sel_510: @global150)
		(unknown_100_7 sel_118: sel_527: global191 sel_510: @global157)
		(self sel_145: unknown_100_2)
		(= gUnknown_100_11 unknown_100_11)
		(= gUnknown_100_14 unknown_100_14)
		(proc0_3)
	)

	(method (sel_57 &tmp temp0 temp1)
		(if
			(and
				(== (Class_100_2 sel_27:) 0)
				(== global111 global119)
				(or
					(and
						(== global128 0)
						(< (global119 sel_86:) (global118 sel_86:))
					)
					(and
						(== global128 3)
						(== (global119 sel_86:) (global118 sel_86:))
					)
				)
			)
			(= temp1
				(Class_100_2 sel_64: (Random 0 (- (Class_100_2 sel_86:) 1)))
			)
			((User sel_317:)
				sel_1: (temp1 sel_1:)
				sel_0: (temp1 sel_0:)
				sel_31: 1
				sel_73: 0
			)
			(Class_100_2 sel_132: (User sel_317:))
		)
		(super sel_57:)
	)

	(method (sel_132 param1)
		(super sel_132: param1)
		(if (== global111 global118)
			(Class_100_2 sel_132: param1)
		)
		(unknown_100_5 sel_132: param1)
		(if (or (proc0_2 param1) (& (param1 sel_31:) $0001))
			(unknown_100_10 sel_119: 132 param1)
		)
	)

	(method (sel_111)
		(DisposeScript 110)
		(DisposeScript 991)
		(DisposeScript 101)
		(DisposeScript 941)
		(DisposeScript 9)
		(unknown_100_0 sel_125: sel_111:)
		(unknown_100_1 sel_125: sel_111:)
		(unknown_100_3 sel_125: sel_111:)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		((Class_7_0 sel_414:) sel_125:)
		(unknown_100_5 sel_125: sel_111:)
		(gUnknown_0_18 sel_125:)
		(unknown_100_10 sel_111:)
		(unknown_100_6 sel_125: sel_111:)
		(unknown_100_7 sel_125: sel_111:)
		(Class_100_2 sel_125: sel_111:)
		(unknown_100_11 sel_111:)
		(unknown_100_13 sel_111:)
		(unknown_100_12 sel_111:)
		(super sel_111:)
	)
)

(instance unknown_100_5 of EventHandler
	(properties
		sel_20 -1
	)
)

(class Class_100_3 of EventHandler
	(properties
		sel_20 -1
		sel_482 0
		sel_647 0
		sel_648 0
		sel_649 2
		sel_650 0
		sel_651 0
		sel_652 0
		sel_187 0
		sel_188 0
		sel_189 0
		sel_190 0
		sel_640 0
	)

	(method (sel_110)
		(= sel_640
			((Class_100_0 sel_109:)
				sel_2: 103
				sel_165: 4
				sel_4: 0
				sel_63: 1
				sel_300: -1
				sel_287:
				sel_282: 500 500
				sel_110:
				sel_283:
				sel_117:
			)
		)
	)

	(method (sel_132 param1 &tmp temp0)
		(if (not (param1 sel_73:))
			(cond
				(
					(and
						global110
						(& (param1 sel_31:) $0002)
						(sel_640 sel_609: param1 global110)
					)
					(cond
						((self sel_628: global110)
							(param1 sel_73: 1)
							(global111 sel_620: self)
							(global111 sel_144:)
						)
						((and global132 (not sel_86))
							(if (not local1)
								(Print 199 7) ; "You must play your highest doublet."
								(= local1 1)
							else
								(= local1 0)
							)
						)
						((not local1)
							(gSound sel_39: 905)
							(gUnknown_0_2 sel_446: (Random 24 26) 0 445)
							(= local1 1)
						)
						(else
							(= local1 0)
						)
					)
				)
				((and (& (param1 sel_31:) $0001) (sel_640 sel_304: param1))
					(param1 sel_73: 1)
					(gSound sel_39: 905)
					(gUnknown_0_2 sel_446: (Random 12 14) 0 443)
				)
				(
					(and
						(proc0_2 param1)
						(== global111 global118)
						(sel_640 sel_304: param1)
					)
					(param1 sel_73: 1)
					(cond
						((global111 sel_628: (global111 sel_621:) self)
							(if (global111 sel_621:)
								(= global537 1)
								(gSound sel_39: 100)
								((global111 sel_621:)
									sel_296:
										MoveTo
										((global111 sel_619:) sel_1:)
										((global111 sel_619:) sel_0:)
										global111
								)
								(global111 sel_81: global110)
								(= global145 global111)
								(global111 sel_621: 0)
								(= global111 0)
							)
						)
						((global111 sel_621:)
							(if (and global132 (not sel_86))
								(Print 199 7) ; "You must play your highest doublet."
							else
								(gSound sel_39: 905)
								(gUnknown_0_2 sel_446: (Random 24 26) 0 445)
							)
						)
						(else
							(gSound sel_39: 905)
							(gUnknown_0_2 sel_446: (Random 12 14) 0 443)
						)
					)
				)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_118 param1 &tmp temp0)
		(if (not argc)
			(super sel_118:)
			(return)
		)
		(gSound2 sel_39: 300)
		(= local2 0)
		(= global127 0)
		(= global134 0)
		(param1 sel_438:)
		(if sel_86
			(self sel_57: param1)
			(if (== (param1 sel_598:) (param1 sel_599:))
				(++ sel_647)
				(++ sel_648)
				(self sel_653: param1)
			else
				(= sel_649 0)
				(+= sel_648 2)
			)
		else
			(= sel_649 (= sel_648 (= sel_647 0)))
			(cond
				((== (param1 sel_598:) (param1 sel_599:))
					(= sel_647 1)
					(= sel_482 (param1 sel_598:))
					(= sel_649 2)
				)
				((== self (unknown_100_10 sel_64: 0))
					(= sel_482
						(if (> (param1 sel_598:) (param1 sel_599:))
							(param1 sel_598:)
						else
							(param1 sel_599:)
						)
					)
				)
				(else
					(= sel_482
						(if (> (param1 sel_598:) (param1 sel_599:))
							(param1 sel_599:)
						else
							(param1 sel_598:)
						)
					)
				)
			)
			(global110
				sel_2: 100
				sel_287:
				sel_165:
					(if sel_647
						(+ sel_482 7)
					else
						(global110 sel_3:)
					)
				sel_282: (if sel_647 153 else 147) (if sel_647 89 else 94)
			)
		)
		(super sel_118: param1)
		(self sel_616:)
	)

	(method (sel_616)
		(if sel_86
			(sel_640 sel_598: sel_482 sel_599: (+ sel_482 1))
			(if (== (+ sel_482 1) 7)
				(sel_640 sel_599: 0)
			)
			(self sel_57: sel_640)
			(sel_640 sel_198:)
		)
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp13 (if (== (param1 sel_598:) (param1 sel_599:)) 1 else 0))
		(= temp0 (self sel_64: (- sel_86 1)))
		(= temp1 (CelWide (temp0 sel_2:) (temp0 sel_3:) (temp0 sel_4:)))
		(= temp2 (CelHigh (temp0 sel_2:) (temp0 sel_3:) (temp0 sel_4:)))
		(= temp11 (= temp9 (temp0 sel_1:)))
		(= temp12 (= temp10 (temp0 sel_0:)))
		(= temp3 0)
		(if (== sel_86 1)
			(if (== self unknown_100_8)
				(= sel_650 0)
			else
				(= sel_650 1)
			)
		)
		(switch sel_651
			(0
				(if temp13
					(= temp11 (- temp9 14))
					(= temp12 (- temp10 5))
					(= temp3 1)
					(= temp5 2)
					(if (== sel_650 3)
						(+= temp12 10)
					)
				else
					(switch sel_652
						(0
							(= temp5 1)
							(= temp11 (- temp9 26))
							(switch sel_650
								(0
									(if (== sel_649 2)
										(= temp12 (+ temp10 5))
									)
								)
								(3
									(if (not sel_649)
										(= temp12 (+ temp10 10))
									)
								)
							)
						)
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp11 (- temp9 14))
							(= temp12
								(if sel_649
									(- temp10 5)
								else
									(- temp10 10)
								)
							)
						)
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp11 (- temp9 14))
							(if sel_649
								(= temp12 (+ temp10 5))
							)
						)
					)
				)
			)
			(1
				(if temp13
					(= temp11 (+ temp9 temp1))
					(= temp12 (- temp10 5))
					(= temp3 1)
					(= temp5 2)
					(if (== sel_650 3)
						(+= temp12 10)
					)
				else
					(switch sel_652
						(1
							(= temp5 0)
							(= temp11 (+ temp9 temp1))
							(switch sel_650
								(1
									(if (== sel_649 2)
										(= temp12 (+ temp10 5))
									)
								)
								(3
									(if (not sel_649)
										(= temp12 (+ temp10 10))
									)
								)
							)
						)
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp11 (+ temp9 temp1))
							(= temp12
								(if sel_649
									(- temp10 5)
								else
									(- temp10 10)
								)
							)
						)
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp11 (+ temp9 temp1))
							(if sel_649
								(= temp12 (+ temp10 5))
							)
						)
					)
				)
			)
			(2
				(if temp13
					(= temp11 (- temp9 6))
					(= temp12 (- temp10 12))
					(= temp3 0)
					(= temp5 0)
					(if (== sel_650 1)
						(+= temp11 12)
					)
				else
					(switch sel_652
						(2
							(= temp5 3)
							(= temp3 1)
							(= temp12 (- temp10 22))
							(switch sel_650
								(2
									(if (== sel_649 1)
										(= temp11 (+ temp9 6))
									)
								)
								(1
									(if (not sel_649)
										(= temp11 (+ temp9 12))
									)
								)
							)
						)
						(0
							(= temp5 1)
							(= temp12 (- temp10 12))
							(= temp11
								(if sel_649
									(- temp9 6)
								else
									(- temp9 12)
								)
							)
						)
						(1
							(= temp5 0)
							(= temp12 (- temp10 12))
							(if sel_649
								(= temp11 (+ temp9 6))
							)
						)
					)
				)
			)
			(3
				(if temp13
					(= temp11 (- temp9 6))
					(= temp12 (+ temp10 temp2))
					(= temp3 0)
					(= temp5 0)
					(if (== sel_650 1)
						(+= temp11 12)
					)
				else
					(switch sel_652
						(3
							(= temp5 2)
							(= temp3 1)
							(= temp12 (+ temp10 temp2))
							(switch sel_650
								(3
									(if (== sel_649 1)
										(= temp11 (+ temp9 6))
									)
								)
								(1
									(if (not sel_649)
										(= temp11 (+ temp9 12))
									)
								)
							)
						)
						(0
							(= temp5 1)
							(= temp12 (+ temp10 temp2))
							(= temp11
								(if sel_649
									(- temp9 6)
								else
									(- temp9 12)
								)
							)
						)
						(1
							(= temp5 0)
							(= temp12 (+ temp10 temp2))
							(if sel_649
								(= temp11 (+ temp9 6))
							)
						)
					)
				)
			)
		)
		(param1 sel_1: temp11 sel_0: temp12)
		(= temp4 (if (== temp3 0) 0 else 7))
		(= temp8
			(if (== sel_482 (param1 sel_598:))
				(param1 sel_599:)
			else
				(param1 sel_598:)
			)
		)
		(switch temp5
			(0
				(= temp6 sel_482)
				(= temp7 temp8)
			)
			(1
				(= temp7 sel_482)
				(= temp6 temp8)
			)
			(2
				(= temp6 sel_482)
				(= temp7 temp8)
			)
			(3
				(= temp7 sel_482)
				(= temp6 temp8)
			)
		)
		(+= temp7 temp4)
		(param1 sel_3: temp7 sel_4: temp6)
		(if (!= param1 sel_640)
			(= sel_482 temp8)
		else
			(sel_640 sel_165: 4 sel_4: (if temp4 1 else 0) sel_198: sel_283:)
		)
	)

	(method (sel_653))

	(method (sel_628 param1 &tmp temp0)
		(= temp0 0)
		(if param1
			(cond
				((not sel_86)
					(if global132
						(if (== (global111 sel_626:) param1)
							(= temp0 1)
						)
					else
						(= temp0 1)
					)
				)
				(
					(or
						(== (param1 sel_598:) sel_482)
						(== (param1 sel_599:) sel_482)
					)
					(= temp0 1)
				)
			)
		)
		(return temp0)
	)
)

(instance unknown_100_6 of Class_100_1
	(properties
		sel_1 3
		sel_0 170
	)
)

(instance unknown_100_7 of Class_100_1
	(properties
		sel_1 263
		sel_0 60
		sel_602 3
		sel_618 3
		sel_31 1
	)
)

(instance unknown_100_8 of Class_100_3
	(properties)

	(method (sel_653)
		(= sel_649
			(if (or (== [local63 sel_648] 0) (== [local63 sel_648] 1)) 2 else 1)
		)
	)

	(method (sel_57 param1)
		(= sel_650 [local63 (- sel_648 1)])
		(= sel_651 [local63 sel_648])
		(= sel_652 [local63 (+ sel_648 1)])
		(super sel_57: param1)
	)
)

(instance unknown_100_9 of Class_100_3
	(properties)

	(method (sel_653)
		(= sel_649
			(if (or (== [local111 sel_648] 0) (== [local111 sel_648] 1))
				2
			else
				1
			)
		)
	)

	(method (sel_57 param1)
		(= sel_650 [local111 (- sel_648 1)])
		(= sel_651 [local111 sel_648])
		(= sel_652 [local111 (+ sel_648 1)])
		(super sel_57: param1)
	)
)

(instance unknown_100_10 of EventHandler
	(properties
		sel_20 -1
	)
)

(instance unknown_100_11 of Class_0_2
	(properties)

	(method (sel_110 param1 &tmp temp0 temp1 temp2 temp3)
		(if (and (Class_100_2 sel_643:) (Class_100_2 sel_86:))
			(self
				sel_2: 103
				sel_287:
				sel_165: 7
				sel_4: (if (== param1 -1) 1 else 0)
				sel_282:
					(if (or (== param1 0) (== param1 -1)) 3 else 261)
					(cond
						((== param1 -1) 3)
						((== param1 0) 26)
						(else 60)
					)
				sel_63: 1
				sel_283:
				sel_63: 5
				sel_198:
			)
			(super sel_110: &rest)
			(for ((= temp0 0)) (< temp0 (Class_100_2 sel_86:)) ((++ temp0))
				(= temp1 (Class_100_2 sel_64: temp0))
				(= temp2
					(if (& temp0 $0001)
						(+ sel_1 29)
					else
						(+ sel_1 2)
					)
				)
				(= temp3 (+ (* (/ temp0 2) 11) 14 sel_0))
				(temp1
					sel_2: 100
					sel_287:
					sel_282: temp2 temp3
					sel_63: 7
					sel_198:
				)
				(if (> (temp1 sel_598:) (temp1 sel_599:))
					(temp1 sel_165: (temp1 sel_599:) sel_4: (temp1 sel_598:))
				else
					(temp1 sel_165: (temp1 sel_598:) sel_4: (temp1 sel_599:))
				)
			)
		)
	)

	(method (sel_102)
		(super sel_102:)
		(Class_100_2 sel_119: 102)
	)
)

(instance unknown_100_12 of Class_0_6
	(properties)

	(method (sel_110)
		(self
			sel_2: 103
			sel_287:
			sel_165: 2
			sel_4: 0
			sel_282: 257 178
			sel_63: 10
			sel_450: unknown_100_13
			sel_198:
		)
		(super sel_110: &rest)
	)

	(method (sel_132 param1)
		(if
			(and
				(not global537)
				(not (global111 sel_615:))
				(super sel_132: param1)
			)
			(param1 sel_73: 1)
			(gSound sel_39: 101)
			(global111 sel_461:)
			(if (== (unknown_100_2 sel_29:) 6)
				(self sel_282: 500 500 sel_283:)
				(unknown_100_2 sel_144:)
				(param1 sel_73: 0)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_436)
		(super sel_436:)
		(gSound sel_39: 101)
	)
)

(instance unknown_100_13 of Class_0_2
	(properties
		sel_2 103
		sel_3 3
		sel_4 14
		sel_60 11
	)

	(method (sel_110)
		(self
			sel_165: sel_3
			sel_287:
			sel_282:
				(+ (unknown_100_12 sel_1:) 4)
				(+ (unknown_100_12 sel_0:) 11)
			sel_63: sel_60
			sel_198:
		)
		(super sel_110: &rest)
	)
)

(instance unknown_100_14 of Actor
	(properties
		sel_20 -1
		sel_1 31
		sel_0 15
		sel_2 850
		sel_4 1
	)

	(method (sel_110)
		(self
			sel_287:
			sel_283:
			sel_165: (if (== global111 unknown_100_6) 2 else 0)
			sel_198:
		)
		(super sel_110: &rest)
	)
)

