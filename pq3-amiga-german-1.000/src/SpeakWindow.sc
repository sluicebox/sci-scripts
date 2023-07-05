;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 699)
(include sci.sh)
(use Main)
(use Window)
(use User)
(use System)

(class SpeakWindow of SysWindow
	(properties
		priority -1
		hMargin 0
		vMargin 0
		speakObj 0
		tailTop 0
		tailLeft 0
		tailBottom 0
		tailRight 0
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

	(method (repos param1 param2)
		(+= top param2)
		(+= left param1)
		(-= bottom param2)
		(-= right param1)
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(SetPort 0)
		(= priority 15)
		(= color (proc0_15 global119 global119 global118))
		(= back (proc0_15 global124 global125 global120))
		(if (not speakObj)
			(= speakObj (User alterEgo:))
		)
		(if
			(and
				(speakObj respondsTo: #head)
				(speakObj head:)
				(not (& ((speakObj head:) signal:) $0080))
			)
			(= speakObj (speakObj head:))
		)
		(= temp6 (speakObj nsTop:))
		(= temp5 (speakObj nsBottom:))
		(= temp8 (speakObj nsLeft:))
		(= temp7 (speakObj nsRight:))
		(= temp1 (speakObj nsTop:))
		(= temp2
			(/ (CelWide (speakObj view:) (speakObj loop:) (speakObj cel:)) 2)
		)
		(if (< (speakObj x:) 159)
			(= temp0 (+ (speakObj x:) temp2))
		else
			(= temp0 160)
		)
		(self move: (- temp0 left) (- temp1 (+ bottom 14)))
		(self repos: -10 -10)
		(self
			move:
				(if (< left 0)
					(- 0 left)
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
				(if (>= right 319)
					(- 319 right)
				else
					0
				)
				0
		)
		(self
			move:
				(if (< (+ right 10) temp8)
					(- 319 right)
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
					(- (speakObj y:) temp1)
				else
					(= temp4 0)
					top
				)
		)
		(if
			(and
				(> temp5 top)
				(< temp6 bottom)
				(< (- temp5 top) (- 189 bottom))
			)
			(self move: 0 (- temp5 top))
		)
		(= brTop top)
		(= brLeft left)
		(= brBottom bottom)
		(= brRight right)
		(= temp10 1)
		(if (!= priority -1)
			(|= temp10 $0002)
		)
		(if temp4
			(= tailTop (+ 1 (- brTop 11)))
			(= temp3 3)
		else
			(= tailTop (- brBottom 2))
			(= temp3 0)
		)
		(= tailBottom (+ tailTop 11))
		(cond
			((< (- left (/ (- left right) 2)) (speakObj x:))
				(+= temp3 1)
			)
			((== (- left (/ (- left right) 2)) (speakObj x:))
				(+= temp3 2)
			)
		)
		(cond
			((< (- right 10) (speakObj x:))
				(= tailRight (- right 10))
				(= tailLeft (- tailRight 20))
			)
			((> (+ left 10) (speakObj x:))
				(= tailLeft (+ left 10))
				(= tailRight (+ tailLeft 20))
			)
			(else
				(= tailLeft (speakObj x:))
				(cond
					((or (== temp3 0) (== temp3 3))
						(+= tailLeft temp2)
					)
					((or (== temp3 1) (== temp3 4))
						(-= tailLeft (+ temp2 20))
					)
				)
				(= tailRight (+ tailLeft 20))
			)
		)
		(= type 128)
		(= lsTop (Min brTop tailTop))
		(= lsBottom (Max brBottom tailBottom))
		(= lsRight brRight)
		(= lsLeft brLeft)
		(self repos: 10 10)
		(super open:)
		(= temp9 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX (- top 10) left (+ bottom 10) right temp10 back priority)
		(Graph grFILL_BOX top (- left 10) bottom (+ right 10) temp10 back priority)
		(DrawCel 997 1 0 brLeft brTop priority)
		(DrawCel 997 1 1 (- (- brRight 1) 10) brTop priority)
		(DrawCel 997 1 2 brLeft (- brBottom 10) priority)
		(DrawCel 997 1 3 (- brRight 10) (- brBottom 10) priority)
		(Graph
			grDRAW_LINE
			brTop
			(+ brLeft 10)
			brTop
			(- brRight 10)
			(proc0_15 global125 global119 global120)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 10)
			brLeft
			(- brBottom 10)
			brLeft
			(proc0_15 global125 global119 global120)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 10)
			(- brRight 1)
			(- brBottom 10)
			(- brRight 1)
			(proc0_15 global119 global119 global118)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 10)
			(- brRight 2)
			(- brBottom 10)
			(- brRight 2)
			(proc0_15 global123 global119 global120)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 1)
			(+ brLeft 10)
			(- brBottom 1)
			(- brRight 10)
			(proc0_15 global119 global119 global118)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 2)
			(+ brLeft 10)
			(- brBottom 2)
			(- brRight 10)
			(proc0_15 global122 global119 global119)
			-1
			-1
		)
		(DrawCel 997 0 temp3 tailLeft tailTop priority)
		(Graph grUPDATE_BOX brTop brLeft brBottom brRight 1)
		(SetPort temp9)
	)

	(method (dispose)
		(SetPort 0)
		(super dispose:)
	)
)

