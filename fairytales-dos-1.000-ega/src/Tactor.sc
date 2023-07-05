;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use n010)
(use Interface)
(use Talker)
(use User)
(use Actor)

(class Tactor of Actor
	(properties
		doCode 0
		selection 0
		talkerObj 0
		talkerID 0
		client 0
	)

	(method (init)
		(self setUp:)
		(super init: &rest)
	)

	(method (setUp))

	(method (incSel)
		(++ selection)
	)

	(method (relPosn param1 param2 param3)
		(self posn: (+ (param1 x:) param2) (+ (param1 y:) param3))
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(cond
			((!= theVerb 5) ; Do
				(super doVerb: theVerb &rest)
			)
			((IsObject doCode)
				(doCode doit: theVerb)
			)
			(else
				(StrCpy @temp0 (if description description else name))
				(StrAt @temp0 0 (proc10_26 (StrAt @temp0 0)))
				(Printf 90 0 @temp0) ; "The %s is quiet right now."
			)
		)
	)
)

(class Tego of Ego
	(properties
		doCode 0
		selection 0
		talkerObj 0
		talkerID 0
	)

	(method (incSel)
		(++ selection)
	)
)

(class TalkerObj of Talker
	(properties
		facingDir 3
	)

	(method (setUp param1 param2 param3)
		(= bust param1)
		(= eyes param2)
		(= mouth param3)
	)

	(method (show param1 &tmp temp0)
		(bust cel: param1)
		(cond
			((and (== facingDir 3) (== loop 1))
				(= loop 0)
				(bust loop: 6)
				(eyes loop: 4)
				(mouth loop: 2)
				(= temp0 (CelWide view 0 0))
				(bust
					nsLeft:
						(- (- temp0 (CelWide (bust view:) 6 0)) (bust nsLeft:))
				)
				(eyes
					nsLeft:
						(- (- temp0 (CelWide (eyes view:) 4 0)) (eyes nsLeft:))
				)
				(mouth
					nsLeft:
						(-
							(- temp0 (CelWide (mouth view:) 2 0))
							(mouth nsLeft:)
						)
				)
			)
			((and (== facingDir 7) (!= loop 1))
				(= loop 1)
				(bust loop: 7)
				(eyes loop: 5)
				(mouth loop: 3)
				(= temp0 (CelWide view 0 0))
				(bust
					nsLeft:
						(- (- temp0 (CelWide (bust view:) 7 0)) (bust nsLeft:))
				)
				(eyes
					nsLeft:
						(- (- temp0 (CelWide (eyes view:) 5 0)) (eyes nsLeft:))
				)
				(mouth
					nsLeft:
						(-
							(- temp0 (CelWide (mouth view:) 3 0))
							(mouth nsLeft:)
						)
				)
			)
		)
		(super show:)
	)
)

