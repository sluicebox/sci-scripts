;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3080)
(include sci.sh)
(use Timed_Vidmail_Sequence)

(public
	Rama_Quake_Vmail_Seq 0
)

(instance Rama_Quake_Vmail_Seq of Timed_Vidmail_Sequence
	(properties
		vidMail1 41
		vidMail2 42
		delay1 10
		delay2 10
	)

	(method (serialize param1)
		(super serialize: param1 3080 0)
	)

	(method (dispose)
		((ScriptID 200 0) script: 0) ; cplainRegion
		((ScriptID 200 0) setScript: 0) ; cplainRegion
		(super dispose:)
	)
)

