;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use h5Messager)
(use IconBar)
(use System)

(public
	proc64996_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (proc64996_0)
	(if (== global896 3)
		(= global923 (Random 420 660))
	else
		(= global923 (Random 1080 1320))
	)
	(= global922 (GetTime))
)

(procedure (localproc_0)
	(if (== global896 3)
		(Random 540 840)
		(return)
	else
		(Random 900 1800)
		(return)
	)
)

(instance uEvt of Event
	(properties)

	(method (new)
		(= type (= message (= modifiers (= y (= x (= claimed (= plane 0)))))))
		(GetEvent gEventMask self)
		(return self)
	)
)

(class User of Obj
	(properties
		alterEgo 0
		input 0
		controls 0
		prevDir 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
	)

	(method (init)
		(= curEvent uEvt)
		(= global918 (GetTime))
		(= local3 (localproc_0))
		(proc64996_0)
		(= local0 0)
		(= local1 -500)
		(= local2 -500)
		(= local4 0)
	)

	(method (canInput n)
		(if argc
			(= input n)
		)
		(return input)
	)

	(method (doit)
		(curEvent new:)
		(self handleEvent: curEvent)
	)

	(method (handleEvent event &tmp eType eMsg eMod dir aObj)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(if
			(and
				(proc64937_0)
				(>= global896 2)
				(switch gCardGameScriptNumber
					(100 1)
					(200 1)
					(300 1)
					(400 1)
					(500 1)
					(1100 1)
					(700 1)
					(1300 1)
					(1200 1)
				)
			)
			(if
				(and
					(not local0)
					(or
						(not controls)
						(!= gMouseX local1)
						(!= gMouseY local2)
						(event type:)
					)
				)
				(= global918 (GetTime))
				(= local1 gMouseX)
				(= local2 gMouseY)
			)
			(cond
				((and (not local0) (>= (Abs (- (GetTime) global918)) local3))
					(if (proc17_0)
						(= local0 1)
					)
				)
				(
					(and
						local0
						(or
							(event type:)
							(!= gMouseX local1)
							(!= gMouseY local2)
						)
					)
					(proc17_1)
					(= local0 0)
					(= global918 (GetTime))
					(= local3 (localproc_0))
				)
			)
		)
		(= eType (event type:))
		(= eMod (event modifiers:))
		(if (and (proc64937_0) (or (== eType evMOUSEBUTTON) (== eType evKEYBOARD)))
			(proc17_3)
			(proc0_15)
		)
		(if
			(and
				(== eType evKEYBOARD)
				(== global896 3)
				controls
				(proc64937_0)
				(<= 59 (/ (event message:) 256) 70)
				(== (DoAudio audPOSITION local4) -1)
			)
			(= local4 (+ 9000 (- (/ (event message:) 256) 58)))
			(gSound play: local4)
			(proc17_4)
			(proc0_7)
			(proc0_15)
		)
		(if (and controls (>= (Abs (- (GetTime) global922)) global923))
			(proc17_5)
		)
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: 434 2))
				(curEvent new:)
			)
		)
		(if (not (gPrints isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gPrints allTrue: 434 2))
				(curEvent new:)
			)
		)
		(if eType
			(= gLastEvent event)
			(if (and mapKeyToDir (!= eType evKEYUP))
				(MapKeyToDir event)
			)
			(if (== eType $0020) ; joyUp
				(= eType evKEYBOARD)
				(= eMsg (if (& eMod emSHIFT) 27 else 13))
				(= eMod $0000)
				(event type: eType message: eMsg modifiers: $0000)
			)
			(if (and gSpeechHandler (gSpeechHandler handleEvent: event))
				(return 1)
			)
			(event localize: (gCast plane:))
			(= eType (event type:))
			(= eMsg (event message:))
			(cond
				((& eType $0100) ; speechEvent
					(cond
						(
							(and
								(== eMsg JOY_UP)
								(or
									(= aObj
										(gCast firstTrue: #perform findNoun)
									)
									(= aObj
										(gFeatures firstTrue: #perform findNoun)
									)
								)
							)
							(aObj doVerb: ((gTheIconBar curIcon:) message:))
						)
						((= aObj (gTheIconBar findIcon: eMsg))
							(gTheIconBar select: aObj)
							(gGame setCursor: (aObj cursor:))
						)
					)
				)
				((& eType $0010) ; direction
					(cond
						((and gDirectionHandler (gDirectionHandler handleEvent: event))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar curIcon:)
											(gTheIconBar walkIconItem:)
										)
									)
									(not gTheIconBar)
								)
								alterEgo
								controls
								(gCast contains: alterEgo)
								(alterEgo handleEvent: event)
							)
							(return 1)
						)
						(
							(and
								gPMouse
								(or (not (& eType evKEYBOARD)) (!= eMsg JOY_NULL))
								(gPMouse handleEvent: event)
							)
							(return 1)
						)
					)
				)
				((and (& eType evKEYBOARD) gKeyDownHandler (gKeyDownHandler handleEvent: event))
					(return 1)
				)
				((and (& eType evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
			(return 1)
		)
		(if gTheIconBar
			(gTheIconBar handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(= eType (event type:))
		(= eMsg (event message:))
		(if (and input (& eType evVERB))
			(cond
				((and (& eType evMOVE) gWalkHandler (gWalkHandler handleEvent: event))
					(return 1)
				)
				(
					(and
						(& eType evMOVE)
						(gCast contains: alterEgo)
						controls
						(alterEgo handleEvent: event)
					)
					(return 1)
				)
				(gUseSortedFeatures)
				((gCast handleEvent: event)
					(return 1)
				)
				((gFeatures handleEvent: event)
					(return 1)
				)
			)
			(if (and (not (event claimed:)) (gRegions handleEvent: event))
				(return 1)
			)
		)
		(if (and eType (gGame handleEvent: event))
			(return 1)
		)
		(return 0)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)
)

(class OnMeAndLowY of Code
	(properties
		theObj 0
		lastY -1
	)

	(method (init)
		(= theObj 0)
		(= lastY -1)
	)

	(method (doit thisObj event)
		(if (and (thisObj onMe: event) (> (thisObj y:) lastY))
			(= theObj thisObj)
			(= lastY (theObj y:))
		)
	)
)

(instance findNoun of Code
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

