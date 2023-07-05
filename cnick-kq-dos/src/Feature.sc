;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use System)

(class CueObj of Script
	(properties
		sel_20 {CueObj}
		sel_265 0
		sel_266 0
	)

	(method (sel_143))
)

(class Feature of Obj
	(properties
		sel_20 {Feature}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_267 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_268 0
		sel_269 26505
		sel_270 0
		sel_271 26505
		sel_272 0
		sel_273 0
		sel_274 0
		sel_275 26505
		sel_276 0
	)

	(method (sel_110)
		(if (self sel_116: 5)
			(gCast sel_118: self)
		else
			(gFeatures sel_118: self)
		)
	)

	(method (sel_281 &tmp temp0))

	(method (sel_132 param1 &tmp temp0)
		(param1 sel_73:)
	)

	(method (sel_278 &tmp temp0))

	(method (sel_277))

	(method (sel_279 &tmp [temp0 2]))

	(method (sel_280)
		(return 1)
	)

	(method (sel_200 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((IsObject sel_271)
					(AvoidPath temp0 temp1 sel_271)
				)
				(
					(or
						(not (or sel_7 sel_9 sel_6 sel_8))
						(and (<= sel_7 temp0 sel_9) (<= sel_6 temp1 sel_8))
					)
					(if (!= sel_271 26505)
						(& sel_271 (OnControl CONTROL temp0 temp1))
					else
						1
					)
				)
			)
		)
	)

	(method (sel_111)
		(if sel_270
			(sel_270 sel_111:)
			(= sel_270 0)
		)
		(if (IsObject sel_271)
			(sel_271 sel_111:)
			(= sel_271 0)
		)
		(gFeatures sel_81: self)
		(super sel_111:)
	)
)

