;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1012)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Kq6Window)
(use Actor)

(public
	tlkGeniePage 32
)

(instance tlkGeniePage of Kq6Talker
	(properties
		y 10
		view 890
		cel 1
		talkWidth 213
		textX 78
		textY 8
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(if (== (gCurRoom curPic:) 160)
			(self cel: 1 x: 80 y: 48 textX: 1 textY: -35 talkWidth: 213)
			(super init: 0 0 tMouth &rest)
		else
			(self cel: 1 x: 5 y: 5 textX: 76 textY: 8 talkWidth: 213)
			(super init: 0 0 0 &rest)
		)
	)
)

(instance tMouth of Prop
	(properties
		view 160
		loop 8
	)
)

