;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64885)
(include sci.sh)
(use Main)
(use System)

(class delayDisposeScript of Obj
	(properties
		scriptId 0
	)

	(method (init aScriptId)
		(super init:)
		(= scriptId aScriptId)
		(gTheDoits add: self)
	)

	(method (doit)
		(DisposeScript scriptId)
		(gTheDoits delete: self)
		(self dispose:)
	)
)

