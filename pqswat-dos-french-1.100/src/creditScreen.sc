;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use Plane)
(use Str)
(use Array)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	creditScreen 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 2601
	local8
)

(procedure (localproc_0)
	(if (< local7 2641)
		(if (not (view1 inUse:))
			(++ local7)
			(view1 view: local7)
		)
		(if (not (view2 inUse:))
			(++ local7)
			(view2 view: local7)
		)
	else
		(if (not (view1 inUse:))
			(= local7 (Random 2601 2641))
			(view1 view: local7)
		)
		(if (not (view2 inUse:))
			(= local7 (Random 2601 2641))
			(view2 view: local7)
		)
	)
)

(class CreditScreen of Plane
	(properties
		picture 26
		script 0
		scroll 0
		creditCast 0
		centerLine 320
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local6 (= local0 (= local1 (= local2 (= local3 (= local4 0))))))
		(Load rsVIEW 2601 2602)
		(Lock rsAUDIO 1500 0)
		(if global112
			((ScriptID 71 0) pausePath: 1) ; crisisRegion
		)
		(if gAutoRobot
			(Robot 10) ; Pause
		)
		(= temp0 (= temp2 0))
		(User canInput: 1)
		(self
			setRect: 0 0 640 459
			back: 0
			picture: (proc4_16 27 27 26 26 26)
			priority: (+ (GetHighPlanePri) 1)
			posn: 0 0
		)
		(super init:)
		(self addCast: ((= creditCast (Cast new:)) plane: self yourself:))
		((= local5
				(IntArray
					with:
						14
						13
						2
						10
						6
						12
						3
						5
						28
						7
						18
						20
						21
						22
						25
						15
						8
						31
						32
						19
						23
						29
						26
						24
						27
						1
						30
				)
			)
			name: {myCase}
		)
		(= local4 (local5 size:))
		(while (< temp2 (local5 size:))
			(= temp1 (Str newWith: 25))
			(if (Message msgGET 40 0 0 (local5 at: temp2) (++ temp0) (temp1 data:))
				(listOStrings add: temp1)
			else
				(listOStrings add: (Str with: {}))
				(temp1 dispose:)
				(++ temp2)
				(= temp0 0)
			)
		)
		(local5 dispose:)
		(swatButn init: (creditScreen creditCast:) setActive: 1)
		(view1
			view: 2601
			init: (creditScreen creditCast:)
			inUse: 1
			setScript: sChangeViews
		)
		(self drawPic: picture 0)
		(self setScript: sCredits self)
		(= local8 (gBackMusic number:))
		(Lock rsAUDIO local8 0)
		(gBackMusic number: 2600 flags: 1 loop: -1 play:)
		(self doit:)
	)

	(method (doit &tmp temp0)
		(for
			((= temp0 ((gUser curEvent:) new:)))
			script
			((= temp0 ((gUser curEvent:) new:)))
			
			(= gGameTime (+ gTickOffset (GetTime)))
			(if (and (& (temp0 type:) $0004) (== (temp0 message:) 32))
				(self setScript: 0)
				(break)
			)
			(if (and casts (& (temp0 type:) $0001))
				(casts firstTrue: #handleEvent temp0)
			)
			(gSounds eachElementDo: #check)
			(if casts
				(casts doit:)
			)
			(if script
				(script doit:)
			)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(FrameOut)
		)
		(self dispose:)
	)

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script dispose:)
		)
	)

	(method (dispose)
		(gBackMusic fade: 0 2 21 1 handle: 0)
		(swatButn dispose:)
		(= local0 (= local1 (= local2 (= local3 (= local4 0)))))
		(gSwatInterface hideCursor: 0)
		(gGame handsOn:)
		(Lock rsAUDIO local8 1)
		(gBackMusic number: local8 loop: -1 play:)
		(super dispose: &rest)
		(if gAutoRobot
			(Robot 4) ; Play
		)
		(if global112
			((ScriptID 71 0) pausePath: 0) ; crisisRegion
		)
	)
)

(instance creditScreen of CreditScreen
	(properties
		scroll 1
		centerLine 480
	)
)

(instance listOStrings of List
	(properties)
)

(instance textActor of Actor
	(properties
		priority 255
		illegalBits 0
		moveSpeed 2
	)

	(method (init)
		(super init: &rest)
		(if (creditScreen scroll:)
			(= y (creditScreen bottom:))
			(UpdateScreenItem self)
			(self setMotion: MoveTo x (* (+ nsBottom 2) -1))
		)
		(++ local1)
	)

	(method (doit)
		(super doit:)
		(if (and (not scratch) (< (+ nsBottom y) 300))
			(= scratch 1)
			(self cue:)
		)
		(if (< (+ nsBottom y) 55)
			(self dispose:)
		)
	)

	(method (cue)
		(sCredits cue:)
	)

	(method (setHeading))

	(method (dispose)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(super dispose:)
	)
)

(instance sCredits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self dispose:)
			(return 1)
		)
		(return 0)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(listOStrings dispose:)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(= state newState)
		(if (< state local4)
			(if (>= ((= register (listOStrings at: local1)) size:) 2)
				(register perform: scrollUpCode)
				(if (not (creditScreen scroll:))
					(= seconds 3)
				)
			else
				(= ticks 1)
			)
			(++ local1)
		else
			(self dispose:)
		)
	)
)

(instance sChangeViews of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(view2 view: 2602)
				(= local7 2602)
				(= ticks 300)
			)
			(1
				(view1 hide: inUse: 0)
				(= cycles 1)
			)
			(2
				(view2 init: (creditScreen creditCast:) inUse: 1)
				(localproc_0)
				(= ticks 300)
			)
			(3
				(view2 hide: inUse: 0)
				(= cycles 1)
			)
			(4
				(view1 show: inUse: 1)
				(localproc_0)
				(= ticks 300)
			)
			(5
				(view1 hide: inUse: 0)
				(= cycles 1)
			)
			(6
				(view2 show: inUse: 1)
				(localproc_0)
				(= ticks 300)
			)
			(7
				(self changeState: 3)
			)
		)
	)
)

(instance scrollUpCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (>= local1 (listOStrings size:))
			(listOStrings dispose:)
		else
			((= local0 (IntArray newWith: 4)) name: {textBox})
			(Text 0 (local0 data:) (param1 data:) 2510 0 0)
			(++ local6)
			(= temp0
				(Bitmap
					0 ; Create
					(+ 1 (- (local0 at: 2) (local0 at: 0)))
					(+ 1 (- (local0 at: 3) (local0 at: 1)))
					10
					0
					gScreenWidth
					gScreenHeight
				)
			)
			(if (OneOf local6 17 18 19)
				(Bitmap
					4 ; AddText
					temp0
					(param1 data:)
					(local0 at: 0)
					(local0 at: 1)
					(local0 at: 2)
					(+ 1 (- (local0 at: 3) (local0 at: 1)))
					28
					0
					10
					2510
					0
					10
					0
				)
			else
				(Bitmap
					4 ; AddText
					temp0
					(param1 data:)
					(local0 at: 0)
					(local0 at: 1)
					(local0 at: 2)
					(+ 1 (- (local0 at: 3) (local0 at: 1)))
					28
					0
					10
					2510
					1
					10
					0
				)
			)
			(= local3 (textActor new:))
			(local3
				x:
					(-
						(creditScreen centerLine:)
						(/ (+ 1 (- (local0 at: 2) (local0 at: 0))) 2)
					)
			)
			(if (not (creditScreen scroll:))
				(local3
					y:
						(-
							(/ (- (creditScreen bottom:) (creditScreen top:)) 2)
							(/ (+ 1 (- (local0 at: 3) (local0 at: 1))) 2)
						)
				)
			)
			(= local2 0)
			(local3
				signal: (& (local3 signal:) $f7df)
				ignoreActors: 1
				ignoreHorizon: 1
				fixPriority: 1
				bitmap: temp0
				setLooper: 0
				nsBottom:
					(+
						(local3 y:)
						(local0 at: 1)
						1
						(- (local0 at: 3) (local0 at: 1))
					)
				init: (creditScreen creditCast:)
			)
			(local0 dispose:)
		)
	)
)

(class SwatView of Prop
	(properties
		inUse 0
	)
)

(instance view1 of SwatView
	(properties
		x 69
		y 102
		view 2601
	)
)

(instance view2 of SwatView
	(properties
		x 69
		y 102
		view 2602
	)
)

(instance swatButn of Button
	(properties
		x 152
		y 293
		view 12
	)

	(method (init)
		(super init: &rest)
		(self setPri: 400)
	)

	(method (doVerb)
		(if (not (view2 script:))
			(view2 setScript: sChangeViewsII)
		)
	)
)

(instance sChangeViewsII of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (view1 inUse:))
						(view2 hide:)
					)
					((not (view2 inUse:))
						(view1 hide:)
					)
				)
				(= cycles 2)
			)
			(1
				(cond
					((not (view1 inUse:))
						(view2 inUse: 0)
						(view1 show: inUse: 1)
						(localproc_0)
					)
					((not (view2 inUse:))
						(view1 inUse: 0)
						(view2 show: inUse: 1)
						(localproc_0)
					)
				)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

