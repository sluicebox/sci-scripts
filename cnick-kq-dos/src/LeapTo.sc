;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Motion)

(class LeapTo of MoveTo
	(properties
		sel_20 {LeapTo}
		sel_82 0
		sel_464 0
		sel_465 0
		sel_466 64
	)

	(method (sel_110 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
		(= temp0 (Abs (/ (- (param1 sel_1:) param2) (param1 sel_51:))))
		(if
			(>
				(= temp1 (Abs (/ (- (param1 sel_0:) param3) (param1 sel_52:))))
				temp0
			)
			(= temp0 temp1)
		)
		(++ temp0)
		(if (<= argc 4)
			(super sel_110: param1 param2 param3)
		else
			(super sel_110: param1 param2 param3 param5)
			(if (>= argc 6)
				(= sel_466 param6)
			)
		)
		(if (>= argc 3)
			(= sel_82 param4)
		)
		(= sel_465 (/ sel_466 2))
		(= sel_464
			(+
				(* temp0 sel_465)
				(- (/ (* 256 (- sel_82 (param1 sel_82:))) temp0) sel_465)
			)
		)
	)

	(method (sel_57)
		(if (>= (Abs (- gGameTime sel_45)) (sel_42 sel_53:))
			(= sel_45 gGameTime)
			(DoBresen self)
			(if sel_219
				(sel_42 sel_82: sel_82)
			else
				(+= sel_465 sel_464)
				(sel_42 sel_82: (+ (sel_42 sel_82:) (/ sel_465 256)))
				(if (>= sel_465 0)
					(&= sel_465 $00ff)
				else
					(|= sel_465 $ff00)
				)
				(-= sel_464 sel_466)
			)
		)
	)
)

