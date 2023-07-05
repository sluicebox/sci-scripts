;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1009)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkGateGuard1 14
	tlkGateGuard2 15
)

(instance tlkGateGuard1 of Narrator
	(properties
		x 10
		y 10
		talkWidth 190
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

(instance tlkGateGuard2 of Narrator
	(properties
		x 110
		y 10
		talkWidth 190
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

