;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1025)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkDeadSouls 79
)

(instance tlkDeadSouls of Narrator
	(properties
		x 175
		y 160
	)

	(method (init)
		(if (> (Random 0 100) 50)
			(self x: 10)
		)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

