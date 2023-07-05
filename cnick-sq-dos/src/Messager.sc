;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 924)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(class Messager of Obj
	(properties
		sel_20 {Messager}
		sel_143 0
		sel_282 0
		sel_283 1
		sel_284 0
		sel_285 0
		sel_286 0
	)

	(method (sel_57)
		(self sel_111:)
	)

	(method (sel_111 &tmp temp0)
		(if sel_282
			(sel_282 sel_119: 143 0 sel_119: 111 1 sel_111:)
			(= sel_282 0)
		)
		(gTheIconBar sel_29: sel_286)
		(= sel_286 0)
		(gTheDoits sel_81: self)
		(= temp0 sel_143)
		(super sel_111:)
		(if temp0
			(temp0 sel_145: sel_285)
		)
	)

	(method (sel_145 param1)
		(if (and argc param1)
			(= sel_285 1)
		)
		(if (or sel_284 sel_285)
			(if gFastCast
				(gFastCast sel_125: sel_111:)
				(= gFastCast 0)
			)
			(gTheDoits sel_118: self)
		else
			(self sel_288:)
		)
	)

	(method (sel_287 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 (= temp2 0)))
		(= sel_143 (= sel_284 (= sel_285 0)))
		(if (not sel_286)
			(= sel_286 (gTheIconBar sel_29:))
		)
		(if (and (> argc 5) param6)
			(= temp3 param6)
		else
			(= temp3 gCurRoomNum)
		)
		(if (not sel_282)
			((= sel_282 (Set sel_109:)) sel_118:)
		)
		(if (== param1 0)
			(if (and (> argc 1) (IsObject param2))
				(= sel_143 param2)
			)
			(self sel_288:)
		else
			(if (and (> argc 4) param5)
				(= sel_143 param5)
			)
			(if (and (> argc 1) param2)
				(= temp0 param2)
			)
			(if (and (> argc 2) param3)
				(= temp1 param3)
			)
			(if (and (> argc 3) param4)
				(= sel_284 1)
				(= temp2 param4)
			else
				(= temp2 1)
			)
			(= sel_143 (if (and (> argc 4) param5) param5 else 0))
			(if
				(or
					(and
						(& gMsgType $0001)
						(Message msgGET temp3 param1 temp0 temp1 temp2)
					)
					0
				)
				(self sel_288: temp3 param1 temp0 temp1 temp2)
			else
				(Printf 924 0 temp3 param1 temp0 temp1 temp2) ; "<Messager> %d: %d, %d, %d, %d not found"
				(self sel_111:)
			)
		)
	)

	(method (sel_288 param1 param2 param3 param4 param5 &tmp temp0)
		(if (= temp0 (Message msgNEXT 0))
			(= temp0 (self sel_289: temp0))
			(sel_282 sel_118: temp0)
			(if argc
				(temp0 sel_287: param2 param3 param4 param5 self param1)
			else
				(temp0 sel_287: 0 0 0 0 self)
			)
		else
			(if gFastCast
				(gFastCast sel_125: sel_111:)
				(= gFastCast 0)
			)
			(gTheDoits sel_118: self)
		)
	)

	(method (sel_289)
		(Print 924 1) ; "Messager findTalker: needs to be overridden"
		(= gQuit 1)
	)
)

