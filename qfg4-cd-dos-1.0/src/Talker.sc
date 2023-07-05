;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64928)
(include sci.sh)
(use Main)
(use Print)
(use RandCycle)
(use Motion)
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
		modeless 1
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		fore 0
		back 7
		dialog 0
		curVolume 0
		saveCursor 0
		audModNum 0
		audNoun 0
		audVerb 0
		audCase 0
		audSequence 0
	)

	(method (init)
		(if (& gMsgType $0002)
			(= curVolume (gGlory masterVolume:))
			(if (>= curVolume 6)
				(gGlory masterVolume: (- curVolume 6))
			else
				(gGlory masterVolume: 1)
			)
		)
		(= initialized 1)
		(super init:)
		(gTalkers addToFront: self)
	)

	(method (handleEvent event &tmp eType)
		(cond
			((event claimed:))
			((== ticks -1)
				(return 0)
			)
			(else
				(= eType (event type:))
				(if (not cueVal)
					(cond
						((& eType $0020) ; joyUp
							(= cueVal 0)
						)
						((& eType evMOUSEBUTTON)
							(= cueVal (& (event modifiers:) emSHIFT))
						)
						((& eType evVERB)
							(= cueVal (& (event modifiers:) emSHIFT))
							(event type: evMOUSEBUTTON message: JOY_NULL modifiers: $0000)
						)
						((& eType evKEYBOARD)
							(= cueVal (== (event message:) KEY_ESCAPE))
						)
					)
				)
				(if
					(or
						(& eType $4021) ; evVERB | joyUp | evMOUSEBUTTON
						(and
							(& eType evKEYBOARD)
							(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
						)
					)
					(if (& gMsgType $0001)
						(if (dialog handleEvent: event)
							(event claimed: 1)
							(self dispose: disposeWhenDone)
						)
					else
						(event claimed: 1)
						(self dispose: disposeWhenDone)
					)
				)
			)
		)
	)

	(method (say param1 param2 param3)
		(if (not initialized)
			(self init:)
		)
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& gMsgType $0001)
			(self startText: param1)
		)
		(if (& gMsgType $0002)
			(self startAudio: param3)
		)
		(+= ticks (+ 60 gGameTime))
		(return 1)
	)

	(method (startText theBuf &tmp strLength)
		(if (not (& gMsgType $0002))
			(= strLength (theBuf size:))
			(= ticks (Max 120 (* (/ (* 24 strLength) 10) gTextSpeed)))
		)
		(self display: theBuf)
		(return ticks)
	)

	(method (display theBuf &tmp theWidth thePrint)
		(if (> (+ x talkWidth) 318)
			(= theWidth (- 318 x))
		else
			(= theWidth talkWidth)
		)
		(= thePrint (Print new:))
		(if showTitle
			(thePrint addTitle: name)
		)
		(thePrint
			fore: fore
			back: back
			posn: x y
			font: font
			width: theWidth
			addText: theBuf
			modeless: 2
			init:
		)
		(gPrints delete: thePrint)
		(= dialog (thePrint dialog:))
	)

	(method (startAudio theKeys &tmp temp0)
		(= audModNum (theKeys at: 0))
		(= audNoun (theKeys at: 1))
		(= audVerb (theKeys at: 2))
		(= audCase (theKeys at: 3))
		(= audSequence (theKeys at: 4))
		(= ticks (DoAudio audPLAY audModNum audNoun audVerb audCase audSequence))
	)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if (& gMsgType $0002)
					(==
						(DoAudio
							audPOSITION
							audModNum
							audNoun
							audVerb
							audCase
							audSequence
						)
						-1
					)
				else
					1
				)
				(or (!= modeless 0) (& gMsgType $0002))
			)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(return 1)
	)

	(method (dispose dWD)
		(= ticks -1)
		(if (or (not argc) dWD)
			(if (& gMsgType $0002)
				(DoAudio audSTOP audModNum audNoun audVerb audCase audSequence)
			)
			(= modNum -1)
			(= initialized 0)
			(gTalkers delete: self)
		)
		(if dialog
			(dialog dispose:)
			(= dialog 0)
		)
		(if (& gMsgType $0002)
			(gGlory masterVolume: curVolume)
		)
		(if caller
			(caller cue: cueVal)
		)
		(= cueVal 0)
		(if (or (not argc) dWD)
			(super dispose:)
		)
	)

	(method (isModeless checkFor)
		(return
			(if argc
				(== modeless checkFor)
			else
				modeless
			)
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

	(method (init theMouth theBust theEyes theFrame)
		(if argc
			(= mouth theMouth)
			(if (> argc 1)
				(= bust theBust)
				(if (> argc 2)
					(= eyes theEyes)
					(if (> argc 3)
						(= frame theFrame)
					)
				)
			)
		)
		(super init:)
		(if (not mouth)
			(= mouth
				((Prop new:) view: view loop: loop cel: cel x: x y: y yourself:)
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
	)

	(method (startText &tmp theTicks)
		(= theTicks (super startText: &rest))
		(if mouth
			(mouth setCycle: RandCycle (* (/ theTicks 3) 2) 0 1)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (display theBuf &tmp theLoop theWidth textLeft theObj thePrint)
		(= theObj
			(cond
				(frame frame)
				(bust bust)
				(else mouth)
			)
		)
		(= thePrint (Print new:))
		(if viewInPrint
			(= theLoop (theObj loop:))
			(if showTitle
				(thePrint addTitle: name)
			)
			(thePrint
				fore: fore
				back: back
				posn: x y
				modeless: 2
				font: font
				addText: theBuf
				addIcon: view theLoop cel 0 0
				init:
			)
		else
			(if (not (+ textX textY))
				(= textX
					(+ (CelWide (theObj view:) (theObj loop:) (theObj cel:)) 5)
				)
			)
			(if (> (+ (= textLeft (+ (theObj nsLeft:) textX)) talkWidth) 318)
				(= theWidth (- 318 textLeft))
			else
				(= theWidth talkWidth)
			)
			(if showTitle
				(thePrint addTitle: name)
			)
			(thePrint
				fore: fore
				back: back
				posn: (+ (theObj x:) textX) (+ (theObj y:) textY)
				modeless: 2
				font: font
				width: theWidth
				addText: theBuf
				init:
			)
		)
		(gPrints delete: thePrint)
		(= dialog (thePrint dialog:))
	)

	(method (startAudio theKeys &tmp [temp0 5])
		(super startAudio: theKeys)
		(if mouth
			(mouth setCycle: RandCycle ticks 0 1)
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
				(mouth dispose:)
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

