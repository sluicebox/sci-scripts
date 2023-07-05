;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 244)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)

(public
	ro244 0
)

(instance ro244 of L7Room
	(properties)

	(method (init)
		(super init:)
		((ScriptID 64017 0) set: 34) ; oFlags
		((ScriptID 64017 0) set: 30) ; oFlags
		((ScriptID 64017 0) set: 32) ; oFlags
		((ScriptID 64017 0) set: 33) ; oFlags
		((ScriptID 64017 0) set: 292) ; oFlags
		(gCurRoom newRoom: 240) ; ro240
	)
)

