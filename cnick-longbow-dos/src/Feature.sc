;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 950)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class CueObj of Script
	(properties
		sel_20 {CueObj}
		sel_290 0
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(1
				(gEgo
					sel_245:
						(GetAngle
							(gEgo sel_1:)
							(gEgo sel_0:)
							(sel_42 sel_1:)
							(sel_42 sel_0:)
						)
						self
				)
				(gTheDoits sel_118: self)
			)
			(2
				(= sel_136 3)
			)
			(3
				(gTheDoits sel_81: self)
				(if
					(not
						(and
							sel_42
							(IsObject (sel_42 sel_291:))
							((sel_42 sel_291:) sel_292: sel_290)
						)
					)
					(sel_42 sel_292: sel_290)
				)
				(= sel_29 0)
			)
		)
	)
)

(class Feature of Obj
	(properties
		sel_20 {Feature}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_204 0
		sel_205 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_293 26505
		sel_291 0
		sel_294 26505
		sel_295 0
		sel_296 0
		sel_297 0
		sel_298 0
	)

	(method (sel_110 param1)
		(cond
			((and argc param1)
				(self sel_96: param1)
			)
			(gFtrInitializer
				(self sel_96: gFtrInitializer)
			)
		)
		(if (self sel_116: 5)
			(gCast sel_118: self)
		else
			(gFeatures sel_118: self)
		)
	)

	(method (sel_302 param1 &tmp temp0 temp1)
		(if (and argc global66)
			(for ((= temp0 (= sel_298 0))) (< temp0 argc) ((++ temp0))
				(= temp1 (global66 sel_57: [param1 temp0]))
				(self sel_298: (| (self sel_298:) temp1))
			)
		)
	)

	(method (sel_133 param1 &tmp temp0)
		(cond
			((param1 sel_73:)
				(return 1)
			)
			(
				(and
					(& (param1 sel_31:) $4000)
					(self sel_209: param1)
					(self sel_301:)
				)
				(CueObj
					sel_29: 0
					sel_136: 0
					sel_42: self
					sel_290: (param1 sel_37:)
				)
				(param1 sel_73: 1)
				(if
					(and
						(gUser sel_229:)
						(>
							(GetDistance
								(gEgo sel_1:)
								(gEgo sel_0:)
								sel_295
								sel_296
							)
							sel_297
						)
						global66
						(& sel_298 (global66 sel_57: (param1 sel_37:)))
					)
					(gEgo
						sel_303:
							PolyPath
							sel_295
							(+ (gEgo sel_82:) sel_296)
							CueObj
					)
				else
					(gEgo sel_303: 0)
					(CueObj sel_144: 3)
				)
			)
		)
		(return (param1 sel_73:))
	)

	(method (sel_299 &tmp temp0)
		(gEgo sel_303: 0)
		(CueObj sel_42: self sel_29: 0 sel_136: 0 sel_145:)
	)

	(method (sel_292 param1 &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (not sel_205)
			(= sel_205 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET sel_205 sel_204 param1 0 1))
			(gMessager sel_287: sel_204 param1 0 0 0 sel_205)
		else
			(temp0 sel_57: param1 self)
		)
	)

	(method (sel_300 param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else gEgo))
		(if
			(>
				(= temp1
					(Abs
						(-
							(GetAngle (temp0 sel_1:) (temp0 sel_0:) sel_1 sel_0)
							(temp0 sel_55:)
						)
					)
				)
				180
			)
			(= temp1 (- 360 temp1))
		)
		(if (<= temp1 sel_293)
			(return 1)
		else
			(self sel_299:)
			(return 0)
		)
	)

	(method (sel_301)
		(return 1)
	)

	(method (sel_209 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((IsObject sel_294)
					(AvoidPath temp0 temp1 sel_294)
				)
				(
					(or
						(not (or sel_7 sel_9 sel_6 sel_8))
						(and (<= sel_7 temp0 sel_9) (<= sel_6 temp1 sel_8))
					)
					(if (!= sel_294 26505)
						(& sel_294 (OnControl CONTROL temp0 temp1))
					else
						1
					)
				)
			)
		)
	)

	(method (sel_111)
		(if sel_291
			(sel_291 sel_111:)
			(= sel_291 0)
		)
		(if (IsObject sel_294)
			(sel_294 sel_111:)
			(= sel_294 0)
		)
		(gFeatures sel_81: self)
		(super sel_111:)
	)
)

(instance dftDoVerb of Code
	(properties
		sel_20 {dftDoVerb}
	)

	(method (sel_57)
		(return 1)
	)
)

