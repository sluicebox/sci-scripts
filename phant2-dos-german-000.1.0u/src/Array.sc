;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64920)
(include sci.sh)
(use WriteFeature)
(use System)

(class Array of Obj
	(properties
		data 0
		type -1
	)

	(method (init val)
		(self fill: 0 -1 (if argc val else 0))
	)

	(method (dispose)
		(if data
			(KArray 4 data) ; ArrayFree
		)
		(super dispose:)
	)

	(method (at n &tmp temp0)
		(= temp0 (KArray 2 data n)) ; ArrayAt
		(if (> argc 1)
			(KArray 3 data n &rest) ; ArrayAtPut
		)
		(return temp0)
	)

	(method (compare source)
		(return
			(if (!= (self size:) (KArray 1 (KArray 9 source))) ; ArraySize, ArrayGetData
				0
			else
				(self compToFrom: 0 (KArray 9 source) 0 -1) ; ArrayGetData
			)
		)
	)

	(method (compToFrom to source from length)
		(return (not (KArray 7 data to (KArray 9 source) from length))) ; ArrayCmp, ArrayGetData
	)

	(method (copy source)
		(if (self isClass:)
			((self new:) copy: source)
		else
			(self copyToFrom: 0 (KArray 9 source) 0 -1) ; ArrayGetData
		)
	)

	(method (copyToFrom to source from length)
		(KArray 6 data to (KArray 9 source) from length) ; ArrayCpy, ArrayGetData
		(return self)
	)

	(method (fill from length val)
		(KArray 5 data from length (if (== argc 3) val else 0)) ; ArrayFill
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

	(method (move to from length)
		(self copyToFrom: to self from length)
	)

	(method (new n &tmp array)
		(if (== type -1)
			(PrintDebug {Can't create an array of base type Array!})
			(return 0)
		)
		(= array (super new:))
		(array
			data:
				(cond
					(argc
						(KArray 0 n type) ; ArrayNew
					)
					(data
						(KArray 8 data) ; ArrayDup
					)
					(else
						(KArray 0 10 type) ; ArrayNew
					)
				)
		)
		(return array)
	)

	(method (newWith n &tmp array)
		(if (not argc)
			(PrintDebug {Invalid argc for Array newWith\n})
			(Empty self)
		)
		(= array (self new: (Max (- argc 1) n)))
		(array at: 0 &rest)
		(return array)
	)

	(method (size)
		(KArray 1 data) ; ArraySize
	)

	(method (with &tmp array)
		(if (not argc)
			(PrintDebug {Invalid argc for Array with\n})
			(Empty self)
		)
		(= array (self new: argc))
		(array at: 0 &rest)
		(return array)
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

