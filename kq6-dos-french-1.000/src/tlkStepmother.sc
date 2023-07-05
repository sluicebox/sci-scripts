;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1027)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkStepmother 10
)

(instance tlkStepmother of Narrator
	(properties
		x 100
		y 16
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

