;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 822)
(include sci.sh)

(public
	proc822_0 0
)

(procedure (proc822_0 param1)
	(if (param1 script:)
		(proc822_0 (param1 script:) &rest)
	else
		(param1 setScript: &rest)
	)
)

