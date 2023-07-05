;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64918)
(include sci.sh)
(use Array)

(public
	SizeOfStr 0
)

(procedure (SizeOfStr str)
	(KString 8 (KArray 9 str)) ; StrLen, ArrayGetData
)

(class Str of ByteArray
	(properties
		type 3
	)

	(method (format &tmp str)
		(if (& -info- $8000)
			(= str (Clone self))
			(str data: (KString 9 &rest)) ; StrFormat
			(return str)
		else
			(KString 10 data &rest) ; StrFormatAt
			(return self)
		)
	)

	(method (with aStr &tmp str)
		(= str (Clone self))
		(str data: (KArray 8 (KArray 9 aStr))) ; ArrayDup, ArrayGetData
		(return str)
	)

	(method (newWith n aStr &tmp str)
		(= str (Str new: n))
		(if aStr
			(str copy: aStr)
		)
		(return str)
	)

	(method (newCopies whatToCopy howMany isChar &tmp str numCopies strToCopy)
		(if (< argc 1)
			(return (Str new:))
		)
		(if (< argc 2)
			(= numCopies 1)
		else
			(= numCopies howMany)
		)
		(if (and (> argc 2) isChar)
			(= str (Str new: numCopies))
			(str fill: 0 numCopies whatToCopy)
		else
			(= str (Str newWith: (* numCopies (SizeOfStr whatToCopy))))
			(= strToCopy (KArray 9 whatToCopy)) ; ArrayGetData
			(while (>= (-- numCopies) 0)
				(str cat: strToCopy)
			)
		)
		(return str)
	)

	(method (at n &tmp temp0 temp1 temp2 temp3)
		(= temp3 (KArray 2 data n)) ; ArrayAt
		(if (> argc 1)
			(if (> (= temp1 (+ n argc -1)) (= temp2 (self size:)))
				(if (> n temp2)
					(KArray 5 data temp2 (- n temp2) 32) ; ArrayFill
				)
				(KArray 3 data temp1 0) ; ArrayAtPut
			)
			(KArray 3 data n &rest) ; ArrayAtPut
		)
		(return temp3)
	)

	(method (cat aStr)
		(self copyToFrom: (self size:) aStr 0 (+ (SizeOfStr aStr) 1))
	)

	(method (translate oldSub newSub)
		(if (< argc 2)
			(return 0)
		)
		(KString 15 data oldSub newSub data) ; StrTrn
		(return 1)
	)

	(method (all oldSub newSub &tmp i lag_i subCount selfSize subSizeOld subSizeNew makeStr)
		(if (< argc 1)
			(return 0)
		)
		(= subCount 0)
		(= lag_i 0)
		(= selfSize (self size:))
		(= subSizeOld (SizeOfStr oldSub))
		(= subSizeNew (SizeOfStr newSub))
		(= makeStr (Str new: (+ (/ selfSize 2) 1)))
		(for ((= i 0)) (<= i (- selfSize subSizeOld)) ((++ i))
			(if (> (self compToFrom: i oldSub 0 subSizeOld) 0)
				(cond
					((== argc 2)
						(if subSizeNew
							(makeStr copyToFrom: lag_i newSub 0 subSizeNew)
							(+= i (- subSizeNew 1))
							(+= lag_i subSizeNew)
						)
					)
					(subSizeOld
						(makeStr copyToFrom: lag_i oldSub 0 subSizeOld)
						(+= i (- subSizeOld 1))
						(+= lag_i subSizeOld)
					)
				)
				(++ subCount)
			)
		)
		(self copyToFrom: 0 makeStr 0 lag_i)
		(self at: lag_i 0)
		(makeStr dispose:)
		(return subCount)
	)

	(method (upper &tmp [temp0 3])
		(KString 13 data) ; StrUpr
	)

	(method (lower &tmp [temp0 3])
		(KString 14 data) ; StrLwr
	)

	(method (subStr n len &tmp l)
		(= l
			(if (== len -1)
				(- (self size:) n)
			else
				len
			)
		)
		((Str new: (+ l 1))
			copyToFrom: 0 self n l
			at: l 0
			yourself:
		)
	)

	(method (getLeft param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (< argc 1)
			(return (Str new:))
		)
		(if (< argc 2)
			(= temp0 32)
		else
			(= temp0 param2)
		)
		(if (< param1 1)
			(return (Str new:))
		)
		(= temp2 (self size:))
		(= temp1 (self subStr: 0 (if (> param1 temp2) temp2 else param1)))
		(if (and (> param1 temp2) temp0)
			(= temp3 (Str newCopies: temp0 (- param1 temp2) 1))
			(temp1 cat: temp3)
			(temp3 dispose:)
		)
		(return temp1)
	)

	(method (getRight param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (< argc 1)
			(return (Str new:))
		)
		(if (< argc 2)
			(= temp0 32)
		else
			(= temp0 param2)
		)
		(if (< param1 1)
			(return (Str new:))
		)
		(= temp2 (self size:))
		(= temp1
			(self
				subStr:
					(if (> param1 temp2)
						0
					else
						(- temp2 param1)
					)
					(if (> param1 temp2) temp2 else param1)
			)
		)
		(if (and (> param1 temp2) temp0)
			(= temp3 (Str newCopies: temp0 (- param1 temp2) 1))
			(temp3 cat: temp1)
			(temp1 dispose:)
			(= temp1 temp3)
		)
		(return temp1)
	)

	(method (indexOf c fromRight &tmp i len)
		(= len (self size:))
		(if (and (> argc 1) fromRight)
			(for ((= i (-- len))) (>= i 0) ((-- i))
				(if (== (self at: i) c)
					(return i)
				)
			)
		else
			(for ((= i 0)) (< i len) ((++ i))
				(if (== (self at: i) c)
					(return i)
				)
			)
		)
		(return -1)
	)

	(method (strIndex str fromRight &tmp selfLen strLen i)
		(= selfLen (self size:))
		(= strLen (SizeOfStr str))
		(if (and (> argc 1) fromRight)
			(for ((= i (- (- selfLen strLen) 1))) (>= i 0) ((-- i))
				(if (self compToFrom: i str 0 strLen)
					(return i)
				)
			)
		else
			(for ((= i 0)) (<= i (- selfLen strLen)) ((++ i))
				(if (self compToFrom: i str 0 strLen)
					(return i)
				)
			)
		)
		(return -1)
	)

	(method (asInteger)
		(KString 11 data) ; StrToInt
	)

	(method (size)
		(KString 8 data) ; StrLen
	)

	(method (init)
		(self at: 0 0)
	)

	(method (strMax)
		(return (- (super size:) 1))
	)

	(method (compare source)
		(return
			(if (!= (self size:) (SizeOfStr source))
				0
			else
				(self compToFrom: 0 (KArray 9 source) 0 (self size:)) ; ArrayGetData
			)
		)
	)

	(method (compToFrom to source from length &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 length) ((++ temp0))
			(if (!= (self at: (+ to temp0)) (source at: (+ from temp0)))
				(return 0)
			)
		)
		(return 1)
	)

	(method (getToken seperators token &tmp i c tok)
		(while (!= (seperators indexOf: (self at: 0)) -1)
			(self move: 0 1 -1)
		)
		(if (== (self at: 0) 0)
			(return 0)
		)
		(= tok
			(if (== argc 2)
				token
			else
				(Str new:)
			)
		)
		(= i 0)
		(for
			((= c (self at: 0)))
			(and c (== (seperators indexOf: c) -1))
			((= c (self at: 0)))
			
			(tok at: i c)
			(self move: 0 1 -1)
			(++ i)
		)
		(tok at: i 0)
		(return tok)
	)

	(method (strip actions &tmp [temp0 2] temp2 temp3 temp4)
		(= actions actions)
		(= temp2 0)
		(= temp3 0)
		(if (< argc 1)
			(= temp3 5)
		else
			(for ((= temp4 0)) (< temp4 argc) ((++ temp4))
				(switch [actions temp4]
					(4
						(|= temp3 $0004)
					)
					(1
						(|= temp3 $0001)
					)
					(2
						(|= temp3 $0002)
					)
					(7
						(= temp3 7)
					)
					(8
						(= temp2 [actions (+ temp4 1)])
						(++ temp4)
					)
				)
			)
		)
		(if temp2
			(KString 12 data temp3 temp2) ; StrTrim
		else
			(KString 12 data temp3) ; StrTrim
		)
	)

	(method (weigh strB &tmp [temp0 6])
		(KString 7 data (KArray 9 strB) -1) ; StrCmp, ArrayGetData
	)
)

