;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Str)
(use Array)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	endRoom 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance endRoom of KQRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 0))
		(User canInput: 1)
		(super init:)
		((= temp3 (IntArray with: 9 3 4 6 5 1 2 7 8)) name: {theCase})
		(while (< temp1 (temp3 size:))
			(= temp2 (Str newWith: 25))
			(if (Message msgGET 960 1 0 (temp3 at: temp1) (++ temp0) (temp2 data:))
				(listOStrings add: temp2)
			else
				(listOStrings add: (Str with: {}))
				(temp2 dispose:)
				(++ temp1)
				(= temp0 0)
			)
		)
		(temp3 dispose:)
		(creditSound play:)
		(self setScript: sCredits)
	)
)

(instance sCredits of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 3)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(1
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 3)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(2
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 3)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(3
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 3)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(4
				(= temp0 (Str with: (listOStrings at: local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
				(++ local1)
				(= register 0)
			)
			(5
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
			)
			(6
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
			)
			(7
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
				(++ local1)
			)
			(8
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
			)
			(9
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
			)
			(10
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
			)
			(11
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
				(++ local1)
			)
			(12
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 3)
				(temp0 dispose:)
				(++ local1)
			)
			(13
				(= temp0 (Str with: (listOStrings at: (++ local1))))
				(temp0 cat: (listOStrings at: (++ local1)))
				(temp0 perform: scrollUpCode)
				(= seconds 6)
				(temp0 dispose:)
				(++ local1)
			)
			(14
				(listOStrings dispose:)
				(= gQuit 1)
			)
		)
	)
)

(instance listOStrings of List
	(properties)
)

(instance creditSound of Sound
	(properties
		number 960
	)
)

(instance scrollUpCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if local4
			(local4 dispose:)
			(= local4 0)
		)
		(if (>= local1 (listOStrings size:))
			(listOStrings dispose:)
		else
			((= local0 (IntArray newWith: 4)) name: {textBox})
			(TextSize (local0 data:) (param1 data:) 960 0)
			(= temp0
				(Bitmap
					0 ; Create
					(* 4 (- (local0 at: 2) (local0 at: 0)))
					(/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5)
					10
					0
					640
					480
				)
			)
			(Bitmap
				4 ; AddText
				temp0
				(param1 data:)
				(local0 at: 0)
				(local0 at: 1)
				(+ (local0 at: 0) (* 2 (- (local0 at: 2) (local0 at: 0))))
				(+
					(local0 at: 1)
					(/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5)
				)
				255
				0
				10
				960
				1
				10
				0
			)
			(= local4 (textActor new:))
			(local4 x: (- 160 (/ (- (local0 at: 2) (local0 at: 0)) 2)))
			(local4 y: (- 68 (/ (- (local0 at: 3) (local0 at: 1)) 2)))
			(= local2 0)
			(local4
				signal: (& (local4 signal:) $f7df)
				ignoreActors: 1
				ignoreHorizon: 1
				fixPriority: 1
				bitmap: temp0
				setLooper: 0
				nsBottom: (+ (local0 at: 1) (- (local0 at: 3) (local0 at: 1)))
				init:
			)
			(local0 dispose:)
		)
	)
)

(instance textActor of Actor
	(properties
		x 95
		y 150
		priority 255
		yStep 3
		illegalBits 0
	)

	(method (dispose)
		(Bitmap 1 bitmap) ; Dispose
		(super dispose:)
	)

	(method (cue)
		(if (> y 0)
			(if (< (++ local1) (listOStrings size:))
				((listOStrings at: local1) perform: scrollUpCode)
			else
				(listOStrings dispose:)
			)
			(self setMotion: MoveTo x (- nsBottom) self)
			(if local3
				(mover b-moveCnt: (local3 b-moveCnt:))
			)
			(= local3 mover)
		else
			(self dispose:)
		)
	)

	(method (setHeading))
)

