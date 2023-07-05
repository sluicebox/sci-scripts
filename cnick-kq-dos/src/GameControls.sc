;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 934)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use System)

(public
	GameControls 0
)

(class Slider of IconI
	(properties
		sel_20 {Slider}
		sel_396 0
		sel_397 0
		sel_398 0
		sel_399 0
		sel_400 0
		sel_401 0
		sel_402 0
		sel_403 0
		sel_5 0
		sel_52 1
		sel_325 0
		sel_404 0
		sel_405 0
		sel_406 0
	)

	(method (sel_198)
		(super sel_198: &rest)
		(if (not sel_401)
			(= sel_400 sel_7)
			(= sel_401 sel_9)
			(= sel_402 (- sel_8 (CelHigh sel_396 sel_397 sel_398)))
			(= sel_403 sel_6)
		)
		(= sel_399 (self sel_407:))
		(DrawCel sel_396 sel_397 sel_398 sel_400 sel_399 -1)
		(Graph grUPDATE_BOX (- sel_6 1) (- sel_7 1) (+ 2 sel_8) (+ 2 sel_9) 1)
	)

	(method (sel_171 param1 &tmp temp0)
		(if (and argc param1)
			(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
				(temp0 sel_147:)
				(cond
					((< (temp0 sel_0:) (- sel_399 sel_52))
						(self sel_174: sel_52 (not (& sel_14 $0200)))
					)
					((> (temp0 sel_0:) (+ sel_399 sel_52))
						(self sel_174: (- sel_52) (not (& sel_14 $0200)))
					)
				)
				(temp0 sel_111:)
			)
			(if (& sel_14 $0200)
				(self sel_57: (self sel_408: sel_399))
			)
			(temp0 sel_111:)
		else
			(return 1)
		)
	)

	(method (sel_199))

	(method (sel_174 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp7 (or (not argc) param2))
		(= temp5 (sign param1))
		(for
			((= temp4 param1))
			(<= sel_52 (Abs temp4))
			((-= temp4 (* sel_52 temp5)))
			
			(= temp0 (- sel_399 (* temp5 sel_52)))
			(= temp1 (CelHigh sel_396 sel_397 sel_398))
			(= sel_399
				(cond
					((< temp0 sel_403) sel_403)
					((> temp0 sel_402) sel_402)
					(else temp0)
				)
			)
			(= temp2 (PicNotValid))
			(PicNotValid 1)
			(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
			(DrawCel sel_396 sel_397 sel_398 sel_400 sel_399 -1)
			(Graph grUPDATE_BOX (- sel_6 1) (- sel_7 1) (+ 2 sel_8) (+ 2 sel_9) 1)
			(PicNotValid temp2)
			(= temp3 (self sel_408: sel_399))
			(= temp6
				(if temp7
					(self sel_57: temp3)
				else
					(self sel_57:)
				)
			)
		)
		(return temp6)
	)

	(method (sel_57)
		(if sel_325
			(Eval sel_325 sel_404 &rest)
		)
	)

	(method (sel_408 param1)
		(return
			(+
				sel_405
				(/
					(* (- sel_402 param1) (- sel_406 sel_405))
					(- sel_402 sel_403)
				)
			)
		)
	)

	(method (sel_407 param1 &tmp temp0)
		(return
			(cond
				(
					(and
						(<
							(= temp0
								(if argc
									param1
								else
									(self sel_57:)
								)
							)
							sel_406
						)
						(< temp0 sel_405)
					)
					(if (< sel_405 sel_406) sel_402 else sel_403)
				)
				((and (> temp0 sel_406) (> temp0 sel_405))
					(if (< sel_405 sel_406) sel_403 else sel_402)
				)
				(else
					(+
						sel_403
						(/
							(* (Abs (- sel_406 temp0)) (- sel_402 sel_403))
							(Abs (- sel_406 sel_405))
						)
					)
				)
			)
		)
	)

	(method (sel_184)
		(self
			sel_174:
				(Max
					sel_52
					(-
						sel_399
						(self
							sel_407:
								(+
									(self sel_57:)
									(sign (- sel_406 sel_405))
								)
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_408: sel_399))
		)
	)

	(method (sel_185)
		(self
			sel_174:
				(Min
					(- sel_52)
					(-
						sel_399
						(self
							sel_407:
								(-
									(self sel_57:)
									(sign (- sel_406 sel_405))
								)
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_408: sel_399))
		)
	)
)

(class GameControls of IconBar
	(properties
		sel_20 {GameControls}
		sel_207 200
		sel_29 0
		sel_409 0
	)

	(method (sel_198 &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds sel_160:)
		(if (and gPMouse (gPMouse sel_116: 159))
			(gPMouse sel_159:)
		)
		(|= sel_29 $0020)
		(if (IsObject sel_32)
			(sel_32 sel_183:)
		else
			(= sel_32
				((gSystemWindow sel_109:)
					sel_187: 46
					sel_188: 24
					sel_189: 155
					sel_190: 296
					sel_60: 15
					sel_183:
					sel_117:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode sel_24))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if (and (not (& (temp4 sel_14:) $0080)) (<= (temp4 sel_9:) 0))
				(temp4 sel_198: temp0 temp1)
				(= temp0 (+ 20 (temp4 sel_9:)))
			else
				(temp4 sel_198:)
			)
		)
		(if (not sel_409)
			(= sel_409 (NodeValue (self sel_124:)))
		)
		(if sel_210
			(gGame
				sel_191:
					gTheCursor
					1
					(+
						(sel_210 sel_7:)
						(/ (- (sel_210 sel_9:) (sel_210 sel_7:)) 2)
					)
					(- (sel_210 sel_8:) 3)
			)
		)
		(self sel_57: sel_102:)
	)

	(method (sel_204 param1 &tmp temp0 temp1 temp2)
		(cond
			((and (& (param1 sel_31:) $4000) (== (param1 sel_37:) 6))
				(= temp1 (self sel_120: 200 param1))
				(param1 sel_111:)
				(if (and temp1 (temp1 sel_192:))
					(= temp2 (GetPort))
					(if (gSystemWindow sel_116: 333)
						(= temp0 (gSystemWindow sel_333:))
						(gSystemWindow sel_333: 1)
						(Printf 934 0 (temp1 sel_192:)) ; "%s"
						(gSystemWindow sel_333: temp0)
					else
						(Printf 934 0 (temp1 sel_192:)) ; "%s"
					)
					(SetPort temp2)
				)
				(if sel_215
					(sel_215 sel_14: (& (sel_215 sel_14:) $ffef))
				)
				(gGame sel_191: 982)
				(return 0)
			)
			((& (param1 sel_31:) $0040)
				(switch (param1 sel_37:)
					(5
						(param1 sel_111:)
						(cond
							((and (IsObject sel_211) (sel_211 sel_116: 185))
								(sel_211 sel_185:)
								(return 0)
							)
							(
								(or
									(not (IsObject sel_211))
									(& (sel_211 sel_14:) $0100)
								)
								(self sel_184:)
								(return 0)
							)
						)
					)
					(1
						(param1 sel_111:)
						(cond
							((and (IsObject sel_211) (sel_211 sel_116: 184))
								(sel_211 sel_184:)
								(return 0)
							)
							(
								(or
									(not (IsObject sel_211))
									(& (sel_211 sel_14:) $0100)
								)
								(self sel_185:)
								(return 0)
							)
						)
					)
					(else
						(super sel_204: param1)
					)
				)
			)
			(else
				(super sel_204: param1)
			)
		)
	)

	(method (sel_171 param1 param2)
		(param1 sel_171: (and (>= argc 2) param2))
	)

	(method (sel_203 &tmp temp0))

	(method (sel_202))

	(method (sel_102)
		(if sel_32
			(sel_32 sel_111:)
		)
		(if (& sel_29 $0020)
			(gSounds sel_160: 0)
			(&= sel_29 $ffdf)
		)
	)
)

(class ControlIcon of IconI
	(properties
		sel_20 {ControlIcon}
		sel_325 0
		sel_404 0
	)

	(method (sel_171)
		(if sel_325
			(if (super sel_171: &rest)
				(if (& sel_14 $0040)
					((if gGameControls gGameControls else GameControls) sel_102:)
				)
				(Eval sel_325 sel_404)
			)
		else
			(super sel_171: &rest)
		)
	)
)

