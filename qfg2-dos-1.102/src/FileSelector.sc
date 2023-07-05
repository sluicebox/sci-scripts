;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 944)
(include sci.sh)
(use Interface)

(class FileSelector of DSelector
	(properties
		x 13
		mask 0
		nFiles 0
	)

	(method (init param1 &tmp [temp0 7] temp7 temp8 temp9)
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
			((= temp9 (FileIO fiFIND_FIRST mask @temp0 0)))
			temp9
			((= temp9 (FileIO fiFIND_NEXT @temp0)))
			
			(++ nFiles)
		)
		(if (not (= text (Memory memALLOC_NONCRIT (+ (* nFiles 13) 1))))
			(return 0)
		)
		(= temp7 0)
		(= temp8 text)
		(for
			((= temp9 (FileIO fiFIND_FIRST mask @temp0 0)))
			(and temp9 (< temp7 nFiles))
			((= temp9 (FileIO fiFIND_NEXT @temp0)))
			
			(StrCpy temp8 @temp0)
			(++ temp7)
			(+= temp8 13)
		)
		(StrAt text (* nFiles 13) 0)
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

