;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64909)
(include sci.sh)
(use Main)
(use System)

(class Styler of Obj
	(properties
		style 0
		plane 0
		seconds 1
		back -1
		priority 200
		animate 0
		refFrame 0
		divisions 0
		captureList 0
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
			((OneOf style 15 16 17 18)
				(switch style
					(15
						(= xDir (* (gEgo xStep:) -1))
						(= yDir 0)
					)
					(16
						(= xDir (gEgo xStep:))
						(= yDir 0)
					)
					(17
						(= xDir 0)
						(= yDir (* (gEgo yStep:) -1))
					)
					(18
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
				)
			)
		)
	)
)

