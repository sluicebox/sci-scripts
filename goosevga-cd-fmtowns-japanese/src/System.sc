;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Interface)
(use User)

(public
	sign 0
	umod 1
)

(local
	local0
	local1
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
		port 0
	)

	(method (new mask &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (super new:))
		(GetEvent (if argc mask else 32767) temp0)
		(if (& mask $8000)
			(return temp0)
		)
		(if (and local1 (== (temp0 type:) 64))
			(User prevDir: (temp0 message:))
			(temp0 type: 0)
		)
		(if
			(and
				local1
				(User prevDir:)
				(== (temp0 type:) 0)
				(or
					(<= (= temp4 (- local0 (= temp3 (GetTime)))) 0)
					(> temp4 gSpeed)
				)
			)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(switch (User prevDir:)
				(1
					(-= temp2 2)
				)
				(2
					(+= temp1 2)
					(-= temp2 2)
				)
				(3
					(+= temp1 2)
				)
				(4
					(+= temp1 2)
					(+= temp2 2)
				)
				(5
					(+= temp2 2)
				)
				(6
					(-= temp1 2)
					(+= temp2 2)
				)
				(7
					(-= temp1 2)
				)
				(8
					(-= temp1 2)
					(-= temp2 2)
				)
			)
			(temp0 x: temp1)
			(temp0 y: temp2)
			(temp0 localize:)
			(SetCursor gTheCursor 1 (temp0 x:) (temp0 y:))
			(temp0 globalize:)
			(temp0 type: 0)
			(= local0 (+ temp3 gSpeed))
		)
		(if (== (temp0 type:) 256)
			(if (& (temp0 modifiers:) $0003)
				(= local1 (not local1))
				(temp0 claimed: 1)
			else
				(temp0 type: 1)
			)
		)
		(if (and (== (temp0 type:) 512) (not (& (temp0 modifiers:) $0003)))
			(temp0 type: 2)
		)
		(return temp0)
	)

	(method (localize &tmp curPort)
		(= curPort (GetPort))
		(cond
			((not port)
				(GlobalToLocal self)
			)
			((!= port curPort)
				(SetPort port)
				(LocalToGlobal self)
				(SetPort curPort)
				(GlobalToLocal self)
			)
		)
		(= port curPort)
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

(class Timer of Obj
	(properties
		cycleCnt -1
		seconds -1
		ticksToDo -1
		lastTime -1
		client 0
	)

	(procedure (localproc_0 &tmp temp0)
		(= temp0 client)
		(= client 0)
		(if (IsObject temp0)
			(if (temp0 respondsTo: #timer)
				(temp0 timer: 0)
			)
			(if (temp0 respondsTo: #cue)
				(temp0 cue:)
			)
		)
	)

	(method (new)
		(return
			(if (== self Timer)
				(super new:)
			else
				self
			)
		)
	)

	(method (init caller)
		(= client caller)
		(gTimers add: self)
		(if (caller respondsTo: #timer)
			(if (IsObject (caller timer:))
				((caller timer:) dispose:)
			)
			(caller timer: self)
		)
	)

	(method (doit &tmp theTime)
		(cond
			((!= cycleCnt -1)
				(if (not (-- cycleCnt))
					(localproc_0)
				)
			)
			((!= seconds -1)
				(if (!= lastTime (= theTime (GetTime 1))) ; SysTime12
					(= lastTime theTime)
					(if (not (-- seconds))
						(localproc_0)
					)
				)
			)
			(
				(or
					(u< (+ ticksToDo lastTime) (GetTime))
					(and
						(u> lastTime (GetTime))
						(u> (+ ticksToDo lastTime) lastTime)
					)
				)
				(localproc_0)
			)
		)
	)

	(method (dispose)
		(if (and (IsObject client) (client respondsTo: #timer))
			(client timer: 0)
		)
		(= client 0)
	)

	(method (delete)
		(if (== client 0)
			(gTimers delete: self)
			(super dispose:)
		)
	)

	(method (setCycle caller cycles &tmp aTimer)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller cycleCnt: cycles)
		(return aTimer)
	)

	(method (set caller sec min hr &tmp aTimer ticks theSpeed [str 50])
		(if (== (= theSpeed gSpeed) 0)
			(= theSpeed 1)
		)
		(= ticks (/ (* sec 60) theSpeed))
		(if (> argc 2)
			(+= ticks (/ (* min 3600) theSpeed))
		)
		(if (> argc 3)
			(+= ticks (* (/ (* hr 3600) theSpeed) 60))
		)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller cycleCnt: ticks)
		(return aTimer)
	)

	(method (setReal caller sec min hr &tmp aTimer secs)
		(= secs sec)
		(if (> argc 2)
			(+= secs (* min 60))
		)
		(if (> argc 3)
			(+= secs (* hr 3600))
		)
		(= aTimer
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(aTimer init: caller seconds: secs)
		(return aTimer)
	)

	(method (set60ths param1 param2 &tmp temp0)
		(= lastTime (GetTime))
		(= temp0
			(if (& -info- $8000)
				(self new:)
			else
				self
			)
		)
		(temp0 init: param1 ticksToDo: param2 lastTime: (GetTime))
		(return temp0)
	)
)

