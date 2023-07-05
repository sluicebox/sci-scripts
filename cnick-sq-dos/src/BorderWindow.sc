;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 936)
(include sci.sh)
(use Window)

(procedure (DrawBeveledWindow t l b r theColor topColor leftColor bottomColor rightColor theBevelWid theShadowWid thePri theMaps &tmp savePort i)
	(= savePort (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX t l (+ b 1) (+ r 1) theMaps theColor thePri)
	(-= t theBevelWid)
	(-= l theBevelWid)
	(+= r theBevelWid)
	(+= b theBevelWid)
	(Graph grFILL_BOX t l (+ t theBevelWid) r theMaps topColor thePri)
	(Graph grFILL_BOX (- b theBevelWid) l b r theMaps bottomColor thePri)
	(for ((= i 0)) (< i theBevelWid) ((++ i))
		(Graph
			grDRAW_LINE
			(+ t i)
			(+ l i)
			(- b (+ i 1))
			(+ l i)
			leftColor
			thePri
			-1
		)
		(Graph
			grDRAW_LINE
			(+ t i)
			(- r (+ i 1))
			(- b (+ i 1))
			(- r (+ i 1))
			rightColor
			thePri
			-1
		)
	)
	(if theShadowWid
		(Graph
			grFILL_BOX
			(+ t theShadowWid)
			r
			(+ b theShadowWid)
			(+ r theShadowWid)
			theMaps
			0
			thePri
		)
		(Graph
			grFILL_BOX
			b
			(+ l theShadowWid)
			(+ b theShadowWid)
			r
			theMaps
			0
			thePri
		)
	)
	(SetPort savePort)
)

(procedure (PushOnScreen wind &tmp dX dY) ; UNUSED
	(= dY
		(cond
			((> (wind sel_196:) 185)
				(- 185 (wind sel_196:))
			)
			((< (wind sel_194:) 10)
				(- 10 (wind sel_194:))
			)
			(else 0)
		)
	)
	(= dX
		(cond
			((> (wind sel_197:) 315)
				(- 315 (wind sel_197:))
			)
			((< (wind sel_195:) 5)
				(- 5 (wind sel_195:))
			)
			(else 0)
		)
	)
	(wind
		sel_194: (+ (wind sel_194:) dY)
		sel_196: (+ (wind sel_196:) dY)
		sel_195: (+ (wind sel_195:) dX)
		sel_197: (+ (wind sel_197:) dX)
	)
)

(class BorderWindow of SysWindow
	(properties
		sel_20 {BorderWindow}
		sel_26 5
		sel_359 7
		sel_360 6
		sel_361 4
		sel_362 3
		sel_363 3
		sel_364 2
	)

	(method (sel_192 &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= sel_60 -1)
			(|= temp1 $0002)
		)
		(= sel_10 (- sel_194 sel_363))
		(= sel_11 (- sel_195 sel_363))
		(= sel_13 (+ sel_197 sel_363 sel_364))
		(= sel_12 (+ sel_196 sel_363 sel_364))
		(= sel_31 128)
		(super sel_192:)
		(DrawBeveledWindow
			sel_194
			sel_195
			sel_196
			sel_197
			sel_26
			sel_359
			sel_360
			sel_362
			sel_361
			sel_363
			sel_364
			sel_60
			temp1
		)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX sel_10 sel_11 sel_12 sel_13 1)
		(SetPort temp0)
	)

	(method (sel_111)
		(super sel_111:)
		(SetPort 0)
	)
)

(class InsetWindow of BorderWindow
	(properties
		sel_20 {InsetWindow}
		sel_359 5
		sel_360 4
		sel_361 2
		sel_362 1
		sel_365 3
		sel_366 2
		sel_367 0
		sel_368 1
		sel_369 5
		sel_370 4
		sel_371 10
		sel_372 24
		sel_373 2
		sel_374 0
		sel_375 2
		sel_376 0
		sel_377 0
	)

	(method (sel_192 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 1)
		(if (!= sel_60 -1)
			(|= temp0 $0002)
		)
		(= temp2 sel_194)
		(= temp3 sel_195)
		(= temp4 sel_196)
		(= temp5 sel_197)
		(-= sel_194 (+ sel_363 sel_371))
		(-= sel_195 (+ sel_363 sel_373))
		(+= sel_196 (+ sel_363 sel_372))
		(+= sel_197 (+ sel_363 sel_373))
		(= sel_376 (+ sel_363 sel_373))
		(= sel_377 (+ sel_363 sel_371))
		(super sel_192:)
		(DrawBeveledWindow
			temp2
			temp3
			temp4
			temp5
			sel_366
			sel_367
			sel_368
			sel_369
			sel_370
			sel_375
			sel_374
			sel_60
			temp0
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- temp2 sel_375)
			(- temp3 sel_375)
			(+ temp4 sel_375)
			(+ temp5 sel_375)
			1
		)
		(SetPort temp1)
	)
)

