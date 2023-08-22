;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64997)
(include sci.sh)
(use WriteFeature)

(class List of Obj
	(properties
		size 0
		elements 0
	)

	(method (init)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
	)

	(method (dispose)
		(if (& state $0001)
			(PrintDebug
				{WARNING: List %s(%d) disposed during traversal}
				name
				self
			)
			(&= state $fffe)
		)
		(if elements
			(self eachElementDo: #dispose &rest)
			(KList 1 elements) ; Dispose
		)
		(= size (= elements 0))
		(super dispose:)
	)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(= temp1 0)
		(while (< temp1 argc)
			(KList 11 elements (KList 2 [param1 temp1]) [param1 temp1]) ; AddToEnd, NewNode
			(++ temp1)
			(++ size)
		)
		(return size)
	)

	(method (addAfter param1 param2 &tmp temp0 temp1 temp2)
		(if (= temp2 (KList 15 elements param1)) ; FindKey
			(-- argc)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp2
					(KList
						9 ; AddAfter
						elements
						temp2
						(KList 2 [param2 temp0]) ; NewNode
						[param2 temp0]
					)
				)
				(++ size)
			)
		)
		(return size)
	)

	(method (addToEnd)
		(self add: &rest)
	)

	(method (addToFront param1 &tmp temp0)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(for ((= temp0 (- argc 1))) (<= 0 temp0) ((-- temp0))
			(KList 10 elements (KList 2 [param1 temp0]) [param1 temp0]) ; AddToFront, NewNode
			(++ size)
		)
		(return size)
	)

	(method (allTrue param1 &tmp temp0)
		(if (& state $0001)
			(PrintDebug
				{Warning: List %s(%d) re-entering traversal\n}
				name
				self
			)
		)
		(|= state $0001)
		(= temp0 (KList 21 elements param1 &rest)) ; AllTrue
		(&= state $fffe)
		(return temp0)
	)

	(method (at param1)
		(KList 17 elements param1) ; At
	)

	(method (contains param1)
		(KList 15 elements param1) ; FindKey
	)

	(method (delete param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(if (KList 16 elements temp1) ; DeleteKey
				(-- size)
			)
		)
		(return self)
	)

	(method (doit)
		(self eachElementDo: #doit &rest)
	)

	(method (eachElementDo param1 &tmp temp0)
		(if (& state $0001)
			(PrintDebug
				{Warning: List %s(%d) re-entering traversal\n}
				name
				self
			)
		)
		(|= state $0001)
		(= temp0 (KList 19 elements param1 &rest)) ; EachElementDo
		(&= state $fffe)
		(return temp0)
	)

	(method (first)
		(KList 3 elements) ; FirstNode
	)

	(method (firstTrue param1 &tmp temp0)
		(if (& state $0001)
			(PrintDebug
				{Warning: List %s(%d) re-entering traversal\n}
				name
				self
			)
		)
		(|= state $0001)
		(= temp0 (KList 20 elements param1 &rest)) ; FirstTrue
		(&= state $fffe)
		(return temp0)
	)

	(method (indexOf param1 &tmp [temp0 2])
		(KList 18 elements param1) ; IndexOf
	)

	(method (isEmpty)
		(return (or (== elements 0) (KList 5 elements))) ; Empty
	)

	(method (last)
		(KList 4 elements) ; LastNode
	)

	(method (next param1)
		(KList 6 param1) ; NextNode
	)

	(method (new)
		((super new:) elements: (KList 0) yourself:) ; New
	)

	(method (prev param1)
		(KList 7 param1) ; PrevNode
	)

	(method (release param1)
		(if elements
			(KList 1 elements) ; Dispose
		)
		(= elements (= size 0))
		(if (and argc (== param1 -1))
			(return)
		)
		(if (and argc (== param1 1))
			(self init: &rest)
		else
			(= elements (KList 0)) ; New
		)
	)

	(method (sort param1 param2 &tmp temp0 temp1)
		(= temp0 (if argc param1 else -1))
		(= temp1 (if (> argc 1) param2 else 0))
		(KList 22 elements temp0 temp1) ; Sort
	)

	(method (value param1)
		(KList 8 param1) ; NodeValue
	)
)

(class Set of List
	(properties)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(= temp1 0)
		(while (< temp1 argc)
			(if (KList 15 elements (= temp0 [param1 temp1])) ; FindKey
				(KList 16 elements temp0) ; DeleteKey
				(-- size)
			)
			(KList 11 elements (KList 2 temp0) temp0) ; AddToEnd, NewNode
			(++ temp1)
			(++ size)
		)
		(return size)
	)

	(method (addAfter param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (= temp2 (KList 15 elements param1)) ; FindKey
			(-- argc)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(if (KList 15 elements (= temp3 [param2 temp0])) ; FindKey
					(KList 16 elements temp3) ; DeleteKey
					(-- size)
				)
				(= temp2 (KList 9 elements temp2 (KList 2 temp3) temp3)) ; AddAfter, NewNode
				(++ size)
			)
		)
		(return size)
	)

	(method (addToFront param1 &tmp temp0 temp1)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(for ((= temp0 (- argc 1))) (<= 0 temp0) ((-- temp0))
			(if (KList 15 elements (= temp1 [param1 temp0])) ; FindKey
				(KList 16 elements temp1) ; DeleteKey
				(-- size)
			)
			(KList 10 elements (KList 2 temp1) temp1) ; AddToFront, NewNode
			(++ size)
		)
		(return size)
	)

	(method (handleEvent)
		(self eachElementDo: #handleEvent &rest)
	)
)

(class Stack of Obj
	(properties
		data 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init:)
		(return temp0)
	)

	(method (init)
		(if (not data)
			(= data (List new:))
		)
	)

	(method (dispose)
		(if data
			(data dispose:)
			(= data 0)
		)
		(super dispose:)
	)

	(method (contains param1)
		(return
			(if data
				(data contains: param1)
			else
				0
			)
		)
	)

	(method (isEmpty)
		(return (or (not data) (not (data size:))))
	)

	(method (peek)
		(return
			(if (self isEmpty:)
				0
			else
				(data at: 0)
			)
		)
	)

	(method (push param1)
		(if (not argc)
			(PrintDebug {Nothing to push\n})
			(SetDebug self)
		)
		(if (not data)
			(self init:)
		)
		(data addToFront: param1)
		(data size:)
	)

	(method (pop param1 &tmp temp0)
		(if (or (not data) (not (data size:)))
			(return 0)
		)
		(= temp0 (data at: 0))
		(if (and argc (!= param1 temp0))
			(PrintDebug {Popped %d, expected %d} temp0 param1)
			(SetDebug self)
		)
		(data delete: temp0)
		(return temp0)
	)
)

