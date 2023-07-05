;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 242)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)

(public
	ro242 0
)

(instance ro242 of L7Room
	(properties)

	(method (init)
		(super init:)
		((ScriptID 64017 0) set: 41) ; oFlags
		((ScriptID 64017 0) set: 38) ; oFlags
		((ScriptID 64017 0) set: 162) ; oFlags
		((ScriptID 64017 0) clear: 34) ; oFlags
		((ScriptID 64017 0) set: 33) ; oFlags
		(gCurRoom newRoom: 240) ; ro240
	)
)

