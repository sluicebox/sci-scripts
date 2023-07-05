;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use User)
(use Actor)

(local
	[local0 8] = [0 4 2 5 1 7 3 6]
)

(class SQEgo of Ego
	(properties
		sel_20 {SQEgo}
		sel_568 0
		sel_426 1
		sel_569 1
	)

	(method (sel_570 param1)
		(sel_568 sel_2: param1)
		(if (not (& (sel_568 sel_14:) $0008))
			(sel_568 sel_113:)
		)
	)

	(method (sel_102)
		(if sel_568
			(sel_568 sel_102:)
		)
		(super sel_102:)
	)

	(method (sel_111)
		(if sel_568
			(sel_568 sel_111:)
		)
		(super sel_111:)
	)

	(method (sel_304)
		(if sel_568
			(sel_568 sel_304:)
		)
		(super sel_304:)
	)
)

(class Head of Prop
	(properties
		sel_20 {Head}
		sel_42 0
		sel_571 0
		sel_572 0
	)

	(method (sel_110 param1)
		(self sel_42: param1 sel_307: 1)
		(= sel_3 (- (NumLoops self) 1))
		(param1 sel_568: self)
		(super sel_110:)
		(self sel_102:)
	)

	(method (sel_57)
		(cond
			(
				(and
					(sel_42 sel_426:)
					(not (& (sel_42 sel_14:) $0008))
					(sel_42 sel_239:)
					(IsObject (sel_42 sel_237:))
					((sel_42 sel_237:) sel_114: Unknown_Class_82)
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
				(self sel_573:)
			)
			((not (& sel_14 $0008))
				(self sel_102:)
			)
		)
		(super sel_57:)
	)

	(method (sel_113 &tmp temp0)
		(if (& sel_14 $0008)
			(self sel_4: (sel_42 sel_3:))
			(= sel_571 sel_236)
			(for ((= temp0 0)) (<= temp0 7) ((++ temp0))
				(if (== sel_4 [local0 temp0])
					(= sel_572 temp0)
				)
			)
		)
		(self
			sel_63: (sel_42 sel_60:)
			sel_3: (- (NumLoops self) 1)
			sel_1: (sel_42 sel_1:)
			sel_0: (sel_42 sel_0:)
			sel_82: (CelHigh sel_2 (sel_42 sel_3:) (sel_42 sel_4:))
			sel_207:
		)
	)

	(method (sel_573 &tmp temp0)
		(if (and (sel_42 sel_569:) (< (-- sel_571) 1))
			(= sel_571 sel_236)
			(if (> (= temp0 (+ sel_572 (- (Random 0 2) 1))) 7)
				(= temp0 0)
			)
			(if (< temp0 0)
				(= temp0 7)
			)
			(= sel_4 [local0 temp0])
		)
	)
)

