;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1212)
(include sci.sh)
(use CloseUpFork)

(public
	cuForkE 0
)

(instance cuForkE of CloseUpFork
	(properties
		animSnd 20006
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

