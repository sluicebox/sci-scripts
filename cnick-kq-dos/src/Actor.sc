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

	(method (sel_200)
		(return
			(if (& sel_14 $0080)
				0
			else
				(super sel_200: &rest)
			)
		)
	)
)

(class View of Feature
	(properties
		sel_20 {View}
		sel_52 2
		sel_2 0
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
	)

	(method (sel_110 param1)
		(&= sel_14 $7fff)
		(if (not (gCast sel_122: self))
			(= sel_13 (= sel_12 (= sel_11 (= sel_10 0))))
			(&= sel_14 $ff77)
		)
		(BaseSetter self)
		(super sel_110: &rest)
		(self sel_290:)
	)

	(method (sel_282 param1 param2 param3)
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
		(self sel_284:)
	)

	(method (sel_111)
		(self sel_285: sel_102:)
		(|= sel_14 $8000)
	)

	(method (sel_102)
		(|= sel_14 $0008)
	)

	(method (sel_198)
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
			(if (IsObject sel_270)
				(sel_270 sel_111:)
			)
			(= sel_270 0)
		)
	)

	(method (sel_283)
		(|= sel_14 $0001)
		(&= sel_14 $fffd)
	)

	(method (sel_284)
		(|= sel_14 $0040)
	)

	(method (sel_285)
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
		(self sel_284:)
	)

	(method (sel_165 param1)
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
		(self sel_284:)
	)

	(method (sel_286 param1)
		(cond
			((== argc 0)
				(|= sel_14 $1000)
			)
			((== param1 -1)
				(&= sel_14 $efff)
			)
			(else
				(|= sel_14 $1000)
				(= sel_4
					(if (>= param1 (self sel_225:))
						(self sel_225:)
					else
						param1
					)
				)
			)
		)
		(self sel_284:)
	)

	(method (sel_287 param1)
		(if (or (== 0 argc) param1)
			(|= sel_14 $4000)
		else
			(&= sel_14 $bfff)
		)
	)

	(method (sel_288)
		(if (not (gCast sel_122: self))
			(self sel_110:)
		)
		(self sel_14: (| sel_14 $8021))
	)

	(method (sel_225)
		(return (- (NumCels self) 1))
	)

	(method (sel_113)
		(Print sel_20 79 sel_2 sel_3 sel_4)
	)

	(method (sel_289 param1 &tmp temp0)
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

	(method (sel_222))

	(method (sel_290))

	(method (sel_280)
		(return (not (& sel_14 $0088)))
	)

	(method (sel_200)
		(return
			(if (self sel_280:)
				(super sel_200: &rest)
			else
				0
			)
		)
	)
)

(class Prop of View
	(properties
		sel_20 {Prop}
		sel_14 0
		sel_223 6
		sel_141 0
		sel_224 0
		sel_134 0
		sel_291 0
	)

	(method (sel_57 &tmp temp0)
		(SetNowSeen self sel_6)
		(if (& sel_14 $8000)
			(return)
		)
		(if sel_141
			(sel_141 sel_57:)
		)
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_224
			(sel_224 sel_57:)
		)
	)

	(method (sel_132 param1)
		(if sel_141
			(sel_141 sel_132: param1)
		)
		(super sel_132: param1)
	)

	(method (sel_153 param1)
		(if sel_224
			(sel_224 sel_111:)
		)
		(if param1
			(self sel_286: -1)
			(self sel_285:)
			(= sel_224
				(if (& (param1 sel_4103:) $8000)
					(param1 sel_109:)
				else
					param1
				)
			)
			(sel_224 sel_110: self &rest)
		else
			(= sel_224 0)
		)
	)

	(method (sel_81)
		(if (& sel_14 $8000)
			(self sel_145: 0 sel_153: 0)
			(if sel_134
				(sel_134 sel_111:)
			)
			(super sel_81:)
		)
	)

	(method (sel_144)
		(if sel_141
			(sel_141 sel_144:)
		)
	)

	(method (sel_145 param1)
		(if (IsObject sel_141)
			(sel_141 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_222)
		(if (and sel_224 (sel_224 sel_219:))
			(sel_224 sel_222:)
		)
	)

	(method (sel_290 param1)
		(cond
			((not sel_291))
			(
				(<
					(if argc
						param1
					else
						(gGame sel_291:)
					)
					sel_291
				)
				(self sel_283:)
			)
			(sel_224
				(self sel_285:)
			)
		)
	)
)

(class Actor of Prop
	(properties
		sel_20 {Actor}
		sel_15 -32768
		sel_228 0
		sel_229 0
		sel_51 3
		sel_53 6
		sel_292 0
		sel_293 0
		sel_56 0
		sel_59 0
		sel_294 0
		sel_295 0
		sel_182 0
	)

	(method (sel_110)
		(super sel_110: &rest)
		(= sel_228 sel_1)
		(= sel_229 sel_0)
	)

	(method (sel_57 &tmp temp0 temp1 temp2)
		(if (& sel_14 $8000)
			(return)
		)
		(if sel_141
			(sel_141 sel_57:)
		)
		(if sel_182
			(sel_182 sel_57: self)
		)
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_294
			(sel_294 sel_57: self)
		)
		(cond
			(sel_295
				(sel_295 sel_57:)
			)
			(sel_56
				(sel_56 sel_57:)
			)
		)
		(if sel_224
			(= temp1 sel_17)
			(= temp2 sel_19)
			(sel_224 sel_57:)
			(if sel_293
				(sel_293 sel_57: self)
			else
				(BaseSetter self)
			)
		)
		(= sel_228 sel_1)
		(= sel_229 sel_0)
	)

	(method (sel_282 param1 param2)
		(super sel_282: param1 param2 &rest)
		(= sel_228 param1)
		(= sel_229 param2)
	)

	(method (sel_296 param1)
		(if (and sel_56 (!= sel_56 -1))
			(sel_56 sel_111:)
		)
		(if param1
			(self sel_285:)
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

	(method (sel_297))

	(method (sel_226)
		(return
			(or
				(not (IsObject sel_56))
				(and (== sel_1 (sel_56 sel_228:)) (== sel_0 (sel_56 sel_229:)))
			)
		)
	)

	(method (sel_58)
		(return (& sel_14 $0400))
	)

	(method (sel_81)
		(if (& sel_14 $8000)
			(if (!= sel_56 -1)
				(self sel_296: 0)
			)
			(if sel_293
				(sel_293 sel_111:)
				(= sel_293 0)
			)
			(if sel_59
				(sel_59 sel_111:)
				(= sel_59 0)
			)
			(if sel_294
				(sel_294 sel_111:)
				(= sel_294 0)
			)
			(if sel_292
				(sel_292 sel_111:)
				(= sel_292 0)
			)
			(if sel_182
				(sel_182 sel_111:)
				(= sel_182 0)
			)
			(if (IsObject sel_270)
				(sel_270 sel_111:)
				(= sel_270 0)
			)
			(super sel_81:)
		)
	)

	(method (sel_298))

	(method (sel_299 &tmp temp0))

	(method (sel_300 &tmp temp0))

	(method (sel_301))

	(method (sel_302))

	(method (sel_234 param1)
		(GetDistance sel_1 sel_0 (param1 sel_1:) (param1 sel_0:) gPerspective)
	)

	(method (sel_54 &tmp temp0))

	(method (sel_303 &tmp [temp0 5]))

	(method (sel_304 param1 param2 param3 param4)
		(return
			(and
				(<= param1 sel_1)
				(< sel_1 param3)
				(<= param2 sel_0)
				(< sel_0 param4)
			)
		)
	)

	(method (sel_305))

	(method (sel_306 param1 param2)
		(if (and (>= argc 1) (!= param1 -1))
			(= sel_51 param1)
		)
		(if (and (>= argc 2) (!= param2 -1))
			(= sel_52 param2)
		)
		(if (and sel_56 (!= -1 sel_56) (sel_56 sel_115: MoveTo))
			((self sel_56:) sel_110:)
		)
	)

	(method (sel_307 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
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
				(self sel_296: 0)
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
		(if (and (= temp7 (gCurRoom sel_308:)) gUseObstacles)
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
				(self sel_296: MoveTo (+ sel_1 temp2) (+ sel_0 temp3))
			)
			(param1
				(self sel_296: 0 sel_232: (* (- param1 1) 45))
			)
			(else
				(self sel_296: 0)
			)
		)
	)

	(method (sel_222)
		(if (and sel_56 (sel_56 sel_219:))
			(sel_56 sel_222:)
		)
		(super sel_222:)
	)

	(method (sel_165 param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(super sel_165:)
						0
					)
					((not (IsObject param1))
						(super sel_165: param1 &rest)
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

	(method (sel_290 param1)
		(cond
			((not sel_291))
			(
				(<
					(if argc
						param1
					else
						(gGame sel_291:)
					)
					sel_291
				)
				(self sel_283:)
			)
			((or sel_224 sel_56)
				(self sel_285:)
			)
		)
	)

	(method (sel_232 param1 param2)
		(if argc
			(= sel_55 param1)
		)
		(if sel_59
			(sel_59 sel_57: self sel_55 (and (>= argc 2) param2))
		else
			(DirLoop self sel_55)
			(if (and (>= argc 2) (IsObject param2))
				(param2 sel_144: &rest)
			)
		)
		(return sel_55)
	)
)

