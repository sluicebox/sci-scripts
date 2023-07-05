;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1013)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use n63002)
(use P2Feature)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	mhRecRmCH3SR1 0
)

(local
	[local0 15] = [340 341 342 343 344 345 346 347 348 349 350 351 352 353 354]
	[local15 15] = [353 354 355 356 357 358 359 360 361 362 363 364 365 366 367]
)

(instance mhRecRmCH3SR1 of P2Room
	(properties
		picture 510
		east 1033
		west 1033
	)

	(method (init)
		(if (not (IsFlag 344))
			(InvPlane recalc: 0)
		)
		(ClearFlag 1001)
		(if (not (IsFlag 347))
			(curtisSitFidget init:)
			(ballLoonies init:)
			(cleaningLoonies init:)
			(nurseFidget init:)
			(ratWomanFidget init:)
			(nurse init:)
			(jinglyToy init:)
			(curtis init:)
			(lunatic1 init:)
			(lunatic2 init:)
			(lunatic4 init:)
			(ratWoman init:)
			(south1Exit init:)
			(south2Exit init:)
		else
			(if (IsFlag 350)
				(curtisStandFidget init:)
				(if (not (NurseTimer initialized:))
					(NurseTimer init: 3 10)
				)
			else
				(curtisSitFidget init:)
				(curtis init:)
				(shadow init:)
			)
			(stillRatWoman init:)
			(chair init:)
			(wallLoonies init:)
			(= south 1033)
		)
		(table init:)
		(super init: &rest)
		(if (not (IsFlag 344))
			(SetFlag 344)
			(gP2SongPlyr fadeIn: 1910 65)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance nurse of P2Feature
	(properties
		priority 300
		scene 150
		doneFlag 345
	)

	(method (init)
		(super init: 29 34 103 176)
	)

	(method (dispose)
		(if plane
			(super dispose: &rest)
		)
	)
)

(instance jinglyToy of P2Feature
	(properties
		priority 500
	)

	(method (init)
		(if (not (IsFlag 349))
			(if (IsFlag 346)
				(return 0)
			else
				(= scene 180)
				(= doneFlag 346)
				(= whoDoit 0)
			)
		else
			(= scene 190)
			(= doneFlag 347)
			(= whoDoit toyStruggleCode)
		)
		(super init: (proc63002_10 343 303 401 283 417 301 356 323))
	)

	(method (onMe)
		(if (super onMe: &rest)
			(if (<= 9 (ballLoonies cel:) 12)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance toyStruggleCode of Code
	(properties)

	(method (doit)
		(gP2SongPlyr start: 1911)
		(ballLoonies dispose:)
		(cleaningLoonies dispose:)
		(nurseFidget dispose:)
		(ratWomanFidget dispose:)
		(UnLoad 128 15102)
		(UnLoad 128 15103)
		(UnLoad 128 15101)
		(nurse dispose:)
		(lunatic1 dispose:)
		(lunatic2 dispose:)
		(lunatic4 dispose:)
		(ratWoman dispose:)
		(south1Exit dispose:)
		(south2Exit dispose:)
		(chair init:)
		(wallLoonies init:)
		(stillRatWoman init:)
		(shadow init:)
		((ScriptID 63000 1) nextRoom: 1033 init:) ; sExit
	)
)

(instance curtis of P2Feature
	(properties
		nextRoom 1023
	)

	(method (init)
		(super
			init: (proc63002_10 278 167 317 86 343 86 395 205 388 276 332 282)
		)
	)
)

(instance lunatic1 of P2Feature
	(properties
		scene 260
		doneFlag 351
	)

	(method (init)
		(super
			init:
				(proc63002_10
					403
					276
					416
					243
					440
					242
					453
					214
					449
					181
					461
					174
					475
					174
					480
					198
					501
					208
					521
					280
					463
					304
				)
		)
	)

	(method (dispose)
		(if plane
			(super dispose: &rest)
		)
	)
)

(instance lunatic2 of P2Feature
	(properties
		scene 280
		doneFlag 352
	)

	(method (init)
		(super
			init:
				(proc63002_10
					219
					331
					225
					266
					258
					238
					286
					212
					307
					225
					298
					250
					289
					259
					336
					331
				)
		)
	)

	(method (dispose)
		(if plane
			(super dispose: &rest)
		)
	)
)

(instance lunatic4 of P2Feature
	(properties)

	(method (init)
		(if
			(proc63002_4
				353
				354
				355
				356
				357
				358
				359
				360
				361
				362
				363
				364
				365
				366
				367
			)
			(return 0)
		else
			(super
				init:
					(proc63002_10
						460
						110
						465
						46
						480
						34
						485
						15
						505
						15
						504
						38
						519
						45
						523
						79
						515
						97
						509
						114
					)
			)
			(= whoDoit loon4Code)
		)
	)

	(method (dispose)
		(if plane
			(super dispose: &rest)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(proc63002_4
				353
				354
				355
				356
				357
				358
				359
				360
				361
				362
				363
				364
				365
				366
				367
			)
			(self dispose:)
		)
	)
)

(instance loon4Code of Code
	(properties)

	(method (doit &tmp temp0)
		(for
			((= temp0 (Random 0 14)))
			(IsFlag [local15 temp0])
			((= temp0 (Random 0 14)))
		)
		(proc63002_7 [local0 temp0])
		(SetFlag [local15 temp0])
	)
)

(instance south1Exit of ExitFeature
	(properties
		priority 1
		nextRoom 1033
		exitDir 4
	)

	(method (init)
		(super init: 0 297 312 335)
	)
)

(instance south2Exit of ExitFeature
	(properties
		priority 1
		nextRoom 1033
		exitDir 4
	)

	(method (init)
		(super init: 422 297 639 335)
	)
)

(instance curtisSitFidget of P2Fidget
	(properties
		x 265
		y 290
		view 15100
		cycleSpeed 8
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 20)
	)
)

(instance ballLoonies of P2Fidget
	(properties
		x 213
		y 338
		view 15102
		cycleSpeed 8
		initStart 2
		initFinish 3
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

(instance cleaningLoonies of P2Fidget
	(properties
		x 415
		y 255
		view 15103
		initStart 1
		initFinish 6
		cycleStart 2
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance ratWomanFidget of P2Fidget
	(properties
		x 506
		y 336
		view 15107
		initStart 1
		initFinish 6
		cycleStart 2
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 50)
	)
)

(instance table of View
	(properties
		x 507
		y 338
		view 15107
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 40)
	)
)

(instance nurseFidget of P2Fidget
	(properties
		x 30
		y 193
		view 15101
		initStart 2
		initFinish 5
		cycleStart 2
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance curtisStandFidget of P2Fidget
	(properties
		x 273
		y 295
		view 15106
		cycleSpeed 8
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance wallLoonies of P2Fidget
	(properties
		x 411
		y 243
		view 15105
		cycleSpeed 4
		initStart 1
		initFinish 6
		cycleStart 2
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 30)
	)
)

(instance chair of View
	(properties
		x 410
		y 243
		view 15105
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance shadow of View
	(properties
		x 274
		y 301
		view 15100
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 5)
	)
)

(instance stillRatWoman of View
	(properties
		x 506
		y 336
		view 15107
	)

	(method (init)
		(super init: &rest)
		(self setPri: 50)
	)
)

(instance ratWoman of P2Feature
	(properties)

	(method (init)
		(if (not (IsFlag 369))
			(= whoDoit ratCode)
			(super init: (proc63002_10 514 315 569 291 631 324 631 335 513 335))
		)
	)

	(method (dispose)
		(if plane
			(super dispose: &rest)
		)
	)
)

(instance ratCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 368))
			(proc63002_7 370)
			(SetFlag 368)
		else
			(proc63002_7 372)
			(SetFlag 369)
			(ratWoman dispose:)
		)
	)
)

