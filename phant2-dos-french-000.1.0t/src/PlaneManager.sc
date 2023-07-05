;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64957)
(include sci.sh)
(use Main)
(use Menu)

(class PlaneManager of Set
	(properties
		plane 0
		forceUpdate 0
	)

	(method (add param1 &tmp temp0 temp1 temp2 temp3)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(if (== argc 1)
			(= temp0 (param1 priority:))
			(= temp3 0)
			(for ((= temp1 (self first:))) temp1 ((= temp1 (self next: temp3)))
				(= temp2 ((self value: temp1) priority:))
				(breakif (>= temp0 temp2))
				(= temp3 temp1)
			)
			(= temp1 (KList 2 param1)) ; NewNode
			(if temp3
				(KList 9 elements temp3 temp1 param1) ; AddAfter
			else
				(KList 10 elements temp1 param1) ; AddToFront
			)
			(++ size)
		else
			(super add: param1 &rest)
			(self update:)
		)
	)

	(method (addToFront)
		(self add: &rest)
	)

	(method (addToEnd)
		(self add: &rest)
	)

	(method (addAfter)
		(self add: &rest)
	)

	(method (doit)
		(if plane
			(plane doit: &rest)
		else
			(super doit: &rest)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event globalize:)
		(if plane
			(if (plane onMe: event)
				(event localize: plane)
				(plane handleEvent: event)
				(event globalize:)
			)
		else
			(|= state $0001)
			(for
				((= temp0 (self first:)))
				(and temp0 (not (event claimed:)))
				((= temp0 (self next: temp0)))
				
				(= temp1 (self value: temp0))
				(if (temp1 onMe: event)
					(event localize: temp1)
					(temp1 handleEvent: event)
					(event globalize:)
				)
			)
			(&= state $fffe)
			(if (= temp1 forceUpdate)
				(= forceUpdate 0)
				(if (== temp1 -1)
					(self update:)
				else
					(self update: temp1)
				)
			)
		)
		(event claimed:)
	)

	(method (modalPlane param1)
		(if argc
			(= plane param1)
		)
		(return plane)
	)

	(method (update param1)
		(cond
			((& state $0001)
				(= forceUpdate (if (and argc (not forceUpdate)) param1 else -1))
			)
			((and argc (self contains: param1))
				(self delete: param1)
				(self add: param1)
			)
			(else
				(self sort: 109 1)
			)
		)
	)
)

(class Cast of Set
	(properties
		plane 0
		itemList 0
		doitList 0
		eventList 0
		mousers 0
		disposing 0
	)

	(method (init param1)
		(= disposing 0)
		(super init:)
		(if (not itemList)
			(= itemList (Set new:))
		)
		(if (not doitList)
			(= doitList (Set new:))
		)
		(if (not eventList)
			(= eventList (Set new:))
		)
		(if (not mousers)
			(= mousers (Set new:))
		)
		(if argc
			(= plane param1)
		)
		(return self)
	)

	(method (dispose)
		(= disposing 1)
		((gUser mousers:) delete: self)
		(itemList release: dispose:)
		(doitList release: dispose:)
		(eventList release: dispose:)
		(mousers release: dispose:)
		(= mousers (= itemList (= doitList (= eventList 0))))
		(super dispose:)
	)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not elements)
			(self init:)
		)
		(= temp1 0)
		(while (< temp1 argc)
			(if (KList 15 elements (= temp0 [param1 temp1])) ; FindKey
				(KList 16 elements temp0) ; DeleteKey
				(-- size)
			)
			(KList 11 elements (KList 2 temp0) temp0) ; AddToEnd, NewNode
			(if (temp0 isScreenItem:)
				(itemList add: temp0)
			)
			(if (temp0 needsDoits:)
				(doitList add: temp0)
			)
			(if (temp0 needsEvents:)
				(eventList add: temp0)
			)
			(if (temp0 tracksMouse:)
				(mousers add: temp0)
				((gUser mousers:) add: self)
			)
			(++ temp1)
			(++ size)
		)
		(return size)
	)

	(method (delete param1 &tmp temp0 temp1)
		(if disposing
			(return -1)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(if (KList 16 elements temp1) ; DeleteKey
				(-- size)
			)
			(itemList delete: temp1)
			(doitList delete: temp1)
			(eventList delete: temp1)
			(mousers delete: temp1)
		)
		(return size)
	)

	(method (doit)
		(doitList doit: &rest)
	)

	(method (flush)
		(= disposing 1)
		((gUser mousers:) delete: self)
		(self eachElementDo: #dispose release:)
		(= disposing 0)
	)

	(method (handleEvent event &tmp temp0)
		(if (== argc 2)
			(event localize: plane)
			(mousers eachElementDo: #track event)
		else
			(if (= temp0 (eventList firstTrue: #onMe event))
				(temp0 handleEvent: event)
			else
				0
			)
			(return)
		)
	)

	(method (release)
		(itemList release:)
		(doitList release:)
		(eventList release:)
		(mousers release:)
		(super release: &rest)
	)
)

(class SortedCast of Cast
	(properties)

	(method (handleEvent)
		(eventList sort: 109 1)
		(super handleEvent: &rest)
	)
)

(class HotCast of Cast
	(properties
		hotList 0
	)

	(method (init param1)
		(if (not hotList)
			(= hotList (Set new:))
		)
		(super init: param1 &rest)
	)

	(method (dispose)
		(hotList release: dispose:)
		(= hotList 0)
		(super dispose:)
	)

	(method (add param1 &tmp temp0 temp1)
		(if (not elements)
			(self init:)
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(= temp0 [param1 temp1])
			(if (temp0 isHot:)
				(hotList add: temp0)
			)
		)
		(super add: param1 &rest)
	)

	(method (addHot param1 param2)
		(if (not hotList)
			(self init:)
		)
		(if (!= argc 2)
			(PrintDebug {Got %d args, should be %d\n} argc 2)
			(Empty self)
		)
		(if param2
			(hotList add: param1)
		else
			(hotList delete: param1)
		)
	)

	(method (delete param1 &tmp temp0 temp1)
		(if disposing
			(return -1)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(hotList delete: [param1 temp0])
		)
		(return (super delete: param1 &rest))
	)

	(method (hotObject param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 0)
		(= temp3 -1)
		(for
			((= temp4 (hotList first:)))
			temp4
			((= temp4 (hotList next: temp4)))
			
			(= temp0 (hotList value: temp4))
			(if (and (temp0 onMe: param1) (> (= temp1 (temp0 priority:)) temp3))
				(= temp2 temp0)
				(= temp3 temp1)
			)
		)
		(return temp2)
	)

	(method (release)
		(hotList release:)
		(super release: &rest)
	)
)

(class OnMeList of Set
	(properties)

	(method (onMe)
		(return (self firstTrue: #onMe &rest))
	)
)

