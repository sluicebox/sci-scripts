;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Window)

(public
	commandWindow 0
)

(instance commandWindow of SysWindow
	(properties)

	(method (open &tmp temp0 temp1)
		(= type 128)
		(= back 0)
		(= left (- (- (= temp1 (+ (/ (- right left) 2) left)) 62) 1))
		(= right (+ left 127))
		(= lsLeft (+ (- left 14) 1))
		(= lsRight (+ right 14))
		(= lsTop (- (- top 28) 1))
		(= lsBottom (+ 13 bottom))
		(super open: &rest)
		(= temp0 (GetPort))
		(SetPort 0)
		(DrawCel 98 0 0 lsLeft lsTop 15)
		(DrawCel 98 0 1 lsLeft bottom 15)
		(Graph grFILL_BOX top left bottom right 1 0 15 -1)
		(Graph grFILL_BOX top lsLeft (+ bottom 1) (+ lsLeft 5) 1 7 15 -1)
		(Graph grFILL_BOX top (+ lsLeft 5) (+ bottom 1) (+ lsLeft 10) 1 6 15 -1)
		(Graph grFILL_BOX top (+ lsLeft 10) (+ bottom 1) (+ lsLeft 13) 1 5 15 -1)
		(Graph grFILL_BOX top right (+ bottom 1) (+ right 3) 1 7 15 -1)
		(Graph grFILL_BOX top (+ right 3) (+ bottom 1) (+ right 8) 1 6 15 -1)
		(Graph grFILL_BOX top (+ right 8) (+ bottom 1) (+ right 13) 1 5 15 -1)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)
)

