;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Print)
(use Talker)
(use System)

(public
	Eco2Talker 0
)

(class Eco2Talker of Talker
	(properties
		keepWindow 1
		dftBack 8
		textSpacer 40
	)

	(method (display)
		(Print mode: 1)
		(super display: &rest)
	)

	(method (setupTalker param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp0 (if (< argc 2) dftBack else param2))
		(if (> argc 2)
			(= textSpacer param3)
		)
		(= temp1 (CelWide view 1 0))
		(= temp2 (CelHigh view 1 0))
		(self
			x:
				(if (OneOf param1 2 4)
					(- 319 (+ temp1 5))
				else
					5
				)
			y:
				(if (OneOf param1 6 4)
					(- 189 (+ temp2 5))
				else
					5
				)
			textX:
				(if (OneOf param1 2 4)
					(- (+ talkWidth textSpacer))
				else
					(+ temp1 textSpacer)
				)
			textY: 10
			back: temp0
		)
	)
)

