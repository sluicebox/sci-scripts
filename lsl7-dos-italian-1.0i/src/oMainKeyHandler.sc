;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64010)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use NewUser)
(use soFlashCyberSniff)
(use Str)
(use System)

(public
	oMainKeyHandler 0
	oRightClickHandler 1
)

(local
	local0
	[local1 8] = [3 6 0 4 2 5 1 7]
)

(instance oMainKeyHandler of EventCode
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (not (& (event type:) $000c)) ; evKEYUP | evKEYBOARD
			(PrintDebug
				{Attempt to execute key handler with non-key event. DJM keys.sc}
			)
			(return)
		)
		(if (not (& (event type:) evKEYBOARD))
			(return)
		)
		(event claimed: 1)
		(switch (event message:)
			(KEY_TAB
				(if (and (gUser canControl:) (gThePlane isEnabled:))
					(if (== ((ScriptID 64037 2) priority:) 450) ; oInvPlane
						((ScriptID 64037 2) setPri: -1) ; oInvPlane
					else
						((ScriptID 64037 2) setPri: 450) ; oInvPlane
					)
					(UpdatePlane (ScriptID 64037 2)) ; oInvPlane
				)
			)
			(KEY_ADD
				(= temp0 (gGame nGameSpeed:))
				(= temp0 (Max 1 (-- temp0)))
				(gGame nGameSpeed: temp0)
				(gEgo setSpeed: temp0)
			)
			(KEY_SUBTRACT
				(= temp0 (gGame nGameSpeed:))
				(= temp0 (Min 10 (++ temp0)))
				(gGame nGameSpeed: temp0)
				(gEgo setSpeed: temp0)
			)
			($003d ; =
				(= temp0 6)
				(gEgo setSpeed: 6)
				(gGame nGameSpeed: temp0)
			)
			(KEY_SHIFT
				(if (= local0 (not local0))
					(TextDialog
						(MakeMessageText 0 0 28 1 14)
						(Str with: global288)
					)
					(PalCycle 0 65 165 1 10) ; Start
				else
					(TextDialog
						(MakeMessageText 0 0 27 1 14)
						(Str with: global288)
					)
					(PalCycle 4) ; Off
				)
			)
			(KEY_F2
				(oBodySFX setRelVol: 200 playSound: 107)
				(event claimed: 1)
			)
			(KEY_F3
				(oBodySFX setRelVol: 200 playSound: 108)
				(event claimed: 1)
			)
			(KEY_F4
				(oBodySFX setRelVol: 200 playSound: 109)
				(event claimed: 1)
			)
			(KEY_F5
				(oBodySFX setRelVol: 200 playSound: 25006)
				(event claimed: 1)
			)
			(KEY_F6
				(oBodySFX setRelVol: 200 playSound: 37403)
				(event claimed: 1)
			)
			(KEY_F7
				(oBodySFX setRelVol: 200 playSound: 37401)
				(event claimed: 1)
			)
			(KEY_F8
				(oBodySFX setRelVol: 200 playSound: 55015)
				(event claimed: 1)
			)
			(KEY_F9
				(oBodySFX setRelVol: 200 playSound: 55004)
				(event claimed: 1)
			)
			(KEY_F10
				(oBodySFX setRelVol: 200 playSound: 37405)
				(event claimed: 1)
			)
			(KEY_LEFT
				(if (& (event modifiers:) emSHIFT)
					(-= gMouseX 7)
				else
					(-= gMouseX 30)
				)
				(event x: gMouseX y: gMouseY type: evMOUSERELEASE claimed: 0)
				(gTheCursor posn: gMouseX gMouseY)
			)
			(KEY_RIGHT
				(if (& (event modifiers:) emSHIFT)
					(+= gMouseX 7)
				else
					(+= gMouseX 30)
				)
				(event x: gMouseX y: gMouseY type: evMOUSERELEASE claimed: 0)
				(gTheCursor posn: gMouseX gMouseY)
			)
			(KEY_UP
				(if (& (event modifiers:) emSHIFT)
					(-= gMouseY 7)
				else
					(-= gMouseY 30)
				)
				(event x: gMouseX y: gMouseY type: evMOUSERELEASE claimed: 0)
				(gTheCursor posn: gMouseX gMouseY)
			)
			(KEY_DOWN
				(if (& (event modifiers:) emSHIFT)
					(+= gMouseY 7)
				else
					(+= gMouseY 30)
				)
				(event x: gMouseX y: gMouseY type: evMOUSERELEASE claimed: 0)
				(gTheCursor posn: gMouseX gMouseY)
			)
			(KEY_SPACE
				(event type: evMOUSEBUTTON claimed: 0)
			)
			(KEY_RETURN
				(event type: evMOUSEBUTTON claimed: 0)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance oRightClickHandler of EventCode
	(properties)

	(method (handleEvent &tmp temp0)
		(return 0)
	)
)

(instance oBodySFX of TPSound
	(properties)
)

