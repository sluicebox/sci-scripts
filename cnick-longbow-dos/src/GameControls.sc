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
		sel_502 0
		sel_503 0
		sel_504 0
		sel_505 0
		sel_506 0
		sel_507 0
		sel_508 0
		sel_509 0
		sel_5 0
		sel_52 1
		sel_340 0
		sel_510 0
		sel_511 0
		sel_512 0
	)

	(method (sel_207)
		(super sel_207: &rest)
		(if (not sel_507)
			(= sel_506 sel_7)
			(= sel_507 sel_9)
			(= sel_508 (- sel_8 (CelHigh sel_502 sel_503 sel_504)))
			(= sel_509 sel_6)
		)
		(= sel_505 (self sel_513:))
		(DrawCel sel_502 sel_503 sel_504 sel_506 sel_505 -1)
		(Graph grUPDATE_BOX (- sel_6 1) (- sel_7 1) (+ 2 sel_8) (+ 2 sel_9) 1)
	)

	(method (sel_179 param1 &tmp temp0)
		(if (and argc param1)
			(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
				(temp0 sel_148:)
				(cond
					((< (temp0 sel_0:) (- sel_505 sel_52))
						(self sel_182: sel_52 (not (& sel_14 $0200)))
					)
					((> (temp0 sel_0:) (+ sel_505 sel_52))
						(self sel_182: (- sel_52) (not (& sel_14 $0200)))
					)
				)
				(temp0 sel_111:)
			)
			(if (& sel_14 $0200)
				(self sel_57: (self sel_514: sel_505))
			)
			(temp0 sel_111:)
		else
			(return 1)
		)
	)

	(method (sel_208))

	(method (sel_182 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp7 (or (not argc) param2))
		(= temp5 (sign param1))
		(for
			((= temp4 param1))
			(<= sel_52 (Abs temp4))
			((-= temp4 (* sel_52 temp5)))
			
			(= temp0 (- sel_505 (* temp5 sel_52)))
			(= temp1 (CelHigh sel_502 sel_503 sel_504))
			(= sel_505
				(cond
					((< temp0 sel_509) sel_509)
					((> temp0 sel_508) sel_508)
					(else temp0)
				)
			)
			(= temp2 (PicNotValid))
			(PicNotValid 1)
			(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
			(DrawCel sel_502 sel_503 sel_504 sel_506 sel_505 -1)
			(Graph grUPDATE_BOX (- sel_6 1) (- sel_7 1) (+ 2 sel_8) (+ 2 sel_9) 1)
			(PicNotValid temp2)
			(= temp3 (self sel_514: sel_505))
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
		(if sel_340
			(Eval sel_340 sel_510 &rest)
		)
	)

	(method (sel_514 param1)
		(return
			(+
				sel_511
				(/
					(* (- sel_508 param1) (- sel_512 sel_511))
					(- sel_508 sel_509)
				)
			)
		)
	)

	(method (sel_513 param1 &tmp temp0)
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
							sel_512
						)
						(< temp0 sel_511)
					)
					(if (< sel_511 sel_512) sel_508 else sel_509)
				)
				((and (> temp0 sel_512) (> temp0 sel_511))
					(if (< sel_511 sel_512) sel_509 else sel_508)
				)
				(else
					(+
						sel_509
						(/
							(* (Abs (- sel_512 temp0)) (- sel_508 sel_509))
							(Abs (- sel_512 sel_511))
						)
					)
				)
			)
		)
	)

	(method (sel_188)
		(self
			sel_182:
				(Max
					sel_52
					(-
						sel_505
						(self
							sel_513:
								(+
									(self sel_57:)
									(sign (- sel_512 sel_511))
								)
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_514: sel_505))
		)
	)

	(method (sel_189)
		(self
			sel_182:
				(Min
					(- sel_52)
					(-
						sel_505
						(self
							sel_513:
								(-
									(self sel_57:)
									(sign (- sel_512 sel_511))
								)
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_514: sel_505))
		)
	)
)

(class GameControls of IconBar
	(properties
		sel_20 {GameControls}
		sel_211 200
		sel_29 0
		sel_384 0
	)

	(method (sel_207 &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds sel_169:)
		(if (and gPMouse (gPMouse sel_116: 168))
			(gPMouse sel_168:)
		)
		(|= sel_29 $0020)
		(if (IsObject sel_32)
			(sel_32 sel_192:)
		else
			(= sel_32
				((gSystemWindow sel_109:)
					sel_194: 46
					sel_195: 24
					sel_196: 155
					sel_197: 296
					sel_60: 15
					sel_192:
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
				(temp4 sel_207: temp0 temp1)
				(= temp0 (+ 20 (temp4 sel_9:)))
			else
				(temp4 sel_207:)
			)
		)
		(if (not sel_384)
			(= sel_384 (NodeValue (self sel_124:)))
		)
		(if sel_214
			(gGame
				sel_198:
					gTheCursor
					1
					(+
						(sel_214 sel_7:)
						(/ (- (sel_214 sel_9:) (sel_214 sel_7:)) 2)
					)
					(- (sel_214 sel_8:) 3)
			)
		)
		(self sel_57: sel_102:)
	)

	(method (sel_224 param1 &tmp temp0 temp1 temp2 [temp3 50])
		(cond
			((== (param1 sel_31:) 8192)
				(= temp1 (self sel_120: 209 param1))
				(param1 sel_111:)
				(if (and temp1 (temp1 sel_387:))
					(= temp2 (GetPort))
					(Format {%s} (temp1 sel_387:))
					(if (gSystemWindow sel_116: 228)
						(= temp0 (gSystemWindow sel_228:))
						(gSystemWindow sel_228: 1)
						(Print @temp3)
						(gSystemWindow sel_228: temp0)
					else
						(Print @temp3)
					)
					(SetPort temp2)
				)
				(if sel_219
					(sel_219 sel_14: (& (sel_219 sel_14:) $ffef))
				)
				(gGame sel_198: 999)
				(return 0)
			)
			((& (param1 sel_31:) $0040)
				(switch (param1 sel_37:)
					(5
						(param1 sel_111:)
						(cond
							((and (IsObject sel_215) (sel_215 sel_116: 189))
								(sel_215 sel_189:)
								(return 0)
							)
							(
								(or
									(not (IsObject sel_215))
									(& (sel_215 sel_14:) $0100)
								)
								(self sel_188:)
								(return 0)
							)
						)
					)
					(1
						(param1 sel_111:)
						(cond
							((and (IsObject sel_215) (sel_215 sel_116: 188))
								(sel_215 sel_188:)
								(return 0)
							)
							(
								(or
									(not (IsObject sel_215))
									(& (sel_215 sel_14:) $0100)
								)
								(self sel_189:)
								(return 0)
							)
						)
					)
					(else
						(super sel_224: param1)
					)
				)
			)
			(else
				(super sel_224: param1)
			)
		)
	)

	(method (sel_179 param1 param2)
		(param1 sel_179: (and (>= argc 2) param2))
	)

	(method (sel_223 &tmp temp0))

	(method (sel_222))

	(method (sel_102)
		(if sel_32
			(sel_32 sel_111:)
			(= sel_32 0)
		)
		(if (& sel_29 $0020)
			(gSounds sel_169: 0)
			(&= sel_29 $ffdf)
		)
	)
)

(class ControlIcon of IconI
	(properties
		sel_20 {ControlIcon}
		sel_340 0
		sel_510 0
	)

	(method (sel_179)
		(if sel_340
			(if (super sel_179: &rest)
				(if (& sel_14 $0040)
					((if gGameControls gGameControls else GameControls) sel_102:)
				)
				(Eval sel_340 sel_510)
			)
		else
			(super sel_179: &rest)
		)
	)
)

