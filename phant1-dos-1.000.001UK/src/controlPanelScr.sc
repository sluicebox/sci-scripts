;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use n1111)
(use Print)
(use Inset)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	controlPanelScr 0
)

(local
	local0
	local1
	local2
	[local3 15] = [77 80 83 87 90 93 97 100 103 107 110 113 116 119 121]
	[local18 15] = [11 14 17 21 24 27 31 34 37 41 44 47 50 53 55]
	local33
	local34
	local35
	local36
	local37
	local38
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp2 (param1 cel:))
	(param1 cel: (+ temp2 param2))
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp3 1)
	(while (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE)
		(temp1 localize: gThePlane)
		(cond
			((param1 onMe: temp1)
				(if (== (param1 cel:) temp2)
					(param1 cel: (+ (param1 cel:) param2))
					(= temp3 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp2)
				(param1 cel: temp2)
				(= temp3 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp1 dispose:)
	)
	(temp1 dispose:)
	(param1 cel: temp2)
	(UpdateScreenItem param1)
	(return temp3)
)

(procedure (localproc_1)
	(cond
		((not global192) 0)
		((== global192 gNormalCursor)
			(global192 loop: 0 cel: 1)
			(gCurrentControl select: 3 gNormalCursor)
			(gUser message: (gUser dftMessage:))
			(global192 init:)
			(= global192 0)
		)
	)
)

(instance chapInset of Inset
	(properties
		picture -2
		view 9807
		loop 5
		x 0
		y 0
		priority 198
	)

	(method (init param1 param2 param3 param4)
		(if
			(and
				(global116 contains: (ScriptID 0 10)) ; fastForward
				((ScriptID 0 10) isNotHidden:) ; fastForward
			)
			(= local36 1)
		else
			(= local36 0)
		)
		(super init: param1 param2 1 param4)
		(if (Robot 6) ; Exists
			(Robot 10) ; Pause
		)
		(if (not local38)
			(gSounds pause:)
		)
		(= local38 0)
		(marker init:)
		(saveButton init:)
		(restoreButton init:)
		(playButton init:)
		(quitButton init:)
		(sizeButton init:)
		(ratingButton init:)
		(moreButton init:)
		(ratingHilite init:)
		(sizeHilite init:)
		(self drawInset:)
	)

	(method (handleEvent event)
		(cond
			((and inset (inset handleEvent: event)))
			((& (event type:) evVERB)
				(event claimed: 1)
				(self doVerb: (event message:))
			)
		)
		(event claimed:)
	)

	(method (doVerb)
		(gGame pragmaFail:)
	)

	(method (dispose)
		(testMusic dispose:)
		(if (not (OneOf local0 2 5))
			(gSounds pause: 0)
		)
		(if (and (Robot 6) (not (IsFlag 297)) (not local37)) ; Exists
			(Robot 4) ; Play
		)
		(gNormalCursor view: 9960 loop: 0 cel: 1)
		(if local36
			((ScriptID 0 10) init: global116) ; fastForward
		)
		((gUser curEvent:) globalize:)
		(if (not (OneOf local0 2 5))
			((ScriptID 0 19) doit: 0) ; intHSCode
		)
		(super dispose: &rest)
	)
)

(instance sizeButton of Prop
	(properties
		x 25
		y 97
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (IsFlag 127)
				(ClearFlag 127)
				(sizeHilite cel: 3)
			else
				(SetFlag 127)
				(sizeHilite cel: 2)
			)
			(UpdateScreenItem sizeHilite)
		)
	)
)

(instance sizeHilite of View
	(properties
		x 51
		y 119
		view 9807
		loop 3
	)

	(method (init)
		(self setPri: 199 ignoreActors: 1 cel: (if (IsFlag 127) 2 else 3))
		(super init: &rest)
	)
)

(instance ratingButton of Prop
	(properties
		x 247
		y 97
		view 9807
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 199 ignoreActors: 1 setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (and (IsFlag 63) (OneOf (PasswordFile hasPassword:) 2 3))
				(ClearFlag 63)
				(PasswordFile newPassword:)
				(ratingHilite cel: 2)
				(UpdateScreenItem ratingHilite)
				(if (not (IsFlag 145))
					((ScriptID 0 18) doVerb: 31 3 0) ; helpIcon
				)
			else
				(= local0 2)
				(chapInset dispose:)
			)
		)
	)
)

(instance ratingHilite of View
	(properties
		x 160
		y 118
		view 9807
		loop 4
	)

	(method (init)
		(self setPri: 199 ignoreActors: 1 cel: (if (IsFlag 63) 3 else 2))
		(super init: &rest)
	)
)

(instance moreButton of Prop
	(properties
		x 140
		y 56
		view 9807
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 199 ignoreActors: 1 setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= local0 5)
			(= local37 1)
			(controlPanelScr cue:)
		)
	)
)

(instance quitButton of Prop
	(properties
		x 247
		y 68
		view 9807
		loop 1
	)

	(method (init)
		(self setPri: 199 ignoreActors: 1 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= local0 1)
			(chapInset dispose:)
		)
	)
)

(instance playButton of Prop
	(properties
		x 25
		y 68
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= local0 0)
			(self dispose:)
			(FrameOut)
			(chapInset dispose:)
		)
	)
)

(instance saveButton of Prop
	(properties
		x 247
		y 41
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199)
		(if (not (IsFlag 145))
			(self setHotspot: 4 3) ; Do, Move
		)
		(super init:)
	)

	(method (doVerb)
		(if (and (not (IsFlag 145)) (localproc_0 self 1))
			(= local0 3)
			(self dispose:)
			(FrameOut)
			(chapInset dispose:)
		)
	)
)

(instance restoreButton of Prop
	(properties
		x 25
		y 41
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199)
		(if (not (IsFlag 145))
			(self setHotspot: 4 3) ; Do, Move
		)
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(= local0 4)
			(self dispose:)
			(FrameOut)
			(chapInset dispose:)
		)
	)
)

(instance marker of Actor
	(properties
		x 17
		y 21
		view 9807
		loop 2
	)

	(method (init &tmp temp0 temp1 temp2)
		(self ignoreActors: 1 setPri: 199)
		(super init:)
		(= x 17)
		(switch gChapter
			(1
				(= temp0 4)
				(if (IsFlag 93)
					(+= x temp0)
				)
				(if (IsFlag 94)
					(+= x temp0)
				)
				(if (gEgo has: 0) ; invLibKey
					(+= x temp0)
				)
				(if (IsFlag 14)
					(+= x temp0)
				)
				(if (IsFlag 158)
					(+= x temp0)
				)
				(if (IsFlag 159)
					(+= x temp0)
				)
				(if (IsFlag 39)
					(+= x temp0)
				)
			)
			(2
				(= x 53)
				(= temp0 8)
				(if (IsFlag 71)
					(+= x temp0)
				)
				(if (IsFlag 233)
					(+= x temp0)
				)
				(if (IsFlag 162)
					(+= x temp0)
				)
				(if (IsFlag 292)
					(+= x temp0)
				)
			)
			(3
				(= x 88)
				(= temp0 3)
				(if (IsFlag 164)
					(+= x temp0)
				)
				(if (gEgo has: 4) ; invPoker
					(+= x temp0)
				)
				(if (IsFlag 7)
					(+= x temp0)
				)
				(if (IsFlag 128)
					(+= x temp0)
				)
				(if (IsFlag 165)
					(+= x temp0)
				)
				(if (IsFlag 167)
					(+= x temp0)
				)
				(if (IsFlag 169)
					(+= x temp0)
				)
				(if (IsFlag 237)
					(+= x temp0)
				)
				(if (IsFlag 173)
					(+= x temp0)
				)
			)
			(4
				(= x 121)
				(= temp0 4)
				(if (not (IsFlag 180))
					(+= x temp0)
				)
				(if (IsFlag 176)
					(+= x temp0)
				)
				(if (IsFlag 153)
					(+= x temp0)
				)
				(if (IsFlag 316)
					(+= x temp0)
				)
				(if (IsFlag 262)
					(+= x temp0)
				)
				(if (IsFlag 187)
					(+= x temp0)
				)
				(if (IsFlag 189)
					(+= x temp0)
				)
				(if (IsFlag 203)
					(+= x temp0)
				)
			)
			(5
				(= x 158)
				(= temp0 9)
				(if (IsFlag 195)
					(+= x temp0)
				)
				(if (IsFlag 214)
					(+= x temp0)
				)
				(if (IsFlag 15)
					(+= x temp0)
				)
			)
			(6
				(= x 194)
				(= temp0 14)
				(if (IsFlag 218)
					(+= x temp0)
				)
				(if (IsFlag 206)
					(+= x temp0)
				)
			)
			(7
				(= x 230)
				(= temp0 3)
				(if (or (gEgo has: 10) (gEgo has: 19)) ; invBrooch, invCutter
					(+= x temp0)
				)
				(if (or (gEgo has: 14) (gEgo has: 15)) ; invCrucifix, invBeads
					(+= x temp0)
				)
				(if (gEgo has: 17) ; invXmasOrn
					(+= x temp0)
				)
				(if (IsFlag 227)
					(+= x temp0)
				)
				(if (gEgo has: 16) ; invSpellBook
					(+= x temp0)
				)
				(if (IsFlag 151)
					(+= x temp0)
				)
				(if (== gCurRoomNum 40100)
					(+= x temp0)
				)
				(if (IsFlag 212)
					(+= x temp0)
				)
				(if (and (IsFlag 212) (not (gEgo has: 16))) ; invSpellBook
					(+= x temp0)
					(+= x temp0)
				)
				(if (and (not (IsFlag 213)) (gEgo has: 18)) ; invStone
					(+= x temp0)
				)
				(if (IsFlag 219)
					(+= x temp0)
					(+= x temp0)
				)
				(if (IsFlag 224)
					(+= x temp0)
				)
			)
		)
		(= temp2 13)
		(while 1
			(if (>= (+= temp2 4) x)
				(break)
			)
			((= temp1 (View new:)) view: 9807 loop: 2 init: x: temp2 y: 21)
			(UpdateScreenItem temp1)
		)
	)
)

(instance testMusic of Sound
	(properties
		flags 1
		number 910
	)
)

(instance controlPanelScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 temp3)
		(switch (= state newState)
			(0
				(if (not local1)
					(= local1 (gUser input:))
					(= local2 (gUser controls:))
				)
				(= local0 0)
				(gNormalCursor view: 9960 loop: 0 cel: 1)
				(gGame setCursor: gNormalCursor 1)
				(gTheControlList eachElementDo: #enable 0)
				(gInventory eachElementDo: #enable 0)
				(gCurRoom setInset: chapInset self)
			)
			(1
				(if (!= local0 2)
					(FrameOut)
				)
				(switch local0
					(0
						(gGame handsOn:)
						(gUser input: local1 controls: local2)
						(= local1 0)
						(= local2 0)
					)
					(1
						(localproc_1)
						(if (not (IsFlag 145))
							(switch
								(Print
									addButton: 1 0 0 0 1 0 0 1 910 ; MISSING MESSAGE
									addButton: 2 0 0 0 2 0 18 1 910 ; MISSING MESSAGE
									addButton: 0 0 0 0 3 0 36 1 910 ; MISSING MESSAGE
									init:
								)
								(0
									(gGame handsOn:)
									(gUser input: local1 controls: local2)
									(= local1 0)
									(= local2 0)
								)
								(1
									(gGame save:)
									(global114 stop: 1)
									(Sounds eachElementDo: #stop)
									(gCurRoom newRoom: 91) ; saveRest
								)
								(2
									(global114 stop: 1)
									(Sounds eachElementDo: #stop)
									(gCurRoom newRoom: 91) ; saveRest
								)
							)
						else
							(if (Robot 6) ; Exists
								(Robot 10) ; Pause
							)
							(if (not (proc0_20))
								(if
									(and
										(Robot 6) ; Exists
										(not (IsFlag 297))
										(not local37)
									)
									(Robot 4) ; Play
								)
								(gGame handsOn:)
								(gUser input: local1 controls: local2)
								(= local1 0)
								(= local2 0)
							else
								(global114 stop: 1)
								(Sounds eachElementDo: #stop)
								(gSaveManager delete: (gSaveManager getCurrentSave:))
								(gCurRoom newRoom: 91) ; saveRest
							)
						)
					)
					(2
						(gGame handsOff:)
						((ScriptID 93 0) init: 0 2 local1 local2) ; getPassword
						(= temp2 (ScriptID 93 0)) ; getPassword
						(if (not (IsFlag 145))
							(switch (PasswordFile hasPassword:)
								(2
									((ScriptID 0 18) doVerb: 31 1 temp2) ; helpIcon
								)
								(3
									((ScriptID 0 18) doVerb: 32 1 temp2) ; helpIcon
								)
								(else
									((ScriptID 0 18) doVerb: 31 1 temp2) ; helpIcon
								)
							)
						else
							(temp2 cue:)
						)
					)
					(3
						(localproc_1)
						(if
							(Print
								addButton: 1 0 0 0 1 0 0 1 910 ; MISSING MESSAGE
								addButton: 0 0 0 0 3 0 18 1 910 ; MISSING MESSAGE
								init:
							)
							(gGame save:)
						)
						(gGame handsOn:)
						(gUser input: local1 controls: local2)
						(= local1 0)
						(= local2 0)
					)
					(4
						(localproc_1)
						(if
							(Print
								addButton: 1 0 0 0 6 0 0 1 910 ; MISSING MESSAGE
								addButton: 0 0 0 0 3 0 18 1 910 ; MISSING MESSAGE
								init:
							)
							(proc1111_6)
							(if gAutoRobot
								(proc1111_6 0 0)
							)
							(global114 stop: 1)
							(gGame restore: global124)
							(= global161 0)
							(= global162 1)
							(= global163 0)
						else
							(gGame handsOn:)
							(gUser input: local1 controls: local2)
							(= local1 0)
							(= local2 0)
						)
					)
					(5
						(gCurRoom setInset: chap2Inset)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance chap2Inset of Inset
	(properties
		picture -2
		view 9807
		loop 6
		x 0
		y 0
		priority 198
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 1 param4)
		(byeButton init:)
		(blackButton init:)
		(blackHilite init:)
		(titleBarButton init:)
		(titleBarHilite init:)
		(midiVolUp init:)
		(midiVolDown init:)
		(dacVolUp init:)
		(dacVolDown init:)
		(gammaUp init:)
		(gammaDown init:)
		(dacVolThermo init:)
		(midiVolThermo init:)
		(gammaThermo init:)
		(self drawInset:)
	)

	(method (handleEvent event)
		(cond
			((and inset (inset handleEvent: event)))
			((& (event type:) evVERB)
				(event claimed: 1)
				(self doVerb: (event message:))
			)
		)
		(event claimed:)
	)

	(method (doVerb)
		(gGame pragmaFail:)
	)

	(method (dispose)
		(= local37 0)
		(= local38 1)
		(if local33
			(local33 dispose:)
			(= local33 0)
		)
		(if local34
			(local34 dispose:)
			(= local34 0)
		)
		(super dispose: &rest)
	)
)

(instance byeButton of Prop
	(properties
		x 137
		y 62
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(gGame setScript: controlPanelScr)
		)
	)
)

(instance blackButton of Prop
	(properties
		x 225
		y 30
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (IsFlag 236)
				(ClearFlag 236)
				(blackHilite cel: 0)
			else
				(SetFlag 236)
				(blackHilite cel: 1)
			)
			(UpdateScreenItem blackHilite)
		)
	)
)

(instance blackHilite of View
	(properties
		x 249
		y 28
		view 9807
		loop 7
	)

	(method (init)
		(self setPri: 199 ignoreActors: 1 cel: (if (IsFlag 236) 1 else 0))
		(super init: &rest)
	)
)

(instance titleBarButton of Prop
	(properties
		x 13
		y 30
		view 9807
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(if (== (titleBarHilite cel:) 0)
				(SetWindowsOption 0 0)
				(titleBarHilite cel: 1)
			else
				(SetWindowsOption 0 1)
				(titleBarHilite cel: 0)
			)
			(UpdateScreenItem titleBarHilite)
		)
	)
)

(instance titleBarHilite of View
	(properties
		x 37
		y 28
		view 9807
		loop 7
	)

	(method (init)
		(self
			setPri: 199
			ignoreActors: 1
			cel: (if (GetWindowsOption 0) 0 else 1)
		)
		(super init: &rest)
	)
)

(instance midiVolUp of Prop
	(properties
		x 37
		y 108
		view 9807
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 2)
			(if (> (++ global187) 15)
				(= global187 15)
			)
			(DoSound sndMASTER_VOLUME global187)
			(midiVolThermo doit:)
		)
	)
)

(instance midiVolDown of Prop
	(properties
		x 19
		y 108
		view 9807
		cel 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 2)
			(if (< (-- global187) 0)
				(= global187 0)
			)
			(DoSound sndMASTER_VOLUME global187)
			(midiVolThermo doit:)
		)
	)
)

(instance dacVolUp of Prop
	(properties
		x 103
		y 108
		view 9807
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(if (localproc_0 self 2)
			(= temp0 (>> global188 $0003))
			(if (> (++ temp0) 15)
				(= temp0 15)
			)
			(DoAudio audVOLUME (= global188 (<< temp0 $0003)))
			(dacVolThermo doit:)
		)
	)
)

(instance dacVolDown of Prop
	(properties
		x 85
		y 108
		view 9807
		cel 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(if (localproc_0 self 2)
			(= temp0 (>> global188 $0003))
			(if (< (-- temp0) 0)
				(= temp0 0)
			)
			(DoAudio audVOLUME (= global188 (<< temp0 $0003)))
			(dacVolThermo doit:)
		)
	)
)

(instance gammaIndicator of Actor
	(properties)
)

(instance gammaUp of Prop
	(properties
		x 239
		y 108
		view 9807
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 2)
			(if (> (+= global189 2) 30)
				(= global189 30)
			)
			(gammaThermo doit:)
		)
	)
)

(instance gammaDown of Prop
	(properties
		x 220
		y 108
		view 9807
		cel 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 199 setHotspot: 4 3) ; Do, Move
		(super init:)
	)

	(method (doVerb)
		(if (localproc_0 self 2)
			(if (< (-= global189 2) -30)
				(= global189 -30)
			)
			(gammaThermo doit:)
		)
	)
)

(instance dacVolThermo of Code
	(properties)

	(method (init &tmp temp0 temp1)
		(if (not local33)
			(= local33 (List new:))
		)
		(if global188
			(for ((= temp0 0)) (< temp0 (>> global188 $0003)) ((++ temp0))
				((= temp1 (Actor new:))
					view: 9807
					loop: 2
					cel: 0
					y: 92
					x: [local3 temp0]
					init:
				)
				(local33 addToFront: temp1)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(cond
			((> (= temp1 (local33 size:)) (>> global188 $0003))
				(= temp2 (KList 8 (local33 first:))) ; NodeValue
				(local33 delete: temp2)
				(temp2 dispose:)
			)
			((and global188 (< temp1 15))
				((= temp0 (Actor new:))
					view: 9807
					loop: 2
					cel: 0
					y: 92
					x: [local3 (- (>> global188 $0003) 1)]
					init:
				)
				(local33 addToFront: temp0)
			)
		)
	)
)

(instance midiVolThermo of Code
	(properties)

	(method (init &tmp temp0 temp1)
		(if (not local34)
			(= local34 (List new:))
		)
		(if global187
			(for ((= temp0 0)) (< temp0 global187) ((++ temp0))
				((= temp1 (Actor new:))
					view: 9807
					loop: 2
					cel: 0
					y: 92
					x: [local18 temp0]
					init:
				)
				(local34 addToFront: temp1)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(cond
			((> (= temp2 (local34 size:)) global187)
				(= temp3 (KList 8 (local34 first:))) ; NodeValue
				(local34 delete: temp3)
				(temp3 dispose:)
			)
			((and global187 (< temp2 15))
				((= temp0 (Actor new:))
					view: 9807
					loop: 2
					cel: 0
					y: 92
					x: [local18 (- global187 1)]
					init:
				)
				(local34 addToFront: temp0)
			)
		)
	)
)

(instance gammaThermo of Code
	(properties)

	(method (init)
		(gammaIndicator
			view: 9807
			loop: 2
			cel: 0
			y: 92
			x: (+ 235 global189)
			init:
		)
	)

	(method (doit)
		(gammaIndicator x: (+ 235 global189))
	)
)

