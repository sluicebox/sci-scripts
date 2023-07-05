;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use User)
(use Actor)
(use System)

(local
	[local0 8] = [0 4 6 2 7 5 1 3]
)

(class rhEgo of Ego
	(properties
		sel_20 {rhEgo}
		sel_595 0
		sel_426 1
		sel_596 1
		sel_597 0
		sel_598 1
	)

	(method (sel_156 param1)
		(= sel_4
			(if (>= param1 (self sel_238:))
				(self sel_238:)
			else
				param1
			)
		)
	)

	(method (sel_155 param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(|= sel_14 $0800)
						0
					)
					((== param1 -1)
						(&= sel_14 $f7ff)
						0
					)
					((not (IsObject param1))
						(= sel_3 param1)
						(|= sel_14 $0800)
						0
					)
					((& (param1 sel_4103:) $8000)
						(param1 sel_109:)
					)
					(else param1)
				)
			)
			(if sel_59
				(sel_59 sel_111:)
			)
			((= sel_59 temp0) sel_110: self &rest)
		)
	)

	(method (sel_63 param1)
		(cond
			((== argc 0)
				(|= sel_14 $0010)
				(sel_595 sel_63:)
			)
			((== param1 -1)
				(&= sel_14 $ffef)
				(sel_595 sel_63: -1)
			)
			(else
				(= sel_60 param1)
				(|= sel_14 $0010)
				(sel_595 sel_63: param1)
			)
		)
	)

	(method (sel_599 param1)
		(sel_595 sel_2: param1)
		(if (not (& (sel_595 sel_14:) $0008))
			(sel_595 sel_113:)
		)
	)

	(method (sel_102)
		(if sel_595
			(sel_595 sel_102:)
		)
		(if sel_597
			(sel_597 sel_102:)
		)
		(super sel_102:)
	)

	(method (sel_111)
		(if sel_595
			(sel_595 sel_111:)
		)
		(if sel_597
			(sel_597 sel_111:)
		)
		(super sel_111:)
	)

	(method (sel_600 param1)
		(if argc
			(self sel_236: param1 sel_53: param1)
		else
			(self sel_236: global141 sel_53: global141)
		)
	)

	(method (sel_601)
		(self sel_236: (gGame sel_602:) sel_53: (gGame sel_602:))
	)
)

(class Head of Prop
	(properties
		sel_20 {Head}
		sel_236 180
		sel_42 0
		sel_603 0
	)

	(method (sel_110 param1)
		(self sel_42: param1 sel_307: 1)
		(param1 sel_595: self)
		(super sel_110:)
		(self sel_102:)
	)

	(method (sel_292 param1 param2)
		(if
			(not
				(and
					sel_42
					(IsObject (sel_42 sel_291:))
					((sel_42 sel_291:) sel_292: param1 param2 &rest)
				)
			)
			(sel_42 sel_292: param1 param2 &rest)
		)
	)

	(method (sel_57)
		(cond
			(
				(and
					(sel_42 sel_426:)
					(not (& (sel_42 sel_14:) $0008))
					(sel_42 sel_239:)
					(IsObject (sel_42 sel_237:))
					(or
						((sel_42 sel_237:) sel_114: Unknown_Class_82)
						((sel_42 sel_237:) sel_114: Unknown_Class_124)
					)
					(== (sel_42 sel_2:) ((sel_42 sel_237:) sel_443:))
				)
				(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
					(if (& (sel_42 sel_14:) $0004)
						(return)
					else
						(self sel_306:)
					)
				)
				(self sel_113:)
				(self sel_604:)
			)
			((not (& sel_14 $0008))
				(self sel_102:)
			)
		)
		(super sel_57:)
	)

	(method (sel_113 &tmp temp0)
		(if (& sel_14 $0008)
			(= sel_4 [local0 (sel_42 sel_3:)])
			(= sel_603 sel_236)
			(self sel_207:)
		)
		(self sel_1: (sel_42 sel_1:) sel_0: (sel_42 sel_0:))
	)

	(method (sel_605)
		(self
			sel_2:
				(if (OneOf (gEgo sel_2:) 1 13 30 34 24 17 703)
					(gEgo sel_2:)
				else
					(+ (gEgo sel_2:) 1)
				)
			sel_3:
				(cond
					((== global126 2) 9)
					((== (gEgo sel_2:) 702) 4)
					(else 8)
				)
			sel_4: [local0 (sel_42 sel_3:)]
			sel_82:
				(switch global126
					(5 38)
					(2 39)
					(3 39)
					(else 40)
				)
		)
		(if (gCast sel_122: gEgo)
			(self sel_57:)
		)
	)

	(method (sel_604 &tmp temp0)
		(if (and (sel_42 sel_596:) (< (-- sel_603) 1))
			(= sel_603 sel_236)
			(= sel_4 (+ [local0 (sel_42 sel_3:)] (- (Random 0 2) 1)))
			(if (> sel_4 7)
				(= sel_4 0)
			)
			(if (< sel_4 0)
				(= sel_4 7)
			)
		)
	)
)

(class SpecialDoVerb of Code
	(properties
		sel_20 {SpecialDoVerb}
	)

	(method (sel_292 param1 param2 param3)
		(param3 sel_292: param1 &rest)
	)
)

(class Beard of Prop
	(properties
		sel_20 {Beard}
		sel_42 0
	)

	(method (sel_110 param1)
		(self sel_42: param1 sel_307: 1)
		(param1 sel_597: self)
		(super sel_110:)
		(self sel_102:)
	)

	(method (sel_57)
		(cond
			(
				(and
					(sel_42 sel_598:)
					(not (& (sel_42 sel_14:) $0008))
					(not (sel_42 sel_239:))
					(IsObject (sel_42 sel_237:))
					(or
						((sel_42 sel_237:) sel_114: Unknown_Class_82)
						((sel_42 sel_237:) sel_114: Unknown_Class_124)
					)
					(not (== (sel_42 sel_2:) ((sel_42 sel_237:) sel_443:)))
				)
				(self sel_113:)
			)
			((not (& sel_14 $0008))
				(self sel_102:)
			)
		)
		(super sel_57: &rest)
	)

	(method (sel_113)
		(self sel_207:)
		(self
			sel_3: (sel_42 sel_3:)
			sel_4: (sel_42 sel_4:)
			sel_1: (sel_42 sel_1:)
			sel_0: (sel_42 sel_0:)
		)
	)
)

