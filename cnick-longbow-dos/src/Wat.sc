;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	Wat 0
	merryMenEntrance 1
	proc125_2 2
	putStuff 3
)

(procedure (proc125_2)
	(Wat
		sel_640: 0
		sel_643: 0
		sel_652: 0
		sel_653: 0
		sel_654: 0
		sel_655: 0
		sel_146: 0
	)
)

(class Wat of Rgn
	(properties
		sel_20 {Wat}
		sel_397 1
		sel_640 0
		sel_641 0
		sel_642 0
		sel_643 0
		sel_644 0
		sel_645 0
		sel_646 0
		sel_647 0
		sel_648 0
		sel_649 0
		sel_650 0
		sel_651 4
		sel_652 0
		sel_653 0
		sel_654 0
		sel_655 4
		sel_656 0
		sel_657 0
	)

	(method (sel_110)
		(= sel_656 travelTimer)
		(if (== gPrevRoomNum 220)
			(= sel_651 (/ (& global112 $00f0) 16))
		)
		(super sel_110:)
	)

	(method (sel_390 param1)
		(if (not (OneOf param1 110 120 100))
			(self sel_397: 0)
		)
	)

	(method (sel_111)
		(if
			(and
				(== global130 1)
				(proc0_5 44)
				(not (proc0_5 75))
				(not (proc0_5 173))
			)
			(proc0_6 103)
		)
		(if
			(and
				(== global130 4)
				(proc0_5 47)
				(not (proc0_5 153))
				(not (proc0_5 174))
			)
			(proc0_6 184)
		)
		(if (and (== global130 8) (proc0_5 135) (not (proc0_5 57)))
			(proc0_6 191)
		)
		(super sel_111:)
	)
)

(instance putStuff of Code
	(properties
		sel_20 {putStuff}
	)

	(method (sel_57 param1 &tmp temp0)
		(= temp0 (gInventory sel_132: param1))
		(if
			(and
				(param1 sel_114: InvI)
				(== (param1 sel_167:) gEgo)
				(or
					(and (== global126 1) (not (OneOf temp0 0 3 15)))
					(and
						(== global126 2)
						(not (OneOf temp0 0 2 14 10 18 8 7))
					)
					(and (== global126 4) (not (OneOf temp0 0 17)))
					(and
						(== global126 5)
						(not (OneOf temp0 0 2 11 14 12 10 13 18))
					)
					(and
						(== global126 6)
						(not (OneOf temp0 0 2 14 10 5 6 17 16 18))
					)
				)
			)
			(gEgo sel_343: temp0 140)
		)
	)
)

(instance travelTimer of Script
	(properties
		sel_20 {travelTimer}
	)

	(method (sel_110)
		(= sel_137 (if (Wat sel_647:) 5 else 10))
		(super sel_110: &rest)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0 0)
			(1
				(Wat
					sel_655:
						(if (== (Wat sel_654:) 1)
							(- (Wat sel_655:) 1)
						else
							(+ (Wat sel_655:) 1)
						)
				)
				(= sel_137 (if (Wat sel_647:) 5 else 10))
			)
			(2
				(if (or (<= (Wat sel_655:) 1) (>= (Wat sel_655:) 9))
					(proc125_2)
					(switch global130
						(1
							(if (and (proc0_5 46) (proc0_5 45))
								(gCurRoom sel_390: 160)
							)
						)
						(4
							(if (proc0_5 48)
								(gCurRoom sel_390: 160)
							)
						)
					)
					(self sel_111:)
				else
					(-= sel_29 2)
					(self sel_145:)
				)
			)
		)
	)
)

(instance merryMenEntrance of Script
	(properties
		sel_20 {merryMenEntrance}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(ScriptID 20) ; MISSING SCRIPT
				(ScriptID 19) ; MISSING SCRIPT
				(ScriptID 23) ; MISSING SCRIPT
				(proc958_0 128 160 161 162 151 152 153 154 155 156)
				((ScriptID 20) ; MISSING SCRIPT
					sel_322: 1
					sel_153: 265 -2
					sel_110:
					sel_162: Unknown_Class_82 161
					sel_303: MoveTo 185 30 self
				)
				((ScriptID 19) ; MISSING SCRIPT
					sel_153: -10 75
					sel_110:
					sel_162: Unknown_Class_82 152
					sel_303: MoveTo 95 70
				)
				((ScriptID 23) ; MISSING SCRIPT
					sel_153: 330 125
					sel_110:
					sel_162: Unknown_Class_82 155
					sel_303: MoveTo 240 125
				)
			)
			(1
				((ScriptID 20) sel_303: MoveTo 185 50 self) ; MISSING SCRIPT
			)
			(2
				((ScriptID 19) sel_304:) ; MISSING SCRIPT
				((ScriptID 23) sel_304:) ; MISSING SCRIPT
				((ScriptID 20) sel_304:) ; MISSING SCRIPT
				(self sel_111:)
			)
		)
	)
)

