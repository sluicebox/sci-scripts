;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Polygon)
(use Feature)
(use Timer)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
)

(instance rm320 of PQRoom
	(properties
		picture 320
		infoRoomSignal 72
	)

	(method (init)
		(= global108 1)
		(SetFlag 15)
		(SetFlag 12)
		(= global114 myShootCode)
		(SetFlag 110)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 300 315)
			((ScriptID 19 2) doit: 14 1) ; addToInv
		)
		(cond
			((and (IsFlag 24) (not (IsFlag 123)))
				(SetFlag 123)
				(self setScript: passedQual)
			)
			((IsFlag 82)
				(self setScript: failedQual)
			)
			((IsFlag 23)
				(gCurRoom setScript: tryQual)
			)
			((IsFlag 80)
				(self setScript: resumeDrill)
			)
			((IsFlag 79)
				(self setScript: finishedDrill)
			)
			((not (IsFlag 22))
				(self setScript: firstEnter)
			)
			((not (IsFlag 53))
				(self setScript: finishZero)
			)
			(else
				(self setScript: regularDrill)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: 13 29 0 0 0) ; "Hey! What are you doing down there?! Let's see some concentration!"
			)
			(6
				(gMessager say: 13 6 0 0 0) ; "Holster that handgun, NOW!"
			)
			(else
				(gMessager say: 13 0 0 0 0) ; "Hey you! Knock it off with the funny stuff! We have live fire conditions!"
			)
		)
	)

	(method (newRoom newRoomNumber)
		(proc4_5)
		(if (not (OneOf newRoomNumber 325 310))
			(ClearFlag 12)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(= global114 0)
		(if (not (OneOf gNewRoomNum 315 325))
			(Lock rsAUDIO 31001 0)
			(gBackMusic fade: 0 2 21 1)
			(ClearFlag 110)
		)
		(ClearFlag 79)
		(myTimer dispose: delete:)
		(shootTimer dispose: delete:)
		(chgRoomTimer dispose: delete:)
		(urgeTimer dispose: delete:)
		(super dispose:)
	)
)

(instance firstEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftTable init:)
				(rightTable init:)
				(proc4_6 32000 68 10)
			)
			(1
				(farRightTable init:)
			)
			(2
				(rightTable setLoop: 3 posn: 363 415)
				(UpdateScreenItem rightTable)
			)
			(3
				(rightTable setLoop: 4 posn: 366 415)
				(UpdateScreenItem rightTable)
			)
			(4
				(rightTable setLoop: 5 posn: 366 415)
				(UpdateScreenItem rightTable)
			)
			(5
				(rightTable setLoop: 6 posn: 363 415)
				(UpdateScreenItem rightTable)
			)
			(6
				(rightTable setLoop: 7 posn: 362 415)
				(UpdateScreenItem rightTable)
			)
			(7
				(rightTable setLoop: 8 posn: 362 415)
				(UpdateScreenItem rightTable)
			)
			(8
				(leftTable setLoop: 9 posn: 68 413)
				(UpdateScreenItem leftTable)
			)
			(9
				(SetFlag 21)
				(saunders view: 32001 setLoop: 0 setCel: 0 posn: 144 394 init:)
				(myTimer setReal: myTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doSaundersCU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((IsFlag 50)
						(gGame showCloseUp: 32004 180 66 self)
					)
					((IsFlag 51)
						(SetFlag 50)
						(if (IsFlag 52)
							(gGame showCloseUp: 32003 180 66 self)
						else
							(gGame showCloseUp: 32002 180 66 self)
						)
					)
					(else
						(SetFlag 51)
						(gGame showCloseUp: 32001 180 66 self)
					)
				)
			)
			(1
				(myTimer setReal: myTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance start25Yard of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(= seconds 3)
			)
			(2
				(gCurRoom newRoom: 325)
			)
		)
	)
)

(instance finishedDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 32010)
				(proc4_6 32010 78 151 0 0 -1 1)
				(saundersFeature init:)
				(leftTable view: 32010 setLoop: 0 setCel: 0 posn: 50 417 init:)
				(rightTable
					view: 32010
					setLoop: 1
					setCel: 0
					posn: 375 425
					init:
				)
				(farRightTable
					view: 32010
					setLoop: 2
					setCel: 0
					posn: 585 264
					init:
				)
			)
			(1
				(shootTimer setReal: shootTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance resumeDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 80)
				(leftTable view: 32011 setLoop: 0 setCel: 0 posn: 35 406 init:)
				(rightTable
					view: 32011
					setLoop: 1
					setCel: 0
					posn: 338 411
					init:
				)
				(proc4_6 32011 12 14 0 0 -1 1)
			)
			(1
				(rightTable setLoop: 2 posn: 338 410)
				(UpdateScreenItem rightTable)
				(FrameOut)
			)
			(2
				(gCurRoom newRoom: 325)
			)
		)
	)
)

(instance regularDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftTable
					view: 32009
					setLoop: 0
					setCel: 0
					setPri: 10
					posn: 32 419
					init:
				)
				(rightTable
					view: 32009
					setLoop: 1
					setCel: 0
					posn: 364 423
					setPri: 10
					init:
				)
				(proc4_6 32009 15 14 0 0 -1 1)
			)
			(1
				(gCurRoom newRoom: 325)
			)
		)
	)
)

(instance saundersDecides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(saunders dispose:)
				(egoView dispose:)
				(proc4_6 32018 75 108 0 0 -1 1)
			)
			(1
				(gCurRoom newRoom: 325)
			)
		)
	)
)

(instance finishZero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 32005)
				(proc4_6 32005 110 69 0 0 -1 1)
				(leftTable
					view: 32005
					setLoop: 0
					setCel: 0
					setPri: 10
					posn: 21 417
					init:
				)
				(rightTable
					view: 32005
					setLoop: 1
					setCel: 0
					posn: 370 425
					init:
				)
				(farRightTable
					view: 32005
					setLoop: 2
					setCel: 0
					posn: 588 272
					init:
				)
			)
			(1
				(gCurRoom newRoom: 325)
			)
		)
	)
)

(instance tryQual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 32012)
				(proc4_6 32012 65 45)
				(leftTable view: 32012 setLoop: 0 setCel: 0 posn: 27 421 init:)
				(rightTable
					view: 32012
					setLoop: 1
					setCel: 0
					posn: 355 423
					init:
				)
			)
			(1
				(saunders view: 32012 setLoop: 4 setCel: 0 posn: 104 436 init:)
				(egoView view: 32012 setLoop: 5 setCel: 0 posn: 404 436 init:)
				(urgeTimer setReal: urgeTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance saundersQual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local0
					(0
						(gGame showCloseUp: 32013 180 66 self)
						(++ local0)
					)
					(1
						(gGame showCloseUp: 32014 180 66 self)
						(++ local0)
					)
					(2
						(gGame showCloseUp: 32015 180 66 self)
					)
				)
			)
			(1
				(urgeTimer setReal: urgeTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance failedQual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 32017)
				(proc4_6 32017 44 79 0 0 -1 1)
				(leftTable view: 32017 setLoop: 1 setCel: 0 posn: 36 406 init:)
				(rightTable
					view: 32017
					setLoop: 0
					setCel: 0
					posn: 376 404
					init:
				)
				(farRightTable
					view: 32017
					setLoop: 2
					setCel: 0
					posn: 581 254
					init:
				)
			)
			(1
				(leftTable setLoop: 4)
				(UpdateScreenItem leftTable)
				(FrameOut)
			)
			(2
				(leftTable setLoop: 5)
				(UpdateScreenItem leftTable)
				(FrameOut)
			)
			(3
				(ClearFlag 82)
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance passedQual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 32016)
				(proc4_6 32016 55 19 0 0 -1 1)
				(leftTable view: 32016 setLoop: 0 setCel: 0 posn: 34 420 init:)
				(rightTable
					view: 32016
					setLoop: 1
					setCel: 0
					posn: 378 419
					init:
				)
				(farRightTable
					view: 32016
					setLoop: 2
					setCel: 0
					posn: 581 264
					init:
				)
			)
			(1
				(leftTable setLoop: 3)
				(UpdateScreenItem leftTable)
				(FrameOut)
			)
			(2
				(leftTable setLoop: 4)
				(UpdateScreenItem leftTable)
				(FrameOut)
			)
			(3
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance leftTable of View
	(properties
		x 68
		y 414
		view 32000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)
)

(instance rightTable of View
	(properties
		x 365
		y 414
		view 32000
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 325)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance farRightTable of View
	(properties
		x 590
		y 248
		view 32000
		loop 2
	)
)

(instance saunders of View
	(properties
		x 8
		y 416
		view 32010
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(myTimer dispose: delete:)
				(urgeTimer dispose: delete:)
				(if (IsFlag 23)
					(gCurRoom setScript: saundersQual)
				else
					(gCurRoom setScript: doSaundersCU)
				)
			)
			(6
				(gMessager say: 11 6 0 0 0) ; "Officer! Are you threatening Saunders? By God, you better not be! Secure that weapon now!"
			)
			(else
				(gMessager say: 11 0 0 0 0) ; "Hey, you two! Quit goofing around!"
			)
		)
	)
)

(instance egoView of View
	(properties
		x 8
		y 416
		view 32010
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 325)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance saundersFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 178 126 227 142 354 243 355 253 341 240 229 179 175
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gMessager say: 11 6 0 0 0) ; "Officer! Are you threatening Saunders? By God, you better not be! Secure that weapon now!"
			)
			(else
				(gMessager say: 11 0 0 0 0) ; "Hey, you two! Quit goofing around!"
			)
		)
	)
)

(instance myTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: doSaundersCU)
			(self dispose: delete:)
		)
	)
)

(instance shootTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: saundersDecides)
			(self dispose: delete:)
		)
	)
)

(instance chgRoomTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom newRoom: 325)
			(self dispose: delete:)
		)
	)
)

(instance urgeTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: saundersQual)
			(self dispose: delete:)
		)
	)
)

(instance myShootCode of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

