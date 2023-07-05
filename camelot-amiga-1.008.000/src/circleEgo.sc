;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 189)
(include sci.sh)
(use Main)
(use System)

(public
	circleEgo 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance circleEgo of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (or (== (++ local2) 7) (not local2))
			((ScriptID 177 2) y: (+ ((ScriptID 177 2) y:) local3)) ; theDove, theDove
			(= local2 (+= local1 local5))
			(if (or (== local1 7) (not local1))
				(if (== local5 1)
					(= local5 -1)
					(= local1 6)
				else
					(= local5 1)
					(= local1 1)
				)
				(= local2 local1)
				(if (== local3 4)
					(= local3 -4)
				else
					(= local3 4)
				)
			)
		)
		(if (< local4 ((ScriptID 177 2) x:)) ; theDove
			((ScriptID 177 2) ; theDove
				x: (- ((ScriptID 177 2) x:) ((ScriptID 177 2) xStep:)) ; theDove, theDove
			)
			(if (< ((ScriptID 177 2) x:) local4) ; theDove
				(self cue:)
			)
		else
			((ScriptID 177 2) ; theDove
				x: (+ ((ScriptID 177 2) x:) ((ScriptID 177 2) xStep:)) ; theDove, theDove
			)
			(if (< local4 ((ScriptID 177 2) x:)) ; theDove
				(self cue:)
			)
		)
		(cond
			((and (< local3 0) (> local0 0))
				((ScriptID 177 2) loop: 6) ; theDove
			)
			((and (< local3 0) (< local0 0))
				((ScriptID 177 2) loop: 5) ; theDove
			)
			((and (> local3 0) (> local0 0))
				((ScriptID 177 2) loop: 2) ; theDove
			)
			(else
				((ScriptID 177 2) loop: 1) ; theDove
			)
		)
		(if (< global199 60)
			(if (and (== ((ScriptID 177 2) z:) global198) (== (Random 1 6) 1)) ; theDove
				(= global198 (+ 50 (Random 1 30)))
			)
		else
			(= global198 local6)
		)
		(if (not (-- global199))
			((ScriptID 177 3) setScript: 0) ; doveShadow
			(((ScriptID 177 2) script:) cue:) ; theDove
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 297)
				(= local6 ((ScriptID 177 2) z:)) ; theDove
				(switch register
					(1
						(= local0 124)
						(= local3 -4)
						(= local5 -1)
					)
					(2
						(= local0 -124)
						(= local3 -4)
						(= local5 -1)
					)
					(3
						(= local0 124)
						(= local3 4)
						(= local5 -1)
					)
				)
				(= global199 84)
				(= local1 6)
				(if (== local5 1)
					(= local1 1)
				)
				(= local2 local1)
				(= local4 (+ ((ScriptID 177 2) x:) local0)) ; theDove
			)
			(1
				(if (> local0 0)
					(= local0 -124)
				else
					(= local0 124)
				)
				(if (> local3 0)
					(= local3 -4)
				else
					(= local3 4)
				)
				(= local4 (+ ((ScriptID 177 2) x:) local0)) ; theDove
			)
			(2
				(= local2 (= local1 7))
				(self changeState: 1)
			)
		)
	)

	(method (dispose)
		(SetFlag 218)
		(ClearFlag 297)
		(super dispose:)
	)
)

