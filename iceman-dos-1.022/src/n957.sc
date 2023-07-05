;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 957)
(include sci.sh)

(public
	LastLink 0
)

(procedure (LastLink whatLink whose &tmp linkValue)
	(return
		(if (and (whose respondsTo: whatLink) (= linkValue (whose whatLink:)))
			(LastLink whatLink linkValue)
		else
			whose
		)
	)
)

