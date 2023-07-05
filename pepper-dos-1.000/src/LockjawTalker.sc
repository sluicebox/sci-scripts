;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2004)
(include sci.sh)
(use Main)
(use BalloonTalker)

(public
	LockjawTalker 0
)

(local
	local0
)

(instance LockjawTalker of BalloonTalker
	(properties
		talkWidth 0
		font 61
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= x ((ScriptID 895 1) x:)) ; lockjaw
		(= y ((ScriptID 895 1) y:)) ; lockjaw
		(= temp0 ((ScriptID 895 1) nsTop:)) ; lockjaw
		(= temp1 ((ScriptID 895 1) nsLeft:)) ; lockjaw
		(= temp2 ((ScriptID 895 1) nsBottom:)) ; lockjaw
		(= temp3 ((ScriptID 895 1) nsRight:)) ; lockjaw
		(cond
			((+ winX winY))
			((<= x 150)
				(if (<= y 100)
					(= x (- temp3 5))
					(= y (+ temp0 30))
					(= tailPosn 3)
				else
					(= x (- temp3 5))
					(= y temp0)
					(= tailPosn 0)
				)
				(+= x offX)
				(+= y offY)
			)
			(else
				(if (<= y 100)
					(= x (- temp1 100))
					(= y (+ temp0 30))
					(= tailPosn 4)
				else
					(= x (- temp1 100))
					(= y temp0)
					(= tailPosn 1)
				)
				(+= x offX)
				(+= y offY)
			)
		)
		(if (not talkWidth)
			(= talkWidth 90)
		)
		(super init: &rest)
	)

	(method (say)
		(if dontUpd
			((ScriptID 895 1) stopUpd:) ; lockjaw
		)
		(super say: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(if ((ScriptID 895 1) cycler:) ; lockjaw
			((ScriptID 895 1) startUpd:) ; lockjaw
		)
		(Animate (gCast elements:) 0)
	)
)

