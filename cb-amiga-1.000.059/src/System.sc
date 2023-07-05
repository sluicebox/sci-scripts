;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Interface)

(public
	sign 0
	umod 1
	Min 2
	Max 3
	InRect 4
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

(procedure (umod n modN)
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

(procedure (InRect lEdge tEdge rEdge bEdge ptxOrObj pty)
	(return
		(and
			(<=
				lEdge
				(if (< argc 6)
					(ptxOrObj x:)
				else
					ptxOrObj
				)
				rEdge
			)
			(<=
				tEdge
				(if (< argc 6)
					(ptxOrObj y:)
				else
					pty
				)
				bEdge
			)
		)
	)
)

(class Obj
	(properties)

	(method (new)
		(Clone self)
	)

	(method (init))

	(method (doit)
		(return self)
	)

	(method (dispose)
		(DisposeClone self)
	)

	(method (showStr where)
		(StrCpy where name)
	)

	(method (showSelf &tmp [str 200])
		(Print (self showStr: @str))
	)

	(method (perform theCode)
		(theCode doit: self &rest)
	)

	(method (respondsTo selector)
		(RespondsTo self selector)
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

(class Code of Obj
	(properties)

	(method (doit))
)

(class Collect of Obj
	(properties
		elements 0
		size 0
	)

	(method (add item &tmp obj n node)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(AddToEnd elements (NewNode [item n] [item n]))
			(++ size)
		)
		(return self)
	)

	(method (delete item &tmp n)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (DeleteKey elements [item n])
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

	(method (next node)
		(NextNode node)
	)

	(method (isEmpty)
		(return (or (== elements 0) (EmptyList elements)))
	)

	(method (contains anObject)
		(FindKey elements anObject)
	)

	(method (eachElementDo action &tmp node nextNode obj)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(if (not (IsObject (= obj (NodeValue node))))
				(return)
			)
			(obj action: &rest)
		)
	)

	(method (firstTrue action &tmp node nextNode obj)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(= obj (NodeValue node))
			(if (obj action: &rest)
				(return obj)
			)
		)
		(return 0)
	)

	(method (allTrue action &tmp node nextNode obj)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(= obj (NodeValue node))
			(if (not (obj action: &rest))
				(return 0)
			)
		)
		(return 1)
	)

	(method (release &tmp node nextNode)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(self delete: (NodeValue node))
		)
	)

	(method (at param1 &tmp temp0)
		(for
			((= temp0 (FirstNode elements)))
			(and param1 temp0)
			((= temp0 (NextNode temp0)))
			
			(-- param1)
		)
		(NodeValue temp0)
	)

	(method (last)
		(LastNode elements)
	)

	(method (prev param1)
		(PrevNode param1)
	)

	(method (addToFront param1 &tmp temp0)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp0 (- argc 1))) (<= 0 temp0) ((-- temp0))
			(AddToFront elements (NewNode [param1 temp0] [param1 temp0]))
			(++ size)
		)
		(return self)
	)

	(method (addToEnd param1 &tmp temp0)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(AddToEnd elements (NewNode [param1 temp0] [param1 temp0]))
			(++ size)
		)
		(return self)
	)

	(method (indexOf param1 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 (FirstNode elements))) temp1 ((= temp1 (NextNode temp1)))
			(if (== param1 (NodeValue temp1))
				(return temp0)
			)
			(++ temp0)
		)
		(return -1)
	)
)

(class Set of Collect
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

(class EventHandler of Set
	(properties)

	(method (handleEvent event &tmp node nextNode obj)
		(for
			((= node (FirstNode elements)))
			(and node (not (event claimed:)))
			((= node nextNode))
			
			(= nextNode (NextNode node))
			(breakif (not (IsObject (= obj (NodeValue node)))))
			(obj handleEvent: event)
		)
		(event claimed:)
	)
)

(class Script of Obj
	(properties
		client 0
		state -1
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		register 0
		script 0
		caller 0
	)

	(method (doit &tmp thisSeconds)
		(if script
			(script doit:)
		)
		(cond
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= thisSeconds (GetTime 1)) ; SysTime12
				(if (!= lastSeconds thisSeconds)
					(= lastSeconds thisSeconds)
					(if (not (-- seconds))
						(self cue:)
					)
				)
			)
		)
	)

	(method (init who whoCares reg)
		(if (>= argc 1)
			(= client who)
			(if (>= argc 2)
				(= caller whoCares)
				(if (>= argc 3)
					(= register reg)
				)
			)
		)
		(self changeState: start)
	)

	(method (dispose)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(if (IsObject client)
			(client script: 0)
		)
		(if (IsObject caller)
			(caller cue: register)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if (= script newScript)
			(script init: self &rest)
		)
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(event claimed:)
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

	(method (new mask &tmp event)
		(= event (super new:))
		(GetEvent (if argc mask else 32767) event)
		(return event)
	)
)

