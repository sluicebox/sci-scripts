;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(class Garbage of View
	(properties
		noun 26
		modNum 999
		signal 16385
		flag 0
		obst 0
	)

	(method (init)
		(if (not (self checkFlag:))
			(super init: &rest)
			(self approachVerbs: 53 approachX: (- x 5) approachY: (+ y 3)) ; Recycle
			(gCurRoom
				addObstacle:
					((= obst (Polygon new:))
						type: PBarredAccess
						init:
							brLeft
							brTop
							brRight
							brTop
							brRight
							brBottom
							brLeft
							brBottom
						yourself:
					)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 47))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (dispose)
		(if (IsObject obst)
			((gCurRoom obstacles:) delete: obst)
			(obst dispose:)
			(= obst 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 47))
			(if (== theVerb 53) ; Recycle
				(if (not (gUser controls:))
					(gMessager say: noun theVerb 13 0 0 999) ; "I can't reach that."
				else
					(gEgo setScript: pickMUp 0 self)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (checkFlag)
		(return (& [global112 (/ flag 16)] (>> $8000 (mod flag 16))))
	)

	(method (setFlag)
		(= [global112 (/ flag 16)]
			(| [global112 (/ flag 16)] (>> $8000 (mod flag 16)))
		)
	)
)

(instance pickMUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 5 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(register setFlag: dispose:)
				(gGame points: 1)
				(gEgo setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

