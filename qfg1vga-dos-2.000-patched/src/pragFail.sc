;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use User)
(use System)

(public
	pragFail 0
)

(procedure (localproc_0 param1)
	(gEgo use: param1 1)
	(gEgo get: 11) ; flask
	(gMessager say: 1 0 0 1 0 121) ; "You pour the contents of the flask all over. Maybe you're not doing this right."
)

(instance pragFail of Code
	(properties)

	(method (doit &tmp temp0 [temp1 52])
		(= temp0 ((gUser curEvent:) message:))
		(if (User input:)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (OneOf temp0 JOY_UP JOY_UPRIGHT JOY_DOWNRIGHT $000a KEY_CLEAR KEY_CONTROL $001a KEY_MULTIPLY)
				(gMessager say: 1 temp0 0 0 0 121)
				(return 1)
			else
				(switch temp0
					(KEY_Q
						(CastDart 0)
					)
					(KEY_CAPITAL
						(ThrowRock 0)
						(return 1)
					)
					(KEY_SHIFT
						(ThrowKnife 0)
						(return 1)
					)
					($0016
						(localproc_0 12)
					)
					($0017
						(localproc_0 13)
					)
					($0018
						(localproc_0 14)
					)
					($0019
						(localproc_0 15)
					)
					($001d
						(localproc_0 19)
					)
					($0027 ; '
						(localproc_0 29)
					)
					(else
						(gMessager say: 1 0 0 2 0 121) ; "There's no point in trying to use one of those there."
						(return 1)
					)
				)
			)
		)
		(return (DisposeScript 121))
	)
)

