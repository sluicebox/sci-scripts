;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	endRoom 0
)

(local
	local0
	local1
	local2 = 100
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(if (> argc 2)
		(= temp0 param3)
	else
		(= temp0 2)
	)
	(if (!= local2 100)
		(for ((= local2 0)) (< local2 100) ((+= local2 temp0))
			(Palette 2 param1 param2 local2) ; PalIntensity
			(FrameOut)
		)
		(Palette 2 param1 param2 100) ; PalIntensity
		(FrameOut)
		(= local2 100)
	)
)

(instance endRoom of ScaryRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(global114 stop: 1)
		(Sounds eachElementDo: #stop)
		(SetFlag 121)
		(= temp0 (= temp1 0))
		(User canInput: 1)
		(super init:)
		((ScriptID 0 11) priority: (- ((gCurRoom plane:) priority:) 1)) ; overlayPlane
		(UpdatePlane (ScriptID 0 11)) ; overlayPlane
		((= temp3 (IntArray with: 9 10 6 12 4 5 7)) name: {theCase})
		(while (< temp1 (temp3 size:))
			(= temp2 (Str newWith: 25))
			(if (Message msgGET 92 1 0 (temp3 at: temp1) (++ temp0) (temp2 data:))
				(listOStrings add: temp2)
			else
				(++ temp1)
				(= temp0 0)
			)
		)
		(temp3 dispose:)
		(DoAudio audPLAY 92 0 0 0 1)
		(= local6 0)
		(self setScript: sCredits)
	)

	(method (doit)
		(if (== (DoAudio audPOSITION 92 0 0 0 1) -1)
			(= local6 0)
			(DoAudio audPLAY 92 0 0 0 1)
		)
		(super doit: &rest)
	)
)

(instance credSound of Sound
	(properties
		number 92
	)
)

(instance sCredits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			(
				(and
					(or (& (event type:) evKEYBOARD) (& (event type:) evMOUSEBUTTON))
					(!= state 3)
				)
				(listOStrings dispose:)
				(self changeState: 6)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (listOStrings at: local1))
				(register perform: scrollUpCode)
				(= ticks 325)
				(++ local1)
			)
			(1
				(if (< local1 (listOStrings size:))
					(= state (- start 1))
				)
				(= cycles 1)
			)
			(2
				(= ticks 650)
				(listOStrings dispose:)
				(= cycles 1)
			)
			(3
				(if local5
					(local5 dispose:)
					(= local5 0)
				)
				(= cycles 2)
			)
			(4
				(= cycles 5)
			)
			(5
				(if (credSound handle:)
					(-- state)
				)
				(= cycles 5)
			)
			(6
				(if (credSound handle:)
					(credSound stop:)
				)
				(DoAudio audSTOP 92 0 0 0 1)
				(localproc_0 24 25 5)
				(gCurRoom newRoom: 91) ; saveRest
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
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(if (>= local1 (listOStrings size:))
			(listOStrings dispose:)
		else
			((= local0 (IntArray newWith: 4)) name: {textBox})
			(Text 0 (local0 data:) (param1 data:) gUserFont 0) ; TextSize
			(= temp0
				(Bitmap
					0 ; Create
					(+ 6 (* 2 (- (local0 at: 2) (local0 at: 0))))
					(+ 6 (/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5))
					0
					0
					630
					450
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
				24
				0
				10
				gUserFont
				1
				0
				0
			)
			(= local5 (textActor new:))
			(local5 x: (- 144 (/ (- (local0 at: 2) (local0 at: 0)) 2)))
			(local5 y: (- 68 (/ (- (local0 at: 3) (local0 at: 1)) 2)))
			(= local3 0)
			(local5
				signal: (& (local5 signal:) $f7df)
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
			(if local4
				(mover b-moveCnt: (local4 b-moveCnt:))
			)
			(= local4 mover)
		else
			(self dispose:)
		)
	)

	(method (setHeading))
)

