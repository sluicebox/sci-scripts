;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Plane)
(use User)
(use System)

(class SpeakWindow of Plane
	(properties
		hMargin 0
		vMargin 0
		speakObj 0
		tailTop 0
		tailLeft 0
		tailBottom 0
		tailRight 0
		forceToX 0
		forceToY 0
		alternate 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		color 1
		type 0
		lsTop 0
		lsBottom 0
		lsRight 0
		lsLeft 0
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

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= priority 15)
		(= color (if alternate 41 else 109))
		(= back (if alternate 47 else 97))
		(= temp11 (if alternate 2 else 0))
		(if (not speakObj)
			(= speakObj (User alterEgo:))
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
				(if (< left (gCurRoom edgeW:))
					(- (gCurRoom edgeW:) left)
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
				(if (>= right (gCurRoom edgeE:))
					(- (gCurRoom edgeE:) right)
				else
					0
				)
				0
		)
		(self
			move:
				(if (< (+ right 10) temp8)
					(- (gCurRoom edgeE:) right)
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
				(< (- temp5 top) (- (gCurRoom edgeS:) bottom))
			)
			(self move: 0 (- temp5 top))
		)
		(if forceToX
			(self moveTo: forceToX top)
		)
		(if forceToY
			(self moveTo: left forceToY)
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
		(|= type $0080)
		(= lsTop (Min brTop tailTop))
		(= lsBottom (Max brBottom tailBottom))
		(= lsRight brRight)
		(= lsLeft brLeft)
		(self repos: 10 10)
		(super init:)
		(proc0_10 990 (+ temp11 1) 0 brLeft brTop priority)
		(proc0_10 990 (+ temp11 1) 1 (- (- brRight 1) 10) brTop priority)
		(proc0_10 990 (+ temp11 1) 2 brLeft (- brBottom 10) priority)
		(proc0_10 990 (+ temp11 1) 3 (- brRight 10) (- brBottom 10) priority)
		(AddLine self brTop (+ brLeft 10) brTop (- brRight 10) 25 7)
		(AddLine self (+ brTop 10) brLeft (- brBottom 10) brLeft 25 7)
		(AddLine
			self
			(+ brTop 10)
			(- brRight 1)
			(- brBottom 10)
			(- brRight 1)
			25
			0
		)
	)
)

