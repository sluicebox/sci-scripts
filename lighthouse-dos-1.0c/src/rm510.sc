;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use LightRoom)
(use Sound)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(if
		(and
			(not (IsFlag 387))
			(not (IsFlag 369))
			(IsFlag 257)
			(OneOf param1 7503 7500 7505 7502)
			(not (IsFlag 357))
		)
		(if (> (++ local0) 1)
			(SetFlag 387)
			((ScriptID 1 3) dispose:) ; exitLeft
			((ScriptID 1 4) dispose:) ; exitRight
			((ScriptID 1 6) dispose:) ; exitUp
			((ScriptID 1 2) dispose:) ; exitBack
			(gCurRoom setScript: sBirdmanAttacks)
			(return 0)
		else
			(return 1)
		)
	)
	(return 1)
)

(instance rm510 of LightRoom
	(properties
		picture 4509
	)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(gBackMusic number: 1010 setLoop: -1 play:)
		(gMySoundFX number: 45103 setLoop: -1 play:)
		(if (IsFlag 386)
			(switch global209
				(0
					(self changeScene: 501 3)
				)
				(1
					(self changeScene: 4510 3)
				)
				(2
					(self changeScene: 4511 3)
				)
				(3
					(self changeScene: 4512 3)
				)
			)
		else
			(switch global209
				(0
					(self changeScene: 501 3)
				)
				(1
					(self changeScene: 4507 3)
				)
				(2
					(self changeScene: 4508 3)
				)
				(3
					(self changeScene: 4509 3)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gBackMusic fade:)
		(gMySoundFX fade:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (changeScene param1 &tmp temp0)
		(= temp0 scene)
		(subProp dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(501
				((ScriptID 1 2) newPic: 504 7) ; exitBack
				((ScriptID 1 4) newPic: 502 2) ; exitRight
				((ScriptID 1 3) newPic: 503 4) ; exitLeft
				((ScriptID 1 6) newPic: 505 3) ; exitUp
				(if (IsFlag 391)
					((ScriptID 1 2) nsLeft: 210) ; exitBack
					(subProp init:)
				)
			)
			(502
				(if (IsFlag 386)
					(if (== global209 1)
						((ScriptID 1 3) newPic: 4510 3) ; exitLeft
					else
						((ScriptID 1 3) newPic: 4511 3) ; exitLeft
					)
				else
					((ScriptID 1 3) newPic: 501 3) ; exitLeft
				)
				((ScriptID 1 4) newPic: 504 7) ; exitRight
			)
			(503
				((ScriptID 1 4) newPic: 501 3) ; exitRight
				((ScriptID 1 3) newPic: 504 7) ; exitLeft
			)
			(504
				((ScriptID 1 5) newRoom: 500) ; exitDown
				(if (IsFlag 386)
					(switch global209
						(0
							((ScriptID 1 2) newPic: 501 3) ; exitBack
						)
						(1
							((ScriptID 1 2) newPic: 4510 3) ; exitBack
						)
						(2
							((ScriptID 1 2) newPic: 4511 3) ; exitBack
						)
						(3
							((ScriptID 1 2) newPic: 4512 3) ; exitBack
						)
					)
				else
					(switch global209
						(0
							((ScriptID 1 2) newPic: 501 3) ; exitBack
						)
						(1
							((ScriptID 1 2) newPic: 4507 3) ; exitBack
						)
						(2
							((ScriptID 1 2) newPic: 4508 3) ; exitBack
						)
						(3
							((ScriptID 1 2) newPic: 4509 3) ; exitBack
						)
					)
				)
				(if (IsFlag 386)
					(switch global209
						(0
							((ScriptID 1 4) newPic: 503 4) ; exitRight
						)
						(1
							((ScriptID 1 4) newPic: 7506 4) ; exitRight
						)
						(2
							((ScriptID 1 4) newPic: 7504 4) ; exitRight
						)
						(3
							((ScriptID 1 4) newPic: 7506 4) ; exitRight
						)
					)
				else
					(switch global209
						(0
							((ScriptID 1 4) newPic: 503 4) ; exitRight
						)
						(1
							((ScriptID 1 4) newPic: 7503 4) ; exitRight
						)
						(2
							((ScriptID 1 4) newPic: 7505 4) ; exitRight
						)
						(3
							((ScriptID 1 4) newPic: 7505 4) ; exitRight
						)
					)
				)
				(if (IsFlag 386)
					(switch global209
						(0
							((ScriptID 1 3) newPic: 502 2) ; exitLeft
						)
						(1
							((ScriptID 1 3) newPic: 502 2) ; exitLeft
						)
						(2
							((ScriptID 1 3) newPic: 502 2) ; exitLeft
						)
						(3
							((ScriptID 1 3) newPic: 7501 2) ; exitLeft
						)
					)
				else
					(switch global209
						(0
							((ScriptID 1 3) newPic: 502 2) ; exitLeft
						)
						(1
							((ScriptID 1 3) newPic: 7500 2) ; exitLeft
						)
						(2
							((ScriptID 1 3) newPic: 7500 2) ; exitLeft
						)
						(3
							((ScriptID 1 3) newPic: 7502 2) ; exitLeft
						)
					)
				)
			)
			(505
				(if (IsFlag 386)
					(switch global209
						(0
							((ScriptID 1 5) newPic: 501 3) ; exitDown
						)
						(1
							((ScriptID 1 5) newPic: 4510 3) ; exitDown
						)
						(2
							((ScriptID 1 5) newPic: 4511 3) ; exitDown
						)
						(3
							((ScriptID 1 5) newPic: 4512 3) ; exitDown
						)
					)
				else
					(switch global209
						(0
							((ScriptID 1 5) newPic: 501 3) ; exitDown
						)
						(1
							((ScriptID 1 5) newPic: 4507 3) ; exitDown
						)
						(2
							((ScriptID 1 5) newPic: 4508 3) ; exitDown
						)
						(3
							((ScriptID 1 5) newPic: 4509 3) ; exitDown
						)
					)
				)
			)
			(4507
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 7500 2) ; exitRight
					((ScriptID 1 3) newPic: 7503 4) ; exitLeft
				)
			)
			(4508
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 7500 2) ; exitRight
					((ScriptID 1 3) newPic: 7505 4) ; exitLeft
				)
			)
			(4509
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 7502 2) ; exitRight
					((ScriptID 1 3) newPic: 7505 4) ; exitLeft
				)
			)
			(4510
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 502 2) ; exitRight
					((ScriptID 1 3) newPic: 7506 4) ; exitLeft
				)
			)
			(4511
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 502 2) ; exitRight
					((ScriptID 1 3) newPic: 7504 4) ; exitLeft
				)
			)
			(4512
				(if (localproc_0 temp0)
					((ScriptID 1 6) newPic: 505 3) ; exitUp
					((ScriptID 1 2) newPic: 504 7) ; exitBack
					((ScriptID 1 4) newPic: 7501 2) ; exitRight
					((ScriptID 1 3) newPic: 7504 4) ; exitLeft
				)
			)
			(7500
				(if (== global209 1)
					((ScriptID 1 3) newPic: 4507 3) ; exitLeft
				else
					((ScriptID 1 3) newPic: 4508 3) ; exitLeft
				)
				((ScriptID 1 4) newPic: 504 7) ; exitRight
			)
			(7501
				((ScriptID 1 3) newPic: 4512 3) ; exitLeft
				((ScriptID 1 4) newPic: 504 7) ; exitRight
			)
			(7502
				((ScriptID 1 3) newPic: 4509 3) ; exitLeft
				((ScriptID 1 4) newPic: 504 7) ; exitRight
			)
			(7503
				((ScriptID 1 4) newPic: 4507 3) ; exitRight
				((ScriptID 1 3) newPic: 504 7) ; exitLeft
			)
			(7504
				(if (== global209 2)
					((ScriptID 1 4) newPic: 4511 3) ; exitRight
				else
					((ScriptID 1 4) newPic: 4512 3) ; exitRight
				)
				((ScriptID 1 3) newPic: 504 7) ; exitLeft
			)
			(7505
				(if (== global209 2)
					((ScriptID 1 4) newPic: 4508 3) ; exitRight
				else
					((ScriptID 1 4) newPic: 4509 3) ; exitRight
				)
				((ScriptID 1 3) newPic: 504 7) ; exitLeft
			)
			(7506
				((ScriptID 1 4) newPic: 4510 3) ; exitRight
				((ScriptID 1 3) newPic: 504 7) ; exitLeft
			)
		)
	)

	(method (notify)
		(if
			(and
				(gCurRoom script:)
				(== (gCurRoom script:) sBirdmanAttacks)
				(== (sBirdmanAttacks state:) 0)
			)
			(gGame handsOff:)
			(sBirdmanAttacks register: 1)
		)
	)
)

(instance sBirdmanAttacks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(entranceSFX play:)
				(if (== global209 3)
					(KillRobot 4509 0 0)
				else
					(KillRobot 4507 0 0)
				)
			)
			(1
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 4)) ; InvInset
					((ScriptID 9 4) dispose:) ; InvInset
				)
				(if register
					(gCurRoom setScript: sSuccess)
				else
					(DoRobot)
					(SetFlag 386)
					(switch global209
						(1
							(gCurRoom drawPic: 4510)
							(proc0_8 4510)
						)
						(2
							(gCurRoom drawPic: 4511)
							(proc0_8 4512)
						)
						(3
							(gCurRoom drawPic: 4512)
							(proc0_8 4514)
						)
					)
					(if
						(and
							(gPanels contains: (ScriptID 9 3)) ; PlCompass
							(not (gPanels contains: (ScriptID 9 4))) ; InvInset
						)
						((ScriptID 9 3) hide:) ; PlCompass
					)
					(gCurRoom drawPic: 165)
					(KillRobot 3149 0 0)
				)
			)
			(2
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(switch global209
					(0
						(gCurRoom changeScene: 501 3)
					)
					(1
						(gCurRoom changeScene: 4510 3)
					)
					(2
						(gCurRoom changeScene: 4511 3)
					)
					(3
						(gCurRoom changeScene: 4512 3)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSuccess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoRobot)
				(switch global209
					(1
						(gCurRoom drawPic: 0)
						(proc0_8 4516)
					)
					(2
						(gCurRoom drawPic: 0)
						(proc0_8 4518)
					)
					(3
						(gCurRoom drawPic: 0)
						(proc0_8 4520)
					)
				)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gCurRoom drawPic: 165)
				(switch global209
					(1
						(KillRobot 3150 0 0)
					)
					(2
						(KillRobot 166 0 0)
					)
					(3
						(KillRobot 165 0 0)
					)
				)
			)
			(1
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(SetFlag 391)
				(= global209 0)
				(gCurRoom changeScene: 501 3)
				(ClearFlag 257)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance subProp of View
	(properties
		x 145
		y 272
		view 501
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(ClearFlag 391)
				(SetFlag 69)
				(gInventory addItem: (ScriptID 9 32)) ; invThrottle
				(sfxGetThrottle play:)
				((ScriptID 1 2) nsLeft: 170) ; exitBack
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sfxGetThrottle of Sound
	(properties
		number 43905
	)
)

(instance entranceSFX of Sound
	(properties
		number 10071
	)
)

