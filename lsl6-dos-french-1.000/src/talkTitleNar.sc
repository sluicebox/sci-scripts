;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1821)
(include sci.sh)
(use Main)
(use Print)
(use Talker)

(public
	talkTitleNar 32
)

(instance talkTitleNar of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)

	(method (display)
		(if global186
			(Print addTitle: global186)
		)
		(super display: &rest)
	)
)

