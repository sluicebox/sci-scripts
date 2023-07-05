;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 984)
(include sci.sh)
(use Main)
(use Sight)
(use System)

(public
	SortedAdd 0
)

(local
	frontList
	backList
	outList
)

(procedure (SortedAdd &tmp frontList2 outList2 backList2) ; UNUSED
	((= frontList (EventHandler new:)) add: name: {fl})
	((= outList (EventHandler new:)) add: name: {ol})
	((= backList (EventHandler new:)) add: name: {bl})
	((= frontList2 (EventHandler new:)) name: {fl2})
	((= outList2 (EventHandler new:)) name: {ol2})
	((= backList2 (EventHandler new:)) name: {bl2})
	(gCast eachElementDo: #perform preSortCode)
	(gFeatures eachElementDo: #perform preSortCode)
	(Sorts frontList frontList2 frontSortCode)
	(gSFeatures add: frontList2)
	(Sorts outList outList2 frontSortCode)
	(gSFeatures add: outList2)
	(gSFeatures add: gRegions)
	(gSFeatures add: gLocales)
	(Sorts backList backList2 backSortCode)
	(gSFeatures add: backList2)
	(frontList release: dispose:)
	(outList release: dispose:)
	(backList release: dispose:)
)

(instance preSortCode of Code
	(properties)

	(method (doit obj)
		(cond
			((CantBeSeen obj gEgo)
				(backList add: obj)
			)
			((IsOffScreen obj)
				(outList add: obj)
			)
			(else
				(frontList add: obj)
			)
		)
	)
)

(instance frontSortCode of Code
	(properties)

	(method (doit obj &tmp dist ang)
		(= dist (gEgo distanceTo: obj))
		(= ang
			(AngleDiff
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (obj x:) (obj y:))
			)
		)
		(if (== (umod ang 90) 0)
			(-- ang)
		)
		(if (> (Abs ang) 90)
			(= ang 89)
			(*= dist 10)
		)
		(if (< (= dist (Abs (CosDiv ang dist))) 0)
			(= dist 32767)
		)
		(return dist)
	)
)

(instance backSortCode of Code
	(properties)

	(method (doit obj &tmp dist ang)
		(= dist (gEgo distanceTo: obj))
		(= ang
			(AngleDiff
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (obj x:) (obj y:))
			)
		)
		(if (== (umod ang 90) 0)
			(-- ang)
		)
		(if (< (= dist (SinDiv ang dist)) 0)
			(= dist 32767)
		)
		(return dist)
	)
)

