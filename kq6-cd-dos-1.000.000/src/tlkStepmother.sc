;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1027)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Kq6Window)
(use Actor)

(public
	tlkStepmother 10
)

(instance tlkStepmother of Kq6Talker
	(properties
		x 100
		y 16
		view 255
		loop 5
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(= textY (= textX 0))
		(if (& gMsgType $0002)
			(= x 225)
			(= y 59)
			(super init: 0 0 momsMouth &rest)
		else
			(= x 20)
			(= y 16)
			(super init: &rest)
		)
	)
)

(instance momsMouth of Prop
	(properties
		view 255
		loop 4
	)
)

