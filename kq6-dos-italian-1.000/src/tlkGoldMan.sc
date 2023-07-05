;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1035)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkGoldMan 34
)

(instance tlkGoldMan of Narrator
	(properties
		x 10
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

