;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 977)
(include sci.sh)
(use Main)
(use Sight)
(use Motion)
(use System)

(local
	[trans1 8] = [2 6 4 0 3 5 1 7]
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(class Grooper of Code
	(properties
		sel_20 {Grooper}
		sel_42 0
		sel_444 0
		sel_445 0
		sel_143 0
	)

	(method (sel_57 param1 param2 param3 param4 &tmp temp0 temp1)
		(if (not sel_42)
			(= sel_42 param1)
		)
		(if (& (sel_42 sel_14:) $0800)
			(if sel_143
				(sel_143 sel_145:)
			)
			(= sel_143 0)
			(return)
		)
		(if (>= argc 3)
			(= sel_143 param3)
		)
		(= temp1 (if (< (NumLoops sel_42) 8) 4 else 8))
		(if (or (not (gCast sel_122: sel_42)) (and (>= argc 4) param4))
			(sel_42
				sel_3:
					[trans2
						(*
							(if (== temp1 4) 2 else 1)
							(/
								(umod
									(+ (sel_42 sel_55:) (/ 180 temp1))
									360
								)
								(/ 360 temp1)
							)
						)
					]
			)
			(if sel_143
				(sel_143 sel_145:)
			)
			(= sel_143 0)
			(return)
		)
		(= temp0
			(if
				(and
					(== (sel_42 sel_3:) (- (NumLoops sel_42) 1))
					((sel_42 sel_237:) sel_114: Unknown_Class_82)
					(== ((sel_42 sel_237:) sel_443:) -1)
				)
				[trans1 (sel_42 sel_4:)]
			else
				[trans1 (sel_42 sel_3:)]
			)
		)
		(if sel_445
			(sel_445 sel_111:)
			(= sel_445 0)
		)
		(if
			(and
				(IsObject sel_444)
				(or
					(sel_444 sel_115: Grycler)
					(not ((sel_42 sel_237:) sel_115: Grycler))
				)
			)
			(sel_444 sel_111:)
			(= sel_444 0)
		)
		(if (not sel_444)
			(= sel_444 (sel_42 sel_237:))
		)
		(if (and (sel_42 sel_237:) ((sel_42 sel_237:) sel_115: Grycler))
			((sel_42 sel_237:) sel_111:)
		)
		(= sel_445 (sel_42 sel_56:))
		(sel_42 sel_237: 0 sel_56: 0 sel_303: 0 sel_162: Grycler self temp0)
	)

	(method (sel_145 &tmp temp0)
		(if (not (IsObject (sel_42 sel_56:)))
			(sel_42 sel_56: sel_445)
		)
		(if (IsObject sel_444)
			(sel_42 sel_237: sel_444)
		)
		(= temp0 sel_143)
		(= sel_143 (= sel_445 (= sel_444 0)))
		(if temp0
			(temp0 sel_145: &rest)
		)
	)

	(method (sel_111)
		(if (IsObject sel_444)
			(sel_444 sel_111:)
			(= sel_444 0)
		)
		(if (IsObject sel_445)
			(sel_445 sel_111:)
			(= sel_445 0)
		)
		(if sel_42
			(sel_42 sel_59: 0)
		)
		(super sel_111:)
	)
)

(class Grycler of Cycle
	(properties
		sel_20 {Grycler}
		sel_446 0
		sel_447 0
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(= sel_143 param2)
		(= sel_447 (if (< (NumLoops sel_42) 8) 4 else 8))
		(= sel_231 (- (sign (AngleDiff (* param3 45) (param1 sel_55:)))))
		(= sel_446 param3)
		(if (self sel_448:)
			(if
				(and
					(((sel_42 sel_59:) sel_444:) sel_114: Unknown_Class_82)
					(== (((sel_42 sel_59:) sel_444:) sel_443:) -1)
				)
				(sel_42 sel_3: [trans2 sel_446])
			)
			(self sel_234:)
		)
	)

	(method (sel_57)
		(sel_42 sel_3: (self sel_233:))
		(if (self sel_448:)
			(self sel_234:)
		)
	)

	(method (sel_234)
		(= gDoMotionCue (= sel_232 1))
	)

	(method (sel_448)
		(return
			(<
				(Abs (AngleDiff (* sel_446 45) (sel_42 sel_55:)))
				(+ (/ 180 sel_447) 1)
			)
		)
	)

	(method (sel_233)
		(return
			(if
				(or
					(< (Abs (- gGameTime sel_158)) (sel_42 sel_236:))
					(self sel_448:)
				)
				(sel_42 sel_3:)
			else
				(= sel_158 gGameTime)
				(+= sel_446 (* sel_231 (/ 8 sel_447)))
				(= sel_446 (umod sel_446 8))
				[trans2 sel_446]
			)
		)
	)
)

