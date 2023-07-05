;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use LightRoom)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm24 0
)

(local
	local0
)

(instance setRackCel of Code
	(properties)

	(method (doit)
		(if gInventory
			(cond
				((IsFlag 168)
					(if (IsFlag 167)
						(return 0)
					else
						(return 2)
					)
				)
				((IsFlag 167)
					(return 3)
				)
				(else
					(return 1)
				)
			)
		)
	)
)

(instance rm24 of LightRoom
	(properties
		picture 24
	)

	(method (init)
		(Lock rsAUDIO 30 1)
		(Lock rsAUDIO 31 1)
		(Lock rsAUDIO 32 1)
		(Lock rsAUDIO 33 1)
		(Lock rsAUDIO 55 1)
		(Lock rsAUDIO 56 1)
		(Lock rsAUDIO 5801 1)
		(super init: &rest)
		(gUser canInput: 1)
		(pRack setCel: (setRackCel doit:) init:)
		(if (IsFlag 13)
			(gMySoundFX fade: 127 5 63 0 0)
			(pDoor setCel: 14)
			(fCar init:)
			(fDoorShut init:)
		)
		(proc0_9 33 0 0 0 5)
		(pDoor init:)
		(fPoster2 init:)
		(fBox init:)
		(fDoor init:)
		(fDrawer init:)
		(fChair init:)
		(if gInventory
			(if (not (IsFlag 167))
				(fBag init:)
			)
			(if (not (IsFlag 168))
				(fUmbrella init:)
			)
		)
		((ScriptID 1 4) init: newRoom: 22) ; exitRight
	)

	(method (cue)
		(fCar init:)
		(fDoorShut init:)
	)

	(method (newRoom newRoomNumber)
		(Lock rsAUDIO 5801 0)
		(Lock rsAUDIO 30 0)
		(Lock rsAUDIO 31 0)
		(Lock rsAUDIO 32 0)
		(Lock rsAUDIO 33 0)
		(Lock rsAUDIO 55 0)
		(Lock rsAUDIO 56 0)
		(if gPanels
			(if (gPanels contains: (ScriptID 3 4)) ; pplPoster2
				((ScriptID 3 4) dispose:) ; pplPoster2
			)
			(if (gPanels contains: (ScriptID 3 6)) ; pplTableDrawer
				((ScriptID 3 6) dispose:) ; pplTableDrawer
			)
			(switch newRoomNumber
				(20
					(if (gPanels contains: (ScriptID 3 3)) ; pplBox
						((ScriptID 3 3) dispose:) ; pplBox
					)
				)
				(300
					(if (gPanels contains: (ScriptID 3 3)) ; pplBox
						((ScriptID 3 3) dispose:) ; pplBox
					)
				)
			)
		)
		(switch newRoomNumber
			(5
				(Lock rsMESSAGE 3 0)
				(Lock rsMESSAGE 330 0)
				(Lock rsSCRIPT 3 0)
				(Lock rsAUDIO 19 0)
				(Lock rsAUDIO 17 0)
				(Lock rsAUDIO 17001 0)
				(Lock rsAUDIO 17002 0)
				(Lock rsAUDIO 17003 0)
				(Lock rsAUDIO 17004 0)
				(Lock rsAUDIO 44 0)
				(Lock rsAUDIO 45 0)
				(Lock rsAUDIO 35 0)
				(Lock rsAUDIO 36 0)
				(Lock rsVIEW 35 0)
				(Lock rsVIEW 52 0)
				(gIRandomMusic fade:)
			)
			(300
				(Lock rsMESSAGE 3 0)
				(Lock rsMESSAGE 330 0)
				(Lock rsSCRIPT 3 0)
				(Lock rsVIEW 35 0)
				(Lock rsVIEW 52 0)
				(Lock rsVIEW 50 0)
				(Lock rsAUDIO 35 0)
				(Lock rsAUDIO 36 0)
				(Lock rsAUDIO 17004 0)
				0
			)
			(else
				(gMySoundFX fade: 32 5 63 0 0)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fDrawer of Feature
	(properties
		x 194
		y 240
		nsBottom 206
		nsLeft 232
		nsRight 274
		nsTop 183
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 6) init:) ; pplTableDrawer
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fDoor of Feature
	(properties
		x 50
		y 301
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 299 84 285 80 169 83 165 83 161 79 157 73 8 0 1 0 299
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 13)
				(pDoor setCycle: End gCurRoom)
				(aSound number: 32 play:)
				(gMySoundFX fade: 127 5 63 0 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pDoor of Prop
	(properties
		priority 222
		y 299
		view 30
		fixPriority 1
	)

	(method (cue)
		(aSound number: 33 play:)
		(gMySoundFX fade: 32 5 63 0 0)
		(fDoor init:)
	)
)

(instance fBox of Feature
	(properties
		x 373
		y 106
		nsBottom 193
		nsLeft 410
		nsRight 476
		nsTop 159
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 3) init:) ; pplBox
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fBag of Feature
	(properties
		x 119
		y 172
		nsBottom 189
		nsLeft 104
		nsRight 135
		nsTop 155
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(SetFlag 167)
			(gInventory addItem: (ScriptID 9 7)) ; invBag
			(pRack setCel: (setRackCel doit:))
			(pRack doit:)
			(aSound number: 30 play:)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fUmbrella of Feature
	(properties
		x 152
		y 139
		nsBottom 174
		nsLeft 142
		nsRight 162
		nsTop 104
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(SetFlag 168)
			(gInventory addItem: (ScriptID 9 6)) ; invUmbrella
			(pRack setCel: (setRackCel doit:))
			(pRack doit:)
			(aSound number: 31 play:)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pRack of Prop
	(properties
		x 93
		y 202
		view 34
	)
)

(instance fPoster2 of Feature
	(properties
		x 200
		y 85
		nsBottom 133
		nsLeft 187
		nsRight 213
		nsTop 38
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 4) init:) ; pplPoster2
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sDriveCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Lock rsAUDIO 19 0)
				(Lock rsAUDIO 17 0)
				(Lock rsAUDIO 17001 0)
				(Lock rsAUDIO 17002 0)
				(Lock rsAUDIO 17003 0)
				(if (not (gInventory contains: (ScriptID 9 6))) ; invUmbrella
					(SetFlag 168)
					(gInventory addItem: (ScriptID 9 6)) ; invUmbrella
					(pRack setCel: (setRackCel doit:))
					(pRack doit:)
					(aSound number: 31 play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not (gInventory contains: (ScriptID 9 7))) ; invBag
					(SetFlag 167)
					(gInventory addItem: (ScriptID 9 7)) ; invBag
					(pRack setCel: (setRackCel doit:))
					(pRack doit:)
					(aSound number: 30 play:)
					(= ticks 45)
				else
					(= cycles 1)
				)
			)
			(2
				(pDoor setCycle: Beg self)
			)
			(3
				(aSound number: 33 setLoop: 1 play: 127 self)
			)
			(4
				(gMySoundFX fade: 32 5 63 0 0)
				(aSound number: 5801 setLoop: 1 play: 127 self)
			)
			(5
				(gIRandomMusic fade:)
				(pDoor setPri: 900)
				(UpdateScreenItem pDoor)
				(DoRobot)
				(pDoor setPri: 900)
				(UpdateScreenItem pDoor)
				(KillRobot 32 0 0 0 5)
			)
			(6
				(DoRobot)
				(gCast eachElementDo: #dispose)
				((ScriptID 9 1) hide:) ; PlInterface
				(gCurRoom drawPic: 0)
				(gMySoundFX stop:)
				(= cycles 3)
			)
			(7
				(gGlobalVMD
					number: 70
					stretch: 1
					dir: 1
					myBlackLines: 1
					init:
					play:
					close:
				)
				(gGlobalVMD myBlackLines: 0)
				(= ticks 1)
			)
			(8
				(gInventory deleteItem: (ScriptID 9 8)) ; invCarKeys
				((ScriptID 9 1) show:) ; PlInterface
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance fChair of Feature
	(properties
		x 451
		y 246
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 410 299 403 207 421 194 441 199 460 215 469 232 474 279 499 287 499 299
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(SetFlag 418)
			(gCurRoom newRoom: 22)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fDoorShut of Feature
	(properties
		x 21
		y 149
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 299 30 299 24 208 32 207 38 208 41 204 35 198 30 202 23 202 12 0 1 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(ClearFlag 13)
				(pDoor setCycle: Beg pDoor)
				(fCar dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fCar of Feature
	(properties
		x 45
		y 144
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 196 73 196 71 108 17 92
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; invCarKeys
				(gCurRoom setScript: sDriveCar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

