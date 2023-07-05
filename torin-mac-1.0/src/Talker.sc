;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64928)
(include sci.sh)
(use Main)
(use TPSound)
(use TranslucentPlane)
(use DText)
(use Str)
(use Print)
(use Dialog)
(use Sync)
(use Scaler)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	MakeSubTitle 0
	MakeMessageSubTitle 1
)

(procedure (MakeSubTitle theBuf &tmp thePrint)
	(if (oTranslucentDialog bInitialized:)
		(oTranslucentDialog dispose:)
	)
	(if ((ScriptID 64002 10) bButtonDown:) ; oTeleprompter
		(return 0)
	)
	(= thePrint (Print new:))
	(thePrint
		fore: 235
		back: 234
		skip: 234
		posn: -1 -1
		font: 0
		width: 400
		dialog: oTranslucentDialog
		addText: theBuf
		modeless: 2
		plane: (ScriptID 0 1) ; oBackgroundPlane
		init:
	)
	(gPrints delete: thePrint)
	(return (thePrint dialog:))
)

(procedure (MakeMessageSubTitle nMod nNoun nVerb nCase nSeq &tmp theBuf oDialog)
	(if (< argc 5)
		(return 0)
	)
	(= theBuf (Str newWith: 4000 {}))
	(if (not (Message msgGET nMod nNoun nVerb nCase nSeq))
		(return 0)
	)
	(Message msgGET nMod nNoun nVerb nCase nSeq (theBuf data:))
	(= oDialog (MakeSubTitle theBuf))
	(theBuf dispose:)
	(return oDialog)
)

(instance oTextTranslucentPlane of TranslucentPlane
	(properties)
)

(class oTranslucentDialog of Dialog
	(properties
		bInitialized 0
	)

	(method (init)
		(= bInitialized 1)
		(super init: &rest)
	)

	(method (center)
		(super center: &rest)
		(self move: 0 (- 316 nsBottom))
	)

	(method (moveTo)
		(super moveTo: &rest)
		(if (oTextTranslucentPlane oMyFeatures:)
			(oTextTranslucentPlane dispose:)
		)
		(oTextTranslucentPlane
			priority: (+ 1 (GetHighPlanePri))
			init: (plane left:) (plane top:) (plane right:) (plane bottom:)
		)
		(plane setPri: (+ 1 (oTextTranslucentPlane priority:)))
	)

	(method (dispose)
		(if bInitialized
			(= bInitialized 0)
			(oTextTranslucentPlane dispose:)
			(super dispose: &rest)
		)
	)
)

(class TPText of DText
	(properties
		back 234
		borderColor 234
	)
)

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
			(= waitCount (+ (Random 0 waitMax) gGameTime))
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
				(if (or (> newCel clientLastCel) (< newCel 0))
					(= cycleDir (- cycleDir))
					(self cycleDone:)
				else
					(client cel: newCel)
				)
			)
		)
	)

	(method (cycleDone)
		(if (== cycleDir -1)
			(= cycleCnt gGameTime)
		else
			(= waitCount (+ (Random waitMin waitMax) gGameTime))
		)
	)
)

(class Narrator of Obj
	(properties
		x -1
		y -1
		textX -1
		textY -1
		caller 0
		modNum -1
		disposeWhenDone 1
		ticks 0
		talkWidth 400
		modeless 2
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		fore 232
		back 227
		dialog 0
		curVolume 0
		saveCursor 0
		audModNum 0
		audNoun 0
		audVerb 0
		audCase 0
		audSequence 0
		curSFXVolume 0
	)

	(method (kill)
		(= caller 0)
		(self dispose:)
	)

	(method (init)
		(if (& gMsgType $0002)
			(= curVolume gMusicVol)
			(SetMusicVol (MulDiv 35 curVolume 100))
			(= curSFXVolume gSFXVol)
			(SetSFXVol (MulDiv 35 curSFXVolume 100))
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
					(event claimed: 1)
					(self dispose:)
				)
			)
		)
	)

	(method (say theBuf msgkey whoCares)
		(cond
			((not initialized)
				(self init:)
			)
			(dialog
				(dialog dispose:)
				(= dialog 0)
			)
		)
		(= caller (if (and (> argc 1) whoCares) whoCares else 0))
		(if (& gMsgType $0001)
			(self startText: theBuf)
		)
		(if (& gMsgType $0002)
			(self startAudio: msgkey)
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

	(method (display theBuf)
		(if ((ScriptID 64002 10) isButtonDown:) ; oTeleprompter
			(return)
		)
		(= dialog (MakeSubTitle theBuf))
	)

	(method (startAudio theKeys)
		(= audModNum (theKeys at: 0))
		(= audNoun (theKeys at: 1))
		(= audVerb (theKeys at: 2))
		(= audCase (theKeys at: 3))
		(= audSequence (theKeys at: 4))
		(= ticks
			(DoAudio
				audPLAY
				audModNum
				audNoun
				audVerb
				audCase
				audSequence
				1
				gAudioVol
			)
		)
		(if (> ticks 0)
			(= ticks (Max 1 (- ticks 30)))
		)
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
			(SetMusicVol curVolume)
			(SetSFXVol curSFXVolume)
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

(class Mouth of Prop
	(properties
		client 0
	)

	(method (init &tmp oClientScaler)
		(if
			(or
				(not client)
				(not (& (client -info-:) $0010))
				(not (client plane:))
				(not ((client plane:) isEnabled:))
			)
			(return)
		)
		(if (client respondsTo: #stopwalk)
			(client stopwalk:)
		)
		(= loop (client cel:))
		(= x (client x:))
		(= y (client y:))
		(self setPri: (+ 1 (client priority:)))
		(self oldScaleX: 128 scaleX: 128 scaleY: 128 setScale: 0 setScaler: 0)
		(cond
			((= oClientScaler (client scaler:))
				(oClientScaler doit:)
				(self
					setScaler:
						Scaler
						(oClientScaler frontSize:)
						(oClientScaler backSize:)
						(oClientScaler frontY:)
						(oClientScaler backY:)
				)
			)
			((& (client scaleSignal:) $0001)
				(self
					setScale:
					scaleX: (client scaleX:)
					scaleY: (client scaleY:)
				)
			)
		)
		(UpdateScreenItem client)
		(super init: &rest)
	)
)

(class Talker of Narrator
	(properties
		frame 0
		bust 0
		eyes 0
		mouth 0
		view 0
		loop 0
		cel 0
		priority 15
		viewInPrint 0
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
		(if bust
			(bust setPri: priority init:)
		)
		(if eyes
			(eyes setPri: priority init:)
		)
		(if frame
			(frame setPri: priority init:)
		)
		(mouth setPri: priority init:)
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

	(method (startAudio theKeys &tmp m n v c s)
		(if mouth
			(= m (theKeys at: 0))
			(= n (theKeys at: 1))
			(= v (theKeys at: 2))
			(= c (theKeys at: 3))
			(= s (theKeys at: 4))
			(mouth setCycle: MouthSync m n v c s)
		)
		(super startAudio: theKeys)
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

