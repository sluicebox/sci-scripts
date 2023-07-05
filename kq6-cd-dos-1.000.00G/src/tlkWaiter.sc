;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1058)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Kq6Window)
(use Actor)

(public
	tlkWaiter 49
)

(instance tlkWaiter of Kq6Talker
	(properties
		y 10
		view 735
		loop 5
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(if (== gMsgType 2)
			(= x 100)
			(= y 104)
			(= textX -58)
			(super init: 0 0 waiterMouth &rest)
		else
			(= x -1)
			(= textY (= textX (= y 10)))
			(super init: &rest)
		)
	)
)

(instance waiterMouth of Actor
	(properties
		view 735
		loop 4
	)
)

