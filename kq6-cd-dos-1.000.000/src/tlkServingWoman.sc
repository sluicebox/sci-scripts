;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1028)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkServingWoman 86
)

(instance tlkServingWoman of Narrator
	(properties
		y 10
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

