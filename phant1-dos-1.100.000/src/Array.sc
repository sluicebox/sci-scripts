;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64920)
(include sci.sh)
(use Print)
(use System)

(class Array of Obj
	(properties
		data 0
		type -1
	)

	(method (new n &tmp array)
		(if (== self Array)
			(Prints {Can't create an array of base type Array!})
			(return 0)
		)
		(= array (super new:))
		(array
			data:
				(cond
					(argc
						(self callKernel: 0 n type)
					)
					(data
						(self callKernel: 8 data)
					)
					(else
						(self callKernel: 0 10 type)
					)
				)
		)
		(return array)
	)

	(method (with &tmp array)
		(= array (self new: argc))
		(array at: 0 &rest)
		(return array)
	)

	(method (newWith n &tmp array)
		(= array (self new: (Max (- argc 1) n)))
		(array at: 0 &rest)
		(return array)
	)

	(method (at n)
		(if (== argc 1)
			(return (self callKernel: 2 data n))
		)
		(self callKernel: 3 data n &rest)
		(return self)
	)

	(method (copyToFrom to source from length)
		(self
			callKernel: 6 data to (self callKernel: 9 source) from length
		)
		(return self)
	)

	(method (copy source)
		(if (self isClass:)
			((self new:) copy: source)
		else
			(self copyToFrom: 0 (self callKernel: 9 source) 0 -1)
		)
	)

	(method (move to from length)
		(self copyToFrom: to self from length)
	)

	(method (compToFrom to source from length)
		(return
			(not
				(self
					callKernel:
						7
						data
						to
						(self callKernel: 9 source)
						from
						length
				)
			)
		)
	)

	(method (compare source)
		(return
			(if
				(!=
					(self size:)
					(self callKernel: 1 (self callKernel: 9 source))
				)
				0
			else
				(self compToFrom: 0 (self callKernel: 9 source) 0 -1)
			)
		)
	)

	(method (fill from length val)
		(self callKernel: 5 data from length (if (== argc 3) val else 0))
	)

	(method (init val)
		(self fill: 0 -1 (if argc val else 0))
	)

	(method (size)
		(self callKernel: 1 data)
	)

	(method (dispose)
		(self callKernel: 4 data)
		(super dispose:)
	)

	(method (indexOf val fromRight &tmp i len)
		(= len (self size:))
		(if (and (> argc 1) fromRight)
			(for ((= i (-- len))) (>= i 0) ((-- i))
				(if (== (self at: i) val)
					(return i)
				)
			)
		else
			(for ((= i 0)) (< i len) ((++ i))
				(if (== (self at: i) val)
					(return i)
				)
			)
		)
		(return -1)
	)

	(method (callKernel)
		(KArray &rest)
	)
)

(class IntArray of Array
	(properties
		type 0
	)
)

(class IDArray of Array
	(properties
		type 1
	)
)

(class ByteArray of Array
	(properties
		type 2
	)
)

