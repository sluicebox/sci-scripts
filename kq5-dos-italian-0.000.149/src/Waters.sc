;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Actor)

(class Waters of Prop
	(properties
		signal 24608
		pos 3
		nLoops 0
		illegalBits 0
		cycCnt 0
		wfCels 0
		wfCnt -1
	)

	(method (init)
		(super init:)
		(Load rsVIEW view)
		(= nLoops (NumLoops self))
	)

	(method (doit)
		(cond
			(cycCnt
				(-- cycCnt)
			)
			(wfCels
				(if (== wfCnt -1)
					(= wfCnt wfCels)
					(self getLoop:)
					(++ x)
					(-- y)
				)
				(if wfCnt
					(if (& (-- wfCnt) $0001)
						(-- x)
					else
						(++ x)
					)
					(++ y)
				else
					(= wfCnt wfCels)
					(-= y wfCnt)
					(= cycCnt cycleSpeed)
				)
			)
			(else
				(if (>= (++ loop) nLoops)
					(= pos (= loop 0))
					(= cycCnt cycleSpeed)
				)
				(self getLoop:)
				(if (>= (++ cel) (NumCels self))
					(= cel 0)
				)
				(self saveLoop:)
			)
		)
	)

	(method (dispose)
		(&= signal $ffdf)
		(super dispose:)
	)
)

