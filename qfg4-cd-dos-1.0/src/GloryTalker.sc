;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Print)
(use Talker)
(use Actor)
(use System)

(class GloryTalker of Talker
	(properties
		font 300
		back 255
	)

	(method (isModeless)
		(return 0)
	)

	(method (show)
		(if (not initialized)
			(self init: &rest)
		)
	)

	(method (hide)
		(if mouth
			(mouth setCycle: 0 hide:)
		)
		(if eyes
			(eyes hide:)
		)
		(if frame
			(frame hide:)
		)
		(if bust
			(bust hide:)
		)
	)

	(method (showAgain)
		(if mouth
			(mouth show:)
		)
		(if eyes
			(eyes show:)
		)
		(if frame
			(frame show:)
		)
		(if bust
			(bust show:)
		)
	)

	(method (init param1 param2 param3 param4)
		(if
			(and
				argc
				(or
					(not (IsFlag 147))
					(and gTeller (!= (gTeller talker:) self))
				)
			)
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
		(Palette 2 0 255 100) ; PalIntensity
		(PalVary 3) ; PalVaryKill
		(ClearFlag 6)
		(if (& gMsgType $0002)
			(= curVolume (gGlory masterVolume:))
			(if (>= curVolume 6)
				(gGlory masterVolume: (- curVolume 6))
			else
				(gGlory masterVolume: 1)
			)
		)
		(= initialized 1)
		(if
			(or
				(not (IsFlag 147))
				(and gTeller (!= (gTeller talker:) self))
			)
			(gTalkers addToFront: self)
			(if (not mouth)
				(= mouth
					((Prop new:)
						view: view
						loop: loop
						cel: cel
						x: x
						y: y
						yourself:
					)
				)
			)
			(mouth init: setPri: priority show:)
			(if bust
				(bust setPri: init:)
			)
			(if eyes
				(eyes setPri: priority init: show:)
			)
			(if frame
				(frame setPri: priority init: show:)
			)
		)
	)

	(method (doit)
		(gCast doit:)
		(if (and (!= ticks -1) (> (- gGameTime ticks) 0) (& gMsgType $0002))
			(== (DoAudio audPOSITION audModNum audNoun audVerb audCase audSequence) -1)
			(if (and 1 (or (!= modeless 0) (& gMsgType $0002)))
				(self dispose: 0)
				(return 0)
			)
		)
		(return 1)
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
						((& temp0 $0020) ; joyUp
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
					(or
						(& temp0 $4021) ; evVERB | joyUp | evMOUSEBUTTON
						(and
							(& temp0 evKEYBOARD)
							(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
						)
					)
					(if (& gMsgType $0001)
						(if (dialog handleEvent: event)
							(event claimed: 1)
							(self dispose: 0)
						)
					else
						(event claimed: 1)
						(self dispose: 0)
					)
				)
			)
		)
	)

	(method (dispose param1)
		(if
			(or
				(not (IsFlag 147))
				(and gTeller (!= (gTeller talker:) self))
			)
			(if mouth
				(mouth setCycle: 0 setCel: 0)
			)
			(if (or (not argc) param1)
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
		)
		(= ticks -1)
		(if (and (!= audModNum -1) (& gMsgType $0002))
			(DoAudio audSTOP audModNum audNoun audVerb audCase audSequence)
			(= audModNum -1)
		)
		(if (or (not argc) param1)
			(= initialized 0)
			(= modNum -1)
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
		(if (and (or (not argc) param1) (not (IsFlag 147)) (IsFlag 148))
			(ClearFlag 148)
			(if (not (== gCurRoomNum 470))
				((gCurRoom plane:) drawPic: (gCurRoom picture:))
			)
			(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
			((ScriptID 0 21) doit:) ; statusCode
			(SetFlag 6)
			(proc0_16)
			(proc0_13)
		)
		(if (or (not argc) param1)
			(if (and (IsFlag 147) gTeller (!= (gTeller talker:) self))
				((gTeller talker:) showAgain:)
			)
			(DisposeClone self)
		)
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3
			(cond
				(frame frame)
				(bust bust)
				(else mouth)
			)
		)
		(= temp4 (Print new:))
		(if viewInPrint
			(= temp0 (temp3 loop:))
			(if showTitle
				(temp4 addTitle: name)
			)
			(temp4
				largeAlp: 1
				fore: fore
				back: back
				posn: x y
				modeless: 2
				font: font
				addText: param1
				addIcon: view temp0 cel 0 0
				init:
			)
		else
			(if (not (+ textX textY))
				(= textX
					(+ (CelWide (temp3 view:) (temp3 loop:) (temp3 cel:)) 5)
				)
			)
			(if (> (+ (= temp2 (+ (temp3 nsLeft:) textX)) talkWidth) 318)
				(= temp1 (- 318 temp2))
			else
				(= temp1 talkWidth)
			)
			(if showTitle
				(temp4 addTitle: name)
			)
			(temp4
				fore: fore
				back: back
				posn: (+ (temp3 x:) textX) (+ (temp3 y:) textY)
				modeless: 2
				font: font
				width: temp1
				addText: param1
				init:
			)
		)
		(gPrints delete: temp4)
		(= dialog (temp4 dialog:))
	)

	(method (say param1 param2 param3)
		(SetFlag 50)
		(if (and (not (IsFlag 147)) (not (IsFlag 148)))
			(if (not (== gCurRoomNum 470))
				((ScriptID 0 21) doit: 100) ; statusCode
			)
			(SetFlag 148)
			(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
			(if (not (== gCurRoomNum 470))
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(FrameOut)
			)
		)
		(if (and global432 (!= global347 global432))
			(global432 hide:)
			(self showAgain:)
		)
		(if (not (gTalkers contains: self))
			(gTalkers addToFront: self)
		)
		(if (and gTeller (!= (gTeller talker:) self))
			((gTeller talker:) hide:)
		)
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
)

