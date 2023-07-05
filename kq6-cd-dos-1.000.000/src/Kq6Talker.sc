;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 909)
(include sci.sh)
(use Main)
(use Kq6Window)
(use Print)
(use Dialog)
(use Talker)

(public
	Kq6Talker 0
)

(class Kq6Talker of Talker
	(properties
		disposeWhenDone 2
		talkWidth 270
		textX 82
		winPosn 1
	)

	(method (init param1)
		(= font gUserFont)
		(= keepWindow 1)
		(= color (Kq6Window color:))
		(= back (Kq6Window back:))
		(if (and (== gMsgType 2) argc (IsObject param1) raveName)
			(= saveX x)
			(= saveY y)
			(if (== winPosn 0)
				(= x 59)
				(= y 15)
			else
				(= x 177)
				(= y 15)
			)
		)
		(if (not (== gCurRoomNum 450))
			(= raving
				(if
					(and
						argc
						param1
						global169
						(== gMsgType 2)
						(not (Platform 5))
					)
					(Platform 6)
				)
			)
		else
			(= raving
				(if
					(and
						(or bust param1)
						global169
						(== gMsgType 2)
						(not (Platform 5))
					)
					(Platform 6)
				)
			)
		)
		(if argc
			(super init: param1 &rest)
		else
			(super init:)
		)
	)
)

(class Kq6Narrator of Narrator
	(properties
		y 10
		keepWindow 1
		strView 945
	)

	(method (init)
		(self font: gUserFont color: (Kq6Window color:) back: (Kq6Window back:))
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3)
		(if (> (+ x talkWidth) 318)
			(= temp0 (- 318 x))
		else
			(= temp0 talkWidth)
		)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(= temp2 (StrAt param1 0))
		(if (>= 90 temp2 65)
			(StrAt param1 0 9)
			((= temp3 (DIcon new:))
				view: strView
				loop: (+ 0 (/ (- temp2 65) 13))
				cel: (mod (- temp2 65) 13)
			)
			(Print
				window: temp1
				posn: x y
				font: font
				width: temp0
				addTitle: (if showTitle name else 0)
				addText: param1 0 7
				addIcon: temp3 0 0 0 0
				modeless: 1
				init:
			)
		else
			(Print
				window: temp1
				posn: x y
				font: font
				width: temp0
				title: (if showTitle name else 0)
				addText: param1
				modeless: 1
				init:
			)
		)
	)
)

