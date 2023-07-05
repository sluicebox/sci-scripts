;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64912)
(include sci.sh)
(use DItem)

(class DIcon of DItem
	(properties
		type 4
	)

	(method (setSize &tmp [temp0 2])
		(= nsLeft x)
		(= nsTop y)
		(= nsRight (- (+ nsLeft (CelWide view loop cel)) 1))
		(= nsBottom (- (+ nsTop (CelHigh view loop cel)) 1))
	)
)

