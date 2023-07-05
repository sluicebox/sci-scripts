;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use TwistyIconItem)
(use ADRoom)
(use Inset)
(use Feature)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm371 0
)

(local
	local0
	[local1 16] = [0 5 10 15 20 25 30 35 40 45 50 55 60 65 70 75]
	[local17 16] = [169 179 191 196 196 196 190 180 168 157 146 141 140 142 147 158]
	[local33 16] = [73 74 82 90 97 104 112 121 122 121 112 104 97 90 82 75]
	[local49 16] = [0 2 4 6 8 10 12 14 1 3 5 7 9 11 13 0]
	local65
	local66
	local67
	local68
	local69
	local70
	local71
	local72
)

(procedure (localproc_0)
	(gGame handsOn:)
	(gTheIconBar disable: 5 4 6)
)

(procedure (localproc_1)
	(gGame handsOff:)
	(gTheIconBar enable: 5 4 6)
)

(instance rm371 of ADRoom
	(properties
		picture 371
	)

	(method (init)
		(LoadMany rsPIC 372 373)
		(= local66 1)
		(super init: &rest)
		((ScriptID 895 0) hide:) ; pepper
		(gTheIconBar disable: 5 4)
		(gCurRoom setScript: sEnterRoom)
	)

	(method (newRoom newRoomNumber)
		(gTheIconBar enable: 5 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (IsFlag 153)
					(if (gEgo has: 39) ; Bag_Of_Money
						(gCurRoom setInset: inSafeEmpty)
					else
						(gCurRoom setInset: inSafeMoney)
					)
				else
					(gCurRoom setInset: inSafeDial)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 153)
				(localproc_0)
				(gGame points: 364 3)
				(= cycles 1)
			)
			(1
				(gCurRoom setInset: 0)
				(= cycles 3)
			)
			(2
				(sFX number: 3705 play:)
				(if (gEgo has: 39) ; Bag_Of_Money
					(gCurRoom setInset: inSafeEmpty self)
				else
					(gCurRoom setInset: inSafeMoney self)
				)
			)
			(3
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sCloseSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 153)
				(localproc_0)
				(gGame points: 366 1)
				(= local68 0)
				(= local69 0)
				(= local70 0)
				(= cycles 1)
			)
			(1
				(gCurRoom setInset: 0 picture: 371)
				(= cycles 3)
			)
			(2
				(sFX number: 3706 play:)
				(gCurRoom setInset: inSafeDial self)
			)
			(3
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sGetBagOMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 365 2)
				(= cycles 1)
			)
			(1
				(gEgo get: 39) ; Bag_Of_Money
				(bagOfMoney dispose:)
				(sFX number: 3715 play:)
				(gMessager say: 2 7 1 0 self) ; "I'll just keep this for old Pugh-Face!"
			)
			(2
				(gCurRoom setInset: 0)
				(= cycles 1)
			)
			(3
				(gCurRoom setInset: inSafeEmpty)
				(self dispose:)
			)
		)
	)
)

(instance sMoveDial of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ local67)
					(1
						(if (== local0 5)
							(= local68 1)
						)
					)
					(2
						(if (== local0 30)
							(= local69 1)
						)
					)
					(3
						(if (== local0 75)
							(= local70 1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(self setScript: sTurnDial self)
			)
			(2
				(if (== local66 1)
					(= local66 0)
				else
					(= local66 1)
				)
				(if (== local67 3)
					(if (and local68 local69 local70)
						(SetFlag 153)
						(gCurRoom setScript: sOpenSafe)
					else
						(ClearFlag 153)
						(gCurRoom setScript: sWrongCombo)
					)
				)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sTurnDial of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 1)
			)
			(1
				(sFX number: 3707 play:)
				(if (== local66 1)
					(repeat
						(if (== local65 15)
							(= local65 -1)
						)
						(cond
							((== (= temp0 [local1 (++ local65)]) 75)
								(knob loop: 2)
							)
							((>= temp0 40)
								(knob loop: 1)
							)
							(else
								(knob loop: 0)
							)
						)
						(knob
							x: [local17 local65]
							y: [local33 local65]
							cel: [local49 local65]
						)
						(Animate (gCast elements:) 0)
						(Wait 7)
						(if (== (= local71 temp0) local0)
							(break)
						)
					)
				else
					(repeat
						(if (== local65 0)
							(= local65 16)
						)
						(cond
							((== (= temp0 [local1 (-- local65)]) 75)
								(knob loop: 2)
							)
							((>= temp0 40)
								(knob loop: 1)
							)
							(else
								(knob loop: 0)
							)
						)
						(knob
							x: [local17 local65]
							y: [local33 local65]
							cel: [local49 local65]
						)
						(Animate (gCast elements:) 0)
						(Wait 7)
						(if (== (= local71 temp0) local0)
							(break)
						)
					)
				)
				(sFX stop:)
				(= cycles 1)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sWrongCombo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 0 5 0 self) ; "That must not have been the right combination. Bummer!"
			)
			(1
				(client setScript: sChangeRooms)
			)
		)
	)
)

(instance sChangeRooms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (gCurRoom inset:) inSafeDial)
						(inSafeDial dispose:)
					)
					((== (gCurRoom inset:) inSafeMoney)
						(inSafeMoney dispose:)
					)
					((== (gCurRoom inset:) inSafeEmpty)
						(inSafeEmpty dispose:)
					)
				)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance inSafeDial of Inset
	(properties
		picture 371
		hideTheCast 1
		noun 1
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable: 9)
		(num0 setOnMeCheck: 1 1 init:)
		(num5 setOnMeCheck: 1 2 init:)
		(num10 setOnMeCheck: 1 4 init:)
		(num15 setOnMeCheck: 1 8 init:)
		(num20 setOnMeCheck: 1 16 init:)
		(num25 setOnMeCheck: 1 32 init:)
		(num30 setOnMeCheck: 1 64 init:)
		(num35 setOnMeCheck: 1 128 init:)
		(num40 setOnMeCheck: 1 256 init:)
		(num45 setOnMeCheck: 1 512 init:)
		(num50 setOnMeCheck: 1 1024 init:)
		(num55 setOnMeCheck: 1 2048 init:)
		(num60 setOnMeCheck: 1 4096 init:)
		(num65 setOnMeCheck: 1 8192 init:)
		(num70 setOnMeCheck: 1 16384 init:)
		(num75 setOnMeCheck: 1 -32768 init:)
		(knob init:)
		(safeFeatureL init:)
		(safeFeatureR init:)
		(toCloseSafe init:)
		(gCurRoom curPic: 371)
		(gMouseDownHandler addToFront: gCurRoom)
		(gKeyDownHandler addToFront: gCurRoom)
		(gDirectionHandler addToFront: gCurRoom)
		(proc883_6 1)
	)

	(method (dispose)
		(gTheIconBar enable: 9)
		(proc883_6 0)
		(num0 dispose:)
		(num5 dispose:)
		(num10 dispose:)
		(num15 dispose:)
		(num20 dispose:)
		(num25 dispose:)
		(num30 dispose:)
		(num35 dispose:)
		(num40 dispose:)
		(num45 dispose:)
		(num50 dispose:)
		(num55 dispose:)
		(num60 dispose:)
		(num65 dispose:)
		(num70 dispose:)
		(num75 dispose:)
		(knob dispose:)
		(safeFeatureL dispose:)
		(safeFeatureR dispose:)
		(toCloseSafe dispose:)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 3 6) ; "Oh, wow! A hidden safe!"
			)
			(7 ; Do
				(gMessager say: 3 7 3) ; "Now, let's see..."
			)
			(128 ; Exit
				(gCurRoom setScript: sChangeRooms)
			)
			(85 ; Talk
				(gMessager say: 3 6) ; "Oh, wow! A hidden safe!"
			)
			(3 ; Walk
				(inSafeDial dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(= temp1 (event type:))
		(= temp0 (event message:))
		(if
			(or
				(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
				(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
				(== temp1 evVERB)
			)
			(cond
				((and (not (gUser controls:)) (not (gUser input:)))
					(event claimed: 1)
				)
				((== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(= local0 -1)
					(cond
						(
							(or
								(safeFeatureL onMe: event)
								(safeFeatureR onMe: event)
							)
							(= local0 -1)
							(event claimed: 1)
							(safeFeatureL doVerb:)
						)
						((num0 onMe: event)
							(= local0 0)
							(= local72 num0)
						)
						((num5 onMe: event)
							(= local0 5)
							(= local72 num5)
						)
						((num10 onMe: event)
							(= local0 10)
							(= local72 num10)
						)
						((num15 onMe: event)
							(= local0 15)
							(= local72 num15)
						)
						((num20 onMe: event)
							(= local0 20)
							(= local72 num20)
						)
						((num25 onMe: event)
							(= local0 25)
							(= local72 num25)
						)
						((num30 onMe: event)
							(= local0 30)
							(= local72 num30)
						)
						((num35 onMe: event)
							(= local0 35)
							(= local72 num35)
						)
						((num40 onMe: event)
							(= local0 40)
							(= local72 num40)
						)
						((num45 onMe: event)
							(= local0 45)
							(= local72 num45)
						)
						((num50 onMe: event)
							(= local0 50)
							(= local72 num50)
						)
						((num55 onMe: event)
							(= local0 55)
							(= local72 num55)
						)
						((num60 onMe: event)
							(= local0 60)
							(= local72 num60)
						)
						((num65 onMe: event)
							(= local0 65)
							(= local72 num65)
						)
						((num70 onMe: event)
							(= local0 70)
							(= local72 num70)
						)
						((num75 onMe: event)
							(= local0 75)
							(= local72 num75)
						)
						((toCloseSafe onMe: event)
							(toCloseSafe doVerb: 7)
						)
						(else
							(super handleEvent: event)
						)
					)
					(if (not (== local0 -1))
						(event claimed: 1)
						(gCurRoom setScript: sMoveDial)
					)
				)
			)
		)
	)
)

(instance inSafeEmpty of Inset
	(properties
		picture 373
		hideTheCast 1
		noun 2
	)

	(method (init)
		(gTheIconBar disable: 9)
		(super init: &rest)
		(gCurRoom curPic: 373)
		(safeFeatureL init:)
		(safeFeatureR init:)
		(toCloseSafe y: 220 init:)
		(proc883_6 1)
		(gCurRoom picture: 373)
	)

	(method (dispose)
		(gTheIconBar enable: 9)
		(proc883_6 0)
		(= local66 1)
		(= local67 0)
		(safeFeatureL dispose:)
		(safeFeatureR dispose:)
		(toCloseSafe dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 2 6 2) ; "There's nothing left in the safe."
			)
			(7 ; Do
				(gMessager say: 2 7 2) ; "There's nothing left in the safe."
			)
			(85 ; Talk
				(gMessager say: 30 85 8 0 0 370) ; "Well, I guess that was the only thing in the safe."
			)
			(84 ; Trivia
				(gMessager say: 2 84 2) ; "TRUE. Many wealthy families kept their valuables in hidden safes, as they still do today."
			)
			(128 ; Exit
				(gCurRoom setScript: sChangeRooms)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inSafeMoney of Inset
	(properties
		picture 372
		hideTheCast 1
		noun 2
	)

	(method (init)
		(super init: &rest)
		(gCurRoom curPic: 372)
		(gTheIconBar disable: 9)
		(bagOfMoney init:)
		(safeFeatureL init:)
		(safeFeatureR init:)
		(toCloseSafe init:)
		(proc883_6 1)
		(gCurRoom picture: 372)
	)

	(method (dispose)
		(proc883_6 0)
		(gTheIconBar enable: 9)
		(= local66 1)
		(= local67 0)
		(safeFeatureL dispose:)
		(safeFeatureR dispose:)
		(toCloseSafe dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 2 6 1 0 0) ; "That creepy Pugh! That bag says "The People's Money"!"
			)
			(7 ; Do
				(gCurRoom setScript: sGetBagOMoney)
			)
			(85 ; Talk
				(gMessager say: 2 85 7 0 0 370) ; MISSING MESSAGE
			)
			(84 ; Trivia
				(gMessager say: 2 84 1) ; "TRUE. Many wealthy families kept their valuables in hidden safes, as they still do today."
			)
			(128 ; Exit
				(gCurRoom setScript: sChangeRooms)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance safeFeatureL of Feature
	(properties
		x 26
		y 94
		nsTop -1
		nsBottom 189
		nsRight 52
	)

	(method (doVerb)
		(if (gCurRoom inset:)
			(gCurRoom setScript: sChangeRooms)
		)
	)
)

(instance safeFeatureR of Feature
	(properties
		x 294
		y 94
		nsLeft 270
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(safeFeatureL doVerb: theVerb &rest)
	)
)

(instance toCloseSafe of Feature
	(properties
		x 161
		y 97
		noun 3
		nsTop 21
		nsLeft 58
		nsBottom 174
		nsRight 265
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 153)
					(gCurRoom setScript: sCloseSafe)
				else
					(gCurRoom setScript: sOpenSafe)
				)
			)
			(128 ; Exit
				(gCurRoom setScript: sChangeRooms)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bagOfMoney of Feature
	(properties
		x 181
		y 107
		noun 2
		nsTop 51
		nsLeft 112
		nsBottom 163
		nsRight 250
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 2 6 1 0 0) ; "That creepy Pugh! That bag says "The People's Money"!"
			)
			(7 ; Do
				(gCurRoom setScript: sGetBagOMoney)
			)
			(85 ; Talk
				(gMessager say: 30 85 7 0 0 370) ; "Would you look at that! A bag of stolen bucks!"
			)
			(84 ; Trivia
				(gMessager say: 2 84 1) ; "TRUE. Many wealthy families kept their valuables in hidden safes, as they still do today."
			)
			(128 ; Exit
				(gCurRoom setScript: sChangeRooms)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knob of Actor
	(properties
		x 169
		y 73
		noun 1
		view 377
	)
)

(instance num0 of Feature
	(properties)
)

(instance num5 of Feature
	(properties)
)

(instance num10 of Feature
	(properties)
)

(instance num15 of Feature
	(properties)
)

(instance num20 of Feature
	(properties)
)

(instance num25 of Feature
	(properties)
)

(instance num30 of Feature
	(properties)
)

(instance num35 of Feature
	(properties)
)

(instance num40 of Feature
	(properties)
)

(instance num45 of Feature
	(properties)
)

(instance num50 of Feature
	(properties)
)

(instance num55 of Feature
	(properties)
)

(instance num60 of Feature
	(properties)
)

(instance num65 of Feature
	(properties)
)

(instance num70 of Feature
	(properties)
)

(instance num75 of Feature
	(properties)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

