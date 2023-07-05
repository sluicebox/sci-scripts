;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Talker)

(public
	invTalker 0
)

(instance invTalker of Narrator
	(properties)

	(method (init)
		(= talkWidth 160)
		(= font 4)
		(= modeless 2)
		(= fore 28)
		(= y (= x (= back -1)))
		(super init: &rest)
	)
)

