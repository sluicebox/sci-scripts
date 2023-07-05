;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Motion)
(use System)

(class PicView of Feature
	(properties
		sel_20 {PicView}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_60 -1
		sel_14 0
		sel_88 0
	)

	(method (sel_113)
		(Print sel_20 79 sel_2 sel_3 sel_4)
	)

	(method (sel_110)
		(gAddToPics sel_118: self)
		(SetNowSeen self)
		(super sel_110: &rest)
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
				((& sel_14 $0080) 0)
				((and (not (IsObject sel_294)) (& sel_14 $1000))
					(if
						(or
							(not (or sel_7 sel_9 sel_6 sel_8))
							(and (<= sel_7 temp0 sel_9) (<= sel_6 temp1 sel_8))
						)
						(not
							(IsItSkip
								sel_2
								sel_3
								sel_4
								(- temp1 sel_6)
								(- temp0 sel_7)
							)
						)
					)
				)
				(else
					(super sel_209: temp0 temp1)
				)
			)
		)
	)
)

(class View of Feature
	(properties
		sel_20 {View}
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 257
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
	)

	(method (sel_110 param1)
		(&= sel_14 $7fff)
		(if (not (gCast sel_122: self))
			(= sel_13 (= sel_12 (= sel_11 (= sel_10 0))))
			(&= sel_14 $ff77)
		)
		(BaseSetter self)
		(super sel_110: &rest)
		(self sel_310:)
	)

	(method (sel_153 param1 param2 param3)
		(if (>= argc 1)
			(= sel_1 param1)
			(if (>= argc 2)
				(= sel_0 param2)
				(if (>= argc 3)
					(= sel_82 param3)
				)
			)
		)
		(BaseSetter self)
		(self sel_305:)
	)

	(method (sel_111)
		(self sel_306: sel_102:)
		(|= sel_14 $8000)
	)

	(method (sel_102)
		(|= sel_14 $0008)
	)

	(method (sel_207)
		(&= sel_14 $fff7)
	)

	(method (sel_81)
		(if (& sel_14 $8000)
			(&= sel_14 $7fff)
			(gCast sel_81: self)
			(if sel_5
				(UnLoad 133 sel_5)
				(= sel_5 0)
			)
			(if (& sel_14 $0020)
				(gAddToPics
					sel_118:
						((PicView sel_109:)
							sel_2: sel_2
							sel_3: sel_3
							sel_4: sel_4
							sel_1: sel_1
							sel_0: sel_0
							sel_82: sel_82
							sel_60: sel_60
							sel_14: sel_14
							sel_117:
						)
				)
				(gFeatures sel_118: self)
			else
				(super sel_111:)
			)
			(if (IsObject sel_291)
				(sel_291 sel_111:)
			)
			(= sel_291 0)
		)
	)

	(method (sel_304)
		(|= sel_14 $0001)
		(&= sel_14 $fffd)
	)

	(method (sel_305)
		(|= sel_14 $0040)
	)

	(method (sel_306)
		(|= sel_14 $0002)
		(&= sel_14 $fffe)
	)

	(method (sel_63 param1)
		(cond
			((== argc 0)
				(|= sel_14 $0010)
			)
			((== param1 -1)
				(&= sel_14 $ffef)
			)
			(else
				(= sel_60 param1)
				(|= sel_14 $0010)
			)
		)
		(self sel_305:)
	)

	(method (sel_155 param1)
		(cond
			((== argc 0)
				(|= sel_14 $0800)
			)
			((== param1 -1)
				(&= sel_14 $f7ff)
			)
			(else
				(= sel_3 param1)
				(|= sel_14 $0800)
			)
		)
		(self sel_305:)
	)

	(method (sel_156 param1)
		(cond
			((== argc 0) 0)
			((== param1 -1) 0)
			(else
				(= sel_4
					(if (>= param1 (self sel_238:))
						(self sel_238:)
					else
						param1
					)
				)
			)
		)
		(self sel_305:)
	)

	(method (sel_307 param1)
		(if (or (== 0 argc) param1)
			(|= sel_14 $4000)
		else
			(&= sel_14 $bfff)
		)
	)

	(method (sel_308)
		(if (not (gCast sel_122: self))
			(self sel_110:)
		)
		(self sel_14: (| sel_14 $8021))
	)

	(method (sel_238)
		(return (- (NumCels self) 1))
	)

	(method (sel_113)
		(Print sel_20 79 sel_2 sel_3 sel_4)
	)

	(method (sel_309 param1 &tmp temp0)
		(= temp0 (& sel_14 $0200))
		(if argc
			(if param1
				(|= sel_14 $0200)
			else
				(&= sel_14 $fdff)
			)
		)
		(return temp0)
	)

	(method (sel_235))

	(method (sel_310))

	(method (sel_301)
		(return (not (& sel_14 $0088)))
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
				((& sel_14 $0080) 0)
				((and (not (IsObject sel_294)) (& sel_14 $1000))
					(if
						(or
							(not (or sel_7 sel_9 sel_6 sel_8))
							(and (<= sel_7 temp0 sel_9) (<= sel_6 temp1 sel_8))
						)
						(not
							(IsItSkip
								sel_2
								sel_3
								sel_4
								(- temp1 sel_6)
								(- temp0 sel_7)
							)
						)
					)
				)
				(else
					(super sel_209: temp0 temp1)
				)
			)
		)
	)

	(method (sel_311 param1 &tmp temp0 temp1 temp2)
		(switch param1
			(0
				(&= sel_103 $fffd)
				(= sel_106 0)
			)
			(-1
				(&= sel_103 $fffc)
				(= sel_106 0)
			)
			(else
				(= temp0 (- param1 (gCurRoom sel_108:)))
				(= temp2 (+ (/ (* (= temp1 (- 190 param1)) 100) temp0) 100))
				(|= sel_103 $0003)
				(= sel_106 (/ (* temp2 128) 100))
			)
		)
	)
)

(class Prop of View
	(properties
		sel_20 {Prop}
		sel_14 0
		sel_236 6
		sel_142 0
		sel_237 0
		sel_135 0
		sel_312 0
		sel_313 0
	)

	(method (sel_57 &tmp temp0)
		(SetNowSeen self sel_6)
		(if (& sel_14 $8000)
			(return)
		)
		(if sel_142
			(sel_142 sel_57:)
		)
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_237
			(sel_237 sel_57:)
		)
		(if sel_313
			(sel_313 sel_57:)
		)
	)

	(method (sel_133 param1)
		(if sel_142
			(sel_142 sel_133: param1)
		)
		(super sel_133: param1)
	)

	(method (sel_162 param1)
		(if sel_237
			(sel_237 sel_111:)
		)
		(if param1
			(self sel_306:)
			(= sel_237
				(if (& (param1 sel_4103:) $8000)
					(param1 sel_109:)
				else
					param1
				)
			)
			(sel_237 sel_110: self &rest)
		else
			(= sel_237 0)
		)
	)

	(method (sel_81)
		(if (& sel_14 $8000)
			(self sel_146: 0 sel_162: 0)
			(if sel_135
				(sel_135 sel_111:)
			)
			(super sel_81:)
		)
	)

	(method (sel_145)
		(if sel_142
			(sel_142 sel_145:)
		)
	)

	(method (sel_146 param1)
		(if (IsObject sel_142)
			(sel_142 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_235)
		(if (and sel_237 (sel_237 sel_232:))
			(sel_237 sel_235:)
		)
	)

	(method (sel_310 param1)
		(cond
			((not sel_312))
			(
				(<
					(if argc
						param1
					else
						(gGame sel_312:)
					)
					sel_312
				)
				(self sel_304:)
			)
			(sel_237
				(self sel_306:)
			)
		)
	)

	(method (sel_311 param1)
		(if (and argc (IsObject param1))
			(if sel_313
				(sel_313 sel_111:)
			)
			(&= sel_103 $fffd)
			(= sel_313 param1)
			(sel_313 sel_110: self)
		else
			(super sel_311: param1)
		)
	)
)

(class Actor of Prop
	(properties
		sel_20 {Actor}
		sel_15 -32768
		sel_241 0
		sel_242 0
		sel_51 3
		sel_314 3
		sel_315 2
		sel_53 6
		sel_316 0
		sel_317 0
		sel_56 0
		sel_59 0
		sel_318 0
		sel_319 0
		sel_320 0
	)

	(method (sel_110)
		(super sel_110: &rest)
		(= sel_241 sel_1)
		(= sel_242 sel_0)
	)

	(method (sel_57 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(if (& sel_14 $8000)
			(return)
		)
		(if sel_142
			(sel_142 sel_57:)
		)
		(if sel_320
			(sel_320 sel_57: self)
		)
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_318
			(sel_318 sel_57: self)
		)
		(if sel_313
			(sel_313 sel_57:)
		)
		(cond
			(sel_319
				(sel_319 sel_57:)
			)
			(sel_56
				(sel_56 sel_57:)
				(if (& sel_103 $0001)
					(= temp3 (/ (* sel_314 sel_104) 128))
					(= temp4 (/ (* sel_315 sel_105) 128))
					(if (or (!= temp3 sel_51) (!= temp4 sel_52))
						(if (< temp3 1)
							(= temp3 1)
						)
						(if (< temp4 1)
							(= temp4 1)
						)
						(self sel_330: temp3 temp4)
					)
				)
			)
		)
		(if sel_237
			(= temp1 sel_17)
			(= temp2 sel_19)
			(sel_237 sel_57:)
			(if sel_317
				(sel_317 sel_57: self)
			else
				(BaseSetter self)
			)
			(if (and (or (!= temp1 sel_17) (!= temp2 sel_19)) (self sel_54:))
				(self sel_327:)
			)
		)
		(= sel_241 sel_1)
		(= sel_242 sel_0)
	)

	(method (sel_153 param1 param2)
		(super sel_153: param1 param2 &rest)
		(= sel_241 param1)
		(= sel_242 param2)
		(if (self sel_54:)
			(self sel_327:)
		)
	)

	(method (sel_303 param1)
		(if (and sel_56 (!= sel_56 -1))
			(sel_56 sel_111:)
		)
		(if param1
			(self sel_306:)
			(= sel_56
				(if (& (param1 sel_4103:) $8000)
					(param1 sel_109:)
				else
					param1
				)
			)
			(sel_56 sel_110: self &rest)
		else
			(= sel_56 0)
		)
	)

	(method (sel_321 param1)
		(if sel_319
			(sel_319 sel_111:)
		)
		(= sel_319
			(if (and (IsObject param1) (& (param1 sel_4103:) $8000))
				(param1 sel_109:)
			else
				param1
			)
		)
		(if sel_319
			(sel_319 sel_110: self &rest)
		)
	)

	(method (sel_239)
		(return
			(or
				(not (IsObject sel_56))
				(and (== sel_1 (sel_56 sel_241:)) (== sel_0 (sel_56 sel_242:)))
			)
		)
	)

	(method (sel_58)
		(return (& sel_14 $0400))
	)

	(method (sel_81)
		(if (& sel_14 $8000)
			(if (!= sel_56 -1)
				(self sel_303: 0)
			)
			(self sel_321: 0)
			(if sel_317
				(sel_317 sel_111:)
				(= sel_317 0)
			)
			(if sel_59
				(sel_59 sel_111:)
				(= sel_59 0)
			)
			(if sel_318
				(sel_318 sel_111:)
				(= sel_318 0)
			)
			(if sel_316
				(sel_316 sel_111:)
				(= sel_316 0)
			)
			(if sel_320
				(sel_320 sel_111:)
				(= sel_320 0)
			)
			(if (IsObject sel_291)
				(sel_291 sel_111:)
				(= sel_291 0)
			)
			(super sel_81:)
		)
	)

	(method (sel_322 param1)
		(if (or (not argc) param1)
			(|= sel_14 $2000)
		else
			(&= sel_14 $dfff)
		)
	)

	(method (sel_323 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(|= sel_15 [param1 temp0])
		)
	)

	(method (sel_324 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(&= sel_15 (~ [param1 temp0]))
		)
	)

	(method (sel_325)
		(if (not sel_316)
			(= sel_316 (Set sel_109:))
		)
		(sel_316 sel_118: &rest)
	)

	(method (sel_326)
		(sel_316 sel_81: &rest)
		(if (sel_316 sel_123:)
			(sel_316 sel_111:)
			(= sel_316 0)
		)
	)

	(method (sel_247 param1)
		(GetDistance sel_1 sel_0 (param1 sel_1:) (param1 sel_0:) gPerspective)
	)

	(method (sel_54 &tmp temp0)
		(if sel_317
			(sel_317 sel_57: self)
		else
			(BaseSetter self)
		)
		(= temp0
			(cond
				((CantBeHere self (gCast sel_24:)))
				(
					(and
						(not (& sel_14 $2000))
						(IsObject gCurRoom)
						(< sel_0 (gCurRoom sel_332:))
					)
					-1
				)
				((and sel_316 (not (sel_316 sel_121: 57 self))) -2)
			)
		)
	)

	(method (sel_327 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 sel_1)
		(= temp3 sel_0)
		(= temp4 0)
		(for ((= temp1 1)) (not temp4) ((++ temp1))
			(for ((= temp0 0)) (and (not temp4) (< temp0 8)) ((++ temp0))
				(= sel_1
					(+ temp2 (* temp1 (sign (CosMult (* temp0 45) 100))))
				)
				(= sel_0
					(- temp3 (* temp1 (sign (SinMult (* temp0 45) 100))))
				)
				(= temp4
					(if (not (self sel_54:))
						(self sel_329:)
					)
				)
			)
		)
		(self sel_153: sel_1 sel_0)
	)

	(method (sel_328 param1 param2 param3 param4)
		(return
			(and
				(<= param1 sel_1)
				(< sel_1 param3)
				(<= param2 sel_0)
				(< sel_0 param4)
			)
		)
	)

	(method (sel_329 param1)
		(if (and argc param1)
			(OnControl CONTROL sel_1 sel_0)
		else
			(OnControl CONTROL sel_17 sel_16 sel_19 sel_18)
		)
	)

	(method (sel_330 param1 param2)
		(if (and (>= argc 1) (!= param1 -1))
			(= sel_51 param1)
		)
		(if (and (>= argc 2) (!= param2 -1))
			(= sel_52 param2)
		)
		(if (and (IsObject sel_56) (sel_56 sel_115: MoveTo))
			(sel_56 sel_110:)
		)
	)

	(method (sel_331 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0
			(if (== (= temp1 (gCurRoom sel_108:)) -30000)
				sel_1
			else
				(gCurRoom sel_107:)
			)
		)
		(if (and (== sel_51 0) (== sel_52 0))
			(return)
		)
		(= temp5 (/ 32000 (Max sel_51 sel_52)))
		(switch param1
			(0
				(self sel_303: 0)
				(return)
			)
			(1
				(= temp2 (- temp0 sel_1))
				(= temp3 (- temp1 sel_0))
			)
			(5
				(= temp2 (- sel_1 temp0))
				(= temp3 (- sel_0 temp1))
			)
			(3
				(= temp2 temp5)
				(= temp3 0)
			)
			(7
				(= temp2 (- temp5))
				(= temp3 0)
			)
			(else
				(if (< 180 (= temp4 (GetAngle sel_1 sel_0 temp0 temp1)))
					(-= temp4 360)
				)
				(= temp4 (+ (/ (+ temp4 90) 2) (* 45 (- param1 2))))
				(= temp2 (SinMult temp4 100))
				(= temp3 (- (CosMult temp4 100)))
			)
		)
		(/= temp5 5)
		(while (and (< (Abs temp3) temp5) (< (Abs temp2) temp5))
			(*= temp2 5)
			(*= temp3 5)
		)
		(if (and (= temp7 (gCurRoom sel_251:)) gUseObstacles)
			(= temp6
				(AvoidPath
					sel_1
					sel_0
					(+ sel_1 temp2)
					(+ sel_0 temp3)
					(temp7 sel_24:)
					(temp7 sel_86:)
					0
				)
			)
			(= temp2 (- (WordAt temp6 2) sel_1))
			(= temp3 (- (WordAt temp6 3) sel_0))
			(Memory memFREE temp6)
		)
		(cond
			((or temp2 temp3)
				(self sel_303: MoveTo (+ sel_1 temp2) (+ sel_0 temp3))
			)
			(param1
				(self sel_303: 0 sel_245: (* (- param1 1) 45))
			)
			(else
				(self sel_303: 0)
			)
		)
	)

	(method (sel_235)
		(if (and sel_56 (sel_56 sel_232:))
			(sel_56 sel_235:)
		)
		(super sel_235:)
	)

	(method (sel_155 param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(super sel_155:)
						0
					)
					((not (IsObject param1))
						(super sel_155: param1 &rest)
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

	(method (sel_310 param1)
		(cond
			((not sel_312))
			(
				(<
					(if argc
						param1
					else
						(gGame sel_312:)
					)
					sel_312
				)
				(self sel_304:)
			)
			((or sel_237 sel_56)
				(self sel_306:)
			)
		)
	)

	(method (sel_245 param1 param2)
		(if argc
			(= sel_55 param1)
		)
		(if sel_59
			(sel_59 sel_57: self sel_55 (and (>= argc 2) param2))
		else
			(DirLoop self sel_55)
			(if (and (>= argc 2) (IsObject param2))
				(param2 sel_145: &rest)
			)
		)
		(return sel_55)
	)
)

