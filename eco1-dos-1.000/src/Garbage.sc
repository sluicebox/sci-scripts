;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use Actor)

(class Garbage of View
	(properties
		flag 0
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(if (not (self checkFlag:))
			(self show: approachVerbs: 10 3 5 ignoreActors: 1 stopUpd:) ; Recycle, Do, Talk
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 149 0 4) ; "That's just trash and not worth Adam's trying to manipulate."
			)
			(5 ; Talk
				(Narrator init: 148 0 4) ; "Garbage can't talk! Even if it could, Adam isn't sure he'd want to hear what it had to say."
			)
			(4 ; Inventory
				(Narrator init: 149 0 4) ; "That's just trash and not worth Adam's trying to manipulate."
			)
			(else
				(super doVerb: theVerb invItem &rest)
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
						(Narrator init: 15)
					)
					(SetScore 10 344)
				)
				(180
					(if (not (IsFlag 347))
						(Narrator init: 96)
					)
					(SetScore 10 347)
				)
				(200
					(if (or (not (IsFlag 345)) (not (IsFlag 346)))
						(Narrator init: 96)
					)
					(if (IsFlag 345)
						(SetScore 10 346)
					)
					(SetScore 10 345)
				)
				(420
					(if (not (IsFlag 348))
						(Narrator init: 96)
					)
					(SetScore 10 348)
				)
			)
		)
	)
)

