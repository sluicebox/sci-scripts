;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Print)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(class Blink of Cycle
	(properties
		waitCount 0
		lastCount 0
		waitMin 0
		waitMax 0
	)

	(method (init obj theTime)
		(if argc
			(= waitMin (/ theTime 2))
			(= waitMax (+ theTime waitMin))
			(super init: obj)
		else
			(super init:)
		)
	)

	(method (doit &tmp newCel)
		(cond
			(waitCount
				(if (> (- gGameTime waitCount) 0)
					(= waitCount 0)
					(self init:)
				)
			)
			((or (> (= newCel (self nextCel:)) (client lastCel:)) (< newCel 0))
				(= cycleDir (- cycleDir))
				(self cycleDone:)
			)
			(else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(if (== cycleDir -1)
			(self init:)
		else
			(= waitCount (+ (Random waitMin waitMax) gGameTime))
		)
	)
)

(class Narrator of Obj
	(properties
		x -1
		y -1
		caller 0
		modNum -1
		disposeWhenDone 1
		ticks 0
		talkWidth 0
		keepWindow 0
		modeless 0
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		color 0
		back 7
		freezeCast 0
		curVolume 0
		saveCursor 0
	)

	(method (init)
		(if global83
			(self curVolume: (gGame masterVolume:))
			(if (>= (gGame masterVolume:) 4)
				(gGame masterVolume: (- curVolume 4))
			)
			(if (not modeless)
				(= saveCursor (gGame setCursor: gWaitCursor 1))
			)
		)
		(= initialized 1)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gTheDoits addToFront: self)
		(if freezeCast
			(= freezeCast gCast)
			(= gCast castOfOne)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:))
			((== ticks -1)
				(return 0)
			)
			(else
				(= temp0 (event type:))
				(if (not cueVal)
					(cond
						((& temp0 evJOYDOWN)
							(= cueVal 0)
						)
						((& temp0 evMOUSEBUTTON)
							(= cueVal (& (event modifiers:) emSHIFT))
						)
						((& temp0 evVERB)
							(= cueVal (& (event modifiers:) emSHIFT))
							(event type: evMOUSEBUTTON message: JOY_NULL modifiers: $0000)
						)
						((& temp0 evKEYBOARD)
							(= cueVal (== (event message:) KEY_ESCAPE))
						)
					)
				)
				(if
					(and
						(or
							(& temp0 $4101) ; evVERB | evJOYDOWN | evMOUSEBUTTON
							(and
								(& temp0 evKEYBOARD)
								(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
							)
						)
						(gModelessDialog handleEvent: event)
					)
					(event claimed: 1)
					(self dispose: disposeWhenDone)
				)
			)
		)
	)

	(method (say param1 param2 param3 param4 param5 param6 param7)
		(if (not initialized)
			(self init:)
		)
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& gMsgType $0001)
			(self startText: param1)
		)
		(if (& gMsgType $0002)
			(self startAudio: param3 param4 param5 param6 param7)
		)
		(+= ticks (+ 60 gGameTime))
		(return 1)
	)

	(method (startText theBuf &tmp strLength)
		(if (not (& gMsgType $0002))
			(= ticks (Max 120 (* gTextSpeed 2 (= strLength (StrLen theBuf)))))
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self display: theBuf)
		(return strLength)
	)

	(method (display theBuf &tmp temp0 temp1 temp2)
		(if (> (+ x talkWidth) 318)
			(= temp0 (- 318 x))
		else
			(= temp0 talkWidth)
		)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(= temp2 (Print new:))
		(if showTitle
			(temp2 addTitle: name)
		)
		(temp2
			window: temp1
			posn: x y
			font: font
			width: temp0
			addText: theBuf
			modeless: 1
			init:
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= ticks (DoAudio audPLAY param1 param2 param3 param4 param5))
	)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if global83
					(== (DoAudio audPOSITION) -1)
				else
					1
				)
				(not keepWindow)
			)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(return 1)
	)

	(method (dispose dWD)
		(= ticks -1)
		(if (or (not argc) dWD)
			(if global83
				(DoAudio audSTOP)
			)
			(= modNum -1)
			(= initialized 0)
			(gMouseDownHandler delete: self)
			(gKeyDownHandler delete: self)
			(gTheDoits delete: self)
			(if (IsObject freezeCast)
				(gCast dispose:)
				(= gCast freezeCast)
				(= freezeCast 1)
			)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if global83
			(gGame masterVolume: curVolume)
		)
		(if caller
			(if (not gSet)
				(= gSet (Set new:))
			)
			(gSet
				add:
					((Cue new:)
						cuee: caller
						cuer: self
						register: cueVal
						yourself:
					)
			)
		)
		(= cueVal 0)
		(if (or (not argc) dWD)
			(super dispose:)
		)
	)
)

(class Talker of Narrator
	(properties
		talkWidth 318
		frame 0
		bust 0
		eyes 0
		mouth 0
		view 0
		loop 0
		cel 0
		priority 15
		viewInPrint 0
		textX 0
		textY 0
		blinkSpeed 100
	)

	(method (init param1 param2 param3 param4)
		(if argc
			(= mouth param1)
			(if (> argc 1)
				(= bust param2)
				(if (> argc 2)
					(= eyes param3)
					(if (> argc 3)
						(= frame param4)
					)
				)
			)
		)
		(super init:)
		(if (not mouth)
			(= mouth
				((TalkerMouth new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					yourself:
				)
			)
		)
		(mouth init: setPri: priority)
		(if bust
			(bust setPri: priority init:)
		)
		(if eyes
			(eyes setPri: priority init:)
		)
		(if frame
			(frame setPri: priority init:)
		)
		(Animate (gCast elements:) 0)
	)

	(method (startText &tmp theLen)
		(= theLen (super startText: &rest))
		(if mouth
			(mouth setCycle: RandCycle (* 3 theLen) 0 1)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (display theBuf &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		((= temp3 (gSystemWindow new:)) color: color back: back)
		(= temp4
			(cond
				(frame frame)
				(bust bust)
				(else mouth)
			)
		)
		(= temp5 (Print new:))
		(if viewInPrint
			(= temp0 (temp4 loop:))
			(if showTitle
				(temp5 addTitle: name)
			)
			(temp5
				window: temp3
				posn: x y
				modeless: 1
				font: font
				addText: theBuf
				addIcon: view temp0 cel 0 0
				init:
			)
		else
			(if (not (+ textX textY))
				(= textX
					(+ (CelWide (temp4 view:) (temp4 loop:) (temp4 cel:)) 5)
				)
			)
			(if (> (+ (= temp2 (+ (temp4 nsLeft:) textX)) talkWidth) 318)
				(= temp1 (- 318 temp2))
			else
				(= temp1 talkWidth)
			)
			(if showTitle
				(temp5 addTitle: name)
			)
			(temp5
				window: temp3
				posn: (+ (temp4 x:) textX) (+ (temp4 y:) textY)
				modeless: 1
				font: font
				width: temp1
				addText: theBuf
				init:
			)
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(super startAudio: param1 param2 param3 param4 param5)
		(if mouth
			(mouth
				setCycle: Unknown_Class_40 param1 param2 param3 param4 param5
			)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (dispose dWD)
		(if mouth
			(mouth setCycle: 0 setCel: 0)
		)
		(if (or (not argc) dWD)
			(if eyes
				(eyes setCycle: 0 setCel: 0)
			)
			(if mouth
				(mouth dispose: delete:)
				(= mouth 0)
			)
			(if bust
				(bust dispose:)
				(= bust 0)
			)
			(if eyes
				(eyes dispose:)
				(= eyes 0)
			)
			(if frame
				(frame dispose:)
				(= frame 0)
			)
		)
		(super dispose: dWD)
	)
)

(class TalkerMouth of Prop
	(properties)

	(method (init)
		(&= signal $feff)
		(super init:)
	)
)

(instance castOfOne of EventHandler
	(properties)
)

