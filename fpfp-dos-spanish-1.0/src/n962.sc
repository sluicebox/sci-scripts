;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 962)
(include sci.sh)

(public
	QueScript 0
)

(procedure (QueScript theClient theScript optCaller optReg &tmp theObj theCaller theReg aTmp) ; UNUSED
	(= theObj theClient)
	(= theCaller 0)
	(= theReg 0)
	(if (>= argc 3)
		(= theCaller optCaller)
		(if (>= argc 4)
			(= theReg optReg)
		)
		((= theScript (ScriptObject theScript)) caller: theCaller register: theReg)
	)
	(while 1
		(cond
			((not theObj)
				(theClient setScript: (ScriptObject theScript))
				(break)
			)
			((not (theObj respondsTo: #next))
				(if (theObj script:)
					(= theObj (theObj script:))
				else
					(theObj setScript: (ScriptObject theScript))
					(break)
				)
			)
			((== theObj theClient)
				(if (== (= theObj (theClient script:)) (theObj script:))
					(= theObj (theObj new:))
				)
			)
			((theObj next:)
				(= aTmp (ScriptObject (theObj next:)))
				(theObj
					next:
						(cond
							((== theObj (theObj next:))
								((aTmp new:) next: 0 yourself:)
							)
							((& (theObj -info-:) $0001)
								((aTmp new:) next: 0 yourself:)
							)
							(else aTmp)
						)
				)
				(= theObj (theObj next:))
			)
			(else
				(theObj
					next:
						(if
							(or
								(== theScript theObj)
								(and
									(IsObject theScript)
									(& (theScript -info-:) $0001)
								)
							)
							(theScript new:)
						else
							theScript
						)
				)
				(break)
			)
		)
	)
)

(procedure (ScriptObject x)
	(return
		(if (IsObject x)
			x
		else
			(ScriptID x)
		)
	)
)

