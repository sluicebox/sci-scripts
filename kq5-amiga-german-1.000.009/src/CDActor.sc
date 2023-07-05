;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 931)
(include sci.sh)
(use Main)
(use User)
(use Actor)
(use System)

(class MyLooper of Code
	(properties)

	(method (doit param1 param2)
		(proc0_24 param1 param2)
	)
)

(class Head of Prop
	(properties
		cycleSpeed 6
		syncMouth 0
		client 0
		cycleCnt 0
		moveHead 1
		headCel {15372406}
	)

	(method (show))

	(method (init param1)
		(self client: param1)
		(param1 head: self)
	)

	(method (cue))

	(method (doit))

	(method (look &tmp [temp0 2]))
)

(class Body of Ego
	(properties
		head 0
		caller 0
		lookingDir 1
		normal 1
	)

	(method (init)
		(super init:)
		(if (not (IsObject head))
			((= head (Head new:)) init: self)
		)
		(= looper MyLooper)
	)

	(method (look))

	(method (cue)
		(if caller
			(caller cue:)
		)
	)

	(procedure (localproc_0) ; UNUSED
		(= head 0)
		(super dispose:)
	)

	(method (dispose)
		(if (IsObject head)
			(head dispose:)
		)
		(super dispose:)
	)

	(method (delete)
		(if (IsObject head)
			(head delete:)
			(= head 0)
		)
		(super delete:)
	)
)

