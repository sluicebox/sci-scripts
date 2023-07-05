;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Talker)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	regionFish 0
)

(local
	[local0 33] = [0 0 0 54 42 45 57 46 49 60 51 53 63 56 57 66 58 59 69 60 61 72 62 63 75 64 65 78 66 67 81 68 69]
	[local33 6]
)

(class regionFish of Rgn
	(properties
		pts 0
		size 0
	)

	(method (init)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(= initialized (= keep 0))
		(self sushi:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (addFish param1 &tmp temp0)
		(for
			((= temp0 0))
			(and (< temp0 argc) (< size 6) (or (not size) (< size gHowFast)))
			((++ temp0))
			
			(= [local33 size] (Clone Fish))
			([local33 size] mPts: [param1 temp0] init:)
			(++ size)
		)
	)

	(method (sushi)
		(if size
			(-- size)
			(while size
				([local33 size] dispose:)
				(-- size)
			)
		)
	)
)

(class Fish of Actor
	(properties
		signal 24576
		mPts 0
		ptsPtr 0
		fishNumber 0
		pathContinue 1
		seconds 0
		lastSeconds 0
	)

	(method (init)
		(self setupFish:)
		(super init: &rest)
		(self startMove:)
	)

	(method (doit &tmp temp0)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
				(if (not (-- seconds))
					(self cue:)
				)
			)
		)
		(super doit:)
	)

	(method (setupFish &tmp temp0 temp1)
		(self
			view:
				(if (!= (= temp1 (WordAt mPts 0)) -1)
					temp1
				else
					(+ (* (Random 1 10) 3) 51)
				)
			fishNumber:
				(if (!= (= temp0 (WordAt mPts 1)) -1)
					temp0
				else
					(Random 0 1)
				)
			posn: (WordAt mPts 2) (WordAt mPts 3)
			setPri: (WordAt mPts 4)
			setCycle: Walk
		)
	)

	(method (startMove)
		(self
			setCycle: Walk
			setMotion:
				FishMover
				(WordAt mPts (= ptsPtr 5))
				(WordAt mPts (+ ptsPtr 1))
				self
		)
	)

	(method (cue &tmp temp0)
		(if (!= (= temp0 (WordAt mPts (+= ptsPtr 2))) 8192)
			(if (== temp0 4096)
				(self setPri: (WordAt mPts (+ ptsPtr 1)))
				(= temp0 (WordAt mPts (+= ptsPtr 2)))
			)
			(if (== temp0 -32768)
				(= pathContinue 0)
			)
			(if (not (OneOf temp0 16384 -32768))
				(self
					setMotion:
						FishMover
						(WordAt mPts ptsPtr)
						(WordAt mPts (+ ptsPtr 1))
						self
				)
			else
				(if (not pathContinue)
					(self setupFish:)
				)
				(self startMove:)
			)
		else
			(= seconds
				(if (!= (= temp0 (WordAt mPts (+ ptsPtr 1))) -1)
					temp0
				else
					(Random 1 5)
				)
			)
			(self setCycle: Fwd)
		)
	)

	(method (doVerb theVerb invItem &tmp [temp0 500] temp500)
		(= temp500 global251)
		(= global251 1)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 (Random 1 8) 0 50)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 1 0 0 (Random 9 12) 0 50)
					)
					(13 ; sharpShell
						(Narrator init: 1 0 0 (Random 13 16) 0 50)
					)
					(17 ; spine
						(Narrator init: 1 0 0 (Random 17 20) 0 50)
					)
					(30 ; hackSaw
						(Narrator init: 1 0 0 (Random 20 24) 0 50)
					)
					(21 ; healingPotion
						(Narrator init: 1 0 0 (Random 25 28) 0 50)
					)
					(29 ; fishLure
						(Narrator init: 1 0 0 (Random 29 32) 0 50)
					)
					(else
						(Narrator init: 1 0 0 (Random 37 41) 0 50)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 (Random 33 36) 0 50)
			)
			(2 ; Look
				(if (and (OneOf gCurRoomNum 440 480) (Random 0 1))
					(Narrator init: 1 0 0 (+ 70 (Random 0 1)))
				else
					(Narrator
						init: 1 0 0 [local0 (+ (- view 51) fishNumber 1)] 0 50
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(= global251 temp500)
	)
)

(class FishMover of MoveTo
	(properties)

	(method (init)
		(super init: &rest)
		(client setLoop: (+ (* (client fishNumber:) 2) (< x (client x:))))
	)
)

