;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
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
	local2 = 100
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0) ; UNUSED
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

(instance endRoom of GK2Room
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(gGame handsOff:)
		(proc11_12)
		(= temp0 (= temp1 0))
		(User canInput: 1)
		(super init:)
		(gInterfacePlane addToDoits: (ScriptID 0 9) 0) ; logo
		(gInterfacePlane addToEvents: (ScriptID 0 9) 0) ; logo
		(gGame disableInventory: 1)
		((ScriptID 0 9) dispose:) ; logo
		((ScriptID 0 7) active: 0) ; movieButton
		((ScriptID 0 5) active: 0) ; recButton
		(exitButton init:)
		(gThePlane
			setRect: 0 0 gLastScreenX gLastScreenY
			priority: (+ (GetHighPlanePri) 1)
		)
		((= temp3 (IntArray with: 10 6 12 7 4 5 2 3)) name: {theCase})
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
		(UpdatePlane gThePlane)
		(proc11_13)
		(self setScript: sCredits)
		(sCredits setScript: sCreditMusic)
	)
)

(instance exitButton of View
	(properties
		x 8
		y 440
		priority 9000
		fixPriority 1
		view 140
		loop 11
	)

	(method (doVerb)
		(= gQuit 1)
	)
)

(instance credSound of Sound
	(properties
		number 92
	)
)

(instance sCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (listOStrings at: local1))
				(register perform: scrollUpCode)
				(= ticks 300)
				(++ local1)
			)
			(1
				(local5
					setMotion:
						MoveTo
						(local5 x:)
						(-
							(local5 nsTop:)
							(- (local5 nsBottom:) (local5 nsTop:))
						)
						self
				)
			)
			(2
				(if (< local1 (listOStrings size:))
					(= state (- start 1))
				)
				(= cycles 1)
			)
			(3
				(= gQuit 1)
			)
		)
	)
)

(instance sCreditMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(credSound number: 92 loop: 0 play: self)
			)
			(1
				(credSound number: 95 loop: -1 play:)
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
			(Text 0 (local0 data:) (param1 data:) gUserFont 0)
			(= temp0
				(Bitmap
					0 ; Create
					(+ 6 (* 2 (- (local0 at: 2) (local0 at: 0))))
					(+ 6 (/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5))
					0
					255
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
				15
				0
				255
				gUserFont
				1
				0
				0
			)
			(= local5 (textActor new:))
			(local5
				x: (- 320 (- (local0 at: 2) (local0 at: 0)))
				y: (- 300 (- (local0 at: 3) (local0 at: 1)))
			)
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
		priority 455
		yStep 3
		illegalBits 0
		moveSpeed 0
	)

	(method (dispose)
		(Bitmap 1 bitmap) ; Dispose
		(super dispose:)
	)

	(method (setHeading))
)

