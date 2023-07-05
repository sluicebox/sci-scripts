;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1826)
(include sci.sh)
(use Main)
(use Talker)

(public
	talkInvNar 98
)

(instance talkInvNar of Narrator
	(properties
		showTitle 1
	)

	(method (init)
		(self font: gUserFont)
		(if global186
			(= name global186)
		)
		(super init: &rest)
	)
)

