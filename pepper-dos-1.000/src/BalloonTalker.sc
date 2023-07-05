;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 877)
(include sci.sh)
(use SpeakWindow)
(use Print)
(use Talker)

(class BalloonTalker of Talker
	(properties
		x 111
		y 111
		view 2000
		winX 0
		winY 0
		tailPosn 0
		dontUpd 1
		cSpeed 6
		talkLoop -1
		forceWidth 0
		hidden 0
		offX 0
		offY 0
	)

	(method (display param1 &tmp temp0 temp1)
		((= temp0 (SpeakWindow new:)) speakObj: self)
		(if (+ winX winY)
			(temp0 x: winX y: winY)
		)
		(temp0 tailPosn: tailPosn)
		((Print new:)
			window: temp0
			font: (if (not font) 1 else font)
			width: talkWidth
			title: 0
			addText: param1
			modeless: 1
			init:
		)
	)
)

