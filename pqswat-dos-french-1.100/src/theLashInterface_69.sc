;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use LashInterface)
(use Motion)
(use Actor)

(public
	theLashInterface 0
)

(procedure (localproc_0)
	(if (and (not (proc4_11 26)) (not (proc4_11 22)) (not (proc4_11 21)))
		(hiGrndButn cel: 0 setCycle: Fwd)
		(hostageButn cel: 0 setCycle: Fwd)
		(suspectButn cel: 0 setCycle: Fwd)
	)
)

(procedure (localproc_1)
	(oOneButn select: 0 1)
	(oTwoButn select: 0 1)
	(oThreeButn select: 0 1)
	(oFourButn select: 0 1)
	(oFiveButn select: 0 1)
	(oSixButn select: 0 1)
	(oSevenButn select: 0 1)
	(oEightButn select: 0 1)
	(oNineButn select: 0 1)
	(oTenButn select: 0 1)
	(oElevenButn select: 0 1)
	(oTwelveButn select: 0 1)
	(oThirteenButn select: 0 1)
	(oFourteenButn select: 0 1)
	(oFifteenButn select: 0 1)
	(oSixteenButn select: 0 1)
	(oSeventeenButn select: 0 1)
	(oEighteenButn select: 0 1)
	(oNineteenButn select: 0 1)
	(oTwentyButn select: 0 1)
)

(procedure (localproc_2)
	(if
		(or
			(proc4_11 26)
			(proc4_11 22)
			(proc4_11 21)
			(and
				(not (proc4_11 43))
				(not (proc4_11 7))
				(not (proc4_11 8))
				(not (proc4_11 80))
				(not (proc4_11 81))
				(not (proc4_11 82))
				(not (proc4_11 83))
				(not (proc4_11 84))
				(not (proc4_11 85))
				(not (proc4_11 28))
				(not (proc4_11 29))
				(not (proc4_11 34))
				(not (proc4_11 35))
				(not (proc4_11 36))
				(not (proc4_11 37))
				(not (proc4_11 86))
				(not (proc4_11 87))
				(not (proc4_11 88))
				(not (proc4_11 89))
				(not (proc4_11 90))
				(not (proc4_11 91))
				(not (proc4_11 92))
				(not (proc4_11 93))
				(not (proc4_11 94))
				(not (proc4_11 95))
				(not (proc4_11 96))
				(not (proc4_11 97))
				(not (proc4_11 98))
				(not (proc4_11 99))
				(not (proc4_11 100))
				(not (proc4_11 101))
				(not (proc4_11 102))
				(not (proc4_11 103))
				(not (proc4_11 104))
				(not (proc4_11 105))
			)
		)
		(hiGrndButn setCycle: 0 cel: (proc4_11 26))
		(hostageButn setCycle: 0 cel: (proc4_11 22))
		(suspectButn setCycle: 0 cel: (proc4_11 21))
		(UpdateScreenItem hiGrndButn)
		(UpdateScreenItem hostageButn)
		(UpdateScreenItem suspectButn)
	)
)

(procedure (localproc_3)
	(return
		(or
			(not (proc4_11 43))
			(not (proc4_11 7))
			(not (proc4_11 8))
			(not (proc4_11 80))
			(not (proc4_11 81))
			(not (proc4_11 82))
			(not (proc4_11 83))
			(not (proc4_11 84))
			(not (proc4_11 85))
			(not (proc4_11 28))
			(not (proc4_11 29))
			(not (proc4_11 34))
			(not (proc4_11 35))
			(not (proc4_11 36))
			(not (proc4_11 37))
			(not (proc4_11 86))
			(not (proc4_11 87))
			(not (proc4_11 88))
			(not (proc4_11 89))
			(not (proc4_11 90))
			(not (proc4_11 91))
			(not (proc4_11 92))
			(not (proc4_11 93))
			(not (proc4_11 94))
			(not (proc4_11 95))
			(not (proc4_11 96))
			(not (proc4_11 97))
			(not (proc4_11 98))
			(not (proc4_11 99))
			(not (proc4_11 100))
			(not (proc4_11 101))
			(not (proc4_11 102))
			(not (proc4_11 103))
			(not (proc4_11 104))
			(not (proc4_11 105))
		)
	)
)

(class OpeningLashButton of LashButton
	(properties)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(localproc_1)
		)
		(super select: param1 param2)
		(if (or (not argc) param1)
			(localproc_0)
		else
			(localproc_2)
		)
	)
)

(instance theLashInterface of LashInterface
	(properties)

	(method (addItems)
		(lashBackground init:)
		(hiGrndButn init:)
		(hostageButn init:)
		(suspectButn init:)
		(inPosnButn init:)
		(yesButn init:)
		(noButn init:)
		(movementButn init:)
		(shotsFiredButn init:)
		(armedButn init:)
		(unarmedButn init:)
		(woundedButn init:)
		(neutralButn init:)
		(levelOneButn init:)
		(levelTwoButn init:)
		(sideOneButn init:)
		(sideTwoButn init:)
		(sideThreeButn init:)
		(sideFourButn init:)
		(oOneButn init:)
		(oTwoButn init:)
		(oThreeButn init:)
		(oFourButn init:)
		(oFiveButn init:)
		(oSixButn init:)
		(oSevenButn init:)
		(oEightButn init:)
		(oNineButn init:)
		(oTenButn init:)
		(oElevenButn init:)
		(oTwelveButn init:)
		(oThirteenButn init:)
		(oFourteenButn init:)
		(oFifteenButn init:)
		(oSixteenButn init:)
		(oSeventeenButn init:)
		(oEighteenButn init:)
		(oNineteenButn init:)
		(oTwentyButn init:)
		(transmitButn init:)
		(leftFlash init:)
		(rightFlash init:)
	)

	(method (clear param1 &tmp temp0)
		(= temp0 (= curIdx (= multiple 0)))
		(if argc
			(= temp0 param1)
		)
		(self eachElementDo: #select 0 temp0 release:)
	)

	(method (transmit)
		(if
			(or
				(hiGrndButn cycler:)
				(hostageButn cycler:)
				(suspectButn cycler:)
			)
			(hiGrndButn setCycle: 0)
			(hostageButn setCycle: 0)
			(suspectButn setCycle: 0)
			(self clear: 1)
		)
		(super transmit: &rest)
	)

	(method (flashDoits)
		(rightFlash doit:)
		(leftFlash doit:)
	)

	(method (buttonDoits)
		(hiGrndButn doit:)
		(hostageButn doit:)
		(suspectButn doit:)
	)
)

(instance lashBackground of View
	(properties
		view 19
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)
)

(instance hiGrndButn of LashButton
	(properties
		view 19
		loop 1
		enumType 26
		buttVerb 37
	)

	(method (init)
		(= x (+ (lashBackground x:) 72))
		(= y (+ (lashBackground y:) 57))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(hostageButn select: 0 1)
			(suspectButn select: 0 1)
		)
		(super select: param1 param2)
		(cond
			((or (not argc) param1)
				(localproc_2)
			)
			((localproc_3)
				(localproc_0)
			)
		)
	)
)

(instance hostageButn of LashButton
	(properties
		view 19
		loop 2
		enumType 22
		buttVerb 90
	)

	(method (init)
		(= x (+ (lashBackground x:) 185))
		(= y (+ (lashBackground y:) 58))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(hiGrndButn select: 0 1)
			(suspectButn select: 0 1)
		)
		(super select: param1 param2)
		(cond
			((or (not argc) param1)
				(localproc_2)
			)
			((localproc_3)
				(localproc_0)
			)
		)
	)
)

(instance suspectButn of LashButton
	(properties
		view 19
		loop 3
		enumType 21
		buttVerb 89
	)

	(method (init)
		(= x (+ (lashBackground x:) 296))
		(= y (+ (lashBackground y:) 58))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(hiGrndButn select: 0 1)
			(hostageButn select: 0 1)
		)
		(super select: param1 param2)
		(cond
			((or (not argc) param1)
				(localproc_2)
			)
			((localproc_3)
				(localproc_0)
			)
		)
	)
)

(instance inPosnButn of LashButton
	(properties
		view 19
		loop 4
		enumType 43
		buttVerb 77
	)

	(method (init)
		(= x (+ (lashBackground x:) 34))
		(= y (+ (lashBackground y:) 83))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2)
		(if (or (not argc) param1)
			(localproc_0)
		else
			(localproc_2)
		)
	)
)

(instance yesButn of LashButton
	(properties
		view 19
		loop 5
		enumType 7
		buttVerb 145
	)

	(method (init)
		(= x (+ (lashBackground x:) 114))
		(= y (+ (lashBackground y:) 83))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(noButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance noButn of LashButton
	(properties
		view 19
		loop 6
		enumType 8
		buttVerb 146
	)

	(method (init)
		(= x (+ (lashBackground x:) 194))
		(= y (+ (lashBackground y:) 83))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(yesButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance movementButn of LashButton
	(properties
		view 19
		loop 7
		enumType 80
		buttVerb 147
	)

	(method (init)
		(= x (+ (lashBackground x:) 274))
		(= y (+ (lashBackground y:) 83))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2)
		(if (or (not argc) param1)
			(localproc_0)
		else
			(localproc_2)
		)
	)
)

(instance shotsFiredButn of LashButton
	(properties
		view 19
		loop 8
		enumType 81
		buttVerb 148
	)

	(method (init)
		(= x (+ (lashBackground x:) 354))
		(= y (+ (lashBackground y:) 83))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2)
		(if (or (not argc) param1)
			(localproc_0)
		else
			(localproc_2)
		)
	)
)

(instance armedButn of LashButton
	(properties
		view 19
		loop 9
		enumType 82
		buttVerb 149
	)

	(method (init)
		(= x (+ (lashBackground x:) 70))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(unarmedButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance unarmedButn of LashButton
	(properties
		view 19
		loop 10
		enumType 83
		buttVerb 150
	)

	(method (init)
		(= x (+ (lashBackground x:) 152))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(armedButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance woundedButn of LashButton
	(properties
		view 19
		loop 11
		enumType 84
		buttVerb 151
	)

	(method (init)
		(= x (+ (lashBackground x:) 234))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(neutralButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance neutralButn of LashButton
	(properties
		view 19
		loop 12
		enumType 85
		buttVerb 178
	)

	(method (init)
		(= x (+ (lashBackground x:) 316))
		(= y (+ (lashBackground y:) 105))
		(super init: &rest)
	)

	(method (select param1 param2)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(woundedButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance levelOneButn of LashButton
	(properties
		view 19
		loop 16
		enumType 28
		buttVerb 156
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 135))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(levelTwoButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance levelTwoButn of LashButton
	(properties
		view 19
		loop 17
		enumType 29
		buttVerb 157
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 135))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: level)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(levelOneButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance sideOneButn of LashButton
	(properties
		view 19
		loop 16
		enumType 34
		buttVerb 156
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 160))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(sideTwoButn select: 0 1)
			(sideThreeButn select: 0 1)
			(sideFourButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance sideTwoButn of LashButton
	(properties
		view 19
		loop 17
		enumType 35
		buttVerb 157
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 160))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(sideOneButn select: 0 1)
			(sideThreeButn select: 0 1)
			(sideFourButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance sideThreeButn of LashButton
	(properties
		view 19
		loop 18
		enumType 36
		buttVerb 158
	)

	(method (init)
		(= x (+ (lashBackground x:) 235))
		(= y (+ (lashBackground y:) 160))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(sideOneButn select: 0 1)
			(sideTwoButn select: 0 1)
			(sideFourButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance sideFourButn of LashButton
	(properties
		view 19
		loop 19
		enumType 37
		buttVerb 159
	)

	(method (init)
		(= x (+ (lashBackground x:) 311))
		(= y (+ (lashBackground y:) 160))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: side)
		)
		(super select: param1 param2 &rest)
		(if (or (not argc) param1)
			(localproc_0)
			(sideOneButn select: 0 1)
			(sideTwoButn select: 0 1)
			(sideThreeButn select: 0 1)
		else
			(localproc_2)
		)
	)
)

(instance oOneButn of OpeningLashButton
	(properties
		view 19
		loop 16
		enumType 86
		buttVerb 156
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 185))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oTwoButn of OpeningLashButton
	(properties
		view 19
		loop 17
		enumType 87
		buttVerb 157
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 185))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oThreeButn of OpeningLashButton
	(properties
		view 19
		loop 18
		enumType 88
		buttVerb 158
	)

	(method (init)
		(= x (+ (lashBackground x:) 235))
		(= y (+ (lashBackground y:) 185))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oFourButn of OpeningLashButton
	(properties
		view 19
		loop 19
		enumType 89
		buttVerb 159
	)

	(method (init)
		(= x (+ (lashBackground x:) 311))
		(= y (+ (lashBackground y:) 185))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oFiveButn of OpeningLashButton
	(properties
		view 19
		loop 20
		enumType 90
		buttVerb 160
	)

	(method (init)
		(= x (+ (lashBackground x:) 387))
		(= y (+ (lashBackground y:) 185))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oSixButn of OpeningLashButton
	(properties
		view 19
		loop 21
		enumType 91
		buttVerb 176
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 207))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oSevenButn of OpeningLashButton
	(properties
		view 19
		loop 22
		enumType 92
		buttVerb 177
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 207))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oEightButn of OpeningLashButton
	(properties
		view 19
		loop 23
		enumType 93
		buttVerb 163
	)

	(method (init)
		(= x (+ (lashBackground x:) 235))
		(= y (+ (lashBackground y:) 207))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oNineButn of OpeningLashButton
	(properties
		view 19
		loop 24
		enumType 94
		buttVerb 164
	)

	(method (init)
		(= x (+ (lashBackground x:) 311))
		(= y (+ (lashBackground y:) 207))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oTenButn of OpeningLashButton
	(properties
		view 19
		loop 25
		enumType 95
		buttVerb 165
	)

	(method (init)
		(= x (+ (lashBackground x:) 387))
		(= y (+ (lashBackground y:) 207))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oElevenButn of OpeningLashButton
	(properties
		view 19
		loop 26
		enumType 96
		buttVerb 166
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 229))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oTwelveButn of OpeningLashButton
	(properties
		view 19
		loop 27
		enumType 97
		buttVerb 167
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 229))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oThirteenButn of OpeningLashButton
	(properties
		view 19
		loop 28
		enumType 98
		buttVerb 168
	)

	(method (init)
		(= x (+ (lashBackground x:) 235))
		(= y (+ (lashBackground y:) 229))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oFourteenButn of OpeningLashButton
	(properties
		view 19
		loop 29
		enumType 99
		buttVerb 169
	)

	(method (init)
		(= x (+ (lashBackground x:) 311))
		(= y (+ (lashBackground y:) 229))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oFifteenButn of OpeningLashButton
	(properties
		view 19
		loop 30
		enumType 100
		buttVerb 170
	)

	(method (init)
		(= x (+ (lashBackground x:) 387))
		(= y (+ (lashBackground y:) 229))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oSixteenButn of OpeningLashButton
	(properties
		view 19
		loop 31
		enumType 101
		buttVerb 171
	)

	(method (init)
		(= x (+ (lashBackground x:) 83))
		(= y (+ (lashBackground y:) 251))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oSeventeenButn of OpeningLashButton
	(properties
		view 19
		loop 32
		enumType 102
		buttVerb 172
	)

	(method (init)
		(= x (+ (lashBackground x:) 159))
		(= y (+ (lashBackground y:) 251))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oEighteenButn of OpeningLashButton
	(properties
		view 19
		loop 33
		enumType 103
		buttVerb 173
	)

	(method (init)
		(= x (+ (lashBackground x:) 235))
		(= y (+ (lashBackground y:) 251))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oNineteenButn of OpeningLashButton
	(properties
		view 19
		loop 34
		enumType 104
		buttVerb 174
	)

	(method (init)
		(= x (+ (lashBackground x:) 311))
		(= y (+ (lashBackground y:) 251))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance oTwentyButn of OpeningLashButton
	(properties
		view 19
		loop 35
		enumType 105
		buttVerb 175
	)

	(method (init)
		(= x (+ (lashBackground x:) 387))
		(= y (+ (lashBackground y:) 251))
		(super init: &rest)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(gLashInterface add: opening)
		)
		(super select: param1 param2 &rest)
	)
)

(instance level of LashButton
	(properties
		buttVerb 153
	)

	(method (doVerb))

	(method (select))
)

(instance side of LashButton
	(properties
		buttVerb 154
	)

	(method (doVerb))

	(method (select))
)

(instance opening of LashButton
	(properties
		buttVerb 155
	)

	(method (doVerb))

	(method (select))
)

(instance transmitButn of Button
	(properties
		view 19
		loop 36
	)

	(method (init)
		(= x (+ (lashBackground x:) 195))
		(= y (+ (lashBackground y:) 279))
		(super init: &rest)
	)

	(method (doVerb)
		(leftFlash setCycle: Fwd)
		(rightFlash setCycle: Fwd)
		(self setActive: 0)
		(gLashInterface transmit:)
	)
)

(instance leftFlash of Prop
	(properties
		view 19
		loop 37
	)

	(method (init)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

(instance rightFlash of Prop
	(properties
		view 19
		loop 38
	)

	(method (init)
		(= x (+ (lashBackground x:) 446))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

