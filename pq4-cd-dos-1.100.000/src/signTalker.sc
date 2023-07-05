;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Talker)

(public
	signTalker 0
)

(instance signTalker of Narrator
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
		(super init: &rest)
	)

	(method (dispose)
		(if (& gMsgType $0002)
			(= gMsgType 2)
		)
		(super dispose: &rest)
	)
)

