;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1024)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Lord_of_the_Dead 78
)

(instance Lord_of_the_Dead of Kq6Talker
	(properties
		name {Lord of the Dead}
		x 168
		y 53
		view 2002
		cel 1
		talkWidth 213
		textX -118
		textY 25
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
		(self setPri: 13)
	)
)

(instance tMouth of Prop
	(properties
		view 692
		loop 2
	)
)

