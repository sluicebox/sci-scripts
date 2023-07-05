;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64928)
(include sci.sh)
(use Main)
(use TPSound)
(use TranslucentPlane)
(use soFlashCyberSniff)
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
	proc64928_0 0
	proc64928_1 1
	proc64928_2 2
)

(local
	local0 = 320
	local1 = 470
	local2 = 450
	local3
	local4
	local5
)

(procedure (proc64928_2 param1 param2 param3 param4)
	(if (> argc 0)
		(= local0 param1)
	else
		(= local0 320)
	)
	(if (> argc 1)
		(= local1 param2)
	else
		(= local1 470)
	)
	(if (> argc 2)
		(= local2 param3)
	else
		(= local2 450)
	)
	(if (> argc 0)
		(= local3 param4)
	else
		(= local3 0)
	)
)

(procedure (proc64928_0 param1 &tmp temp0 temp1)
	(if (oTranslucentDialog bInitialized:)
		(PrintDebug {Tried to create two subtitles at same time. talker.sc})
		(oTranslucentDialog dispose:)
	)
	(= temp1 (GetTextWidth param1 local3 local2))
	(= temp0 (Print new:))
	(temp0
		fore: 87
		back: 0
		skip: 0
		posn: -1 -1
		font: local3
		width: temp1
		dialog: oTranslucentDialog
		addText: param1
		modeless: 2
		plane: (ScriptID 0 1) ; oBackgroundPlane
		init:
	)
	(gPrints delete: temp0)
	(temp0 dialog:)
)

(procedure (proc64928_1 param1 param2 param3 param4 param5 &tmp temp0 temp1) ; UNUSED
	(if (< argc 5)
		(PrintDebug
			{Passed less than the minimum no. of args to MakeMessageSubTitle}
		)
		(return 0)
	)
	(if (not (Message msgGET param1 param2 param3 param4 param5))
		(PrintDebug
			{MakeMessageSubtitle: No message found m:%hu n:%d v:%d c:%d s:%d}
			param1
			param2
			param3
			param4
			param5
		)
		(return 0)
	)
	(= temp0 (Str newWith: 4000 {}))
	(Message msgGET param1 param2 param3 param4 param5 (temp0 data:))
	(= temp1 (proc64928_0 temp0))
	(temp0 dispose:)
	(return temp1)
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

	(method (center &tmp temp0 temp1)
		(super center: &rest)
		(= temp0 (+ (- nsRight nsLeft) 1))
		(= temp1 (+ nsLeft (/ temp0 2)))
		(self move: (- local0 temp1) (- local1 nsBottom))
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
		back 0
		borderColor 0
	)
)

(class Blink of Cycle
	(properties
		waitCount 0
		lastCount 0
		waitMax 0
		waitMin 0
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
		back 227
		caller 0
		modNum -1
		x -1
		y -1
		disposeWhenDone 1
		ticks -1
		modeless 2
		dialog 0
		saveCursor 0
		initialized 0
		font 0
		fore 232
		talkWidth 400
		cueVal 0
		showTitle 0
		curVolume 0
		audModNum -1
		audNoun 0
		audVerb 0
		audCase 0
		audSequence 0
		textX -1
		textY -1
		nSaveTime 0
		curSFXVolume 0
	)

	(method (kill)
		(= caller 0)
		(self dispose:)
	)

	(method (init)
		(if (& gMsgType $0002)
			(= curVolume global227)
			(if (not ((ScriptID 64017 0) test: 305)) ; oFlags
				(proc64031_0 (MulDiv 55 global227 100))
			)
			(= curSFXVolume global228)
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

	(method (say param1 param2 param3)
		(if (not initialized)
			(self init:)
		else
			(PrintDebug
				{Tried to say two messages simultaneously with one talker. mle}
			)
			(if dialog
				(dialog dispose:)
				(= dialog 0)
			)
		)
		(= caller (if (and (> argc 1) param3) param3 else 0))
		(if (& gMsgType $0001)
			(self startText: param1 param2)
		)
		(if (& gMsgType $0002)
			(self startAudio: param2 param1)
			0
		)
		(= nSaveTime (+ gTickOffset (GetTime)))
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
		(= dialog (proc64928_0 theBuf))
	)

	(method (startAudio param1 param2 &tmp temp0 temp1)
		(= audModNum (param1 at: 0))
		(= audNoun (param1 at: 1))
		(= audVerb (param1 at: 2))
		(= audCase (param1 at: 3))
		(= audSequence (param1 at: 4))
		(if (and local4 local5)
			(= temp1 global229)
		else
			(= temp1 (| global229 $0080))
		)
		(= ticks
			(DoAudio audPLAY audModNum audNoun audVerb audCase audSequence 1 temp1)
		)
		(if (> ticks 0)
			(= ticks (Max 1 (- ticks 30)))
		)
		(if (<= ticks 0)
			(PrintDebug
				{Missing audio for %d %d %d %d %hu}
				audNoun
				audVerb
				audCase
				audSequence
				audModNum
			)
		)
		(if (<= ticks 0)
			(= temp0 (param2 size:))
			(= ticks (Max 120 (* (/ (* 24 temp0) 10) gTextSpeed)))
			(if (not dialog)
				(self display: param2)
			)
		)
	)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime nSaveTime) ticks)
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
			(proc64031_0 curVolume)
			(proc64031_1 curSFXVolume)
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

	(method (init &tmp temp0)
		(if
			(or
				(not client)
				(not (& (client Info:) $0010))
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
			((= temp0 (client scaler:))
				(temp0 doit:)
				(self
					setScaler:
						Scaler
						(temp0 frontSize:)
						(temp0 backSize:)
						(temp0 frontY:)
						(temp0 backY:)
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
		priority 15
		frame 0
		loop 0
		cel 0
		view 0
		bust 0
		eyes 0
		mouth 0
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

	(method (startAudio param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(if mouth
			(= temp0 (param1 at: 0))
			(= temp1 (param1 at: 1))
			(= temp2 (param1 at: 2))
			(= temp3 (param1 at: 3))
			(= temp4 (param1 at: 4))
			(= local4 (ResCheck 147 temp0 temp1 temp2 temp3 temp4)) ; AUDIO36
			(= local5 (ResCheck 148 temp0 temp1 temp2 temp3 temp4)) ; SYNC36
			(PrintDebug {Aud, Sync: %d %d} local4 local5)
			(if (and local4 local5)
				(mouth setCycle: MouthSync temp0 temp1 temp2 temp3 temp4)
			else
				(mouth setCycle: TalkRandCycle)
			)
		)
		(super startAudio: param1 param2)
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

