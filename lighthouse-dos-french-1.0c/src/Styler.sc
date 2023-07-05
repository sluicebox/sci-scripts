;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64909)
(include sci.sh)
(use Main)
(use Array)
(use System)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14) ; UNUSED
	(= temp14 (if (and (> argc 1) param2) param2 else 1))
	(= temp13 (if (> argc 2) param3 else 20))
	(= temp12 (if (> argc 3) param4 else 2))
	(= temp0 (= temp4 (= temp8 (param1 left:))))
	(= temp1 (= temp5 (= temp9 (param1 top:))))
	(= temp2 (= temp6 (= temp10 (param1 right:))))
	(= temp3 (= temp7 (= temp11 (param1 bottom:))))
	(if (& temp14 $0001)
		(-= temp4 temp12)
		(-= temp6 temp12)
		(+= temp8 temp12)
		(+= temp10 temp12)
	)
	(if (& temp14 $0002)
		(-= temp5 temp12)
		(-= temp7 temp12)
		(+= temp9 temp12)
		(+= temp11 temp12)
	)
	1
	(while temp13
		(param1 setRect: temp4 temp5 temp6 temp7 1)
		(FrameOut)
		(param1 setRect: temp8 temp9 temp10 temp11 1)
		(FrameOut)
		(-- temp13)
	)
	(param1 setRect: temp0 temp1 temp2 temp3 1)
)

(class Styler of Obj
	(properties
		back -1
		plane 0
		priority 200
		style 0
		animate 0
		refFrame 0
		divisions 0
		captureList 0
		pFadeArray 0
		seconds 1
		blackScreen 0
	)

	(method (init)
		(super init: &rest)
		(= pFadeArray (IntArray new: 0))
	)

	(method (addExclusionRange aStart aEnd &tmp tSize)
		(if pFadeArray
			(= tSize (pFadeArray size:))
			(pFadeArray at: tSize aStart aEnd)
		)
	)

	(method (doit aPlane aStyle time aBack ani &tmp xDir yDir)
		(if argc
			(= plane aPlane)
			(if (> argc 1)
				(= style aStyle)
				(if (> argc 2)
					(= seconds time)
					(if (> argc 3)
						(= back aBack)
						(if (> argc 4)
							(= animate ani)
						else
							(= animate 0)
						)
					else
						(= back -1)
					)
				else
					(= seconds 1)
				)
			else
				(= style 0)
			)
		else
			(= plane gThePlane)
		)
		(&= style $00ff)
		(cond
			((OneOf style 16 17 18 19)
				(switch style
					(16
						(= xDir (* (gEgo xStep:) -1))
						(= yDir 0)
					)
					(17
						(= xDir (gEgo xStep:))
						(= yDir 0)
					)
					(18
						(= xDir 0)
						(= yDir (* (gEgo yStep:) -1))
					)
					(19
						(= xDir 0)
						(= yDir (gEgo yStep:))
					)
				)
				(SetScroll
					plane
					xDir
					yDir
					(plane picture:)
					animate
					(gEgo cycleSpeed:)
				)
			)
			(divisions
				(SetShowStyle
					style
					plane
					seconds
					back
					priority
					animate
					refFrame
					blackScreen
					(pFadeArray data:)
					divisions
				)
			)
			(else
				(SetShowStyle
					style
					plane
					seconds
					back
					priority
					animate
					refFrame
					blackScreen
					(pFadeArray data:)
				)
			)
		)
	)
)

