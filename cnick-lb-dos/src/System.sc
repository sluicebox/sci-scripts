;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Interface)

(public
	sign 0
	umod 1
	Min 2
	Max 3
	InRect 4
	OneOf 5
	WordAt 6
	Eval 7
)

(procedure (sign x)
	(return
		(if (< x 0)
			-1
		else
			(> x 0)
		)
	)
)

(procedure (umod n modN) ; UNUSED
	(if (< (-= n (* modN (/ n modN))) 0)
		(+= n modN)
	)
	(return n)
)

(procedure (Min nums &tmp otherMin)
	(return
		(if (or (== argc 1) (< nums (= otherMin (Min &rest))))
			nums
		else
			otherMin
		)
	)
)

(procedure (Max nums &tmp otherMax)
	(return
		(if (or (== argc 1) (> nums (= otherMax (Max &rest))))
			nums
		else
			otherMax
		)
	)
)

(procedure (InRect lEdge tEdge rEdge bEdge ptxOrObj pty) ; UNUSED
	(return
		(and
			(<=
				lEdge
				(if (< argc 6)
					(ptxOrObj sel_1:)
				else
					ptxOrObj
				)
				rEdge
			)
			(<=
				tEdge
				(if (< argc 6)
					(ptxOrObj sel_0:)
				else
					pty
				)
				bEdge
			)
		)
	)
)

(procedure (OneOf what things &tmp i)
	(for ((= i 0)) (< i (- argc 1)) ((++ i))
		(if (== what [things i])
			(return (or what 1))
		)
	)
	(return 0)
)

(procedure (WordAt ptr n)
	(Memory memPEEK (+ ptr (* 2 n)))
)

(procedure (Eval obj sel)
	(obj sel: &rest)
)

(class Obj
	(properties
		sel_20 {Obj}
	)

	(method (sel_109)
		(Clone self)
	)

	(method (sel_110))

	(method (sel_57)
		(return self)
	)

	(method (sel_111)
		(DisposeClone self)
	)

	(method (sel_112 param1)
		(StrCpy param1 sel_20)
	)

	(method (sel_113 &tmp [temp0 200])
		(Print (self sel_112: @temp0))
	)

	(method (sel_96 param1)
		(param1 sel_57: self &rest)
	)

	(method (sel_116 param1)
		(RespondsTo self param1)
	)

	(method (sel_115 param1)
		(return
			(and
				(& (param1 sel_4103:) $8000)
				(not (& sel_4103 $8000))
				(== sel_4098 (param1 sel_4098:))
			)
		)
	)

	(method (sel_114 param1 &tmp temp0)
		(return
			(or
				(and
					(== sel_4098 (param1 sel_4098:))
					(== sel_4100 (param1 sel_4100:))
				)
				(and
					(= temp0 (self sel_4102:))
					(IsObject temp0)
					(temp0 sel_114: param1)
				)
			)
		)
	)

	(method (sel_117)
		(return self)
	)
)

(class Code of Obj
	(properties
		sel_20 {Code}
	)

	(method (sel_57))
)

(class Collect of Obj
	(properties
		sel_20 {Collect}
		sel_24 0
		sel_86 0
	)

	(method (sel_57)
		(self sel_119: 57 &rest)
	)

	(method (sel_112 param1)
		(Format param1 999 0 sel_20 sel_86) ; "%s [Collection of size %d]"
	)

	(method (sel_113 &tmp [temp0 40])
		(Print (self sel_112: @temp0))
		(self sel_119: 113)
	)

	(method (sel_118 param1 &tmp temp0 temp1 temp2)
		(if (not sel_24)
			(= sel_24 (NewList))
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(AddToEnd sel_24 (NewNode [param1 temp1] [param1 temp1]))
			(++ sel_86)
		)
		(return self)
	)

	(method (sel_81 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (DeleteKey sel_24 [param1 temp0])
				(-- sel_86)
			)
		)
		(return self)
	)

	(method (sel_111)
		(if sel_24
			(self sel_119: 111)
			(DisposeList sel_24)
		)
		(= sel_86 (= sel_24 0))
		(super sel_111:)
	)

	(method (sel_124)
		(FirstNode sel_24)
	)

	(method (sel_65 param1)
		(NextNode param1)
	)

	(method (sel_123)
		(return (or (== sel_24 0) (EmptyList sel_24)))
	)

	(method (sel_122 param1)
		(if (not (self sel_123:))
			(FindKey sel_24 param1)
		)
	)

	(method (sel_119 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return)
			)
			(temp2 param1: &rest)
		)
	)

	(method (sel_120 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (temp2 param1: &rest)
				(return temp2)
			)
		)
		(return 0)
	)

	(method (sel_121 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (not (temp2 param1: &rest))
				(return 0)
			)
		)
		(return 1)
	)

	(method (sel_125 &tmp temp0 temp1)
		(for ((= temp0 (FirstNode sel_24))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(self sel_81: (NodeValue temp0))
		)
	)
)

(class List of Collect
	(properties
		sel_20 {List}
	)

	(method (sel_112 param1)
		(Format param1 999 1 sel_20 sel_86) ; "%s [List of size %d]"
	)

	(method (sel_64 param1 &tmp temp0)
		(for
			((= temp0 (FirstNode sel_24)))
			(and param1 temp0)
			((= temp0 (NextNode temp0)))
			
			(-- param1)
		)
		(return
			(if temp0
				(NodeValue temp0)
			else
				0
			)
		)
	)

	(method (sel_126)
		(LastNode sel_24)
	)

	(method (sel_127 param1)
		(PrevNode param1)
	)

	(method (sel_128 param1 &tmp temp0)
		(if (not sel_24)
			(= sel_24 (NewList))
		)
		(for ((= temp0 (- argc 1))) (<= 0 temp0) ((-- temp0))
			(AddToFront sel_24 (NewNode [param1 temp0] [param1 temp0]))
			(++ sel_86)
		)
		(return self)
	)

	(method (sel_129 param1 &tmp temp0)
		(if (not sel_24)
			(= sel_24 (NewList))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(AddToEnd sel_24 (NewNode [param1 temp0] [param1 temp0]))
			(++ sel_86)
		)
		(return self)
	)

	(method (sel_130 param1 param2 &tmp temp0 temp1 temp2)
		(if (= temp2 (FindKey sel_24 param1))
			(-- argc)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp2
					(AddAfter
						sel_24
						temp2
						(NewNode [param2 temp0] [param2 temp0])
					)
				)
				(++ sel_86)
			)
		)
		(return self)
	)

	(method (sel_131 param1 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 (FirstNode sel_24))) temp1 ((= temp1 (NextNode temp1)))
			(if (== param1 (NodeValue temp1))
				(return temp0)
			)
			(++ temp0)
		)
		(return -1)
	)
)

(class Set of List
	(properties
		sel_20 {Set}
	)

	(method (sel_112 param1)
		(Format param1 999 2 sel_20 sel_86) ; "%s [Set of size %d]"
	)

	(method (sel_118 param1 &tmp temp0 temp1 temp2)
		(if (not sel_24)
			(= sel_24 (NewList))
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(= temp2 [param1 temp1])
			(if (not (self sel_122: temp2))
				(AddToEnd sel_24 (NewNode temp2 temp2))
				(++ sel_86)
			)
		)
	)
)

(class EventHandler of Set
	(properties
		sel_20 {EventHandler}
	)

	(method (sel_132 param1 &tmp temp0 temp1 temp2)
		(for
			((= temp0 (FirstNode sel_24)))
			(and temp0 (not (param1 sel_73:)))
			((= temp0 temp1))
			
			(= temp1 (NextNode temp0))
			(breakif (not (IsObject (= temp2 (NodeValue temp0)))))
			(temp2 sel_132: param1)
		)
		(param1 sel_73:)
	)
)

(class Script of Obj
	(properties
		sel_20 {Script}
		sel_42 0
		sel_29 -1
		sel_133 0
		sel_134 0
		sel_135 0
		sel_136 0
		sel_137 0
		sel_138 0
		sel_139 0
		sel_140 0
		sel_141 0
		sel_142 0
		sel_65 0
	)

	(method (sel_57 &tmp temp0)
		(if sel_141
			(sel_141 sel_57:)
		)
		(cond
			(sel_135
				(if (not (-- sel_135))
					(self sel_144:)
				)
			)
			(sel_136
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= sel_137 temp0)
					(= sel_137 temp0)
					(if (not (-- sel_136))
						(self sel_144:)
					)
				)
			)
			((and sel_138 (<= (-= sel_138 (Abs (- gGameTime sel_139))) 0))
				(= sel_138 0)
				(self sel_144:)
			)
		)
		(= sel_139 gGameTime)
	)

	(method (sel_110 param1 param2 param3)
		(= sel_139 gGameTime)
		(if (>= argc 1)
			((= sel_42 param1) sel_141: self)
			(if (>= argc 2)
				(= sel_142 param2)
				(if (>= argc 3)
					(= sel_140 param3)
				)
			)
		)
		(= sel_29 (- sel_133 1))
		(self sel_144:)
	)

	(method (sel_111 &tmp temp0)
		(if (IsObject sel_141)
			(sel_141 sel_111:)
		)
		(if (IsObject sel_134)
			(sel_134 sel_111:)
		)
		(if (IsObject sel_42)
			(sel_42
				sel_141:
					(= temp0
						(cond
							((IsObject sel_65) sel_65)
							(sel_65
								(ScriptID sel_65)
							)
						)
					)
			)
			(cond
				((not temp0) 0)
				((== gNewRoomNum gCurRoomNum)
					(temp0 sel_110: sel_42)
				)
				(else
					(temp0 sel_111:)
				)
			)
		)
		(if (and (IsObject sel_142) (== gNewRoomNum gCurRoomNum))
			(sel_142 sel_144: sel_140)
		)
		(= sel_141 (= sel_134 (= sel_42 (= sel_65 (= sel_142 0)))))
		(super sel_111:)
	)

	(method (sel_143 param1)
		(= sel_29 param1)
	)

	(method (sel_144)
		(if sel_42
			(self sel_143: (+ sel_29 1) &rest)
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

	(method (sel_132 param1)
		(if sel_141
			(sel_141 sel_132: param1)
		)
		(param1 sel_73:)
	)
)

(class Event of Obj
	(properties
		sel_20 {Event}
		sel_31 0
		sel_37 0
		sel_61 0
		sel_0 0
		sel_1 0
		sel_73 0
		sel_146 0
	)

	(method (sel_109 param1 &tmp temp0)
		(= temp0 (super sel_109:))
		(GetEvent (if argc param1 else 32767) temp0)
		(return temp0)
	)

	(method (sel_147 &tmp temp0)
		(if (!= sel_31 16384)
			(= temp0 (GetPort))
			(cond
				((not sel_146)
					(GlobalToLocal self)
				)
				((!= sel_146 temp0)
					(SetPort sel_146)
					(LocalToGlobal self)
					(SetPort temp0)
					(GlobalToLocal self)
				)
			)
			(= sel_146 temp0)
		)
		(return self)
	)

	(method (sel_148 &tmp temp0)
		(if (!= sel_31 16384)
			(= temp0 (GetPort))
			(cond
				((== sel_146 temp0)
					(LocalToGlobal self)
				)
				(sel_146
					(SetPort sel_146)
					(LocalToGlobal self)
					(SetPort temp0)
				)
			)
			(= sel_146 0)
		)
		(return self)
	)
)

