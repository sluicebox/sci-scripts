;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 922)
(include sci.sh)
(use Main)
(use Interface)

(class DIcon of DItem
	(properties
		type 4
		view 0
		loop 0
		cel 0
	)

	(method (setSize)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of DItem
	(properties
		type 1
		state 3
		text 0
		font 0
	)

	(method (dispose isNotPtr)
		(if (and text (or (not argc) (not isNotPtr)))
			(Memory memFREE (self text:))
		)
		(super dispose:)
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font 0 0)
		(+= [r 2] 2)
		(+= [r 3] 2)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 15) 16) 16))
		(= nsRight (+ [r 3] nsLeft))
	)
)

(class DEdit of DItem
	(properties
		type 3
		state 1
		text 0
		font 0
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(= font gInputFont)
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

