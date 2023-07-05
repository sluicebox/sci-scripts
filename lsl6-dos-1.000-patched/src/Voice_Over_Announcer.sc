;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1823)
(include sci.sh)
(use Main)
(use Talker)

(public
	Voice_Over_Announcer 33
)

(instance Voice_Over_Announcer of Narrator
	(properties
		name {Voice-Over Announcer}
		showTitle 1
		color 22
		back 152
	)

	(method (init)
		(= font gUserFont)
		(= x -1)
		(= y 150)
		(= modeless 1)
		(if (!= talkWidth -2)
			(= talkWidth 300)
		else
			(= talkWidth 100)
		)
		(super init: &rest)
	)
)

