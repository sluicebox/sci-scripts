;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 963)
(include sci.sh)
(use DPath)

(class RelDPath of DPath
	(properties)

	(method (setTarget)
		(if (!= (points at: value) -32768)
			(+= x (points at: value))
			(+= y (points at: (++ value)))
			(++ value)
		)
	)
)

