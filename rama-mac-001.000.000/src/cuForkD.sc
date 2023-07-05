;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1211)
(include sci.sh)
(use CloseUpFork)

(public
	cuForkD 0
)

(instance cuForkD of CloseUpFork
	(properties
		animSnd 20005
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

