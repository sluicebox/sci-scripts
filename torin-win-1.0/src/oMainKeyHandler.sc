;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64010)
(include sci.sh)
(use Main)
(use oBoogle)
(use DialogPlane)
(use NewUser)
(use n64896)
(use Str)
(use System)

(public
	oMainKeyHandler 0
	oRightClickHandler 1
)

(local
	bPsychMode
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(instance oMainKeyHandler of EventCode
	(properties)

	(method (handleEvent event &tmp nSpeed)
		(if (not (& (event type:) $000c)) ; evKEYUP | evKEYBOARD
			(return)
		)
		(if (not (& (event type:) evKEYBOARD))
			(return)
		)
		(event claimed: 1)
		(switch (event message:)
			(KEY_ADD
				(= nSpeed (gGame nGameSpeed:))
				(= nSpeed (Max 1 (-- nSpeed)))
				(gGame nGameSpeed: nSpeed)
				(gEgo setSpeed: nSpeed)
				((ScriptID 64018 0) setSpeed: nSpeed) ; oBoogle
			)
			(KEY_SUBTRACT
				(= nSpeed (gGame nGameSpeed:))
				(= nSpeed (Min 10 (++ nSpeed)))
				(gGame nGameSpeed: nSpeed)
				(gEgo setSpeed: nSpeed)
				((ScriptID 64018 0) setSpeed: nSpeed) ; oBoogle
			)
			($003d ; =
				(= nSpeed 6)
				(gEgo setSpeed: 6)
				((ScriptID 64018 0) setSpeed: nSpeed) ; oBoogle
				(gGame nGameSpeed: nSpeed)
			)
			(KEY_SHIFT
				(if (= bPsychMode (not bPsychMode))
					(TextDialog (MakeMessageText 0 0 37 1 0) (Str with: goDismissString))
					(PalCycle 0 65 165 1 10) ; Start
				else
					(TextDialog (MakeMessageText 0 0 38 1 0) (Str with: goDismissString))
					(PalCycle 4) ; Off
				)
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

	(method (handleEvent event &tmp ppDest)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emSHIFT)
				(gUser canControl:)
				(gEgo bIsInitialized:)
				(gEgo isNotHidden:)
				(gEgo plane:)
				((gEgo plane:) isEnabled:)
				((gEgo plane:) onMe: (event globalize: yourself:))
			)
			(event localize: (gEgo plane:))
			(= ppDest (GetDestLoc gEgo (event x:) (event y:)))
			(gEgo setMotion: 0)
			(gEgo
				setLoop:
					[trans2
						(/
							(umod
								(+
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(ppDest at: 0)
										(ppDest at: 1)
									)
									22
								)
								360
							)
							45
						)
					]
			)
			(gEgo posn: (ppDest at: 0) (ppDest at: 1))
			(ppDest dispose:)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

