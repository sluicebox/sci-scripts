;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Talker)

(public
	computerTalker 0
)

(instance computerTalker of Narrator
	(properties)

	(method (init)
		(= talkWidth 160)
		(= font 4)
		(= modeless 2)
		(= fore 28)
		(= y (= x (= back -1)))
		(if (& gMsgType $0002)
			(= gMsgType 3)
		)
		(gPqFlags set: 179)
		(super init: &rest)
	)

	(method (dispose)
		(gPqFlags clear: 179)
		(if (& gMsgType $0002)
			(= gMsgType 3)
		)
		(super dispose: &rest)
	)
)

