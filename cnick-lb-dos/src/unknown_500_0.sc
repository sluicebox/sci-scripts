;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n007)
(use Interface)
(use RandCycle)
(use Path)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	unknown_500_0 0
	proc500_2 2
)

(local
	[local0 19] = [40 -2 38 -2 31 -2 28 -2 23 -2 18 -2 22 -2 10 -2 14 -2 -32768]
	[local19 15] = [8 -2 3 -2 4 -2 7 -2 8 -2 4 -2 5 0 -32768]
	[local34 4] = [54 13 60 42]
	[local38 4] = [9 12 13 4]
	[local42 5] = [121 150 180 210 240]
	local47
	[local48 2]
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
)

(procedure (proc500_2 &tmp [temp0 300] [temp300 100])
	(if (or (!= (gSong sel_40:) 804) (== (gSong sel_157:) -1))
		(gSong sel_39: 804 sel_165: -1)
	)
	(= local56 (gSystemWindow sel_25:))
	(= local57 (gSystemWindow sel_26:))
	(gSystemWindow sel_25: 16 sel_26: 21)
	(StrCpy @temp0 (Format @temp300 599 5)) ; "Yacht Scorecard"
	(StrCat @temp0 (Format @temp300 599 6)) ; "Current Total Score"
	(StrCat @temp0 (Format @temp300 599 7 local60)) ; "Players  Score After %d Game"
	(if (!= local60 1)
		(StrCat @temp0 (Format @temp300 599 8)) ; "s"
	)
	(StrCat @temp0 (Format @temp300 599 9)) ; "-------------------------------"
	(if (unknown_500_1 sel_31:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				10
				(unknown_500_1 sel_510:)
				(unknown_500_1 sel_669:)
				(unknown_500_1 sel_691:)
			)
		)
	)
	(if (unknown_500_2 sel_31:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				11
				(unknown_500_2 sel_510:)
				(unknown_500_2 sel_669:)
				(unknown_500_2 sel_691:)
			)
		)
	)
	(if (unknown_500_3 sel_31:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				12
				(unknown_500_3 sel_510:)
				(unknown_500_3 sel_669:)
				(unknown_500_3 sel_691:)
			)
		)
	)
	(if (unknown_500_4 sel_31:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				13
				(unknown_500_4 sel_510:)
				(unknown_500_4 sel_669:)
				(unknown_500_4 sel_691:)
			)
		)
	)
	(StrCat @temp0 (Format @temp300 599 14)) ; "-------------------------------"
	(if local59
		(StrCat @temp0 (Format @temp300 599 15 local58 (local59 sel_510:))) ; "High Game: %3d by %-10s"
	)
	(Print @temp0 30 500 67 188 27 0 182 gUnknown_0_25 64 50 -1)
	(gSystemWindow sel_25: local56 sel_26: local57)
	(gSong sel_162:)
)

(class Class_500_0 of Class_0_6
	(properties
		sel_1 37
		sel_2 503
		sel_655 0
		sel_656 -1
		sel_657 0
		sel_658 0
		sel_659 0
		sel_660 0
		sel_661 0
	)

	(method (sel_668)
		(unknown_500_17 sel_656: (global178 sel_669:))
		(if (!= (global186 sel_31:) 2)
			(proc0_3)
		)
		(unknown_500_17 sel_656: (global178 sel_669:))
		(global178 sel_670: (- (global178 sel_670:) 1))
		(unknown_500_21 sel_282: 500 500 sel_438:)
		(unknown_500_17 sel_666:)
		(global178 sel_671: 0)
		(unknown_500_14 sel_165: (if (== (unknown_500_19 sel_86:) 1) 7 else 6))
		(if
			(and
				(not (global178 sel_670:))
				(==
					global178
					(unknown_500_19 sel_64: (- (unknown_500_19 sel_86:) 1))
				)
			)
			(unknown_500_14 sel_165: 8)
			(unknown_500_10 sel_29: 7 sel_144:)
		)
	)

	(method (sel_132 param1 &tmp temp0)
		(if (super sel_132: param1)
			(param1 sel_73: 1)
			(gSound sel_39: 100 sel_165: 1)
			(if (< (unknown_500_14 sel_3:) 6)
				(if (== global178 global500)
					(cond
						((or local61 (== (global178 sel_671:) 3))
							(gSound2 sel_39: 907 sel_165: 1)
							(Class_0_5 sel_446: 599 0 -32768 445 -32768)
						)
						((!= ((global178 sel_64: (- sel_3 1)) sel_656:) -1)
							(gSound2 sel_39: 907 sel_165: 1)
							(Class_0_5 sel_446: (Random 9 11) -32768 443 -32768)
						)
						(else
							(= temp0 (global178 sel_671:))
							(if (and global519 (!= (global178 sel_671:) 2))
								(if (and global533 (!= global533 self))
									(gSound2 sel_39: 907 sel_165: 1)
									(Class_0_5
										sel_446: (Random 6 8) -32768 445 -32768
									)
									(return)
								else
									(= global533 self)
								)
							)
							(if
								(or
									(!= (unknown_500_20 sel_1:) sel_1)
									(!= (unknown_500_20 sel_0:) sel_0)
								)
								(= global533 self)
								(unknown_500_20 sel_282: sel_1 sel_0)
								(return)
							else
								(= global533 0)
								(unknown_500_20 sel_282: 500 500)
							)
							(self sel_283:)
							(proc0_1)
							((global178 sel_64: (- sel_3 1))
								sel_666:
									((global178 sel_64: (- sel_3 1)) sel_655:)
							)
							(Class_500_4 sel_119: 438)
							(self sel_668:)
							(if
								(and
									(== (global178 sel_31:) 1)
									(== temp0 2)
									(or (== sel_3 7) (== sel_3 8) (== sel_3 10))
									((global178 sel_64: (- sel_3 1)) sel_655:)
								)
								(gSound2 sel_39: 901 sel_165: 1)
								(Class_0_5 sel_446: (Random 33 35) 0 443 -32768)
							)
							(if (not ((global178 sel_64: (- sel_3 1)) sel_655:))
								(gSound2 sel_39: 905 sel_165: 1)
								(Class_0_5 sel_446: (Random 27 29) 0 444 -32768)
							)
						)
					)
				else
					(gSound2 sel_39: 907 sel_165: 1)
					(Class_0_5 sel_446: (Random 12 14) -32768 445 -32768)
				)
			else
				(gSound2 sel_39: 907 sel_165: 1)
				(Class_0_5 sel_446: (Random 15 17) -32768 445 -32768)
			)
		)
	)

	(method (sel_666 param1)
		(if argc
			((global500 sel_64: (- sel_3 1)) sel_656: param1)
			(= global533 0)
		)
		(if (>= ((global500 sel_64: (- sel_3 1)) sel_656:) 0)
			(Format @global550 599 1 ((global500 sel_64: (- sel_3 1)) sel_656:)) ; "%3d"
			(self sel_667:)
		)
	)

	(method (sel_667)
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			81
			(- sel_0 8)
			dsBACKGROUND
			(global500 sel_25:)
			dsCOLOR
			global375
		)
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			82
			(- sel_0 8)
			dsBACKGROUND
			global376
			dsCOLOR
			global377
		)
	)

	(method (sel_110)
		(self sel_165: sel_3 sel_4: 0 sel_63: 7 sel_282: sel_1 sel_0 sel_287:)
		(super sel_110: &rest)
	)

	(method (sel_662))

	(method (sel_663))

	(method (sel_664 &tmp temp0)
		(cond
			((== (global178 sel_671:) 0)
				((Class_500_4 sel_64: 0) sel_366: 1)
				((Class_500_4 sel_64: 1) sel_366: 1)
				((Class_500_4 sel_64: 2) sel_366: 1)
				((Class_500_4 sel_64: 3) sel_366: 1)
				((Class_500_4 sel_64: 4) sel_366: 1)
			)
			(sel_659
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(if (== ((Class_500_4 sel_64: temp0) sel_482:) sel_659)
						((Class_500_4 sel_64: temp0) sel_366: 1)
					else
						((Class_500_4 sel_64: temp0) sel_366: 0)
					)
				)
			)
			(else
				((Class_500_4 sel_64: 0) sel_366: (& sel_660 $0001))
				((Class_500_4 sel_64: 1) sel_366: (& sel_660 $0002))
				((Class_500_4 sel_64: 2) sel_366: (& sel_660 $0004))
				((Class_500_4 sel_64: 3) sel_366: (& sel_660 $0008))
				((Class_500_4 sel_64: 4) sel_366: (& sel_660 $0010))
			)
		)
	)

	(method (sel_665 param1 &tmp temp0)
		(for ((= temp0 (= sel_660 0))) (< temp0 argc) ((++ temp0))
			(switch [param1 temp0]
				(-1 0)
				(0
					(|= sel_660 $0001)
				)
				(1
					(|= sel_660 $0002)
				)
				(2
					(|= sel_660 $0004)
				)
				(3
					(|= sel_660 $0008)
				)
				(4
					(|= sel_660 $0010)
				)
			)
		)
	)
)

(class Class_500_1 of RelPath
	(properties
		sel_20 -1
	)

	(method (sel_64 param1)
		(return [local0 param1])
	)
)

(class Class_500_2 of RelPath
	(properties
		sel_20 -1
	)

	(method (sel_64 param1)
		(return [local19 param1])
	)
)

(class Class_500_3 of Class_0_7
	(properties
		sel_2 500
		sel_482 0
		sel_366 0
		sel_485 0
		sel_486 0
		sel_487 0
		sel_488 0
		sel_489 0
		sel_672 0
		sel_673 0
		sel_674 0
		sel_675 0
		sel_676 0
		sel_677 0
	)

	(method (sel_498)
		(if (not sel_366)
			(= sel_482 (Random 1 6))
			(self sel_678: sel_489: 1)
			(if (!= gHowFast 0)
				(self
					sel_282:
						(- 0 (Random sel_486 sel_488))
						(Random sel_485 sel_487)
					sel_287:
					sel_300:
					sel_53: 0
					sel_223: 0
					sel_306: 50 50
					sel_153: End
					sel_296: sel_672 self
					sel_63: 10
					sel_110:
				)
			else
				(self
					sel_2: sel_674
					sel_165: sel_675
					sel_282:
						(= sel_676 (+ (- 0 (Random sel_486 sel_488)) 270))
						(= sel_677 (- (Random sel_485 sel_487) 30))
					sel_198:
					sel_110:
					sel_4: 6
				)
				(if (== global507 global509)
					(unknown_500_12 sel_144:)
				)
			)
		)
	)

	(method (sel_494)
		(if (not sel_366)
			(self sel_2: 500 sel_282: 400 400)
		)
	)

	(method (sel_497)
		(= sel_366 0)
	)

	(method (sel_144)
		(switch (++ sel_489)
			(2
				(self
					sel_4: 0
					sel_165: sel_675
					sel_2: sel_674
					sel_153: End
					sel_296: sel_673 self
				)
			)
			(3
				(self sel_153: 0 sel_676: sel_1 sel_677: sel_0)
				(if (== global508 self)
					(unknown_500_12 sel_144:)
				)
			)
		)
	)

	(method (sel_678)
		(switch (Random 0 3)
			(0
				(= sel_672 Class_500_1)
				(= sel_673 Class_500_2)
				(= sel_674 501)
				(= sel_675 (- (* sel_482 2) 2))
				(self sel_165: 0 sel_4: 0)
				(= sel_452 501)
				(= sel_453 12)
				(= sel_454 (- sel_482 1))
			)
			(1
				(= sel_672 Class_500_1)
				(= sel_673 Class_500_2)
				(= sel_674 501)
				(= sel_675 (- (* sel_482 2) 1))
				(self sel_165: 1 sel_4: 0)
				(= sel_452 501)
				(= sel_453 13)
				(= sel_454 (- sel_482 1))
			)
			(2
				(= sel_672 Class_500_1)
				(= sel_673 Class_500_2)
				(= sel_674 501)
				(= sel_675 (- (* sel_482 2) 2))
				(self sel_165: 0 sel_4: 0)
				(= sel_452 501)
				(= sel_453 12)
				(= sel_454 (- sel_482 1))
			)
			(3
				(= sel_672 Class_500_1)
				(= sel_673 Class_500_2)
				(= sel_674 501)
				(= sel_675 (- (* sel_482 2) 1))
				(self sel_165: 1 sel_4: 0)
				(= sel_452 501)
				(= sel_453 13)
				(= sel_454 (- sel_482 1))
			)
		)
	)
)

(class Class_500_4 of List
	(properties
		sel_20 -1
		sel_679 0
	)

	(method (sel_685)
		(self
			sel_125:
			sel_118:
				unknown_500_5
				unknown_500_6
				unknown_500_7
				unknown_500_8
				unknown_500_9
		)
	)

	(method (sel_680)
		(= global501 ((self sel_64: 0) sel_482:))
		(= global502 ((self sel_64: 1) sel_482:))
		(= global503 ((self sel_64: 2) sel_482:))
		(= global504 ((self sel_64: 3) sel_482:))
		(= global505 ((self sel_64: 4) sel_482:))
	)

	(method (sel_681 &tmp temp0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(cond
				(
					(>
						((self sel_64: temp0) sel_482:)
						((self sel_64: (+ temp0 1)) sel_482:)
					)
					(self
						sel_130: (self sel_64: (+ temp0 1)) (self sel_64: temp0)
					)
					(self sel_81: (self sel_64: temp0))
					(= temp0 -1)
				)
				(
					(and
						(==
							((self sel_64: temp0) sel_482:)
							((self sel_64: (+ temp0 1)) sel_482:)
						)
						(Class_500_5 sel_86:)
						(not (Class_500_5 sel_122: (self sel_64: temp0)))
					)
					(self
						sel_130: (self sel_64: (+ temp0 1)) (self sel_64: temp0)
					)
					(self sel_81: (self sel_64: temp0))
				)
			)
		)
		(= global511 (self sel_683: 1))
		(= global512 (self sel_683: 2))
		(= global513 (self sel_683: 3))
		(= global514 (self sel_683: 4))
		(= global515 (self sel_683: 5))
		(= global516 (self sel_683: 6))
	)

	(method (sel_684 param1 param2 &tmp temp0)
		(= param1 0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (== ((self sel_64: temp0) sel_482:) param2)
				(+= param1 param2)
			)
		)
		(return param1)
	)

	(method (sel_682)
		(return (+ global501 global502 global503 global504 global505))
	)

	(method (sel_683 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (== ((self sel_64: temp0) sel_482:) param1)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class Class_500_5 of Set
	(properties
		sel_20 -1
		sel_6 170
		sel_7 50
		sel_8 199
		sel_9 300
		sel_686 190
	)

	(method (sel_687 param1 param2 &tmp temp0)
		(= temp0 (if (>= argc 2) param2 else unknown_500_13))
		(if (and sel_86 (self sel_122: param1))
			(self sel_81: param1)
		)
		(proc0_4)
		(= global518 param1)
		(param1
			sel_296: MoveTo (param1 sel_676:) (param1 sel_677:) temp0
			sel_306: 35 35
			sel_63: 14
		)
	)

	(method (sel_118 param1 param2 &tmp [temp0 2] temp2 temp3)
		(if argc
			(= temp3 (if (>= argc 2) param2 else unknown_500_13))
			(= temp2 (self sel_689:))
			(proc0_4)
			(= global518 param1)
			(param1
				sel_296: MoveTo temp2 sel_686 temp3
				sel_306: 35 35
				sel_63: 14
			)
			(super sel_118: param1)
		else
			(super sel_118:)
		)
	)

	(method (sel_689 param1 &tmp temp0 temp1)
		(= temp1 (if (not sel_86) [local42 0] else 0))
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if
				(and
					(or (not argc) (!= param1 [local42 temp0]))
					(self sel_688: [local42 temp0])
				)
				(= temp1 [local42 temp0])
				(break)
			)
		)
		(return temp1)
	)

	(method (sel_688 param1 &tmp temp0)
		(if sel_86
			(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
				(if (== ((self sel_64: temp0) sel_1:) param1)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (sel_132 param1)
		(if
			(and
				(not (param1 sel_73:))
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
			)
			(param1 sel_73: 1)
		)
		(param1 sel_73:)
	)

	(method (sel_437)
		((Class_7_0 sel_414:) sel_118: self)
	)

	(method (sel_438)
		((Class_7_0 sel_414:) sel_81: self)
	)
)

(class Class_500_6 of List
	(properties
		sel_20 -1
		sel_31 1
		sel_670 12
		sel_671 3
		sel_25 0
		sel_527 0
		sel_510 0
		sel_690 0
		sel_691 0
	)

	(method (sel_446)
		(if sel_690
			(sel_690 sel_446: &rest)
		)
	)

	(method (sel_497)
		(= sel_670 12)
		(= sel_671 3)
		(self sel_119: 656 -1)
	)

	(method (sel_669 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(if (> ((self sel_64: temp1) sel_656:) 0)
				(+= temp0 ((self sel_64: temp1) sel_656:))
			)
		)
		(return temp0)
	)

	(method (sel_695)
		(-- sel_671)
		(unknown_500_15 sel_4: sel_671 sel_284:)
	)

	(method (sel_110)
		(self
			sel_118:
				((gUnknown_501_0 sel_109:) sel_661: gUnknown_501_0 sel_117:)
				((gUnknown_501_1 sel_109:) sel_661: gUnknown_501_1 sel_117:)
				((gUnknown_501_2 sel_109:) sel_661: gUnknown_501_2 sel_117:)
				((gUnknown_501_3 sel_109:) sel_661: gUnknown_501_3 sel_117:)
				((gUnknown_501_4 sel_109:) sel_661: gUnknown_501_4 sel_117:)
				((gUnknown_501_5 sel_109:) sel_661: gUnknown_501_5 sel_117:)
				((gUnknown_501_6 sel_109:) sel_661: gUnknown_501_6 sel_117:)
				((gUnknown_501_7 sel_109:) sel_661: gUnknown_501_7 sel_117:)
				((gUnknown_501_8 sel_109:) sel_661: gUnknown_501_8 sel_117:)
				((gUnknown_501_9 sel_109:) sel_661: gUnknown_501_9 sel_117:)
				((gUnknown_501_10 sel_109:) sel_661: gUnknown_501_10 sel_117:)
				((gUnknown_501_11 sel_109:) sel_661: gUnknown_501_11 sel_117:)
		)
	)

	(method (sel_562)
		(switch (global178 sel_31:)
			(1
				(if global180
					(self sel_692:)
					(self sel_693:)
				)
			)
			(2
				(self sel_692:)
				(self sel_694:)
			)
		)
	)

	(method (sel_692 &tmp temp0 temp1)
		(global178 sel_119: 662)
		(global178 sel_119: 663)
		(if (or (not global519) (and global519 (== (global178 sel_671:) 2)))
			(= global534 0)
			(= temp1 -1)
			(for ((= temp0 0)) (<= temp0 11) ((++ temp0))
				(if
					(and
						(> ((global178 sel_64: temp0) sel_658:) temp1)
						(== ((global178 sel_64: temp0) sel_656:) -1)
					)
					(= temp1 ((global178 sel_64: temp0) sel_658:))
					(= global534 (global178 sel_64: temp0))
					(= global520 ((global178 sel_64: temp0) sel_661:))
				)
			)
		)
		(global534 sel_664:)
		(return global534)
	)

	(method (sel_693))

	(method (sel_694))

	(method (sel_696 &tmp temp0)
		(= temp0 sel_670)
		(if (> ((self sel_64: 11) sel_656:) -1)
			(-- temp0)
		)
		(if (> ((self sel_64: 10) sel_656:) -1)
			(-- temp0)
		)
		(return (< temp0 5))
	)

	(method (sel_132 param1 &tmp temp0 [temp1 2] temp3)
		(if
			(and
				(< (unknown_500_14 sel_3:) 6)
				(= temp0 (Class_500_4 sel_120: 132 param1))
			)
			(switch (temp0 sel_460: param1)
				(1
					(if gClass_0_7
						(= temp3 (Event sel_109:))
						(if (Class_500_5 sel_122: gClass_0_7)
							(proc0_4)
							(Class_500_5 sel_81: gClass_0_7)
							(gClass_0_7 sel_461:)
							(= global518 gClass_0_7)
							(gClass_0_7
								sel_296:
									MoveTo
									(gClass_0_7 sel_676:)
									(gClass_0_7 sel_677:)
									unknown_500_13
							)
							(gSound sel_39: 302)
						else
							(Class_500_5 sel_81: gClass_0_7 sel_118: gClass_0_7)
							(gClass_0_7 sel_461:)
							(gSound sel_39: 302)
						)
						(temp3 sel_111:)
						(= gClass_0_7 0)
					)
				)
				(2
					(if gClass_0_7
						(= temp3 (Event sel_109:))
						(if (Class_500_5 sel_122: gClass_0_7)
							(proc0_4)
							(Class_500_5 sel_81: gClass_0_7)
							(gClass_0_7 sel_461:)
							(= global518 gClass_0_7)
							(gClass_0_7
								sel_296:
									MoveTo
									(gClass_0_7 sel_676:)
									(gClass_0_7 sel_677:)
									unknown_500_13
							)
							(gSound sel_39: 302)
						else
							(Class_500_5 sel_81: gClass_0_7 sel_118: gClass_0_7)
							(gClass_0_7 sel_461: sel_285:)
							(gSound sel_39: 302)
						)
						(temp3 sel_111:)
						(= gClass_0_7 0)
					)
				)
			)
		)
	)
)

(instance unknown_500_0 of Rm
	(properties
		sel_20 -1
		sel_368 500
		sel_28 10
	)

	(method (sel_110 &tmp temp0 temp1 temp2)
		(= global510 0)
		(if (gUnknown_0_2 sel_441:)
			(gUnknown_0_2 sel_282: 286 33 sel_198: sel_110:)
			(Load rsTEXT (+ (* (+ (gUnknown_0_2 sel_2:) 1) 1000) global187))
		)
		(if (gUnknown_0_3 sel_441:)
			(gUnknown_0_3 sel_282: 286 99 sel_198: sel_110:)
			(Load rsTEXT (+ (* (+ (gUnknown_0_3 sel_2:) 1) 1000) global187))
		)
		(if (gUnknown_0_4 sel_441:)
			(gUnknown_0_4 sel_282: 286 165 sel_198: sel_110:)
			(Load rsTEXT (+ (* (+ (gUnknown_0_4 sel_2:) 1) 1000) global187))
		)
		(Load rsTEXT 19500)
		(Class_0_5 sel_110:)
		(super sel_110:)
		(gSong sel_162:)
		(Load rsVIEW 500)
		(Load rsVIEW 501)
		(Load rsVIEW 503)
		(Load rsVIEW 504)
		(Load rsVIEW 510)
		(Load rsFONT 500)
		(Load rsSOUND 500)
		(Load rsSOUND 501)
		(Load rsSOUND 502)
		(Load rsSOUND 503)
		(Load rsSOUND 504)
		(Load rsSOUND 505)
		(Load rsSOUND 907)
		(Load rsSOUND 100)
		(Load rsSOUND 901)
		(ScriptID 501) ; unknown_501_0
		(ScriptID 510) ; unknown_510_0
		Path
		RandCycle
		(Load rsTEXT 599)
		(Load rsFONT 999)
		(User sel_319: 1)
		((= gYacht_opt yacht_opt) sel_57:)
		(= gUnknown_501_0 (ScriptID 501 0)) ; unknown_501_0
		(= gUnknown_501_1 (ScriptID 501 1)) ; unknown_501_1
		(= gUnknown_501_2 (ScriptID 501 2)) ; unknown_501_2
		(= gUnknown_501_3 (ScriptID 501 3)) ; unknown_501_3
		(= gUnknown_501_4 (ScriptID 501 4)) ; unknown_501_4
		(= gUnknown_501_5 (ScriptID 501 5)) ; unknown_501_5
		(= gUnknown_501_6 (ScriptID 501 6)) ; unknown_501_6
		(= gUnknown_501_7 (ScriptID 501 7)) ; unknown_501_7
		(= gUnknown_501_8 (ScriptID 501 8)) ; unknown_501_8
		(= gUnknown_501_9 (ScriptID 501 9)) ; unknown_501_9
		(= gUnknown_501_10 (ScriptID 501 10)) ; unknown_501_10
		(= gUnknown_501_11 (ScriptID 501 11)) ; unknown_501_11
		(unknown_500_1
			sel_118:
			sel_527: global190
			sel_31: global194
			sel_510: @global150
		)
		(unknown_500_2
			sel_118:
			sel_527: global191
			sel_31: global195
			sel_510: @global157
		)
		(unknown_500_3
			sel_118:
			sel_527: global192
			sel_31: global196
			sel_510: @global164
		)
		(unknown_500_4
			sel_118:
			sel_527: global193
			sel_31: global197
			sel_510: @global171
		)
		(Class_500_5 sel_118:)
		(Class_500_4 sel_118:)
		(unknown_500_19 sel_118:)
		(= temp0 -1)
		(if (unknown_500_1 sel_31:)
			(++ temp0)
			(unknown_500_1
				sel_25: (if global294 [local38 temp0] else [local34 temp0])
				sel_110:
			)
		)
		(if (unknown_500_2 sel_31:)
			(++ temp0)
			(unknown_500_2
				sel_25: (if global294 [local38 temp0] else [local34 temp0])
				sel_110:
			)
		)
		(if (unknown_500_3 sel_31:)
			(++ temp0)
			(unknown_500_3
				sel_25: (if global294 [local38 temp0] else [local34 temp0])
				sel_110:
			)
		)
		(if (unknown_500_4 sel_31:)
			(++ temp0)
			(unknown_500_4
				sel_25: (if global294 [local38 temp0] else [local34 temp0])
				sel_110:
			)
		)
		(unknown_500_21 sel_1: 500)
		(unknown_500_18 sel_437: sel_110: sel_283:)
		(gUnknown_501_0 sel_437: sel_110: sel_283:)
		(gUnknown_501_1 sel_437: sel_110: sel_283:)
		(gUnknown_501_2 sel_437: sel_110: sel_283:)
		(gUnknown_501_3 sel_437: sel_110: sel_283:)
		(gUnknown_501_4 sel_437: sel_110: sel_283:)
		(gUnknown_501_5 sel_437: sel_110: sel_283:)
		(gUnknown_501_6 sel_437: sel_110: sel_283:)
		(gUnknown_501_7 sel_437: sel_110: sel_283:)
		(gUnknown_501_8 sel_437: sel_110: sel_283:)
		(gUnknown_501_9 sel_437: sel_110: sel_283:)
		(gUnknown_501_10 sel_437: sel_110: sel_283:)
		(gUnknown_501_11 sel_437: sel_110: sel_283:)
		(unknown_500_16 sel_110:)
		(unknown_500_15 sel_4: 3 sel_165: 5 sel_110: sel_283:)
		(unknown_500_17 sel_110: sel_283:)
		(unknown_500_14 sel_110: sel_437:)
		(unknown_500_19 sel_110:)
		(= local58 (= local60 0))
		(= local59 0)
		(for ((= temp2 0)) (< temp2 (unknown_500_19 sel_86:)) ((++ temp2))
			(if (== ((= temp1 (unknown_500_19 sel_64: temp2)) sel_31:) 2)
				(switch temp2
					(0
						(unknown_500_23
							sel_63: 14
							sel_282:
								((temp1 sel_690:) sel_1:)
								((temp1 sel_690:) sel_0:)
							sel_288:
						)
					)
					(1
						(unknown_500_24
							sel_63: 14
							sel_282:
								((temp1 sel_690:) sel_1:)
								((temp1 sel_690:) sel_0:)
							sel_288:
						)
					)
					(2
						(unknown_500_25
							sel_63: 14
							sel_282:
								((temp1 sel_690:) sel_1:)
								((temp1 sel_690:) sel_0:)
							sel_288:
						)
					)
					(3
						(unknown_500_26
							sel_63: 14
							sel_282:
								((temp1 sel_690:) sel_1:)
								((temp1 sel_690:) sel_0:)
							sel_288:
						)
					)
				)
			)
		)
		(unknown_500_16 sel_144: 0)
		(self sel_145: unknown_500_10)
		(unknown_500_20
			sel_282: (unknown_500_20 sel_1:) (unknown_500_20 sel_0:)
			sel_63: (unknown_500_20 sel_60:)
			sel_287:
			sel_110:
		)
	)

	(method (sel_132 param1 &tmp [temp0 2])
		(if (not (param1 sel_73:))
			(unknown_500_18 sel_132: param1)
			(if (!= (unknown_500_21 sel_1:) 500)
				(unknown_500_21 sel_132: param1)
			else
				(unknown_500_14 sel_132: param1)
			)
			(gUnknown_501_0 sel_132: param1)
			(gUnknown_501_1 sel_132: param1)
			(gUnknown_501_2 sel_132: param1)
			(gUnknown_501_3 sel_132: param1)
			(gUnknown_501_4 sel_132: param1)
			(gUnknown_501_5 sel_132: param1)
			(gUnknown_501_6 sel_132: param1)
			(gUnknown_501_7 sel_132: param1)
			(gUnknown_501_8 sel_132: param1)
			(gUnknown_501_9 sel_132: param1)
			(gUnknown_501_10 sel_132: param1)
			(gUnknown_501_11 sel_132: param1)
			(if (and (param1 sel_73:) gClass_0_7)
				(gClass_0_7 sel_461:)
				(= gClass_0_7 0)
			)
			(global178 sel_132: param1)
			(param1 sel_73: 1)
		)
	)

	(method (sel_57)
		(super sel_57: &rest)
		(Random 1 6)
		(if global536
			(if (== (++ local50) 150)
				(= local50 0)
				(Palette palANIMATE 64 66 1)
			)
			(if (== (++ local51) 350)
				(= local51 0)
				(Palette palANIMATE 66 69 1)
			)
			(if (== (++ local52) 650)
				(= local52 0)
				(Palette palANIMATE 69 72 1)
			)
			(if (== (++ local53) 350)
				(= local53 0)
				(Palette palANIMATE 72 74 1)
			)
			(if (== (++ local54) 250)
				(= local54 0)
				(Palette palANIMATE 77 80 1)
			)
			(if (== (++ local55) 250)
				(= local55 0)
				(Palette palANIMATE 75 77 1)
			)
		)
	)

	(method (sel_111 &tmp temp0 temp1)
		(Class_7_0 sel_125:)
		(Class_500_5 sel_125:)
		(Class_500_4 sel_125:)
		(unknown_500_19 sel_125:)
		(for ((= temp0 11)) (>= temp0 0) ((-- temp0))
			(if (unknown_500_1 sel_86:)
				(= temp1 (unknown_500_1 sel_64: temp0))
				(unknown_500_1 sel_81: temp1)
				(temp1 sel_111: sel_81:)
			)
			(if (unknown_500_2 sel_86:)
				(= temp1 (unknown_500_2 sel_64: temp0))
				(unknown_500_2 sel_81: temp1)
				(temp1 sel_111: sel_81:)
			)
			(if (unknown_500_3 sel_86:)
				(= temp1 (unknown_500_3 sel_64: temp0))
				(unknown_500_3 sel_81: temp1)
				(temp1 sel_111: sel_81:)
			)
			(if (unknown_500_4 sel_86:)
				(= temp1 (unknown_500_4 sel_64: temp0))
				(unknown_500_4 sel_81: temp1)
				(temp1 sel_111: sel_81:)
			)
		)
		(unknown_500_1 sel_111:)
		(unknown_500_2 sel_111:)
		(unknown_500_3 sel_111:)
		(unknown_500_4 sel_111:)
		(unknown_500_23 sel_111:)
		(unknown_500_24 sel_111:)
		(unknown_500_25 sel_111:)
		(unknown_500_26 sel_111:)
		(Class_500_5 sel_111:)
		(Class_500_4 sel_111:)
		(unknown_500_19 sel_111:)
		(DisposeScript 501)
		(DisposeScript 983)
		(DisposeScript 510)
		(DisposeScript 9)
		(DisposeScript 941)
		(super sel_111: &rest)
	)
)

(instance unknown_500_1 of Class_500_6
	(properties)
)

(instance unknown_500_2 of Class_500_6
	(properties)
)

(instance unknown_500_3 of Class_500_6
	(properties)
)

(instance unknown_500_4 of Class_500_6
	(properties)
)

(instance unknown_500_5 of Class_500_3
	(properties
		sel_485 150
		sel_486 30
		sel_487 170
		sel_488 50
	)
)

(instance unknown_500_6 of Class_500_3
	(properties
		sel_485 65
		sel_486 40
		sel_487 80
		sel_488 60
	)
)

(instance unknown_500_7 of Class_500_3
	(properties
		sel_485 110
		sel_486 70
		sel_487 130
		sel_488 90
	)
)

(instance unknown_500_8 of Class_500_3
	(properties
		sel_485 70
		sel_486 90
		sel_487 90
		sel_488 110
	)
)

(instance unknown_500_9 of Class_500_3
	(properties
		sel_485 140
		sel_486 120
		sel_487 160
		sel_488 140
	)
)

(instance unknown_500_10 of Script
	(properties
		sel_20 -1
	)

	(method (sel_143 param1 &tmp temp0 temp1 [temp2 100] temp102 temp103 temp104 temp105)
		(switch (= sel_29 param1)
			(0
				(= global145 global178)
				(unknown_500_19 sel_57: 1)
				(= global186 global178)
				(= global178 global145)
				(Class_500_4
					sel_118:
						unknown_500_5
						unknown_500_6
						unknown_500_7
						unknown_500_8
						unknown_500_9
				)
				(if (== (global178 sel_31:) 2)
					(= sel_135 1)
				)
				(unknown_500_15 sel_4: 3 sel_284:)
			)
			(1
				(unknown_500_15 sel_4: 3 sel_284:)
				(if (== (global178 sel_31:) 2)
					(proc0_4)
				)
				(Class_500_4 sel_119: 497)
				(global178 sel_671: 3)
				(Class_500_5 sel_125:)
				(Class_500_4 sel_119: 438)
				(= global509 5)
				(if (== (global178 sel_31:) 2)
					(= sel_135 30)
				else
					(= sel_135 1)
				)
			)
			(2
				(if (== (global178 sel_31:) 2)
					(unknown_500_14 sel_436:)
				)
				(Class_500_4 sel_119: 494)
				(= sel_135 1)
			)
			(3
				(cond
					((== global509 5)
						(gSound sel_39: 500)
					)
					((== global509 4)
						(gSound sel_39: 500)
					)
					((== global509 3)
						(gSound sel_39: 501)
					)
					((== global509 2)
						(gSound sel_39: 501)
					)
					((== global509 1)
						(gSound sel_39: 502)
					)
				)
				(= sel_138 60)
			)
			(4
				(global178 sel_695:)
				(gSound sel_99: 0)
				(cond
					((== global509 5)
						(gSound sel_39: 503)
					)
					((== global509 4)
						(gSound sel_39: 503)
					)
					((== global509 3)
						(gSound sel_39: 504)
					)
					((== global509 2)
						(gSound sel_39: 504)
					)
					((== global509 1)
						(gSound sel_39: 505)
					)
				)
				(self sel_145: unknown_500_12)
			)
			(5
				(gSound sel_159:)
				(Class_500_4 sel_680:)
				(Class_500_4 sel_681: sel_680:)
				(global178 sel_692:)
				(if (== (global178 sel_31:) 2)
					(if (and global519 (== (global178 sel_671:) 2))
						(if (== (global178 sel_31:) 2)
							(= temp104 (* (- (global534 sel_3:) 1) 3))
							(gSound2 sel_39: 100 sel_165: 1)
							(if (or global519 (!= temp104 10))
								(global178
									sel_446:
										(Random (+ 36 temp104) (+ 38 temp104))
								)
							)
						)
						(unknown_500_20
							sel_282: (global520 sel_1:) (global520 sel_0:)
						)
						(= global533 global520)
					)
					(if (and (not global519) (== (global178 sel_671:) 0))
						(unknown_500_20
							sel_282: (global520 sel_1:) (global520 sel_0:)
						)
					)
					(self sel_145: unknown_500_11)
				)
			)
			(6
				(= global509 5)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(if (>= ((Class_500_4 sel_64: temp0) sel_0:) 170)
						((Class_500_4 sel_64: temp0) sel_366: 1)
						(-- global509)
					else
						((Class_500_4 sel_64: temp0) sel_366: 0)
					)
				)
				(if (and (global178 sel_671:) global509)
					(= sel_29 1)
				)
				(= sel_135 1)
			)
			(7
				(= sel_135 1)
				(if (== (global178 sel_31:) 2)
					(Wait 1)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
				)
				(unknown_500_19 sel_57:)
				(= global145 global178)
				(unknown_500_19 sel_57: 1)
				(= global186 global178)
				(= global178 global145)
				(global178 sel_119: 658 0)
				(if (global178 sel_670:)
					(= sel_29 0)
				)
			)
			(8
				(for
					((= temp0 0))
					(< temp0 (unknown_500_19 sel_86:))
					((++ temp0))
					
					((unknown_500_19 sel_64: temp0)
						sel_691:
							(+
								((unknown_500_19 sel_64: temp0) sel_691:)
								(= temp105
									((unknown_500_19 sel_64: temp0) sel_669:)
								)
							)
					)
					(if (> temp105 local58)
						(= local58 temp105)
						(= local59 (unknown_500_19 sel_64: temp0))
					)
				)
				(++ local60)
				(= sel_135 20)
			)
			(9
				(= temp102 0)
				(= temp1 (unknown_500_19 sel_64: 0))
				(= temp103 ((unknown_500_19 sel_64: 0) sel_669:))
				(if (> (unknown_500_19 sel_86:) 1)
					(for
						((= temp0 1))
						(< temp0 (unknown_500_19 sel_86:))
						((++ temp0))
						
						(cond
							(
								(>
									((unknown_500_19 sel_64: temp0) sel_669:)
									(temp1 sel_669:)
								)
								(= temp102 0)
								(= temp1 (unknown_500_19 sel_64: temp0))
								(= temp103 (temp1 sel_669:))
							)
							(
								(==
									((unknown_500_19 sel_64: temp0) sel_669:)
									(temp1 sel_669:)
								)
								(= temp102 temp103)
							)
						)
					)
					(gSong sel_39: 906 sel_165: 1)
					(cond
						(temp102
							(gSong sel_39: 804 sel_165: -1)
							(Class_0_5 sel_446: (Random 30 32))
						)
						((== (temp1 sel_31:) 2)
							(gSong sel_39: 804 sel_165: -1)
							(temp1 sel_446: (Random 81 83) 0 443 -32768)
						)
						(else
							(gSong sel_39: 906 sel_165: -1)
							(Class_0_5
								sel_446:
									(Format @global550 599 2 (temp1 sel_510:)) ; "Congratulations %s, You Won!"
							)
						)
					)
					(proc0_1)
					(proc500_2)
					(gSong sel_162:)
				)
			)
			(10
				(unknown_500_20 sel_282: 500 500)
				(unknown_500_19 sel_57:)
				(= global145 global178)
				(unknown_500_19 sel_57: 1)
				(= global186 global178)
				(= global178 global145)
				(global178 sel_119: 658 0)
				(unknown_500_19 sel_119: 497)
				(Format @global550 599 3)
				(global178 sel_119: 667)
				(unknown_500_17 sel_656: 0 sel_666:)
				(unknown_500_15 sel_4: 3 sel_284:)
				(global178 sel_671: 0)
				(= local61 1)
				(if (== (global178 sel_31:) 2)
					(unknown_500_14 sel_165: 4)
					(= sel_29 0)
					(= sel_135 1)
				)
			)
			(11
				(= sel_29 0)
				(= sel_135 1)
			)
		)
	)
)

(instance unknown_500_11 of Script
	(properties
		sel_20 -1
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= global517 0)
				(= sel_135 1)
			)
			(1
				(if global517
					((Class_500_4 sel_64: (- global517 1)) sel_63: 10)
				)
				(cond
					(((Class_500_4 sel_64: global517) sel_366:)
						(if
							(not
								(Class_500_5
									sel_122: (Class_500_4 sel_64: global517)
								)
							)
							(= local47 1)
							(Class_500_5
								sel_118: (Class_500_4 sel_64: global517) self
							)
							(gSound sel_39: 302)
						else
							(= local47 0)
							(= sel_135 1)
						)
					)
					((Class_500_5 sel_122: (Class_500_4 sel_64: global517))
						(= local47 1)
						(Class_500_5
							sel_687: (Class_500_4 sel_64: global517) self
						)
						(gSound sel_39: 302)
					)
					(else
						(= local47 0)
						(= sel_135 1)
					)
				)
			)
			(2
				(Class_500_5 sel_119: 283)
				(if (!= (++ global517) 5)
					(-= sel_29 2)
				)
				(= sel_135 (+ (* local47 10) 1))
			)
			(3
				((Class_500_4 sel_64: (- global517 1)) sel_63: 10)
				(= sel_135 1)
			)
			(4
				(if
					(or
						(== (global178 sel_671:) 0)
						(== (Class_500_5 sel_86:) 5)
					)
					(cond
						((== (global534 sel_655:) 0)
							(gSound2 sel_39: 907 sel_165: 1)
							(global178 sel_446: (Random 24 26) 0 445 -32768)
						)
						((and (not global519) (== (global178 sel_31:) 2))
							(= temp0 (* (- (global534 sel_3:) 1) 3))
							(gSound2 sel_39: 100 sel_165: 1)
							(global178
								sel_446: (Random (+ 36 temp0) (+ 38 temp0))
							)
						)
					)
					(global534 sel_666: (global534 sel_655:) sel_668:)
					(Class_500_4 sel_119: 438)
					(if
						(and
							(== (global178 sel_31:) 2)
							(== (global186 sel_31:) 2)
						)
						(proc0_4)
						(= sel_135 30)
						(return)
					)
				else
					(sel_42 sel_144:)
				)
				(sel_42 sel_145: 0)
			)
			(5
				(if
					(or
						(== (unknown_500_14 sel_3:) 6)
						(== (unknown_500_14 sel_3:) 7)
					)
					(unknown_500_14 sel_165: 4)
					(unknown_500_20 sel_282: 500 500)
				)
				(= global510 1)
				(proc0_4)
				(sel_42 sel_144: sel_145: 0)
			)
		)
	)
)

(instance unknown_500_12 of Script
	(properties
		sel_20 -1
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= local61 0)
				(if (not (Class_500_5 sel_122: unknown_500_5))
					(unknown_500_5 sel_285:)
				)
				(if (not (Class_500_5 sel_122: unknown_500_6))
					(unknown_500_6 sel_285:)
				)
				(if (not (Class_500_5 sel_122: unknown_500_7))
					(unknown_500_7 sel_285:)
				)
				(if (not (Class_500_5 sel_122: unknown_500_8))
					(unknown_500_8 sel_285:)
				)
				(if (not (Class_500_5 sel_122: unknown_500_9))
					(unknown_500_9 sel_285:)
				)
				(Class_500_4 sel_685:)
				(= global507 0)
				(= global508 0)
				(= sel_135 1)
			)
			(1
				(for
					((= temp0 0))
					(or
						((Class_500_4 sel_64: temp0) sel_489:)
						((Class_500_4 sel_64: temp0) sel_366:)
					)
					((++ temp0))
				)
				(++ global507)
				((Class_500_4 sel_64: temp0) sel_498:)
				(if (== global507 global509)
					(= global508 (Class_500_4 sel_64: temp0))
				)
				(= sel_135 (Random 1 3))
			)
			(2
				(if (!= global507 global509)
					(-= sel_29 2)
					(= sel_135 1)
				)
			)
			(3
				(sel_42 sel_145: 0 sel_135: 1)
				(Class_500_4 sel_119: 489 0)
				(= global510 0)
				(unknown_500_5 sel_437: sel_283:)
				(unknown_500_6 sel_437: sel_283:)
				(unknown_500_7 sel_437: sel_283:)
				(unknown_500_8 sel_437: sel_283:)
				(unknown_500_9 sel_437: sel_283:)
				(if (== (global178 sel_671:) 0)
					(unknown_500_21 sel_110:)
				)
				(if (!= (global178 sel_31:) 2)
					(proc0_3)
				)
				(if
					(==
						(unknown_500_5 sel_482:)
						(unknown_500_6 sel_482:)
						(unknown_500_7 sel_482:)
						(unknown_500_8 sel_482:)
						(unknown_500_9 sel_482:)
					)
					(Class_500_4 sel_119: 283)
					(proc0_1)
					(if
						(and
							(or
								(not global519)
								(and
									(IsObject global533)
									(== (global533 sel_661:) gUnknown_501_10)
								)
							)
							(== ((global178 sel_64: 10) sel_656:) -1)
						)
						(gSound sel_39: 906 sel_165: 1)
						(if (== (global178 sel_31:) 2)
							(global178 sel_446: (Random 75 77) 0 444 -32768)
						else
							(Class_0_5 sel_446: (Random 72 74) 0 445 -32768)
						)
					)
				)
				(gSound sel_99: 1)
			)
		)
	)
)

(instance unknown_500_13 of Prop
	(properties
		sel_20 -1
	)

	(method (sel_144)
		(if (!= (global178 sel_31:) 2)
			(proc0_3)
		)
		(global518 sel_63: 10 sel_283:)
	)
)

(instance unknown_500_14 of Class_0_6
	(properties)

	(method (sel_110)
		(self
			sel_2: 504
			sel_287:
			sel_165: 4
			sel_4: 0
			sel_282: 31 199
			sel_63: 13
			sel_198:
		)
		(super sel_110: &rest)
	)

	(method (sel_132 param1)
		(if (and (not global510) (super sel_132: param1))
			(gSound2 sel_39: 100 sel_165: 1)
			(if (== (unknown_500_10 sel_29:) 8)
				(return)
			)
			(param1 sel_73: 1)
			(if
				(and
					(== sel_3 4)
					(not (global178 sel_671:))
					(< (unknown_500_10 sel_29:) 9)
				)
				(gSound2 sel_39: 907 sel_165: 1)
				(Class_0_5 sel_446: (Random 18 20) -32768)
				(return)
			)
			(if
				(and
					(== sel_3 4)
					(== (Class_500_5 sel_86:) 5)
					(< (unknown_500_10 sel_29:) 9)
				)
				(gSound2 sel_39: 907 sel_165: 1)
				(Class_0_5 sel_446: (Random 21 23) -32768)
				(return)
			)
			(if (== sel_3 8)
				(self sel_165: 4)
				(unknown_500_20 sel_282: 500 500)
				(unknown_500_10 sel_144:)
				(return)
			)
			(if (and global519 (== (global178 sel_671:) 2) (not global533))
				(gSound2 sel_39: 907 sel_165: 1)
				(Class_0_5 sel_446: (Random 3 5) -32768 445 -32768)
				(return)
			)
			(if (or (== sel_3 6) (== sel_3 7))
				(unknown_500_15 sel_4: 3 sel_284:)
				(self sel_165: 4)
				(unknown_500_20 sel_282: 500 500)
			)
			(unknown_500_10 sel_144:)
			(= global510 1)
			(proc0_4)
		)
		(param1 sel_73:)
	)
)

(instance unknown_500_15 of View
	(properties
		sel_20 -1
	)

	(method (sel_110)
		(self sel_287: sel_2: 504 sel_165: 9 sel_4: 0 sel_282: 83 199 sel_63: 7)
		(super sel_110: &rest)
	)
)

(instance unknown_500_16 of Prop
	(properties
		sel_20 -1
	)

	(method (sel_110)
		(DrawCel 503 0 sel_4 75 0 7)
	)

	(method (sel_144 &tmp temp0)
		(if (> (unknown_500_19 sel_86:) 1)
			(if (not argc)
				(= temp0 (unknown_500_19 sel_131: global500))
				(if (> (unknown_500_19 sel_86:) (+ temp0 1))
					(= global500 (unknown_500_19 sel_64: (+ temp0 1)))
				else
					(= global500 (unknown_500_19 sel_64: 0))
				)
				(if (== global178 global500)
					(if global533
						(unknown_500_20
							sel_282: (global533 sel_1:) (global533 sel_0:)
						)
					else
						(unknown_500_20 sel_282: 500 500)
					)
				else
					(unknown_500_20 sel_282: 500 500)
				)
			)
			(self sel_4: (unknown_500_19 sel_131: global500) sel_110:)
			(proc0_1)
			(global500 sel_119: 666)
		)
		(unknown_500_17
			sel_666:
				(if (global500 sel_86:)
					(global500 sel_669:)
				else
					0
				)
		)
	)
)

(instance unknown_500_17 of Class_500_0
	(properties)

	(method (sel_110)
		(self
			sel_287:
			sel_2: 503
			sel_165: 13
			sel_4: 0
			sel_282: 37 170
			sel_63: 7
			sel_656: 0
		)
		(super sel_110: &rest)
	)

	(method (sel_666 param1)
		(if argc
			(= sel_656 param1)
		)
		(Format @global550 599 4 sel_656) ; "%3d"
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			81
			(- sel_0 10)
			dsBACKGROUND
			(global500 sel_25:)
			dsCOLOR
			global375
		)
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			82
			(- sel_0 10)
			dsBACKGROUND
			global376
			dsCOLOR
			global377
		)
	)
)

(instance unknown_500_18 of Class_0_6
	(properties)

	(method (sel_110)
		(self sel_287: sel_2: 504 sel_165: 0 sel_4: 0 sel_282: 37 24 sel_63: 7)
		(super sel_110: &rest)
	)

	(method (sel_132 param1)
		(if (super sel_132: param1)
			(gSound2 sel_39: 100 sel_165: 1)
			(param1 sel_73: 1)
			(unknown_500_16 sel_144:)
		)
		(param1 sel_73:)
	)
)

(instance unknown_500_19 of List
	(properties
		sel_20 -1
	)

	(method (sel_110 &tmp temp0)
		(= temp0 1)
		(if (unknown_500_1 sel_31:)
			(self sel_118: unknown_500_1)
		)
		(if (unknown_500_2 sel_31:)
			(self sel_118: unknown_500_2)
		)
		(if (unknown_500_3 sel_31:)
			(self sel_118: unknown_500_3)
		)
		(if (unknown_500_4 sel_31:)
			(self sel_118: unknown_500_4)
		)
		(if (== (unknown_500_1 sel_31:) 2)
			(unknown_500_1 sel_690: gUnknown_0_2)
			(++ temp0)
		)
		(if (== (unknown_500_2 sel_31:) 2)
			(unknown_500_2 sel_690: (if (== temp0 2) gUnknown_0_3 else gUnknown_0_2))
			(++ temp0)
		)
		(if (== (unknown_500_3 sel_31:) 2)
			(switch temp0
				(1
					(unknown_500_3 sel_690: gUnknown_0_2)
				)
				(2
					(unknown_500_3 sel_690: gUnknown_0_3)
				)
				(3
					(unknown_500_3 sel_690: gUnknown_0_4)
				)
			)
			(++ temp0)
		)
		(if (== (unknown_500_4 sel_31:) 2)
			(switch temp0
				(1
					(unknown_500_4 sel_690: gUnknown_0_2)
				)
				(2
					(unknown_500_4 sel_690: gUnknown_0_3)
				)
				(3
					(unknown_500_4 sel_690: gUnknown_0_4)
				)
			)
		)
		(= global500 (= global178 (self sel_64: 0)))
	)

	(method (sel_57 param1 &tmp temp0)
		(if (> sel_86 1)
			(= temp0 (self sel_131: global178))
			(if (> sel_86 (+ temp0 1))
				(= global178 (self sel_64: (+ temp0 1)))
			else
				(= global178 (self sel_64: 0))
			)
			(if (or (not argc) (not param1))
				(= global500 global178)
				(unknown_500_18 sel_165: (unknown_500_19 sel_131: global178))
				(unknown_500_16 sel_144: 1)
			)
		)
	)
)

(instance unknown_500_20 of View
	(properties
		sel_20 -1
		sel_1 500
		sel_0 500
		sel_2 503
		sel_3 14
		sel_60 9
	)
)

(instance unknown_500_21 of Class_0_6
	(properties)

	(method (sel_110)
		(self
			sel_287:
			sel_2: 504
			sel_165: 5
			sel_4: 0
			sel_282: 31 199
			sel_63: 14
		)
		(super sel_110: &rest)
		(self sel_437:)
	)

	(method (sel_132 param1)
		(if (super sel_132: param1)
			(param1 sel_73: 1)
			(gSound2 sel_39: 907 sel_165: 1)
			(Class_0_5 sel_446: (Random 18 20) -32768)
		)
		(param1 sel_73:)
	)
)

(instance yacht_opt of File
	(properties
		sel_20 {yacht.opt}
	)

	(method (sel_57 param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self sel_183: 2)
					(self
						sel_328: (Format @temp0 599 16 global519 global536) ; "%d%d"
						sel_332:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self sel_183: 1)
				(= global519 (ReadNumber (self sel_327: @temp20 2)))
				(= global536 (ReadNumber (self sel_327: @temp20 2)))
				(self sel_332:)
				(return 0)
			)
			(else
				(= global519 0)
				(= global536 1)
				(return 0)
			)
		)
	)
)

(instance unknown_500_23 of View
	(properties
		sel_20 -1
		sel_2 503
		sel_3 15
	)
)

(instance unknown_500_24 of View
	(properties
		sel_20 -1
		sel_2 503
		sel_3 15
		sel_4 1
	)
)

(instance unknown_500_25 of View
	(properties
		sel_20 -1
		sel_2 503
		sel_3 15
		sel_4 2
	)
)

(instance unknown_500_26 of View
	(properties
		sel_20 -1
		sel_2 503
		sel_3 15
		sel_4 3
	)
)

