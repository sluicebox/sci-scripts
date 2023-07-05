;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use SQRoom)
(use Str)
(use Array)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	regCredits 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance regCredits of SQRoom
	(properties
		picture 431
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 0))
		(User canInput: 1)
		(super init:)
		((= temp3 (IntArray with: 8 2 3 5 1 6 4 7 14 10 12 13 11 15 9 16))
			name: {theCase}
		)
		(while (< temp1 (temp3 size:))
			(= temp2 (Str newWith: 25))
			(if (Message msgGET 435 1 0 (temp3 at: temp1) (++ temp0) (temp2 data:))
				(listOStrings add: temp2)
			else
				(listOStrings add: (Str with: {}))
				(temp2 dispose:)
				(++ temp1)
				(= temp0 0)
			)
		)
		(temp3 dispose:)
		(self setScript: sCredits)
	)
)

(instance sCredits of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(= seconds 0)
			(= ticks 1)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(gMessager say: 0 0 5 0 self 98) ; "Thank you for purchasing Space Quest 6. You did purchase it, didn't you? Oh, of course you did. You sure couldn't be like one of those weasels who would make illegal copies. You're too cool for that."
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(1
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(2
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(3
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(4
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(5
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(6
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(7
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(8
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(9
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(10
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(11
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(12
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(13
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(14
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(15
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(= seconds 6)
				else
					(= ticks 1)
				)
				(++ local1)
			)
			(16
				(gMessager say: 0 0 20 0 self 98) ; "I'll kick your ass!"
			)
			(17
				(listOStrings dispose:)
				(local4 dispose:)
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance listOStrings of List
	(properties)
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
			(Text 0 (local0 data:) (param1 data:) 60 0)
			(= temp0
				(Bitmap
					0 ; Create
					(+ 6 (* 2 (- (local0 at: 2) (local0 at: 0))))
					(/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5)
					10
					145
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
				(/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5)
				7
				145
				10
				60
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

