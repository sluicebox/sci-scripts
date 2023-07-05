;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 108)
(include sci.sh)
(use Main)
(use rentOffice)
(use Sync)

(public
	proc108_0 0
)

(local
	local0
)

(procedure (proc108_0)
	(= local0 0)
	(= global564 0)
	(if (!= global323 60)
		(cond
			((not (global302 dressedForWork:))
				(if global413
					(global413 init: 16 MouthSync (+ global400 900))
				)
				(= global564 (proc0_18 (+ global400 900) global413))
			)
			((< (global302 dependibility:) (- (global302 minDepend:) 5))
				(gASoundEffect play: 30)
				(if global413
					(global413 init: 16 MouthSync (+ global400 920))
				)
				(= global564 (proc0_18 (+ global400 920) global413))
				(= local0 -1)
				(global302 wage: 0 worksAt: 0 occupation: 0 jobT: -1)
			)
			(
				(and
					(< (global302 dependibility:) (- (global302 minDepend:) 2))
					global329
				)
				(if global413
					(global413 init: 16 MouthSync (+ global400 940))
				)
				(= global564 (proc0_18 (+ global400 940) global413))
				(localproc_0)
			)
			(else
				(localproc_0)
			)
		)
	else
		(if global413
			(global413 init: 16 MouthSync (+ global400 960))
		)
		(= global564 (proc0_18 (+ global400 960) global413))
	)
	(return local0)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 [temp3 5])
	(= global329 0)
	(if
		(<
			(global302 experience:)
			(+ (global302 maxExper:) (global302 expCredit:))
		)
		(global302 experience: (+ (global302 experience:) 1))
	)
	(if
		(<
			(global302 dependibility:)
			(+ (global302 minDepend:) 20 (global302 eduCredit:))
		)
		(global302 dependibility: (+ (global302 dependibility:) 1))
	)
	(global302
		carStat:
			(if (global302 wage:)
				(* (/ (global302 dependibility:) 8) 10)
			else
				0
			)
	)
	(if (> (global302 carStat:) 100)
		(global302 carStat: 100)
	)
	(= temp1 (= temp0 (* (global302 wage:) 8)))
	(if (> (+ global323 6) 60)
		(= temp2 (- 60 global323))
		(= temp1 (/ (* temp1 temp2) 6))
	)
	(if (global302 rentOwed:)
		(if (> (/ temp0 2) (global302 rentOwed:))
			(= temp1 (- temp0 (global302 rentOwed:)))
			(global302 rentOwed: 0)
		else
			(= temp1 (- (/ temp0 2) 2))
			(global302 rentOwed: (- (global302 rentOwed:) (/ temp0 2)))
		)
		(if global413
			(global413 init: 16 MouthSync (+ global400 980))
		)
		(if (not global562)
			(= global564 (proc0_18 (+ global400 980) global413))
			(= global562 1)
		)
		(if (== (global302 worksAt:) 1)
			(proc201_1)
		)
		(global302 rentExt: -1)
	)
	(proc0_10 temp1)
	(= local0 1)
	(gCalc doit:)
	(gTimeKeep doit: 6)
)

