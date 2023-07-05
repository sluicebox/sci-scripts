;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(class IconI of Obj
	(properties
		sel_20 {IconI}
		sel_2 -1
		sel_3 -1
		sel_4 -1
		sel_7 0
		sel_6 -1
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 -1
		sel_31 16384
		sel_37 -1
		sel_61 0
		sel_14 1
		sel_192 0
		sel_193 0
		sel_194 0
		sel_195 0
		sel_196 0
		sel_197 0
	)

	(method (sel_198 param1 param2 &tmp [temp0 7])
		(|= sel_14 $0020)
		(if argc
			(= sel_9 (+ (= sel_7 param1) (CelWide sel_2 sel_3 sel_4)))
			(= sel_8 (+ (= sel_6 param2) (CelHigh sel_2 sel_3 sel_4)))
		else
			(= sel_9 (+ sel_7 (CelWide sel_2 sel_3 sel_4)))
			(= sel_8 (+ sel_6 (CelHigh sel_2 sel_3 sel_4)))
		)
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
		(if (& sel_14 $0004)
			(self sel_201:)
		)
		(if (and gPMouse (gPMouse sel_116: 159))
			(gPMouse sel_159:)
		)
	)

	(method (sel_201)
		(DrawCel
			sel_193
			sel_194
			sel_195
			(+
				sel_7
				(/
					(-
						(CelWide sel_2 sel_3 sel_4)
						(CelWide sel_193 sel_194 sel_195)
					)
					2
				)
			)
			(+
				sel_6
				(/
					(-
						(CelHigh sel_2 sel_3 sel_4)
						(CelHigh sel_193 sel_194 sel_195)
					)
					2
				)
			)
			-1
		)
	)

	(method (sel_200 param1)
		(return
			(and
				(>= (param1 sel_1:) sel_7)
				(>= (param1 sel_0:) sel_6)
				(<= (param1 sel_1:) sel_9)
				(<= (param1 sel_0:) sel_8)
			)
		)
	)

	(method (sel_199 &tmp [temp0 5]))

	(method (sel_171 param1 &tmp temp0 temp1)
		(return
			(cond
				((& sel_14 $0004) 0)
				((and argc param1 (& sel_14 $0001))
					(DrawCel sel_2 sel_3 (= temp1 1) sel_7 sel_6 -1)
					(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					(while (!= ((= temp0 (Event sel_109:)) sel_31:) 2)
						(temp0 sel_147:)
						(cond
							((self sel_200: temp0)
								(if (not temp1)
									(DrawCel
										sel_2
										sel_3
										(= temp1 1)
										sel_7
										sel_6
										-1
									)
									(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
								)
							)
							(temp1
								(DrawCel sel_2 sel_3 (= temp1 0) sel_7 sel_6 -1)
								(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
							)
						)
						(temp0 sel_111:)
					)
					(temp0 sel_111:)
					(if (== temp1 1)
						(DrawCel sel_2 sel_3 0 sel_7 sel_6 -1)
						(Graph grUPDATE_BOX sel_6 sel_7 sel_8 sel_9 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(class IconBar of Set
	(properties
		sel_20 {IconBar}
		sel_207 0
		sel_5 0
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
		sel_146 0
		sel_32 0
		sel_29 1024
		sel_216 0
		sel_0 0
	)

	(method (sel_206 &tmp [temp0 104]))

	(method (sel_132 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(param1 sel_147:)
		(cond
			((& sel_29 $0004))
			(
				(or
					(and
						(not (= temp1 (param1 sel_31:)))
						(& sel_29 $0400)
						(<= -10 (param1 sel_0:) sel_207)
						(<= 0 (param1 sel_1:) 320)
						(not (= temp0 0))
					)
					(and
						(== temp1 4)
						(or
							(== (param1 sel_37:) 27)
							(== (param1 sel_37:) 21248)
						)
						(= temp0 1)
					)
				)
				(param1 sel_148:)
				(= sel_208 (param1 sel_1:))
				(= sel_209 (param1 sel_0:))
				(= temp2 gTheCursor)
				(= temp3 sel_210)
				(= temp5 sel_213)
				(self sel_198:)
				(if temp0
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
				(self sel_57:)
				(= temp4
					(if (and (== temp3 sel_210) (== temp5 sel_213))
						temp2
					else
						(sel_210 sel_33:)
					)
				)
				(if temp0
					(gGame sel_191: temp4 1 sel_208 sel_209)
				else
					(gGame
						sel_191:
							temp4
							1
							((= temp6 (Event sel_109:)) sel_1:)
							(Max (temp6 sel_0:) (+ 1 sel_207))
					)
					(temp6 sel_111:)
				)
				(self sel_102:)
			)
			((& temp1 $0004)
				(switch (param1 sel_37:)
					(13
						(if (IsObject sel_210)
							(param1
								sel_31: (sel_210 sel_31:)
								sel_37: (sel_210 sel_37:)
							)
						)
					)
					(20992
						(self sel_202:)
						(param1 sel_73: 1)
					)
					(0
						(if (& (param1 sel_31:) $0040)
							(self sel_203:)
							(param1 sel_73: 1)
						)
					)
				)
			)
			((& temp1 $0001)
				(cond
					((& (param1 sel_61:) $0003)
						(self sel_203:)
						(param1 sel_73: 1)
					)
					((& (param1 sel_61:) $0004)
						(self sel_202:)
						(param1 sel_73: 1)
					)
					((IsObject sel_210)
						(param1
							sel_31: (sel_210 sel_31:)
							sel_37: (sel_210 sel_37:)
						)
					)
				)
			)
		)
	)

	(method (sel_205 param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self sel_64: [param1 temp0])
					)
				)
				(temp1 sel_14: (| (temp1 sel_14:) $0004))
				(cond
					((== temp1 sel_210)
						(self sel_203:)
					)
					((== temp1 sel_211)
						(self sel_184:)
					)
				)
			)
		else
			(|= sel_29 $0004)
		)
	)

	(method (sel_170 param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self sel_64: [param1 temp0])
					)
				)
				(temp1 sel_14: (& (temp1 sel_14:) $fffb))
			)
		else
			(&= sel_29 $fffb)
		)
	)

	(method (sel_198 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds sel_160:)
		(|= sel_29 $0020)
		(gGame sel_191: 982 1)
		(= sel_207
			(CelHigh
				((= temp0 (self sel_64: 0)) sel_2:)
				(temp0 sel_3:)
				(temp0 sel_4:)
			)
		)
		(= sel_146 (GetPort))
		(SetPort -1)
		(= sel_5 (Graph grSAVE_BOX sel_0 0 (+ sel_0 sel_207) 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 sel_0)
		(for ((= temp5 (FirstNode sel_24))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 sel_9:) 0)
				(temp7 sel_198: temp3 temp4)
				(= temp3 (temp7 sel_9:))
			else
				(temp7 sel_198:)
			)
		)
		(if sel_213
			(if (gEgo sel_217: (gInventory sel_131: sel_213))
				(= temp3
					(+
						(/
							(-
								(- (sel_214 sel_9:) (sel_214 sel_7:))
								(CelWide
									(sel_213 sel_2:)
									(+ (sel_213 sel_3:) 1)
									(sel_213 sel_4:)
								)
							)
							2
						)
						(sel_214 sel_7:)
					)
				)
				(= temp4
					(+
						sel_0
						(/
							(-
								(- (sel_214 sel_8:) (sel_214 sel_6:))
								(CelHigh
									(sel_213 sel_2:)
									(+ (sel_213 sel_3:) 1)
									(sel_213 sel_4:)
								)
							)
							2
						)
						(sel_214 sel_6:)
					)
				)
				(DrawCel
					(sel_213 sel_2:)
					(+ (sel_213 sel_3:) 1)
					(sel_213 sel_4:)
					temp3
					temp4
					-1
				)
				(if (& (sel_214 sel_14:) $0004)
					(sel_214 sel_201:)
				)
			else
				(= sel_213 0)
			)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX sel_0 0 (+ sel_0 sel_207) 320 1)
		(self sel_199: sel_210)
		(gGame
			sel_191:
				gTheCursor
				(+ (sel_210 sel_7:) (/ (- (sel_210 sel_7:) (sel_210 sel_9:)) 2))
		)
	)

	(method (sel_102 &tmp temp0 temp1 temp2)
		(if (& sel_29 $0020)
			(gSounds sel_160: 0)
			(&= sel_29 $ffdf)
			(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
				(= temp1 (NextNode temp0))
				(if (not (IsObject (= temp2 (NodeValue temp0))))
					(return)
				)
				((= temp2 (NodeValue temp0)) sel_14: (& (temp2 sel_14:) $ffdf))
			)
			(Graph grRESTORE_BOX sel_5)
			(Graph grUPDATE_BOX sel_0 0 (+ sel_0 sel_207) 320 1)
			(Graph grREDRAW_BOX sel_0 0 (+ sel_0 sel_207) 320)
			(SetPort sel_146)
			(= sel_207 sel_216)
		)
	)

	(method (sel_57 &tmp temp0)
		(while (and (= temp0 (Event sel_109:)) (& sel_29 $0020))
			(gSounds sel_119: 167)
			(Wait 1)
			(if (== (temp0 sel_31:) 256)
				(temp0
					sel_31: 4
					sel_37: (if (& (temp0 sel_61:) $0003) 27 else 13)
					sel_61: 0
				)
			)
			(temp0 sel_147:)
			(if
				(and
					(or
						(== (temp0 sel_31:) 1)
						(and (== (temp0 sel_31:) 4) (== (temp0 sel_37:) 13))
					)
					(IsObject sel_215)
					(& (sel_215 sel_14:) $0010)
				)
				(temp0 sel_31: 16384 sel_37: (sel_215 sel_37:))
			)
			(MapKeyToDir temp0)
			(if (self sel_204: temp0)
				(break)
			)
		)
		(if (IsObject temp0)
			(temp0 sel_111:)
		)
	)

	(method (sel_204 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (param1 sel_1:))
		(= temp0 (param1 sel_0:))
		(= temp2 (param1 sel_31:))
		(= temp3 (param1 sel_37:))
		(= temp5 (param1 sel_73:))
		(= temp4 (self sel_120: 200 param1))
		(param1 sel_111:)
		(if (& temp2 $0040)
			(switch temp3
				(3
					(self sel_184:)
				)
				(7
					(self sel_185:)
				)
			)
		else
			(switch temp2
				(0
					(cond
						(
							(not
								(and
									(<= 0 temp0 (+ sel_0 sel_207))
									(<= 0 temp1 320)
								)
							)
							(if
								(and
									(& sel_29 $0400)
									(or
										(not (IsObject sel_215))
										(not (& (sel_215 sel_14:) $0010))
									)
								)
								(= sel_209 0)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 sel_211))
							(= sel_209 0)
							(self sel_199: temp4)
						)
					)
				)
				(1
					(if (and temp4 (self sel_171: temp4 1))
						(if (== temp4 sel_215)
							(if (temp4 sel_33:)
								(gGame sel_191: (temp4 sel_33:))
							)
							(if (& sel_29 $0800)
								(self sel_206:)
							else
								(sel_215 sel_14: (| (sel_215 sel_14:) $0010))
							)
						else
							(= temp5 (& (temp4 sel_14:) $0040))
						)
					)
				)
				(4
					(switch temp3
						(27
							(= temp5 1)
						)
						(13
							(if (not temp4)
								(= temp4 sel_211)
							)
							(cond
								((and temp4 (== temp4 sel_215))
									(if (!= (temp4 sel_33:) -1)
										(gGame sel_191: (temp4 sel_33:))
									)
									(if sel_215
										(sel_215
											sel_14: (| (sel_215 sel_14:) $0010)
										)
									)
								)
								((IsObject temp4)
									(self sel_171: temp4)
									(= temp5 (& (temp4 sel_14:) $0040))
								)
							)
						)
						(3840
							(self sel_185:)
						)
						(9
							(self sel_184:)
						)
					)
				)
				(16384
					(if (== temp3 6)
						(if (and temp4 (temp4 sel_192:))
							(= temp6 (GetPort))
							(Printf 937 0 (temp4 sel_192:)) ; "%s"
							(SetPort temp6)
						)
						(if sel_215
							(sel_215 sel_14: (& (sel_215 sel_14:) $ffef))
						)
						(gGame sel_191: 982)
					)
				)
			)
		)
		(return temp5)
	)

	(method (sel_184 &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 sel_86)
			((= temp1 (mod (+ temp1 1) sel_86)))
			
			(= temp0
				(self sel_64: (mod (+ temp1 (self sel_131: sel_211)) sel_86))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_124:)))
			)
			(breakif (not (& (temp0 sel_14:) $0004)))
		)
		(if (& sel_29 $0020)
			(gGame
				sel_191:
					gTheCursor
					1
					(+ (temp0 sel_7:) (/ (- (temp0 sel_9:) (temp0 sel_7:)) 2))
					(- (temp0 sel_8:) 3)
			)
		)
		(self sel_199: temp0)
	)

	(method (sel_185 &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 sel_86)
			((= temp1 (mod (+ temp1 1) sel_86)))
			
			(= temp0
				(self sel_64: (mod (- (self sel_131: sel_211) temp1) sel_86))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_126:)))
			)
			(breakif (not (& (temp0 sel_14:) $0004)))
		)
		(if (& sel_29 $0020)
			(gGame
				sel_191:
					gTheCursor
					1
					(+ (temp0 sel_7:) (/ (- (temp0 sel_9:) (temp0 sel_7:)) 2))
					(- (temp0 sel_8:) 3)
			)
		)
		(self sel_199: temp0)
	)

	(method (sel_171 param1 param2)
		(return
			(if (param1 sel_171: (and (>= argc 2) param2))
				(if (not (& (param1 sel_14:) $0002))
					(= sel_210 param1)
				)
				1
			)
		)
	)

	(method (sel_199 param1 &tmp temp0)
		(if (not (& (param1 sel_14:) $0004))
			(if (IsObject sel_211)
				(sel_211 sel_199: 0)
			)
			(= sel_211 param1)
			(sel_211 sel_199: 1)
		)
	)

	(method (sel_203 &tmp temp0 temp1)
		(if (& sel_29 $0004)
			(return)
		)
		(= temp0 sel_210)
		(= temp1 0)
		(while
			(&
				((= temp0
						(self sel_64: (mod (+ (self sel_131: temp0) 1) sel_86))
					)
					sel_14:
				)
				$0006
			)
			(if (> temp1 (+ 1 sel_86))
				(return)
			else
				(++ temp1)
			)
		)
		(= sel_210 temp0)
		(gGame sel_191: (sel_210 sel_33:) 1)
	)

	(method (sel_202 &tmp temp0)
		(cond
			((& sel_29 $0004)
				(return)
			)
			(
				(and
					(!= sel_210 (= temp0 (NodeValue (self sel_124:))))
					(not (& (temp0 sel_14:) $0004))
				)
				(= sel_212 sel_210)
				(= sel_210 (NodeValue (self sel_124:)))
			)
			((and sel_212 (not (& (sel_212 sel_14:) $0004)))
				(= sel_210 sel_212)
			)
		)
		(gGame sel_191: (sel_210 sel_33:) 1)
	)
)

