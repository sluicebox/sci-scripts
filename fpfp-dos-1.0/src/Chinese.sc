;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1844)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Chinese 12
)

(instance Chinese of Talker
	(properties
		x 5
		y 5
		view 1844
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: chineseBust chineseEyes chineseMouth &rest)
	)
)

(instance chineseBust of Prop
	(properties
		view 1844
		loop 1
	)
)

(instance chineseEyes of Prop
	(properties
		nsTop 29
		nsLeft 39
		view 1844
		loop 2
	)
)

(instance chineseMouth of Prop
	(properties
		nsTop 42
		nsLeft 26
		view 1844
	)
)

