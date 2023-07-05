;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use RobotPlayer)
(use LightInv)
(use Array)
(use PanelPlane)
(use Polygon)
(use Cursor)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	pplPhone 0
	pLittleLight 1
	pplPoster 2
	pplBox 3
	pplPoster2 4
	pplDeskDrawer 5
	pplTableDrawer 6
	pplJournal 7
	sPlayMessages 8
)

(instance pfJournalLeftPage of PanelFeature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(self onMe: event)
					(!= gTheCursor leftCursor)
					(!= (rJournal curFrame:) 0)
				)
				(gGame setCursor: leftCursor)
			)
			(
				(and
					(self onMe: event)
					(== (rJournal curFrame:) 0)
					(!= gTheCursor gNormalCursor)
				)
				(gGame normalizeCursor:)
			)
			(
				(and
					(self onMe: event)
					(== (rJournal curFrame:) 0)
					(== gTheCursor gNormalCursor)
					(& (event type:) evMOUSEBUTTON)
				)
				(event claimed: 1)
				(pplJournal dispose:)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (!= (rJournal curFrame:) 0)
					(gGame handsOff:)
					(localSound number: (+ 52 (Random 0 2)) play:)
					(if (> (rJournal curFrame:) 7)
						(rJournal
							caller: pplJournal
							cycleTo: (- (rJournal curFrame:) 10) 2 40
						)
					else
						(rJournal caller: pplJournal cycleTo: 0 2 40)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self createPoly: 102 73 280 73 319 81 321 422 93 418)
		(super init: &rest)
	)
)

(instance pfJournalRightPage of PanelFeature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(self onMe: event)
					(!= gTheCursor rightCursor)
					(< (rJournal curFrame:) 87)
				)
				(gGame setCursor: rightCursor)
			)
			(
				(and
					(self onMe: event)
					(== (rJournal curFrame:) 87)
					(!= gTheCursor gNormalCursor)
				)
				(gGame normalizeCursor:)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (< (rJournal curFrame:) 87)
					(gGame handsOff:)
					(localSound number: (+ 52 (Random 0 2)) play:)
					(if (> (rJournal curFrame:) 0)
						(rJournal
							caller: pplJournal
							cycleTo: (+ (rJournal curFrame:) 10) 1 40 0
						)
					else
						(rJournal
							caller: pplJournal
							startFrame: 0
							cycleTo: 7 1 40
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self createPoly: 319 81 356 73 541 73 551 420 321 422)
		(super init: &rest)
	)
)

(instance pplJournal of PanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(not (pfJournalLeftPage onMe: event))
				(not (pfJournalRightPage onMe: event))
				(!= gTheCursor gNormalCursor)
			)
			(gGame normalizeCursor:)
		)
		(if
			(and
				(self onMe: event)
				(not (pfJournalLeftPage onMe: event))
				(not (pfJournalRightPage onMe: event))
				(& (event type:) evMOUSEBUTTON)
			)
			(event claimed: 1)
			(self dispose:)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(PlInterface dispose:)
		(= picture -1)
		(= priority (+ (GetHighPlanePri) 1))
		(SetFlag 28)
		(DoRobot)
		(super init: 0 0 640 480)
		(rJournal init: 4042 0 0 0 -1 self)
		(pfJournalLeftPage init: self 1 1)
		(pfJournalRightPage init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(PlInterface init:)
		(rJournal dispose:)
		(if (IsFlag 12)
			(proc0_9 23 0 0)
		else
			(proc0_9 28 0 0)
		)
		(if (and (IsFlag 28) (IsFlag 29))
			(if (== gCurRoomNum 22)
				((ScriptID 1 3) newRoom: 24) ; exitLeft
			else
				((ScriptID 1 3) newRoom: 22) ; exitLeft
			)
		)
		(pplDeskDrawer init: 1)
		(super dispose: &rest)
	)
)

(instance pplTableDrawer of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppTableDrawer cel:)
				(not (event claimed:))
			)
			(event claimed: 1)
			(gGame handsOff:)
			(localSound number: 56 play:)
			(if (not (gEgo has: (ScriptID 9 8))) ; invCarKeys
				(ppInsideTableDrawer dispose: pplTableDrawer 1 1)
			)
			(ppTableDrawer setCycle: Beg self)
			(pfKeysDrawer dispose: InsetPanelPlane 1 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self setBitmap: 54 7 0)
		(global105 delete: (bitmap approachX:))
		(ppTableDrawer cel: 0 init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplDeskDrawer of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppDeskDrawer cel:)
				(not (event claimed:))
			)
			(event claimed: 1)
			(gGame handsOff:)
			(localSound number: 38 play:)
			(ppDeskDrawer setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init param1)
		(super init: &rest)
		(self setBitmap: 58 1 0)
		(global105 delete: (bitmap approachX:))
		(if (not argc)
			(ppDeskDrawer cel: 0)
		)
		(ppDeskDrawer init: self 1 1 setPri: (+ (self priority:) 1))
		(if (or argc (ppDeskDrawer cel:))
			(pfJournal init: pplDeskDrawer)
			(pfDrawerHandle init: pplDeskDrawer)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplPhone of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 52 2 0)
		(global105 delete: (bitmap approachX:))
		(ppBigLight setPri: (+ (self priority:) 1) init: self 1 1)
		(ppMsgButton init: self 1 1)
		(ppLeftArrow init: self 1 1)
		(ppRightArrow init: self 1 1)
	)

	(method (dispose)
		(soundEffect stop:)
		(gMessager caller: 0 dispose:)
		(if (and (IsFlag 28) (IsFlag 29))
			(if (== gCurRoomNum 22)
				((ScriptID 1 3) newRoom: 24) ; exitLeft
			else
				((ScriptID 1 3) newRoom: 22) ; exitLeft
			)
		)
		(if (not (IsFlag 29))
			(pLittleLight setCycle: Fwd)
		else
			(pLittleLight setCycle: 0 setCel: 0)
		)
		(super dispose: &rest)
	)
)

(instance pplPoster of PanelPlane
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: event))
					(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				)
				(event claimed: 1)
				(self dispose:)
			)
			((and (not (self onMe: event)) (not ((ScriptID 9 1) onMe: event))) ; PlInterface
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 245 187)
		(self setBitmap: 35 0 0)
		(global105 delete: (bitmap approachX:))
	)
)

(instance pplPoster2 of PanelPlane
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: event))
					(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				)
				(event claimed: 1)
				(self dispose:)
			)
			((and (not (self onMe: event)) (not ((ScriptID 9 1) onMe: event))) ; PlInterface
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 106 277)
		(self setBitmap: 35 1 0)
		(global105 delete: (bitmap approachX:))
	)
)

(instance pplBox of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppBigbox cel:)
				(not (event claimed:))
			)
			(event claimed: 1)
			(gGame handsOff:)
			(ppBigbox setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self setBitmap: 50 0 0)
		(global105 delete: (bitmap approachX:))
		(ppBigbox init: self 1 1)
	)

	(method (cue)
		(localSound number: 36 play:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance ppDeskDrawer of PanelProp
	(properties
		cycleSpeed 4
		view 58
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (not cel)
			(gGame handsOff:)
			(self setCycle: End self)
			(localSound number: 37 play:)
			(pfJournal init: pplDeskDrawer)
			(pfDrawerHandle init: pplDeskDrawer)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppTableDrawer of PanelProp
	(properties
		y 1
		view 54
		z 1
	)

	(method (init)
		(super init: &rest)
		(if cel
			(switch global210
				(0
					(self setLoop: 0)
				)
				(3
					(self setLoop: 3)
				)
				(4
					(self setLoop: 4)
				)
				(5
					(self setLoop: 5)
				)
			)
			(pfKeysDrawer init: InsetPanelPlane)
		else
			(self setLoop: 6)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (not cel)
			(gGame handsOff:)
			(localSound number: 55 play:)
			(self setScript: sCycleForward self)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(if (and cel (not (gInventory contains: (ScriptID 9 8)))) ; invCarKeys
			(ppInsideTableDrawer init: pplTableDrawer 1 1)
		)
		(gGame handsOn:)
	)
)

(instance ppInsideTableDrawer of PanelProp
	(properties
		y 2
		loop 1
		view 54
		z 2
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (OneOf global210 0 4)
					(gGame handsOff:)
					(self setCycle: End self)
				else
					(= global210 5)
					(ppTableDrawer setLoop: 5)
					(UpdateScreenItem ppTableDrawer)
					(gInventory addItem: (ScriptID 9 8)) ; invCarKeys
					(localSound number: 31 play:)
					(self dispose: pplTableDrawer 1 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (== loop 1)
			(self setLoop: 2 setCel: 0)
			(= global210 4)
		else
			(= global210 3)
		)
		(ppTableDrawer setLoop: global210)
		(UpdateScreenItem ppTableDrawer)
		(gGame handsOn:)
	)
)

(instance ppBigLight of PanelProp
	(properties
		x 84
		y 159
		cycleSpeed 24
		loop 6
		view 52
	)

	(method (cue)
		(if (not (IsFlag 29))
			(sPlayMessages cue:)
		else
			(ppMsgButton setScript: 0)
		)
	)

	(method (init)
		(super init: &rest)
		(pLittleLight setCycle: 0)
		(if (not (IsFlag 29))
			(self setCycle: Fwd)
		)
		(approachX hotVerbs: 5)
	)
)

(instance ppMsgButton of PanelProp
	(properties
		x 99
		y 159
		loop 3
		view 52
	)

	(method (cue)
		(if (!= (sPlayMessages start:) 3)
			(self setScript: sPlayMessages)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (and (gUser canInput:) (not (self script:)))
				(ppBigLight setCycle: 0 setCel: 1)
				(self setScript: (ScriptID 0 3) self) ; sDepress
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(sPlayMessages start: 0)
		(self setScript: 0)
		(sPlayMessages state: -1)
		(super dispose: &rest)
	)
)

(instance ppLeftArrow of PanelProp
	(properties
		x 84
		y 177
		loop 4
		view 52
	)

	(method (cue)
		(if (!= (sPlayMessages state:) -1)
			(gNarrator dispose: 1)
			(self setScript: sRewind)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (gUser canInput:)
				(self setScript: (ScriptID 0 3) self) ; sDepress
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ppRightArrow of PanelProp
	(properties
		x 123
		y 177
		loop 5
		view 52
	)

	(method (cue)
		(if
			(or
				(!= (sPlayMessages state:) 2)
				(and (== (sPlayMessages state:) 2) (ppMsgButton script:))
			)
			(gNarrator dispose: 1)
			(self setScript: sFastForward)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (gUser canInput:)
				(self setScript: (ScriptID 0 3) self) ; sDepress
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ppBigbox of PanelProp
	(properties
		cycleSpeed 4
		loop 1
		view 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 5 104 20 73 41 55 54 52 196 89 164 199 140 199 23 152
					yourself:
				)
		)
		(if (IsFlag 136)
			(self setLoop: 2)
		else
			(self setLoop: 1)
		)
		(super init: &rest)
		(self setPri: (+ (pplBox priority:) 1))
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if cel
				(if (not (IsFlag 136))
					(pfLighter dispose:)
				)
				(self
					setPolygon:
						((Polygon new:)
							init: 5 104 20 73 41 55 54 52 196 89 164 199 140 199 23 152
							yourself:
						)
				)
				(self setCycle: Beg self)
			else
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 57 65 191 105 199 78 199 9 157 1 57 1
							yourself:
						)
				)
				(if (not (IsFlag 136))
					(pfLighter init: pplBox)
				)
				(localSound number: 35 play:)
				(self setCycle: End self)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(if (not cel)
			(localSound number: 36 play:)
		)
		(gGame handsOn:)
	)
)

(instance pfJournal of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 67 112 89 162 134 160 157 154 123 104 70 108)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplDeskDrawer dispose:)
				(pplJournal init:)
			)
		)
	)
)

(instance pfDrawerHandle of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 9 169 198 155 198 183 16 197)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(localSound number: 38 play:)
				(ppDeskDrawer setCycle: Beg pplDeskDrawer)
				(pfJournal dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pfLighter of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 69 131 110 146 118 141 120 134 91 105 74 107 59 120)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory addItem: (ScriptID 9 5)) ; invLighter
				(SetFlag 136)
				(ppBigbox setLoop: 2)
				(soundEffect number: 4001 play:)
				(self dispose:)
			)
		)
	)
)

(instance pLittleLight of Prop
	(properties
		cycleSpeed 24
		view 52
	)

	(method (doit)
		(if (gPanels contains: pplPhone)
			(if (ppBigLight cel:)
				(self setCel: 0)
			else
				(self setCel: 1)
			)
		)
		(super doit: &rest)
	)

	(method (init)
		(if (== gCurRoomNum 20)
			(= loop 1)
		else
			(= loop 0)
		)
		(super init: &rest)
		(if (not (IsFlag 29))
			(self setCycle: Fwd)
		)
	)
)

(instance sCycleBackward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ppTableDrawer setCycle: Beg self)
			)
			(1
				(ppTableDrawer setLoop: 6 setCel: 4 setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sCycleForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ppTableDrawer setCycle: End self)
			)
			(1
				(switch global210
					(0
						(ppTableDrawer setLoop: 0)
					)
					(3
						(ppTableDrawer setLoop: 3)
					)
					(4
						(ppTableDrawer setLoop: 4)
					)
					(5
						(ppTableDrawer setLoop: 5)
					)
				)
				(ppTableDrawer setCel: 0 setCycle: End self)
				(pfKeysDrawer init: pplTableDrawer)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sPlayMessages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= start 1)
				(gMessager say: 1 0 0 0 ppBigLight 3) ; "Hello, dear, it's your mother. It seems like we never hear from you anymore! Don't worry, your father and I are fine. When you get tired of living in that damp, chilly house, your room at home is still waiting for you! Make sure you're taking your vitamins and using that nice umbrella Aunt Selma gave you last Christmas. I love you! Bye!"
			)
			(1
				(= start 2)
				(gMessager say: 2 0 0 0 ppBigLight 3) ; "(GRUFFLY) Hello. Remember me? Your editor? You're not answering your calls, are you? I'm getting tired of talking to a machine! I thought you'd be home writing but apparently you're not. You know I can't send you out that advance until I actuall see some of that story you're working on! Call me back! (LOUD HANG UP)"
			)
			(2
				(= start 3)
				(msgStinger play:)
				(gMessager say: 35 0 0 0 ppBigLight 330) ; "This is Jeremiah Krick. Something has happened... something horrible! I have to leave immediately! I don't know how long I'll be gone... Amanda is here at the lighthouse. I don't want to leave her alone... Please come right away. If you don't hear from me soon, it will mean that I have failed, and then?! God, I just can't think of that now! There is no time... I have no choice... Please, you're the only one who can help me! Come now!"
				(SetFlag 29)
				(if (and (IsFlag 28) (IsFlag 29))
					((ScriptID 1 3) newRoom: 24) ; exitLeft
				)
			)
		)
	)
)

(instance sFastForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(soundEffect stop: number: (+ (Random 0 1) 44) play: self)
				(gMessager caller: 0 dispose:)
				(= register (sPlayMessages state:))
				(sPlayMessages dispose:)
			)
			(1
				(switch register
					(-1
						(sPlayMessages start: 1)
						(gUser canInput: 1)
						(ppBigLight setCycle: 0 setCel: 1)
						(ppMsgButton setScript: sPlayMessages)
					)
					(0
						(sPlayMessages start: 1)
						(gUser canInput: 1)
						(ppBigLight setCycle: 0 setCel: 1)
						(ppMsgButton setScript: sPlayMessages)
					)
					(1
						(sPlayMessages start: 2)
						(gUser canInput: 1)
						(ppBigLight setCycle: 0 setCel: 1)
						(ppMsgButton setScript: sPlayMessages)
					)
					(else
						(ppBigLight setCycle: 0 setCel: 1)
						(gUser canInput: 1)
					)
				)
			)
		)
	)
)

(instance sRewind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(soundEffect stop: number: 24 play: self)
				(gMessager caller: 0 dispose:)
				(= register (sPlayMessages state:))
				(sPlayMessages dispose:)
			)
			(1
				(sPlayMessages start: 0)
				(gUser canInput: 1)
				(ppMsgButton setScript: sPlayMessages)
			)
		)
	)
)

(instance soundEffect of Sound
	(properties)
)

(instance msgStinger of Sound
	(properties
		number 17004
	)
)

(instance localSound of Sound
	(properties
		loop 0
	)
)

(instance rightCursor of Cursor
	(properties
		view 1100
	)
)

(instance leftCursor of Cursor
	(properties
		loop 1
		view 1100
	)
)

(instance rJournal of RobotPlayer
	(properties)

	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= param5 -1)
		(= number param1)
		(if (< argc 5)
			(= param6 gThePlane)
		)
		(= x param3)
		(= y param4)
		(= curFrame param2)
		(Robot 0 param1 param6 param5 param3 param4) ; Open
		(Robot 1 param2) ; DisplayFrame
		(FrameOut)
		(= temp0 (IntArray new: 14))
		(= end (= maxFrame (- (Robot 2 (temp0 data:)) 1))) ; FrameInfo
		(temp0 dispose:)
		(= global208 self)
	)
)

(instance pfKeysDrawer of PanelFeature
	(properties
		x 72
		y 146
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 14 122 25 155 58 175 77 179 125 181 131 134 87 134 61 130 40 121 21 111
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (ppTableDrawer cel:)
			(if (not (gInventory contains: (ScriptID 9 8))) ; invCarKeys
				(ppInsideTableDrawer dispose: pplTableDrawer 1 1)
			)
			(localSound number: 56 play:)
			(ppTableDrawer setScript: sCycleBackward ppTableDrawer)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

