;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1821)
(include sci.sh)
(use Main)
(use LarryTalker)

(public
	talkTitleNar 32
)

(instance talkTitleNar of LarryTalker
	(properties)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp [temp0 2])
		(self name: (global186 data:))
		(super display: param1 &rest)
	)
)

