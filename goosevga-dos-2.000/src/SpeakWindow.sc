;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Window)
(use User)
(use System)

(procedure (localproc_0 param1 param2)
	(return (if (>= global106 256) param1 else param2))
)

(class SpeakWindow of SysWindow
	(properties
		priority -1
		hMargin 0
		vMargin 0
		speakingObj 0
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

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= priority 15)
		(= color (gSystemWindow color:))
		(= back 6)
		(if (not (IsObject speakingObj))
			(= speakingObj (User alterEgo:))
		)
		(if
			(and
				(speakingObj respondsTo: #head)
				(speakingObj head:)
				(not (& ((speakingObj head:) signal:) $0080))
			)
			(= speakingObj (speakingObj head:))
		)
		(= temp6 (speakingObj nsTop:))
		(= temp5 (speakingObj nsBottom:))
		(= temp8 (speakingObj nsLeft:))
		(= temp7 (speakingObj nsRight:))
		(= temp1 (speakingObj nsTop:))
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
		(if (< (speakingObj x:) 159)
			(= temp0 (+ (speakingObj x:) temp2))
		else
			(= temp0 160)
		)
		(self move: (- temp0 left) (- temp1 (+ bottom 16)))
		(self repos: -10 -10)
		(self
			move:
				(if (< left global61)
					(- global61 left)
				else
					0
				)
				(if (< top 4)
					(- 4 top)
				else
					0
				)
		)
		(self
			move:
				(if (>= right 320)
					(- 320 right)
				else
					0
				)
				0
		)
		(self
			move:
				(if (< (+ right 10) temp8)
					(- global60 right)
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
					(+ temp1 25)
				else
					(= temp4 0)
					top
				)
		)
		(cond
			((== global343 1)
				(= temp4 0)
				(self moveTo: 50 4)
			)
			((== global343 2)
				(self moveTo: (- 320 (- right left)) 10)
				(= temp4 0)
			)
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
			(= tailTop (+ 1 (- brTop 9)))
			(= temp3 3)
		else
			(= tailTop (- brBottom 2))
			(= temp3 0)
		)
		(= tailBottom (+ tailTop 9))
		(if (< (- left (/ (- left right) 2)) (speakingObj x:))
			(+= temp3 1)
			(= temp11 0)
		else
			(= temp11 1)
		)
		(cond
			((< (- right 10) (speakingObj x:))
				(= tailRight (- right 10))
				(= tailLeft (- tailRight 11))
			)
			((> (+ left 10) (speakingObj x:))
				(= tailLeft (+ left 10))
				(= tailRight (+ tailLeft 11))
			)
			(else
				(if temp11
					(= tailLeft (+ (speakingObj nsRight:) 2))
				else
					(= tailLeft (- (- (speakingObj nsLeft:) 11) 2))
				)
				(= tailRight (+ tailLeft 11))
			)
		)
		(= type 128)
		(= lsTop (Min brTop tailTop))
		(= lsBottom
			(if global343
				(+ brBottom 9)
			else
				(Max brBottom tailBottom)
			)
		)
		(= lsRight brRight)
		(= lsLeft brLeft)
		(self repos: 10 10)
		(super open:)
		(= temp9 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX (- top 10) left (+ bottom 10) right temp10 back priority)
		(Graph grFILL_BOX top (- left 10) bottom (+ right 10) temp10 back priority)
		(DrawCel 999 1 0 brLeft brTop priority)
		(DrawCel 999 1 1 (- (- brRight 1) 10) brTop priority)
		(DrawCel 999 1 2 brLeft (- brBottom 10) priority)
		(DrawCel 999 1 3 (- brRight 10) (- brBottom 10) priority)
		(Graph
			grDRAW_LINE
			brTop
			(+ brLeft 10)
			brTop
			(- brRight 10)
			(localproc_0 6 (gSystemWindow color:))
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 10)
			brLeft
			(- brBottom 10)
			brLeft
			(localproc_0 6 (gSystemWindow color:))
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 10)
			(- brRight 1)
			(- brBottom 10)
			(- brRight 1)
			(gSystemWindow color:)
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 1)
			(+ brLeft 10)
			(- brBottom 1)
			(- brRight 10)
			(gSystemWindow color:)
			-1
			-1
		)
		(cond
			((== global343 1)
				(DrawCel 999 0 1 (+ left 10) (- brBottom 2) priority)
				(DrawCel 999 0 0 (- right 20) (- brBottom 2) priority)
			)
			((== global343 2)
				(DrawCel 999 0 1 (- right 20) (- brBottom 2) priority)
			)
			(else
				(DrawCel 999 0 temp3 tailLeft tailTop priority)
			)
		)
		(Graph grUPDATE_BOX brTop brLeft brBottom brRight 1)
		(SetPort temp9)
	)

	(method (dispose)
		(= speakingObj 0)
		(if (not (== global343 2))
			(SetPort 0 0 190 320 3 4)
		)
		(if window
			(DisposeWindow window)
			(= window 0)
		)
		(if (not (== global343 2))
			(SetPort 0 0 156 258 3 4)
		)
		(DisposeClone self)
	)
)

