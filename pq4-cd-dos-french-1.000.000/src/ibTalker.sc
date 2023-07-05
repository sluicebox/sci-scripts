;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Talker)

(public
	ibTalker 0
)

(instance ibTalker of Narrator
	(properties)

	(method (init)
		(= y (if (IsHiRes) 153 else 132))
		(= x -1)
		(= talkWidth 240)
		(= fore (if (IsHiRes) 17 else 28))
		(= back 0)
		(= font (if (IsHiRes) 4 else 1999))
		(super init: &rest)
	)
)

