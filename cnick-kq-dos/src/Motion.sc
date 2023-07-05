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
		sel_142 0
		sel_218 1
		sel_149 0
		sel_219 0
	)

	(method (sel_110 param1)
		(if argc
			(= sel_42 param1)
		)
		(= sel_149 (- (- gGameTime (sel_42 sel_223:)) 1))
		(= sel_219 0)
	)

	(method (sel_220)
		(return
			(if (< (Abs (- gGameTime sel_149)) (sel_42 sel_223:))
				(sel_42 sel_4:)
			else
				(= sel_149 gGameTime)
				(if (& (sel_42 sel_14:) $1000)
					(sel_42 sel_4:)
				else
					(+ (sel_42 sel_4:) sel_218)
				)
			)
		)
	)

	(method (sel_221))

	(method (sel_222)
		(sel_42 sel_224: 0)
		(if (and sel_219 (IsObject sel_142))
			(sel_142 sel_144:)
		)
		(self sel_111:)
	)
)

(class Fwd of Cycle
	(properties
		sel_20 {Fwd}
	)

	(method (sel_57 &tmp temp0)
		(if (> (= temp0 (self sel_220:)) (sel_42 sel_225:))
			(self sel_221:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_221)
		(sel_42 sel_4: 0)
	)
)

(class Walk of Fwd
	(properties
		sel_20 {Walk}
	)

	(method (sel_57 &tmp temp0)
		(if (not (sel_42 sel_226:))
			(super sel_57:)
		)
	)
)

(class CT of Cycle
	(properties
		sel_20 {CT}
		sel_227 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp temp0)
		(super sel_110: param1)
		(= sel_218 param3)
		(if (== argc 4)
			(= sel_142 param4)
		)
		(= temp0 (sel_42 sel_225:))
		(= sel_227 (if (> param2 temp0) temp0 else param2))
	)

	(method (sel_57 &tmp temp0 temp1)
		(= temp1 (sel_42 sel_225:))
		(if (> sel_227 temp1)
			(= sel_227 temp1)
		)
		(= temp0 (self sel_220:))
		(sel_42
			sel_4:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== gGameTime sel_149) (== sel_227 (sel_42 sel_4:)))
			(self sel_221:)
		)
	)

	(method (sel_221)
		(= sel_219 1)
		(if sel_142
			(= gDoMotionCue 1)
		else
			(self sel_222:)
		)
	)
)

(class End of CT
	(properties
		sel_20 {End}
	)

	(method (sel_110 param1 param2)
		(super
			sel_110: param1 (param1 sel_225:) 1 (if (== argc 2) param2 else 0)
		)
	)
)

(class Motion of Obj
	(properties
		sel_20 {Motion}
		sel_42 0
		sel_142 0
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
		sel_219 0
		sel_228 0
		sel_229 0
	)

	(method (sel_110 param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(= sel_1 param2)
				(if (>= argc 3)
					(= sel_0 param3)
					(if (>= argc 4)
						(= sel_142 param4)
					)
				)
			)
		)
		(= sel_229 (= sel_228 (= sel_219 0)))
		(= sel_45 (+ 1 (sel_42 sel_53:) gGameTime))
		(if (= temp3 (sel_42 sel_224:))
			(temp3 sel_149: sel_45)
		)
		(if
			(GetDistance
				(= temp2 (sel_42 sel_1:))
				(= temp3 (sel_42 sel_0:))
				sel_1
				sel_0
			)
			(sel_42 sel_232: (GetAngle temp2 temp3 sel_1 sel_0))
		)
		(InitBresen self)
	)

	(method (sel_231)
		(return (and (== (sel_42 sel_1:) sel_1) (== (sel_42 sel_0:) sel_0)))
	)

	(method (sel_230 param1 param2)
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
		(= sel_219 1)
		(if sel_142
			(= gDoMotionCue 1)
		else
			(self sel_222:)
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

(class MoveTo of Motion
	(properties
		sel_20 {MoveTo}
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_231)
		(return
			(and
				(<= (Abs (- (sel_42 sel_1:) sel_1)) (sel_42 sel_51:))
				(<= (Abs (- (sel_42 sel_0:) sel_0)) (sel_42 sel_52:))
			)
		)
	)
)

