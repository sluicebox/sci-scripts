;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 892)
(include sci.sh)
(use Main)
(use Window)
(use Actor)

(class BalloonWindow of SysWindow
	(properties
		balloonView 0
		balloonTail 0
		x 0
		y 0
		height 0
		width 0
		tailCel 0
		tailOffset 0
		tailScale 0
	)

	(method (open &tmp temp0 temp1 temp2)
		(= priority 15)
		(= color 0)
		(= back 7)
		(= top (+ y 14))
		(= left (+ x 23))
		(= brTop top)
		(= brLeft left)
		(= brBottom bottom)
		(= brRight right)
		(= temp1 (/ (* 128 (+ width 25)) 175))
		(= temp2 (/ (* 128 (+ height 15)) 60))
		(Animate (gCast elements:) 0)
		((= balloonTail (View new:))
			view: 914
			name: {balloonTail}
			setPri: 14
			loop: 0
			cel: tailCel
			x: (+ ((ScriptID 895 0) x:) tailOffset) ; pepper
			y: (- ((ScriptID 895 0) nsTop:) 5) ; pepper
			setScale:
			scaleX: tailScale
			scaleY: tailScale
			init:
			stopUpd:
		)
		((= balloonView (View new:))
			view: 915
			name: {balloonView}
			setPri: 15
			loop: 0
			cel: 0
			x: x
			y: y
			setScale:
			scaleX: temp1
			scaleY: temp2
			init:
			stopUpd:
		)
		(Animate (gCast elements:) 0)
		(= type 128)
		(super open: &rest)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX top left bottom right 1)
		(SetPort temp0)
	)

	(method (dispose)
		(if balloonView
			(balloonView dispose:)
			(= balloonView 0)
		)
		(if balloonTail
			(balloonTail dispose:)
			(= balloonTail 0)
		)
		(super dispose:)
	)
)

