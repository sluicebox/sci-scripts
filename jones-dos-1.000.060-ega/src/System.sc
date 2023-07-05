;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Interface)

(public
	sign 0
	umod 1
)

(procedure (sign x) ; UNUSED
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

(procedure (localproc_0 param1 param2 param3 param4 param5 param6) ; UNUSED
	(return
		(and
			(<=
				param1
				(if (< argc 6)
					(param5 x:)
				else
					param5
				)
				param3
			)
			(<=
				param2
				(if (< argc 6)
					(param5 y:)
				else
					param6
				)
				param4
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

	(method (showStr where)
		(Format where 999 0 name size) ; "%s [Collection of size %d]"
	)

	(method (showSelf &tmp [str 40])
		(Print (self showStr: @str))
		(self eachElementDo: #showSelf)
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
)

(class List of Collect
	(properties)

	(method (showStr where)
		(Format where 999 1 name size) ; "%s [List of size %d]"
	)

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

	(method (addToEnd obj &tmp n)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(AddToEnd elements (NewNode [obj n] [obj n]))
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

	(method (showStr where)
		(Format where 999 2 name size) ; "%s [Set of size %d]"
	)

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
		register2 0
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

	(method (init param1 param2 param3 param4)
		(= register (= register2 0))
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
					(if (>= argc 4)
						(= register2 param4)
					)
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
		port 0
	)

	(method (new mask &tmp temp0 temp1)
		(= temp0 (super new:))
		(GetEvent (if argc mask else 32767) temp0)
		(if (== (temp0 type:) 256)
			(temp0
				type: 4
				message: (if (& (temp0 modifiers:) $0003) 27 else 13)
			)
		)
		(if (or (== (temp0 type:) 2) (== (temp0 type:) 1))
			(= global447 0)
		)
		(if (== (temp0 type:) 4)
			(= global447 1)
		)
		(return temp0)
	)

	(method (localize param1 &tmp temp0 temp1)
		(= temp0 (GetPort))
		(= temp1 (if argc param1 else temp0))
		(cond
			((not port)
				(SetPort temp1)
				(GlobalToLocal self)
			)
			((not temp1)
				(SetPort port)
				(LocalToGlobal self)
			)
			((!= port temp1)
				(SetPort port)
				(LocalToGlobal self)
				(SetPort temp1)
				(GlobalToLocal self)
			)
		)
		(SetPort temp0)
		(= port temp1)
	)

	(method (globalize &tmp curPort)
		(= curPort (GetPort))
		(cond
			((== port curPort)
				(LocalToGlobal self)
			)
			(port
				(SetPort port)
				(LocalToGlobal self)
				(SetPort curPort)
			)
		)
		(= port 0)
	)
)

