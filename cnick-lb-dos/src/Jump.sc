;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 991)
(include sci.sh)
(use Main)
(use Motion)

(class Jump of Motion
	(properties
		sel_20 {Jump}
		sel_1 20000
		sel_0 20000
		sel_260 0
		sel_261 3
		sel_51 20000
		sel_52 0
		sel_14 0
		sel_15 0
		sel_262 1
		sel_263 1
	)

	(method (sel_110 param1 param2 &tmp temp0)
		(= sel_42 param1)
		(if (== argc 2)
			(= sel_142 param2)
		)
		(= sel_15 (sel_42 sel_15:))
		(= sel_14 (sel_42 sel_14:))
		(sel_42 sel_15: 0 sel_63:)
		(if (== sel_51 20000)
			(= sel_51
				(cond
					(
						(or
							(> (= temp0 (sel_42 sel_55:)) 330)
							(< temp0 30)
							(< 150 temp0 210)
						)
						0
					)
					((< temp0 180)
						(sel_42 sel_51:)
					)
					(else
						(- (sel_42 sel_51:))
					)
				)
			)
		)
		(if (not (and sel_262 (< (* sel_51 sel_260) 0)))
			(= sel_262 0)
		)
		(if (not (and sel_263 (< (* sel_52 sel_261) 0)))
			(= sel_263 0)
		)
		(self sel_264:)
	)

	(method (sel_57 &tmp temp0 temp1)
		(= sel_228 (sel_42 sel_1:))
		(= sel_229 (sel_42 sel_0:))
		(sel_42 sel_1: (+ sel_228 sel_51) sel_0: (+ sel_229 sel_52))
		(= temp0 sel_51)
		(= temp1 sel_52)
		(+= sel_51 sel_260)
		(+= sel_52 sel_261)
		(if
			(and
				(not sel_262)
				(!= sel_1 20000)
				(<= 0 (* sel_43 (- (sel_42 sel_1:) sel_1)))
			)
			(sel_42 sel_1: sel_1)
			(self sel_97:)
			(return)
		)
		(if
			(and
				(not sel_263)
				(!= sel_0 20000)
				(<= 0 (* sel_44 (- (sel_42 sel_0:) sel_0)))
			)
			(sel_42 sel_0: sel_0)
			(self sel_97:)
			(return)
		)
		(if (<= (* temp0 sel_51) 0)
			(= sel_262 0)
			(self sel_264:)
		)
		(if (<= (* temp1 sel_52) 0)
			(= sel_263 0)
			(self sel_264:)
		)
	)

	(method (sel_97)
		(sel_42 sel_15: sel_15 sel_14: sel_14)
		(if sel_142
			(= gDoMotionCue 1)
			(= sel_219 1)
		)
	)

	(method (sel_264)
		(= sel_43
			(if
				(or
					(> (sel_42 sel_1:) sel_1)
					(and (== (sel_42 sel_1:) sel_1) (> sel_51 0))
				)
				-1
			else
				1
			)
		)
		(= sel_44
			(if
				(or
					(> (sel_42 sel_0:) sel_0)
					(and (== (sel_42 sel_0:) sel_0) (> sel_52 0))
				)
				-1
			else
				1
			)
		)
	)

	(method (sel_222)
		(sel_42 sel_56: 0)
		(if (and sel_219 (IsObject sel_142))
			(sel_142 sel_144:)
		)
		(self sel_111:)
	)
)

(class JumpTo of Jump
	(properties
		sel_20 {JumpTo}
	)

	(method (sel_110 param1 param2 param3 param4 &tmp temp0 temp1 [temp2 52])
		(= sel_42 param1)
		(= sel_1 param2)
		(= sel_0 param3)
		(if (and (== sel_1 (param1 sel_1:)) (== sel_0 (param1 sel_0:)))
			(= sel_15 (sel_42 sel_15:))
			(= sel_14 (sel_42 sel_14:))
			(self sel_97:)
			(return)
		)
		(= temp0 (- sel_1 (param1 sel_1:)))
		(= temp1 (- sel_0 (param1 sel_0:)))
		(SetJump self temp0 temp1 sel_261)
		(if (not temp0)
			(= sel_1 20000)
		)
		(if (not temp1)
			(= sel_0 20000)
		)
		(switch argc
			(3
				(super sel_110: param1)
			)
			(4
				(super sel_110: param1 param4)
			)
		)
	)

	(method (sel_97)
		(if (!= sel_1 20000)
			(sel_42 sel_1: sel_1)
		)
		(if (!= sel_0 20000)
			(sel_42 sel_0: sel_0)
		)
		(super sel_97:)
	)
)

