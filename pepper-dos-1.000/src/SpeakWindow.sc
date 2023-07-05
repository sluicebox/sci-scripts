;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 891)
(include sci.sh)
(use Main)
(use Window)
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
		tailBits 0
		tailPosn 0
		underBits1 0
		underBits2 0
		atTop 0
		x 0
		y 0
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

	(method (open &tmp temp0 temp1 temp2 temp3 [temp4 4])
		(= color 0)
		(= back 6)
		(= priority 15)
		(if (+ x y)
			(= temp0 x)
			(= temp1 y)
			(= y (= x 0))
		else
			(= temp0 (speakObj x:))
			(= temp1 (speakObj y:))
		)
		(= tailPosn (speakObj tailPosn:))
		(if (OneOf tailPosn 0 1)
			(self move: (- temp0 left) (- temp1 (+ bottom 10)))
			(self repos: -10 -10)
			(= brTop top)
			(= brLeft left)
			(= brBottom bottom)
			(= brRight right)
		else
			(self moveTo: temp0 temp1)
			(= brTop (- top 10))
			(= brLeft (- left 10))
			(= brBottom (+ bottom 10))
			(= brRight (+ right 10))
		)
		(= temp3 1)
		(if (!= priority -1)
			(|= temp3 $0002)
		)
		(switch tailPosn
			(1
				(= tailTop (- brBottom 8))
				(= tailLeft (- brRight 35))
			)
			(4
				(= tailTop (- brTop 3))
				(= tailLeft (- brRight 35))
			)
			(3
				(= tailTop (- brTop 3))
				(= tailLeft (+ brLeft 20))
			)
			(else
				(= tailPosn 0)
				(= tailTop (- brBottom 8))
				(= tailLeft (+ brLeft 20))
			)
		)
		(= tailBottom (+ tailTop 11))
		(= type 128)
		(= lsTop (Min brTop tailTop))
		(= lsBottom (Max brBottom tailBottom))
		(= lsRight brRight)
		(= lsLeft brLeft)
		(if (OneOf tailPosn 0 1)
			(self repos: 10 10)
		)
		(super open: &rest)
		(= temp2 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX (+ top 3) (- left 3) (- bottom 2) right temp3 back priority)
		(Graph
			grFILL_BOX
			(- top 3)
			(+ left 3)
			(+ bottom 4)
			(- right 6)
			temp3
			back
			priority
		)
		(DrawCel 905 2 0 (+ brLeft 7) (+ brTop 7) priority)
		(DrawCel 905 2 1 (- brRight 20) (+ brTop 7) priority)
		(DrawCel 905 2 3 (- brRight 20) (- brBottom 16) priority)
		(DrawCel 905 2 2 (+ brLeft 7) (- brBottom 16) priority)
		(Graph grDRAW_LINE (+ brTop 7) (+ brLeft 17) (+ brTop 7) (- brRight 21) 7 -1 -1)
		(Graph grDRAW_LINE (+ brTop 8) (+ brLeft 17) (+ brTop 8) (- brRight 21) 6 -1 -1)
		(Graph grDRAW_LINE (+ brTop 17) (+ brLeft 7) (- brBottom 17) (+ brLeft 7) 7 -1 -1)
		(Graph grDRAW_LINE (+ brTop 17) (+ brLeft 8) (- brBottom 17) (+ brLeft 8) 6 -1 -1)
		(Graph
			grDRAW_LINE
			(+ brTop 17)
			(- brRight 11)
			(- brBottom 17)
			(- brRight 11)
			5
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ brTop 17)
			(- brRight 12)
			(- brBottom 17)
			(- brRight 12)
			6
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 9)
			(+ brLeft 17)
			(- brBottom 9)
			(- brRight 21)
			6
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 8)
			(+ brLeft 17)
			(- brBottom 8)
			(- brRight 21)
			global122
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- brBottom 7)
			(+ brLeft 17)
			(- brBottom 7)
			(- brRight 21)
			global119
			-1
			-1
		)
		(DrawCel 905 3 tailPosn tailLeft tailTop priority)
		(Graph grUPDATE_BOX (- top 4) (- left 4) (+ bottom 5) right 1)
		(SetPort temp2)
	)
)

