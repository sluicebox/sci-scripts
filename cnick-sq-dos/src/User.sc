;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(instance uEvt of Event
	(properties
		sel_20 {uEvt}
	)
)

(class User of Obj
	(properties
		sel_20 {User}
		sel_333 0
		sel_334 0
		sel_335 0
		sel_336 0
		sel_1 -1
		sel_0 -1
		sel_337 1
		sel_338 0
	)

	(method (sel_110)
		(= sel_338 uEvt)
	)

	(method (sel_339 param1)
		(if argc
			(= sel_334 param1)
		)
		(return sel_334)
	)

	(method (sel_57)
		(sel_338
			sel_31: 0
			sel_37: 0
			sel_61: 0
			sel_0: 0
			sel_1: 0
			sel_73: 0
			sel_147: 0
		)
		(GetEvent 32767 sel_338)
		(self sel_133: sel_338)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2 temp3)
		(= gMouseX (param1 sel_1:))
		(= gMouseY (param1 sel_0:))
		(= temp0 (param1 sel_31:))
		(= temp2 (param1 sel_61:))
		(if temp0
			(= gLastEvent param1)
			(if sel_337
				(MapKeyToDir param1)
			)
			(if (== temp0 256)
				(= temp0 4)
				(= temp1 (if (& temp2 $0003) 27 else 13))
				(= temp2 0)
				(param1 sel_31: temp0 sel_37: temp1 sel_61: 0)
			)
			(if (and gPrints (gPrints sel_133: param1))
				(return 1)
			)
			(param1 sel_148:)
			(= temp0 (param1 sel_31:))
			(= temp1 (param1 sel_37:))
			(cond
				((& temp0 $0040)
					(cond
						((and gDirectionHandler (gDirectionHandler sel_133: param1))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar sel_214:)
											(gTheIconBar sel_220:)
										)
									)
									(not gTheIconBar)
								)
								sel_333
								sel_335
								(gCast sel_122: sel_333)
								(sel_333 sel_133: param1)
							)
							(return 1)
						)
						(
							(and
								gPMouse
								sel_334
								(!= temp1 0)
								(gPMouse sel_133: param1)
							)
							(return 1)
						)
					)
				)
				((and (& temp0 $0004) gKeyDownHandler (gKeyDownHandler sel_133: param1))
					(return 1)
				)
				((and (& temp0 $0003) gMouseDownHandler (gMouseDownHandler sel_133: param1))
					(return 1)
				)
			)
		)
		(if gTheIconBar
			(gTheIconBar sel_133: param1)
		)
		(= temp0 (param1 sel_31:))
		(= temp1 (param1 sel_37:))
		(if (and sel_334 (& temp0 $4000))
			(cond
				((and (& temp0 $1000) gWalkHandler (gWalkHandler sel_133: param1))
					(return 1)
				)
				(
					(and
						(& temp0 $1000)
						(gCast sel_122: sel_333)
						sel_335
						(sel_333 sel_133: param1)
					)
					(return 1)
				)
				(gUseSortedFeatures
					(OnMeAndLowY sel_110:)
					(gCast sel_119: 96 OnMeAndLowY param1)
					(gFeatures sel_119: 96 OnMeAndLowY param1)
					(if
						(and
							(OnMeAndLowY sel_340:)
							((OnMeAndLowY sel_340:) sel_133: param1)
						)
						(return 1)
					)
				)
				((gCast sel_133: param1)
					(return 1)
				)
				((gFeatures sel_133: param1)
					(return 1)
				)
			)
			(if (and (not (param1 sel_73:)) (gRegions sel_133: param1))
				(return 1)
			)
		)
		(if temp0
			(cond
				((gGame sel_133: param1)
					(return 1)
				)
				((and gPrints (gPrints sel_133: param1))
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sel_229 param1)
		(if argc
			(= sel_335 param1)
			(= sel_336 0)
		)
		(return sel_335)
	)
)

(class Ego of Actor
	(properties
		sel_20 {Ego}
		sel_14 8192
		sel_341 0
	)

	(method (sel_110)
		(super sel_110:)
		(if (not sel_237)
			(self sel_162: Walk)
		)
	)

	(method (sel_57)
		(super sel_57:)
		(= sel_341
			(cond
				((<= sel_1 0) 4)
				((>= sel_1 319) 2)
				((>= sel_0 189) 3)
				((<= sel_0 (gCurRoom sel_332:)) 1)
				(else 0)
			)
		)
	)

	(method (sel_342 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory sel_64: [param1 temp0]) sel_183: self)
		)
	)

	(method (sel_343 param1 param2 &tmp temp0)
		(if (self sel_230: param1)
			((= temp0 (gInventory sel_64: param1))
				sel_183: (if (== argc 1) -1 else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar sel_217:) temp0))
				(gTheIconBar
					sel_214: (gTheIconBar sel_64: 0)
					sel_217: 0
					sel_225: ((gTheIconBar sel_218:) sel_33: 999 sel_117:)
				)
			)
		)
	)

	(method (sel_230 param1 &tmp temp0)
		(if (= temp0 (gInventory sel_64: param1))
			(temp0 sel_345: self)
		)
	)

	(method (sel_344 param1)
		(if argc
			(= sel_53 (= sel_236 param1))
		)
		(return sel_53)
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 sel_31:))
		(= temp2 (param1 sel_37:))
		(cond
			((and sel_142 (sel_142 sel_133: param1)) 1)
			((& temp1 $0040)
				(if (and (== (= temp0 temp2) 0) (& temp1 $0004))
					(param1 sel_73:)
					(return)
				)
				(if
					(and
						(& temp1 $0004)
						(== temp0 (gUser sel_336:))
						(IsObject sel_56)
					)
					(= temp0 0)
				)
				(gUser sel_336: temp0)
				(self sel_331: temp0)
				(param1 sel_73: 1)
			)
			((& temp1 $4000)
				(if (& temp1 $1000)
					(switch gUseObstacles
						(0
							(self
								sel_303:
									MoveTo
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
							)
						)
						(1
							(self
								sel_303:
									Unknown_Class_37
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
							)
						)
						(2
							(self
								sel_303:
									Unknown_Class_37
									(param1 sel_1:)
									(+ (param1 sel_0:) sel_82)
									0
									0
							)
						)
					)
					(gUser sel_336: 0)
					(param1 sel_73: 1)
				else
					(super sel_133: param1)
				)
			)
			(else
				(super sel_133: param1)
			)
		)
		(param1 sel_73:)
	)
)

(class OnMeAndLowY of Code
	(properties
		sel_20 {OnMeAndLowY}
		sel_340 0
		sel_346 -1
	)

	(method (sel_110)
		(= sel_340 0)
		(= sel_346 -1)
	)

	(method (sel_57 param1 param2)
		(if (and (param1 sel_209: param2) (> (param1 sel_0:) sel_346))
			(= sel_340 param1)
			(= sel_346 (sel_340 sel_0:))
		)
	)
)

