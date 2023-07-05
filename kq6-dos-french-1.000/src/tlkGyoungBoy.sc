;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1019)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)

(public
	tlkGyoungBoy 22
)

(instance tlkGyoungBoy of Narrator
	(properties
		x 10
		y 10
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(if (== gCurRoomNum 260)
			(= x 110)
		)
		(super init: &rest)
	)
)

