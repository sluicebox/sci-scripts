;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64928)
(include sci.sh)
(use Main)
(use ExitButton)
(use rm4400)
(use Str)
(use Print)
(use Sync)
(use RandCycle)
(use StopWalk)
(use Actor)
(use System)

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
			(= curVolume (gGame masterVolume:))
			(gGame masterVolume: (/ (* curVolume 2) 3))
		)
		(= initialized 1)
		(super init:)
		(DoAudio 12 0) ; AudMixCheck
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
						(and
							(IsFlag 540)
							((ScriptID 16 0) handleEvent: event) ; skipCartoon
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

	(method (say param1 param2)
		(if (not initialized)
			(self init:)
		)
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& gMsgType $0001)
			(self startText: param1)
		)
		(if (& gMsgType $0002)
			(self startAudio: param1)
		)
		(+= ticks (+ 60 gGameTime))
		(return 1)
	)

	(method (startText theBuf &tmp temp0 temp1)
		(if (not (& gMsgType $0002))
			(= temp0 (theBuf size:))
			(= ticks (Max 120 (* (/ (* 24 temp0) 10) gTextSpeed)))
		)
		(if (& gMsgType $0002)
			(= temp1 (Str newWith: 400 {}))
			(Message
				msgGET
				(theBuf at: 0)
				(theBuf at: 1)
				(theBuf at: 2)
				(theBuf at: 3)
				(theBuf at: 4)
				(temp1 data:)
			)
			(self display: temp1)
		else
			(self display: theBuf)
		)
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

	(method (startAudio theKeys)
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
			(gGame masterVolume: curVolume)
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

	(method (startAudio theKeys &tmp m n v c s)
		(super startAudio: theKeys)
		(if mouth
			(= m (theKeys at: 0))
			(= n (theKeys at: 1))
			(= v (theKeys at: 2))
			(= c (theKeys at: 3))
			(= s (theKeys at: 4))
			(mouth setCycle: MouthSync m n v c s)
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

(class KQTalker of Narrator
	(properties
		client 0
		mouth 0
		view -1
		loop -1
		clientCel -2
		mouth_x -999
		mouth_y -999
		hide_mouth 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp3 view)
		(= temp0 mouth_x)
		(= temp1 mouth_y)
		(= temp2 loop)
		(if (== clientCel -1)
			(= clientCel (client lastCel:))
		)
		(if (== temp2 -1)
			(cond
				((== client gEgo)
					(if
						(and
							(== view -1)
							(OneOf
								(client view:)
								2241
								800
								836
								870
								902
								9021
								9022
							)
						)
						(= temp2 (client cel:))
					else
						(= temp2 (+ (client loop:) 20))
					)
				)
				((and (== gCurRoomNum 1500) (== client (ScriptID 1500 1))) ; spirit
					(= temp2 (+ (client cel:) 20))
				)
				(else
					(= temp2 (+ (client loop:) 20))
				)
			)
		)
		(if (== temp3 -1)
			(if
				(and
					(== client gEgo)
					(OneOf (client view:) 2241 800 836 870 902 9021 9022)
				)
				(= temp3 (+ (client view:) 30000))
				(if (not (ResCheck rsVIEW temp3))
					(= temp3 30800)
				)
			else
				(= temp3 (client view:))
			)
		)
		(if (== mouth_x -999)
			(= temp0 (client x:))
		else
			(+= temp0 (client x:))
		)
		(if (== mouth_y -999)
			(= temp1 (client y:))
		else
			(+= temp1 (client y:))
		)
		(= mouth (Prop new:))
		(if
			(or
				(== client gEgo)
				(and (== gCurRoomNum 1500) (== client (ScriptID 1500 1))) ; spirit
			)
			(mouth
				view: temp3
				loop: temp2
				setPri: (+ (client priority:) 1)
				posn: temp0 temp1
				scaleX: (client scaleX:)
				scaleY: (client scaleY:)
				scaleSignal: (client scaleSignal:)
			)
		else
			(if (!= clientCel -2)
				(client setCel: clientCel)
			)
			(mouth
				view: temp3
				loop: temp2
				setPri: (+ (client priority:) 1)
				posn: temp0 temp1
				scaleX: (client scaleX:)
				scaleY: (client scaleY:)
				scaleSignal: (client scaleSignal:)
			)
		)
		(mouth cel: 0 init:)
		(if
			(or
				(& (client signal:) $0008)
				(not (gCast contains: client))
				hide_mouth
				(and
					(client respondsTo: #cycler)
					(client cycler:)
					(not ((client cycler:) isKindOf: StopWalk))
				)
			)
			(mouth hide:)
		)
		(if (!= temp3 30800)
			(Load rsVIEW temp3)
		)
		(super init: &rest)
	)

	(method (startText)
		(super startText: &rest)
		(mouth setCycle: RandCycle ticks 0 1)
	)

	(method (doit)
		(super doit:)
		(if mouth
			(if
				(and
					(not hide_mouth)
					(gCast contains: client)
					(& (mouth signal:) $0008)
					(client respondsTo: #cycler)
					(not (client cycler:))
				)
				(mouth show:)
			)
			(mouth doit:)
		)
	)

	(method (startAudio param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (param1 at: 0))
		(= temp1 (param1 at: 1))
		(= temp2 (param1 at: 2))
		(= temp3 (param1 at: 3))
		(= temp4 (param1 at: 4))
		(super startAudio: param1 &rest)
		(mouth setCycle: MouthSync temp0 temp1 temp2 temp3 temp4)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(mouth dispose:)
			(= mouth 0)
		)
		(super dispose: param1)
	)
)

