;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 970)
(include sci.sh)
(use Main)
(use SysWindow)
(use User)

(class SpeakWindow of SysWindow
	(properties
		color 18
		back 6
		hMargin 0
		vMargin 0
		underBits 0
		tailBits 0
		speakingObj 0
		tailTop 0
		tailLeft 0
		tailBottom 0
		tailRight 0
		cornerRadius 8
	)

	(method (move param1 param2)
		(+= top param2)
		(+= left param1)
		(+= bottom param2)
		(+= right param1)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 left) (- param2 top))
	)

	(method (inset param1 param2)
		(+= top param2)
		(+= left param1)
		(-= bottom param2)
		(-= right param1)
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(SetPort 0)
		(if (not speakingObj)
			(= speakingObj (User alterEgo:))
		)
		(if (and (speakingObj respondsTo: #head) (speakingObj head:))
			(= speakingObj (speakingObj head:))
		)
		(= temp1
			(-
				(= temp1
					(-
						(speakingObj y:)
						(+
							4
							(CelHigh
								(speakingObj view:)
								(speakingObj loop:)
								(speakingObj cel:)
							)
						)
					)
				)
				(speakingObj z:)
			)
		)
		(= temp0 (- (speakingObj x:) (/ (- right left) 2)))
		(self move: (- temp0 left) (- temp1 (+ bottom cornerRadius 4)))
		(self inset: (- cornerRadius) (- cornerRadius))
		(self
			move:
				(if (< left global63)
					(- global63 left)
				else
					0
				)
				(if (< top 0)
					(- 0 top)
				else
					0
				)
		)
		(self
			move:
				(if (>= right global62)
					(- global62 right)
				else
					0
				)
				0
		)
		(self
			moveTo:
				left
				(if (> bottom temp1)
					(= temp4 1)
					(+ (speakingObj y:) 12)
				else
					(= temp4 0)
					top
				)
		)
		(= brTop top)
		(= brLeft left)
		(= brBottom bottom)
		(= brRight right)
		(= underBits (Graph grSAVE_BOX brTop brLeft brBottom brRight 3))
		(if temp4
			(= tailTop (- brTop 8))
			(= temp3 4)
		else
			(= tailTop brBottom)
			(= temp3 0)
		)
		(= tailBottom (+ tailTop 8))
		(= temp2
			(/
				(CelWide
					(speakingObj view:)
					(speakingObj loop:)
					(speakingObj cel:)
				)
				2
			)
		)
		(cond
			((< (= temp5 (- left (/ (- left right) 2))) (speakingObj x:))
				(+= temp3 1)
			)
			((== temp5 (speakingObj x:))
				(+= temp3 2)
			)
		)
		(cond
			((< (- right 15) (speakingObj x:))
				(= tailRight (- right 12))
				(= tailLeft (- tailRight 12))
			)
			((> (+ left 15) (speakingObj x:))
				(= tailLeft (+ left 12))
				(= tailRight (+ tailLeft 12))
			)
			(else
				(= tailLeft (+ (speakingObj x:) 4))
				(switch (- temp3 4)
					(0
						(+= tailLeft temp2)
					)
					(1
						(-= tailLeft (+ temp2 12))
					)
					(else
						(-= tailLeft 6)
					)
				)
				(= tailRight (+ tailLeft 12))
			)
		)
		(= tailBits (Graph grSAVE_BOX tailTop tailLeft tailBottom tailRight 3))
		(DrawCel 999 0 temp3 tailLeft tailTop 15 -1)
		(self inset: cornerRadius 0)
		(Graph grFILL_BOX top left bottom right 3 back 15)
		(self inset: (- cornerRadius) cornerRadius)
		(Graph grFILL_BOX top left bottom right 3 back 15)
		(self inset: cornerRadius 0)
		(DrawCel 999 0 3 brLeft brTop 15 -1)
		(DrawCel 999 0 3 (- brRight (* cornerRadius 2)) brTop 15 -1)
		(DrawCel 999 0 3 brLeft (- brBottom (* cornerRadius 2)) 15 -1)
		(DrawCel
			999
			0
			3
			(- brRight (* cornerRadius 2))
			(- brBottom (* cornerRadius 2))
			15
			-1
		)
		(Graph grUPDATE_BOX brTop brLeft brBottom brRight 1)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX tailBits)
		(Graph grUPDATE_BOX brTop brLeft brBottom brRight 1)
		(Graph grUPDATE_BOX tailTop tailLeft tailBottom tailRight 1)
		(super dispose:)
	)
)

