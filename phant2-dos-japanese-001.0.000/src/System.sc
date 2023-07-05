;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64999)
(include sci.sh)
(use Main)
(use Array)
(use WriteFeature)

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

(procedure (umod n modN) ; UNUSED
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

(procedure (InRect lEdge tEdge rEdge bEdge ptxOrObj pty) ; UNUSED
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

(class Code of Obj
	(properties)

	(method (doit))
)

(class Send of Obj
	(properties
		state 256
		plane -1
		register 0
		cuee 0
		cueSelector 0
		cuer 0
	)

	(method (new param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (super new:))
		(= temp1 0)
		(if argc
			(temp0 cuee: param1)
			(if (and param1 (param1 respondsTo: #plane))
				(= temp1 (param1 plane:))
			)
			(if (> argc 1)
				(temp0 cueSelector: param2)
				(if (> argc 2)
					(temp0 register: param3)
					(if (> argc 3)
						(temp0 cuer: param4)
					)
				)
			)
		)
		(if temp1
			(temp0 plane: temp1)
			(temp1 add: temp0)
		else
			(temp0 plane: 0)
			(gCast add: temp0)
		)
		(return temp0)
	)

	(method (dispose)
		(if plane
			((plane cast:) delete: self)
		else
			(gCast delete: self)
		)
		(= plane (= cuee (= cuer (= register (= cueSelector 0)))))
		(super dispose: &rest)
	)

	(method (doit)
		(Eval cuee cueSelector register)
		(self dispose:)
	)
)

(class SendMany of Send
	(properties)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new: param1 param2))
		(if (> argc 10)
			(PrintDebug
				{Too many params (%d) for SendMany (Max 10)\n}
				(- argc 2)
			)
			(Empty self)
		)
		(temp0
			register:
				(if (> argc 2)
					(IntArray with: &rest)
				else
					0
				)
		)
		(return temp0)
	)

	(method (doit)
		(switch
			(if register
				(register size:)
			else
				0
			)
			(0
				(Eval cuee cueSelector)
			)
			(1
				(Eval cuee cueSelector (register at: 0))
			)
			(2
				(Eval cuee cueSelector (register at: 0) (register at: 1))
			)
			(3
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
				)
			)
			(4
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
					(register at: 3)
				)
			)
			(5
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
					(register at: 3)
					(register at: 4)
				)
			)
			(6
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
					(register at: 3)
					(register at: 4)
					(register at: 5)
				)
			)
			(7
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
					(register at: 3)
					(register at: 4)
					(register at: 5)
					(register at: 6)
				)
			)
			(else
				(Eval
					cuee
					cueSelector
					(register at: 0)
					(register at: 1)
					(register at: 2)
					(register at: 3)
					(register at: 4)
					(register at: 5)
					(register at: 6)
					(register at: 7)
				)
			)
		)
		(self dispose:)
	)

	(method (dispose)
		(if register
			(register dispose:)
		)
		(super dispose: &rest)
	)
)

(class Cue of Send
	(properties
		cueSelector 20
	)

	(method (new param1 param2 param3 &tmp temp0 temp1)
		(= temp1 (if argc param1 else 0))
		(= temp0 (super new: temp1))
		(if (> argc 1)
			(temp0 register: param2)
			(if (> argc 2)
				(temp0 cuer: param3)
			)
		)
		(return temp0)
	)
)

