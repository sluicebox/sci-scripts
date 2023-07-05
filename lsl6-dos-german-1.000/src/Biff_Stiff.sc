;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1144)
(include sci.sh)
(use LarryTalker)

(public
	Biff_Stiff 24
)

(instance Biff_Stiff of LarryTalker
	(properties
		name {Biff Stiff}
		view 98
		loop 1
		talkWidth 302
		showTitle 1
		color 175
		back 231
	)

	(method (init)
		(= y 135)
		(= modeless 1)
		(super init:)
	)
)

