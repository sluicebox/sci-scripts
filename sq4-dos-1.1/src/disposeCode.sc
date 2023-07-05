;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use LoadMany)
(use System)

(public
	disposeCode 0
)

(instance disposeCode of Code
	(properties)

	(method (doit param1)
		(LoadMany
			0
			939
			974
			969
			966
			965
			964
			956
			982
			951
			941
			961
			942
			945
			946
			812
			808
			708
			810
			940
			807
		)
		(if
			(or
				(and
					(OneOf param1 25 30 35 40 45 50 55 60 65)
					(!= global102 701)
				)
				(and
					(OneOf
						param1
						370
						371
						375
						376
						380
						381
						385
						386
						387
						390
						391
						395
						397
						398
						399
						400
						405
						406
						410
						411
					)
					(!= global102 700)
				)
				(and
					(OneOf
						param1
						150
						500
						505
						510
						514
						515
						520
						525
						541
						544
						545
					)
					(!= global102 704)
				)
				(not
					(OneOf
						param1
						25
						30
						35
						40
						45
						50
						55
						60
						65
						370
						371
						375
						376
						380
						381
						385
						386
						387
						390
						391
						395
						397
						398
						399
						400
						405
						406
						410
						411
						150
						500
						505
						510
						514
						515
						520
						525
						541
						544
						545
					)
				)
			)
			(DisposeScript 806)
		)
		(if (not (OneOf param1 405 406 410 411))
			(DisposeScript 809)
		)
		(DisposeScript 800)
		(DisposeScript 801)
	)
)

