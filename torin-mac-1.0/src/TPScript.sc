;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64030)
(include sci.sh)
(use System)

(class TPScript of Script
	(properties
		bHasFF 0
		bHasRew 0
		bKillRew 1
	)

	(method (setButtons)
		(cond
			(bHasFF
				((ScriptID 64002 6) enable:) ; oFastForward
				((ScriptID 64002 6) setScript: self) ; oFastForward
			)
			(bKillRew
				((ScriptID 64002 6) disable:) ; oFastForward
			)
		)
		(cond
			(bHasRew
				((ScriptID 64002 4) enable:) ; oRewind
				((ScriptID 64002 4) setScript: self) ; oRewind
			)
			(bKillRew
				((ScriptID 64002 4) disable:) ; oRewind
			)
		)
	)

	(method (init)
		(self setButtons:)
		(super init: &rest)
	)

	(method (ff))

	(method (rewind))

	(method (dispose)
		(if bHasFF
			((ScriptID 64002 6) disable:) ; oFastForward
			((ScriptID 64002 6) setScript: 0) ; oFastForward
		)
		(super dispose: &rest)
	)
)

