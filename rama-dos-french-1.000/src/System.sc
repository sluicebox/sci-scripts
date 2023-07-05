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

	(method (info)
		(return -info-)
	)

	(method (getSuper)
		super
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
					(& (what info:) $8000)
					(not (& -info- $8000))
					(== what super)
				)
			)
		)
	)

	(method (isKindOf what &tmp theSuper)
		(return
			(or (== what self) (and (= theSuper super) (theSuper isKindOf: what)))
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
		size 0
		elements 0
		nextNode 0
	)

	(method (new)
		((super new:) elements: (KList 0) yourself:) ; New
	)

	(method (init)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(return self)
	)

	(method (doit)
		(self eachElementDo: #doit &rest)
	)

	(method (add item &tmp obj n node)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (not (self isDuplicate: [item n]))
				(KList 11 elements (KList 2 [item n]) [item n]) ; AddToEnd, NewNode
				(++ size)
			)
		)
		(return self)
	)

	(method (delete item &tmp n)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (and nextNode (== [item n] (KList 8 nextNode))) ; NodeValue
				(= nextNode (KList 6 (KList 15 elements [item n]))) ; NextNode, FindKey
			)
			(if (KList 16 elements [item n]) ; DeleteKey
				(-- size)
			)
		)
		(return self)
	)

	(method (dispose)
		(if elements
			(self eachElementDo: #dispose)
			(KList 1 elements) ; Dispose
		)
		(= size (= elements 0))
		(super dispose:)
	)

	(method (first)
		(KList 3 elements) ; FirstNode
	)

	(method (next node)
		(KList 6 node) ; NextNode
	)

	(method (isEmpty)
		(return (or (== elements 0) (KList 5 elements))) ; Empty
	)

	(method (contains anObject)
		(KList 15 elements anObject) ; FindKey
	)

	(method (eachElementDo action &tmp [temp0 2])
		(KList 19 elements action &rest) ; EachElementDo
	)

	(method (firstTrue action &tmp [temp0 2])
		(KList 20 elements action &rest) ; FirstTrue
	)

	(method (allTrue action &tmp [temp0 2])
		(KList 21 elements action &rest) ; AllTrue
	)

	(method (release &tmp node)
		(for ((= node (KList 3 elements))) node ((= node nextNode)) ; FirstNode
			(= nextNode (KList 6 node)) ; NextNode
			(self delete: (KList 8 node)) ; NodeValue
		)
	)

	(method (isDuplicate)
		(return 0)
	)

	(method (value n)
		(KList 8 n) ; NodeValue
	)
)

(class List of Collect
	(properties)

	(method (at n &tmp node)
		(KList 17 elements n) ; At
	)

	(method (last)
		(KList 4 elements) ; LastNode
	)

	(method (prev node)
		(KList 7 node) ; PrevNode
	)

	(method (addToFront obj &tmp n)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(for ((= n (- argc 1))) (<= 0 n) ((-- n))
			(if (not (self isDuplicate: [obj n]))
				(KList 10 elements (KList 2 [obj n]) [obj n]) ; AddToFront, NewNode
				(++ size)
			)
		)
		(return self)
	)

	(method (addToEnd obj &tmp n)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(for ((= n 0)) (< n argc) ((++ n))
			(if (not (self isDuplicate: [obj n]))
				(KList 11 elements (KList 2 [obj n]) [obj n]) ; AddToEnd, NewNode
				(++ size)
			)
		)
		(return self)
	)

	(method (addAfter el obj &tmp n num insertNode)
		(if (= insertNode (KList 15 elements el)) ; FindKey
			(-- argc)
			(for ((= n 0)) (< n argc) ((++ n))
				(if (not (self isDuplicate: [obj n]))
					(= insertNode
						(KList
							9 ; AddAfter
							elements
							insertNode
							(KList 2 [obj n]) ; NewNode
							[obj n]
						)
					)
					(++ size)
				)
			)
		)
		(return self)
	)

	(method (indexOf obj &tmp [temp0 2])
		(KList 18 elements obj) ; IndexOf
	)

	(method (sort theProp doDescending &tmp v des)
		(= v (if argc theProp else -1))
		(= des (if (> argc 1) doDescending))
		(KList 22 elements v des) ; Sort
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
			((= node (KList 3 elements))) ; FirstNode
			(and node (not (evtClone claimed:)))
			((= node nextNode))
			
			(= nextNode (KList 6 node)) ; NextNode
			(= obj (KList 8 node)) ; NodeValue
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
		caller 0
		client 0
		script 0
		state -1
		lastTicks 0
		ticks 0
		timer 0
		seconds 0
		next 0
		register 0
		start 0
		cycles 0
		lastSeconds 0
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
		plane 0
		x 0
		y 0
		modifiers 0
		roll 0
		yaw 0
		z 0
		type 0
		claimed 0
		message 0
		pitch 0
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
		register 0
		cuee 0
		cuer 0
	)

	(method (doit)
		(gCuees delete: self)
		(cuee cue: register cuer)
		(self dispose:)
	)
)

