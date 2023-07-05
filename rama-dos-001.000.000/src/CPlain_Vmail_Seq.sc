;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1018)
(include sci.sh)
(use Timed_Vidmail_Sequence)

(public
	CPlain_Vmail_Seq 0
)

(instance CPlain_Vmail_Seq of Timed_Vidmail_Sequence
	(properties
		vidMail1 43
		vidMail2 43
		vidMail3 43
		delay1 200
	)

	(method (serialize param1)
		(super serialize: param1 1018 0)
	)

	(method (dispose)
		((ScriptID 200 0) script: 0) ; cplainRegion
		((ScriptID 200 0) setScript: 0) ; cplainRegion
		(super dispose: &rest)
	)
)

