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

(procedure (SortedAdd theOrigin theLists &tmp i toList fromColl node dist obj ang invisible objMinFront distMinFront frontList objMinOut distMinOut outList objMinBack distMinBack backList)
	((= frontList (EventHandler new:)) add: name: {fl})
	((= outList (EventHandler new:)) add: name: {ol})
	((= backList (EventHandler new:)) add: name: {bl})
	((= toList [theLists 0]) add: frontList outList gRegions gLocales backList)
	(-- argc)
	(repeat
		(= objMinFront (= objMinOut (= objMinBack 0)))
		(= distMinFront (= distMinOut (= distMinBack 32767)))
		(for ((= i 1)) (< i argc) ((++ i))
			(= fromColl [theLists i])
			(for
				((= node (FirstNode (fromColl elements:))))
				(and node (IsObject (= obj (NodeValue node))))
				((= node (NextNode node)))
				
				(if (toList firstTrue: #contains obj)
				else
					(= dist (theOrigin distanceTo: obj))
					(= ang
						(AngleDiff
							(theOrigin heading:)
							(GetAngle
								(theOrigin x:)
								(theOrigin y:)
								(obj x:)
								(obj y:)
							)
						)
					)
					(if (== (umod ang 90) 0)
						(-- ang)
					)
					(if (= invisible (CantBeSeen obj theOrigin))
						(= dist (SinDiv ang dist))
					else
						(if (> (Abs ang) 90)
							(= ang 89)
							(*= dist 10)
						)
						(= dist (Abs (CosDiv ang dist)))
					)
					(if (< dist 0)
						(= dist 32767)
					)
					(cond
						(invisible
							(if (<= dist distMinBack)
								(= distMinBack dist)
								(= objMinBack obj)
							)
						)
						((IsOffScreen obj)
							(if (<= dist distMinOut)
								(= distMinOut dist)
								(= objMinOut obj)
							)
						)
						((<= dist distMinFront)
							(= distMinFront dist)
							(= objMinFront obj)
						)
					)
				)
			)
		)
		(if objMinFront
			(frontList addToEnd: objMinFront)
		)
		(if objMinOut
			(outList addToEnd: objMinOut)
		)
		(if objMinBack
			(backList addToEnd: objMinBack)
		)
		(contif (or objMinFront objMinOut objMinBack))
		(break)
	)
)

