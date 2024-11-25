;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use Window)
(use System)

(local
	yesI
)

(class InvI of IconI
	(properties
		sel_20 {InvI}
		sel_2 0
		sel_3 0
		sel_4 0
		sel_6 0
		sel_33 999
		sel_37 0
		sel_14 0
		sel_167 0
		sel_142 0
		sel_74 0
	)

	(method (sel_209 param1)
		(return (and (super sel_209: param1) (not (& sel_14 $0004))))
	)

	(method (sel_292 param1)
		(if (not sel_205)
			(= sel_205 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET sel_205 sel_204 param1 0 1))
			(gMessager sel_287: sel_204 param1 0 0 0 sel_205)
		)
	)

	(method (sel_208 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== sel_202 -1)
			(return)
		)
		(= temp4 (if (and argc param1) sel_202 else sel_203))
		(= temp0 (- sel_6 2))
		(= temp1 (- sel_7 2))
		(= temp2 (+ sel_8 1))
		(= temp3 (+ sel_9 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- sel_6 2) (- sel_7 2) (+ sel_8 2) (+ sel_9 2) 1)
	)

	(method (sel_207 &tmp [temp0 4])
		(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
	)

	(method (sel_345 param1)
		(return (== sel_167 param1))
	)

	(method (sel_183 param1)
		(= sel_167 param1)
		(if (and sel_74 (== param1 gEgo))
			(gGame sel_380: sel_74)
			(= sel_74 0)
		)
		(return self)
	)
)

(class Inv of IconBar
	(properties
		sel_20 {Inv}
		sel_381 {You are carrying:}
		sel_55 0
		sel_382 {nothing!}
		sel_383 0
		sel_384 0
		sel_385 0
	)

	(method (sel_386 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 [temp22 50])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self sel_124:))) temp8 ((= temp8 (self sel_65: temp8)))
			(if ((= temp9 (NodeValue temp8)) sel_114: InvI)
				(if (temp9 sel_345: param1)
					(temp9 sel_14: (& (temp9 sel_14:) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 sel_2:)
									(temp9 sel_3:)
									(temp9 sel_4:)
								)
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 sel_2:)
									(temp9 sel_3:)
									(temp9 sel_4:)
								)
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 sel_14: (| (temp9 sel_14:) $0004))
				)
			else
				(++ temp3)
				(+=
					temp5
					(CelWide (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:))
				)
				(if
					(>
						(= temp7
							(CelHigh
								(temp9 sel_2:)
								(temp9 sel_3:)
								(temp9 sel_4:)
							)
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (not temp0)
			(Format @temp22 {%s %s} sel_381 sel_382)
			(Print @temp22)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(= yesI (/ temp0 temp16))
		(if (< (* temp16 yesI) temp0)
			(++ yesI)
		)
		(= temp10 (Max (+ 4 temp5) (* yesI (+ 4 temp2))))
		(= temp11 (* temp16 (+ 4 temp1)))
		(= temp12 (/ (- 190 temp11) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self sel_32:))
			(temp21
				sel_194: temp12
				sel_195: temp13
				sel_197: temp15
				sel_196: temp14
				sel_192:
			)
		)
		(= temp20 yesI)
		(if temp0
			(= temp18
				(+
					2
					(if (temp21 sel_116: 377)
						(temp21 sel_377:)
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (temp21 sel_116: 376)
							(temp21 sel_376:)
						)
					)
				)
			)
			(for
				((= temp8 (self sel_124:)))
				temp8
				((= temp8 (self sel_65: temp8)))
				
				(if
					(and
						(not (& ((= temp9 (NodeValue temp8)) sel_14:) $0004))
						(temp9 sel_114: InvI)
					)
					(if (not (& (temp9 sel_14:) $0080))
						(temp9
							sel_7:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide
													(temp9 sel_2:)
													(temp9 sel_3:)
													(temp9 sel_4:)
												)
											)
										)
										2
									)
								)
							sel_6:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh
													(temp9 sel_2:)
													(temp9 sel_3:)
													(temp9 sel_4:)
												)
											)
										)
										2
									)
								)
						)
						(temp9
							sel_9: (+ (temp9 sel_7:) temp6)
							sel_8: (+ (temp9 sel_6:) temp7)
						)
						(if (-- temp20)
							(+= temp17 temp2)
						else
							(= temp20 yesI)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 sel_7:))
						(= temp18 (temp9 sel_6:))
					)
					(temp9 sel_207:)
					(if (== temp9 param2)
						(temp9 sel_208:)
					)
				)
			)
		)
		(= temp17 (/ (- (- (temp21 sel_197:) (temp21 sel_195:)) temp5) 2))
		(= temp11 (- (temp21 sel_196:) (temp21 sel_194:)))
		(= temp18 32767)
		(for ((= temp8 (self sel_124:))) temp8 ((= temp8 (self sel_65: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) sel_114: InvI))
				(= temp6 (CelWide (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:)))
				(= temp7 (CelHigh (temp9 sel_2:) (temp9 sel_3:) (temp9 sel_4:)))
				(if (not (& (temp9 sel_14:) $0080))
					(if (== temp18 32767)
						(= temp18 (- temp11 temp7))
					)
					(temp9
						sel_7: temp17
						sel_6: temp18
						sel_8: temp11
						sel_9: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 sel_7:) temp6))
				(= temp18 (temp9 sel_6:))
				(temp9 sel_14: (& (temp9 sel_14:) $fffb) sel_207:)
			)
		)
		(return 1)
	)

	(method (sel_110)
		(= sel_55 sel_381)
	)

	(method (sel_345 param1)
		(self sel_120: 345 param1)
	)

	(method (sel_113 param1)
		(gSounds sel_169:)
		(if (and gPMouse (gPMouse sel_116: 168))
			(gPMouse sel_168:)
		)
		(if (gTheIconBar sel_211:)
			(gTheIconBar sel_102:)
		)
		(if (not sel_32)
			(= sel_32 (SysWindow sel_109:))
		)
		(if (sel_32 sel_32:)
			(sel_32 sel_111:)
			(= sel_32 0)
		)
		(if (not sel_384)
			(= sel_384 (NodeValue (self sel_124:)))
		)
		(= sel_214 0)
		(if (self sel_207: (if argc param1 else gEgo))
			(self sel_57:)
		)
	)

	(method (sel_207 param1 &tmp temp0 temp1)
		(gGame
			sel_198:
				(if sel_214
					(sel_214 sel_33:)
				else
					(sel_385 sel_33:)
				)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(|= sel_29 $0020)
		(if
			(not
				(= temp1
					(self
						sel_386:
							(if argc param1 else gEgo)
							(gTheIconBar sel_214:)
					)
				)
			)
			(&= sel_29 $ffdf)
		)
		(PicNotValid temp0)
		(return temp1)
	)

	(method (sel_188 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp2 (self sel_132: sel_215))
		(= temp3 (+ temp1 temp2))
		(repeat
			(= temp0
				(self
					sel_64:
						(if (<= temp3 sel_86)
							temp3
						else
							(mod temp3 (- sel_86 1))
						)
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_124:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			else
				(++ temp3)
			)
		)
		(self sel_208: temp0 1)
	)

	(method (sel_189 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3 (- (= temp2 (self sel_132: sel_215)) temp1))
		(repeat
			(= temp0 (self sel_64: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self sel_127:)))
			)
			(if (not (& (temp0 sel_14:) $0004))
				(break)
			else
				(-- temp3)
			)
		)
		(self sel_208: temp0 1)
	)

	(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (+ (/ (- (param1 sel_9:) (param1 sel_7:)) 2) (param1 sel_7:)))
		(= temp2 param2)
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						sel_120:
							209
							((= temp1 (Event sel_109:))
								sel_1: temp3
								sel_0: temp2
								sel_117:
							)
					)
				)
				(temp1 sel_111:)
				(return temp0)
			)
			(temp1 sel_111:)
			(if (< param2 param3)
				(+= temp2 4)
			else
				(-= temp2 4)
			)
		)
	)

	(method (sel_57 &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 [temp9 50])
		(while ((= temp1 (Event sel_109:)) sel_31:)
			(temp1 sel_111:)
		)
		(temp1 sel_111:)
		(= temp1 0)
		(while (& sel_29 $0020)
			(invEvent
				sel_31: 0
				sel_37: 0
				sel_61: 0
				sel_0: 0
				sel_1: 0
				sel_73: 0
				sel_147: 0
			)
			(GetEvent evALL_EVENTS invEvent)
			(= gMouseX (invEvent sel_1:))
			(= gMouseY (invEvent sel_0:))
			(= temp8 0)
			(invEvent sel_148:)
			(if
				(and
					sel_214
					(not (invEvent sel_61:))
					(!= sel_214 sel_385)
					(or
						(== (invEvent sel_31:) 1)
						(and
							(== (invEvent sel_31:) 4)
							(== (invEvent sel_37:) 13)
							(= temp8 1)
						)
						(and (== (invEvent sel_31:) 256) (= temp8 1))
					)
					(or (!= sel_214 sel_219) (& (sel_219 sel_14:) $0010))
				)
				(invEvent sel_31: 16384 sel_37: (sel_214 sel_37:))
			)
			(MapKeyToDir invEvent)
			(cond
				((and (== (= temp2 (invEvent sel_31:)) 1) (invEvent sel_61:))
					(self sel_223:)
					(invEvent sel_73: 1)
				)
				(
					(and
						(== temp2 0)
						(= temp0 (self sel_120: 209 invEvent))
						(!= temp0 sel_215)
					)
					(self sel_208: temp0)
				)
				(
					(or
						(== temp2 1)
						(and (== temp2 4) (== (invEvent sel_37:) 13))
						(== temp2 256)
					)
					(if
						(and
							(IsObject sel_215)
							(self sel_179: sel_215 (== temp2 1))
						)
						(cond
							((== sel_215 sel_384)
								(break)
							)
							((== sel_215 sel_219)
								(if (!= (sel_215 sel_33:) -1)
									(gGame sel_198: (sel_219 sel_33:))
								)
								(cond
									((& sel_29 $0800)
										(self sel_226:)
									)
									(sel_219
										(sel_219
											sel_14: (| (sel_219 sel_14:) $0010)
										)
									)
								)
							)
							(else
								(= sel_214 sel_215)
								(gGame sel_198: (sel_214 sel_33:))
							)
						)
					)
				)
				((& temp2 $0040)
					(switch (invEvent sel_37:)
						(3
							(self sel_188:)
						)
						(7
							(self sel_189:)
						)
						(1
							(if
								(and
									sel_215
									(= temp0
										(localproc_0
											sel_215
											(- (sel_215 sel_6:) 1)
											0
										)
									)
								)
								(self sel_208: temp0 1)
							else
								(self sel_189:)
							)
						)
						(5
							(if
								(and
									sel_215
									(= temp0
										(localproc_0
											sel_215
											(+ (sel_215 sel_8:) 1)
											(sel_32 sel_196:)
										)
									)
								)
								(self sel_208: temp0 1)
							else
								(self sel_188:)
							)
						)
						(0
							(if (& temp2 $0004)
								(self sel_223:)
							)
						)
					)
				)
				((== temp2 4)
					(switch (invEvent sel_37:)
						(9
							(self sel_188:)
						)
						(3840
							(self sel_189:)
						)
					)
				)
				((and (& temp2 $4000) (= temp0 (self sel_120: 209 invEvent)))
					(cond
						((& temp2 $2000)
							(if (and temp0 (temp0 sel_387:))
								(Format @temp9 {%s} (temp0 sel_387:))
								(if (gSystemWindow sel_116: 228)
									(= temp6 (gSystemWindow sel_228:))
									(gSystemWindow sel_228: 1)
									(Print @temp9)
									(gSystemWindow sel_228: temp6)
								else
									(Print @temp9)
								)
							)
							(sel_219 sel_14: (& (sel_219 sel_14:) $ffef))
							(gGame sel_198: 999)
						)
						((== temp0 sel_384)
							(break)
						)
						((not (temp0 sel_114: InvI))
							(if (self sel_179: temp0 (not temp8))
								(= sel_214 temp0)
								(gGame sel_198: (sel_214 sel_33:))
								(if (== temp0 sel_219)
									(if (& sel_29 $0800)
										(self sel_226:)
									else
										(sel_219
											sel_14: (| (sel_219 sel_14:) $0010)
										)
									)
								)
							)
						)
						(sel_214
							(if (gSystemWindow sel_116: 228)
								(= temp6 (gSystemWindow sel_228:))
								(gSystemWindow sel_228: 1)
							)
							(if (sel_214 sel_114: InvI)
								(temp0 sel_292: (sel_214 sel_37:))
							else
								(temp0 sel_292: (invEvent sel_37:))
							)
							(if (gSystemWindow sel_116: 228)
								(gSystemWindow sel_228: temp6)
							)
						)
					)
				)
			)
			(invEvent sel_111:)
		)
		(invEvent sel_111:)
		(self sel_102:)
	)

	(method (sel_102)
		(if (& sel_29 $0020)
			(gSounds sel_169: 0)
			(&= sel_29 $ffdf)
		)
		(if sel_32
			(sel_32 sel_111:)
		)
		(if (and (IsObject sel_214) (sel_214 sel_114: InvI))
			(if (not (gTheIconBar sel_217:))
				(gTheIconBar sel_178: (gTheIconBar sel_218:))
			)
			(gTheIconBar
				sel_214:
					((gTheIconBar sel_218:) sel_33: (sel_214 sel_33:) sel_117:)
				sel_217: sel_214
			)
			(if ((gTheIconBar sel_214:) sel_33:)
				(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
			)
		)
	)

	(method (sel_223 &tmp temp0)
		(= temp0 sel_214)
		(while
			((= temp0 (self sel_64: (mod (+ (self sel_132: temp0) 1) sel_86)))
				sel_114: InvI
			)
		)
		(= sel_214 temp0)
		(if sel_219
			(if (== sel_214 sel_219)
				(sel_219 sel_14: (| (sel_219 sel_14:) $0010))
			else
				(sel_219 sel_14: (& (sel_219 sel_14:) $ffef))
			)
		)
		(gGame sel_198: (sel_214 sel_33:))
	)
)

(instance invEvent of Event
	(properties
		sel_20 {invEvent}
	)
)

