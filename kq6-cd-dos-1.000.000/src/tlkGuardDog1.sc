;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1015)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Talker)
(use System)

(public
	tlkGuardDog1 6
	tlkGuardDog2 7
	tlkGuardDog 8
)

(instance tlkGuardDog of Narrator
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

(instance tlkGuardDog1 of Narrator
	(properties
		y 10
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(cond
			((== gCurRoomNum 800)
				(= x 100)
				(= y 119)
				(= talkWidth 190)
			)
			((OneOf gCurRoomNum 850 880 820 180 860 730) 0)
			(else
				(= x -1)
				(= y 10)
			)
		)
		(super init: &rest)
	)
)

(instance tlkGuardDog2 of Narrator
	(properties
		y 10
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(cond
			((== gCurRoomNum 800)
				(= x 10)
				(= y 65)
				(= talkWidth 96)
			)
			((OneOf gCurRoomNum 850 880 820) 0)
			(else
				(= x -1)
				(= y 10)
			)
		)
		(super init: &rest)
	)
)

