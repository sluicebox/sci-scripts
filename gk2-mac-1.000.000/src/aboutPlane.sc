;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Print)
(use PanelPlane)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	aboutPlane 0
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

(instance aboutCode of Code ; UNUSED
	(properties)

	(method (doit)
		(Printf
			{Gabriel Knight II: \nThe Beast Within \n\nBy Jane Jensen \n\nversion: %s}
			gVersion
		)
	)
)

(instance aboutPlane of PanelPlane
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= local0 (= local1 0))
		(Sound pause: 1)
		((gUser hotCursor:) showWait:)
		(= global135 0)
		(= local4 ((gUser hotCursor:) hotObjList:))
		((gUser hotCursor:) hotObjList: (List new:))
		(super init: 0 0 gLastScreenX gLastScreenY)
		(= priority (+ (GetHighPlanePri) 1))
		((gUser hotCursor:) update: isHot: 0)
		(self drawPic: -1)
		(exitButton init: self 1 1)
		(gGame disableInventory:)
		((ScriptID 0 9) active: 0) ; logo
		((ScriptID 0 7) active: 0) ; movieButton
		((ScriptID 0 5) active: 0) ; recButton
		(UpdatePlane self)
		(= temp0 (= temp1 0))
		(User canInput: 1)
		((= temp2 (IntArray with: 1 10 6 12 7 4 5 2)) name: {theCase})
		(while (< temp1 (temp2 size:))
			(= local5 (Str newWith: 25))
			(if (Message msgGET 92 1 0 (temp2 at: temp1) (++ temp0) (local5 data:))
				(listOStrings add: local5)
			else
				(++ temp1)
				(= temp0 0)
			)
		)
		(temp2 dispose:)
		(doitList add: (aboutScript init:))
	)

	(method (dispose)
		(listOStrings dispose:)
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(if local0
			(local0 dispose:)
		)
		(if local3
			(local3 dispose:)
			(= local3 0)
		)
		(gGame disableInventory: 0)
		((ScriptID 0 9) active: 1) ; logo
		((ScriptID 0 7) active: 1) ; movieButton
		((ScriptID 0 5) active: 1) ; recButton
		(Sound pause: 0)
		(doitList delete: (aboutScript dispose: yourself:))
		(((gUser hotCursor:) hotObjList:) release: dispose:)
		((gUser hotCursor:) hotObjList: local4)
		((gUser hotCursor:) isHot: 1)
		(= global135 1)
		(super dispose: &rest)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
	)
)

(instance exitButton of PanelButton
	(properties
		x 8
		y 440
		priority 9000
		fixPriority 1
		view 140
		loop 11
		highlit 1
	)

	(method (doVerb)
		(aboutPlane dispose:)
	)
)

(instance aboutScript of Script
	(properties)

	(method (init)
		(= lastTicks gGameTime)
		(= client (= caller (= register 0)))
		(= state (- start 1))
		(self cue:)
		(return self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (listOStrings at: local1))
				(register perform: scrollUpCode)
				(= ticks 250)
				(++ local1)
			)
			(1
				(local3
					setMotion:
						MoveTo
						(local3 x:)
						(-
							(local3 nsTop:)
							(* (- (local3 nsBottom:) (local3 nsTop:)) 2)
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
				(= ticks 500)
				(listOStrings dispose:)
				(= cycles 1)
			)
			(4
				(if local3
					(local3 dispose:)
					(= local3 0)
				)
				(= cycles 2)
			)
			(5
				(= cycles 5)
			)
			(6
				(= cycles 5)
			)
			(7
				(gGame panelObj: aboutPlane)
				(gGame panelSelector: 143)
				(aboutPlane addToDoits: self 0)
				(self dispose:)
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
		(if local3
			(local3 dispose:)
			(= local3 0)
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
			(= local3 (textActor new:))
			(local3
				x: (- 320 (- (local0 at: 2) (local0 at: 0)))
				y: (- 300 (- (local0 at: 3) (local0 at: 1)))
			)
			(local3
				signal: (& (local3 signal:) $f7df)
				ignoreActors: 1
				ignoreHorizon: 1
				fixPriority: 1
				bitmap: temp0
				setLooper: 0
				nsBottom: (+ (local0 at: 1) (- (local0 at: 3) (local0 at: 1)))
				init: aboutPlane 1
			)
			(local0 dispose:)
			(= local0 0)
		)
	)
)

(instance textActor of Actor
	(properties
		x 95
		y 150
		priority 600
		yStep 3
		illegalBits 0
		moveSpeed 0
	)

	(method (init param1 param2 param3)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(|= -info- $0010)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
	)

	(method (dispose)
		(Bitmap 1 bitmap) ; Dispose
		((self plane:) addToDoits: self 0)
		((((self plane:) casts:) at: 0) delete: self)
		(super dispose:)
	)

	(method (setHeading))
)

