;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64918)
(include sci.sh)
(use Array)

(public
	SizeOfStr 0
)

(procedure (SizeOfStr str)
	(KString 10 (KString 9 str)) ; StrLen, StrGetData
)

(class Str of ByteArray
	(properties
		type 3
	)

	(method (format &tmp str)
		(if (& -info- $8000)
			(= str (Clone self))
			(str data: (self callKernel: 11 &rest))
			(return str)
		else
			(self callKernel: 12 data &rest)
			(return self)
		)
	)

	(method (with aStr &tmp str)
		(= str (Clone self))
		(str data: (self callKernel: 8 (self callKernel: 9 aStr)))
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
			(= strToCopy (KString 9 whatToCopy)) ; StrGetData
			(while (>= (-- numCopies) 0)
				(str cat: strToCopy)
			)
		)
		(return str)
	)

	(method (at n &tmp c)
		(= c (super at: n &rest))
		(if (> argc 1)
			(return self)
		)
		(return c)
	)

	(method (cat aStr)
		(self copyToFrom: (self size:) aStr 0 (+ (SizeOfStr aStr) 1))
	)

	(method (translate oldSub newSub &tmp temp0 temp1 [temp2 4])
		(if (< argc 2)
			(return 0)
		)
		(self callKernel: 17 data oldSub newSub data)
		(return temp1) ; UNINIT
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

	(method (upper &tmp i mySize cur)
		(= mySize (self size:))
		(for ((= i 0)) (< i mySize) ((++ i))
			(if (and (>= (= cur (self at: i)) 97) (<= cur 122))
				(self at: i (- cur 32))
			)
		)
	)

	(method (lower &tmp i mySize cur)
		(= mySize (self size:))
		(for ((= i 0)) (< i mySize) ((++ i))
			(if (and (>= (= cur (self at: i)) 65) (<= cur 90))
				(self at: i (+ cur 32))
			)
		)
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

	(method (left charCount padAsked &tmp padChar str mySize padStr)
		(if (< argc 1)
			(return (Str new:))
		)
		(if (< argc 2)
			(= padChar 32)
		else
			(= padChar padAsked)
		)
		(if (< charCount 1)
			(return (Str new:))
		)
		(= mySize (self size:))
		(= str (self subStr: 0 (if (> charCount mySize) mySize else charCount)))
		(if (and (> charCount mySize) padChar)
			(= padStr (Str newCopies: padChar (- charCount mySize)))
			(str cat: padStr)
			(padStr dispose:)
		)
		(return str)
	)

	(method (right charCount padAsked &tmp padChar str mySize padStr)
		(if (< argc 1)
			(return (Str new:))
		)
		(if (< argc 2)
			(= padChar 32)
		else
			(= padChar padAsked)
		)
		(if (< charCount 1)
			(return (Str new:))
		)
		(= mySize (self size:))
		(= str
			(self
				subStr:
					(if (> charCount mySize)
						0
					else
						(- mySize charCount)
					)
					(if (> charCount mySize) mySize else charCount)
			)
		)
		(if (and (> charCount mySize) padChar)
			(= padStr (Str newCopies: padChar (- charCount mySize)))
			(padStr cat: str)
			(str dispose:)
			(= str padStr)
		)
		(return str)
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
		(self callKernel: 13 data)
	)

	(method (size)
		(self callKernel: 10 data)
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
				(self compToFrom: 0 (self callKernel: 9 source) 0 (self size:))
			)
		)
	)

	(method (compToFrom to source from length)
		(return
			(not (self callKernel: 7 data (self callKernel: 9 source) length))
		)
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

	(method (strip actions &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 [temp7 2] temp9 temp10 temp11)
		(= actions actions)
		(= temp0 0)
		(= temp1 0)
		(= temp2 0)
		(= temp3 0)
		(= temp6 0)
		(= temp11 0)
		(if (< argc 1)
			(= temp0 1)
			(= temp1 1)
		else
			(for ((= temp9 0)) (< temp9 argc) ((++ temp9))
				(switch [actions temp9]
					(123
						(= temp0 1)
						(|= temp11 $0004)
					)
					(124
						(= temp1 1)
						(|= temp11 $0001)
					)
					(125
						(= temp2 1)
						(|= temp11 $0002)
					)
					(126
						(= temp3 1)
						(= temp11 7)
					)
					(127
						(= temp6 [actions (+ temp9 1)])
						(++ temp9)
					)
				)
			)
		)
		(if temp6
			(self callKernel: 14 data temp11 temp6)
		else
			(self callKernel: 14 data temp11)
		)
	)

	(method (fitTo &tmp [temp0 6]))

	(method (weigh strB &tmp strA loopInt curCharA curCharB aSize bSize)
		(= strA self)
		(= aSize (self size:))
		(= bSize (strB size:))
		(for ((= loopInt 0)) (and (< loopInt aSize) (< loopInt bSize)) ((++ loopInt))
			(= curCharA (strA at: loopInt))
			(= curCharB (strB at: loopInt))
			(if (!= curCharA curCharB)
				(if (< curCharA curCharB)
					(return -1)
				else
					(return 1)
				)
			)
		)
		(cond
			((== aSize bSize)
				(return 0)
			)
			((< aSize bSize)
				(return -1)
			)
			(else
				(return 1)
			)
		)
	)

	(method (callKernel)
		(KString &rest)
	)
)

