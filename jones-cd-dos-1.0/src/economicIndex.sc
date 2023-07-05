;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use System)

(public
	economicIndex 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(cond
		((< (param1 index:) (local1 index:))
			(= local1 param1)
		)
		((> (param1 index:) (local0 index:))
			(= local0 param1)
		)
	)
)

(class EconomicIndex of Obj
	(properties
		index 0
		reading 0
		high 0
		low 0
		lowerRange 0
		upperRange 0
		adjustment 0
		risk 4
		headline 0
	)

	(method (init param1 param2)
		(= index param1)
		(= reading param2)
		(cond
			(global373
				(if (> index -3)
					(-= index 3)
					(if (< index -3)
						(= index -3)
					)
				else
					(-- index)
				)
			)
			(global444
				(if (< index 3)
					(+= index 3)
					(if (> index 3)
						(= index 3)
					)
				else
					(++ index)
				)
			)
		)
		(= high 0)
		(cond
			((< reading 80)
				(= high 2)
			)
			((< reading 90)
				(= high 1)
			)
		)
		(= low 0)
		(cond
			((> reading 160)
				(= low 2)
			)
			((> reading 130)
				(= low 1)
			)
		)
		(cond
			(
				(<
					(= global553
						(-
							(= global553
								(Random (+ 100 (- -3 low)) (+ 100 3 high))
							)
							100
						)
					)
					index
				)
				(-- index)
				(if (< index (- -3 low))
					(= index (- -3 low))
				)
			)
			((> global553 index)
				(++ index)
				(if (> index (+ 3 high))
					(= index (+ 3 high))
				)
			)
		)
		(= lowerRange -3)
		(= upperRange 3)
		(cond
			((< index 0)
				(= lowerRange (+ -3 (* 2 index)))
			)
			((> index 0)
				(= upperRange (+ 3 (* 2 index)))
			)
		)
		(= adjustment (Random (+ 100 lowerRange) (+ 100 upperRange)))
		(-= adjustment 100)
		(cond
			((== adjustment lowerRange)
				(-= adjustment (Random 0 (* risk (Abs index))))
			)
			((== adjustment lowerRange)
				(+= adjustment (Random 0 (* risk (Abs index))))
			)
		)
	)

	(method (doit param1 &tmp temp0)
		(= temp0 (if argc param1 else 0))
		(+= reading (+ adjustment (/ param1 3)))
		(cond
			(global373
				(= reading (/ (* reading (+ 16 global373)) 20))
			)
			(global444
				(= reading (/ (* reading 11) 10))
			)
		)
		(if (< reading 70)
			(= reading 70)
		)
		(if (> reading 190)
			(= reading 190)
		)
		(return reading)
	)
)

(instance mainI of EconomicIndex
	(properties
		headline 20
	)
)

(instance investIndex of EconomicIndex
	(properties
		headline 18
	)
)

(instance gdsIndex of EconomicIndex
	(properties
		headline 20
	)
)

(instance gldIndex of EconomicIndex
	(properties
		risk 2
		headline 5
	)
)

(instance silIndex of EconomicIndex
	(properties
		risk 2
		headline 7
	)
)

(instance prkIndex of EconomicIndex
	(properties
		headline 9
	)
)

(instance bcIndex of EconomicIndex
	(properties
		risk 1
		headline 11
	)
)

(instance penIndex of EconomicIndex
	(properties
		risk 10
		headline 13
	)
)

(instance economicIndex of Obj
	(properties)

	(method (doit)
		(= global444 0)
		(= global373 0)
		(cond
			(
				(and
					(>= global307 80)
					(>= global372 8)
					(not (Random 0 (* global374 30)))
				)
				(= global415 (= global373 (Random 1 3)))
			)
			((and (>= global372 8) (<= global307 120))
				(= global444 (not (Random 0 (* global374 30))))
			)
		)
		(= global307 (mainI init: global315 global307 doit:))
		(= global315 (mainI index:))
		(= local0 (= local1 mainI))
		(= global308 (investIndex init: global316 global308 doit: global315))
		(= global316 (investIndex index:))
		(localproc_0 investIndex)
		(= global309 (gdsIndex init: global317 global309 doit: global315))
		(= global317 (gdsIndex index:))
		(localproc_0 gdsIndex)
		(= global310 (gldIndex init: global318 global310 doit: global316))
		(= global318 (gldIndex index:))
		(localproc_0 gldIndex)
		(= global311 (silIndex init: global319 global311 doit: global316))
		(= global319 (silIndex index:))
		(localproc_0 silIndex)
		(= global312 (prkIndex init: global320 global312 doit: global316))
		(= global320 (prkIndex index:))
		(localproc_0 prkIndex)
		(= global313 (bcIndex init: global321 global313 doit: global316))
		(= global321 (bcIndex index:))
		(localproc_0 bcIndex)
		(= global314 (penIndex init: global322 global314 doit: global316))
		(= global322 (penIndex index:))
		(localproc_0 penIndex)
		(mainI dispose:)
		(investIndex dispose:)
		(gdsIndex dispose:)
		(gldIndex dispose:)
		(silIndex dispose:)
		(prkIndex dispose:)
		(bcIndex dispose:)
		(penIndex dispose:)
		(if (not global415)
			(cond
				((> (Abs (local1 index:)) (Abs (local0 index:)))
					(if
						(or
							(and (>= (Abs (local1 index:)) 3) (Random 0 3))
							(and
								(== (Abs (local1 index:)) 2)
								(not (Random 0 2))
							)
						)
						(= global415 (+ (local1 headline:) 1))
					)
				)
				(
					(or
						(and (>= (Abs (local0 index:)) 3) (Random 0 3))
						(and (== (Abs (local0 index:)) 2) (not (Random 0 2)))
					)
					(= global415 (local0 headline:))
				)
			)
		)
		(self dispose:)
		(DisposeScript 107)
	)
)

