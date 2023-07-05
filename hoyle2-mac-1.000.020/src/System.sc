;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)

(class Obj
	(properties)

	(method (new)
		(Clone self)
	)

	(method (init))

	(method (doit))

	(method (dispose)
		(DisposeClone self)
	)

	(method (isMemberOf what)
		(return
			(and
				(& (what -info-:) $8000)
				(not (& -info- $8000))
				(== species (what species:))
			)
		)
	)

	(method (isKindOf what &tmp theSuper)
		(= theSuper (self superClass:))
		(return
			(or
				(== species (what species:))
				(and (IsObject theSuper) (theSuper isKindOf: what))
			)
		)
	)

	(method (yourself)
		(return self)
	)
)

(class Col of Obj
	(properties
		elements 0
		size 0
	)

	(method (add param1 &tmp temp0 temp1)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(AddToEnd elements (NewNode [param1 temp1] [param1 temp1]))
			(++ size)
		)
		(return self)
	)

	(method (delete param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (DeleteKey elements [param1 temp0])
				(-- size)
			)
		)
		(return self)
	)

	(method (dispose)
		(if elements
			(self eachElementDo: #dispose)
			(DisposeList elements)
		)
		(= size (= elements 0))
		(super dispose:)
	)

	(method (first)
		(FirstNode elements)
	)

	(method (next param1)
		(NextNode param1)
	)

	(method (isEmpty)
		(return (or (== elements 0) (EmptyList elements)))
	)

	(method (contains param1)
		(FindKey elements param1)
	)

	(method (eachElementDo param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return)
			)
			(temp2 param1: &rest)
		)
	)

	(method (firstTrue param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (temp2 param1: &rest)
				(return temp2)
			)
		)
		(return 0)
	)

	(method (allTrue param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (not (temp2 param1: &rest))
				(return 0)
			)
		)
		(return 1)
	)
)

(class List of Col
	(properties)

	(method (at n &tmp node)
		(for
			((= node (FirstNode elements)))
			(and n node)
			((= node (NextNode node)))
			
			(-- n)
		)
		(NodeValue node)
	)

	(method (last)
		(LastNode elements)
	)

	(method (prev node)
		(PrevNode node)
	)

	(method (addToFront obj &tmp n)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n (- argc 1))) (<= 0 n) ((-- n))
			(AddToFront elements (NewNode [obj n] [obj n]))
			(++ size)
		)
		(return self)
	)

	(method (addAfter el obj &tmp n num insertNode)
		(if (= insertNode (FindKey elements el))
			(-- argc)
			(for ((= n 0)) (< n argc) ((++ n))
				(= insertNode
					(AddAfter
						elements
						insertNode
						(NewNode [obj n] [obj n])
					)
				)
				(++ size)
			)
		)
		(return self)
	)

	(method (indexOf obj &tmp n node)
		(= n 0)
		(for ((= node (FirstNode elements))) node ((= node (NextNode node)))
			(if (== obj (NodeValue node))
				(return n)
			)
			(++ n)
		)
		(return -1)
	)
)

(class Set of List
	(properties)

	(method (add item &tmp obj n anItem)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(= anItem [item n])
			(if (not (self contains: anItem))
				(AddToEnd elements (NewNode anItem anItem))
				(++ size)
			)
		)
	)
)

(class Event of Obj
	(properties
		type 0
		message 0
		modifiers 0
		y 0
		x 0
		claimed 0
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new:))
		(GetEvent (if argc param1 else 32767) temp0)
		(if
			(and
				(< (temp0 y:) 10)
				(or
					(== (temp0 type:) 256)
					(== (temp0 message:) 13)
					(== (temp0 message:) 20992)
				)
			)
			(temp0 type: 4 message: (if (and (>= argc 2) param2) 13 else 27))
		)
		(if (== (temp0 type:) 256)
			(temp0 type: 4 message: 13)
		)
		(return temp0)
	)
)

