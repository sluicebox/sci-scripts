;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 944)
(include sci.sh)
(use Interface)

(class FileSelector of DSelector
	(properties
		x 30
		mask 0
		nFiles 0
	)

	(method (init param1 &tmp [temp0 16] temp16 temp17 temp18)
		(if (> argc 0)
			(= mask param1)
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
			((= temp18 (FileIO fiFIND_FIRST mask @temp0 0)))
			temp18
			((= temp18 (FileIO fiFIND_NEXT @temp0)))
			
			(++ nFiles)
		)
		(if (not (= text (Memory memALLOC_NONCRIT (+ (* nFiles 30) 1))))
			(return 0)
		)
		(= temp16 0)
		(= temp17 text)
		(for
			((= temp18 (FileIO fiFIND_FIRST mask @temp0 0)))
			(and temp18 (< temp16 nFiles))
			((= temp18 (FileIO fiFIND_NEXT @temp0)))
			
			(StrCpy temp17 @temp0)
			(++ temp16)
			(+= temp17 30)
		)
		(StrAt text (* nFiles 30) 0)
		(super init:)
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

