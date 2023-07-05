;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 892)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use User)
(use System)

(class MiracleGro of Code
	(properties
		who 0
		color 0
		holdScript 0
		holdClient 0
		holdLooper 0
		holdNormal 0
		holdControl 0
		endX 0
		endY 0
		busy 0
		whichView 0
		dir 0
		backToOk 0
		vList 0
	)

	(method (init param1 &tmp temp0)
		(= vList [param1 0])
		(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
			(vList add: [param1 temp0])
		)
	)

	(method (dispose)
		(vList dispose:)
		(= vList 0)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(if busy
			(return)
		)
		(= holdControl (User controls:))
		(HandsOff 1)
		(= busy 1)
		(if
			(and
				(IsObject (who mover:))
				(IsObject ((who mover:) caller:))
				(= holdScript ((who mover:) caller:))
			)
			(= holdClient (holdScript client:))
			(holdScript client: 0)
		)
		(cond
			((not (IsObject (who mover:)))
				(= endX (who x:))
				(= endY (who y:))
			)
			(((who mover:) isKindOf: PolyPath)
				(= endX ((who mover:) finalX:))
				(= endY ((who mover:) finalY:))
			)
			(else
				(= endX ((who mover:) x:))
				(= endY ((who mover:) y:))
			)
		)
		(= temp0 0)
		(= whichView -1)
		(while (< temp0 (vList size:))
			(if (== (who view:) (vList at: temp0))
				(= whichView temp0)
				(break)
			)
			(+= temp0 7)
		)
		(if (== whichView -1)
			(who view: (vList at: (if (== gDay 1) 7 else 21)))
			(if holdControl
				(HandsOn)
			)
			(= busy 0)
			(return)
		)
		(if (or (> (who heading:) 270) (< (who heading:) 90))
			(= dir 1)
		else
			(= dir -1)
		)
		(while (& (OnControl CONTROL endX endY) color)
			(-= endY dir)
		)
		(= holdNormal (who normal:))
		(= holdLooper (who looper:))
		(who
			normal: 0
			setMotion: 0
			setLoop: -1
			setLoop: (vList at: (+ whichView 3))
			view: (vList at: (+ whichView 1))
			yStep: (vList at: (+ whichView 6))
			setCel: 0
		)
		(who
			setMotion:
				PolyPath
				(who x:)
				(- (who y:) (* (who yStep:) (- (NumCels who) 1) dir))
			setCycle: End self
		)
	)

	(method (cue &tmp temp0)
		(if (& (OnControl CONTROL (who x:) (who y:)) color)
			(for
				((= temp0 (who y:)))
				(& (OnControl CONTROL (who x:) temp0) color)
				((-= temp0 dir))
			)
			(= backToOk 1)
			(who
				view: (vList at: (+ whichView 2))
				setCycle: Walk
				setLoop: -1
				setLoop: holdLooper
				setStep: (vList at: (+ whichView 4)) (vList at: (+ whichView 5))
				loop: (if (== dir 1) 3 else 2)
				setMotion: PolyPath (who x:) temp0 self
			)
		else
			(if holdScript
				(holdScript client: holdClient)
			)
			(if (not backToOk)
				(who
					view: (vList at: (+ whichView 2))
					setCycle: Walk
					setLoop: -1
					setLoop: holdLooper
					setStep:
						(vList at: (+ whichView 4))
						(vList at: (+ whichView 5))
					loop: (if (== dir 1) 3 else 2)
				)
			)
			(cond
				(holdScript
					(who setMotion: PolyPath endX endY holdScript)
				)
				(
					(or
						(and (== dir 1) (> endY (who y:)))
						(and (== dir -1) (< endY (who y:)))
					)
					(= endY (who y:))
				)
				(else
					(who setMotion: PolyPath endX endY)
				)
			)
			(who normal: holdNormal)
			(if holdControl
				(HandsOn)
			)
			(= backToOk
				(= dir (= holdControl (= holdClient (= holdScript (= busy 0)))))
			)
		)
	)
)

