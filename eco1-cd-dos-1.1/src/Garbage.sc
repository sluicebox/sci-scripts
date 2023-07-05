;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use Talker)
(use System)

(class Garbage of EcoView
	(properties
		flag 0
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(if (not (self checkFlag:))
			(self show: approachVerbs: 6 4 2 ignoreActors: 1 stopUpd:) ; Recycle, Do, Talk
			(if (or (not approachX) (not approachY))
				(if (< (self x:) 161)
					(self approachX: (+ x 33) approachY: (- y 7))
				else
					(self approachX: (- x 33) approachY: (- y 7))
				)
			)
			(if (not priority)
				(self setPri: 0)
			)
		else
			(self dispose:)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 1 0 0 149 0 4)
			)
			(2 ; Talk
				(EcoNarrator init: 1 0 0 148 0 4)
			)
			(44 ; Inventory
				(EcoNarrator init: 1 0 0 149 0 4)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)

	(method (checkFlag)
		(return (& [global236 (/ flag 16)] (>> $8000 (mod flag 16))))
	)

	(method (setFlag)
		(= [global236 (/ flag 16)]
			(| [global236 (/ flag 16)] (>> $8000 (mod flag 16)))
		)
	)

	(method (cue)
		(self setFlag: dispose:)
		(Animate (gCast elements:) 0)
		(self checkRoom:)
	)

	(method (checkRoom)
		(if (not (gCast firstTrue: #isKindOf Garbage))
			(switch gCurRoomNum
				(120
					(if (not (IsFlag 344))
						(EcoNarrator init: global250 0 0 15)
					)
					(SetScore 10 344)
				)
				(180
					(if (not (IsFlag 347))
						(EcoNarrator init: global250 0 0 96)
					)
					(SetScore 10 347)
				)
				(200
					(if (or (not (IsFlag 345)) (not (IsFlag 346)))
						(EcoNarrator init: global250 0 0 96)
					)
					(if (IsFlag 345)
						(SetScore 10 346)
					)
					(SetScore 10 345)
				)
				(420
					(if (not (IsFlag 348))
						(EcoNarrator init: global250 0 0 96)
					)
					(SetScore 10 348)
				)
			)
		)
	)
)

