;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Interface)

(public
	Buy 0
	CheckFunds 1
	GiveMoney 2
)

(procedure (Buy invItem costCentimes qty canBuyMoreThanOnce askHowMany isQuiet &tmp [whatStr 20] [invDesc 20] [str 40] rc howMany quiet)
	(= quiet (if (>= argc 6) isQuiet else 0))
	(StrToLower @invDesc 11 (* invItem 2))
	(if (and invItem (gEgo has: invItem) (or (< argc 4) (not canBuyMoreThanOnce)))
		(if (not quiet)
			(Format @whatStr @invDesc {})
			(HighPrint (Format @str 3 0 @whatStr)) ; "You already have the %s."
		)
		(= rc 4)
	else
		(cond
			((and (>= argc 3) (> qty 0))
				(= howMany qty)
			)
			((and (>= argc 5) askHowMany (not qty))
				(Pluralize @invDesc invItem 2)
				(StrToLower @whatStr @invDesc)
				(if (<= (= howMany (GetNumber (Format @str 3 1 @whatStr))) 0) ; "How many %s do you want?"
					(return 5)
				)
				(*= costCentimes howMany)
			)
			(else
				(= howMany 1)
			)
		)
		(Pluralize @invDesc invItem howMany)
		(StrToLower @whatStr @invDesc)
		(switch (= rc (_CheckFunds costCentimes))
			(3
				(if invItem
					(gEgo get: invItem howMany)
				)
				(if (not quiet)
					(HighPrint (Format @str 3 2 @whatStr)) ; "You put the %s away."
				)
			)
			(2
				(if invItem
					(gEgo get: invItem howMany)
				)
				(_GiveMoney costCentimes)
				(if (not quiet)
					(HighPrint
						(Format ; "You pay for the %s and put %s away."
							@str
							3
							3
							@whatStr
							(if (> howMany 1) {them} else {it})
						)
					)
				)
			)
		)
	)
	(return rc)
)

(procedure (GiveMoney costCentimes)
	(_GiveMoney costCentimes)
)

(procedure (CheckFunds costCentimes)
	(_CheckFunds costCentimes)
)

(procedure (_CheckFunds costCentimes &tmp rc)
	(cond
		((not costCentimes)
			(= rc 3)
		)
		(
			(or
				(> [gInvNum 2] 327) ; Dinar
				(u>= (+ [gInvNum 1] (* [gInvNum 2] 100)) costCentimes) ; Centime, Dinar
			)
			(= rc 2)
		)
		([gInvNum 17] ; Gold
			(= rc 1)
		)
		(else
			(= rc 0)
		)
	)
	(return rc)
)

(procedure (_GiveMoney costCentimes &tmp haveD haveC costD costC rc theDiff)
	(= haveC [gInvNum 1]) ; Centime
	(= haveD [gInvNum 2]) ; Dinar
	(= costD (/ costCentimes 100))
	(= costC (mod costCentimes 100))
	(= rc 1)
	(if (== (_CheckFunds costCentimes) 2)
		(if (<= costD haveD)
			(-= haveD costD)
			(if (<= costC haveC)
				(-= haveC costC)
			else
				(-- haveD)
				(+= haveC (- 100 costC))
			)
		else
			(-= costD haveD)
			(= haveD 0)
			(+= costC (* costD 100))
			(-= haveC costC)
		)
	)
	(if rc
		(= [gInvNum 2] haveD) ; Dinar
		(= [gInvNum 1] haveC) ; Centime
	)
	(return rc)
)

