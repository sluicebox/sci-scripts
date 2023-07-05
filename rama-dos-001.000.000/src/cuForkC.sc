;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1210)
(include sci.sh)
(use CloseUpFork)

(public
	cuForkC 0
)

(instance cuForkC of CloseUpFork
	(properties
		animSnd 20004
	)

	(method (init)
		(Trigger client: self)
		(super init: &rest)
	)

	(method (dispose)
		(Trigger client: 0)
		(super dispose: &rest)
	)

	(method (start)
		(self setScript: StrikeFork)
	)
)

