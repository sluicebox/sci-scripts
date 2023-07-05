;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use System)

(class Cycle of Obj
	(properties
		sel_20 {Cycle}
		sel_42 0
		sel_143 0
		sel_231 1
		sel_158 0
		sel_232 0
	)

	(method (sel_110 param1)
		(if argc
			(= sel_42 param1)
		)
		(= sel_158 (- (- gGameTime (sel_42 sel_236:)) 1))
		(= sel_232 0)
	)

	(method (sel_233)
		(return
			(if (< (Abs (- gGameTime sel_158)) (sel_42 sel_236:))
				(sel_42 sel_4:)
			else
				(= sel_158 gGameTime)
				(+ (sel_42 sel_4:) sel_231)
			)
		)
	)

	(method (sel_234))

	(method (sel_235)
		(sel_42 sel_237: 0)
		(if (and sel_232 (IsObject sel_143))
			(sel_143 sel_145:)
		)
		(self sel_111:)
	)
)

(class Fwd of Cycle
	(properties
		sel_20 {Fwd}
	)

	(method (sel_57 &tmp temp0)
		(if (> (= temp0 (self sel_233:)) (sel_42 sel_238:))
			(self sel_234:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_234)
		(sel_42 sel_4: 0)
	)
)

(class Walk of Fwd
	(properties
		sel_20 {Walk}
	)

	(method (sel_57 &tmp temp0)
		(if (not (sel_42 sel_239:))
			(super sel_57:)
		)
	)
)

(class CT of Cycle
	(properties
		sel_20 {CT}
		sel_240 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp temp0)
		(super sel_110: param1)
		(= sel_231 param3)
		(if (== argc 4)
			(= sel_143 param4)
		)
		(= temp0 (sel_42 sel_238:))
		(= sel_240 (if (> param2 temp0) temp0 else param2))
	)

	(method (sel_57 &tmp temp0 temp1)
		(= temp1 (sel_42 sel_238:))
		(if (> sel_240 temp1)
			(= sel_240 temp1)
		)
		(= temp0 (self sel_233:))
		(sel_42
			sel_4:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== gGameTime sel_158) (== sel_240 (sel_42 sel_4:)))
			(self sel_234:)
		)
	)

	(method (sel_234)
		(= sel_232 1)
		(if sel_143
			(= gDoMotionCue 1)
		else
			(self sel_235:)
		)
	)
)

(class End of CT
	(properties
		sel_20 {End}
	)

	(method (sel_110 param1 param2)
		(super
			sel_110: param1 (param1 sel_238:) 1 (if (== argc 2) param2 else 0)
		)
	)
)

(class Beg of CT
	(properties
		sel_20 {Beg}
	)

	(method (sel_110 param1 param2)
		(super sel_110: param1 0 -1 (if (== argc 2) param2 else 0))
	)
)

(class SyncWalk of Fwd
	(properties
		sel_20 {SyncWalk}
		sel_241 0
		sel_242 0
	)

	(method (sel_57 &tmp temp0)
		(if
			(and
				(IsObject (= temp0 (sel_42 sel_56:)))
				(or (!= (sel_42 sel_1:) sel_241) (!= (sel_42 sel_0:) sel_242))
			)
			(= sel_241 (sel_42 sel_1:))
			(= sel_242 (sel_42 sel_0:))
			(super sel_57:)
		)
	)

	(method (sel_233)
		(= sel_158 (+ gGameTime (sel_42 sel_236:)))
		(super sel_233:)
	)
)

(class Motion of Obj
	(properties
		sel_20 {Motion}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_232 0
		sel_241 0
		sel_242 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(= sel_1 param2)
				(if (>= argc 3)
					(= sel_0 param3)
					(if (>= argc 4)
						(= sel_143 param4)
					)
				)
			)
		)
		(= sel_242 (= sel_241 (= sel_232 0)))
		(= sel_45 (+ 1 (sel_42 sel_53:) gGameTime))
		(if (= temp3 (sel_42 sel_237:))
			(temp3 sel_158: sel_45)
		)
		(if
			(GetDistance
				(= temp2 (sel_42 sel_1:))
				(= temp3 (sel_42 sel_0:))
				sel_1
				sel_0
			)
			(sel_42 sel_245: (GetAngle temp2 temp3 sel_1 sel_0))
		)
		(InitBresen self)
	)

	(method (sel_244)
		(return (and (== (sel_42 sel_1:) sel_1) (== (sel_42 sel_0:) sel_0)))
	)

	(method (sel_243 param1 param2)
		(if argc
			(= sel_1 param1)
			(= sel_0 param2)
		)
	)

	(method (sel_57 &tmp [temp0 6])
		(if (>= (Abs (- gGameTime sel_45)) (sel_42 sel_53:))
			(= sel_45 gGameTime)
			(DoBresen self)
		)
	)

	(method (sel_97)
		(= sel_232 1)
		(if sel_143
			(= gDoMotionCue 1)
		else
			(self sel_235:)
		)
	)

	(method (sel_235)
		(sel_42 sel_56: 0)
		(if (and sel_232 (IsObject sel_143))
			(sel_143 sel_145:)
		)
		(self sel_111:)
	)
)

(class MoveTo of Motion
	(properties
		sel_20 {MoveTo}
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_244)
		(return
			(and
				(<= (Abs (- (sel_42 sel_1:) sel_1)) (sel_42 sel_51:))
				(<= (Abs (- (sel_42 sel_0:) sel_0)) (sel_42 sel_52:))
			)
		)
	)
)

