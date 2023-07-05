;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1017)
(include sci.sh)
(use Timed_Vidmail_Sequence)

(public
	HubCamp_Vmail_Seq 0
)

(instance HubCamp_Vmail_Seq of Timed_Vidmail_Sequence
	(properties
		vidMail1 35
		vidMail2 36
		delay1 200
	)

	(method (serialize param1)
		(super serialize: param1 1017 0)
	)
)

