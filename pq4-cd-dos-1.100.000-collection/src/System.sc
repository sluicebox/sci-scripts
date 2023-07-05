;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64999)
(include sci.sh)
(use Main)

(public
	sign 0
	umod 1
	Min 2
	Max 3
	InRect 4
	OneOf 5
	Eval 6
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

(procedure (Eval obj sel)
	(obj sel: &rest)
)

(class Obj
	(properties
		scratch 0
	)

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

	(method (perform theCode)
		(theCode doit: self &rest)
	)

	(method (respondsTo selector)
		(RespondsTo self selector)
	)

	(method (isClass)
		(return (& -info- $8000))
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
				(and (= theSuper (self -super-:)) (theSuper isKindOf: what))
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
		nextNode 0
	)

	(method (new)
		((super new:) elements: (NewList) yourself:)
	)

	(method (doit)
		(self eachElementDo: #doit &rest)
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
			(if (and nextNode (== [item n] (NodeValue nextNode)))
				(= nextNode (NextNode (FindKey elements [item n])))
			)
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

	(method (eachElementDo action &tmp [temp0 2])
		(ListEachElementDo elements action &rest)
	)

	(method (firstTrue action &tmp [temp0 2])
		(ListFirstTrue elements action &rest)
	)

	(method (allTrue action &tmp [temp0 2])
		(ListAllTrue elements action &rest)
	)

	(method (release &tmp node)
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

	(method (at n &tmp node)
		(ListAt elements n)
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

	(method (indexOf obj &tmp [temp0 2])
		(ListIndexOf elements obj)
	)
)

(class Set of List
	(properties)

	(method (isDuplicate obj)
		(self contains: obj)
	)
)

(class EventHandler of Set
	(properties)

	(method (handleEvent event &tmp node evtClone ret obj)
		(= evtClone (Clone event))
		(for
			((= node (FirstNode elements)))
			(and node (not (evtClone claimed:)))
			((= node nextNode))
			
			(= nextNode (NextNode node))
			(= obj (NodeValue node))
			(obj handleEvent: evtClone)
		)
		(= ret (evtClone claimed:))
		(evtClone dispose:)
		(return ret)
	)
)

(class Cast of EventHandler
	(properties
		plane 0
	)

	(method (dispose)
		(if plane
			((plane casts:) delete: self)
			(= plane 0)
		)
		(super dispose:)
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
			(ticks
				(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
					(= ticks 0)
					(= lastTicks gGameTime)
					(self cue:)
				else
					(= lastTicks gGameTime)
				)
			)
		)
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
		(if script
			(script dispose:)
		)
		(if timer
			(timer dispose:)
		)
		(if client
			(client script: (= theNextScript next))
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
		(if (and caller (== gNewRoomNum gCurRoomNum))
			(caller cue: register)
		)
		(= seconds
			(= cycles
				(= ticks (= script (= timer (= client (= next (= caller 0))))))
			)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(if client
			(= lastTicks gGameTime)
			(self changeState: (+ state 1) &rest)
		)
	)

	(method (setScript newScript)
		(if script
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
		x 0
		y 0
		z 0
		yaw 0
		pitch 0
		roll 0
		claimed 0
		plane 0
	)

	(method (new mask &tmp event)
		(= event (super new:))
		(GetEvent (if argc mask else 32767) event)
		(return event)
	)

	(method (localize toPlane)
		(if plane
			(LocalToGlobal self plane)
		)
		(GlobalToLocal self (= plane toPlane))
		(return self)
	)

	(method (globalize)
		(if plane
			(LocalToGlobal self plane)
			(= plane 0)
		)
		(return self)
	)
)

(class Cue of Obj
	(properties
		cuee 0
		cuer 0
		register 0
	)

	(method (doit)
		(gCuees delete: self)
		(cuee cue: register cuer)
		(self dispose:)
	)
)

