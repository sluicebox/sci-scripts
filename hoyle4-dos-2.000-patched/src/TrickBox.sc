;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use System)

(class TrickBox of Obj
	(properties
		underBits 0
		view 704
		loop 0
		cel 0
		x 3
		y 150
		priority 14
		active 0
		saveBits 0
	)

	(method (init param1 param2)
		(= underBits
			(Graph
				grSAVE_BOX
				(- y 1)
				(- x 1)
				(+ y (CelHigh view loop cel) 1)
				(+ x (CelWide view loop cel) 1)
				3
			)
		)
		(DrawCel view loop cel x y priority)
		(= active 1)
		(self increment: 0 param1 param2)
		(self increment: 1 param1 param2)
		(= global433 0)
		(cond
			((== global193 700)
				(= global434 (/ (+ global427 4) 5))
				(DrawCel view 5 global434 (+ x 6) (+ y 6) priority)
				(DrawCel
					view
					7
					(if (>= (gTrick trump:) 0)
						(gTrick trump:)
					else
						4
					)
					(+ x 12)
					(+ y 6)
					priority
				)
				(if (>= global424 50)
					(DrawCel
						view
						4
						(if (== global424 50) 0 else 1)
						(+ x 29)
						(+ y 4)
						priority
					)
				)
				(DrawCel view 3 (global429 location:) (+ x 70) (+ y 4) priority)
			)
			((== global193 800)
				(DrawCel
					view
					2
					(if (>= (gTrick trump:) 0)
						(gTrick trump:)
					else
						4
					)
					(+ x 12)
					(+ y 6)
					priority
				)
				(DrawCel view 3 (global429 location:) (+ x 70) (+ y 4) priority)
			)
		)
	)

	(method (save)
		(= saveBits
			(Graph
				grSAVE_BOX
				y
				x
				(+ y (CelHigh view loop cel))
				(+ x (CelWide view loop cel))
				1
			)
		)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(= underBits 0)
		)
	)

	(method (restore)
		(= underBits
			(Graph
				grSAVE_BOX
				(- y 1)
				(- x 1)
				(+ y (CelHigh view loop cel) 1)
				(+ x (CelWide view loop cel) 1)
				3
			)
		)
		(Graph grRESTORE_BOX saveBits)
		(Graph
			grUPDATE_BOX
			y
			x
			(+ y (CelHigh view loop cel))
			(+ x (CelWide view loop cel))
		)
		(Graph
			grREDRAW_BOX
			y
			x
			(+ y (CelHigh view loop cel))
			(+ x (CelWide view loop cel))
		)
		(= saveBits 0)
	)

	(method (erase)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(Graph
				grUPDATE_BOX
				y
				x
				(+ y (CelHigh view loop cel))
				(+ x (CelWide view loop cel))
				1
			)
			(= active (= underBits 0))
		)
	)

	(method (increment param1 param2 param3)
		(cond
			((or (== (global429 location:) 1) (== (global429 location:) 3))
				(if (== param1 0)
					(++ global433)
					(DrawCel view 1 param2 (+ x 20) (+ y 32) priority)
				else
					(DrawCel view 1 param3 (+ x 62) (+ y 32) priority)
				)
			)
			((== param1 0)
				(DrawCel view 1 param2 (+ x 62) (+ y 32) priority)
			)
			(else
				(++ global433)
				(DrawCel view 1 param3 (+ x 20) (+ y 32) priority)
			)
		)
	)
)

