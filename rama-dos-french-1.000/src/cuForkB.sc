;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1209)
(include sci.sh)
(use CloseUpFork)

(public
	cuForkB 0
)

(instance cuForkB of CloseUpFork
	(properties
		animSnd 20003
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

