;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use System)

(class EScore of Obj
	(properties
		wePoints 0
		weTricksWon 0
		theyPoints 0
		theyTricksWon 0
	)

	(method (gameInit)
		(= theyPoints (= wePoints 0))
	)

	(method (handInit)
		(= theyTricksWon (= weTricksWon 0))
	)

	(method (addScore param1 param2)
		(cond
			((== param1 0)
				(if (> (+= wePoints param2) global283)
					(= wePoints global283)
				)
			)
			((> (+= theyPoints param2) global283)
				(= theyPoints global283)
			)
		)
	)
)

