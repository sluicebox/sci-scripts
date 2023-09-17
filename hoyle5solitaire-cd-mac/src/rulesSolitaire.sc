;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6100)
(include sci.sh)
(use Main)
(use RulesPrint)
(use System)

(public
	rulesSolitaire 0
)

(instance rulesSolitaire of Code
	(properties)

	(method (init &tmp temp0)
		(= temp0
			(switch gCardGameScriptNumber
				(6001 5)
				(6002 4)
				(6003 5)
				(6004 3)
				(6005 4)
				(6006 5)
				(6007 4)
				(6008 4)
				(6009 4)
				(6010 4)
				(6011 4)
				(6012 4)
				(6013 3)
				(6014 4)
				(6015 4)
				(6016 4)
				(6017 4)
				(6018 3)
				(6019 5)
				(6020 7)
				(6021 4)
				(6022 4)
				(6023 5)
				(6024 4)
				(6025 5)
				(6026 4)
				(6027 6)
				(6028 6)
			)
		)
		(proc821_0 gCardGameScriptNumber temp0)
		(DisposeScript 6100)
	)
)

