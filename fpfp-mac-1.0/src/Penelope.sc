;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1812)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Penelope 56
)

(instance Penelope of Talker
	(properties
		x 5
		y 5
		view 1802
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
				(= x 190)
				(= y 80)
				(= textX -163)
				(= textY 10)
				(= talkWidth 135)
			)
			((== gCurRoomNum 600)
				(= x 200)
				(= y 76)
				(= textX -180)
			)
		)
		(super init: penelopeBust penelopeEyes penelopeMouth &rest)
	)
)

(instance penelopeBust of Prop
	(properties
		view 1802
		loop 1
	)
)

(instance penelopeEyes of Prop
	(properties
		nsTop 40
		nsLeft 39
		view 1802
		loop 2
	)
)

(instance penelopeMouth of Prop
	(properties
		nsTop 50
		nsLeft 37
		view 1802
	)
)

