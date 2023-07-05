;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Actor)

(class ActorBody of CDActor
	(properties
		lookingDir 1
	)

	(method (init)
		(super init:)
		(if (not head)
			(= head (Head new:))
			(head init: self)
		)
		(= looper MyLooper)
	)

	(method (look param1)
		(= lookingDir param1)
	)

	(method (get))

	(method (put))
)

