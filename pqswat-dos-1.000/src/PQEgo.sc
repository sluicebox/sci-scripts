;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Ego)

(class PQEgo of Ego
	(properties
		medals 0
	)

	(method (awardMedal param1)
		(|= medals param1)
		(if (& param1 $0001)
			(if (>= global444 6)
				(return)
			else
				(++ global444)
			)
		)
		(if (& param1 $0002)
			(if (>= global439 3)
				(return)
			else
				(++ global439)
			)
		)
		(if (& param1 $0004)
			(if (>= global440 11)
				(return)
			else
				(++ global440)
			)
		)
		(if (& param1 $0040)
			(if (>= global442 26)
				(return)
			else
				(++ global442)
			)
		)
		(if (& param1 $0020)
			(if (>= global443 11)
				(return)
			else
				(++ global443)
			)
		)
	)

	(method (makeLeader)
		(|= medals $0080)
	)
)

