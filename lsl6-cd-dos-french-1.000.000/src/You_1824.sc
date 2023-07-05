;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1824)
(include sci.sh)
(use Main)
(use Talker)

(public
	You 34
)

(instance You of Narrator
	(properties
		showTitle 1
		back 74
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {Du})
				(33 {Tu})
				(else {You})
			)
		)
		(= font gUserFont)
		(= x -1)
		(= y 140)
		(= modeless 1)
		(super init: &rest)
	)
)

