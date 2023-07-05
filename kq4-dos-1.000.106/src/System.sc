;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Interface)

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

	(method (add item &tmp obj n [node 41])
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(AddToEnd elements (NewNode [item n] [item n]))
			(++ size)
		)
		(return self)
	)

	(method (delete item &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 0)
		(while (< temp0 argc)
			(if (DeleteKey elements [item temp0])
				(-- size)
				(++ temp1)
			)
			(++ temp0)
		)
		(return temp1)
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

	(method (firstTrue action &tmp temp0 temp1)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if ((NodeValue temp0) action: &rest)
				(return (NodeValue temp0))
			)
		)
		(return 0)
	)

	(method (allTrue action &tmp temp0 temp1)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if (not ((NodeValue temp0) action: &rest))
				(return 0)
			)
		)
		(return 1)
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

(class Script of Obj
	(properties
		client 0
		state -1
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
	)

	(method (doit &tmp thisSeconds)
		(cond
			(cycles
				(if (not (-- cycles))
					(client cue:)
				)
			)
			(seconds
				(= thisSeconds (GetTime 1)) ; SysTime12
				(if (!= lastSeconds thisSeconds)
					(= lastSeconds thisSeconds)
					(if (not (-- seconds))
						(client cue:)
					)
				)
			)
		)
	)

	(method (init who)
		(= client who)
		(self changeState: start)
	)

	(method (dispose)
		(if (IsObject timer)
			(timer dispose:)
		)
		(if (IsObject client)
			(client script: 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (handleEvent))
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

(class Timer of Obj
	(properties
		cycleCnt -1
		seconds -1
		lastTime -1
		client 0
	)

	(procedure (CueClient &tmp who)
		(= who client)
		(= client 0)
		(if (IsObject who)
			(if (who respondsTo: #timer)
				(who timer: 0)
			)
			(if (who respondsTo: #cue)
				(who cue:)
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
		(if (IsObject (caller timer:))
			((caller timer:) dispose:)
		)
		(= client caller)
		(gTimers add: self)
		(caller timer: self)
	)

	(method (doit &tmp theTime)
		(cond
			((!= cycleCnt -1)
				(if (not (-- cycleCnt))
					(CueClient)
				)
			)
			((!= lastTime (= theTime (GetTime 1))) ; SysTime12
				(= lastTime theTime)
				(if (not (-- seconds))
					(CueClient)
				)
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
		(= aTimer (self new:))
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
		(= aTimer (self new:))
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
		(= aTimer (self new:))
		(aTimer init: caller seconds: secs)
		(return aTimer)
	)
)

(class TO
	(properties
		timeLeft 0
	)

	(method (set cToCount)
		(= timeLeft cToCount)
	)

	(method (doit)
		(if timeLeft
			(-- timeLeft)
		)
	)
)

