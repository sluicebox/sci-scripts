;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1817)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Madame 47
)

(instance Madame of Talker
	(properties
		x 5
		y 5
		view 1803
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(cond
			((== gCurRoomNum 790)
				(= x 208)
				(= y 65)
				(= textX -163)
				(= textY 40)
				(= talkWidth 135)
				(super init: madameBust madameEyes madameMouth &rest)
			)
			((== gCurRoomNum 420)
				(= y (= x 0))
				(= textX 10)
				(= textY 140)
				(= talkWidth 290)
				(super
					init: madameCloseBust madameCloseEyes madameCloseMouth &rest
				)
			)
			((== gCurRoomNum 600)
				(= x 208)
				(= y 65)
				(= textX -180)
				(super init: madameBust madameEyes madameMouth &rest)
			)
			(else
				(super init: madameBust madameEyes madameMouth &rest)
			)
		)
	)
)

(instance madameCloseBust of Prop
	(properties
		view 1843
	)
)

(instance madameCloseEyes of Prop
	(properties
		nsTop 80
		nsLeft 114
		view 420
	)
)

(instance madameCloseMouth of Prop
	(properties
		nsTop 96
		nsLeft 106
		view 420
		loop 1
	)
)

(instance madameBust of Prop
	(properties
		view 1803
		loop 1
	)
)

(instance madameEyes of Prop
	(properties
		nsTop 48
		nsLeft 41
		view 1803
		loop 2
	)
)

(instance madameMouth of Prop
	(properties
		nsTop 64
		nsLeft 42
		view 1803
	)
)

