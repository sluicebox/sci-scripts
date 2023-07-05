;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use Main)
(use SQRoom)
(use Styler)
(use Str)
(use Array)
(use Motion)
(use Actor)
(use System)

(public
	endCredits 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(cond
		((< gHowFast 3)
			(= temp3 18000)
		)
		((< gHowFast 4)
			(= temp3 12000)
		)
		((< gHowFast 5)
			(= temp3 7500)
		)
		((< gHowFast 6)
			(= temp3 4500)
		)
		(else
			(= temp3 3000)
		)
	)
	(if (or (== argc 0) (== param1 0))
		(= param1 1)
	)
	(for ((= temp0 100)) (> temp0 0) ((-= temp0 param1))
		(Palette 2 0 220 temp0) ; PalIntensity
		(Palette 2 222 256 temp0) ; PalIntensity
		(= gGameTime (+ gTickOffset (GetTime)))
		(gCast doit:)
		(FrameOut)
		(for ((= temp2 0)) (< temp2 temp3) ((++ temp2))
		)
	)
	(Palette 2 0 220 0) ; PalIntensity
	(Palette 2 222 256 0) ; PalIntensity
	(FrameOut)
	(if (and (== argc 2) param2)
		(param2 cue:)
	)
)

(instance endCredits of SQRoom
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 0))
		(gGame setCursor: gWaitCursor)
		(gUser canControl: 0 canInput: 0)
		(super init: &rest)
		((= temp3 (IntArray with: 1)) name: {theCase})
		(while (< temp1 (temp3 size:))
			(= temp2 (Str newWith: 25))
			(if (Message msgGET 100 1 0 (temp3 at: temp1) (++ temp0) (temp2 data:))
				(listOStrings add: temp2)
			else
				(listOStrings add: (Str with: {}))
				(temp2 dispose:)
				(++ temp1)
				(= temp0 0)
			)
		)
		(temp3 dispose:)
		(gTheIconBar hide: 1 disable:)
		(self setScript: doCredits)
	)

	(method (doVerb)
		(return 1)
	)
)

(instance doCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(Palette 2 0 256 100) ; PalIntensity
				(= cycles 2)
			)
			(1
				(if (<= gHowFast 3)
					(PlayVMD 0 {540.vmd}) ; Open
					(PlayVMD 1 0 0 64) ; Put
				else
					(PlayVMD 0 {1540.vmd}) ; Open
					(PlayVMD 1 109 57 64) ; Put
				)
				(PlayVMD 14 1) ; WaitEvent
				(= cycles 2)
			)
			(2
				(proc0_7 1 0 self 1)
			)
			(3
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(4
				(Palette 2 0 256 100) ; PalIntensity
				(gCurRoom drawPic: 546 14)
				(gGSound1 number: 150 loop: -1 setVol: 50 play:)
				(gTheCursor hide:)
				((gCurRoom plane:) setRect: 0 0 320 200)
				(UpdatePlane (gCurRoom plane:))
				(PalCycle 0 112 143 -1 3) ; Start
				(PalCycle 0 144 159 -1 4) ; Start
				(= cycles 1)
			)
			(5
				(gMessager sayRange: 0 0 2 1 2 self 950) ; "As Roger and Stellar warp off into the nebulaset, many questions remain. Will Roger and Stellar become an item? How will Beatrice Wankmeister react when she hears about this new friend in Roger's life?"
			)
			(6
				(if (>= ((= register (listOStrings at: local1)) size:) 2)
					(register perform: scrollUpCode)
					(-- state)
					(cond
						((== local1 23)
							(gMessager say: 0 0 8 0 0 950) ; "credits"
							(= seconds 12)
						)
						((== local1 26)
							(= seconds 12)
						)
						((== local1 27)
							(= seconds 12)
						)
						((== local1 31)
							(= seconds 6)
						)
						((== local1 0)
							(gMessager say: 0 0 4 0 0 950) ; "I've been up to my lips in urinal pucks lately. I hope it's something different."
							(= seconds 12)
						)
						((== local1 16)
							(gMessager say: 0 0 9 0 0 950) ; "credits"
							(= seconds 12)
						)
						((== local1 2)
							(gMessager say: 0 0 3 0 0 100) ; "Who wrote this crap? Oh yeah, Scott. Yeah, well, yeah, then good work."
							(= seconds 6)
						)
						((== local1 11)
							(gMessager say: 0 0 4 0 0 100) ; "Did you hear about the animator who killed himself? Yeah, he couldn't draw his own breath."
							(= seconds 6)
						)
						(else
							(= seconds 6)
						)
					)
				else
					(= ticks 1)
				)
				(= global178 (++ local1))
			)
			(7
				(listOStrings dispose:)
				(local4 dispose:)
				(gMessager say: 0 0 5 0 self 950) ; "buh bye 1"
			)
			(8
				(gMessager say: 0 0 6 0 self 950) ; "farewell"
			)
			(9
				(Styler divisions: 10)
				(gMessager say: 0 0 7 0 self 950) ; "bye 3"
			)
			(10
				(gGSound1 fade:)
				(gCurRoom drawPic: -1 2)
				(= ticks 90)
			)
			(11
				(gMessager say: 0 0 2 3 self 950) ; "Thank you for playing Space Quest 6. This is Gary Owens signing off."
			)
			(12
				(= cycles 3)
			)
			(13
				(= gQuit 1)
			)
		)
	)
)

(instance fadeDaPic of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 600)
			)
			(1
				(localproc_0 1 self)
			)
			(2
				(self dispose:)
			)
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
			(Text 0 (local0 data:) (param1 data:) 70 0)
			(= temp0
				(Bitmap
					0 ; Create
					(* 4 (- (local0 at: 2) (local0 at: 0)))
					(/ (* (- (local0 at: 3) (local0 at: 1)) 12) 5)
					10
					10
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
				206
				10
				10
				70
				1
				10
				0
			)
			(= local4 (textActor new:))
			(local4 x: (- 160 (/ (- (local0 at: 2) (local0 at: 0)) 2)))
			(local4 y: (- 92 (/ (- (local0 at: 3) (local0 at: 1)) 2)))
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

