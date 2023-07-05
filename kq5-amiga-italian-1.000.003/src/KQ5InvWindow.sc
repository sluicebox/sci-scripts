;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 757)
(include sci.sh)
(use BertaWindow)

(class KQ5InvWindow of BertaWindow
	(properties)

	(method (open &tmp temp0)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)
)

