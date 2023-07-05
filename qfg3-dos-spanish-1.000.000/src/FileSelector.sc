;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 944)
(include sci.sh)
(use Dialog)

(procedure (SortFileNames theNames theLen &tmp i j [temp 13] swapped theName theNextName)
	(for ((= i (- theLen 1))) (> i 0) ((-- i))
		(= swapped 0)
		(for ((= j 0)) (< j i) ((++ j))
			(= theNextName (+ (= theName (+ theNames (* j 13))) 13))
			(if (< (StrCmp theNextName theName) 0)
				(StrCpy @temp theName)
				(StrCpy theName theNextName)
				(StrCpy theNextName @temp)
				(= swapped 1)
			)
		)
		(breakif (not swapped))
	)
)

(class FileSelector of DSelector
	(properties
		x 13
		mask 0
		nFiles 0
		sort 1
	)

	(method (readFiles theMask &tmp [fileName 7] i cp rc)
		(if (> argc 0)
			(= mask theMask)
		)
		(if (not mask)
			(= mask {*.*})
		)
		(if text
			(Memory memFREE text)
			(= text 0)
		)
		(= nFiles 0)
		(for
			((= rc (FileIO fiFIND_FIRST mask @fileName 0)))
			rc
			((= rc (FileIO fiFIND_NEXT @fileName)))
			
			(++ nFiles)
		)
		(if (not (= text (Memory memALLOC_NONCRIT (+ (* nFiles 13) 1))))
			(return 0)
		)
		(= i 0)
		(= cp text)
		(for
			((= rc (FileIO fiFIND_FIRST mask @fileName 0)))
			(and rc (< i nFiles))
			((= rc (FileIO fiFIND_NEXT @fileName)))
			
			(StrCpy cp @fileName)
			(++ i)
			(+= cp 13)
		)
		(StrAt text (* nFiles 13) 0)
		(if sort
			(SortFileNames text nFiles)
		)
		(return 1)
	)

	(method (setSize &tmp [r 4])
		(super setSize:)
		(TextSize @[r 0] {M} font)
		(= nsRight (+ nsLeft (* [r 3] x)))
	)

	(method (dispose)
		(if text
			(Memory memFREE text)
			(= text 0)
		)
		(super dispose:)
	)
)

