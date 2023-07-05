;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Interface)
(use DButton)
(use PanelPlane)
(use Cursor)
(use Sound)
(use System)

(public
	MunichMapRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(switch gChapter
		(1
			(SetFlag 23)
			(SetFlag 28)
			(if
				(and
					(IsFlag 411)
					(IsFlag 412)
					(IsFlag 830)
					(IsFlag 851)
					(gEgo has: 2) ; invUbergrauLetter
				)
				(= local0 1)
			)
			(if (and (gEgo has: 13) (IsFlag 432)) ; invKlingmannReceipt
				(= local1 1)
			)
			(if (IsFlag 30)
				(= local4 1)
			)
		)
		(3
			(SetFlag 23)
			(SetFlag 28)
			(SetFlag 24)
			(SetFlag 26)
			(SetFlag 27)
			(= local1 1)
			(if
				(and
					(IsFlag 533)
					(IsFlag 241)
					(IsFlag 411)
					(IsFlag 546)
				)
				(= local0 1)
			)
			(if (IsFlag 50)
				(= local6 1)
			)
			(if (and (IsFlag 515) (IsFlag 968))
				(= local4 1)
			)
		)
		(5
			(SetFlag 23)
			(SetFlag 28)
			(SetFlag 24)
			(SetFlag 26)
			(SetFlag 27)
			(SetFlag 29)
			(= local1 1)
			(= local0 1)
			(= local6 1)
			(if (gEgo has: 48) ; invLedgerPage
				(= local4 1)
			)
			(if (gEgo has: 55) ; invWolfTags
				(= local2 1)
			)
		)
	)
)

(instance subwaySound of Sound
	(properties
		number 200
	)
)

(instance subwaySound2 of Sound
	(properties
		number 202
	)
)

(instance subwayStop of Sound
	(properties
		number 201
	)
)

(class MapButton of DButton
	(properties
		modNum 0
		view 199
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (BAD_SELECTOR))

	(method (BAD_SELECTOR))

	(method (doit)
		(if (== (GKHotCursor BAD_SELECTOR:) self)
			(self BAD_SELECTOR: 1)
			(= BAD_SELECTOR 0)
			(gTopMessage BAD_SELECTOR: modNum noun 0)
		else
			(if (not BAD_SELECTOR)
				(self BAD_SELECTOR:)
				(= BAD_SELECTOR 1)
			)
			(if (not (gCurRoom BAD_SELECTOR:))
				(self BAD_SELECTOR: 0)
				(if BAD_SELECTOR
					(self hilite: 1)
				)
			)
		)
	)

	(method (BAD_SELECTOR param1)
		(= BAD_SELECTOR param1)
	)

	(method (init param1 param2 param3)
		(super init: &rest)
		(if (gGk2Music handle:)
			(gGk2Music client: 0 stop:)
		)
		(if (gGk2Sound handle:)
			(gGk2Sound client: 0 stop:)
		)
		(self moveTo: param2 param3)
		(UpdateScreenItem self)
		(if (not (IsFlag param1))
			(GKHotCursor delete: self)
			(^= state $0001)
			(= BAD_SELECTOR 0)
			(self hilite: 0)
		else
			(= BAD_SELECTOR 1)
			(self hilite: 1)
		)
		(return self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= temp1 (event type:)) evKEYBOARD)
						(== (event message:) key)
					)
					(and (& temp1 evMOUSEBUTTON) (self onMe: event))
				)
			)
			(event claimed: 1)
			(= temp0 (self track: event))
		)
		(if temp0
			(self BAD_SELECTOR:)
		)
	)

	(method (track param1 &tmp temp0 temp1)
		(= temp0 0)
		(if (& $0001 (param1 type:))
			(= temp1 0)
			(repeat
				(= param1 (Event new: 32768))
				(param1 localize: plane)
				(if (!= (= temp0 (self onMe: param1)) temp1)
					(if temp0
						(= cel 2)
						(++ textTop)
						(++ textBottom)
					else
						(= cel 0)
						(-- textTop)
						(-- textBottom)
					)
					(self draw:)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(-- textTop)
				(-- textBottom)
			)
			(self hilite: (& state $0008))
			(return (if temp0 self else 0))
		else
			(return self)
		)
	)
)

(class MapRoom of GK2Room
	(properties
		picture 200
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (BAD_SELECTOR)
		(^= BAD_SELECTOR $0001)
		(if BAD_SELECTOR
			(mapText init: (ScriptID 0 8)) ; bottomPlane
			(BAD_SELECTOR eachElementDo: #BAD_SELECTOR)
		else
			((((ScriptID 0 8) casts:) at: 0) delete: mapText) ; bottomPlane
			(mapText dispose:)
		)
	)

	(method (init &tmp [temp0 2])
		(if (IsFlag 530)
			(SetFlag 549)
		)
		(= BAD_SELECTOR 0)
		(super init: &rest)
		(proc11_13)
		(BAD_SELECTOR init:)
		((gInterfacePlane BAD_SELECTOR:) delete: (ScriptID 0 4)) ; inventoryButton
		((gInterfacePlane BAD_SELECTOR:) delete: (ScriptID 0 4)) ; inventoryButton
		((ScriptID 0 4) dispose:) ; inventoryButton
		((ScriptID 0 6) init: gInterfacePlane 1 1) ; mapHintButton
		(if (or (< gChapter 5) (and (== gChapter 5) (gEgo has: 6))) ; invTapeRecorder
			((ScriptID 0 5) mask:) ; recButton
		)
		((ScriptID 0 7) mask:) ; movieButton
	)

	(method (doit)
		(if (not (GKHotCursor BAD_SELECTOR:))
			(gTopMessage BAD_SELECTOR: 0)
		)
		(super doit: &rest)
	)

	(method (dispose)
		((gInterfacePlane BAD_SELECTOR:) delete: (ScriptID 0 6)) ; mapHintButton
		((gInterfacePlane BAD_SELECTOR:) delete: (ScriptID 0 6)) ; mapHintButton
		(if (or (< gChapter 5) (and (== gChapter 5) (gEgo has: 6))) ; invTapeRecorder
			((ScriptID 0 5) mask: 0) ; recButton
		)
		(if (mapText plane:)
			((((ScriptID 0 8) casts:) at: 0) delete: mapText) ; bottomPlane
			(mapText dispose:)
		)
		((ScriptID 0 7) mask: 0) ; movieButton
		((ScriptID 0 6) dispose:) ; mapHintButton
		((ScriptID 0 4) init: gInterfacePlane 1 1) ; inventoryButton
		(BAD_SELECTOR release: dispose:)
		(super dispose: &rest)
	)
)

(instance mapText of PanelText
	(properties
		x 55
		y 5
		fore 13
		back 1
		skip 1
		width 200
		height 28
	)

	(method (init)
		(if (== (gGame printLang:) 351)
			(= width 300)
		)
		(super init: &rest)
		(self BAD_SELECTOR: 0 19 0 0 1)
	)
)

(instance buttonList of List
	(properties)

	(method (init)
		(if (IsFlag 23)
			(self add: (Farm init: 23 141 232))
		)
		(if (IsFlag 24)
			(self add: (Zoo init: 24 284 287))
		)
		(if (IsFlag 22)
			(self add: (Dorn init: 22 15 259))
		)
		(if (IsFlag 26)
			(self add: (Lab init: 26 421 105))
		)
		(if (IsFlag 27)
			(self add: (Police init: 27 503 100))
		)
		(if (IsFlag 28)
			(self add: (Marien init: 28 382 188))
		)
		(if (IsFlag 29)
			(self add: (VonGlower init: 29 548 248))
		)
		(super init: &rest)
	)
)

(instance MunichMapRm of MapRoom
	(properties
		modNum 200
	)

	(method (init)
		(localproc_0)
		(= BAD_SELECTOR buttonList)
		(super init: &rest)
		(Load 140 201) ; WAVE
		(soundScript init:)
		(self setScript: sFlashEm)
	)
)

(instance Farm of MapButton
	(properties
		noun 12
		modNum 200
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 220) ; farmFldRm
			(= loop 12)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local0))
	)

	(method (BAD_SELECTOR)
		(if (== gChapter 5)
			(gMessager say: 20 62 0 0 0 200) ; "(PICKUP, TRY TO RETURN TO FARM CH 5)I don't need to go back to the Huber's place right now."
		else
			(gCurRoom setScript: exitScript 0 self)
		)
	)
)

(instance Zoo of MapButton
	(properties
		noun 13
		modNum 200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 230) ; hellZooRm
			(= loop 13)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local1))
	)

	(method (BAD_SELECTOR)
		(switch gChapter
			(1
				(gCurRoom setScript: exitScript 0 self)
			)
			(3
				(if (IsFlag 504)
					(gMessager say: 6 62) ; "(TRY TO GO TO ZOO AFTER CH 3 CLUB MTG STARTS)It's past the zoo's closing time."
				else
					(gCurRoom setScript: exitScript 0 self)
				)
			)
			(5
				(gMessager say: 22 62) ; "(TRY TO RETURN TO POLICE STATION AFTER FINK, CH 1)No point in goin' back in there at the moment."
			)
		)
	)
)

(instance Dorn of MapButton
	(properties
		noun 14
		modNum 200
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 250) ; dornExtRm
			(= loop 11)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local2))
	)

	(method (BAD_SELECTOR)
		(gCurRoom setScript: exitScript 0 self)
	)
)

(instance Grossburg of MapButton
	(properties
		noun 15
		modNum 200
		loop 3
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 350) ; grossExtRm
			(= loop 14)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local3))
	)

	(method (BAD_SELECTOR)
		(gCurRoom setScript: exitScript 0 self)
	)
)

(instance Lab of MapButton
	(properties
		noun 16
		modNum 200
		loop 4
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 300) ; labRm
			(= loop 15)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not (IsFlag 426)))
	)

	(method (BAD_SELECTOR)
		(if (IsFlag 426)
			(gMessager say: 11 62) ; "(TRY TO RETURN TO LAB AFTER FINISHED)I don't need to do anythin' else at the lab."
		else
			(gCurRoom setScript: exitScript 0 self)
		)
	)
)

(instance Police of MapButton
	(properties
		noun 17
		modNum 200
		loop 5
	)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 320 310 3212) ; leberRm, policeRm
			(= loop 16)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local4))
	)

	(method (BAD_SELECTOR)
		(switch gChapter
			(1
				(if (IsFlag 30)
					(gMessager say: 9 62) ; "(TRY TO RETURN TO POLICE STATION AFTER FINK, CH 1)No point in goin' back in there at the moment. I can't even try to talk my way in."
				else
					(SetFlag 30)
					(gCurRoom setScript: exitScript 0 self)
				)
			)
			(3
				(cond
					((and (IsFlag 518) (IsFlag 515) (gEgo has: 34)) ; invGrosPhoneNumber
						(gMessager say: 5 62) ; "(TRY TO GO TO POLICE STATION AFTER CH 3 CLUB MTG STARTS)The police station is closed."
					)
					((IsFlag 530)
						(gCurRoom setScript: exitScript 0 self)
					)
					(else
						(gMessager say: 9 62) ; "(TRY TO RETURN TO POLICE STATION AFTER FINK, CH 1)No point in goin' back in there at the moment. I can't even try to talk my way in."
					)
				)
			)
			(5
				(if (gEgo has: 48) ; invLedgerPage
					(gMessager say: 1 62) ; "(TRY TO GO TO LEBER'S OFFICE AFTER TRICKING HIM, SLY AT END)I don't want to talk to Leber. Besides, he's probably out looking for 'The Friendly Wanderer' club."
				else
					(gCurRoom setScript: exitScript 0 self)
				)
			)
		)
	)
)

(instance Marien of MapButton
	(properties
		noun 18
		modNum 200
		loop 6
	)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 4001 400) ; marienRm
			(= loop 17)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local5))
	)

	(method (BAD_SELECTOR)
		(if (== gPrevRoomNum 4001)
			(gCurRoom setScript: exitScript 0 self)
		else
			(gCurRoom setScript: exitScript 0 self)
		)
	)
)

(instance VonGlower of MapButton
	(properties
		noun 19
		modNum 200
		loop 7
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 330) ; vgHouseRm
			(= loop 18)
		)
		(return self)
	)

	(method (BAD_SELECTOR)
		(self BAD_SELECTOR: (not local6))
	)

	(method (BAD_SELECTOR)
		(switch gChapter
			(3
				(cond
					((IsFlag 504)
						(gMessager say: 8 62) ; "(TRY TO GO TO VON GLOWER'S HOUSE AFTER CH 3 CLUB MTG STARTS)Von Glower's at the club."
					)
					((IsFlag 50)
						(gMessager say: 7 62) ; "(TRY TO GO TO VON GLOWERS HOUSE AFTER FINISHED DIALOGUE)I don't want to bother the Baron again."
					)
					(else
						(gCurRoom setScript: exitScript 0 self)
					)
				)
			)
			(5
				(gMessager say: 2 62) ; "(AFTER DETTA SCENE)Just thinking about von Glower's place gives me a hang-over. I'll see him this afternoon."
			)
		)
	)
)

(instance sFlashEm of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 (buttonList size:)) ((++ temp0))
					(= temp1 (buttonList at: temp0))
					(if (temp1 BAD_SELECTOR:)
						(temp1 hilite: 0)
					)
				)
				(= ticks 15)
			)
			(1
				(for ((= temp0 0)) (< temp0 (buttonList size:)) ((++ temp0))
					(if ((buttonList at: temp0) BAD_SELECTOR:)
						((buttonList at: temp0) hilite: 1 BAD_SELECTOR:)
					)
				)
				(= ticks 15)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(Lock 140 200 0) ; WAVE
		(Lock 140 202 0) ; WAVE
		(subwaySound client: 0 stop:)
		(subwaySound2 client: 0 stop:)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock 140 200 1) ; WAVE
				(subwaySound loop: 1 play: 63 self)
			)
			(1
				(Lock 140 200 0) ; WAVE
				(Lock 140 202 1) ; WAVE
				(subwaySound2 loop: 1 play: 63 self)
			)
			(2
				(Lock 140 202 0) ; WAVE
				(self changeState: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (== (self state:) 0))
			(subwayStop client: 0 stop:)
			(event claimed: 1)
			(self cue:)
		)
		(super handleEvent: event)
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) add: self)
	)

	(method (dispose)
		((gUser BAD_SELECTOR:) delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Lock 140 200 0) ; WAVE
				(soundScript dispose:)
				(subwayStop loop: 1 number: 201 play: 63 self)
			)
			(1
				(switch register
					(Farm
						(if (mapText plane:)
							((((ScriptID 0 8) casts:) at: 0) delete: mapText) ; bottomPlane
							(mapText dispose:)
						)
						(PlayScene 1016 0 220) ; farmFldRm
					)
					(Zoo
						(gCurRoom newRoom: 230) ; hellZooRm
					)
					(Dorn
						(gCurRoom newRoom: 250) ; dornExtRm
					)
					(Grossburg
						(gCurRoom newRoom: 350) ; grossExtRm
					)
					(Lab
						(gCurRoom newRoom: 300) ; labRm
					)
					(Police
						(switch gChapter
							(1
								(gCurRoom newRoom: 310) ; policeRm
							)
							(else
								(gCurRoom newRoom: 320) ; leberRm
							)
						)
					)
					(Marien
						(if (== gPrevRoomNum 4001)
							(gCurRoom newRoom: 4002)
						else
							(gCurRoom newRoom: 400) ; marienRm
						)
					)
					(VonGlower
						(gCurRoom newRoom: 330) ; vgHouseRm
					)
				)
			)
		)
	)
)

