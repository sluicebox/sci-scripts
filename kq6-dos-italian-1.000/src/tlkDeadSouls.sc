;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1025)
(include sci.sh)
(use Main)
(use Kq6Window)
(use n913)
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
		(self y: (proc913_5 160 160 160 155 160))
		(self x: 10)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(super init: &rest)
	)
)

