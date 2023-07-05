;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1009)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Kq6Window)
(use n913)
(use Actor)

(public
	tlkGateGuard1 14
	tlkGateGuard2 15
)

(instance tlkGateGuard1 of Kq6Talker
	(properties
		x 10
		y 10
		view 890
		cel 1
		talkWidth 190
	)

	(method (dispose)
		(super dispose: &rest)
		(= y (= x 10))
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(cond
			((== gMsgType 1)
				(= textY 10)
				(super init: 0 0 0 &rest)
			)
			((and (== gCurRoomNum 220) (== ((ScriptID 220 3) y:) 97)) ; guard1
				(= textY 0)
				(gd1Mouth loop: 6)
				(= x 91)
				(= y 58)
				(super init: 0 0 gd1Mouth &rest)
			)
			((and (== gCurRoomNum 220) (== ((ScriptID 220 3) y:) 119)) ; guard1
				(= textY 0)
				(gd1Mouth loop: 6)
				(= x 102)
				(= y 80)
				(super init: 0 0 gd1Mouth &rest)
			)
			(
				(and
					(== gCurRoomNum 220)
					(== ((ScriptID 220 3) loop:) 0) ; guard1
					(== ((ScriptID 220 3) cel:) 0) ; guard1
				)
				(= textY 0)
				(gd1Mouth loop: 6)
				(= x 95)
				(= y 71)
				(super init: 0 0 gd1Mouth &rest)
			)
			((IsFlag 162)
				(= textY 0)
				(gd1Mouth loop: 6)
				(= x 100)
				(= y 70)
				(super init: 0 0 gd1Mouth &rest)
			)
			(else
				(gd1Mouth loop: 4)
				(= x 94)
				(= y 70)
				(= textY 0)
				(super init: 0 0 gd1Mouth &rest)
			)
		)
	)
)

(instance tlkGateGuard2 of Kq6Talker
	(properties
		x 20
		y 10
		view 890
		cel 1
		talkWidth 190
		textY -10
	)

	(method (dispose)
		(super dispose: &rest)
		(= x 20)
		(= y 10)
	)

	(method (init)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(if (or (== gMsgType 1) (IsFlag 162))
			(= textY 10)
			(super init: 0 0 0 &rest)
		else
			(= x 133)
			(= y 70)
			(= textY -10)
			(super init: 0 0 gd2Mouth &rest)
		)
	)
)

(instance gd1Mouth of Prop
	(properties
		view 224
		loop 4
	)
)

(instance gd2Mouth of Prop
	(properties
		view 224
		loop 5
	)
)

