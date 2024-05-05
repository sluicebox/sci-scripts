;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 404)
(include sci.sh)
(use Main)
(use Interface)
(use DisplayBox)

(public
	scoreObj 0
)

(instance scoreObj of ScoreCard
	(properties
		y 48
		title {GIN RUMMY SCORECARD}
	)

	(method (display &tmp [temp0 200] temp200 temp201 temp202 temp203 temp204 temp205 temp206 temp207 temp208 temp209)
		(gGame setCursor: 999)
		(= temp200 (gPlayer0 total:))
		(= temp201 (gPlayer2 total:))
		(if global510
			(= temp202 (= temp203 (= temp208 (= temp209 0))))
		else
			(= temp202
				(if (< (gPlayer0 bestDeadWood:) (gPlayer2 bestDeadWood:))
					(- (gPlayer2 bestDeadWood:) (gPlayer0 bestDeadWood:))
				else
					0
				)
			)
			(= temp203
				(if (< (gPlayer2 bestDeadWood:) (gPlayer0 bestDeadWood:))
					(- (gPlayer0 bestDeadWood:) (gPlayer2 bestDeadWood:))
				else
					0
				)
			)
			(= temp208 (gPlayer0 bonus:))
			(= temp209 (gPlayer2 bonus:))
		)
		(= temp206 (gPlayer0 handsWon:))
		(= temp207 (gPlayer2 handsWon:))
		(gPlayer0 total: (= temp204 (+ temp200 temp202 temp208)))
		(gPlayer2 total: (= temp205 (+ temp201 temp203 temp209)))
		(if
			(or
				(>= (gPlayer0 total:) global511)
				(>= (gPlayer2 total:) global511)
			)
			(if (> (gPlayer0 total:) (gPlayer2 total:))
				(= global509 gPlayer0)
			)
			(if (> (gPlayer2 total:) (gPlayer0 total:))
				(= global509 gPlayer2)
			)
		)
		(= global199 (Format @temp0 404 0))
		(StrCat global199 {___________})
		(StrCat global199 ((gPlayer2 altrEgo:) name:))
		(StrCat global199 @global138)
		(StrCat global199 {\n})
		(StrCat global199 { ------------------------------ })
		(StrCat global199 {\n})
		(StrCat global199 { Prev Score__})
		(StrCat global199 (Format @global520 404 1 temp201)) ; "%3d"
		(StrCat global199 {_______})
		(StrCat global199 (Format @global520 404 1 temp200)) ; "%3d"
		(StrCat global199 {\n})
		(StrCat global199 { This Hand___})
		(StrCat global199 (Format @global520 404 1 temp203)) ; "%3d"
		(StrCat global199 {_______})
		(StrCat global199 (Format @global520 404 1 temp202)) ; "%3d"
		(StrCat global199 {\n})
		(StrCat global199 { Bonus_______})
		(StrCat global199 (Format @global520 404 1 temp209)) ; "%3d"
		(StrCat global199 {_______})
		(StrCat global199 (Format @global520 404 1 temp208)) ; "%3d"
		(StrCat global199 {\n})
		(StrCat global199 { ------------------------------ })
		(StrCat global199 {\n})
		(if global509
			(StrCat global199 { FINAL SCORE })
		else
			(StrCat global199 { Total Score })
		)
		(StrCat global199 (Format @global520 404 1 temp205)) ; "%3d"
		(StrCat global199 {_______})
		(StrCat global199 (Format @global520 404 1 temp204)) ; "%3d"
		(StrCat global199 {\n})
		(StrCat global199 { ------------------------------ })
		(StrCat global199 {\n})
		(StrCat global199 { Hands Won____})
		(StrCat global199 (Format @global520 404 2 temp207)) ; "%2d"
		(StrCat global199 {________})
		(StrCat global199 (Format @global520 404 2 temp206)) ; "%2d"
		(StrCat global199 {\n})
		(= global305 (Print global199 #font sFont #title title #at x y #dispose))
		(proc0_1 13600)
		(gModelessDialog dispose:)
	)
)

