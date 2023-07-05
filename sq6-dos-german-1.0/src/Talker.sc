;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64928)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use Sync)
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
					(= cycleCnt gGameTime)
				)
			)
			((!= (= newCel (self nextCel:)) (client cel:))
				(if (> newCel clientLastCel)
					(self cycleDone:)
				else
					(client cel: newCel)
				)
			)
		)
	)

	(method (cycleDone)
		(client cel: 0)
		(= waitCount (+ (proc0_8 waitMin waitMax) gGameTime))
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
		modeless 2
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
		strHandle 0
		curText 0
	)

	(method (init)
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
						(dialog handleEvent: event)
					)
					(event claimed: 1)
					(self dispose: disposeWhenDone)
				)
			)
		)
	)

	(method (say theBuf whoCares theMod theNoun theVerb theCase theSeq)
		(if (not initialized)
			(self init:)
		)
		(= caller (if (and (> argc 1) whoCares) whoCares else 0))
		(if (& gMsgType $0001)
			(self startText: theBuf)
		)
		(if (& gMsgType $0002)
			(self startAudio: theMod theNoun theVerb theCase theSeq)
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
		(= thePrint (Print new:))
		(thePrint x: 7 y: 192 font: gUserFont back: 0 modeless: 2 init:)
		(if gTextScroller
			(= strHandle (Str format: {%s\n\n} theBuf))
			(= curText (gTextScroller addString: (strHandle data:) gUserFont 82 0))
		)
		(gPrints delete: thePrint)
		(= dialog (thePrint dialog:))
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= audModNum param1)
		(= audNoun param2)
		(= audVerb param3)
		(= audCase param4)
		(= audSequence param5)
		(= ticks (DoAudio audPLAY param1 param2 param3 param4 audSequence 1 130))
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
		(if curText
			(gTextScroller addString: {} gUserFont 82 0)
			(strHandle dispose:)
			(= curText 0)
		)
		(= ticks -1)
		(if (or (not argc) dWD)
			(= modNum -1)
			(= initialized 0)
			(gTalkers delete: self)
		)
		(if dialog
			(dialog dispose:)
			(= dialog 0)
		)
		(if (& gMsgType $0002)
			(DoAudio audSTOP audModNum audNoun audVerb audCase audSequence)
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
		framePri 197
		bustPri 198
		eyePri 199
		mouthPri 200
		view 0
		loop 0
		cel 0
		priority 199
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
		(mouth init: setPri: mouthPri)
		(if bust
			(bust init: setPri: bustPri)
		)
		(if eyes
			(eyes init: setPri: eyePri)
		)
		(if frame
			(frame init: setPri: framePri)
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
			(thePrint x: 7 y: 192 font: gUserFont back: 0 modeless: 2 init:)
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
			(thePrint x: 7 y: 192 font: gUserFont back: 0 modeless: 2 init:)
		)
		(if gTextScroller
			(= strHandle (Str format: {%s\n} (self name:)))
			(gTextScroller addString: (strHandle data:) 50 84 0)
			(strHandle dispose:)
			(= strHandle (Str format: {%s\n\n} theBuf))
			(= curText (gTextScroller addString: (strHandle data:) gUserFont 82 0 0))
		)
		(gPrints delete: thePrint)
		(= dialog (thePrint dialog:))
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= audModNum param1)
		(= audNoun param2)
		(= audVerb param3)
		(= audCase param4)
		(= audSequence param5)
		(super startAudio: param1 param2 param3 param4 audSequence)
		(if mouth
			(mouth setCycle: MouthSync param1 param2 param3 param4 param5)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (dispose dWD)
		(if curText
			(gTextScroller addString: {} 50 84 0)
			(gTextScroller addString: {} gUserFont 82 0)
			(strHandle dispose:)
			(= curText 0)
		)
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

