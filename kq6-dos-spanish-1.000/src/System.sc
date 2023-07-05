;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Print)

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
		(Prints (self showStr: @str))
	)

	(method (perform theCode)
		(theCode doit: self &rest)
	)

	(method (respondsTo selector)
		(RespondsTo self selector)
	)

	(method (isMemberOf what)
		(return
			(or
				(== what self)
				(and
					(& (what -info-:) $8000)
					(not (& -info- $8000))
					(== -propDict- (what -propDict-:))
				)
			)
		)
	)

	(method (isKindOf what &tmp theSuper)
		(return
			(or
				(and
					(== -propDict- (what -propDict-:))
					(== -classScript- (what -classScript-:))
				)
				(and
					(= theSuper (self -super-:))
					(IsObject theSuper)
					(theSuper isKindOf: what)
				)
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

	(method (doit)
		(self eachElementDo: #doit &rest)
	)

	(method (showStr where)
		(Format where 999 0 name size) ; "%s [Collection of size %d]"
	)

	(method (showSelf &tmp [str 40])
		(Prints (self showStr: @str))
		(self eachElementDo: #showSelf)
	)

	(method (add item &tmp obj n node)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (not (self isDuplicate: [item n]))
				(AddToEnd elements (NewNode [item n] [item n]))
				(++ size)
			)
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

	(method (isDuplicate)
		(return 0)
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
		(return
			(if node
				(NodeValue node)
			else
				0
			)
		)
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
			(if (not (self isDuplicate: [obj n]))
				(AddToFront elements (NewNode [obj n] [obj n]))
				(++ size)
			)
		)
		(return self)
	)

	(method (addToEnd obj &tmp n)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (not (self isDuplicate: [obj n]))
				(AddToEnd elements (NewNode [obj n] [obj n]))
				(++ size)
			)
		)
		(return self)
	)

	(method (addAfter el obj &tmp n num insertNode)
		(if (= insertNode (FindKey elements el))
			(-- argc)
			(for ((= n 0)) (< n argc) ((++ n))
				(if (not (self isDuplicate: [obj n]))
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

	(method (isDuplicate obj)
		(self contains: obj)
	)
)

(class EventHandler of Set
	(properties)

	(method (handleEvent event &tmp node nextNode obj evtClone ret)
		(= evtClone (Clone event))
		(for
			((= node (FirstNode elements)))
			(and node (not (evtClone claimed:)))
			((= node nextNode))
			
			(= nextNode (NextNode node))
			(breakif (not (IsObject (= obj (NodeValue node)))))
			(obj handleEvent: evtClone)
		)
		(= ret (evtClone claimed:))
		(evtClone dispose:)
		(return ret)
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
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
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
			((and ticks (<= (-= ticks (Abs (- gGameTime lastTicks))) 0))
				(= ticks 0)
				(self cue:)
			)
		)
		(= lastTicks gGameTime)
	)

	(method (init who whoCares reg)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client who) script: self)
			(if (>= argc 2)
				(= caller whoCares)
				(if (>= argc 3)
					(= register reg)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose &tmp theNextScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(if (IsObject client)
			(client
				script:
					(= theNextScript
						(cond
							((IsObject next) next)
							(next
								(ScriptID next)
							)
						)
					)
			)
			(cond
				((not theNextScript) 0)
				((== gNewRoomNum gCurRoomNum)
					(theNextScript init: client)
				)
				(else
					(theNextScript dispose:)
				)
			)
		)
		(if (and (IsObject caller) (== gNewRoomNum gCurRoomNum))
			(caller cue: register)
		)
		(= script (= timer (= client (= next (= caller 0)))))
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(if client
			(self changeState: (+ state 1) &rest)
		)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
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

	(method (new mask &tmp event)
		(= event (super new:))
		(GetEvent (if argc mask else 32767) event)
		(return event)
	)

	(method (localize &tmp curPort)
		(if (not (& type $4000))
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
		(return self)
	)

	(method (globalize &tmp curPort)
		(if (not (& type $4000))
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
		(return self)
	)
)

(class Cursor of Obj
	(properties
		view 0
		loop 0
		cel 0
		x 0
		y 0
		hotSpotX 0
		hotSpotY 0
		hidden 1
	)

	(method (init)
		(if (or hotSpotX hotSpotY)
			(SetCursor view loop cel hotSpotX hotSpotY)
		else
			(SetCursor view loop cel)
		)
	)

	(method (posn theX theY)
		(SetCursor theX theY)
	)

	(method (posnHotSpot theX theY)
		(= hotSpotX theX)
		(= hotSpotY theY)
		(self init:)
	)

	(method (setLoop whichLoop)
		(= loop whichLoop)
		(self init:)
	)

	(method (setCel whichCel)
		(= cel whichCel)
		(self init:)
	)

	(method (showCursor trueOrFalse)
		(if argc
			(= hidden trueOrFalse)
			(SetCursor hidden)
		)
	)
)

