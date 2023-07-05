;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1802)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Srini 40
)

(instance Srini of Talker
	(properties
		x 5
		y 5
		view 1801
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(if (== gCurRoomNum 790)
			(= x 190)
			(= y 80)
			(= textX -163)
			(= textY 20)
			(= talkWidth 135)
			(super init: sriniBust sriniEyes sriniMouth &rest)
		else
			(super init: sriniBust sriniEyes sriniMouth &rest)
		)
	)
)

(instance sriniBust of Prop
	(properties
		view 1801
		loop 1
	)
)

(instance sriniEyes of Prop
	(properties
		nsTop 45
		nsLeft 45
		view 1801
		loop 2
	)
)

(instance sriniMouth of Prop
	(properties
		nsTop 51
		nsLeft 41
		view 1801
	)
)

